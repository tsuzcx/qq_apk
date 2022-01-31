package com.tencent.mm.af;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.ah.o;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.protocal.protobuf.aci;
import com.tencent.mm.protocal.protobuf.adf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.s;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

public final class l
{
  private static final f<Long, p> eka;
  
  static
  {
    AppMethodBeat.i(11221);
    eka = new com.tencent.mm.a.h(50);
    AppMethodBeat.o(11221);
  }
  
  public static int LZ()
  {
    AppMethodBeat.i(11220);
    Context localContext = ah.getContext();
    if (at.isNetworkConnected(localContext))
    {
      if (at.is2G(localContext))
      {
        AppMethodBeat.o(11220);
        return 2;
      }
      if (at.is3G(localContext))
      {
        AppMethodBeat.o(11220);
        return 3;
      }
      if (at.is4G(localContext))
      {
        AppMethodBeat.o(11220);
        return 4;
      }
      if (at.isWifi(localContext))
      {
        AppMethodBeat.o(11220);
        return 1;
      }
      AppMethodBeat.o(11220);
      return 0;
    }
    AppMethodBeat.o(11220);
    return 100;
  }
  
  public static aci a(q paramq, adf paramadf, String paramString1, String paramString2)
  {
    AppMethodBeat.i(151356);
    if ((paramq == null) || (paramq.type != 5))
    {
      AppMethodBeat.o(151356);
      return null;
    }
    aci localaci = new aci();
    localaci.fgj = 1;
    localaci.fgh = paramq.type;
    localaci.fgl = paramq.fgl;
    localaci.videoWidth = paramq.videoWidth;
    localaci.videoHeight = paramq.videoHeight;
    localaci.duration = paramq.fjN;
    localaci.fgi = ((int)paramq.time);
    localaci.cqX = paramString1;
    localaci.fjB = paramString2;
    localaci.fjJ = paramq.fjJ;
    paramadf.aoA(paramq.title);
    paramadf.aoB(paramq.fjL);
    AppMethodBeat.o(151356);
    return localaci;
  }
  
  public static aci a(bi parambi, adf paramadf)
  {
    AppMethodBeat.i(151355);
    if (parambi == null)
    {
      AppMethodBeat.o(151355);
      return null;
    }
    if ((parambi.bCn()) && (!parambi.dvV()))
    {
      parambi = j.b.ab(parambi.field_content, parambi.field_reserved);
      if (parambi == null)
      {
        AppMethodBeat.o(151355);
        return null;
      }
      e locale = (e)parambi.R(e.class);
      if ((locale == null) || (locale.fgj != 1) || (locale.fgh != 5))
      {
        AppMethodBeat.o(151355);
        return null;
      }
      aci localaci = new aci();
      localaci.fgj = 1;
      localaci.fgh = locale.fgh;
      localaci.fgl = locale.fgl;
      localaci.videoWidth = locale.videoWidth;
      localaci.videoHeight = locale.videoHeight;
      localaci.duration = locale.duration;
      localaci.fgi = locale.fgi;
      localaci.fjJ = parambi.thumburl;
      localaci.cqX = parambi.cGN;
      localaci.fjB = parambi.cGO;
      paramadf.aoA(parambi.title);
      paramadf.aoB(parambi.description);
      AppMethodBeat.o(151355);
      return localaci;
    }
    AppMethodBeat.o(151355);
    return null;
  }
  
  public static String a(Context paramContext, int paramInt, String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(11218);
    if (paramContext == null)
    {
      ab.w("MicroMsg.AppMsgBizHelper", "getReaderAppMsgContent: context is null");
      AppMethodBeat.o(11218);
      return null;
    }
    if ((paramString1 == null) || (paramString2 == null))
    {
      ab.w("MicroMsg.AppMsgBizHelper", "getReaderAppMsgContent: msg is null");
      AppMethodBeat.o(11218);
      return null;
    }
    g.RM();
    if (!g.RL().isSDCardAvailable())
    {
      com.tencent.mm.ui.base.t.ii(paramContext);
      AppMethodBeat.o(11218);
      return null;
    }
    try
    {
      paramString1 = ((com.tencent.mm.plugin.biz.a.a)g.E(com.tencent.mm.plugin.biz.a.a.class)).b(paramLong, paramString1);
      paramContext = paramString1.fjy;
      if ((paramContext != null) && (paramContext.size() > 0) && (paramInt < paramContext.size()))
      {
        q localq = (q)paramContext.get(paramInt);
        paramContext = new j.b();
        paramContext.title = localq.title;
        paramContext.description = localq.fjL;
        paramContext.action = "view";
        paramContext.type = 5;
        paramContext.url = localq.url;
        paramContext.cGN = paramString1.cGN;
        paramContext.cGO = paramString1.cGO;
        paramContext.dGR = paramString1.dGR;
        paramContext.thumburl = a(localq);
        paramString1 = new e();
        paramString1.fgh = localq.type;
        if (localq.type == 5)
        {
          paramString1.fgl = localq.fgl;
          paramString1.fgi = ((int)localq.time);
          paramString1.duration = localq.fjN;
          paramString1.videoWidth = localq.videoWidth;
          paramString1.videoHeight = localq.videoHeight;
        }
        paramContext.a(paramString1);
        if (bo.isNullOrNil(paramContext.thumburl))
        {
          paramString1 = o.adg().rj(paramString2);
          if (paramString1 != null) {
            paramContext.thumburl = paramString1.acX();
          }
        }
        paramContext = j.b.a(paramContext, null, null);
        AppMethodBeat.o(11218);
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      ab.printErrStackTrace("MicroMsg.AppMsgBizHelper", paramContext, "", new Object[0]);
      ab.e("MicroMsg.AppMsgBizHelper", "retransmit app msg error : %s", new Object[] { paramContext.getLocalizedMessage() });
      AppMethodBeat.o(11218);
    }
    return null;
  }
  
  public static String a(q paramq)
  {
    AppMethodBeat.i(11215);
    if (paramq.type == 5)
    {
      if (bo.isNullOrNil(paramq.fjJ))
      {
        paramq = paramq.fka;
        AppMethodBeat.o(11215);
        return paramq;
      }
      paramq = paramq.fjJ;
      AppMethodBeat.o(11215);
      return paramq;
    }
    if (bo.isNullOrNil(paramq.fka))
    {
      paramq = paramq.fjJ;
      AppMethodBeat.o(11215);
      return paramq;
    }
    paramq = paramq.fka;
    AppMethodBeat.o(11215);
    return paramq;
  }
  
  public static String ac(String paramString1, String paramString2)
  {
    AppMethodBeat.i(11210);
    paramString1 = br.F(paramString1, "msg");
    if (paramString1 == null)
    {
      ab.e("MicroMsg.AppMsgBizHelper", "getAppMsgDyeingTempFromUser fail, values is null");
      paramString1 = null;
      if ((!bo.isNullOrNil(paramString1)) || (com.tencent.mm.model.t.ot(paramString2))) {
        break label192;
      }
    }
    for (;;)
    {
      if (!bo.isNullOrNil(paramString2))
      {
        if (na(paramString2))
        {
          paramString1 = ((com.tencent.mm.plugin.appbrand.service.i)g.E(com.tencent.mm.plugin.appbrand.service.i.class)).Ae(paramString2);
          if ((paramString1 != null) && (!TextUtils.isEmpty(paramString1.field_nickname)))
          {
            paramString1 = paramString1.field_nickname;
            AppMethodBeat.o(11210);
            return paramString1;
            paramString1 = (String)paramString1.get(".msg.fromusername");
            break;
          }
        }
        paramString1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(paramString2);
        if ((paramString1 == null) || ((int)paramString1.euF <= 0))
        {
          AppMethodBeat.o(11210);
          return "";
        }
        paramString1 = ((b)g.E(b.class)).nE(paramString2);
        AppMethodBeat.o(11210);
        return paramString1;
      }
      AppMethodBeat.o(11210);
      return "";
      label192:
      paramString2 = paramString1;
    }
  }
  
  public static p b(long paramLong, String paramString)
  {
    AppMethodBeat.i(11214);
    if (paramLong > 0L)
    {
      localp = (p)eka.get(Long.valueOf(paramLong));
      if (localp != null)
      {
        AppMethodBeat.o(11214);
        return localp;
      }
    }
    Object localObject1 = be.apC(paramString);
    if (localObject1 == null)
    {
      paramString = new p();
      AppMethodBeat.o(11214);
      return paramString;
    }
    int i = bo.getInt((String)((Map)localObject1).get(".msg.appmsg.mmreader.category.$type"), 0);
    paramString = bo.nullAsNil((String)((Map)localObject1).get(".msg.appmsg.mmreader.name"));
    int j = bo.getInt((String)((Map)localObject1).get(".msg.appmsg.mmreader.forbid_forward"), 0);
    int k = bo.getInt((String)((Map)localObject1).get(".msg.appmsg.mmreader.category.$count"), 0);
    Object localObject2 = (String)((Map)localObject1).get(".msg.commenturl");
    p localp = new p();
    localp.type = i;
    localp.name = paramString;
    localp.dGR = ((String)localObject2);
    localp.fjz = j;
    i = 0;
    while (i < k)
    {
      localObject2 = new q();
      Object localObject3 = new StringBuilder(".msg.appmsg.mmreader.category.item");
      label681:
      StringBuilder localStringBuilder;
      if (i == 0)
      {
        paramString = "";
        localObject3 = paramString;
        ((q)localObject2).title = ((String)((Map)localObject1).get((String)localObject3 + ".title"));
        ((q)localObject2).url = ((String)((Map)localObject1).get((String)localObject3 + ".url"));
        ((q)localObject2).fjH = ((String)((Map)localObject1).get((String)localObject3 + ".shorturl"));
        ((q)localObject2).fjI = ((String)((Map)localObject1).get((String)localObject3 + ".longurl"));
        ((q)localObject2).time = bo.getLong((String)((Map)localObject1).get((String)localObject3 + ".pub_time"), 0L);
        ((q)localObject2).fjK = ((String)((Map)localObject1).get((String)localObject3 + ".tweetid"));
        ((q)localObject2).fjL = ((String)((Map)localObject1).get((String)localObject3 + ".digest"));
        ((q)localObject2).type = bo.getInt((String)((Map)localObject1).get((String)localObject3 + ".itemshowtype"), 0);
        ((q)localObject2).fjN = bo.getInt((String)((Map)localObject1).get((String)localObject3 + ".play_length"), 0);
        ((q)localObject2).fjJ = ((String)((Map)localObject1).get((String)localObject3 + ".cover"));
        paramString = (String)((Map)localObject1).get((String)localObject3 + ".cover_235_1");
        if (((((q)localObject2).type != 5) && (!bo.isNullOrNil(paramString))) || (bo.isNullOrNil(((q)localObject2).fjJ))) {
          ((q)localObject2).fjJ = paramString;
        }
        j = 0;
        if (j >= 100) {
          break label780;
        }
        localStringBuilder = new StringBuilder().append((String)localObject3).append(".pic_urls.pic_url");
        if (j != 0) {
          break label771;
        }
      }
      label771:
      for (paramString = "";; paramString = String.valueOf(j))
      {
        paramString = (String)((Map)localObject1).get(paramString);
        if (bo.isNullOrNil(paramString)) {
          break label780;
        }
        ((q)localObject2).fkb.add(paramString);
        j += 1;
        break label681;
        paramString = String.valueOf(i);
        break;
      }
      label780:
      if (((q)localObject2).fkb.size() == 0) {
        ((q)localObject2).fkb.add(((q)localObject2).fjJ);
      }
      ((q)localObject2).fka = ((String)((Map)localObject1).get((String)localObject3 + ".cover_1_1"));
      ((q)localObject2).fjM = bo.getInt((String)((Map)localObject1).get((String)localObject3 + ".del_flag"), 0);
      ((q)localObject2).fjO = ((String)((Map)localObject1).get((String)localObject3 + ".weapp_username"));
      ((q)localObject2).fjP = ((String)((Map)localObject1).get((String)localObject3 + ".weapp_path"));
      ((q)localObject2).fjQ = bo.getInt((String)((Map)localObject1).get((String)localObject3 + ".weapp_version"), 0);
      ((q)localObject2).fjR = bo.getInt((String)((Map)localObject1).get((String)localObject3 + ".weapp_state"), 0);
      ((q)localObject2).fjS = ((String)((Map)localObject1).get((String)localObject3 + ".weapp_appid"));
      ((q)localObject2).fjT = ((String)((Map)localObject1).get((String)localObject3 + ".weapp_image_url"));
      ((q)localObject2).fjU = ((String)((Map)localObject1).get((String)localObject3 + ".weapp_icon"));
      ((q)localObject2).fjV = ((String)((Map)localObject1).get((String)localObject3 + ".weapp_nickname"));
      ((q)localObject2).fjW = ((String)((Map)localObject1).get((String)localObject3 + ".play_url"));
      ((q)localObject2).fjX = ((String)((Map)localObject1).get((String)localObject3 + ".player"));
      ((q)localObject2).fjY = bo.getInt((String)((Map)localObject1).get((String)localObject3 + ".music_source"), 1);
      ((q)localObject2).fjZ = bo.getInt((String)((Map)localObject1).get((String)localObject3 + ".pic_num"), 1);
      ((q)localObject2).videoWidth = bo.getInt((String)((Map)localObject1).get((String)localObject3 + ".video_width"), 0);
      ((q)localObject2).videoHeight = bo.getInt((String)((Map)localObject1).get((String)localObject3 + ".video_height"), 0);
      ((q)localObject2).fgl = ((String)((Map)localObject1).get((String)localObject3 + ".vid"));
      localp.fjy.add(localObject2);
      i += 1;
    }
    localp.fgn = com.tencent.mm.aj.j.p((Map)localObject1);
    paramString = bo.nullAsNil((String)((Map)localObject1).get(".msg.fromusername"));
    if (!bo.isNullOrNil(paramString))
    {
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(paramString).Oe();
      localp.cGN = paramString;
      localp.cGO = ((String)localObject1);
    }
    if (paramLong > 0L) {
      eka.f(Long.valueOf(paramLong), localp);
    }
    AppMethodBeat.o(11214);
    return localp;
  }
  
  public static String c(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 0;
    AppMethodBeat.i(11219);
    int j = s.getSessionId();
    if ((paramString == null) || (!paramString.contains("mp.weixin.qq.com")) || ((j <= 0) && (paramInt2 < 0) && (paramInt1 < 0) && (paramInt3 <= 0)))
    {
      AppMethodBeat.o(11219);
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
      if (paramInt2 >= 0) {
        str1 = paramString + "&subscene=" + paramInt2;
      }
      paramString = str1;
      if (j > 0) {
        paramString = str1 + "&sessionid=" + j;
      }
      str1 = paramString;
      if (paramInt3 > 0) {
        str1 = paramString + "&clicktime=" + paramInt3;
      }
      paramString = str1;
      if (i != 0) {
        paramString = str1.replace("?&", "?");
      }
      paramString = paramString + str3;
      AppMethodBeat.o(11219);
      return paramString;
      str1 = paramString;
    }
  }
  
  public static boolean c(long paramLong, String paramString)
  {
    AppMethodBeat.i(11217);
    if (paramString == null)
    {
      AppMethodBeat.o(11217);
      return false;
    }
    paramString = ((com.tencent.mm.plugin.biz.a.a)g.E(com.tencent.mm.plugin.biz.a.a.class)).b(paramLong, paramString);
    if (paramString == null)
    {
      ab.w("MicroMsg.AppMsgBizHelper", "isBizMsgForbidForward reader is null");
      AppMethodBeat.o(11217);
      return false;
    }
    if (paramString.fjz == 1)
    {
      AppMethodBeat.o(11217);
      return true;
    }
    AppMethodBeat.o(11217);
    return false;
  }
  
  public static String kq(int paramInt)
  {
    AppMethodBeat.i(11216);
    if ((paramInt <= 0) || (paramInt >= 86400L))
    {
      AppMethodBeat.o(11216);
      return null;
    }
    if (paramInt < 3600L) {}
    for (Object localObject = "mm:ss";; localObject = "HH:mm:ss")
    {
      localObject = new SimpleDateFormat((String)localObject);
      ((SimpleDateFormat)localObject).setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
      localObject = ((SimpleDateFormat)localObject).format(Long.valueOf(paramInt * 1000L));
      AppMethodBeat.o(11216);
      return localObject;
    }
  }
  
  public static boolean na(String paramString)
  {
    AppMethodBeat.i(11211);
    if ((paramString != null) && (paramString.endsWith("@app")))
    {
      AppMethodBeat.o(11211);
      return true;
    }
    AppMethodBeat.o(11211);
    return false;
  }
  
  public static String nb(String paramString)
  {
    AppMethodBeat.i(11212);
    Map localMap = br.F(paramString, "msg");
    if (localMap == null)
    {
      ab.e("MicroMsg.AppMsgBizHelper", "getAppMsgDyeingTempTitle fail, values is null");
      AppMethodBeat.o(11212);
      return " ";
    }
    bo.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_show_type"), 0);
    bo.bf((String)localMap.get(".msg.appmsg.ext_pay_info.pay_type"), "");
    String str = bo.nullAsNil((String)localMap.get(".msg.appmsg.title"));
    paramString = str;
    if (bo.isNullOrNil(str)) {
      paramString = (String)localMap.get(".msg.appmsg.mmreader.category.item.title");
    }
    str = paramString;
    if (bo.isNullOrNil(paramString)) {
      str = " ";
    }
    AppMethodBeat.o(11212);
    return str;
  }
  
  public static String nc(String paramString)
  {
    AppMethodBeat.i(11213);
    paramString = be.apC(paramString);
    if (paramString == null)
    {
      Object localObject = new p();
      paramString = new StringBuilder("");
      localObject = ((p)localObject).fjy.iterator();
      while (((Iterator)localObject).hasNext())
      {
        q localq = (q)((Iterator)localObject).next();
        if (!bo.isNullOrNil(localq.title)) {
          paramString.append(localq.title);
        }
      }
      paramString = paramString.toString();
      AppMethodBeat.o(11213);
      return paramString;
    }
    paramString = (String)paramString.get(".msg.appmsg.mmreader.category.item.title");
    if (paramString == null)
    {
      AppMethodBeat.o(11213);
      return "";
    }
    AppMethodBeat.o(11213);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.af.l
 * JD-Core Version:    0.7.0.1
 */