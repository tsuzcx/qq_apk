package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.plugin.exdevice.service.j.a;
import com.tencent.mm.protocal.protobuf.bob;
import com.tencent.mm.protocal.protobuf.km;
import com.tencent.mm.protocal.protobuf.kn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class aa
  extends j.a
  implements f
{
  static Object ddM;
  private static final byte[] qjI;
  private static aa qjJ;
  static LinkedList<String> qjN;
  private static HashMap<String, kn> qjO;
  final aw jnx;
  boolean qiX;
  volatile String qir;
  a qjK;
  HashMap<String, byte[]> qjL;
  LinkedList<n> qjM;
  
  static
  {
    AppMethodBeat.i(23435);
    qjI = new byte[] { -2, 1, 1 };
    ddM = new Object();
    qjN = new LinkedList();
    qjO = new HashMap(32);
    AppMethodBeat.o(23435);
  }
  
  private aa()
  {
    AppMethodBeat.i(23429);
    this.qjL = new HashMap();
    this.qjM = new LinkedList();
    this.jnx = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(23427);
        ae.i("MicroMsg.exdevice.ScanDeviceLogic", "Restart scanning...");
        ad.cmQ().a(0, aa.this);
        AppMethodBeat.o(23427);
        return true;
      }
    }, true);
    this.qiX = false;
    AppMethodBeat.o(23429);
  }
  
  private void a(kn paramkn)
  {
    AppMethodBeat.i(23433);
    if (paramkn == null)
    {
      ae.e("MicroMsg.exdevice.ScanDeviceLogic", "item null..");
      AppMethodBeat.o(23433);
      return;
    }
    if (bu.isNullOrNil(paramkn.FVh))
    {
      ae.e("MicroMsg.exdevice.ScanDeviceLogic", "invalid mac(null or nil)");
      AppMethodBeat.o(23433);
      return;
    }
    if (paramkn.Ret != 0)
    {
      ae.e("MicroMsg.exdevice.ScanDeviceLogic", "device(%s) is invalid", new Object[] { paramkn.FVh });
      AppMethodBeat.o(23433);
      return;
    }
    if ((paramkn.FVo == null) || (bu.isNullOrNil(paramkn.FVo.nIM)))
    {
      ae.e("MicroMsg.exdevice.ScanDeviceLogic", "invalid device id(mac=%s)", new Object[] { paramkn.FVh });
      AppMethodBeat.o(23433);
      return;
    }
    if ((bu.isNullOrNil(paramkn.FVo.FSh)) || (!paramkn.FVo.FSh.equals(this.qir)))
    {
      ae.e("MicroMsg.exdevice.ScanDeviceLogic", "device type (%s) is not equal to brand name (%s)", new Object[] { paramkn.nIN, this.qir });
      AppMethodBeat.o(23433);
      return;
    }
    byte[] arrayOfByte = (byte[])this.qjL.get(paramkn.FVh);
    String str1 = paramkn.FVh;
    String str2 = paramkn.FVo.FSh;
    String str3 = paramkn.FVo.nIM;
    String str4 = paramkn.nIN;
    int i;
    if (arrayOfByte == null)
    {
      i = 0;
      ae.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, BatchSearch find mac=%s, deviceType=%s, deviceId=%s, %s, %s", new Object[] { str1, str2, str3, str4, Integer.valueOf(i) });
      if (this.qjK == null) {
        break label323;
      }
      if (arrayOfByte == null) {
        break label337;
      }
    }
    label323:
    label337:
    for (arrayOfByte = be(arrayOfByte);; arrayOfByte = null)
    {
      this.qjK.a(paramkn.FVo.nIM, arrayOfByte, false);
      AppMethodBeat.o(23433);
      return;
      i = arrayOfByte.length;
      break;
      ae.e("MicroMsg.exdevice.ScanDeviceLogic", "mCallback null");
      AppMethodBeat.o(23433);
      return;
    }
  }
  
  private static byte[] be(byte[] paramArrayOfByte)
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
          ae.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, Manufacturer Specific Data size = %s", new Object[] { Integer.valueOf(k) });
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
            ae.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, Manufacturer Specific Data %s" + b.bf(arrayOfByte));
            continue;
            AppMethodBeat.o(23434);
            return arrayOfByte;
          }
          break;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        ae.printErrStackTrace("MicroMsg.exdevice.ScanDeviceLogic", paramArrayOfByte, "", new Object[0]);
        ae.e("MicroMsg.exdevice.ScanDeviceLogic", "EX in parseBroadcastPacket %s", new Object[] { paramArrayOfByte.getMessage() });
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
  
  public static aa cmG()
  {
    AppMethodBeat.i(23428);
    if (qjJ != null)
    {
      localaa = qjJ;
      AppMethodBeat.o(23428);
      return localaa;
    }
    aa localaa = new aa();
    qjJ = localaa;
    AppMethodBeat.o(23428);
    return localaa;
  }
  
  public final void CN(int paramInt)
  {
    AppMethodBeat.i(23430);
    ae.i("MicroMsg.exdevice.ScanDeviceLogic", "stopScanDevice %s, stopTimer", new Object[] { Integer.valueOf(paramInt) });
    this.jnx.stopTimer();
    if (this.qiX)
    {
      ad.cmQ().CM(paramInt);
      this.qiX = false;
      this.qir = null;
      this.qjL.clear();
      bc.ajj().b(542, this);
      ??? = this.qjM.iterator();
      while (((Iterator)???).hasNext())
      {
        n localn = (n)((Iterator)???).next();
        if (localn != null) {
          bc.ajj().a(localn);
        }
      }
      this.qjM.clear();
      if (this.qjK != null) {
        this.qjK.a(null, null, true);
      }
      this.qjK = null;
    }
    synchronized (ddM)
    {
      qjN.clear();
      AppMethodBeat.o(23430);
      return;
      ae.i("MicroMsg.exdevice.ScanDeviceLogic", "stopScanDevice has been stoped");
    }
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String arg5, int paramInt3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23431);
    if (this.qjL.containsKey(paramString2))
    {
      AppMethodBeat.o(23431);
      return;
    }
    if (paramString2 == null)
    {
      ae.w("MicroMsg.exdevice.ScanDeviceLogic", "deviceMac is null");
      AppMethodBeat.o(23431);
      return;
    }
    paramString1 = paramString2.replaceAll(":", "");
    ??? = qjI;
    if ((bu.cF(paramArrayOfByte)) || (bu.cF(???)) || (???.length > paramArrayOfByte.length)) {
      paramInt1 = -1;
    }
    for (;;)
    {
      if (paramInt1 != -1) {
        if (paramInt1 + 9 <= paramArrayOfByte.length)
        {
          ??? = new byte[paramInt1 + 9];
          System.arraycopy(paramArrayOfByte, 0, ???, 0, ???.length);
          ae.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, scanFound mac:%s, realAd:%s", new Object[] { paramString1, b.bf(???) });
          this.qjL.put(paramString1, ???);
          label158:
          paramString1 = this.qir + "_" + paramString2;
          if (qjO.containsKey(paramString1)) {
            break label394;
          }
        }
      }
      synchronized (ddM)
      {
        if (qjN.contains(paramString1))
        {
          ae.d("MicroMsg.exdevice.ScanDeviceLogic", "hakon, already doing");
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
          this.qjL.put(paramString1, null);
          break label158;
          this.qjL.put(paramString1, null);
          break label158;
        }
        else
        {
          qjN.add(paramString1);
          ??? = this.qir;
          paramString2 = new k(new String[] { paramString2 }, ???);
          if (bc.ajj().a(paramString2, 0))
          {
            this.qjM.add(paramString2);
            AppMethodBeat.o(23431);
            return;
          }
        }
      }
    }
    qjN.remove(paramString1);
    ae.e("MicroMsg.exdevice.ScanDeviceLogic", "MMCore.getNetSceneQueue().doScene failed!!!");
    AppMethodBeat.o(23431);
    return;
    label394:
    ae.d("MicroMsg.exdevice.ScanDeviceLogic", "hakon, hit cache %s, %s", new Object[] { this.qir, paramString2 });
    a((kn)qjO.get(paramString1));
    AppMethodBeat.o(23431);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String arg3, n paramn)
  {
    AppMethodBeat.i(23432);
    if (paramn == null) {}
    for (Object localObject = "";; localObject = Integer.valueOf(paramn.getType()))
    {
      ae.i("MicroMsg.exdevice.ScanDeviceLogic", "onSceneEnd, %s, errType=%d, errCode=%d, errMsg=%s", new Object[] { localObject, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), ??? });
      this.qjM.remove(paramn);
      if ((paramInt1 == 0) && (paramInt2 == 0) && (paramn != null)) {
        break;
      }
      ae.e("MicroMsg.exdevice.ScanDeviceLogic", "do scene failed!!!");
      AppMethodBeat.o(23432);
      return;
    }
    if (542 == paramn.getType())
    {
      paramn = ((k)paramn).cmB().FVl.iterator();
      while (paramn.hasNext())
      {
        localObject = (kn)paramn.next();
        if (bu.isNullOrNil(((kn)localObject).FVh))
        {
          ae.e("MicroMsg.exdevice.ScanDeviceLogic", "invalid mac(null or nil)");
        }
        else
        {
          String str = this.qir + "_" + ((kn)localObject).FVh;
          synchronized (ddM)
          {
            if (qjN.contains(str)) {
              qjN.remove(str);
            }
            if (!qjO.containsKey(str))
            {
              ae.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, put into cache, %s", new Object[] { str });
              qjO.put(str, localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.aa
 * JD-Core Version:    0.7.0.1
 */