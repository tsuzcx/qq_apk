package com.tencent.mm.plugin.appbrand.appcache.predownload.b;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.a.b;
import com.tencent.mm.plugin.appbrand.config.a.b.a.b;
import com.tencent.mm.plugin.appbrand.config.z;
import com.tencent.mm.protocal.protobuf.fnv;
import com.tencent.mm.protocal.protobuf.fnw;
import com.tencent.mm.protocal.protobuf.fpn;
import com.tencent.mm.protocal.protobuf.fps;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public class e
  extends a<Boolean, fps>
{
  private static Boolean a(String paramString1, String paramString2, fps paramfps)
  {
    AppMethodBeat.i(44391);
    Object localObject1 = paramfps.UNG;
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
        Object localObject2 = new fnw();
        ((fnw)localObject2).parseFrom((byte[])localObject1);
        localObject1 = m.bFF().c(paramString1, new String[] { "versionInfo" });
        WxaAttributes.WxaVersionInfo localWxaVersionInfo;
        if (localObject1 == null)
        {
          localWxaVersionInfo = null;
          localObject1 = null;
          localObject3 = ((fnw)localObject2).RTU.iterator();
          if (((Iterator)localObject3).hasNext())
          {
            fnv localfnv = (fnv)((Iterator)localObject3).next();
            if (!"WxaAppVersionInfo".equals(localfnv.CRg)) {
              break label516;
            }
            localObject1 = WxaAttributes.WxaVersionInfo.afv(localfnv.Izj);
            break label516;
          }
        }
        else
        {
          localWxaVersionInfo = ((WxaAttributes)localObject1).bLH();
          continue;
        }
        if (localObject1 == null)
        {
          localObject1 = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.nKB;
          com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.F(paramfps.UNq.UNn, 87L);
          paramfps = Boolean.FALSE;
          AppMethodBeat.o(44391);
          return paramfps;
        }
        Object localObject3 = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.nKB;
        com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.F(paramfps.UNq.UNn, 88L);
        if ((localWxaVersionInfo != null) && (localObject1 != null))
        {
          if (localWxaVersionInfo.appVersion < ((WxaAttributes.WxaVersionInfo)localObject1).appVersion)
          {
            break label519;
            if (!bool2) {
              continue;
            }
            m.bFF().a(paramString1, ((fnw)localObject2).RTT, ((fnw)localObject2).RTU);
            if (m.bFF().c(paramString1, new String[0]) != null)
            {
              bool1 = true;
              if (bool1) {
                ((b)m.W(b.class)).b(new b.a.b(paramString1));
              }
              localObject2 = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.nKB;
              j = paramfps.UNq.UNn;
              if (!bool1) {
                continue;
              }
              i = 85;
              com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.F(j, i);
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
          localObject2 = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.nKB;
          com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.F(paramfps.UNq.UNn, 84L);
          bool1 = false;
          continue;
          i = localWxaVersionInfo.appVersion;
          continue;
          int j = ((WxaAttributes.WxaVersionInfo)localObject1).appVersion;
          continue;
          continue;
        }
      }
      catch (Exception paramfps)
      {
        Log.printErrStackTrace("MicroMsg.AppBrand.Predownload.CmdIssueContact", paramfps, "call[%s | %s], decode base64", new Object[] { paramString1, paramString2 });
        paramString1 = Boolean.FALSE;
        AppMethodBeat.o(44391);
        return paramString1;
      }
      label516:
      label519:
      boolean bool2 = true;
    }
  }
  
  final String bHX()
  {
    return "CmdIssueContact";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.b.e
 * JD-Core Version:    0.7.0.1
 */