package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.plugin.exdevice.service.j.a;
import com.tencent.mm.protocal.protobuf.bfj;
import com.tencent.mm.protocal.protobuf.jx;
import com.tencent.mm.protocal.protobuf.jy;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class aa
  extends j.a
  implements g
{
  static Object cTX;
  private static final byte[] oWn;
  private static aa oWo;
  static LinkedList<String> oWs;
  private static HashMap<String, jy> oWt;
  final av irp;
  volatile String oUW;
  boolean oVC;
  a oWp;
  HashMap<String, byte[]> oWq;
  LinkedList<n> oWr;
  
  static
  {
    AppMethodBeat.i(23435);
    oWn = new byte[] { -2, 1, 1 };
    cTX = new Object();
    oWs = new LinkedList();
    oWt = new HashMap(32);
    AppMethodBeat.o(23435);
  }
  
  private aa()
  {
    AppMethodBeat.i(23429);
    this.oWq = new HashMap();
    this.oWr = new LinkedList();
    this.irp = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(23427);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ScanDeviceLogic", "Restart scanning...");
        ad.bZN().a(0, aa.this);
        AppMethodBeat.o(23427);
        return true;
      }
    }, true);
    this.oVC = false;
    AppMethodBeat.o(23429);
  }
  
  private void a(jy paramjy)
  {
    AppMethodBeat.i(23433);
    if (paramjy == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ScanDeviceLogic", "item null..");
      AppMethodBeat.o(23433);
      return;
    }
    if (bt.isNullOrNil(paramjy.CEQ))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ScanDeviceLogic", "invalid mac(null or nil)");
      AppMethodBeat.o(23433);
      return;
    }
    if (paramjy.Ret != 0)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ScanDeviceLogic", "device(%s) is invalid", new Object[] { paramjy.CEQ });
      AppMethodBeat.o(23433);
      return;
    }
    if ((paramjy.CEX == null) || (bt.isNullOrNil(paramjy.CEX.mAT)))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ScanDeviceLogic", "invalid device id(mac=%s)", new Object[] { paramjy.CEQ });
      AppMethodBeat.o(23433);
      return;
    }
    if ((bt.isNullOrNil(paramjy.CEX.CBS)) || (!paramjy.CEX.CBS.equals(this.oUW)))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ScanDeviceLogic", "device type (%s) is not equal to brand name (%s)", new Object[] { paramjy.mAU, this.oUW });
      AppMethodBeat.o(23433);
      return;
    }
    byte[] arrayOfByte = (byte[])this.oWq.get(paramjy.CEQ);
    String str1 = paramjy.CEQ;
    String str2 = paramjy.CEX.CBS;
    String str3 = paramjy.CEX.mAT;
    String str4 = paramjy.mAU;
    int i;
    if (arrayOfByte == null)
    {
      i = 0;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, BatchSearch find mac=%s, deviceType=%s, deviceId=%s, %s, %s", new Object[] { str1, str2, str3, str4, Integer.valueOf(i) });
      if (this.oWp == null) {
        break label323;
      }
      if (arrayOfByte == null) {
        break label337;
      }
    }
    label323:
    label337:
    for (arrayOfByte = bd(arrayOfByte);; arrayOfByte = null)
    {
      this.oWp.a(paramjy.CEX.mAT, arrayOfByte, false);
      AppMethodBeat.o(23433);
      return;
      i = arrayOfByte.length;
      break;
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ScanDeviceLogic", "mCallback null");
      AppMethodBeat.o(23433);
      return;
    }
  }
  
  public static aa bZD()
  {
    AppMethodBeat.i(23428);
    if (oWo != null)
    {
      localaa = oWo;
      AppMethodBeat.o(23428);
      return localaa;
    }
    aa localaa = new aa();
    oWo = localaa;
    AppMethodBeat.o(23428);
    return localaa;
  }
  
  private static byte[] bd(byte[] paramArrayOfByte)
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
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, Manufacturer Specific Data size = %s", new Object[] { Integer.valueOf(k) });
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
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, Manufacturer Specific Data %s" + b.be(arrayOfByte));
            continue;
            AppMethodBeat.o(23434);
            return arrayOfByte;
          }
          break;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.exdevice.ScanDeviceLogic", paramArrayOfByte, "", new Object[0]);
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ScanDeviceLogic", "EX in parseBroadcastPacket %s", new Object[] { paramArrayOfByte.getMessage() });
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
  
  public final void Ba(int paramInt)
  {
    AppMethodBeat.i(23430);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ScanDeviceLogic", "stopScanDevice %s, stopTimer", new Object[] { Integer.valueOf(paramInt) });
    this.irp.stopTimer();
    if (this.oVC)
    {
      ad.bZN().AZ(paramInt);
      this.oVC = false;
      this.oUW = null;
      this.oWq.clear();
      az.aeS().b(542, this);
      ??? = this.oWr.iterator();
      while (((Iterator)???).hasNext())
      {
        n localn = (n)((Iterator)???).next();
        if (localn != null) {
          az.aeS().a(localn);
        }
      }
      this.oWr.clear();
      if (this.oWp != null) {
        this.oWp.a(null, null, true);
      }
      this.oWp = null;
    }
    synchronized (cTX)
    {
      oWs.clear();
      AppMethodBeat.o(23430);
      return;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ScanDeviceLogic", "stopScanDevice has been stoped");
    }
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String arg5, int paramInt3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23431);
    if (this.oWq.containsKey(paramString2))
    {
      AppMethodBeat.o(23431);
      return;
    }
    if (paramString2 == null)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.exdevice.ScanDeviceLogic", "deviceMac is null");
      AppMethodBeat.o(23431);
      return;
    }
    paramString1 = paramString2.replaceAll(":", "");
    ??? = oWn;
    if ((bt.cw(paramArrayOfByte)) || (bt.cw(???)) || (???.length > paramArrayOfByte.length)) {
      paramInt1 = -1;
    }
    for (;;)
    {
      if (paramInt1 != -1) {
        if (paramInt1 + 9 <= paramArrayOfByte.length)
        {
          ??? = new byte[paramInt1 + 9];
          System.arraycopy(paramArrayOfByte, 0, ???, 0, ???.length);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, scanFound mac:%s, realAd:%s", new Object[] { paramString1, b.be(???) });
          this.oWq.put(paramString1, ???);
          label158:
          paramString1 = this.oUW + "_" + paramString2;
          if (oWt.containsKey(paramString1)) {
            break label394;
          }
        }
      }
      synchronized (cTX)
      {
        if (oWs.contains(paramString1))
        {
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.exdevice.ScanDeviceLogic", "hakon, already doing");
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
          this.oWq.put(paramString1, null);
          break label158;
          this.oWq.put(paramString1, null);
          break label158;
        }
        else
        {
          oWs.add(paramString1);
          ??? = this.oUW;
          paramString2 = new k(new String[] { paramString2 }, ???);
          if (az.aeS().a(paramString2, 0))
          {
            this.oWr.add(paramString2);
            AppMethodBeat.o(23431);
            return;
          }
        }
      }
    }
    oWs.remove(paramString1);
    com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ScanDeviceLogic", "MMCore.getNetSceneQueue().doScene failed!!!");
    AppMethodBeat.o(23431);
    return;
    label394:
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.exdevice.ScanDeviceLogic", "hakon, hit cache %s, %s", new Object[] { this.oUW, paramString2 });
    a((jy)oWt.get(paramString1));
    AppMethodBeat.o(23431);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String arg3, n paramn)
  {
    AppMethodBeat.i(23432);
    if (paramn == null) {}
    for (Object localObject = "";; localObject = Integer.valueOf(paramn.getType()))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ScanDeviceLogic", "onSceneEnd, %s, errType=%d, errCode=%d, errMsg=%s", new Object[] { localObject, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), ??? });
      this.oWr.remove(paramn);
      if ((paramInt1 == 0) && (paramInt2 == 0) && (paramn != null)) {
        break;
      }
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ScanDeviceLogic", "do scene failed!!!");
      AppMethodBeat.o(23432);
      return;
    }
    if (542 == paramn.getType())
    {
      paramn = ((k)paramn).bZy().CEU.iterator();
      while (paramn.hasNext())
      {
        localObject = (jy)paramn.next();
        if (bt.isNullOrNil(((jy)localObject).CEQ))
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ScanDeviceLogic", "invalid mac(null or nil)");
        }
        else
        {
          String str = this.oUW + "_" + ((jy)localObject).CEQ;
          synchronized (cTX)
          {
            if (oWs.contains(str)) {
              oWs.remove(str);
            }
            if (!oWt.containsKey(str))
            {
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, put into cache, %s", new Object[] { str });
              oWt.put(str, localObject);
            }
            a((jy)localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.aa
 * JD-Core Version:    0.7.0.1
 */