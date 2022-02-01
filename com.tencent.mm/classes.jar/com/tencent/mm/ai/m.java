package com.tencent.mm.ai;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.am.k;
import com.tencent.mm.b.f;
import com.tencent.mm.b.h;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.ajv;
import com.tencent.mm.protocal.protobuf.aks;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu;
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
  private static final f<Long, u> fTI;
  private static final ConcurrentHashMap<Long, Integer> hCQ;
  
  static
  {
    AppMethodBeat.i(123952);
    fTI = new h(50);
    hCQ = new ConcurrentHashMap(50);
    AppMethodBeat.o(123952);
  }
  
  public static u a(long paramLong, String paramString)
  {
    AppMethodBeat.i(123941);
    if (paramLong > 0L)
    {
      localu = (u)fTI.get(Long.valueOf(paramLong));
      if (localu != null)
      {
        AppMethodBeat.o(123941);
        return localu;
      }
    }
    Object localObject1 = bj.aQM(paramString);
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
    localu.fkq = ((String)localObject2);
    localu.hDc = j;
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
        ((v)localObject2).hDk = ((String)((Map)localObject1).get((String)localObject3 + ".shorturl"));
        ((v)localObject2).hDl = ((String)((Map)localObject1).get((String)localObject3 + ".longurl"));
        ((v)localObject2).time = bt.getLong((String)((Map)localObject1).get((String)localObject3 + ".pub_time"), 0L);
        ((v)localObject2).hDn = ((String)((Map)localObject1).get((String)localObject3 + ".tweetid"));
        ((v)localObject2).hDo = ((String)((Map)localObject1).get((String)localObject3 + ".digest"));
        ((v)localObject2).type = bt.getInt((String)((Map)localObject1).get((String)localObject3 + ".itemshowtype"), 0);
        ((v)localObject2).hDq = bt.getInt((String)((Map)localObject1).get((String)localObject3 + ".play_length"), 0);
        ((v)localObject2).hDm = ((String)((Map)localObject1).get((String)localObject3 + ".cover"));
        paramString = (String)((Map)localObject1).get((String)localObject3 + ".cover_235_1");
        localObject4 = (String)((Map)localObject1).get((String)localObject3 + ".cover_16_9");
        if (((((v)localObject2).type != 5) && (!bt.isNullOrNil(paramString))) || (bt.isNullOrNil(((v)localObject2).hDm))) {
          ((v)localObject2).hDm = paramString;
        }
        if ((((v)localObject2).type == 5) && (!bt.isNullOrNil((String)localObject4))) {
          ((v)localObject2).hDm = ((String)localObject4);
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
        if (bt.isNullOrNil(paramString)) {
          break label813;
        }
        ((v)localObject2).hDE.add(paramString);
        j += 1;
        break label716;
        paramString = String.valueOf(i);
        break;
      }
      label813:
      if (((v)localObject2).hDE.size() == 0) {
        ((v)localObject2).hDE.add(((v)localObject2).hDm);
      }
      ((v)localObject2).hDD = ((String)((Map)localObject1).get((String)localObject3 + ".cover_1_1"));
      ((v)localObject2).hDp = bt.getInt((String)((Map)localObject1).get((String)localObject3 + ".del_flag"), 0);
      ((v)localObject2).hDr = ((String)((Map)localObject1).get((String)localObject3 + ".weapp_username"));
      ((v)localObject2).hDs = ((String)((Map)localObject1).get((String)localObject3 + ".weapp_path"));
      ((v)localObject2).hDt = bt.getInt((String)((Map)localObject1).get((String)localObject3 + ".weapp_version"), 0);
      ((v)localObject2).hDu = bt.getInt((String)((Map)localObject1).get((String)localObject3 + ".weapp_state"), 0);
      ((v)localObject2).hDv = ((String)((Map)localObject1).get((String)localObject3 + ".weapp_appid"));
      ((v)localObject2).hDw = ((String)((Map)localObject1).get((String)localObject3 + ".weapp_image_url"));
      ((v)localObject2).hDx = ((String)((Map)localObject1).get((String)localObject3 + ".weapp_icon"));
      ((v)localObject2).hDy = ((String)((Map)localObject1).get((String)localObject3 + ".weapp_nickname"));
      ((v)localObject2).hDz = ((String)((Map)localObject1).get((String)localObject3 + ".play_url"));
      ((v)localObject2).hDA = ((String)((Map)localObject1).get((String)localObject3 + ".player"));
      ((v)localObject2).hDB = bt.getInt((String)((Map)localObject1).get((String)localObject3 + ".music_source"), 1);
      ((v)localObject2).hDC = bt.getInt((String)((Map)localObject1).get((String)localObject3 + ".pic_num"), 1);
      ((v)localObject2).videoWidth = bt.getInt((String)((Map)localObject1).get((String)localObject3 + ".video_width"), 0);
      ((v)localObject2).videoHeight = bt.getInt((String)((Map)localObject1).get((String)localObject3 + ".video_height"), 0);
      ((v)localObject2).hzk = bt.getInt((String)((Map)localObject1).get((String)localObject3 + ".is_pay_subscribe"), 0);
      ((v)localObject2).hzm = ((String)((Map)localObject1).get((String)localObject3 + ".vid"));
      localu.hDb.add(localObject2);
      i += 1;
    }
    localu.hzF = k.v((Map)localObject1);
    paramString = bt.nullAsNil((String)((Map)localObject1).get(".msg.fromusername"));
    if (!bt.isNullOrNil(paramString))
    {
      localObject1 = ((l)g.ab(l.class)).azp().Bf(paramString).adu();
      localu.dHo = paramString;
      localu.dHp = ((String)localObject1);
    }
    if (paramLong > 0L)
    {
      fTI.q(Long.valueOf(paramLong), localu);
      hCQ.put(Long.valueOf(paramLong), Integer.valueOf(k));
    }
    AppMethodBeat.o(123941);
    return localu;
  }
  
  public static ajv a(v paramv, aks paramaks, String paramString1, String paramString2)
  {
    AppMethodBeat.i(123946);
    if ((paramv == null) || (paramv.type == -1))
    {
      AppMethodBeat.o(123946);
      return null;
    }
    ajv localajv = new ajv();
    if (paramv.type == 5) {}
    for (int i = 1;; i = 0)
    {
      localajv.hzj = i;
      localajv.hzh = paramv.type;
      localajv.hzk = paramv.hzk;
      localajv.hzm = paramv.hzm;
      localajv.videoWidth = paramv.videoWidth;
      localajv.videoHeight = paramv.videoHeight;
      localajv.duration = paramv.hDq;
      localajv.hzi = ((int)paramv.time);
      localajv.doK = paramString1;
      localajv.hDe = paramString2;
      localajv.hDm = paramv.hDm;
      paramaks.aPs(paramv.title);
      paramaks.aPt(paramv.hDo);
      AppMethodBeat.o(123946);
      return localajv;
    }
  }
  
  public static ajv a(bu parambu, aks paramaks)
  {
    AppMethodBeat.i(123944);
    if (parambu == null)
    {
      AppMethodBeat.o(123944);
      return null;
    }
    if ((parambu.cTc()) && (!parambu.fpd()))
    {
      parambu = k.b.aA(parambu.field_content, parambu.field_reserved);
      if (parambu == null)
      {
        AppMethodBeat.o(123944);
        return null;
      }
      e locale = (e)parambu.ao(e.class);
      if ((locale == null) || ((locale.hzh == -1) && (locale.hzp != 1)))
      {
        AppMethodBeat.o(123944);
        return null;
      }
      ajv localajv = new ajv();
      localajv.hzj = locale.hzj;
      localajv.hzh = locale.hzh;
      localajv.hzk = locale.hzk;
      localajv.hzm = locale.hzm;
      localajv.videoWidth = locale.videoWidth;
      localajv.videoHeight = locale.videoHeight;
      localajv.duration = locale.duration;
      localajv.hzi = locale.hzi;
      localajv.hDm = parambu.thumburl;
      localajv.doK = parambu.dHo;
      localajv.hDe = parambu.dHp;
      paramaks.aPs(parambu.title);
      paramaks.aPt(parambu.description);
      AppMethodBeat.o(123944);
      return localajv;
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
    g.ajD();
    if (!g.ajC().isSDCardAvailable())
    {
      t.g(paramContext, null);
      AppMethodBeat.o(123949);
      return null;
    }
    try
    {
      paramString1 = ((a)g.ab(a.class)).a(paramLong, paramString1);
      paramContext = paramString1.hDb;
      if ((paramContext != null) && (paramContext.size() > 0) && (paramInt < paramContext.size()))
      {
        v localv = (v)paramContext.get(paramInt);
        paramContext = new k.b();
        paramContext.title = localv.title;
        paramContext.description = localv.hDo;
        paramContext.action = "view";
        paramContext.type = 5;
        paramContext.url = localv.url;
        paramContext.dHo = paramString1.dHo;
        paramContext.dHp = paramString1.dHp;
        paramContext.fkq = paramString1.fkq;
        paramContext.thumburl = a(localv);
        paramString1 = new e();
        paramString1.hzh = localv.type;
        paramString1.hzk = localv.hzk;
        if (localv.type == 5)
        {
          paramString1.hzm = localv.hzm;
          paramString1.hzi = ((int)localv.time);
          paramString1.duration = localv.hDq;
          paramString1.videoWidth = localv.videoWidth;
          paramString1.videoHeight = localv.videoHeight;
        }
        paramContext.a(paramString1);
        if (bt.isNullOrNil(paramContext.thumburl))
        {
          paramString1 = p.aEx().Dj(paramString2);
          if (paramString1 != null) {
            paramContext.thumburl = paramString1.aEq();
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
      if (bt.isNullOrNil(paramv.hDm))
      {
        paramv = paramv.hDD;
        AppMethodBeat.o(123943);
        return paramv;
      }
      paramv = paramv.hDm;
      AppMethodBeat.o(123943);
      return paramv;
    }
    if (bt.isNullOrNil(paramv.hDD))
    {
      paramv = paramv.hDm;
      AppMethodBeat.o(123943);
      return paramv;
    }
    paramv = paramv.hDD;
    AppMethodBeat.o(123943);
    return paramv;
  }
  
  public static String aB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(123937);
    paramString1 = bw.M(paramString1, "msg");
    if (paramString1 == null)
    {
      ad.e("MicroMsg.AppMsgBizHelper", "getAppMsgDyeingTempFromUser fail, values is null");
      paramString1 = null;
      if ((!bt.isNullOrNil(paramString1)) || (w.Ad(paramString2))) {
        break label191;
      }
    }
    for (;;)
    {
      if (!bt.isNullOrNil(paramString2))
      {
        if (yt(paramString2))
        {
          paramString1 = ((n)g.ab(n.class)).Nt(paramString2);
          if ((paramString1 != null) && (!TextUtils.isEmpty(paramString1.field_nickname)))
          {
            paramString1 = paramString1.field_nickname;
            AppMethodBeat.o(123937);
            return paramString1;
            paramString1 = (String)paramString1.get(".msg.fromusername");
            break;
          }
        }
        paramString1 = ((l)g.ab(l.class)).azp().Bf(paramString2);
        if ((paramString1 == null) || ((int)paramString1.gfj <= 0))
        {
          AppMethodBeat.o(123937);
          return "";
        }
        paramString1 = ((com.tencent.mm.plugin.messenger.a.b)g.ab(com.tencent.mm.plugin.messenger.a.b.class)).zf(paramString2);
        AppMethodBeat.o(123937);
        return paramString1;
      }
      AppMethodBeat.o(123937);
      return "";
      label191:
      paramString2 = paramString1;
    }
  }
  
  public static int aaW()
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
      if (ay.is5G(localContext))
      {
        AppMethodBeat.o(123951);
        return 5;
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
  
  public static int b(long paramLong, String paramString)
  {
    AppMethodBeat.i(123942);
    if (paramLong > 0L)
    {
      Integer localInteger = (Integer)hCQ.get(Long.valueOf(paramLong));
      if (localInteger != null)
      {
        i = localInteger.intValue();
        AppMethodBeat.o(123942);
        return i;
      }
    }
    paramString = bj.aQM(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(123942);
      return 0;
    }
    paramString = Integer.valueOf(bt.getInt((String)paramString.get(".msg.appmsg.mmreader.category.$count"), 0));
    if (paramLong > 0L) {
      hCQ.put(Long.valueOf(paramLong), paramString);
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
    if (paramString.hDc == 1)
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
    int j = com.tencent.mm.storage.y.getSessionId();
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
  
  public static String oi(int paramInt)
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
  
  public static ajv t(bu parambu)
  {
    AppMethodBeat.i(123945);
    if (parambu == null)
    {
      AppMethodBeat.o(123945);
      return null;
    }
    if (parambu.cxg())
    {
      parambu = k.b.aA(parambu.field_content, parambu.field_reserved);
      if (parambu == null)
      {
        AppMethodBeat.o(123945);
        return null;
      }
      e locale = (e)parambu.ao(e.class);
      if ((locale == null) || (locale.hzo == null))
      {
        AppMethodBeat.o(123945);
        return null;
      }
      ajv localajv = new ajv();
      localajv.doK = parambu.dHo;
      localajv.hDe = parambu.dHp;
      localajv.FCb = locale.hzo.FCb;
      localajv.videoUrl = locale.hzo.videoUrl;
      localajv.hzm = locale.hzo.FCc;
      localajv.hDm = locale.hzo.hDm;
      localajv.videoWidth = locale.hzo.width;
      localajv.videoHeight = locale.hzo.height;
      localajv.duration = locale.hzo.videoDuration;
      AppMethodBeat.o(123945);
      return localajv;
    }
    AppMethodBeat.o(123945);
    return null;
  }
  
  public static boolean yt(String paramString)
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
  
  public static String yu(String paramString)
  {
    AppMethodBeat.i(123939);
    Map localMap = bw.M(paramString, "msg");
    if (localMap == null)
    {
      ad.e("MicroMsg.AppMsgBizHelper", "getAppMsgDyeingTempTitle fail, values is null");
      AppMethodBeat.o(123939);
      return " ";
    }
    bt.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_show_type"), 0);
    bt.bI((String)localMap.get(".msg.appmsg.ext_pay_info.pay_type"), "");
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
  
  public static String yv(String paramString)
  {
    AppMethodBeat.i(123940);
    paramString = bj.aQM(paramString);
    if (paramString == null)
    {
      Object localObject = new u();
      paramString = new StringBuilder("");
      localObject = ((u)localObject).hDb.iterator();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ai.m
 * JD-Core Version:    0.7.0.1
 */