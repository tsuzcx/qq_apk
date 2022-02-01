package com.tencent.mobileqq.activity.widget.qqmusic.business.player;

public class SongSwitch
{
  private int jdField_a_of_type_Int = 0;
  private final String jdField_a_of_type_JavaLangString = "SongSwitch";
  private final int b = 1;
  private final int c = 2;
  private final int d = 4;
  private final int e = 8;
  private final int f = 16;
  private final int g = 32;
  private final int h = 64;
  private final int i = 128;
  private final int j = 256;
  private final int k = 512;
  private final int l = 1024;
  private final int m = 2048;
  private final int n = 4096;
  private final int o = 8192;
  private final int p = 16384;
  
  public SongSwitch(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Int < 0) {}
    while ((this.jdField_a_of_type_Int & 0x1) <= 0) {
      return false;
    }
    return true;
  }
  
  public boolean b()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (a())
    {
      bool1 = bool2;
      if ((this.jdField_a_of_type_Int & 0x2) > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean c()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (a())
    {
      bool1 = bool2;
      if ((this.jdField_a_of_type_Int & 0x4) > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean d()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (a())
    {
      bool1 = bool2;
      if ((this.jdField_a_of_type_Int & 0x8) > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean e()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (a())
    {
      bool1 = bool2;
      if ((this.jdField_a_of_type_Int & 0x10) > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean f()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (a())
    {
      bool1 = bool2;
      if ((this.jdField_a_of_type_Int & 0x20) > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean g()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (a())
    {
      bool1 = bool2;
      if ((this.jdField_a_of_type_Int & 0x40) > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean h()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (a())
    {
      bool1 = bool2;
      if ((this.jdField_a_of_type_Int & 0x80) > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean i()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (a())
    {
      bool1 = bool2;
      if ((this.jdField_a_of_type_Int & 0x100) > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean j()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (a())
    {
      bool1 = bool2;
      if ((this.jdField_a_of_type_Int & 0x2000) > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean k()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (a())
    {
      bool1 = bool2;
      if ((this.jdField_a_of_type_Int & 0x400) > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean l()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (a())
    {
      bool1 = bool2;
      if ((this.jdField_a_of_type_Int & 0x800) > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean m()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (a())
    {
      bool1 = bool2;
      if ((this.jdField_a_of_type_Int & 0x1000) > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean n()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (a())
    {
      bool1 = bool2;
      if ((this.jdField_a_of_type_Int & 0x200) > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean o()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (a())
    {
      bool1 = bool2;
      if ((this.jdField_a_of_type_Int & 0x4000) > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.business.player.SongSwitch
 * JD-Core Version:    0.7.0.1
 */