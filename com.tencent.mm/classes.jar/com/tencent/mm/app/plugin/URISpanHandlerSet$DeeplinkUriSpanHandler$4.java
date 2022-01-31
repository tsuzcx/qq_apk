package com.tencent.mm.app.plugin;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.pluginsdk.e.a;
import com.tencent.mm.protocal.protobuf.clr;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;

final class URISpanHandlerSet$DeeplinkUriSpanHandler$4
  implements e.a
{
  URISpanHandlerSet$DeeplinkUriSpanHandler$4(URISpanHandlerSet.DeeplinkUriSpanHandler paramDeeplinkUriSpanHandler, p paramp) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, m paramm, boolean paramBoolean)
  {
    AppMethodBeat.i(15648);
    if ((this.caw != null) && (this.caw.isShowing())) {
      this.caw.dismiss();
    }
    if ((paramm != null) && (paramInt1 != 0) && (paramInt2 != 0) && ((paramm instanceof ab)))
    {
      paramString = ((ab)paramm).ajY();
      if ((paramString != null) && (URISpanHandlerSet.a(this.cau.cam) != null)) {
        t.makeText(URISpanHandlerSet.a(this.cau.cam), URISpanHandlerSet.a(this.cau.cam).getString(2131297087) + " : " + bo.nullAsNil(paramString.xVH), 0).show();
      }
    }
    AppMethodBeat.o(15648);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.DeeplinkUriSpanHandler.4
 * JD-Core Version:    0.7.0.1
 */