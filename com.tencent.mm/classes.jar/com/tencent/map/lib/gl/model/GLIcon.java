package com.tencent.map.lib.gl.model;

import android.graphics.Bitmap;
import android.graphics.RectF;
import com.tencent.map.lib.basemap.data.GeoPoint;

public class GLIcon
  extends a
  implements a.a
{
  public static final int BOTTOM = 16;
  public static final int CENTER = 1;
  public static final int LEFT = 4096;
  public static final int RIGHT = 65536;
  public static final int TOP = 256;
  private float mAlpha = 1.0F;
  private float mAnchorPointX = 0.5F;
  private float mAnchorPointY = 0.5F;
  private boolean mAvoidAnno = false;
  private float mBottomPartLen = 0.0F;
  private RectF mBounds;
  private int mCurrentState = 0;
  public int mDisplayId;
  private boolean mFastLoad = false;
  private boolean mFixPos = false;
  private boolean mFlat = true;
  private boolean mHasIconChanged = false;
  private String mIconName;
  public Bitmap[] mIcons;
  private boolean mIsDirty = false;
  private int mLastIconHei;
  private String mLastIconName;
  private int mLastIconWid;
  private float mLeftPartLen = 0.0F;
  private int mOffsetX;
  private int mOffsetY;
  public double mPositionX;
  public double mPositionY;
  private float mRightPartLen = 0.0F;
  private int mRotateAngle = 0;
  private float mScaleX = 1.0F;
  private float mScaleY = 1.0F;
  private float mTopPartLen = 0.0F;
  
  public GLIcon(String paramString, GeoPoint paramGeoPoint, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, Bitmap... paramVarArgs)
  {
    setAdapter(this);
    this.mAnchorPointX = paramFloat1;
    this.mAnchorPointY = paramFloat2;
    this.mOffsetX = paramInt1;
    this.mOffsetY = paramInt2;
    if (paramGeoPoint != null)
    {
      this.mPositionX = (paramGeoPoint.getLongitudeE6() / 1000000.0D);
      this.mPositionY = (paramGeoPoint.getLatitudeE6() / 1000000.0D);
    }
    update(paramString, paramVarArgs);
  }
  
  public GLIcon(String paramString, GeoPoint paramGeoPoint, float paramFloat1, float paramFloat2, Bitmap... paramVarArgs)
  {
    this(paramString, paramGeoPoint, paramFloat1, paramFloat2, 0, 0, paramVarArgs);
  }
  
  public GLIcon(String paramString, GeoPoint paramGeoPoint, Bitmap... paramVarArgs)
  {
    this(paramString, paramGeoPoint, 0.5F, 0.5F, 0, 0, paramVarArgs);
  }
  
  private Bitmap getBmByState(int paramInt)
  {
    if (this.mIcons == null) {
      return null;
    }
    if ((paramInt < 0) || (paramInt >= this.mIcons.length)) {
      return this.mIcons[0];
    }
    return this.mIcons[paramInt];
  }
  
  protected void build(int paramInt1, int paramInt2)
  {
    if ((this.mLastIconWid == paramInt1) && (this.mLastIconHei == paramInt2)) {
      return;
    }
    this.mLastIconWid = paramInt1;
    this.mLastIconHei = paramInt2;
    float f1 = this.mOffsetX / paramInt1;
    float f2 = this.mOffsetY / paramInt2;
    this.mBounds = new RectF(f1, -f2, 0.0F, 0.0F);
    this.mAnchorPointX -= f1;
    this.mAnchorPointY -= f2;
    this.mLeftPartLen = (-this.mLastIconWid * this.mAnchorPointX);
    this.mRightPartLen = (this.mLastIconWid + this.mLeftPartLen);
    this.mTopPartLen = (this.mLastIconHei * this.mAnchorPointY);
    this.mBottomPartLen = (this.mTopPartLen - this.mLastIconHei);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof GLIcon)) {}
    while (this.mDisplayId != ((GLIcon)paramObject).mDisplayId) {
      return false;
    }
    return true;
  }
  
  public float getAlpha()
  {
    return this.mAlpha;
  }
  
  public float getAnchorY()
  {
    return this.mAnchorPointY;
  }
  
  public float getAnchroX()
  {
    return this.mAnchorPointX;
  }
  
  public float getBottom()
  {
    return this.mBottomPartLen;
  }
  
  public RectF getBounds()
  {
    return new RectF(this.mBounds);
  }
  
  public String getIconName()
  {
    return this.mIconName;
  }
  
  public String getLastName()
  {
    return this.mLastIconName;
  }
  
  public float getLeft()
  {
    return this.mLeftPartLen;
  }
  
  public float getRight()
  {
    return this.mRightPartLen;
  }
  
  public float getRotateAngle()
  {
    return this.mRotateAngle;
  }
  
  public float getScaleX()
  {
    return this.mScaleX;
  }
  
  public float getScaleY()
  {
    return this.mScaleY;
  }
  
  public Bitmap getTextureBm(int paramInt)
  {
    try
    {
      Bitmap localBitmap = getBmByState(getState());
      return localBitmap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String getTextureUID()
  {
    return this.mIconName;
  }
  
  public float getTop()
  {
    return this.mTopPartLen;
  }
  
  public boolean hasTexture()
  {
    return true;
  }
  
  public boolean isAvoidAnno()
  {
    return this.mAvoidAnno;
  }
  
  public boolean isDirty()
  {
    return this.mIsDirty;
  }
  
  public boolean isFastLoad()
  {
    return this.mFastLoad;
  }
  
  public boolean isFixPos()
  {
    return this.mFixPos;
  }
  
  public boolean isFlat()
  {
    return this.mFlat;
  }
  
  public boolean isIconChanged()
  {
    return this.mHasIconChanged;
  }
  
  public void setAlpha(float paramFloat)
  {
    this.mAlpha = paramFloat;
    setDirty(true);
  }
  
  public void setAnchor(float paramFloat1, float paramFloat2)
  {
    this.mAnchorPointX = paramFloat1;
    this.mAnchorPointY = paramFloat2;
    build(this.mLastIconWid, this.mLastIconHei);
    setDirty(true);
  }
  
  public void setAvoidAnno(boolean paramBoolean)
  {
    this.mAvoidAnno = paramBoolean;
  }
  
  public void setDirty(boolean paramBoolean)
  {
    this.mIsDirty = paramBoolean;
  }
  
  public void setFastLoad(boolean paramBoolean)
  {
    this.mFastLoad = paramBoolean;
  }
  
  public void setFixPos(boolean paramBoolean)
  {
    this.mFixPos = paramBoolean;
  }
  
  public void setFlat(boolean paramBoolean)
  {
    this.mFlat = paramBoolean;
  }
  
  public void setIconChanged(boolean paramBoolean)
  {
    this.mHasIconChanged = paramBoolean;
    if (!paramBoolean) {
      this.mLastIconName = this.mIconName;
    }
  }
  
  public void setOffset(int paramInt1, int paramInt2)
  {
    this.mOffsetX = paramInt1;
    this.mOffsetY = paramInt2;
    setDirty(true);
  }
  
  public void setPosition(GeoPoint paramGeoPoint)
  {
    if (paramGeoPoint != null) {
      if (!this.mFixPos) {
        break label41;
      }
    }
    label41:
    for (double d = 1.0D;; d = 1000000.0D)
    {
      this.mPositionX = (paramGeoPoint.getLongitudeE6() / d);
      this.mPositionY = (paramGeoPoint.getLatitudeE6() / d);
      setDirty(true);
      return;
    }
  }
  
  public void setRotateAngle(int paramInt)
  {
    this.mRotateAngle = paramInt;
    setDirty(true);
  }
  
  public void setScale(float paramFloat1, float paramFloat2)
  {
    this.mScaleX = paramFloat1;
    this.mScaleY = paramFloat2;
    setDirty(true);
  }
  
  public void setState(int paramInt)
  {
    try
    {
      this.mCurrentState = paramInt;
      setDirty(true);
      setIconChanged(true);
      Bitmap localBitmap = getBmByState(paramInt);
      if (localBitmap != null)
      {
        int i = localBitmap.getWidth();
        int j = localBitmap.getHeight();
        if ((this.mLastIconWid != i) || (this.mLastIconHei != j)) {
          build(i, j);
        }
      }
      super.setState(paramInt);
      return;
    }
    finally {}
  }
  
  public final void update(String paramString, Bitmap... paramVarArgs)
  {
    if (paramVarArgs == null) {}
    for (;;)
    {
      return;
      try
      {
        setDirty(true);
        setIconChanged(true);
        this.mIconName = paramString;
        this.mIcons = paramVarArgs;
        if ((this.mCurrentState < 0) || (this.mCurrentState >= paramVarArgs.length)) {
          this.mCurrentState = 0;
        }
        if (paramVarArgs[this.mCurrentState] == null) {
          continue;
        }
        build(paramVarArgs[this.mCurrentState].getWidth(), paramVarArgs[this.mCurrentState].getHeight());
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.map.lib.gl.model.GLIcon
 * JD-Core Version:    0.7.0.1
 */