package com.tencent.mm.app.plugin;

import android.app.Activity;
import android.app.Service;
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
import com.tencent.mm.an.t;
import com.tencent.mm.chatroom.ui.ManagerRoomByWeworkUI;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.a.aaq;
import com.tencent.mm.f.a.cg;
import com.tencent.mm.f.a.ch;
import com.tencent.mm.f.a.xw;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.bind.ui.MobileFriendUI;
import com.tencent.mm.plugin.setting.model.m;
import com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalInfoUI;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.f.e;

class URISpanHandlerSet
{
  Context mContext;
  
  public URISpanHandlerSet(Context paramContext)
  {
    AppMethodBeat.i(19768);
    this.mContext = null;
    if (paramContext == null) {}
    for (paramContext = MMApplicationContext.getContext();; paramContext = this.mContext)
    {
      this.mContext = paramContext;
      AppMethodBeat.o(19768);
      return;
    }
  }
  
  @URISpanHandlerSet.a
  class AAUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    AAUriSpanHandler()
    {
      super();
    }
    
    final boolean a(final View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, final com.tencent.mm.pluginsdk.ui.span.i parami)
    {
      AppMethodBeat.i(268351);
      Object localObject;
      if (paramu.type == 35) {
        for (;;)
        {
          try
          {
            paramView = Uri.parse(paramu.url);
            parami = paramView.getQueryParameter("billno");
            if (Util.isNullOrNil(parami))
            {
              Log.e("MicroMsg.URISpanHandlerSet", "url error, billno is null");
              AppMethodBeat.o(268351);
              return true;
            }
            int i = Util.getInt(paramView.getQueryParameter("scene"), 3);
            if (!(paramu.bnW instanceof Bundle)) {
              continue;
            }
            paramView = ((Bundle)paramu.bnW).getString("chatroom_name");
            localObject = new Intent();
            ((Intent)localObject).putExtra("bill_no", parami);
            ((Intent)localObject).putExtra("enter_scene", i);
            ((Intent)localObject).putExtra("chatroom", paramView);
            com.tencent.mm.by.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "aa", ".ui.PaylistAAUI", (Intent)localObject);
          }
          catch (Exception paramView)
          {
            Log.e("MicroMsg.URISpanHandlerSet", "handle click new aa open detail link error: %s, url: %s", new Object[] { paramView.getMessage(), paramu.url });
            continue;
          }
          AppMethodBeat.o(268351);
          return true;
          if ((paramu.bnW instanceof String))
          {
            paramView = paramu.bnW.toString();
          }
          else
          {
            Log.e("MicroMsg.URISpanHandlerSet", "illegal data type, %s", new Object[] { paramu });
            AppMethodBeat.o(268351);
            return true;
          }
        }
      }
      if (paramu.type == 37) {}
      for (;;)
      {
        final long l;
        try
        {
          paramView = Uri.parse(paramu.url).getQueryParameter("billno");
          if (Util.isNullOrNil(paramView))
          {
            Log.e("MicroMsg.URISpanHandlerSet", "url error, billno is null");
            AppMethodBeat.o(268351);
            return true;
          }
          if (!(paramu.bnW instanceof Bundle))
          {
            Log.e("MicroMsg.URISpanHandlerSet", "error data!");
            AppMethodBeat.o(268351);
            return true;
          }
          parami = (Bundle)paramu.bnW;
          localObject = parami.getString("chatroom_name");
          if (Util.isNullOrNil((String)localObject))
          {
            Log.e("MicroMsg.URISpanHandlerSet", "empty chatroom!");
            AppMethodBeat.o(268351);
            return true;
          }
          l = parami.getLong("msg_id", -1L);
          if (l < 0L)
          {
            Log.e("MicroMsg.URISpanHandlerSet", "msgId is null");
            AppMethodBeat.o(268351);
            return true;
          }
          com.tencent.mm.ui.base.h.a(URISpanHandlerSet.a(URISpanHandlerSet.this), R.l.eTz, -1, R.l.eTC, R.l.cancel, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(19673);
              paramAnonymousDialogInterface = new cg();
              paramAnonymousDialogInterface.fxR.fxS = paramView;
              paramAnonymousDialogInterface.fxR.fxT = this.fgD;
              paramAnonymousDialogInterface.fxR.fxU = l;
              EventCenter.instance.publish(paramAnonymousDialogInterface);
              AppMethodBeat.o(19673);
            }
          }, null);
        }
        catch (Exception paramView)
        {
          Log.e("MicroMsg.URISpanHandlerSet", "handle click new aa close link error: %s, url: %s", new Object[] { paramView.getMessage(), paramu.url });
          continue;
        }
        AppMethodBeat.o(268351);
        return false;
        if (paramu.type == 36) {
          try
          {
            parami = Uri.parse(paramu.url).getQueryParameter("billno");
            if (Util.isNullOrNil(parami))
            {
              Log.e("MicroMsg.URISpanHandlerSet", "url error, billno is null");
              AppMethodBeat.o(268351);
              return true;
            }
            paramView = null;
            if ((paramu.bnW instanceof Bundle)) {
              paramView = (Bundle)paramu.bnW;
            }
            if ((paramView == null) || (Util.isNullOrNil(paramView.getString("chatroom_name"))))
            {
              Log.e("MicroMsg.URISpanHandlerSet", "empty chatroom!");
              AppMethodBeat.o(268351);
              return true;
            }
            localObject = paramView.getString("chatroom_name");
            l = paramView.getLong("msg_id", -1L);
            com.tencent.mm.ui.base.h.a(URISpanHandlerSet.a(URISpanHandlerSet.this), R.l.eTA, -1, R.l.eTB, R.l.cancel, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(19674);
                paramAnonymousDialogInterface = new ch();
                paramAnonymousDialogInterface.fxV.fxS = parami;
                paramAnonymousDialogInterface.fxV.fxT = this.fgD;
                paramAnonymousDialogInterface.fxV.fxU = l;
                EventCenter.instance.publish(paramAnonymousDialogInterface);
                AppMethodBeat.o(19674);
              }
            }, null);
          }
          catch (Exception paramView)
          {
            Log.e("MicroMsg.URISpanHandlerSet", "handle click new aa urge notify link error: %s, url: %s", new Object[] { paramView.getMessage(), paramu.url });
          }
        }
      }
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final int[] abR()
    {
      return new int[] { 35, 36, 37 };
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u hi(String paramString)
    {
      AppMethodBeat.i(19675);
      if (paramString.trim().toLowerCase().startsWith("weixin://weixinnewaa/opendetail"))
      {
        paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 35, null);
        AppMethodBeat.o(19675);
        return paramString;
      }
      if (paramString.trim().toLowerCase().startsWith("weixin://weixinnewaa/closeurgenotify"))
      {
        paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 36, null);
        AppMethodBeat.o(19675);
        return paramString;
      }
      if (paramString.trim().toLowerCase().startsWith("weixin://weixinnewaa/closeaa"))
      {
        paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 37, null);
        AppMethodBeat.o(19675);
        return paramString;
      }
      AppMethodBeat.o(19675);
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class AddressUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    AddressUriSpanHandler()
    {
      super();
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.i parami)
    {
      AppMethodBeat.i(273273);
      if (paramu.type == 44)
      {
        paramu = Uri.parse("geo:0,0?q=" + Uri.encode(paramu.url));
        paramView = new Intent("android.intent.action.VIEW");
        paramView.setData(paramu);
        paramView.addFlags(268435456);
        if (paramView.resolveActivity(MMApplicationContext.getContext().getPackageManager()) != null)
        {
          paramu = MMApplicationContext.getContext();
          paramView = new com.tencent.mm.hellhoundlib.b.a().bm(paramView);
          com.tencent.mm.hellhoundlib.a.a.b(paramu, paramView.aFh(), "com/tencent/mm/app/plugin/URISpanHandlerSet$AddressUriSpanHandler", "handleSpanClick", "(Landroid/view/View;Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramu.startActivity((Intent)paramView.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramu, "com/tencent/mm/app/plugin/URISpanHandlerSet$AddressUriSpanHandler", "handleSpanClick", "(Landroid/view/View;Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.plugin.report.service.h.IzE.a(12809, new Object[] { Integer.valueOf(9), "" });
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.IzE.a(12809, new Object[] { Integer.valueOf(8), "" });
          AppMethodBeat.o(273273);
          return true;
          Log.w("MicroMsg.URISpanHandlerSet", "Cannot find map app");
        }
      }
      AppMethodBeat.o(273273);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final int[] abR()
    {
      return new int[] { 44 };
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u hi(String paramString)
    {
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class AlphaInstallUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    AlphaInstallUriSpanHandler()
    {
      super();
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.i parami)
    {
      AppMethodBeat.i(196870);
      if (paramu.type == 32)
      {
        paramView = paramu.url.replace("weixin://alphainstall?", "");
        paramu = Uri.parse(paramView).getQueryParameter("md5");
        paramu = com.tencent.mm.loader.j.b.aSL() + paramu + ".apk";
        if (com.tencent.mm.vfs.u.agG(paramu)) {
          r.b(MMApplicationContext.getContext(), paramu, null, false);
        }
        for (;;)
        {
          AppMethodBeat.o(196870);
          return true;
          paramu = new Intent();
          paramu.putExtra("rawUrl", paramView.toString());
          com.tencent.mm.by.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "webview", ".ui.tools.WebViewUI", paramu);
        }
      }
      AppMethodBeat.o(196870);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final int[] abR()
    {
      return new int[] { 32 };
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u hi(String paramString)
    {
      AppMethodBeat.i(19678);
      if (paramString.trim().toLowerCase().startsWith("weixin://alphainstall?"))
      {
        paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 32, null);
        AppMethodBeat.o(19678);
        return paramString;
      }
      AppMethodBeat.o(19678);
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class BindMobileUrilSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    BindMobileUrilSpanHandler()
    {
      super();
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.i parami)
    {
      AppMethodBeat.i(280354);
      if (paramu.type == 5)
      {
        if (parami != null) {
          parami.a(paramu);
        }
        MMWizardActivity.aH(URISpanHandlerSet.a(URISpanHandlerSet.this), new Intent(URISpanHandlerSet.a(URISpanHandlerSet.this), BindMContactIntroUI.class));
        if (parami != null) {
          parami.b(paramu);
        }
        AppMethodBeat.o(280354);
        return true;
      }
      AppMethodBeat.o(280354);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      AppMethodBeat.i(19683);
      if (paramString.equals("weixin://setting/bindphone"))
      {
        paramString = new Intent(URISpanHandlerSet.a(URISpanHandlerSet.this), BindMContactIntroUI.class);
        if ((URISpanHandlerSet.a(URISpanHandlerSet.this) instanceof Service)) {
          paramString.addFlags(268435456);
        }
        MMWizardActivity.aH(URISpanHandlerSet.a(URISpanHandlerSet.this), paramString);
        AppMethodBeat.o(19683);
        return true;
      }
      AppMethodBeat.o(19683);
      return false;
    }
    
    final int[] abR()
    {
      return new int[] { 5 };
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u hi(String paramString)
    {
      AppMethodBeat.i(19681);
      if (paramString.trim().startsWith("weixin://setting/bindphone"))
      {
        paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 5, null);
        AppMethodBeat.o(19681);
        return paramString;
      }
      AppMethodBeat.o(19681);
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class CardUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    CardUriSpanHandler()
    {
      super();
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.i parami)
    {
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      AppMethodBeat.i(19686);
      if (paramString.startsWith("wxcard://cardjumptype=1"))
      {
        paramString = null;
        if (paramu != null) {
          paramString = paramu.hfQ().toString();
        }
        paramu = new Intent();
        paramu.putExtra("user_name", paramString);
        paramu.putExtra("view_type", 1);
        com.tencent.mm.by.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "card", ".ui.CardViewUI", paramu);
        AppMethodBeat.o(19686);
        return true;
      }
      AppMethodBeat.o(19686);
      return false;
    }
    
    final int[] abR()
    {
      return new int[0];
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u hi(String paramString)
    {
      return null;
    }
  }
  
  @URISpanHandlerSet.a(abS=URISpanHandlerSet.PRIORITY.LOW)
  class DeeplinkUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    DeeplinkUriSpanHandler()
    {
      super();
    }
    
    final boolean a(final View paramView, final com.tencent.mm.pluginsdk.ui.applet.u paramu, final com.tencent.mm.pluginsdk.ui.span.i parami)
    {
      AppMethodBeat.i(289918);
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
              AppMethodBeat.o(289918);
              return true;
            }
            parami = com.tencent.mm.ao.g.gu(paramView);
            if (parami == null)
            {
              Log.e("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler BizInfo is null");
              AppMethodBeat.o(289918);
              return true;
            }
            if (paramu.startsWith("weixin://shieldBrandMsg/")) {
              com.tencent.mm.ui.base.h.a(URISpanHandlerSet.a(URISpanHandlerSet.this), R.l.eUl, R.l.app_tip, R.l.eUk, R.l.cancel, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(19690);
                  paramAnonymousInt = parami.field_brandFlag;
                  parami.field_brandFlag |= 0x1;
                  Log.i("MicroMsg.URISpanHandlerSet", "shield biz msg %s, %s, old = %d, new = %d", new Object[] { paramu, paramView, Integer.valueOf(paramAnonymousInt), Integer.valueOf(parami.field_brandFlag) });
                  com.tencent.mm.ao.g.i(parami);
                  AppMethodBeat.o(19690);
                }
              }, null);
            }
          }
          for (;;)
          {
            AppMethodBeat.o(289918);
            return true;
            if (paramu.startsWith("weixin://receiveBrandMsg/"))
            {
              com.tencent.mm.ui.base.h.a(URISpanHandlerSet.a(URISpanHandlerSet.this), R.l.eUj, R.l.app_tip, R.l.eUi, R.l.cancel, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(19691);
                  paramAnonymousInt = parami.field_brandFlag;
                  parami.field_brandFlag &= 0xFFFFFFFE;
                  Log.i("MicroMsg.URISpanHandlerSet", "receive biz msg %s, %s, old = %d, new = %d", new Object[] { paramu, paramView, Integer.valueOf(paramAnonymousInt), Integer.valueOf(parami.field_brandFlag) });
                  com.tencent.mm.ao.g.i(parami);
                  AppMethodBeat.o(19691);
                }
              }, null);
              continue;
              if (com.tencent.mm.pluginsdk.g.n(Uri.parse(paramu)))
              {
                com.tencent.mm.pluginsdk.g.X(URISpanHandlerSet.a(URISpanHandlerSet.this), paramView, paramu);
              }
              else if (paramu.startsWith("weixin://receiveWeAppKFMsg"))
              {
                if (Util.isNullOrNil(paramView))
                {
                  Log.e("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler username is null, handle the BUILTIN_RECEIVE_WEAPP_KFMSG ,  the herfUrl is %s", new Object[] { paramu });
                  AppMethodBeat.o(289918);
                  return true;
                }
                com.tencent.mm.ui.base.h.a(URISpanHandlerSet.a(URISpanHandlerSet.this), R.l.eou, R.l.app_tip, R.l.eot, R.l.cancel, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                  {
                    AppMethodBeat.i(19692);
                    Log.i("MicroMsg.URISpanHandlerSet", "AppBrandServiceHelper switchTo to receive msg for username %s", new Object[] { paramView });
                    com.tencent.mm.ui.appbrand.e.l(URISpanHandlerSet.a(URISpanHandlerSet.this), paramView, true);
                    AppMethodBeat.o(19692);
                  }
                }, null);
              }
              else if (paramu.startsWith("weixin://xmail/bind"))
              {
                paramView = new Intent().putExtra("Contact_User", "qqmail");
                paramView.putExtra("key_need_rebind_xmail", true);
                com.tencent.mm.by.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "profile", ".ui.ContactInfoUI", paramView);
              }
              else
              {
                com.tencent.mm.pluginsdk.g.a(URISpanHandlerSet.a(URISpanHandlerSet.this), paramu, paramView, 1, paramu, null);
              }
            }
          }
        }
        AppMethodBeat.o(289918);
        return false;
      }
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
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
      if (com.tencent.mm.pluginsdk.g.n(Uri.parse(paramString)))
      {
        int j = paramBundle.getInt("key_scene", -1);
        Log.d("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler jump, %d, %s", new Object[] { Integer.valueOf(j), paramString });
        int i = j;
        if (j == -1) {
          i = 5;
        }
        paramu = com.tencent.mm.ui.base.h.a(URISpanHandlerSet.a(URISpanHandlerSet.this), "", true, null);
        com.tencent.mm.pluginsdk.g.a(URISpanHandlerSet.a(URISpanHandlerSet.this), paramString, i, new URISpanHandlerSet.DeeplinkUriSpanHandler.4(this, paramu));
        AppMethodBeat.o(19696);
        return true;
      }
      AppMethodBeat.o(19696);
      return false;
    }
    
    final int[] abR()
    {
      return new int[] { 30 };
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u hi(String paramString)
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
  
  @URISpanHandlerSet.a
  class EmotionStoreUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    EmotionStoreUriSpanHandler()
    {
      super();
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.i parami)
    {
      AppMethodBeat.i(286722);
      if (paramu.type == 29)
      {
        if (parami != null) {
          parami.a(paramu);
        }
        paramView = new Intent();
        paramView.putExtra("download_entrance_scene", 21);
        paramView.putExtra("extra_id", (String)paramu.bv(String.class));
        paramView.putExtra("preceding_scence", 3);
        com.tencent.mm.by.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "emoji", ".ui.EmojiStoreDetailUI", paramView);
        if (parami != null) {
          parami.b(paramu);
        }
        AppMethodBeat.o(286722);
        return true;
      }
      AppMethodBeat.o(286722);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final int[] abR()
    {
      return new int[] { 29 };
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u hi(String paramString)
    {
      AppMethodBeat.i(19697);
      if (paramString.trim().startsWith("weixin://emoticonstore/"))
      {
        int i = paramString.lastIndexOf("/");
        String str = "";
        if (i != -1) {
          str = paramString.substring(i + 1);
        }
        paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 29, str);
        AppMethodBeat.o(19697);
        return paramString;
      }
      AppMethodBeat.o(19697);
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class EnterChatRoomUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    EnterChatRoomUriSpanHandler()
    {
      super();
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.i parami)
    {
      AppMethodBeat.i(257962);
      if (paramu.type == 55)
      {
        Log.i("MicroMsg.URISpanHandlerSet", "handleClickEnterChatRoomSystemMsgUrl");
        try
        {
          paramView = paramu.url;
          int i = paramView.trim().lastIndexOf("/");
          if ((i >= 0) && (i < paramView.trim().length() - 1))
          {
            paramView = paramView.trim().substring(i + 1);
            if (ab.Lj(paramView))
            {
              bh.beI();
              parami = com.tencent.mm.model.c.bbL().RG(paramView);
              if ((parami == null) || ((int)parami.jxt == 0))
              {
                parami = new as();
                parami.setUsername(paramView);
                bh.beI();
                com.tencent.mm.model.c.bbL().av(parami);
              }
            }
            Object localObject = new Intent(URISpanHandlerSet.a(URISpanHandlerSet.this), ChattingUI.class).putExtra("Chat_User", paramView).putExtra("Chat_Mode", 1);
            if ((URISpanHandlerSet.a(URISpanHandlerSet.this) instanceof Service)) {
              ((Intent)localObject).addFlags(268435456);
            }
            parami = URISpanHandlerSet.a(URISpanHandlerSet.this);
            localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(parami, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/app/plugin/URISpanHandlerSet$EnterChatRoomUriSpanHandler", "handleSpanClick", "(Landroid/view/View;Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            parami.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(parami, "com/tencent/mm/app/plugin/URISpanHandlerSet$EnterChatRoomUriSpanHandler", "handleSpanClick", "(Landroid/view/View;Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            if (paramu.ilw == 1)
            {
              parami = Util.nullAs(paramu.chatroomName, "");
              com.tencent.mm.chatroom.c.b.f(Util.nullAs(paramView, ""), parami, 3);
              Log.i("MicroMsg.URISpanHandlerSet", "handleClickEnterChatRoomSystemMsgUrl migrate(%s -> %s)", new Object[] { parami, Util.nullAs(paramView, "") });
            }
            AppMethodBeat.o(257962);
            return true;
          }
        }
        catch (Exception paramView)
        {
          Log.e("MicroMsg.URISpanHandlerSet", "handle click link error: %s, url: %s", new Object[] { paramView.getMessage(), paramu.url });
        }
      }
      AppMethodBeat.o(257962);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final int[] abR()
    {
      return new int[] { 55 };
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u hi(String paramString)
    {
      AppMethodBeat.i(257959);
      if (paramString.trim().toLowerCase().startsWith("weixin://jump/chatroom/"))
      {
        paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 55, null);
        AppMethodBeat.o(257959);
        return paramString;
      }
      AppMethodBeat.o(257959);
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class EnterRoomUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    EnterRoomUriSpanHandler()
    {
      super();
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.i parami)
    {
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      AppMethodBeat.i(19699);
      if (paramString.startsWith("weixin://jump/mainframe/"))
      {
        int i = paramString.trim().lastIndexOf("/");
        if ((i >= 0) && (i < paramString.trim().length() - 1))
        {
          paramString = paramString.trim().substring(i + 1);
          if (ab.Lj(paramString))
          {
            bh.beI();
            paramu = com.tencent.mm.model.c.bbL().RG(paramString);
            if ((paramu == null) || ((int)paramu.jxt == 0))
            {
              paramu = new as();
              paramu.setUsername(paramString);
              bh.beI();
              com.tencent.mm.model.c.bbL().av(paramu);
            }
          }
          paramu = new Intent(URISpanHandlerSet.a(URISpanHandlerSet.this), ChattingUI.class).putExtra("Chat_User", paramString).putExtra("Chat_Mode", 1);
          if ((URISpanHandlerSet.a(URISpanHandlerSet.this) instanceof Service)) {
            paramu.addFlags(268435456);
          }
          paramString = URISpanHandlerSet.a(URISpanHandlerSet.this);
          paramu = new com.tencent.mm.hellhoundlib.b.a().bm(paramu);
          com.tencent.mm.hellhoundlib.a.a.b(paramString, paramu.aFh(), "com/tencent/mm/app/plugin/URISpanHandlerSet$EnterRoomUriSpanHandler", "handleUriJump", "(Ljava/lang/String;ZLcom/tencent/mm/pluginsdk/UriJumpCallback;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramString.startActivity((Intent)paramu.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/app/plugin/URISpanHandlerSet$EnterRoomUriSpanHandler", "handleUriJump", "(Ljava/lang/String;ZLcom/tencent/mm/pluginsdk/UriJumpCallback;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(19699);
          return true;
        }
      }
      AppMethodBeat.o(19699);
      return false;
    }
    
    final int[] abR()
    {
      return new int[0];
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u hi(String paramString)
    {
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class ExposeUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    ExposeUriSpanHandler()
    {
      super();
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.i parami)
    {
      AppMethodBeat.i(279810);
      if (paramu.type == 31)
      {
        paramView = new Intent();
        if (parami == null)
        {
          AppMethodBeat.o(279810);
          return false;
        }
        paramu = (String)parami.a(paramu);
        paramView.putExtra("k_username", paramu);
        if ((Util.isNullOrNil(paramu)) || (!paramu.endsWith("@chatroom"))) {
          break label134;
        }
      }
      label134:
      for (int i = 36;; i = 39)
      {
        paramView.putExtra("showShare", false);
        paramView.putExtra("rawUrl", String.format(f.e.VRX, new Object[] { Integer.valueOf(i) }));
        com.tencent.mm.by.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "webview", ".ui.tools.WebViewUI", paramView);
        AppMethodBeat.o(279810);
        return true;
        AppMethodBeat.o(279810);
        return false;
      }
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final int[] abR()
    {
      return new int[] { 31 };
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u hi(String paramString)
    {
      AppMethodBeat.i(19700);
      if (paramString.trim().toLowerCase().equals("weixin://expose/"))
      {
        paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 31, null);
        AppMethodBeat.o(19700);
        return paramString;
      }
      AppMethodBeat.o(19700);
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class FeedbackUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    FeedbackUriSpanHandler()
    {
      super();
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.i parami)
    {
      AppMethodBeat.i(284972);
      if (paramu.type == 34)
      {
        paramView = paramu.url.trim().replace("weixin://feedback/next/", "");
        Log.d("MicroMsg.URISpanHandlerSet", "FeedbackUriSpanHandler, url:%s, content:%s", new Object[] { paramu.url, paramView });
        bh.aGY().a(new m(q.auR(), paramView, 8), 0);
        AppMethodBeat.o(284972);
        return true;
      }
      AppMethodBeat.o(284972);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final int[] abR()
    {
      return new int[] { 34 };
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u hi(String paramString)
    {
      AppMethodBeat.i(19702);
      if (paramString.trim().startsWith("weixin://feedback/next/"))
      {
        paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 34, null);
        AppMethodBeat.o(19702);
        return paramString;
      }
      AppMethodBeat.o(19702);
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class FlightNumberSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    FlightNumberSpanHandler()
    {
      super();
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.i parami)
    {
      AppMethodBeat.i(289278);
      if (parami != null) {
        parami.a(paramu);
      }
      if (paramu.type == 50)
      {
        Log.i("MicroMsg.URISpanHandlerSet", "FlightNumberSpanHandler click %s", new Object[] { paramu.url });
        if ((paramu.bnW == null) || (!(paramu.bnW instanceof Bundle))) {
          break label120;
        }
      }
      label120:
      for (long l = ((Bundle)paramu.bnW).getLong("msgSvrId");; l = 0L)
      {
        ((com.tencent.mm.plugin.box.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.box.a.c.class)).b(URISpanHandlerSet.a(URISpanHandlerSet.this), paramu.url, l);
        if (parami != null) {
          parami.b(paramu);
        }
        AppMethodBeat.o(289278);
        return true;
      }
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final int[] abR()
    {
      return new int[] { 50 };
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u hi(String paramString)
    {
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class FriendMobileUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    FriendMobileUriSpanHandler()
    {
      super();
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.i parami)
    {
      AppMethodBeat.i(291499);
      if (paramu.type == 20)
      {
        if (parami != null) {
          parami.a(paramu);
        }
        Object localObject = new Intent(URISpanHandlerSet.a(URISpanHandlerSet.this), MobileFriendUI.class);
        paramView = URISpanHandlerSet.a(URISpanHandlerSet.this);
        localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/app/plugin/URISpanHandlerSet$FriendMobileUriSpanHandler", "handleSpanClick", "(Landroid/view/View;Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/app/plugin/URISpanHandlerSet$FriendMobileUriSpanHandler", "handleSpanClick", "(Landroid/view/View;Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        if (parami != null) {
          parami.b(paramu);
        }
        AppMethodBeat.o(291499);
        return true;
      }
      AppMethodBeat.o(291499);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      AppMethodBeat.i(19710);
      if (paramString.equals("weixin://findfriend/mobile"))
      {
        paramu = new Intent(URISpanHandlerSet.a(URISpanHandlerSet.this), MobileFriendUI.class);
        if ((URISpanHandlerSet.a(URISpanHandlerSet.this) instanceof Service)) {
          paramu.addFlags(268435456);
        }
        paramString = URISpanHandlerSet.a(URISpanHandlerSet.this);
        paramu = new com.tencent.mm.hellhoundlib.b.a().bm(paramu);
        com.tencent.mm.hellhoundlib.a.a.b(paramString, paramu.aFh(), "com/tencent/mm/app/plugin/URISpanHandlerSet$FriendMobileUriSpanHandler", "handleUriJump", "(Ljava/lang/String;ZLcom/tencent/mm/pluginsdk/UriJumpCallback;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)paramu.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/app/plugin/URISpanHandlerSet$FriendMobileUriSpanHandler", "handleUriJump", "(Ljava/lang/String;ZLcom/tencent/mm/pluginsdk/UriJumpCallback;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(19710);
        return true;
      }
      AppMethodBeat.o(19710);
      return false;
    }
    
    final int[] abR()
    {
      return new int[] { 20 };
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u hi(String paramString)
    {
      AppMethodBeat.i(19708);
      if (paramString.trim().startsWith("weixin://findfriend/mobile"))
      {
        paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 20, null);
        AppMethodBeat.o(19708);
        return paramString;
      }
      AppMethodBeat.o(19708);
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class FriendSearchUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    FriendSearchUriSpanHandler()
    {
      super();
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.i parami)
    {
      AppMethodBeat.i(292005);
      if (paramu.type == 17)
      {
        if (parami != null) {
          parami.a(paramu);
        }
        com.tencent.mm.by.c.ad(URISpanHandlerSet.a(URISpanHandlerSet.this), "subapp", ".ui.pluginapp.ContactSearchUI");
        if (parami != null) {
          parami.b(paramu);
        }
        AppMethodBeat.o(292005);
        return true;
      }
      AppMethodBeat.o(292005);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      AppMethodBeat.i(19713);
      if (paramString.equals("weixin://findfriend/search"))
      {
        paramString = new Intent();
        if ((URISpanHandlerSet.a(URISpanHandlerSet.this) instanceof Service)) {
          paramString.addFlags(268435456);
        }
        com.tencent.mm.by.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "subapp", ".ui.pluginapp.ContactSearchUI", paramString);
        AppMethodBeat.o(19713);
        return true;
      }
      AppMethodBeat.o(19713);
      return false;
    }
    
    final int[] abR()
    {
      return new int[] { 17 };
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u hi(String paramString)
    {
      AppMethodBeat.i(19711);
      if (paramString.trim().startsWith("weixin://findfriend/search"))
      {
        paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 17, null);
        AppMethodBeat.o(19711);
        return paramString;
      }
      AppMethodBeat.o(19711);
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class FriendShareUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    FriendShareUriSpanHandler()
    {
      super();
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.i parami)
    {
      AppMethodBeat.i(286232);
      if (paramu.type == 18)
      {
        if (parami != null) {
          parami.a(paramu);
        }
        com.tencent.mm.by.c.ad(URISpanHandlerSet.a(URISpanHandlerSet.this), "setting", ".ui.qrcode.ShareMicroMsgChoiceUI");
        if (parami != null) {
          parami.b(paramu);
        }
        AppMethodBeat.o(286232);
        return true;
      }
      AppMethodBeat.o(286232);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      AppMethodBeat.i(19716);
      if (paramString.equals("weixin://findfriend/share"))
      {
        paramString = new Intent();
        if ((URISpanHandlerSet.a(URISpanHandlerSet.this) instanceof Service)) {
          paramString.addFlags(268435456);
        }
        com.tencent.mm.by.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "setting", ".ui.qrcode.ShareMicroMsgChoiceUI", paramString);
        AppMethodBeat.o(19716);
        return true;
      }
      AppMethodBeat.o(19716);
      return false;
    }
    
    final int[] abR()
    {
      return new int[] { 18 };
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u hi(String paramString)
    {
      AppMethodBeat.i(19714);
      if (paramString.trim().startsWith("weixin://findfriend/share"))
      {
        paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 18, null);
        AppMethodBeat.o(19714);
        return paramString;
      }
      AppMethodBeat.o(19714);
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class HoneyPayLinkSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    HoneyPayLinkSpanHandler()
    {
      super();
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.i parami)
    {
      AppMethodBeat.i(276613);
      if (paramu.type == 46)
      {
        Log.i("MicroMsg.URISpanHandlerSet", "go to honey pay proxy");
        if ((paramu.bnW != null) && ((paramu.bnW instanceof Bundle)))
        {
          paramu = Uri.parse(paramu.url);
          paramView = paramu.getQueryParameter("cardNo");
          boolean bool = paramu.getQueryParameter("isPayer").equals("1");
          paramu = new Intent();
          paramu.putExtra("key_card_no", paramView);
          paramu.putExtra("key_is_payer", bool);
          com.tencent.mm.by.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "honey_pay", ".ui.HoneyPayProxyUI", paramu);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(276613);
        return false;
        if (paramu.type == 47)
        {
          Log.i("MicroMsg.URISpanHandlerSet", "go to bank card list");
          paramView = new Intent();
          paramView.putExtra("intent_finish_self", true);
          com.tencent.mm.by.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "wallet", ".bind.ui.WalletBankcardManageUI", paramView);
          com.tencent.mm.plugin.report.service.h.IzE.a(15191, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
        }
      }
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final int[] abR()
    {
      return new int[] { 46, 47 };
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u hi(String paramString)
    {
      AppMethodBeat.i(19717);
      if (paramString.trim().startsWith("native://wcpay/honeypay"))
      {
        paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 46, null);
        AppMethodBeat.o(19717);
        return paramString;
      }
      if (paramString.trim().startsWith("weixin://wcpay/bankCardList"))
      {
        paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 47, null);
        AppMethodBeat.o(19717);
        return paramString;
      }
      AppMethodBeat.o(19717);
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class JumpActivityUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    JumpActivityUriSpanHandler()
    {
      super();
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.i parami)
    {
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      AppMethodBeat.i(19721);
      if (paramString.toLowerCase().startsWith("weixin://jump/"))
      {
        paramString = paramString.split("/");
        paramString = paramString[(paramString.length - 1)];
        if ("mainframe".equalsIgnoreCase(paramString))
        {
          paramu = new Intent(URISpanHandlerSet.a(URISpanHandlerSet.this), LauncherUI.class);
          if ((URISpanHandlerSet.a(URISpanHandlerSet.this) instanceof Service)) {
            paramu.addFlags(268435456);
          }
          paramu.addFlags(67108864);
          paramString = URISpanHandlerSet.a(URISpanHandlerSet.this);
          paramu = new com.tencent.mm.hellhoundlib.b.a().bm(paramu);
          com.tencent.mm.hellhoundlib.a.a.b(paramString, paramu.aFh(), "com/tencent/mm/app/plugin/URISpanHandlerSet$JumpActivityUriSpanHandler", "handleUriJump", "(Ljava/lang/String;ZLcom/tencent/mm/pluginsdk/UriJumpCallback;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramString.startActivity((Intent)paramu.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/app/plugin/URISpanHandlerSet$JumpActivityUriSpanHandler", "handleUriJump", "(Ljava/lang/String;ZLcom/tencent/mm/pluginsdk/UriJumpCallback;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        for (;;)
        {
          AppMethodBeat.o(19721);
          return true;
          if ("shake".equalsIgnoreCase(paramString))
          {
            com.tencent.mm.plugin.report.service.h.IzE.kvStat(10221, "1");
            paramString = new Intent();
            paramString.addFlags(67108864);
            if ((URISpanHandlerSet.a(URISpanHandlerSet.this) instanceof Service)) {
              paramString.addFlags(268435456);
            }
            com.tencent.mm.by.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "shake", ".ui.ShakeReportUI", paramString);
            if ((URISpanHandlerSet.a(URISpanHandlerSet.this) != null) && ((URISpanHandlerSet.a(URISpanHandlerSet.this) instanceof Activity))) {
              ((Activity)URISpanHandlerSet.a(URISpanHandlerSet.this)).finish();
            }
          }
          else if ("scanqrcode".equalsIgnoreCase(paramString))
          {
            paramString = new Intent();
            paramString.putExtra("BaseScanUI_select_scan_mode", 1);
            paramString.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 2);
            paramString.setFlags(65536);
            paramString.addFlags(67108864);
            if ((URISpanHandlerSet.a(URISpanHandlerSet.this) instanceof Service)) {
              paramString.addFlags(268435456);
            }
            com.tencent.mm.by.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "scanner", ".ui.BaseScanUI", paramString);
          }
        }
      }
      AppMethodBeat.o(19721);
      return false;
    }
    
    final int[] abR()
    {
      return new int[0];
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u hi(String paramString)
    {
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class JumpPatSettingUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    JumpPatSettingUriSpanHandler()
    {
      super();
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.i parami)
    {
      AppMethodBeat.i(273911);
      if (paramu.type == 57)
      {
        Log.i("MicroMsg.URISpanHandlerSet", "handleClickJumpToPatSetting");
        paramu = new Intent();
        paramu.setClass(URISpanHandlerSet.a(URISpanHandlerSet.this), SettingsPersonalInfoUI.class);
        paramu.putExtra("jumptoPat", true);
        paramView = URISpanHandlerSet.a(URISpanHandlerSet.this);
        paramu = new com.tencent.mm.hellhoundlib.b.a().bm(paramu);
        com.tencent.mm.hellhoundlib.a.a.b(paramView, paramu.aFh(), "com/tencent/mm/app/plugin/URISpanHandlerSet$JumpPatSettingUriSpanHandler", "handleSpanClick", "(Landroid/view/View;Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramView.startActivity((Intent)paramu.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/app/plugin/URISpanHandlerSet$JumpPatSettingUriSpanHandler", "handleSpanClick", "(Landroid/view/View;Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      new MMHandler().postDelayed(new URISpanHandlerSet.JumpPatSettingUriSpanHandler.1(this), 2000L);
      AppMethodBeat.o(273911);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final int[] abR()
    {
      return new int[] { 57 };
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u hi(String paramString)
    {
      AppMethodBeat.i(273910);
      if (paramString.trim().toLowerCase().startsWith("weixin://jump/setpat/"))
      {
        paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 57, null);
        AppMethodBeat.o(273910);
        return paramString;
      }
      AppMethodBeat.o(273910);
      return null;
    }
  }
  
  @URISpanHandlerSet.a(abS=URISpanHandlerSet.PRIORITY.HIGH)
  class LuckyMoneyUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    LuckyMoneyUriSpanHandler()
    {
      super();
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.i parami)
    {
      AppMethodBeat.i(286238);
      if (paramu.type == 33)
      {
        Log.i("MicroMsg.URISpanHandlerSet", "hrefInfo.getType() == MMSpanConstants.Type.TYPE_LUCKY_MONEY_NORMAL");
        if (parami == null)
        {
          Log.i("MicroMsg.URISpanHandlerSet", "LuckyMoneyUriSpanHandler handleSpanClick() clickCallback == null");
          AppMethodBeat.o(286238);
          return false;
        }
        paramView = new Intent();
        paramView.putExtra("key_native_url", paramu.url);
        paramView.putExtra("key_username", (String)parami.a(paramu));
        paramView.putExtra("key_lucky_money_can_received", true);
        paramView.putExtra("key_jump_from", 4);
        paramView.putExtra("scene_id", 1002);
        if (paramu.url.startsWith("frhb://c2cbizmessagehandler/hongbao/receivehongbao"))
        {
          paramView.putExtra("key_hk_scene", 1);
          com.tencent.mm.by.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "luckymoney", ".hk.ui.LuckyMoneyHKBeforeDetailUI", paramView);
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.IzE.a(12097, new Object[] { Integer.valueOf(11), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
          com.tencent.mm.plugin.report.service.h.IzE.a(11850, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
          AppMethodBeat.o(286238);
          return true;
          com.tencent.mm.by.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "luckymoney", ".ui.LuckyMoneyBeforeDetailUI", paramView);
        }
      }
      if (paramu.type == 59)
      {
        Log.i("MicroMsg.URISpanHandlerSet", "hrefInfo.getType() == MMSpanConstants.Type.TYPE_LUCKY_MONEY_UNION");
        if (parami == null)
        {
          Log.i("MicroMsg.URISpanHandlerSet", "LuckyMoneyUriSpanHandler handleSpanClick() clickCallback == null");
          AppMethodBeat.o(286238);
          return false;
        }
        paramView = new Intent();
        paramView.putExtra("key_native_url", paramu.url);
        paramView.putExtra("key_username", (String)parami.a(paramu));
        paramView.putExtra("key_lucky_money_can_received", true);
        paramView.putExtra("key_jump_from", 4);
        paramView.putExtra("scene_id", 1005);
        com.tencent.mm.by.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "luckymoney", ".ui.LuckyMoneyBeforeDetailUI", paramView);
        com.tencent.mm.plugin.report.service.h.IzE.a(12097, new Object[] { Integer.valueOf(11), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
        com.tencent.mm.plugin.report.service.h.IzE.a(11850, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
        AppMethodBeat.o(286238);
        return true;
      }
      AppMethodBeat.o(286238);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final int[] abR()
    {
      return new int[] { 33, 59 };
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u hi(String paramString)
    {
      AppMethodBeat.i(19722);
      if ((paramString.trim().toLowerCase().startsWith("weixin://weixinhongbao/")) || (paramString.trim().toLowerCase().startsWith("frhb://c2cbizmessagehandler/hongbao/receivehongbao")))
      {
        paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 33, null);
        AppMethodBeat.o(19722);
        return paramString;
      }
      if (paramString.trim().toLowerCase().startsWith("weixin://weixinunionhongbao/"))
      {
        paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 59, null);
        AppMethodBeat.o(19722);
        return paramString;
      }
      AppMethodBeat.o(19722);
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class OfflineFQFSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    OfflineFQFSpanHandler()
    {
      super();
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.i parami)
    {
      AppMethodBeat.i(277448);
      if (paramu.type == 51)
      {
        Log.i("MicroMsg.URISpanHandlerSet", "go to offline fqf");
        if ((paramu.bnW != null) && ((paramu.bnW instanceof Bundle)))
        {
          Object localObject = (Bundle)paramu.bnW;
          paramView = ((Bundle)localObject).getString("repayment_tiny_app_username");
          localObject = ((Bundle)localObject).getString("repayment_tiny_app_path");
          xw localxw = new xw();
          localxw.fWN.userName = paramView;
          localxw.fWN.fWP = Util.nullAs((String)localObject, "");
          localxw.fWN.fWQ = 0;
          EventCenter.instance.publish(localxw);
        }
        if (parami != null) {
          parami.b(paramu);
        }
      }
      AppMethodBeat.o(277448);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final int[] abR()
    {
      return new int[] { 51 };
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u hi(String paramString)
    {
      AppMethodBeat.i(169680);
      if (paramString.trim().startsWith("weixin://wcpay/fqf/opentinyapp"))
      {
        paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 51, null);
        AppMethodBeat.o(169680);
        return paramString;
      }
      AppMethodBeat.o(169680);
      return null;
    }
  }
  
  static enum PRIORITY
  {
    static
    {
      AppMethodBeat.i(19726);
      LOW = new PRIORITY("LOW", 0);
      NORMAL = new PRIORITY("NORMAL", 1);
      HIGH = new PRIORITY("HIGH", 2);
      $VALUES = new PRIORITY[] { LOW, NORMAL, HIGH };
      AppMethodBeat.o(19726);
    }
    
    private PRIORITY() {}
  }
  
  @URISpanHandlerSet.a
  class PayTransferUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    PayTransferUriSpanHandler()
    {
      super();
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.i parami)
    {
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      AppMethodBeat.i(19727);
      if (paramString.startsWith("wxpay://"))
      {
        if (paramu == null) {
          break label245;
        }
        paramBundle = paramu.hfQ().toString();
        paramu = paramu.hfR();
        if (!(paramu instanceof com.tencent.mm.plugin.wallet.a)) {
          break label240;
        }
        paramu = (com.tencent.mm.plugin.wallet.a)paramu;
      }
      for (;;)
      {
        if (Util.isNullOrNil(paramBundle))
        {
          Log.e("MicroMsg.URISpanHandlerSet", "SERVICE_JUMP_TO_PAY fail, null username");
          AppMethodBeat.o(19727);
          return false;
        }
        String str = paramString.substring(8);
        paramString = str;
        if (str.indexOf("&") > 0) {
          paramString = str.split("&")[0];
        }
        int i = paramString.indexOf("=");
        if (i >= 0) {}
        for (paramString = paramString.substring(i + 1);; paramString = "")
        {
          if (Util.getInt(paramString, 0) == 1)
          {
            if ((z.bdr()) || (z.bds())) {
              f.a(URISpanHandlerSet.a(URISpanHandlerSet.this), 5, paramBundle, 11, paramu);
            }
            for (;;)
            {
              AppMethodBeat.o(19727);
              return true;
              f.a(URISpanHandlerSet.a(URISpanHandlerSet.this), 2, paramBundle, 11, paramu);
            }
          }
          Toast.makeText(URISpanHandlerSet.a(URISpanHandlerSet.this), URISpanHandlerSet.a(URISpanHandlerSet.this).getString(R.l.eSo), 0).show();
          AppMethodBeat.o(19727);
          return false;
          AppMethodBeat.o(19727);
          return false;
        }
        label240:
        paramu = null;
        continue;
        label245:
        paramu = null;
        paramBundle = null;
      }
    }
    
    final int[] abR()
    {
      return new int[0];
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u hi(String paramString)
    {
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class PluginUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    PluginUriSpanHandler()
    {
      super();
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.i parami)
    {
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      AppMethodBeat.i(19731);
      if (paramString.equals("weixin://plugin"))
      {
        paramString = new Intent();
        if ((URISpanHandlerSet.a(URISpanHandlerSet.this) instanceof Service)) {
          paramString.addFlags(268435456);
        }
        com.tencent.mm.by.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "setting", ".ui.setting.SettingsPluginsUI", paramString);
        AppMethodBeat.o(19731);
        return true;
      }
      AppMethodBeat.o(19731);
      return false;
    }
    
    final int[] abR()
    {
      return new int[] { 26 };
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u hi(String paramString)
    {
      AppMethodBeat.i(19730);
      if (paramString.trim().startsWith("weixin://plugin"))
      {
        paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 26, null);
        AppMethodBeat.o(19730);
        return paramString;
      }
      AppMethodBeat.o(19730);
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class ProfileUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    ProfileUriSpanHandler()
    {
      super();
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.i parami)
    {
      AppMethodBeat.i(287378);
      if (paramu.type == 3)
      {
        if (parami != null) {
          parami.a(paramu);
        }
        paramView = (String)paramu.bv(String.class);
        Intent localIntent = new Intent();
        localIntent.addFlags(268435456);
        localIntent.putExtra("Contact_User", paramView);
        bh.beI();
        as localas = com.tencent.mm.model.c.bbL().RG(paramView);
        if ((localas != null) && ((int)localas.jxt > 0) && (d.rk(localas.field_type))) {
          com.tencent.mm.ui.contact.e.a(localIntent, paramView);
        }
        if (Util.nullAsNil(paramView).length() > 0) {
          com.tencent.mm.by.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "profile", ".ui.ContactInfoUI", localIntent);
        }
        if (parami != null) {
          parami.b(paramu);
        }
        AppMethodBeat.o(287378);
        return true;
      }
      AppMethodBeat.o(287378);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      AppMethodBeat.i(19734);
      if (paramString.startsWith("weixin://contacts/profile/"))
      {
        paramString = paramString.trim().replace("weixin://contacts/profile/", "").replace("/", "");
        if (Util.isNullOrNil(paramString))
        {
          Log.e("MicroMsg.URISpanHandlerSet", "jumpToActivity fail, user is null");
          AppMethodBeat.o(19734);
          return true;
        }
        paramu = new Intent();
        paramu.addFlags(268435456);
        paramu.putExtra("Contact_User", paramString);
        bh.beI();
        paramBundle = com.tencent.mm.model.c.bbL().RG(paramString);
        if ((paramBundle != null) && ((int)paramBundle.jxt > 0) && (d.rk(paramBundle.field_type))) {
          com.tencent.mm.ui.contact.e.a(paramu, paramString);
        }
        com.tencent.mm.by.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "profile", ".ui.ContactInfoUI", paramu);
        AppMethodBeat.o(19734);
        return true;
      }
      AppMethodBeat.o(19734);
      return false;
    }
    
    final int[] abR()
    {
      return new int[] { 3 };
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u hi(String paramString)
    {
      AppMethodBeat.i(19732);
      if (paramString.trim().startsWith("weixin://contacts/profile/"))
      {
        paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 3, paramString.trim().replace("weixin://contacts/profile/", "").replace("/", ""));
        AppMethodBeat.o(19732);
        return paramString;
      }
      AppMethodBeat.o(19732);
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class ScanQrCodeUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    ScanQrCodeUriSpanHandler()
    {
      super();
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.i parami)
    {
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      int j = 0;
      AppMethodBeat.i(19735);
      if (paramString.equals("weixin://scanqrcode/"))
      {
        if (!paramBoolean)
        {
          Log.e("MicroMsg.URISpanHandlerSet", "jumpToActivity, scan qrcode permission fail");
          AppMethodBeat.o(19735);
          return true;
        }
        paramString = new Intent();
        paramString.putExtra("BaseScanUI_select_scan_mode", 1);
        int i = j;
        if (paramBundle != null)
        {
          i = j;
          if (paramBundle.getInt("fromScene") == 100) {
            i = 1;
          }
        }
        if (i == 0) {
          paramString.addFlags(67108864);
        }
        if ((URISpanHandlerSet.a(URISpanHandlerSet.this) instanceof Service)) {
          paramString.addFlags(268435456);
        }
        com.tencent.mm.by.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "scanner", ".ui.BaseScanUI", paramString);
        AppMethodBeat.o(19735);
        return true;
      }
      AppMethodBeat.o(19735);
      return false;
    }
    
    final int[] abR()
    {
      return new int[0];
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u hi(String paramString)
    {
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class SetSafeDeviceUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    SetSafeDeviceUriSpanHandler()
    {
      super();
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.i parami)
    {
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      AppMethodBeat.i(19736);
      if (paramString.equals("weixin://setting/account/safedevice"))
      {
        bh.beI();
        paramString = (String)com.tencent.mm.model.c.aHp().b(6, "");
        bh.beI();
        paramu = (String)com.tencent.mm.model.c.aHp().b(4097, "");
        if (!Util.isNullOrNil(paramString))
        {
          paramString = new Intent();
          if ((URISpanHandlerSet.a(URISpanHandlerSet.this) instanceof Service)) {
            paramString.addFlags(268435456);
          }
          com.tencent.mm.by.c.ad(URISpanHandlerSet.a(URISpanHandlerSet.this), "account", ".security.ui.MySafeDeviceListUI");
        }
        for (;;)
        {
          AppMethodBeat.o(19736);
          return true;
          if (!Util.isNullOrNil(paramu))
          {
            paramString = new Intent(URISpanHandlerSet.a(URISpanHandlerSet.this), BindMContactIntroUI.class);
            paramString.putExtra("bind_scene", 1);
            if ((URISpanHandlerSet.a(URISpanHandlerSet.this) instanceof Service)) {
              paramString.addFlags(268435456);
            }
            MMWizardActivity.aH(URISpanHandlerSet.a(URISpanHandlerSet.this), paramString);
          }
          else
          {
            paramString = new Intent();
            if ((URISpanHandlerSet.a(URISpanHandlerSet.this) instanceof Service)) {
              paramString.addFlags(268435456);
            }
            com.tencent.mm.by.c.a(URISpanHandlerSet.a(URISpanHandlerSet.this), "account", ".security.ui.BindSafeDeviceUI", paramString);
          }
        }
      }
      AppMethodBeat.o(19736);
      return false;
    }
    
    final int[] abR()
    {
      return new int[0];
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u hi(String paramString)
    {
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class SettingPluginLomoUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    SettingPluginLomoUriSpanHandler()
    {
      super();
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.i parami)
    {
      AppMethodBeat.i(243034);
      if (paramu.type == 12)
      {
        if (parami != null) {
          parami.a(paramu);
        }
        paramView = new Intent();
        paramView.putExtra("Contact_User", "weibo");
        com.tencent.mm.by.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "profile", ".ui.ContactInfoUI", paramView);
        if (parami != null) {
          parami.b(paramu);
        }
        AppMethodBeat.o(243034);
        return true;
      }
      AppMethodBeat.o(243034);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      AppMethodBeat.i(19750);
      if (paramString.equals("weixin://setting/plugin/lomo"))
      {
        paramString = new Intent();
        paramString.putExtra("Contact_User", "weibo");
        if ((URISpanHandlerSet.a(URISpanHandlerSet.this) instanceof Service)) {
          paramString.addFlags(268435456);
        }
        com.tencent.mm.by.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "profile", ".ui.ContactInfoUI", paramString);
        AppMethodBeat.o(19750);
        return true;
      }
      AppMethodBeat.o(19750);
      return false;
    }
    
    final int[] abR()
    {
      return new int[] { 12 };
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u hi(String paramString)
    {
      AppMethodBeat.i(19748);
      if (paramString.trim().startsWith("weixin://setting/plugin/lomo"))
      {
        paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 12, null);
        AppMethodBeat.o(19748);
        return paramString;
      }
      AppMethodBeat.o(19748);
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class SettingPluginQQMailUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    SettingPluginQQMailUriSpanHandler()
    {
      super();
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.i parami)
    {
      AppMethodBeat.i(279029);
      if (paramu.type == 10)
      {
        if (parami != null) {
          parami.a(paramu);
        }
        paramView = new Intent();
        paramView.putExtra("Contact_User", "qqmail");
        com.tencent.mm.by.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "profile", ".ui.ContactInfoUI", paramView);
        if (parami != null) {
          parami.b(paramu);
        }
        AppMethodBeat.o(279029);
        return true;
      }
      AppMethodBeat.o(279029);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      AppMethodBeat.i(19753);
      if (paramString.equals("weixin://setting/plugin/qqmail"))
      {
        paramString = new Intent();
        paramString.putExtra("Contact_User", "qqmail");
        if ((URISpanHandlerSet.a(URISpanHandlerSet.this) instanceof Service)) {
          paramString.addFlags(268435456);
        }
        com.tencent.mm.by.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "profile", ".ui.ContactInfoUI", paramString);
        AppMethodBeat.o(19753);
        return true;
      }
      AppMethodBeat.o(19753);
      return false;
    }
    
    final int[] abR()
    {
      return new int[] { 10 };
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u hi(String paramString)
    {
      AppMethodBeat.i(19751);
      if (paramString.trim().startsWith("weixin://setting/plugin/qqmail"))
      {
        paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 10, null);
        AppMethodBeat.o(19751);
        return paramString;
      }
      AppMethodBeat.o(19751);
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class SettingPluginQQMsgUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    SettingPluginQQMsgUriSpanHandler()
    {
      super();
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.i parami)
    {
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final int[] abR()
    {
      return new int[] { 13 };
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u hi(String paramString)
    {
      AppMethodBeat.i(19754);
      if (paramString.trim().startsWith("weixin://setting/plugin/qqmsg"))
      {
        paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 13, null);
        AppMethodBeat.o(19754);
        return paramString;
      }
      AppMethodBeat.o(19754);
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class SettingPluginSxMsgUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    SettingPluginSxMsgUriSpanHandler()
    {
      super();
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.i parami)
    {
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final int[] abR()
    {
      return new int[] { 11 };
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u hi(String paramString)
    {
      AppMethodBeat.i(19755);
      if (paramString.trim().startsWith("weixin://setting/plugin/sxmsg"))
      {
        paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 11, null);
        AppMethodBeat.o(19755);
        return paramString;
      }
      AppMethodBeat.o(19755);
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class UnKnowToUrlSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    UnKnowToUrlSpanHandler()
    {
      super();
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.i parami)
    {
      AppMethodBeat.i(226583);
      if (paramu.type == 2147483646)
      {
        if ((paramu.bnW instanceof Bundle))
        {
          paramView = ((Bundle)paramu.bnW).getString("rawUrl");
          if (Util.isNullOrNil(paramView)) {
            Log.i("MicroMsg.URISpanHandlerSet", "TYPE_UNKNOW_TO_URL url == null");
          }
        }
        for (;;)
        {
          AppMethodBeat.o(226583);
          return true;
          com.tencent.mm.plugin.account.sdk.b.a.b(MMApplicationContext.getContext(), paramView, 0, true);
          continue;
          Log.i("MicroMsg.URISpanHandlerSet", "TYPE_UNKNOW_TO_URL hrefInfo.getData() no instanceof Bundle");
        }
      }
      AppMethodBeat.o(226583);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final int[] abR()
    {
      return new int[] { 2147483646 };
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u hi(String paramString)
    {
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class UpgradeAssociateChatRoomUrlSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    UpgradeAssociateChatRoomUrlSpanHandler()
    {
      super();
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.i parami)
    {
      AppMethodBeat.i(278406);
      if (paramu.type == 53) {
        Log.i("MicroMsg.URISpanHandlerSet", "handleClickUpgradeAssociateChatRoomUrl");
      }
      for (;;)
      {
        int i;
        try
        {
          paramView = Uri.parse(paramu.url).getQueryParameter("roomname");
          if (Util.isNullOrNil(paramView))
          {
            Log.w("MicroMsg.URISpanHandlerSet", "Username is null.");
            AppMethodBeat.o(278406);
            return true;
          }
          if (ab.Lj(paramView))
          {
            parami = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(paramView);
            if (parami == null)
            {
              Log.e("MicroMsg.URISpanHandlerSet", "handleClickUpgradeAssociateChatRoomUrl %s member is null", new Object[] { paramView });
              AppMethodBeat.o(278406);
              return true;
            }
            Log.i("MicroMsg.URISpanHandlerSet", "handleClickUpgradeAssociateChatRoomUrl room:%s chatroomStatus:%s owener:%s", new Object[] { paramView, Integer.valueOf(parami.field_chatroomStatus), Util.nullAs(parami.field_roomowner, "") });
            if (parami.field_memberCount >= v.bcU())
            {
              i = 1;
              if (!ab.PV(paramView)) {
                break label300;
              }
              if (parami.Rh(z.bcZ())) {
                break label392;
              }
              Log.i("MicroMsg.URISpanHandlerSet", "handleClickUpgradeAssociateChatRoomUrl：no owner");
              if (URISpanHandlerSet.a(URISpanHandlerSet.this) != null)
              {
                com.tencent.mm.ui.base.h.a(URISpanHandlerSet.a(URISpanHandlerSet.this), URISpanHandlerSet.a(URISpanHandlerSet.this).getString(R.l.chatroom_sys_msg_room_upgrade_to_wework_no_owner), "", URISpanHandlerSet.a(URISpanHandlerSet.this).getString(R.l.app_i_know), false, null);
                break label628;
                ManagerRoomByWeworkUI.d(paramView, 2, 2, j);
                AppMethodBeat.o(278406);
                return true;
              }
            }
            else
            {
              i = 0;
              continue;
            }
            Log.e("MicroMsg.URISpanHandlerSet", "handleClickUpgradeAssociateChatRoomUrl：mContext is null");
          }
        }
        catch (Exception paramView)
        {
          Log.e("MicroMsg.URISpanHandlerSet", "handle click link error: %s, url: %s", new Object[] { paramView.getMessage(), paramu.url });
        }
        for (;;)
        {
          AppMethodBeat.o(278406);
          return true;
          label300:
          if ((ab.PT(paramView)) && (!parami.Rh(z.bcZ())))
          {
            Log.i("MicroMsg.URISpanHandlerSet", "handleClickUpgradeAssociateChatRoomUrl：isAssociateChatRoom ");
            if (URISpanHandlerSet.a(URISpanHandlerSet.this) != null) {
              com.tencent.mm.ui.base.h.a(URISpanHandlerSet.a(URISpanHandlerSet.this), URISpanHandlerSet.a(URISpanHandlerSet.this).getString(R.l.chatroom_sys_msg_room_upgrade_to_wework_done), "", URISpanHandlerSet.a(URISpanHandlerSet.this).getString(R.l.app_i_know), false, null);
            }
            for (;;)
            {
              AppMethodBeat.o(278406);
              return true;
              Log.e("MicroMsg.URISpanHandlerSet", "handleClickUpgradeAssociateChatRoomUrl：mContext is null");
            }
          }
          label392:
          if (i != 0)
          {
            Log.i("MicroMsg.URISpanHandlerSet", "handleClickUpgradeAssociateChatRoomUrl：exceed maxnum");
            if (URISpanHandlerSet.a(URISpanHandlerSet.this) != null) {
              com.tencent.mm.ui.base.h.a(URISpanHandlerSet.a(URISpanHandlerSet.this), URISpanHandlerSet.a(URISpanHandlerSet.this).getString(R.l.chatroom_sys_msg_room_upgrade_to_wework_exceed_max_num), "", URISpanHandlerSet.a(URISpanHandlerSet.this).getString(R.l.app_i_know), false, null);
            }
            for (;;)
            {
              ManagerRoomByWeworkUI.d(paramView, 2, 2, 2);
              AppMethodBeat.o(278406);
              return true;
              Log.e("MicroMsg.URISpanHandlerSet", "handleClickUpgradeAssociateChatRoomUrl：mContext is null");
            }
          }
          com.tencent.mm.plugin.newtips.a.fiO().aap(25);
          com.tencent.mm.plugin.newtips.a.fiO().aap(26);
          com.tencent.mm.plugin.newtips.a.fiO().aap(27);
          parami = new Intent();
          parami.setClass(MMApplicationContext.getContext(), ManagerRoomByWeworkUI.class);
          parami.addFlags(268435456);
          parami.putExtra("RoomInfo_Id", paramView);
          parami.putExtra("upgrade_openim_room_from_scene", 2);
          paramView = MMApplicationContext.getContext();
          parami = new com.tencent.mm.hellhoundlib.b.a().bm(parami);
          com.tencent.mm.hellhoundlib.a.a.b(paramView, parami.aFh(), "com/tencent/mm/app/plugin/URISpanHandlerSet$UpgradeAssociateChatRoomUrlSpanHandler", "handleSpanClick", "(Landroid/view/View;Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramView.startActivity((Intent)parami.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/app/plugin/URISpanHandlerSet$UpgradeAssociateChatRoomUrlSpanHandler", "handleSpanClick", "(Landroid/view/View;Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(278406);
        return false;
        label628:
        int j = 1;
        if (i != 0) {
          j = 3;
        }
      }
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final int[] abR()
    {
      return new int[] { 53 };
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u hi(String paramString)
    {
      AppMethodBeat.i(179565);
      if (paramString.trim().toLowerCase().startsWith("weixin://weixingroupupdate?"))
      {
        paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 53, null);
        AppMethodBeat.o(179565);
        return paramString;
      }
      AppMethodBeat.o(179565);
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class VerifyContactUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    VerifyContactUriSpanHandler()
    {
      super();
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.i parami)
    {
      AppMethodBeat.i(285860);
      if (paramu.type == 4)
      {
        if (parami != null)
        {
          parami.a(paramu);
          parami.b(paramu);
        }
        AppMethodBeat.o(285860);
        return true;
      }
      AppMethodBeat.o(285860);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final int[] abR()
    {
      return new int[] { 4 };
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u hi(String paramString)
    {
      AppMethodBeat.i(19764);
      if (paramString.trim().startsWith("weixin://findfriend/verifycontact"))
      {
        paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 4, null);
        AppMethodBeat.o(19764);
        return paramString;
      }
      AppMethodBeat.o(19764);
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class VoipCallAgainUrilSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    VoipCallAgainUrilSpanHandler()
    {
      super();
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.i parami)
    {
      AppMethodBeat.i(292059);
      if (paramu.type == 38)
      {
        paramu = Uri.parse(paramu.url);
        paramView = paramu.getQueryParameter("username");
        paramu = paramu.getQueryParameter("isvideocall");
        parami = new aaq();
        parami.fZM.fDn = 5;
        parami.fZM.talker = paramView;
        parami.fZM.context = URISpanHandlerSet.a(URISpanHandlerSet.this);
        if ((paramView != null) && (!paramView.equals("")))
        {
          if ((paramu != null) && (paramu.equals("true"))) {}
          for (parami.fZM.fZI = 2;; parami.fZM.fZI = 4)
          {
            EventCenter.instance.publish(parami);
            AppMethodBeat.o(292059);
            return true;
          }
        }
      }
      AppMethodBeat.o(292059);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final int[] abR()
    {
      return new int[] { 38 };
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u hi(String paramString)
    {
      AppMethodBeat.i(19766);
      if (paramString.trim().startsWith("weixin://voip/callagain/"))
      {
        paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 38, null);
        AppMethodBeat.o(19766);
        return paramString;
      }
      AppMethodBeat.o(19766);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet
 * JD-Core Version:    0.7.0.1
 */