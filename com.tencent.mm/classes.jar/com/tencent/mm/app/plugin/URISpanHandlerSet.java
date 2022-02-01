package com.tencent.mm.app.plugin;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.g.a.cc;
import com.tencent.mm.g.a.cd;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.g.b.a.lh;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.bind.ui.MobileFriendUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandCheckWxaShortLinkUI;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC.a;
import com.tencent.mm.plugin.setting.model.m;
import com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalInfoUI;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.plugin.websearch.api.ag;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.pluginsdk.ui.span.i;
import com.tencent.mm.pluginsdk.ui.span.t.b;
import com.tencent.mm.protocal.protobuf.czj;
import com.tencent.mm.protocal.protobuf.egl;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.e;
import com.tencent.mm.ui.e.e;
import com.tencent.mm.vfs.s;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;
import kotlin.g.b.p;

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
    
    final int[] Xp()
    {
      return new int[] { 35, 36, 37 };
    }
    
    final boolean a(final View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, final i parami)
    {
      AppMethodBeat.i(231415);
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
              AppMethodBeat.o(231415);
              return true;
            }
            int i = Util.getInt(paramView.getQueryParameter("scene"), 3);
            if (!(paramu.data instanceof Bundle)) {
              continue;
            }
            paramView = ((Bundle)paramu.data).getString("chatroom_name");
            localObject = new Intent();
            ((Intent)localObject).putExtra("bill_no", parami);
            ((Intent)localObject).putExtra("enter_scene", i);
            ((Intent)localObject).putExtra("chatroom", paramView);
            com.tencent.mm.br.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "aa", ".ui.PaylistAAUI", (Intent)localObject);
          }
          catch (Exception paramView)
          {
            Log.e("MicroMsg.URISpanHandlerSet", "handle click new aa open detail link error: %s, url: %s", new Object[] { paramView.getMessage(), paramu.url });
            continue;
          }
          AppMethodBeat.o(231415);
          return true;
          if ((paramu.data instanceof String))
          {
            paramView = paramu.data.toString();
          }
          else
          {
            Log.e("MicroMsg.URISpanHandlerSet", "illegal data type, %s", new Object[] { paramu });
            AppMethodBeat.o(231415);
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
            AppMethodBeat.o(231415);
            return true;
          }
          if (!(paramu.data instanceof Bundle))
          {
            Log.e("MicroMsg.URISpanHandlerSet", "error data!");
            AppMethodBeat.o(231415);
            return true;
          }
          parami = (Bundle)paramu.data;
          localObject = parami.getString("chatroom_name");
          if (Util.isNullOrNil((String)localObject))
          {
            Log.e("MicroMsg.URISpanHandlerSet", "empty chatroom!");
            AppMethodBeat.o(231415);
            return true;
          }
          l = parami.getLong("msg_id", -1L);
          if (l < 0L)
          {
            Log.e("MicroMsg.URISpanHandlerSet", "msgId is null");
            AppMethodBeat.o(231415);
            return true;
          }
          com.tencent.mm.ui.base.h.a(URISpanHandlerSet.a(URISpanHandlerSet.this), 2131766351, -1, 2131766354, 2131756929, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(19673);
              paramAnonymousDialogInterface = new cc();
              paramAnonymousDialogInterface.dFj.dFk = paramView;
              paramAnonymousDialogInterface.dFj.dFl = this.dnY;
              paramAnonymousDialogInterface.dFj.dFm = l;
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
        AppMethodBeat.o(231415);
        return false;
        if (paramu.type == 36) {
          try
          {
            parami = Uri.parse(paramu.url).getQueryParameter("billno");
            if (Util.isNullOrNil(parami))
            {
              Log.e("MicroMsg.URISpanHandlerSet", "url error, billno is null");
              AppMethodBeat.o(231415);
              return true;
            }
            paramView = null;
            if ((paramu.data instanceof Bundle)) {
              paramView = (Bundle)paramu.data;
            }
            if ((paramView == null) || (Util.isNullOrNil(paramView.getString("chatroom_name"))))
            {
              Log.e("MicroMsg.URISpanHandlerSet", "empty chatroom!");
              AppMethodBeat.o(231415);
              return true;
            }
            localObject = paramView.getString("chatroom_name");
            l = paramView.getLong("msg_id", -1L);
            com.tencent.mm.ui.base.h.a(URISpanHandlerSet.a(URISpanHandlerSet.this), 2131766352, -1, 2131766353, 2131756929, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(19674);
                paramAnonymousDialogInterface = new cd();
                paramAnonymousDialogInterface.dFn.dFk = parami;
                paramAnonymousDialogInterface.dFn.dFl = this.dnY;
                paramAnonymousDialogInterface.dFn.dFm = l;
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
    
    final com.tencent.mm.pluginsdk.ui.applet.u gx(String paramString)
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
    
    final int[] Xp()
    {
      return new int[] { 44 };
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami)
    {
      AppMethodBeat.i(231416);
      if (paramu.type == 44)
      {
        paramu = Uri.parse("geo:0,0?q=" + Uri.encode(paramu.url));
        paramView = new Intent("android.intent.action.VIEW");
        paramView.setData(paramu);
        paramView.addFlags(268435456);
        if (paramView.resolveActivity(MMApplicationContext.getContext().getPackageManager()) != null)
        {
          paramu = MMApplicationContext.getContext();
          paramView = new com.tencent.mm.hellhoundlib.b.a().bl(paramView);
          com.tencent.mm.hellhoundlib.a.a.a(paramu, paramView.axQ(), "com/tencent/mm/app/plugin/URISpanHandlerSet$AddressUriSpanHandler", "handleSpanClick", "(Landroid/view/View;Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramu.startActivity((Intent)paramView.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramu, "com/tencent/mm/app/plugin/URISpanHandlerSet$AddressUriSpanHandler", "handleSpanClick", "(Landroid/view/View;Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.plugin.report.service.h.CyF.a(12809, new Object[] { Integer.valueOf(9), "" });
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.CyF.a(12809, new Object[] { Integer.valueOf(8), "" });
          AppMethodBeat.o(231416);
          return true;
          Log.w("MicroMsg.URISpanHandlerSet", "Cannot find map app");
        }
      }
      AppMethodBeat.o(231416);
      return false;
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
  
  @URISpanHandlerSet.a
  class AlphaInstallUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    AlphaInstallUriSpanHandler()
    {
      super();
    }
    
    final int[] Xp()
    {
      return new int[] { 32 };
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami)
    {
      AppMethodBeat.i(231417);
      if (paramu.type == 32)
      {
        paramView = paramu.url.replace("weixin://alphainstall?", "");
        paramu = Uri.parse(paramView).getQueryParameter("md5");
        paramu = com.tencent.mm.loader.j.b.aKJ() + paramu + ".apk";
        if (s.YS(paramu)) {
          com.tencent.mm.pluginsdk.model.app.r.b(MMApplicationContext.getContext(), paramu, null, false);
        }
        for (;;)
        {
          AppMethodBeat.o(231417);
          return true;
          paramu = new Intent();
          paramu.putExtra("rawUrl", paramView.toString());
          com.tencent.mm.br.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "webview", ".ui.tools.WebViewUI", paramu);
        }
      }
      AppMethodBeat.o(231417);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u gx(String paramString)
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
  
  abstract class BaseUriSpanHandler
  {
    public BaseUriSpanHandler() {}
    
    abstract int[] Xp();
    
    abstract boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami);
    
    abstract boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle);
    
    abstract com.tencent.mm.pluginsdk.ui.applet.u gx(String paramString);
  }
  
  @URISpanHandlerSet.a
  class BindMobileUrilSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    BindMobileUrilSpanHandler()
    {
      super();
    }
    
    final int[] Xp()
    {
      return new int[] { 5 };
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami)
    {
      AppMethodBeat.i(231419);
      if (paramu.type == 5)
      {
        if (parami != null) {
          parami.a(paramu);
        }
        MMWizardActivity.ay(URISpanHandlerSet.a(URISpanHandlerSet.this), new Intent(URISpanHandlerSet.a(URISpanHandlerSet.this), BindMContactIntroUI.class));
        if (parami != null) {
          parami.b(paramu);
        }
        AppMethodBeat.o(231419);
        return true;
      }
      AppMethodBeat.o(231419);
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
        MMWizardActivity.ay(URISpanHandlerSet.a(URISpanHandlerSet.this), paramString);
        AppMethodBeat.o(19683);
        return true;
      }
      AppMethodBeat.o(19683);
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u gx(String paramString)
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
    
    final int[] Xp()
    {
      return new int[0];
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami)
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
          paramString = paramu.glZ().toString();
        }
        paramu = new Intent();
        paramu.putExtra("user_name", paramString);
        paramu.putExtra("view_type", 1);
        com.tencent.mm.br.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "card", ".ui.CardViewUI", paramu);
        AppMethodBeat.o(19686);
        return true;
      }
      AppMethodBeat.o(19686);
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u gx(String paramString)
    {
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
    
    final int[] Xp()
    {
      return new int[] { 29 };
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami)
    {
      AppMethodBeat.i(231423);
      if (paramu.type == 29)
      {
        if (parami != null) {
          parami.a(paramu);
        }
        paramView = new Intent();
        paramView.putExtra("download_entrance_scene", 21);
        paramView.putExtra("extra_id", (String)paramu.ba(String.class));
        paramView.putExtra("preceding_scence", 3);
        com.tencent.mm.br.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "emoji", ".ui.EmojiStoreDetailUI", paramView);
        if (parami != null) {
          parami.b(paramu);
        }
        AppMethodBeat.o(231423);
        return true;
      }
      AppMethodBeat.o(231423);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u gx(String paramString)
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
    
    final int[] Xp()
    {
      return new int[] { 55 };
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami)
    {
      AppMethodBeat.i(231425);
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
            if (ab.Eq(paramView))
            {
              bg.aVF();
              parami = com.tencent.mm.model.c.aSN().Kn(paramView);
              if ((parami == null) || ((int)parami.gMZ == 0))
              {
                parami = new as();
                parami.setUsername(paramView);
                bg.aVF();
                com.tencent.mm.model.c.aSN().ap(parami);
              }
            }
            Object localObject = new Intent(URISpanHandlerSet.a(URISpanHandlerSet.this), ChattingUI.class).putExtra("Chat_User", paramView).putExtra("Chat_Mode", 1);
            if ((URISpanHandlerSet.a(URISpanHandlerSet.this) instanceof Service)) {
              ((Intent)localObject).addFlags(268435456);
            }
            parami = URISpanHandlerSet.a(URISpanHandlerSet.this);
            localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(parami, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/app/plugin/URISpanHandlerSet$EnterChatRoomUriSpanHandler", "handleSpanClick", "(Landroid/view/View;Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            parami.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(parami, "com/tencent/mm/app/plugin/URISpanHandlerSet$EnterChatRoomUriSpanHandler", "handleSpanClick", "(Landroid/view/View;Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            if (paramu.fRg == 1)
            {
              parami = Util.nullAs(paramu.chatroomName, "");
              com.tencent.mm.chatroom.c.b.f(Util.nullAs(paramView, ""), parami, 3);
              Log.i("MicroMsg.URISpanHandlerSet", "handleClickEnterChatRoomSystemMsgUrl migrate(%s -> %s)", new Object[] { parami, Util.nullAs(paramView, "") });
            }
            AppMethodBeat.o(231425);
            return true;
          }
        }
        catch (Exception paramView)
        {
          Log.e("MicroMsg.URISpanHandlerSet", "handle click link error: %s, url: %s", new Object[] { paramView.getMessage(), paramu.url });
        }
      }
      AppMethodBeat.o(231425);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u gx(String paramString)
    {
      AppMethodBeat.i(231424);
      if (paramString.trim().toLowerCase().startsWith("weixin://jump/chatroom/"))
      {
        paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 55, null);
        AppMethodBeat.o(231424);
        return paramString;
      }
      AppMethodBeat.o(231424);
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
    
    final int[] Xp()
    {
      return new int[0];
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami)
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
          if (ab.Eq(paramString))
          {
            bg.aVF();
            paramu = com.tencent.mm.model.c.aSN().Kn(paramString);
            if ((paramu == null) || ((int)paramu.gMZ == 0))
            {
              paramu = new as();
              paramu.setUsername(paramString);
              bg.aVF();
              com.tencent.mm.model.c.aSN().ap(paramu);
            }
          }
          paramu = new Intent(URISpanHandlerSet.a(URISpanHandlerSet.this), ChattingUI.class).putExtra("Chat_User", paramString).putExtra("Chat_Mode", 1);
          if ((URISpanHandlerSet.a(URISpanHandlerSet.this) instanceof Service)) {
            paramu.addFlags(268435456);
          }
          paramString = URISpanHandlerSet.a(URISpanHandlerSet.this);
          paramu = new com.tencent.mm.hellhoundlib.b.a().bl(paramu);
          com.tencent.mm.hellhoundlib.a.a.a(paramString, paramu.axQ(), "com/tencent/mm/app/plugin/URISpanHandlerSet$EnterRoomUriSpanHandler", "handleUriJump", "(Ljava/lang/String;ZLcom/tencent/mm/pluginsdk/UriJumpCallback;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramString.startActivity((Intent)paramu.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/app/plugin/URISpanHandlerSet$EnterRoomUriSpanHandler", "handleUriJump", "(Ljava/lang/String;ZLcom/tencent/mm/pluginsdk/UriJumpCallback;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(19699);
          return true;
        }
      }
      AppMethodBeat.o(19699);
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u gx(String paramString)
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
    
    final int[] Xp()
    {
      return new int[] { 31 };
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami)
    {
      AppMethodBeat.i(231426);
      if (paramu.type == 31)
      {
        paramView = new Intent();
        if (parami == null)
        {
          AppMethodBeat.o(231426);
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
        paramView.putExtra("rawUrl", String.format(e.e.OyU, new Object[] { Integer.valueOf(i) }));
        com.tencent.mm.br.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "webview", ".ui.tools.WebViewUI", paramView);
        AppMethodBeat.o(231426);
        return true;
        AppMethodBeat.o(231426);
        return false;
      }
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u gx(String paramString)
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
    
    final int[] Xp()
    {
      return new int[] { 34 };
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami)
    {
      AppMethodBeat.i(231427);
      if (paramu.type == 34)
      {
        paramView = paramu.url.trim().replace("weixin://feedback/next/", "");
        Log.d("MicroMsg.URISpanHandlerSet", "FeedbackUriSpanHandler, url:%s, content:%s", new Object[] { paramu.url, paramView });
        bg.azz().a(new m(q.aoL(), paramView, 8), 0);
        AppMethodBeat.o(231427);
        return true;
      }
      AppMethodBeat.o(231427);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u gx(String paramString)
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
    
    final int[] Xp()
    {
      return new int[] { 50 };
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami)
    {
      AppMethodBeat.i(231428);
      if (parami != null) {
        parami.a(paramu);
      }
      if (paramu.type == 50)
      {
        Log.i("MicroMsg.URISpanHandlerSet", "FlightNumberSpanHandler click %s", new Object[] { paramu.url });
        if ((paramu.data == null) || (!(paramu.data instanceof Bundle))) {
          break label120;
        }
      }
      label120:
      for (long l = ((Bundle)paramu.data).getLong("msgSvrId");; l = 0L)
      {
        ((com.tencent.mm.plugin.box.a.c)g.af(com.tencent.mm.plugin.box.a.c.class)).b(URISpanHandlerSet.a(URISpanHandlerSet.this), paramu.url, l);
        if (parami != null) {
          parami.b(paramu);
        }
        AppMethodBeat.o(231428);
        return true;
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
  
  @URISpanHandlerSet.a
  class FriendMobileUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    FriendMobileUriSpanHandler()
    {
      super();
    }
    
    final int[] Xp()
    {
      return new int[] { 20 };
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami)
    {
      AppMethodBeat.i(231430);
      if (paramu.type == 20)
      {
        if (parami != null) {
          parami.a(paramu);
        }
        Object localObject = new Intent(URISpanHandlerSet.a(URISpanHandlerSet.this), MobileFriendUI.class);
        paramView = URISpanHandlerSet.a(URISpanHandlerSet.this);
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/app/plugin/URISpanHandlerSet$FriendMobileUriSpanHandler", "handleSpanClick", "(Landroid/view/View;Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/app/plugin/URISpanHandlerSet$FriendMobileUriSpanHandler", "handleSpanClick", "(Landroid/view/View;Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        if (parami != null) {
          parami.b(paramu);
        }
        AppMethodBeat.o(231430);
        return true;
      }
      AppMethodBeat.o(231430);
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
        paramu = new com.tencent.mm.hellhoundlib.b.a().bl(paramu);
        com.tencent.mm.hellhoundlib.a.a.a(paramString, paramu.axQ(), "com/tencent/mm/app/plugin/URISpanHandlerSet$FriendMobileUriSpanHandler", "handleUriJump", "(Ljava/lang/String;ZLcom/tencent/mm/pluginsdk/UriJumpCallback;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)paramu.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/app/plugin/URISpanHandlerSet$FriendMobileUriSpanHandler", "handleUriJump", "(Ljava/lang/String;ZLcom/tencent/mm/pluginsdk/UriJumpCallback;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(19710);
        return true;
      }
      AppMethodBeat.o(19710);
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u gx(String paramString)
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
    
    final int[] Xp()
    {
      return new int[] { 17 };
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami)
    {
      AppMethodBeat.i(231431);
      if (paramu.type == 17)
      {
        if (parami != null) {
          parami.a(paramu);
        }
        com.tencent.mm.br.c.V(URISpanHandlerSet.a(URISpanHandlerSet.this), "subapp", ".ui.pluginapp.ContactSearchUI");
        if (parami != null) {
          parami.b(paramu);
        }
        AppMethodBeat.o(231431);
        return true;
      }
      AppMethodBeat.o(231431);
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
        com.tencent.mm.br.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "subapp", ".ui.pluginapp.ContactSearchUI", paramString);
        AppMethodBeat.o(19713);
        return true;
      }
      AppMethodBeat.o(19713);
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u gx(String paramString)
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
    
    final int[] Xp()
    {
      return new int[] { 18 };
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami)
    {
      AppMethodBeat.i(231432);
      if (paramu.type == 18)
      {
        if (parami != null) {
          parami.a(paramu);
        }
        com.tencent.mm.br.c.V(URISpanHandlerSet.a(URISpanHandlerSet.this), "setting", ".ui.qrcode.ShareMicroMsgChoiceUI");
        if (parami != null) {
          parami.b(paramu);
        }
        AppMethodBeat.o(231432);
        return true;
      }
      AppMethodBeat.o(231432);
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
        com.tencent.mm.br.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "setting", ".ui.qrcode.ShareMicroMsgChoiceUI", paramString);
        AppMethodBeat.o(19716);
        return true;
      }
      AppMethodBeat.o(19716);
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u gx(String paramString)
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
    
    final int[] Xp()
    {
      return new int[] { 46, 47 };
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami)
    {
      AppMethodBeat.i(231433);
      if (paramu.type == 46)
      {
        Log.i("MicroMsg.URISpanHandlerSet", "go to honey pay proxy");
        if ((paramu.data != null) && ((paramu.data instanceof Bundle)))
        {
          paramu = Uri.parse(paramu.url);
          paramView = paramu.getQueryParameter("cardNo");
          boolean bool = paramu.getQueryParameter("isPayer").equals("1");
          paramu = new Intent();
          paramu.putExtra("key_card_no", paramView);
          paramu.putExtra("key_is_payer", bool);
          com.tencent.mm.br.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "honey_pay", ".ui.HoneyPayProxyUI", paramu);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(231433);
        return false;
        if (paramu.type == 47)
        {
          Log.i("MicroMsg.URISpanHandlerSet", "go to bank card list");
          paramView = new Intent();
          paramView.putExtra("intent_finish_self", true);
          com.tencent.mm.br.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "wallet", ".bind.ui.WalletBankcardManageUI", paramView);
          com.tencent.mm.plugin.report.service.h.CyF.a(15191, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
        }
      }
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u gx(String paramString)
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
    
    final int[] Xp()
    {
      return new int[0];
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami)
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
          paramu = new com.tencent.mm.hellhoundlib.b.a().bl(paramu);
          com.tencent.mm.hellhoundlib.a.a.a(paramString, paramu.axQ(), "com/tencent/mm/app/plugin/URISpanHandlerSet$JumpActivityUriSpanHandler", "handleUriJump", "(Ljava/lang/String;ZLcom/tencent/mm/pluginsdk/UriJumpCallback;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramString.startActivity((Intent)paramu.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/app/plugin/URISpanHandlerSet$JumpActivityUriSpanHandler", "handleUriJump", "(Ljava/lang/String;ZLcom/tencent/mm/pluginsdk/UriJumpCallback;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        for (;;)
        {
          AppMethodBeat.o(19721);
          return true;
          if ("shake".equalsIgnoreCase(paramString))
          {
            com.tencent.mm.plugin.report.service.h.CyF.kvStat(10221, "1");
            paramString = new Intent();
            paramString.addFlags(67108864);
            if ((URISpanHandlerSet.a(URISpanHandlerSet.this) instanceof Service)) {
              paramString.addFlags(268435456);
            }
            com.tencent.mm.br.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "shake", ".ui.ShakeReportUI", paramString);
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
            com.tencent.mm.br.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "scanner", ".ui.BaseScanUI", paramString);
          }
        }
      }
      AppMethodBeat.o(19721);
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u gx(String paramString)
    {
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class JumpPatSettingDialogUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    JumpPatSettingDialogUriSpanHandler()
    {
      super();
    }
    
    final int[] Xp()
    {
      return new int[] { 61 };
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami)
    {
      AppMethodBeat.i(231437);
      if (paramu.type == 61)
      {
        paramu = SecDataUIC.CWq;
        ((czj)SecDataUIC.a.c(paramView.getContext(), 4, czj.class)).MEF = 1;
        paramView = new com.tencent.mm.plugin.patmsg.ui.b(paramView.getContext());
        paramView.show();
        paramView.getWindow().setLayout(-1, -1);
      }
      AppMethodBeat.o(231437);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u gx(String paramString)
    {
      AppMethodBeat.i(231436);
      if (paramString.trim().toLowerCase().startsWith("weixin://jump/setpat_bottom_sheet/"))
      {
        paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 61, null);
        AppMethodBeat.o(231436);
        return paramString;
      }
      AppMethodBeat.o(231436);
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
    
    final int[] Xp()
    {
      return new int[] { 57 };
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami)
    {
      AppMethodBeat.i(231440);
      if (paramu.type == 57)
      {
        Log.i("MicroMsg.URISpanHandlerSet", "handleClickJumpToPatSetting");
        paramu = new Intent();
        paramu.setClass(URISpanHandlerSet.a(URISpanHandlerSet.this), SettingsPersonalInfoUI.class);
        paramu.putExtra("jumptoPat", true);
        paramView = URISpanHandlerSet.a(URISpanHandlerSet.this);
        paramu = new com.tencent.mm.hellhoundlib.b.a().bl(paramu);
        com.tencent.mm.hellhoundlib.a.a.a(paramView, paramu.axQ(), "com/tencent/mm/app/plugin/URISpanHandlerSet$JumpPatSettingUriSpanHandler", "handleSpanClick", "(Landroid/view/View;Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramView.startActivity((Intent)paramu.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/app/plugin/URISpanHandlerSet$JumpPatSettingUriSpanHandler", "handleSpanClick", "(Landroid/view/View;Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      new MMHandler().postDelayed(new URISpanHandlerSet.JumpPatSettingUriSpanHandler.1(this), 2000L);
      AppMethodBeat.o(231440);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u gx(String paramString)
    {
      AppMethodBeat.i(231439);
      if (paramString.trim().toLowerCase().startsWith("weixin://jump/setpat/"))
      {
        paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 57, null);
        AppMethodBeat.o(231439);
        return paramString;
      }
      AppMethodBeat.o(231439);
      return null;
    }
  }
  
  @URISpanHandlerSet.a(Xq=URISpanHandlerSet.PRIORITY.HIGH)
  class LuckyMoneyUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    LuckyMoneyUriSpanHandler()
    {
      super();
    }
    
    final int[] Xp()
    {
      return new int[] { 33, 59 };
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami)
    {
      AppMethodBeat.i(231441);
      if (paramu.type == 33)
      {
        Log.i("MicroMsg.URISpanHandlerSet", "hrefInfo.getType() == MMSpanConstants.Type.TYPE_LUCKY_MONEY_NORMAL");
        if (parami == null)
        {
          Log.i("MicroMsg.URISpanHandlerSet", "LuckyMoneyUriSpanHandler handleSpanClick() clickCallback == null");
          AppMethodBeat.o(231441);
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
          com.tencent.mm.br.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "luckymoney", ".hk.ui.LuckyMoneyHKBeforeDetailUI", paramView);
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.CyF.a(12097, new Object[] { Integer.valueOf(11), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
          com.tencent.mm.plugin.report.service.h.CyF.a(11850, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
          AppMethodBeat.o(231441);
          return true;
          com.tencent.mm.br.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "luckymoney", ".ui.LuckyMoneyBeforeDetailUI", paramView);
        }
      }
      if (paramu.type == 59)
      {
        Log.i("MicroMsg.URISpanHandlerSet", "hrefInfo.getType() == MMSpanConstants.Type.TYPE_LUCKY_MONEY_UNION");
        if (parami == null)
        {
          Log.i("MicroMsg.URISpanHandlerSet", "LuckyMoneyUriSpanHandler handleSpanClick() clickCallback == null");
          AppMethodBeat.o(231441);
          return false;
        }
        paramView = new Intent();
        paramView.putExtra("key_native_url", paramu.url);
        paramView.putExtra("key_username", (String)parami.a(paramu));
        paramView.putExtra("key_lucky_money_can_received", true);
        paramView.putExtra("key_jump_from", 4);
        paramView.putExtra("scene_id", 1005);
        com.tencent.mm.br.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "luckymoney", ".ui.LuckyMoneyBeforeDetailUI", paramView);
        com.tencent.mm.plugin.report.service.h.CyF.a(12097, new Object[] { Integer.valueOf(11), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
        com.tencent.mm.plugin.report.service.h.CyF.a(11850, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
        AppMethodBeat.o(231441);
        return true;
      }
      AppMethodBeat.o(231441);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u gx(String paramString)
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
    
    final int[] Xp()
    {
      return new int[] { 51 };
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami)
    {
      AppMethodBeat.i(231442);
      if (paramu.type == 51)
      {
        Log.i("MicroMsg.URISpanHandlerSet", "go to offline fqf");
        if ((paramu.data != null) && ((paramu.data instanceof Bundle)))
        {
          Object localObject = (Bundle)paramu.data;
          paramView = ((Bundle)localObject).getString("repayment_tiny_app_username");
          localObject = ((Bundle)localObject).getString("repayment_tiny_app_path");
          wq localwq = new wq();
          localwq.ecI.userName = paramView;
          localwq.ecI.ecK = Util.nullAs((String)localObject, "");
          localwq.ecI.ecL = 0;
          EventCenter.instance.publish(localwq);
        }
        if (parami != null) {
          parami.b(paramu);
        }
      }
      AppMethodBeat.o(231442);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u gx(String paramString)
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
    
    final int[] Xp()
    {
      return new int[0];
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami)
    {
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      AppMethodBeat.i(19727);
      if (paramString.startsWith("wxpay://"))
      {
        if (paramu == null) {
          break label244;
        }
        paramBundle = paramu.glZ().toString();
        paramu = paramu.gma();
        if (!(paramu instanceof com.tencent.mm.plugin.wallet.a)) {
          break label239;
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
            if ((z.aUp()) || (z.aUq())) {
              com.tencent.mm.pluginsdk.wallet.f.a(URISpanHandlerSet.a(URISpanHandlerSet.this), 5, paramBundle, 11, paramu);
            }
            for (;;)
            {
              AppMethodBeat.o(19727);
              return true;
              com.tencent.mm.pluginsdk.wallet.f.a(URISpanHandlerSet.a(URISpanHandlerSet.this), 2, paramBundle, 11, paramu);
            }
          }
          Toast.makeText(URISpanHandlerSet.a(URISpanHandlerSet.this), URISpanHandlerSet.a(URISpanHandlerSet.this).getString(2131765243), 0).show();
          AppMethodBeat.o(19727);
          return false;
          AppMethodBeat.o(19727);
          return false;
        }
        label239:
        paramu = null;
        continue;
        label244:
        paramu = null;
        paramBundle = null;
      }
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u gx(String paramString)
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
    
    final int[] Xp()
    {
      return new int[] { 26 };
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami)
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
        com.tencent.mm.br.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "setting", ".ui.setting.SettingsPluginsUI", paramString);
        AppMethodBeat.o(19731);
        return true;
      }
      AppMethodBeat.o(19731);
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u gx(String paramString)
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
    
    final int[] Xp()
    {
      return new int[] { 3 };
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami)
    {
      AppMethodBeat.i(231445);
      if (paramu.type == 3)
      {
        if (parami != null) {
          parami.a(paramu);
        }
        paramView = (String)paramu.ba(String.class);
        Intent localIntent = new Intent();
        localIntent.addFlags(268435456);
        localIntent.putExtra("Contact_User", paramView);
        bg.aVF();
        as localas = com.tencent.mm.model.c.aSN().Kn(paramView);
        if ((localas != null) && ((int)localas.gMZ > 0) && (com.tencent.mm.contact.c.oR(localas.field_type))) {
          e.a(localIntent, paramView);
        }
        if (Util.nullAsNil(paramView).length() > 0) {
          com.tencent.mm.br.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "profile", ".ui.ContactInfoUI", localIntent);
        }
        if (parami != null) {
          parami.b(paramu);
        }
        AppMethodBeat.o(231445);
        return true;
      }
      AppMethodBeat.o(231445);
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
        bg.aVF();
        paramBundle = com.tencent.mm.model.c.aSN().Kn(paramString);
        if ((paramBundle != null) && ((int)paramBundle.gMZ > 0) && (com.tencent.mm.contact.c.oR(paramBundle.field_type))) {
          e.a(paramu, paramString);
        }
        com.tencent.mm.br.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "profile", ".ui.ContactInfoUI", paramu);
        AppMethodBeat.o(19734);
        return true;
      }
      AppMethodBeat.o(19734);
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u gx(String paramString)
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
    
    final int[] Xp()
    {
      return new int[0];
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami)
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
        com.tencent.mm.br.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "scanner", ".ui.BaseScanUI", paramString);
        AppMethodBeat.o(19735);
        return true;
      }
      AppMethodBeat.o(19735);
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u gx(String paramString)
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
    
    final int[] Xp()
    {
      return new int[0];
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami)
    {
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      AppMethodBeat.i(19736);
      if (paramString.equals("weixin://setting/account/safedevice"))
      {
        bg.aVF();
        paramString = (String)com.tencent.mm.model.c.azQ().get(6, "");
        bg.aVF();
        paramu = (String)com.tencent.mm.model.c.azQ().get(4097, "");
        if (!Util.isNullOrNil(paramString))
        {
          paramString = new Intent();
          if ((URISpanHandlerSet.a(URISpanHandlerSet.this) instanceof Service)) {
            paramString.addFlags(268435456);
          }
          com.tencent.mm.br.c.V(URISpanHandlerSet.a(URISpanHandlerSet.this), "account", ".security.ui.MySafeDeviceListUI");
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
            MMWizardActivity.ay(URISpanHandlerSet.a(URISpanHandlerSet.this), paramString);
          }
          else
          {
            paramString = new Intent();
            if ((URISpanHandlerSet.a(URISpanHandlerSet.this) instanceof Service)) {
              paramString.addFlags(268435456);
            }
            com.tencent.mm.br.c.a(URISpanHandlerSet.a(URISpanHandlerSet.this), "account", ".security.ui.BindSafeDeviceUI", paramString);
          }
        }
      }
      AppMethodBeat.o(19736);
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u gx(String paramString)
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
    
    final int[] Xp()
    {
      return new int[] { 12 };
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami)
    {
      AppMethodBeat.i(231450);
      if (paramu.type == 12)
      {
        if (parami != null) {
          parami.a(paramu);
        }
        paramView = new Intent();
        paramView.putExtra("Contact_User", "weibo");
        com.tencent.mm.br.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "profile", ".ui.ContactInfoUI", paramView);
        if (parami != null) {
          parami.b(paramu);
        }
        AppMethodBeat.o(231450);
        return true;
      }
      AppMethodBeat.o(231450);
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
        com.tencent.mm.br.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "profile", ".ui.ContactInfoUI", paramString);
        AppMethodBeat.o(19750);
        return true;
      }
      AppMethodBeat.o(19750);
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u gx(String paramString)
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
    
    final int[] Xp()
    {
      return new int[] { 10 };
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami)
    {
      AppMethodBeat.i(231451);
      if (paramu.type == 10)
      {
        if (parami != null) {
          parami.a(paramu);
        }
        paramView = new Intent();
        paramView.putExtra("Contact_User", "qqmail");
        com.tencent.mm.br.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "profile", ".ui.ContactInfoUI", paramView);
        if (parami != null) {
          parami.b(paramu);
        }
        AppMethodBeat.o(231451);
        return true;
      }
      AppMethodBeat.o(231451);
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
        com.tencent.mm.br.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "profile", ".ui.ContactInfoUI", paramString);
        AppMethodBeat.o(19753);
        return true;
      }
      AppMethodBeat.o(19753);
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u gx(String paramString)
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
    
    final int[] Xp()
    {
      return new int[] { 13 };
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami)
    {
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u gx(String paramString)
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
    
    final int[] Xp()
    {
      return new int[] { 11 };
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami)
    {
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u gx(String paramString)
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
  class StoryEntranceHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    StoryEntranceHandler()
    {
      super();
    }
    
    final int[] Xp()
    {
      return new int[] { 48 };
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami)
    {
      AppMethodBeat.i(231453);
      if (paramu.type == 48)
      {
        paramView = paramu.username;
        if (TextUtils.isEmpty(paramView))
        {
          AppMethodBeat.o(231453);
          return false;
        }
        if (com.tencent.mm.plugin.sns.f.a.aOE(paramView)) {
          o.bB(URISpanHandlerSet.a(URISpanHandlerSet.this), paramView);
        }
        if (parami != null) {
          parami.b(paramu);
        }
        AppMethodBeat.o(231453);
        return true;
      }
      AppMethodBeat.o(231453);
      return false;
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
  
  @URISpanHandlerSet.a
  class TopicSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    TopicSpanHandler()
    {
      super();
    }
    
    final int[] Xp()
    {
      return new int[] { 58 };
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami)
    {
      AppMethodBeat.i(231455);
      label98:
      long l1;
      int m;
      long l2;
      int j;
      int k;
      Object localObject;
      int i;
      label426:
      label432:
      label437:
      if (paramu.type == 58)
      {
        parami = SecDataUIC.CWq;
        p.h(paramView, "view");
        parami = paramView.getContext();
        p.g(parami, "view.context");
        parami = SecDataUIC.a.gU(parami);
        int n;
        if (parami != null)
        {
          parami = parami.eSr();
          if (parami != null)
          {
            parami = parami.eSo();
            if ((parami == null) || (parami.containsKey(String.valueOf(paramView.hashCode())) != true)) {
              break label354;
            }
            paramView = (com.tencent.mm.bw.a)parami.get(String.valueOf(paramView.hashCode()));
            parami = (egl)paramView;
            Log.i("MicroMsg.URISpanHandlerSet", "TopicSpanHandler click %s %s", new Object[] { paramu.url, parami });
            l1 = 0L;
            m = 0;
            paramView = "";
            l2 = cl.aWB();
            j = 0;
            if (parami == null) {
              break label889;
            }
            l1 = parami.KMf;
            m = parami.Ngu;
            paramView = parami.Ngv;
            l2 = parami.KMc;
            k = parami.Ngw;
            j = parami.Ngx;
            n = parami.Ngy;
            if ((m != 3) || (TextUtils.isEmpty(paramView))) {
              break label851;
            }
            parami = paramView.split("#");
            if ((parami == null) || (parami.length < 2)) {
              break label851;
            }
            localObject = parami[1];
            if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.equals("0", (CharSequence)localObject))) {
              break label437;
            }
            i = 1;
          }
        }
        label354:
        label359:
        for (;;)
        {
          label244:
          if ((i != 0) && (n != 0))
          {
            Log.i("MicroMsg.WebSearch.WebSearchReportLogic", "need correct feeId");
            localObject = aj.faO().Zr(n);
            if ((localObject != null) && (((SnsInfo)localObject).field_snsId != 0L))
            {
              parami[1] = com.tencent.mm.plugin.sns.data.r.Jb(((SnsInfo)localObject).field_snsId);
              paramView = new StringBuilder();
              i = 0;
              for (;;)
              {
                if (i < parami.length)
                {
                  paramView.append(parami[i]);
                  if (i != parami.length - 1) {
                    paramView.append("#");
                  }
                  i += 1;
                  continue;
                  parami = null;
                  break;
                  paramView = paramView.getParent();
                  if ((paramView == null) || ((parami != null) && (parami.containsKey(String.valueOf(paramView.hashCode())) == true)))
                  {
                    if (parami == null) {
                      break label432;
                    }
                    if (paramView == null) {
                      break label426;
                    }
                  }
                  for (i = paramView.hashCode();; i = 0)
                  {
                    paramView = (com.tencent.mm.bw.a)parami.get(String.valueOf(i));
                    break;
                    paramView = paramView.getParent();
                    break label359;
                  }
                  paramView = null;
                  break label98;
                  i = 0;
                  break label244;
                }
              }
              paramView = paramView.toString();
            }
          }
        }
      }
      for (;;)
      {
        long l3 = l1;
        if (paramu.data != null)
        {
          l3 = l1;
          if ((paramu.data instanceof Bundle)) {
            l3 = ((Bundle)paramu.data).getLong("msgSvrId");
          }
        }
        paramu = paramu.url;
        i = 73;
        if ((m == 1) || (m == 2))
        {
          i = 73;
          label512:
          parami = d.Nj(i);
          localObject = new ag();
          ((ag)localObject).context = URISpanHandlerSet.a(URISpanHandlerSet.this);
          ((ag)localObject).scene = i;
          ((ag)localObject).query = paramu;
          ((ag)localObject).title = paramu;
          ((ag)localObject).sessionId = parami;
          ((ag)localObject).IEk = true;
          ((ag)localObject).IEl = true;
          ((ag)localObject).IEm = true;
          ((ag)localObject).IEn = 1;
          ((ag)localObject).statusBarColor = com.tencent.mm.cb.a.n(URISpanHandlerSet.a(URISpanHandlerSet.this), 2131101424);
          ((ag)localObject).IEo = true;
          ((ag)localObject).dVU.put("msgSvrId", String.valueOf(l3));
          ((ag)localObject).dVU.put("parentSearchID", "");
          ((ag)localObject).dVU.put("fromTagSearch", "1");
          ((ag)localObject).IEt.put("ShareSceneId", paramView);
          ((ag)localObject).IEt.put("SnsContentType", String.valueOf(j));
          ((com.tencent.mm.plugin.websearch.api.h)g.af(com.tencent.mm.plugin.websearch.api.h.class)).a((ag)localObject);
          localObject = new lh();
          ((lh)localObject).enl = 1L;
          ((lh)localObject).eua = cl.aWB();
          ((lh)localObject).eYp = 1L;
          if ((TextUtils.isEmpty(paramu)) || (!paramu.startsWith("#"))) {
            break label886;
          }
          paramu = paramu.substring(1);
        }
        label851:
        label886:
        for (;;)
        {
          ((lh)localObject).eYq = ((lh)localObject).x("ResultQuery", paramu, true);
          ((lh)localObject).eYr = m;
          ((lh)localObject).eYs = ((lh)localObject).x("ShareSceneId", paramView, true);
          ((lh)localObject).eYt = l2;
          ((lh)localObject).eYu = k;
          ((lh)localObject).eYv = ((lh)localObject).x("SearchSessionId", parami, true);
          ((lh)localObject).bfK();
          ar.a((com.tencent.mm.plugin.report.a)localObject);
          AppMethodBeat.o(231455);
          return true;
          break;
          if (m == 3)
          {
            i = 79;
            break label512;
          }
          if ((m != 4) && (m != 5)) {
            break label512;
          }
          i = 80;
          break label512;
        }
        label889:
        k = 0;
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
  
  @URISpanHandlerSet.a
  class UnKnowToUrlSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    UnKnowToUrlSpanHandler()
    {
      super();
    }
    
    final int[] Xp()
    {
      return new int[] { 2147483646 };
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami)
    {
      AppMethodBeat.i(231457);
      if (paramu.type == 2147483646)
      {
        if ((paramu.data instanceof Bundle))
        {
          paramView = ((Bundle)paramu.data).getString("rawUrl");
          if (Util.isNullOrNil(paramView)) {
            Log.i("MicroMsg.URISpanHandlerSet", "TYPE_UNKNOW_TO_URL url == null");
          }
        }
        for (;;)
        {
          AppMethodBeat.o(231457);
          return true;
          com.tencent.mm.plugin.account.a.b.a.b(MMApplicationContext.getContext(), paramView, 0, true);
          continue;
          Log.i("MicroMsg.URISpanHandlerSet", "TYPE_UNKNOW_TO_URL hrefInfo.getData() no instanceof Bundle");
        }
      }
      AppMethodBeat.o(231457);
      return false;
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
  
  @URISpanHandlerSet.a
  class VerifyContactUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    VerifyContactUriSpanHandler()
    {
      super();
    }
    
    final int[] Xp()
    {
      return new int[] { 4 };
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami)
    {
      AppMethodBeat.i(231459);
      if (paramu.type == 4)
      {
        if (parami != null)
        {
          parami.a(paramu);
          parami.b(paramu);
        }
        AppMethodBeat.o(231459);
        return true;
      }
      AppMethodBeat.o(231459);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u gx(String paramString)
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
    
    final int[] Xp()
    {
      return new int[] { 38 };
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami)
    {
      AppMethodBeat.i(231460);
      if (paramu.type == 38)
      {
        paramu = Uri.parse(paramu.url);
        paramView = paramu.getQueryParameter("username");
        paramu = paramu.getQueryParameter("isvideocall");
        parami = new zj();
        parami.efx.dKy = 5;
        parami.efx.talker = paramView;
        parami.efx.context = URISpanHandlerSet.a(URISpanHandlerSet.this);
        if ((paramView != null) && (!paramView.equals("")))
        {
          if ((paramu != null) && (paramu.equals("true"))) {}
          for (parami.efx.eft = 2;; parami.efx.eft = 4)
          {
            EventCenter.instance.publish(parami);
            AppMethodBeat.o(231460);
            return true;
          }
        }
      }
      AppMethodBeat.o(231460);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u gx(String paramString)
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
  
  @URISpanHandlerSet.a
  class WeWorkUrlSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    private final String dol;
    
    WeWorkUrlSpanHandler()
    {
      super();
      AppMethodBeat.i(231461);
      this.dol = ("https://" + WeChatHosts.domainString(2131761751) + "/wework_admin/commdownload");
      AppMethodBeat.o(231461);
    }
    
    private static String getAppName(Context paramContext, String paramString)
    {
      AppMethodBeat.i(179569);
      paramContext = paramContext.getPackageManager();
      try
      {
        paramContext = paramContext.getApplicationInfo(paramString, 0).loadLabel(paramContext).toString();
        AppMethodBeat.o(179569);
        return paramContext;
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        AppMethodBeat.o(179569);
      }
      return null;
    }
    
    final int[] Xp()
    {
      return new int[] { 52 };
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami)
    {
      AppMethodBeat.i(231462);
      if (paramu.type == 52)
      {
        paramView = new Intent();
        paramView.setAction("android.intent.action.VIEW");
        paramView.setData(Uri.parse(paramu.url));
        paramView.setPackage("com.tencent.wework");
        paramView.setFlags(268435456);
        try
        {
          boolean bool = com.tencent.mm.pluginsdk.model.app.h.b(MMApplicationContext.getContext(), paramView, getAppName(MMApplicationContext.getContext(), "com.tencent.wework"));
          if (!bool) {
            com.tencent.mm.plugin.account.a.b.a.b(MMApplicationContext.getContext(), this.dol, 0, true);
          }
          Log.i("MicroMsg.URISpanHandlerSet", "WeWorkUrlSpanHandler result:%s", new Object[] { Boolean.valueOf(bool) });
          AppMethodBeat.o(231462);
          return true;
        }
        catch (Exception paramView)
        {
          AppMethodBeat.o(231462);
          return false;
        }
      }
      AppMethodBeat.o(231462);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u gx(String paramString)
    {
      AppMethodBeat.i(179567);
      if (paramString.trim().toLowerCase().startsWith("wxwork://jump?"))
      {
        paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 52, null);
        AppMethodBeat.o(179567);
        return paramString;
      }
      AppMethodBeat.o(179567);
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class WxaShortLinkUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    WxaShortLinkUriSpanHandler()
    {
      super();
    }
    
    final int[] Xp()
    {
      return new int[] { 60 };
    }
    
    final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami)
    {
      AppMethodBeat.i(231464);
      Log.i("MicroMsg.URISpanHandlerSet", "[WxaShortLinkUriSpanHandler] handleSpanClick ");
      paramView = paramu.data;
      if ((paramView instanceof Bundle))
      {
        paramView = ((Bundle)paramView).getString("key_wxa_short_link_launch_scene", "");
        if (paramView.isEmpty())
        {
          Log.i("MicroMsg.URISpanHandlerSet", "[WxaShortLinkUriSpanHandler] scene is null ");
          if (BuildInfo.IS_FLAVOR_RED)
          {
            paramView = new Error("[WxaShortLinkUriSpanHandler]  scene must not is null");
            AppMethodBeat.o(231464);
            throw paramView;
          }
        }
        else
        {
          parami = t.b.valueOf(paramView);
          Log.i("MicroMsg.URISpanHandlerSet", "[WxaShortLinkUriSpanHandler] sceneName=%s  scene=%d  preScene=%d", new Object[] { paramView, Integer.valueOf(parami.Kss), Integer.valueOf(parami.Kst) });
          AppBrandCheckWxaShortLinkUI.a(URISpanHandlerSet.a(URISpanHandlerSet.this), paramu.url, parami);
        }
      }
      do
      {
        AppMethodBeat.o(231464);
        return false;
        Log.i("MicroMsg.URISpanHandlerSet", "[WxaShortLinkUriSpanHandler] HrefInfo has not data");
      } while (!BuildInfo.IS_FLAVOR_RED);
      paramView = new Error("[WxaShortLinkUriSpanHandler] HrefInfo has not data");
      AppMethodBeat.o(231464);
      throw paramView;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u gx(String paramString)
    {
      AppMethodBeat.i(231463);
      if (paramString.trim().toLowerCase().startsWith("mp://"))
      {
        paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 60, null);
        AppMethodBeat.o(231463);
        return paramString;
      }
      AppMethodBeat.o(231463);
      return null;
    }
  }
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.TYPE})
  static @interface a
  {
    URISpanHandlerSet.PRIORITY Xq() default URISpanHandlerSet.PRIORITY.NORMAL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet
 * JD-Core Version:    0.7.0.1
 */