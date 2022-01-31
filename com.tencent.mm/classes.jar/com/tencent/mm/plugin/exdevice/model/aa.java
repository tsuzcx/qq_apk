package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.service.j.a;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.c.aop;
import com.tencent.mm.protocal.c.hd;
import com.tencent.mm.protocal.c.he;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class aa
  extends j.a
  implements f
{
  static Object bjn = new Object();
  private static final byte[] jwd = { -2, 1, 1 };
  private static aa jwe;
  static LinkedList<String> jwi = new LinkedList();
  private static HashMap<String, he> jwj = new HashMap(32);
  final am fqP = new am(new am.a()
  {
    public final boolean tC()
    {
      y.i("MicroMsg.exdevice.ScanDeviceLogic", "Restart scanning...");
      ad.aLS().a(0, aa.this);
      return true;
    }
  }, true);
  volatile String juL;
  boolean jvr = false;
  aa.a jwf;
  HashMap<String, byte[]> jwg = new HashMap();
  LinkedList<com.tencent.mm.ah.m> jwh = new LinkedList();
  
  private void a(he paramhe)
  {
    if (paramhe == null)
    {
      y.e("MicroMsg.exdevice.ScanDeviceLogic", "item null..");
      return;
    }
    if (bk.bl(paramhe.sAE))
    {
      y.e("MicroMsg.exdevice.ScanDeviceLogic", "invalid mac(null or nil)");
      return;
    }
    if (paramhe.sze != 0)
    {
      y.e("MicroMsg.exdevice.ScanDeviceLogic", "device(%s) is invalid", new Object[] { paramhe.sAE });
      return;
    }
    if ((paramhe.sAL == null) || (bk.bl(paramhe.sAL.hQb)))
    {
      y.e("MicroMsg.exdevice.ScanDeviceLogic", "invalid device id(mac=%s)", new Object[] { paramhe.sAE });
      return;
    }
    if ((bk.bl(paramhe.sAL.syI)) || (!paramhe.sAL.syI.equals(this.juL)))
    {
      y.e("MicroMsg.exdevice.ScanDeviceLogic", "device type (%s) is not equal to brand name (%s)", new Object[] { paramhe.hQc, this.juL });
      return;
    }
    byte[] arrayOfByte = (byte[])this.jwg.get(paramhe.sAE);
    String str1 = paramhe.sAE;
    String str2 = paramhe.sAL.syI;
    String str3 = paramhe.sAL.hQb;
    String str4 = paramhe.hQc;
    int i;
    if (arrayOfByte == null)
    {
      i = 0;
      y.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, BatchSearch find mac=%s, deviceType=%s, deviceId=%s, %s, %s", new Object[] { str1, str2, str3, str4, Integer.valueOf(i) });
      if (this.jwf == null) {
        break label281;
      }
      if (arrayOfByte == null) {
        break label289;
      }
    }
    label281:
    label289:
    for (arrayOfByte = ap(arrayOfByte);; arrayOfByte = null)
    {
      this.jwf.a(paramhe.sAL.hQb, arrayOfByte, false);
      return;
      i = arrayOfByte.length;
      break;
      y.e("MicroMsg.exdevice.ScanDeviceLogic", "mCallback null");
      return;
    }
  }
  
  public static aa aLI()
  {
    if (jwe != null) {
      return jwe;
    }
    aa localaa = new aa();
    jwe = localaa;
    return localaa;
  }
  
  private static byte[] ap(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte1 = null;
    int i = 0;
    int j = 0;
    byte[] arrayOfByte2 = arrayOfByte1;
    for (;;)
    {
      int k;
      try
      {
        if (i < paramArrayOfByte.length - 2)
        {
          int m = i + 1;
          k = paramArrayOfByte[i];
          arrayOfByte2 = arrayOfByte1;
          if (k != 0)
          {
            i = m + 1;
            switch (paramArrayOfByte[m])
            {
            case -1: 
              y.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, Manufacturer Specific Data size = %s", new Object[] { Integer.valueOf(k) });
              arrayOfByte1 = new byte[k - 1];
              if (k > 1)
              {
                if ((j >= 32) || (j >= arrayOfByte1.length)) {
                  break label198;
                }
                m = j + 1;
                int n = i + 1;
                arrayOfByte1[j] = paramArrayOfByte[i];
                i = n;
                j = m;
                break label210;
              }
              y.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, Manufacturer Specific Data %s" + b.aq(arrayOfByte1));
            }
          }
        }
      }
      catch (Exception paramArrayOfByte)
      {
        y.printErrStackTrace("MicroMsg.exdevice.ScanDeviceLogic", paramArrayOfByte, "", new Object[0]);
        y.e("MicroMsg.exdevice.ScanDeviceLogic", "EX in parseBroadcastPacket %s", new Object[] { paramArrayOfByte.getMessage() });
        arrayOfByte2 = null;
      }
      return arrayOfByte2;
      label198:
      break label210;
      i += k - 1;
      break;
      label210:
      k -= 1;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String arg5, int paramInt3, byte[] paramArrayOfByte)
  {
    if (this.jwg.containsKey(paramString2)) {
      return;
    }
    if (paramString2 == null)
    {
      y.w("MicroMsg.exdevice.ScanDeviceLogic", "deviceMac is null");
      return;
    }
    paramString1 = paramString2.replaceAll(":", "");
    ??? = jwd;
    if ((bk.bE(paramArrayOfByte)) || (bk.bE(???)) || (???.length > paramArrayOfByte.length))
    {
      paramInt1 = -1;
      if (paramInt1 == -1) {
        break label257;
      }
      if (paramInt1 + 9 > paramArrayOfByte.length) {
        break label244;
      }
      ??? = new byte[paramInt1 + 9];
      System.arraycopy(paramArrayOfByte, 0, ???, 0, ???.length);
      y.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, scanFound mac:%s, realAd:%s", new Object[] { paramString1, b.aq(???) });
      this.jwg.put(paramString1, ???);
    }
    for (;;)
    {
      paramString1 = this.juL + "_" + paramString2;
      if (jwj.containsKey(paramString1)) {
        break label347;
      }
      synchronized (bjn)
      {
        if (!jwi.contains(paramString1)) {
          break label270;
        }
        y.d("MicroMsg.exdevice.ScanDeviceLogic", "hakon, already doing");
        return;
      }
      paramInt2 = 0;
      for (;;)
      {
        if (paramInt2 >= paramArrayOfByte.length) {
          break label239;
        }
        paramInt1 = paramInt2;
        if (b.b(paramArrayOfByte, paramInt2, ???)) {
          break;
        }
        paramInt2 += 1;
      }
      label239:
      paramInt1 = -1;
      break;
      label244:
      this.jwg.put(paramString1, null);
      continue;
      label257:
      this.jwg.put(paramString1, null);
    }
    label270:
    jwi.add(paramString1);
    ??? = this.juL;
    paramString2 = new k(new String[] { paramString2 }, ???);
    if (au.Dk().a(paramString2, 0))
    {
      this.jwh.add(paramString2);
      return;
    }
    jwi.remove(paramString1);
    y.e("MicroMsg.exdevice.ScanDeviceLogic", "MMCore.getNetSceneQueue().doScene failed!!!");
    return;
    label347:
    y.d("MicroMsg.exdevice.ScanDeviceLogic", "hakon, hit cache %s, %s", new Object[] { this.juL, paramString2 });
    a((he)jwj.get(paramString1));
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String arg3, com.tencent.mm.ah.m paramm)
  {
    Object localObject;
    if (paramm == null)
    {
      localObject = "";
      y.i("MicroMsg.exdevice.ScanDeviceLogic", "onSceneEnd, %s, errType=%d, errCode=%d, errMsg=%s", new Object[] { localObject, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), ??? });
      this.jwh.remove(paramm);
      if ((paramInt1 == 0) && (paramInt2 == 0) && (paramm != null)) {
        break label89;
      }
      y.e("MicroMsg.exdevice.ScanDeviceLogic", "do scene failed!!!");
    }
    label89:
    while (542 != paramm.getType())
    {
      return;
      localObject = Integer.valueOf(paramm.getType());
      break;
    }
    paramm = ((k)paramm).aLD().sAI.iterator();
    for (;;)
    {
      if (paramm.hasNext())
      {
        localObject = (he)paramm.next();
        if (!bk.bl(((he)localObject).sAE)) {
          break label159;
        }
        y.e("MicroMsg.exdevice.ScanDeviceLogic", "invalid mac(null or nil)");
        continue;
      }
      break;
      label159:
      String str = this.juL + "_" + ((he)localObject).sAE;
      synchronized (bjn)
      {
        if (jwi.contains(str)) {
          jwi.remove(str);
        }
        if (!jwj.containsKey(str))
        {
          y.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, put into cache, %s", new Object[] { str });
          jwj.put(str, localObject);
        }
        a((he)localObject);
      }
    }
  }
  
  public final void qp(int paramInt)
  {
    y.i("MicroMsg.exdevice.ScanDeviceLogic", "stopScanDevice %s, stopTimer", new Object[] { Integer.valueOf(paramInt) });
    this.fqP.stopTimer();
    if (this.jvr)
    {
      ??? = ad.aLS();
      y.i("MicroMsg.exdevice.ExdeviceConnectManager", "stopScanLogic, bluetooth version = %d", new Object[] { Integer.valueOf(paramInt) });
      if (this == null) {
        y.e("MicroMsg.exdevice.ExdeviceConnectManager", "null == aCallback");
      }
      for (;;)
      {
        this.jvr = false;
        this.juL = null;
        this.jwg.clear();
        au.Dk().b(542, this);
        ??? = this.jwh.iterator();
        while (((Iterator)???).hasNext())
        {
          com.tencent.mm.ah.m localm = (com.tencent.mm.ah.m)((Iterator)???).next();
          if (localm != null) {
            au.Dk().c(localm);
          }
        }
        if (((d)???).jtw == null) {
          y.i("MicroMsg.exdevice.ExdeviceConnectManager", "exdevice process is dead, just leave");
        } else if (u.aMn().jtr == null) {
          y.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
        } else if (!u.aMn().jtr.c(paramInt, ((d)???).jtC)) {
          y.e("MicroMsg.exdevice.ExdeviceConnectManager", "stopScan failed!!!");
        }
      }
      this.jwh.clear();
      if (this.jwf != null) {
        this.jwf.a(null, null, true);
      }
      this.jwf = null;
    }
    synchronized (bjn)
    {
      jwi.clear();
      return;
      y.i("MicroMsg.exdevice.ScanDeviceLogic", "stopScanDevice has been stoped");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.aa
 * JD-Core Version:    0.7.0.1
 */