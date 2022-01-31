package com.tencent.mm.plugin.exdevice.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.b.c;
import com.tencent.mm.plugin.exdevice.b.e;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.ab;

public final class f
  extends ae
{
  private e lJr;
  private a lJs;
  private int mErrorCode;
  
  public f(int paramInt1, long paramLong, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(19734);
    this.lJr = new e(paramLong, paramInt2, paramInt3, paramArrayOfByte);
    this.mErrorCode = paramInt1;
    AppMethodBeat.o(19734);
  }
  
  public final boolean a(m paramm, d paramd)
  {
    AppMethodBeat.i(19735);
    boolean bool;
    if (!u.bqz().jp(this.lJr.jRn))
    {
      ab.e("MicroMsg.exdevice.MMInitTaskExcuter", "This device send other cmd before do auth, device id = %d", new Object[] { Long.valueOf(this.lJr.jRn) });
      this.lJr.a(-2, "", new byte[0], new byte[0], 0, 0);
      this.lJs = new a(this.lJr, paramd);
      bool = this.lJs.b(paramm);
      ab.i("MicroMsg.exdevice.MMInitTaskExcuter", "init start task : %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(19735);
      return bool;
    }
    if ((-5 == this.mErrorCode) || (-3 == this.mErrorCode) || (-4 == this.mErrorCode))
    {
      ab.e("MicroMsg.exdevice.MMInitTaskExcuter", "Error Code = %d, reply errorcode to device and close channel", new Object[] { Integer.valueOf(this.mErrorCode) });
      this.lJr.a(-1, "", new byte[0], new byte[0], 0, 0);
      this.lJs = new a(this.lJr, paramd);
      bool = this.lJs.b(paramm);
      ab.i("MicroMsg.exdevice.MMInitTaskExcuter", "init start task : %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(19735);
      return bool;
    }
    Object localObject = (com.tencent.mm.plugin.exdevice.e.f)this.lJr.bpx();
    if (localObject == null)
    {
      ab.e("MicroMsg.exdevice.MMInitTaskExcuter", "Init Request parse failed, Tell device before stop this task");
      this.lJr.a(-4, "", new byte[0], new byte[0], 0, 0);
      this.lJs = new a(this.lJr, paramd);
      bool = this.lJs.b(paramm);
      ab.i("MicroMsg.exdevice.MMInitTaskExcuter", "init start task : %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(19735);
      return bool;
    }
    if (((com.tencent.mm.plugin.exdevice.e.f)localObject).lGN != null) {}
    for (byte[] arrayOfByte = ((com.tencent.mm.plugin.exdevice.e.f)localObject).lGN.toByteArray();; arrayOfByte = null)
    {
      if (((com.tencent.mm.plugin.exdevice.e.f)localObject).lGM != null) {}
      for (localObject = ((com.tencent.mm.plugin.exdevice.e.f)localObject).lGM.toByteArray();; localObject = null)
      {
        ad.bqf();
        int i = com.tencent.mm.plugin.exdevice.model.d.bpH();
        switch (i)
        {
        default: 
          ab.e("MicroMsg.exdevice.MMInitTaskExcuter", "initScene = %d, Cannot start init response", new Object[] { Integer.valueOf(i) });
        }
        this.lJr.a(0, null, (byte[])localObject, arrayOfByte, i, (int)(com.tencent.mm.plugin.exdevice.j.b.brl() / 1000L));
        this.lJs = new a(this.lJr, paramd);
        bool = this.lJs.b(paramm);
        AppMethodBeat.o(19735);
        return bool;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.i.f
 * JD-Core Version:    0.7.0.1
 */