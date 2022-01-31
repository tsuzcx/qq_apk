package com.tencent.faceBeauty;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.util.i;
import java.util.ArrayList;
import java.util.List;

public abstract class b
{
  public static final int FACE_FEATURE_NUM = 83;
  public static final String TAG = "FaceDetect";
  protected int faceCount = 0;
  protected boolean mDetectedFace;
  public List<FaceParam> mFaceParams = new ArrayList();
  protected List<Boolean> mFemale = new ArrayList();
  protected boolean mGetFaceFeatures = false;
  protected boolean mGetFaceGender = false;
  
  public static Rect boundingRect(int[][] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int k = paramArrayOfInt[paramInt1][0];
    int i = paramArrayOfInt[paramInt1][1];
    paramInt1 += 1;
    int j = i;
    int i1 = k;
    if (paramInt1 <= paramInt2)
    {
      int n;
      int m;
      label50:
      int i3;
      int i2;
      if (paramArrayOfInt[paramInt1][0] < k)
      {
        n = paramArrayOfInt[paramInt1][0];
        m = i1;
        if (paramArrayOfInt[paramInt1][1] >= i) {
          break label124;
        }
        i3 = paramArrayOfInt[paramInt1][1];
        i2 = j;
      }
      for (;;)
      {
        paramInt1 += 1;
        i1 = m;
        k = n;
        j = i2;
        i = i3;
        break;
        m = i1;
        n = k;
        if (paramArrayOfInt[paramInt1][0] <= i1) {
          break label50;
        }
        m = paramArrayOfInt[paramInt1][0];
        n = k;
        break label50;
        label124:
        i2 = j;
        i3 = i;
        if (paramArrayOfInt[paramInt1][1] > j)
        {
          i2 = paramArrayOfInt[paramInt1][1];
          i3 = i;
        }
      }
    }
    return new Rect(k, i, i1, j);
  }
  
  public final void detectFace(Bitmap paramBitmap)
  {
    long l = System.currentTimeMillis();
    doDetectFace(paramBitmap);
    i.l("FaceDetect", "detectFace() :" + (System.currentTimeMillis() - l));
  }
  
  public final boolean detectedFace()
  {
    return this.mDetectedFace;
  }
  
  protected abstract void doDetectFace(Bitmap paramBitmap);
  
  protected abstract void doInitial();
  
  protected abstract void doRelease();
  
  public Rect getEyes(int paramInt)
  {
    if (paramInt > this.mFaceParams.size() - 1) {
      return null;
    }
    return ((FaceParam)this.mFaceParams.get(paramInt)).bsU;
  }
  
  public int getFaceCount()
  {
    return this.faceCount;
  }
  
  public int[][] getFaceFeatures(int paramInt)
  {
    if (paramInt > this.mFaceParams.size() - 1) {
      return null;
    }
    return ((FaceParam)this.mFaceParams.get(paramInt)).bsW;
  }
  
  public boolean getFaceFemale(int paramInt)
  {
    if (paramInt > this.mFemale.size() - 1) {
      return false;
    }
    return ((Boolean)this.mFemale.get(paramInt)).booleanValue();
  }
  
  public FaceParam getFaceParams(int paramInt)
  {
    if (paramInt > this.mFaceParams.size() - 1) {
      return null;
    }
    return (FaceParam)this.mFaceParams.get(paramInt);
  }
  
  public Rect getFaces(int paramInt)
  {
    if (paramInt > this.mFaceParams.size() - 1) {
      return null;
    }
    return ((FaceParam)this.mFaceParams.get(paramInt)).bsP;
  }
  
  public Point getLeftEyeCenters(int paramInt)
  {
    if (paramInt > this.mFaceParams.size() - 1) {
      return null;
    }
    return ((FaceParam)this.mFaceParams.get(paramInt)).bsS;
  }
  
  public Rect getLeftEyes(int paramInt)
  {
    if (paramInt > this.mFaceParams.size() - 1) {
      return null;
    }
    return ((FaceParam)this.mFaceParams.get(paramInt)).bsQ;
  }
  
  public Rect getMouths(int paramInt)
  {
    if (paramInt > this.mFaceParams.size() - 1) {
      return null;
    }
    return ((FaceParam)this.mFaceParams.get(paramInt)).bsV;
  }
  
  public Point getRightEyeCenters(int paramInt)
  {
    if (paramInt > this.mFaceParams.size() - 1) {
      return null;
    }
    return ((FaceParam)this.mFaceParams.get(paramInt)).bsT;
  }
  
  public Rect getRightEyes(int paramInt)
  {
    if (paramInt > this.mFaceParams.size() - 1) {
      return null;
    }
    return ((FaceParam)this.mFaceParams.get(paramInt)).bsR;
  }
  
  public void needDetectFaceFeatures(boolean paramBoolean)
  {
    this.mGetFaceFeatures = paramBoolean;
  }
  
  public void needDetectFaceGender(boolean paramBoolean)
  {
    this.mGetFaceGender = paramBoolean;
  }
  
  public final void release()
  {
    doRelease();
  }
  
  public void resizeData(int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < this.faceCount)
    {
      FaceParam localFaceParam = (FaceParam)this.mFaceParams.get(i);
      if ((localFaceParam.height != paramInt2) || (localFaceParam.width != paramInt1))
      {
        float f1 = paramInt1 / localFaceParam.width;
        float f2 = paramInt2 / localFaceParam.height;
        localFaceParam.height = ((int)(localFaceParam.height * f2));
        localFaceParam.width = ((int)(localFaceParam.width * f1));
        Object localObject = localFaceParam.bsP;
        ((Rect)localObject).left = ((int)(((Rect)localObject).left * f1));
        ((Rect)localObject).top = ((int)(((Rect)localObject).top * f2));
        ((Rect)localObject).right = ((int)(((Rect)localObject).right * f1));
        ((Rect)localObject).bottom = ((int)(((Rect)localObject).bottom * f2));
        localObject = localFaceParam.bsQ;
        ((Rect)localObject).left = ((int)(((Rect)localObject).left * f1));
        ((Rect)localObject).top = ((int)(((Rect)localObject).top * f2));
        ((Rect)localObject).right = ((int)(((Rect)localObject).right * f1));
        ((Rect)localObject).bottom = ((int)(((Rect)localObject).bottom * f2));
        localObject = localFaceParam.bsS;
        ((Point)localObject).x = ((int)(((Point)localObject).x * f1));
        ((Point)localObject).y = ((int)(((Point)localObject).y * f2));
        localObject = localFaceParam.bsR;
        ((Rect)localObject).left = ((int)(((Rect)localObject).left * f1));
        ((Rect)localObject).top = ((int)(((Rect)localObject).top * f2));
        ((Rect)localObject).right = ((int)(((Rect)localObject).right * f1));
        ((Rect)localObject).bottom = ((int)(((Rect)localObject).bottom * f2));
        localObject = localFaceParam.bsT;
        ((Point)localObject).x = ((int)(((Point)localObject).x * f1));
        ((Point)localObject).y = ((int)(((Point)localObject).y * f2));
        localObject = localFaceParam.bsU;
        ((Rect)localObject).left = ((int)(((Rect)localObject).left * f1));
        ((Rect)localObject).top = ((int)(((Rect)localObject).top * f2));
        ((Rect)localObject).right = ((int)(((Rect)localObject).right * f1));
        ((Rect)localObject).bottom = ((int)(((Rect)localObject).bottom * f2));
        localObject = localFaceParam.bsV;
        ((Rect)localObject).left = ((int)(((Rect)localObject).left * f1));
        ((Rect)localObject).top = ((int)(((Rect)localObject).top * f2));
        ((Rect)localObject).right = ((int)(((Rect)localObject).right * f1));
        ((Rect)localObject).bottom = ((int)(((Rect)localObject).bottom * f2));
        if (localFaceParam.bsW != null)
        {
          localObject = localFaceParam.bsW;
          int j = 0;
          while (j < localObject.length)
          {
            localObject[j][0] = ((int)(localObject[j][0] * f1));
            localObject[j][1] = ((int)(localObject[j][1] * f2));
            j += 1;
          }
        }
        localFaceParam.height = paramInt2;
        localFaceParam.width = paramInt1;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.faceBeauty.b
 * JD-Core Version:    0.7.0.1
 */