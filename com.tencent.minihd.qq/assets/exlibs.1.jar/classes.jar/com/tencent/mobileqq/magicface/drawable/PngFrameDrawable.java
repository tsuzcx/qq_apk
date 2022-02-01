package com.tencent.mobileqq.magicface.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.util.DisplayMetrics;
import com.tencent.qphone.base.util.QLog;
import jdm;
import jdw;

public class PngFrameDrawable
  extends Drawable
  implements IRedrawNotify
{
  private static final int jdField_a_of_type_Int = 6;
  private static final String jdField_a_of_type_JavaLangString = PngFrameDrawable.class.getSimpleName();
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private PngGifEngine jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngGifEngine;
  private jdm jdField_a_of_type_Jdm;
  private int b;
  
  public PngFrameDrawable(PngPlayParam paramPngPlayParam, Resources paramResources)
  {
    this(new jdm(paramPngPlayParam), paramResources);
  }
  
  private PngFrameDrawable(jdm paramjdm, Resources paramResources)
  {
    this.jdField_a_of_type_Jdm = paramjdm;
    if (paramResources != null) {}
    for (this.jdField_b_of_type_Int = paramResources.getDisplayMetrics().densityDpi;; this.jdField_b_of_type_Int = paramjdm.e)
    {
      b();
      return;
    }
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func initGifEngine");
    }
    jdw localjdw = new jdw();
    localjdw.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawableIRedrawNotify = this;
    localjdw.jdField_a_of_type_Int = this.jdField_a_of_type_Jdm.jdField_b_of_type_Int;
    localjdw.jdField_b_of_type_Int = this.jdField_a_of_type_Jdm.jdField_a_of_type_Int;
    if (!this.jdField_a_of_type_Jdm.jdField_a_of_type_Boolean) {}
    for (localjdw.jdField_a_of_type_ArrayOfJavaLangString = null;; localjdw.jdField_a_of_type_ArrayOfJavaLangString = this.jdField_a_of_type_Jdm.jdField_a_of_type_ArrayOfJavaLangString)
    {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngGifEngine = new PngGifEngine();
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngGifEngine.a(localjdw);
      return;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "PngFrameDrawable 【onDestroy】, mBitmapDrawn:" + this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngGifEngine = null;
    this.jdField_a_of_type_Jdm = null;
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Jdm.jdField_b_of_type_ArrayOfJavaLangString != null) && (paramInt < this.jdField_a_of_type_Jdm.jdField_b_of_type_ArrayOfJavaLangString.length)) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngGifEngine.a(this.jdField_a_of_type_Jdm.jdField_b_of_type_ArrayOfJavaLangString[paramInt]);
    }
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngGifEngine.b();
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func onBitmapReady,bitmap:" + paramBitmap);
    }
    if (paramBitmap == null) {
      return;
    }
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    invalidateSelf();
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled());
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func draw,bitmap:" + this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, getBounds(), this.jdField_a_of_type_Jdm.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  public Drawable.ConstantState getConstantState()
  {
    return this.jdField_a_of_type_Jdm;
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.jdField_a_of_type_Jdm.jdField_a_of_type_AndroidGraphicsPaint.getAlpha())
    {
      this.jdField_a_of_type_Jdm.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt);
      invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.jdField_a_of_type_Jdm.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.drawable.PngFrameDrawable
 * JD-Core Version:    0.7.0.1
 */