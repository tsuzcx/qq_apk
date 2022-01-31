package com.tencent.mm.app.plugin;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.a.b.a;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.pluginsdk.v;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

@URISpanHandlerSet.a
class URISpanHandlerSet$UnKnowToUrlSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$UnKnowToUrlSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final int[] Cf()
  {
    return new int[] { 2147483646 };
  }
  
  final boolean a(m paramm, g paramg)
  {
    AppMethodBeat.i(15717);
    if (paramm.type == 2147483646)
    {
      if ((paramm.data instanceof Bundle))
      {
        paramm = ((Bundle)paramm.data).getString("rawUrl");
        if (bo.isNullOrNil(paramm)) {
          ab.i("MicroMsg.URISpanHandlerSet", "TYPE_UNKNOW_TO_URL url == null");
        }
      }
      for (;;)
      {
        AppMethodBeat.o(15717);
        return true;
        a.b(ah.getContext(), paramm, 0, true);
        continue;
        ab.i("MicroMsg.URISpanHandlerSet", "TYPE_UNKNOW_TO_URL hrefInfo.getData() no instanceof Bundle");
      }
    }
    AppMethodBeat.o(15717);
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
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.UnKnowToUrlSpanHandler
 * JD-Core Version:    0.7.0.1
 */