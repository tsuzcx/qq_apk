package com.tencent.mm.app.plugin;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.account.friend.a.b;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.pluginsdk.ui.d.l;
import com.tencent.mm.pluginsdk.v;
import com.tencent.mm.sdk.platformtools.bo;

@URISpanHandlerSet.a
class URISpanHandlerSet$PhoneEmailUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$PhoneEmailUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final int[] Cf()
  {
    return new int[] { 25, 24 };
  }
  
  final boolean a(m paramm, g paramg)
  {
    AppMethodBeat.i(15683);
    Bundle localBundle;
    if (paramm.type == 25)
    {
      paramg = paramm.username;
      localBundle = new Bundle();
      if ((paramg != null) && (!paramg.equals(r.Zn())))
      {
        localBundle.putString("Contact_User", paramg);
        paramg = com.tencent.mm.plugin.account.a.getAddrUploadStg().wX(paramg);
        if ((paramg == null) || (bo.isNullOrNil(paramg.Al()))) {
          break label156;
        }
      }
    }
    label156:
    for (paramg = bo.nullAsNil(paramg.aqf()).replace(" ", "");; paramg = null)
    {
      localBundle.putString("Contact_Mobile_MD5", paramg);
      localBundle.putInt("fromScene", 1);
      l.a(URISpanHandlerSet.a(this.cam), paramm.url, null, localBundle);
      AppMethodBeat.o(15683);
      return true;
      if (paramm.type == 24) {
        l.b(URISpanHandlerSet.a(this.cam), paramm.url, null);
      }
      AppMethodBeat.o(15683);
      return false;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.PhoneEmailUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */