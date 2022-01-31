package com.tencent.mm.app.plugin;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.pluginsdk.v;

@URISpanHandlerSet.a
class URISpanHandlerSet$CardUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$CardUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final int[] Cf()
  {
    return new int[0];
  }
  
  final boolean a(m paramm, g paramg)
  {
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, v paramv, Bundle paramBundle)
  {
    AppMethodBeat.i(15641);
    if (paramString.startsWith("wxcard://cardjumptype=1"))
    {
      paramString = null;
      if (paramv != null) {
        paramString = paramv.dkU().toString();
      }
      paramv = new Intent();
      paramv.putExtra("user_name", paramString);
      paramv.putExtra("view_type", 1);
      d.b(URISpanHandlerSet.a(this.cam), "card", ".ui.CardViewUI", paramv);
      AppMethodBeat.o(15641);
      return true;
    }
    AppMethodBeat.o(15641);
    return false;
  }
  
  final m dN(String paramString)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.CardUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */