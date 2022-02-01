package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.plugin.exdevice.service.j.a;
import com.tencent.mm.protocal.protobuf.cat;
import com.tencent.mm.protocal.protobuf.ld;
import com.tencent.mm.protocal.protobuf.le;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class aa
  extends j.a
  implements i
{
  static Object duI;
  private static final byte[] rAD;
  private static aa rAE;
  static LinkedList<String> rAI;
  private static HashMap<String, le> rAJ;
  final MTimerHandler klF;
  a rAF;
  HashMap<String, byte[]> rAG;
  LinkedList<q> rAH;
  boolean rzT;
  volatile String rzn;
  
  static
  {
    AppMethodBeat.i(23435);
    rAD = new byte[] { -2, 1, 1 };
    duI = new Object();
    rAI = new LinkedList();
    rAJ = new HashMap(32);
    AppMethodBeat.o(23435);
  }
  
  private aa()
  {
    AppMethodBeat.i(23429);
    this.rAG = new HashMap();
    this.rAH = new LinkedList();
    this.klF = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(23427);
        Log.i("MicroMsg.exdevice.ScanDeviceLogic", "Restart scanning...");
        ad.cKS().a(0, aa.this);
        AppMethodBeat.o(23427);
        return true;
      }
    }, true);
    this.rzT = false;
    AppMethodBeat.o(23429);
  }
  
  private void a(le paramle)
  {
    AppMethodBeat.i(23433);
    if (paramle == null)
    {
      Log.e("MicroMsg.exdevice.ScanDeviceLogic", "item null..");
      AppMethodBeat.o(23433);
      return;
    }
    if (Util.isNullOrNil(paramle.KOS))
    {
      Log.e("MicroMsg.exdevice.ScanDeviceLogic", "invalid mac(null or nil)");
      AppMethodBeat.o(23433);
      return;
    }
    if (paramle.Ret != 0)
    {
      Log.e("MicroMsg.exdevice.ScanDeviceLogic", "device(%s) is invalid", new Object[] { paramle.KOS });
      AppMethodBeat.o(23433);
      return;
    }
    if ((paramle.KOZ == null) || (Util.isNullOrNil(paramle.KOZ.oTH)))
    {
      Log.e("MicroMsg.exdevice.ScanDeviceLogic", "invalid device id(mac=%s)", new Object[] { paramle.KOS });
      AppMethodBeat.o(23433);
      return;
    }
    if ((Util.isNullOrNil(paramle.KOZ.KLO)) || (!paramle.KOZ.KLO.equals(this.rzn)))
    {
      Log.e("MicroMsg.exdevice.ScanDeviceLogic", "device type (%s) is not equal to brand name (%s)", new Object[] { paramle.oTI, this.rzn });
      AppMethodBeat.o(23433);
      return;
    }
    byte[] arrayOfByte = (byte[])this.rAG.get(paramle.KOS);
    String str1 = paramle.KOS;
    String str2 = paramle.KOZ.KLO;
    String str3 = paramle.KOZ.oTH;
    String str4 = paramle.oTI;
    int i;
    if (arrayOfByte == null)
    {
      i = 0;
      Log.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, BatchSearch find mac=%s, deviceType=%s, deviceId=%s, %s, %s", new Object[] { str1, str2, str3, str4, Integer.valueOf(i) });
      if (this.rAF == null) {
        break label323;
      }
      if (arrayOfByte == null) {
        break label337;
      }
    }
    label323:
    label337:
    for (arrayOfByte = bv(arrayOfByte);; arrayOfByte = null)
    {
      this.rAF.a(paramle.KOZ.oTH, arrayOfByte, false);
      AppMethodBeat.o(23433);
      return;
      i = arrayOfByte.length;
      break;
      Log.e("MicroMsg.exdevice.ScanDeviceLogic", "mCallback null");
      AppMethodBeat.o(23433);
      return;
    }
  }
  
  private static byte[] bv(byte[] paramArrayOfByte)
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
          Log.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, Manufacturer Specific Data size = %s", new Object[] { Integer.valueOf(k) });
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
            Log.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, Manufacturer Specific Data %s" + b.bw(arrayOfByte));
            continue;
            AppMethodBeat.o(23434);
            return arrayOfByte;
          }
          break;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        Log.printErrStackTrace("MicroMsg.exdevice.ScanDeviceLogic", paramArrayOfByte, "", new Object[0]);
        Log.e("MicroMsg.exdevice.ScanDeviceLogic", "EX in parseBroadcastPacket %s", new Object[] { paramArrayOfByte.getMessage() });
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
  
  public static aa cKI()
  {
    AppMethodBeat.i(23428);
    if (rAE != null)
    {
      localaa = rAE;
      AppMethodBeat.o(23428);
      return localaa;
    }
    aa localaa = new aa();
    rAE = localaa;
    AppMethodBeat.o(23428);
    return localaa;
  }
  
  public final void Gy(int paramInt)
  {
    AppMethodBeat.i(23430);
    Log.i("MicroMsg.exdevice.ScanDeviceLogic", "stopScanDevice %s, stopTimer", new Object[] { Integer.valueOf(paramInt) });
    this.klF.stopTimer();
    if (this.rzT)
    {
      ad.cKS().Gx(paramInt);
      this.rzT = false;
      this.rzn = null;
      this.rAG.clear();
      bg.azz().b(542, this);
      ??? = this.rAH.iterator();
      while (((Iterator)???).hasNext())
      {
        q localq = (q)((Iterator)???).next();
        if (localq != null) {
          bg.azz().a(localq);
        }
      }
      this.rAH.clear();
      if (this.rAF != null) {
        this.rAF.a(null, null, true);
      }
      this.rAF = null;
    }
    synchronized (duI)
    {
      rAI.clear();
      AppMethodBeat.o(23430);
      return;
      Log.i("MicroMsg.exdevice.ScanDeviceLogic", "stopScanDevice has been stoped");
    }
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String arg5, int paramInt3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23431);
    if (this.rAG.containsKey(paramString2))
    {
      AppMethodBeat.o(23431);
      return;
    }
    if (paramString2 == null)
    {
      Log.w("MicroMsg.exdevice.ScanDeviceLogic", "deviceMac is null");
      AppMethodBeat.o(23431);
      return;
    }
    paramString1 = paramString2.replaceAll(":", "");
    ??? = rAD;
    if ((Util.isNullOrNil(paramArrayOfByte)) || (Util.isNullOrNil(???)) || (???.length > paramArrayOfByte.length)) {
      paramInt1 = -1;
    }
    for (;;)
    {
      if (paramInt1 != -1) {
        if (paramInt1 + 9 <= paramArrayOfByte.length)
        {
          ??? = new byte[paramInt1 + 9];
          System.arraycopy(paramArrayOfByte, 0, ???, 0, ???.length);
          Log.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, scanFound mac:%s, realAd:%s", new Object[] { paramString1, b.bw(???) });
          this.rAG.put(paramString1, ???);
          label158:
          paramString1 = this.rzn + "_" + paramString2;
          if (rAJ.containsKey(paramString1)) {
            break label394;
          }
        }
      }
      synchronized (duI)
      {
        if (rAI.contains(paramString1))
        {
          Log.d("MicroMsg.exdevice.ScanDeviceLogic", "hakon, already doing");
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
          this.rAG.put(paramString1, null);
          break label158;
          this.rAG.put(paramString1, null);
          break label158;
        }
        else
        {
          rAI.add(paramString1);
          ??? = this.rzn;
          paramString2 = new k(new String[] { paramString2 }, ???);
          if (bg.azz().a(paramString2, 0))
          {
            this.rAH.add(paramString2);
            AppMethodBeat.o(23431);
            return;
          }
        }
      }
    }
    rAI.remove(paramString1);
    Log.e("MicroMsg.exdevice.ScanDeviceLogic", "MMCore.getNetSceneQueue().doScene failed!!!");
    AppMethodBeat.o(23431);
    return;
    label394:
    Log.d("MicroMsg.exdevice.ScanDeviceLogic", "hakon, hit cache %s, %s", new Object[] { this.rzn, paramString2 });
    a((le)rAJ.get(paramString1));
    AppMethodBeat.o(23431);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String arg3, q paramq)
  {
    AppMethodBeat.i(23432);
    if (paramq == null) {}
    for (Object localObject = "";; localObject = Integer.valueOf(paramq.getType()))
    {
      Log.i("MicroMsg.exdevice.ScanDeviceLogic", "onSceneEnd, %s, errType=%d, errCode=%d, errMsg=%s", new Object[] { localObject, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), ??? });
      this.rAH.remove(paramq);
      if ((paramInt1 == 0) && (paramInt2 == 0) && (paramq != null)) {
        break;
      }
      Log.e("MicroMsg.exdevice.ScanDeviceLogic", "do scene failed!!!");
      AppMethodBeat.o(23432);
      return;
    }
    if (542 == paramq.getType())
    {
      paramq = ((k)paramq).cKD().KOW.iterator();
      while (paramq.hasNext())
      {
        localObject = (le)paramq.next();
        if (Util.isNullOrNil(((le)localObject).KOS))
        {
          Log.e("MicroMsg.exdevice.ScanDeviceLogic", "invalid mac(null or nil)");
        }
        else
        {
          String str = this.rzn + "_" + ((le)localObject).KOS;
          synchronized (duI)
          {
            if (rAI.contains(str)) {
              rAI.remove(str);
            }
            if (!rAJ.containsKey(str))
            {
              Log.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, put into cache, %s", new Object[] { str });
              rAJ.put(str, localObject);
            }
            a((le)localObject);
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