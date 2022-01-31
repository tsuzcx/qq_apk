package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.plugin.exdevice.b.f;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.sdk.platformtools.y;

public final class h
  extends ae
{
  private f jti;
  private a jzW;
  
  public h(f paramf)
  {
    this.jti = paramf;
  }
  
  public final boolean a(m paramm, d paramd)
  {
    this.jzW = new a(this.jti, paramd);
    boolean bool = this.jzW.b(paramm);
    y.i("MicroMsg.exdevice.MMSendDataToDeviceExcuter", "send data to devide : %b", new Object[] { Boolean.valueOf(bool) });
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.i.h
 * JD-Core Version:    0.7.0.1
 */