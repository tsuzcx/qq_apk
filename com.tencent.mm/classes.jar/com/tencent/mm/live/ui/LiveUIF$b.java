package com.tencent.mm.live.ui;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.n.c;
import d.g.b.k;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
final class LiveUIF$b
  implements n.c
{
  LiveUIF$b(LiveUIF paramLiveUIF) {}
  
  public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
  {
    AppMethodBeat.i(203293);
    AppCompatActivity localAppCompatActivity = this.KyN.getContext();
    k.g(localAppCompatActivity, "context");
    paraml.c(0, (CharSequence)localAppCompatActivity.getResources().getString(2131766583));
    localAppCompatActivity = this.KyN.getContext();
    k.g(localAppCompatActivity, "context");
    paraml.c(1, (CharSequence)localAppCompatActivity.getResources().getString(2131766558));
    AppMethodBeat.o(203293);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.ui.LiveUIF.b
 * JD-Core Version:    0.7.0.1
 */