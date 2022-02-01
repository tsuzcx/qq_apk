package com.tencent.mm.plugin.appbrand.appcache.b.b;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.b.e.e;
import com.tencent.mm.protocal.protobuf.bot;
import com.tencent.mm.protocal.protobuf.ebw;
import com.tencent.mm.protocal.protobuf.ecd;
import com.tencent.mm.protocal.protobuf.vg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class g
  extends a<Boolean, ecd>
{
  private static Boolean a(String paramString1, String paramString2, ecd paramecd)
  {
    AppMethodBeat.i(44401);
    Object localObject = paramecd.GhJ;
    if (bs.isNullOrNil((String)localObject))
    {
      ac.e("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", "call[%s | %s], empty base64", new Object[] { paramString1, paramString2 });
      paramString1 = Boolean.FALSE;
      AppMethodBeat.o(44401);
      return paramString1;
    }
    if (bs.gY(paramecd.FWP))
    {
      ac.e("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", "call[%s | %s], empty sceneList", new Object[] { paramString1, paramString2 });
      paramString1 = Boolean.FALSE;
      AppMethodBeat.o(44401);
      return paramString1;
    }
    for (;;)
    {
      try
      {
        byte[] arrayOfByte = Base64.decode((String)localObject, 0);
        localObject = new bot();
        ((bot)localObject).parseFrom(arrayOfByte);
        if (((bot)localObject).Feg.Epw.xy.length == 0)
        {
          ac.e("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", "call[%s | %s], parse pb, invalid foreground control bytes", new Object[] { paramString1, paramString2 });
          localObject = com.tencent.mm.plugin.appbrand.appcache.b.c.a.jqG;
          com.tencent.mm.plugin.appbrand.appcache.b.c.a.A(paramecd.Ghr.Gho, 105L);
          paramecd = Boolean.FALSE;
          AppMethodBeat.o(44401);
          return paramecd;
        }
        localObject = com.tencent.mm.plugin.appbrand.appcache.b.c.a.jqG;
        com.tencent.mm.plugin.appbrand.appcache.b.c.a.A(paramecd.Ghr.Gho, 104L);
        LinkedList localLinkedList = paramecd.FWP;
        long l1 = paramecd.GhK & 0xFFFFFFFF;
        long l2 = paramecd.GhL & 0xFFFFFFFF;
        if (localLinkedList == null)
        {
          localObject = "null";
          ac.i("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", "call[%s| %s] WriteToStorage, sceneList %s, time[%d, %d]", new Object[] { paramString1, paramString2, localObject, Long.valueOf(l1), Long.valueOf(l2) });
          boolean bool = ((e)j.T(e.class)).a(arrayOfByte, paramString2, localLinkedList, l1, l2);
          localObject = com.tencent.mm.plugin.appbrand.appcache.b.c.a.jqG;
          int j = paramecd.Ghr.Gho;
          if (!bool) {
            break label456;
          }
          i = 107;
          com.tencent.mm.plugin.appbrand.appcache.b.c.a.A(j, i);
          AppMethodBeat.o(44401);
          return Boolean.valueOf(bool);
        }
        if (bs.gY(localLinkedList))
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
      catch (Exception paramecd)
      {
        ac.printErrStackTrace("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", paramecd, "call[%s | %s], decode base64", new Object[] { paramString1, paramString2 });
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
  
  final String aXD()
  {
    return "CmdIssueLaunch";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.b.g
 * JD-Core Version:    0.7.0.1
 */