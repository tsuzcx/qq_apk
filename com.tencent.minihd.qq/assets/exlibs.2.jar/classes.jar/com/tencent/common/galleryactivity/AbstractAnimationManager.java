package com.tencent.common.galleryactivity;

import java.util.ArrayList;

public abstract class AbstractAnimationManager
  implements AnimationLister
{
  public static final long b = 350L;
  protected long a;
  protected ArrayList a;
  protected boolean a;
  public boolean b = true;
  public boolean c;
  
  public AbstractAnimationManager()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Long = 350L;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Long = 350L;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(AnimationLister paramAnimationLister)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramAnimationLister)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramAnimationLister);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public abstract boolean b();
  
  public abstract boolean c();
  
  public boolean d()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.common.galleryactivity.AbstractAnimationManager
 * JD-Core Version:    0.7.0.1
 */