package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bo;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class bk
{
  public static int hpc;
  private static ConcurrentHashMap<Long, String> hpd;
  
  static
  {
    AppMethodBeat.i(150189);
    hpc = 0;
    hpd = new ConcurrentHashMap();
    AppMethodBeat.o(150189);
  }
  
  public static void A(bo parambo)
  {
    AppMethodBeat.i(150177);
    if ((parambo != null) && (!bs.isNullOrNil(parambo.eul)))
    {
      Object localObject = bv.L(parambo.eul, "msgsource");
      if ((localObject != null) && (bs.aLy((String)((Map)localObject).get(".msgsource.sec_msg_node.sfn")) == 1)) {
        try
        {
          localObject = parambo.eul.substring(parambo.eul.indexOf("<sec_msg_node"), parambo.eul.indexOf("</sec_msg_node") + 12 + 2);
          ac.i("MicroMsg.MsgSourceHelper", (String)localObject);
          if (!bs.isNullOrNil((String)localObject))
          {
            String str = ((String)localObject).substring(((String)localObject).indexOf("<sfn"), ((String)localObject).indexOf("</sfn") + 3 + 2);
            parambo.qf(parambo.eul.replace((CharSequence)localObject, ((String)localObject).replace(str, "<sfn>0<sfn/>")));
          }
          AppMethodBeat.o(150177);
          return;
        }
        catch (Exception parambo)
        {
          ac.printErrStackTrace("MicroMsg.MsgSourceHelper", parambo, "resetShareForbidden msg exception", new Object[0]);
        }
      }
    }
    AppMethodBeat.o(150177);
  }
  
  @Deprecated
  public static String B(bo parambo)
  {
    AppMethodBeat.i(150178);
    if ((parambo != null) && (!bs.isNullOrNil(parambo.eul)))
    {
      parambo = bv.L(parambo.eul, "msgsource");
      if (parambo != null)
      {
        parambo = (String)parambo.get(".msgsource.sec_msg_node.show-h5");
        if (!bs.isNullOrNil(parambo))
        {
          AppMethodBeat.o(150178);
          return parambo;
        }
      }
    }
    AppMethodBeat.o(150178);
    return "";
  }
  
  public static void B(String paramString, long paramLong)
  {
    AppMethodBeat.i(150184);
    if ((!bs.isNullOrNil(paramString)) && (paramLong > 0L) && (hpd.containsKey(Long.valueOf(paramLong))))
    {
      paramString = ((k)g.ab(k.class)).dcr().aF(paramString, paramLong);
      if ((!bs.isNullOrNil(paramString.field_talker)) && (paramString.field_msgSvrId > 0L))
      {
        ac.i("MicroMsg.MsgSourceHelper", "found sec msg of %s", new Object[] { Long.valueOf(paramLong) });
        a(paramString, (String)hpd.get(Long.valueOf(paramLong)));
        hpd.remove(Long.valueOf(paramLong));
      }
    }
    AppMethodBeat.o(150184);
  }
  
  public static String C(bo parambo)
  {
    AppMethodBeat.i(150179);
    if ((parambo != null) && (!bs.isNullOrNil(parambo.eul)))
    {
      parambo = bv.L(parambo.eul, "msgsource");
      if (parambo != null)
      {
        parambo = (String)parambo.get(".msgsource.sec_msg_node.share-tip-url");
        if (!bs.isNullOrNil(parambo))
        {
          AppMethodBeat.o(150179);
          return parambo;
        }
      }
    }
    AppMethodBeat.o(150179);
    return "";
  }
  
  public static int D(bo parambo)
  {
    AppMethodBeat.i(150180);
    if ((parambo != null) && (!bs.isNullOrNil(parambo.eul)))
    {
      parambo = bv.L(parambo.eul, "msgsource");
      if (parambo != null)
      {
        int i = bs.aLy((String)parambo.get(".msgsource.sec_msg_node.clip-len"));
        AppMethodBeat.o(150180);
        return i;
      }
    }
    AppMethodBeat.o(150180);
    return 0;
  }
  
  public static int E(bo parambo)
  {
    AppMethodBeat.i(150182);
    if ((parambo != null) && (!bs.isNullOrNil(parambo.eul)))
    {
      parambo = bv.L(parambo.eul, "msgsource");
      if (parambo != null)
      {
        int i = bs.aLy((String)parambo.get(".msgsource.sec_msg_node.fold-reduce"));
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
        hpc |= 0x1;
        AppMethodBeat.o(150170);
        return;
      }
      hpc &= 0xFFFFFFFE;
    }
    AppMethodBeat.o(150170);
  }
  
  public static String TG()
  {
    AppMethodBeat.i(150173);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(bs.nullAsNil(azd()));
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
  
  public static void a(bo parambo, int paramInt)
  {
    AppMethodBeat.i(163510);
    if ((parambo != null) && (!bs.isNullOrNil(parambo.eul)))
    {
      Map localMap = bv.L(parambo.eul, "msgsource");
      if (localMap != null)
      {
        localMap.put(".msgsource.sec_msg_node.clip-len", String.valueOf(paramInt));
        a(parambo, q(localMap));
      }
    }
    AppMethodBeat.o(163510);
  }
  
  public static void a(bo parambo, String paramString)
  {
    AppMethodBeat.i(163511);
    if (parambo != null)
    {
      String str2 = parambo.eul;
      String str1;
      if (!bs.isNullOrNil(str2))
      {
        str1 = str2;
        if (str2.trim().startsWith("<msgsource>")) {}
      }
      else
      {
        str1 = "<msgsource></msgsource>";
      }
      parambo.qf(str1.replaceAll("(?s)<sec_msg_node[^>]*>.*?</sec_msg_node>", "").replace("</msgsource>", paramString + "</msgsource>"));
      ((k)g.ab(k.class)).dcr().b(parambo.field_msgSvrId, parambo);
    }
    AppMethodBeat.o(163511);
  }
  
  public static String azd()
  {
    AppMethodBeat.i(150171);
    Object localObject = new StringBuilder();
    if (hpc != 0)
    {
      ((StringBuilder)localObject).append("<");
      ((StringBuilder)localObject).append("bizflag");
      ((StringBuilder)localObject).append(">");
      ((StringBuilder)localObject).append(hpc);
      ((StringBuilder)localObject).append("</");
      ((StringBuilder)localObject).append("bizflag");
      ((StringBuilder)localObject).append(">");
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(150171);
    return localObject;
  }
  
  public static String aze()
  {
    AppMethodBeat.i(150187);
    String str = (String)g.agR().agA().get(70, null);
    if (!bs.isNullOrNil(str)) {
      g.agR().agA().set(70, "");
    }
    ac.d("MicroMsg.MsgSourceHelper", "getMsg ccr[%s]", new Object[] { str });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<msgsource>");
    localStringBuilder.append(bs.nullAsNil(str));
    if (hpc != 0)
    {
      localStringBuilder.append("<");
      localStringBuilder.append("bizflag");
      localStringBuilder.append(">");
      localStringBuilder.append(hpc);
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
    ac.d("MicroMsg.MsgSourceHelper", "getAndResetMsgSrcIn msgsource[%s]", new Object[] { str });
    AppMethodBeat.o(150187);
    return str;
  }
  
  public static void b(bo parambo, String paramString)
  {
    AppMethodBeat.i(163512);
    String str2 = parambo.eul;
    String str1;
    if (!bs.isNullOrNil(str2))
    {
      str1 = str2;
      if (str2.trim().startsWith("<msgsource>")) {}
    }
    else
    {
      str1 = "<msgsource></msgsource>";
    }
    parambo.qf(str1.replaceAll("(?s)<alnode[^>]*>.*?</alnode>", "").replace("</msgsource>", paramString + "</msgsource>"));
    AppMethodBeat.o(163512);
  }
  
  public static void d(long paramLong, String paramString)
  {
    AppMethodBeat.i(150183);
    if ((paramLong > 0L) && (!bs.isNullOrNil(paramString))) {
      hpd.put(Long.valueOf(paramLong), paramString);
    }
    AppMethodBeat.o(150183);
  }
  
  public static String q(Map<String, String> paramMap)
  {
    AppMethodBeat.i(150185);
    int i = bs.aLy((String)paramMap.get(".msgsource.sec_msg_node.sfn"));
    String str1 = bs.nullAsNil((String)paramMap.get(".msgsource.sec_msg_node.show-h5"));
    int j = bs.aLy((String)paramMap.get(".msgsource.sec_msg_node.clip-len"));
    String str2 = bs.nullAsNil((String)paramMap.get(".msgsource.sec_msg_node.share-tip-url"));
    int k = bs.aLy((String)paramMap.get(".msgsource.sec_msg_node.fold-reduce"));
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
  
  public static String r(Map<String, String> paramMap)
  {
    AppMethodBeat.i(163513);
    int i = bs.aLy((String)paramMap.get(".msgsource.alnode.cf"));
    paramMap = new StringBuilder();
    paramMap.append("<alnode>");
    paramMap.append("<cf>").append(i).append("</cf>");
    paramMap.append("</alnode>");
    paramMap = paramMap.toString();
    AppMethodBeat.o(163513);
    return paramMap;
  }
  
  public static int w(bo parambo)
  {
    AppMethodBeat.i(150172);
    if (parambo == null)
    {
      AppMethodBeat.o(150172);
      return 0;
    }
    parambo = bv.L(parambo.eul, "msgsource");
    if (parambo != null)
    {
      parambo = (String)parambo.get(".msgsource.bizflag");
      if (bs.isNullOrNil(parambo)) {}
    }
    for (int i = bs.getInt(parambo, 0);; i = 0)
    {
      AppMethodBeat.o(150172);
      return i;
    }
  }
  
  public static boolean x(bo parambo)
  {
    AppMethodBeat.i(150174);
    if ((parambo != null) && (!bs.isNullOrNil(parambo.eul)))
    {
      parambo = bv.L(parambo.eul, "msgsource");
      if ((parambo != null) && (bs.aLy((String)parambo.get(".msgsource.sec_msg_node.sfn")) == 1))
      {
        AppMethodBeat.o(150174);
        return true;
      }
    }
    AppMethodBeat.o(150174);
    return false;
  }
  
  public static boolean y(bo parambo)
  {
    AppMethodBeat.i(150175);
    if (parambo != null)
    {
      int i = E(parambo);
      if ((parambo.isText()) && (i >= 3))
      {
        AppMethodBeat.o(150175);
        return true;
      }
      if ((parambo.eZm()) && (i >= 2))
      {
        AppMethodBeat.o(150175);
        return true;
      }
    }
    AppMethodBeat.o(150175);
    return false;
  }
  
  public static void yt(String paramString)
  {
    AppMethodBeat.i(150188);
    ac.i("MicroMsg.MsgSourceHelper", "parseMsgSource  has been Deprecated  by dk. at 20151218 [%s] %s ", new Object[] { paramString, "" });
    AppMethodBeat.o(150188);
  }
  
  public static String yu(String paramString)
  {
    AppMethodBeat.i(163514);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(163514);
      return null;
    }
    paramString = bv.L(paramString, "msgsource");
    if (paramString != null)
    {
      paramString = (String)paramString.get(".msgsource.sec_msg_node.uuid");
      AppMethodBeat.o(163514);
      return paramString;
    }
    AppMethodBeat.o(163514);
    return null;
  }
  
  public static String yv(String paramString)
  {
    AppMethodBeat.i(163515);
    if (bs.isNullOrNil(paramString))
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
  
  public static boolean z(bo parambo)
  {
    AppMethodBeat.i(150176);
    if (parambo != null)
    {
      int i = E(parambo);
      if ((parambo.isText()) && (i > 3))
      {
        AppMethodBeat.o(150176);
        return true;
      }
      if ((parambo.eZm()) && (i > 2))
      {
        AppMethodBeat.o(150176);
        return true;
      }
    }
    AppMethodBeat.o(150176);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.bk
 * JD-Core Version:    0.7.0.1
 */