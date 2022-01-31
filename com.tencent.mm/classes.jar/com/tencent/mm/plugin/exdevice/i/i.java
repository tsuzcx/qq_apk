package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.plugin.exdevice.b.c;
import com.tencent.mm.plugin.exdevice.b.g;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.y;

public final class i
  extends ae
{
  private a jzV;
  private g jzX;
  
  public i(int paramInt)
  {
    this.jzX = new g(paramInt);
  }
  
  public final boolean a(m paramm, d paramd)
  {
    if (!u.aMm().dX(this.jzX.hXu))
    {
      y.w("MicroMsg.exdevice.MMSwitchBackGroudTaskExcuter", "push switch backgroud event to device before it do auth, device id = %d", new Object[] { Long.valueOf(this.jzX.hXu) });
      return true;
    }
    this.jzV = new a(this.jzX, paramd);
    return this.jzV.b(paramm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.i.i
 * JD-Core Version:    0.7.0.1
 */