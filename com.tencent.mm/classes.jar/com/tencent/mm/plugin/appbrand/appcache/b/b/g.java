package com.tencent.mm.plugin.appbrand.appcache.b.b;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.b.e.e;
import com.tencent.mm.protocal.protobuf.bua;
import com.tencent.mm.protocal.protobuf.ejt;
import com.tencent.mm.protocal.protobuf.eka;
import com.tencent.mm.protocal.protobuf.xi;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class g
  extends a<Boolean, eka>
{
  private static Boolean a(String paramString1, String paramString2, eka parameka)
  {
    AppMethodBeat.i(44401);
    Object localObject = parameka.Ine;
    if (bu.isNullOrNil((String)localObject))
    {
      ae.e("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", "call[%s | %s], empty base64", new Object[] { paramString1, paramString2 });
      paramString1 = Boolean.FALSE;
      AppMethodBeat.o(44401);
      return paramString1;
    }
    if (bu.ht(parameka.Ibs))
    {
      ae.e("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", "call[%s | %s], empty sceneList", new Object[] { paramString1, paramString2 });
      paramString1 = Boolean.FALSE;
      AppMethodBeat.o(44401);
      return paramString1;
    }
    for (;;)
    {
      try
      {
        byte[] arrayOfByte = Base64.decode((String)localObject, 0);
        localObject = new bua();
        ((bua)localObject).parseFrom(arrayOfByte);
        if (((bua)localObject).Hhk.Gph.zr.length == 0)
        {
          ae.e("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", "call[%s | %s], parse pb, invalid foreground control bytes", new Object[] { paramString1, paramString2 });
          localObject = com.tencent.mm.plugin.appbrand.appcache.b.c.a.jNM;
          com.tencent.mm.plugin.appbrand.appcache.b.c.a.A(parameka.ImM.ImJ, 105L);
          parameka = Boolean.FALSE;
          AppMethodBeat.o(44401);
          return parameka;
        }
        localObject = com.tencent.mm.plugin.appbrand.appcache.b.c.a.jNM;
        com.tencent.mm.plugin.appbrand.appcache.b.c.a.A(parameka.ImM.ImJ, 104L);
        LinkedList localLinkedList = parameka.Ibs;
        long l1 = parameka.Inf & 0xFFFFFFFF;
        long l2 = parameka.Ing & 0xFFFFFFFF;
        if (localLinkedList == null)
        {
          localObject = "null";
          ae.i("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", "call[%s| %s] WriteToStorage, sceneList %s, time[%d, %d]", new Object[] { paramString1, paramString2, localObject, Long.valueOf(l1), Long.valueOf(l2) });
          boolean bool = ((e)j.T(e.class)).a(arrayOfByte, paramString2, localLinkedList, l1, l2);
          localObject = com.tencent.mm.plugin.appbrand.appcache.b.c.a.jNM;
          int j = parameka.ImM.ImJ;
          if (!bool) {
            break label456;
          }
          i = 107;
          com.tencent.mm.plugin.appbrand.appcache.b.c.a.A(j, i);
          AppMethodBeat.o(44401);
          return Boolean.valueOf(bool);
        }
        if (bu.ht(localLinkedList))
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
      catch (Exception parameka)
      {
        ae.printErrStackTrace("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", parameka, "call[%s | %s], decode base64", new Object[] { paramString1, paramString2 });
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
  
  final String bbD()
  {
    return "CmdIssueLaunch";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.b.g
 * JD-Core Version:    0.7.0.1
 */