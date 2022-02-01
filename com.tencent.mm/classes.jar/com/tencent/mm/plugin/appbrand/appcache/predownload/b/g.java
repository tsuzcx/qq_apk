package com.tencent.mm.plugin.appbrand.appcache.predownload.b;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.a.b;
import com.tencent.mm.plugin.appbrand.config.a.b.a.a;
import com.tencent.mm.plugin.appbrand.config.af;
import com.tencent.mm.protocal.protobuf.gku;
import com.tencent.mm.protocal.protobuf.gkv;
import com.tencent.mm.protocal.protobuf.gmn;
import com.tencent.mm.protocal.protobuf.gmu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public class g
  extends a<Boolean, gmu>
{
  private static Boolean a(String paramString1, String paramString2, gmu paramgmu)
  {
    AppMethodBeat.i(44391);
    Object localObject1 = paramgmu.acid;
    if (Util.isNullOrNil((String)localObject1))
    {
      Log.e("MicroMsg.AppBrand.Predownload.CmdIssueContact", "call[%s | %s], empty base64", new Object[] { paramString1, paramString2 });
      paramString1 = Boolean.FALSE;
      AppMethodBeat.o(44391);
      return paramString1;
    }
    for (;;)
    {
      try
      {
        localObject1 = Base64.decode((String)localObject1, 0);
        Object localObject2 = new gkv();
        ((gkv)localObject2).parseFrom((byte[])localObject1);
        localObject1 = n.cfc().d(paramString1, new String[] { "versionInfo" });
        WxaAttributes.WxaVersionInfo localWxaVersionInfo;
        if (localObject1 == null)
        {
          localWxaVersionInfo = null;
          localObject1 = null;
          localObject3 = ((gkv)localObject2).YRu.iterator();
          if (((Iterator)localObject3).hasNext())
          {
            gku localgku = (gku)((Iterator)localObject3).next();
            if (!"WxaAppVersionInfo".equals(localgku.ILw)) {
              break label516;
            }
            localObject1 = WxaAttributes.WxaVersionInfo.XW(localgku.OzQ);
            break label516;
          }
        }
        else
        {
          localWxaVersionInfo = ((WxaAttributes)localObject1).clf();
          continue;
        }
        if (localObject1 == null)
        {
          localObject1 = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.qJY;
          com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.ac(paramgmu.achK.achH, 87L);
          paramgmu = Boolean.FALSE;
          AppMethodBeat.o(44391);
          return paramgmu;
        }
        Object localObject3 = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.qJY;
        com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.ac(paramgmu.achK.achH, 88L);
        if ((localWxaVersionInfo != null) && (localObject1 != null))
        {
          if (localWxaVersionInfo.appVersion < ((WxaAttributes.WxaVersionInfo)localObject1).appVersion)
          {
            break label519;
            if (!bool2) {
              continue;
            }
            n.cfc().a(paramString1, ((gkv)localObject2).YRt, ((gkv)localObject2).YRu);
            if (n.cfc().d(paramString1, new String[0]) != null)
            {
              bool1 = true;
              if (bool1) {
                ((b)n.ag(b.class)).a(new b.a.a(paramString1));
              }
              localObject2 = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.qJY;
              j = paramgmu.achK.achH;
              if (!bool1) {
                continue;
              }
              i = 85;
              com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.ac(j, i);
              if (localWxaVersionInfo != null) {
                continue;
              }
              i = -1;
              if (localObject1 != null) {
                continue;
              }
              j = -1;
              Log.i("MicroMsg.AppBrand.Predownload.CmdIssueContact", "call[%s | %s], record.ver %d, issue.ver %d, doIssue %b, issueRet %b", new Object[] { paramString1, paramString2, Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
              AppMethodBeat.o(44391);
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
          localObject2 = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.qJY;
          com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.ac(paramgmu.achK.achH, 84L);
          bool1 = false;
          continue;
          i = localWxaVersionInfo.appVersion;
          continue;
          int j = ((WxaAttributes.WxaVersionInfo)localObject1).appVersion;
          continue;
          continue;
        }
      }
      catch (Exception paramgmu)
      {
        Log.printErrStackTrace("MicroMsg.AppBrand.Predownload.CmdIssueContact", paramgmu, "call[%s | %s], decode base64", new Object[] { paramString1, paramString2 });
        paramString1 = Boolean.FALSE;
        AppMethodBeat.o(44391);
        return paramString1;
      }
      label516:
      label519:
      boolean bool2 = true;
    }
  }
  
  final String cht()
  {
    return "CmdIssueContact";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.b.g
 * JD-Core Version:    0.7.0.1
 */