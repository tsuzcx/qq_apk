package com.tencent.mm.ah;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.p;
import com.tencent.mm.b.f;
import com.tencent.mm.b.h;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.protobuf.ahf;
import com.tencent.mm.protocal.protobuf.aic;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bo;
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
  private static final f<Long, u> fAs;
  private static final ConcurrentHashMap<Long, Integer> hkH;
  
  static
  {
    AppMethodBeat.i(123952);
    fAs = new h(50);
    hkH = new ConcurrentHashMap(50);
    AppMethodBeat.o(123952);
  }
  
  public static int Yu()
  {
    AppMethodBeat.i(123951);
    Context localContext = com.tencent.mm.sdk.platformtools.ai.getContext();
    if (ax.isNetworkConnected(localContext))
    {
      if (ax.is2G(localContext))
      {
        AppMethodBeat.o(123951);
        return 2;
      }
      if (ax.is3G(localContext))
      {
        AppMethodBeat.o(123951);
        return 3;
      }
      if (ax.is4G(localContext))
      {
        AppMethodBeat.o(123951);
        return 4;
      }
      if (ax.isWifi(localContext))
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
      localu = (u)fAs.get(Long.valueOf(paramLong));
      if (localu != null)
      {
        AppMethodBeat.o(123941);
        return localu;
      }
    }
    Object localObject1 = bi.aLg(paramString);
    if (localObject1 == null)
    {
      paramString = new u();
      AppMethodBeat.o(123941);
      return paramString;
    }
    int i = bs.getInt((String)((Map)localObject1).get(".msg.appmsg.mmreader.category.$type"), 0);
    paramString = bs.nullAsNil((String)((Map)localObject1).get(".msg.appmsg.mmreader.name"));
    int j = bs.getInt((String)((Map)localObject1).get(".msg.appmsg.mmreader.forbid_forward"), 0);
    int k = bs.getInt((String)((Map)localObject1).get(".msg.appmsg.mmreader.category.$count"), 0);
    Object localObject2 = (String)((Map)localObject1).get(".msg.commenturl");
    u localu = new u();
    localu.type = i;
    localu.name = paramString;
    localu.eSb = ((String)localObject2);
    localu.hkT = j;
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
        ((v)localObject2).hlb = ((String)((Map)localObject1).get((String)localObject3 + ".shorturl"));
        ((v)localObject2).hlc = ((String)((Map)localObject1).get((String)localObject3 + ".longurl"));
        ((v)localObject2).time = bs.getLong((String)((Map)localObject1).get((String)localObject3 + ".pub_time"), 0L);
        ((v)localObject2).hle = ((String)((Map)localObject1).get((String)localObject3 + ".tweetid"));
        ((v)localObject2).hlf = ((String)((Map)localObject1).get((String)localObject3 + ".digest"));
        ((v)localObject2).type = bs.getInt((String)((Map)localObject1).get((String)localObject3 + ".itemshowtype"), 0);
        ((v)localObject2).hlh = bs.getInt((String)((Map)localObject1).get((String)localObject3 + ".play_length"), 0);
        ((v)localObject2).hld = ((String)((Map)localObject1).get((String)localObject3 + ".cover"));
        paramString = (String)((Map)localObject1).get((String)localObject3 + ".cover_235_1");
        localObject4 = (String)((Map)localObject1).get((String)localObject3 + ".cover_16_9");
        if (((((v)localObject2).type != 5) && (!bs.isNullOrNil(paramString))) || (bs.isNullOrNil(((v)localObject2).hld))) {
          ((v)localObject2).hld = paramString;
        }
        if ((((v)localObject2).type == 5) && (!bs.isNullOrNil((String)localObject4))) {
          ((v)localObject2).hld = ((String)localObject4);
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
        if (bs.isNullOrNil(paramString)) {
          break label813;
        }
        ((v)localObject2).hlv.add(paramString);
        j += 1;
        break label716;
        paramString = String.valueOf(i);
        break;
      }
      label813:
      if (((v)localObject2).hlv.size() == 0) {
        ((v)localObject2).hlv.add(((v)localObject2).hld);
      }
      ((v)localObject2).hlu = ((String)((Map)localObject1).get((String)localObject3 + ".cover_1_1"));
      ((v)localObject2).hlg = bs.getInt((String)((Map)localObject1).get((String)localObject3 + ".del_flag"), 0);
      ((v)localObject2).hli = ((String)((Map)localObject1).get((String)localObject3 + ".weapp_username"));
      ((v)localObject2).hlj = ((String)((Map)localObject1).get((String)localObject3 + ".weapp_path"));
      ((v)localObject2).hlk = bs.getInt((String)((Map)localObject1).get((String)localObject3 + ".weapp_version"), 0);
      ((v)localObject2).hll = bs.getInt((String)((Map)localObject1).get((String)localObject3 + ".weapp_state"), 0);
      ((v)localObject2).hlm = ((String)((Map)localObject1).get((String)localObject3 + ".weapp_appid"));
      ((v)localObject2).hln = ((String)((Map)localObject1).get((String)localObject3 + ".weapp_image_url"));
      ((v)localObject2).hlo = ((String)((Map)localObject1).get((String)localObject3 + ".weapp_icon"));
      ((v)localObject2).hlp = ((String)((Map)localObject1).get((String)localObject3 + ".weapp_nickname"));
      ((v)localObject2).hlq = ((String)((Map)localObject1).get((String)localObject3 + ".play_url"));
      ((v)localObject2).hlr = ((String)((Map)localObject1).get((String)localObject3 + ".player"));
      ((v)localObject2).hls = bs.getInt((String)((Map)localObject1).get((String)localObject3 + ".music_source"), 1);
      ((v)localObject2).hlt = bs.getInt((String)((Map)localObject1).get((String)localObject3 + ".pic_num"), 1);
      ((v)localObject2).videoWidth = bs.getInt((String)((Map)localObject1).get((String)localObject3 + ".video_width"), 0);
      ((v)localObject2).videoHeight = bs.getInt((String)((Map)localObject1).get((String)localObject3 + ".video_height"), 0);
      ((v)localObject2).hhb = bs.getInt((String)((Map)localObject1).get((String)localObject3 + ".is_pay_subscribe"), 0);
      ((v)localObject2).hhd = ((String)((Map)localObject1).get((String)localObject3 + ".vid"));
      localu.hkS.add(localObject2);
      i += 1;
    }
    localu.hhw = com.tencent.mm.al.j.u((Map)localObject1);
    paramString = bs.nullAsNil((String)((Map)localObject1).get(".msg.fromusername"));
    if (!bs.isNullOrNil(paramString))
    {
      localObject1 = ((k)g.ab(k.class)).awB().aNt(paramString).aaR();
      localu.dvl = paramString;
      localu.dvm = ((String)localObject1);
    }
    if (paramLong > 0L)
    {
      fAs.o(Long.valueOf(paramLong), localu);
      hkH.put(Long.valueOf(paramLong), Integer.valueOf(k));
    }
    AppMethodBeat.o(123941);
    return localu;
  }
  
  public static ahf a(v paramv, aic paramaic, String paramString1, String paramString2)
  {
    AppMethodBeat.i(123946);
    if ((paramv == null) || (paramv.type == -1))
    {
      AppMethodBeat.o(123946);
      return null;
    }
    ahf localahf = new ahf();
    if (paramv.type == 5) {}
    for (int i = 1;; i = 0)
    {
      localahf.hha = i;
      localahf.hgY = paramv.type;
      localahf.hhb = paramv.hhb;
      localahf.hhd = paramv.hhd;
      localahf.videoWidth = paramv.videoWidth;
      localahf.videoHeight = paramv.videoHeight;
      localahf.duration = paramv.hlh;
      localahf.hgZ = ((int)paramv.time);
      localahf.ddo = paramString1;
      localahf.hkV = paramString2;
      localahf.hld = paramv.hld;
      paramaic.aJP(paramv.title);
      paramaic.aJQ(paramv.hlf);
      AppMethodBeat.o(123946);
      return localahf;
    }
  }
  
  public static ahf a(bo parambo, aic paramaic)
  {
    AppMethodBeat.i(123944);
    if (parambo == null)
    {
      AppMethodBeat.o(123944);
      return null;
    }
    if ((parambo.cKN()) && (!parambo.eZj()))
    {
      parambo = k.b.az(parambo.field_content, parambo.field_reserved);
      if (parambo == null)
      {
        AppMethodBeat.o(123944);
        return null;
      }
      e locale = (e)parambo.ao(e.class);
      if ((locale == null) || ((locale.hgY == -1) && (locale.hhg != 1)))
      {
        AppMethodBeat.o(123944);
        return null;
      }
      ahf localahf = new ahf();
      localahf.hha = locale.hha;
      localahf.hgY = locale.hgY;
      localahf.hhb = locale.hhb;
      localahf.hhd = locale.hhd;
      localahf.videoWidth = locale.videoWidth;
      localahf.videoHeight = locale.videoHeight;
      localahf.duration = locale.duration;
      localahf.hgZ = locale.hgZ;
      localahf.hld = parambo.thumburl;
      localahf.ddo = parambo.dvl;
      localahf.hkV = parambo.dvm;
      paramaic.aJP(parambo.title);
      paramaic.aJQ(parambo.description);
      AppMethodBeat.o(123944);
      return localahf;
    }
    AppMethodBeat.o(123944);
    return null;
  }
  
  public static String a(Context paramContext, int paramInt, String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(123949);
    if (paramContext == null)
    {
      ac.w("MicroMsg.AppMsgBizHelper", "getReaderAppMsgContent: context is null");
      AppMethodBeat.o(123949);
      return null;
    }
    if ((paramString1 == null) || (paramString2 == null))
    {
      ac.w("MicroMsg.AppMsgBizHelper", "getReaderAppMsgContent: msg is null");
      AppMethodBeat.o(123949);
      return null;
    }
    g.agS();
    if (!g.agR().isSDCardAvailable())
    {
      t.g(paramContext, null);
      AppMethodBeat.o(123949);
      return null;
    }
    try
    {
      paramString1 = ((a)g.ab(a.class)).a(paramLong, paramString1);
      paramContext = paramString1.hkS;
      if ((paramContext != null) && (paramContext.size() > 0) && (paramInt < paramContext.size()))
      {
        v localv = (v)paramContext.get(paramInt);
        paramContext = new k.b();
        paramContext.title = localv.title;
        paramContext.description = localv.hlf;
        paramContext.action = "view";
        paramContext.type = 5;
        paramContext.url = localv.url;
        paramContext.dvl = paramString1.dvl;
        paramContext.dvm = paramString1.dvm;
        paramContext.eSb = paramString1.eSb;
        paramContext.thumburl = a(localv);
        paramString1 = new e();
        paramString1.hgY = localv.type;
        paramString1.hhb = localv.hhb;
        if (localv.type == 5)
        {
          paramString1.hhd = localv.hhd;
          paramString1.hgZ = ((int)localv.time);
          paramString1.duration = localv.hlh;
          paramString1.videoWidth = localv.videoWidth;
          paramString1.videoHeight = localv.videoHeight;
        }
        paramContext.a(paramString1);
        if (bs.isNullOrNil(paramContext.thumburl))
        {
          paramString1 = p.aBw().Ak(paramString2);
          if (paramString1 != null) {
            paramContext.thumburl = paramString1.aBo();
          }
        }
        paramContext = k.b.a(paramContext, null, null);
        AppMethodBeat.o(123949);
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      ac.printErrStackTrace("MicroMsg.AppMsgBizHelper", paramContext, "", new Object[0]);
      ac.e("MicroMsg.AppMsgBizHelper", "retransmit app msg error : %s", new Object[] { paramContext.getLocalizedMessage() });
      AppMethodBeat.o(123949);
    }
    return null;
  }
  
  public static String a(v paramv)
  {
    AppMethodBeat.i(123943);
    if (paramv.type == 5)
    {
      if (bs.isNullOrNil(paramv.hld))
      {
        paramv = paramv.hlu;
        AppMethodBeat.o(123943);
        return paramv;
      }
      paramv = paramv.hld;
      AppMethodBeat.o(123943);
      return paramv;
    }
    if (bs.isNullOrNil(paramv.hlu))
    {
      paramv = paramv.hld;
      AppMethodBeat.o(123943);
      return paramv;
    }
    paramv = paramv.hlu;
    AppMethodBeat.o(123943);
    return paramv;
  }
  
  public static String aA(String paramString1, String paramString2)
  {
    AppMethodBeat.i(123937);
    paramString1 = bv.L(paramString1, "msg");
    if (paramString1 == null)
    {
      ac.e("MicroMsg.AppMsgBizHelper", "getAppMsgDyeingTempFromUser fail, values is null");
      paramString1 = null;
      if ((!bs.isNullOrNil(paramString1)) || (w.xg(paramString2))) {
        break label191;
      }
    }
    for (;;)
    {
      if (!bs.isNullOrNil(paramString2))
      {
        if (vC(paramString2))
        {
          paramString1 = ((com.tencent.mm.plugin.appbrand.service.m)g.ab(com.tencent.mm.plugin.appbrand.service.m.class)).Ka(paramString2);
          if ((paramString1 != null) && (!TextUtils.isEmpty(paramString1.field_nickname)))
          {
            paramString1 = paramString1.field_nickname;
            AppMethodBeat.o(123937);
            return paramString1;
            paramString1 = (String)paramString1.get(".msg.fromusername");
            break;
          }
        }
        paramString1 = ((k)g.ab(k.class)).awB().aNt(paramString2);
        if ((paramString1 == null) || ((int)paramString1.fLJ <= 0))
        {
          AppMethodBeat.o(123937);
          return "";
        }
        paramString1 = ((com.tencent.mm.plugin.messenger.a.b)g.ab(com.tencent.mm.plugin.messenger.a.b.class)).wk(paramString2);
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
      Integer localInteger = (Integer)hkH.get(Long.valueOf(paramLong));
      if (localInteger != null)
      {
        i = localInteger.intValue();
        AppMethodBeat.o(123942);
        return i;
      }
    }
    paramString = bi.aLg(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(123942);
      return 0;
    }
    paramString = Integer.valueOf(bs.getInt((String)paramString.get(".msg.appmsg.mmreader.category.$count"), 0));
    if (paramLong > 0L) {
      hkH.put(Long.valueOf(paramLong), paramString);
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
      ac.w("MicroMsg.AppMsgBizHelper", "isBizMsgForbidForward reader is null");
      AppMethodBeat.o(123948);
      return false;
    }
    if (paramString.hkT == 1)
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
    int j = com.tencent.mm.storage.v.getSessionId();
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
  
  public static String nJ(int paramInt)
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
  
  public static ahf t(bo parambo)
  {
    AppMethodBeat.i(123945);
    if (parambo == null)
    {
      AppMethodBeat.o(123945);
      return null;
    }
    if (parambo.cru())
    {
      parambo = k.b.az(parambo.field_content, parambo.field_reserved);
      if (parambo == null)
      {
        AppMethodBeat.o(123945);
        return null;
      }
      e locale = (e)parambo.ao(e.class);
      if ((locale == null) || (locale.hhf == null))
      {
        AppMethodBeat.o(123945);
        return null;
      }
      ahf localahf = new ahf();
      localahf.ddo = parambo.dvl;
      localahf.hkV = parambo.dvm;
      localahf.DWF = locale.hhf.DWF;
      localahf.videoUrl = locale.hhf.videoUrl;
      localahf.hhd = locale.hhf.DWG;
      localahf.hld = locale.hhf.hld;
      localahf.videoWidth = locale.hhf.width;
      localahf.videoHeight = locale.hhf.height;
      localahf.duration = locale.hhf.videoDuration;
      AppMethodBeat.o(123945);
      return localahf;
    }
    AppMethodBeat.o(123945);
    return null;
  }
  
  public static boolean vC(String paramString)
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
  
  public static String vD(String paramString)
  {
    AppMethodBeat.i(123939);
    Map localMap = bv.L(paramString, "msg");
    if (localMap == null)
    {
      ac.e("MicroMsg.AppMsgBizHelper", "getAppMsgDyeingTempTitle fail, values is null");
      AppMethodBeat.o(123939);
      return " ";
    }
    bs.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_show_type"), 0);
    bs.bG((String)localMap.get(".msg.appmsg.ext_pay_info.pay_type"), "");
    String str = bs.nullAsNil((String)localMap.get(".msg.appmsg.title"));
    paramString = str;
    if (bs.isNullOrNil(str)) {
      paramString = (String)localMap.get(".msg.appmsg.mmreader.category.item.title");
    }
    str = paramString;
    if (bs.isNullOrNil(paramString)) {
      str = " ";
    }
    AppMethodBeat.o(123939);
    return str;
  }
  
  public static String vE(String paramString)
  {
    AppMethodBeat.i(123940);
    paramString = bi.aLg(paramString);
    if (paramString == null)
    {
      Object localObject = new u();
      paramString = new StringBuilder("");
      localObject = ((u)localObject).hkS.iterator();
      while (((Iterator)localObject).hasNext())
      {
        v localv = (v)((Iterator)localObject).next();
        if (!bs.isNullOrNil(localv.title)) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ah.m
 * JD-Core Version:    0.7.0.1
 */