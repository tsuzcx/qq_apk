package com.tencent.mm.plugin.appbrand.appcache.predownload.b;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.predownload.e.e;
import com.tencent.mm.protocal.protobuf.che;
import com.tencent.mm.protocal.protobuf.fem;
import com.tencent.mm.protocal.protobuf.fet;
import com.tencent.mm.protocal.protobuf.ys;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class g
  extends a<Boolean, fet>
{
  private static Boolean a(String paramString1, String paramString2, fet paramfet)
  {
    AppMethodBeat.i(44401);
    Object localObject = paramfet.NAg;
    if (Util.isNullOrNil((String)localObject))
    {
      Log.e("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", "call[%s | %s], empty base64", new Object[] { paramString1, paramString2 });
      paramString1 = Boolean.FALSE;
      AppMethodBeat.o(44401);
      return paramString1;
    }
    if (Util.isNullOrNil(paramfet.NnI))
    {
      Log.e("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", "call[%s | %s], empty sceneList", new Object[] { paramString1, paramString2 });
      paramString1 = Boolean.FALSE;
      AppMethodBeat.o(44401);
      return paramString1;
    }
    for (;;)
    {
      try
      {
        byte[] arrayOfByte = Base64.decode((String)localObject, 0);
        localObject = new che();
        ((che)localObject).parseFrom(arrayOfByte);
        if (((che)localObject).MmA.LjS.zy.length == 0)
        {
          Log.e("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", "call[%s | %s], parse pb, invalid foreground control bytes", new Object[] { paramString1, paramString2 });
          localObject = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.kQt;
          com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.F(paramfet.NzO.NzL, 105L);
          paramfet = Boolean.FALSE;
          AppMethodBeat.o(44401);
          return paramfet;
        }
        localObject = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.kQt;
        com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.F(paramfet.NzO.NzL, 104L);
        LinkedList localLinkedList = paramfet.NnI;
        long l1 = paramfet.NAh & 0xFFFFFFFF;
        long l2 = paramfet.NAi & 0xFFFFFFFF;
        if (localLinkedList == null)
        {
          localObject = "null";
          Log.i("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", "call[%s| %s] WriteToStorage, sceneList %s, time[%d, %d]", new Object[] { paramString1, paramString2, localObject, Long.valueOf(l1), Long.valueOf(l2) });
          boolean bool = ((e)n.W(e.class)).a(arrayOfByte, paramString2, localLinkedList, l1, l2);
          localObject = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.kQt;
          int j = paramfet.NzO.NzL;
          if (!bool) {
            break label456;
          }
          i = 107;
          com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.F(j, i);
          AppMethodBeat.o(44401);
          return Boolean.valueOf(bool);
        }
        if (Util.isNullOrNil(localLinkedList))
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
      catch (Exception paramfet)
      {
        Log.printErrStackTrace("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", paramfet, "call[%s | %s], decode base64", new Object[] { paramString1, paramString2 });
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
  
  final String bwQ()
  {
    return "CmdIssueLaunch";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.b.g
 * JD-Core Version:    0.7.0.1
 */