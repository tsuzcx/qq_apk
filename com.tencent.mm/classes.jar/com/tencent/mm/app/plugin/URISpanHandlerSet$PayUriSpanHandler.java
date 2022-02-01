package com.tencent.mm.app.plugin;

import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.je;
import com.tencent.mm.g.a.je.a;
import com.tencent.mm.pluginsdk.ui.span.i;
import com.tencent.mm.sdk.event.EventCenter;

@URISpanHandlerSet.a
class URISpanHandlerSet$PayUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$PayUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final int[] Xp()
  {
    return new int[] { 28 };
  }
  
  final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami)
  {
    AppMethodBeat.i(231443);
    if (paramu.type == 28)
    {
      if (parami != null) {
        parami.a(paramu);
      }
      paramView = new je();
      paramView.dNT.actionCode = 11;
      paramView.dNT.result = paramu.url;
      paramView.dNT.context = URISpanHandlerSet.a(this.dnW);
      paramView.dNT.dNV = new Bundle();
      paramView.dNT.dNV.putInt("pay_channel", 6);
      EventCenter.instance.asyncPublish(paramView, Looper.myLooper());
      if (parami != null) {
        parami.b(paramu);
      }
      AppMethodBeat.o(231443);
      return true;
    }
    AppMethodBeat.o(231443);
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
  {
    return false;
  }
  
  final com.tencent.mm.pluginsdk.ui.applet.u gx(String paramString)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.PayUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */