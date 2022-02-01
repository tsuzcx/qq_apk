package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.cc;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class bt
{
  private static float omA;
  public static int omv;
  private static ConcurrentHashMap<Long, String> omw;
  private static int omx;
  private static float omy;
  private static float omz;
  
  static
  {
    AppMethodBeat.i(150189);
    omv = 0;
    omw = new ConcurrentHashMap();
    omx = 1;
    omy = 0.75F;
    omz = 0.4F;
    omA = 0.5F;
    AppMethodBeat.o(150189);
  }
  
  public static String A(Map<String, String> paramMap)
  {
    AppMethodBeat.i(150185);
    int i = Util.safeParseInt((String)paramMap.get(".msgsource.sec_msg_node.sfn"));
    String str1 = Util.nullAsNil((String)paramMap.get(".msgsource.sec_msg_node.show-h5"));
    int j = Util.safeParseInt((String)paramMap.get(".msgsource.sec_msg_node.clip-len"));
    String str2 = Util.nullAsNil((String)paramMap.get(".msgsource.sec_msg_node.share-tip-url"));
    int k = Util.safeParseInt((String)paramMap.get(".msgsource.sec_msg_node.fold-reduce"));
    int m = Util.safeParseInt((String)paramMap.get(".msgsource.sec_msg_node.media-to-emoji"));
    int n = Util.safeParseInt((String)paramMap.get(".msgsource.sec_msg_node.block-range"));
    int i1 = Util.safeParseInt((String)paramMap.get(".msgsource.sec_msg_node.bubble-type"));
    int i2 = Util.safeParseInt((String)paramMap.get(".msgsource.sec_msg_node.preview-type"));
    int i3 = Util.safeParseInt((String)paramMap.get(".msgsource.sec_msg_node.url-click-type"));
    paramMap = new StringBuilder();
    paramMap.append("<sec_msg_node>");
    paramMap.append("<sfn>").append(i).append("</sfn>");
    paramMap.append("<show-h5><![CDATA[").append(str1).append("]]></show-h5>");
    paramMap.append("<clip-len>").append(j).append("</clip-len>");
    paramMap.append("<share-tip-url><![CDATA[").append(str2).append("]]></share-tip-url>");
    paramMap.append("<fold-reduce>").append(k).append("</fold-reduce>");
    paramMap.append("<media-to-emoji>").append(m).append("</media-to-emoji>");
    paramMap.append("<block-range>").append(n).append("</block-range>");
    paramMap.append("<bubble-type>").append(i1).append("</bubble-type>");
    paramMap.append("<preview-type>").append(i2).append("</preview-type>");
    paramMap.append("<url-click-type>").append(i3).append("</url-click-type>");
    paramMap.append("</sec_msg_node>");
    paramMap = paramMap.toString();
    AppMethodBeat.o(150185);
    return paramMap;
  }
  
  public static String B(Map<String, String> paramMap)
  {
    AppMethodBeat.i(163513);
    int i = Util.safeParseInt((String)paramMap.get(".msgsource.alnode.cf"));
    paramMap = (String)paramMap.get(".msgsource.alnode.inlenlist");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<alnode>");
    localStringBuilder.append("<cf>").append(i).append("</cf>");
    if (!Util.isNullOrNil(paramMap)) {
      localStringBuilder.append("<inlenlist>").append(paramMap).append("</inlenlist>");
    }
    localStringBuilder.append("</alnode>");
    paramMap = localStringBuilder.toString();
    AppMethodBeat.o(163513);
    return paramMap;
  }
  
  public static int E(cc paramcc)
  {
    AppMethodBeat.i(150172);
    if (paramcc == null)
    {
      AppMethodBeat.o(150172);
      return 0;
    }
    paramcc = XmlParser.parseXml(paramcc.jUr, "msgsource", null);
    if (paramcc != null)
    {
      paramcc = (String)paramcc.get(".msgsource.bizflag");
      if (Util.isNullOrNil(paramcc)) {}
    }
    for (int i = Util.getInt(paramcc, 0);; i = 0)
    {
      AppMethodBeat.o(150172);
      return i;
    }
  }
  
  public static void F(String paramString, long paramLong)
  {
    AppMethodBeat.i(150184);
    if ((!Util.isNullOrNil(paramString)) && (paramLong > 0L) && (omw.containsKey(Long.valueOf(paramLong))))
    {
      paramString = ((n)h.ax(n.class)).gaZ().aU(paramString, paramLong);
      if ((paramString != null) && (!Util.isNullOrNil(paramString.field_talker)) && (paramString.field_msgSvrId > 0L))
      {
        Log.i("MicroMsg.MsgSourceHelper", "found sec msg of %s", new Object[] { Long.valueOf(paramLong) });
        c(paramString, (String)omw.get(Long.valueOf(paramLong)));
        omw.remove(Long.valueOf(paramLong));
      }
    }
    AppMethodBeat.o(150184);
  }
  
  public static boolean F(cc paramcc)
  {
    AppMethodBeat.i(150174);
    if (P(paramcc) == 2)
    {
      AppMethodBeat.o(150174);
      return true;
    }
    if ((paramcc != null) && (!Util.isNullOrNil(paramcc.jUr)))
    {
      paramcc = XmlParser.parseXml(paramcc.jUr, "msgsource", null);
      if ((paramcc != null) && (Util.safeParseInt((String)paramcc.get(".msgsource.sec_msg_node.sfn")) == 1))
      {
        AppMethodBeat.o(150174);
        return true;
      }
    }
    AppMethodBeat.o(150174);
    return false;
  }
  
  public static int G(cc paramcc)
  {
    int i = 0;
    AppMethodBeat.i(242034);
    if (omx == 0)
    {
      AppMethodBeat.o(242034);
      return 0;
    }
    int j;
    if ((paramcc != null) && (!Util.isNullOrNil(paramcc.jUr)))
    {
      paramcc = XmlParser.parseXml(paramcc.jUr, "msgsource", null);
      if (paramcc != null)
      {
        j = Util.getInt((String)paramcc.get(".msgsource.sec_msg_node.media-to-emoji"), 0);
        if (j <= 1) {
          break label117;
        }
        if (z(paramcc) == 0)
        {
          if (paramcc != null) {
            i = Util.getInt((String)paramcc.get(".msgsource.sec_msg_node.preview-type"), 0);
          }
          if (i == 0) {
            break label117;
          }
        }
      }
    }
    label117:
    for (i = 1;; i = j)
    {
      AppMethodBeat.o(242034);
      return i;
      AppMethodBeat.o(242034);
      return 0;
    }
  }
  
  public static boolean H(cc paramcc)
  {
    AppMethodBeat.i(242039);
    if (G(paramcc) > 0)
    {
      AppMethodBeat.o(242039);
      return true;
    }
    AppMethodBeat.o(242039);
    return false;
  }
  
  public static boolean I(cc paramcc)
  {
    AppMethodBeat.i(242042);
    int i = G(paramcc);
    if ((i == 2) || (i == 4))
    {
      AppMethodBeat.o(242042);
      return true;
    }
    AppMethodBeat.o(242042);
    return false;
  }
  
  public static boolean J(cc paramcc)
  {
    AppMethodBeat.i(242043);
    int i = G(paramcc);
    if ((i == 3) || (i == 4))
    {
      AppMethodBeat.o(242043);
      return true;
    }
    AppMethodBeat.o(242043);
    return false;
  }
  
  public static long JR(String paramString)
  {
    AppMethodBeat.i(242128);
    if ((paramString != null) && (!Util.isNullOrNil(paramString)))
    {
      paramString = XmlParser.parseXml(paramString, "msgsource", null);
      if (paramString != null)
      {
        long l = Util.safeParseLong((String)paramString.get(".msgsource.share_msg.svrid"));
        AppMethodBeat.o(242128);
        return l;
      }
    }
    AppMethodBeat.o(242128);
    return -1L;
  }
  
  public static long JS(String paramString)
  {
    AppMethodBeat.i(242131);
    if ((paramString != null) && (!Util.isNullOrNil(paramString)))
    {
      paramString = XmlParser.parseXml(paramString, "msgsource", null);
      if (paramString != null)
      {
        long l = Util.safeParseLong((String)paramString.get(".msgsource.share_msg.newsvrid"));
        AppMethodBeat.o(242131);
        return l;
      }
    }
    AppMethodBeat.o(242131);
    return -1L;
  }
  
  public static long JT(String paramString)
  {
    AppMethodBeat.i(242132);
    if ((paramString != null) && (!Util.isNullOrNil(paramString)))
    {
      paramString = XmlParser.parseXml(paramString, "msgsource", null);
      if (paramString != null)
      {
        long l = Util.safeParseLong((String)paramString.get(".msgsource.share_msg.createtime"));
        AppMethodBeat.o(242132);
        return l * 1000L;
      }
    }
    AppMethodBeat.o(242132);
    return -1L;
  }
  
  public static void JU(String paramString)
  {
    AppMethodBeat.i(150188);
    Log.i("MicroMsg.MsgSourceHelper", "parseMsgSource  has been Deprecated  by dk. at 20151218 [%s] %s ", new Object[] { paramString, "" });
    AppMethodBeat.o(150188);
  }
  
  public static String JV(String paramString)
  {
    AppMethodBeat.i(163514);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(163514);
      return null;
    }
    paramString = XmlParser.parseXml(paramString, "msgsource", null);
    if (paramString != null)
    {
      paramString = (String)paramString.get(".msgsource.sec_msg_node.uuid");
      AppMethodBeat.o(163514);
      return paramString;
    }
    AppMethodBeat.o(163514);
    return null;
  }
  
  public static String JW(String paramString)
  {
    AppMethodBeat.i(163515);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(163515);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<msgsource><sec_msg_node><uuid>").append(paramString).append("</uuid></sec_msg_node></msgsource>");
    paramString = localStringBuilder.toString();
    AppMethodBeat.o(163515);
    return paramString;
  }
  
  public static float K(cc paramcc)
  {
    AppMethodBeat.i(242044);
    if (!H(paramcc))
    {
      AppMethodBeat.o(242044);
      return 1.0F;
    }
    float f = omy;
    AppMethodBeat.o(242044);
    return f;
  }
  
  public static float L(cc paramcc)
  {
    AppMethodBeat.i(242045);
    if (!H(paramcc))
    {
      AppMethodBeat.o(242045);
      return 1.0F;
    }
    float f = omz;
    AppMethodBeat.o(242045);
    return f;
  }
  
  public static float M(cc paramcc)
  {
    AppMethodBeat.i(242047);
    if (!H(paramcc))
    {
      AppMethodBeat.o(242047);
      return 1.0F;
    }
    float f = omA;
    AppMethodBeat.o(242047);
    return f;
  }
  
  public static boolean N(cc paramcc)
  {
    AppMethodBeat.i(150175);
    if (paramcc != null)
    {
      int i = Z(paramcc);
      if ((paramcc.iYl()) && (i >= 3))
      {
        AppMethodBeat.o(150175);
        return true;
      }
      if ((paramcc.iYk()) && (i >= 2))
      {
        AppMethodBeat.o(150175);
        return true;
      }
    }
    AppMethodBeat.o(150175);
    return false;
  }
  
  public static void O(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(150170);
    if ("bizflag".equals(paramString))
    {
      if (paramBoolean)
      {
        omv |= 0x1;
        AppMethodBeat.o(150170);
        return;
      }
      omv &= 0xFFFFFFFE;
    }
    AppMethodBeat.o(150170);
  }
  
  public static boolean O(cc paramcc)
  {
    AppMethodBeat.i(150176);
    if (paramcc != null)
    {
      int i = Z(paramcc);
      if ((paramcc.iYl()) && (i > 3))
      {
        AppMethodBeat.o(150176);
        return true;
      }
      if ((paramcc.iYk()) && (i > 2))
      {
        AppMethodBeat.o(150176);
        return true;
      }
    }
    AppMethodBeat.o(150176);
    return false;
  }
  
  private static int P(cc paramcc)
  {
    AppMethodBeat.i(242066);
    if ((paramcc != null) && (!Util.isNullOrNil(paramcc.jUr)))
    {
      paramcc = XmlParser.parseXml(paramcc.jUr, "msgsource", null);
      if (paramcc != null)
      {
        int i = Util.getInt((String)paramcc.get(".msgsource.sec_msg_node.bubble-type"), 0);
        AppMethodBeat.o(242066);
        return i;
      }
    }
    AppMethodBeat.o(242066);
    return 0;
  }
  
  public static boolean Q(cc paramcc)
  {
    AppMethodBeat.i(242074);
    if (P(paramcc) == 1)
    {
      AppMethodBeat.o(242074);
      return true;
    }
    AppMethodBeat.o(242074);
    return false;
  }
  
  private static int R(cc paramcc)
  {
    AppMethodBeat.i(242082);
    if ((paramcc != null) && (!Util.isNullOrNil(paramcc.jUr)))
    {
      paramcc = XmlParser.parseXml(paramcc.jUr, "msgsource", null);
      if (paramcc != null)
      {
        int i = Util.getInt((String)paramcc.get(".msgsource.sec_msg_node.preview-type"), 0);
        AppMethodBeat.o(242082);
        return i;
      }
    }
    AppMethodBeat.o(242082);
    return 0;
  }
  
  public static boolean S(cc paramcc)
  {
    AppMethodBeat.i(242087);
    if (R(paramcc) == 1)
    {
      AppMethodBeat.o(242087);
      return true;
    }
    AppMethodBeat.o(242087);
    return false;
  }
  
  public static boolean T(cc paramcc)
  {
    AppMethodBeat.i(242089);
    if (R(paramcc) == 2)
    {
      AppMethodBeat.o(242089);
      return true;
    }
    AppMethodBeat.o(242089);
    return false;
  }
  
  public static boolean U(cc paramcc)
  {
    AppMethodBeat.i(242094);
    if ((paramcc != null) && (!Util.isNullOrNil(paramcc.jUr)))
    {
      paramcc = XmlParser.parseXml(paramcc.jUr, "msgsource", null);
      if (paramcc != null)
      {
        if (Util.getInt((String)paramcc.get(".msgsource.sec_msg_node.url-click-type"), 0) != 0)
        {
          AppMethodBeat.o(242094);
          return true;
        }
        AppMethodBeat.o(242094);
        return false;
      }
    }
    AppMethodBeat.o(242094);
    return false;
  }
  
  public static void V(cc paramcc)
  {
    AppMethodBeat.i(150177);
    if (!Util.isNullOrNil(paramcc.jUr))
    {
      Object localObject = XmlParser.parseXml(paramcc.jUr, "msgsource", null);
      if ((localObject != null) && (Util.safeParseInt((String)((Map)localObject).get(".msgsource.sec_msg_node.sfn")) == 1)) {
        try
        {
          localObject = paramcc.jUr.substring(paramcc.jUr.indexOf("<sec_msg_node"), paramcc.jUr.indexOf("</sec_msg_node") + 12 + 2);
          Log.i("MicroMsg.MsgSourceHelper", (String)localObject);
          if (!Util.isNullOrNil((String)localObject))
          {
            String str = ((String)localObject).substring(((String)localObject).indexOf("<sfn"), ((String)localObject).indexOf("</sfn") + 3 + 2);
            paramcc.AU(paramcc.jUr.replace((CharSequence)localObject, ((String)localObject).replace(str, "<sfn>0<sfn/>")));
          }
          AppMethodBeat.o(150177);
          return;
        }
        catch (Exception paramcc)
        {
          Log.printErrStackTrace("MicroMsg.MsgSourceHelper", paramcc, "resetShareForbidden msg exception", new Object[0]);
        }
      }
    }
    AppMethodBeat.o(150177);
  }
  
  public static String W(cc paramcc)
  {
    AppMethodBeat.i(150178);
    if ((paramcc != null) && (!Util.isNullOrNil(paramcc.jUr)))
    {
      paramcc = XmlParser.parseXml(paramcc.jUr, "msgsource", null);
      if (paramcc != null)
      {
        paramcc = (String)paramcc.get(".msgsource.sec_msg_node.show-h5");
        if (!Util.isNullOrNil(paramcc))
        {
          AppMethodBeat.o(150178);
          return paramcc;
        }
      }
    }
    AppMethodBeat.o(150178);
    return "";
  }
  
  public static String X(cc paramcc)
  {
    AppMethodBeat.i(150179);
    if ((paramcc != null) && (!Util.isNullOrNil(paramcc.jUr)))
    {
      paramcc = XmlParser.parseXml(paramcc.jUr, "msgsource", null);
      if (paramcc != null)
      {
        paramcc = (String)paramcc.get(".msgsource.sec_msg_node.share-tip-url");
        if (!Util.isNullOrNil(paramcc))
        {
          AppMethodBeat.o(150179);
          return paramcc;
        }
      }
    }
    AppMethodBeat.o(150179);
    return "";
  }
  
  public static int Y(cc paramcc)
  {
    AppMethodBeat.i(150180);
    if ((paramcc != null) && (!Util.isNullOrNil(paramcc.jUr)))
    {
      paramcc = XmlParser.parseXml(paramcc.jUr, "msgsource", null);
      if (paramcc != null)
      {
        int i = Util.safeParseInt((String)paramcc.get(".msgsource.sec_msg_node.clip-len"));
        AppMethodBeat.o(150180);
        return i;
      }
    }
    AppMethodBeat.o(150180);
    return 0;
  }
  
  public static int Z(cc paramcc)
  {
    AppMethodBeat.i(150182);
    if ((paramcc != null) && (!Util.isNullOrNil(paramcc.jUr)))
    {
      paramcc = XmlParser.parseXml(paramcc.jUr, "msgsource", null);
      if (paramcc != null)
      {
        int j = Util.safeParseInt((String)paramcc.get(".msgsource.sec_msg_node.fold-reduce"));
        int i = j;
        if (j > 1)
        {
          i = j;
          if (z(paramcc) != 0) {
            i = 1;
          }
        }
        AppMethodBeat.o(150182);
        return i;
      }
    }
    AppMethodBeat.o(150182);
    return 0;
  }
  
  public static boolean aa(cc paramcc)
  {
    AppMethodBeat.i(242106);
    if ((paramcc != null) && (!Util.isNullOrNil(paramcc.jUr)))
    {
      paramcc = XmlParser.parseXml(paramcc.jUr, "msgsource", null);
      if (paramcc != null)
      {
        if (Util.safeParseInt((String)paramcc.get(".msgsource.sec_msg_node.block-range")) != 0)
        {
          AppMethodBeat.o(242106);
          return true;
        }
        AppMethodBeat.o(242106);
        return false;
      }
    }
    AppMethodBeat.o(242106);
    return false;
  }
  
  public static String ab(cc paramcc)
  {
    AppMethodBeat.i(242133);
    String str = (String)h.baE().ban().d(70, null);
    if (!Util.isNullOrNil(str)) {
      h.baE().ban().B(70, "");
    }
    Log.d("MicroMsg.MsgSourceHelper", "getMsg ccr[%s]", new Object[] { str });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<msgsource>");
    localStringBuilder.append(Util.nullAsNil(str));
    if (omv != 0)
    {
      localStringBuilder.append("<");
      localStringBuilder.append("bizflag");
      localStringBuilder.append(">");
      localStringBuilder.append(omv);
      localStringBuilder.append("</");
      localStringBuilder.append("bizflag");
      localStringBuilder.append(">");
    }
    if (paramcc != null)
    {
      paramcc = JV(paramcc.jUr);
      if (!Util.isNullOrNil(paramcc))
      {
        localStringBuilder.append("<sec_msg_node>");
        localStringBuilder.append("<uuid>");
        localStringBuilder.append(paramcc);
        localStringBuilder.append("</uuid>");
        localStringBuilder.append("</sec_msg_node>");
      }
    }
    localStringBuilder.append("</msgsource>");
    paramcc = localStringBuilder.toString();
    if ("<msgsource></msgsource>".equals(paramcc))
    {
      AppMethodBeat.o(242133);
      return "";
    }
    Log.d("MicroMsg.MsgSourceHelper", "getAndResetMsgSrcIn msgsource[%s]", new Object[] { paramcc });
    AppMethodBeat.o(242133);
    return paramcc;
  }
  
  public static String b(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(242125);
    String str;
    if (!Util.isNullOrNil(paramString))
    {
      str = paramString;
      if (paramString.trim().startsWith("<msgsource>")) {}
    }
    else
    {
      str = "<msgsource></msgsource>";
    }
    paramString = new StringBuilder();
    paramString.append("<share_msg>");
    paramString.append("<createtime>").append(paramLong1 / 1000L).append("</createtime>");
    paramString.append("<svrid>").append(paramLong2).append("</svrid>");
    paramString.append("<newsvrid>").append(paramLong3).append("</newsvrid>");
    paramString.append("</share_msg>");
    paramString = str.replaceAll("(?s)<share_msg[^>]*>.*?</share_msg>", "").replace("</msgsource>", paramString + "</msgsource>");
    AppMethodBeat.o(242125);
    return paramString;
  }
  
  public static void b(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    omx = paramInt;
    omy = paramFloat1;
    omz = paramFloat2;
    omA = paramFloat3;
  }
  
  public static void b(cc paramcc, int paramInt)
  {
    AppMethodBeat.i(163510);
    if ((paramcc != null) && (!Util.isNullOrNil(paramcc.jUr)))
    {
      Map localMap = XmlParser.parseXml(paramcc.jUr, "msgsource", null);
      if (localMap != null)
      {
        localMap.put(".msgsource.sec_msg_node.clip-len", String.valueOf(paramInt));
        c(paramcc, A(localMap));
      }
    }
    AppMethodBeat.o(163510);
  }
  
  public static String bCP()
  {
    AppMethodBeat.i(150171);
    Object localObject = new StringBuilder();
    if (omv != 0)
    {
      ((StringBuilder)localObject).append("<");
      ((StringBuilder)localObject).append("bizflag");
      ((StringBuilder)localObject).append(">");
      ((StringBuilder)localObject).append(omv);
      ((StringBuilder)localObject).append("</");
      ((StringBuilder)localObject).append("bizflag");
      ((StringBuilder)localObject).append(">");
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(150171);
    return localObject;
  }
  
  public static String bCQ()
  {
    AppMethodBeat.i(150173);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Util.nullAsNil(bCP()));
    if (((StringBuilder)localObject).length() > 0)
    {
      ((StringBuilder)localObject).insert(0, "<msgsource>");
      ((StringBuilder)localObject).append("</msgsource>");
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(150173);
      return localObject;
    }
    AppMethodBeat.o(150173);
    return null;
  }
  
  public static String bCR()
  {
    AppMethodBeat.i(150187);
    String str = ab(null);
    AppMethodBeat.o(150187);
    return str;
  }
  
  public static void c(cc paramcc, String paramString)
  {
    AppMethodBeat.i(163511);
    if (paramcc != null)
    {
      String str2 = paramcc.jUr;
      String str1;
      if (!Util.isNullOrNil(str2))
      {
        str1 = str2;
        if (str2.trim().startsWith("<msgsource>")) {}
      }
      else
      {
        str1 = "<msgsource></msgsource>";
      }
      paramcc.AU(str1.replaceAll("(?s)<sec_msg_node[^>]*>.*?</sec_msg_node>", "").replace("</msgsource>", paramString + "</msgsource>"));
      ((n)h.ax(n.class)).gaZ().b(paramcc.field_msgSvrId, paramcc);
    }
    AppMethodBeat.o(163511);
  }
  
  public static void d(cc paramcc, String paramString)
  {
    AppMethodBeat.i(163512);
    String str2 = paramcc.jUr;
    String str1;
    if (!Util.isNullOrNil(str2))
    {
      str1 = str2;
      if (str2.trim().startsWith("<msgsource>")) {}
    }
    else
    {
      str1 = "<msgsource></msgsource>";
    }
    paramcc.AU(str1.replaceAll("(?s)<alnode[^>]*>.*?</alnode>", "").replace("</msgsource>", paramString + "</msgsource>"));
    AppMethodBeat.o(163512);
  }
  
  public static void f(long paramLong, String paramString)
  {
    AppMethodBeat.i(150183);
    if ((paramLong > 0L) && (!Util.isNullOrNil(paramString))) {
      omw.put(Long.valueOf(paramLong), paramString);
    }
    AppMethodBeat.o(150183);
  }
  
  private static int z(Map<String, String> paramMap)
  {
    AppMethodBeat.i(242058);
    if (paramMap != null)
    {
      int i = Util.getInt((String)paramMap.get(".msgsource.sec_msg_node.bubble-type"), 0);
      AppMethodBeat.o(242058);
      return i;
    }
    AppMethodBeat.o(242058);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.bt
 * JD-Core Version:    0.7.0.1
 */