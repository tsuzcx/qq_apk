package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.b.g;
import com.tencent.mm.g.c.di;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.r;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.bu;

public final class e
  extends com.tencent.mm.plugin.exdevice.model.ae
  implements com.tencent.mm.ak.f
{
  private int mErrorCode;
  private m qgX;
  private d qnu;
  private com.tencent.mm.plugin.exdevice.c.b qnv;
  private a qnw;
  
  public e(int paramInt1, long paramLong, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23799);
    this.qnv = null;
    this.qnv = new com.tencent.mm.plugin.exdevice.c.b(paramLong, paramInt2, paramInt3, paramArrayOfByte);
    this.mErrorCode = paramInt1;
    AppMethodBeat.o(23799);
  }
  
  public final boolean a(m paramm, d paramd)
  {
    AppMethodBeat.i(23801);
    boolean bool;
    if ((-5 == this.mErrorCode) || (-3 == this.mErrorCode) || (-4 == this.mErrorCode))
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.exdevice.MMAuthTaskExcuter", "Error Code = %d, reply errorcode to device and close channel", new Object[] { Integer.valueOf(this.mErrorCode) });
      this.qnv.a(-1, "", new byte[0]);
      this.qnw = new a(this.qnv, paramd);
      bool = this.qnw.b(paramm);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(23801);
      return bool;
    }
    com.tencent.mm.plugin.exdevice.i.b localb = ad.cmJ().adz(this.qnv.nZd);
    if (localb == null)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.exdevice.MMAuthTaskExcuter", "get device info failed : %d", new Object[] { Long.valueOf(this.qnv.nZd) });
      AppMethodBeat.o(23801);
      return false;
    }
    com.tencent.mm.plugin.exdevice.f.a locala = (com.tencent.mm.plugin.exdevice.f.a)this.qnv.cmh();
    if (locala == null)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.exdevice.MMAuthTaskExcuter", "Auth Request parse failed!!!, Tell device before stop this task");
      this.qnv.a(-4, "", new byte[0]);
      this.qnw = new a(this.qnv, paramd);
      bool = this.qnw.b(paramm);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(23801);
      return bool;
    }
    byte[] arrayOfByte1;
    long l;
    label405:
    byte[] arrayOfByte2;
    if (locala.qkJ == 2)
    {
      if (locala.qkL != null)
      {
        arrayOfByte1 = locala.qkL.zr;
        if (!bu.cF(arrayOfByte1)) {
          break label405;
        }
      }
      for (l = -1L; l != this.qnv.nZd; l = com.tencent.mm.plugin.exdevice.k.b.bg(tmp413_411))
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.exdevice.MMAuthTaskExcuter", "Auth Request parse fail!!!, Invalid MacAddress");
        this.qnv.a(-1, "", new byte[0]);
        this.qnw = new a(this.qnv, paramd);
        bool = this.qnw.b(paramm);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(23801);
        return bool;
        arrayOfByte2 = new byte[8];
        byte[] tmp413_411 = arrayOfByte2;
        tmp413_411[0] = 0;
        byte[] tmp418_413 = tmp413_411;
        tmp418_413[1] = 0;
        byte[] tmp423_418 = tmp418_413;
        tmp423_418[2] = 0;
        byte[] tmp428_423 = tmp423_418;
        tmp428_423[3] = 0;
        byte[] tmp433_428 = tmp428_423;
        tmp433_428[4] = 0;
        byte[] tmp438_433 = tmp433_428;
        tmp438_433[5] = 0;
        byte[] tmp443_438 = tmp438_433;
        tmp443_438[6] = 0;
        byte[] tmp449_443 = tmp443_438;
        tmp449_443[7] = 0;
        tmp449_443;
        System.arraycopy(arrayOfByte1, 0, tmp413_411, 2, 6);
      }
    }
    if ((locala.qkJ == 1) || (locala.qkJ == 1))
    {
      if ((locala.qkG == null) || (!com.tencent.mm.plugin.exdevice.k.b.c(locala.qkG.zr, 0, g.C((localb.field_deviceType + localb.field_deviceID).getBytes()))))
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.exdevice.MMAuthTaskExcuter", "Auth Request parse fail!!!, Invalid Md5DeviceTypeAndDeviceId");
        this.qnv.a(-1, "", new byte[0]);
        this.qnw = new a(this.qnv, paramd);
        bool = this.qnw.b(paramm);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(23801);
        return bool;
      }
    }
    else
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.exdevice.MMAuthTaskExcuter", "Auth Request parse fail!!!, Invalid AuthMethod");
      this.qnv.a(-8, "", new byte[0]);
      this.qnw = new a(this.qnv, paramd);
      bool = this.qnw.b(paramm);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(23801);
      return bool;
    }
    if (localb != null)
    {
      l = localb.fhv;
      if (System.currentTimeMillis() / 1000L < l)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.exdevice.MMAuthTaskExcuter", "device has been blocked");
        this.qnv.a(-5, "", new byte[0]);
        this.qnw = new a(this.qnv, paramd);
        bool = this.qnw.b(paramm);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(23801);
        return bool;
      }
      l = localb.fhw;
      int i = localb.fhu;
      if ((i + l > 0L) && (l + i < System.currentTimeMillis() / 1000L))
      {
        arrayOfByte1 = u.cnk().u(this.qnv.nZd, 1);
        tmp413_411 = u.cnk().u(this.qnv.nZd, 2);
        if (arrayOfByte1 == null)
        {
          i = -1;
          if (tmp413_411 != null) {
            break label1073;
          }
        }
        label1073:
        for (int j = -1;; j = tmp413_411.length)
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.MMAuthTaskExcuter", "has not reach time out, just set back sessionkey, get auth buf from local, auth buf length = %d, session key buf lenght = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          if ((arrayOfByte1 == null) || (tmp413_411 == null)) {
            break label1081;
          }
          u.cnk().uW(localb.field_mac);
          if (2 == u.cnk().uT(localb.field_mac))
          {
            ad.cmU();
            com.tencent.mm.plugin.exdevice.model.e.e(localb.field_brandName, localb.field_url, 2, localb.field_deviceID);
          }
          this.qnv.a(0, "", u.cnk().u(this.qnv.nZd, 1));
          this.qnw = new a(this.qnv, this.qnu);
          paramm.setChannelSessionKey(localb.field_mac, tmp413_411);
          bool = this.qnw.b(paramm);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(bool) });
          AppMethodBeat.o(23801);
          return bool;
          i = arrayOfByte1.length;
          break;
        }
        label1081:
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.MMAuthTaskExcuter", "has not reach time out, but local authbuf is null, do auth from server");
      }
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.MMAuthTaskExcuter", "now do really auth from server");
    this.qgX = paramm;
    this.qnu = paramd;
    paramd = null;
    paramm = paramd;
    if (locala != null)
    {
      paramm = paramd;
      if (locala.qkK != null) {
        paramm = locala.qkK.toByteArray();
      }
    }
    bc.ajj().a(541, this);
    paramm = new r(localb.field_brandName, localb.field_deviceType, localb.field_deviceID, locala.qkI, paramm);
    bc.ajj().a(paramm, 0);
    AppMethodBeat.o(23801);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(23800);
    bc.ajj().b(541, this);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.MMAuthTaskExcuter", "onscen end, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    paramn = (r)paramn;
    com.tencent.mm.plugin.exdevice.i.b localb = ad.cmJ().adz(this.qnv.nZd);
    if (localb == null)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.exdevice.MMAuthTaskExcuter", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceId Failed!!!");
      AppMethodBeat.o(23800);
      return;
    }
    long l = localb.fhv;
    if (System.currentTimeMillis() / 1000L < l)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.exdevice.MMAuthTaskExcuter", "device has been blocked");
      this.qnv.a(-5, "", new byte[0]);
      this.qnw = new a(this.qnv, this.qnu);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(this.qnw.b(this.qgX)) });
      AppMethodBeat.o(23800);
      return;
    }
    this.qnv.a(paramInt2, paramString, paramn.cmD());
    this.qnw = new a(this.qnv, this.qnu);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(this.qnw.b(this.qgX)) });
    AppMethodBeat.o(23800);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.e
 * JD-Core Version:    0.7.0.1
 */