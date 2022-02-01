package com.tencent.mm.plugin.appbrand.appcache.b.b;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.b.e.e;
import com.tencent.mm.protocal.protobuf.btg;
import com.tencent.mm.protocal.protobuf.eic;
import com.tencent.mm.protocal.protobuf.eij;
import com.tencent.mm.protocal.protobuf.xf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class g
  extends a<Boolean, eij>
{
  private static Boolean a(String paramString1, String paramString2, eij parameij)
  {
    AppMethodBeat.i(44401);
    Object localObject = parameij.HSX;
    if (bt.isNullOrNil((String)localObject))
    {
      ad.e("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", "call[%s | %s], empty base64", new Object[] { paramString1, paramString2 });
      paramString1 = Boolean.FALSE;
      AppMethodBeat.o(44401);
      return paramString1;
    }
    if (bt.hj(parameij.HHF))
    {
      ad.e("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", "call[%s | %s], empty sceneList", new Object[] { paramString1, paramString2 });
      paramString1 = Boolean.FALSE;
      AppMethodBeat.o(44401);
      return paramString1;
    }
    for (;;)
    {
      try
      {
        byte[] arrayOfByte = Base64.decode((String)localObject, 0);
        localObject = new btg();
        ((btg)localObject).parseFrom(arrayOfByte);
        if (((btg)localObject).GNK.FWI.zr.length == 0)
        {
          ad.e("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", "call[%s | %s], parse pb, invalid foreground control bytes", new Object[] { paramString1, paramString2 });
          localObject = com.tencent.mm.plugin.appbrand.appcache.b.c.a.jKA;
          com.tencent.mm.plugin.appbrand.appcache.b.c.a.A(parameij.HSF.HSC, 105L);
          parameij = Boolean.FALSE;
          AppMethodBeat.o(44401);
          return parameij;
        }
        localObject = com.tencent.mm.plugin.appbrand.appcache.b.c.a.jKA;
        com.tencent.mm.plugin.appbrand.appcache.b.c.a.A(parameij.HSF.HSC, 104L);
        LinkedList localLinkedList = parameij.HHF;
        long l1 = parameij.HSY & 0xFFFFFFFF;
        long l2 = parameij.HSZ & 0xFFFFFFFF;
        if (localLinkedList == null)
        {
          localObject = "null";
          ad.i("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", "call[%s| %s] WriteToStorage, sceneList %s, time[%d, %d]", new Object[] { paramString1, paramString2, localObject, Long.valueOf(l1), Long.valueOf(l2) });
          boolean bool = ((e)j.T(e.class)).a(arrayOfByte, paramString2, localLinkedList, l1, l2);
          localObject = com.tencent.mm.plugin.appbrand.appcache.b.c.a.jKA;
          int j = parameij.HSF.HSC;
          if (!bool) {
            break label456;
          }
          i = 107;
          com.tencent.mm.plugin.appbrand.appcache.b.c.a.A(j, i);
          AppMethodBeat.o(44401);
          return Boolean.valueOf(bool);
        }
        if (bt.hj(localLinkedList))
        {
          localObject = "{}";
          continue;
        }
        localObject = new StringBuilder("{");
        Iterator localIterator = localLinkedList.iterator();
        if (localIterator.hasNext())
        {
          ((StringBuilder)localObject).append(localIterator.next().toString()).append(',');
          continue;
        }
        ((StringBuilder)localObject).append("}");
      }
      catch (Exception parameij)
      {
        ad.printErrStackTrace("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", parameij, "call[%s | %s], decode base64", new Object[] { paramString1, paramString2 });
        paramString1 = Boolean.FALSE;
        AppMethodBeat.o(44401);
        return paramString1;
      }
      localObject = ((StringBuilder)localObject).toString();
      continue;
      label456:
      int i = 108;
    }
  }
  
  final String bbb()
  {
    return "CmdIssueLaunch";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.b.g
 * JD-Core Version:    0.7.0.1
 */