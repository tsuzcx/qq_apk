package com.tencent.mm.app.plugin;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.pluginsdk.g.a;
import com.tencent.mm.pluginsdk.ui.span.i;
import com.tencent.mm.protocal.protobuf.ekq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.appbrand.e;
import com.tencent.mm.ui.base.h;

@URISpanHandlerSet.a(Xq=URISpanHandlerSet.PRIORITY.LOW)
class URISpanHandlerSet$DeeplinkUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$DeeplinkUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final int[] Xp()
  {
    return new int[] { 30 };
  }
  
  final boolean a(final View paramView, final com.tencent.mm.pluginsdk.ui.applet.u paramu, final i parami)
  {
    AppMethodBeat.i(231422);
    Log.i("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler handleSpanClick %d, %s", new Object[] { Integer.valueOf(paramu.type), paramu.url });
    if (parami != null) {}
    for (paramView = (String)parami.a(paramu);; paramView = null)
    {
      if (paramu.type == 30)
      {
        paramu = Util.nullAsNil(paramu.url);
        if ((paramu.startsWith("weixin://shieldBrandMsg/")) || (paramu.startsWith("weixin://receiveBrandMsg/")))
        {
          if (Util.isNullOrNil(paramView))
          {
            Log.e("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler username is null");
            AppMethodBeat.o(231422);
            return true;
          }
          parami = com.tencent.mm.al.g.fJ(paramView);
          if (parami == null)
          {
            Log.e("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler BizInfo is null");
            AppMethodBeat.o(231422);
            return true;
          }
          if (paramu.startsWith("weixin://shieldBrandMsg/")) {
            h.a(URISpanHandlerSet.a(this.dnW), 2131766694, 2131755998, 2131766693, 2131756929, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(19690);
                paramAnonymousInt = parami.field_brandFlag;
                parami.field_brandFlag |= 0x1;
                Log.i("MicroMsg.URISpanHandlerSet", "shield biz msg %s, %s, old = %d, new = %d", new Object[] { paramu, paramView, Integer.valueOf(paramAnonymousInt), Integer.valueOf(parami.field_brandFlag) });
                com.tencent.mm.al.g.i(parami);
                AppMethodBeat.o(19690);
              }
            }, null);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(231422);
          return true;
          if (paramu.startsWith("weixin://receiveBrandMsg/"))
          {
            h.a(URISpanHandlerSet.a(this.dnW), 2131766692, 2131755998, 2131766691, 2131756929, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(19691);
                paramAnonymousInt = parami.field_brandFlag;
                parami.field_brandFlag &= 0xFFFFFFFE;
                Log.i("MicroMsg.URISpanHandlerSet", "receive biz msg %s, %s, old = %d, new = %d", new Object[] { paramu, paramView, Integer.valueOf(paramAnonymousInt), Integer.valueOf(parami.field_brandFlag) });
                com.tencent.mm.al.g.i(parami);
                AppMethodBeat.o(19691);
              }
            }, null);
            continue;
            if (com.tencent.mm.pluginsdk.g.w(Uri.parse(paramu)))
            {
              com.tencent.mm.pluginsdk.g.P(URISpanHandlerSet.a(this.dnW), paramView, paramu);
            }
            else if (paramu.startsWith("weixin://receiveWeAppKFMsg"))
            {
              if (Util.isNullOrNil(paramView))
              {
                Log.e("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler username is null, handle the BUILTIN_RECEIVE_WEAPP_KFMSG ,  the herfUrl is %s", new Object[] { paramu });
                AppMethodBeat.o(231422);
                return true;
              }
              h.a(URISpanHandlerSet.a(this.dnW), 2131755683, 2131755998, 2131755682, 2131756929, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(19692);
                  Log.i("MicroMsg.URISpanHandlerSet", "AppBrandServiceHelper switchTo to receive msg for username %s", new Object[] { paramView });
                  e.l(URISpanHandlerSet.a(URISpanHandlerSet.DeeplinkUriSpanHandler.this.dnW), paramView, true);
                  AppMethodBeat.o(19692);
                }
              }, null);
            }
            else if (paramu.startsWith("weixin://xmail/bind"))
            {
              paramView = new Intent().putExtra("Contact_User", "qqmail");
              paramView.putExtra("key_need_rebind_xmail", true);
              com.tencent.mm.br.c.b(URISpanHandlerSet.a(this.dnW), "profile", ".ui.ContactInfoUI", paramView);
            }
            else
            {
              com.tencent.mm.pluginsdk.g.a(URISpanHandlerSet.a(this.dnW), paramu, paramView, 1, paramu, null);
            }
          }
        }
      }
      AppMethodBeat.o(231422);
      return false;
    }
  }
  
  final boolean a(String paramString, boolean paramBoolean, final com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
  {
    AppMethodBeat.i(19696);
    if ((Util.isNullOrNil(paramString)) || (paramBundle == null))
    {
      if (paramString == null)
      {
        paramBoolean = true;
        if (paramBundle != null) {
          break label71;
        }
      }
      label71:
      for (boolean bool = true;; bool = false)
      {
        Log.e("MicroMsg.URISpanHandlerSet", "url is null ? %b, paramsBundle is null ? %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
        AppMethodBeat.o(19696);
        return false;
        paramBoolean = false;
        break;
      }
    }
    if (com.tencent.mm.pluginsdk.g.w(Uri.parse(paramString)))
    {
      int j = paramBundle.getInt("key_scene", -1);
      Log.d("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler jump, %d, %s", new Object[] { Integer.valueOf(j), paramString });
      int i = j;
      if (j == -1) {
        i = 5;
      }
      paramu = h.a(URISpanHandlerSet.a(this.dnW), "", true, null);
      com.tencent.mm.pluginsdk.g.a(URISpanHandlerSet.a(this.dnW), paramString, i, new g.a()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.q paramAnonymousq, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(19693);
          if ((paramu != null) && (paramu.isShowing())) {
            paramu.dismiss();
          }
          if ((paramAnonymousq != null) && (paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0) && ((paramAnonymousq instanceof ac)))
          {
            paramAnonymousString = ((ac)paramAnonymousq).bfD();
            if ((paramAnonymousString != null) && (URISpanHandlerSet.a(URISpanHandlerSet.DeeplinkUriSpanHandler.this.dnW) != null) && (!Util.isNullOrNil(paramAnonymousString.NjR))) {
              com.tencent.mm.ui.base.u.makeText(URISpanHandlerSet.a(URISpanHandlerSet.DeeplinkUriSpanHandler.this.dnW), URISpanHandlerSet.a(URISpanHandlerSet.DeeplinkUriSpanHandler.this.dnW).getString(2131755998) + " : " + Util.nullAsNil(paramAnonymousString.NjR), 0).show();
            }
          }
          AppMethodBeat.o(19693);
        }
      });
      AppMethodBeat.o(19696);
      return true;
    }
    AppMethodBeat.o(19696);
    return false;
  }
  
  final com.tencent.mm.pluginsdk.ui.applet.u gx(String paramString)
  {
    AppMethodBeat.i(19694);
    Log.i("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler getHrefFromUrl %s", new Object[] { paramString });
    if (paramString.trim().toLowerCase().startsWith("weixin://"))
    {
      paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 30, null);
      AppMethodBeat.o(19694);
      return paramString;
    }
    AppMethodBeat.o(19694);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.DeeplinkUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */