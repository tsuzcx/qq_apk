package com.pay.data.report;

public class APPluginReportParams
{
  public static APPluginReportParams g;
  public long a = 0L;
  public String b = "";
  public String c = "launchpay";
  public int d = 0;
  public int e = 0;
  public int f = 0;
  
  public static APPluginReportParams getInstance()
  {
    try
    {
      if (g == null) {
        g = new APPluginReportParams();
      }
      APPluginReportParams localAPPluginReportParams = g;
      return localAPPluginReportParams;
    }
    finally {}
  }
  
  public String a()
  {
    return this.c;
  }
  
  public void a(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.a = paramLong;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public int b()
  {
    return this.f;
  }
  
  public void b(int paramInt)
  {
    this.e = paramInt;
  }
  
  public int c()
  {
    return this.e;
  }
  
  public void c(int paramInt)
  {
    this.d = paramInt;
  }
  
  public int d()
  {
    return this.d;
  }
  
  public String e()
  {
    try
    {
      String str = this.b;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long f()
  {
    try
    {
      long l = this.a;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setLaunchInterface(String paramString)
  {
    this.c = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.data.report.APPluginReportParams
 * JD-Core Version:    0.7.0.1
 */