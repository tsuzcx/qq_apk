package com.tencent.liteav;

import android.content.Context;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.datareport.TXCDRExtInfo;
import com.tencent.liteav.basic.datareport.a;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class d
{
  private static String a;
  private static HashMap<String, d.a> w;
  private HashMap b;
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
  private boolean p;
  private long q;
  private long r;
  private long s;
  private long t;
  private long u;
  private String v;
  private String x;
  
  static
  {
    AppMethodBeat.i(67704);
    a = "TXCDataReport";
    w = new HashMap();
    AppMethodBeat.o(67704);
  }
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(67681);
    this.p = false;
    this.q = 0L;
    this.r = 0L;
    this.s = 0L;
    this.t = 0L;
    this.u = 0L;
    this.x = "";
    this.b = new HashMap(100);
    this.h = paramContext.getApplicationContext();
    this.i = TXCCommonUtil.getAppVersion();
    this.o = 5000;
    this.u = 0L;
    AppMethodBeat.o(67681);
  }
  
  private void b(boolean paramBoolean)
  {
    AppMethodBeat.i(67701);
    Object localObject = new TXCDRExtInfo();
    ((TXCDRExtInfo)localObject).url = this.c;
    ((TXCDRExtInfo)localObject).report_common = false;
    ((TXCDRExtInfo)localObject).report_status = false;
    String str2 = (String)this.b.get("token");
    TXCDRApi.InitEvent(this.h, str2, a.X, a.am, (TXCDRExtInfo)localObject);
    this.u = TXCTimeUtil.getUtcTimeTick();
    TXCDRApi.txSetEventValue(str2, a.X, "u64_timestamp", String.valueOf(this.u));
    TXCDRApi.txSetEventValue(str2, a.X, "str_device_type", (String)this.b.get("str_device_type"));
    TXCDRApi.txSetEventIntValue(str2, a.X, "u32_network_type", e("u32_network_type"));
    long l4 = TXCStatus.a(this.x, 7107);
    long l2 = TXCStatus.a(this.x, 7108);
    long l1 = l2;
    if (l2 != -1L) {
      l1 = l2 - l4;
    }
    int i1 = a.X;
    String str1;
    if (paramBoolean)
    {
      l2 = l1;
      TXCDRApi.txSetEventIntValue(str2, i1, "u32_dns_time", l2);
      str1 = TXCStatus.b(this.x, 7110);
      i1 = a.X;
      if (!paramBoolean) {
        break label871;
      }
      localObject = str1;
      label219:
      TXCDRApi.txSetEventValue(str2, i1, "u32_server_ip", (String)localObject);
      l3 = TXCStatus.a(this.x, 7109);
      l2 = l3;
      if (l3 != -1L) {
        l2 = l3 - l4;
      }
      i1 = a.X;
      if (!paramBoolean) {
        break label878;
      }
    }
    label871:
    label878:
    for (long l3 = l2;; l3 = -1L)
    {
      TXCDRApi.txSetEventIntValue(str2, i1, "u32_connect_server_time", l3);
      TXCDRApi.txSetEventIntValue(str2, a.X, "u32_stream_begin", -1L);
      this.j = (TXCStatus.a(this.x, 6001) - l4);
      TXCDRApi.txSetEventIntValue(str2, a.X, "u32_first_i_frame", this.j);
      l3 = TXCStatus.a(this.x, 7103) - l4;
      TXCDRApi.txSetEventIntValue(str2, a.X, "u32_first_frame_down", l3);
      TXCDRApi.txSetEventValue(str2, a.X, "str_user_id", (String)this.b.get("str_user_id"));
      TXCDRApi.txSetEventValue(str2, a.X, "str_package_name", (String)this.b.get("str_package_name"));
      TXCDRApi.txSetEventValue(str2, a.X, "str_app_version", this.i);
      TXCDRApi.txSetEventValue(str2, a.X, "dev_uuid", (String)this.b.get("dev_uuid"));
      i1 = TXCStatus.c(this.x, 2013);
      TXCDRApi.txSetEventValue(str2, a.X, "u32_max_cache_time", String.valueOf(i1));
      int i2 = TXCStatus.c(this.x, 2012);
      TXCDRApi.txSetEventValue(str2, a.X, "u32_min_cache_time", String.valueOf(i2));
      int i3 = TXCStatus.c(this.x, 7105);
      TXCDRApi.txSetEventValue(str2, a.X, "u64_err_code", String.valueOf(i3));
      localObject = TXCStatus.b(this.x, 7106);
      TXCDRApi.txSetEventValue(str2, a.X, "str_err_info", (String)localObject);
      int i4 = TXCStatus.c(this.x, 7112);
      TXCDRApi.txSetEventValue(str2, a.X, "u32_link_type", String.valueOf(i4));
      int i5 = TXCStatus.c(this.x, 7111);
      TXCDRApi.txSetEventValue(str2, a.X, "u32_channel_type", String.valueOf(i5));
      TXCDRApi.nativeReportEvent(str2, a.X);
      TXCLog.d(a, "report evt 40501: token=" + str2 + " u64_timestamp=" + this.u + " str_device_type=" + (String)this.b.get("str_device_type") + " u32_network_type=" + e("u32_network_type") + " u32_dns_time=" + l1 + " u32_server_ip=" + str1 + " u32_connect_server_time=" + l2 + " u32_stream_begin=-1 u32_first_i_frame=" + this.j + " u32_first_frame_down=" + l3 + " str_user_id=" + (String)this.b.get("str_user_id") + " str_package_name=" + (String)this.b.get("str_package_name") + " str_app_version=" + this.i + " dev_uuid=" + (String)this.b.get("dev_uuid") + " u32_max_cache_time=" + i1 + " u32_min_cache_time=" + i2 + " u64_err_code=" + i3 + " str_err_info=" + (String)localObject + " u32_link_type=" + i4 + " u32_channel_type=" + i5);
      AppMethodBeat.o(67701);
      return;
      l2 = -1L;
      break;
      localObject = "";
      break label219;
    }
  }
  
  protected static boolean c(String paramString)
  {
    AppMethodBeat.i(67687);
    if ((paramString != null) && (paramString.contains("myqcloud")))
    {
      AppMethodBeat.o(67687);
      return true;
    }
    boolean bool = com.tencent.liteav.basic.e.b.a().a(paramString);
    AppMethodBeat.o(67687);
    return bool;
  }
  
  private int e(String paramString)
  {
    AppMethodBeat.i(67699);
    paramString = (Number)this.b.get(paramString);
    if (paramString != null)
    {
      int i1 = paramString.intValue();
      AppMethodBeat.o(67699);
      return i1;
    }
    AppMethodBeat.o(67699);
    return 0;
  }
  
  private void i()
  {
    AppMethodBeat.i(67690);
    Object localObject = new TXCDRExtInfo();
    ((TXCDRExtInfo)localObject).url = this.c;
    ((TXCDRExtInfo)localObject).report_common = false;
    ((TXCDRExtInfo)localObject).report_status = false;
    String str = (String)this.b.get("token");
    TXCDRApi.InitEvent(this.h, str, a.U, a.am, (TXCDRExtInfo)localObject);
    long l4 = TXCTimeUtil.getUtcTimeTick();
    TXCDRApi.txSetEventIntValue(str, a.U, "u64_timestamp", l4);
    TXCDRApi.txSetEventValue(str, a.U, "str_device_type", (String)this.b.get("str_device_type"));
    TXCDRApi.txSetEventIntValue(str, a.U, "u32_network_type", e("u32_network_type"));
    long l5 = TXCStatus.a(this.x, 7107);
    long l2 = TXCStatus.a(this.x, 7108);
    long l1 = l2;
    if (l2 != -1L) {
      l1 = l2 - l5;
    }
    TXCDRApi.txSetEventIntValue(str, a.U, "u32_dns_time", l1);
    localObject = TXCStatus.b(this.x, 7110);
    TXCDRApi.txSetEventValue(str, a.U, "u32_server_ip", (String)localObject);
    long l3 = TXCStatus.a(this.x, 7109);
    l2 = l3;
    if (l3 != -1L) {
      l2 = l3 - l5;
    }
    TXCDRApi.txSetEventIntValue(str, a.U, "u32_connect_server_time", l2);
    TXCDRApi.txSetEventIntValue(str, a.U, "u32_stream_begin", -1L);
    this.j = (TXCStatus.a(this.x, 6001) - l5);
    TXCDRApi.txSetEventIntValue(str, a.U, "u32_first_i_frame", this.j);
    l3 = TXCStatus.a(this.x, 7103) - l5;
    TXCDRApi.txSetEventIntValue(str, a.U, "u32_first_frame_down", l3);
    TXCDRApi.txSetEventValue(str, a.U, "str_user_id", (String)this.b.get("str_user_id"));
    TXCDRApi.txSetEventValue(str, a.U, "str_package_name", (String)this.b.get("str_package_name"));
    TXCDRApi.txSetEventValue(str, a.U, "str_app_version", this.i);
    TXCDRApi.txSetEventValue(str, a.U, "dev_uuid", (String)this.b.get("dev_uuid"));
    TXCDRApi.txSetEventIntValue(str, a.U, "u32_isp2p", this.k);
    TXCDRApi.nativeReportEvent(str, a.U);
    TXCLog.d(a, "report evt 40101: token=" + str + " u64_timestamp=" + l4 + " str_device_type=" + (String)this.b.get("str_device_type") + " u32_network_type=" + e("u32_network_type") + " u32_dns_time=" + l1 + " u32_server_ip=" + (String)localObject + " u32_connect_server_time=" + l2 + " u32_stream_begin=-1 u32_first_i_frame=" + this.j + " u32_first_frame_down=" + l3 + " str_user_id=" + (String)this.b.get("str_user_id") + " str_package_name=" + (String)this.b.get("str_package_name") + " str_app_version=" + this.i + " dev_uuid=" + (String)this.b.get("dev_uuid") + " u32_isp2p=" + this.k);
    AppMethodBeat.o(67690);
  }
  
  private void j()
  {
    AppMethodBeat.i(67691);
    TXCDRExtInfo localTXCDRExtInfo = new TXCDRExtInfo();
    localTXCDRExtInfo.url = this.c;
    localTXCDRExtInfo.report_common = false;
    localTXCDRExtInfo.report_status = false;
    String str = (String)this.b.get("token");
    TXCDRApi.InitEvent(this.h, str, a.U, a.am, localTXCDRExtInfo);
    long l1 = TXCTimeUtil.getUtcTimeTick();
    TXCDRApi.txSetEventIntValue(str, a.U, "u64_timestamp", l1);
    TXCDRApi.txSetEventValue(str, a.U, "str_device_type", (String)this.b.get("str_device_type"));
    TXCDRApi.txSetEventIntValue(str, a.U, "u32_network_type", e("u32_network_type"));
    TXCDRApi.txSetEventIntValue(str, a.U, "u32_dns_time", -1L);
    TXCDRApi.txSetEventValue(str, a.U, "u32_server_ip", "");
    TXCDRApi.txSetEventIntValue(str, a.U, "u32_connect_server_time", -1L);
    TXCDRApi.txSetEventIntValue(str, a.U, "u32_stream_begin", -1L);
    TXCDRApi.txSetEventIntValue(str, a.U, "u32_first_i_frame", -1L);
    TXCDRApi.txSetEventIntValue(str, a.U, "u32_first_frame_down", -1L);
    TXCDRApi.txSetEventValue(str, a.U, "str_user_id", (String)this.b.get("str_user_id"));
    TXCDRApi.txSetEventValue(str, a.U, "str_package_name", (String)this.b.get("str_package_name"));
    TXCDRApi.txSetEventValue(str, a.U, "str_app_version", this.i);
    TXCDRApi.txSetEventValue(str, a.U, "dev_uuid", (String)this.b.get("dev_uuid"));
    TXCDRApi.txSetEventIntValue(str, a.U, "u32_isp2p", this.k);
    TXCDRApi.nativeReportEvent(str, a.U);
    TXCLog.d(a, "report evt 40101: token=" + str + " u64_timestamp=" + l1 + " str_device_type=" + (String)this.b.get("str_device_type") + " u32_network_type=" + e("u32_network_type") + " u32_dns_time=-1 u32_server_ip= u32_connect_server_time=-1 u32_stream_begin=-1 u32_first_i_frame=-1 u32_first_frame_down=-1 str_user_id=" + (String)this.b.get("str_user_id") + " str_package_name=" + (String)this.b.get("str_package_name") + " str_app_version=" + this.i + " dev_uuid=" + (String)this.b.get("dev_uuid") + " u32_isp2p=" + this.k);
    AppMethodBeat.o(67691);
  }
  
  private void k()
  {
    AppMethodBeat.i(67692);
    TXCDRExtInfo localTXCDRExtInfo = new TXCDRExtInfo();
    localTXCDRExtInfo.url = this.c;
    localTXCDRExtInfo.report_common = false;
    localTXCDRExtInfo.report_status = false;
    String str = (String)this.b.get("token");
    TXCDRApi.InitEvent(this.h, str, a.W, a.am, localTXCDRExtInfo);
    long l1 = TXCTimeUtil.getUtcTimeTick();
    TXCDRApi.txSetEventIntValue(str, a.W, "u64_timestamp", l1);
    long l2 = TXCStatus.a(this.x, 7107);
    l2 = (TXCTimeUtil.getTimeTick() - l2) / 1000L;
    TXCDRApi.txSetEventIntValue(str, a.W, "u32_result", l2);
    long l3 = TXCStatus.a(this.x, 6003);
    TXCDRApi.txSetEventIntValue(str, a.W, "u32_avg_block_time", l3);
    TXCDRApi.txSetEventValue(str, a.W, "str_app_version", this.i);
    TXCDRApi.txSetEventIntValue(str, a.W, "u32_isp2p", this.k);
    TXCDRApi.txSetEventIntValue(str, a.W, "u32_avg_load", TXCStatus.a(this.x, 2001));
    TXCDRApi.txSetEventIntValue(str, a.W, "u32_load_cnt", TXCStatus.a(this.x, 2002));
    TXCDRApi.txSetEventIntValue(str, a.W, "u32_max_load", TXCStatus.a(this.x, 2003));
    TXCDRApi.txSetEventIntValue(str, a.W, "u32_first_i_frame", this.j);
    TXCDRApi.txSetEventIntValue(str, a.W, "u32_speed_cnt", TXCStatus.a(this.x, 2004));
    TXCDRApi.txSetEventIntValue(str, a.W, "u32_nodata_cnt", TXCStatus.a(this.x, 2005));
    TXCDRApi.txSetEventIntValue(str, a.W, "u32_avg_cache_time", TXCStatus.a(this.x, 2008));
    TXCDRApi.txSetEventIntValue(str, a.W, "u32_is_real_time", TXCStatus.a(this.x, 2009));
    TXCDRApi.nativeReportEvent(str, a.W);
    TXCLog.d(a, "report evt 40102: token=" + str + " str_stream_url=" + this.c + " u64_timestamp=" + l1 + " u32_result=" + l2 + " u32_avg_block_time=" + l3 + " str_app_version=" + this.i + " u32_isp2p=" + this.k + " u32_avg_load=" + TXCStatus.a(this.x, 2001) + " u32_load_cnt=" + TXCStatus.a(this.x, 2002) + " u32_max_load=" + TXCStatus.a(this.x, 2003) + " u32_first_i_frame=" + this.j + " u32_speed_cnt=" + TXCStatus.a(this.x, 2004) + " u32_nodata_cnt=" + TXCStatus.a(this.x, 2005) + " u32_avg_cache_time=" + TXCStatus.a(this.x, 2008) + " u32_is_real_time=" + TXCStatus.a(this.x, 2009));
    AppMethodBeat.o(67692);
  }
  
  private void l()
  {
    AppMethodBeat.i(67693);
    Object localObject = new TXCDRExtInfo();
    ((TXCDRExtInfo)localObject).url = this.c;
    ((TXCDRExtInfo)localObject).report_common = false;
    ((TXCDRExtInfo)localObject).report_status = true;
    String str = (String)this.b.get("token");
    TXCDRApi.InitEvent(this.h, str, a.V, a.am, (TXCDRExtInfo)localObject);
    int i1 = TXCStatus.c(this.x, 7102);
    int i2 = TXCStatus.c(this.x, 7101);
    TXCDRApi.txSetEventIntValue(str, a.V, "u32_avg_net_speed", i1 + i2);
    double d1 = TXCStatus.d(this.x, 6002);
    TXCDRApi.txSetEventIntValue(str, a.V, "u32_fps", (int)d1);
    long l1 = TXCStatus.a(this.x, 6004);
    if ((this.l != -1L) && (l1 >= this.l)) {
      TXCDRApi.txSetEventIntValue(str, a.V, "u32_avg_block_count", l1 - this.l);
    }
    for (;;)
    {
      this.l = l1;
      localObject = com.tencent.liteav.basic.util.b.a();
      i1 = com.tencent.liteav.basic.util.b.b();
      l1 = TXCStatus.a(this.x, 6008);
      TXCDRApi.txSetEventIntValue(str, a.V, "u32_avg_cache_count", l1);
      TXCDRApi.txSetEventIntValue(str, a.V, "u32_cpu_usage", localObject[1]);
      TXCDRApi.txSetEventIntValue(str, a.V, "u32_app_cpu_usage", localObject[0]);
      TXCDRApi.txSetEventIntValue(str, a.V, "u32_app_mem_usage", i1);
      TXCDRApi.txSetEventValue(str, a.V, "str_app_version", this.i);
      TXCDRApi.txSetEventIntValue(str, a.V, "u32_isp2p", this.k);
      TXCDRApi.nativeReportEvent(str, a.V);
      if (this.p)
      {
        this.t += 1L;
        this.s += l1;
        if (l1 > this.r) {
          this.r = l1;
        }
      }
      AppMethodBeat.o(67693);
      return;
      TXCDRApi.txSetEventIntValue(str, a.V, "u32_avg_block_count", 0L);
    }
  }
  
  private void m()
  {
    AppMethodBeat.i(67694);
    Object localObject1 = new HashMap();
    String str1 = TXCStatus.b(this.x, 7116);
    Object localObject2 = TXCStatus.b(this.x, 7117);
    Object localObject3 = TXCStatus.b(this.x, 7118);
    int i1 = TXCStatus.c(this.x, 7105);
    String str2 = TXCStatus.b(this.x, 7106);
    int i2 = TXCStatus.c(this.x, 7111);
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
    l2 = TXCStatus.a(this.x, 6003);
    l1 = TXCStatus.a(this.x, 6006);
    long l3 = TXCStatus.a(this.x, 6005);
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
        i1 = a.af;
        i2 = a.al;
        localObject2 = new TXCDRExtInfo();
        ((TXCDRExtInfo)localObject2).command_id_comment = "LINKMIC";
        TXCDRApi.InitEvent(this.h, str1, i1, i2, (TXCDRExtInfo)localObject2);
        TXCLog.d(a, "report evt 40402: token=".concat(String.valueOf(str1)));
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
        AppMethodBeat.o(67694);
        return;
      }
    }
  }
  
  private void n()
  {
    AppMethodBeat.i(67695);
    TXCDRExtInfo localTXCDRExtInfo = new TXCDRExtInfo();
    localTXCDRExtInfo.report_common = false;
    localTXCDRExtInfo.report_status = false;
    localTXCDRExtInfo.url = this.c;
    long l1 = TXCStatus.a(this.x, 7013);
    String str = (String)this.b.get("token");
    TXCDRApi.InitEvent(this.h, str, a.P, a.al, localTXCDRExtInfo);
    long l2 = TXCTimeUtil.getUtcTimeTick();
    TXCDRApi.txSetEventIntValue(str, a.P, "u64_timestamp", TXCTimeUtil.getUtcTimeTick());
    TXCDRApi.txSetEventValue(str, a.P, "str_device_type", (String)this.b.get("str_device_type"));
    TXCDRApi.txSetEventIntValue(str, a.P, "u32_network_type", e("u32_network_type"));
    TXCDRApi.txSetEventIntValue(str, a.P, "u32_dns_time", -1L);
    TXCDRApi.txSetEventIntValue(str, a.P, "u32_connect_server_time", -1L);
    TXCDRApi.txSetEventValue(str, a.P, "u32_server_ip", "");
    TXCDRApi.txSetEventIntValue(str, a.P, "u32_video_resolution", this.d << 16 | this.e);
    TXCDRApi.txSetEventIntValue(str, a.P, "u32_audio_samplerate", this.g);
    TXCDRApi.txSetEventIntValue(str, a.P, "u32_video_bitrate", this.f);
    TXCDRApi.txSetEventValue(str, a.P, "str_user_id", (String)this.b.get("str_user_id"));
    TXCDRApi.txSetEventValue(str, a.P, "str_package_name", (String)this.b.get("str_package_name"));
    TXCDRApi.txSetEventIntValue(str, a.P, "u32_channel_type", l1);
    TXCDRApi.txSetEventValue(str, a.P, "str_app_version", this.i);
    TXCDRApi.txSetEventValue(str, a.P, "dev_uuid", (String)this.b.get("dev_uuid"));
    TXCDRApi.nativeReportEvent(str, a.P);
    TXCLog.d(a, "report evt 40001: token=" + str + " str_stream_url=" + this.c + " u64_timestamp=" + l2 + " str_device_type=" + this.b.get("str_device_type") + " u32_network_type=" + e("u32_network_type") + " u32_dns_time=-1 u32_connect_server_time=-1 u32_server_ip= u32_video_resolution=" + (this.d << 16 | this.e) + " u32_audio_samplerate=" + this.g + " u32_video_bitrate=" + this.f + " str_user_id=" + this.b.get("str_user_id") + " str_package_name=" + this.b.get("str_package_name") + " u32_channel_type=" + l1 + " str_app_version=" + this.b.get("dev_uuid") + " dev_uuid=" + e("u32_max_load"));
    AppMethodBeat.o(67695);
  }
  
  private void o()
  {
    AppMethodBeat.i(67696);
    Object localObject = new TXCDRExtInfo();
    ((TXCDRExtInfo)localObject).report_common = false;
    ((TXCDRExtInfo)localObject).report_status = false;
    ((TXCDRExtInfo)localObject).url = this.c;
    String str1 = TXCStatus.b(this.x, 7012);
    long l3 = TXCStatus.a(this.x, 7009);
    long l1 = TXCStatus.a(this.x, 7010);
    if (l1 != -1L) {
      l1 -= l3;
    }
    for (;;)
    {
      long l2 = TXCStatus.a(this.x, 7011);
      if (l2 != -1L) {
        l2 -= l3;
      }
      for (;;)
      {
        l3 = TXCStatus.a(this.x, 7013);
        String str2 = (String)this.b.get("token");
        TXCDRApi.InitEvent(this.h, str2, a.P, a.al, (TXCDRExtInfo)localObject);
        long l4 = TXCTimeUtil.getUtcTimeTick();
        TXCDRApi.txSetEventIntValue(str2, a.P, "u64_timestamp", l4);
        TXCDRApi.txSetEventValue(str2, a.P, "str_device_type", (String)this.b.get("str_device_type"));
        TXCDRApi.txSetEventIntValue(str2, a.P, "u32_network_type", e("u32_network_type"));
        TXCDRApi.txSetEventIntValue(str2, a.P, "u32_dns_time", l1);
        TXCDRApi.txSetEventIntValue(str2, a.P, "u32_connect_server_time", l2);
        TXCDRApi.txSetEventValue(str2, a.P, "u32_server_ip", str1);
        TXCDRApi.txSetEventIntValue(str2, a.P, "u32_video_resolution", this.d << 16 | this.e);
        TXCDRApi.txSetEventIntValue(str2, a.P, "u32_audio_samplerate", this.g);
        TXCDRApi.txSetEventIntValue(str2, a.P, "u32_video_bitrate", this.f);
        TXCDRApi.txSetEventValue(str2, a.P, "str_user_id", (String)this.b.get("str_user_id"));
        TXCDRApi.txSetEventValue(str2, a.P, "str_package_name", (String)this.b.get("str_package_name"));
        TXCDRApi.txSetEventIntValue(str2, a.P, "u32_channel_type", l3);
        TXCDRApi.txSetEventValue(str2, a.P, "str_app_version", this.i);
        TXCDRApi.txSetEventValue(str2, a.P, "dev_uuid", (String)this.b.get("dev_uuid"));
        localObject = TXCStatus.b(this.x, 7019);
        TXCDRApi.txSetEventValue(str2, a.P, "str_nearest_ip_list", (String)localObject);
        TXCDRApi.nativeReportEvent(str2, a.P);
        TXCLog.d(a, "report evt 40001: token=" + str2 + " str_stream_url=" + this.c + " u64_timestamp=" + l4 + " str_device_type=" + this.b.get("str_device_type") + " u32_network_type=" + e("u32_network_type") + " u32_dns_time=" + l1 + " u32_connect_server_time=" + l2 + " u32_server_ip=" + str1 + " u32_video_resolution=" + (this.d << 16 | this.e) + " u32_audio_samplerate=" + this.g + " u32_video_bitrate=" + this.f + " str_user_id=" + this.b.get("str_user_id") + " str_package_name=" + this.b.get("str_package_name") + " u32_channel_type=" + l3 + " str_app_version=" + this.b.get("dev_uuid") + " dev_uuid=" + e("u32_max_load"));
        AppMethodBeat.o(67696);
        return;
      }
    }
  }
  
  private void p()
  {
    AppMethodBeat.i(67697);
    TXCDRExtInfo localTXCDRExtInfo = new TXCDRExtInfo();
    localTXCDRExtInfo.report_common = false;
    localTXCDRExtInfo.report_status = false;
    localTXCDRExtInfo.url = this.c;
    long l3 = TXCStatus.a(this.x, 7009);
    long l1 = TXCStatus.a(this.x, 7013);
    String str = (String)this.b.get("token");
    TXCDRApi.InitEvent(this.h, str, a.R, a.al, localTXCDRExtInfo);
    long l2 = TXCTimeUtil.getUtcTimeTick();
    TXCDRApi.txSetEventIntValue(str, a.R, "u64_timestamp", l2);
    l3 = (TXCTimeUtil.getTimeTick() - l3) / 1000L;
    TXCDRApi.txSetEventIntValue(str, a.R, "u32_result", l3);
    TXCDRApi.txSetEventValue(str, a.R, "str_user_id", (String)this.b.get("str_user_id"));
    TXCDRApi.txSetEventValue(str, a.R, "str_package_name", (String)this.b.get("str_package_name"));
    TXCDRApi.txSetEventIntValue(str, a.R, "u32_channel_type", l1);
    TXCDRApi.txSetEventValue(str, a.R, "str_app_version", this.i);
    TXCDRApi.txSetEventValue(str, a.R, "dev_uuid", (String)this.b.get("dev_uuid"));
    int i1 = TXCStatus.c(this.x, 7016);
    TXCDRApi.txSetEventValue(str, a.R, "u32_ip_count_quic", String.valueOf(i1));
    i1 = TXCStatus.c(this.x, 7017);
    TXCDRApi.txSetEventValue(str, a.R, "u32_connect_count_quic", String.valueOf(i1));
    i1 = TXCStatus.c(this.x, 7018);
    TXCDRApi.txSetEventValue(str, a.R, "u32_connect_count_tcp", String.valueOf(i1));
    TXCDRApi.nativeReportEvent(str, a.R);
    TXCLog.d(a, "report evt 40002: token=" + str + " str_stream_url=" + this.c + " u64_timestamp=" + l2 + " u32_result=" + l3 + " str_user_id=" + this.b.get("str_user_id") + " str_package_name=" + this.b.get("str_package_name") + " u32_channel_type=" + l1 + " str_app_version=" + this.i + " dev_uuid=" + this.b.get("dev_uuid"));
    AppMethodBeat.o(67697);
  }
  
  private void q()
  {
    AppMethodBeat.i(67698);
    Object localObject2 = new TXCDRExtInfo();
    ((TXCDRExtInfo)localObject2).report_common = false;
    ((TXCDRExtInfo)localObject2).report_status = true;
    ((TXCDRExtInfo)localObject2).url = this.c;
    Object localObject1 = com.tencent.liteav.basic.util.b.a();
    int i1 = localObject1[0];
    int i2 = localObject1[1];
    int i3 = com.tencent.liteav.basic.util.b.b();
    long l1 = TXCStatus.a(this.x, 7013);
    int i4 = TXCStatus.c(this.x, 7004);
    int i5 = TXCStatus.c(this.x, 7003);
    double d1 = TXCStatus.d(this.x, 4001);
    int i6 = TXCStatus.c(this.x, 7005);
    int i7 = TXCStatus.c(this.x, 7002);
    int i8 = TXCStatus.c(this.x, 7001);
    int i9 = TXCStatus.c(this.x, 4007);
    localObject1 = TXCStatus.b(this.x, 7012);
    String str1 = TXCStatus.b(this.x, 7014);
    String str2 = TXCStatus.b(this.x, 7015);
    String str3 = TXCStatus.b(this.x, 3001);
    long l2 = TXCStatus.a(this.x, 3002);
    double d2 = TXCStatus.d(this.x, 3003);
    int i10 = TXCStatus.c(this.x, 7020);
    String str4 = (String)this.b.get("token");
    TXCDRApi.InitEvent(this.h, str4, a.Q, a.al, (TXCDRExtInfo)localObject2);
    TXCDRApi.txSetEventIntValue(str4, a.Q, "u32_avg_audio_bitrate", i7);
    TXCDRApi.txSetEventIntValue(str4, a.Q, "u32_avg_video_bitrate", i8);
    TXCDRApi.txSetEventIntValue(str4, a.Q, "u32_avg_net_speed", i4 + i5);
    TXCDRApi.txSetEventIntValue(str4, a.Q, "u32_fps", (int)d1);
    TXCDRApi.txSetEventIntValue(str4, a.Q, "u32_avg_cache_size", i6);
    TXCDRApi.txSetEventIntValue(str4, a.Q, "u32_cpu_usage", i2);
    TXCDRApi.txSetEventIntValue(str4, a.Q, "u32_app_cpu_usage", i1);
    TXCDRApi.txSetEventIntValue(str4, a.Q, "u32_app_mem_usage", i3);
    TXCDRApi.txSetEventIntValue(str4, a.Q, "u32_channel_type", l1);
    TXCDRApi.txSetEventValue(str4, a.Q, "str_app_version", this.i);
    TXCDRApi.txSetEventValue(str4, a.Q, "str_device_type", (String)this.b.get("str_device_type"));
    TXCDRApi.txSetEventIntValue(str4, a.Q, "u32_hw_enc", i9);
    try
    {
      if ((this.h != null) && (com.tencent.liteav.basic.util.b.d(this.h) == 1))
      {
        localObject2 = (WifiManager)this.h.getSystemService("wifi");
        if (localObject2 != null)
        {
          localObject2 = ((WifiManager)localObject2).getConnectionInfo();
          if (localObject2 != null)
          {
            TXCDRApi.txSetEventValue(str4, a.Q, "str_wifi_ssid", ((WifiInfo)localObject2).getSSID());
            TXCDRApi.txSetEventIntValue(str4, a.Q, "str_wifi_signal_strength", WifiManager.calculateSignalLevel(((WifiInfo)localObject2).getRssi(), 32));
            TXCDRApi.txSetEventIntValue(str4, a.Q, "str_wifi_link_speed", ((WifiInfo)localObject2).getLinkSpeed());
          }
        }
      }
    }
    catch (Exception localException)
    {
      label549:
      break label549;
    }
    TXCDRApi.txSetEventValue(str4, a.Q, "str_server_ip", (String)localObject1);
    TXCDRApi.txSetEventValue(str4, a.Q, "str_quic_connection_id", str1);
    TXCDRApi.txSetEventValue(str4, a.Q, "str_quic_connection_stats", str2);
    TXCDRApi.txSetEventValue(str4, a.Q, "str_beauty_stats", str3);
    TXCDRApi.txSetEventIntValue(str4, a.Q, "u32_send_strategy", i10);
    TXCDRApi.txSetEventIntValue(str4, a.Q, "u32_preprocess_timecost", l2);
    TXCDRApi.txSetEventIntValue(str4, a.Q, "u32_preprocess_fps_out", (int)d2);
    TXCDRApi.nativeReportEvent(str4, a.Q);
    AppMethodBeat.o(67698);
  }
  
  private void r()
  {
    AppMethodBeat.i(67700);
    this.m = false;
    this.n = 0L;
    this.b.put("str_user_id", com.tencent.liteav.basic.util.b.b(this.h));
    this.b.put("str_device_type", com.tencent.liteav.basic.util.b.c());
    this.b.put("str_device_type", com.tencent.liteav.basic.util.b.c());
    this.b.put("u32_network_type", Integer.valueOf(com.tencent.liteav.basic.util.b.d(this.h)));
    this.b.put("token", com.tencent.liteav.basic.util.b.e());
    this.b.put("str_package_name", com.tencent.liteav.basic.util.b.c(this.h));
    this.b.put("dev_uuid", com.tencent.liteav.basic.util.b.e(this.h));
    AppMethodBeat.o(67700);
  }
  
  private void s()
  {
    AppMethodBeat.i(67702);
    Object localObject = new TXCDRExtInfo();
    ((TXCDRExtInfo)localObject).url = this.c;
    ((TXCDRExtInfo)localObject).report_common = false;
    ((TXCDRExtInfo)localObject).report_status = false;
    String str = (String)this.b.get("token");
    TXCDRApi.InitEvent(this.h, str, a.Z, a.am, (TXCDRExtInfo)localObject);
    TXCDRApi.txSetEventValue(str, a.Z, "u64_begin_timestamp", String.valueOf(this.u));
    long l2 = TXCTimeUtil.getUtcTimeTick();
    TXCDRApi.txSetEventIntValue(str, a.Z, "u64_end_timestamp", l2);
    long l3 = (l2 - this.u) / 1000L;
    TXCDRApi.txSetEventIntValue(str, a.Z, "u64_playtime", l3);
    TXCDRApi.txSetEventValue(str, a.Z, "str_device_type", (String)this.b.get("str_device_type"));
    TXCDRApi.txSetEventIntValue(str, a.Z, "u32_network_type", e("u32_network_type"));
    localObject = TXCStatus.b(this.x, 7110);
    TXCDRApi.txSetEventValue(str, a.Z, "u32_server_ip", (String)localObject);
    TXCDRApi.txSetEventValue(str, a.Z, "str_user_id", (String)this.b.get("str_user_id"));
    TXCDRApi.txSetEventValue(str, a.Z, "str_package_name", (String)this.b.get("str_package_name"));
    TXCDRApi.txSetEventValue(str, a.Z, "str_app_version", this.i);
    TXCDRApi.txSetEventValue(str, a.Z, "dev_uuid", (String)this.b.get("dev_uuid"));
    long l4 = TXCStatus.a(this.x, 6003);
    long l5 = TXCStatus.a(this.x, 6005);
    long l6 = TXCStatus.a(this.x, 6006);
    long l1 = 0L;
    if (l4 > 0L) {
      l1 = l6 / l4;
    }
    TXCDRApi.txSetEventIntValue(str, a.Z, "u64_block_count", l4);
    TXCDRApi.txSetEventIntValue(str, a.Z, "u64_block_duration_max", l5);
    TXCDRApi.txSetEventIntValue(str, a.Z, "u64_block_duration_avg", l1);
    l6 = TXCStatus.a(this.x, 6009);
    TXCDRApi.txSetEventIntValue(str, a.Z, "u64_jitter_cache_max", l6);
    long l7 = TXCStatus.a(this.x, 6008);
    TXCDRApi.txSetEventIntValue(str, a.Z, "u64_jitter_cache_avg", l7);
    long l8 = TXCStatus.a(this.x, 2008);
    TXCDRApi.txSetEventIntValue(str, a.Z, "u64_audio_cache_avg", l8);
    int i1 = TXCStatus.c(this.x, 7112);
    TXCDRApi.txSetEventValue(str, a.Z, "u32_link_type", String.valueOf(i1));
    long l9 = TXCStatus.c(this.x, 2001);
    TXCDRApi.txSetEventValue(str, a.Z, "u32_avg_load", String.valueOf(l9));
    long l10 = TXCStatus.c(this.x, 2002);
    TXCDRApi.txSetEventValue(str, a.Z, "u32_load_cnt", String.valueOf(l10));
    long l11 = TXCStatus.c(this.x, 2003);
    TXCDRApi.txSetEventValue(str, a.Z, "u32_max_load", String.valueOf(l11));
    int i2 = TXCStatus.c(this.x, 7111);
    TXCDRApi.txSetEventValue(str, a.Z, "u32_channel_type", String.valueOf(i2));
    int i3 = TXCStatus.c(this.x, 7113);
    TXCDRApi.txSetEventValue(str, a.Z, "u32_ip_count_quic", String.valueOf(i3));
    i3 = TXCStatus.c(this.x, 7114);
    TXCDRApi.txSetEventValue(str, a.Z, "u32_connect_count_quic", String.valueOf(i3));
    i3 = TXCStatus.c(this.x, 7115);
    TXCDRApi.txSetEventValue(str, a.Z, "u32_connect_count_tcp", String.valueOf(i3));
    TXCDRApi.nativeReportEvent(str, a.Z);
    TXCLog.d(a, "report evt 40502: token=" + str + " str_stream_url=" + this.c + " u64_begin_timestamp=" + this.u + " u64_end_timestamp=" + l2 + " u64_playtime=" + l3 + " str_device_type=" + (String)this.b.get("str_device_type") + " u32_network_type=" + e("u32_network_type") + " u32_server_ip=" + (String)localObject + " str_user_id=" + (String)this.b.get("str_user_id") + " str_package_name=" + (String)this.b.get("str_package_name") + " str_app_version=" + this.i + " dev_uuid=" + (String)this.b.get("dev_uuid") + " u64_block_count=" + l4 + " u64_block_duration_max=" + l5 + " u64_block_duration_avg=" + l1 + " u64_jitter_cache_max=" + l6 + " u64_jitter_cache_avg=" + l7 + " u64_audio_cache_avg=" + l8 + " u32_link_type=" + i1 + " u32_avg_load=" + l9 + " u32_load_cnt=" + l10 + " u32_max_load=" + l11 + " u32_channel_type=" + i2);
    AppMethodBeat.o(67702);
  }
  
  private void t()
  {
    int i2 = 2;
    AppMethodBeat.i(67703);
    Object localObject = new TXCDRExtInfo();
    ((TXCDRExtInfo)localObject).url = this.c;
    ((TXCDRExtInfo)localObject).report_common = false;
    ((TXCDRExtInfo)localObject).report_status = true;
    String str = (String)this.b.get("token");
    TXCDRApi.InitEvent(this.h, str, a.Y, a.am, (TXCDRExtInfo)localObject);
    int i1 = TXCStatus.c(this.x, 7102);
    int i3 = TXCStatus.c(this.x, 7101);
    TXCDRApi.txSetEventIntValue(str, a.Y, "u32_net_speed", i1 + i3);
    double d1 = TXCStatus.d(this.x, 6002);
    TXCDRApi.txSetEventIntValue(str, a.Y, "u32_fps", (int)d1);
    long l1 = TXCStatus.a(this.x, 6004);
    if ((this.l != -1L) && (l1 >= this.l))
    {
      TXCDRApi.txSetEventIntValue(str, a.Y, "u32_video_block_count", l1 - this.l);
      this.l = l1;
      l1 = TXCStatus.a(this.x, 6008);
      TXCDRApi.txSetEventIntValue(str, a.Y, "u32_video_cache_count", l1);
      localObject = com.tencent.liteav.basic.util.b.a();
      TXCDRApi.txSetEventIntValue(str, a.Y, "u32_cpu_usage", localObject[1]);
      TXCDRApi.txSetEventIntValue(str, a.Y, "u32_app_cpu_usage", localObject[0]);
      i1 = com.tencent.liteav.basic.util.b.b();
      TXCDRApi.txSetEventIntValue(str, a.Y, "u32_app_mem_usage", i1);
      TXCDRApi.txSetEventValue(str, a.Y, "str_app_version", this.i);
      TXCDRApi.txSetEventValue(str, a.Y, "str_device_type", (String)this.b.get("str_device_type"));
      if (TXCStatus.c(this.x, 5002) != 0) {
        break label591;
      }
    }
    label591:
    for (i1 = 2;; i1 = 1)
    {
      TXCDRApi.txSetEventIntValue(str, a.Y, "u32_video_decode_type", i1);
      if (TXCStatus.c(this.x, 2015) == 0) {}
      for (i1 = i2;; i1 = 1)
      {
        TXCDRApi.txSetEventIntValue(str, a.Y, "u32_audio_decode_type", i1);
        TXCDRApi.txSetEventIntValue(str, a.Y, "u32_network_type", e("u32_network_type"));
        i1 = TXCStatus.c(this.x, 6007);
        TXCDRApi.txSetEventIntValue(str, a.Y, "u32_video_cache_time", i1);
        i1 = TXCStatus.c(this.x, 2010);
        TXCDRApi.txSetEventIntValue(str, a.Y, "u32_audio_cache_time", i1);
        i1 = TXCStatus.c(this.x, 2011);
        TXCDRApi.txSetEventIntValue(str, a.Y, "u32_audio_jitter", i1);
        i1 = TXCStatus.c(this.x, 2014);
        TXCDRApi.txSetEventIntValue(str, a.Y, "u32_audio_drop", i1);
        l1 = (TXCTimeUtil.getUtcTimeTick() - this.u) / 1000L;
        TXCDRApi.txSetEventValue(str, a.Y, "u64_playtime", String.valueOf(l1));
        i1 = TXCStatus.c(this.x, 7112);
        TXCDRApi.txSetEventValue(str, a.Y, "u32_link_type", String.valueOf(i1));
        i1 = TXCStatus.c(this.x, 7111);
        TXCDRApi.txSetEventValue(str, a.Y, "u32_channel_type", String.valueOf(i1));
        TXCDRApi.nativeReportEvent(str, a.Y);
        AppMethodBeat.o(67703);
        return;
        TXCDRApi.txSetEventIntValue(str, a.Y, "u32_video_block_count", 0L);
        break;
      }
    }
  }
  
  public void a()
  {
    AppMethodBeat.i(67682);
    r();
    this.l = -1L;
    this.q = System.currentTimeMillis();
    AppMethodBeat.o(67682);
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
    AppMethodBeat.i(67685);
    this.c = paramString;
    b(paramString);
    AppMethodBeat.o(67685);
  }
  
  public void a(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  public void b()
  {
    AppMethodBeat.i(67683);
    if (this.m)
    {
      p();
      AppMethodBeat.o(67683);
      return;
    }
    TXCLog.e(a, "push " + this.c + " failed!");
    n();
    AppMethodBeat.o(67683);
  }
  
  public void b(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void b(String paramString)
  {
    if (paramString == null) {
      return;
    }
    this.v = paramString;
  }
  
  public void c()
  {
    AppMethodBeat.i(67684);
    if (this.m) {
      if (this.p) {
        s();
      }
    }
    for (;;)
    {
      if (this.p) {
        m();
      }
      AppMethodBeat.o(67684);
      return;
      k();
      continue;
      TXCLog.e(a, "play " + this.c + " failed");
      if (this.p) {
        b(false);
      } else {
        j();
      }
    }
  }
  
  protected d.a d()
  {
    AppMethodBeat.i(67686);
    try
    {
      Object localObject2 = Uri.parse(this.v);
      if (localObject2 == null)
      {
        localObject1 = d.a.a;
        AppMethodBeat.o(67686);
        return localObject1;
      }
      localObject1 = ((Uri)localObject2).getHost();
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = d.a.a;
        AppMethodBeat.o(67686);
        return localObject1;
      }
      String str = ((Uri)localObject2).getScheme();
      if (str == null)
      {
        localObject1 = d.a.a;
        AppMethodBeat.o(67686);
        return localObject1;
      }
      if ((!str.equals("rtmp")) && (!str.equals("http")) && (!str.equals("https")))
      {
        localObject1 = d.a.a;
        AppMethodBeat.o(67686);
        return localObject1;
      }
      if (c((String)localObject1))
      {
        localObject1 = d.a.b;
        AppMethodBeat.o(67686);
        return localObject1;
      }
      localObject2 = ((Uri)localObject2).getQueryParameterNames();
      if ((localObject2 != null) && ((((Set)localObject2).contains("bizid")) || (((Set)localObject2).contains("txTime")) || (((Set)localObject2).contains("txSecret"))))
      {
        localObject1 = d.a.b;
        AppMethodBeat.o(67686);
        return localObject1;
      }
      if (w.containsKey(localObject1))
      {
        localObject1 = (d.a)w.get(localObject1);
        AppMethodBeat.o(67686);
        return localObject1;
      }
      w.put(localObject1, d.a.a);
      new Thread(new d.1(this, (String)localObject1)).start();
    }
    catch (Exception localException)
    {
      Object localObject1;
      label252:
      break label252;
    }
    localObject1 = d.a.a;
    AppMethodBeat.o(67686);
    return localObject1;
  }
  
  public void d(String paramString)
  {
    this.x = paramString;
  }
  
  public void e()
  {
    AppMethodBeat.i(67688);
    if ((!this.m) && (!TextUtils.isEmpty(TXCStatus.b(this.x, 7012))))
    {
      o();
      this.m = true;
    }
    if (this.n <= 0L) {
      this.n = TXCTimeUtil.getTimeTick();
    }
    if ((this.m) && (TXCTimeUtil.getTimeTick() - this.n > 5000L))
    {
      q();
      this.n = TXCTimeUtil.getTimeTick();
    }
    AppMethodBeat.o(67688);
  }
  
  public void f()
  {
    AppMethodBeat.i(67689);
    if (!this.m)
    {
      long l1 = TXCStatus.a(this.x, 6001);
      long l2 = TXCStatus.a(this.x, 7104);
      if ((l1 != 0L) || (l2 != 0L))
      {
        if (!this.p) {
          break label180;
        }
        b(true);
        this.o = 5000;
        this.m = true;
      }
      String str = TXCStatus.b(this.x, 7119);
      if (str != null) {
        b(str);
      }
    }
    if (this.n <= 0L) {
      this.n = TXCTimeUtil.getTimeTick();
    }
    if ((this.m) && (TXCTimeUtil.getTimeTick() > this.n + this.o))
    {
      if (!this.p) {
        break label187;
      }
      t();
      this.o = 5000;
    }
    for (;;)
    {
      this.l = TXCStatus.a(this.x, 6004);
      this.n = TXCTimeUtil.getTimeTick();
      AppMethodBeat.o(67689);
      return;
      label180:
      i();
      break;
      label187:
      if (d() == d.a.c)
      {
        AppMethodBeat.o(67689);
        return;
      }
      l();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.d
 * JD-Core Version:    0.7.0.1
 */