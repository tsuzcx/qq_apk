package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.p;
import d.g.b.y.f;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
final class l$a$d
  implements Runnable
{
  l$a$d(y.f paramf, Context paramContext) {}
  
  public final void run()
  {
    AppMethodBeat.i(205892);
    this.sVS.NiY = p.a(this.crf, (CharSequence)this.crf.getResources().getString(2131755936), true, 0, (DialogInterface.OnCancelListener)1.thS);
    AppMethodBeat.o(205892);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.l.a.d
 * JD-Core Version:    0.7.0.1
 */