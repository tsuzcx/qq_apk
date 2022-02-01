package com.tencent.mm.message;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.contact.d;
import com.tencent.mm.modelavatar.j;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.s;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.plugin.biz.b.f;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.ask;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.SemiXml;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.aa;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;

public final class m
{
  private static final com.tencent.mm.b.f<Long, u> lNS;
  private static final ConcurrentHashMap<Long, Integer> nUp;
  
  static
  {
    AppMethodBeat.i(123952);
    lNS = new com.tencent.mm.b.h(50);
    nUp = new ConcurrentHashMap(50);
    AppMethodBeat.o(123952);
  }
  
  public static boolean Hh(String paramString)
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
  
  public static String Hi(String paramString)
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
  
  public static String Hj(String paramString)
  {
    AppMethodBeat.i(123940);
    Object localObject2 = SemiXml.decode(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = XmlParser.parseXml(paramString, "msg", null);
    }
    if (localObject1 == null)
    {
      localObject1 = new u();
      paramString = new StringBuilder("");
      localObject1 = ((u)localObject1).nUC.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (v)((Iterator)localObject1).next();
        if (!Util.isNullOrNil(((v)localObject2).title)) {
          paramString.append(((v)localObject2).title);
        }
      }
      paramString = paramString.toString();
      AppMethodBeat.o(123940);
      return paramString;
    }
    paramString = (String)((Map)localObject1).get(".msg.appmsg.mmreader.category.item.title");
    if (paramString == null)
    {
      AppMethodBeat.o(123940);
      return "";
    }
    AppMethodBeat.o(123940);
    return paramString;
  }
  
  public static arn a(v paramv, ask paramask, String paramString1, String paramString2)
  {
    AppMethodBeat.i(123946);
    if ((paramv == null) || (paramv.type == -1))
    {
      AppMethodBeat.o(123946);
      return null;
    }
    arn localarn = new arn();
    if (paramv.type == 5) {}
    for (int i = 1;; i = 0)
    {
      localarn.nQo = i;
      localarn.nQm = paramv.type;
      localarn.nQp = paramv.nQp;
      localarn.vid = paramv.vid;
      localarn.videoWidth = paramv.videoWidth;
      localarn.videoHeight = paramv.videoHeight;
      localarn.duration = paramv.nUQ;
      localarn.nQn = ((int)paramv.time);
      localarn.hEE = paramString1;
      localarn.nUF = paramString2;
      localarn.nUM = paramv.nUM;
      paramask.btB(paramv.title);
      paramask.btC(paramv.nUO);
      AppMethodBeat.o(123946);
      return localarn;
    }
  }
  
  public static arn a(cc paramcc, ask paramask)
  {
    AppMethodBeat.i(123944);
    if (paramcc == null)
    {
      AppMethodBeat.o(123944);
      return null;
    }
    if ((paramcc.fxR()) && (!paramcc.iYe()))
    {
      paramcc = k.b.aP(paramcc.field_content, paramcc.field_reserved);
      if (paramcc == null)
      {
        AppMethodBeat.o(123944);
        return null;
      }
      e locale = (e)paramcc.aK(e.class);
      if ((locale == null) || ((locale.nQm == -1) && (locale.nQt != 1)))
      {
        AppMethodBeat.o(123944);
        return null;
      }
      arn localarn = new arn();
      localarn.nQo = locale.nQo;
      localarn.nQm = locale.nQm;
      localarn.nQp = locale.nQp;
      localarn.vid = locale.vid;
      localarn.videoWidth = locale.videoWidth;
      localarn.videoHeight = locale.videoHeight;
      localarn.duration = locale.duration;
      localarn.nQn = locale.nQn;
      localarn.nUM = paramcc.thumburl;
      localarn.hEE = paramcc.iaa;
      localarn.nUF = paramcc.iab;
      paramask.btB(paramcc.title);
      paramask.btC(paramcc.description);
      AppMethodBeat.o(123944);
      return localarn;
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
    com.tencent.mm.kernel.h.baF();
    if (!com.tencent.mm.kernel.h.baE().isSDCardAvailable())
    {
      aa.j(paramContext, null);
      AppMethodBeat.o(123949);
      return null;
    }
    try
    {
      paramString1 = ((a)com.tencent.mm.kernel.h.ax(a.class)).c(paramLong, paramString1);
      paramContext = paramString1.nUC;
      if ((paramContext != null) && (paramContext.size() > 0) && (paramInt < paramContext.size()))
      {
        v localv = (v)paramContext.get(paramInt);
        paramContext = new k.b();
        paramContext.title = localv.title;
        paramContext.description = localv.nUO;
        paramContext.action = "view";
        paramContext.type = 5;
        paramContext.url = localv.url;
        paramContext.iaa = paramString1.iaa;
        paramContext.iab = paramString1.iab;
        paramContext.kLg = paramString1.kLg;
        paramContext.thumburl = a(localv);
        paramString1 = new e();
        paramString1.nQm = localv.type;
        paramString1.nQp = localv.nQp;
        if ((localv.type == 5) || (localv.type == 16))
        {
          paramString1.vid = localv.vid;
          paramString1.nQn = ((int)localv.time);
          paramString1.duration = localv.nUQ;
          paramString1.videoWidth = localv.videoWidth;
          paramString1.videoHeight = localv.videoHeight;
        }
        paramContext.a(paramString1);
        if (Util.isNullOrNil(paramContext.thumburl))
        {
          paramString1 = q.bFE().LS(paramString2);
          if (paramString1 != null) {
            paramContext.thumburl = paramString1.bFw();
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
    if ((paramv.type == 5) || (paramv.type == 16))
    {
      if (Util.isNullOrNil(paramv.nUM))
      {
        paramv = paramv.nVd;
        AppMethodBeat.o(123943);
        return paramv;
      }
      paramv = paramv.nUM;
      AppMethodBeat.o(123943);
      return paramv;
    }
    if (Util.isNullOrNil(paramv.nVd))
    {
      paramv = paramv.nUM;
      AppMethodBeat.o(123943);
      return paramv;
    }
    paramv = paramv.nVd;
    AppMethodBeat.o(123943);
    return paramv;
  }
  
  public static int aPK()
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
  
  public static String aQ(String paramString1, String paramString2)
  {
    Object localObject = null;
    AppMethodBeat.i(123937);
    paramString1 = XmlParser.parseXml(paramString1, "msg", null);
    if (paramString1 == null)
    {
      Log.e("MicroMsg.AppMsgBizHelper", "getAppMsgDyeingTempFromUser fail, values is null");
      paramString1 = localObject;
      if ((!Util.isNullOrNil(paramString1)) || (au.bwp(paramString2))) {
        break label192;
      }
    }
    for (;;)
    {
      if (!Util.isNullOrNil(paramString2))
      {
        if (Hh(paramString2))
        {
          paramString1 = ((s)com.tencent.mm.kernel.h.ax(s.class)).Xy(paramString2);
          if ((paramString1 != null) && (!TextUtils.isEmpty(paramString1.field_nickname)))
          {
            paramString1 = paramString1.field_nickname;
            AppMethodBeat.o(123937);
            return paramString1;
            paramString1 = (String)paramString1.get(".msg.fromusername");
            break;
          }
        }
        paramString1 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramString2);
        if ((paramString1 == null) || ((int)paramString1.maN <= 0))
        {
          AppMethodBeat.o(123937);
          return "";
        }
        paramString1 = ((b)com.tencent.mm.kernel.h.ax(b.class)).getDisplayName(paramString2);
        AppMethodBeat.o(123937);
        return paramString1;
      }
      AppMethodBeat.o(123937);
      return "";
      label192:
      paramString2 = paramString1;
    }
  }
  
  public static u c(long paramLong, String paramString)
  {
    AppMethodBeat.i(123941);
    if (paramLong > 0L)
    {
      localObject1 = (u)lNS.get(Long.valueOf(paramLong));
      if (localObject1 != null)
      {
        AppMethodBeat.o(123941);
        return localObject1;
      }
    }
    Object localObject1 = SemiXml.decode(paramString);
    if (localObject1 == null) {
      localObject1 = XmlParser.parseXml(paramString, "msg", null);
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        paramString = new u();
        AppMethodBeat.o(123941);
        return paramString;
      }
      int i = Util.getInt((String)((Map)localObject1).get(".msg.appmsg.mmreader.category.$type"), 0);
      String str = Util.nullAsNil((String)((Map)localObject1).get(".msg.appmsg.mmreader.name"));
      int j = Util.getInt((String)((Map)localObject1).get(".msg.appmsg.mmreader.forbid_forward"), 0);
      int k = Util.getInt((String)((Map)localObject1).get(".msg.appmsg.mmreader.category.$count"), 0);
      Object localObject2 = (String)((Map)localObject1).get(".msg.commenturl");
      u localu = new u();
      localu.type = i;
      localu.name = str;
      localu.kLg = ((String)localObject2);
      localu.nUD = j;
      i = 0;
      while (i < k)
      {
        localObject2 = new v();
        Object localObject3 = new StringBuilder(".msg.appmsg.mmreader.category.item");
        Object localObject4;
        if (i == 0)
        {
          str = "";
          localObject3 = str;
          ((v)localObject2).title = ((String)((Map)localObject1).get((String)localObject3 + ".title"));
          ((v)localObject2).url = ((String)((Map)localObject1).get((String)localObject3 + ".url"));
          ((v)localObject2).nUK = ((String)((Map)localObject1).get((String)localObject3 + ".shorturl"));
          ((v)localObject2).nUL = ((String)((Map)localObject1).get((String)localObject3 + ".longurl"));
          ((v)localObject2).time = Util.getLong((String)((Map)localObject1).get((String)localObject3 + ".pub_time"), 0L);
          ((v)localObject2).nUN = ((String)((Map)localObject1).get((String)localObject3 + ".tweetid"));
          ((v)localObject2).nUO = ((String)((Map)localObject1).get((String)localObject3 + ".digest"));
          ((v)localObject2).type = Util.getInt((String)((Map)localObject1).get((String)localObject3 + ".itemshowtype"), 0);
          ((v)localObject2).nUQ = Util.getInt((String)((Map)localObject1).get((String)localObject3 + ".play_length"), 0);
          ((v)localObject2).nUM = ((String)((Map)localObject1).get((String)localObject3 + ".cover"));
          str = (String)((Map)localObject1).get((String)localObject3 + ".cover_235_1");
          localObject4 = (String)((Map)localObject1).get((String)localObject3 + ".cover_16_9");
          if (((((v)localObject2).type != 5) && (!Util.isNullOrNil(str))) || (Util.isNullOrNil(((v)localObject2).nUM))) {
            ((v)localObject2).nUM = str;
          }
          if ((((v)localObject2).type == 5) && (!Util.isNullOrNil((String)localObject4))) {
            ((v)localObject2).nUM = ((String)localObject4);
          }
          j = 0;
          label758:
          if (j >= 100) {
            break label863;
          }
          localObject4 = new StringBuilder().append((String)localObject3).append(".pic_urls.pic_url");
          if (j != 0) {
            break label853;
          }
        }
        label853:
        for (str = "";; str = String.valueOf(j))
        {
          str = (String)((Map)localObject1).get(str);
          if (Util.isNullOrNil(str)) {
            break label863;
          }
          ((v)localObject2).nVe.add(str);
          j += 1;
          break label758;
          str = String.valueOf(i);
          break;
        }
        label863:
        if (((v)localObject2).nVe.size() == 0) {
          ((v)localObject2).nVe.add(((v)localObject2).nUM);
        }
        ((v)localObject2).nVd = ((String)((Map)localObject1).get((String)localObject3 + ".cover_1_1"));
        ((v)localObject2).nUP = Util.getInt((String)((Map)localObject1).get((String)localObject3 + ".del_flag"), 0);
        ((v)localObject2).nUR = ((String)((Map)localObject1).get((String)localObject3 + ".weapp_username"));
        ((v)localObject2).nUS = ((String)((Map)localObject1).get((String)localObject3 + ".weapp_path"));
        ((v)localObject2).nUT = Util.getInt((String)((Map)localObject1).get((String)localObject3 + ".weapp_version"), 0);
        ((v)localObject2).nUU = Util.getInt((String)((Map)localObject1).get((String)localObject3 + ".weapp_state"), 0);
        ((v)localObject2).nUV = ((String)((Map)localObject1).get((String)localObject3 + ".weapp_appid"));
        ((v)localObject2).nUW = ((String)((Map)localObject1).get((String)localObject3 + ".weapp_image_url"));
        ((v)localObject2).nUX = ((String)((Map)localObject1).get((String)localObject3 + ".weapp_icon"));
        ((v)localObject2).nUY = ((String)((Map)localObject1).get((String)localObject3 + ".weapp_nickname"));
        ((v)localObject2).nUZ = ((String)((Map)localObject1).get((String)localObject3 + ".play_url"));
        ((v)localObject2).nVa = ((String)((Map)localObject1).get((String)localObject3 + ".player"));
        ((v)localObject2).nVb = Util.getInt((String)((Map)localObject1).get((String)localObject3 + ".music_source"), 1);
        ((v)localObject2).nVc = Util.getInt((String)((Map)localObject1).get((String)localObject3 + ".pic_num"), 1);
        ((v)localObject2).videoWidth = Util.getInt((String)((Map)localObject1).get((String)localObject3 + ".video_width"), 0);
        ((v)localObject2).videoHeight = Util.getInt((String)((Map)localObject1).get((String)localObject3 + ".video_height"), 0);
        ((v)localObject2).nQp = Util.getInt((String)((Map)localObject1).get((String)localObject3 + ".is_pay_subscribe"), 0);
        ((v)localObject2).nVh = Util.getLong((String)((Map)localObject1).get((String)localObject3 + ".comment_topic_id"), 0L);
        ((v)localObject2).vid = ((String)((Map)localObject1).get((String)localObject3 + ".vid"));
        ((v)localObject2).nVi = paramString;
        localu.nUC.add(localObject2);
        i += 1;
      }
      localu.nQS = com.tencent.mm.an.k.E((Map)localObject1);
      paramString = Util.nullAsNil((String)((Map)localObject1).get(".msg.fromusername"));
      if (!Util.isNullOrNil(paramString))
      {
        localObject1 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramString).aSU();
        localu.iaa = paramString;
        localu.iab = ((String)localObject1);
      }
      if (paramLong > 0L)
      {
        lNS.B(Long.valueOf(paramLong), localu);
        nUp.put(Long.valueOf(paramLong), Integer.valueOf(k));
      }
      AppMethodBeat.o(123941);
      return localu;
    }
  }
  
  public static int d(long paramLong, String paramString)
  {
    AppMethodBeat.i(123942);
    if (paramLong > 0L)
    {
      Integer localInteger = (Integer)nUp.get(Long.valueOf(paramLong));
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
      nUp.put(Long.valueOf(paramLong), paramString);
    }
    int i = paramString.intValue();
    AppMethodBeat.o(123942);
    return i;
  }
  
  public static String e(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 0;
    AppMethodBeat.i(123950);
    int j = ad.getSessionId();
    if ((paramString == null) || (!paramString.contains(WeChatHosts.domainString(b.f.host_mp_weixin_qq_com))) || ((j <= 0) && (paramInt2 < 0) && (paramInt1 < 0) && (paramInt3 <= 0)))
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
        paramString = str2.replaceAll("(&scene=[\\d]*)", "").replaceAll("(\\?scene=[\\d]*)", "?");
        paramString = paramString + "&scene=" + paramInt1;
      }
      str1 = paramString;
      if (paramInt2 >= 0)
      {
        paramString = paramString.replaceAll("(&subscene=[\\d]*)", "").replaceAll("(\\?subscene=[\\d]*)", "?");
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
  
  public static boolean e(long paramLong, String paramString)
  {
    AppMethodBeat.i(123948);
    if (paramString == null)
    {
      AppMethodBeat.o(123948);
      return false;
    }
    paramString = ((a)com.tencent.mm.kernel.h.ax(a.class)).c(paramLong, paramString);
    if (paramString == null)
    {
      Log.w("MicroMsg.AppMsgBizHelper", "isBizMsgForbidForward reader is null");
      AppMethodBeat.o(123948);
      return false;
    }
    if (paramString.nUD == 1)
    {
      AppMethodBeat.o(123948);
      return true;
    }
    AppMethodBeat.o(123948);
    return false;
  }
  
  public static String uD(int paramInt)
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
  
  public static arn x(cc paramcc)
  {
    AppMethodBeat.i(123945);
    if (paramcc == null)
    {
      AppMethodBeat.o(123945);
      return null;
    }
    if (paramcc.dSI())
    {
      paramcc = k.b.aP(paramcc.field_content, paramcc.field_reserved);
      if (paramcc == null)
      {
        AppMethodBeat.o(123945);
        return null;
      }
      e locale = (e)paramcc.aK(e.class);
      if ((locale == null) || (locale.nQs == null))
      {
        AppMethodBeat.o(123945);
        return null;
      }
      arn localarn = new arn();
      localarn.hEE = paramcc.iaa;
      localarn.nUF = paramcc.iab;
      localarn.YMm = locale.nQs.YMm;
      localarn.videoUrl = locale.nQs.videoUrl;
      localarn.vid = locale.nQs.YMn;
      localarn.nUM = locale.nQs.nUM;
      localarn.videoWidth = locale.nQs.width;
      localarn.videoHeight = locale.nQs.height;
      localarn.duration = locale.nQs.videoDuration;
      AppMethodBeat.o(123945);
      return localarn;
    }
    AppMethodBeat.o(123945);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.message.m
 * JD-Core Version:    0.7.0.1
 */