package com.tencent.mm.live.view;

import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.live.b.f;
import com.tencent.mm.live.b.f.a;
import com.tencent.mm.plugin.messenger.a.a;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/live/view/LiveVisitorPluginLayout$handleJoinLiveErr$clickSpan$1", "Lcom/tencent/mm/plugin/messenger/api/AvoidDuplicatedPressableSpan;", "onClickImp", "", "widget", "Landroid/view/View;", "plugin-logic_release"})
public final class LiveVisitorPluginLayout$j
  extends a
{
  LiveVisitorPluginLayout$j(int paramInt) {}
  
  public final void onClickImp(View paramView)
  {
    AppMethodBeat.i(216640);
    p.h(paramView, "widget");
    paramView = new Intent();
    f.a locala = f.gPE;
    paramView.putExtra("rawUrl", f.anj());
    paramView.putExtra("showShare", false);
    d.f(this.hev.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramView);
    AppMethodBeat.o(216640);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.view.LiveVisitorPluginLayout.j
 * JD-Core Version:    0.7.0.1
 */