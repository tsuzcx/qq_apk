package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.plugin.exdevice.service.j.a;
import com.tencent.mm.protocal.protobuf.bjb;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.protocal.protobuf.ke;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class aa
  extends j.a
  implements g
{
  static Object cRu;
  static LinkedList<String> pzD;
  private static HashMap<String, ke> pzE;
  private static final byte[] pzy;
  private static aa pzz;
  final au iRv;
  boolean pyN;
  volatile String pyh;
  a pzA;
  HashMap<String, byte[]> pzB;
  LinkedList<n> pzC;
  
  static
  {
    AppMethodBeat.i(23435);
    pzy = new byte[] { -2, 1, 1 };
    cRu = new Object();
    pzD = new LinkedList();
    pzE = new HashMap(32);
    AppMethodBeat.o(23435);
  }
  
  private aa()
  {
    AppMethodBeat.i(23429);
    this.pzB = new HashMap();
    this.pzC = new LinkedList();
    this.iRv = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(23427);
        ac.i("MicroMsg.exdevice.ScanDeviceLogic", "Restart scanning...");
        ad.cgW().a(0, aa.this);
        AppMethodBeat.o(23427);
        return true;
      }
    }, true);
    this.pyN = false;
    AppMethodBeat.o(23429);
  }
  
  private void a(ke paramke)
  {
    AppMethodBeat.i(23433);
    if (paramke == null)
    {
      ac.e("MicroMsg.exdevice.ScanDeviceLogic", "item null..");
      AppMethodBeat.o(23433);
      return;
    }
    if (bs.isNullOrNil(paramke.DXq))
    {
      ac.e("MicroMsg.exdevice.ScanDeviceLogic", "invalid mac(null or nil)");
      AppMethodBeat.o(23433);
      return;
    }
    if (paramke.Ret != 0)
    {
      ac.e("MicroMsg.exdevice.ScanDeviceLogic", "device(%s) is invalid", new Object[] { paramke.DXq });
      AppMethodBeat.o(23433);
      return;
    }
    if ((paramke.DXx == null) || (bs.isNullOrNil(paramke.DXx.ncU)))
    {
      ac.e("MicroMsg.exdevice.ScanDeviceLogic", "invalid device id(mac=%s)", new Object[] { paramke.DXq });
      AppMethodBeat.o(23433);
      return;
    }
    if ((bs.isNullOrNil(paramke.DXx.DUp)) || (!paramke.DXx.DUp.equals(this.pyh)))
    {
      ac.e("MicroMsg.exdevice.ScanDeviceLogic", "device type (%s) is not equal to brand name (%s)", new Object[] { paramke.ncV, this.pyh });
      AppMethodBeat.o(23433);
      return;
    }
    byte[] arrayOfByte = (byte[])this.pzB.get(paramke.DXq);
    String str1 = paramke.DXq;
    String str2 = paramke.DXx.DUp;
    String str3 = paramke.DXx.ncU;
    String str4 = paramke.ncV;
    int i;
    if (arrayOfByte == null)
    {
      i = 0;
      ac.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, BatchSearch find mac=%s, deviceType=%s, deviceId=%s, %s, %s", new Object[] { str1, str2, str3, str4, Integer.valueOf(i) });
      if (this.pzA == null) {
        break label323;
      }
      if (arrayOfByte == null) {
        break label337;
      }
    }
    label323:
    label337:
    for (arrayOfByte = bc(arrayOfByte);; arrayOfByte = null)
    {
      this.pzA.a(paramke.DXx.ncU, arrayOfByte, false);
      AppMethodBeat.o(23433);
      return;
      i = arrayOfByte.length;
      break;
      ac.e("MicroMsg.exdevice.ScanDeviceLogic", "mCallback null");
      AppMethodBeat.o(23433);
      return;
    }
  }
  
  private static byte[] bc(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23434);
    byte[] arrayOfByte = null;
    int i = 0;
    int j = 0;
    for (;;)
    {
      int k;
      try
      {
        int m;
        if (i < paramArrayOfByte.length - 2)
        {
          m = i + 1;
          k = paramArrayOfByte[i];
          if (k != 0) {
            i = m + 1;
          }
        }
        switch (paramArrayOfByte[m])
        {
        case -1: 
          ac.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, Manufacturer Specific Data size = %s", new Object[] { Integer.valueOf(k) });
          arrayOfByte = new byte[k - 1];
          if (k > 1)
          {
            if ((j < 32) && (j < arrayOfByte.length))
            {
              m = j + 1;
              int n = i + 1;
              arrayOfByte[j] = paramArrayOfByte[i];
              i = n;
              j = m;
              break label217;
            }
          }
          else
          {
            ac.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, Manufacturer Specific Data %s" + b.bd(arrayOfByte));
            continue;
            AppMethodBeat.o(23434);
            return arrayOfByte;
          }
          break;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        ac.printErrStackTrace("MicroMsg.exdevice.ScanDeviceLogic", paramArrayOfByte, "", new Object[0]);
        ac.e("MicroMsg.exdevice.ScanDeviceLogic", "EX in parseBroadcastPacket %s", new Object[] { paramArrayOfByte.getMessage() });
        AppMethodBeat.o(23434);
        return null;
      }
      break label217;
      i += k - 1;
      continue;
      label217:
      k -= 1;
    }
  }
  
  public static aa cgM()
  {
    AppMethodBeat.i(23428);
    if (pzz != null)
    {
      localaa = pzz;
      AppMethodBeat.o(23428);
      return localaa;
    }
    aa localaa = new aa();
    pzz = localaa;
    AppMethodBeat.o(23428);
    return localaa;
  }
  
  public final void BS(int paramInt)
  {
    AppMethodBeat.i(23430);
    ac.i("MicroMsg.exdevice.ScanDeviceLogic", "stopScanDevice %s, stopTimer", new Object[] { Integer.valueOf(paramInt) });
    this.iRv.stopTimer();
    if (this.pyN)
    {
      ad.cgW().BR(paramInt);
      this.pyN = false;
      this.pyh = null;
      this.pzB.clear();
      az.agi().b(542, this);
      ??? = this.pzC.iterator();
      while (((Iterator)???).hasNext())
      {
        n localn = (n)((Iterator)???).next();
        if (localn != null) {
          az.agi().a(localn);
        }
      }
      this.pzC.clear();
      if (this.pzA != null) {
        this.pzA.a(null, null, true);
      }
      this.pzA = null;
    }
    synchronized (cRu)
    {
      pzD.clear();
      AppMethodBeat.o(23430);
      return;
      ac.i("MicroMsg.exdevice.ScanDeviceLogic", "stopScanDevice has been stoped");
    }
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String arg5, int paramInt3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23431);
    if (this.pzB.containsKey(paramString2))
    {
      AppMethodBeat.o(23431);
      return;
    }
    if (paramString2 == null)
    {
      ac.w("MicroMsg.exdevice.ScanDeviceLogic", "deviceMac is null");
      AppMethodBeat.o(23431);
      return;
    }
    paramString1 = paramString2.replaceAll(":", "");
    ??? = pzy;
    if ((bs.cv(paramArrayOfByte)) || (bs.cv(???)) || (???.length > paramArrayOfByte.length)) {
      paramInt1 = -1;
    }
    for (;;)
    {
      if (paramInt1 != -1) {
        if (paramInt1 + 9 <= paramArrayOfByte.length)
        {
          ??? = new byte[paramInt1 + 9];
          System.arraycopy(paramArrayOfByte, 0, ???, 0, ???.length);
          ac.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, scanFound mac:%s, realAd:%s", new Object[] { paramString1, b.bd(???) });
          this.pzB.put(paramString1, ???);
          label158:
          paramString1 = this.pyh + "_" + paramString2;
          if (pzE.containsKey(paramString1)) {
            break label394;
          }
        }
      }
      synchronized (cRu)
      {
        if (pzD.contains(paramString1))
        {
          ac.d("MicroMsg.exdevice.ScanDeviceLogic", "hakon, already doing");
          AppMethodBeat.o(23431);
          return;
          paramInt2 = 0;
          for (;;)
          {
            if (paramInt2 >= paramArrayOfByte.length) {
              break label262;
            }
            paramInt1 = paramInt2;
            if (b.c(paramArrayOfByte, paramInt2, ???)) {
              break;
            }
            paramInt2 += 1;
          }
          label262:
          paramInt1 = -1;
          continue;
          this.pzB.put(paramString1, null);
          break label158;
          this.pzB.put(paramString1, null);
          break label158;
        }
        else
        {
          pzD.add(paramString1);
          ??? = this.pyh;
          paramString2 = new k(new String[] { paramString2 }, ???);
          if (az.agi().a(paramString2, 0))
          {
            this.pzC.add(paramString2);
            AppMethodBeat.o(23431);
            return;
          }
        }
      }
    }
    pzD.remove(paramString1);
    ac.e("MicroMsg.exdevice.ScanDeviceLogic", "MMCore.getNetSceneQueue().doScene failed!!!");
    AppMethodBeat.o(23431);
    return;
    label394:
    ac.d("MicroMsg.exdevice.ScanDeviceLogic", "hakon, hit cache %s, %s", new Object[] { this.pyh, paramString2 });
    a((ke)pzE.get(paramString1));
    AppMethodBeat.o(23431);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String arg3, n paramn)
  {
    AppMethodBeat.i(23432);
    if (paramn == null) {}
    for (Object localObject = "";; localObject = Integer.valueOf(paramn.getType()))
    {
      ac.i("MicroMsg.exdevice.ScanDeviceLogic", "onSceneEnd, %s, errType=%d, errCode=%d, errMsg=%s", new Object[] { localObject, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), ??? });
      this.pzC.remove(paramn);
      if ((paramInt1 == 0) && (paramInt2 == 0) && (paramn != null)) {
        break;
      }
      ac.e("MicroMsg.exdevice.ScanDeviceLogic", "do scene failed!!!");
      AppMethodBeat.o(23432);
      return;
    }
    if (542 == paramn.getType())
    {
      paramn = ((k)paramn).cgH().DXu.iterator();
      while (paramn.hasNext())
      {
        localObject = (ke)paramn.next();
        if (bs.isNullOrNil(((ke)localObject).DXq))
        {
          ac.e("MicroMsg.exdevice.ScanDeviceLogic", "invalid mac(null or nil)");
        }
        else
        {
          String str = this.pyh + "_" + ((ke)localObject).DXq;
          synchronized (cRu)
          {
            if (pzD.contains(str)) {
              pzD.remove(str);
            }
            if (!pzE.containsKey(str))
            {
              ac.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, put into cache, %s", new Object[] { str });
              pzE.put(str, localObject);
            }
            a((ke)localObject);
          }
        }
      }
    }
    AppMethodBeat.o(23432);
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString, byte[] paramArrayOfByte, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.aa
 * JD-Core Version:    0.7.0.1
 */