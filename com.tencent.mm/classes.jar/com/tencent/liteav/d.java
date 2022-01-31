package com.tencent.liteav;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.datareport.TXCDRExtInfo;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class d
{
  private static String a = "TXCDataReport";
  private HashMap b = new HashMap(100);
  private String c;
  private int d;
  private int e;
  private int f;
  private int g;
  private Context h;
  private String i;
  private long j;
  private int k;
  private long l;
  private boolean m;
  private long n;
  private int o;
  private boolean p = false;
  private long q = 0L;
  private long r = 0L;
  private long s = 0L;
  private long t = 0L;
  private long u = 0L;
  private String v = "";
  
  public d(Context paramContext)
  {
    this.h = paramContext.getApplicationContext();
    this.i = TXCCommonUtil.getAppVersion();
    this.o = 5000;
    this.u = 0L;
  }
  
  private void b(boolean paramBoolean)
  {
    Object localObject = new TXCDRExtInfo();
    ((TXCDRExtInfo)localObject).url = this.c;
    ((TXCDRExtInfo)localObject).report_common = false;
    ((TXCDRExtInfo)localObject).report_status = false;
    String str2 = (String)this.b.get("token");
    TXCDRApi.InitEvent(this.h, str2, com.tencent.liteav.basic.datareport.a.X, com.tencent.liteav.basic.datareport.a.am, (TXCDRExtInfo)localObject);
    this.u = TXCTimeUtil.getUtcTimeTick();
    TXCDRApi.txSetEventValue(str2, com.tencent.liteav.basic.datareport.a.X, "u64_timestamp", String.valueOf(this.u));
    TXCDRApi.txSetEventValue(str2, com.tencent.liteav.basic.datareport.a.X, "str_device_type", (String)this.b.get("str_device_type"));
    TXCDRApi.txSetEventIntValue(str2, com.tencent.liteav.basic.datareport.a.X, "u32_network_type", c("u32_network_type"));
    long l4 = TXCStatus.b(this.v, 7107);
    long l2 = TXCStatus.b(this.v, 7108);
    long l1 = l2;
    if (l2 != -1L) {
      l1 = l2 - l4;
    }
    int i1 = com.tencent.liteav.basic.datareport.a.X;
    String str1;
    if (paramBoolean)
    {
      l2 = l1;
      TXCDRApi.txSetEventIntValue(str2, i1, "u32_dns_time", l2);
      str1 = TXCStatus.c(this.v, 7110);
      i1 = com.tencent.liteav.basic.datareport.a.X;
      if (!paramBoolean) {
        break label852;
      }
      localObject = str1;
      label214:
      TXCDRApi.txSetEventValue(str2, i1, "u32_server_ip", (String)localObject);
      l3 = TXCStatus.b(this.v, 7109);
      l2 = l3;
      if (l3 != -1L) {
        l2 = l3 - l4;
      }
      i1 = com.tencent.liteav.basic.datareport.a.X;
      if (!paramBoolean) {
        break label859;
      }
    }
    label852:
    label859:
    for (long l3 = l2;; l3 = -1L)
    {
      TXCDRApi.txSetEventIntValue(str2, i1, "u32_connect_server_time", l3);
      TXCDRApi.txSetEventIntValue(str2, com.tencent.liteav.basic.datareport.a.X, "u32_stream_begin", -1L);
      this.j = (TXCStatus.b(this.v, 6001) - l4);
      TXCDRApi.txSetEventIntValue(str2, com.tencent.liteav.basic.datareport.a.X, "u32_first_i_frame", this.j);
      l3 = TXCStatus.b(this.v, 7103) - l4;
      TXCDRApi.txSetEventIntValue(str2, com.tencent.liteav.basic.datareport.a.X, "u32_first_frame_down", l3);
      TXCDRApi.txSetEventValue(str2, com.tencent.liteav.basic.datareport.a.X, "str_user_id", (String)this.b.get("str_user_id"));
      TXCDRApi.txSetEventValue(str2, com.tencent.liteav.basic.datareport.a.X, "str_package_name", (String)this.b.get("str_package_name"));
      TXCDRApi.txSetEventValue(str2, com.tencent.liteav.basic.datareport.a.X, "str_app_version", this.i);
      TXCDRApi.txSetEventValue(str2, com.tencent.liteav.basic.datareport.a.X, "dev_uuid", (String)this.b.get("dev_uuid"));
      i1 = TXCStatus.d(this.v, 2013);
      TXCDRApi.txSetEventValue(str2, com.tencent.liteav.basic.datareport.a.X, "u32_max_cache_time", String.valueOf(i1));
      int i2 = TXCStatus.d(this.v, 2012);
      TXCDRApi.txSetEventValue(str2, com.tencent.liteav.basic.datareport.a.X, "u32_min_cache_time", String.valueOf(i2));
      int i3 = TXCStatus.d(this.v, 7105);
      TXCDRApi.txSetEventValue(str2, com.tencent.liteav.basic.datareport.a.X, "u64_err_code", String.valueOf(i3));
      localObject = TXCStatus.c(this.v, 7106);
      TXCDRApi.txSetEventValue(str2, com.tencent.liteav.basic.datareport.a.X, "str_err_info", (String)localObject);
      int i4 = TXCStatus.d(this.v, 7112);
      TXCDRApi.txSetEventValue(str2, com.tencent.liteav.basic.datareport.a.X, "u32_link_type", String.valueOf(i4));
      int i5 = TXCStatus.d(this.v, 7111);
      TXCDRApi.txSetEventValue(str2, com.tencent.liteav.basic.datareport.a.X, "u32_channel_type", String.valueOf(i5));
      TXCDRApi.nativeReportEvent(str2, com.tencent.liteav.basic.datareport.a.X);
      TXCLog.d(a, "report evt 40501: token=" + str2 + " u64_timestamp=" + this.u + " str_device_type=" + (String)this.b.get("str_device_type") + " u32_network_type=" + c("u32_network_type") + " u32_dns_time=" + l1 + " u32_server_ip=" + str1 + " u32_connect_server_time=" + l2 + " u32_stream_begin=-1 u32_first_i_frame=" + this.j + " u32_first_frame_down=" + l3 + " str_user_id=" + (String)this.b.get("str_user_id") + " str_package_name=" + (String)this.b.get("str_package_name") + " str_app_version=" + this.i + " dev_uuid=" + (String)this.b.get("dev_uuid") + " u32_max_cache_time=" + i1 + " u32_min_cache_time=" + i2 + " u64_err_code=" + i3 + " str_err_info=" + (String)localObject + " u32_link_type=" + i4 + " u32_channel_type=" + i5);
      return;
      l2 = -1L;
      break;
      localObject = "";
      break label214;
    }
  }
  
  private int c(String paramString)
  {
    paramString = (Number)this.b.get(paramString);
    if (paramString != null) {
      return paramString.intValue();
    }
    return 0;
  }
  
  private void f()
  {
    Object localObject = new TXCDRExtInfo();
    ((TXCDRExtInfo)localObject).url = this.c;
    ((TXCDRExtInfo)localObject).report_common = false;
    ((TXCDRExtInfo)localObject).report_status = false;
    String str = (String)this.b.get("token");
    TXCDRApi.InitEvent(this.h, str, com.tencent.liteav.basic.datareport.a.U, com.tencent.liteav.basic.datareport.a.am, (TXCDRExtInfo)localObject);
    long l4 = TXCTimeUtil.getUtcTimeTick();
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.U, "u64_timestamp", l4);
    TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.U, "str_device_type", (String)this.b.get("str_device_type"));
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.U, "u32_network_type", c("u32_network_type"));
    long l5 = TXCStatus.b(this.v, 7107);
    long l2 = TXCStatus.b(this.v, 7108);
    long l1 = l2;
    if (l2 != -1L) {
      l1 = l2 - l5;
    }
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.U, "u32_dns_time", l1);
    localObject = TXCStatus.c(this.v, 7110);
    TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.U, "u32_server_ip", (String)localObject);
    long l3 = TXCStatus.b(this.v, 7109);
    l2 = l3;
    if (l3 != -1L) {
      l2 = l3 - l5;
    }
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.U, "u32_connect_server_time", l2);
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.U, "u32_stream_begin", -1L);
    this.j = (TXCStatus.b(this.v, 6001) - l5);
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.U, "u32_first_i_frame", this.j);
    l3 = TXCStatus.b(this.v, 7103) - l5;
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.U, "u32_first_frame_down", l3);
    TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.U, "str_user_id", (String)this.b.get("str_user_id"));
    TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.U, "str_package_name", (String)this.b.get("str_package_name"));
    TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.U, "str_app_version", this.i);
    TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.U, "dev_uuid", (String)this.b.get("dev_uuid"));
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.U, "u32_isp2p", this.k);
    TXCDRApi.nativeReportEvent(str, com.tencent.liteav.basic.datareport.a.U);
    TXCLog.d(a, "report evt 40101: token=" + str + " u64_timestamp=" + l4 + " str_device_type=" + (String)this.b.get("str_device_type") + " u32_network_type=" + c("u32_network_type") + " u32_dns_time=" + l1 + " u32_server_ip=" + (String)localObject + " u32_connect_server_time=" + l2 + " u32_stream_begin=-1 u32_first_i_frame=" + this.j + " u32_first_frame_down=" + l3 + " str_user_id=" + (String)this.b.get("str_user_id") + " str_package_name=" + (String)this.b.get("str_package_name") + " str_app_version=" + this.i + " dev_uuid=" + (String)this.b.get("dev_uuid") + " u32_isp2p=" + this.k);
  }
  
  private void g()
  {
    TXCDRExtInfo localTXCDRExtInfo = new TXCDRExtInfo();
    localTXCDRExtInfo.url = this.c;
    localTXCDRExtInfo.report_common = false;
    localTXCDRExtInfo.report_status = false;
    String str = (String)this.b.get("token");
    TXCDRApi.InitEvent(this.h, str, com.tencent.liteav.basic.datareport.a.U, com.tencent.liteav.basic.datareport.a.am, localTXCDRExtInfo);
    long l1 = TXCTimeUtil.getUtcTimeTick();
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.U, "u64_timestamp", l1);
    TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.U, "str_device_type", (String)this.b.get("str_device_type"));
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.U, "u32_network_type", c("u32_network_type"));
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.U, "u32_dns_time", -1L);
    TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.U, "u32_server_ip", "");
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.U, "u32_connect_server_time", -1L);
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.U, "u32_stream_begin", -1L);
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.U, "u32_first_i_frame", -1L);
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.U, "u32_first_frame_down", -1L);
    TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.U, "str_user_id", (String)this.b.get("str_user_id"));
    TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.U, "str_package_name", (String)this.b.get("str_package_name"));
    TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.U, "str_app_version", this.i);
    TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.U, "dev_uuid", (String)this.b.get("dev_uuid"));
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.U, "u32_isp2p", this.k);
    TXCDRApi.nativeReportEvent(str, com.tencent.liteav.basic.datareport.a.U);
    TXCLog.d(a, "report evt 40101: token=" + str + " u64_timestamp=" + l1 + " str_device_type=" + (String)this.b.get("str_device_type") + " u32_network_type=" + c("u32_network_type") + " u32_dns_time=-1 u32_server_ip= u32_connect_server_time=-1 u32_stream_begin=-1 u32_first_i_frame=-1 u32_first_frame_down=-1 str_user_id=" + (String)this.b.get("str_user_id") + " str_package_name=" + (String)this.b.get("str_package_name") + " str_app_version=" + this.i + " dev_uuid=" + (String)this.b.get("dev_uuid") + " u32_isp2p=" + this.k);
  }
  
  private void h()
  {
    TXCDRExtInfo localTXCDRExtInfo = new TXCDRExtInfo();
    localTXCDRExtInfo.url = this.c;
    localTXCDRExtInfo.report_common = false;
    localTXCDRExtInfo.report_status = false;
    String str = (String)this.b.get("token");
    TXCDRApi.InitEvent(this.h, str, com.tencent.liteav.basic.datareport.a.W, com.tencent.liteav.basic.datareport.a.am, localTXCDRExtInfo);
    long l1 = TXCTimeUtil.getUtcTimeTick();
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.W, "u64_timestamp", l1);
    long l2 = TXCStatus.b(this.v, 7107);
    l2 = (TXCTimeUtil.getTimeTick() - l2) / 1000L;
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.W, "u32_result", l2);
    long l3 = TXCStatus.b(this.v, 6003);
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.W, "u32_avg_block_time", l3);
    TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.W, "str_app_version", this.i);
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.W, "u32_isp2p", this.k);
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.W, "u32_avg_load", TXCStatus.b(this.v, 2001));
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.W, "u32_load_cnt", TXCStatus.b(this.v, 2002));
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.W, "u32_max_load", TXCStatus.b(this.v, 2003));
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.W, "u32_first_i_frame", this.j);
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.W, "u32_speed_cnt", TXCStatus.b(this.v, 2004));
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.W, "u32_nodata_cnt", TXCStatus.b(this.v, 2005));
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.W, "u32_avg_cache_time", TXCStatus.b(this.v, 2007));
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.W, "u32_is_real_time", TXCStatus.b(this.v, 2008));
    TXCDRApi.nativeReportEvent(str, com.tencent.liteav.basic.datareport.a.W);
    TXCLog.d(a, "report evt 40102: token=" + str + " str_stream_url=" + this.c + " u64_timestamp=" + l1 + " u32_result=" + l2 + " u32_avg_block_time=" + l3 + " str_app_version=" + this.i + " u32_isp2p=" + this.k + " u32_avg_load=" + TXCStatus.b(this.v, 2001) + " u32_load_cnt=" + TXCStatus.b(this.v, 2002) + " u32_max_load=" + TXCStatus.b(this.v, 2003) + " u32_first_i_frame=" + this.j + " u32_speed_cnt=" + TXCStatus.b(this.v, 2004) + " u32_nodata_cnt=" + TXCStatus.b(this.v, 2005) + " u32_avg_cache_time=" + TXCStatus.b(this.v, 2007) + " u32_is_real_time=" + TXCStatus.b(this.v, 2008));
  }
  
  private void i()
  {
    Object localObject = new TXCDRExtInfo();
    ((TXCDRExtInfo)localObject).url = this.c;
    ((TXCDRExtInfo)localObject).report_common = false;
    ((TXCDRExtInfo)localObject).report_status = true;
    String str = (String)this.b.get("token");
    TXCDRApi.InitEvent(this.h, str, com.tencent.liteav.basic.datareport.a.V, com.tencent.liteav.basic.datareport.a.am, (TXCDRExtInfo)localObject);
    int i1 = TXCStatus.d(this.v, 7102);
    int i2 = TXCStatus.d(this.v, 7101);
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.V, "u32_avg_net_speed", i1 + i2);
    double d1 = TXCStatus.e(this.v, 6002);
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.V, "u32_fps", (int)d1);
    long l1 = TXCStatus.b(this.v, 6004);
    if ((this.l != -1L) && (l1 >= this.l)) {
      TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.V, "u32_avg_block_count", l1 - this.l);
    }
    for (;;)
    {
      this.l = l1;
      localObject = com.tencent.liteav.basic.util.a.a();
      l1 = TXCStatus.b(this.v, 2006);
      TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.V, "u32_avg_cache_count", l1);
      TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.V, "u32_cpu_usage", localObject[1]);
      TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.V, "u32_app_cpu_usage", localObject[0]);
      TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.V, "str_app_version", this.i);
      TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.V, "u32_isp2p", this.k);
      TXCDRApi.nativeReportEvent(str, com.tencent.liteav.basic.datareport.a.V);
      if (this.p)
      {
        this.t += 1L;
        this.s += l1;
        if (l1 > this.r) {
          this.r = l1;
        }
      }
      return;
      TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.V, "u32_avg_block_count", 0L);
    }
  }
  
  private void j()
  {
    Object localObject1 = new HashMap();
    String str1 = TXCStatus.c(this.v, 7113);
    Object localObject2 = TXCStatus.c(this.v, 7114);
    Object localObject3 = TXCStatus.c(this.v, 7115);
    int i1 = TXCStatus.d(this.v, 7105);
    String str2 = TXCStatus.c(this.v, 7106);
    int i2 = TXCStatus.d(this.v, 7111);
    ((Map)localObject1).put("stream_url", str1);
    ((Map)localObject1).put("stream_id", localObject2);
    ((Map)localObject1).put("bizid", localObject3);
    ((Map)localObject1).put("err_code", String.valueOf(i1));
    ((Map)localObject1).put("err_info", str2);
    ((Map)localObject1).put("channel_type", String.valueOf(i2));
    long l1 = System.currentTimeMillis();
    long l2 = this.q;
    ((Map)localObject1).put("start_time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date(this.q)));
    ((Map)localObject1).put("end_time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date(l1)));
    ((Map)localObject1).put("total_time", String.valueOf(l1 - l2));
    l2 = TXCStatus.b(this.v, 6003);
    l1 = TXCStatus.b(this.v, 6006);
    long l3 = TXCStatus.b(this.v, 6005);
    if (l2 != 0L) {}
    for (l1 /= l2;; l1 = 0L)
    {
      ((Map)localObject1).put("block_count", String.valueOf(l2));
      ((Map)localObject1).put("block_duration_max", String.valueOf(l3));
      ((Map)localObject1).put("block_duration_avg", String.valueOf(l1));
      if (this.t != 0L) {}
      for (l1 = this.s / this.t;; l1 = 0L)
      {
        ((Map)localObject1).put("jitter_cache_max", String.valueOf(this.r));
        ((Map)localObject1).put("jitter_cache_avg", String.valueOf(l1));
        str1 = TXCDRApi.txCreateToken();
        i1 = com.tencent.liteav.basic.datareport.a.af;
        i2 = com.tencent.liteav.basic.datareport.a.al;
        localObject2 = new TXCDRExtInfo();
        ((TXCDRExtInfo)localObject2).command_id_comment = "LINKMIC";
        TXCDRApi.InitEvent(this.h, str1, i1, i2, (TXCDRExtInfo)localObject2);
        TXCLog.d(a, "report evt 40402: token=" + str1);
        localObject1 = ((Map)localObject1).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject1).next();
          localObject2 = (String)((Map.Entry)localObject3).getKey();
          localObject3 = (String)((Map.Entry)localObject3).getValue();
          TXCLog.e(a, "RealTimePlayStatisticInfo: " + (String)localObject2 + " = " + (String)localObject3);
          if ((localObject2 != null) && (((String)localObject2).length() > 0) && (localObject3 != null)) {
            TXCDRApi.txSetEventValue(str1, i1, (String)localObject2, (String)localObject3);
          }
        }
        TXCDRApi.nativeReportEvent(str1, i1);
        this.p = false;
        this.q = 0L;
        this.t = 0L;
        this.s = 0L;
        this.r = 0L;
        return;
      }
    }
  }
  
  private void k()
  {
    TXCDRExtInfo localTXCDRExtInfo = new TXCDRExtInfo();
    localTXCDRExtInfo.report_common = false;
    localTXCDRExtInfo.report_status = false;
    localTXCDRExtInfo.url = this.c;
    long l1 = TXCStatus.b(this.v, 7013);
    String str = (String)this.b.get("token");
    TXCDRApi.InitEvent(this.h, str, com.tencent.liteav.basic.datareport.a.P, com.tencent.liteav.basic.datareport.a.al, localTXCDRExtInfo);
    long l2 = TXCTimeUtil.getUtcTimeTick();
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.P, "u64_timestamp", TXCTimeUtil.getUtcTimeTick());
    TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.P, "str_device_type", (String)this.b.get("str_device_type"));
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.P, "u32_network_type", c("u32_network_type"));
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.P, "u32_dns_time", -1L);
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.P, "u32_connect_server_time", -1L);
    TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.P, "u32_server_ip", "");
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.P, "u32_video_resolution", this.d << 16 | this.e);
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.P, "u32_audio_samplerate", this.g);
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.P, "u32_video_bitrate", this.f);
    TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.P, "str_user_id", (String)this.b.get("str_user_id"));
    TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.P, "str_package_name", (String)this.b.get("str_package_name"));
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.P, "u32_channel_type", l1);
    TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.P, "str_app_version", this.i);
    TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.P, "dev_uuid", (String)this.b.get("dev_uuid"));
    TXCDRApi.nativeReportEvent(str, com.tencent.liteav.basic.datareport.a.P);
    TXCLog.d(a, "report evt 40001: token=" + str + " str_stream_url=" + this.c + " u64_timestamp=" + l2 + " str_device_type=" + this.b.get("str_device_type") + " u32_network_type=" + c("u32_network_type") + " u32_dns_time=-1 u32_connect_server_time=-1 u32_server_ip= u32_video_resolution=" + (this.d << 16 | this.e) + " u32_audio_samplerate=" + this.g + " u32_video_bitrate=" + this.f + " str_user_id=" + this.b.get("str_user_id") + " str_package_name=" + this.b.get("str_package_name") + " u32_channel_type=" + l1 + " str_app_version=" + this.b.get("dev_uuid") + " dev_uuid=" + c("u32_max_load"));
  }
  
  private void l()
  {
    Object localObject = new TXCDRExtInfo();
    ((TXCDRExtInfo)localObject).report_common = false;
    ((TXCDRExtInfo)localObject).report_status = false;
    ((TXCDRExtInfo)localObject).url = this.c;
    String str1 = TXCStatus.c(this.v, 7012);
    long l3 = TXCStatus.b(this.v, 7009);
    long l1 = TXCStatus.b(this.v, 7010);
    if (l1 != -1L) {
      l1 -= l3;
    }
    for (;;)
    {
      long l2 = TXCStatus.b(this.v, 7011);
      if (l2 != -1L) {
        l2 -= l3;
      }
      for (;;)
      {
        l3 = TXCStatus.b(this.v, 7013);
        String str2 = (String)this.b.get("token");
        TXCDRApi.InitEvent(this.h, str2, com.tencent.liteav.basic.datareport.a.P, com.tencent.liteav.basic.datareport.a.al, (TXCDRExtInfo)localObject);
        long l4 = TXCTimeUtil.getUtcTimeTick();
        TXCDRApi.txSetEventIntValue(str2, com.tencent.liteav.basic.datareport.a.P, "u64_timestamp", l4);
        TXCDRApi.txSetEventValue(str2, com.tencent.liteav.basic.datareport.a.P, "str_device_type", (String)this.b.get("str_device_type"));
        TXCDRApi.txSetEventIntValue(str2, com.tencent.liteav.basic.datareport.a.P, "u32_network_type", c("u32_network_type"));
        TXCDRApi.txSetEventIntValue(str2, com.tencent.liteav.basic.datareport.a.P, "u32_dns_time", l1);
        TXCDRApi.txSetEventIntValue(str2, com.tencent.liteav.basic.datareport.a.P, "u32_connect_server_time", l2);
        TXCDRApi.txSetEventValue(str2, com.tencent.liteav.basic.datareport.a.P, "u32_server_ip", str1);
        TXCDRApi.txSetEventIntValue(str2, com.tencent.liteav.basic.datareport.a.P, "u32_video_resolution", this.d << 16 | this.e);
        TXCDRApi.txSetEventIntValue(str2, com.tencent.liteav.basic.datareport.a.P, "u32_audio_samplerate", this.g);
        TXCDRApi.txSetEventIntValue(str2, com.tencent.liteav.basic.datareport.a.P, "u32_video_bitrate", this.f);
        TXCDRApi.txSetEventValue(str2, com.tencent.liteav.basic.datareport.a.P, "str_user_id", (String)this.b.get("str_user_id"));
        TXCDRApi.txSetEventValue(str2, com.tencent.liteav.basic.datareport.a.P, "str_package_name", (String)this.b.get("str_package_name"));
        TXCDRApi.txSetEventIntValue(str2, com.tencent.liteav.basic.datareport.a.P, "u32_channel_type", l3);
        TXCDRApi.txSetEventValue(str2, com.tencent.liteav.basic.datareport.a.P, "str_app_version", this.i);
        TXCDRApi.txSetEventValue(str2, com.tencent.liteav.basic.datareport.a.P, "dev_uuid", (String)this.b.get("dev_uuid"));
        localObject = TXCStatus.c(this.v, 7019);
        TXCDRApi.txSetEventValue(str2, com.tencent.liteav.basic.datareport.a.P, "str_nearest_ip_list", (String)localObject);
        TXCDRApi.nativeReportEvent(str2, com.tencent.liteav.basic.datareport.a.P);
        TXCLog.d(a, "report evt 40001: token=" + str2 + " str_stream_url=" + this.c + " u64_timestamp=" + l4 + " str_device_type=" + this.b.get("str_device_type") + " u32_network_type=" + c("u32_network_type") + " u32_dns_time=" + l1 + " u32_connect_server_time=" + l2 + " u32_server_ip=" + str1 + " u32_video_resolution=" + (this.d << 16 | this.e) + " u32_audio_samplerate=" + this.g + " u32_video_bitrate=" + this.f + " str_user_id=" + this.b.get("str_user_id") + " str_package_name=" + this.b.get("str_package_name") + " u32_channel_type=" + l3 + " str_app_version=" + this.b.get("dev_uuid") + " dev_uuid=" + c("u32_max_load"));
        return;
      }
    }
  }
  
  private void m()
  {
    TXCDRExtInfo localTXCDRExtInfo = new TXCDRExtInfo();
    localTXCDRExtInfo.report_common = false;
    localTXCDRExtInfo.report_status = false;
    localTXCDRExtInfo.url = this.c;
    long l3 = TXCStatus.b(this.v, 7009);
    long l1 = TXCStatus.b(this.v, 7013);
    String str = (String)this.b.get("token");
    TXCDRApi.InitEvent(this.h, str, com.tencent.liteav.basic.datareport.a.R, com.tencent.liteav.basic.datareport.a.al, localTXCDRExtInfo);
    long l2 = TXCTimeUtil.getUtcTimeTick();
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.R, "u64_timestamp", l2);
    l3 = (TXCTimeUtil.getTimeTick() - l3) / 1000L;
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.R, "u32_result", l3);
    TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.R, "str_user_id", (String)this.b.get("str_user_id"));
    TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.R, "str_package_name", (String)this.b.get("str_package_name"));
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.R, "u32_channel_type", l1);
    TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.R, "str_app_version", this.i);
    TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.R, "dev_uuid", (String)this.b.get("dev_uuid"));
    int i1 = TXCStatus.d(this.v, 7016);
    TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.R, "u32_ip_count_quic", String.valueOf(i1));
    i1 = TXCStatus.d(this.v, 7017);
    TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.R, "u32_connect_count_quic", String.valueOf(i1));
    i1 = TXCStatus.d(this.v, 7018);
    TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.R, "u32_connect_count_tcp", String.valueOf(i1));
    TXCDRApi.nativeReportEvent(str, com.tencent.liteav.basic.datareport.a.R);
    TXCLog.d(a, "report evt 40002: token=" + str + " str_stream_url=" + this.c + " u64_timestamp=" + l2 + " u32_result=" + l3 + " str_user_id=" + this.b.get("str_user_id") + " str_package_name=" + this.b.get("str_package_name") + " u32_channel_type=" + l1 + " str_app_version=" + this.i + " dev_uuid=" + this.b.get("dev_uuid"));
  }
  
  private void n()
  {
    Object localObject2 = new TXCDRExtInfo();
    ((TXCDRExtInfo)localObject2).report_common = false;
    ((TXCDRExtInfo)localObject2).report_status = true;
    ((TXCDRExtInfo)localObject2).url = this.c;
    Object localObject1 = com.tencent.liteav.basic.util.a.a();
    int i1 = localObject1[0];
    int i2 = localObject1[1];
    long l1 = TXCStatus.b(this.v, 7013);
    int i3 = TXCStatus.d(this.v, 7004);
    int i4 = TXCStatus.d(this.v, 7003);
    double d1 = TXCStatus.e(this.v, 4001);
    int i5 = TXCStatus.d(this.v, 7005);
    int i6 = TXCStatus.d(this.v, 7002);
    int i7 = TXCStatus.d(this.v, 7001);
    int i8 = TXCStatus.d(this.v, 4004);
    localObject1 = TXCStatus.c(this.v, 7012);
    String str1 = TXCStatus.c(this.v, 7014);
    String str2 = TXCStatus.c(this.v, 7015);
    String str3 = TXCStatus.c(this.v, 3001);
    long l2 = TXCStatus.b(this.v, 3002);
    double d2 = TXCStatus.e(this.v, 3003);
    int i9 = TXCStatus.d(this.v, 7020);
    String str4 = (String)this.b.get("token");
    TXCDRApi.InitEvent(this.h, str4, com.tencent.liteav.basic.datareport.a.Q, com.tencent.liteav.basic.datareport.a.al, (TXCDRExtInfo)localObject2);
    TXCDRApi.txSetEventIntValue(str4, com.tencent.liteav.basic.datareport.a.Q, "u32_avg_audio_bitrate", i6);
    TXCDRApi.txSetEventIntValue(str4, com.tencent.liteav.basic.datareport.a.Q, "u32_avg_video_bitrate", i7);
    TXCDRApi.txSetEventIntValue(str4, com.tencent.liteav.basic.datareport.a.Q, "u32_avg_net_speed", i3 + i4);
    TXCDRApi.txSetEventIntValue(str4, com.tencent.liteav.basic.datareport.a.Q, "u32_fps", (int)d1);
    TXCDRApi.txSetEventIntValue(str4, com.tencent.liteav.basic.datareport.a.Q, "u32_avg_cache_size", i5);
    TXCDRApi.txSetEventIntValue(str4, com.tencent.liteav.basic.datareport.a.Q, "u32_cpu_usage", i2);
    TXCDRApi.txSetEventIntValue(str4, com.tencent.liteav.basic.datareport.a.Q, "u32_app_cpu_usage", i1);
    TXCDRApi.txSetEventIntValue(str4, com.tencent.liteav.basic.datareport.a.Q, "u32_channel_type", l1);
    TXCDRApi.txSetEventValue(str4, com.tencent.liteav.basic.datareport.a.Q, "str_app_version", this.i);
    TXCDRApi.txSetEventValue(str4, com.tencent.liteav.basic.datareport.a.Q, "str_device_type", (String)this.b.get("str_device_type"));
    TXCDRApi.txSetEventIntValue(str4, com.tencent.liteav.basic.datareport.a.Q, "u32_hw_enc", i8);
    try
    {
      if ((this.h != null) && (com.tencent.liteav.basic.util.a.c(this.h) == 1))
      {
        localObject2 = (WifiManager)this.h.getSystemService("wifi");
        if (localObject2 != null)
        {
          localObject2 = ((WifiManager)localObject2).getConnectionInfo();
          if (localObject2 != null)
          {
            TXCDRApi.txSetEventValue(str4, com.tencent.liteav.basic.datareport.a.Q, "str_wifi_ssid", ((WifiInfo)localObject2).getSSID());
            TXCDRApi.txSetEventIntValue(str4, com.tencent.liteav.basic.datareport.a.Q, "str_wifi_signal_strength", WifiManager.calculateSignalLevel(((WifiInfo)localObject2).getRssi(), 32));
            TXCDRApi.txSetEventIntValue(str4, com.tencent.liteav.basic.datareport.a.Q, "str_wifi_link_speed", ((WifiInfo)localObject2).getLinkSpeed());
          }
        }
      }
    }
    catch (Exception localException)
    {
      label524:
      break label524;
    }
    TXCDRApi.txSetEventValue(str4, com.tencent.liteav.basic.datareport.a.Q, "str_server_ip", (String)localObject1);
    TXCDRApi.txSetEventValue(str4, com.tencent.liteav.basic.datareport.a.Q, "str_quic_connection_id", str1);
    TXCDRApi.txSetEventValue(str4, com.tencent.liteav.basic.datareport.a.Q, "str_quic_connection_stats", str2);
    TXCDRApi.txSetEventValue(str4, com.tencent.liteav.basic.datareport.a.Q, "str_beauty_stats", str3);
    TXCDRApi.txSetEventIntValue(str4, com.tencent.liteav.basic.datareport.a.Q, "u32_send_strategy", i9);
    TXCDRApi.txSetEventIntValue(str4, com.tencent.liteav.basic.datareport.a.Q, "u32_preprocess_timecost", l2);
    TXCDRApi.txSetEventIntValue(str4, com.tencent.liteav.basic.datareport.a.Q, "u32_preprocess_fps_out", (int)d2);
    TXCDRApi.nativeReportEvent(str4, com.tencent.liteav.basic.datareport.a.Q);
  }
  
  private void o()
  {
    this.m = false;
    this.n = 0L;
    this.b.put("str_user_id", com.tencent.liteav.basic.util.a.a(this.h));
    this.b.put("str_device_type", com.tencent.liteav.basic.util.a.b());
    this.b.put("str_device_type", com.tencent.liteav.basic.util.a.b());
    this.b.put("u32_network_type", Integer.valueOf(com.tencent.liteav.basic.util.a.c(this.h)));
    this.b.put("token", com.tencent.liteav.basic.util.a.c());
    this.b.put("str_package_name", com.tencent.liteav.basic.util.a.b(this.h));
    this.b.put("dev_uuid", com.tencent.liteav.basic.util.a.d(this.h));
  }
  
  private void p()
  {
    Object localObject = new TXCDRExtInfo();
    ((TXCDRExtInfo)localObject).url = this.c;
    ((TXCDRExtInfo)localObject).report_common = false;
    ((TXCDRExtInfo)localObject).report_status = false;
    String str = (String)this.b.get("token");
    TXCDRApi.InitEvent(this.h, str, com.tencent.liteav.basic.datareport.a.Z, com.tencent.liteav.basic.datareport.a.am, (TXCDRExtInfo)localObject);
    TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Z, "u64_begin_timestamp", String.valueOf(this.u));
    long l2 = TXCTimeUtil.getUtcTimeTick();
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Z, "u64_end_timestamp", l2);
    long l3 = (l2 - this.u) / 1000L;
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Z, "u64_playtime", l3);
    TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Z, "str_device_type", (String)this.b.get("str_device_type"));
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Z, "u32_network_type", c("u32_network_type"));
    localObject = TXCStatus.c(this.v, 7110);
    TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Z, "u32_server_ip", (String)localObject);
    TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Z, "str_user_id", (String)this.b.get("str_user_id"));
    TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Z, "str_package_name", (String)this.b.get("str_package_name"));
    TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Z, "str_app_version", this.i);
    TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Z, "dev_uuid", (String)this.b.get("dev_uuid"));
    long l4 = TXCStatus.b(this.v, 6003);
    long l5 = TXCStatus.b(this.v, 6005);
    long l6 = TXCStatus.b(this.v, 6006);
    long l1 = 0L;
    if (l4 > 0L) {
      l1 = l6 / l4;
    }
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Z, "u64_block_count", l4);
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Z, "u64_block_duration_max", l5);
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Z, "u64_block_duration_avg", l1);
    l6 = TXCStatus.b(this.v, 6009);
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Z, "u64_jitter_cache_max", l6);
    long l7 = TXCStatus.b(this.v, 6008);
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Z, "u64_jitter_cache_avg", l7);
    long l8 = TXCStatus.b(this.v, 2007);
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Z, "u64_audio_cache_avg", l8);
    int i1 = TXCStatus.d(this.v, 7112);
    TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Z, "u32_link_type", String.valueOf(i1));
    long l9 = TXCStatus.d(this.v, 2001);
    TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Z, "u32_avg_load", String.valueOf(l9));
    long l10 = TXCStatus.d(this.v, 2002);
    TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Z, "u32_load_cnt", String.valueOf(l10));
    long l11 = TXCStatus.d(this.v, 2003);
    TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Z, "u32_max_load", String.valueOf(l11));
    int i2 = TXCStatus.d(this.v, 7111);
    TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Z, "u32_channel_type", String.valueOf(i2));
    int i3 = TXCStatus.d(this.v, 7116);
    TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Z, "u32_ip_count_quic", String.valueOf(i3));
    i3 = TXCStatus.d(this.v, 7117);
    TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Z, "u32_connect_count_quic", String.valueOf(i3));
    i3 = TXCStatus.d(this.v, 7118);
    TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Z, "u32_connect_count_tcp", String.valueOf(i3));
    TXCDRApi.nativeReportEvent(str, com.tencent.liteav.basic.datareport.a.Z);
    TXCLog.d(a, "report evt 40502: token=" + str + " str_stream_url=" + this.c + " u64_begin_timestamp=" + this.u + " u64_end_timestamp=" + l2 + " u64_playtime=" + l3 + " str_device_type=" + (String)this.b.get("str_device_type") + " u32_network_type=" + c("u32_network_type") + " u32_server_ip=" + (String)localObject + " str_user_id=" + (String)this.b.get("str_user_id") + " str_package_name=" + (String)this.b.get("str_package_name") + " str_app_version=" + this.i + " dev_uuid=" + (String)this.b.get("dev_uuid") + " u64_block_count=" + l4 + " u64_block_duration_max=" + l5 + " u64_block_duration_avg=" + l1 + " u64_jitter_cache_max=" + l6 + " u64_jitter_cache_avg=" + l7 + " u64_audio_cache_avg=" + l8 + " u32_link_type=" + i1 + " u32_avg_load=" + l9 + " u32_load_cnt=" + l10 + " u32_max_load=" + l11 + " u32_channel_type=" + i2);
  }
  
  private void q()
  {
    int i2 = 2;
    Object localObject = new TXCDRExtInfo();
    ((TXCDRExtInfo)localObject).url = this.c;
    ((TXCDRExtInfo)localObject).report_common = false;
    ((TXCDRExtInfo)localObject).report_status = true;
    String str = (String)this.b.get("token");
    TXCDRApi.InitEvent(this.h, str, com.tencent.liteav.basic.datareport.a.Y, com.tencent.liteav.basic.datareport.a.am, (TXCDRExtInfo)localObject);
    int i1 = TXCStatus.d(this.v, 7102);
    int i3 = TXCStatus.d(this.v, 7101);
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Y, "u32_net_speed", i1 + i3);
    double d1 = TXCStatus.e(this.v, 6002);
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Y, "u32_fps", (int)d1);
    long l1 = TXCStatus.b(this.v, 6004);
    if ((this.l != -1L) && (l1 >= this.l))
    {
      TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Y, "u32_video_block_count", l1 - this.l);
      this.l = l1;
      l1 = TXCStatus.b(this.v, 2006);
      TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Y, "u32_video_cache_count", l1);
      localObject = com.tencent.liteav.basic.util.a.a();
      TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Y, "u32_cpu_usage", localObject[1]);
      TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Y, "u32_app_cpu_usage", localObject[0]);
      TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Y, "str_app_version", this.i);
      TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Y, "str_device_type", (String)this.b.get("str_device_type"));
      if (TXCStatus.d(this.v, 5002) != 0) {
        break label562;
      }
    }
    label562:
    for (i1 = 2;; i1 = 1)
    {
      TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Y, "u32_video_decode_type", i1);
      if (TXCStatus.d(this.v, 2015) == 0) {}
      for (i1 = i2;; i1 = 1)
      {
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Y, "u32_audio_decode_type", i1);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Y, "u32_network_type", c("u32_network_type"));
        i1 = TXCStatus.d(this.v, 6007);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Y, "u32_video_cache_time", i1);
        i1 = TXCStatus.d(this.v, 2010);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Y, "u32_audio_cache_time", i1);
        i1 = TXCStatus.d(this.v, 2011);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Y, "u32_audio_jitter", i1);
        i1 = TXCStatus.d(this.v, 2014);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Y, "u32_audio_drop", i1);
        l1 = (TXCTimeUtil.getUtcTimeTick() - this.u) / 1000L;
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Y, "u64_playtime", String.valueOf(l1));
        i1 = TXCStatus.d(this.v, 7112);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Y, "u32_link_type", String.valueOf(i1));
        i1 = TXCStatus.d(this.v, 7111);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Y, "u32_channel_type", String.valueOf(i1));
        TXCDRApi.nativeReportEvent(str, com.tencent.liteav.basic.datareport.a.Y);
        return;
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Y, "u32_video_block_count", 0L);
        break;
      }
    }
  }
  
  public void a()
  {
    o();
    this.l = -1L;
    this.q = System.currentTimeMillis();
  }
  
  public void a(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.d = paramInt1;
    this.e = paramInt2;
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  public void b()
  {
    if (this.m)
    {
      m();
      return;
    }
    TXCLog.e(a, "push " + this.c + " failed!");
    k();
  }
  
  public void b(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void b(String paramString)
  {
    this.v = paramString;
  }
  
  public void c()
  {
    if (this.m) {
      if (this.p) {
        p();
      }
    }
    for (;;)
    {
      if (this.p) {
        j();
      }
      return;
      h();
      continue;
      TXCLog.e(a, "play " + this.c + " failed");
      if (this.p) {
        b(false);
      } else {
        g();
      }
    }
  }
  
  public void d()
  {
    if ((!this.m) && (!TextUtils.isEmpty(TXCStatus.c(this.v, 7012))))
    {
      l();
      this.m = true;
    }
    if (this.n <= 0L) {
      this.n = TXCTimeUtil.getTimeTick();
    }
    if ((this.m) && (TXCTimeUtil.getTimeTick() - this.n > 5000L))
    {
      n();
      this.n = TXCTimeUtil.getTimeTick();
    }
  }
  
  public void e()
  {
    if (!this.m)
    {
      long l1 = TXCStatus.b(this.v, 6001);
      long l2 = TXCStatus.b(this.v, 7104);
      if ((l1 != 0L) || (l2 != 0L))
      {
        if (!this.p) {
          break label145;
        }
        b(true);
        this.o = 5000;
        this.m = true;
      }
    }
    if (this.n <= 0L) {
      this.n = TXCTimeUtil.getTimeTick();
    }
    if ((this.m) && (TXCTimeUtil.getTimeTick() > this.n + this.o))
    {
      if (!this.p) {
        break label152;
      }
      q();
      this.o = 5000;
    }
    for (;;)
    {
      this.l = TXCStatus.b(this.v, 6004);
      this.n = TXCTimeUtil.getTimeTick();
      return;
      label145:
      f();
      break;
      label152:
      i();
      this.o = TXCDRApi.getStatusReportInterval();
      if (this.o < 5000) {
        this.o = 5000;
      }
      if (this.o > 300000) {
        this.o = 300000;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.liteav.d
 * JD-Core Version:    0.7.0.1
 */