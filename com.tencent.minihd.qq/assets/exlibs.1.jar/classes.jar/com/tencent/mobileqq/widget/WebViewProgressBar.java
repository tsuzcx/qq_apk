package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

public class WebViewProgressBar
  extends View
{
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private WebViewProgressBarController jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController;
  private boolean jdField_a_of_type_Boolean = true;
  private Drawable b;
  
  public WebViewProgressBar(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public WebViewProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public WebViewProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.b = getContext().getResources().getDrawable(2130841797);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getContext().getResources().getDrawable(2130841798);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int j;
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController.a() != 6))
    {
      if (this.b != null)
      {
        this.b.setBounds(0, 0, getWidth(), getHeight());
        this.b.draw(paramCanvas);
      }
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        j = (int)this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController.a();
        if (this.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setAlpha(this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController.a());
        }
        if (j >= this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth()) {
          break label147;
        }
        i = j - this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
        j = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(i, 0, j + i, getHeight());
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      return;
      label147:
      i = 0;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController.a(getWidth());
    }
  }
  
  public void setController(WebViewProgressBarController paramWebViewProgressBarController)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController == paramWebViewProgressBarController) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController.a(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController = paramWebViewProgressBarController;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController.a(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController.a(getWidth());
    }
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.WebViewProgressBar
 * JD-Core Version:    0.7.0.1
 */