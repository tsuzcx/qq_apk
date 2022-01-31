package com.tencent.map.lib.gl.model;

import android.graphics.Bitmap;
import android.graphics.RectF;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GLIcon
  extends a
  implements a.a
{
  public static final int BOTTOM = 16;
  public static final int CENTER = 1;
  public static final int LEFT = 4096;
  public static final int RIGHT = 65536;
  public static final int TOP = 256;
  private float mAlpha;
  private float mAnchorPointX;
  private float mAnchorPointY;
  private boolean mAvoidAnno;
  private float mBottomPartLen;
  private RectF mBounds;
  private int mCurrentState;
  public int mDisplayId;
  private boolean mFastLoad;
  private boolean mFixPos;
  private boolean mFlat;
  private boolean mHasIconChanged;
  private String mIconName;
  public Bitmap[] mIcons;
  private boolean mIsDirty;
  private int mLastIconHei;
  private String mLastIconName;
  private int mLastIconWid;
  private float mLeftPartLen;
  private int mOffsetX;
  private int mOffsetY;
  public double mPositionX;
  public double mPositionY;
  private float mRightPartLen;
  private int mRotateAngle;
  private float mScaleX;
  private float mScaleY;
  private float mTopPartLen;
  
  public GLIcon(String paramString, GeoPoint paramGeoPoint, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, Bitmap... paramVarArgs)
  {
    AppMethodBeat.i(98124);
    this.mCurrentState = 0;
    this.mAnchorPointX = 0.5F;
    this.mAnchorPointY = 0.5F;
    this.mIsDirty = false;
    this.mLeftPartLen = 0.0F;
    this.mRightPartLen = 0.0F;
    this.mTopPartLen = 0.0F;
    this.mBottomPartLen = 0.0F;
    this.mAlpha = 1.0F;
    this.mRotateAngle = 0;
    this.mScaleX = 1.0F;
    this.mScaleY = 1.0F;
    this.mFixPos = false;
    this.mFlat = true;
    this.mHasIconChanged = false;
    this.mFastLoad = false;
    this.mAvoidAnno = false;
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
    AppMethodBeat.o(98124);
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
    AppMethodBeat.i(98125);
    if ((this.mLastIconWid == paramInt1) && (this.mLastIconHei == paramInt2))
    {
      AppMethodBeat.o(98125);
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
    AppMethodBeat.o(98125);
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
    AppMethodBeat.i(98134);
    RectF localRectF = new RectF(this.mBounds);
    AppMethodBeat.o(98134);
    return localRectF;
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
      AppMethodBeat.i(98135);
      Bitmap localBitmap = getBmByState(getState());
      AppMethodBeat.o(98135);
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
    AppMethodBeat.i(98130);
    this.mAlpha = paramFloat;
    setDirty(true);
    AppMethodBeat.o(98130);
  }
  
  public void setAnchor(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(98129);
    this.mAnchorPointX = paramFloat1;
    this.mAnchorPointY = paramFloat2;
    build(this.mLastIconWid, this.mLastIconHei);
    setDirty(true);
    AppMethodBeat.o(98129);
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
    AppMethodBeat.i(98126);
    this.mOffsetX = paramInt1;
    this.mOffsetY = paramInt2;
    setDirty(true);
    AppMethodBeat.o(98126);
  }
  
  public void setPosition(GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(98127);
    if (paramGeoPoint != null) {
      if (!this.mFixPos) {
        break label51;
      }
    }
    label51:
    for (double d = 1.0D;; d = 1000000.0D)
    {
      this.mPositionX = (paramGeoPoint.getLongitudeE6() / d);
      this.mPositionY = (paramGeoPoint.getLatitudeE6() / d);
      setDirty(true);
      AppMethodBeat.o(98127);
      return;
    }
  }
  
  public void setRotateAngle(int paramInt)
  {
    AppMethodBeat.i(98132);
    this.mRotateAngle = paramInt;
    setDirty(true);
    AppMethodBeat.o(98132);
  }
  
  public void setScale(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(98131);
    this.mScaleX = paramFloat1;
    this.mScaleY = paramFloat2;
    setDirty(true);
    AppMethodBeat.o(98131);
  }
  
  public void setState(int paramInt)
  {
    try
    {
      AppMethodBeat.i(98133);
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
      AppMethodBeat.o(98133);
      return;
    }
    finally {}
  }
  
  /* Error */
  public final void update(String paramString, Bitmap... paramVarArgs)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 236
    //   4: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_2
    //   8: ifnonnull +11 -> 19
    //   11: ldc 236
    //   13: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: aload_0
    //   20: iconst_1
    //   21: invokevirtual 202	com/tencent/map/lib/gl/model/GLIcon:setDirty	(Z)V
    //   24: aload_0
    //   25: iconst_1
    //   26: invokevirtual 225	com/tencent/map/lib/gl/model/GLIcon:setIconChanged	(Z)V
    //   29: aload_0
    //   30: aload_1
    //   31: putfield 170	com/tencent/map/lib/gl/model/GLIcon:mIconName	Ljava/lang/String;
    //   34: aload_0
    //   35: aload_2
    //   36: putfield 137	com/tencent/map/lib/gl/model/GLIcon:mIcons	[Landroid/graphics/Bitmap;
    //   39: aload_0
    //   40: getfield 65	com/tencent/map/lib/gl/model/GLIcon:mCurrentState	I
    //   43: iflt +12 -> 55
    //   46: aload_0
    //   47: getfield 65	com/tencent/map/lib/gl/model/GLIcon:mCurrentState	I
    //   50: aload_2
    //   51: arraylength
    //   52: if_icmplt +8 -> 60
    //   55: aload_0
    //   56: iconst_0
    //   57: putfield 65	com/tencent/map/lib/gl/model/GLIcon:mCurrentState	I
    //   60: aload_2
    //   61: aload_0
    //   62: getfield 65	com/tencent/map/lib/gl/model/GLIcon:mCurrentState	I
    //   65: aaload
    //   66: ifnull +25 -> 91
    //   69: aload_0
    //   70: aload_2
    //   71: aload_0
    //   72: getfield 65	com/tencent/map/lib/gl/model/GLIcon:mCurrentState	I
    //   75: aaload
    //   76: invokevirtual 230	android/graphics/Bitmap:getWidth	()I
    //   79: aload_2
    //   80: aload_0
    //   81: getfield 65	com/tencent/map/lib/gl/model/GLIcon:mCurrentState	I
    //   84: aaload
    //   85: invokevirtual 233	android/graphics/Bitmap:getHeight	()I
    //   88: invokevirtual 207	com/tencent/map/lib/gl/model/GLIcon:build	(II)V
    //   91: ldc 236
    //   93: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: goto -80 -> 16
    //   99: astore_1
    //   100: aload_0
    //   101: monitorexit
    //   102: aload_1
    //   103: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	GLIcon
    //   0	104	1	paramString	String
    //   0	104	2	paramVarArgs	Bitmap[]
    // Exception table:
    //   from	to	target	type
    //   2	7	99	finally
    //   11	16	99	finally
    //   19	55	99	finally
    //   55	60	99	finally
    //   60	91	99	finally
    //   91	96	99	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.map.lib.gl.model.GLIcon
 * JD-Core Version:    0.7.0.1
 */