package com.tencent.mm.app.plugin;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.patmsg.ui.b;
import com.tencent.mm.plugin.secdata.ui.a;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.pluginsdk.ui.span.i;
import com.tencent.mm.protocal.protobuf.diw;

@URISpanHandlerSet.a
class URISpanHandlerSet$JumpPatSettingDialogUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$JumpPatSettingDialogUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami)
  {
    AppMethodBeat.i(273022);
    if (paramu.type == 61)
    {
      paramu = a.JbV;
      ((diw)a.a.c(paramView.getContext(), 4, diw.class)).TQp = 1;
      paramView = new b(paramView.getContext());
      paramView.show();
      paramView.getWindow().setLayout(-1, -1);
    }
    AppMethodBeat.o(273022);
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
  {
    return false;
  }
  
  final int[] abR()
  {
    return new int[] { 61 };
  }
  
  final com.tencent.mm.pluginsdk.ui.applet.u hi(String paramString)
  {
    AppMethodBeat.i(273021);
    if (paramString.trim().toLowerCase().startsWith("weixin://jump/setpat_bottom_sheet/"))
    {
      paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 61, null);
      AppMethodBeat.o(273021);
      return paramString;
    }
    AppMethodBeat.o(273021);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.JumpPatSettingDialogUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */