package com.tencent.mm.ah;

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
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.protocal.protobuf.alc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
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
  private static final f<Long, u> fVO;
  private static final ConcurrentHashMap<Long, Integer> hFI;
  
  static
  {
    AppMethodBeat.i(123952);
    fVO = new h(50);
    hFI = new ConcurrentHashMap(50);
    AppMethodBeat.o(123952);
  }
  
  public static u a(long paramLong, String paramString)
  {
    AppMethodBeat.i(123941);
    if (paramLong > 0L)
    {
      localu = (u)fVO.get(Long.valueOf(paramLong));
      if (localu != null)
      {
        AppMethodBeat.o(123941);
        return localu;
      }
    }
    Object localObject1 = bk.aSj(paramString);
    if (localObject1 == null)
    {
      paramString = new u();
      AppMethodBeat.o(123941);
      return paramString;
    }
    int i = bu.getInt((String)((Map)localObject1).get(".msg.appmsg.mmreader.category.$type"), 0);
    paramString = bu.nullAsNil((String)((Map)localObject1).get(".msg.appmsg.mmreader.name"));
    int j = bu.getInt((String)((Map)localObject1).get(".msg.appmsg.mmreader.forbid_forward"), 0);
    int k = bu.getInt((String)((Map)localObject1).get(".msg.appmsg.mmreader.category.$count"), 0);
    Object localObject2 = (String)((Map)localObject1).get(".msg.commenturl");
    u localu = new u();
    localu.type = i;
    localu.name = paramString;
    localu.fmn = ((String)localObject2);
    localu.hFU = j;
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
        ((v)localObject2).hGc = ((String)((Map)localObject1).get((String)localObject3 + ".shorturl"));
        ((v)localObject2).hGd = ((String)((Map)localObject1).get((String)localObject3 + ".longurl"));
        ((v)localObject2).time = bu.getLong((String)((Map)localObject1).get((String)localObject3 + ".pub_time"), 0L);
        ((v)localObject2).hGf = ((String)((Map)localObject1).get((String)localObject3 + ".tweetid"));
        ((v)localObject2).hGg = ((String)((Map)localObject1).get((String)localObject3 + ".digest"));
        ((v)localObject2).type = bu.getInt((String)((Map)localObject1).get((String)localObject3 + ".itemshowtype"), 0);
        ((v)localObject2).hGi = bu.getInt((String)((Map)localObject1).get((String)localObject3 + ".play_length"), 0);
        ((v)localObject2).hGe = ((String)((Map)localObject1).get((String)localObject3 + ".cover"));
        paramString = (String)((Map)localObject1).get((String)localObject3 + ".cover_235_1");
        localObject4 = (String)((Map)localObject1).get((String)localObject3 + ".cover_16_9");
        if (((((v)localObject2).type != 5) && (!bu.isNullOrNil(paramString))) || (bu.isNullOrNil(((v)localObject2).hGe))) {
          ((v)localObject2).hGe = paramString;
        }
        if ((((v)localObject2).type == 5) && (!bu.isNullOrNil((String)localObject4))) {
          ((v)localObject2).hGe = ((String)localObject4);
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
        if (bu.isNullOrNil(paramString)) {
          break label813;
        }
        ((v)localObject2).hGw.add(paramString);
        j += 1;
        break label716;
        paramString = String.valueOf(i);
        break;
      }
      label813:
      if (((v)localObject2).hGw.size() == 0) {
        ((v)localObject2).hGw.add(((v)localObject2).hGe);
      }
      ((v)localObject2).hGv = ((String)((Map)localObject1).get((String)localObject3 + ".cover_1_1"));
      ((v)localObject2).hGh = bu.getInt((String)((Map)localObject1).get((String)localObject3 + ".del_flag"), 0);
      ((v)localObject2).hGj = ((String)((Map)localObject1).get((String)localObject3 + ".weapp_username"));
      ((v)localObject2).hGk = ((String)((Map)localObject1).get((String)localObject3 + ".weapp_path"));
      ((v)localObject2).hGl = bu.getInt((String)((Map)localObject1).get((String)localObject3 + ".weapp_version"), 0);
      ((v)localObject2).hGm = bu.getInt((String)((Map)localObject1).get((String)localObject3 + ".weapp_state"), 0);
      ((v)localObject2).hGn = ((String)((Map)localObject1).get((String)localObject3 + ".weapp_appid"));
      ((v)localObject2).hGo = ((String)((Map)localObject1).get((String)localObject3 + ".weapp_image_url"));
      ((v)localObject2).hGp = ((String)((Map)localObject1).get((String)localObject3 + ".weapp_icon"));
      ((v)localObject2).hGq = ((String)((Map)localObject1).get((String)localObject3 + ".weapp_nickname"));
      ((v)localObject2).hGr = ((String)((Map)localObject1).get((String)localObject3 + ".play_url"));
      ((v)localObject2).hGs = ((String)((Map)localObject1).get((String)localObject3 + ".player"));
      ((v)localObject2).hGt = bu.getInt((String)((Map)localObject1).get((String)localObject3 + ".music_source"), 1);
      ((v)localObject2).hGu = bu.getInt((String)((Map)localObject1).get((String)localObject3 + ".pic_num"), 1);
      ((v)localObject2).videoWidth = bu.getInt((String)((Map)localObject1).get((String)localObject3 + ".video_width"), 0);
      ((v)localObject2).videoHeight = bu.getInt((String)((Map)localObject1).get((String)localObject3 + ".video_height"), 0);
      ((v)localObject2).hBY = bu.getInt((String)((Map)localObject1).get((String)localObject3 + ".is_pay_subscribe"), 0);
      ((v)localObject2).hCa = ((String)((Map)localObject1).get((String)localObject3 + ".vid"));
      localu.hFT.add(localObject2);
      i += 1;
    }
    localu.hCt = k.C((Map)localObject1);
    paramString = bu.nullAsNil((String)((Map)localObject1).get(".msg.fromusername"));
    if (!bu.isNullOrNil(paramString))
    {
      localObject1 = ((l)g.ab(l.class)).azF().BH(paramString).adF();
      localu.dIt = paramString;
      localu.dIu = ((String)localObject1);
    }
    if (paramLong > 0L)
    {
      fVO.q(Long.valueOf(paramLong), localu);
      hFI.put(Long.valueOf(paramLong), Integer.valueOf(k));
    }
    AppMethodBeat.o(123941);
    return localu;
  }
  
  public static akf a(v paramv, alc paramalc, String paramString1, String paramString2)
  {
    AppMethodBeat.i(123946);
    if ((paramv == null) || (paramv.type == -1))
    {
      AppMethodBeat.o(123946);
      return null;
    }
    akf localakf = new akf();
    if (paramv.type == 5) {}
    for (int i = 1;; i = 0)
    {
      localakf.hBX = i;
      localakf.hBV = paramv.type;
      localakf.hBY = paramv.hBY;
      localakf.hCa = paramv.hCa;
      localakf.videoWidth = paramv.videoWidth;
      localakf.videoHeight = paramv.videoHeight;
      localakf.duration = paramv.hGi;
      localakf.hBW = ((int)paramv.time);
      localakf.dpP = paramString1;
      localakf.hFW = paramString2;
      localakf.hGe = paramv.hGe;
      paramalc.aQP(paramv.title);
      paramalc.aQQ(paramv.hGg);
      AppMethodBeat.o(123946);
      return localakf;
    }
  }
  
  public static akf a(bv parambv, alc paramalc)
  {
    AppMethodBeat.i(123944);
    if (parambv == null)
    {
      AppMethodBeat.o(123944);
      return null;
    }
    if ((parambv.cVH()) && (!parambv.fta()))
    {
      parambv = k.b.aB(parambv.field_content, parambv.field_reserved);
      if (parambv == null)
      {
        AppMethodBeat.o(123944);
        return null;
      }
      e locale = (e)parambv.ao(e.class);
      if ((locale == null) || ((locale.hBV == -1) && (locale.hCd != 1)))
      {
        AppMethodBeat.o(123944);
        return null;
      }
      akf localakf = new akf();
      localakf.hBX = locale.hBX;
      localakf.hBV = locale.hBV;
      localakf.hBY = locale.hBY;
      localakf.hCa = locale.hCa;
      localakf.videoWidth = locale.videoWidth;
      localakf.videoHeight = locale.videoHeight;
      localakf.duration = locale.duration;
      localakf.hBW = locale.hBW;
      localakf.hGe = parambv.thumburl;
      localakf.dpP = parambv.dIt;
      localakf.hFW = parambv.dIu;
      paramalc.aQP(parambv.title);
      paramalc.aQQ(parambv.description);
      AppMethodBeat.o(123944);
      return localakf;
    }
    AppMethodBeat.o(123944);
    return null;
  }
  
  public static String a(Context paramContext, int paramInt, String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(123949);
    if (paramContext == null)
    {
      ae.w("MicroMsg.AppMsgBizHelper", "getReaderAppMsgContent: context is null");
      AppMethodBeat.o(123949);
      return null;
    }
    if ((paramString1 == null) || (paramString2 == null))
    {
      ae.w("MicroMsg.AppMsgBizHelper", "getReaderAppMsgContent: msg is null");
      AppMethodBeat.o(123949);
      return null;
    }
    g.ajS();
    if (!g.ajR().isSDCardAvailable())
    {
      t.g(paramContext, null);
      AppMethodBeat.o(123949);
      return null;
    }
    try
    {
      paramString1 = ((a)g.ab(a.class)).a(paramLong, paramString1);
      paramContext = paramString1.hFT;
      if ((paramContext != null) && (paramContext.size() > 0) && (paramInt < paramContext.size()))
      {
        v localv = (v)paramContext.get(paramInt);
        paramContext = new k.b();
        paramContext.title = localv.title;
        paramContext.description = localv.hGg;
        paramContext.action = "view";
        paramContext.type = 5;
        paramContext.url = localv.url;
        paramContext.dIt = paramString1.dIt;
        paramContext.dIu = paramString1.dIu;
        paramContext.fmn = paramString1.fmn;
        paramContext.thumburl = a(localv);
        paramString1 = new e();
        paramString1.hBV = localv.type;
        paramString1.hBY = localv.hBY;
        if (localv.type == 5)
        {
          paramString1.hCa = localv.hCa;
          paramString1.hBW = ((int)localv.time);
          paramString1.duration = localv.hGi;
          paramString1.videoWidth = localv.videoWidth;
          paramString1.videoHeight = localv.videoHeight;
        }
        paramContext.a(paramString1);
        if (bu.isNullOrNil(paramContext.thumburl))
        {
          paramString1 = p.aEN().DL(paramString2);
          if (paramString1 != null) {
            paramContext.thumburl = paramString1.aEG();
          }
        }
        paramContext = k.b.a(paramContext, null, null);
        AppMethodBeat.o(123949);
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      ae.printErrStackTrace("MicroMsg.AppMsgBizHelper", paramContext, "", new Object[0]);
      ae.e("MicroMsg.AppMsgBizHelper", "retransmit app msg error : %s", new Object[] { paramContext.getLocalizedMessage() });
      AppMethodBeat.o(123949);
    }
    return null;
  }
  
  public static String a(v paramv)
  {
    AppMethodBeat.i(123943);
    if (paramv.type == 5)
    {
      if (bu.isNullOrNil(paramv.hGe))
      {
        paramv = paramv.hGv;
        AppMethodBeat.o(123943);
        return paramv;
      }
      paramv = paramv.hGe;
      AppMethodBeat.o(123943);
      return paramv;
    }
    if (bu.isNullOrNil(paramv.hGv))
    {
      paramv = paramv.hGe;
      AppMethodBeat.o(123943);
      return paramv;
    }
    paramv = paramv.hGv;
    AppMethodBeat.o(123943);
    return paramv;
  }
  
  public static String aC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(123937);
    paramString1 = bx.M(paramString1, "msg");
    if (paramString1 == null)
    {
      ae.e("MicroMsg.AppMsgBizHelper", "getAppMsgDyeingTempFromUser fail, values is null");
      paramString1 = null;
      if ((!bu.isNullOrNil(paramString1)) || (x.AN(paramString2))) {
        break label191;
      }
    }
    for (;;)
    {
      if (!bu.isNullOrNil(paramString2))
      {
        if (zd(paramString2))
        {
          paramString1 = ((o)g.ab(o.class)).Ob(paramString2);
          if ((paramString1 != null) && (!TextUtils.isEmpty(paramString1.field_nickname)))
          {
            paramString1 = paramString1.field_nickname;
            AppMethodBeat.o(123937);
            return paramString1;
            paramString1 = (String)paramString1.get(".msg.fromusername");
            break;
          }
        }
        paramString1 = ((l)g.ab(l.class)).azF().BH(paramString2);
        if ((paramString1 == null) || ((int)paramString1.ght <= 0))
        {
          AppMethodBeat.o(123937);
          return "";
        }
        paramString1 = ((b)g.ab(b.class)).zP(paramString2);
        AppMethodBeat.o(123937);
        return paramString1;
      }
      AppMethodBeat.o(123937);
      return "";
      label191:
      paramString2 = paramString1;
    }
  }
  
  public static int abf()
  {
    AppMethodBeat.i(123951);
    Context localContext = ak.getContext();
    if (az.isNetworkConnected(localContext))
    {
      if (az.is2G(localContext))
      {
        AppMethodBeat.o(123951);
        return 2;
      }
      if (az.is3G(localContext))
      {
        AppMethodBeat.o(123951);
        return 3;
      }
      if (az.is4G(localContext))
      {
        AppMethodBeat.o(123951);
        return 4;
      }
      if (az.is5G(localContext))
      {
        AppMethodBeat.o(123951);
        return 5;
      }
      if (az.isWifi(localContext))
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
      Integer localInteger = (Integer)hFI.get(Long.valueOf(paramLong));
      if (localInteger != null)
      {
        i = localInteger.intValue();
        AppMethodBeat.o(123942);
        return i;
      }
    }
    paramString = bk.aSj(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(123942);
      return 0;
    }
    paramString = Integer.valueOf(bu.getInt((String)paramString.get(".msg.appmsg.mmreader.category.$count"), 0));
    if (paramLong > 0L) {
      hFI.put(Long.valueOf(paramLong), paramString);
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
      ae.w("MicroMsg.AppMsgBizHelper", "isBizMsgForbidForward reader is null");
      AppMethodBeat.o(123948);
      return false;
    }
    if (paramString.hFU == 1)
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
  
  public static String ol(int paramInt)
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
  
  public static akf t(bv parambv)
  {
    AppMethodBeat.i(123945);
    if (parambv == null)
    {
      AppMethodBeat.o(123945);
      return null;
    }
    if (parambv.cyH())
    {
      parambv = k.b.aB(parambv.field_content, parambv.field_reserved);
      if (parambv == null)
      {
        AppMethodBeat.o(123945);
        return null;
      }
      e locale = (e)parambv.ao(e.class);
      if ((locale == null) || (locale.hCc == null))
      {
        AppMethodBeat.o(123945);
        return null;
      }
      akf localakf = new akf();
      localakf.dpP = parambv.dIt;
      localakf.hFW = parambv.dIu;
      localakf.FUw = locale.hCc.FUw;
      localakf.videoUrl = locale.hCc.videoUrl;
      localakf.hCa = locale.hCc.FUx;
      localakf.hGe = locale.hCc.hGe;
      localakf.videoWidth = locale.hCc.width;
      localakf.videoHeight = locale.hCc.height;
      localakf.duration = locale.hCc.videoDuration;
      AppMethodBeat.o(123945);
      return localakf;
    }
    AppMethodBeat.o(123945);
    return null;
  }
  
  public static boolean zd(String paramString)
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
  
  public static String ze(String paramString)
  {
    AppMethodBeat.i(123939);
    Map localMap = bx.M(paramString, "msg");
    if (localMap == null)
    {
      ae.e("MicroMsg.AppMsgBizHelper", "getAppMsgDyeingTempTitle fail, values is null");
      AppMethodBeat.o(123939);
      return " ";
    }
    bu.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_show_type"), 0);
    bu.bI((String)localMap.get(".msg.appmsg.ext_pay_info.pay_type"), "");
    String str = bu.nullAsNil((String)localMap.get(".msg.appmsg.title"));
    paramString = str;
    if (bu.isNullOrNil(str)) {
      paramString = (String)localMap.get(".msg.appmsg.mmreader.category.item.title");
    }
    str = paramString;
    if (bu.isNullOrNil(paramString)) {
      str = " ";
    }
    AppMethodBeat.o(123939);
    return str;
  }
  
  public static String zf(String paramString)
  {
    AppMethodBeat.i(123940);
    paramString = bk.aSj(paramString);
    if (paramString == null)
    {
      Object localObject = new u();
      paramString = new StringBuilder("");
      localObject = ((u)localObject).hFT.iterator();
      while (((Iterator)localObject).hasNext())
      {
        v localv = (v)((Iterator)localObject).next();
        if (!bu.isNullOrNil(localv.title)) {
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