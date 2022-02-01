package com.tencent.mm.app.plugin;

import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.friend.a.b;
import com.tencent.mm.pluginsdk.ui.span.i;
import com.tencent.mm.pluginsdk.ui.span.n;
import com.tencent.mm.sdk.platformtools.Util;

@URISpanHandlerSet.a
class URISpanHandlerSet$PhoneEmailUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$PhoneEmailUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final int[] Xp()
  {
    return new int[] { 25, 24 };
  }
  
  final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami)
  {
    AppMethodBeat.i(231444);
    if (parami != null) {
      parami.a(paramu);
    }
    if (paramu.type == 25)
    {
      paramView = paramu.username;
      parami = new Bundle();
      if ((paramView != null) && (!paramView.equals(z.aTY())))
      {
        parami.putString("Contact_User", paramView);
        paramView = com.tencent.mm.plugin.account.a.getAddrUploadStg().SR(paramView);
        if ((paramView == null) || (Util.isNullOrNil(paramView.getMd5()))) {
          break label177;
        }
      }
    }
    label177:
    for (paramView = Util.nullAsNil(paramView.bnP()).replace(" ", "");; paramView = null)
    {
      parami.putString("Contact_Mobile_MD5", paramView);
      parami.putInt("fromScene", 1);
      n.a(URISpanHandlerSet.a(this.dnW), paramu.url, null, parami);
      AppMethodBeat.o(231444);
      return true;
      if (paramu.type == 24) {
        n.b(URISpanHandlerSet.a(this.dnW), paramu.url, null);
      }
      if (parami != null) {
        parami.b(paramu);
      }
      AppMethodBeat.o(231444);
      return false;
    }
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
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.PhoneEmailUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */