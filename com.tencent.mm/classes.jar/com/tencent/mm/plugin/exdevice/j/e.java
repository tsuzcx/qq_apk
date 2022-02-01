package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.c.cw;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.model.r;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.bt;

public final class e
  extends ae
  implements com.tencent.mm.al.g
{
  private int mErrorCode;
  private m oTC;
  private d oZZ;
  private com.tencent.mm.plugin.exdevice.c.b paa;
  private a pab;
  
  public e(int paramInt1, long paramLong, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23799);
    this.paa = null;
    this.paa = new com.tencent.mm.plugin.exdevice.c.b(paramLong, paramInt2, paramInt3, paramArrayOfByte);
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
      this.paa.a(-1, "", new byte[0]);
      this.pab = new a(this.paa, paramd);
      bool = this.pab.b(paramm);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(23801);
      return bool;
    }
    com.tencent.mm.plugin.exdevice.i.b localb = com.tencent.mm.plugin.exdevice.model.ad.bZG().UQ(this.paa.mQq);
    if (localb == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.MMAuthTaskExcuter", "get device info failed : %d", new Object[] { Long.valueOf(this.paa.mQq) });
      AppMethodBeat.o(23801);
      return false;
    }
    com.tencent.mm.plugin.exdevice.f.a locala = (com.tencent.mm.plugin.exdevice.f.a)this.paa.bZe();
    if (locala == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.MMAuthTaskExcuter", "Auth Request parse failed!!!, Tell device before stop this task");
      this.paa.a(-4, "", new byte[0]);
      this.pab = new a(this.paa, paramd);
      bool = this.pab.b(paramm);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(23801);
      return bool;
    }
    byte[] arrayOfByte1;
    long l;
    label405:
    byte[] arrayOfByte2;
    if (locala.oXo == 2)
    {
      if (locala.oXq != null)
      {
        arrayOfByte1 = locala.oXq.wA;
        if (!bt.cw(arrayOfByte1)) {
          break label405;
        }
      }
      for (l = -1L; l != this.paa.mQq; l = com.tencent.mm.plugin.exdevice.k.b.bf(tmp413_411))
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.MMAuthTaskExcuter", "Auth Request parse fail!!!, Invalid MacAddress");
        this.paa.a(-1, "", new byte[0]);
        this.pab = new a(this.paa, paramd);
        bool = this.pab.b(paramm);
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
    if ((locala.oXo == 1) || (locala.oXo == 1))
    {
      if ((locala.oXl == null) || (!com.tencent.mm.plugin.exdevice.k.b.c(locala.oXl.wA, 0, com.tencent.mm.b.g.E((localb.field_deviceType + localb.field_deviceID).getBytes()))))
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.MMAuthTaskExcuter", "Auth Request parse fail!!!, Invalid Md5DeviceTypeAndDeviceId");
        this.paa.a(-1, "", new byte[0]);
        this.pab = new a(this.paa, paramd);
        bool = this.pab.b(paramm);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(23801);
        return bool;
      }
    }
    else
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.MMAuthTaskExcuter", "Auth Request parse fail!!!, Invalid AuthMethod");
      this.paa.a(-8, "", new byte[0]);
      this.pab = new a(this.paa, paramd);
      bool = this.pab.b(paramm);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(23801);
      return bool;
    }
    if (localb != null)
    {
      l = localb.eKk;
      if (System.currentTimeMillis() / 1000L < l)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.MMAuthTaskExcuter", "device has been blocked");
        this.paa.a(-5, "", new byte[0]);
        this.pab = new a(this.paa, paramd);
        bool = this.pab.b(paramm);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(23801);
        return bool;
      }
      l = localb.eKl;
      int i = localb.eKj;
      if ((i + l > 0L) && (l + i < System.currentTimeMillis() / 1000L))
      {
        arrayOfByte1 = u.cah().t(this.paa.mQq, 1);
        tmp413_411 = u.cah().t(this.paa.mQq, 2);
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
          u.cah().oV(localb.field_mac);
          if (2 == u.cah().oS(localb.field_mac))
          {
            com.tencent.mm.plugin.exdevice.model.ad.bZR();
            com.tencent.mm.plugin.exdevice.model.e.d(localb.field_brandName, localb.field_url, 2, localb.field_deviceID);
          }
          this.paa.a(0, "", u.cah().t(this.paa.mQq, 1));
          this.pab = new a(this.paa, this.oZZ);
          paramm.setChannelSessionKey(localb.field_mac, tmp413_411);
          bool = this.pab.b(paramm);
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
    this.oTC = paramm;
    this.oZZ = paramd;
    paramd = null;
    paramm = paramd;
    if (locala != null)
    {
      paramm = paramd;
      if (locala.oXp != null) {
        paramm = locala.oXp.toByteArray();
      }
    }
    az.aeS().a(541, this);
    paramm = new r(localb.field_brandName, localb.field_deviceType, localb.field_deviceID, locala.oXn, paramm);
    az.aeS().a(paramm, 0);
    AppMethodBeat.o(23801);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(23800);
    az.aeS().b(541, this);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.MMAuthTaskExcuter", "onscen end, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    paramn = (r)paramn;
    com.tencent.mm.plugin.exdevice.i.b localb = com.tencent.mm.plugin.exdevice.model.ad.bZG().UQ(this.paa.mQq);
    if (localb == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.MMAuthTaskExcuter", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceId Failed!!!");
      AppMethodBeat.o(23800);
      return;
    }
    long l = localb.eKk;
    if (System.currentTimeMillis() / 1000L < l)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.MMAuthTaskExcuter", "device has been blocked");
      this.paa.a(-5, "", new byte[0]);
      this.pab = new a(this.paa, this.oZZ);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(this.pab.b(this.oTC)) });
      AppMethodBeat.o(23800);
      return;
    }
    this.paa.a(paramInt2, paramString, paramn.bZA());
    this.pab = new a(this.paa, this.oZZ);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(this.pab.b(this.oTC)) });
    AppMethodBeat.o(23800);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.e
 * JD-Core Version:    0.7.0.1
 */