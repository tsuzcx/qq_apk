package com.tencent.mm.app.plugin;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.n.a;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.pluginsdk.v;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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
  
  final int[] Cf()
  {
    return new int[] { 3 };
  }
  
  final boolean a(m paramm, g paramg)
  {
    AppMethodBeat.i(15687);
    if (paramm.type == 3)
    {
      if (paramg != null) {
        paramg.a(paramm);
      }
      String str = (String)paramm.ap(String.class);
      Intent localIntent = new Intent();
      localIntent.addFlags(268435456);
      localIntent.putExtra("Contact_User", str);
      aw.aaz();
      ad localad = c.YA().arw(str);
      if ((localad != null) && ((int)localad.euF > 0) && (a.je(localad.field_type))) {
        e.a(localIntent, str);
      }
      if (bo.nullAsNil(str).length() > 0) {
        d.b(URISpanHandlerSet.a(this.cam), "profile", ".ui.ContactInfoUI", localIntent);
      }
      if (paramg != null) {
        paramg.b(paramm);
      }
      AppMethodBeat.o(15687);
      return true;
    }
    AppMethodBeat.o(15687);
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, v paramv, Bundle paramBundle)
  {
    AppMethodBeat.i(15688);
    if (paramString.startsWith("weixin://contacts/profile/"))
    {
      paramString = paramString.trim().replace("weixin://contacts/profile/", "").replace("/", "");
      if (bo.isNullOrNil(paramString))
      {
        ab.e("MicroMsg.URISpanHandlerSet", "jumpToActivity fail, user is null");
        AppMethodBeat.o(15688);
        return true;
      }
      paramv = new Intent();
      paramv.addFlags(268435456);
      paramv.putExtra("Contact_User", paramString);
      aw.aaz();
      paramBundle = c.YA().arw(paramString);
      if ((paramBundle != null) && ((int)paramBundle.euF > 0) && (a.je(paramBundle.field_type))) {
        e.a(paramv, paramString);
      }
      d.b(URISpanHandlerSet.a(this.cam), "profile", ".ui.ContactInfoUI", paramv);
      AppMethodBeat.o(15688);
      return true;
    }
    AppMethodBeat.o(15688);
    return false;
  }
  
  final m dN(String paramString)
  {
    AppMethodBeat.i(15686);
    if (paramString.trim().startsWith("weixin://contacts/profile/"))
    {
      paramString = new m(paramString, 3, paramString.trim().replace("weixin://contacts/profile/", "").replace("/", ""));
      AppMethodBeat.o(15686);
      return paramString;
    }
    AppMethodBeat.o(15686);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.ProfileUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */