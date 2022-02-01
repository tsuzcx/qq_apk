package com.tencent.mm.plugin.appbrand.appcache.b.b;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.a.b;
import com.tencent.mm.plugin.appbrand.config.a.b.a.b;
import com.tencent.mm.plugin.appbrand.config.v;
import com.tencent.mm.protocal.protobuf.eah;
import com.tencent.mm.protocal.protobuf.eai;
import com.tencent.mm.protocal.protobuf.ebw;
import com.tencent.mm.protocal.protobuf.ecb;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.LinkedList;

public class e
  extends a<Boolean, ecb>
{
  private static Boolean a(String paramString1, String paramString2, ecb paramecb)
  {
    AppMethodBeat.i(44391);
    Object localObject1 = paramecb.GhH;
    if (bs.isNullOrNil((String)localObject1))
    {
      ac.e("MicroMsg.AppBrand.Predownload.CmdIssueContact", "call[%s | %s], empty base64", new Object[] { paramString1, paramString2 });
      paramString1 = Boolean.FALSE;
      AppMethodBeat.o(44391);
      return paramString1;
    }
    for (;;)
    {
      try
      {
        localObject1 = Base64.decode((String)localObject1, 0);
        Object localObject2 = new eai();
        ((eai)localObject2).parseFrom((byte[])localObject1);
        localObject1 = j.aVu().d(paramString1, new String[] { "versionInfo" });
        WxaAttributes.WxaVersionInfo localWxaVersionInfo;
        if (localObject1 == null)
        {
          localWxaVersionInfo = null;
          localObject1 = null;
          localObject3 = ((eai)localObject2).EaX.iterator();
          if (((Iterator)localObject3).hasNext())
          {
            eah localeah = (eah)((Iterator)localObject3).next();
            if (!"WxaAppVersionInfo".equals(localeah.tlp)) {
              break label516;
            }
            localObject1 = WxaAttributes.WxaVersionInfo.Ky(localeah.wTM);
            break label516;
          }
        }
        else
        {
          localWxaVersionInfo = ((WxaAttributes)localObject1).baN();
          continue;
        }
        if (localObject1 == null)
        {
          localObject1 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.jqG;
          com.tencent.mm.plugin.appbrand.appcache.b.c.a.A(paramecb.Ghr.Gho, 87L);
          paramecb = Boolean.FALSE;
          AppMethodBeat.o(44391);
          return paramecb;
        }
        Object localObject3 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.jqG;
        com.tencent.mm.plugin.appbrand.appcache.b.c.a.A(paramecb.Ghr.Gho, 88L);
        if ((localWxaVersionInfo != null) && (localObject1 != null))
        {
          if (localWxaVersionInfo.aBM < ((WxaAttributes.WxaVersionInfo)localObject1).aBM)
          {
            break label519;
            if (!bool2) {
              continue;
            }
            j.aVu().a(paramString1, ((eai)localObject2).EaW, ((eai)localObject2).EaX);
            if (j.aVu().d(paramString1, new String[0]) != null)
            {
              bool1 = true;
              if (bool1) {
                ((b)j.T(b.class)).b(new b.a.b(paramString1));
              }
              localObject2 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.jqG;
              j = paramecb.Ghr.Gho;
              if (!bool1) {
                continue;
              }
              i = 85;
              com.tencent.mm.plugin.appbrand.appcache.b.c.a.A(j, i);
              if (localWxaVersionInfo != null) {
                continue;
              }
              i = -1;
              if (localObject1 != null) {
                continue;
              }
              j = -1;
              ac.i("MicroMsg.AppBrand.Predownload.CmdIssueContact", "call[%s | %s], record.ver %d, issue.ver %d, doIssue %b, issueRet %b", new Object[] { paramString1, paramString2, Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
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
          localObject2 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.jqG;
          com.tencent.mm.plugin.appbrand.appcache.b.c.a.A(paramecb.Ghr.Gho, 84L);
          bool1 = false;
          continue;
          i = localWxaVersionInfo.aBM;
          continue;
          int j = ((WxaAttributes.WxaVersionInfo)localObject1).aBM;
          continue;
          continue;
        }
      }
      catch (Exception paramecb)
      {
        ac.printErrStackTrace("MicroMsg.AppBrand.Predownload.CmdIssueContact", paramecb, "call[%s | %s], decode base64", new Object[] { paramString1, paramString2 });
        paramString1 = Boolean.FALSE;
        AppMethodBeat.o(44391);
        return paramString1;
      }
      label516:
      label519:
      boolean bool2 = true;
    }
  }
  
  final String aXD()
  {
    return "CmdIssueContact";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.b.e
 * JD-Core Version:    0.7.0.1
 */