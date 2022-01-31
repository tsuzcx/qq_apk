package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.plugin.exdevice.b.c;
import com.tencent.mm.plugin.exdevice.b.e;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.y;

public final class f
  extends ae
{
  private e jzS;
  private a jzT;
  private int mErrorCode;
  
  public f(int paramInt1, long paramLong, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    this.jzS = new e(paramLong, paramInt2, paramInt3, paramArrayOfByte);
    this.mErrorCode = paramInt1;
  }
  
  public final boolean a(m paramm, d paramd)
  {
    boolean bool;
    if (!u.aMm().dX(this.jzS.hXu))
    {
      y.e("MicroMsg.exdevice.MMInitTaskExcuter", "This device send other cmd before do auth, device id = %d", new Object[] { Long.valueOf(this.jzS.hXu) });
      this.jzS.a(-2, "", new byte[0], new byte[0], 0, 0);
      this.jzT = new a(this.jzS, paramd);
      bool = this.jzT.b(paramm);
      y.i("MicroMsg.exdevice.MMInitTaskExcuter", "init start task : %b", new Object[] { Boolean.valueOf(bool) });
      return bool;
    }
    if ((-5 == this.mErrorCode) || (-3 == this.mErrorCode) || (-4 == this.mErrorCode))
    {
      y.e("MicroMsg.exdevice.MMInitTaskExcuter", "Error Code = %d, reply errorcode to device and close channel", new Object[] { Integer.valueOf(this.mErrorCode) });
      this.jzS.a(-1, "", new byte[0], new byte[0], 0, 0);
      this.jzT = new a(this.jzS, paramd);
      bool = this.jzT.b(paramm);
      y.i("MicroMsg.exdevice.MMInitTaskExcuter", "init start task : %b", new Object[] { Boolean.valueOf(bool) });
      return bool;
    }
    Object localObject = (com.tencent.mm.plugin.exdevice.e.f)this.jzS.aLk();
    if (localObject == null)
    {
      y.e("MicroMsg.exdevice.MMInitTaskExcuter", "Init Request parse failed, Tell device before stop this task");
      this.jzS.a(-4, "", new byte[0], new byte[0], 0, 0);
      this.jzT = new a(this.jzS, paramd);
      bool = this.jzT.b(paramm);
      y.i("MicroMsg.exdevice.MMInitTaskExcuter", "init start task : %b", new Object[] { Boolean.valueOf(bool) });
      return bool;
    }
    if (((com.tencent.mm.plugin.exdevice.e.f)localObject).jxo != null) {}
    for (byte[] arrayOfByte = ((com.tencent.mm.plugin.exdevice.e.f)localObject).jxo.toByteArray();; arrayOfByte = null)
    {
      if (((com.tencent.mm.plugin.exdevice.e.f)localObject).jxn != null) {}
      for (localObject = ((com.tencent.mm.plugin.exdevice.e.f)localObject).jxn.toByteArray();; localObject = null)
      {
        ad.aLS();
        int i = com.tencent.mm.plugin.exdevice.model.d.aLt();
        switch (i)
        {
        default: 
          y.e("MicroMsg.exdevice.MMInitTaskExcuter", "initScene = %d, Cannot start init response", new Object[] { Integer.valueOf(i) });
        }
        this.jzS.a(0, null, (byte[])localObject, arrayOfByte, i, (int)(com.tencent.mm.plugin.exdevice.j.b.aMX() / 1000L));
        this.jzT = new a(this.jzS, paramd);
        return this.jzT.b(paramm);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.i.f
 * JD-Core Version:    0.7.0.1
 */