package com.tencent.mm.plugin.hp.net;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.boots.a.c;
import com.tencent.mm.protocal.protobuf.bxh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.h;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d
{
  public static LinkedList<bxh> cGb()
  {
    AppMethodBeat.i(187224);
    LinkedList localLinkedList = new LinkedList();
    long l1 = 0L;
    try
    {
      long l2 = com.tencent.mm.kernel.a.aeL() & 0xFFFFFFFF;
      l1 = l2;
      ad.i("MicroMsg.Tinker.NetSceneUtil", "uin is %s", new Object[] { bt.aGs(String.valueOf(l2)) });
      l1 = l2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        ad.printErrStackTrace("MicroMsg.Tinker.NetSceneUtil", localException, "tinker patch manager get uin failed.", new Object[0]);
        continue;
        String str = "0";
        continue;
        str = "0";
        continue;
        int i = 2;
      }
      AppMethodBeat.o(187224);
    }
    localLinkedList.add(gP("code-version", h.glW));
    localLinkedList.add(gP("code-reversion", h.REV));
    localLinkedList.add(gP("sdk", String.valueOf(Build.VERSION.SDK_INT)));
    localLinkedList.add(gP("os-name", com.tencent.mm.protocal.d.CpH));
    localLinkedList.add(gP("device-brand", com.tencent.mm.protocal.d.CpE));
    localLinkedList.add(gP("device-name", com.tencent.mm.protocal.d.DEVICE_NAME));
    if (Build.SUPPORTED_64_BIT_ABIS.length > 0)
    {
      localObject = "1";
      localLinkedList.add(gP("support-64-bit", (String)localObject));
      if (!q.is64BitRuntime()) {
        break label338;
      }
      localObject = "1";
      localLinkedList.add(gP("device-is-64-bit-runtime", (String)localObject));
      localLinkedList.add(gP("uin", String.valueOf(l1)));
      if (!ay.isWifi(aj.getContext())) {
        break label345;
      }
      i = 3;
      localLinkedList.add(gP("network", String.valueOf(i)));
      localObject = (c)g.ab(c.class);
      if (localObject == null) {
        break label350;
      }
      localObject = ((c)localObject).bBI();
      if (localObject == null) {
        break label350;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.boots.a.a locala = (com.tencent.mm.plugin.boots.a.a)((Iterator)localObject).next();
        localLinkedList.add(gP(Integer.toHexString(locala.field_key), String.valueOf(locala.field_dau)));
      }
    }
    label338:
    label345:
    label350:
    return localLinkedList;
  }
  
  private static bxh gP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(187225);
    bxh localbxh = new bxh();
    localbxh.key = paramString1;
    localbxh.value = paramString2;
    AppMethodBeat.o(187225);
    return localbxh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.net.d
 * JD-Core Version:    0.7.0.1
 */