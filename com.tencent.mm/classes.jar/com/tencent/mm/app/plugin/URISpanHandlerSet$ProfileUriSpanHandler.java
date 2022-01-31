package com.tencent.mm.app.plugin;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.br.d;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.n.a;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.contact.e;

@URISpanHandlerSet.a
class URISpanHandlerSet$ProfileUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$ProfileUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final boolean a(m paramm, g paramg)
  {
    if (paramm.type == 3)
    {
      if (paramg != null) {
        paramg.a(paramm);
      }
      String str = (String)paramm.S(String.class);
      Intent localIntent = new Intent();
      localIntent.addFlags(268435456);
      localIntent.putExtra("Contact_User", str);
      au.Hx();
      ad localad = c.Fw().abl(str);
      if ((localad != null) && ((int)localad.dBe > 0) && (a.gR(localad.field_type))) {
        e.a(localIntent, str);
      }
      if (bk.pm(str).length() > 0) {
        d.b(URISpanHandlerSet.a(this.byk), "profile", ".ui.ContactInfoUI", localIntent);
      }
      if (paramg != null) {
        paramg.b(paramm);
      }
      return true;
    }
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, s params, Bundle paramBundle)
  {
    if (paramString.startsWith("weixin://contacts/profile/"))
    {
      paramString = paramString.trim().replace("weixin://contacts/profile/", "").replace("/", "");
      if (bk.bl(paramString))
      {
        y.e("MicroMsg.URISpanHandlerSet", "jumpToActivity fail, user is null");
        return true;
      }
      params = new Intent();
      params.addFlags(268435456);
      params.putExtra("Contact_User", paramString);
      au.Hx();
      paramBundle = c.Fw().abl(paramString);
      if ((paramBundle != null) && ((int)paramBundle.dBe > 0) && (a.gR(paramBundle.field_type))) {
        e.a(params, paramString);
      }
      d.b(URISpanHandlerSet.a(this.byk), "profile", ".ui.ContactInfoUI", params);
      return true;
    }
    return false;
  }
  
  final m cA(String paramString)
  {
    if (paramString.trim().startsWith("weixin://contacts/profile/")) {
      return new m(paramString, 3, paramString.trim().replace("weixin://contacts/profile/", "").replace("/", ""));
    }
    return null;
  }
  
  final int[] tA()
  {
    return new int[] { 3 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.ProfileUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */