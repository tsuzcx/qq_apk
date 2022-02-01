package com.tencent.liteav;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.datareport.TXCDRExtInfo;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.f;
import com.tencent.liteav.network.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class e
{
  private static HashMap<String, a> A;
  private static String a;
  private String B;
  private String C;
  private HashMap b;
  private String c;
  private int d;
  private int e;
  private int f;
  private int g;
  private Context h;
  private String i;
  private long j;
  private long k;
  private long l;
  private long m;
  private boolean n;
  private long o;
  private int p;
  private long q;
  private long r;
  private boolean s;
  private long t;
  private long u;
  private long v;
  private long w;
  private long x;
  private int y;
  private String z;
  
  static
  {
    AppMethodBeat.i(222371);
    a = "TXCDataReport";
    A = new HashMap();
    AppMethodBeat.o(222371);
  }
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(16559);
    this.s = false;
    this.t = 0L;
    this.u = 0L;
    this.v = 0L;
    this.w = 0L;
    this.x = 0L;
    this.y = 0;
    this.B = "";
    this.C = "";
    this.b = new HashMap(100);
    this.h = paramContext.getApplicationContext();
    this.i = TXCCommonUtil.getAppVersion();
    this.p = 5000;
    this.x = 0L;
    AppMethodBeat.o(16559);
  }
  
  private void a(int paramInt, String paramString)
  {
    AppMethodBeat.i(16597);
    String str2 = TXCStatus.b(this.B, 7121);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = paramString;
    }
    this.b.put("str_session_id", str1);
    this.b.put("u32_server_ip", TXCStatus.b(this.B, 7110));
    if (this.s)
    {
      this.b.put("str_stream_url", TXCStatus.b(this.B, 7116));
      f((String)this.b.get("str_stream_url"));
    }
    for (;;)
    {
      TXCDRApi.txSetEventValue(paramString, paramInt, "str_user_id", (String)this.b.get("str_user_id"));
      TXCDRApi.txSetEventValue(paramString, paramInt, "dev_uuid", (String)this.b.get("dev_uuid"));
      TXCDRApi.txSetEventValue(paramString, paramInt, "str_session_id", (String)this.b.get("str_session_id"));
      TXCDRApi.txSetEventValue(paramString, paramInt, "str_device_type", (String)this.b.get("str_device_type"));
      TXCDRApi.txSetEventValue(paramString, paramInt, "str_os_info", (String)this.b.get("str_os_info"));
      TXCDRApi.txSetEventValue(paramString, paramInt, "str_package_name", (String)this.b.get("str_package_name"));
      TXCDRApi.txSetEventIntValue(paramString, paramInt, "u32_network_type", g("u32_network_type"));
      TXCDRApi.txSetEventValue(paramString, paramInt, "u32_server_ip", (String)this.b.get("u32_server_ip"));
      TXCDRApi.txSetEventValue(paramString, paramInt, "str_stream_url", (String)this.b.get("str_stream_url"));
      AppMethodBeat.o(16597);
      return;
      this.b.put("str_stream_url", this.c);
    }
  }
  
  private void c(int paramInt)
  {
    AppMethodBeat.i(16573);
    TXCDRExtInfo localTXCDRExtInfo = new TXCDRExtInfo();
    localTXCDRExtInfo.url = this.c;
    localTXCDRExtInfo.report_common = false;
    localTXCDRExtInfo.report_status = false;
    String str = (String)this.b.get("token");
    TXCDRApi.InitEvent(this.h, str, paramInt, com.tencent.liteav.basic.datareport.a.am, localTXCDRExtInfo);
    a(paramInt, str);
    TXCDRApi.txSetEventIntValue(str, paramInt, "u64_timestamp", ((Long)this.b.get("u64_timestamp")).longValue());
    long l7 = TXCStatus.a(this.B, 7107);
    long l2 = TXCStatus.a(this.B, 7108);
    long l1 = l2;
    if (l2 != -1L) {
      l1 = l2 - l7;
    }
    label205:
    int i1;
    label267:
    long l4;
    label304:
    long l5;
    label341:
    long l6;
    if (l1 < 0L)
    {
      l2 = -1L;
      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_dns_time", l2);
      l3 = TXCStatus.a(this.B, 7109);
      l2 = l3;
      if (l3 != -1L) {
        l2 = l3 - l7;
      }
      if (l2 >= 0L) {
        break label909;
      }
      l3 = -1L;
      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_connect_server_time", l3);
      i1 = TXCStatus.c(this.B, 5004);
      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_video_decode_type", i1);
      this.j = (TXCStatus.a(this.B, 6001) - l7);
      if (this.j >= 0L) {
        break label916;
      }
      l3 = -1L;
      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_first_i_frame", l3);
      l4 = TXCStatus.a(this.B, 7103) - l7;
      if (l4 >= 0L) {
        break label925;
      }
      l3 = -1L;
      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_first_frame_down", l3);
      l5 = TXCStatus.a(this.B, 5005) - l7;
      if (l5 >= 0L) {
        break label932;
      }
      l3 = -1L;
      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_first_video_decode_time", l3);
      l6 = TXCStatus.a(this.B, 7104) - l7;
      if (l6 >= 0L) {
        break label939;
      }
      l3 = -1L;
      label378:
      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_first_audio_frame_down", l3);
      l7 = TXCStatus.a(this.B, 2033) - l7;
      if (l7 >= 0L) {
        break label946;
      }
    }
    label909:
    label916:
    label925:
    label932:
    label939:
    label946:
    for (long l3 = -1L;; l3 = l7)
    {
      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_first_audio_render_time", l3);
      int i2 = TXCStatus.c(this.B, 7105);
      TXCDRApi.txSetEventIntValue(str, paramInt, "u64_err_code", i2);
      int i3 = TXCStatus.c(this.B, 7106);
      TXCDRApi.txSetEventIntValue(str, paramInt, "str_err_info", i3);
      int i4 = TXCStatus.c(this.B, 7112);
      TXCDRApi.txSetEventValue(str, paramInt, "u32_link_type", String.valueOf(i4));
      int i5 = TXCStatus.c(this.B, 7111);
      TXCDRApi.txSetEventValue(str, paramInt, "u32_channel_type", String.valueOf(i5));
      TXCDRApi.txSetEventValue(str, paramInt, "str_app_version", this.i);
      TXCDRApi.nativeReportEvent(str, paramInt);
      TXCLog.d(a, "report evt " + paramInt + ": token=" + str + "\nstr_user_id=" + this.b.get("str_user_id") + "\ndev_uuid=" + this.b.get("dev_uuid") + "\nstr_session_id=" + this.b.get("str_session_id") + "\nstr_device_type=" + this.b.get("str_device_type") + "\nstr_os_info=" + this.b.get("str_os_info") + "\nstr_package_name=" + this.b.get("str_package_name") + "\nu32_network_type=" + this.b.get("u32_network_type") + "\nu32_server_ip=" + this.b.get("u32_server_ip") + "\nstr_stream_url=" + this.b.get("str_stream_url") + "\nu64_timestamp=" + this.b.get("u64_timestamp") + "\nu32_dns_time=" + l1 + "\nu32_connect_server_time=" + l2 + "\nu32_video_decode_type=" + i1 + "\nu32_first_frame_down=" + l4 + "\nu32_first_video_decode_time=" + l5 + "\nu32_first_i_frame=" + this.j + "\nu32_first_audio_frame_down=" + l6 + "\nu32_first_audio_render_time=" + l7 + "\nu64_err_code=" + i2 + "\nstr_err_info=" + i3 + "\nu32_link_type=" + i4 + "\nu32_channel_type=" + i5 + "\nstr_app_version=" + this.i);
      AppMethodBeat.o(16573);
      return;
      l2 = l1;
      break;
      l3 = l2;
      break label205;
      l3 = this.j;
      break label267;
      l3 = l4;
      break label304;
      l3 = l5;
      break label341;
      l3 = l6;
      break label378;
    }
  }
  
  protected static boolean c(String paramString)
  {
    AppMethodBeat.i(222363);
    if ((paramString != null) && (paramString.contains("myqcloud")))
    {
      AppMethodBeat.o(222363);
      return true;
    }
    boolean bool = com.tencent.liteav.basic.d.c.a().a(paramString);
    AppMethodBeat.o(222363);
    return bool;
  }
  
  private void d(int paramInt)
  {
    AppMethodBeat.i(222368);
    Object localObject = new TXCDRExtInfo();
    ((TXCDRExtInfo)localObject).url = this.c;
    ((TXCDRExtInfo)localObject).report_common = false;
    ((TXCDRExtInfo)localObject).report_status = false;
    String str = (String)this.b.get("token");
    TXCDRApi.InitEvent(this.h, str, paramInt, com.tencent.liteav.basic.datareport.a.am, (TXCDRExtInfo)localObject);
    a(paramInt, str);
    long l1 = TXCTimeUtil.getUtcTimeTick();
    TXCDRApi.txSetEventIntValue(str, paramInt, "u64_end_timestamp", l1);
    TXCDRApi.txSetEventIntValue(str, paramInt, "u64_timestamp", l1);
    double d1 = TXCStatus.d(this.B, 9002);
    TXCDRApi.txSetEventValue(str, paramInt, "u32_avg_cpu_usage", String.valueOf(d1));
    double d2 = TXCStatus.d(this.B, 9005);
    TXCDRApi.txSetEventValue(str, paramInt, "u32_avg_memory", String.valueOf(d2));
    localObject = String.valueOf(this.x);
    TXCDRApi.txSetEventValue(str, paramInt, "u64_begin_timestamp", (String)localObject);
    l1 = TXCStatus.a(this.B, 7107);
    l1 = (TXCTimeUtil.getTimeTick() - l1) / 1000L;
    if (l1 < 0L)
    {
      l2 = -1L;
      TXCDRApi.txSetEventIntValue(str, paramInt, "u64_playtime", l2);
      if (l1 >= 0L) {
        break label1380;
      }
    }
    label1380:
    for (long l2 = -1L;; l2 = l1)
    {
      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_result", l2);
      int i1 = TXCStatus.c(this.B, 7105);
      TXCDRApi.txSetEventIntValue(str, paramInt, "u64_err_code", i1);
      int i2 = TXCStatus.c(this.B, 2004);
      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_speed_cnt", i2);
      int i3 = TXCStatus.c(this.B, 2008);
      TXCDRApi.txSetEventIntValue(str, paramInt, "u64_audio_cache_avg", i3);
      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_avg_cache_time", i3);
      long l3 = TXCStatus.c(this.B, 2003);
      TXCDRApi.txSetEventValue(str, paramInt, "u32_max_load", String.valueOf(l3));
      long l4 = TXCStatus.c(this.B, 2001);
      TXCDRApi.txSetEventValue(str, paramInt, "u32_avg_load", String.valueOf(l4));
      long l5 = TXCStatus.c(this.B, 2002);
      TXCDRApi.txSetEventValue(str, paramInt, "u32_load_cnt", String.valueOf(l5));
      int i4 = TXCStatus.c(this.B, 2005);
      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_nodata_cnt", i4);
      long l6 = l4 * l5;
      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_audio_block_time", l6);
      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_first_i_frame", this.j);
      int i5 = TXCStatus.c(this.B, 6015);
      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_video_width", i5);
      int i6 = TXCStatus.c(this.B, 6016);
      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_video_height", i6);
      double d3 = TXCStatus.d(this.B, 6017);
      TXCDRApi.txSetEventValue(str, paramInt, "u32_video_avg_fps", String.valueOf(d3));
      long l7 = TXCStatus.a(this.B, 6003);
      long l9 = TXCStatus.a(this.B, 6005);
      long l8 = TXCStatus.a(this.B, 6006);
      l2 = 0L;
      if (l7 > 0L) {
        l2 = l8 / l7;
      }
      TXCDRApi.txSetEventIntValue(str, paramInt, "u64_block_duration_avg", l2);
      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_avg_block_time", l2);
      TXCDRApi.txSetEventIntValue(str, paramInt, "u64_block_count", l7);
      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_video_block_time", l8);
      TXCDRApi.txSetEventIntValue(str, paramInt, "u64_block_duration_max", l9);
      l9 = TXCStatus.a(this.B, 6009);
      TXCDRApi.txSetEventIntValue(str, paramInt, "u64_jitter_cache_max", l9);
      long l10 = TXCStatus.a(this.B, 6008);
      TXCDRApi.txSetEventIntValue(str, paramInt, "u64_jitter_cache_avg", l10);
      TXCDRApi.txSetEventValue(str, paramInt, "u32_link_type", String.valueOf(TXCStatus.c(this.B, 7112)));
      int i7 = TXCStatus.c(this.B, 7111);
      TXCDRApi.txSetEventValue(str, paramInt, "u32_channel_type", String.valueOf(i7));
      int i8 = TXCStatus.c(this.B, 7113);
      TXCDRApi.txSetEventValue(str, paramInt, "u32_ip_count_quic", String.valueOf(i8));
      int i9 = TXCStatus.c(this.B, 7114);
      TXCDRApi.txSetEventValue(str, paramInt, "u32_connect_count_quic", String.valueOf(i9));
      int i10 = TXCStatus.c(this.B, 7115);
      TXCDRApi.txSetEventValue(str, paramInt, "u32_connect_count_tcp", String.valueOf(i10));
      TXCDRApi.txSetEventValue(str, paramInt, "str_app_version", this.i);
      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_is_real_time", TXCStatus.a(this.B, 2009));
      TXCDRApi.nativeReportEvent(str, paramInt);
      TXCLog.d(a, "report evt " + paramInt + ": token=" + str + "\nstr_user_id=" + this.b.get("str_user_id") + "\ndev_uuid=" + this.b.get("dev_uuid") + "\nstr_session_id=" + this.b.get("str_session_id") + "\nstr_device_type=" + this.b.get("str_device_type") + "\nstr_os_info=" + this.b.get("str_os_info") + "\nstr_package_name=" + this.b.get("str_package_name") + "\nu32_network_type=" + this.b.get("u32_network_type") + "\nu32_server_ip=" + this.b.get("u32_server_ip") + "\nstr_stream_url=" + this.b.get("str_stream_url") + "\nu64_timestamp=" + this.b.get("u64_timestamp") + "\nu32_avg_cpu_usage=" + d1 + "\nu32_avg_memory=" + d2 + "\nu32_first_i_frame=" + this.j + "\nu32_video_width=" + i5 + "\nu32_video_height=" + i6 + "\nu32_video_avg_fps=" + d3 + "\nu32_speed_cnt=" + i2 + "\nu32_nodata_cnt=" + i4 + "\nu32_avg_cache_time=" + i3 + "\nu32_avg_block_time=" + l2 + "\nu32_avg_load=" + l4 + "\nu32_max_load=" + l3 + "\nu32_video_block_time=" + l8 + "\nu32_audio_block_time=" + l6 + "\nu32_load_cnt=" + l5 + "\nu32_result=" + l1 + "\nu64_err_code=" + i1 + "\nu32_channel_type=" + i7 + "\nu32_ip_count_quic=" + i8 + "\nu32_connect_count_quic=" + i9 + "\nu32_connect_count_tcp=" + i10 + "\nu64_block_count=" + l7 + "\nu64_jitter_cache_max=" + l9 + "\nu64_jitter_cache_avg=" + l10 + "\nu64_begin_timestamp=" + (String)localObject + "\nu32_is_real_time=" + TXCStatus.a(this.B, 2009) + "\nstr_app_version=" + this.i);
      AppMethodBeat.o(222368);
      return;
      l2 = l1;
      break;
    }
  }
  
  private void e(int paramInt)
  {
    int i1 = 2;
    AppMethodBeat.i(222369);
    Object localObject = new TXCDRExtInfo();
    ((TXCDRExtInfo)localObject).url = this.c;
    ((TXCDRExtInfo)localObject).report_common = false;
    ((TXCDRExtInfo)localObject).report_status = true;
    String str = (String)this.b.get("token");
    TXCDRApi.InitEvent(this.h, str, paramInt, com.tencent.liteav.basic.datareport.a.am, (TXCDRExtInfo)localObject);
    a(paramInt, str);
    TXCDRApi.txSetEventIntValue(str, paramInt, "u64_timestamp", TXCTimeUtil.getUtcTimeTick());
    localObject = f.a();
    TXCDRApi.txSetEventIntValue(str, paramInt, "u32_cpu_usage", localObject[1]);
    TXCDRApi.txSetEventIntValue(str, paramInt, "u32_app_cpu_usage", localObject[0]);
    TXCDRApi.txSetEventValue(str, paramInt, "u32_avg_cpu_usage", String.valueOf(TXCStatus.d(this.B, 9002)));
    TXCDRApi.txSetEventValue(str, paramInt, "u32_avg_memory", String.valueOf(TXCStatus.d(this.B, 9005)));
    TXCDRApi.txSetEventIntValue(str, paramInt, "u32_recv_av_diff_time", TXCStatus.a(this.B, 6014, 2));
    TXCDRApi.txSetEventIntValue(str, paramInt, "u32_play_av_diff_time", TXCStatus.a(this.B, 6013, 2));
    TXCDRApi.txSetEventValue(str, paramInt, "u64_playtime", String.valueOf((TXCTimeUtil.getUtcTimeTick() - this.x) / 1000L));
    if (TXCStatus.c(this.B, 2015) == 0) {}
    for (;;)
    {
      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_audio_decode_type", i1);
      long l1 = TXCStatus.a(this.B, 2002);
      long l2;
      if (this.m == -1L)
      {
        TXCDRApi.txSetEventIntValue(str, paramInt, "u32_audio_block_count", 0L);
        this.m = l1;
        TXCDRApi.txSetEventIntValue(str, paramInt, "u32_audio_cache_time", TXCStatus.c(this.B, 2010));
        TXCDRApi.txSetEventIntValue(str, paramInt, "u32_audio_drop", TXCStatus.c(this.B, 2014));
        TXCDRApi.txSetEventIntValue(str, paramInt, "u32_video_decode_type", TXCStatus.c(this.B, 5004));
        TXCDRApi.txSetEventIntValue(str, paramInt, "u32_video_recv_fps", j());
        TXCDRApi.txSetEventIntValue(str, paramInt, "u32_fps", (int)TXCStatus.d(this.B, 6002));
        TXCDRApi.txSetEventIntValue(str, paramInt, "u32_video_cache_time", TXCStatus.c(this.B, 6007));
        l1 = TXCStatus.a(this.B, 6008);
        TXCDRApi.txSetEventIntValue(str, paramInt, "u32_video_cache_count", l1);
        TXCDRApi.txSetEventIntValue(str, paramInt, "u32_avg_cache_count", l1);
        l2 = TXCStatus.a(this.B, 6004);
        if ((this.k == -1L) || (l2 < this.k)) {
          break label725;
        }
        TXCDRApi.txSetEventIntValue(str, paramInt, "u32_video_block_count", l2 - this.k);
        label481:
        this.k = l2;
        i1 = TXCStatus.c(this.B, 7102) + TXCStatus.c(this.B, 7101);
        TXCDRApi.txSetEventIntValue(str, paramInt, "u32_net_speed", i1);
        TXCDRApi.txSetEventIntValue(str, paramInt, "u32_avg_net_speed", i1);
        TXCDRApi.txSetEventValue(str, paramInt, "u32_link_type", String.valueOf(TXCStatus.c(this.B, 7112)));
        TXCDRApi.txSetEventValue(str, paramInt, "u32_channel_type", String.valueOf(TXCStatus.c(this.B, 7111)));
        TXCDRApi.txSetEventValue(str, paramInt, "str_app_version", this.i);
        l2 = TXCStatus.a(this.B, 6021);
        if (l2 <= this.l) {
          break label738;
        }
        TXCDRApi.txSetEventIntValue(str, paramInt, "u32_video_light_block_count", l2 - this.l);
      }
      for (;;)
      {
        this.l = l2;
        TXCDRApi.nativeReportEvent(str, paramInt);
        if (this.s)
        {
          this.w += 1L;
          this.v += l1;
          if (l1 > this.u) {
            this.u = l1;
          }
        }
        AppMethodBeat.o(222369);
        return;
        if (l1 >= this.m)
        {
          TXCDRApi.txSetEventIntValue(str, paramInt, "u32_audio_block_count", l1 - this.m);
          break;
        }
        TXCDRApi.txSetEventIntValue(str, paramInt, "u32_audio_block_count", -1L);
        break;
        label725:
        TXCDRApi.txSetEventIntValue(str, paramInt, "u32_video_block_count", 0L);
        break label481;
        label738:
        TXCDRApi.txSetEventIntValue(str, paramInt, "u32_video_light_block_count", 0L);
      }
      i1 = 1;
    }
  }
  
  private void f(String paramString)
  {
    AppMethodBeat.i(222366);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("room://")))
    {
      paramString = paramString.split("/");
      paramString[(paramString.length - 1)].split("_");
      TXCStatus.a(this.B, 7112, Long.valueOf(3L));
    }
    AppMethodBeat.o(222366);
  }
  
  private int g(String paramString)
  {
    AppMethodBeat.i(222370);
    paramString = (Number)this.b.get(paramString);
    if (paramString != null)
    {
      int i1 = paramString.intValue();
      AppMethodBeat.o(222370);
      return i1;
    }
    AppMethodBeat.o(222370);
    return 0;
  }
  
  private void i()
  {
    AppMethodBeat.i(16580);
    a(6002, 6017, 6018);
    int[] arrayOfInt = f.a();
    TXCStatus.a(this.B, 9001, Integer.valueOf(arrayOfInt[0]));
    a(9001, 9002, 9003);
    TXCStatus.a(this.B, 9004, Integer.valueOf(f.b()));
    a(9004, 9005, 9006);
    AppMethodBeat.o(16580);
  }
  
  private int j()
  {
    AppMethodBeat.i(222367);
    int i2 = 0;
    long l1 = TXCTimeUtil.getTimeTick();
    long l2 = TXCStatus.c(this.B, 6019);
    int i1 = i2;
    if (l2 != 0L)
    {
      i1 = i2;
      if (l1 != 0L)
      {
        long l3 = this.q;
        i1 = (int)((l2 - this.r) * 1000L / (l1 - l3));
      }
    }
    this.q = l1;
    this.r = l2;
    AppMethodBeat.o(222367);
    return i1;
  }
  
  private void k()
  {
    AppMethodBeat.i(182276);
    Object localObject1 = new HashMap();
    String str1 = TXCStatus.b(this.B, 7116);
    Object localObject2 = TXCStatus.b(this.B, 7117);
    Object localObject3 = TXCStatus.b(this.B, 7118);
    int i1 = TXCStatus.c(this.B, 7105);
    String str2 = TXCStatus.b(this.B, 7106);
    int i2 = TXCStatus.c(this.B, 7111);
    ((Map)localObject1).put("stream_url", str1);
    ((Map)localObject1).put("stream_id", localObject2);
    ((Map)localObject1).put("bizid", localObject3);
    ((Map)localObject1).put("err_code", String.valueOf(i1));
    ((Map)localObject1).put("err_info", str2);
    ((Map)localObject1).put("channel_type", String.valueOf(i2));
    long l1 = System.currentTimeMillis();
    long l2 = this.t;
    ((Map)localObject1).put("start_time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date(this.t)));
    ((Map)localObject1).put("end_time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date(l1)));
    ((Map)localObject1).put("total_time", String.valueOf(l1 - l2));
    l2 = TXCStatus.a(this.B, 6003);
    l1 = TXCStatus.a(this.B, 6006);
    long l3 = TXCStatus.a(this.B, 6005);
    if (l2 != 0L) {}
    for (l1 /= l2;; l1 = 0L)
    {
      ((Map)localObject1).put("block_count", String.valueOf(l2));
      ((Map)localObject1).put("block_duration_max", String.valueOf(l3));
      ((Map)localObject1).put("block_duration_avg", String.valueOf(l1));
      if (this.w != 0L) {}
      for (l1 = this.v / this.w;; l1 = 0L)
      {
        ((Map)localObject1).put("jitter_cache_max", String.valueOf(this.u));
        ((Map)localObject1).put("jitter_cache_avg", String.valueOf(l1));
        str1 = TXCDRApi.txCreateToken();
        i1 = com.tencent.liteav.basic.datareport.a.af;
        i2 = com.tencent.liteav.basic.datareport.a.al;
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
        this.s = false;
        this.t = 0L;
        this.w = 0L;
        this.v = 0L;
        this.u = 0L;
        AppMethodBeat.o(182276);
        return;
      }
    }
  }
  
  private void l()
  {
    AppMethodBeat.i(16584);
    TXCDRExtInfo localTXCDRExtInfo = new TXCDRExtInfo();
    localTXCDRExtInfo.report_common = false;
    localTXCDRExtInfo.report_status = false;
    localTXCDRExtInfo.url = this.c;
    long l1 = TXCStatus.a(this.B, 7013);
    String str = (String)this.b.get("token");
    TXCDRApi.InitEvent(this.h, str, com.tencent.liteav.basic.datareport.a.P, com.tencent.liteav.basic.datareport.a.al, localTXCDRExtInfo);
    long l2 = TXCTimeUtil.getUtcTimeTick();
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.P, "u64_timestamp", TXCTimeUtil.getUtcTimeTick());
    TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.P, "str_device_type", (String)this.b.get("str_device_type"));
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.P, "u32_network_type", g("u32_network_type"));
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
    TXCLog.d(a, "report evt 40001: token=" + str + " str_stream_url=" + this.c + " u64_timestamp=" + l2 + " str_device_type=" + this.b.get("str_device_type") + " u32_network_type=" + g("u32_network_type") + " u32_dns_time=-1 u32_connect_server_time=-1 u32_server_ip= u32_video_resolution" + "=" + (this.d << 16 | this.e) + " u32_audio_samplerate=" + this.g + " u32_video_bitrate=" + this.f + " str_user_id=" + this.b.get("str_user_id") + " str_package_name=" + this.b.get("str_package_name") + " u32_channel_type=" + l1 + " str_app_version=" + this.b.get("dev_uuid") + " dev_uuid=" + g("u32_max_load"));
    AppMethodBeat.o(16584);
  }
  
  private void m()
  {
    AppMethodBeat.i(16585);
    Object localObject = new TXCDRExtInfo();
    ((TXCDRExtInfo)localObject).report_common = false;
    ((TXCDRExtInfo)localObject).report_status = false;
    ((TXCDRExtInfo)localObject).url = this.c;
    String str1 = TXCStatus.b(this.B, 7012);
    long l3 = TXCStatus.a(this.B, 7009);
    long l1 = TXCStatus.a(this.B, 7010);
    if (l1 != -1L) {
      l1 -= l3;
    }
    for (;;)
    {
      long l2 = TXCStatus.a(this.B, 7011);
      if (l2 != -1L) {
        l2 -= l3;
      }
      for (;;)
      {
        l3 = TXCStatus.a(this.B, 7013);
        String str2 = (String)this.b.get("token");
        TXCDRApi.InitEvent(this.h, str2, com.tencent.liteav.basic.datareport.a.P, com.tencent.liteav.basic.datareport.a.al, (TXCDRExtInfo)localObject);
        long l4 = TXCTimeUtil.getUtcTimeTick();
        TXCDRApi.txSetEventIntValue(str2, com.tencent.liteav.basic.datareport.a.P, "u64_timestamp", l4);
        TXCDRApi.txSetEventValue(str2, com.tencent.liteav.basic.datareport.a.P, "str_device_type", (String)this.b.get("str_device_type"));
        TXCDRApi.txSetEventIntValue(str2, com.tencent.liteav.basic.datareport.a.P, "u32_network_type", g("u32_network_type"));
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
        localObject = TXCStatus.b(this.B, 7019);
        TXCDRApi.txSetEventValue(str2, com.tencent.liteav.basic.datareport.a.P, "str_nearest_ip_list", (String)localObject);
        TXCDRApi.nativeReportEvent(str2, com.tencent.liteav.basic.datareport.a.P);
        TXCLog.d(a, "report evt 40001: token=" + str2 + " str_stream_url=" + this.c + " u64_timestamp=" + l4 + " str_device_type=" + this.b.get("str_device_type") + " u32_network_type=" + g("u32_network_type") + " u32_dns_time=" + l1 + " u32_connect_server_time=" + l2 + " u32_server_ip=" + str1 + " u32_video_resolution=" + (this.d << 16 | this.e) + " u32_audio_samplerate=" + this.g + " u32_video_bitrate=" + this.f + " str_user_id=" + this.b.get("str_user_id") + " str_package_name=" + this.b.get("str_package_name") + " u32_channel_type=" + l3 + " str_app_version=" + this.b.get("dev_uuid") + " dev_uuid=" + g("u32_max_load"));
        AppMethodBeat.o(16585);
        return;
      }
    }
  }
  
  private void n()
  {
    AppMethodBeat.i(16586);
    TXCDRExtInfo localTXCDRExtInfo = new TXCDRExtInfo();
    localTXCDRExtInfo.report_common = false;
    localTXCDRExtInfo.report_status = false;
    localTXCDRExtInfo.url = this.c;
    long l3 = TXCStatus.a(this.B, 7009);
    long l1 = TXCStatus.a(this.B, 7013);
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
    int i1 = TXCStatus.c(this.B, 7016);
    TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.R, "u32_ip_count_quic", String.valueOf(i1));
    i1 = TXCStatus.c(this.B, 7017);
    TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.R, "u32_connect_count_quic", String.valueOf(i1));
    i1 = TXCStatus.c(this.B, 7018);
    TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.R, "u32_connect_count_tcp", String.valueOf(i1));
    TXCDRApi.nativeReportEvent(str, com.tencent.liteav.basic.datareport.a.R);
    TXCLog.d(a, "report evt 40002: token=" + str + " str_stream_url=" + this.c + " u64_timestamp=" + l2 + " u32_result=" + l3 + " str_user_id=" + this.b.get("str_user_id") + " str_package_name=" + this.b.get("str_package_name") + " u32_channel_type=" + l1 + " str_app_version=" + this.i + " dev_uuid=" + this.b.get("dev_uuid"));
    AppMethodBeat.o(16586);
  }
  
  private void o()
  {
    AppMethodBeat.i(16588);
    TXCDRExtInfo localTXCDRExtInfo = new TXCDRExtInfo();
    localTXCDRExtInfo.report_common = false;
    localTXCDRExtInfo.report_status = true;
    localTXCDRExtInfo.url = this.c;
    Object localObject = f.a();
    int i1 = localObject[0];
    int i2 = localObject[1];
    int i3 = f.b();
    long l1 = TXCStatus.a(this.B, 7013);
    int i4 = TXCStatus.c(this.B, 7004);
    int i5 = TXCStatus.c(this.B, 7003);
    double d1 = TXCStatus.d(this.B, 4001);
    int i6 = TXCStatus.c(this.B, 7005);
    int i7 = TXCStatus.c(this.B, 7002);
    int i8 = TXCStatus.c(this.B, 7001);
    int i9 = TXCStatus.c(this.B, 4007);
    localObject = TXCStatus.b(this.B, 7012);
    String str1 = TXCStatus.b(this.B, 7014);
    String str2 = TXCStatus.b(this.B, 7015);
    String str3 = TXCStatus.b(this.B, 3001);
    long l2 = TXCStatus.a(this.B, 3002);
    double d2 = TXCStatus.d(this.B, 3003);
    int i10 = TXCStatus.c(this.B, 7020);
    String str4 = (String)this.b.get("token");
    TXCDRApi.InitEvent(this.h, str4, com.tencent.liteav.basic.datareport.a.Q, com.tencent.liteav.basic.datareport.a.al, localTXCDRExtInfo);
    TXCDRApi.txSetEventIntValue(str4, com.tencent.liteav.basic.datareport.a.Q, "u32_avg_audio_bitrate", i7);
    TXCDRApi.txSetEventIntValue(str4, com.tencent.liteav.basic.datareport.a.Q, "u32_avg_video_bitrate", i8);
    TXCDRApi.txSetEventIntValue(str4, com.tencent.liteav.basic.datareport.a.Q, "u32_avg_net_speed", i4 + i5);
    TXCDRApi.txSetEventIntValue(str4, com.tencent.liteav.basic.datareport.a.Q, "u32_fps", (int)d1);
    TXCDRApi.txSetEventIntValue(str4, com.tencent.liteav.basic.datareport.a.Q, "u32_avg_cache_size", i6);
    TXCDRApi.txSetEventIntValue(str4, com.tencent.liteav.basic.datareport.a.Q, "u32_cpu_usage", i2);
    TXCDRApi.txSetEventIntValue(str4, com.tencent.liteav.basic.datareport.a.Q, "u32_app_cpu_usage", i1);
    TXCDRApi.txSetEventIntValue(str4, com.tencent.liteav.basic.datareport.a.Q, "u32_avg_memory", i3);
    TXCDRApi.txSetEventIntValue(str4, com.tencent.liteav.basic.datareport.a.Q, "u32_channel_type", l1);
    TXCDRApi.txSetEventValue(str4, com.tencent.liteav.basic.datareport.a.Q, "str_app_version", this.i);
    TXCDRApi.txSetEventValue(str4, com.tencent.liteav.basic.datareport.a.Q, "str_device_type", (String)this.b.get("str_device_type"));
    TXCDRApi.txSetEventIntValue(str4, com.tencent.liteav.basic.datareport.a.Q, "u32_hw_enc", i9);
    TXCDRApi.txSetEventValue(str4, com.tencent.liteav.basic.datareport.a.Q, "str_server_ip", (String)localObject);
    TXCDRApi.txSetEventValue(str4, com.tencent.liteav.basic.datareport.a.Q, "str_quic_connection_id", str1);
    TXCDRApi.txSetEventValue(str4, com.tencent.liteav.basic.datareport.a.Q, "str_quic_connection_stats", str2);
    TXCDRApi.txSetEventValue(str4, com.tencent.liteav.basic.datareport.a.Q, "str_beauty_stats", str3);
    TXCDRApi.txSetEventIntValue(str4, com.tencent.liteav.basic.datareport.a.Q, "u32_send_strategy", i10);
    TXCDRApi.txSetEventIntValue(str4, com.tencent.liteav.basic.datareport.a.Q, "u32_preprocess_timecost", l2);
    TXCDRApi.txSetEventIntValue(str4, com.tencent.liteav.basic.datareport.a.Q, "u32_preprocess_fps_out", (int)d2);
    TXCDRApi.nativeReportEvent(str4, com.tencent.liteav.basic.datareport.a.Q);
    AppMethodBeat.o(16588);
  }
  
  private void p()
  {
    AppMethodBeat.i(16589);
    this.n = false;
    this.o = 0L;
    this.y = 0;
    Object localObject2 = this.C;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = TXCCommonUtil.getUserId();
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = f.b(this.h);
    }
    this.b.put("str_user_id", localObject2);
    this.b.put("str_device_type", f.c());
    this.b.put("str_device_type", f.c());
    this.b.put("u32_network_type", Integer.valueOf(f.e(this.h)));
    this.b.put("token", f.e());
    this.b.put("str_package_name", f.c(this.h));
    this.b.put("dev_uuid", f.f(this.h));
    this.b.put("str_os_info", f.d());
    this.x = TXCTimeUtil.getUtcTimeTick();
    this.b.put("u64_timestamp", Long.valueOf(this.x));
    AppMethodBeat.o(16589);
  }
  
  public void a()
  {
    AppMethodBeat.i(16567);
    p();
    this.k = -1L;
    this.m = -1L;
    this.l = 0L;
    this.t = System.currentTimeMillis();
    AppMethodBeat.o(16567);
  }
  
  public void a(int paramInt)
  {
    AppMethodBeat.i(16569);
    this.f = paramInt;
    AppMethodBeat.o(16569);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(16562);
    this.d = paramInt1;
    this.e = paramInt2;
    AppMethodBeat.o(16562);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(222365);
    if (paramInt1 == 6002)
    {
      d2 = TXCStatus.d(this.B, paramInt1);
      if (d2 < 0.001D)
      {
        AppMethodBeat.o(222365);
        return;
      }
      d1 = TXCStatus.d(this.B, paramInt2);
      paramInt1 = TXCStatus.c(this.B, paramInt3) + 1;
      d2 = (d2 - d1) / paramInt1;
      TXCStatus.a(this.B, paramInt2, Double.valueOf(d2 + d1));
      TXCStatus.a(this.B, paramInt3, Integer.valueOf(paramInt1));
      AppMethodBeat.o(222365);
      return;
    }
    paramInt1 = TXCStatus.c(this.B, paramInt1);
    if (paramInt1 < 0.001D)
    {
      AppMethodBeat.o(222365);
      return;
    }
    double d1 = TXCStatus.d(this.B, paramInt2);
    int i1 = TXCStatus.c(this.B, paramInt3) + 1;
    double d2 = (paramInt1 - d1) / i1;
    TXCStatus.a(this.B, paramInt2, Double.valueOf(d1 + d2));
    TXCStatus.a(this.B, paramInt3, Integer.valueOf(i1));
    AppMethodBeat.o(222365);
  }
  
  public void a(String paramString)
  {
    AppMethodBeat.i(222361);
    this.c = paramString;
    b(paramString);
    AppMethodBeat.o(222361);
  }
  
  public void a(boolean paramBoolean)
  {
    this.s = paramBoolean;
  }
  
  public void b()
  {
    AppMethodBeat.i(16568);
    if (this.n)
    {
      n();
      AppMethodBeat.o(16568);
      return;
    }
    TXCLog.e(a, "push " + this.c + " failed!");
    l();
    AppMethodBeat.o(16568);
  }
  
  public void b(int paramInt)
  {
    AppMethodBeat.i(16570);
    this.g = paramInt;
    AppMethodBeat.o(16570);
  }
  
  public void b(String paramString)
  {
    AppMethodBeat.i(16591);
    if (paramString == null)
    {
      AppMethodBeat.o(16591);
      return;
    }
    this.z = paramString;
    AppMethodBeat.o(16591);
  }
  
  public void c()
  {
    AppMethodBeat.i(222360);
    if (this.n) {
      if (this.s)
      {
        e(com.tencent.liteav.basic.datareport.a.Y);
        if (!this.s) {
          break label154;
        }
        d(com.tencent.liteav.basic.datareport.a.Z);
      }
    }
    for (;;)
    {
      if (this.s) {
        k();
      }
      TXCStatus.a(this.B, 7107, Long.valueOf(0L));
      TXCStatus.a(this.B, 2033, Long.valueOf(0L));
      TXCStatus.a(this.B, 6001, Long.valueOf(0L));
      TXCStatus.a(this.B, 7104, Long.valueOf(0L));
      TXCStatus.a(this.B, 7108, Long.valueOf(0L));
      AppMethodBeat.o(222360);
      return;
      if (d() == a.c) {
        break;
      }
      e(com.tencent.liteav.basic.datareport.a.V);
      break;
      label154:
      d(com.tencent.liteav.basic.datareport.a.W);
      continue;
      TXCLog.e(a, "play " + this.c + " failed");
      if (this.s) {
        c(com.tencent.liteav.basic.datareport.a.X);
      } else {
        c(com.tencent.liteav.basic.datareport.a.U);
      }
    }
  }
  
  protected a d()
  {
    AppMethodBeat.i(222362);
    try
    {
      Object localObject2 = Uri.parse(this.z);
      if (localObject2 == null)
      {
        localObject1 = a.a;
        AppMethodBeat.o(222362);
        return localObject1;
      }
      localObject1 = ((Uri)localObject2).getHost();
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = a.a;
        AppMethodBeat.o(222362);
        return localObject1;
      }
      String str = ((Uri)localObject2).getScheme();
      if (str == null)
      {
        localObject1 = a.a;
        AppMethodBeat.o(222362);
        return localObject1;
      }
      if ((!str.equals("rtmp")) && (!str.equals("http")) && (!str.equals("https")))
      {
        localObject1 = a.a;
        AppMethodBeat.o(222362);
        return localObject1;
      }
      if (c((String)localObject1))
      {
        localObject1 = a.b;
        AppMethodBeat.o(222362);
        return localObject1;
      }
      localObject2 = ((Uri)localObject2).getQueryParameterNames();
      if ((localObject2 != null) && ((((Set)localObject2).contains("bizid")) || (((Set)localObject2).contains("txTime")) || (((Set)localObject2).contains("txSecret"))))
      {
        localObject1 = a.b;
        AppMethodBeat.o(222362);
        return localObject1;
      }
      if (A.containsKey(localObject1))
      {
        localObject1 = (a)A.get(localObject1);
        AppMethodBeat.o(222362);
        return localObject1;
      }
      A.put(localObject1, a.a);
      new Thread(new Runnable()
      {
        public void run()
        {
          boolean bool2 = false;
          AppMethodBeat.i(222644);
          try
          {
            Object localObject = com.tencent.liteav.network.a.a.a.c().a(new b(this.a, true), null);
            int j = localObject.length;
            int i = 0;
            boolean bool1 = bool2;
            HashMap localHashMap;
            String str;
            if (i < j)
            {
              localHashMap = localObject[i];
              if ((localHashMap.a()) && (e.c(localHashMap.a))) {
                bool1 = true;
              }
            }
            else
            {
              localHashMap = e.g();
              str = this.a;
              if (!bool1) {
                break label147;
              }
            }
            label147:
            for (localObject = e.a.b;; localObject = e.a.c)
            {
              localHashMap.put(str, localObject);
              TXCLog.d(e.h(), this.a + " isTencent " + bool1);
              AppMethodBeat.o(222644);
              return;
              i += 1;
              break;
            }
            return;
          }
          catch (Exception localException)
          {
            TXCLog.e(e.h(), "check dns failed.", localException);
            AppMethodBeat.o(222644);
          }
        }
      }).start();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1;
        TXCLog.e(a, "check stream failed.", localException);
      }
    }
    localObject1 = a.a;
    AppMethodBeat.o(222362);
    return localObject1;
  }
  
  public void d(String paramString)
  {
    this.B = paramString;
  }
  
  public void e()
  {
    AppMethodBeat.i(222364);
    if ((!this.n) && (!TextUtils.isEmpty(TXCStatus.b(this.B, 7012))))
    {
      m();
      this.n = true;
    }
    if (this.o <= 0L) {
      this.o = TXCTimeUtil.getTimeTick();
    }
    if ((this.n) && (TXCTimeUtil.getTimeTick() - this.o > 5000L))
    {
      o();
      this.o = TXCTimeUtil.getTimeTick();
    }
    AppMethodBeat.o(222364);
  }
  
  public void e(String paramString)
  {
    this.C = paramString;
  }
  
  public void f()
  {
    AppMethodBeat.i(16592);
    i();
    int i1;
    if (!this.n)
    {
      long l1 = TXCStatus.a(this.B, 6001);
      long l2 = TXCStatus.a(this.B, 7104);
      long l3 = TXCStatus.a(this.B, 2033);
      long l4 = TXCStatus.a(this.B, 7108);
      if ((l1 > 0L) && (l2 > 0L) && (l4 > 0L) && (l3 > 0L))
      {
        if (!this.s) {
          break label292;
        }
        i1 = com.tencent.liteav.basic.datareport.a.X;
        c(i1);
        this.p = 5000;
        this.n = true;
      }
      String str = TXCStatus.b(this.B, 7119);
      if (str != null) {
        b(str);
      }
    }
    if ((this.y >= 3) && (!this.n))
    {
      if (this.s)
      {
        i1 = com.tencent.liteav.basic.datareport.a.X;
        label168:
        c(i1);
        this.p = 5000;
        this.n = true;
      }
    }
    else
    {
      this.y += 1;
      if (this.o <= 0L) {
        this.o = TXCTimeUtil.getTimeTick();
      }
      if (TXCTimeUtil.getTimeTick() > this.o + this.p)
      {
        if (!this.s) {
          break label306;
        }
        e(com.tencent.liteav.basic.datareport.a.Y);
        this.p = 5000;
      }
    }
    for (;;)
    {
      this.k = TXCStatus.a(this.B, 6004);
      this.m = TXCStatus.c(this.B, 2002);
      this.o = TXCTimeUtil.getTimeTick();
      AppMethodBeat.o(16592);
      return;
      label292:
      i1 = com.tencent.liteav.basic.datareport.a.U;
      break;
      i1 = com.tencent.liteav.basic.datareport.a.U;
      break label168;
      label306:
      if (d() == a.c)
      {
        AppMethodBeat.o(16592);
        return;
      }
      e(com.tencent.liteav.basic.datareport.a.V);
      this.p = TXCDRApi.getStatusReportInterval();
      if (this.p < 5000) {
        this.p = 5000;
      }
      if (this.p > 300000) {
        this.p = 300000;
      }
    }
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(222387);
      a = new a("PENDING", 0);
      b = new a("CONFIRM", 1);
      c = new a("NEGATIVE", 2);
      d = new a[] { a, b, c };
      AppMethodBeat.o(222387);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.e
 * JD-Core Version:    0.7.0.1
 */