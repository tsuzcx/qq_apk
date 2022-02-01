package com.tencent.mobileqq.activity.fling;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import gnj;

public class ContentWrapView
  extends RelativeLayout
{
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private gnj jdField_a_of_type_Gnj;
  
  public ContentWrapView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ContentWrapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ContentWrapView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a()
  {
    gnj localgnj = this.jdField_a_of_type_Gnj;
    if (localgnj == null) {}
    while (!localgnj.jdField_a_of_type_Boolean) {
      return;
    }
    gnj.a(localgnj).setTranslate(localgnj.jdField_a_of_type_Float, localgnj.b);
    localgnj.jdField_a_of_type_Boolean = false;
  }
  
  private void a(Context paramContext)
  {
    setWillNotDraw(false);
  }
  
  public void draw(Canvas paramCanvas)
  {
    gnj localgnj = this.jdField_a_of_type_Gnj;
    if (localgnj != null)
    {
      a();
      paramCanvas.concat(gnj.a(localgnj));
    }
    super.draw(paramCanvas);
  }
  
  public void ensureTransformationInfo()
  {
    if (this.jdField_a_of_type_Gnj == null) {
      this.jdField_a_of_type_Gnj = new gnj();
    }
  }
  
  public float getTransX()
  {
    if (this.jdField_a_of_type_Gnj != null) {
      return this.jdField_a_of_type_Gnj.jdField_a_of_type_Float;
    }
    return 0.0F;
  }
  
  public float getTransY()
  {
    if (this.jdField_a_of_type_Gnj != null) {
      return this.jdField_a_of_type_Gnj.b;
    }
    return 0.0F;
  }
  
  public void transX(float paramFloat)
  {
    ensureTransformationInfo();
    gnj localgnj = this.jdField_a_of_type_Gnj;
    if (localgnj.jdField_a_of_type_Float != paramFloat)
    {
      localgnj.jdField_a_of_type_Float = paramFloat;
      localgnj.jdField_a_of_type_Boolean = true;
      invalidate();
    }
  }
  
  public void transXBy(float paramFloat)
  {
    if (paramFloat != 0.0F) {
      transX(getTransX() + paramFloat);
    }
  }
  
  public void transY(float paramFloat)
  {
    ensureTransformationInfo();
    gnj localgnj = this.jdField_a_of_type_Gnj;
    if (localgnj.b != paramFloat)
    {
      localgnj.b = paramFloat;
      localgnj.jdField_a_of_type_Boolean = true;
      invalidate();
    }
  }
  
  public void transYBy(float paramFloat)
  {
    if (paramFloat != 0.0F) {
      transX(getTransX() + paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.fling.ContentWrapView
 * JD-Core Version:    0.7.0.1
 */