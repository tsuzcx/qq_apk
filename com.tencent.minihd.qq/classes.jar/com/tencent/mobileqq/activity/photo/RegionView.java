package com.tencent.mobileqq.activity.photo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import com.tencent.mobileqq.activity.PortraitImageview;

public class RegionView
  extends View
{
  int jdField_a_of_type_Int;
  final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private PortraitImageview jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview;
  Rect[] jdField_a_of_type_ArrayOfAndroidGraphicsRect;
  int jdField_b_of_type_Int;
  Rect jdField_b_of_type_AndroidGraphicsRect;
  int c;
  int d;
  int e;
  
  public RegionView(Context paramContext, PortraitImageview paramPortraitImageview, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramContext);
    paramPortraitImageview.setRegionView(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview = paramPortraitImageview;
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramInt3;
  }
  
  public Bitmap a()
  {
    Matrix localMatrix = this.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview.a();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview.a();
    localMatrix.postTranslate(-((RectF)localObject).left, -((RectF)localObject).top);
    localMatrix.postScale(this.c / ((RectF)localObject).width(), this.d / ((RectF)localObject).height(), 0.0F, 0.0F);
    localObject = Bitmap.createBitmap(this.c, this.d, Bitmap.Config.RGB_565);
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview.a();
    if ((localObject != null) && (localBitmap != null)) {
      new Canvas((Bitmap)localObject).drawBitmap(localBitmap, localMatrix, new Paint(6));
    }
    return localObject;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview != null)
    {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview.a();
      this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview.b();
    }
    this.jdField_a_of_type_AndroidGraphicsRect.left = ((getWidth() - this.jdField_a_of_type_Int) / 2);
    this.jdField_a_of_type_AndroidGraphicsRect.right = ((getWidth() + this.jdField_a_of_type_Int) / 2);
    this.jdField_a_of_type_AndroidGraphicsRect.top = ((getHeight() - this.jdField_b_of_type_Int) / 2);
    this.jdField_a_of_type_AndroidGraphicsRect.bottom = ((getHeight() + this.jdField_b_of_type_Int) / 2);
    if (this.e == 0)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(1711276032);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      Path localPath = new Path();
      float f = this.jdField_a_of_type_AndroidGraphicsRect.top + this.jdField_a_of_type_AndroidGraphicsRect.height() * 0.5F;
      localPath.moveTo(getWidth(), f);
      localPath.addArc(new RectF(this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.bottom), 0.0F, -360.0F);
      localPath.moveTo(getWidth(), f);
      localPath.lineTo(getWidth(), getHeight());
      localPath.lineTo(0.0F, getHeight());
      localPath.lineTo(0.0F, 0.0F);
      localPath.lineTo(getWidth(), 0.0F);
      localPath.moveTo(getWidth(), f);
      localPath.close();
      paramCanvas.drawPath(localPath, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(1291845632);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(5.0F);
      paramCanvas.drawCircle(this.jdField_a_of_type_AndroidGraphicsRect.left + this.jdField_a_of_type_AndroidGraphicsRect.width() * 0.5F, f, this.jdField_a_of_type_AndroidGraphicsRect.width() * 0.5F, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(3.0F);
      paramCanvas.drawCircle(this.jdField_a_of_type_AndroidGraphicsRect.left + this.jdField_a_of_type_AndroidGraphicsRect.width() * 0.5F, f, this.jdField_a_of_type_AndroidGraphicsRect.width() * 0.5F, this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
    }
    this.jdField_a_of_type_ArrayOfAndroidGraphicsRect = new Rect[] { new Rect(0, 0, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top), new Rect(this.jdField_a_of_type_AndroidGraphicsRect.left, 0, this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.top), new Rect(this.jdField_a_of_type_AndroidGraphicsRect.right, 0, getWidth(), this.jdField_a_of_type_AndroidGraphicsRect.top), new Rect(0, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.bottom), new Rect(this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.top, getWidth(), this.jdField_a_of_type_AndroidGraphicsRect.bottom), new Rect(0, this.jdField_a_of_type_AndroidGraphicsRect.bottom, this.jdField_a_of_type_AndroidGraphicsRect.left, getHeight()), new Rect(this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.bottom, this.jdField_a_of_type_AndroidGraphicsRect.right, getHeight()), new Rect(this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.bottom, getWidth(), getHeight()) };
    this.jdField_b_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_b_of_type_AndroidGraphicsRect.set(this.jdField_a_of_type_AndroidGraphicsRect);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(1711276032);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfAndroidGraphicsRect.length)
    {
      paramCanvas.drawRect(this.jdField_a_of_type_ArrayOfAndroidGraphicsRect[i], this.jdField_a_of_type_AndroidGraphicsPaint);
      i += 1;
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(0);
    paramCanvas.drawRect(this.jdField_b_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    paramCanvas.drawRect(this.jdField_b_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.RegionView
 * JD-Core Version:    0.7.0.1
 */