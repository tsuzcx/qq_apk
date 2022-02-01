package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.content.Context;
import android.net.DhcpInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.o;
import com.tencent.mm.protocal.protobuf.za;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class b$1
  implements Runnable
{
  b$1(b paramb, int paramInt, List paramList) {}
  
  public final void run()
  {
    AppMethodBeat.i(21864);
    Object localObject;
    int k;
    String str;
    int i;
    switch (this.val$type)
    {
    default: 
      AppMethodBeat.o(21864);
      return;
    case 1: 
      localObject = (WifiManager)ai.getContext().getSystemService("wifi");
      int j = ((WifiManager)localObject).getConnectionInfo().getIpAddress();
      localObject = ((WifiManager)localObject).getDhcpInfo();
      if (localObject == null)
      {
        AppMethodBeat.o(21864);
        return;
      }
      k = ((DhcpInfo)localObject).netmask;
      str = (j & 0xFF) + "." + (j >> 8 & 0xFF) + "." + (j >> 16 & 0xFF) + "." + (j >> 24 & 0xFF);
      ac.e("MicroMsg.BakOldJavaEngine", "localip:%s, mask:%d", new Object[] { str, Integer.valueOf(k) });
      localObject = null;
      i = 0;
      Iterator localIterator = this.naA.iterator();
      label193:
      while (localIterator.hasNext())
      {
        za localza = (za)localIterator.next();
        ac.i("MicroMsg.BakOldJavaEngine", "try ip:%s", new Object[] { localza.EpD });
        if (localza.EpD != null)
        {
          String[] arrayOfString = localza.EpD.split("\\.");
          if (arrayOfString.length >= 4)
          {
            int m = o.E(new byte[] { (byte)(bs.getInt(arrayOfString[0], 0) & 0xFF), (byte)(bs.getInt(arrayOfString[1], 0) & 0xFF), (byte)(bs.getInt(arrayOfString[2], 0) & 0xFF), (byte)(bs.getInt(arrayOfString[3], 0) & 0xFF) });
            if ((k & m) == (k & j))
            {
              b.a(this.naB, localza.EpD, ((Integer)localza.Etf.getFirst()).intValue());
              AppMethodBeat.o(21864);
              return;
            }
            if ((m & 0xFFFF) != (0xFFFF & j)) {
              break label557;
            }
            localObject = localza.EpD;
            i = ((Integer)localza.Etf.getFirst()).intValue();
          }
        }
      }
    }
    label557:
    for (;;)
    {
      break label193;
      if (localObject != null)
      {
        ac.w("MicroMsg.BakOldJavaEngine", "try to connect to secondary:%s, port:%d", new Object[] { localObject, Integer.valueOf(i) });
        b.a(this.naB, (String)localObject, i);
        AppMethodBeat.o(21864);
        return;
      }
      b.a(this.naB, 10009, String.format("not match ip mask:%d, localip:%s", new Object[] { Integer.valueOf(k), str }).getBytes());
      ac.e("MicroMsg.BakOldJavaEngine", "not match ip mask:%d, localip:%s", new Object[] { Integer.valueOf(k), str });
      AppMethodBeat.o(21864);
      return;
      b.a(this.naB, ((Integer)((za)this.naA.get(0)).Etf.getFirst()).intValue());
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.b.1
 * JD-Core Version:    0.7.0.1
 */