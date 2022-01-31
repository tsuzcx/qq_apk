package com.tencent.mm.model;

import com.tencent.mm.h.c.cs;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import java.util.Map;

public final class bf
{
  public static int dWT = 0;
  
  public static String HQ()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (dWT != 0)
    {
      localStringBuilder.append("<");
      localStringBuilder.append("bizflag");
      localStringBuilder.append(">");
      localStringBuilder.append(dWT);
      localStringBuilder.append("</");
      localStringBuilder.append("bizflag");
      localStringBuilder.append(">");
    }
    return localStringBuilder.toString();
  }
  
  public static String HR()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(bk.pm(HQ()));
    if (localStringBuilder.length() > 0)
    {
      localStringBuilder.insert(0, "<msgsource>");
      localStringBuilder.append("</msgsource>");
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public static String HS()
  {
    String str = (String)g.DP().Dz().get(70, null);
    if (!bk.bl(str)) {
      g.DP().Dz().o(70, "");
    }
    y.d("MicroMsg.MsgSourceHelper", "getMsg ccr[%s]", new Object[] { str });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<msgsource>");
    localStringBuilder.append(bk.pm(str));
    if (dWT != 0)
    {
      localStringBuilder.append("<");
      localStringBuilder.append("bizflag");
      localStringBuilder.append(">");
      localStringBuilder.append(dWT);
      localStringBuilder.append("</");
      localStringBuilder.append("bizflag");
      localStringBuilder.append(">");
    }
    localStringBuilder.append("</msgsource>");
    return localStringBuilder.toString();
  }
  
  public static void iO(String paramString)
  {
    y.i("MicroMsg.MsgSourceHelper", "parseMsgSource  has been Deprecated  by dk. at 20151218 [%s] %s ", new Object[] { paramString, "" });
  }
  
  public static int j(bi parambi)
  {
    if (parambi == null) {
      return 0;
    }
    parambi = bn.s(parambi.czr, "msgsource");
    if (parambi != null)
    {
      parambi = (String)parambi.get(".msgsource.bizflag");
      if (bk.bl(parambi)) {}
    }
    for (int i = bk.getInt(parambi, 0);; i = 0) {
      return i;
    }
  }
  
  public static boolean k(bi parambi)
  {
    if ((parambi != null) && (!bk.bl(parambi.czr)))
    {
      parambi = bn.s(parambi.czr, "msgsource");
      if ((parambi != null) && (bk.ZR((String)parambi.get(".msgsource.sec_msg_node.sfn")) == 1)) {
        return true;
      }
    }
    return false;
  }
  
  public static void l(bi parambi)
  {
    Object localObject;
    if ((parambi != null) && (!bk.bl(parambi.czr)))
    {
      localObject = bn.s(parambi.czr, "msgsource");
      if ((localObject == null) || (bk.ZR((String)((Map)localObject).get(".msgsource.sec_msg_node.sfn")) != 1)) {}
    }
    try
    {
      localObject = parambi.czr.substring(parambi.czr.indexOf("<sec_msg_node"), parambi.czr.indexOf("</sec_msg_node") + 12 + 2);
      y.i("MicroMsg.MsgSourceHelper", (String)localObject);
      if (!bk.bl((String)localObject))
      {
        String str = ((String)localObject).substring(((String)localObject).indexOf("<sfn"), ((String)localObject).indexOf("</sfn") + 3 + 2);
        parambi.cY(parambi.czr.replace((CharSequence)localObject, ((String)localObject).replace(str, "<sfn>0<sfn/>")));
      }
      return;
    }
    catch (Exception parambi)
    {
      y.printErrStackTrace("MicroMsg.MsgSourceHelper", parambi, "resetShareForbidden msg exception", new Object[0]);
    }
  }
  
  public static boolean m(bi parambi)
  {
    if ((parambi != null) && (!bk.bl(parambi.czr)))
    {
      parambi = bn.s(parambi.czr, "msgsource");
      if ((parambi != null) && (bk.ZR((String)parambi.get(".msgsource.sec_msg_node.fd")) == 1)) {
        return true;
      }
    }
    return false;
  }
  
  public static String n(bi parambi)
  {
    if ((parambi != null) && (!bk.bl(parambi.czr)))
    {
      parambi = bn.s(parambi.czr, "msgsource");
      if (parambi != null)
      {
        parambi = (String)parambi.get(".msgsource.sec_msg_node.show-h5");
        if (!bk.bl(parambi)) {
          return parambi;
        }
      }
    }
    return "";
  }
  
  public static void x(String paramString, boolean paramBoolean)
  {
    if ("bizflag".equals(paramString))
    {
      if (paramBoolean) {
        dWT |= 0x1;
      }
    }
    else {
      return;
    }
    dWT &= 0xFFFFFFFE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.model.bf
 * JD-Core Version:    0.7.0.1
 */