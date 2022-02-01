package com.tencent.mm.plugin.appbrand.appcache.predownload.b;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.plugin.appbrand.appcache.predownload.e.e;
import com.tencent.mm.protocal.protobuf.cqa;
import com.tencent.mm.protocal.protobuf.fpn;
import com.tencent.mm.protocal.protobuf.fpu;
import com.tencent.mm.protocal.protobuf.yw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class g
  extends a<Boolean, fpu>
{
  private static Boolean a(String paramString1, String paramString2, fpu paramfpu)
  {
    AppMethodBeat.i(44401);
    Object localObject = paramfpu.UNI;
    if (Util.isNullOrNil((String)localObject))
    {
      Log.e("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", "call[%s | %s], empty base64", new Object[] { paramString1, paramString2 });
      paramString1 = Boolean.FALSE;
      AppMethodBeat.o(44401);
      return paramString1;
    }
    if (Util.isNullOrNil(paramfpu.UAz))
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
        localObject = new cqa();
        ((cqa)localObject).parseFrom(arrayOfByte);
        if (((cqa)localObject).Txv.SkZ.UH.length == 0)
        {
          Log.e("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", "call[%s | %s], parse pb, invalid foreground control bytes", new Object[] { paramString1, paramString2 });
          localObject = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.nKB;
          com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.F(paramfpu.UNq.UNn, 105L);
          paramfpu = Boolean.FALSE;
          AppMethodBeat.o(44401);
          return paramfpu;
        }
        localObject = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.nKB;
        com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.F(paramfpu.UNq.UNn, 104L);
        LinkedList localLinkedList = paramfpu.UAz;
        long l1 = paramfpu.UNJ & 0xFFFFFFFF;
        long l2 = paramfpu.UNK & 0xFFFFFFFF;
        if (localLinkedList == null)
        {
          localObject = "null";
          Log.i("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", "call[%s| %s] WriteToStorage, sceneList %s, time[%d, %d]", new Object[] { paramString1, paramString2, localObject, Long.valueOf(l1), Long.valueOf(l2) });
          boolean bool = ((e)m.W(e.class)).a(arrayOfByte, paramString2, localLinkedList, l1, l2);
          localObject = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.nKB;
          int j = paramfpu.UNq.UNn;
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
      catch (Exception paramfpu)
      {
        Log.printErrStackTrace("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", paramfpu, "call[%s | %s], decode base64", new Object[] { paramString1, paramString2 });
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
  
  final String bHX()
  {
    return "CmdIssueLaunch";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.b.g
 * JD-Core Version:    0.7.0.1
 */