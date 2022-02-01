package com.tencent.mobileqq.bubble;

import android.graphics.Rect;
import java.util.Arrays;

public class BubbleInfo$CommonAttrs
{
  public static final int a = 50;
  public static final boolean a = true;
  public static final int b = 1;
  public Rect a;
  public AnimationConfig a;
  public String a;
  public String[] a;
  public String b;
  public boolean b;
  public int c;
  public boolean c;
  public int d = 1;
  public int e = 50;
  public int f = -1;
  public int g = 1;
  
  public BubbleInfo$CommonAttrs()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[0];
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public String toString()
  {
    return "CommonAttrs [key=" + this.jdField_b_of_type_JavaLangString + ", mRect=" + this.jdField_a_of_type_AndroidGraphicsRect + ", count=" + this.jdField_c_of_type_Int + ", duration=" + this.e + ", align=" + this.f + ", mBigImgPath=" + this.jdField_a_of_type_JavaLangString + ", repeatCount=" + this.d + ", mAnimationPath=" + Arrays.toString(this.jdField_a_of_type_ArrayOfJavaLangString) + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleInfo.CommonAttrs
 * JD-Core Version:    0.7.0.1
 */