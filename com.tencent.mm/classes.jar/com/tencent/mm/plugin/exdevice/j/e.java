package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.b.ee;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.exdevice.model.ah;
import com.tencent.mm.plugin.exdevice.model.ai;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class e
  extends ai
  implements h
{
  private int mErrorCode;
  private m yps;
  private d ywj;
  private com.tencent.mm.plugin.exdevice.c.b ywk;
  private a ywl;
  
  public e(int paramInt1, long paramLong, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23799);
    this.ywk = null;
    this.ywk = new com.tencent.mm.plugin.exdevice.c.b(paramLong, paramInt2, paramInt3, paramArrayOfByte);
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
      this.ywk.a(-1, "", new byte[0]);
      this.ywl = new a(this.ywk, paramd);
      bool = this.ywl.b(paramm);
      Log.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(23801);
      return bool;
    }
    com.tencent.mm.plugin.exdevice.i.b localb = ah.dFO().apH(this.ywk.vyj);
    if (localb == null)
    {
      Log.e("MicroMsg.exdevice.MMAuthTaskExcuter", "get device info failed : %d", new Object[] { Long.valueOf(this.ywk.vyj) });
      AppMethodBeat.o(23801);
      return false;
    }
    com.tencent.mm.plugin.exdevice.f.a locala = (com.tencent.mm.plugin.exdevice.f.a)this.ywk.dFk();
    if (locala == null)
    {
      Log.e("MicroMsg.exdevice.MMAuthTaskExcuter", "Auth Request parse failed!!!, Tell device before stop this task");
      this.ywk.a(-4, "", new byte[0]);
      this.ywl = new a(this.ywk, paramd);
      bool = this.ywl.b(paramm);
      Log.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(23801);
      return bool;
    }
    byte[] arrayOfByte1;
    long l;
    label405:
    byte[] arrayOfByte2;
    if (locala.yto == 2)
    {
      if (locala.ytq != null)
      {
        arrayOfByte1 = locala.ytq.Op;
        if (!Util.isNullOrNil(arrayOfByte1)) {
          break label405;
        }
      }
      for (l = -1L; l != this.ywk.vyj; l = com.tencent.mm.plugin.exdevice.k.b.bL(tmp413_411))
      {
        Log.e("MicroMsg.exdevice.MMAuthTaskExcuter", "Auth Request parse fail!!!, Invalid MacAddress");
        this.ywk.a(-1, "", new byte[0]);
        this.ywl = new a(this.ywk, paramd);
        bool = this.ywl.b(paramm);
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
    if ((locala.yto == 1) || (locala.yto == 1))
    {
      if ((locala.ytl == null) || (!com.tencent.mm.plugin.exdevice.k.b.d(locala.ytl.Op, 0, com.tencent.mm.b.g.U((localb.field_deviceType + localb.field_deviceID).getBytes()))))
      {
        Log.e("MicroMsg.exdevice.MMAuthTaskExcuter", "Auth Request parse fail!!!, Invalid Md5DeviceTypeAndDeviceId");
        this.ywk.a(-1, "", new byte[0]);
        this.ywl = new a(this.ywk, paramd);
        bool = this.ywl.b(paramm);
        Log.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(23801);
        return bool;
      }
    }
    else
    {
      Log.e("MicroMsg.exdevice.MMAuthTaskExcuter", "Auth Request parse fail!!!, Invalid AuthMethod");
      this.ywk.a(-8, "", new byte[0]);
      this.ywl = new a(this.ywk, paramd);
      bool = this.ywl.b(paramm);
      Log.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(23801);
      return bool;
    }
    if (localb != null)
    {
      l = localb.kCZ;
      if (System.currentTimeMillis() / 1000L < l)
      {
        Log.e("MicroMsg.exdevice.MMAuthTaskExcuter", "device has been blocked");
        this.ywk.a(-5, "", new byte[0]);
        this.ywl = new a(this.ywk, paramd);
        bool = this.ywl.b(paramm);
        Log.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(23801);
        return bool;
      }
      l = localb.kDa;
      int i = localb.kCY;
      if ((i + l > 0L) && (l + i < System.currentTimeMillis() / 1000L))
      {
        arrayOfByte1 = com.tencent.mm.plugin.exdevice.service.u.dGD().C(this.ywk.vyj, 1);
        tmp413_411 = com.tencent.mm.plugin.exdevice.service.u.dGD().C(this.ywk.vyj, 2);
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
          com.tencent.mm.plugin.exdevice.service.u.dGD().lE(localb.field_mac);
          if (2 == com.tencent.mm.plugin.exdevice.service.u.dGD().lB(localb.field_mac))
          {
            ah.dGc();
            com.tencent.mm.plugin.exdevice.model.g.d(localb.field_brandName, localb.field_url, 2, localb.field_deviceID);
          }
          this.ywk.a(0, "", com.tencent.mm.plugin.exdevice.service.u.dGD().C(this.ywk.vyj, 1));
          this.ywl = new a(this.ywk, this.ywj);
          paramm.setChannelSessionKey(localb.field_mac, tmp413_411);
          bool = this.ywl.b(paramm);
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
    this.yps = paramm;
    this.ywj = paramd;
    paramd = null;
    paramm = paramd;
    if (locala != null)
    {
      paramm = paramd;
      if (locala.ytp != null) {
        paramm = locala.ytp.toByteArray();
      }
    }
    bh.aZW().a(541, this);
    paramm = new com.tencent.mm.plugin.exdevice.model.u(localb.field_brandName, localb.field_deviceType, localb.field_deviceID, locala.ytn, paramm);
    bh.aZW().a(paramm, 0);
    AppMethodBeat.o(23801);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(23800);
    bh.aZW().b(541, this);
    Log.i("MicroMsg.exdevice.MMAuthTaskExcuter", "onscen end, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    paramp = (com.tencent.mm.plugin.exdevice.model.u)paramp;
    com.tencent.mm.plugin.exdevice.i.b localb = ah.dFO().apH(this.ywk.vyj);
    if (localb == null)
    {
      Log.e("MicroMsg.exdevice.MMAuthTaskExcuter", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceId Failed!!!");
      AppMethodBeat.o(23800);
      return;
    }
    long l = localb.kCZ;
    if (System.currentTimeMillis() / 1000L < l)
    {
      Log.e("MicroMsg.exdevice.MMAuthTaskExcuter", "device has been blocked");
      this.ywk.a(-5, "", new byte[0]);
      this.ywl = new a(this.ywk, this.ywj);
      Log.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(this.ywl.b(this.yps)) });
      AppMethodBeat.o(23800);
      return;
    }
    this.ywk.a(paramInt2, paramString, paramp.dFI());
    this.ywl = new a(this.ywk, this.ywj);
    Log.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(this.ywl.b(this.yps)) });
    AppMethodBeat.o(23800);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.e
 * JD-Core Version:    0.7.0.1
 */