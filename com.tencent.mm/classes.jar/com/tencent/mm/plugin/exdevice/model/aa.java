package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.service.j.a;
import com.tencent.mm.protocal.protobuf.auh;
import com.tencent.mm.protocal.protobuf.iu;
import com.tencent.mm.protocal.protobuf.iv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class aa
  extends j.a
  implements f
{
  static Object ceY;
  private static final byte[] lFC;
  private static aa lFD;
  static LinkedList<String> lFH;
  private static HashMap<String, iv> lFI;
  final ap gIs;
  boolean lEQ;
  volatile String lEk;
  aa.a lFE;
  HashMap<String, byte[]> lFF;
  LinkedList<m> lFG;
  
  static
  {
    AppMethodBeat.i(19366);
    lFC = new byte[] { -2, 1, 1 };
    ceY = new Object();
    lFH = new LinkedList();
    lFI = new HashMap(32);
    AppMethodBeat.o(19366);
  }
  
  private aa()
  {
    AppMethodBeat.i(19360);
    this.lFF = new HashMap();
    this.lFG = new LinkedList();
    this.gIs = new ap(new aa.1(this), true);
    this.lEQ = false;
    AppMethodBeat.o(19360);
  }
  
  private void a(iv paramiv)
  {
    AppMethodBeat.i(19364);
    if (paramiv == null)
    {
      ab.e("MicroMsg.exdevice.ScanDeviceLogic", "item null..");
      AppMethodBeat.o(19364);
      return;
    }
    if (bo.isNullOrNil(paramiv.wuT))
    {
      ab.e("MicroMsg.exdevice.ScanDeviceLogic", "invalid mac(null or nil)");
      AppMethodBeat.o(19364);
      return;
    }
    if (paramiv.Ret != 0)
    {
      ab.e("MicroMsg.exdevice.ScanDeviceLogic", "device(%s) is invalid", new Object[] { paramiv.wuT });
      AppMethodBeat.o(19364);
      return;
    }
    if ((paramiv.wva == null) || (bo.isNullOrNil(paramiv.wva.jJD)))
    {
      ab.e("MicroMsg.exdevice.ScanDeviceLogic", "invalid device id(mac=%s)", new Object[] { paramiv.wuT });
      AppMethodBeat.o(19364);
      return;
    }
    if ((bo.isNullOrNil(paramiv.wva.wsq)) || (!paramiv.wva.wsq.equals(this.lEk)))
    {
      ab.e("MicroMsg.exdevice.ScanDeviceLogic", "device type (%s) is not equal to brand name (%s)", new Object[] { paramiv.jJE, this.lEk });
      AppMethodBeat.o(19364);
      return;
    }
    byte[] arrayOfByte = (byte[])this.lFF.get(paramiv.wuT);
    String str1 = paramiv.wuT;
    String str2 = paramiv.wva.wsq;
    String str3 = paramiv.wva.jJD;
    String str4 = paramiv.jJE;
    int i;
    if (arrayOfByte == null)
    {
      i = 0;
      ab.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, BatchSearch find mac=%s, deviceType=%s, deviceId=%s, %s, %s", new Object[] { str1, str2, str3, str4, Integer.valueOf(i) });
      if (this.lFE == null) {
        break label323;
      }
      if (arrayOfByte == null) {
        break label337;
      }
    }
    label323:
    label337:
    for (arrayOfByte = aN(arrayOfByte);; arrayOfByte = null)
    {
      this.lFE.a(paramiv.wva.jJD, arrayOfByte, false);
      AppMethodBeat.o(19364);
      return;
      i = arrayOfByte.length;
      break;
      ab.e("MicroMsg.exdevice.ScanDeviceLogic", "mCallback null");
      AppMethodBeat.o(19364);
      return;
    }
  }
  
  private static byte[] aN(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(19365);
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
          ab.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, Manufacturer Specific Data size = %s", new Object[] { Integer.valueOf(k) });
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
            ab.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, Manufacturer Specific Data %s" + b.aO(arrayOfByte));
            continue;
            AppMethodBeat.o(19365);
            return arrayOfByte;
          }
          break;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        ab.printErrStackTrace("MicroMsg.exdevice.ScanDeviceLogic", paramArrayOfByte, "", new Object[0]);
        ab.e("MicroMsg.exdevice.ScanDeviceLogic", "EX in parseBroadcastPacket %s", new Object[] { paramArrayOfByte.getMessage() });
        AppMethodBeat.o(19365);
        return null;
      }
      break label217;
      i += k - 1;
      continue;
      label217:
      k -= 1;
    }
  }
  
  public static aa bpV()
  {
    AppMethodBeat.i(19359);
    if (lFD != null)
    {
      localaa = lFD;
      AppMethodBeat.o(19359);
      return localaa;
    }
    aa localaa = new aa();
    lFD = localaa;
    AppMethodBeat.o(19359);
    return localaa;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String arg5, int paramInt3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(19362);
    if (this.lFF.containsKey(paramString2))
    {
      AppMethodBeat.o(19362);
      return;
    }
    if (paramString2 == null)
    {
      ab.w("MicroMsg.exdevice.ScanDeviceLogic", "deviceMac is null");
      AppMethodBeat.o(19362);
      return;
    }
    paramString1 = paramString2.replaceAll(":", "");
    ??? = lFC;
    if ((bo.ce(paramArrayOfByte)) || (bo.ce(???)) || (???.length > paramArrayOfByte.length)) {
      paramInt1 = -1;
    }
    for (;;)
    {
      if (paramInt1 != -1) {
        if (paramInt1 + 9 <= paramArrayOfByte.length)
        {
          ??? = new byte[paramInt1 + 9];
          System.arraycopy(paramArrayOfByte, 0, ???, 0, ???.length);
          ab.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, scanFound mac:%s, realAd:%s", new Object[] { paramString1, b.aO(???) });
          this.lFF.put(paramString1, ???);
          label155:
          paramString1 = this.lEk + "_" + paramString2;
          if (lFI.containsKey(paramString1)) {
            break label389;
          }
        }
      }
      synchronized (ceY)
      {
        if (lFH.contains(paramString1))
        {
          ab.d("MicroMsg.exdevice.ScanDeviceLogic", "hakon, already doing");
          AppMethodBeat.o(19362);
          return;
          paramInt2 = 0;
          for (;;)
          {
            if (paramInt2 >= paramArrayOfByte.length) {
              break label257;
            }
            paramInt1 = paramInt2;
            if (b.c(paramArrayOfByte, paramInt2, ???)) {
              break;
            }
            paramInt2 += 1;
          }
          label257:
          paramInt1 = -1;
          continue;
          this.lFF.put(paramString1, null);
          break label155;
          this.lFF.put(paramString1, null);
          break label155;
        }
        else
        {
          lFH.add(paramString1);
          ??? = this.lEk;
          paramString2 = new k(new String[] { paramString2 }, ???);
          if (aw.Rc().a(paramString2, 0))
          {
            this.lFG.add(paramString2);
            AppMethodBeat.o(19362);
            return;
          }
        }
      }
    }
    lFH.remove(paramString1);
    ab.e("MicroMsg.exdevice.ScanDeviceLogic", "MMCore.getNetSceneQueue().doScene failed!!!");
    AppMethodBeat.o(19362);
    return;
    label389:
    ab.d("MicroMsg.exdevice.ScanDeviceLogic", "hakon, hit cache %s, %s", new Object[] { this.lEk, paramString2 });
    a((iv)lFI.get(paramString1));
    AppMethodBeat.o(19362);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String arg3, m paramm)
  {
    AppMethodBeat.i(19363);
    if (paramm == null) {}
    for (Object localObject = "";; localObject = Integer.valueOf(paramm.getType()))
    {
      ab.i("MicroMsg.exdevice.ScanDeviceLogic", "onSceneEnd, %s, errType=%d, errCode=%d, errMsg=%s", new Object[] { localObject, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), ??? });
      this.lFG.remove(paramm);
      if ((paramInt1 == 0) && (paramInt2 == 0) && (paramm != null)) {
        break;
      }
      ab.e("MicroMsg.exdevice.ScanDeviceLogic", "do scene failed!!!");
      AppMethodBeat.o(19363);
      return;
    }
    if (542 == paramm.getType())
    {
      paramm = ((k)paramm).bpQ().wuX.iterator();
      while (paramm.hasNext())
      {
        localObject = (iv)paramm.next();
        if (bo.isNullOrNil(((iv)localObject).wuT))
        {
          ab.e("MicroMsg.exdevice.ScanDeviceLogic", "invalid mac(null or nil)");
        }
        else
        {
          String str = this.lEk + "_" + ((iv)localObject).wuT;
          synchronized (ceY)
          {
            if (lFH.contains(str)) {
              lFH.remove(str);
            }
            if (!lFI.containsKey(str))
            {
              ab.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, put into cache, %s", new Object[] { str });
              lFI.put(str, localObject);
            }
            a((iv)localObject);
          }
        }
      }
    }
    AppMethodBeat.o(19363);
  }
  
  public final void uW(int paramInt)
  {
    AppMethodBeat.i(19361);
    ab.i("MicroMsg.exdevice.ScanDeviceLogic", "stopScanDevice %s, stopTimer", new Object[] { Integer.valueOf(paramInt) });
    this.gIs.stopTimer();
    if (this.lEQ)
    {
      ad.bqf().uV(paramInt);
      this.lEQ = false;
      this.lEk = null;
      this.lFF.clear();
      aw.Rc().b(542, this);
      ??? = this.lFG.iterator();
      while (((Iterator)???).hasNext())
      {
        m localm = (m)((Iterator)???).next();
        if (localm != null) {
          aw.Rc().a(localm);
        }
      }
      this.lFG.clear();
      if (this.lFE != null) {
        this.lFE.a(null, null, true);
      }
      this.lFE = null;
    }
    synchronized (ceY)
    {
      lFH.clear();
      AppMethodBeat.o(19361);
      return;
      ab.i("MicroMsg.exdevice.ScanDeviceLogic", "stopScanDevice has been stoped");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.aa
 * JD-Core Version:    0.7.0.1
 */