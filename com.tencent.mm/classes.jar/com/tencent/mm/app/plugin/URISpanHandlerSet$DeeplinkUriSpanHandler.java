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
import com.tencent.mm.R.l;
import com.tencent.mm.am.p;
import com.tencent.mm.modelsimple.ad;
import com.tencent.mm.pluginsdk.g.a;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.span.m;
import com.tencent.mm.pluginsdk.v;
import com.tencent.mm.protocal.protobuf.fqi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.appbrand.e;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;

@URISpanHandlerSet.a(aDR=URISpanHandlerSet.PRIORITY.LOW)
class URISpanHandlerSet$DeeplinkUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$DeeplinkUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet) {}
  
  public final boolean a(final View paramView, final u paramu, final m paramm)
  {
    AppMethodBeat.i(239376);
    Log.i("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler handleSpanClick %d, %s", new Object[] { Integer.valueOf(paramu.type), paramu.url });
    if (paramm != null) {}
    for (paramView = (String)paramm.a(paramu);; paramView = null)
    {
      if (paramu.type == 30)
      {
        paramu = Util.nullAsNil(paramu.url);
        if ((paramu.startsWith("weixin://shieldBrandMsg/")) || (paramu.startsWith("weixin://receiveBrandMsg/")))
        {
          if (Util.isNullOrNil(paramView))
          {
            Log.e("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler username is null");
            AppMethodBeat.o(239376);
            return true;
          }
          paramm = com.tencent.mm.an.g.hU(paramView);
          if (paramm == null)
          {
            Log.e("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler BizInfo is null");
            AppMethodBeat.o(239376);
            return true;
          }
          if (paramu.startsWith("weixin://shieldBrandMsg/")) {
            k.a(URISpanHandlerSet.a(this.hkL), R.l.gXm, R.l.app_tip, R.l.gXl, R.l.cancel, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(19690);
                paramAnonymousInt = paramm.field_brandFlag;
                paramm.field_brandFlag |= 0x1;
                Log.i("MicroMsg.URISpanHandlerSet", "shield biz msg %s, %s, old = %d, new = %d", new Object[] { paramu, paramView, Integer.valueOf(paramAnonymousInt), Integer.valueOf(paramm.field_brandFlag) });
                com.tencent.mm.an.g.i(paramm);
                AppMethodBeat.o(19690);
              }
            }, null);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(239376);
          return true;
          if (paramu.startsWith("weixin://receiveBrandMsg/"))
          {
            k.a(URISpanHandlerSet.a(this.hkL), R.l.gXk, R.l.app_tip, R.l.gXj, R.l.cancel, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(19691);
                paramAnonymousInt = paramm.field_brandFlag;
                paramm.field_brandFlag &= 0xFFFFFFFE;
                Log.i("MicroMsg.URISpanHandlerSet", "receive biz msg %s, %s, old = %d, new = %d", new Object[] { paramu, paramView, Integer.valueOf(paramAnonymousInt), Integer.valueOf(paramm.field_brandFlag) });
                com.tencent.mm.an.g.i(paramm);
                AppMethodBeat.o(19691);
              }
            }, null);
            continue;
            if (com.tencent.mm.pluginsdk.g.p(Uri.parse(paramu)))
            {
              com.tencent.mm.pluginsdk.g.ab(URISpanHandlerSet.a(this.hkL), paramView, paramu);
            }
            else if (paramu.startsWith("weixin://receiveWeAppKFMsg"))
            {
              if (Util.isNullOrNil(paramView))
              {
                Log.e("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler username is null, handle the BUILTIN_RECEIVE_WEAPP_KFMSG ,  the herfUrl is %s", new Object[] { paramu });
                AppMethodBeat.o(239376);
                return true;
              }
              k.a(URISpanHandlerSet.a(this.hkL), R.l.grs, R.l.app_tip, R.l.grr, R.l.cancel, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(19692);
                  Log.i("MicroMsg.URISpanHandlerSet", "AppBrandServiceHelper switchTo to receive msg for username %s", new Object[] { paramView });
                  e.l(URISpanHandlerSet.a(URISpanHandlerSet.DeeplinkUriSpanHandler.this.hkL), paramView, true);
                  AppMethodBeat.o(19692);
                }
              }, null);
            }
            else if (paramu.startsWith("weixin://xmail/bind"))
            {
              paramView = new Intent().putExtra("Contact_User", "qqmail");
              paramView.putExtra("key_need_rebind_xmail", true);
              com.tencent.mm.br.c.b(URISpanHandlerSet.a(this.hkL), "profile", ".ui.ContactInfoUI", paramView);
            }
            else
            {
              com.tencent.mm.pluginsdk.g.a(URISpanHandlerSet.a(this.hkL), paramu, paramView, 1, paramu, null);
            }
          }
        }
      }
      AppMethodBeat.o(239376);
      return false;
    }
  }
  
  public final boolean a(String paramString, boolean paramBoolean, final v paramv, Bundle paramBundle)
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
    if (com.tencent.mm.pluginsdk.g.p(Uri.parse(paramString)))
    {
      int j = paramBundle.getInt("key_scene", -1);
      Log.d("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler jump, %d, %s", new Object[] { Integer.valueOf(j), paramString });
      int i = j;
      if (j == -1) {
        i = 5;
      }
      paramv = k.a(URISpanHandlerSet.a(this.hkL), "", true, null);
      com.tencent.mm.pluginsdk.g.a(URISpanHandlerSet.a(this.hkL), paramString, i, new g.a()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(19693);
          if ((paramv != null) && (paramv.isShowing())) {
            paramv.dismiss();
          }
          if ((paramAnonymousp != null) && (paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0) && ((paramAnonymousp instanceof ad)))
          {
            paramAnonymousString = ((ad)paramAnonymousp).bMA();
            if ((paramAnonymousString != null) && (URISpanHandlerSet.a(URISpanHandlerSet.DeeplinkUriSpanHandler.this.hkL) != null) && (!Util.isNullOrNil(paramAnonymousString.abQg))) {
              aa.makeText(URISpanHandlerSet.a(URISpanHandlerSet.DeeplinkUriSpanHandler.this.hkL), URISpanHandlerSet.a(URISpanHandlerSet.DeeplinkUriSpanHandler.this.hkL).getString(R.l.app_tip) + " : " + Util.nullAsNil(paramAnonymousString.abQg), 0).show();
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
  
  public final int[] aDQ()
  {
    return new int[] { 30 };
  }
  
  public final u iJ(String paramString)
  {
    AppMethodBeat.i(19694);
    Log.i("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler getHrefFromUrl %s", new Object[] { paramString });
    if (paramString.trim().toLowerCase().startsWith("weixin://"))
    {
      paramString = new u(paramString, 30, null);
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