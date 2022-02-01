package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bu;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class bl
{
  public static int hHu;
  private static ConcurrentHashMap<Long, String> hHv;
  
  static
  {
    AppMethodBeat.i(150189);
    hHu = 0;
    hHv = new ConcurrentHashMap();
    AppMethodBeat.o(150189);
  }
  
  public static boolean A(bu parambu)
  {
    AppMethodBeat.i(150175);
    if (parambu != null)
    {
      int i = G(parambu);
      if ((parambu.isText()) && (i >= 3))
      {
        AppMethodBeat.o(150175);
        return true;
      }
      if ((parambu.fpi()) && (i >= 2))
      {
        AppMethodBeat.o(150175);
        return true;
      }
    }
    AppMethodBeat.o(150175);
    return false;
  }
  
  public static boolean B(bu parambu)
  {
    AppMethodBeat.i(150176);
    if (parambu != null)
    {
      int i = G(parambu);
      if ((parambu.isText()) && (i > 3))
      {
        AppMethodBeat.o(150176);
        return true;
      }
      if ((parambu.fpi()) && (i > 2))
      {
        AppMethodBeat.o(150176);
        return true;
      }
    }
    AppMethodBeat.o(150176);
    return false;
  }
  
  public static void Bs(String paramString)
  {
    AppMethodBeat.i(150188);
    ad.i("MicroMsg.MsgSourceHelper", "parseMsgSource  has been Deprecated  by dk. at 20151218 [%s] %s ", new Object[] { paramString, "" });
    AppMethodBeat.o(150188);
  }
  
  public static String Bt(String paramString)
  {
    AppMethodBeat.i(163514);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(163514);
      return null;
    }
    paramString = bw.M(paramString, "msgsource");
    if (paramString != null)
    {
      paramString = (String)paramString.get(".msgsource.sec_msg_node.uuid");
      AppMethodBeat.o(163514);
      return paramString;
    }
    AppMethodBeat.o(163514);
    return null;
  }
  
  public static String Bu(String paramString)
  {
    AppMethodBeat.i(163515);
    if (bt.isNullOrNil(paramString))
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
  
  public static void C(bu parambu)
  {
    AppMethodBeat.i(150177);
    if ((parambu != null) && (!bt.isNullOrNil(parambu.eLs)))
    {
      Object localObject = bw.M(parambu.eLs, "msgsource");
      if ((localObject != null) && (bt.aRe((String)((Map)localObject).get(".msgsource.sec_msg_node.sfn")) == 1)) {
        try
        {
          localObject = parambu.eLs.substring(parambu.eLs.indexOf("<sec_msg_node"), parambu.eLs.indexOf("</sec_msg_node") + 12 + 2);
          ad.i("MicroMsg.MsgSourceHelper", (String)localObject);
          if (!bt.isNullOrNil((String)localObject))
          {
            String str = ((String)localObject).substring(((String)localObject).indexOf("<sfn"), ((String)localObject).indexOf("</sfn") + 3 + 2);
            parambu.sP(parambu.eLs.replace((CharSequence)localObject, ((String)localObject).replace(str, "<sfn>0<sfn/>")));
          }
          AppMethodBeat.o(150177);
          return;
        }
        catch (Exception parambu)
        {
          ad.printErrStackTrace("MicroMsg.MsgSourceHelper", parambu, "resetShareForbidden msg exception", new Object[0]);
        }
      }
    }
    AppMethodBeat.o(150177);
  }
  
  @Deprecated
  public static String D(bu parambu)
  {
    AppMethodBeat.i(150178);
    if ((parambu != null) && (!bt.isNullOrNil(parambu.eLs)))
    {
      parambu = bw.M(parambu.eLs, "msgsource");
      if (parambu != null)
      {
        parambu = (String)parambu.get(".msgsource.sec_msg_node.show-h5");
        if (!bt.isNullOrNil(parambu))
        {
          AppMethodBeat.o(150178);
          return parambu;
        }
      }
    }
    AppMethodBeat.o(150178);
    return "";
  }
  
  public static void D(String paramString, long paramLong)
  {
    AppMethodBeat.i(150184);
    if ((!bt.isNullOrNil(paramString)) && (paramLong > 0L) && (hHv.containsKey(Long.valueOf(paramLong))))
    {
      paramString = ((l)g.ab(l.class)).dlK().aI(paramString, paramLong);
      if ((!bt.isNullOrNil(paramString.field_talker)) && (paramString.field_msgSvrId > 0L))
      {
        ad.i("MicroMsg.MsgSourceHelper", "found sec msg of %s", new Object[] { Long.valueOf(paramLong) });
        a(paramString, (String)hHv.get(Long.valueOf(paramLong)));
        hHv.remove(Long.valueOf(paramLong));
      }
    }
    AppMethodBeat.o(150184);
  }
  
  public static String E(bu parambu)
  {
    AppMethodBeat.i(150179);
    if ((parambu != null) && (!bt.isNullOrNil(parambu.eLs)))
    {
      parambu = bw.M(parambu.eLs, "msgsource");
      if (parambu != null)
      {
        parambu = (String)parambu.get(".msgsource.sec_msg_node.share-tip-url");
        if (!bt.isNullOrNil(parambu))
        {
          AppMethodBeat.o(150179);
          return parambu;
        }
      }
    }
    AppMethodBeat.o(150179);
    return "";
  }
  
  public static int F(bu parambu)
  {
    AppMethodBeat.i(150180);
    if ((parambu != null) && (!bt.isNullOrNil(parambu.eLs)))
    {
      parambu = bw.M(parambu.eLs, "msgsource");
      if (parambu != null)
      {
        int i = bt.aRe((String)parambu.get(".msgsource.sec_msg_node.clip-len"));
        AppMethodBeat.o(150180);
        return i;
      }
    }
    AppMethodBeat.o(150180);
    return 0;
  }
  
  public static int G(bu parambu)
  {
    AppMethodBeat.i(150182);
    if ((parambu != null) && (!bt.isNullOrNil(parambu.eLs)))
    {
      parambu = bw.M(parambu.eLs, "msgsource");
      if (parambu != null)
      {
        int i = bt.aRe((String)parambu.get(".msgsource.sec_msg_node.fold-reduce"));
        AppMethodBeat.o(150182);
        return i;
      }
    }
    AppMethodBeat.o(150182);
    return 0;
  }
  
  public static void H(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(150170);
    if ("bizflag".equals(paramString))
    {
      if (paramBoolean)
      {
        hHu |= 0x1;
        AppMethodBeat.o(150170);
        return;
      }
      hHu &= 0xFFFFFFFE;
    }
    AppMethodBeat.o(150170);
  }
  
  public static String VW()
  {
    AppMethodBeat.i(150173);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(bt.nullAsNil(aCh()));
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
  
  public static void a(bu parambu, int paramInt)
  {
    AppMethodBeat.i(163510);
    if ((parambu != null) && (!bt.isNullOrNil(parambu.eLs)))
    {
      Map localMap = bw.M(parambu.eLs, "msgsource");
      if (localMap != null)
      {
        localMap.put(".msgsource.sec_msg_node.clip-len", String.valueOf(paramInt));
        a(parambu, r(localMap));
      }
    }
    AppMethodBeat.o(163510);
  }
  
  public static void a(bu parambu, String paramString)
  {
    AppMethodBeat.i(163511);
    if (parambu != null)
    {
      String str2 = parambu.eLs;
      String str1;
      if (!bt.isNullOrNil(str2))
      {
        str1 = str2;
        if (str2.trim().startsWith("<msgsource>")) {}
      }
      else
      {
        str1 = "<msgsource></msgsource>";
      }
      parambu.sP(str1.replaceAll("(?s)<sec_msg_node[^>]*>.*?</sec_msg_node>", "").replace("</msgsource>", paramString + "</msgsource>"));
      ((l)g.ab(l.class)).dlK().b(parambu.field_msgSvrId, parambu);
    }
    AppMethodBeat.o(163511);
  }
  
  public static String aCh()
  {
    AppMethodBeat.i(150171);
    Object localObject = new StringBuilder();
    if (hHu != 0)
    {
      ((StringBuilder)localObject).append("<");
      ((StringBuilder)localObject).append("bizflag");
      ((StringBuilder)localObject).append(">");
      ((StringBuilder)localObject).append(hHu);
      ((StringBuilder)localObject).append("</");
      ((StringBuilder)localObject).append("bizflag");
      ((StringBuilder)localObject).append(">");
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(150171);
    return localObject;
  }
  
  public static String aCi()
  {
    AppMethodBeat.i(150187);
    String str = (String)g.ajC().ajl().get(70, null);
    if (!bt.isNullOrNil(str)) {
      g.ajC().ajl().set(70, "");
    }
    ad.d("MicroMsg.MsgSourceHelper", "getMsg ccr[%s]", new Object[] { str });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<msgsource>");
    localStringBuilder.append(bt.nullAsNil(str));
    if (hHu != 0)
    {
      localStringBuilder.append("<");
      localStringBuilder.append("bizflag");
      localStringBuilder.append(">");
      localStringBuilder.append(hHu);
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
    ad.d("MicroMsg.MsgSourceHelper", "getAndResetMsgSrcIn msgsource[%s]", new Object[] { str });
    AppMethodBeat.o(150187);
    return str;
  }
  
  public static void b(bu parambu, String paramString)
  {
    AppMethodBeat.i(163512);
    String str2 = parambu.eLs;
    String str1;
    if (!bt.isNullOrNil(str2))
    {
      str1 = str2;
      if (str2.trim().startsWith("<msgsource>")) {}
    }
    else
    {
      str1 = "<msgsource></msgsource>";
    }
    parambu.sP(str1.replaceAll("(?s)<alnode[^>]*>.*?</alnode>", "").replace("</msgsource>", paramString + "</msgsource>"));
    AppMethodBeat.o(163512);
  }
  
  public static void d(long paramLong, String paramString)
  {
    AppMethodBeat.i(150183);
    if ((paramLong > 0L) && (!bt.isNullOrNil(paramString))) {
      hHv.put(Long.valueOf(paramLong), paramString);
    }
    AppMethodBeat.o(150183);
  }
  
  public static String r(Map<String, String> paramMap)
  {
    AppMethodBeat.i(150185);
    int i = bt.aRe((String)paramMap.get(".msgsource.sec_msg_node.sfn"));
    String str1 = bt.nullAsNil((String)paramMap.get(".msgsource.sec_msg_node.show-h5"));
    int j = bt.aRe((String)paramMap.get(".msgsource.sec_msg_node.clip-len"));
    String str2 = bt.nullAsNil((String)paramMap.get(".msgsource.sec_msg_node.share-tip-url"));
    int k = bt.aRe((String)paramMap.get(".msgsource.sec_msg_node.fold-reduce"));
    paramMap = new StringBuilder();
    paramMap.append("<sec_msg_node>");
    paramMap.append("<sfn>").append(i).append("</sfn>");
    paramMap.append("<show-h5><![CDATA[").append(str1).append("]]></show-h5>");
    paramMap.append("<clip-len>").append(j).append("</clip-len>");
    paramMap.append("<share-tip-url><![CDATA[").append(str2).append("]]></share-tip-url>");
    paramMap.append("<fold-reduce>").append(k).append("</fold-reduce>");
    paramMap.append("</sec_msg_node>");
    paramMap = paramMap.toString();
    AppMethodBeat.o(150185);
    return paramMap;
  }
  
  public static String s(Map<String, String> paramMap)
  {
    AppMethodBeat.i(163513);
    int i = bt.aRe((String)paramMap.get(".msgsource.alnode.cf"));
    paramMap = new StringBuilder();
    paramMap.append("<alnode>");
    paramMap.append("<cf>").append(i).append("</cf>");
    paramMap.append("</alnode>");
    paramMap = paramMap.toString();
    AppMethodBeat.o(163513);
    return paramMap;
  }
  
  public static int y(bu parambu)
  {
    AppMethodBeat.i(150172);
    if (parambu == null)
    {
      AppMethodBeat.o(150172);
      return 0;
    }
    parambu = bw.M(parambu.eLs, "msgsource");
    if (parambu != null)
    {
      parambu = (String)parambu.get(".msgsource.bizflag");
      if (bt.isNullOrNil(parambu)) {}
    }
    for (int i = bt.getInt(parambu, 0);; i = 0)
    {
      AppMethodBeat.o(150172);
      return i;
    }
  }
  
  public static boolean z(bu parambu)
  {
    AppMethodBeat.i(150174);
    if ((parambu != null) && (!bt.isNullOrNil(parambu.eLs)))
    {
      parambu = bw.M(parambu.eLs, "msgsource");
      if ((parambu != null) && (bt.aRe((String)parambu.get(".msgsource.sec_msg_node.sfn")) == 1))
      {
        AppMethodBeat.o(150174);
        return true;
      }
    }
    AppMethodBeat.o(150174);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.bl
 * JD-Core Version:    0.7.0.1
 */