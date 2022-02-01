package com.tencent.mobileqq.activity.aio.anim;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import frm;
import java.util.Arrays;

public class VipPendantDrawable
  extends Drawable
{
  static final int jdField_a_of_type_Int = -1;
  private static final String jdField_a_of_type_JavaLangString = "VipPendantDrawable";
  static final int b = 50;
  protected static final int c = 1;
  private static final int f = 0;
  Resources jdField_a_of_type_AndroidContentResResources;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(6);
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  VipPendantDrawable.MutilePlayInfo jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPendantDrawable$MutilePlayInfo;
  protected Object a;
  protected int d = -1;
  protected int e = 50;
  private int g;
  private int h;
  
  public VipPendantDrawable(Resources paramResources)
  {
    this.jdField_a_of_type_AndroidContentResResources = paramResources;
  }
  
  public void a()
  {
    this.d = -1;
    this.e = 50;
  }
  
  public void a(VipPendantDrawable.MutilePlayInfo paramMutilePlayInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPendantDrawable$MutilePlayInfo = paramMutilePlayInfo;
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_JavaLangObject instanceof frm)) && (((frm)this.jdField_a_of_type_JavaLangObject).a != null) && (this.d == 1) && (((frm)this.jdField_a_of_type_JavaLangObject).a.equals(paramString))) {
      return;
    }
    a();
    this.d = 1;
    this.jdField_a_of_type_JavaLangObject = new frm(this, paramString);
  }
  
  public void a(String[] paramArrayOfString, int paramInt)
  {
    if (paramArrayOfString == null) {}
    while ((this.d == 0) && (Arrays.equals((String[])this.jdField_a_of_type_JavaLangObject, paramArrayOfString))) {
      return;
    }
    a();
    this.d = 0;
    this.jdField_a_of_type_JavaLangObject = paramArrayOfString;
    this.e = paramInt;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.d == -1) {}
    Bitmap localBitmap;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPendantDrawable$MutilePlayInfo == null);
      localBitmap = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPendantDrawable$MutilePlayInfo.a();
    } while ((localBitmap == null) || (localBitmap.isRecycled()));
    paramCanvas.drawBitmap(localBitmap, null, getBounds(), this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.jdField_a_of_type_AndroidGraphicsPaint.getAlpha())
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt);
      invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(paramBoolean);
    invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.VipPendantDrawable
 * JD-Core Version:    0.7.0.1
 */