package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.bv;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class bn
{
  public static int hKm;
  private static ConcurrentHashMap<Long, String> hKn;
  
  static
  {
    AppMethodBeat.i(150189);
    hKm = 0;
    hKn = new ConcurrentHashMap();
    AppMethodBeat.o(150189);
  }
  
  public static boolean A(bv parambv)
  {
    AppMethodBeat.i(150175);
    if (parambv != null)
    {
      int i = G(parambv);
      if ((parambv.isText()) && (i >= 3))
      {
        AppMethodBeat.o(150175);
        return true;
      }
      if ((parambv.ftg()) && (i >= 2))
      {
        AppMethodBeat.o(150175);
        return true;
      }
    }
    AppMethodBeat.o(150175);
    return false;
  }
  
  public static boolean B(bv parambv)
  {
    AppMethodBeat.i(150176);
    if (parambv != null)
    {
      int i = G(parambv);
      if ((parambv.isText()) && (i > 3))
      {
        AppMethodBeat.o(150176);
        return true;
      }
      if ((parambv.ftg()) && (i > 2))
      {
        AppMethodBeat.o(150176);
        return true;
      }
    }
    AppMethodBeat.o(150176);
    return false;
  }
  
  public static void BU(String paramString)
  {
    AppMethodBeat.i(150188);
    ae.i("MicroMsg.MsgSourceHelper", "parseMsgSource  has been Deprecated  by dk. at 20151218 [%s] %s ", new Object[] { paramString, "" });
    AppMethodBeat.o(150188);
  }
  
  public static String BV(String paramString)
  {
    AppMethodBeat.i(163514);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(163514);
      return null;
    }
    paramString = bx.M(paramString, "msgsource");
    if (paramString != null)
    {
      paramString = (String)paramString.get(".msgsource.sec_msg_node.uuid");
      AppMethodBeat.o(163514);
      return paramString;
    }
    AppMethodBeat.o(163514);
    return null;
  }
  
  public static String BW(String paramString)
  {
    AppMethodBeat.i(163515);
    if (bu.isNullOrNil(paramString))
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
  
  public static void C(bv parambv)
  {
    AppMethodBeat.i(150177);
    if ((parambv != null) && (!bu.isNullOrNil(parambv.eNd)))
    {
      Object localObject = bx.M(parambv.eNd, "msgsource");
      if ((localObject != null) && (bu.aSB((String)((Map)localObject).get(".msgsource.sec_msg_node.sfn")) == 1)) {
        try
        {
          localObject = parambv.eNd.substring(parambv.eNd.indexOf("<sec_msg_node"), parambv.eNd.indexOf("</sec_msg_node") + 12 + 2);
          ae.i("MicroMsg.MsgSourceHelper", (String)localObject);
          if (!bu.isNullOrNil((String)localObject))
          {
            String str = ((String)localObject).substring(((String)localObject).indexOf("<sfn"), ((String)localObject).indexOf("</sfn") + 3 + 2);
            parambv.tk(parambv.eNd.replace((CharSequence)localObject, ((String)localObject).replace(str, "<sfn>0<sfn/>")));
          }
          AppMethodBeat.o(150177);
          return;
        }
        catch (Exception parambv)
        {
          ae.printErrStackTrace("MicroMsg.MsgSourceHelper", parambv, "resetShareForbidden msg exception", new Object[0]);
        }
      }
    }
    AppMethodBeat.o(150177);
  }
  
  @Deprecated
  public static String D(bv parambv)
  {
    AppMethodBeat.i(150178);
    if ((parambv != null) && (!bu.isNullOrNil(parambv.eNd)))
    {
      parambv = bx.M(parambv.eNd, "msgsource");
      if (parambv != null)
      {
        parambv = (String)parambv.get(".msgsource.sec_msg_node.show-h5");
        if (!bu.isNullOrNil(parambv))
        {
          AppMethodBeat.o(150178);
          return parambv;
        }
      }
    }
    AppMethodBeat.o(150178);
    return "";
  }
  
  public static void D(String paramString, long paramLong)
  {
    AppMethodBeat.i(150184);
    if ((!bu.isNullOrNil(paramString)) && (paramLong > 0L) && (hKn.containsKey(Long.valueOf(paramLong))))
    {
      paramString = ((l)g.ab(l.class)).doJ().aJ(paramString, paramLong);
      if ((!bu.isNullOrNil(paramString.field_talker)) && (paramString.field_msgSvrId > 0L))
      {
        ae.i("MicroMsg.MsgSourceHelper", "found sec msg of %s", new Object[] { Long.valueOf(paramLong) });
        a(paramString, (String)hKn.get(Long.valueOf(paramLong)));
        hKn.remove(Long.valueOf(paramLong));
      }
    }
    AppMethodBeat.o(150184);
  }
  
  public static String E(bv parambv)
  {
    AppMethodBeat.i(150179);
    if ((parambv != null) && (!bu.isNullOrNil(parambv.eNd)))
    {
      parambv = bx.M(parambv.eNd, "msgsource");
      if (parambv != null)
      {
        parambv = (String)parambv.get(".msgsource.sec_msg_node.share-tip-url");
        if (!bu.isNullOrNil(parambv))
        {
          AppMethodBeat.o(150179);
          return parambv;
        }
      }
    }
    AppMethodBeat.o(150179);
    return "";
  }
  
  public static int F(bv parambv)
  {
    AppMethodBeat.i(150180);
    if ((parambv != null) && (!bu.isNullOrNil(parambv.eNd)))
    {
      parambv = bx.M(parambv.eNd, "msgsource");
      if (parambv != null)
      {
        int i = bu.aSB((String)parambv.get(".msgsource.sec_msg_node.clip-len"));
        AppMethodBeat.o(150180);
        return i;
      }
    }
    AppMethodBeat.o(150180);
    return 0;
  }
  
  public static int G(bv parambv)
  {
    AppMethodBeat.i(150182);
    if ((parambv != null) && (!bu.isNullOrNil(parambv.eNd)))
    {
      parambv = bx.M(parambv.eNd, "msgsource");
      if (parambv != null)
      {
        int i = bu.aSB((String)parambv.get(".msgsource.sec_msg_node.fold-reduce"));
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
        hKm |= 0x1;
        AppMethodBeat.o(150170);
        return;
      }
      hKm &= 0xFFFFFFFE;
    }
    AppMethodBeat.o(150170);
  }
  
  public static String We()
  {
    AppMethodBeat.i(150173);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(bu.nullAsNil(aCx()));
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
  
  public static void a(bv parambv, int paramInt)
  {
    AppMethodBeat.i(163510);
    if ((parambv != null) && (!bu.isNullOrNil(parambv.eNd)))
    {
      Map localMap = bx.M(parambv.eNd, "msgsource");
      if (localMap != null)
      {
        localMap.put(".msgsource.sec_msg_node.clip-len", String.valueOf(paramInt));
        a(parambv, y(localMap));
      }
    }
    AppMethodBeat.o(163510);
  }
  
  public static void a(bv parambv, String paramString)
  {
    AppMethodBeat.i(163511);
    if (parambv != null)
    {
      String str2 = parambv.eNd;
      String str1;
      if (!bu.isNullOrNil(str2))
      {
        str1 = str2;
        if (str2.trim().startsWith("<msgsource>")) {}
      }
      else
      {
        str1 = "<msgsource></msgsource>";
      }
      parambv.tk(str1.replaceAll("(?s)<sec_msg_node[^>]*>.*?</sec_msg_node>", "").replace("</msgsource>", paramString + "</msgsource>"));
      ((l)g.ab(l.class)).doJ().b(parambv.field_msgSvrId, parambv);
    }
    AppMethodBeat.o(163511);
  }
  
  public static String aCx()
  {
    AppMethodBeat.i(150171);
    Object localObject = new StringBuilder();
    if (hKm != 0)
    {
      ((StringBuilder)localObject).append("<");
      ((StringBuilder)localObject).append("bizflag");
      ((StringBuilder)localObject).append(">");
      ((StringBuilder)localObject).append(hKm);
      ((StringBuilder)localObject).append("</");
      ((StringBuilder)localObject).append("bizflag");
      ((StringBuilder)localObject).append(">");
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(150171);
    return localObject;
  }
  
  public static String aCy()
  {
    AppMethodBeat.i(150187);
    String str = (String)g.ajR().ajA().get(70, null);
    if (!bu.isNullOrNil(str)) {
      g.ajR().ajA().set(70, "");
    }
    ae.d("MicroMsg.MsgSourceHelper", "getMsg ccr[%s]", new Object[] { str });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<msgsource>");
    localStringBuilder.append(bu.nullAsNil(str));
    if (hKm != 0)
    {
      localStringBuilder.append("<");
      localStringBuilder.append("bizflag");
      localStringBuilder.append(">");
      localStringBuilder.append(hKm);
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
    ae.d("MicroMsg.MsgSourceHelper", "getAndResetMsgSrcIn msgsource[%s]", new Object[] { str });
    AppMethodBeat.o(150187);
    return str;
  }
  
  public static void b(bv parambv, String paramString)
  {
    AppMethodBeat.i(163512);
    String str2 = parambv.eNd;
    String str1;
    if (!bu.isNullOrNil(str2))
    {
      str1 = str2;
      if (str2.trim().startsWith("<msgsource>")) {}
    }
    else
    {
      str1 = "<msgsource></msgsource>";
    }
    parambv.tk(str1.replaceAll("(?s)<alnode[^>]*>.*?</alnode>", "").replace("</msgsource>", paramString + "</msgsource>"));
    AppMethodBeat.o(163512);
  }
  
  public static void d(long paramLong, String paramString)
  {
    AppMethodBeat.i(150183);
    if ((paramLong > 0L) && (!bu.isNullOrNil(paramString))) {
      hKn.put(Long.valueOf(paramLong), paramString);
    }
    AppMethodBeat.o(150183);
  }
  
  public static int y(bv parambv)
  {
    AppMethodBeat.i(150172);
    if (parambv == null)
    {
      AppMethodBeat.o(150172);
      return 0;
    }
    parambv = bx.M(parambv.eNd, "msgsource");
    if (parambv != null)
    {
      parambv = (String)parambv.get(".msgsource.bizflag");
      if (bu.isNullOrNil(parambv)) {}
    }
    for (int i = bu.getInt(parambv, 0);; i = 0)
    {
      AppMethodBeat.o(150172);
      return i;
    }
  }
  
  public static String y(Map<String, String> paramMap)
  {
    AppMethodBeat.i(150185);
    int i = bu.aSB((String)paramMap.get(".msgsource.sec_msg_node.sfn"));
    String str1 = bu.nullAsNil((String)paramMap.get(".msgsource.sec_msg_node.show-h5"));
    int j = bu.aSB((String)paramMap.get(".msgsource.sec_msg_node.clip-len"));
    String str2 = bu.nullAsNil((String)paramMap.get(".msgsource.sec_msg_node.share-tip-url"));
    int k = bu.aSB((String)paramMap.get(".msgsource.sec_msg_node.fold-reduce"));
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
  
  public static String z(Map<String, String> paramMap)
  {
    AppMethodBeat.i(163513);
    int i = bu.aSB((String)paramMap.get(".msgsource.alnode.cf"));
    paramMap = new StringBuilder();
    paramMap.append("<alnode>");
    paramMap.append("<cf>").append(i).append("</cf>");
    paramMap.append("</alnode>");
    paramMap = paramMap.toString();
    AppMethodBeat.o(163513);
    return paramMap;
  }
  
  public static boolean z(bv parambv)
  {
    AppMethodBeat.i(150174);
    if ((parambv != null) && (!bu.isNullOrNil(parambv.eNd)))
    {
      parambv = bx.M(parambv.eNd, "msgsource");
      if ((parambv != null) && (bu.aSB((String)parambv.get(".msgsource.sec_msg_node.sfn")) == 1))
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
 * Qualified Name:     com.tencent.mm.model.bn
 * JD-Core Version:    0.7.0.1
 */