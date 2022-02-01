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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/live/view/LiveVisitorPluginLayout$handleJoinLiveErr$clickSpan$1", "Lcom/tencent/mm/plugin/messenger/api/AvoidDuplicatedPressableSpan;", "onClickImp", "", "widget", "Landroid/view/View;", "plugin-logic_release"})
public final class LiveVisitorPluginLayout$j
  extends a
{
  LiveVisitorPluginLayout$j(int paramInt) {}
  
  public final void onClickImp(View paramView)
  {
    AppMethodBeat.i(208603);
    p.h(paramView, "widget");
    paramView = new Intent();
    o.a locala = o.hGl;
    paramView.putExtra("rawUrl", o.aFj());
    paramView.putExtra("showShare", false);
    c.f(this.hXf.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramView);
    AppMethodBeat.o(208603);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.view.LiveVisitorPluginLayout.j
 * JD-Core Version:    0.7.0.1
 */