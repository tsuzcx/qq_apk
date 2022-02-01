package com.tencent.mm.ag;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.al.k;
import com.tencent.mm.b.f;
import com.tencent.mm.b.h;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.amt;
import com.tencent.mm.protocal.protobuf.anq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.SemiXml;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;

public final class m
{
  private static final f<Long, u> gAU;
  private static final ConcurrentHashMap<Long, Integer> izR;
  
  static
  {
    AppMethodBeat.i(123952);
    gAU = new h(50);
    izR = new ConcurrentHashMap(50);
    AppMethodBeat.o(123952);
  }
  
  public static boolean HF(String paramString)
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
  
  public static String HG(String paramString)
  {
    AppMethodBeat.i(123939);
    Map localMap = XmlParser.parseXml(paramString, "msg", null);
    if (localMap == null)
    {
      Log.e("MicroMsg.AppMsgBizHelper", "getAppMsgDyeingTempTitle fail, values is null");
      AppMethodBeat.o(123939);
      return " ";
    }
    Util.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_show_type"), 0);
    Util.nullAs((String)localMap.get(".msg.appmsg.ext_pay_info.pay_type"), "");
    String str = Util.nullAsNil((String)localMap.get(".msg.appmsg.title"));
    paramString = str;
    if (Util.isNullOrNil(str)) {
      paramString = (String)localMap.get(".msg.appmsg.mmreader.category.item.title");
    }
    str = paramString;
    if (Util.isNullOrNil(paramString)) {
      str = " ";
    }
    AppMethodBeat.o(123939);
    return str;
  }
  
  public static String HH(String paramString)
  {
    AppMethodBeat.i(123940);
    paramString = SemiXml.decode(paramString);
    if (paramString == null)
    {
      Object localObject = new u();
      paramString = new StringBuilder("");
      localObject = ((u)localObject).iAd.iterator();
      while (((Iterator)localObject).hasNext())
      {
        v localv = (v)((Iterator)localObject).next();
        if (!Util.isNullOrNil(localv.title)) {
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
  
  public static u a(long paramLong, String paramString)
  {
    AppMethodBeat.i(123941);
    if (paramLong > 0L)
    {
      localu = (u)gAU.get(Long.valueOf(paramLong));
      if (localu != null)
      {
        AppMethodBeat.o(123941);
        return localu;
      }
    }
    Object localObject1 = SemiXml.decode(paramString);
    if (localObject1 == null)
    {
      paramString = new u();
      AppMethodBeat.o(123941);
      return paramString;
    }
    int i = Util.getInt((String)((Map)localObject1).get(".msg.appmsg.mmreader.category.$type"), 0);
    paramString = Util.nullAsNil((String)((Map)localObject1).get(".msg.appmsg.mmreader.name"));
    int j = Util.getInt((String)((Map)localObject1).get(".msg.appmsg.mmreader.forbid_forward"), 0);
    int k = Util.getInt((String)((Map)localObject1).get(".msg.appmsg.mmreader.category.$count"), 0);
    Object localObject2 = (String)((Map)localObject1).get(".msg.commenturl");
    u localu = new u();
    localu.type = i;
    localu.name = paramString;
    localu.fQR = ((String)localObject2);
    localu.iAe = j;
    i = 0;
    while (i < k)
    {
      localObject2 = new v();
      Object localObject3 = new StringBuilder(".msg.appmsg.mmreader.category.item");
      Object localObject4;
      if (i == 0)
      {
        paramString = "";
        localObject3 = paramString;
        ((v)localObject2).title = ((String)((Map)localObject1).get((String)localObject3 + ".title"));
        ((v)localObject2).url = ((String)((Map)localObject1).get((String)localObject3 + ".url"));
        ((v)localObject2).iAm = ((String)((Map)localObject1).get((String)localObject3 + ".shorturl"));
        ((v)localObject2).iAn = ((String)((Map)localObject1).get((String)localObject3 + ".longurl"));
        ((v)localObject2).time = Util.getLong((String)((Map)localObject1).get((String)localObject3 + ".pub_time"), 0L);
        ((v)localObject2).iAp = ((String)((Map)localObject1).get((String)localObject3 + ".tweetid"));
        ((v)localObject2).iAq = ((String)((Map)localObject1).get((String)localObject3 + ".digest"));
        ((v)localObject2).type = Util.getInt((String)((Map)localObject1).get((String)localObject3 + ".itemshowtype"), 0);
        ((v)localObject2).iAs = Util.getInt((String)((Map)localObject1).get((String)localObject3 + ".play_length"), 0);
        ((v)localObject2).iAo = ((String)((Map)localObject1).get((String)localObject3 + ".cover"));
        paramString = (String)((Map)localObject1).get((String)localObject3 + ".cover_235_1");
        localObject4 = (String)((Map)localObject1).get((String)localObject3 + ".cover_16_9");
        if (((((v)localObject2).type != 5) && (!Util.isNullOrNil(paramString))) || (Util.isNullOrNil(((v)localObject2).iAo))) {
          ((v)localObject2).iAo = paramString;
        }
        if ((((v)localObject2).type == 5) && (!Util.isNullOrNil((String)localObject4))) {
          ((v)localObject2).iAo = ((String)localObject4);
        }
        j = 0;
        label716:
        if (j >= 100) {
          break label813;
        }
        localObject4 = new StringBuilder().append((String)localObject3).append(".pic_urls.pic_url");
        if (j != 0) {
          break label804;
        }
      }
      label804:
      for (paramString = "";; paramString = String.valueOf(j))
      {
        paramString = (String)((Map)localObject1).get(paramString);
        if (Util.isNullOrNil(paramString)) {
          break label813;
        }
        ((v)localObject2).iAE.add(paramString);
        j += 1;
        break label716;
        paramString = String.valueOf(i);
        break;
      }
      label813:
      if (((v)localObject2).iAE.size() == 0) {
        ((v)localObject2).iAE.add(((v)localObject2).iAo);
      }
      ((v)localObject2).iAD = ((String)((Map)localObject1).get((String)localObject3 + ".cover_1_1"));
      ((v)localObject2).iAr = Util.getInt((String)((Map)localObject1).get((String)localObject3 + ".del_flag"), 0);
      ((v)localObject2).iAt = ((String)((Map)localObject1).get((String)localObject3 + ".weapp_username"));
      ((v)localObject2).weappPath = ((String)((Map)localObject1).get((String)localObject3 + ".weapp_path"));
      ((v)localObject2).weappVersion = Util.getInt((String)((Map)localObject1).get((String)localObject3 + ".weapp_version"), 0);
      ((v)localObject2).iAu = Util.getInt((String)((Map)localObject1).get((String)localObject3 + ".weapp_state"), 0);
      ((v)localObject2).iAv = ((String)((Map)localObject1).get((String)localObject3 + ".weapp_appid"));
      ((v)localObject2).iAw = ((String)((Map)localObject1).get((String)localObject3 + ".weapp_image_url"));
      ((v)localObject2).iAx = ((String)((Map)localObject1).get((String)localObject3 + ".weapp_icon"));
      ((v)localObject2).iAy = ((String)((Map)localObject1).get((String)localObject3 + ".weapp_nickname"));
      ((v)localObject2).iAz = ((String)((Map)localObject1).get((String)localObject3 + ".play_url"));
      ((v)localObject2).iAA = ((String)((Map)localObject1).get((String)localObject3 + ".player"));
      ((v)localObject2).iAB = Util.getInt((String)((Map)localObject1).get((String)localObject3 + ".music_source"), 1);
      ((v)localObject2).iAC = Util.getInt((String)((Map)localObject1).get((String)localObject3 + ".pic_num"), 1);
      ((v)localObject2).videoWidth = Util.getInt((String)((Map)localObject1).get((String)localObject3 + ".video_width"), 0);
      ((v)localObject2).videoHeight = Util.getInt((String)((Map)localObject1).get((String)localObject3 + ".video_height"), 0);
      ((v)localObject2).iwf = Util.getInt((String)((Map)localObject1).get((String)localObject3 + ".is_pay_subscribe"), 0);
      ((v)localObject2).iAH = Util.getLong((String)((Map)localObject1).get((String)localObject3 + ".comment_topic_id"), 0L);
      ((v)localObject2).vid = ((String)((Map)localObject1).get((String)localObject3 + ".vid"));
      localu.iAd.add(localObject2);
      i += 1;
    }
    localu.iwz = k.E((Map)localObject1);
    paramString = Util.nullAsNil((String)((Map)localObject1).get(".msg.fromusername"));
    if (!Util.isNullOrNil(paramString))
    {
      localObject1 = ((l)g.af(l.class)).aSN().Kn(paramString).arI();
      localu.eag = paramString;
      localu.eah = ((String)localObject1);
    }
    if (paramLong > 0L)
    {
      gAU.x(Long.valueOf(paramLong), localu);
      izR.put(Long.valueOf(paramLong), Integer.valueOf(k));
    }
    AppMethodBeat.o(123941);
    return localu;
  }
  
  public static amt a(v paramv, anq paramanq, String paramString1, String paramString2)
  {
    AppMethodBeat.i(123946);
    if ((paramv == null) || (paramv.type == -1))
    {
      AppMethodBeat.o(123946);
      return null;
    }
    amt localamt = new amt();
    if (paramv.type == 5) {}
    for (int i = 1;; i = 0)
    {
      localamt.iwe = i;
      localamt.iwc = paramv.type;
      localamt.iwf = paramv.iwf;
      localamt.vid = paramv.vid;
      localamt.videoWidth = paramv.videoWidth;
      localamt.videoHeight = paramv.videoHeight;
      localamt.duration = paramv.iAs;
      localamt.iwd = ((int)paramv.time);
      localamt.dHc = paramString1;
      localamt.iAg = paramString2;
      localamt.iAo = paramv.iAo;
      paramanq.bhs(paramv.title);
      paramanq.bht(paramv.iAq);
      AppMethodBeat.o(123946);
      return localamt;
    }
  }
  
  public static amt a(ca paramca, anq paramanq)
  {
    AppMethodBeat.i(123944);
    if (paramca == null)
    {
      AppMethodBeat.o(123944);
      return null;
    }
    if ((paramca.dOQ()) && (!paramca.gAt()))
    {
      paramca = k.b.aD(paramca.field_content, paramca.field_reserved);
      if (paramca == null)
      {
        AppMethodBeat.o(123944);
        return null;
      }
      e locale = (e)paramca.as(e.class);
      if ((locale == null) || ((locale.iwc == -1) && (locale.iwj != 1)))
      {
        AppMethodBeat.o(123944);
        return null;
      }
      amt localamt = new amt();
      localamt.iwe = locale.iwe;
      localamt.iwc = locale.iwc;
      localamt.iwf = locale.iwf;
      localamt.vid = locale.vid;
      localamt.videoWidth = locale.videoWidth;
      localamt.videoHeight = locale.videoHeight;
      localamt.duration = locale.duration;
      localamt.iwd = locale.iwd;
      localamt.iAo = paramca.thumburl;
      localamt.dHc = paramca.eag;
      localamt.iAg = paramca.eah;
      paramanq.bhs(paramca.title);
      paramanq.bht(paramca.description);
      AppMethodBeat.o(123944);
      return localamt;
    }
    AppMethodBeat.o(123944);
    return null;
  }
  
  public static String a(Context paramContext, int paramInt, String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(123949);
    if (paramContext == null)
    {
      Log.w("MicroMsg.AppMsgBizHelper", "getReaderAppMsgContent: context is null");
      AppMethodBeat.o(123949);
      return null;
    }
    if ((paramString1 == null) || (paramString2 == null))
    {
      Log.w("MicroMsg.AppMsgBizHelper", "getReaderAppMsgContent: msg is null");
      AppMethodBeat.o(123949);
      return null;
    }
    g.aAi();
    if (!g.aAh().isSDCardAvailable())
    {
      com.tencent.mm.ui.base.u.g(paramContext, null);
      AppMethodBeat.o(123949);
      return null;
    }
    try
    {
      paramString1 = ((a)g.af(a.class)).a(paramLong, paramString1);
      paramContext = paramString1.iAd;
      if ((paramContext != null) && (paramContext.size() > 0) && (paramInt < paramContext.size()))
      {
        v localv = (v)paramContext.get(paramInt);
        paramContext = new k.b();
        paramContext.title = localv.title;
        paramContext.description = localv.iAq;
        paramContext.action = "view";
        paramContext.type = 5;
        paramContext.url = localv.url;
        paramContext.eag = paramString1.eag;
        paramContext.eah = paramString1.eah;
        paramContext.fQR = paramString1.fQR;
        paramContext.thumburl = a(localv);
        paramString1 = new e();
        paramString1.iwc = localv.type;
        paramString1.iwf = localv.iwf;
        if (localv.type == 5)
        {
          paramString1.vid = localv.vid;
          paramString1.iwd = ((int)localv.time);
          paramString1.duration = localv.iAs;
          paramString1.videoWidth = localv.videoWidth;
          paramString1.videoHeight = localv.videoHeight;
        }
        paramContext.a(paramString1);
        if (Util.isNullOrNil(paramContext.thumburl))
        {
          paramString1 = p.aYB().Mx(paramString2);
          if (paramString1 != null) {
            paramContext.thumburl = paramString1.aYt();
          }
        }
        paramContext = k.b.a(paramContext, null, null);
        AppMethodBeat.o(123949);
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace("MicroMsg.AppMsgBizHelper", paramContext, "", new Object[0]);
      Log.e("MicroMsg.AppMsgBizHelper", "retransmit app msg error : %s", new Object[] { paramContext.getLocalizedMessage() });
      AppMethodBeat.o(123949);
    }
    return null;
  }
  
  public static String a(v paramv)
  {
    AppMethodBeat.i(123943);
    if (paramv.type == 5)
    {
      if (Util.isNullOrNil(paramv.iAo))
      {
        paramv = paramv.iAD;
        AppMethodBeat.o(123943);
        return paramv;
      }
      paramv = paramv.iAo;
      AppMethodBeat.o(123943);
      return paramv;
    }
    if (Util.isNullOrNil(paramv.iAD))
    {
      paramv = paramv.iAo;
      AppMethodBeat.o(123943);
      return paramv;
    }
    paramv = paramv.iAD;
    AppMethodBeat.o(123943);
    return paramv;
  }
  
  public static String aE(String paramString1, String paramString2)
  {
    Object localObject = null;
    AppMethodBeat.i(123937);
    paramString1 = XmlParser.parseXml(paramString1, "msg", null);
    if (paramString1 == null)
    {
      Log.e("MicroMsg.AppMsgBizHelper", "getAppMsgDyeingTempFromUser fail, values is null");
      paramString1 = localObject;
      if ((!Util.isNullOrNil(paramString1)) || (com.tencent.mm.model.ab.Js(paramString2))) {
        break label192;
      }
    }
    for (;;)
    {
      if (!Util.isNullOrNil(paramString2))
      {
        if (HF(paramString2))
        {
          paramString1 = ((q)g.af(q.class)).Xk(paramString2);
          if ((paramString1 != null) && (!TextUtils.isEmpty(paramString1.field_nickname)))
          {
            paramString1 = paramString1.field_nickname;
            AppMethodBeat.o(123937);
            return paramString1;
            paramString1 = (String)paramString1.get(".msg.fromusername");
            break;
          }
        }
        paramString1 = ((l)g.af(l.class)).aSN().Kn(paramString2);
        if ((paramString1 == null) || ((int)paramString1.gMZ <= 0))
        {
          AppMethodBeat.o(123937);
          return "";
        }
        paramString1 = ((b)g.af(b.class)).getDisplayName(paramString2);
        AppMethodBeat.o(123937);
        return paramString1;
      }
      AppMethodBeat.o(123937);
      return "";
      label192:
      paramString2 = paramString1;
    }
  }
  
  public static int ape()
  {
    AppMethodBeat.i(123951);
    Context localContext = MMApplicationContext.getContext();
    if (NetStatusUtil.isNetworkConnected(localContext))
    {
      if (NetStatusUtil.is2G(localContext))
      {
        AppMethodBeat.o(123951);
        return 2;
      }
      if (NetStatusUtil.is3G(localContext))
      {
        AppMethodBeat.o(123951);
        return 3;
      }
      if (NetStatusUtil.is4G(localContext))
      {
        AppMethodBeat.o(123951);
        return 4;
      }
      if (NetStatusUtil.is5G(localContext))
      {
        AppMethodBeat.o(123951);
        return 5;
      }
      if (NetStatusUtil.isWifi(localContext))
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
  
  public static int b(long paramLong, String paramString)
  {
    AppMethodBeat.i(123942);
    if (paramLong > 0L)
    {
      Integer localInteger = (Integer)izR.get(Long.valueOf(paramLong));
      if (localInteger != null)
      {
        i = localInteger.intValue();
        AppMethodBeat.o(123942);
        return i;
      }
    }
    paramString = SemiXml.decode(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(123942);
      return 0;
    }
    paramString = Integer.valueOf(Util.getInt((String)paramString.get(".msg.appmsg.mmreader.category.$count"), 0));
    if (paramLong > 0L) {
      izR.put(Long.valueOf(paramLong), paramString);
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
    paramString = ((a)g.af(a.class)).a(paramLong, paramString);
    if (paramString == null)
    {
      Log.w("MicroMsg.AppMsgBizHelper", "isBizMsgForbidForward reader is null");
      AppMethodBeat.o(123948);
      return false;
    }
    if (paramString.iAe == 1)
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
    int j = com.tencent.mm.storage.ab.getSessionId();
    if ((paramString == null) || (!paramString.contains(WeChatHosts.domainString(2131761726))) || ((j <= 0) && (paramInt2 < 0) && (paramInt1 < 0) && (paramInt3 <= 0)))
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
  
  public static String rJ(int paramInt)
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
  
  public static amt v(ca paramca)
  {
    AppMethodBeat.i(123945);
    if (paramca == null)
    {
      AppMethodBeat.o(123945);
      return null;
    }
    if (paramca.cWK())
    {
      paramca = k.b.aD(paramca.field_content, paramca.field_reserved);
      if (paramca == null)
      {
        AppMethodBeat.o(123945);
        return null;
      }
      e locale = (e)paramca.as(e.class);
      if ((locale == null) || (locale.iwi == null))
      {
        AppMethodBeat.o(123945);
        return null;
      }
      amt localamt = new amt();
      localamt.dHc = paramca.eag;
      localamt.iAg = paramca.eah;
      localamt.KOe = locale.iwi.KOe;
      localamt.videoUrl = locale.iwi.videoUrl;
      localamt.vid = locale.iwi.KOf;
      localamt.iAo = locale.iwi.iAo;
      localamt.videoWidth = locale.iwi.width;
      localamt.videoHeight = locale.iwi.height;
      localamt.duration = locale.iwi.videoDuration;
      AppMethodBeat.o(123945);
      return localamt;
    }
    AppMethodBeat.o(123945);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ag.m
 * JD-Core Version:    0.7.0.1
 */