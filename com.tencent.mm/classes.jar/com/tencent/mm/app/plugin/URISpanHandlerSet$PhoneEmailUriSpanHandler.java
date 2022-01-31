package com.tencent.mm.app.plugin;

import android.os.Bundle;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.account.friend.a.a;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.pluginsdk.ui.d.l;
import com.tencent.mm.sdk.platformtools.bk;

@URISpanHandlerSet.a
class URISpanHandlerSet$PhoneEmailUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$PhoneEmailUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final boolean a(m paramm, g paramg)
  {
    Bundle localBundle;
    if (paramm.type == 25)
    {
      paramg = paramm.username;
      localBundle = new Bundle();
      if ((paramg != null) && (!paramg.equals(q.Gj())))
      {
        localBundle.putString("Contact_User", paramg);
        paramg = com.tencent.mm.plugin.account.b.getAddrUploadStg().pH(paramg);
        if ((paramg == null) || (bk.bl(paramg.Wv()))) {
          break label138;
        }
      }
    }
    label138:
    for (paramg = bk.pm(paramg.WD()).replace(" ", "");; paramg = null)
    {
      localBundle.putString("Contact_Mobile_MD5", paramg);
      localBundle.putInt("fromScene", 1);
      l.a(URISpanHandlerSet.a(this.byk), paramm.url, null, localBundle);
      return true;
      if (paramm.type == 24) {
        l.b(URISpanHandlerSet.a(this.byk), paramm.url, null);
      }
      return false;
    }
  }
  
  final boolean a(String paramString, boolean paramBoolean, s params, Bundle paramBundle)
  {
    return false;
  }
  
  final m cA(String paramString)
  {
    return null;
  }
  
  final int[] tA()
  {
    return new int[] { 25, 24 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.PhoneEmailUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */