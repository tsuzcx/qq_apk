package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.c.c;
import com.tencent.mm.plugin.exdevice.c.e;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;

public final class f
  extends com.tencent.mm.plugin.exdevice.model.ae
{
  private int mErrorCode;
  private e qnx;
  private a qny;
  
  public f(int paramInt1, long paramLong, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23802);
    this.qnx = new e(paramLong, paramInt2, paramInt3, paramArrayOfByte);
    this.mErrorCode = paramInt1;
    AppMethodBeat.o(23802);
  }
  
  public final boolean a(m paramm, d paramd)
  {
    AppMethodBeat.i(23803);
    boolean bool;
    if (!u.cnk().uY(this.qnx.nZd))
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.exdevice.MMInitTaskExcuter", "This device send other cmd before do auth, device id = %d", new Object[] { Long.valueOf(this.qnx.nZd) });
      this.qnx.a(-2, "", new byte[0], new byte[0], 0, 0);
      this.qny = new a(this.qnx, paramd);
      bool = this.qny.b(paramm);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.MMInitTaskExcuter", "init start task : %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(23803);
      return bool;
    }
    if ((-5 == this.mErrorCode) || (-3 == this.mErrorCode) || (-4 == this.mErrorCode))
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.exdevice.MMInitTaskExcuter", "Error Code = %d, reply errorcode to device and close channel", new Object[] { Integer.valueOf(this.mErrorCode) });
      this.qnx.a(-1, "", new byte[0], new byte[0], 0, 0);
      this.qny = new a(this.qnx, paramd);
      bool = this.qny.b(paramm);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.MMInitTaskExcuter", "init start task : %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(23803);
      return bool;
    }
    Object localObject = (com.tencent.mm.plugin.exdevice.f.f)this.qnx.cmh();
    if (localObject == null)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.exdevice.MMInitTaskExcuter", "Init Request parse failed, Tell device before stop this task");
      this.qnx.a(-4, "", new byte[0], new byte[0], 0, 0);
      this.qny = new a(this.qnx, paramd);
      bool = this.qny.b(paramm);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.MMInitTaskExcuter", "init start task : %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(23803);
      return bool;
    }
    if (((com.tencent.mm.plugin.exdevice.f.f)localObject).qkT != null) {}
    for (byte[] arrayOfByte = ((com.tencent.mm.plugin.exdevice.f.f)localObject).qkT.toByteArray();; arrayOfByte = null)
    {
      if (((com.tencent.mm.plugin.exdevice.f.f)localObject).qkS != null) {}
      for (localObject = ((com.tencent.mm.plugin.exdevice.f.f)localObject).qkS.toByteArray();; localObject = null)
      {
        ad.cmQ();
        int i = com.tencent.mm.plugin.exdevice.model.d.cmr();
        switch (i)
        {
        default: 
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.exdevice.MMInitTaskExcuter", "initScene = %d, Cannot start init response", new Object[] { Integer.valueOf(i) });
        }
        this.qnx.a(0, null, (byte[])localObject, arrayOfByte, i, (int)(com.tencent.mm.plugin.exdevice.k.b.cnX() / 1000L));
        this.qny = new a(this.qnx, paramd);
        bool = this.qny.b(paramm);
        AppMethodBeat.o(23803);
        return bool;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.f
 * JD-Core Version:    0.7.0.1
 */