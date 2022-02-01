package com.tencent.wstt.SSCM;

import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import java.util.Date;

public class SSCM
{
  private static final int jdField_b_of_type_Int = 0;
  private static final int jdField_c_of_type_Int = 1;
  private static final int jdField_d_of_type_Int = 2;
  private static final int jdField_e_of_type_Int = 0;
  private static final int jdField_f_of_type_Int = 1;
  private static final int jdField_g_of_type_Int = 2;
  private double jdField_a_of_type_Double;
  private float jdField_a_of_type_Float;
  public int a;
  private long jdField_a_of_type_Long;
  boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private float jdField_d_of_type_Float;
  private float jdField_e_of_type_Float;
  private float jdField_f_of_type_Float;
  private float jdField_g_of_type_Float;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  
  public SSCM()
  {
    a();
  }
  
  private long a()
  {
    return new Date().getTime();
  }
  
  private long b()
  {
    return new Date().getTime();
  }
  
  public int a(Context paramContext, long paramLong)
  {
    this.h = Utils.a(paramContext);
    if (!this.jdField_a_of_type_Boolean) {
      switch (this.h)
      {
      default: 
        this.i = 4096;
      }
    }
    for (;;)
    {
      if (paramLong < 102400L) {
        this.i *= 4;
      }
      if (paramLong - this.i <= this.i / 2) {
        this.i = ((int)paramLong);
      }
      return this.i;
      this.i = 32768;
      continue;
      this.i = 16384;
      continue;
      this.i = 8192;
    }
  }
  
  public int a(Context paramContext, long paramLong1, long paramLong2, int paramInt)
  {
    this.jdField_a_of_type_Long = a();
    if (paramLong1 < 102400L) {}
    for (this.n = 1; true == this.jdField_b_of_type_Boolean; this.n = 2)
    {
      a();
      this.j = a(paramContext, paramLong1);
      this.jdField_b_of_type_Boolean = false;
      return this.j;
    }
    this.c = ((float)(this.j / this.jdField_a_of_type_Double));
    label144:
    label176:
    float f1;
    if (0.0F == this.e)
    {
      this.e = this.c;
      if (this.jdField_a_of_type_Int != 2)
      {
        this.o += 1;
        if (this.d != 0.0F) {
          break label278;
        }
        this.jdField_a_of_type_Float = 1.0F;
        if (this.o == this.n) {
          this.jdField_b_of_type_Float = this.e;
        }
      }
      switch (this.jdField_a_of_type_Int)
      {
      default: 
        if (paramLong1 - paramLong2 - this.j <= this.j / 2) {
          this.j = ((int)(paramLong1 - paramLong2));
        }
        if (this.o == 0)
        {
          f1 = this.d;
          label219:
          if ((paramInt <= 0) || ((this.j >= 0) && (this.j <= paramInt))) {
            break label646;
          }
          this.j = paramInt;
        }
        break;
      }
    }
    for (;;)
    {
      return this.j;
      this.e = ((float)(0.8D * this.c + 0.2D * this.e));
      break;
      label278:
      if (this.o != this.n) {
        break label144;
      }
      this.jdField_a_of_type_Float = ((float)((this.e - this.d) / this.jdField_b_of_type_Float / ((this.j - this.k) / (this.i + 0.0D))));
      break label144;
      if (this.o != this.n) {
        break label176;
      }
      if (this.jdField_a_of_type_Float < 0.09D)
      {
        this.jdField_a_of_type_Int = 1;
        this.j = ((int)(1.05D * this.k));
      }
      for (;;)
      {
        this.e = 0.0F;
        this.o = 0;
        break;
        this.jdField_a_of_type_Int = 0;
        this.k = this.j;
        this.j = (this.k * 2);
        this.d = this.e;
      }
      if (this.o != this.n) {
        break label176;
      }
      if (this.jdField_a_of_type_Float < 0.09D)
      {
        this.jdField_a_of_type_Int = 2;
        this.f = this.e;
        this.d = 0.0F;
        this.k = 0;
        this.g = this.e;
        break label176;
      }
      this.jdField_a_of_type_Int = 1;
      this.k = this.j;
      this.j = ((int)(1.05D * this.k));
      this.d = this.e;
      this.g = this.e;
      this.e = 0.0F;
      this.o = 0;
      break label176;
      if (Math.abs(this.e - this.f) > 0.2D * this.f) {}
      for (this.l += 1;; this.l = 0)
      {
        if (this.l >= this.m) {
          break label596;
        }
        this.jdField_a_of_type_Int = 2;
        break;
      }
      label596:
      this.l = 0;
      this.jdField_a_of_type_Int = 0;
      this.j = this.i;
      this.d = 0.0F;
      this.k = 0;
      this.e = 0.0F;
      this.o = 0;
      break label176;
      f1 = this.e;
      break label219;
      label646:
      if (this.j < 0)
      {
        this.l = 0;
        this.jdField_a_of_type_Int = 0;
        this.j = this.i;
        this.d = 0.0F;
        this.k = 0;
        this.e = 0.0F;
        this.o = 0;
      }
    }
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 0;
    this.i = 0;
    this.j = 0;
    this.k = 0;
    this.jdField_b_of_type_Float = 0.0F;
    this.c = 0.0F;
    this.d = 0.0F;
    this.e = 0.0F;
    this.jdField_a_of_type_Double = 0.0D;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_Float = 0.0F;
    this.g = 0.0F;
    this.l = 0;
    this.o = 0;
    this.m = 3;
    this.n = 2;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    this.i = paramInt;
  }
  
  public void b()
  {
    this.jdField_b_of_type_Long = b();
    this.jdField_a_of_type_Double = ((this.jdField_b_of_type_Long - this.jdField_a_of_type_Long) / 1000.0D);
    QLog.d("upload", 2, "sendFilePakage time:" + this.jdField_a_of_type_Double);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Long = a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.wstt.SSCM.SSCM
 * JD-Core Version:    0.7.0.1
 */