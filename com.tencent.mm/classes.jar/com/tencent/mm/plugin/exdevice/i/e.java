package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.a.g;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.c.cc;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.model.r;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class e
  extends ae
  implements com.tencent.mm.ah.f
{
  private com.tencent.mm.plugin.exdevice.service.m jtr;
  private d jzP;
  private com.tencent.mm.plugin.exdevice.b.b jzQ = null;
  private a jzR;
  private int mErrorCode;
  
  public e(int paramInt1, long paramLong, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    this.jzQ = new com.tencent.mm.plugin.exdevice.b.b(paramLong, paramInt2, paramInt3, paramArrayOfByte);
    this.mErrorCode = paramInt1;
  }
  
  public final boolean a(com.tencent.mm.plugin.exdevice.service.m paramm, d paramd)
  {
    boolean bool;
    if ((-5 == this.mErrorCode) || (-3 == this.mErrorCode) || (-4 == this.mErrorCode))
    {
      y.e("MicroMsg.exdevice.MMAuthTaskExcuter", "Error Code = %d, reply errorcode to device and close channel", new Object[] { Integer.valueOf(this.mErrorCode) });
      this.jzQ.d(-1, "", new byte[0]);
      this.jzR = new a(this.jzQ, paramd);
      bool = this.jzR.b(paramm);
      y.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(bool) });
      return bool;
    }
    com.tencent.mm.plugin.exdevice.h.b localb = ad.aLL().BF(this.jzQ.hXu);
    if (localb == null)
    {
      y.e("MicroMsg.exdevice.MMAuthTaskExcuter", "get device info failed : %d", new Object[] { Long.valueOf(this.jzQ.hXu) });
      return false;
    }
    com.tencent.mm.plugin.exdevice.e.a locala = (com.tencent.mm.plugin.exdevice.e.a)this.jzQ.aLk();
    if (locala == null)
    {
      y.e("MicroMsg.exdevice.MMAuthTaskExcuter", "Auth Request parse failed!!!, Tell device before stop this task");
      this.jzQ.d(-4, "", new byte[0]);
      this.jzR = new a(this.jzQ, paramd);
      bool = this.jzR.b(paramm);
      y.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(bool) });
      return bool;
    }
    byte[] arrayOfByte1;
    long l;
    label375:
    byte[] arrayOfByte2;
    if (locala.jxe == 2)
    {
      if (locala.jxg != null)
      {
        arrayOfByte1 = locala.jxg.oY;
        if (!bk.bE(arrayOfByte1)) {
          break label375;
        }
      }
      for (l = -1L; l != this.jzQ.hXu; l = com.tencent.mm.plugin.exdevice.j.b.ar(tmp383_381))
      {
        y.e("MicroMsg.exdevice.MMAuthTaskExcuter", "Auth Request parse fail!!!, Invalid MacAddress");
        this.jzQ.d(-1, "", new byte[0]);
        this.jzR = new a(this.jzQ, paramd);
        bool = this.jzR.b(paramm);
        y.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(bool) });
        return bool;
        arrayOfByte2 = new byte[8];
        byte[] tmp383_381 = arrayOfByte2;
        tmp383_381[0] = 0;
        byte[] tmp388_383 = tmp383_381;
        tmp388_383[1] = 0;
        byte[] tmp393_388 = tmp388_383;
        tmp393_388[2] = 0;
        byte[] tmp398_393 = tmp393_388;
        tmp398_393[3] = 0;
        byte[] tmp403_398 = tmp398_393;
        tmp403_398[4] = 0;
        byte[] tmp408_403 = tmp403_398;
        tmp408_403[5] = 0;
        byte[] tmp413_408 = tmp408_403;
        tmp413_408[6] = 0;
        byte[] tmp419_413 = tmp413_408;
        tmp419_413[7] = 0;
        tmp419_413;
        System.arraycopy(arrayOfByte1, 0, tmp383_381, 2, 6);
      }
    }
    if ((locala.jxe == 1) || (locala.jxe == 1))
    {
      if ((locala.jxb == null) || (!com.tencent.mm.plugin.exdevice.j.b.b(locala.jxb.oY, 0, g.p((localb.field_deviceType + localb.field_deviceID).getBytes()))))
      {
        y.e("MicroMsg.exdevice.MMAuthTaskExcuter", "Auth Request parse fail!!!, Invalid Md5DeviceTypeAndDeviceId");
        this.jzQ.d(-1, "", new byte[0]);
        this.jzR = new a(this.jzQ, paramd);
        bool = this.jzR.b(paramm);
        y.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(bool) });
        return bool;
      }
    }
    else
    {
      y.e("MicroMsg.exdevice.MMAuthTaskExcuter", "Auth Request parse fail!!!, Invalid AuthMethod");
      this.jzQ.d(-8, "", new byte[0]);
      this.jzR = new a(this.jzQ, paramd);
      bool = this.jzR.b(paramm);
      y.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(bool) });
      return bool;
    }
    if (localb != null)
    {
      l = localb.cMQ;
      if (System.currentTimeMillis() / 1000L < l)
      {
        y.e("MicroMsg.exdevice.MMAuthTaskExcuter", "device has been blocked");
        this.jzQ.d(-5, "", new byte[0]);
        this.jzR = new a(this.jzQ, paramd);
        bool = this.jzR.b(paramm);
        y.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(bool) });
        return bool;
      }
      l = localb.cMR;
      int i = localb.cMP;
      if ((i + l > 0L) && (l + i < System.currentTimeMillis() / 1000L))
      {
        arrayOfByte1 = u.aMm().l(this.jzQ.hXu, 1);
        tmp383_381 = u.aMm().l(this.jzQ.hXu, 2);
        if (arrayOfByte1 == null)
        {
          i = -1;
          if (tmp383_381 != null) {
            break label1019;
          }
        }
        label1019:
        for (int j = -1;; j = tmp383_381.length)
        {
          y.i("MicroMsg.exdevice.MMAuthTaskExcuter", "has not reach time out, just set back sessionkey, get auth buf from local, auth buf length = %d, session key buf lenght = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          if ((arrayOfByte1 == null) || (tmp383_381 == null)) {
            break label1027;
          }
          u.aMm().dV(localb.field_mac);
          if (2 == u.aMm().dS(localb.field_mac))
          {
            ad.aLW();
            com.tencent.mm.plugin.exdevice.model.e.c(localb.field_brandName, localb.field_url, 2, localb.field_deviceID);
          }
          this.jzQ.d(0, "", u.aMm().l(this.jzQ.hXu, 1));
          this.jzR = new a(this.jzQ, this.jzP);
          paramm.setChannelSessionKey(localb.field_mac, tmp383_381);
          bool = this.jzR.b(paramm);
          y.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(bool) });
          return bool;
          i = arrayOfByte1.length;
          break;
        }
        label1027:
        y.i("MicroMsg.exdevice.MMAuthTaskExcuter", "has not reach time out, but local authbuf is null, do auth from server");
      }
    }
    y.i("MicroMsg.exdevice.MMAuthTaskExcuter", "now do really auth from server");
    this.jtr = paramm;
    this.jzP = paramd;
    paramd = null;
    paramm = paramd;
    if (locala != null)
    {
      paramm = paramd;
      if (locala.jxf != null) {
        paramm = locala.jxf.toByteArray();
      }
    }
    au.Dk().a(541, this);
    paramm = new r(localb.field_brandName, localb.field_deviceType, localb.field_deviceID, locala.jxd, paramm);
    au.Dk().a(paramm, 0);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    au.Dk().b(541, this);
    y.i("MicroMsg.exdevice.MMAuthTaskExcuter", "onscen end, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    paramm = (r)paramm;
    com.tencent.mm.plugin.exdevice.h.b localb = ad.aLL().BF(this.jzQ.hXu);
    if (localb == null)
    {
      y.e("MicroMsg.exdevice.MMAuthTaskExcuter", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceId Failed!!!");
      return;
    }
    long l = localb.cMQ;
    if (System.currentTimeMillis() / 1000L < l)
    {
      y.e("MicroMsg.exdevice.MMAuthTaskExcuter", "device has been blocked");
      this.jzQ.d(-5, "", new byte[0]);
      this.jzR = new a(this.jzQ, this.jzP);
      y.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(this.jzR.b(this.jtr)) });
      return;
    }
    this.jzQ.d(paramInt2, paramString, paramm.aLF());
    this.jzR = new a(this.jzQ, this.jzP);
    y.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(this.jzR.b(this.jtr)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.i.e
 * JD-Core Version:    0.7.0.1
 */