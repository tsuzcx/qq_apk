package com.tencent.mm.app.plugin;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.e.a;
import com.tencent.mm.plugin.story.api.n;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.pluginsdk.v;

@URISpanHandlerSet.a
class URISpanHandlerSet$StoryEntranceHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$StoryEntranceHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final int[] Cf()
  {
    return new int[] { 48 };
  }
  
  final boolean a(m paramm, g paramg)
  {
    AppMethodBeat.i(15713);
    if (paramm.type == 48)
    {
      String str = paramm.username;
      if (TextUtils.isEmpty(str))
      {
        AppMethodBeat.o(15713);
        return false;
      }
      if (a.ZS(str)) {
        n.aS(URISpanHandlerSet.a(this.cam), str);
      }
      if (paramg != null) {
        paramg.b(paramm);
      }
      AppMethodBeat.o(15713);
      return true;
    }
    AppMethodBeat.o(15713);
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, v paramv, Bundle paramBundle)
  {
    return false;
  }
  
  final m dN(String paramString)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.StoryEntranceHandler
 * JD-Core Version:    0.7.0.1
 */