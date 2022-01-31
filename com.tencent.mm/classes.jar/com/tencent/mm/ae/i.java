package com.tencent.mm.ae;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mm.a.f;
import com.tencent.mm.ag.h;
import com.tencent.mm.ag.o;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.sdk.platformtools.ba;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

public final class i
{
  private static final f<Long, l> dss = new f(50);
  
  public static String N(String paramString1, String paramString2)
  {
    paramString1 = bn.s(paramString1, "msg");
    if (paramString1 == null)
    {
      y.e("MicroMsg.AppMsgBizHelper", "getAppMsgDyeingTempFromUser fail, values is null");
      paramString1 = null;
      if ((!bk.bl(paramString1)) || (com.tencent.mm.model.s.hK(paramString2))) {
        break label115;
      }
    }
    for (;;)
    {
      if (!bk.bl(paramString2))
      {
        if (gr(paramString2))
        {
          paramString1 = ((c)g.r(c.class)).so(paramString2);
          if ((paramString1 != null) && (!TextUtils.isEmpty(paramString1.field_nickname)))
          {
            return paramString1.field_nickname;
            paramString1 = (String)paramString1.get(".msg.fromusername");
            break;
          }
        }
        return ((b)g.r(b.class)).gV(paramString2);
      }
      return "";
      label115:
      paramString2 = paramString1;
    }
  }
  
  public static String a(Context paramContext, int paramInt, String paramString1, String paramString2, long paramLong)
  {
    if (paramContext == null)
    {
      y.w("MicroMsg.AppMsgBizHelper", "getReaderAppMsgContent: context is null");
      return null;
    }
    if ((paramString1 == null) || (paramString2 == null))
    {
      y.w("MicroMsg.AppMsgBizHelper", "getReaderAppMsgContent: msg is null");
      return null;
    }
    g.DQ();
    if (!g.DP().isSDCardAvailable())
    {
      com.tencent.mm.ui.base.s.gM(paramContext);
      return null;
    }
    try
    {
      paramContext = ((a)g.r(a.class)).d(paramLong, paramString1);
      paramString1 = paramContext.dTx;
      if ((paramString1 != null) && (paramString1.size() > 0) && (paramInt < paramString1.size()))
      {
        m localm = (m)paramString1.get(paramInt);
        paramString1 = new g.a();
        paramString1.title = localm.title;
        paramString1.description = localm.dTF;
        paramString1.action = "view";
        paramString1.type = 5;
        paramString1.url = localm.url;
        paramString1.bYG = paramContext.bYG;
        paramString1.bYH = paramContext.bYH;
        paramString1.cQF = paramContext.cQF;
        paramString1.thumburl = localm.dTD;
        if (bk.bl(paramString1.thumburl))
        {
          paramContext = o.Kh().kp(paramString2);
          if (paramContext != null) {
            paramString1.thumburl = paramContext.JX();
          }
        }
        paramContext = g.a.a(paramString1, null, null);
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      y.printErrStackTrace("MicroMsg.AppMsgBizHelper", paramContext, "", new Object[0]);
      y.e("MicroMsg.AppMsgBizHelper", "retransmit app msg error : %s", new Object[] { paramContext.getLocalizedMessage() });
    }
    return null;
  }
  
  public static l d(long paramLong, String paramString)
  {
    if (paramLong > 0L)
    {
      locall = (l)dss.get(Long.valueOf(paramLong));
      if (locall != null) {
        return locall;
      }
    }
    Object localObject1 = ba.Zx(paramString);
    if (localObject1 == null) {
      return gu(paramString);
    }
    int i = bk.getInt((String)((Map)localObject1).get(".msg.appmsg.mmreader.category.$type"), 0);
    paramString = bk.pm((String)((Map)localObject1).get(".msg.appmsg.mmreader.name"));
    int k = bk.getInt((String)((Map)localObject1).get(".msg.appmsg.mmreader.forbid_forward"), 0);
    int j = bk.getInt((String)((Map)localObject1).get(".msg.appmsg.mmreader.category.$count"), 0);
    Object localObject2 = (String)((Map)localObject1).get(".msg.commenturl");
    l locall = new l();
    locall.type = i;
    locall.name = paramString;
    locall.cQF = ((String)localObject2);
    locall.dTy = k;
    i = 0;
    if (i < j)
    {
      localObject2 = new m();
      Object localObject3 = new StringBuilder(".msg.appmsg.mmreader.category.item");
      if (i == 0) {}
      for (paramString = "";; paramString = String.valueOf(i))
      {
        paramString = paramString;
        ((m)localObject2).title = ((String)((Map)localObject1).get(paramString + ".title"));
        ((m)localObject2).url = ((String)((Map)localObject1).get(paramString + ".url"));
        ((m)localObject2).dTB = ((String)((Map)localObject1).get(paramString + ".shorturl"));
        ((m)localObject2).dTC = ((String)((Map)localObject1).get(paramString + ".longurl"));
        ((m)localObject2).time = bk.getLong((String)((Map)localObject1).get(paramString + ".pub_time"), 0L);
        ((m)localObject2).dTE = ((String)((Map)localObject1).get(paramString + ".tweetid"));
        ((m)localObject2).dTF = ((String)((Map)localObject1).get(paramString + ".digest"));
        ((m)localObject2).type = bk.getInt((String)((Map)localObject1).get(paramString + ".itemshowtype"), 0);
        ((m)localObject2).dTH = bk.getInt((String)((Map)localObject1).get(paramString + ".play_length"), 0);
        ((m)localObject2).dTD = ((String)((Map)localObject1).get(paramString + ".cover"));
        localObject3 = (String)((Map)localObject1).get(paramString + ".cover_235_1");
        if (!bk.bl((String)localObject3)) {
          ((m)localObject2).dTD = ((String)localObject3);
        }
        ((m)localObject2).dTU = ((String)((Map)localObject1).get(paramString + ".cover_1_1"));
        ((m)localObject2).dTG = bk.getInt((String)((Map)localObject1).get(paramString + ".del_flag"), 0);
        ((m)localObject2).dTI = ((String)((Map)localObject1).get(paramString + ".weapp_username"));
        ((m)localObject2).dTJ = ((String)((Map)localObject1).get(paramString + ".weapp_path"));
        ((m)localObject2).dTK = bk.getInt((String)((Map)localObject1).get(paramString + ".weapp_version"), 0);
        ((m)localObject2).dTL = bk.getInt((String)((Map)localObject1).get(paramString + ".weapp_state"), 0);
        ((m)localObject2).dTM = ((String)((Map)localObject1).get(paramString + ".weapp_appid"));
        ((m)localObject2).dTN = ((String)((Map)localObject1).get(paramString + ".weapp_image_url"));
        ((m)localObject2).dTO = ((String)((Map)localObject1).get(paramString + ".weapp_icon"));
        ((m)localObject2).dTP = ((String)((Map)localObject1).get(paramString + ".weapp_nickname"));
        ((m)localObject2).dTQ = ((String)((Map)localObject1).get(paramString + ".play_url"));
        ((m)localObject2).dTR = ((String)((Map)localObject1).get(paramString + ".player"));
        ((m)localObject2).dTS = bk.getInt((String)((Map)localObject1).get(paramString + ".music_source"), 1);
        ((m)localObject2).dTT = bk.getInt((String)((Map)localObject1).get(paramString + ".pic_num"), 1);
        locall.dTx.add(localObject2);
        i += 1;
        break;
      }
    }
    locall.dQr = com.tencent.mm.ai.j.l((Map)localObject1);
    paramString = bk.pm((String)((Map)localObject1).get(".msg.fromusername"));
    if (!bk.bl(paramString))
    {
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(paramString).Bp();
      locall.bYG = paramString;
      locall.bYH = ((String)localObject1);
    }
    if (paramLong > 0L) {
      dss.f(Long.valueOf(paramLong), locall);
    }
    return locall;
  }
  
  public static boolean e(long paramLong, String paramString)
  {
    if (paramString == null) {
      return false;
    }
    paramString = ((a)g.r(a.class)).d(paramLong, paramString);
    if (paramString == null)
    {
      y.w("MicroMsg.AppMsgBizHelper", "isBizMsgForbidForward reader is null");
      return false;
    }
    return paramString.dTy == 1;
  }
  
  public static String g(String paramString, int paramInt1, int paramInt2)
  {
    int i = com.tencent.mm.storage.s.getSessionId();
    if ((paramString == null) || ((i <= 0) && (paramInt2 < 0) && (paramInt1 < 0))) {
      return paramString;
    }
    String str2 = "";
    int j = paramString.indexOf("#");
    String str1;
    if (j > 0)
    {
      str1 = paramString.substring(0, j);
      str2 = paramString.substring(j);
      paramString = str1;
    }
    for (;;)
    {
      str1 = paramString;
      if (paramInt1 >= 0) {
        str1 = paramString + "&scene=" + paramInt1;
      }
      paramString = str1;
      if (paramInt2 >= 0) {
        paramString = str1 + "&subscene=" + paramInt2;
      }
      str1 = paramString;
      if (i > 0) {
        str1 = paramString + "&sessionid=" + i;
      }
      return str1 + str2;
    }
  }
  
  public static boolean gr(String paramString)
  {
    return (paramString != null) && (paramString.endsWith("@app"));
  }
  
  public static String gs(String paramString)
  {
    Map localMap = bn.s(paramString, "msg");
    if (localMap == null)
    {
      y.e("MicroMsg.AppMsgBizHelper", "getAppMsgDyeingTempTitle fail, values is null");
      paramString = " ";
      return paramString;
    }
    int i = bk.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_show_type"), 0);
    String str = bk.aM((String)localMap.get(".msg.appmsg.ext_pay_info.pay_type"), "");
    paramString = null;
    if ((str.equals("wx_f2f")) || (str.equals("wx_md"))) {
      paramString = bk.pm((String)localMap.get(".msg.appmsg.title"));
    }
    for (;;)
    {
      str = paramString;
      if (bk.bl(paramString)) {
        str = (String)localMap.get(".msg.appmsg.mmreader.category.item.title");
      }
      paramString = str;
      if (!bk.bl(str)) {
        break;
      }
      return " ";
      if (i != 0) {
        paramString = bk.pm((String)localMap.get(".msg.appmsg.mmreader.template_header.title"));
      }
    }
  }
  
  public static String gt(String paramString)
  {
    Object localObject = ba.Zx(paramString);
    if (localObject == null)
    {
      localObject = gu(paramString);
      paramString = new StringBuilder("");
      localObject = ((l)localObject).dTx.iterator();
      while (((Iterator)localObject).hasNext())
      {
        m localm = (m)((Iterator)localObject).next();
        if (!bk.bl(localm.title)) {
          paramString.append(localm.title);
        }
      }
      paramString = paramString.toString();
    }
    do
    {
      return paramString;
      localObject = (String)((Map)localObject).get(".msg.appmsg.mmreader.category.item.title");
      paramString = (String)localObject;
    } while (localObject != null);
    return "";
  }
  
  private static l gu(String paramString)
  {
    try
    {
      l locall = (l)new l().aH(Base64.decode(paramString, 0));
      return locall;
    }
    catch (Exception localException)
    {
      try
      {
        paramString = (l)new l().aH(bk.ZM(paramString));
        return paramString;
      }
      catch (Exception paramString) {}
    }
    return new l();
  }
  
  public static String hF(int paramInt)
  {
    if ((paramInt <= 0) || (paramInt >= 86400L)) {
      return null;
    }
    if (paramInt < 3600L) {}
    for (Object localObject = "mm:ss";; localObject = "HH:mm:ss")
    {
      localObject = new SimpleDateFormat((String)localObject);
      ((SimpleDateFormat)localObject).setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
      return ((SimpleDateFormat)localObject).format(Long.valueOf(paramInt * 1000L));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ae.i
 * JD-Core Version:    0.7.0.1
 */