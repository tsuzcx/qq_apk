package com.tencent.faceBeauty;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.lang.reflect.Array;

public class FaceParam
  implements Parcelable
{
  public static final Parcelable.Creator<FaceParam> CREATOR = new FaceParam.1();
  private static final String TAG = FaceParam.class.getSimpleName();
  public Rect bcn = null;
  public Rect bco = null;
  public Rect bcp = null;
  public Point bcq = null;
  public Point bcr = null;
  public Rect bcs = null;
  public Rect bct = null;
  public int[][] bcu = null;
  public int height = 0;
  public int width = 0;
  
  public FaceParam() {}
  
  private FaceParam(Parcel paramParcel)
  {
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    this.bcq = new Point(paramParcel.readInt(), paramParcel.readInt());
    this.bcr = new Point(paramParcel.readInt(), paramParcel.readInt());
    ClassLoader localClassLoader = Rect.class.getClassLoader();
    this.bcn = ((Rect)paramParcel.readParcelable(localClassLoader));
    this.bco = ((Rect)paramParcel.readParcelable(localClassLoader));
    this.bcp = ((Rect)paramParcel.readParcelable(localClassLoader));
    this.bcs = ((Rect)paramParcel.readParcelable(localClassLoader));
    this.bct = ((Rect)paramParcel.readParcelable(localClassLoader));
    if (paramParcel.readInt() == 1)
    {
      paramParcel = paramParcel.createIntArray();
      if ((paramParcel != null) && (paramParcel.length >= 2))
      {
        int i = paramParcel.length / 2;
        this.bcu = ((int[][])Array.newInstance(Integer.TYPE, new int[] { i, 2 }));
        i = 0;
        while (i < paramParcel.length / 2)
        {
          this.bcu[i][0] = paramParcel[(i * 2)];
          this.bcu[i][1] = paramParcel[(i * 2 + 1)];
          i += 1;
        }
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
    paramParcel.writeInt(this.bcq.x);
    paramParcel.writeInt(this.bcq.y);
    paramParcel.writeInt(this.bcr.x);
    paramParcel.writeInt(this.bcr.y);
    paramParcel.writeParcelable(this.bcn, 1);
    paramParcel.writeParcelable(this.bco, 1);
    paramParcel.writeParcelable(this.bcp, 1);
    paramParcel.writeParcelable(this.bcs, 1);
    paramParcel.writeParcelable(this.bct, 1);
    if (this.bcu != null)
    {
      paramParcel.writeInt(1);
      int[] arrayOfInt = new int[this.bcu.length * 2];
      paramInt = 0;
      while (paramInt < this.bcu.length)
      {
        arrayOfInt[(paramInt * 2)] = this.bcu[paramInt][0];
        arrayOfInt[(paramInt * 2 + 1)] = this.bcu[paramInt][1];
        paramInt += 1;
      }
      paramParcel.writeIntArray(arrayOfInt);
      return;
    }
    paramParcel.writeInt(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.faceBeauty.FaceParam
 * JD-Core Version:    0.7.0.1
 */