package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ca;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class bs
{
  public static int luY;
  private static ConcurrentHashMap<Long, String> luZ;
  private static int lva;
  private static float lvb;
  private static float lvc;
  private static float lvd;
  
  static
  {
    AppMethodBeat.i(150189);
    luY = 0;
    luZ = new ConcurrentHashMap();
    lva = 1;
    lvb = 0.75F;
    lvc = 0.4F;
    lvd = 0.5F;
    AppMethodBeat.o(150189);
  }
  
  public static void B(String paramString, long paramLong)
  {
    AppMethodBeat.i(150184);
    if ((!Util.isNullOrNil(paramString)) && (paramLong > 0L) && (luZ.containsKey(Long.valueOf(paramLong))))
    {
      paramString = ((n)h.ae(n.class)).eSe().aL(paramString, paramLong);
      if ((!Util.isNullOrNil(paramString.field_talker)) && (paramString.field_msgSvrId > 0L))
      {
        Log.i("MicroMsg.MsgSourceHelper", "found sec msg of %s", new Object[] { Long.valueOf(paramLong) });
        a(paramString, (String)luZ.get(Long.valueOf(paramLong)));
        luZ.remove(Long.valueOf(paramLong));
      }
    }
    AppMethodBeat.o(150184);
  }
  
  public static int C(ca paramca)
  {
    AppMethodBeat.i(150172);
    if (paramca == null)
    {
      AppMethodBeat.o(150172);
      return 0;
    }
    paramca = XmlParser.parseXml(paramca.hxy, "msgsource", null);
    if (paramca != null)
    {
      paramca = (String)paramca.get(".msgsource.bizflag");
      if (Util.isNullOrNil(paramca)) {}
    }
    for (int i = Util.getInt(paramca, 0);; i = 0)
    {
      AppMethodBeat.o(150172);
      return i;
    }
  }
  
  public static boolean D(ca paramca)
  {
    AppMethodBeat.i(150174);
    if (N(paramca) == 2)
    {
      AppMethodBeat.o(150174);
      return true;
    }
    if ((paramca != null) && (!Util.isNullOrNil(paramca.hxy)))
    {
      paramca = XmlParser.parseXml(paramca.hxy, "msgsource", null);
      if ((paramca != null) && (Util.safeParseInt((String)paramca.get(".msgsource.sec_msg_node.sfn")) == 1))
      {
        AppMethodBeat.o(150174);
        return true;
      }
    }
    AppMethodBeat.o(150174);
    return false;
  }
  
  public static int E(ca paramca)
  {
    int i = 0;
    AppMethodBeat.i(240738);
    if (lva == 0)
    {
      AppMethodBeat.o(240738);
      return 0;
    }
    int j;
    if ((paramca != null) && (!Util.isNullOrNil(paramca.hxy)))
    {
      paramca = XmlParser.parseXml(paramca.hxy, "msgsource", null);
      if (paramca != null)
      {
        j = Util.getInt((String)paramca.get(".msgsource.sec_msg_node.media-to-emoji"), 0);
        if (j <= 1) {
          break label117;
        }
        if (s(paramca) == 0)
        {
          if (paramca != null) {
            i = Util.getInt((String)paramca.get(".msgsource.sec_msg_node.preview-type"), 0);
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
      AppMethodBeat.o(240738);
      return i;
      AppMethodBeat.o(240738);
      return 0;
    }
  }
  
  public static boolean F(ca paramca)
  {
    AppMethodBeat.i(240739);
    if (E(paramca) > 0)
    {
      AppMethodBeat.o(240739);
      return true;
    }
    AppMethodBeat.o(240739);
    return false;
  }
  
  public static boolean G(ca paramca)
  {
    AppMethodBeat.i(240742);
    int i = E(paramca);
    if ((i == 2) || (i == 4))
    {
      AppMethodBeat.o(240742);
      return true;
    }
    AppMethodBeat.o(240742);
    return false;
  }
  
  public static boolean H(ca paramca)
  {
    AppMethodBeat.i(240743);
    int i = E(paramca);
    if ((i == 3) || (i == 4))
    {
      AppMethodBeat.o(240743);
      return true;
    }
    AppMethodBeat.o(240743);
    return false;
  }
  
  public static float I(ca paramca)
  {
    AppMethodBeat.i(240745);
    if (!F(paramca))
    {
      AppMethodBeat.o(240745);
      return 1.0F;
    }
    float f = lvb;
    AppMethodBeat.o(240745);
    return f;
  }
  
  public static float J(ca paramca)
  {
    AppMethodBeat.i(240747);
    if (!F(paramca))
    {
      AppMethodBeat.o(240747);
      return 1.0F;
    }
    float f = lvc;
    AppMethodBeat.o(240747);
    return f;
  }
  
  public static float K(ca paramca)
  {
    AppMethodBeat.i(240748);
    if (!F(paramca))
    {
      AppMethodBeat.o(240748);
      return 1.0F;
    }
    float f = lvd;
    AppMethodBeat.o(240748);
    return f;
  }
  
  public static void K(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(150170);
    if ("bizflag".equals(paramString))
    {
      if (paramBoolean)
      {
        luY |= 0x1;
        AppMethodBeat.o(150170);
        return;
      }
      luY &= 0xFFFFFFFE;
    }
    AppMethodBeat.o(150170);
  }
  
  public static boolean L(ca paramca)
  {
    AppMethodBeat.i(150175);
    if (paramca != null)
    {
      int i = V(paramca);
      if ((paramca.hwH()) && (i >= 3))
      {
        AppMethodBeat.o(150175);
        return true;
      }
      if ((paramca.hwG()) && (i >= 2))
      {
        AppMethodBeat.o(150175);
        return true;
      }
    }
    AppMethodBeat.o(150175);
    return false;
  }
  
  public static boolean M(ca paramca)
  {
    AppMethodBeat.i(150176);
    if (paramca != null)
    {
      int i = V(paramca);
      if ((paramca.hwH()) && (i > 3))
      {
        AppMethodBeat.o(150176);
        return true;
      }
      if ((paramca.hwG()) && (i > 2))
      {
        AppMethodBeat.o(150176);
        return true;
      }
    }
    AppMethodBeat.o(150176);
    return false;
  }
  
  private static int N(ca paramca)
  {
    AppMethodBeat.i(240750);
    if ((paramca != null) && (!Util.isNullOrNil(paramca.hxy)))
    {
      paramca = XmlParser.parseXml(paramca.hxy, "msgsource", null);
      if (paramca != null)
      {
        int i = Util.getInt((String)paramca.get(".msgsource.sec_msg_node.bubble-type"), 0);
        AppMethodBeat.o(240750);
        return i;
      }
    }
    AppMethodBeat.o(240750);
    return 0;
  }
  
  public static boolean O(ca paramca)
  {
    AppMethodBeat.i(240751);
    if (N(paramca) == 1)
    {
      AppMethodBeat.o(240751);
      return true;
    }
    AppMethodBeat.o(240751);
    return false;
  }
  
  public static boolean P(ca paramca)
  {
    AppMethodBeat.i(240752);
    if ((paramca != null) && (!Util.isNullOrNil(paramca.hxy)))
    {
      paramca = XmlParser.parseXml(paramca.hxy, "msgsource", null);
      if (paramca == null) {}
    }
    for (int i = Util.getInt((String)paramca.get(".msgsource.sec_msg_node.preview-type"), 0); i == 1; i = 0)
    {
      AppMethodBeat.o(240752);
      return true;
    }
    AppMethodBeat.o(240752);
    return false;
  }
  
  public static boolean Q(ca paramca)
  {
    AppMethodBeat.i(240753);
    if ((paramca != null) && (!Util.isNullOrNil(paramca.hxy)))
    {
      paramca = XmlParser.parseXml(paramca.hxy, "msgsource", null);
      if (paramca != null)
      {
        if (Util.getInt((String)paramca.get(".msgsource.sec_msg_node.url-click-type"), 0) != 0)
        {
          AppMethodBeat.o(240753);
          return true;
        }
        AppMethodBeat.o(240753);
        return false;
      }
    }
    AppMethodBeat.o(240753);
    return false;
  }
  
  public static void R(ca paramca)
  {
    AppMethodBeat.i(150177);
    if ((paramca != null) && (!Util.isNullOrNil(paramca.hxy)))
    {
      Object localObject = XmlParser.parseXml(paramca.hxy, "msgsource", null);
      if ((localObject != null) && (Util.safeParseInt((String)((Map)localObject).get(".msgsource.sec_msg_node.sfn")) == 1)) {
        try
        {
          localObject = paramca.hxy.substring(paramca.hxy.indexOf("<sec_msg_node"), paramca.hxy.indexOf("</sec_msg_node") + 12 + 2);
          Log.i("MicroMsg.MsgSourceHelper", (String)localObject);
          if (!Util.isNullOrNil((String)localObject))
          {
            String str = ((String)localObject).substring(((String)localObject).indexOf("<sfn"), ((String)localObject).indexOf("</sfn") + 3 + 2);
            paramca.Ip(paramca.hxy.replace((CharSequence)localObject, ((String)localObject).replace(str, "<sfn>0<sfn/>")));
          }
          AppMethodBeat.o(150177);
          return;
        }
        catch (Exception paramca)
        {
          Log.printErrStackTrace("MicroMsg.MsgSourceHelper", paramca, "resetShareForbidden msg exception", new Object[0]);
        }
      }
    }
    AppMethodBeat.o(150177);
  }
  
  public static void RT(String paramString)
  {
    AppMethodBeat.i(150188);
    Log.i("MicroMsg.MsgSourceHelper", "parseMsgSource  has been Deprecated  by dk. at 20151218 [%s] %s ", new Object[] { paramString, "" });
    AppMethodBeat.o(150188);
  }
  
  public static String RU(String paramString)
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
  
  public static String RV(String paramString)
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
  
  @Deprecated
  public static String S(ca paramca)
  {
    AppMethodBeat.i(150178);
    if ((paramca != null) && (!Util.isNullOrNil(paramca.hxy)))
    {
      paramca = XmlParser.parseXml(paramca.hxy, "msgsource", null);
      if (paramca != null)
      {
        paramca = (String)paramca.get(".msgsource.sec_msg_node.show-h5");
        if (!Util.isNullOrNil(paramca))
        {
          AppMethodBeat.o(150178);
          return paramca;
        }
      }
    }
    AppMethodBeat.o(150178);
    return "";
  }
  
  public static String T(ca paramca)
  {
    AppMethodBeat.i(150179);
    if ((paramca != null) && (!Util.isNullOrNil(paramca.hxy)))
    {
      paramca = XmlParser.parseXml(paramca.hxy, "msgsource", null);
      if (paramca != null)
      {
        paramca = (String)paramca.get(".msgsource.sec_msg_node.share-tip-url");
        if (!Util.isNullOrNil(paramca))
        {
          AppMethodBeat.o(150179);
          return paramca;
        }
      }
    }
    AppMethodBeat.o(150179);
    return "";
  }
  
  public static int U(ca paramca)
  {
    AppMethodBeat.i(150180);
    if ((paramca != null) && (!Util.isNullOrNil(paramca.hxy)))
    {
      paramca = XmlParser.parseXml(paramca.hxy, "msgsource", null);
      if (paramca != null)
      {
        int i = Util.safeParseInt((String)paramca.get(".msgsource.sec_msg_node.clip-len"));
        AppMethodBeat.o(150180);
        return i;
      }
    }
    AppMethodBeat.o(150180);
    return 0;
  }
  
  public static int V(ca paramca)
  {
    AppMethodBeat.i(150182);
    if ((paramca != null) && (!Util.isNullOrNil(paramca.hxy)))
    {
      paramca = XmlParser.parseXml(paramca.hxy, "msgsource", null);
      if (paramca != null)
      {
        int j = Util.safeParseInt((String)paramca.get(".msgsource.sec_msg_node.fold-reduce"));
        int i = j;
        if (j > 1)
        {
          i = j;
          if (s(paramca) != 0) {
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
  
  public static boolean W(ca paramca)
  {
    AppMethodBeat.i(240757);
    if ((paramca != null) && (!Util.isNullOrNil(paramca.hxy)))
    {
      paramca = XmlParser.parseXml(paramca.hxy, "msgsource", null);
      if (paramca != null)
      {
        if (Util.safeParseInt((String)paramca.get(".msgsource.sec_msg_node.block-range")) != 0)
        {
          AppMethodBeat.o(240757);
          return true;
        }
        AppMethodBeat.o(240757);
        return false;
      }
    }
    AppMethodBeat.o(240757);
    return false;
  }
  
  public static void a(ca paramca, String paramString)
  {
    AppMethodBeat.i(163511);
    if (paramca != null)
    {
      String str2 = paramca.hxy;
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
      paramca.Ip(str1.replaceAll("(?s)<sec_msg_node[^>]*>.*?</sec_msg_node>", "").replace("</msgsource>", paramString + "</msgsource>"));
      ((n)h.ae(n.class)).eSe().b(paramca.field_msgSvrId, paramca);
    }
    AppMethodBeat.o(163511);
  }
  
  public static String apc()
  {
    AppMethodBeat.i(150173);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Util.nullAsNil(beY()));
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
  
  public static void b(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    lva = paramInt;
    lvb = paramFloat1;
    lvc = paramFloat2;
    lvd = paramFloat3;
  }
  
  public static void b(ca paramca, int paramInt)
  {
    AppMethodBeat.i(163510);
    if ((paramca != null) && (!Util.isNullOrNil(paramca.hxy)))
    {
      Map localMap = XmlParser.parseXml(paramca.hxy, "msgsource", null);
      if (localMap != null)
      {
        localMap.put(".msgsource.sec_msg_node.clip-len", String.valueOf(paramInt));
        a(paramca, t(localMap));
      }
    }
    AppMethodBeat.o(163510);
  }
  
  public static void b(ca paramca, String paramString)
  {
    AppMethodBeat.i(163512);
    String str2 = paramca.hxy;
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
    paramca.Ip(str1.replaceAll("(?s)<alnode[^>]*>.*?</alnode>", "").replace("</msgsource>", paramString + "</msgsource>"));
    AppMethodBeat.o(163512);
  }
  
  public static String beY()
  {
    AppMethodBeat.i(150171);
    Object localObject = new StringBuilder();
    if (luY != 0)
    {
      ((StringBuilder)localObject).append("<");
      ((StringBuilder)localObject).append("bizflag");
      ((StringBuilder)localObject).append(">");
      ((StringBuilder)localObject).append(luY);
      ((StringBuilder)localObject).append("</");
      ((StringBuilder)localObject).append("bizflag");
      ((StringBuilder)localObject).append(">");
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(150171);
    return localObject;
  }
  
  public static String beZ()
  {
    AppMethodBeat.i(150187);
    String str = (String)h.aHG().aHp().b(70, null);
    if (!Util.isNullOrNil(str)) {
      h.aHG().aHp().i(70, "");
    }
    Log.d("MicroMsg.MsgSourceHelper", "getMsg ccr[%s]", new Object[] { str });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<msgsource>");
    localStringBuilder.append(Util.nullAsNil(str));
    if (luY != 0)
    {
      localStringBuilder.append("<");
      localStringBuilder.append("bizflag");
      localStringBuilder.append(">");
      localStringBuilder.append(luY);
      localStringBuilder.append("</");
      localStringBuilder.append("bizflag");
      localStringBuilder.append(">");
    }
    localStringBuilder.append("</msgsource>");
    str = localStringBuilder.toString();
    if ("<msgsource></msgsource>".equals(str))
    {
      AppMethodBeat.o(150187);
      return "";
    }
    Log.d("MicroMsg.MsgSourceHelper", "getAndResetMsgSrcIn msgsource[%s]", new Object[] { str });
    AppMethodBeat.o(150187);
    return str;
  }
  
  public static void e(long paramLong, String paramString)
  {
    AppMethodBeat.i(150183);
    if ((paramLong > 0L) && (!Util.isNullOrNil(paramString))) {
      luZ.put(Long.valueOf(paramLong), paramString);
    }
    AppMethodBeat.o(150183);
  }
  
  private static int s(Map<String, String> paramMap)
  {
    AppMethodBeat.i(240749);
    if (paramMap != null)
    {
      int i = Util.getInt((String)paramMap.get(".msgsource.sec_msg_node.bubble-type"), 0);
      AppMethodBeat.o(240749);
      return i;
    }
    AppMethodBeat.o(240749);
    return 0;
  }
  
  public static String t(Map<String, String> paramMap)
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
  
  public static String u(Map<String, String> paramMap)
  {
    AppMethodBeat.i(163513);
    int i = Util.safeParseInt((String)paramMap.get(".msgsource.alnode.cf"));
    paramMap = new StringBuilder();
    paramMap.append("<alnode>");
    paramMap.append("<cf>").append(i).append("</cf>");
    paramMap.append("</alnode>");
    paramMap = paramMap.toString();
    AppMethodBeat.o(163513);
    return paramMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.bs
 * JD-Core Version:    0.7.0.1
 */