package com.pay.data.report;

import android.content.Context;

public class APPluginReportParams
{
  private static APPluginReportParams a;
  private long b = 0L;
  private long c = 0L;
  private String d = "";
  private String e = "";
  private String f = "launchpay";
  private long g = 0L;
  private int h = 0;
  private int i = 0;
  private int j = 0;
  private Context k = null;
  
  public static APPluginReportParams getInstance()
  {
    try
    {
      if (a == null) {
        a = new APPluginReportParams();
      }
      APPluginReportParams localAPPluginReportParams = a;
      return localAPPluginReportParams;
    }
    finally {}
  }
  
  public String a()
  {
    try
    {
      String str = this.e;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.c = paramLong;
  }
  
  public void a(String paramString)
  {
    this.e = paramString;
  }
  
  public long b()
  {
    try
    {
      long l = this.c;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b(int paramInt)
  {
    this.i = paramInt;
  }
  
  public String c()
  {
    return this.f;
  }
  
  public void c(int paramInt)
  {
    this.j = paramInt;
  }
  
  public int d()
  {
    return this.h;
  }
  
  public int e()
  {
    return this.i;
  }
  
  public int f()
  {
    return this.j;
  }
  
  public void setLaunchInterface(String paramString)
  {
    this.f = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     com.pay.data.report.APPluginReportParams
 * JD-Core Version:    0.7.0.1
 */