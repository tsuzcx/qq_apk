package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.b.g;
import com.tencent.mm.f.c.ds;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.model.af;
import com.tencent.mm.plugin.exdevice.model.s;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class e
  extends af
  implements i
{
  private int mErrorCode;
  private m vdz;
  private d vkl;
  private com.tencent.mm.plugin.exdevice.c.b vkm;
  private a vkn;
  
  public e(int paramInt1, long paramLong, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23799);
    this.vkm = null;
    this.vkm = new com.tencent.mm.plugin.exdevice.c.b(paramLong, paramInt2, paramInt3, paramArrayOfByte);
    this.mErrorCode = paramInt1;
    AppMethodBeat.o(23799);
  }
  
  public final boolean a(m paramm, d paramd)
  {
    AppMethodBeat.i(23801);
    boolean bool;
    if ((-5 == this.mErrorCode) || (-3 == this.mErrorCode) || (-4 == this.mErrorCode))
    {
      Log.e("MicroMsg.exdevice.MMAuthTaskExcuter", "Error Code = %d, reply errorcode to device and close channel", new Object[] { Integer.valueOf(this.mErrorCode) });
      this.vkm.a(-1, "", new byte[0]);
      this.vkn = new a(this.vkm, paramd);
      bool = this.vkn.b(paramm);
      Log.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(23801);
      return bool;
    }
    com.tencent.mm.plugin.exdevice.i.b localb = ae.cZx().avH(this.vkm.smk);
    if (localb == null)
    {
      Log.e("MicroMsg.exdevice.MMAuthTaskExcuter", "get device info failed : %d", new Object[] { Long.valueOf(this.vkm.smk) });
      AppMethodBeat.o(23801);
      return false;
    }
    com.tencent.mm.plugin.exdevice.f.a locala = (com.tencent.mm.plugin.exdevice.f.a)this.vkm.cYT();
    if (locala == null)
    {
      Log.e("MicroMsg.exdevice.MMAuthTaskExcuter", "Auth Request parse failed!!!, Tell device before stop this task");
      this.vkm.a(-4, "", new byte[0]);
      this.vkn = new a(this.vkm, paramd);
      bool = this.vkn.b(paramm);
      Log.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(23801);
      return bool;
    }
    byte[] arrayOfByte1;
    long l;
    label405:
    byte[] arrayOfByte2;
    if (locala.vhm == 2)
    {
      if (locala.vho != null)
      {
        arrayOfByte1 = locala.vho.UH;
        if (!Util.isNullOrNil(arrayOfByte1)) {
          break label405;
        }
      }
      for (l = -1L; l != this.vkm.smk; l = com.tencent.mm.plugin.exdevice.k.b.bL(tmp413_411))
      {
        Log.e("MicroMsg.exdevice.MMAuthTaskExcuter", "Auth Request parse fail!!!, Invalid MacAddress");
        this.vkm.a(-1, "", new byte[0]);
        this.vkn = new a(this.vkm, paramd);
        bool = this.vkn.b(paramm);
        Log.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(bool) });
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
    if ((locala.vhm == 1) || (locala.vhm == 1))
    {
      if ((locala.vhj == null) || (!com.tencent.mm.plugin.exdevice.k.b.c(locala.vhj.UH, 0, g.V((localb.field_deviceType + localb.field_deviceID).getBytes()))))
      {
        Log.e("MicroMsg.exdevice.MMAuthTaskExcuter", "Auth Request parse fail!!!, Invalid Md5DeviceTypeAndDeviceId");
        this.vkm.a(-1, "", new byte[0]);
        this.vkn = new a(this.vkm, paramd);
        bool = this.vkn.b(paramm);
        Log.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(23801);
        return bool;
      }
    }
    else
    {
      Log.e("MicroMsg.exdevice.MMAuthTaskExcuter", "Auth Request parse fail!!!, Invalid AuthMethod");
      this.vkm.a(-8, "", new byte[0]);
      this.vkn = new a(this.vkm, paramd);
      bool = this.vkn.b(paramm);
      Log.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(23801);
      return bool;
    }
    if (localb != null)
    {
      l = localb.idP;
      if (System.currentTimeMillis() / 1000L < l)
      {
        Log.e("MicroMsg.exdevice.MMAuthTaskExcuter", "device has been blocked");
        this.vkm.a(-5, "", new byte[0]);
        this.vkn = new a(this.vkm, paramd);
        bool = this.vkn.b(paramm);
        Log.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(23801);
        return bool;
      }
      l = localb.idQ;
      int i = localb.idO;
      if ((i + l > 0L) && (l + i < System.currentTimeMillis() / 1000L))
      {
        arrayOfByte1 = u.dak().t(this.vkm.smk, 1);
        tmp413_411 = u.dak().t(this.vkm.smk, 2);
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
          Log.i("MicroMsg.exdevice.MMAuthTaskExcuter", "has not reach time out, just set back sessionkey, get auth buf from local, auth buf length = %d, session key buf lenght = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          if ((arrayOfByte1 == null) || (tmp413_411 == null)) {
            break label1081;
          }
          u.dak().Jo(localb.field_mac);
          if (2 == u.dak().Jl(localb.field_mac))
          {
            ae.cZJ();
            com.tencent.mm.plugin.exdevice.model.e.d(localb.field_brandName, localb.field_url, 2, localb.field_deviceID);
          }
          this.vkm.a(0, "", u.dak().t(this.vkm.smk, 1));
          this.vkn = new a(this.vkm, this.vkl);
          paramm.setChannelSessionKey(localb.field_mac, tmp413_411);
          bool = this.vkn.b(paramm);
          Log.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(bool) });
          AppMethodBeat.o(23801);
          return bool;
          i = arrayOfByte1.length;
          break;
        }
        label1081:
        Log.i("MicroMsg.exdevice.MMAuthTaskExcuter", "has not reach time out, but local authbuf is null, do auth from server");
      }
    }
    Log.i("MicroMsg.exdevice.MMAuthTaskExcuter", "now do really auth from server");
    this.vdz = paramm;
    this.vkl = paramd;
    paramd = null;
    paramm = paramd;
    if (locala != null)
    {
      paramm = paramd;
      if (locala.vhn != null) {
        paramm = locala.vhn.toByteArray();
      }
    }
    bh.aGY().a(541, this);
    paramm = new s(localb.field_brandName, localb.field_deviceType, localb.field_deviceID, locala.vhl, paramm);
    bh.aGY().a(paramm, 0);
    AppMethodBeat.o(23801);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(23800);
    bh.aGY().b(541, this);
    Log.i("MicroMsg.exdevice.MMAuthTaskExcuter", "onscen end, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    paramq = (s)paramq;
    com.tencent.mm.plugin.exdevice.i.b localb = ae.cZx().avH(this.vkm.smk);
    if (localb == null)
    {
      Log.e("MicroMsg.exdevice.MMAuthTaskExcuter", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceId Failed!!!");
      AppMethodBeat.o(23800);
      return;
    }
    long l = localb.idP;
    if (System.currentTimeMillis() / 1000L < l)
    {
      Log.e("MicroMsg.exdevice.MMAuthTaskExcuter", "device has been blocked");
      this.vkm.a(-5, "", new byte[0]);
      this.vkn = new a(this.vkm, this.vkl);
      Log.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(this.vkn.b(this.vdz)) });
      AppMethodBeat.o(23800);
      return;
    }
    this.vkm.a(paramInt2, paramString, paramq.cZr());
    this.vkn = new a(this.vkm, this.vkl);
    Log.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(this.vkn.b(this.vdz)) });
    AppMethodBeat.o(23800);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.e
 * JD-Core Version:    0.7.0.1
 */