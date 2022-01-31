package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import java.util.Map;

public final class bh
{
  public static int fnb = 0;
  
  public static void B(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(77813);
    if ("bizflag".equals(paramString))
    {
      if (paramBoolean)
      {
        fnb |= 0x1;
        AppMethodBeat.o(77813);
        return;
      }
      fnb &= 0xFFFFFFFE;
    }
    AppMethodBeat.o(77813);
  }
  
  public static void a(bi parambi, int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(77823);
    if (parambi != null)
    {
      Object localObject2 = parambi.dns;
      Object localObject1;
      if (!bo.isNullOrNil((String)localObject2))
      {
        localObject1 = localObject2;
        if (((String)localObject2).trim().startsWith("<msgsource>")) {}
      }
      else
      {
        localObject1 = "<msgsource></msgsource>";
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("<sec_msg_node>");
      ((StringBuilder)localObject2).append("<sfn>").append(paramInt1).append("</sfn>");
      ((StringBuilder)localObject2).append("<fd>").append(paramInt2).append("</fd>");
      ((StringBuilder)localObject2).append("<show-h5><![CDATA[").append(bo.nullAsNil(paramString1)).append("]]></show-h5>");
      ((StringBuilder)localObject2).append("<clip-len>").append(paramInt3).append("</clip-len>");
      ((StringBuilder)localObject2).append("<share-tip-url><![CDATA[").append(bo.nullAsNil(paramString2)).append("]]></share-tip-url>");
      ((StringBuilder)localObject2).append("</sec_msg_node>");
      parambi.jl(((String)localObject1).replaceAll("(?s)<sec_msg_node[^>]*>.*?</sec_msg_node>", "").replace("</msgsource>", ((StringBuilder)localObject2).toString() + "</msgsource>"));
      ((j)g.E(j.class)).bPQ().b(parambi.field_msgSvrId, parambi);
    }
    AppMethodBeat.o(77823);
  }
  
  public static String aaP()
  {
    AppMethodBeat.i(77814);
    Object localObject = new StringBuilder();
    if (fnb != 0)
    {
      ((StringBuilder)localObject).append("<");
      ((StringBuilder)localObject).append("bizflag");
      ((StringBuilder)localObject).append(">");
      ((StringBuilder)localObject).append(fnb);
      ((StringBuilder)localObject).append("</");
      ((StringBuilder)localObject).append("bizflag");
      ((StringBuilder)localObject).append(">");
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(77814);
    return localObject;
  }
  
  public static String aaQ()
  {
    AppMethodBeat.i(77816);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(bo.nullAsNil(aaP()));
    if (((StringBuilder)localObject).length() > 0)
    {
      ((StringBuilder)localObject).insert(0, "<msgsource>");
      ((StringBuilder)localObject).append("</msgsource>");
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(77816);
      return localObject;
    }
    AppMethodBeat.o(77816);
    return null;
  }
  
  public static String aaR()
  {
    AppMethodBeat.i(77824);
    String str = (String)g.RL().Ru().get(70, null);
    if (!bo.isNullOrNil(str)) {
      g.RL().Ru().set(70, "");
    }
    ab.d("MicroMsg.MsgSourceHelper", "getMsg ccr[%s]", new Object[] { str });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<msgsource>");
    localStringBuilder.append(bo.nullAsNil(str));
    if (fnb != 0)
    {
      localStringBuilder.append("<");
      localStringBuilder.append("bizflag");
      localStringBuilder.append(">");
      localStringBuilder.append(fnb);
      localStringBuilder.append("</");
      localStringBuilder.append("bizflag");
      localStringBuilder.append(">");
    }
    localStringBuilder.append("</msgsource>");
    str = localStringBuilder.toString();
    if ("<msgsource></msgsource>".equals(str))
    {
      AppMethodBeat.o(77824);
      return "";
    }
    ab.d("MicroMsg.MsgSourceHelper", "getAndResetMsgSrcIn msgsource[%s]", new Object[] { str });
    AppMethodBeat.o(77824);
    return str;
  }
  
  public static int n(bi parambi)
  {
    AppMethodBeat.i(77815);
    if (parambi == null)
    {
      AppMethodBeat.o(77815);
      return 0;
    }
    parambi = br.F(parambi.dns, "msgsource");
    if (parambi != null)
    {
      parambi = (String)parambi.get(".msgsource.bizflag");
      if (bo.isNullOrNil(parambi)) {}
    }
    for (int i = bo.getInt(parambi, 0);; i = 0)
    {
      AppMethodBeat.o(77815);
      return i;
    }
  }
  
  public static boolean o(bi parambi)
  {
    AppMethodBeat.i(77817);
    if ((parambi != null) && (!bo.isNullOrNil(parambi.dns)))
    {
      parambi = br.F(parambi.dns, "msgsource");
      if ((parambi != null) && (bo.apV((String)parambi.get(".msgsource.sec_msg_node.sfn")) == 1))
      {
        AppMethodBeat.o(77817);
        return true;
      }
    }
    AppMethodBeat.o(77817);
    return false;
  }
  
  public static void p(bi parambi)
  {
    AppMethodBeat.i(77818);
    if ((parambi != null) && (!bo.isNullOrNil(parambi.dns)))
    {
      Object localObject = br.F(parambi.dns, "msgsource");
      if ((localObject != null) && (bo.apV((String)((Map)localObject).get(".msgsource.sec_msg_node.sfn")) == 1)) {
        try
        {
          localObject = parambi.dns.substring(parambi.dns.indexOf("<sec_msg_node"), parambi.dns.indexOf("</sec_msg_node") + 12 + 2);
          ab.i("MicroMsg.MsgSourceHelper", (String)localObject);
          if (!bo.isNullOrNil((String)localObject))
          {
            String str = ((String)localObject).substring(((String)localObject).indexOf("<sfn"), ((String)localObject).indexOf("</sfn") + 3 + 2);
            parambi.jl(parambi.dns.replace((CharSequence)localObject, ((String)localObject).replace(str, "<sfn>0<sfn/>")));
          }
          AppMethodBeat.o(77818);
          return;
        }
        catch (Exception parambi)
        {
          ab.printErrStackTrace("MicroMsg.MsgSourceHelper", parambi, "resetShareForbidden msg exception", new Object[0]);
        }
      }
    }
    AppMethodBeat.o(77818);
  }
  
  public static void pC(String paramString)
  {
    AppMethodBeat.i(77825);
    ab.i("MicroMsg.MsgSourceHelper", "parseMsgSource  has been Deprecated  by dk. at 20151218 [%s] %s ", new Object[] { paramString, "" });
    AppMethodBeat.o(77825);
  }
  
  public static boolean q(bi parambi)
  {
    AppMethodBeat.i(77819);
    if ((parambi != null) && (!bo.isNullOrNil(parambi.dns)))
    {
      parambi = br.F(parambi.dns, "msgsource");
      if ((parambi != null) && (bo.apV((String)parambi.get(".msgsource.sec_msg_node.fd")) == 1))
      {
        AppMethodBeat.o(77819);
        return true;
      }
    }
    AppMethodBeat.o(77819);
    return false;
  }
  
  public static String r(bi parambi)
  {
    AppMethodBeat.i(77820);
    if ((parambi != null) && (!bo.isNullOrNil(parambi.dns)))
    {
      parambi = br.F(parambi.dns, "msgsource");
      if (parambi != null)
      {
        parambi = (String)parambi.get(".msgsource.sec_msg_node.show-h5");
        if (!bo.isNullOrNil(parambi))
        {
          AppMethodBeat.o(77820);
          return parambi;
        }
      }
    }
    AppMethodBeat.o(77820);
    return "";
  }
  
  public static String s(bi parambi)
  {
    AppMethodBeat.i(77821);
    if ((parambi != null) && (!bo.isNullOrNil(parambi.dns)))
    {
      parambi = br.F(parambi.dns, "msgsource");
      if (parambi != null)
      {
        parambi = (String)parambi.get(".msgsource.sec_msg_node.share-tip-url");
        if (!bo.isNullOrNil(parambi))
        {
          AppMethodBeat.o(77821);
          return parambi;
        }
      }
    }
    AppMethodBeat.o(77821);
    return "";
  }
  
  public static int t(bi parambi)
  {
    AppMethodBeat.i(77822);
    if ((parambi != null) && (!bo.isNullOrNil(parambi.dns)))
    {
      parambi = br.F(parambi.dns, "msgsource");
      if (parambi != null)
      {
        int i = bo.apV((String)parambi.get(".msgsource.sec_msg_node.clip-len"));
        AppMethodBeat.o(77822);
        return i;
      }
    }
    AppMethodBeat.o(77822);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.bh
 * JD-Core Version:    0.7.0.1
 */