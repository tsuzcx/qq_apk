package com.tencent.mm.live.view;

import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.live.b.o;
import com.tencent.mm.live.b.o.a;
import com.tencent.mm.plugin.messenger.a.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/live/view/LiveAnchorPluginLayout$createNewLive$1$clickSpan$1", "Lcom/tencent/mm/plugin/messenger/api/AvoidDuplicatedPressableSpan;", "onClickImp", "", "widget", "Landroid/view/View;", "plugin-logic_release"})
public final class LiveAnchorPluginLayout$b$a
  extends a
{
  LiveAnchorPluginLayout$b$a(int paramInt) {}
  
  public final void onClickImp(View paramView)
  {
    AppMethodBeat.i(208498);
    p.h(paramView, "widget");
    paramView = new Intent();
    o.a locala = o.hGl;
    paramView.putExtra("rawUrl", o.aFj());
    paramView.putExtra("showShare", false);
    c.f(this.hWm.hWk.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramView);
    AppMethodBeat.o(208498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.view.LiveAnchorPluginLayout.b.a
 * JD-Core Version:    0.7.0.1
 */