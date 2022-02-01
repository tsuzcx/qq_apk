package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bl;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class bk
{
  public static int gOC;
  private static ConcurrentHashMap<Long, String> gOD;
  
  static
  {
    AppMethodBeat.i(150189);
    gOC = 0;
    gOD = new ConcurrentHashMap();
    AppMethodBeat.o(150189);
  }
  
  public static void A(bl parambl)
  {
    AppMethodBeat.i(150177);
    if ((parambl != null) && (!bt.isNullOrNil(parambl.esh)))
    {
      Object localObject = bw.K(parambl.esh, "msgsource");
      if ((localObject != null) && (bt.aGh((String)((Map)localObject).get(".msgsource.sec_msg_node.sfn")) == 1)) {
        try
        {
          localObject = parambl.esh.substring(parambl.esh.indexOf("<sec_msg_node"), parambl.esh.indexOf("</sec_msg_node") + 12 + 2);
          ad.i("MicroMsg.MsgSourceHelper", (String)localObject);
          if (!bt.isNullOrNil((String)localObject))
          {
            String str = ((String)localObject).substring(((String)localObject).indexOf("<sfn"), ((String)localObject).indexOf("</sfn") + 3 + 2);
            parambl.mZ(parambl.esh.replace((CharSequence)localObject, ((String)localObject).replace(str, "<sfn>0<sfn/>")));
          }
          AppMethodBeat.o(150177);
          return;
        }
        catch (Exception parambl)
        {
          ad.printErrStackTrace("MicroMsg.MsgSourceHelper", parambl, "resetShareForbidden msg exception", new Object[0]);
        }
      }
    }
    AppMethodBeat.o(150177);
  }
  
  public static void A(String paramString, long paramLong)
  {
    AppMethodBeat.i(150184);
    if ((!bt.isNullOrNil(paramString)) && (paramLong > 0L) && (gOD.containsKey(Long.valueOf(paramLong))))
    {
      paramString = ((k)g.ab(k.class)).cOI().aD(paramString, paramLong);
      if ((!bt.isNullOrNil(paramString.field_talker)) && (paramString.field_msgSvrId > 0L))
      {
        ad.i("MicroMsg.MsgSourceHelper", "found sec msg of %s", new Object[] { Long.valueOf(paramLong) });
        a(paramString, (String)gOD.get(Long.valueOf(paramLong)));
        gOD.remove(Long.valueOf(paramLong));
      }
    }
    AppMethodBeat.o(150184);
  }
  
  @Deprecated
  public static String B(bl parambl)
  {
    AppMethodBeat.i(150178);
    if ((parambl != null) && (!bt.isNullOrNil(parambl.esh)))
    {
      parambl = bw.K(parambl.esh, "msgsource");
      if (parambl != null)
      {
        parambl = (String)parambl.get(".msgsource.sec_msg_node.show-h5");
        if (!bt.isNullOrNil(parambl))
        {
          AppMethodBeat.o(150178);
          return parambl;
        }
      }
    }
    AppMethodBeat.o(150178);
    return "";
  }
  
  public static String C(bl parambl)
  {
    AppMethodBeat.i(150179);
    if ((parambl != null) && (!bt.isNullOrNil(parambl.esh)))
    {
      parambl = bw.K(parambl.esh, "msgsource");
      if (parambl != null)
      {
        parambl = (String)parambl.get(".msgsource.sec_msg_node.share-tip-url");
        if (!bt.isNullOrNil(parambl))
        {
          AppMethodBeat.o(150179);
          return parambl;
        }
      }
    }
    AppMethodBeat.o(150179);
    return "";
  }
  
  public static int D(bl parambl)
  {
    AppMethodBeat.i(150180);
    if ((parambl != null) && (!bt.isNullOrNil(parambl.esh)))
    {
      parambl = bw.K(parambl.esh, "msgsource");
      if (parambl != null)
      {
        int i = bt.aGh((String)parambl.get(".msgsource.sec_msg_node.clip-len"));
        AppMethodBeat.o(150180);
        return i;
      }
    }
    AppMethodBeat.o(150180);
    return 0;
  }
  
  public static int E(bl parambl)
  {
    AppMethodBeat.i(150182);
    if ((parambl != null) && (!bt.isNullOrNil(parambl.esh)))
    {
      parambl = bw.K(parambl.esh, "msgsource");
      if (parambl != null)
      {
        int i = bt.aGh((String)parambl.get(".msgsource.sec_msg_node.fold-reduce"));
        AppMethodBeat.o(150182);
        return i;
      }
    }
    AppMethodBeat.o(150182);
    return 0;
  }
  
  public static void G(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(150170);
    if ("bizflag".equals(paramString))
    {
      if (paramBoolean)
      {
        gOC |= 0x1;
        AppMethodBeat.o(150170);
        return;
      }
      gOC &= 0xFFFFFFFE;
    }
    AppMethodBeat.o(150170);
  }
  
  public static String SM()
  {
    AppMethodBeat.i(150173);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(bt.nullAsNil(asm()));
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
  
  public static void a(bl parambl, int paramInt)
  {
    AppMethodBeat.i(163510);
    if ((parambl != null) && (!bt.isNullOrNil(parambl.esh)))
    {
      Map localMap = bw.K(parambl.esh, "msgsource");
      if (localMap != null)
      {
        localMap.put(".msgsource.sec_msg_node.clip-len", String.valueOf(paramInt));
        a(parambl, r(localMap));
      }
    }
    AppMethodBeat.o(163510);
  }
  
  public static void a(bl parambl, String paramString)
  {
    AppMethodBeat.i(163511);
    if (parambl != null)
    {
      String str2 = parambl.esh;
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
      parambl.mZ(str1.replaceAll("(?s)<sec_msg_node[^>]*>.*?</sec_msg_node>", "").replace("</msgsource>", paramString + "</msgsource>"));
      ((k)g.ab(k.class)).cOI().b(parambl.field_msgSvrId, parambl);
    }
    AppMethodBeat.o(163511);
  }
  
  public static String asm()
  {
    AppMethodBeat.i(150171);
    Object localObject = new StringBuilder();
    if (gOC != 0)
    {
      ((StringBuilder)localObject).append("<");
      ((StringBuilder)localObject).append("bizflag");
      ((StringBuilder)localObject).append(">");
      ((StringBuilder)localObject).append(gOC);
      ((StringBuilder)localObject).append("</");
      ((StringBuilder)localObject).append("bizflag");
      ((StringBuilder)localObject).append(">");
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(150171);
    return localObject;
  }
  
  public static String asn()
  {
    AppMethodBeat.i(150187);
    String str = (String)g.afB().afk().get(70, null);
    if (!bt.isNullOrNil(str)) {
      g.afB().afk().set(70, "");
    }
    ad.d("MicroMsg.MsgSourceHelper", "getMsg ccr[%s]", new Object[] { str });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<msgsource>");
    localStringBuilder.append(bt.nullAsNil(str));
    if (gOC != 0)
    {
      localStringBuilder.append("<");
      localStringBuilder.append("bizflag");
      localStringBuilder.append(">");
      localStringBuilder.append(gOC);
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
  
  public static void b(bl parambl, String paramString)
  {
    AppMethodBeat.i(163512);
    String str2 = parambl.esh;
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
    parambl.mZ(str1.replaceAll("(?s)<alnode[^>]*>.*?</alnode>", "").replace("</msgsource>", paramString + "</msgsource>"));
    AppMethodBeat.o(163512);
  }
  
  public static void d(long paramLong, String paramString)
  {
    AppMethodBeat.i(150183);
    if ((paramLong > 0L) && (!bt.isNullOrNil(paramString))) {
      gOD.put(Long.valueOf(paramLong), paramString);
    }
    AppMethodBeat.o(150183);
  }
  
  public static String r(Map<String, String> paramMap)
  {
    AppMethodBeat.i(150185);
    int i = bt.aGh((String)paramMap.get(".msgsource.sec_msg_node.sfn"));
    String str1 = bt.nullAsNil((String)paramMap.get(".msgsource.sec_msg_node.show-h5"));
    int j = bt.aGh((String)paramMap.get(".msgsource.sec_msg_node.clip-len"));
    String str2 = bt.nullAsNil((String)paramMap.get(".msgsource.sec_msg_node.share-tip-url"));
    int k = bt.aGh((String)paramMap.get(".msgsource.sec_msg_node.fold-reduce"));
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
    int i = bt.aGh((String)paramMap.get(".msgsource.alnode.cf"));
    paramMap = new StringBuilder();
    paramMap.append("<alnode>");
    paramMap.append("<cf>").append(i).append("</cf>");
    paramMap.append("</alnode>");
    paramMap = paramMap.toString();
    AppMethodBeat.o(163513);
    return paramMap;
  }
  
  public static void un(String paramString)
  {
    AppMethodBeat.i(150188);
    ad.i("MicroMsg.MsgSourceHelper", "parseMsgSource  has been Deprecated  by dk. at 20151218 [%s] %s ", new Object[] { paramString, "" });
    AppMethodBeat.o(150188);
  }
  
  public static String uo(String paramString)
  {
    AppMethodBeat.i(163514);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(163514);
      return null;
    }
    paramString = bw.K(paramString, "msgsource");
    if (paramString != null)
    {
      paramString = (String)paramString.get(".msgsource.sec_msg_node.uuid");
      AppMethodBeat.o(163514);
      return paramString;
    }
    AppMethodBeat.o(163514);
    return null;
  }
  
  public static String up(String paramString)
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
  
  public static int w(bl parambl)
  {
    AppMethodBeat.i(150172);
    if (parambl == null)
    {
      AppMethodBeat.o(150172);
      return 0;
    }
    parambl = bw.K(parambl.esh, "msgsource");
    if (parambl != null)
    {
      parambl = (String)parambl.get(".msgsource.bizflag");
      if (bt.isNullOrNil(parambl)) {}
    }
    for (int i = bt.getInt(parambl, 0);; i = 0)
    {
      AppMethodBeat.o(150172);
      return i;
    }
  }
  
  public static boolean x(bl parambl)
  {
    AppMethodBeat.i(150174);
    if ((parambl != null) && (!bt.isNullOrNil(parambl.esh)))
    {
      parambl = bw.K(parambl.esh, "msgsource");
      if ((parambl != null) && (bt.aGh((String)parambl.get(".msgsource.sec_msg_node.sfn")) == 1))
      {
        AppMethodBeat.o(150174);
        return true;
      }
    }
    AppMethodBeat.o(150174);
    return false;
  }
  
  public static boolean y(bl parambl)
  {
    AppMethodBeat.i(150175);
    if (parambl != null)
    {
      int i = E(parambl);
      if ((parambl.isText()) && (i >= 3))
      {
        AppMethodBeat.o(150175);
        return true;
      }
      if ((parambl.eJO()) && (i >= 2))
      {
        AppMethodBeat.o(150175);
        return true;
      }
    }
    AppMethodBeat.o(150175);
    return false;
  }
  
  public static boolean z(bl parambl)
  {
    AppMethodBeat.i(150176);
    if (parambl != null)
    {
      int i = E(parambl);
      if ((parambl.isText()) && (i > 3))
      {
        AppMethodBeat.o(150176);
        return true;
      }
      if ((parambl.eJO()) && (i > 2))
      {
        AppMethodBeat.o(150176);
        return true;
      }
    }
    AppMethodBeat.o(150176);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.bk
 * JD-Core Version:    0.7.0.1
 */