package com.tencent.liteav.beauty;

import android.content.Context;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;

public class a
{
  private static a a = null;
  private static Context b = null;
  private static boolean c = false;
  private static boolean d = false;
  private static boolean e = false;
  private static boolean f = false;
  private static boolean g = false;
  private static boolean h = false;
  private static boolean i = false;
  private static boolean j = false;
  private static boolean k = false;
  private static boolean l = false;
  private static boolean m = false;
  private static boolean n = false;
  private static boolean o = false;
  private String p = "ReportDuaManage";
  
  public static a a()
  {
    if (a == null) {
      a = new a();
    }
    return a;
  }
  
  private void f()
  {
    TXCLog.i(this.p, "resetReportState");
    c = false;
    d = false;
    e = false;
    f = false;
    g = false;
    h = false;
    i = false;
    j = false;
    k = false;
    l = false;
    m = false;
    n = false;
    o = false;
  }
  
  public void a(Context paramContext)
  {
    f();
    b = paramContext.getApplicationContext();
    if (!c)
    {
      TXCLog.i(this.p, "reportSDKInit");
      TXCDRApi.txReportDAU(b, 1201, 0, "reportSDKInit!");
    }
    c = true;
  }
  
  public void b()
  {
    if (!d)
    {
      TXCLog.i(this.p, "reportBeautyDua");
      TXCDRApi.txReportDAU(b, 1202, 0, "reportBeautyDua");
    }
    d = true;
  }
  
  public void c()
  {
    if (!e)
    {
      TXCLog.i(this.p, "reportWhiteDua");
      TXCDRApi.txReportDAU(b, 1203, 0, "reportWhiteDua");
    }
    e = true;
  }
  
  public void d()
  {
    if (!j)
    {
      TXCLog.i(this.p, "reportFilterImageDua");
      TXCDRApi.txReportDAU(b, 1208, 0, "reportFilterImageDua");
    }
    j = true;
  }
  
  public void e()
  {
    if (!n)
    {
      TXCLog.i(this.p, "reportWarterMarkDua");
      TXCDRApi.txReportDAU(b, 1212, 0, "reportWarterMarkDua");
    }
    n = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.liteav.beauty.a
 * JD-Core Version:    0.7.0.1
 */