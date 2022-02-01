package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.plugin.exdevice.service.j.a;
import com.tencent.mm.protocal.protobuf.ciu;
import com.tencent.mm.protocal.protobuf.kt;
import com.tencent.mm.protocal.protobuf.ku;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class ab
  extends j.a
  implements i
{
  static Object fnq;
  private static final byte[] vgk;
  private static ab vgl;
  static LinkedList<String> vgp;
  private static HashMap<String, ku> vgq;
  final MTimerHandler ndv;
  volatile String veU;
  boolean vfA;
  a vgm;
  HashMap<String, byte[]> vgn;
  LinkedList<q> vgo;
  
  static
  {
    AppMethodBeat.i(23435);
    vgk = new byte[] { -2, 1, 1 };
    fnq = new Object();
    vgp = new LinkedList();
    vgq = new HashMap(32);
    AppMethodBeat.o(23435);
  }
  
  private ab()
  {
    AppMethodBeat.i(23429);
    this.vgn = new HashMap();
    this.vgo = new LinkedList();
    this.ndv = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(23427);
        Log.i("MicroMsg.exdevice.ScanDeviceLogic", "Restart scanning...");
        ae.cZF().a(0, ab.this);
        AppMethodBeat.o(23427);
        return true;
      }
    }, true);
    this.vfA = false;
    AppMethodBeat.o(23429);
  }
  
  private void a(ku paramku)
  {
    AppMethodBeat.i(23433);
    if (paramku == null)
    {
      Log.e("MicroMsg.exdevice.ScanDeviceLogic", "item null..");
      AppMethodBeat.o(23433);
      return;
    }
    if (Util.isNullOrNil(paramku.RPQ))
    {
      Log.e("MicroMsg.exdevice.ScanDeviceLogic", "invalid mac(null or nil)");
      AppMethodBeat.o(23433);
      return;
    }
    if (paramku.CqV != 0)
    {
      Log.e("MicroMsg.exdevice.ScanDeviceLogic", "device(%s) is invalid", new Object[] { paramku.RPQ });
      AppMethodBeat.o(23433);
      return;
    }
    if ((paramku.RPX == null) || (Util.isNullOrNil(paramku.RPX.rVF)))
    {
      Log.e("MicroMsg.exdevice.ScanDeviceLogic", "invalid device id(mac=%s)", new Object[] { paramku.RPQ });
      AppMethodBeat.o(23433);
      return;
    }
    if ((Util.isNullOrNil(paramku.RPX.RMK)) || (!paramku.RPX.RMK.equals(this.veU)))
    {
      Log.e("MicroMsg.exdevice.ScanDeviceLogic", "device type (%s) is not equal to brand name (%s)", new Object[] { paramku.rVG, this.veU });
      AppMethodBeat.o(23433);
      return;
    }
    byte[] arrayOfByte = (byte[])this.vgn.get(paramku.RPQ);
    String str1 = paramku.RPQ;
    String str2 = paramku.RPX.RMK;
    String str3 = paramku.RPX.rVF;
    String str4 = paramku.rVG;
    int i;
    if (arrayOfByte == null)
    {
      i = 0;
      Log.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, BatchSearch find mac=%s, deviceType=%s, deviceId=%s, %s, %s", new Object[] { str1, str2, str3, str4, Integer.valueOf(i) });
      if (this.vgm == null) {
        break label323;
      }
      if (arrayOfByte == null) {
        break label337;
      }
    }
    label323:
    label337:
    for (arrayOfByte = bJ(arrayOfByte);; arrayOfByte = null)
    {
      this.vgm.a(paramku.RPX.rVF, arrayOfByte, false);
      AppMethodBeat.o(23433);
      return;
      i = arrayOfByte.length;
      break;
      Log.e("MicroMsg.exdevice.ScanDeviceLogic", "mCallback null");
      AppMethodBeat.o(23433);
      return;
    }
  }
  
  private static byte[] bJ(byte[] paramArrayOfByte)
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
            Log.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, Manufacturer Specific Data %s" + b.bK(arrayOfByte));
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
  
  public static ab cZu()
  {
    AppMethodBeat.i(23428);
    if (vgl != null)
    {
      localab = vgl;
      AppMethodBeat.o(23428);
      return localab;
    }
    ab localab = new ab();
    vgl = localab;
    AppMethodBeat.o(23428);
    return localab;
  }
  
  public final void Kf(int paramInt)
  {
    AppMethodBeat.i(23430);
    Log.i("MicroMsg.exdevice.ScanDeviceLogic", "stopScanDevice %s, stopTimer", new Object[] { Integer.valueOf(paramInt) });
    this.ndv.stopTimer();
    if (this.vfA)
    {
      ae.cZF().Ke(paramInt);
      this.vfA = false;
      this.veU = null;
      this.vgn.clear();
      bh.aGY().b(542, this);
      ??? = this.vgo.iterator();
      while (((Iterator)???).hasNext())
      {
        q localq = (q)((Iterator)???).next();
        if (localq != null) {
          bh.aGY().a(localq);
        }
      }
      this.vgo.clear();
      if (this.vgm != null) {
        this.vgm.a(null, null, true);
      }
      this.vgm = null;
    }
    synchronized (fnq)
    {
      vgp.clear();
      AppMethodBeat.o(23430);
      return;
      Log.i("MicroMsg.exdevice.ScanDeviceLogic", "stopScanDevice has been stoped");
    }
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String arg5, int paramInt3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23431);
    if (this.vgn.containsKey(paramString2))
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
    ??? = vgk;
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
          Log.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, scanFound mac:%s, realAd:%s", new Object[] { paramString1, b.bK(???) });
          this.vgn.put(paramString1, ???);
          label158:
          paramString1 = this.veU + "_" + paramString2;
          if (vgq.containsKey(paramString1)) {
            break label394;
          }
        }
      }
      synchronized (fnq)
      {
        if (vgp.contains(paramString1))
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
          this.vgn.put(paramString1, null);
          break label158;
          this.vgn.put(paramString1, null);
          break label158;
        }
        else
        {
          vgp.add(paramString1);
          ??? = this.veU;
          paramString2 = new k(new String[] { paramString2 }, ???);
          if (bh.aGY().a(paramString2, 0))
          {
            this.vgo.add(paramString2);
            AppMethodBeat.o(23431);
            return;
          }
        }
      }
    }
    vgp.remove(paramString1);
    Log.e("MicroMsg.exdevice.ScanDeviceLogic", "MMCore.getNetSceneQueue().doScene failed!!!");
    AppMethodBeat.o(23431);
    return;
    label394:
    Log.d("MicroMsg.exdevice.ScanDeviceLogic", "hakon, hit cache %s, %s", new Object[] { this.veU, paramString2 });
    a((ku)vgq.get(paramString1));
    AppMethodBeat.o(23431);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String arg3, q paramq)
  {
    AppMethodBeat.i(23432);
    if (paramq == null) {}
    for (Object localObject = "";; localObject = Integer.valueOf(paramq.getType()))
    {
      Log.i("MicroMsg.exdevice.ScanDeviceLogic", "onSceneEnd, %s, errType=%d, errCode=%d, errMsg=%s", new Object[] { localObject, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), ??? });
      this.vgo.remove(paramq);
      if ((paramInt1 == 0) && (paramInt2 == 0) && (paramq != null)) {
        break;
      }
      Log.e("MicroMsg.exdevice.ScanDeviceLogic", "do scene failed!!!");
      AppMethodBeat.o(23432);
      return;
    }
    if (542 == paramq.getType())
    {
      paramq = ((k)paramq).cZp().RPU.iterator();
      while (paramq.hasNext())
      {
        localObject = (ku)paramq.next();
        if (Util.isNullOrNil(((ku)localObject).RPQ))
        {
          Log.e("MicroMsg.exdevice.ScanDeviceLogic", "invalid mac(null or nil)");
        }
        else
        {
          String str = this.veU + "_" + ((ku)localObject).RPQ;
          synchronized (fnq)
          {
            if (vgp.contains(str)) {
              vgp.remove(str);
            }
            if (!vgq.containsKey(str))
            {
              Log.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, put into cache, %s", new Object[] { str });
              vgq.put(str, localObject);
            }
            a((ku)localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ab
 * JD-Core Version:    0.7.0.1
 */