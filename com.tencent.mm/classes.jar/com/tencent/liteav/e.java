package com.tencent.liteav;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.datareport.TXCDRExtInfo;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.util.TXCBuild;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.h;
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
  private static String a;
  private static HashMap<String, e.a> ae;
  private long A;
  private int B;
  private long C;
  private long D;
  private long E;
  private long F;
  private long G;
  private long H;
  private long I;
  private long J;
  private long K;
  private long L;
  private long M;
  private long N;
  private long O;
  private long P;
  private long Q;
  private long R;
  private long S;
  private long T;
  private long U;
  private long V;
  private long W;
  private long X;
  private long Y;
  private long Z;
  private long aa;
  private boolean ab;
  private long ac;
  private String ad;
  private String af;
  private String ag;
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
  private long n;
  private long o;
  private boolean p;
  private long q;
  private int r;
  private long s;
  private long t;
  private boolean u;
  private long v;
  private long w;
  private long x;
  private long y;
  private long z;
  
  static
  {
    AppMethodBeat.i(229484);
    a = "TXCDataReport";
    ae = new HashMap();
    AppMethodBeat.o(229484);
  }
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(16559);
    this.s = 0L;
    this.t = 0L;
    this.u = false;
    this.v = 0L;
    this.w = 0L;
    this.x = 0L;
    this.y = 0L;
    this.z = 0L;
    this.A = 0L;
    this.B = 0;
    this.C = 0L;
    this.D = 0L;
    this.E = 0L;
    this.F = 0L;
    this.G = 0L;
    this.H = 0L;
    this.I = 0L;
    this.J = 0L;
    this.K = 0L;
    this.L = 0L;
    this.M = 0L;
    this.N = 0L;
    this.O = 0L;
    this.P = 0L;
    this.Q = 0L;
    this.R = 0L;
    this.S = 0L;
    this.T = 0L;
    this.U = 0L;
    this.V = 0L;
    this.W = 0L;
    this.X = 0L;
    this.Y = 0L;
    this.Z = 0L;
    this.aa = 0L;
    this.ab = false;
    this.ac = 0L;
    this.af = "";
    this.ag = "";
    this.b = new HashMap(100);
    this.h = paramContext.getApplicationContext();
    this.i = TXCCommonUtil.getAppVersion();
    this.r = 5000;
    this.z = 0L;
    this.D = 0L;
    AppMethodBeat.o(16559);
  }
  
  private void a(int paramInt, String paramString)
  {
    AppMethodBeat.i(16597);
    String str2 = TXCStatus.b(this.af, 7121);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = paramString;
    }
    this.b.put("str_session_id", str1);
    this.b.put("u32_server_ip", TXCStatus.b(this.af, 7110));
    if (this.u)
    {
      this.b.put("str_stream_url", TXCStatus.b(this.af, 7116));
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
      this.b.put("str_stream_url", TXCStatus.b(this.af, 7119));
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
    TXCDRApi.InitEvent(this.h, str, paramInt, com.tencent.liteav.basic.datareport.a.an, localTXCDRExtInfo);
    a(paramInt, str);
    TXCDRApi.txSetEventIntValue(str, paramInt, "u64_timestamp", ((Long)this.b.get("u64_timestamp")).longValue());
    long l6 = TXCStatus.a(this.af, 7107);
    long l2 = TXCStatus.a(this.af, 7108);
    long l1 = l2;
    if (l2 != -1L) {
      l1 = l2 - l6;
    }
    label209:
    int i1;
    label275:
    long l4;
    label313:
    long l5;
    label353:
    long l7;
    label411:
    label451:
    int i2;
    int i3;
    int i4;
    int i5;
    if (l1 < 0L)
    {
      l2 = -1L;
      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_dns_time", l2);
      l3 = TXCStatus.a(this.af, 7109);
      l2 = l3;
      if (l3 != -1L) {
        l2 = l3 - l6;
      }
      if (l2 >= 0L) {
        break label974;
      }
      l3 = -1L;
      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_connect_server_time", l3);
      i1 = TXCStatus.c(this.af, 5004);
      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_video_decode_type", i1);
      this.j = (TXCStatus.a(this.af, 6001) - this.C);
      if (this.j >= 0L) {
        break label981;
      }
      l3 = -1L;
      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_first_i_frame", l3);
      l4 = TXCStatus.a(this.af, 7103) - l6;
      if (l4 >= 0L) {
        break label990;
      }
      l3 = -1L;
      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_first_frame_down", l3);
      l5 = TXCStatus.a(this.af, 5005) - this.C;
      if (l5 >= 0L) {
        break label997;
      }
      l3 = -1L;
      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_first_video_decode_time", l3);
      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_customrender_mode", TXCStatus.c(this.af, 6015));
      l6 = TXCStatus.a(this.af, 7104) - l6;
      if (l6 >= 0L) {
        break label1004;
      }
      l3 = -1L;
      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_first_audio_frame_down", l3);
      l7 = TXCStatus.a(this.af, 2033) - this.C;
      if (l7 >= 0L) {
        break label1011;
      }
      l3 = -1L;
      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_first_audio_render_time", l3);
      i2 = TXCStatus.c(this.af, 7105);
      TXCDRApi.txSetEventIntValue(str, paramInt, "u64_err_code", i2);
      i3 = TXCStatus.c(this.af, 7106);
      TXCDRApi.txSetEventIntValue(str, paramInt, "str_err_info", i3);
      i4 = TXCStatus.c(this.af, 7112);
      TXCDRApi.txSetEventValue(str, paramInt, "u32_link_type", String.valueOf(i4));
      i5 = TXCStatus.c(this.af, 7111);
      TXCDRApi.txSetEventValue(str, paramInt, "u32_channel_type", String.valueOf(i5));
      TXCDRApi.txSetEventValue(str, paramInt, "str_app_version", this.i);
      if (!this.ab) {
        break label1018;
      }
    }
    label974:
    label981:
    label990:
    label997:
    label1004:
    label1011:
    label1018:
    for (long l3 = 1L;; l3 = 0L)
    {
      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_isp2p", l3);
      TXCDRApi.nativeReportEvent(str, paramInt);
      TXCLog.d(a, "report evt " + paramInt + ": token=" + str + "\nstr_user_id=" + this.b.get("str_user_id") + "\ndev_uuid=" + this.b.get("dev_uuid") + "\nstr_session_id=" + this.b.get("str_session_id") + "\nstr_device_type=" + this.b.get("str_device_type") + "\nstr_os_info=" + this.b.get("str_os_info") + "\nstr_package_name=" + this.b.get("str_package_name") + "\nu32_network_type=" + this.b.get("u32_network_type") + "\nu32_server_ip=" + this.b.get("u32_server_ip") + "\nstr_stream_url=" + this.b.get("str_stream_url") + "\nu64_timestamp=" + this.b.get("u64_timestamp") + "\nu32_dns_time=" + l1 + "\nu32_connect_server_time=" + l2 + "\nu32_video_decode_type=" + i1 + "\nu32_first_frame_down=" + l4 + "\nu32_first_video_decode_time=" + l5 + "\nu32_first_i_frame=" + this.j + "\nu32_first_audio_frame_down=" + l6 + "\nu32_first_audio_render_time=" + l7 + "\nu64_err_code=" + i2 + "\nstr_err_info=" + i3 + "\nu32_link_type=" + i4 + "\nu32_channel_type=" + i5 + "\nstr_app_version=" + this.i);
      AppMethodBeat.o(16573);
      return;
      l2 = l1;
      break;
      l3 = l2;
      break label209;
      l3 = this.j;
      break label275;
      l3 = l4;
      break label313;
      l3 = l5;
      break label353;
      l3 = l6;
      break label411;
      l3 = l7;
      break label451;
    }
  }
  
  protected static boolean c(String paramString)
  {
    AppMethodBeat.i(229340);
    if ((paramString != null) && (paramString.contains("myqcloud")))
    {
      AppMethodBeat.o(229340);
      return true;
    }
    boolean bool = com.tencent.liteav.basic.d.c.a().a(paramString);
    AppMethodBeat.o(229340);
    return bool;
  }
  
  private void d(int paramInt)
  {
    AppMethodBeat.i(229381);
    Object localObject = new TXCDRExtInfo();
    ((TXCDRExtInfo)localObject).url = this.c;
    ((TXCDRExtInfo)localObject).report_common = false;
    ((TXCDRExtInfo)localObject).report_status = false;
    String str = (String)this.b.get("token");
    TXCDRApi.InitEvent(this.h, str, paramInt, com.tencent.liteav.basic.datareport.a.an, (TXCDRExtInfo)localObject);
    a(paramInt, str);
    long l1 = TXCTimeUtil.getUtcTimeTick();
    TXCDRApi.txSetEventIntValue(str, paramInt, "u64_end_timestamp", l1);
    TXCDRApi.txSetEventIntValue(str, paramInt, "u64_timestamp", l1);
    double d1 = TXCStatus.d(this.af, 9002);
    TXCDRApi.txSetEventValue(str, paramInt, "u32_avg_cpu_usage", String.valueOf(d1));
    double d2 = TXCStatus.d(this.af, 9005);
    TXCDRApi.txSetEventValue(str, paramInt, "u32_avg_memory", String.valueOf(d2));
    localObject = String.valueOf(this.z);
    TXCDRApi.txSetEventValue(str, paramInt, "u64_begin_timestamp", (String)localObject);
    l1 = TXCStatus.a(this.af, 7107);
    l1 = (TXCTimeUtil.getTimeTick() - l1) / 1000L;
    long l2;
    label229:
    int i2;
    int i3;
    int i4;
    long l4;
    long l5;
    long l6;
    int i5;
    long l7;
    label461:
    int i6;
    int i7;
    double d3;
    long l8;
    long l9;
    long l10;
    long l11;
    int i8;
    int i9;
    int i10;
    int i11;
    int i1;
    if (l1 < 0L)
    {
      l2 = -1L;
      TXCDRApi.txSetEventIntValue(str, paramInt, "u64_playtime", l2);
      if (l1 >= 0L) {
        break label2018;
      }
      l2 = -1L;
      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_result", l2);
      i2 = TXCStatus.c(this.af, 7105);
      TXCDRApi.txSetEventIntValue(str, paramInt, "u64_err_code", i2);
      i3 = TXCStatus.c(this.af, 2004);
      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_speed_cnt", i3);
      i4 = TXCStatus.c(this.af, 2008);
      TXCDRApi.txSetEventIntValue(str, paramInt, "u64_audio_cache_avg", i4);
      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_avg_cache_time", i4);
      l4 = TXCStatus.c(this.af, 2003);
      TXCDRApi.txSetEventValue(str, paramInt, "u32_max_load", String.valueOf(l4));
      l5 = TXCStatus.c(this.af, 2001);
      TXCDRApi.txSetEventValue(str, paramInt, "u32_avg_load", String.valueOf(l5));
      l6 = TXCStatus.c(this.af, 2002);
      TXCDRApi.txSetEventValue(str, paramInt, "u32_load_cnt", String.valueOf(l6));
      i5 = TXCStatus.c(this.af, 2005);
      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_nodata_cnt", i5);
      l7 = l5 * l6;
      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_audio_block_time", l7);
      if (this.j >= 0L) {
        break label2025;
      }
      l2 = -1L;
      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_first_i_frame", l2);
      i6 = TXCStatus.c(this.af, 6010);
      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_video_width", i6);
      i7 = TXCStatus.c(this.af, 6011);
      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_video_height", i7);
      d3 = TXCStatus.d(this.af, 6007);
      TXCDRApi.txSetEventValue(str, paramInt, "u32_video_avg_fps", String.valueOf(d3));
      l8 = TXCStatus.a(this.af, 6003);
      l3 = TXCStatus.a(this.af, 6005);
      l9 = TXCStatus.a(this.af, 6006);
      l2 = 0L;
      if (l8 > 0L) {
        l2 = l9 / l8;
      }
      TXCDRApi.txSetEventIntValue(str, paramInt, "u64_block_duration_avg", l2);
      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_avg_block_time", l2);
      TXCDRApi.txSetEventIntValue(str, paramInt, "u64_block_count", l8);
      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_video_block_time", l9);
      TXCDRApi.txSetEventIntValue(str, paramInt, "u64_block_duration_max", l3);
      l10 = TXCStatus.a(this.af, 6103);
      TXCDRApi.txSetEventIntValue(str, paramInt, "u64_jitter_cache_max", l10);
      l11 = TXCStatus.a(this.af, 6102);
      TXCDRApi.txSetEventIntValue(str, paramInt, "u64_jitter_cache_avg", l11);
      TXCDRApi.txSetEventValue(str, paramInt, "u32_link_type", String.valueOf(TXCStatus.c(this.af, 7112)));
      i8 = TXCStatus.c(this.af, 7111);
      TXCDRApi.txSetEventValue(str, paramInt, "u32_channel_type", String.valueOf(i8));
      i9 = TXCStatus.c(this.af, 7113);
      TXCDRApi.txSetEventValue(str, paramInt, "u32_ip_count_quic", String.valueOf(i9));
      i10 = TXCStatus.c(this.af, 7114);
      TXCDRApi.txSetEventValue(str, paramInt, "u32_connect_count_quic", String.valueOf(i10));
      i11 = TXCStatus.c(this.af, 7115);
      TXCDRApi.txSetEventValue(str, paramInt, "u32_connect_count_tcp", String.valueOf(i11));
      TXCDRApi.txSetEventValue(str, paramInt, "str_app_version", this.i);
      if (!this.u) {
        break label2034;
      }
      i1 = 1;
      label849:
      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_is_real_time", i1);
      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_first_frame_black", TXCStatus.a(this.af, 6013));
      TXCDRApi.txSetEventValue(str, paramInt, "u64_audio_receive_pkt_cnt", String.valueOf(TXCStatus.c(this.af, 2036)));
      TXCDRApi.txSetEventValue(str, paramInt, "u32_audio_receive_internal_0_500ms", String.valueOf(TXCStatus.c(this.af, 2037)));
      TXCDRApi.txSetEventValue(str, paramInt, "u32_audio_receive_internal_500_1000ms", String.valueOf(TXCStatus.c(this.af, 2038)));
      TXCDRApi.txSetEventValue(str, paramInt, "u32_audio_receive_internal_1000_1500ms", String.valueOf(TXCStatus.c(this.af, 2039)));
      TXCDRApi.txSetEventValue(str, paramInt, "u32_audio_receive_internal_1500_2000ms", String.valueOf(TXCStatus.c(this.af, 2040)));
      TXCDRApi.txSetEventValue(str, paramInt, "u32_audio_receive_internal_2000_3000ms", String.valueOf(TXCStatus.c(this.af, 2041)));
      TXCDRApi.txSetEventValue(str, paramInt, "u32_audio_receive_internal_3000_5000ms", String.valueOf(TXCStatus.c(this.af, 2042)));
      TXCDRApi.txSetEventValue(str, paramInt, "u32_audio_receive_internal_5000_8000ms", String.valueOf(TXCStatus.c(this.af, 2043)));
      TXCDRApi.txSetEventValue(str, paramInt, "u32_audio_receive_internal_8000_11000ms", String.valueOf(TXCStatus.c(this.af, 2044)));
      TXCDRApi.txSetEventValue(str, paramInt, "u32_raudio_eceive_internal_11000_15000ms", String.valueOf(TXCStatus.c(this.af, 2045)));
      TXCDRApi.txSetEventValue(str, paramInt, "u32_audio_receive_internal_biger_15000ms", String.valueOf(TXCStatus.c(this.af, 2046)));
      l3 = TXCStatus.c(this.af, 2047);
      if (l3 > this.D) {
        this.D = l3;
      }
      TXCDRApi.txSetEventValue(str, paramInt, "u32_audio_max_receive_internal_inms", String.valueOf(this.D));
      TXCDRApi.txSetEventValue(str, paramInt, "u32_audio_total_drop_receive_pkt_cnt", String.valueOf(TXCStatus.c(this.af, 2048)));
      TXCDRApi.txSetEventValue(str, paramInt, "u32_audio_block_time_0_60ms_cnt", String.valueOf(TXCStatus.c(this.af, 2049)));
      TXCDRApi.txSetEventValue(str, paramInt, "u32_audio_block_time_60_200ms_cnt", String.valueOf(TXCStatus.c(this.af, 2050)));
      TXCDRApi.txSetEventValue(str, paramInt, "u32_audio_block_time_200_500ms_cnt", String.valueOf(TXCStatus.c(this.af, 2051)));
      TXCDRApi.txSetEventValue(str, paramInt, "u32_audio_block_time_500_1000ms_cnt", String.valueOf(TXCStatus.c(this.af, 2052)));
      TXCDRApi.txSetEventValue(str, paramInt, "u32_audio_block_time_1000_2000ms_cnt", String.valueOf(TXCStatus.c(this.af, 2053)));
      TXCDRApi.txSetEventValue(str, paramInt, "u32_audio_block_time_2000_5000ms_cnt", String.valueOf(TXCStatus.c(this.af, 2054)));
      TXCDRApi.txSetEventValue(str, paramInt, "u32_audio_block_time_5000_10000ms_cnt", String.valueOf(TXCStatus.c(this.af, 2055)));
      TXCDRApi.txSetEventValue(str, paramInt, "u32_audio_block_time_10000_20000ms_cnt", String.valueOf(TXCStatus.c(this.af, 2056)));
      TXCDRApi.txSetEventValue(str, paramInt, "u32_audio_block_time_biger_20000ms_cnt", String.valueOf(TXCStatus.c(this.af, 2057)));
      TXCDRApi.txSetEventValue(str, paramInt, "u32_audio_total_block_time_in_ms", String.valueOf(TXCStatus.c(this.af, 2058)));
      TXCDRApi.txSetEventValue(str, paramInt, "u32_audio_decode_fail_cnt", String.valueOf(TXCStatus.c(this.af, 2059)));
      if (!this.ab) {
        break label2040;
      }
    }
    label2018:
    label2025:
    label2034:
    label2040:
    for (long l3 = 1L;; l3 = 0L)
    {
      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_isp2p", l3);
      TXCDRApi.nativeReportEvent(str, paramInt);
      TXCLog.d(a, "report evt " + paramInt + ": token=" + str + "\nstr_user_id=" + this.b.get("str_user_id") + "\ndev_uuid=" + this.b.get("dev_uuid") + "\nstr_session_id=" + this.b.get("str_session_id") + "\nstr_device_type=" + this.b.get("str_device_type") + "\nstr_os_info=" + this.b.get("str_os_info") + "\nstr_package_name=" + this.b.get("str_package_name") + "\nu32_network_type=" + this.b.get("u32_network_type") + "\nu32_server_ip=" + this.b.get("u32_server_ip") + "\nstr_stream_url=" + this.b.get("str_stream_url") + "\nu64_timestamp=" + this.b.get("u64_timestamp") + "\nu32_avg_cpu_usage=" + d1 + "\nu32_avg_memory=" + d2 + "\nu32_first_i_frame=" + this.j + "\nu32_video_width=" + i6 + "\nu32_video_height=" + i7 + "\nu32_video_avg_fps=" + d3 + "\nu32_speed_cnt=" + i3 + "\nu32_nodata_cnt=" + i5 + "\nu32_avg_cache_time=" + i4 + "\nu32_avg_block_time=" + l2 + "\nu32_avg_load=" + l5 + "\nu32_max_load=" + l4 + "\nu32_video_block_time=" + l9 + "\nu32_audio_block_time=" + l7 + "\nu32_load_cnt=" + l6 + "\nu32_result=" + l1 + "\nu64_err_code=" + i2 + "\nu32_channel_type=" + i8 + "\nu32_ip_count_quic=" + i9 + "\nu32_connect_count_quic=" + i10 + "\nu32_connect_count_tcp=" + i11 + "\nu64_block_count=" + l8 + "\nu64_jitter_cache_max=" + l10 + "\nu64_jitter_cache_avg=" + l11 + "\nu64_begin_timestamp=" + (String)localObject + "\nu32_is_real_time=" + TXCStatus.a(this.af, 2009) + "\nstr_app_version=" + this.i);
      AppMethodBeat.o(229381);
      return;
      l2 = l1;
      break;
      l2 = l1;
      break label229;
      l2 = this.j;
      break label461;
      i1 = 0;
      break label849;
    }
  }
  
  private void e(int paramInt)
  {
    int i1 = 2;
    long l2 = 0L;
    AppMethodBeat.i(229410);
    Object localObject = new TXCDRExtInfo();
    ((TXCDRExtInfo)localObject).url = this.c;
    ((TXCDRExtInfo)localObject).report_common = false;
    ((TXCDRExtInfo)localObject).report_status = true;
    String str = (String)this.b.get("token");
    TXCDRApi.InitEvent(this.h, str, paramInt, com.tencent.liteav.basic.datareport.a.an, (TXCDRExtInfo)localObject);
    a(paramInt, str);
    TXCDRApi.txSetEventIntValue(str, paramInt, "u64_timestamp", TXCTimeUtil.getUtcTimeTick());
    localObject = h.a();
    TXCDRApi.txSetEventIntValue(str, paramInt, "u32_cpu_usage", localObject[1]);
    TXCDRApi.txSetEventIntValue(str, paramInt, "u32_app_cpu_usage", localObject[0]);
    TXCDRApi.txSetEventValue(str, paramInt, "u32_avg_cpu_usage", String.valueOf(TXCStatus.d(this.af, 9002)));
    TXCDRApi.txSetEventValue(str, paramInt, "u32_avg_memory", String.valueOf(TXCStatus.d(this.af, 9005)));
    TXCDRApi.txSetEventIntValue(str, paramInt, "u32_recv_av_diff_time", TXCStatus.a(this.af, 6108, 2));
    TXCDRApi.txSetEventIntValue(str, paramInt, "u32_play_av_diff_time", TXCStatus.a(this.af, 6107, 2));
    TXCDRApi.txSetEventValue(str, paramInt, "u64_playtime", String.valueOf((TXCTimeUtil.getUtcTimeTick() - this.z) / 1000L));
    if (TXCStatus.c(this.af, 2015) == 0) {}
    for (;;)
    {
      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_audio_decode_type", i1);
      long l1 = TXCStatus.a(this.af, 2002);
      long l4;
      label492:
      label753:
      long l3;
      if (this.o == -1L)
      {
        TXCDRApi.txSetEventIntValue(str, paramInt, "u32_audio_block_count", 0L);
        this.o = l1;
        TXCDRApi.txSetEventIntValue(str, paramInt, "u32_audio_cache_time", TXCStatus.c(this.af, 2010));
        TXCDRApi.txSetEventIntValue(str, paramInt, "u32_audio_drop", TXCStatus.c(this.af, 2014));
        TXCDRApi.txSetEventIntValue(str, paramInt, "u32_video_decode_type", TXCStatus.c(this.af, 5004));
        TXCDRApi.txSetEventIntValue(str, paramInt, "u32_video_recv_fps", j());
        TXCDRApi.txSetEventIntValue(str, paramInt, "u32_fps", (int)TXCStatus.d(this.af, 6002));
        TXCDRApi.txSetEventIntValue(str, paramInt, "u32_video_cache_time", TXCStatus.c(this.af, 6101));
        l4 = TXCStatus.a(this.af, 6102);
        TXCDRApi.txSetEventIntValue(str, paramInt, "u32_video_cache_count", l4);
        TXCDRApi.txSetEventIntValue(str, paramInt, "u32_avg_cache_count", l4);
        l1 = TXCStatus.a(this.af, 6004);
        if ((this.k == -1L) || (l1 < this.k)) {
          break label2105;
        }
        TXCDRApi.txSetEventIntValue(str, paramInt, "u32_video_block_count", l1 - this.k);
        this.k = l1;
        i1 = TXCStatus.c(this.af, 7102);
        int i2 = TXCStatus.c(this.af, 7101);
        int i3 = i1 + i2;
        TXCDRApi.txSetEventIntValue(str, paramInt, "u32_net_speed", i3);
        TXCDRApi.txSetEventIntValue(str, paramInt, "u32_avg_net_speed", i3);
        TXCDRApi.txSetEventIntValue(str, paramInt, "u32_avg_audio_bitrate", i1);
        TXCDRApi.txSetEventIntValue(str, paramInt, "u32_avg_video_bitrate", i2);
        TXCDRApi.txSetEventValue(str, paramInt, "u32_link_type", String.valueOf(TXCStatus.c(this.af, 7112)));
        TXCDRApi.txSetEventValue(str, paramInt, "u32_channel_type", String.valueOf(TXCStatus.c(this.af, 7111)));
        TXCDRApi.txSetEventValue(str, paramInt, "str_app_version", this.i);
        l1 = TXCStatus.a(this.af, 6009);
        if (l1 <= this.l) {
          break label2118;
        }
        TXCDRApi.txSetEventIntValue(str, paramInt, "u32_video_light_block_count", l1 - this.l);
        label666:
        this.l = l1;
        l1 = TXCStatus.a(this.af, 6003);
        if (l1 <= this.m) {
          break label2131;
        }
        TXCDRApi.txSetEventIntValue(str, paramInt, "u32_video_large_block_count", l1 - this.m);
        label710:
        this.m = l1;
        i1 = TXCStatus.c(this.af, 2034);
        if (i1 <= this.n) {
          break label2144;
        }
        TXCDRApi.txSetEventIntValue(str, paramInt, "u32_audio_jitter_60ms_count", i1 - this.n);
        this.n = i1;
        TXCDRApi.txSetEventIntValue(str, paramInt, "u32_video_decode_fail", TXCStatus.c(this.af, 5006));
        TXCDRApi.txSetEventIntValue(str, paramInt, "u32_audio_decode_fail", TXCStatus.c(this.af, 2035));
        l1 = TXCStatus.a(this.af, 2036);
        if (l1 < this.E) {
          break label2157;
        }
        TXCDRApi.txSetEventIntValue(str, paramInt, "u32_audio_receive_pkt_cnt", l1 - this.E);
        label837:
        this.E = l1;
        l3 = TXCTimeUtil.getUtcTimeTick();
        if ((this.F <= 0L) || (l3 <= this.F)) {
          break label2230;
        }
      }
      label2230:
      for (l1 = l3 - this.F;; l1 = 0L)
      {
        TXCDRApi.txSetEventIntValue(str, paramInt, "u32_internal_time_in_ms", l1);
        this.F = l3;
        l3 = TXCStatus.a(this.af, 2037);
        if (l3 > this.G) {}
        for (l1 = l3 - this.G;; l1 = 0L)
        {
          TXCDRApi.txSetEventIntValue(str, paramInt, "u32_audio_receive_internal_0_500ms", l1);
          this.G = l3;
          l3 = TXCStatus.a(this.af, 2038);
          if (l3 > this.H) {}
          for (l1 = l3 - this.H;; l1 = 0L)
          {
            TXCDRApi.txSetEventIntValue(str, paramInt, "u32_audio_receive_internal_500_1000ms", l1);
            this.H = l3;
            l3 = TXCStatus.a(this.af, 2039);
            if (l3 > this.I) {}
            for (l1 = l3 - this.I;; l1 = 0L)
            {
              TXCDRApi.txSetEventIntValue(str, paramInt, "u32_audio_receive_internal_1000_1500ms", l1);
              this.I = l3;
              l3 = TXCStatus.a(this.af, 2040);
              if (l3 > this.J) {}
              for (l1 = l3 - this.J;; l1 = 0L)
              {
                TXCDRApi.txSetEventIntValue(str, paramInt, "u32_audio_receive_internal_1500_2000ms", l1);
                this.J = l3;
                l3 = TXCStatus.a(this.af, 2041);
                if (l3 > this.K) {}
                for (l1 = l3 - this.K;; l1 = 0L)
                {
                  TXCDRApi.txSetEventIntValue(str, paramInt, "u32_audio_receive_internal_2000_3000ms", l1);
                  this.K = l3;
                  l3 = TXCStatus.a(this.af, 2042);
                  if (l3 > this.L) {}
                  for (l1 = l3 - this.L;; l1 = 0L)
                  {
                    TXCDRApi.txSetEventIntValue(str, paramInt, "u32_audio_receive_internal_3000_5000ms", l1);
                    this.L = l3;
                    l3 = TXCStatus.a(this.af, 2043);
                    if (l3 > this.M) {}
                    for (l1 = l3 - this.M;; l1 = 0L)
                    {
                      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_audio_receive_internal_5000_8000ms", l1);
                      this.M = l3;
                      l3 = TXCStatus.a(this.af, 2044);
                      if (l3 > this.N) {}
                      for (l1 = l3 - this.N;; l1 = 0L)
                      {
                        TXCDRApi.txSetEventIntValue(str, paramInt, "u32_audio_receive_internal_8000_11000ms", l1);
                        this.N = l3;
                        l3 = TXCStatus.a(this.af, 2045);
                        if (l3 > this.O) {}
                        for (l1 = l3 - this.O;; l1 = 0L)
                        {
                          TXCDRApi.txSetEventIntValue(str, paramInt, "u32_raudio_eceive_internal_11000_15000ms", l1);
                          this.O = l3;
                          l3 = TXCStatus.a(this.af, 2046);
                          if (l3 > this.P) {}
                          for (l1 = l3 - this.P;; l1 = 0L)
                          {
                            TXCDRApi.txSetEventIntValue(str, paramInt, "u32_audio_receive_internal_biger_15000ms", l1);
                            this.P = l3;
                            long l5 = TXCStatus.a(this.af, 2049);
                            l3 = l5 - this.Q;
                            l1 = l3;
                            if (l3 < 0L) {
                              l1 = 0L;
                            }
                            TXCDRApi.txSetEventIntValue(str, paramInt, "u32_audio_block_time_0_60ms_cnt", l1);
                            this.Q = l5;
                            l5 = TXCStatus.a(this.af, 2050);
                            l3 = l5 - this.R;
                            l1 = l3;
                            if (l3 < 0L) {
                              l1 = 0L;
                            }
                            TXCDRApi.txSetEventIntValue(str, paramInt, "u32_audio_block_time_60_200ms_cnt", l1);
                            this.R = l5;
                            l5 = TXCStatus.a(this.af, 2051);
                            l3 = l5 - this.S;
                            l1 = l3;
                            if (l3 < 0L) {
                              l1 = 0L;
                            }
                            TXCDRApi.txSetEventIntValue(str, paramInt, "u32_audio_block_time_200_500ms_cnt", l1);
                            this.S = l5;
                            l5 = TXCStatus.a(this.af, 2052);
                            l3 = l5 - this.T;
                            l1 = l3;
                            if (l3 < 0L) {
                              l1 = 0L;
                            }
                            TXCDRApi.txSetEventIntValue(str, paramInt, "u32_audio_block_time_500_1000ms_cnt", l1);
                            this.T = l5;
                            l5 = TXCStatus.a(this.af, 2053);
                            l3 = l5 - this.U;
                            l1 = l3;
                            if (l3 < 0L) {
                              l1 = 0L;
                            }
                            TXCDRApi.txSetEventIntValue(str, paramInt, "u32_audio_block_time_1000_2000ms_cnt", l1);
                            this.U = l5;
                            l5 = TXCStatus.a(this.af, 2054);
                            l3 = l5 - this.V;
                            l1 = l3;
                            if (l3 < 0L) {
                              l1 = 0L;
                            }
                            TXCDRApi.txSetEventIntValue(str, paramInt, "u32_audio_block_time_2000_5000ms_cnt", l1);
                            this.V = l5;
                            l5 = TXCStatus.a(this.af, 2055);
                            l3 = l5 - this.W;
                            l1 = l3;
                            if (l3 < 0L) {
                              l1 = 0L;
                            }
                            TXCDRApi.txSetEventIntValue(str, paramInt, "u32_audio_block_time_5000_10000ms_cnt", l1);
                            this.W = l5;
                            l5 = TXCStatus.a(this.af, 2056);
                            l3 = l5 - this.X;
                            l1 = l3;
                            if (l3 < 0L) {
                              l1 = 0L;
                            }
                            TXCDRApi.txSetEventIntValue(str, paramInt, "u32_audio_block_time_10000_20000ms_cnt", l1);
                            this.X = l5;
                            l5 = TXCStatus.a(this.af, 2057);
                            l3 = l5 - this.Y;
                            l1 = l3;
                            if (l3 < 0L) {
                              l1 = 0L;
                            }
                            TXCDRApi.txSetEventIntValue(str, paramInt, "u32_audio_block_time_biger_20000ms_cnt", l1);
                            this.Y = l5;
                            l5 = TXCStatus.a(this.af, 2058);
                            l3 = l5 - this.Z;
                            l1 = l3;
                            if (l3 < 0L) {
                              l1 = 0L;
                            }
                            TXCDRApi.txSetEventIntValue(str, paramInt, "u32_audio_total_block_time_in_ms", l1);
                            this.Z = l5;
                            l5 = TXCStatus.a(this.af, 2059);
                            l3 = l5 - this.aa;
                            l1 = l3;
                            if (l3 < 0L) {
                              l1 = 0L;
                            }
                            TXCDRApi.txSetEventIntValue(str, paramInt, "u32_audio_decode_fail_cnt", l1);
                            this.aa = l5;
                            l1 = l2;
                            if (this.ab) {
                              l1 = 1L;
                            }
                            TXCDRApi.txSetEventIntValue(str, paramInt, "u32_isp2p", l1);
                            l1 = TXCStatus.a(this.af, 6006);
                            TXCDRApi.txSetEventIntValue(str, paramInt, "u32_video_interval_block_time", l1 - this.ac);
                            this.ac = l1;
                            TXCDRApi.nativeReportEvent(str, paramInt);
                            if (this.u)
                            {
                              this.y += 1L;
                              this.x += l4;
                              if (l4 > this.w) {
                                this.w = l4;
                              }
                            }
                            AppMethodBeat.o(229410);
                            return;
                            if (l1 >= this.o)
                            {
                              TXCDRApi.txSetEventIntValue(str, paramInt, "u32_audio_block_count", l1 - this.o);
                              break;
                            }
                            TXCDRApi.txSetEventIntValue(str, paramInt, "u32_audio_block_count", -1L);
                            break;
                            label2105:
                            TXCDRApi.txSetEventIntValue(str, paramInt, "u32_video_block_count", 0L);
                            break label492;
                            label2118:
                            TXCDRApi.txSetEventIntValue(str, paramInt, "u32_video_light_block_count", 0L);
                            break label666;
                            label2131:
                            TXCDRApi.txSetEventIntValue(str, paramInt, "u32_video_large_block_count", 0L);
                            break label710;
                            label2144:
                            TXCDRApi.txSetEventIntValue(str, paramInt, "u32_audio_jitter_60ms_count", 0L);
                            break label753;
                            label2157:
                            TXCDRApi.txSetEventIntValue(str, paramInt, "u32_audio_receive_pkt_cnt", 0L);
                            break label837;
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      i1 = 1;
    }
  }
  
  private void f(String paramString)
  {
    AppMethodBeat.i(229355);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("room://")))
    {
      paramString = paramString.split("/");
      paramString[(paramString.length - 1)].split("_");
      TXCStatus.a(this.af, 7112, Long.valueOf(3L));
    }
    AppMethodBeat.o(229355);
  }
  
  private int g(String paramString)
  {
    AppMethodBeat.i(229467);
    paramString = (Number)this.b.get(paramString);
    if (paramString != null)
    {
      int i1 = paramString.intValue();
      AppMethodBeat.o(229467);
      return i1;
    }
    AppMethodBeat.o(229467);
    return 0;
  }
  
  private void i()
  {
    AppMethodBeat.i(16580);
    a(6002, 6007, 6008);
    int[] arrayOfInt = h.a();
    TXCStatus.a(this.af, 9001, Integer.valueOf(arrayOfInt[0]));
    a(9001, 9002, 9003);
    TXCStatus.a(this.af, 9004, Integer.valueOf(h.b()));
    a(9004, 9005, 9006);
    AppMethodBeat.o(16580);
  }
  
  private int j()
  {
    AppMethodBeat.i(229363);
    long l1 = TXCTimeUtil.getTimeTick();
    long l2 = TXCStatus.c(this.af, 6109);
    long l3;
    if (this.s != 0L) {
      l3 = this.s;
    }
    for (int i1 = (int)((l2 - this.t) * 1000L / (l1 - l3));; i1 = (int)(l2 * 1000L / (l1 - this.A)))
    {
      this.s = l1;
      this.t = l2;
      AppMethodBeat.o(229363);
      return i1;
    }
  }
  
  private void k()
  {
    AppMethodBeat.i(182276);
    Object localObject1 = new HashMap();
    String str1 = TXCStatus.b(this.af, 7116);
    Object localObject2 = TXCStatus.b(this.af, 7117);
    Object localObject3 = TXCStatus.b(this.af, 7118);
    int i1 = TXCStatus.c(this.af, 7105);
    String str2 = TXCStatus.b(this.af, 7106);
    int i2 = TXCStatus.c(this.af, 7111);
    ((Map)localObject1).put("stream_url", str1);
    ((Map)localObject1).put("stream_id", localObject2);
    ((Map)localObject1).put("bizid", localObject3);
    ((Map)localObject1).put("err_code", String.valueOf(i1));
    ((Map)localObject1).put("err_info", str2);
    ((Map)localObject1).put("channel_type", String.valueOf(i2));
    long l1 = System.currentTimeMillis();
    long l2 = this.v;
    ((Map)localObject1).put("start_time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date(this.v)));
    ((Map)localObject1).put("end_time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date(l1)));
    ((Map)localObject1).put("total_time", String.valueOf(l1 - l2));
    l2 = TXCStatus.a(this.af, 6003);
    l1 = TXCStatus.a(this.af, 6006);
    long l3 = TXCStatus.a(this.af, 6005);
    if (l2 != 0L) {}
    for (l1 /= l2;; l1 = 0L)
    {
      ((Map)localObject1).put("block_count", String.valueOf(l2));
      ((Map)localObject1).put("block_duration_max", String.valueOf(l3));
      ((Map)localObject1).put("block_duration_avg", String.valueOf(l1));
      if (this.y != 0L) {}
      for (l1 = this.x / this.y;; l1 = 0L)
      {
        ((Map)localObject1).put("jitter_cache_max", String.valueOf(this.w));
        ((Map)localObject1).put("jitter_cache_avg", String.valueOf(l1));
        str1 = TXCDRApi.txCreateToken();
        i1 = com.tencent.liteav.basic.datareport.a.ag;
        i2 = com.tencent.liteav.basic.datareport.a.am;
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
        this.u = false;
        this.v = 0L;
        this.y = 0L;
        this.x = 0L;
        this.w = 0L;
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
    long l1 = TXCStatus.a(this.af, 7013);
    String str = (String)this.b.get("token");
    TXCDRApi.InitEvent(this.h, str, com.tencent.liteav.basic.datareport.a.P, com.tencent.liteav.basic.datareport.a.am, localTXCDRExtInfo);
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
    String str1 = TXCStatus.b(this.af, 7012);
    long l3 = TXCStatus.a(this.af, 7009);
    long l1 = TXCStatus.a(this.af, 7010);
    if (l1 != -1L) {
      l1 -= l3;
    }
    for (;;)
    {
      long l2 = TXCStatus.a(this.af, 7011);
      if (l2 != -1L) {
        l2 -= l3;
      }
      for (;;)
      {
        l3 = TXCStatus.a(this.af, 7013);
        String str2 = (String)this.b.get("token");
        TXCDRApi.InitEvent(this.h, str2, com.tencent.liteav.basic.datareport.a.P, com.tencent.liteav.basic.datareport.a.am, (TXCDRExtInfo)localObject);
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
        localObject = TXCStatus.b(this.af, 7019);
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
    long l3 = TXCStatus.a(this.af, 7009);
    long l1 = TXCStatus.a(this.af, 7013);
    String str = (String)this.b.get("token");
    TXCDRApi.InitEvent(this.h, str, com.tencent.liteav.basic.datareport.a.R, com.tencent.liteav.basic.datareport.a.am, localTXCDRExtInfo);
    long l2 = TXCTimeUtil.getUtcTimeTick();
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.R, "u64_timestamp", l2);
    l3 = (TXCTimeUtil.getTimeTick() - l3) / 1000L;
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.R, "u32_result", l3);
    TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.R, "str_user_id", (String)this.b.get("str_user_id"));
    TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.R, "str_package_name", (String)this.b.get("str_package_name"));
    TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.R, "u32_channel_type", l1);
    TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.R, "str_app_version", this.i);
    TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.R, "dev_uuid", (String)this.b.get("dev_uuid"));
    int i1 = TXCStatus.c(this.af, 7016);
    TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.R, "u32_ip_count_quic", String.valueOf(i1));
    i1 = TXCStatus.c(this.af, 7017);
    TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.R, "u32_connect_count_quic", String.valueOf(i1));
    i1 = TXCStatus.c(this.af, 7018);
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
    Object localObject = h.a();
    int i1 = localObject[0];
    int i2 = localObject[1];
    int i3 = h.b();
    long l1 = TXCStatus.a(this.af, 7013);
    int i4 = TXCStatus.c(this.af, 7004);
    int i5 = TXCStatus.c(this.af, 7003);
    double d1 = TXCStatus.d(this.af, 4001);
    int i6 = TXCStatus.c(this.af, 7005);
    int i7 = TXCStatus.c(this.af, 7002);
    int i8 = TXCStatus.c(this.af, 7001);
    int i9 = TXCStatus.c(this.af, 4007);
    localObject = TXCStatus.b(this.af, 7012);
    String str1 = TXCStatus.b(this.af, 7014);
    String str2 = TXCStatus.b(this.af, 7015);
    String str3 = TXCStatus.b(this.af, 3001);
    long l2 = TXCStatus.a(this.af, 3002);
    double d2 = TXCStatus.d(this.af, 3003);
    int i10 = TXCStatus.c(this.af, 7020);
    String str4 = (String)this.b.get("token");
    TXCDRApi.InitEvent(this.h, str4, com.tencent.liteav.basic.datareport.a.Q, com.tencent.liteav.basic.datareport.a.am, localTXCDRExtInfo);
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
    this.p = false;
    this.q = 0L;
    this.B = 0;
    Object localObject2 = this.ag;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = TXCCommonUtil.getUserId();
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = h.b(this.h);
    }
    this.b.put("str_user_id", localObject2);
    this.b.put("str_device_type", TXCBuild.Model());
    this.b.put("str_device_type", TXCBuild.Model());
    this.b.put("u32_network_type", Integer.valueOf(h.e(this.h)));
    this.b.put("token", h.c());
    this.b.put("str_package_name", h.c(this.h));
    this.b.put("dev_uuid", h.f(this.h));
    this.b.put("str_os_info", TXCBuild.Version());
    this.z = TXCTimeUtil.getUtcTimeTick();
    this.b.put("u64_timestamp", Long.valueOf(this.z));
    this.A = TXCTimeUtil.getTimeTick();
    AppMethodBeat.o(16589);
  }
  
  public void a()
  {
    AppMethodBeat.i(16567);
    p();
    this.k = -1L;
    this.o = -1L;
    this.l = 0L;
    this.m = 0L;
    this.n = 0L;
    this.E = -1L;
    this.F = 0L;
    this.v = System.currentTimeMillis();
    this.C = TXCTimeUtil.getTimeTick();
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
    AppMethodBeat.i(229538);
    if (paramInt1 == 6002)
    {
      d2 = TXCStatus.d(this.af, paramInt1);
      if (d2 < 0.001D)
      {
        AppMethodBeat.o(229538);
        return;
      }
      d1 = TXCStatus.d(this.af, paramInt2);
      paramInt1 = TXCStatus.c(this.af, paramInt3) + 1;
      d2 = (d2 - d1) / paramInt1;
      TXCStatus.a(this.af, paramInt2, Double.valueOf(d2 + d1));
      TXCStatus.a(this.af, paramInt3, Integer.valueOf(paramInt1));
      AppMethodBeat.o(229538);
      return;
    }
    paramInt1 = TXCStatus.c(this.af, paramInt1);
    if (paramInt1 < 0.001D)
    {
      AppMethodBeat.o(229538);
      return;
    }
    double d1 = TXCStatus.d(this.af, paramInt2);
    int i1 = TXCStatus.c(this.af, paramInt3) + 1;
    double d2 = (paramInt1 - d1) / i1;
    TXCStatus.a(this.af, paramInt2, Double.valueOf(d1 + d2));
    TXCStatus.a(this.af, paramInt3, Integer.valueOf(i1));
    AppMethodBeat.o(229538);
  }
  
  public void a(String paramString)
  {
    AppMethodBeat.i(229505);
    this.c = paramString;
    b(paramString);
    AppMethodBeat.o(229505);
  }
  
  public void a(boolean paramBoolean)
  {
    this.u = paramBoolean;
  }
  
  public void b()
  {
    AppMethodBeat.i(16568);
    if (this.p)
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
    this.ad = paramString;
    AppMethodBeat.o(16591);
  }
  
  public void b(boolean paramBoolean)
  {
    AppMethodBeat.i(16571);
    this.ab = paramBoolean;
    AppMethodBeat.o(16571);
  }
  
  public void c()
  {
    AppMethodBeat.i(229498);
    if (this.p) {
      if (this.u)
      {
        e(com.tencent.liteav.basic.datareport.a.Y);
        if (!this.u) {
          break label154;
        }
        d(com.tencent.liteav.basic.datareport.a.Z);
      }
    }
    for (;;)
    {
      if (this.u) {
        k();
      }
      TXCStatus.a(this.af, 7107, Long.valueOf(0L));
      TXCStatus.a(this.af, 2033, Long.valueOf(0L));
      TXCStatus.a(this.af, 6001, Long.valueOf(0L));
      TXCStatus.a(this.af, 7104, Long.valueOf(0L));
      TXCStatus.a(this.af, 7108, Long.valueOf(0L));
      AppMethodBeat.o(229498);
      return;
      if (d() == e.a.c) {
        break;
      }
      e(com.tencent.liteav.basic.datareport.a.V);
      break;
      label154:
      d(com.tencent.liteav.basic.datareport.a.W);
      continue;
      TXCLog.e(a, "play " + this.c + " failed");
      if (this.u) {
        c(com.tencent.liteav.basic.datareport.a.X);
      } else {
        c(com.tencent.liteav.basic.datareport.a.U);
      }
    }
  }
  
  protected e.a d()
  {
    AppMethodBeat.i(229517);
    try
    {
      Object localObject2 = Uri.parse(this.ad);
      if (localObject2 == null)
      {
        localObject1 = e.a.a;
        AppMethodBeat.o(229517);
        return localObject1;
      }
      localObject1 = ((Uri)localObject2).getHost();
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = e.a.a;
        AppMethodBeat.o(229517);
        return localObject1;
      }
      String str = ((Uri)localObject2).getScheme();
      if (str == null)
      {
        localObject1 = e.a.a;
        AppMethodBeat.o(229517);
        return localObject1;
      }
      if ((!str.equals("rtmp")) && (!str.equals("http")) && (!str.equals("https")))
      {
        localObject1 = e.a.a;
        AppMethodBeat.o(229517);
        return localObject1;
      }
      if (c((String)localObject1))
      {
        localObject1 = e.a.b;
        AppMethodBeat.o(229517);
        return localObject1;
      }
      localObject2 = ((Uri)localObject2).getQueryParameterNames();
      if ((localObject2 != null) && ((((Set)localObject2).contains("bizid")) || (((Set)localObject2).contains("txTime")) || (((Set)localObject2).contains("txSecret"))))
      {
        localObject1 = e.a.b;
        AppMethodBeat.o(229517);
        return localObject1;
      }
      if (ae.containsKey(localObject1))
      {
        localObject1 = (e.a)ae.get(localObject1);
        AppMethodBeat.o(229517);
        return localObject1;
      }
      ae.put(localObject1, e.a.a);
      new Thread(new Runnable()
      {
        public void run()
        {
          boolean bool2 = false;
          AppMethodBeat.i(229461);
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
              AppMethodBeat.o(229461);
              return;
              i += 1;
              break;
            }
            return;
          }
          catch (Exception localException)
          {
            TXCLog.e(e.h(), "check dns failed.", localException);
            AppMethodBeat.o(229461);
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
    localObject1 = e.a.a;
    AppMethodBeat.o(229517);
    return localObject1;
  }
  
  public void d(String paramString)
  {
    this.af = paramString;
  }
  
  public void e()
  {
    AppMethodBeat.i(229535);
    if ((!this.p) && (!TextUtils.isEmpty(TXCStatus.b(this.af, 7012))))
    {
      m();
      this.p = true;
    }
    if (this.q <= 0L) {
      this.q = TXCTimeUtil.getTimeTick();
    }
    if ((this.p) && (TXCTimeUtil.getTimeTick() - this.q > 5000L))
    {
      o();
      this.q = TXCTimeUtil.getTimeTick();
    }
    AppMethodBeat.o(229535);
  }
  
  public void e(String paramString)
  {
    this.ag = paramString;
  }
  
  public void f()
  {
    AppMethodBeat.i(16592);
    i();
    int i1;
    if (!this.p)
    {
      long l1 = TXCStatus.a(this.af, 6001);
      long l2 = TXCStatus.a(this.af, 7104);
      long l3 = TXCStatus.a(this.af, 2033);
      long l4 = TXCStatus.a(this.af, 7108);
      if ((l1 > 0L) && (l2 > 0L) && (l4 > 0L) && (l3 > 0L))
      {
        if (!this.u) {
          break label292;
        }
        i1 = com.tencent.liteav.basic.datareport.a.X;
        c(i1);
        this.r = 5000;
        this.p = true;
      }
      String str = TXCStatus.b(this.af, 7119);
      if (str != null) {
        b(str);
      }
    }
    if ((this.B >= 3) && (!this.p))
    {
      if (this.u)
      {
        i1 = com.tencent.liteav.basic.datareport.a.X;
        label168:
        c(i1);
        this.r = 5000;
        this.p = true;
      }
    }
    else
    {
      this.B += 1;
      if (this.q <= 0L) {
        this.q = TXCTimeUtil.getTimeTick();
      }
      if (TXCTimeUtil.getTimeTick() > this.q + this.r)
      {
        if (!this.u) {
          break label306;
        }
        e(com.tencent.liteav.basic.datareport.a.Y);
        this.r = 5000;
      }
    }
    for (;;)
    {
      this.k = TXCStatus.a(this.af, 6004);
      this.o = TXCStatus.c(this.af, 2002);
      this.q = TXCTimeUtil.getTimeTick();
      AppMethodBeat.o(16592);
      return;
      label292:
      i1 = com.tencent.liteav.basic.datareport.a.U;
      break;
      i1 = com.tencent.liteav.basic.datareport.a.U;
      break label168;
      label306:
      if (d() == e.a.c)
      {
        AppMethodBeat.o(16592);
        return;
      }
      e(com.tencent.liteav.basic.datareport.a.V);
      this.r = TXCDRApi.getStatusReportInterval();
      if (this.r < 5000) {
        this.r = 5000;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.e
 * JD-Core Version:    0.7.0.1
 */