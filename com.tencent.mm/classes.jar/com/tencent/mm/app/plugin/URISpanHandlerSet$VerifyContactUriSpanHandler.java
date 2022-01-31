package com.tencent.mm.app.plugin;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.pluginsdk.v;

@URISpanHandlerSet.a
class URISpanHandlerSet$VerifyContactUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$VerifyContactUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final int[] Cf()
  {
    return new int[] { 4 };
  }
  
  final boolean a(m paramm, g paramg)
  {
    AppMethodBeat.i(15719);
    if (paramm.type == 4)
    {
      if (paramg != null)
      {
        paramg.a(paramm);
        paramg.b(paramm);
      }
      AppMethodBeat.o(15719);
      return true;
    }
    AppMethodBeat.o(15719);
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, v paramv, Bundle paramBundle)
  {
    return false;
  }
  
  final m dN(String paramString)
  {
    AppMethodBeat.i(15718);
    if (paramString.trim().startsWith("weixin://findfriend/verifycontact"))
    {
      paramString = new m(paramString, 4, null);
      AppMethodBeat.o(15718);
      return paramString;
    }
    AppMethodBeat.o(15718);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.VerifyContactUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */