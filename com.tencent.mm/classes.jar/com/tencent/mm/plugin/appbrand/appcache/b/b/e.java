package com.tencent.mm.plugin.appbrand.appcache.b.b;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.protocal.protobuf.daa;
import com.tencent.mm.protocal.protobuf.dab;
import com.tencent.mm.protocal.protobuf.dbg;
import com.tencent.mm.protocal.protobuf.dbl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

public class e
  extends a<Boolean, dbl>
{
  private static Boolean a(String paramString1, String paramString2, dbl paramdbl)
  {
    AppMethodBeat.i(129464);
    Object localObject1 = paramdbl.yhN;
    if (bo.isNullOrNil((String)localObject1))
    {
      ab.e("MicroMsg.AppBrand.Predownload.CmdIssueContact", "call[%s | %s], empty base64", new Object[] { paramString1, paramString2 });
      paramString1 = Boolean.FALSE;
      AppMethodBeat.o(129464);
      return paramString1;
    }
    for (;;)
    {
      try
      {
        localObject1 = Base64.decode((String)localObject1, 0);
        Object localObject2 = new dab();
        ((dab)localObject2).parseFrom((byte[])localObject1);
        localObject1 = g.auF().d(paramString1, new String[] { "versionInfo" });
        WxaAttributes.WxaVersionInfo localWxaVersionInfo;
        if (localObject1 == null)
        {
          localWxaVersionInfo = null;
          localObject1 = null;
          localObject3 = ((dab)localObject2).wxO.iterator();
          if (((Iterator)localObject3).hasNext())
          {
            daa localdaa = (daa)((Iterator)localObject3).next();
            if (!"WxaAppVersionInfo".equals(localdaa.wxP)) {
              break label492;
            }
            localObject1 = WxaAttributes.WxaVersionInfo.AD(localdaa.qsu);
            break label492;
          }
        }
        else
        {
          localWxaVersionInfo = ((WxaAttributes)localObject1).ayE();
          continue;
        }
        if (localObject1 == null)
        {
          localObject1 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.gXW;
          com.tencent.mm.plugin.appbrand.appcache.b.c.a.B(paramdbl.yhA.yhy, 87L);
          paramdbl = Boolean.FALSE;
          AppMethodBeat.o(129464);
          return paramdbl;
        }
        Object localObject3 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.gXW;
        com.tencent.mm.plugin.appbrand.appcache.b.c.a.B(paramdbl.yhA.yhy, 88L);
        if ((localWxaVersionInfo != null) && (localObject1 != null))
        {
          if (localWxaVersionInfo.bDc < ((WxaAttributes.WxaVersionInfo)localObject1).bDc)
          {
            break label495;
            if (!bool2) {
              continue;
            }
            g.auF().a(paramString1, ((dab)localObject2).wxN, ((dab)localObject2).wxO);
            if (g.auF().d(paramString1, new String[0]) != null)
            {
              bool1 = true;
              localObject2 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.gXW;
              j = paramdbl.yhA.yhy;
              if (!bool1) {
                continue;
              }
              i = 85;
              com.tencent.mm.plugin.appbrand.appcache.b.c.a.B(j, i);
              if (localWxaVersionInfo != null) {
                continue;
              }
              i = -1;
              if (localObject1 != null) {
                continue;
              }
              j = -1;
              ab.i("MicroMsg.AppBrand.Predownload.CmdIssueContact", "call[%s | %s], record.ver %d, issue.ver %d, doIssue %b, issueRet %b", new Object[] { paramString1, paramString2, Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
              AppMethodBeat.o(129464);
              return Boolean.valueOf(bool1);
            }
          }
          else
          {
            bool2 = false;
            continue;
          }
          boolean bool1 = false;
          continue;
          int i = 86;
          continue;
          localObject2 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.gXW;
          com.tencent.mm.plugin.appbrand.appcache.b.c.a.B(paramdbl.yhA.yhy, 84L);
          bool1 = false;
          continue;
          i = localWxaVersionInfo.bDc;
          continue;
          int j = ((WxaAttributes.WxaVersionInfo)localObject1).bDc;
          continue;
          continue;
        }
      }
      catch (Exception paramdbl)
      {
        ab.printErrStackTrace("MicroMsg.AppBrand.Predownload.CmdIssueContact", paramdbl, "call[%s | %s], decode base64", new Object[] { paramString1, paramString2 });
        paramString1 = Boolean.FALSE;
        AppMethodBeat.o(129464);
        return paramString1;
      }
      label492:
      label495:
      boolean bool2 = true;
    }
  }
  
  final String awm()
  {
    return "CmdIssueContact";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.b.e
 * JD-Core Version:    0.7.0.1
 */