package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.c.c;
import com.tencent.mm.plugin.exdevice.c.e;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.ac;

public final class f
  extends ae
{
  private int mErrorCode;
  private e pDn;
  private a pDo;
  
  public f(int paramInt1, long paramLong, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23802);
    this.pDn = new e(paramLong, paramInt2, paramInt3, paramArrayOfByte);
    this.mErrorCode = paramInt1;
    AppMethodBeat.o(23802);
  }
  
  public final boolean a(m paramm, d paramd)
  {
    AppMethodBeat.i(23803);
    boolean bool;
    if (!u.chq().sJ(this.pDn.nsB))
    {
      ac.e("MicroMsg.exdevice.MMInitTaskExcuter", "This device send other cmd before do auth, device id = %d", new Object[] { Long.valueOf(this.pDn.nsB) });
      this.pDn.a(-2, "", new byte[0], new byte[0], 0, 0);
      this.pDo = new a(this.pDn, paramd);
      bool = this.pDo.b(paramm);
      ac.i("MicroMsg.exdevice.MMInitTaskExcuter", "init start task : %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(23803);
      return bool;
    }
    if ((-5 == this.mErrorCode) || (-3 == this.mErrorCode) || (-4 == this.mErrorCode))
    {
      ac.e("MicroMsg.exdevice.MMInitTaskExcuter", "Error Code = %d, reply errorcode to device and close channel", new Object[] { Integer.valueOf(this.mErrorCode) });
      this.pDn.a(-1, "", new byte[0], new byte[0], 0, 0);
      this.pDo = new a(this.pDn, paramd);
      bool = this.pDo.b(paramm);
      ac.i("MicroMsg.exdevice.MMInitTaskExcuter", "init start task : %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(23803);
      return bool;
    }
    Object localObject = (com.tencent.mm.plugin.exdevice.f.f)this.pDn.cgn();
    if (localObject == null)
    {
      ac.e("MicroMsg.exdevice.MMInitTaskExcuter", "Init Request parse failed, Tell device before stop this task");
      this.pDn.a(-4, "", new byte[0], new byte[0], 0, 0);
      this.pDo = new a(this.pDn, paramd);
      bool = this.pDo.b(paramm);
      ac.i("MicroMsg.exdevice.MMInitTaskExcuter", "init start task : %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(23803);
      return bool;
    }
    if (((com.tencent.mm.plugin.exdevice.f.f)localObject).pAJ != null) {}
    for (byte[] arrayOfByte = ((com.tencent.mm.plugin.exdevice.f.f)localObject).pAJ.toByteArray();; arrayOfByte = null)
    {
      if (((com.tencent.mm.plugin.exdevice.f.f)localObject).pAI != null) {}
      for (localObject = ((com.tencent.mm.plugin.exdevice.f.f)localObject).pAI.toByteArray();; localObject = null)
      {
        ad.cgW();
        int i = com.tencent.mm.plugin.exdevice.model.d.cgx();
        switch (i)
        {
        default: 
          ac.e("MicroMsg.exdevice.MMInitTaskExcuter", "initScene = %d, Cannot start init response", new Object[] { Integer.valueOf(i) });
        }
        this.pDn.a(0, null, (byte[])localObject, arrayOfByte, i, (int)(com.tencent.mm.plugin.exdevice.k.b.cid() / 1000L));
        this.pDo = new a(this.pDn, paramd);
        bool = this.pDo.b(paramm);
        AppMethodBeat.o(23803);
        return bool;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.f
 * JD-Core Version:    0.7.0.1
 */