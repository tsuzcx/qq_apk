package com.tencent.mobileqq.pic;

import android.os.Bundle;
import com.tencent.mobileqq.activity.PredownloadTest.ConfigInfo;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.servlet.ReportServlet;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public abstract class BaseStrategy
  implements PreDownloadStrategy, BusinessObserver
{
  public static final long a = 524288000L;
  public static final String a = "UseLocalFlowSet";
  public static final long b = 10485760L;
  public static final String b = "MaxWifiFlow";
  public static final long c = 10485760L;
  public static final String c = "Max4GFlow";
  public static final long d = 5242880L;
  public static final String d = "Max3GFlow";
  public static final String e = "Max2GFlow";
  public static final String f = "PreDownPolicy";
  public static long g = 0L;
  public static final String g = "PicDTPt2";
  public static long h = 0L;
  protected QQAppInterface a;
  protected long e;
  protected long f;
  protected long i = 524288000L;
  protected long j = 10485760L;
  protected long k = 10485760L;
  protected long l = 5242880L;
  
  public int a(long paramLong, int paramInt1, int paramInt2)
  {
    b();
    boolean bool = DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpredownload_whitelist.name());
    if (QLog.isColorLevel()) {
      Logger.a("PIC_TAG_PRELOAD", "isOverLimit", "isInDPCWhiteList:" + bool);
    }
    if ((paramInt2 == 0) || ((bool) && (paramInt2 != 3)))
    {
      if (this.f >= this.i)
      {
        PicReporter.a(paramInt2, this.i);
        Logger.a("PIC_TAG_PRELOAD", "isOverLimit", "result:true,netWokrType:" + paramInt2 + ",picTrafficFlowWIFI:" + this.f);
        return -8;
      }
    }
    else if (paramInt2 == 1)
    {
      if (this.e >= this.j)
      {
        PicReporter.a(paramInt2, this.j);
        Logger.a("PIC_TAG_PRELOAD", "isOverLimit", "result:true,netWokrType:" + paramInt2 + ",picTrafficFlowXG:" + this.e);
        return -8;
      }
    }
    else if (paramInt2 == 2)
    {
      if (this.e >= this.k)
      {
        PicReporter.a(paramInt2, this.k);
        Logger.a("PIC_TAG_PRELOAD", "isOverLimit", "result:true,netWokrType:" + paramInt2 + ",picTrafficFlowXG:" + this.e);
        return -8;
      }
    }
    else if ((paramInt2 == 3) && (this.e >= this.l))
    {
      PicReporter.a(paramInt2, this.l);
      Logger.a("PIC_TAG_PRELOAD", "isOverLimit", "result:true,netWokrType:" + paramInt2 + ",picTrafficFlowXG:" + this.e);
      return -8;
    }
    return 0;
  }
  
  public PredownloadTest.ConfigInfo a()
  {
    return null;
  }
  
  public void a()
  {
    g = PicPreDownloadUtils.a(this.a, "UseLocalFlowSet", 0L);
    h = PicPreDownloadUtils.a(this.a, "PicDTPt2", 0L);
    this.i = PicPreDownloadUtils.a(this.a, "MaxWifiFlow", 524288000L);
    this.j = PicPreDownloadUtils.a(this.a, "Max4GFlow", 10485760L);
    this.k = PicPreDownloadUtils.a(this.a, "Max3GFlow", 10485760L);
    this.l = PicPreDownloadUtils.a(this.a, "Max2GFlow", 5242880L);
  }
  
  public void a(PredownloadTest.ConfigInfo paramConfigInfo) {}
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    paramQQAppInterface.registObserver(this);
    a();
  }
  
  public void b()
  {
    NewIntent localNewIntent = new NewIntent(this.a.getApplication(), ReportServlet.class);
    localNewIntent.putExtra("sendType", 3);
    localNewIntent.putExtra("tags", new String[] { "param_XGC2CPicDownloadFlow", "param_XGGroupPicDownloadFlow", "param_WIFIC2CPicDownloadFlow", "param_WIFIGroupPicDownloadFlow" });
    this.a.startServlet(localNewIntent);
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((3 == paramInt) && (paramBoolean))
    {
      paramBundle = paramBundle.getLongArray("__base_tag_curentDay");
      if ((paramBundle != null) && (paramBundle.length == 4))
      {
        this.e = (paramBundle[0] + paramBundle[1]);
        this.f = (paramBundle[2] + paramBundle[3]);
        Logger.a("PIC_TAG_PRELOAD", "", "onReceive", "picTrafficFlowXG:" + this.e + ",C2CPicDownFlowXG:" + paramBundle[0] + ",Group/DiscussPicDownFlowXG:" + paramBundle[1] + ",\npicTrafficFlowWIFI:" + this.f + ",C2CPicDownFlowWIFI:" + paramBundle[2] + ",Group/DiscussPicDownFlowWIFI:" + paramBundle[3]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pic.BaseStrategy
 * JD-Core Version:    0.7.0.1
 */