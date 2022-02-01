package com.tencent.mm.ai;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.p;
import com.tencent.mm.b.f;
import com.tencent.mm.b.h;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.protobuf.agg;
import com.tencent.mm.protocal.protobuf.ahd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.base.t;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;

public final class m
{
  private static final f<Long, u> fwL;
  private static final ConcurrentHashMap<Long, Integer> gKh;
  
  static
  {
    AppMethodBeat.i(123952);
    fwL = new h(50);
    gKh = new ConcurrentHashMap(50);
    AppMethodBeat.o(123952);
  }
  
  public static int Xx()
  {
    AppMethodBeat.i(123951);
    Context localContext = aj.getContext();
    if (ay.isNetworkConnected(localContext))
    {
      if (ay.is2G(localContext))
      {
        AppMethodBeat.o(123951);
        return 2;
      }
      if (ay.is3G(localContext))
      {
        AppMethodBeat.o(123951);
        return 3;
      }
      if (ay.is4G(localContext))
      {
        AppMethodBeat.o(123951);
        return 4;
      }
      if (ay.isWifi(localContext))
      {
        AppMethodBeat.o(123951);
        return 1;
      }
      AppMethodBeat.o(123951);
      return 0;
    }
    AppMethodBeat.o(123951);
    return 100;
  }
  
  public static u a(long paramLong, String paramString)
  {
    AppMethodBeat.i(123941);
    if (paramLong > 0L)
    {
      localu = (u)fwL.get(Long.valueOf(paramLong));
      if (localu != null)
      {
        AppMethodBeat.o(123941);
        return localu;
      }
    }
    Object localObject1 = bj.aFP(paramString);
    if (localObject1 == null)
    {
      paramString = new u();
      AppMethodBeat.o(123941);
      return paramString;
    }
    int i = bt.getInt((String)((Map)localObject1).get(".msg.appmsg.mmreader.category.$type"), 0);
    paramString = bt.nullAsNil((String)((Map)localObject1).get(".msg.appmsg.mmreader.name"));
    int j = bt.getInt((String)((Map)localObject1).get(".msg.appmsg.mmreader.forbid_forward"), 0);
    int k = bt.getInt((String)((Map)localObject1).get(".msg.appmsg.mmreader.category.$count"), 0);
    Object localObject2 = (String)((Map)localObject1).get(".msg.commenturl");
    u localu = new u();
    localu.type = i;
    localu.name = paramString;
    localu.eOT = ((String)localObject2);
    localu.gKt = j;
    i = 0;
    while (i < k)
    {
      localObject2 = new v();
      Object localObject3 = new StringBuilder(".msg.appmsg.mmreader.category.item");
      label660:
      StringBuilder localStringBuilder;
      if (i == 0)
      {
        paramString = "";
        localObject3 = paramString;
        ((v)localObject2).title = ((String)((Map)localObject1).get((String)localObject3 + ".title"));
        ((v)localObject2).url = ((String)((Map)localObject1).get((String)localObject3 + ".url"));
        ((v)localObject2).gKB = ((String)((Map)localObject1).get((String)localObject3 + ".shorturl"));
        ((v)localObject2).gKC = ((String)((Map)localObject1).get((String)localObject3 + ".longurl"));
        ((v)localObject2).time = bt.getLong((String)((Map)localObject1).get((String)localObject3 + ".pub_time"), 0L);
        ((v)localObject2).gKE = ((String)((Map)localObject1).get((String)localObject3 + ".tweetid"));
        ((v)localObject2).gKF = ((String)((Map)localObject1).get((String)localObject3 + ".digest"));
        ((v)localObject2).type = bt.getInt((String)((Map)localObject1).get((String)localObject3 + ".itemshowtype"), 0);
        ((v)localObject2).gKH = bt.getInt((String)((Map)localObject1).get((String)localObject3 + ".play_length"), 0);
        ((v)localObject2).gKD = ((String)((Map)localObject1).get((String)localObject3 + ".cover"));
        paramString = (String)((Map)localObject1).get((String)localObject3 + ".cover_235_1");
        if (((((v)localObject2).type != 5) && (!bt.isNullOrNil(paramString))) || (bt.isNullOrNil(((v)localObject2).gKD))) {
          ((v)localObject2).gKD = paramString;
        }
        j = 0;
        if (j >= 100) {
          break label757;
        }
        localStringBuilder = new StringBuilder().append((String)localObject3).append(".pic_urls.pic_url");
        if (j != 0) {
          break label748;
        }
      }
      label748:
      for (paramString = "";; paramString = String.valueOf(j))
      {
        paramString = (String)((Map)localObject1).get(paramString);
        if (bt.isNullOrNil(paramString)) {
          break label757;
        }
        ((v)localObject2).gKV.add(paramString);
        j += 1;
        break label660;
        paramString = String.valueOf(i);
        break;
      }
      label757:
      if (((v)localObject2).gKV.size() == 0) {
        ((v)localObject2).gKV.add(((v)localObject2).gKD);
      }
      ((v)localObject2).gKU = ((String)((Map)localObject1).get((String)localObject3 + ".cover_1_1"));
      ((v)localObject2).gKG = bt.getInt((String)((Map)localObject1).get((String)localObject3 + ".del_flag"), 0);
      ((v)localObject2).gKI = ((String)((Map)localObject1).get((String)localObject3 + ".weapp_username"));
      ((v)localObject2).gKJ = ((String)((Map)localObject1).get((String)localObject3 + ".weapp_path"));
      ((v)localObject2).gKK = bt.getInt((String)((Map)localObject1).get((String)localObject3 + ".weapp_version"), 0);
      ((v)localObject2).gKL = bt.getInt((String)((Map)localObject1).get((String)localObject3 + ".weapp_state"), 0);
      ((v)localObject2).gKM = ((String)((Map)localObject1).get((String)localObject3 + ".weapp_appid"));
      ((v)localObject2).gKN = ((String)((Map)localObject1).get((String)localObject3 + ".weapp_image_url"));
      ((v)localObject2).gKO = ((String)((Map)localObject1).get((String)localObject3 + ".weapp_icon"));
      ((v)localObject2).gKP = ((String)((Map)localObject1).get((String)localObject3 + ".weapp_nickname"));
      ((v)localObject2).gKQ = ((String)((Map)localObject1).get((String)localObject3 + ".play_url"));
      ((v)localObject2).gKR = ((String)((Map)localObject1).get((String)localObject3 + ".player"));
      ((v)localObject2).gKS = bt.getInt((String)((Map)localObject1).get((String)localObject3 + ".music_source"), 1);
      ((v)localObject2).gKT = bt.getInt((String)((Map)localObject1).get((String)localObject3 + ".pic_num"), 1);
      ((v)localObject2).videoWidth = bt.getInt((String)((Map)localObject1).get((String)localObject3 + ".video_width"), 0);
      ((v)localObject2).videoHeight = bt.getInt((String)((Map)localObject1).get((String)localObject3 + ".video_height"), 0);
      ((v)localObject2).gGA = bt.getInt((String)((Map)localObject1).get((String)localObject3 + ".is_pay_subscribe"), 0);
      ((v)localObject2).gGC = ((String)((Map)localObject1).get((String)localObject3 + ".vid"));
      localu.gKs.add(localObject2);
      i += 1;
    }
    localu.gGV = com.tencent.mm.am.j.v((Map)localObject1);
    paramString = bt.nullAsNil((String)((Map)localObject1).get(".msg.fromusername"));
    if (!bt.isNullOrNil(paramString))
    {
      localObject1 = ((k)g.ab(k.class)).apM().aHY(paramString).ZW();
      localu.dxz = paramString;
      localu.dxA = ((String)localObject1);
    }
    if (paramLong > 0L)
    {
      fwL.o(Long.valueOf(paramLong), localu);
      gKh.put(Long.valueOf(paramLong), Integer.valueOf(k));
    }
    AppMethodBeat.o(123941);
    return localu;
  }
  
  public static agg a(v paramv, ahd paramahd, String paramString1, String paramString2)
  {
    AppMethodBeat.i(123946);
    if ((paramv == null) || (paramv.type == -1))
    {
      AppMethodBeat.o(123946);
      return null;
    }
    agg localagg = new agg();
    if (paramv.type == 5) {}
    for (int i = 1;; i = 0)
    {
      localagg.gGz = i;
      localagg.gGx = paramv.type;
      localagg.gGA = paramv.gGA;
      localagg.gGC = paramv.gGC;
      localagg.videoWidth = paramv.videoWidth;
      localagg.videoHeight = paramv.videoHeight;
      localagg.duration = paramv.gKH;
      localagg.gGy = ((int)paramv.time);
      localagg.dfT = paramString1;
      localagg.gKv = paramString2;
      localagg.gKD = paramv.gKD;
      paramahd.aEy(paramv.title);
      paramahd.aEz(paramv.gKF);
      AppMethodBeat.o(123946);
      return localagg;
    }
  }
  
  public static agg a(bl parambl, ahd paramahd)
  {
    AppMethodBeat.i(123944);
    if (parambl == null)
    {
      AppMethodBeat.o(123944);
      return null;
    }
    if ((parambl.cxB()) && (!parambl.eJL()))
    {
      parambl = k.b.ar(parambl.field_content, parambl.field_reserved);
      if (parambl == null)
      {
        AppMethodBeat.o(123944);
        return null;
      }
      e locale = (e)parambl.ao(e.class);
      if ((locale == null) || ((locale.gGx == -1) && (locale.gGF != 1)))
      {
        AppMethodBeat.o(123944);
        return null;
      }
      agg localagg = new agg();
      localagg.gGz = locale.gGz;
      localagg.gGx = locale.gGx;
      localagg.gGA = locale.gGA;
      localagg.gGC = locale.gGC;
      localagg.videoWidth = locale.videoWidth;
      localagg.videoHeight = locale.videoHeight;
      localagg.duration = locale.duration;
      localagg.gGy = locale.gGy;
      localagg.gKD = parambl.thumburl;
      localagg.dfT = parambl.dxz;
      localagg.gKv = parambl.dxA;
      paramahd.aEy(parambl.title);
      paramahd.aEz(parambl.description);
      AppMethodBeat.o(123944);
      return localagg;
    }
    AppMethodBeat.o(123944);
    return null;
  }
  
  public static String a(Context paramContext, int paramInt, String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(123949);
    if (paramContext == null)
    {
      ad.w("MicroMsg.AppMsgBizHelper", "getReaderAppMsgContent: context is null");
      AppMethodBeat.o(123949);
      return null;
    }
    if ((paramString1 == null) || (paramString2 == null))
    {
      ad.w("MicroMsg.AppMsgBizHelper", "getReaderAppMsgContent: msg is null");
      AppMethodBeat.o(123949);
      return null;
    }
    g.afC();
    if (!g.afB().isSDCardAvailable())
    {
      t.g(paramContext, null);
      AppMethodBeat.o(123949);
      return null;
    }
    try
    {
      paramString1 = ((a)g.ab(a.class)).a(paramLong, paramString1);
      paramContext = paramString1.gKs;
      if ((paramContext != null) && (paramContext.size() > 0) && (paramInt < paramContext.size()))
      {
        v localv = (v)paramContext.get(paramInt);
        paramContext = new k.b();
        paramContext.title = localv.title;
        paramContext.description = localv.gKF;
        paramContext.action = "view";
        paramContext.type = 5;
        paramContext.url = localv.url;
        paramContext.dxz = paramString1.dxz;
        paramContext.dxA = paramString1.dxA;
        paramContext.eOT = paramString1.eOT;
        paramContext.thumburl = a(localv);
        paramString1 = new e();
        paramString1.gGx = localv.type;
        paramString1.gGA = localv.gGA;
        if (localv.type == 5)
        {
          paramString1.gGC = localv.gGC;
          paramString1.gGy = ((int)localv.time);
          paramString1.duration = localv.gKH;
          paramString1.videoWidth = localv.videoWidth;
          paramString1.videoHeight = localv.videoHeight;
        }
        paramContext.a(paramString1);
        if (bt.isNullOrNil(paramContext.thumburl))
        {
          paramString1 = p.auF().we(paramString2);
          if (paramString1 != null) {
            paramContext.thumburl = paramString1.aux();
          }
        }
        paramContext = k.b.a(paramContext, null, null);
        AppMethodBeat.o(123949);
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      ad.printErrStackTrace("MicroMsg.AppMsgBizHelper", paramContext, "", new Object[0]);
      ad.e("MicroMsg.AppMsgBizHelper", "retransmit app msg error : %s", new Object[] { paramContext.getLocalizedMessage() });
      AppMethodBeat.o(123949);
    }
    return null;
  }
  
  public static String a(v paramv)
  {
    AppMethodBeat.i(123943);
    if (paramv.type == 5)
    {
      if (bt.isNullOrNil(paramv.gKD))
      {
        paramv = paramv.gKU;
        AppMethodBeat.o(123943);
        return paramv;
      }
      paramv = paramv.gKD;
      AppMethodBeat.o(123943);
      return paramv;
    }
    if (bt.isNullOrNil(paramv.gKU))
    {
      paramv = paramv.gKD;
      AppMethodBeat.o(123943);
      return paramv;
    }
    paramv = paramv.gKU;
    AppMethodBeat.o(123943);
    return paramv;
  }
  
  public static String as(String paramString1, String paramString2)
  {
    AppMethodBeat.i(123937);
    paramString1 = bw.K(paramString1, "msg");
    if (paramString1 == null)
    {
      ad.e("MicroMsg.AppMsgBizHelper", "getAppMsgDyeingTempFromUser fail, values is null");
      paramString1 = null;
      if ((!bt.isNullOrNil(paramString1)) || (w.td(paramString2))) {
        break label191;
      }
    }
    for (;;)
    {
      if (!bt.isNullOrNil(paramString2))
      {
        if (rz(paramString2))
        {
          paramString1 = ((com.tencent.mm.plugin.appbrand.service.m)g.ab(com.tencent.mm.plugin.appbrand.service.m.class)).FW(paramString2);
          if ((paramString1 != null) && (!TextUtils.isEmpty(paramString1.field_nickname)))
          {
            paramString1 = paramString1.field_nickname;
            AppMethodBeat.o(123937);
            return paramString1;
            paramString1 = (String)paramString1.get(".msg.fromusername");
            break;
          }
        }
        paramString1 = ((k)g.ab(k.class)).apM().aHY(paramString2);
        if ((paramString1 == null) || ((int)paramString1.fId <= 0))
        {
          AppMethodBeat.o(123937);
          return "";
        }
        paramString1 = ((com.tencent.mm.plugin.messenger.a.b)g.ab(com.tencent.mm.plugin.messenger.a.b.class)).sh(paramString2);
        AppMethodBeat.o(123937);
        return paramString1;
      }
      AppMethodBeat.o(123937);
      return "";
      label191:
      paramString2 = paramString1;
    }
  }
  
  public static int b(long paramLong, String paramString)
  {
    AppMethodBeat.i(123942);
    if (paramLong > 0L)
    {
      Integer localInteger = (Integer)gKh.get(Long.valueOf(paramLong));
      if (localInteger != null)
      {
        i = localInteger.intValue();
        AppMethodBeat.o(123942);
        return i;
      }
    }
    paramString = bj.aFP(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(123942);
      return 0;
    }
    paramString = Integer.valueOf(bt.getInt((String)paramString.get(".msg.appmsg.mmreader.category.$count"), 0));
    if (paramLong > 0L) {
      gKh.put(Long.valueOf(paramLong), paramString);
    }
    int i = paramString.intValue();
    AppMethodBeat.o(123942);
    return i;
  }
  
  public static boolean c(long paramLong, String paramString)
  {
    AppMethodBeat.i(123948);
    if (paramString == null)
    {
      AppMethodBeat.o(123948);
      return false;
    }
    paramString = ((a)g.ab(a.class)).a(paramLong, paramString);
    if (paramString == null)
    {
      ad.w("MicroMsg.AppMsgBizHelper", "isBizMsgForbidForward reader is null");
      AppMethodBeat.o(123948);
      return false;
    }
    if (paramString.gKt == 1)
    {
      AppMethodBeat.o(123948);
      return true;
    }
    AppMethodBeat.o(123948);
    return false;
  }
  
  public static String d(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 0;
    AppMethodBeat.i(123950);
    int j = com.tencent.mm.storage.u.getSessionId();
    if ((paramString == null) || (!paramString.contains("mp.weixin.qq.com")) || ((j <= 0) && (paramInt2 < 0) && (paramInt1 < 0) && (paramInt3 <= 0)))
    {
      AppMethodBeat.o(123950);
      return paramString;
    }
    String str3 = "";
    int k = paramString.indexOf("#");
    String str1;
    if (k > 0)
    {
      str1 = paramString.substring(0, k);
      str3 = paramString.substring(k);
    }
    for (;;)
    {
      String str2 = str1;
      if (!paramString.contains("?"))
      {
        str2 = str1 + "?";
        i = 1;
      }
      paramString = str2;
      if (paramInt1 >= 0)
      {
        paramString = str2.replaceAll("(scene=[\\d]*)", "");
        paramString = paramString + "&scene=" + paramInt1;
      }
      str1 = paramString;
      if (paramInt2 >= 0)
      {
        paramString = paramString.replaceAll("(subscene=[\\d]*)", "");
        str1 = paramString + "&subscene=" + paramInt2;
      }
      paramString = str1;
      if (j > 0) {
        paramString = str1 + "&sessionid=" + j;
      }
      str1 = paramString;
      if (paramInt3 > 0)
      {
        paramString = paramString + "&clicktime=" + paramInt3;
        str1 = paramString + "&enterid=" + paramInt3;
      }
      paramString = str1;
      if (i != 0) {
        paramString = str1.replace("?&", "?");
      }
      paramString = paramString + str3;
      AppMethodBeat.o(123950);
      return paramString;
      str1 = paramString;
    }
  }
  
  public static String mV(int paramInt)
  {
    AppMethodBeat.i(123947);
    if ((paramInt <= 0) || (paramInt >= 86400L))
    {
      AppMethodBeat.o(123947);
      return null;
    }
    if (paramInt < 3600L) {}
    for (Object localObject = "mm:ss";; localObject = "HH:mm:ss")
    {
      localObject = new SimpleDateFormat((String)localObject);
      ((SimpleDateFormat)localObject).setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
      localObject = ((SimpleDateFormat)localObject).format(Long.valueOf(paramInt * 1000L));
      AppMethodBeat.o(123947);
      return localObject;
    }
  }
  
  public static String rA(String paramString)
  {
    AppMethodBeat.i(123939);
    Map localMap = bw.K(paramString, "msg");
    if (localMap == null)
    {
      ad.e("MicroMsg.AppMsgBizHelper", "getAppMsgDyeingTempTitle fail, values is null");
      AppMethodBeat.o(123939);
      return " ";
    }
    bt.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_show_type"), 0);
    bt.by((String)localMap.get(".msg.appmsg.ext_pay_info.pay_type"), "");
    String str = bt.nullAsNil((String)localMap.get(".msg.appmsg.title"));
    paramString = str;
    if (bt.isNullOrNil(str)) {
      paramString = (String)localMap.get(".msg.appmsg.mmreader.category.item.title");
    }
    str = paramString;
    if (bt.isNullOrNil(paramString)) {
      str = " ";
    }
    AppMethodBeat.o(123939);
    return str;
  }
  
  public static String rB(String paramString)
  {
    AppMethodBeat.i(123940);
    paramString = bj.aFP(paramString);
    if (paramString == null)
    {
      Object localObject = new u();
      paramString = new StringBuilder("");
      localObject = ((u)localObject).gKs.iterator();
      while (((Iterator)localObject).hasNext())
      {
        v localv = (v)((Iterator)localObject).next();
        if (!bt.isNullOrNil(localv.title)) {
          paramString.append(localv.title);
        }
      }
      paramString = paramString.toString();
      AppMethodBeat.o(123940);
      return paramString;
    }
    paramString = (String)paramString.get(".msg.appmsg.mmreader.category.item.title");
    if (paramString == null)
    {
      AppMethodBeat.o(123940);
      return "";
    }
    AppMethodBeat.o(123940);
    return paramString;
  }
  
  public static boolean rz(String paramString)
  {
    AppMethodBeat.i(123938);
    if ((paramString != null) && (paramString.endsWith("@app")))
    {
      AppMethodBeat.o(123938);
      return true;
    }
    AppMethodBeat.o(123938);
    return false;
  }
  
  public static agg t(bl parambl)
  {
    AppMethodBeat.i(123945);
    if (parambl == null)
    {
      AppMethodBeat.o(123945);
      return null;
    }
    if (parambl.cjN())
    {
      parambl = k.b.ar(parambl.field_content, parambl.field_reserved);
      if (parambl == null)
      {
        AppMethodBeat.o(123945);
        return null;
      }
      e locale = (e)parambl.ao(e.class);
      if ((locale == null) || (locale.gGE == null))
      {
        AppMethodBeat.o(123945);
        return null;
      }
      agg localagg = new agg();
      localagg.dfT = parambl.dxz;
      localagg.gKv = parambl.dxA;
      localagg.CEf = locale.gGE.CEf;
      localagg.videoUrl = locale.gGE.videoUrl;
      localagg.gGC = locale.gGE.CEg;
      localagg.gKD = locale.gGE.gKD;
      localagg.videoWidth = locale.gGE.width;
      localagg.videoHeight = locale.gGE.height;
      localagg.duration = locale.gGE.videoDuration;
      AppMethodBeat.o(123945);
      return localagg;
    }
    AppMethodBeat.o(123945);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ai.m
 * JD-Core Version:    0.7.0.1
 */