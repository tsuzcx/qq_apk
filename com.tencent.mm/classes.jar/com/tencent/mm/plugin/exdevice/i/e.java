package com.tencent.mm.plugin.exdevice.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.model.r;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class e
  extends ae
  implements com.tencent.mm.ai.f
{
  private com.tencent.mm.plugin.exdevice.service.m lCQ;
  private d lJo;
  private com.tencent.mm.plugin.exdevice.b.b lJp;
  private a lJq;
  private int mErrorCode;
  
  public e(int paramInt1, long paramLong, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(19731);
    this.lJp = null;
    this.lJp = new com.tencent.mm.plugin.exdevice.b.b(paramLong, paramInt2, paramInt3, paramArrayOfByte);
    this.mErrorCode = paramInt1;
    AppMethodBeat.o(19731);
  }
  
  public final boolean a(com.tencent.mm.plugin.exdevice.service.m paramm, d paramd)
  {
    AppMethodBeat.i(19733);
    boolean bool;
    if ((-5 == this.mErrorCode) || (-3 == this.mErrorCode) || (-4 == this.mErrorCode))
    {
      ab.e("MicroMsg.exdevice.MMAuthTaskExcuter", "Error Code = %d, reply errorcode to device and close channel", new Object[] { Integer.valueOf(this.mErrorCode) });
      this.lJp.e(-1, "", new byte[0]);
      this.lJq = new a(this.lJp, paramd);
      bool = this.lJq.b(paramm);
      ab.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(19733);
      return bool;
    }
    com.tencent.mm.plugin.exdevice.h.b localb = ad.bpY().LH(this.lJp.jRn);
    if (localb == null)
    {
      ab.e("MicroMsg.exdevice.MMAuthTaskExcuter", "get device info failed : %d", new Object[] { Long.valueOf(this.lJp.jRn) });
      AppMethodBeat.o(19733);
      return false;
    }
    com.tencent.mm.plugin.exdevice.e.a locala = (com.tencent.mm.plugin.exdevice.e.a)this.lJp.bpx();
    if (locala == null)
    {
      ab.e("MicroMsg.exdevice.MMAuthTaskExcuter", "Auth Request parse failed!!!, Tell device before stop this task");
      this.lJp.e(-4, "", new byte[0]);
      this.lJq = new a(this.lJp, paramd);
      bool = this.lJq.b(paramm);
      ab.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(19733);
      return bool;
    }
    byte[] arrayOfByte1;
    long l;
    label405:
    byte[] arrayOfByte2;
    if (locala.lGD == 2)
    {
      if (locala.lGF != null)
      {
        arrayOfByte1 = locala.lGF.pW;
        if (!bo.ce(arrayOfByte1)) {
          break label405;
        }
      }
      for (l = -1L; l != this.lJp.jRn; l = com.tencent.mm.plugin.exdevice.j.b.aP(tmp413_411))
      {
        ab.e("MicroMsg.exdevice.MMAuthTaskExcuter", "Auth Request parse fail!!!, Invalid MacAddress");
        this.lJp.e(-1, "", new byte[0]);
        this.lJq = new a(this.lJp, paramd);
        bool = this.lJq.b(paramm);
        ab.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(19733);
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
    if ((locala.lGD == 1) || (locala.lGD == 1))
    {
      if ((locala.lGA == null) || (!com.tencent.mm.plugin.exdevice.j.b.c(locala.lGA.pW, 0, g.x((localb.field_deviceType + localb.field_deviceID).getBytes()))))
      {
        ab.e("MicroMsg.exdevice.MMAuthTaskExcuter", "Auth Request parse fail!!!, Invalid Md5DeviceTypeAndDeviceId");
        this.lJp.e(-1, "", new byte[0]);
        this.lJq = new a(this.lJp, paramd);
        bool = this.lJq.b(paramm);
        ab.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(19733);
        return bool;
      }
    }
    else
    {
      ab.e("MicroMsg.exdevice.MMAuthTaskExcuter", "Auth Request parse fail!!!, Invalid AuthMethod");
      this.lJp.e(-8, "", new byte[0]);
      this.lJq = new a(this.lJp, paramd);
      bool = this.lJq.b(paramm);
      ab.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(19733);
      return bool;
    }
    if (localb != null)
    {
      l = localb.dCG;
      if (System.currentTimeMillis() / 1000L < l)
      {
        ab.e("MicroMsg.exdevice.MMAuthTaskExcuter", "device has been blocked");
        this.lJp.e(-5, "", new byte[0]);
        this.lJq = new a(this.lJp, paramd);
        bool = this.lJq.b(paramm);
        ab.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(19733);
        return bool;
      }
      l = localb.dCH;
      int i = localb.dCF;
      if ((i + l > 0L) && (l + i < System.currentTimeMillis() / 1000L))
      {
        arrayOfByte1 = u.bqz().q(this.lJp.jRn, 1);
        tmp413_411 = u.bqz().q(this.lJp.jRn, 2);
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
          ab.i("MicroMsg.exdevice.MMAuthTaskExcuter", "has not reach time out, just set back sessionkey, get auth buf from local, auth buf length = %d, session key buf lenght = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          if ((arrayOfByte1 == null) || (tmp413_411 == null)) {
            break label1081;
          }
          u.bqz().jn(localb.field_mac);
          if (2 == u.bqz().jk(localb.field_mac))
          {
            ad.bqj();
            com.tencent.mm.plugin.exdevice.model.e.c(localb.field_brandName, localb.field_url, 2, localb.field_deviceID);
          }
          this.lJp.e(0, "", u.bqz().q(this.lJp.jRn, 1));
          this.lJq = new a(this.lJp, this.lJo);
          paramm.setChannelSessionKey(localb.field_mac, tmp413_411);
          bool = this.lJq.b(paramm);
          ab.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(bool) });
          AppMethodBeat.o(19733);
          return bool;
          i = arrayOfByte1.length;
          break;
        }
        label1081:
        ab.i("MicroMsg.exdevice.MMAuthTaskExcuter", "has not reach time out, but local authbuf is null, do auth from server");
      }
    }
    ab.i("MicroMsg.exdevice.MMAuthTaskExcuter", "now do really auth from server");
    this.lCQ = paramm;
    this.lJo = paramd;
    paramd = null;
    paramm = paramd;
    if (locala != null)
    {
      paramm = paramd;
      if (locala.lGE != null) {
        paramm = locala.lGE.toByteArray();
      }
    }
    aw.Rc().a(541, this);
    paramm = new r(localb.field_brandName, localb.field_deviceType, localb.field_deviceID, locala.lGC, paramm);
    aw.Rc().a(paramm, 0);
    AppMethodBeat.o(19733);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(19732);
    aw.Rc().b(541, this);
    ab.i("MicroMsg.exdevice.MMAuthTaskExcuter", "onscen end, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    paramm = (r)paramm;
    com.tencent.mm.plugin.exdevice.h.b localb = ad.bpY().LH(this.lJp.jRn);
    if (localb == null)
    {
      ab.e("MicroMsg.exdevice.MMAuthTaskExcuter", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceId Failed!!!");
      AppMethodBeat.o(19732);
      return;
    }
    long l = localb.dCG;
    if (System.currentTimeMillis() / 1000L < l)
    {
      ab.e("MicroMsg.exdevice.MMAuthTaskExcuter", "device has been blocked");
      this.lJp.e(-5, "", new byte[0]);
      this.lJq = new a(this.lJp, this.lJo);
      ab.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(this.lJq.b(this.lCQ)) });
      AppMethodBeat.o(19732);
      return;
    }
    this.lJp.e(paramInt2, paramString, paramm.bpS());
    this.lJq = new a(this.lJp, this.lJo);
    ab.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[] { Boolean.valueOf(this.lJq.b(this.lCQ)) });
    AppMethodBeat.o(19732);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.i.e
 * JD-Core Version:    0.7.0.1
 */