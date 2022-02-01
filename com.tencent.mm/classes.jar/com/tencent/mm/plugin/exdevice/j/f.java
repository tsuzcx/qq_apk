package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.c.c;
import com.tencent.mm.plugin.exdevice.c.e;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.Log;

public final class f
  extends ae
{
  private int mErrorCode;
  private e rEE;
  private a rEF;
  
  public f(int paramInt1, long paramLong, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23802);
    this.rEE = new e(paramLong, paramInt2, paramInt3, paramArrayOfByte);
    this.mErrorCode = paramInt1;
    AppMethodBeat.o(23802);
  }
  
  public final boolean a(m paramm, d paramd)
  {
    AppMethodBeat.i(23803);
    boolean bool;
    if (!u.cLx().Dc(this.rEE.pkb))
    {
      Log.e("MicroMsg.exdevice.MMInitTaskExcuter", "This device send other cmd before do auth, device id = %d", new Object[] { Long.valueOf(this.rEE.pkb) });
      this.rEE.a(-2, "", new byte[0], new byte[0], 0, 0);
      this.rEF = new a(this.rEE, paramd);
      bool = this.rEF.b(paramm);
      Log.i("MicroMsg.exdevice.MMInitTaskExcuter", "init start task : %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(23803);
      return bool;
    }
    if ((-5 == this.mErrorCode) || (-3 == this.mErrorCode) || (-4 == this.mErrorCode))
    {
      Log.e("MicroMsg.exdevice.MMInitTaskExcuter", "Error Code = %d, reply errorcode to device and close channel", new Object[] { Integer.valueOf(this.mErrorCode) });
      this.rEE.a(-1, "", new byte[0], new byte[0], 0, 0);
      this.rEF = new a(this.rEE, paramd);
      bool = this.rEF.b(paramm);
      Log.i("MicroMsg.exdevice.MMInitTaskExcuter", "init start task : %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(23803);
      return bool;
    }
    Object localObject = (com.tencent.mm.plugin.exdevice.f.f)this.rEE.cKj();
    if (localObject == null)
    {
      Log.e("MicroMsg.exdevice.MMInitTaskExcuter", "Init Request parse failed, Tell device before stop this task");
      this.rEE.a(-4, "", new byte[0], new byte[0], 0, 0);
      this.rEF = new a(this.rEE, paramd);
      bool = this.rEF.b(paramm);
      Log.i("MicroMsg.exdevice.MMInitTaskExcuter", "init start task : %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(23803);
      return bool;
    }
    if (((com.tencent.mm.plugin.exdevice.f.f)localObject).rBO != null) {}
    for (byte[] arrayOfByte = ((com.tencent.mm.plugin.exdevice.f.f)localObject).rBO.toByteArray();; arrayOfByte = null)
    {
      if (((com.tencent.mm.plugin.exdevice.f.f)localObject).rBN != null) {}
      for (localObject = ((com.tencent.mm.plugin.exdevice.f.f)localObject).rBN.toByteArray();; localObject = null)
      {
        ad.cKS();
        int i = com.tencent.mm.plugin.exdevice.model.d.cKt();
        switch (i)
        {
        default: 
          Log.e("MicroMsg.exdevice.MMInitTaskExcuter", "initScene = %d, Cannot start init response", new Object[] { Integer.valueOf(i) });
        }
        this.rEE.a(0, null, (byte[])localObject, arrayOfByte, i, (int)(com.tencent.mm.plugin.exdevice.k.b.cMj() / 1000L));
        this.rEF = new a(this.rEE, paramd);
        bool = this.rEF.b(paramm);
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