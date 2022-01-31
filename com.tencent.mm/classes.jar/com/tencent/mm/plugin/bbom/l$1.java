package com.tencent.mm.plugin.bbom;

import com.tencent.mm.h.a.kd;
import com.tencent.mm.model.am.b.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.storage.u;

final class l$1
  implements am.b.a
{
  l$1(l paraml, u paramu, String paramString) {}
  
  public final void m(String paramString, boolean paramBoolean)
  {
    if ((this.dAz != null) && (this.dAz.ctO()))
    {
      paramString = new kd();
      paramString.bSY.chatroomName = this.dUz;
      paramString.bSY.bSZ = this.dAz.ctN();
      a.udP.m(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.l.1
 * JD-Core Version:    0.7.0.1
 */