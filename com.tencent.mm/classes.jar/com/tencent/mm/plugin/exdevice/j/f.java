package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.c.c;
import com.tencent.mm.plugin.exdevice.c.e;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;

public final class f
  extends ae
{
  private int mErrorCode;
  private e qgS;
  private a qgT;
  
  public f(int paramInt1, long paramLong, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23802);
    this.qgS = new e(paramLong, paramInt2, paramInt3, paramArrayOfByte);
    this.mErrorCode = paramInt1;
    AppMethodBeat.o(23802);
  }
  
  public final boolean a(m paramm, d paramd)
  {
    AppMethodBeat.i(23803);
    boolean bool;
    if (!u.clU().uH(this.qgS.nTx))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.MMInitTaskExcuter", "This device send other cmd before do auth, device id = %d", new Object[] { Long.valueOf(this.qgS.nTx) });
      this.qgS.a(-2, "", new byte[0], new byte[0], 0, 0);
      this.qgT = new a(this.qgS, paramd);
      bool = this.qgT.b(paramm);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.MMInitTaskExcuter", "init start task : %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(23803);
      return bool;
    }
    if ((-5 == this.mErrorCode) || (-3 == this.mErrorCode) || (-4 == this.mErrorCode))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.MMInitTaskExcuter", "Error Code = %d, reply errorcode to device and close channel", new Object[] { Integer.valueOf(this.mErrorCode) });
      this.qgS.a(-1, "", new byte[0], new byte[0], 0, 0);
      this.qgT = new a(this.qgS, paramd);
      bool = this.qgT.b(paramm);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.MMInitTaskExcuter", "init start task : %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(23803);
      return bool;
    }
    Object localObject = (com.tencent.mm.plugin.exdevice.f.f)this.qgS.ckR();
    if (localObject == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.MMInitTaskExcuter", "Init Request parse failed, Tell device before stop this task");
      this.qgS.a(-4, "", new byte[0], new byte[0], 0, 0);
      this.qgT = new a(this.qgS, paramd);
      bool = this.qgT.b(paramm);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.MMInitTaskExcuter", "init start task : %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(23803);
      return bool;
    }
    if (((com.tencent.mm.plugin.exdevice.f.f)localObject).qeo != null) {}
    for (byte[] arrayOfByte = ((com.tencent.mm.plugin.exdevice.f.f)localObject).qeo.toByteArray();; arrayOfByte = null)
    {
      if (((com.tencent.mm.plugin.exdevice.f.f)localObject).qen != null) {}
      for (localObject = ((com.tencent.mm.plugin.exdevice.f.f)localObject).qen.toByteArray();; localObject = null)
      {
        com.tencent.mm.plugin.exdevice.model.ad.clA();
        int i = com.tencent.mm.plugin.exdevice.model.d.clb();
        switch (i)
        {
        default: 
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.MMInitTaskExcuter", "initScene = %d, Cannot start init response", new Object[] { Integer.valueOf(i) });
        }
        this.qgS.a(0, null, (byte[])localObject, arrayOfByte, i, (int)(com.tencent.mm.plugin.exdevice.k.b.cmH() / 1000L));
        this.qgT = new a(this.qgS, paramd);
        bool = this.qgT.b(paramm);
        AppMethodBeat.o(23803);
        return bool;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.f
 * JD-Core Version:    0.7.0.1
 */