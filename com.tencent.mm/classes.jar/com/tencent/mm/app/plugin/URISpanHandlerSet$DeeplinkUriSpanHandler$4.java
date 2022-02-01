package com.tencent.mm.app.plugin;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.an.q;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.pluginsdk.g.a;
import com.tencent.mm.protocal.protobuf.euv;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.w;

final class URISpanHandlerSet$DeeplinkUriSpanHandler$4
  implements g.a
{
  URISpanHandlerSet$DeeplinkUriSpanHandler$4(URISpanHandlerSet.DeeplinkUriSpanHandler paramDeeplinkUriSpanHandler, s params) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, q paramq, boolean paramBoolean)
  {
    AppMethodBeat.i(19693);
    if ((this.fgL != null) && (this.fgL.isShowing())) {
      this.fgL.dismiss();
    }
    if ((paramq != null) && (paramInt1 != 0) && (paramInt2 != 0) && ((paramq instanceof ac)))
    {
      paramString = ((ac)paramq).boT();
      if ((paramString != null) && (URISpanHandlerSet.a(this.fgJ.fgB) != null) && (!Util.isNullOrNil(paramString.Uwz))) {
        w.makeText(URISpanHandlerSet.a(this.fgJ.fgB), URISpanHandlerSet.a(this.fgJ.fgB).getString(R.l.app_tip) + " : " + Util.nullAsNil(paramString.Uwz), 0).show();
      }
    }
    AppMethodBeat.o(19693);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.DeeplinkUriSpanHandler.4
 * JD-Core Version:    0.7.0.1
 */