package com.tencent.mm.plugin.hp.net;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.boots.a.c;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.ccc;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.h;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e
{
  public static LinkedList<ccc> cTl()
  {
    AppMethodBeat.i(189693);
    LinkedList localLinkedList = new LinkedList();
    long l1 = 0L;
    try
    {
      long l2 = com.tencent.mm.kernel.a.agb() & 0xFFFFFFFF;
      l1 = l2;
      ac.i("MicroMsg.Tinker.NetSceneUtil", "uin is %s", new Object[] { bs.aLJ(String.valueOf(l2)) });
      l1 = l2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        ac.printErrStackTrace("MicroMsg.Tinker.NetSceneUtil", localException, "tinker patch manager get uin failed.", new Object[0]);
        continue;
        String str = "0";
        continue;
        str = "0";
        continue;
        int i = 2;
      }
      AppMethodBeat.o(189693);
    }
    localLinkedList.add(hg("code-version", h.gMJ));
    localLinkedList.add(hg("code-reversion", h.REV));
    localLinkedList.add(hg("sdk", String.valueOf(Build.VERSION.SDK_INT)));
    localLinkedList.add(hg("os-name", d.DHZ));
    localLinkedList.add(hg("device-brand", d.DHW));
    localLinkedList.add(hg("device-name", d.DEVICE_NAME));
    if (Build.SUPPORTED_64_BIT_ABIS.length > 0)
    {
      localObject = "1";
      localLinkedList.add(hg("support-64-bit", (String)localObject));
      if (!q.is64BitRuntime()) {
        break label338;
      }
      localObject = "1";
      localLinkedList.add(hg("device-is-64-bit-runtime", (String)localObject));
      localLinkedList.add(hg("uin", String.valueOf(l1)));
      if (!ax.isWifi(ai.getContext())) {
        break label345;
      }
      i = 3;
      localLinkedList.add(hg("network", String.valueOf(i)));
      localObject = (c)g.ab(c.class);
      if (localObject == null) {
        break label350;
      }
      localObject = ((c)localObject).bIG();
      if (localObject == null) {
        break label350;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.boots.a.a locala = (com.tencent.mm.plugin.boots.a.a)((Iterator)localObject).next();
        localLinkedList.add(hg(Integer.toHexString(locala.field_key), String.valueOf(locala.field_dau)));
      }
    }
    label338:
    label345:
    label350:
    return localLinkedList;
  }
  
  private static ccc hg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(189694);
    ccc localccc = new ccc();
    localccc.key = paramString1;
    localccc.value = paramString2;
    AppMethodBeat.o(189694);
    return localccc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.net.e
 * JD-Core Version:    0.7.0.1
 */