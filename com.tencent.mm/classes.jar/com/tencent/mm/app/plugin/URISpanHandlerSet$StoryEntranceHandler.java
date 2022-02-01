package com.tencent.mm.app.plugin;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.f.a;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.pluginsdk.ui.span.i;

@URISpanHandlerSet.a
class URISpanHandlerSet$StoryEntranceHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$StoryEntranceHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami)
  {
    AppMethodBeat.i(285996);
    if (paramu.type == 48)
    {
      paramView = paramu.username;
      if (TextUtils.isEmpty(paramView))
      {
        AppMethodBeat.o(285996);
        return false;
      }
      if (a.aZA(paramView)) {
        o.bP(URISpanHandlerSet.a(this.fgB), paramView);
      }
      if (parami != null) {
        parami.b(paramu);
      }
      AppMethodBeat.o(285996);
      return true;
    }
    AppMethodBeat.o(285996);
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
  {
    return false;
  }
  
  final int[] abR()
  {
    return new int[] { 48 };
  }
  
  final com.tencent.mm.pluginsdk.ui.applet.u hi(String paramString)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.StoryEntranceHandler
 * JD-Core Version:    0.7.0.1
 */