package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.content.Context;
import android.net.DhcpInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.o;
import com.tencent.mm.protocal.protobuf.vd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class b$1
  implements Runnable
{
  b$1(b paramb, int paramInt, List paramList) {}
  
  public final void run()
  {
    AppMethodBeat.i(17807);
    Object localObject;
    int k;
    String str;
    int i;
    switch (this.bHS)
    {
    default: 
      AppMethodBeat.o(17807);
      return;
    case 1: 
      localObject = (WifiManager)ah.getContext().getSystemService("wifi");
      int j = ((WifiManager)localObject).getConnectionInfo().getIpAddress();
      localObject = ((WifiManager)localObject).getDhcpInfo();
      if (localObject == null)
      {
        AppMethodBeat.o(17807);
        return;
      }
      k = ((DhcpInfo)localObject).netmask;
      str = (j & 0xFF) + "." + (j >> 8 & 0xFF) + "." + (j >> 16 & 0xFF) + "." + (j >> 24 & 0xFF);
      ab.e("MicroMsg.BakOldJavaEngine", "localip:%s, mask:%d", new Object[] { str, Integer.valueOf(k) });
      localObject = null;
      i = 0;
      Iterator localIterator = this.jHh.iterator();
      label193:
      while (localIterator.hasNext())
      {
        vd localvd = (vd)localIterator.next();
        ab.i("MicroMsg.BakOldJavaEngine", "try ip:%s", new Object[] { localvd.wKH });
        if (localvd.wKH != null)
        {
          String[] arrayOfString = localvd.wKH.split("\\.");
          if (arrayOfString.length >= 4)
          {
            int m = o.z(new byte[] { (byte)(bo.getInt(arrayOfString[0], 0) & 0xFF), (byte)(bo.getInt(arrayOfString[1], 0) & 0xFF), (byte)(bo.getInt(arrayOfString[2], 0) & 0xFF), (byte)(bo.getInt(arrayOfString[3], 0) & 0xFF) });
            if ((k & m) == (k & j))
            {
              b.a(this.jHi, localvd.wKH, ((Integer)localvd.wNF.getFirst()).intValue());
              AppMethodBeat.o(17807);
              return;
            }
            if ((m & 0xFFFF) != (0xFFFF & j)) {
              break label557;
            }
            localObject = localvd.wKH;
            i = ((Integer)localvd.wNF.getFirst()).intValue();
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
        ab.w("MicroMsg.BakOldJavaEngine", "try to connect to secondary:%s, port:%d", new Object[] { localObject, Integer.valueOf(i) });
        b.a(this.jHi, (String)localObject, i);
        AppMethodBeat.o(17807);
        return;
      }
      b.a(this.jHi, 10009, String.format("not match ip mask:%d, localip:%s", new Object[] { Integer.valueOf(k), str }).getBytes());
      ab.e("MicroMsg.BakOldJavaEngine", "not match ip mask:%d, localip:%s", new Object[] { Integer.valueOf(k), str });
      AppMethodBeat.o(17807);
      return;
      b.a(this.jHi, ((Integer)((vd)this.jHh.get(0)).wNF.getFirst()).intValue());
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.b.1
 * JD-Core Version:    0.7.0.1
 */