package com.tencent.mobileqq.magicface.model;

import jeb;

public abstract class MagicfaceDecoder
{
  public static final int a = 480;
  public static final int b = 640;
  public static final int c = 852;
  public static final int d = 720;
  protected MagicfaceData a;
  public MagicfaceDecoder.MagicPlayListener a;
  public MagicfaceDecoder.MagicfaceRenderListener a;
  public volatile boolean a;
  public int e = 8;
  public int f = 1000 / this.e;
  
  public MagicfaceDecoder()
  {
    g();
  }
  
  public abstract void a();
  
  public void a(int paramInt)
  {
    this.e = paramInt;
    this.f = (1000 / paramInt);
  }
  
  public void a(MagicfaceData paramMagicfaceData)
  {
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceData = paramMagicfaceData;
  }
  
  public void a(MagicfaceDecoder.MagicPlayListener paramMagicPlayListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder$MagicPlayListener = paramMagicPlayListener;
  }
  
  public void a(MagicfaceDecoder.MagicfaceRenderListener paramMagicfaceRenderListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder$MagicfaceRenderListener = paramMagicfaceRenderListener;
  }
  
  public void c() {}
  
  public void d()
  {
    f();
    if (!this.jdField_a_of_type_Boolean) {
      new Thread(new jeb(this)).start();
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  protected void f() {}
  
  protected void g()
  {
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.model.MagicfaceDecoder
 * JD-Core Version:    0.7.0.1
 */