package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.plugin.exdevice.service.j.a;
import com.tencent.mm.protocal.protobuf.bnj;
import com.tencent.mm.protocal.protobuf.km;
import com.tencent.mm.protocal.protobuf.kn;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class aa
  extends j.a
  implements f
{
  static Object dcK;
  private static final byte[] qdd;
  private static aa qde;
  static LinkedList<String> qdi;
  private static HashMap<String, kn> qdj;
  final av jkD;
  volatile String qbM;
  boolean qcs;
  a qdf;
  HashMap<String, byte[]> qdg;
  LinkedList<n> qdh;
  
  static
  {
    AppMethodBeat.i(23435);
    qdd = new byte[] { -2, 1, 1 };
    dcK = new Object();
    qdi = new LinkedList();
    qdj = new HashMap(32);
    AppMethodBeat.o(23435);
  }
  
  private aa()
  {
    AppMethodBeat.i(23429);
    this.qdg = new HashMap();
    this.qdh = new LinkedList();
    this.jkD = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(23427);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ScanDeviceLogic", "Restart scanning...");
        ad.clA().a(0, aa.this);
        AppMethodBeat.o(23427);
        return true;
      }
    }, true);
    this.qcs = false;
    AppMethodBeat.o(23429);
  }
  
  private void a(kn paramkn)
  {
    AppMethodBeat.i(23433);
    if (paramkn == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ScanDeviceLogic", "item null..");
      AppMethodBeat.o(23433);
      return;
    }
    if (bt.isNullOrNil(paramkn.FCM))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ScanDeviceLogic", "invalid mac(null or nil)");
      AppMethodBeat.o(23433);
      return;
    }
    if (paramkn.Ret != 0)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ScanDeviceLogic", "device(%s) is invalid", new Object[] { paramkn.FCM });
      AppMethodBeat.o(23433);
      return;
    }
    if ((paramkn.FCT == null) || (bt.isNullOrNil(paramkn.FCT.nDr)))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ScanDeviceLogic", "invalid device id(mac=%s)", new Object[] { paramkn.FCM });
      AppMethodBeat.o(23433);
      return;
    }
    if ((bt.isNullOrNil(paramkn.FCT.FzJ)) || (!paramkn.FCT.FzJ.equals(this.qbM)))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ScanDeviceLogic", "device type (%s) is not equal to brand name (%s)", new Object[] { paramkn.nDs, this.qbM });
      AppMethodBeat.o(23433);
      return;
    }
    byte[] arrayOfByte = (byte[])this.qdg.get(paramkn.FCM);
    String str1 = paramkn.FCM;
    String str2 = paramkn.FCT.FzJ;
    String str3 = paramkn.FCT.nDr;
    String str4 = paramkn.nDs;
    int i;
    if (arrayOfByte == null)
    {
      i = 0;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, BatchSearch find mac=%s, deviceType=%s, deviceId=%s, %s, %s", new Object[] { str1, str2, str3, str4, Integer.valueOf(i) });
      if (this.qdf == null) {
        break label323;
      }
      if (arrayOfByte == null) {
        break label337;
      }
    }
    label323:
    label337:
    for (arrayOfByte = bf(arrayOfByte);; arrayOfByte = null)
    {
      this.qdf.a(paramkn.FCT.nDr, arrayOfByte, false);
      AppMethodBeat.o(23433);
      return;
      i = arrayOfByte.length;
      break;
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ScanDeviceLogic", "mCallback null");
      AppMethodBeat.o(23433);
      return;
    }
  }
  
  private static byte[] bf(byte[] paramArrayOfByte)
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
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, Manufacturer Specific Data %s" + b.bg(arrayOfByte));
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
  
  public static aa clq()
  {
    AppMethodBeat.i(23428);
    if (qde != null)
    {
      localaa = qde;
      AppMethodBeat.o(23428);
      return localaa;
    }
    aa localaa = new aa();
    qde = localaa;
    AppMethodBeat.o(23428);
    return localaa;
  }
  
  public final void CB(int paramInt)
  {
    AppMethodBeat.i(23430);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ScanDeviceLogic", "stopScanDevice %s, stopTimer", new Object[] { Integer.valueOf(paramInt) });
    this.jkD.stopTimer();
    if (this.qcs)
    {
      ad.clA().CA(paramInt);
      this.qcs = false;
      this.qbM = null;
      this.qdg.clear();
      ba.aiU().b(542, this);
      ??? = this.qdh.iterator();
      while (((Iterator)???).hasNext())
      {
        n localn = (n)((Iterator)???).next();
        if (localn != null) {
          ba.aiU().a(localn);
        }
      }
      this.qdh.clear();
      if (this.qdf != null) {
        this.qdf.a(null, null, true);
      }
      this.qdf = null;
    }
    synchronized (dcK)
    {
      qdi.clear();
      AppMethodBeat.o(23430);
      return;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ScanDeviceLogic", "stopScanDevice has been stoped");
    }
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String arg5, int paramInt3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23431);
    if (this.qdg.containsKey(paramString2))
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
    ??? = qdd;
    if ((bt.cC(paramArrayOfByte)) || (bt.cC(???)) || (???.length > paramArrayOfByte.length)) {
      paramInt1 = -1;
    }
    for (;;)
    {
      if (paramInt1 != -1) {
        if (paramInt1 + 9 <= paramArrayOfByte.length)
        {
          ??? = new byte[paramInt1 + 9];
          System.arraycopy(paramArrayOfByte, 0, ???, 0, ???.length);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, scanFound mac:%s, realAd:%s", new Object[] { paramString1, b.bg(???) });
          this.qdg.put(paramString1, ???);
          label158:
          paramString1 = this.qbM + "_" + paramString2;
          if (qdj.containsKey(paramString1)) {
            break label394;
          }
        }
      }
      synchronized (dcK)
      {
        if (qdi.contains(paramString1))
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
          this.qdg.put(paramString1, null);
          break label158;
          this.qdg.put(paramString1, null);
          break label158;
        }
        else
        {
          qdi.add(paramString1);
          ??? = this.qbM;
          paramString2 = new k(new String[] { paramString2 }, ???);
          if (ba.aiU().a(paramString2, 0))
          {
            this.qdh.add(paramString2);
            AppMethodBeat.o(23431);
            return;
          }
        }
      }
    }
    qdi.remove(paramString1);
    com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ScanDeviceLogic", "MMCore.getNetSceneQueue().doScene failed!!!");
    AppMethodBeat.o(23431);
    return;
    label394:
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.exdevice.ScanDeviceLogic", "hakon, hit cache %s, %s", new Object[] { this.qbM, paramString2 });
    a((kn)qdj.get(paramString1));
    AppMethodBeat.o(23431);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String arg3, n paramn)
  {
    AppMethodBeat.i(23432);
    if (paramn == null) {}
    for (Object localObject = "";; localObject = Integer.valueOf(paramn.getType()))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ScanDeviceLogic", "onSceneEnd, %s, errType=%d, errCode=%d, errMsg=%s", new Object[] { localObject, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), ??? });
      this.qdh.remove(paramn);
      if ((paramInt1 == 0) && (paramInt2 == 0) && (paramn != null)) {
        break;
      }
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ScanDeviceLogic", "do scene failed!!!");
      AppMethodBeat.o(23432);
      return;
    }
    if (542 == paramn.getType())
    {
      paramn = ((k)paramn).cll().FCQ.iterator();
      while (paramn.hasNext())
      {
        localObject = (kn)paramn.next();
        if (bt.isNullOrNil(((kn)localObject).FCM))
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ScanDeviceLogic", "invalid mac(null or nil)");
        }
        else
        {
          String str = this.qbM + "_" + ((kn)localObject).FCM;
          synchronized (dcK)
          {
            if (qdi.contains(str)) {
              qdi.remove(str);
            }
            if (!qdj.containsKey(str))
            {
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, put into cache, %s", new Object[] { str });
              qdj.put(str, localObject);
            }
            a((kn)localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.aa
 * JD-Core Version:    0.7.0.1
 */