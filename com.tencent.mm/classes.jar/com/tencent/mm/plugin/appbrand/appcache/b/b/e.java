package com.tencent.mm.plugin.appbrand.appcache.b.b;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.a.b;
import com.tencent.mm.plugin.appbrand.config.a.b.a.b;
import com.tencent.mm.plugin.appbrand.config.v;
import com.tencent.mm.protocal.protobuf.duq;
import com.tencent.mm.protocal.protobuf.dur;
import com.tencent.mm.protocal.protobuf.dwf;
import com.tencent.mm.protocal.protobuf.dwk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;

public class e
  extends a<Boolean, dwk>
{
  private static Boolean a(String paramString1, String paramString2, dwk paramdwk)
  {
    AppMethodBeat.i(44391);
    Object localObject1 = paramdwk.EKv;
    if (bt.isNullOrNil((String)localObject1))
    {
      ad.e("MicroMsg.AppBrand.Predownload.CmdIssueContact", "call[%s | %s], empty base64", new Object[] { paramString1, paramString2 });
      paramString1 = Boolean.FALSE;
      AppMethodBeat.o(44391);
      return paramString1;
    }
    for (;;)
    {
      try
      {
        localObject1 = Base64.decode((String)localObject1, 0);
        Object localObject2 = new dur();
        ((dur)localObject2).parseFrom((byte[])localObject1);
        localObject1 = j.aOC().d(paramString1, new String[] { "versionInfo" });
        WxaAttributes.WxaVersionInfo localWxaVersionInfo;
        if (localObject1 == null)
        {
          localWxaVersionInfo = null;
          localObject1 = null;
          localObject3 = ((dur)localObject2).CIv.iterator();
          if (((Iterator)localObject3).hasNext())
          {
            duq localduq = (duq)((Iterator)localObject3).next();
            if (!"WxaAppVersionInfo".equals(localduq.sdv)) {
              break label516;
            }
            localObject1 = WxaAttributes.WxaVersionInfo.Gu(localduq.vJI);
            break label516;
          }
        }
        else
        {
          localWxaVersionInfo = ((WxaAttributes)localObject1).aTP();
          continue;
        }
        if (localObject1 == null)
        {
          localObject1 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.iQw;
          com.tencent.mm.plugin.appbrand.appcache.b.c.a.D(paramdwk.EKf.EKc, 87L);
          paramdwk = Boolean.FALSE;
          AppMethodBeat.o(44391);
          return paramdwk;
        }
        Object localObject3 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.iQw;
        com.tencent.mm.plugin.appbrand.appcache.b.c.a.D(paramdwk.EKf.EKc, 88L);
        if ((localWxaVersionInfo != null) && (localObject1 != null))
        {
          if (localWxaVersionInfo.aAS < ((WxaAttributes.WxaVersionInfo)localObject1).aAS)
          {
            break label519;
            if (!bool2) {
              continue;
            }
            j.aOC().a(paramString1, ((dur)localObject2).CIu, ((dur)localObject2).CIv);
            if (j.aOC().d(paramString1, new String[0]) != null)
            {
              bool1 = true;
              if (bool1) {
                ((b)j.T(b.class)).b(new b.a.b(paramString1));
              }
              localObject2 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.iQw;
              j = paramdwk.EKf.EKc;
              if (!bool1) {
                continue;
              }
              i = 85;
              com.tencent.mm.plugin.appbrand.appcache.b.c.a.D(j, i);
              if (localWxaVersionInfo != null) {
                continue;
              }
              i = -1;
              if (localObject1 != null) {
                continue;
              }
              j = -1;
              ad.i("MicroMsg.AppBrand.Predownload.CmdIssueContact", "call[%s | %s], record.ver %d, issue.ver %d, doIssue %b, issueRet %b", new Object[] { paramString1, paramString2, Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
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
          localObject2 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.iQw;
          com.tencent.mm.plugin.appbrand.appcache.b.c.a.D(paramdwk.EKf.EKc, 84L);
          bool1 = false;
          continue;
          i = localWxaVersionInfo.aAS;
          continue;
          int j = ((WxaAttributes.WxaVersionInfo)localObject1).aAS;
          continue;
          continue;
        }
      }
      catch (Exception paramdwk)
      {
        ad.printErrStackTrace("MicroMsg.AppBrand.Predownload.CmdIssueContact", paramdwk, "call[%s | %s], decode base64", new Object[] { paramString1, paramString2 });
        paramString1 = Boolean.FALSE;
        AppMethodBeat.o(44391);
        return paramString1;
      }
      label516:
      label519:
      boolean bool2 = true;
    }
  }
  
  final String aQI()
  {
    return "CmdIssueContact";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.b.e
 * JD-Core Version:    0.7.0.1
 */