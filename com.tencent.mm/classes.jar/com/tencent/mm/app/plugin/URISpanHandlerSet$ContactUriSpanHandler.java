package com.tencent.mm.app.plugin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.y;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.v;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.contact.SelectContactUI;
import java.util.List;

@URISpanHandlerSet.a
class URISpanHandlerSet$ContactUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$ContactUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final int[] Cf()
  {
    return new int[] { 23, 21, 22, 2 };
  }
  
  final boolean a(m paramm, com.tencent.mm.pluginsdk.ui.d.g paramg)
  {
    int k = 0;
    AppMethodBeat.i(15643);
    int i = paramm.type;
    if ((i == 23) || (i == 21) || (i == 22) || (i == 2))
    {
      y localy = (y)paramm.ap(y.class);
      if (paramg != null) {
        paramg.a(paramm);
      }
      if (localy == null)
      {
        h.b(URISpanHandlerSet.a(this.cam), URISpanHandlerSet.a(this.cam).getString(2131301067), URISpanHandlerSet.a(this.cam).getString(2131297087), true);
        AppMethodBeat.o(15643);
        return false;
      }
      if (localy.getType().equals("@t.qq.com"))
      {
        if (((j)com.tencent.mm.kernel.g.E(j.class)).YI().TL("@t.qq.com") == null) {
          break label409;
        }
        i = 1;
        if (i == 0) {
          h.b(URISpanHandlerSet.a(this.cam), URISpanHandlerSet.a(this.cam).getString(2131301067), URISpanHandlerSet.a(this.cam).getString(2131297087), true);
        }
      }
      Object localObject;
      int j;
      if (localy.getType().equals("@domain.android"))
      {
        localObject = ((j)com.tencent.mm.kernel.g.E(j.class)).YI().bQi();
        j = k;
        if (((List)localObject).size() > 0) {
          i = 0;
        }
      }
      for (;;)
      {
        j = k;
        if (i < ((List)localObject).size())
        {
          if (((bq)((List)localObject).get(i)).isEnable()) {
            j = 1;
          }
        }
        else
        {
          if (j == 0) {
            h.b(URISpanHandlerSet.a(this.cam), URISpanHandlerSet.a(this.cam).getString(2131301067), URISpanHandlerSet.a(this.cam).getString(2131297087), true);
          }
          localObject = new Intent();
          ((Intent)localObject).setClass(URISpanHandlerSet.a(this.cam), SelectContactUI.class);
          ((Intent)localObject).putExtra("Contact_GroupFilter_Type", localy.getType()).putExtra("Contact_GroupFilter_Str", localy.aaf()).putExtra("Contact_GroupFilter_DisplayName", localy.Oe());
          ((Intent)localObject).addFlags(268435456);
          URISpanHandlerSet.a(this.cam).startActivity((Intent)localObject);
          if (paramg != null) {
            paramg.b(paramm);
          }
          AppMethodBeat.o(15643);
          return true;
          label409:
          i = 0;
          break;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(15643);
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, v paramv, Bundle paramBundle)
  {
    AppMethodBeat.i(15644);
    if ((paramString.equals("weixin://contacts/microblog/")) || (paramString.equals("weixin://contacts/micromessenger/")) || (paramString.equals("weixin://contacts/all/")))
    {
      paramv = z.oT(URISpanHandlerSet.a(this.cam).getString(2131300543));
      if (paramString.equals("weixin://contacts/microblog/")) {
        paramv = z.oT(URISpanHandlerSet.a(this.cam).getString(2131300542));
      }
      if (paramString.equals("weixin://contacts/micromessenger/")) {
        paramv = z.oT(URISpanHandlerSet.a(this.cam).getString(2131300543));
      }
      if (paramString.equals("weixin://contacts/all/")) {
        paramv = z.oT(URISpanHandlerSet.a(this.cam).getString(2131300539));
      }
      paramString = new Intent();
      paramString.setClass(URISpanHandlerSet.a(this.cam), SelectContactUI.class);
      paramString.putExtra("Contact_GroupFilter_Type", paramv.getType()).putExtra("Contact_GroupFilter_Str", paramv.aaf()).putExtra("Contact_GroupFilter_DisplayName", paramv.Oe());
      paramString.addFlags(268435456);
      AppMethodBeat.o(15644);
      return true;
    }
    AppMethodBeat.o(15644);
    return false;
  }
  
  final m dN(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(15642);
    if (paramString.trim().equals("weixin://contacts/all/")) {
      localObject = new m(paramString, 23, new y("@all.android", null, URISpanHandlerSet.a(this.cam).getString(2131300539), null, true, true));
    }
    for (;;)
    {
      AppMethodBeat.o(15642);
      return localObject;
      if (paramString.trim().equals("weixin://contacts/microblog/"))
      {
        localObject = new m(paramString, 22, z.oT(URISpanHandlerSet.a(this.cam).getString(2131300542)));
      }
      else if (paramString.trim().equals("weixin://contacts/micromessenger/"))
      {
        localObject = new m(paramString, 2, new y("@micromsg.qq.com", null, URISpanHandlerSet.a(this.cam).getString(2131300543), null, true, true));
      }
      else if (paramString.trim().startsWith("weixin://contacts/"))
      {
        localObject = paramString.trim().substring(0, paramString.trim().length() - 1);
        int i = ((String)localObject).lastIndexOf("/");
        if (i == -1)
        {
          AppMethodBeat.o(15642);
          return null;
        }
        localObject = new m(paramString, 21, z.ak("@".concat(String.valueOf(((String)localObject).substring(i + 1))), URISpanHandlerSet.a(this.cam).getString(2131300541)));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.ContactUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */