package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.gdpr.b;

final class a$3$1$2
  implements b
{
  a$3$1$2(a.3.1 param1, Runnable paramRunnable) {}
  
  public final void kK(int paramInt)
  {
    AppMethodBeat.i(132051);
    if (paramInt == 0)
    {
      this.inU.run();
      AppMethodBeat.o(132051);
      return;
    }
    com.tencent.mm.plugin.appbrand.ipc.a.a(this.inT.inS.inO.getBaseContext(), this.inT.inS.inO.getBaseContext().getString(2131297148), this.inT.inS.inO.getBaseContext().getString(2131297149), this.inT.inS.inO.getBaseContext().getString(2131297018), null, null, null, null);
    this.inT.inS.inO.finish();
    AppMethodBeat.o(132051);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.precondition.a.3.1.2
 * JD-Core Version:    0.7.0.1
 */