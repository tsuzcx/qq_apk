package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.b.g;
import com.tencent.mm.g.c.di;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.model.r;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.bt;

public final class e
  extends ae
  implements com.tencent.mm.al.f
{
  private int mErrorCode;
  private m qas;
  private d qgP;
  private com.tencent.mm.plugin.exdevice.c.b qgQ;
  private a qgR;
  
  public e(int paramInt1, long paramLong, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23799);
    this.qgQ = null;
    this.qgQ = new com.tencent.mm.plugin.exdevice.c.b(paramLong, paramInt2, paramInt3, paramArrayOfByte);
    this.mErrorCode = paramInt1;
    AppMethodBeat.o(23799);
  }
  
  public final boolean a(m paramm, d paramd)
  {
    AppMethodBeat.i(23801);
    boolean bool;
    if ((-5 == this.mErrorCode) || (-3 == this.mErrorCode) || (-4 == this.mErrorCode))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.MMAuthTaskExcuter", "Error Code = %d, reply errorcode to device and close channel", new Object[] { Integer.valueOf(this.mErrorCode) });
      this.qgQ.a(-1, "", new byte[0]);
      this.qgR = new a(this.qgQ, paramd);
      bool = this.qgR.b(paramm);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(23801);
      return bool;
    }
    com.tencent.mm.plugin.exdevice.i.b localb = com.tencent.mm.plugin.exdevice.model.ad.clt().acI(this.qgQ.nTx);
    if (localb == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.MMAuthTaskExcuter", "get device info failed : %d", new Object[] { Long.valueOf(this.qgQ.nTx) });
      AppMethodBeat.o(23801);
      return false;
    }
    com.tencent.mm.plugin.exdevice.f.a locala = (com.tencent.mm.plugin.exdevice.f.a)this.qgQ.ckR();
    if (locala == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.MMAuthTaskExcuter", "Auth Request parse failed!!!, Tell device before stop this task");
      this.qgQ.a(-4, "", new byte[0]);
      this.qgR = new a(this.qgQ, paramd);
      bool = this.qgR.b(paramm);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(23801);
      return bool;
    }
    byte[] arrayOfByte1;
    long l;
    label405:
    byte[] arrayOfByte2;
    if (locala.qee == 2)
    {
      if (locala.qeg != null)
      {
        arrayOfByte1 = locala.qeg.zr;
        if (!bt.cC(arrayOfByte1)) {
          break label405;
        }
      }
      for (l = -1L; l != this.qgQ.nTx; l = com.tencent.mm.plugin.exdevice.k.b.bh(tmp413_411))
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.MMAuthTaskExcuter", "Auth Request parse fail!!!, Invalid MacAddress");
        this.qgQ.a(-1, "", new byte[0]);
        this.qgR = new a(this.qgQ, paramd);
        bool = this.qgR.b(paramm);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(bool) });
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
    if ((locala.qee == 1) || (locala.qee == 1))
    {
      if ((locala.qeb == null) || (!com.tencent.mm.plugin.exdevice.k.b.c(locala.qeb.zr, 0, g.C((localb.field_deviceType + localb.field_deviceID).getBytes()))))
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.MMAuthTaskExcuter", "Auth Request parse fail!!!, Invalid Md5DeviceTypeAndDeviceId");
        this.qgQ.a(-1, "", new byte[0]);
        this.qgR = new a(this.qgQ, paramd);
        bool = this.qgR.b(paramm);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(23801);
        return bool;
      }
    }
    else
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.MMAuthTaskExcuter", "Auth Request parse fail!!!, Invalid AuthMethod");
      this.qgQ.a(-8, "", new byte[0]);
      this.qgR = new a(this.qgQ, paramd);
      bool = this.qgR.b(paramm);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(23801);
      return bool;
    }
    if (localb != null)
    {
      l = localb.ffy;
      if (System.currentTimeMillis() / 1000L < l)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.MMAuthTaskExcuter", "device has been blocked");
        this.qgQ.a(-5, "", new byte[0]);
        this.qgR = new a(this.qgQ, paramd);
        bool = this.qgR.b(paramm);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(23801);
        return bool;
      }
      l = localb.ffz;
      int i = localb.ffx;
      if ((i + l > 0L) && (l + i < System.currentTimeMillis() / 1000L))
      {
        arrayOfByte1 = u.clU().u(this.qgQ.nTx, 1);
        tmp413_411 = u.clU().u(this.qgQ.nTx, 2);
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
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.MMAuthTaskExcuter", "has not reach time out, just set back sessionkey, get auth buf from local, auth buf length = %d, session key buf lenght = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          if ((arrayOfByte1 == null) || (tmp413_411 == null)) {
            break label1081;
          }
          u.clU().uF(localb.field_mac);
          if (2 == u.clU().uC(localb.field_mac))
          {
            com.tencent.mm.plugin.exdevice.model.ad.clE();
            com.tencent.mm.plugin.exdevice.model.e.e(localb.field_brandName, localb.field_url, 2, localb.field_deviceID);
          }
          this.qgQ.a(0, "", u.clU().u(this.qgQ.nTx, 1));
          this.qgR = new a(this.qgQ, this.qgP);
          paramm.setChannelSessionKey(localb.field_mac, tmp413_411);
          bool = this.qgR.b(paramm);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(bool) });
          AppMethodBeat.o(23801);
          return bool;
          i = arrayOfByte1.length;
          break;
        }
        label1081:
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.MMAuthTaskExcuter", "has not reach time out, but local authbuf is null, do auth from server");
      }
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.MMAuthTaskExcuter", "now do really auth from server");
    this.qas = paramm;
    this.qgP = paramd;
    paramd = null;
    paramm = paramd;
    if (locala != null)
    {
      paramm = paramd;
      if (locala.qef != null) {
        paramm = locala.qef.toByteArray();
      }
    }
    ba.aiU().a(541, this);
    paramm = new r(localb.field_brandName, localb.field_deviceType, localb.field_deviceID, locala.qed, paramm);
    ba.aiU().a(paramm, 0);
    AppMethodBeat.o(23801);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(23800);
    ba.aiU().b(541, this);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.MMAuthTaskExcuter", "onscen end, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    paramn = (r)paramn;
    com.tencent.mm.plugin.exdevice.i.b localb = com.tencent.mm.plugin.exdevice.model.ad.clt().acI(this.qgQ.nTx);
    if (localb == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.MMAuthTaskExcuter", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceId Failed!!!");
      AppMethodBeat.o(23800);
      return;
    }
    long l = localb.ffy;
    if (System.currentTimeMillis() / 1000L < l)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.MMAuthTaskExcuter", "device has been blocked");
      this.qgQ.a(-5, "", new byte[0]);
      this.qgR = new a(this.qgQ, this.qgP);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(this.qgR.b(this.qas)) });
      AppMethodBeat.o(23800);
      return;
    }
    this.qgQ.a(paramInt2, paramString, paramn.cln());
    this.qgR = new a(this.qgQ, this.qgP);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(this.qgR.b(this.qas)) });
    AppMethodBeat.o(23800);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.e
 * JD-Core Version:    0.7.0.1
 */