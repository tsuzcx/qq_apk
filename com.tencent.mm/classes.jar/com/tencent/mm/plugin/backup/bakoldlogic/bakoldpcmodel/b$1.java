package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.content.Context;
import android.net.DhcpInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.mm.a.n;
import com.tencent.mm.protocal.c.ri;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class b$1
  implements Runnable
{
  b$1(b paramb, int paramInt, List paramList) {}
  
  public final void run()
  {
    Object localObject;
    int k;
    String str;
    int i;
    switch (this.bns)
    {
    default: 
    case 1: 
      int j;
      do
      {
        return;
        localObject = (WifiManager)ae.getContext().getSystemService("wifi");
        j = ((WifiManager)localObject).getConnectionInfo().getIpAddress();
        localObject = ((WifiManager)localObject).getDhcpInfo();
      } while (localObject == null);
      k = ((DhcpInfo)localObject).netmask;
      str = (j & 0xFF) + "." + (j >> 8 & 0xFF) + "." + (j >> 16 & 0xFF) + "." + (j >> 24 & 0xFF);
      y.e("MicroMsg.BakOldJavaEngine", "localip:%s, mask:%d", new Object[] { str, Integer.valueOf(k) });
      localObject = null;
      i = 0;
      Iterator localIterator = this.hNF.iterator();
      while (localIterator.hasNext())
      {
        ri localri = (ri)localIterator.next();
        y.i("MicroMsg.BakOldJavaEngine", "try ip:%s", new Object[] { localri.sMR });
        if (localri.sMR != null)
        {
          String[] arrayOfString = localri.sMR.split("\\.");
          if (arrayOfString.length >= 4)
          {
            int m = n.q(new byte[] { (byte)(bk.getInt(arrayOfString[0], 0) & 0xFF), (byte)(bk.getInt(arrayOfString[1], 0) & 0xFF), (byte)(bk.getInt(arrayOfString[2], 0) & 0xFF), (byte)(bk.getInt(arrayOfString[3], 0) & 0xFF) });
            if ((k & m) == (k & j))
            {
              b.a(this.hNG, localri.sMR, ((Integer)localri.sPm.getFirst()).intValue());
              return;
            }
            if ((m & 0xFFFF) != (0xFFFF & j)) {
              break label520;
            }
            localObject = localri.sMR;
            i = ((Integer)localri.sPm.getFirst()).intValue();
          }
        }
      }
    }
    label520:
    for (;;)
    {
      break;
      if (localObject != null)
      {
        y.w("MicroMsg.BakOldJavaEngine", "try to connect to secondary:%s, port:%d", new Object[] { localObject, Integer.valueOf(i) });
        b.a(this.hNG, (String)localObject, i);
        return;
      }
      b.a(this.hNG, 10009, String.format("not match ip mask:%d, localip:%s", new Object[] { Integer.valueOf(k), str }).getBytes());
      y.e("MicroMsg.BakOldJavaEngine", "not match ip mask:%d, localip:%s", new Object[] { Integer.valueOf(k), str });
      return;
      b.a(this.hNG, ((Integer)((ri)this.hNF.get(0)).sPm.getFirst()).intValue());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.b.1
 * JD-Core Version:    0.7.0.1
 */