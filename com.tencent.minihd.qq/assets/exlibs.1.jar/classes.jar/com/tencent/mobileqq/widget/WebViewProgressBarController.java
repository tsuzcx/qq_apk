package com.tencent.mobileqq.widget;

import android.os.Handler;
import kzj;
import kzk;

public class WebViewProgressBarController
{
  public static final byte a = 0;
  private static final float jdField_a_of_type_Float = 20.0F;
  public static final int a = 200;
  private static final String jdField_a_of_type_JavaLangString = "WebViewProgressBarController";
  public static final byte b = 1;
  private static final float b = 80.0F;
  public static final int b = 20;
  public static final byte c = 2;
  private static final float jdField_c_of_type_Float = 10.0F;
  public static final byte d = 0;
  private static final int jdField_d_of_type_Int = 0;
  public static final byte e = 1;
  private static final float jdField_e_of_type_Float = 40.0F;
  private static final int jdField_e_of_type_Int = 98;
  public static final byte f = 2;
  private static final float jdField_f_of_type_Float = 300.0F;
  private static final int jdField_f_of_type_Int = 5;
  public static final byte g = 3;
  private static final float jdField_g_of_type_Float = 0.5F;
  private static final int jdField_g_of_type_Int = 20;
  public static final byte h = 4;
  public static final byte i = 5;
  public static final byte j = 6;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler = new kzk(this);
  protected WebViewProgressBar a;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  private float jdField_d_of_type_Float;
  private float jdField_h_of_type_Float;
  private int jdField_h_of_type_Int = 255;
  private float i;
  private float j;
  private byte jdField_k_of_type_Byte = -1;
  private float jdField_k_of_type_Float;
  private byte l = 6;
  
  public WebViewProgressBarController()
  {
    this.c = 0;
  }
  
  private long a(long paramLong)
  {
    long l1 = paramLong;
    if (paramLong > 30L) {
      l1 = 30L;
    }
    return l1;
  }
  
  public byte a()
  {
    return this.l;
  }
  
  public float a()
  {
    return this.jdField_k_of_type_Float;
  }
  
  public int a()
  {
    return this.jdField_h_of_type_Int;
  }
  
  public void a()
  {
    int n = kzj.a(0).b();
    int m = n;
    if (n <= 0) {
      m = kzj.a(0).a();
    }
    this.i = (20.0F / m);
    this.jdField_h_of_type_Float = 0.0F;
    this.l = 0;
    this.jdField_k_of_type_Float = this.j;
    this.jdField_h_of_type_Int = 255;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setVisibility(0);
    }
    e();
  }
  
  public void a(byte paramByte)
  {
    switch (paramByte)
    {
    default: 
    case 0: 
      do
      {
        return;
      } while (this.jdField_k_of_type_Byte == 0);
      this.jdField_k_of_type_Byte = 0;
      a();
      return;
    case 1: 
      b();
      return;
    }
    if ((this.jdField_k_of_type_Byte == 0) || (this.jdField_k_of_type_Byte == 1)) {
      c();
    }
    this.jdField_k_of_type_Byte = 2;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(WebViewProgressBar paramWebViewProgressBar)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar = paramWebViewProgressBar;
  }
  
  public byte b()
  {
    return this.jdField_k_of_type_Byte;
  }
  
  public void b()
  {
    kzj.a(0).a();
    int n = kzj.a(1).b();
    int m = n;
    if (n <= 0) {
      m = kzj.a(1).a();
    }
    this.i = (60.0F / m);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.l = 2;
    this.jdField_k_of_type_Byte = 1;
    e();
  }
  
  public void c()
  {
    kzj.a(1).a();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.l = 5;
    this.i = 0.1333333F;
    if (this.jdField_h_of_type_Float <= 60.0F) {
      this.i = ((40.0F + (60.0F - this.jdField_h_of_type_Float) * 0.5F) / 300.0F);
    }
    for (this.d = 0.8166667F;; this.d = (245.0F * this.i / (100.0F - this.jdField_h_of_type_Float)))
    {
      e();
      return;
    }
  }
  
  public void d()
  {
    this.l = 6;
    this.jdField_h_of_type_Float = 0.0F;
    this.j = ((int)(this.jdField_h_of_type_Float * this.c / 100.0F));
    this.jdField_h_of_type_Int = 255;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void e()
  {
    long l1;
    if (this.l != 6)
    {
      l1 = System.currentTimeMillis();
      if (this.jdField_h_of_type_Float < 100.0F) {
        break label66;
      }
      d();
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(200);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(200, 20L);
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.invalidate();
      }
      return;
      label66:
      long l2;
      float f1;
      switch (this.l)
      {
      default: 
        break;
      case 0: 
        l2 = a(l1 - this.jdField_a_of_type_Long);
        f1 = this.jdField_h_of_type_Float;
        this.jdField_h_of_type_Float = ((float)l2 * this.i + f1);
        this.jdField_a_of_type_Long = l1;
        if (this.jdField_h_of_type_Float >= 20.0F)
        {
          this.jdField_a_of_type_Long = l1;
          this.l = 1;
          this.i /= 5.0F;
        }
        this.jdField_k_of_type_Float = (this.c * this.jdField_h_of_type_Float / 100.0F);
        break;
      case 1: 
        l2 = a(l1 - this.jdField_a_of_type_Long);
        f1 = this.jdField_h_of_type_Float;
        this.jdField_h_of_type_Float = ((float)l2 * this.i + f1);
        this.jdField_a_of_type_Long = l1;
        if (this.jdField_h_of_type_Float >= 98.0F)
        {
          this.jdField_a_of_type_Long = l1;
          this.l = 4;
          this.jdField_h_of_type_Float = 98.0F;
          this.i = 0.0F;
        }
        this.jdField_k_of_type_Float = (this.c * this.jdField_h_of_type_Float / 100.0F);
        break;
      case 2: 
        l2 = a(l1 - this.jdField_a_of_type_Long);
        f1 = this.jdField_h_of_type_Float;
        this.jdField_h_of_type_Float = ((float)l2 * this.i + f1);
        this.jdField_a_of_type_Long = l1;
        if (this.jdField_h_of_type_Float >= 80.0F)
        {
          this.jdField_a_of_type_Long = l1;
          this.l = 3;
          this.i /= 20.0F;
        }
        this.jdField_k_of_type_Float = (this.c * this.jdField_h_of_type_Float / 100.0F);
        break;
      case 3: 
        l2 = a(l1 - this.jdField_a_of_type_Long);
        f1 = this.jdField_h_of_type_Float;
        this.jdField_h_of_type_Float = ((float)l2 * this.i + f1);
        this.jdField_a_of_type_Long = l1;
        if (this.jdField_h_of_type_Float >= 98.0F)
        {
          this.jdField_a_of_type_Long = l1;
          this.l = 4;
          this.i = 0.0F;
        }
        this.jdField_k_of_type_Float = (this.c * this.jdField_h_of_type_Float / 100.0F);
        break;
      case 5: 
        l2 = a(l1 - this.jdField_a_of_type_Long);
        this.jdField_h_of_type_Float += (float)l2 * this.i;
        this.jdField_a_of_type_Long = l1;
        this.jdField_k_of_type_Float = (this.c * this.jdField_h_of_type_Float / 100.0F);
        if (this.jdField_a_of_type_Boolean)
        {
          if (this.jdField_k_of_type_Float >= this.c) {
            this.jdField_k_of_type_Float = this.c;
          }
        }
        else
        {
          this.jdField_h_of_type_Int -= (int)((float)l2 * this.d);
          if (this.jdField_h_of_type_Int <= 0)
          {
            d();
            this.jdField_h_of_type_Int = 0;
          }
        }
        break;
      case 4: 
        this.jdField_k_of_type_Float = (this.c * this.jdField_h_of_type_Float / 100.0F);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.WebViewProgressBarController
 * JD-Core Version:    0.7.0.1
 */