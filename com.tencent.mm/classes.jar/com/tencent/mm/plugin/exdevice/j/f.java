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
  private e pac;
  private a pad;
  
  public f(int paramInt1, long paramLong, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23802);
    this.pac = new e(paramLong, paramInt2, paramInt3, paramArrayOfByte);
    this.mErrorCode = paramInt1;
    AppMethodBeat.o(23802);
  }
  
  public final boolean a(m paramm, d paramd)
  {
    AppMethodBeat.i(23803);
    boolean bool;
    if (!u.cah().oX(this.pac.mQq))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.MMInitTaskExcuter", "This device send other cmd before do auth, device id = %d", new Object[] { Long.valueOf(this.pac.mQq) });
      this.pac.a(-2, "", new byte[0], new byte[0], 0, 0);
      this.pad = new a(this.pac, paramd);
      bool = this.pad.b(paramm);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.MMInitTaskExcuter", "init start task : %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(23803);
      return bool;
    }
    if ((-5 == this.mErrorCode) || (-3 == this.mErrorCode) || (-4 == this.mErrorCode))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.MMInitTaskExcuter", "Error Code = %d, reply errorcode to device and close channel", new Object[] { Integer.valueOf(this.mErrorCode) });
      this.pac.a(-1, "", new byte[0], new byte[0], 0, 0);
      this.pad = new a(this.pac, paramd);
      bool = this.pad.b(paramm);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.MMInitTaskExcuter", "init start task : %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(23803);
      return bool;
    }
    Object localObject = (com.tencent.mm.plugin.exdevice.f.f)this.pac.bZe();
    if (localObject == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.MMInitTaskExcuter", "Init Request parse failed, Tell device before stop this task");
      this.pac.a(-4, "", new byte[0], new byte[0], 0, 0);
      this.pad = new a(this.pac, paramd);
      bool = this.pad.b(paramm);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.MMInitTaskExcuter", "init start task : %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(23803);
      return bool;
    }
    if (((com.tencent.mm.plugin.exdevice.f.f)localObject).oXy != null) {}
    for (byte[] arrayOfByte = ((com.tencent.mm.plugin.exdevice.f.f)localObject).oXy.toByteArray();; arrayOfByte = null)
    {
      if (((com.tencent.mm.plugin.exdevice.f.f)localObject).oXx != null) {}
      for (localObject = ((com.tencent.mm.plugin.exdevice.f.f)localObject).oXx.toByteArray();; localObject = null)
      {
        com.tencent.mm.plugin.exdevice.model.ad.bZN();
        int i = com.tencent.mm.plugin.exdevice.model.d.bZo();
        switch (i)
        {
        default: 
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.MMInitTaskExcuter", "initScene = %d, Cannot start init response", new Object[] { Integer.valueOf(i) });
        }
        this.pac.a(0, null, (byte[])localObject, arrayOfByte, i, (int)(com.tencent.mm.plugin.exdevice.k.b.caU() / 1000L));
        this.pad = new a(this.pac, paramd);
        bool = this.pad.b(paramm);
        AppMethodBeat.o(23803);
        return bool;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.f
 * JD-Core Version:    0.7.0.1
 */