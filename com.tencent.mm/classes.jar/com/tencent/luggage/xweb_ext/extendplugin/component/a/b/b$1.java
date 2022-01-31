package com.tencent.luggage.xweb_ext.extendplugin.component.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class b$1
  implements Runnable
{
  b$1(b paramb, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(139820);
    b.a(this.bHt, this.bHs);
    ab.i("TXLivePusherJSAdapter", "notifyOrientationChanged, angle:" + this.bHs + ", orientation:" + b.a(this.bHt));
    b.a(this.bHt, this.bHs, b.a(this.bHt));
    AppMethodBeat.o(139820);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.a.b.b.1
 * JD-Core Version:    0.7.0.1
 */