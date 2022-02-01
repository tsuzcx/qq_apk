package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.p;
import d.g.b.y.f;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
final class a$b
  implements Runnable
{
  a$b(y.f paramf, Context paramContext) {}
  
  public final void run()
  {
    AppMethodBeat.i(205016);
    this.sVS.NiY = p.a(this.crf, (CharSequence)this.crf.getResources().getString(2131755936), false, 0, (DialogInterface.OnCancelListener)1.sVV);
    AppMethodBeat.o(205016);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.a.b
 * JD-Core Version:    0.7.0.1
 */