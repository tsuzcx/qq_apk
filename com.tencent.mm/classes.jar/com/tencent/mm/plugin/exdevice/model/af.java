package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.plugin.exdevice.service.j.a;
import com.tencent.mm.protocal.protobuf.cyx;
import com.tencent.mm.protocal.protobuf.lp;
import com.tencent.mm.protocal.protobuf.lq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class af
  extends j.a
  implements h
{
  static Object hrB;
  private static final byte[] ysk;
  private static af ysl;
  static LinkedList<String> ysp;
  private static HashMap<String, lq> ysq;
  final MTimerHandler qaM;
  volatile String yqR;
  boolean yrw;
  af.a ysm;
  HashMap<String, byte[]> ysn;
  LinkedList<p> yso;
  
  static
  {
    AppMethodBeat.i(23435);
    ysk = new byte[] { -2, 1, 1 };
    hrB = new Object();
    ysp = new LinkedList();
    ysq = new HashMap(32);
    AppMethodBeat.o(23435);
  }
  
  private af()
  {
    AppMethodBeat.i(23429);
    this.ysn = new HashMap();
    this.yso = new LinkedList();
    this.qaM = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(23427);
        Log.i("MicroMsg.exdevice.ScanDeviceLogic", "Restart scanning...");
        ah.dFY().a(0, af.this);
        AppMethodBeat.o(23427);
        return true;
      }
    }, true);
    this.yrw = false;
    AppMethodBeat.o(23429);
  }
  
  private void a(lq paramlq)
  {
    AppMethodBeat.i(23433);
    if (paramlq == null)
    {
      Log.e("MicroMsg.exdevice.ScanDeviceLogic", "item null..");
      AppMethodBeat.o(23433);
      return;
    }
    if (Util.isNullOrNil(paramlq.YNe))
    {
      Log.e("MicroMsg.exdevice.ScanDeviceLogic", "invalid mac(null or nil)");
      AppMethodBeat.o(23433);
      return;
    }
    if (paramlq.Idd != 0)
    {
      Log.e("MicroMsg.exdevice.ScanDeviceLogic", "device(%s) is invalid", new Object[] { paramlq.YNe });
      AppMethodBeat.o(23433);
      return;
    }
    if ((paramlq.YNl == null) || (Util.isNullOrNil(paramlq.YNl.vgV)))
    {
      Log.e("MicroMsg.exdevice.ScanDeviceLogic", "invalid device id(mac=%s)", new Object[] { paramlq.YNe });
      AppMethodBeat.o(23433);
      return;
    }
    if ((Util.isNullOrNil(paramlq.YNl.YJY)) || (!paramlq.YNl.YJY.equals(this.yqR)))
    {
      Log.e("MicroMsg.exdevice.ScanDeviceLogic", "device type (%s) is not equal to brand name (%s)", new Object[] { paramlq.vgW, this.yqR });
      AppMethodBeat.o(23433);
      return;
    }
    byte[] arrayOfByte = (byte[])this.ysn.get(paramlq.YNe);
    String str1 = paramlq.YNe;
    String str2 = paramlq.YNl.YJY;
    String str3 = paramlq.YNl.vgV;
    String str4 = paramlq.vgW;
    int i;
    if (arrayOfByte == null)
    {
      i = 0;
      Log.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, BatchSearch find mac=%s, deviceType=%s, deviceId=%s, %s, %s", new Object[] { str1, str2, str3, str4, Integer.valueOf(i) });
      if (this.ysm == null) {
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
      this.ysm.a(paramlq.YNl.vgV, arrayOfByte, false);
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
  
  public static af dFL()
  {
    AppMethodBeat.i(23428);
    if (ysl != null)
    {
      localaf = ysl;
      AppMethodBeat.o(23428);
      return localaf;
    }
    af localaf = new af();
    ysl = localaf;
    AppMethodBeat.o(23428);
    return localaf;
  }
  
  public final void Le(int paramInt)
  {
    AppMethodBeat.i(23430);
    Log.i("MicroMsg.exdevice.ScanDeviceLogic", "stopScanDevice %s, stopTimer", new Object[] { Integer.valueOf(paramInt) });
    this.qaM.stopTimer();
    if (this.yrw)
    {
      ah.dFY().Lc(paramInt);
      this.yrw = false;
      this.yqR = null;
      this.ysn.clear();
      bh.aZW().b(542, this);
      ??? = this.yso.iterator();
      while (((Iterator)???).hasNext())
      {
        p localp = (p)((Iterator)???).next();
        if (localp != null) {
          bh.aZW().a(localp);
        }
      }
      this.yso.clear();
      if (this.ysm != null) {
        this.ysm.a(null, null, true);
      }
      this.ysm = null;
    }
    synchronized (hrB)
    {
      ysp.clear();
      AppMethodBeat.o(23430);
      return;
      Log.i("MicroMsg.exdevice.ScanDeviceLogic", "stopScanDevice has been stoped");
    }
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String arg5, int paramInt3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23431);
    if (this.ysn.containsKey(paramString2))
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
    ??? = ysk;
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
          this.ysn.put(paramString1, ???);
          label158:
          paramString1 = this.yqR + "_" + paramString2;
          if (ysq.containsKey(paramString1)) {
            break label394;
          }
        }
      }
      synchronized (hrB)
      {
        if (ysp.contains(paramString1))
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
            if (b.d(paramArrayOfByte, paramInt2, ???)) {
              break;
            }
            paramInt2 += 1;
          }
          label262:
          paramInt1 = -1;
          continue;
          this.ysn.put(paramString1, null);
          break label158;
          this.ysn.put(paramString1, null);
          break label158;
        }
        else
        {
          ysp.add(paramString1);
          ??? = this.yqR;
          paramString2 = new m(new String[] { paramString2 }, ???);
          if (bh.aZW().a(paramString2, 0))
          {
            this.yso.add(paramString2);
            AppMethodBeat.o(23431);
            return;
          }
        }
      }
    }
    ysp.remove(paramString1);
    Log.e("MicroMsg.exdevice.ScanDeviceLogic", "MMCore.getNetSceneQueue().doScene failed!!!");
    AppMethodBeat.o(23431);
    return;
    label394:
    Log.d("MicroMsg.exdevice.ScanDeviceLogic", "hakon, hit cache %s, %s", new Object[] { this.yqR, paramString2 });
    a((lq)ysq.get(paramString1));
    AppMethodBeat.o(23431);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String arg3, p paramp)
  {
    AppMethodBeat.i(23432);
    if (paramp == null) {}
    for (Object localObject = "";; localObject = Integer.valueOf(paramp.getType()))
    {
      Log.i("MicroMsg.exdevice.ScanDeviceLogic", "onSceneEnd, %s, errType=%d, errCode=%d, errMsg=%s", new Object[] { localObject, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), ??? });
      this.yso.remove(paramp);
      if ((paramInt1 == 0) && (paramInt2 == 0) && (paramp != null)) {
        break;
      }
      Log.e("MicroMsg.exdevice.ScanDeviceLogic", "do scene failed!!!");
      AppMethodBeat.o(23432);
      return;
    }
    if (542 == paramp.getType())
    {
      paramp = ((m)paramp).dFG().YNi.iterator();
      while (paramp.hasNext())
      {
        localObject = (lq)paramp.next();
        if (Util.isNullOrNil(((lq)localObject).YNe))
        {
          Log.e("MicroMsg.exdevice.ScanDeviceLogic", "invalid mac(null or nil)");
        }
        else
        {
          String str = this.yqR + "_" + ((lq)localObject).YNe;
          synchronized (hrB)
          {
            if (ysp.contains(str)) {
              ysp.remove(str);
            }
            if (!ysq.containsKey(str))
            {
              Log.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, put into cache, %s", new Object[] { str });
              ysq.put(str, localObject);
            }
            a((lq)localObject);
          }
        }
      }
    }
    AppMethodBeat.o(23432);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.af
 * JD-Core Version:    0.7.0.1
 */