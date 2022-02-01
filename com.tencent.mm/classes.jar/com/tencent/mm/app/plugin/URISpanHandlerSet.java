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
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.ui.ManagerRoomByWeworkUI;
import com.tencent.mm.g.a.ip;
import com.tencent.mm.g.a.ip.a;
import com.tencent.mm.g.a.nc;
import com.tencent.mm.g.a.qv;
import com.tencent.mm.g.a.st;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.g.a.yh;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.al;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.model.z.b;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.bind.ui.MobileFriendUI;
import com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalInfoUI;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.wxpaysdk.api.ResendMsgInfo;
import com.tencent.mm.pluginsdk.g.a;
import com.tencent.mm.pluginsdk.ui.span.m;
import com.tencent.mm.protocal.protobuf.dqu;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.cb;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.MainTabUI;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.AddressUI;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.widget.a.f.a;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;

class URISpanHandlerSet
{
  Context mContext;
  
  public URISpanHandlerSet(Context paramContext)
  {
    AppMethodBeat.i(19768);
    this.mContext = null;
    if (paramContext == null) {}
    for (paramContext = ak.getContext();; paramContext = this.mContext)
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
    
    final int[] Nd()
    {
      return new int[] { 35, 36, 37 };
    }
    
    final boolean a(com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.h paramh)
    {
      AppMethodBeat.i(19676);
      Object localObject1;
      Object localObject2;
      if (paramu.type == 35) {
        for (;;)
        {
          try
          {
            paramh = Uri.parse(paramu.url);
            localObject1 = paramh.getQueryParameter("billno");
            if (bu.isNullOrNil((String)localObject1))
            {
              com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.URISpanHandlerSet", "url error, billno is null");
              AppMethodBeat.o(19676);
              return true;
            }
            int i = bu.getInt(paramh.getQueryParameter("scene"), 3);
            if (!(paramu.data instanceof Bundle)) {
              continue;
            }
            paramh = ((Bundle)paramu.data).getString("chatroom_name");
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("bill_no", (String)localObject1);
            ((Intent)localObject2).putExtra("enter_scene", i);
            ((Intent)localObject2).putExtra("chatroom", paramh);
            com.tencent.mm.br.d.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "aa", ".ui.PaylistAAUI", (Intent)localObject2);
          }
          catch (Exception paramh)
          {
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.URISpanHandlerSet", "handle click new aa open detail link error: %s, url: %s", new Object[] { paramh.getMessage(), paramu.url });
            continue;
          }
          AppMethodBeat.o(19676);
          return true;
          if ((paramu.data instanceof String))
          {
            paramh = paramu.data.toString();
          }
          else
          {
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.URISpanHandlerSet", "illegal data type, %s", new Object[] { paramu });
            AppMethodBeat.o(19676);
            return true;
          }
        }
      }
      if (paramu.type == 37) {}
      for (;;)
      {
        long l;
        try
        {
          paramh = Uri.parse(paramu.url).getQueryParameter("billno");
          if (bu.isNullOrNil(paramh))
          {
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.URISpanHandlerSet", "url error, billno is null");
            AppMethodBeat.o(19676);
            return true;
          }
          if (!(paramu.data instanceof Bundle))
          {
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.URISpanHandlerSet", "error data!");
            AppMethodBeat.o(19676);
            return true;
          }
          localObject1 = (Bundle)paramu.data;
          localObject2 = ((Bundle)localObject1).getString("chatroom_name");
          if (bu.isNullOrNil((String)localObject2))
          {
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.URISpanHandlerSet", "empty chatroom!");
            AppMethodBeat.o(19676);
            return true;
          }
          l = ((Bundle)localObject1).getLong("msg_id", -1L);
          if (l < 0L)
          {
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.URISpanHandlerSet", "msgId is null");
            AppMethodBeat.o(19676);
            return true;
          }
          com.tencent.mm.ui.base.h.a(URISpanHandlerSet.a(URISpanHandlerSet.this), 2131764107, -1, 2131764110, 2131756766, new URISpanHandlerSet.AAUriSpanHandler.1(this, paramh, (String)localObject2, l), null);
        }
        catch (Exception paramh)
        {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.URISpanHandlerSet", "handle click new aa close link error: %s, url: %s", new Object[] { paramh.getMessage(), paramu.url });
          continue;
        }
        AppMethodBeat.o(19676);
        return false;
        if (paramu.type == 36) {
          try
          {
            localObject1 = Uri.parse(paramu.url).getQueryParameter("billno");
            if (bu.isNullOrNil((String)localObject1))
            {
              com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.URISpanHandlerSet", "url error, billno is null");
              AppMethodBeat.o(19676);
              return true;
            }
            paramh = null;
            if ((paramu.data instanceof Bundle)) {
              paramh = (Bundle)paramu.data;
            }
            if ((paramh == null) || (bu.isNullOrNil(paramh.getString("chatroom_name"))))
            {
              com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.URISpanHandlerSet", "empty chatroom!");
              AppMethodBeat.o(19676);
              return true;
            }
            localObject2 = paramh.getString("chatroom_name");
            l = paramh.getLong("msg_id", -1L);
            com.tencent.mm.ui.base.h.a(URISpanHandlerSet.a(URISpanHandlerSet.this), 2131764108, -1, 2131764109, 2131756766, new URISpanHandlerSet.AAUriSpanHandler.2(this, (String)localObject1, (String)localObject2, l), null);
          }
          catch (Exception paramh)
          {
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.URISpanHandlerSet", "handle click new aa urge notify link error: %s, url: %s", new Object[] { paramh.getMessage(), paramu.url });
          }
        }
      }
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u fL(String paramString)
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
    
    final int[] Nd()
    {
      return new int[] { 44 };
    }
    
    final boolean a(com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.h paramh)
    {
      AppMethodBeat.i(19677);
      if (paramu.type == 44)
      {
        paramh = Uri.parse("geo:0,0?q=" + Uri.encode(paramu.url));
        paramu = new Intent("android.intent.action.VIEW");
        paramu.setData(paramh);
        paramu.addFlags(268435456);
        if (paramu.resolveActivity(ak.getContext().getPackageManager()) != null)
        {
          paramh = ak.getContext();
          paramu = new com.tencent.mm.hellhoundlib.b.a().bc(paramu);
          com.tencent.mm.hellhoundlib.a.a.a(paramh, paramu.ahE(), "com/tencent/mm/app/plugin/URISpanHandlerSet$AddressUriSpanHandler", "handleSpanClick", "(Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramh.startActivity((Intent)paramu.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramh, "com/tencent/mm/app/plugin/URISpanHandlerSet$AddressUriSpanHandler", "handleSpanClick", "(Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.plugin.report.service.g.yxI.f(12809, new Object[] { Integer.valueOf(9), "" });
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.g.yxI.f(12809, new Object[] { Integer.valueOf(8), "" });
          AppMethodBeat.o(19677);
          return true;
          com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.URISpanHandlerSet", "Cannot find map app");
        }
      }
      AppMethodBeat.o(19677);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u fL(String paramString)
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
    
    final int[] Nd()
    {
      return new int[] { 32 };
    }
    
    final boolean a(com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.h paramh)
    {
      AppMethodBeat.i(19679);
      if (paramu.type == 32)
      {
        paramu = paramu.url.replace("weixin://alphainstall?", "");
        paramh = Uri.parse(paramu).getQueryParameter("md5");
        paramh = com.tencent.mm.loader.j.b.asj() + paramh + ".apk";
        if (com.tencent.mm.vfs.o.fB(paramh)) {
          com.tencent.mm.pluginsdk.model.app.r.b(ak.getContext(), paramh, null, false);
        }
        for (;;)
        {
          AppMethodBeat.o(19679);
          return true;
          paramh = new Intent();
          paramh.putExtra("rawUrl", paramu.toString());
          com.tencent.mm.br.d.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "webview", ".ui.tools.WebViewUI", paramh);
        }
      }
      AppMethodBeat.o(19679);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u fL(String paramString)
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
  class AppBrandLinkSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    AppBrandLinkSpanHandler()
    {
      super();
    }
    
    final int[] Nd()
    {
      return new int[] { 45 };
    }
    
    final boolean a(com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.h paramh)
    {
      AppMethodBeat.i(19680);
      if (paramu.type == 45)
      {
        if (paramh != null)
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.URISpanHandlerSet", "AppBrandLinkSpanHandler click appbrandlink");
          paramh.b(paramu);
          AppMethodBeat.o(19680);
          return true;
        }
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.URISpanHandlerSet", "clickCallback is null, return");
      }
      AppMethodBeat.o(19680);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u fL(String paramString)
    {
      return null;
    }
  }
  
  abstract class BaseUriSpanHandler
  {
    public BaseUriSpanHandler() {}
    
    abstract int[] Nd();
    
    abstract boolean a(com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.h paramh);
    
    abstract boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle);
    
    abstract com.tencent.mm.pluginsdk.ui.applet.u fL(String paramString);
  }
  
  @URISpanHandlerSet.a
  class BindMobileUrilSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    BindMobileUrilSpanHandler()
    {
      super();
    }
    
    final int[] Nd()
    {
      return new int[] { 5 };
    }
    
    final boolean a(com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.h paramh)
    {
      AppMethodBeat.i(19682);
      if (paramu.type == 5)
      {
        if (paramh != null) {
          paramh.a(paramu);
        }
        MMWizardActivity.al(URISpanHandlerSet.a(URISpanHandlerSet.this), new Intent(URISpanHandlerSet.a(URISpanHandlerSet.this), BindMContactIntroUI.class));
        if (paramh != null) {
          paramh.b(paramu);
        }
        AppMethodBeat.o(19682);
        return true;
      }
      AppMethodBeat.o(19682);
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
        MMWizardActivity.al(URISpanHandlerSet.a(URISpanHandlerSet.this), paramString);
        AppMethodBeat.o(19683);
        return true;
      }
      AppMethodBeat.o(19683);
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u fL(String paramString)
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
  class BizMsgMenuUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    BizMsgMenuUriSpanHandler()
    {
      super();
    }
    
    final int[] Nd()
    {
      return new int[] { 43 };
    }
    
    final boolean a(com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.h paramh)
    {
      AppMethodBeat.i(19685);
      if (43 == paramu.type)
      {
        if (bu.isNullOrNil(paramu.username))
        {
          com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.URISpanHandlerSet", "BizMsgMenuUriSpanHandler Username is null.");
          AppMethodBeat.o(19685);
          return true;
        }
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.URISpanHandlerSet", "BizMsgMenuUriSpanHandler, url:%s", new Object[] { paramu.url });
        Object localObject = Uri.parse(paramu.url.trim());
        paramh = ((Uri)localObject).getQueryParameter("msgmenuid");
        localObject = ((Uri)localObject).getQueryParameter("msgmenucontent");
        com.tencent.mm.plugin.report.service.g.yxI.f(14522, new Object[] { bu.nullAsNil(paramh), paramu.username });
        if ((bu.isNullOrNil(paramh)) || (bu.isNullOrNil((String)localObject)))
        {
          com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.URISpanHandlerSet", "BizMsgMenuUriSpanHandler id or msgContent is null.");
          AppMethodBeat.o(19685);
          return true;
        }
        try
        {
          localObject = URLDecoder.decode((String)localObject, "UTF-8");
          HashMap localHashMap = new HashMap();
          localHashMap.put("bizmsgmenuid", paramh);
          paramh = com.tencent.mm.modelmulti.o.Gz(paramu.username);
          paramh.toUser = paramu.username;
          paramh.content = ((String)localObject);
          paramh.type = x.Bb(paramu.username);
          paramh.dEu = 1;
          paramh.iiU = localHashMap;
          paramh.iiV = 5;
          paramh.aJO().execute();
          AppMethodBeat.o(19685);
          return true;
        }
        catch (UnsupportedEncodingException paramu)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.URISpanHandlerSet", "BizMsgMenuUriSpanHandler exp, msg = %s", new Object[] { paramu.getMessage() });
          }
        }
      }
      AppMethodBeat.o(19685);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u fL(String paramString)
    {
      AppMethodBeat.i(19684);
      if (paramString.trim().startsWith("weixin://bizmsgmenu"))
      {
        paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 43, null);
        AppMethodBeat.o(19684);
        return paramString;
      }
      AppMethodBeat.o(19684);
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
    
    final int[] Nd()
    {
      return new int[0];
    }
    
    final boolean a(com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.h paramh)
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
          paramString = paramu.fcN().toString();
        }
        paramu = new Intent();
        paramu.putExtra("user_name", paramString);
        paramu.putExtra("view_type", 1);
        com.tencent.mm.br.d.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "card", ".ui.CardViewUI", paramu);
        AppMethodBeat.o(19686);
        return true;
      }
      AppMethodBeat.o(19686);
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u fL(String paramString)
    {
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class ContactUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    ContactUriSpanHandler()
    {
      super();
    }
    
    final int[] Nd()
    {
      return new int[] { 23, 21, 22, 2 };
    }
    
    final boolean a(com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.h paramh)
    {
      AppMethodBeat.i(19688);
      int i = paramu.type;
      if ((i == 23) || (i == 21) || (i == 22) || (i == 2))
      {
        Object localObject1 = (ad)paramu.aY(ad.class);
        if (paramh != null) {
          paramh.a(paramu);
        }
        if (localObject1 == null)
        {
          com.tencent.mm.ui.base.h.c(URISpanHandlerSet.a(URISpanHandlerSet.this), URISpanHandlerSet.a(URISpanHandlerSet.this).getString(2131760689), URISpanHandlerSet.a(URISpanHandlerSet.this).getString(2131755906), true);
          AppMethodBeat.o(19688);
          return false;
        }
        if (((ad)localObject1).getType().equals("@t.qq.com"))
        {
          if (((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azO().arD("@t.qq.com") == null) {
            break label460;
          }
          i = 1;
          if (i == 0) {
            com.tencent.mm.ui.base.h.c(URISpanHandlerSet.a(URISpanHandlerSet.this), URISpanHandlerSet.a(URISpanHandlerSet.this).getString(2131760689), URISpanHandlerSet.a(URISpanHandlerSet.this).getString(2131755906), true);
          }
        }
        Object localObject2;
        if (((ad)localObject1).getType().equals("@domain.android"))
        {
          localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azO().dpd();
          if (((List)localObject2).size() <= 0) {
            break label472;
          }
          i = 0;
          label229:
          if (i >= ((List)localObject2).size()) {
            break label472;
          }
          if (!((cb)((List)localObject2).get(i)).isEnable()) {
            break label465;
          }
        }
        label460:
        label465:
        label472:
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            com.tencent.mm.ui.base.h.c(URISpanHandlerSet.a(URISpanHandlerSet.this), URISpanHandlerSet.a(URISpanHandlerSet.this).getString(2131760689), URISpanHandlerSet.a(URISpanHandlerSet.this).getString(2131755906), true);
          }
          localObject2 = new Intent();
          ((Intent)localObject2).setClass(URISpanHandlerSet.a(URISpanHandlerSet.this), SelectContactUI.class);
          ((Intent)localObject2).putExtra("Contact_GroupFilter_Type", ((ad)localObject1).getType()).putExtra("Contact_GroupFilter_Str", ((ad)localObject1).aBL()).putExtra("Contact_GroupFilter_DisplayName", ((ad)localObject1).adF());
          ((Intent)localObject2).addFlags(268435456);
          localObject1 = URISpanHandlerSet.a(URISpanHandlerSet.this);
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/app/plugin/URISpanHandlerSet$ContactUriSpanHandler", "handleSpanClick", "(Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/app/plugin/URISpanHandlerSet$ContactUriSpanHandler", "handleSpanClick", "(Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          if (paramh != null) {
            paramh.b(paramu);
          }
          AppMethodBeat.o(19688);
          return true;
          i = 0;
          break;
          i += 1;
          break label229;
        }
      }
      AppMethodBeat.o(19688);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      AppMethodBeat.i(19689);
      if ((paramString.equals("weixin://contacts/microblog/")) || (paramString.equals("weixin://contacts/micromessenger/")) || (paramString.equals("weixin://contacts/all/")))
      {
        paramu = com.tencent.mm.model.ae.Bw(URISpanHandlerSet.a(URISpanHandlerSet.this).getString(2131760134));
        if (paramString.equals("weixin://contacts/microblog/")) {
          paramu = com.tencent.mm.model.ae.Bw(URISpanHandlerSet.a(URISpanHandlerSet.this).getString(2131760133));
        }
        if (paramString.equals("weixin://contacts/micromessenger/")) {
          paramu = com.tencent.mm.model.ae.Bw(URISpanHandlerSet.a(URISpanHandlerSet.this).getString(2131760134));
        }
        if (paramString.equals("weixin://contacts/all/")) {
          paramu = com.tencent.mm.model.ae.Bw(URISpanHandlerSet.a(URISpanHandlerSet.this).getString(2131760083));
        }
        paramString = new Intent();
        paramString.setClass(URISpanHandlerSet.a(URISpanHandlerSet.this), SelectContactUI.class);
        paramString.putExtra("Contact_GroupFilter_Type", paramu.getType()).putExtra("Contact_GroupFilter_Str", paramu.aBL()).putExtra("Contact_GroupFilter_DisplayName", paramu.adF());
        paramString.addFlags(268435456);
        AppMethodBeat.o(19689);
        return true;
      }
      AppMethodBeat.o(19689);
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u fL(String paramString)
    {
      Object localObject = null;
      AppMethodBeat.i(19687);
      if (paramString.trim().equals("weixin://contacts/all/")) {
        localObject = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 23, new ad("@all.android", null, URISpanHandlerSet.a(URISpanHandlerSet.this).getString(2131760083), null, true, true));
      }
      for (;;)
      {
        AppMethodBeat.o(19687);
        return localObject;
        if (paramString.trim().equals("weixin://contacts/microblog/"))
        {
          localObject = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 22, com.tencent.mm.model.ae.Bw(URISpanHandlerSet.a(URISpanHandlerSet.this).getString(2131760133)));
        }
        else if (paramString.trim().equals("weixin://contacts/micromessenger/"))
        {
          localObject = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 2, new ad("@micromsg.qq.com", null, URISpanHandlerSet.a(URISpanHandlerSet.this).getString(2131760134), null, true, true));
        }
        else if (paramString.trim().startsWith("weixin://contacts/"))
        {
          localObject = paramString.trim().substring(0, paramString.trim().length() - 1);
          int i = ((String)localObject).lastIndexOf("/");
          if (i == -1)
          {
            AppMethodBeat.o(19687);
            return null;
          }
          localObject = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 21, com.tencent.mm.model.ae.aL("@".concat(String.valueOf(((String)localObject).substring(i + 1))), URISpanHandlerSet.a(URISpanHandlerSet.this).getString(2131760085)));
        }
      }
    }
  }
  
  @URISpanHandlerSet.a(Ne=URISpanHandlerSet.PRIORITY.LOW)
  class DeeplinkUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    DeeplinkUriSpanHandler()
    {
      super();
    }
    
    final int[] Nd()
    {
      return new int[] { 30 };
    }
    
    final boolean a(final com.tencent.mm.pluginsdk.ui.applet.u paramu, final com.tencent.mm.pluginsdk.ui.span.h paramh)
    {
      AppMethodBeat.i(19695);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler handleSpanClick %d, %s", new Object[] { Integer.valueOf(paramu.type), paramu.url });
      if (paramh != null) {}
      for (paramh = (String)paramh.a(paramu);; paramh = null)
      {
        if (paramu.type == 30)
        {
          paramu = bu.nullAsNil(paramu.url);
          final com.tencent.mm.api.c localc;
          if ((paramu.startsWith("weixin://shieldBrandMsg/")) || (paramu.startsWith("weixin://receiveBrandMsg/")))
          {
            if (bu.isNullOrNil(paramh))
            {
              com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler username is null");
              AppMethodBeat.o(19695);
              return true;
            }
            localc = com.tencent.mm.al.g.eX(paramh);
            if (localc == null)
            {
              com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler BizInfo is null");
              AppMethodBeat.o(19695);
              return true;
            }
            if (paramu.startsWith("weixin://shieldBrandMsg/")) {
              com.tencent.mm.ui.base.h.a(URISpanHandlerSet.a(URISpanHandlerSet.this), 2131764392, 2131755906, 2131764391, 2131756766, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(19690);
                  paramAnonymousInt = localc.field_brandFlag;
                  localc.field_brandFlag |= 0x1;
                  com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.URISpanHandlerSet", "shield biz msg %s, %s, old = %d, new = %d", new Object[] { paramu, paramh, Integer.valueOf(paramAnonymousInt), Integer.valueOf(localc.field_brandFlag) });
                  com.tencent.mm.al.g.h(localc);
                  AppMethodBeat.o(19690);
                }
              }, null);
            }
          }
          for (;;)
          {
            AppMethodBeat.o(19695);
            return true;
            if (paramu.startsWith("weixin://receiveBrandMsg/"))
            {
              com.tencent.mm.ui.base.h.a(URISpanHandlerSet.a(URISpanHandlerSet.this), 2131764390, 2131755906, 2131764389, 2131756766, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(19691);
                  paramAnonymousInt = localc.field_brandFlag;
                  localc.field_brandFlag &= 0xFFFFFFFE;
                  com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.URISpanHandlerSet", "receive biz msg %s, %s, old = %d, new = %d", new Object[] { paramu, paramh, Integer.valueOf(paramAnonymousInt), Integer.valueOf(localc.field_brandFlag) });
                  com.tencent.mm.al.g.h(localc);
                  AppMethodBeat.o(19691);
                }
              }, null);
              continue;
              if (com.tencent.mm.pluginsdk.g.v(Uri.parse(paramu)))
              {
                com.tencent.mm.pluginsdk.g.K(URISpanHandlerSet.a(URISpanHandlerSet.this), paramh, paramu);
              }
              else if (paramu.startsWith("weixin://receiveWeAppKFMsg"))
              {
                if (bu.isNullOrNil(paramh))
                {
                  com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler username is null, handle the BUILTIN_RECEIVE_WEAPP_KFMSG ,  the herfUrl is %s", new Object[] { paramu });
                  AppMethodBeat.o(19695);
                  return true;
                }
                com.tencent.mm.ui.base.h.a(URISpanHandlerSet.a(URISpanHandlerSet.this), 2131755636, 2131755906, 2131755635, 2131756766, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                  {
                    AppMethodBeat.i(19692);
                    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.URISpanHandlerSet", "AppBrandServiceHelper switchTo to receive msg for username %s", new Object[] { paramh });
                    com.tencent.mm.ui.appbrand.e.l(URISpanHandlerSet.a(URISpanHandlerSet.this), paramh, true);
                    AppMethodBeat.o(19692);
                  }
                }, null);
              }
              else if (paramu.startsWith("weixin://xmail/bind"))
              {
                paramu = new Intent().putExtra("Contact_User", "qqmail");
                paramu.putExtra("key_need_rebind_xmail", true);
                com.tencent.mm.br.d.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "profile", ".ui.ContactInfoUI", paramu);
              }
              else
              {
                com.tencent.mm.pluginsdk.g.a(URISpanHandlerSet.a(URISpanHandlerSet.this), paramu, paramh, 1, paramu, null);
              }
            }
          }
        }
        AppMethodBeat.o(19695);
        return false;
      }
    }
    
    final boolean a(String paramString, boolean paramBoolean, final com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      AppMethodBeat.i(19696);
      if ((bu.isNullOrNil(paramString)) || (paramBundle == null))
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
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.URISpanHandlerSet", "url is null ? %b, paramsBundle is null ? %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
          AppMethodBeat.o(19696);
          return false;
          paramBoolean = false;
          break;
        }
      }
      if (com.tencent.mm.pluginsdk.g.v(Uri.parse(paramString)))
      {
        int j = paramBundle.getInt("key_scene", -1);
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler jump, %d, %s", new Object[] { Integer.valueOf(j), paramString });
        int i = j;
        if (j == -1) {
          i = 5;
        }
        paramu = com.tencent.mm.ui.base.h.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "", true, null);
        com.tencent.mm.pluginsdk.g.a(URISpanHandlerSet.a(URISpanHandlerSet.this), paramString, i, new g.a()
        {
          public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(19693);
            if ((paramu != null) && (paramu.isShowing())) {
              paramu.dismiss();
            }
            if ((paramAnonymousn != null) && (paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0) && ((paramAnonymousn instanceof com.tencent.mm.modelsimple.ac)))
            {
              paramAnonymousString = ((com.tencent.mm.modelsimple.ac)paramAnonymousn).aLA();
              if ((paramAnonymousString != null) && (URISpanHandlerSet.a(URISpanHandlerSet.this) != null)) {
                t.makeText(URISpanHandlerSet.a(URISpanHandlerSet.this), URISpanHandlerSet.a(URISpanHandlerSet.this).getString(2131755906) + " : " + bu.nullAsNil(paramAnonymousString.HXL), 0).show();
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
    
    final com.tencent.mm.pluginsdk.ui.applet.u fL(String paramString)
    {
      AppMethodBeat.i(19694);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler getHrefFromUrl %s", new Object[] { paramString });
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
    
    final int[] Nd()
    {
      return new int[] { 29 };
    }
    
    final boolean a(com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.h paramh)
    {
      AppMethodBeat.i(19698);
      if (paramu.type == 29)
      {
        if (paramh != null) {
          paramh.a(paramu);
        }
        Intent localIntent = new Intent();
        localIntent.putExtra("download_entrance_scene", 21);
        localIntent.putExtra("extra_id", (String)paramu.aY(String.class));
        localIntent.putExtra("preceding_scence", 3);
        com.tencent.mm.br.d.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "emoji", ".ui.EmojiStoreDetailUI", localIntent);
        if (paramh != null) {
          paramh.b(paramu);
        }
        AppMethodBeat.o(19698);
        return true;
      }
      AppMethodBeat.o(19698);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u fL(String paramString)
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
    
    final int[] Nd()
    {
      return new int[] { 55 };
    }
    
    final boolean a(com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.h paramh)
    {
      AppMethodBeat.i(186316);
      if (paramu.type == 55)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.URISpanHandlerSet", "handleClickEnterChatRoomSystemMsgUrl");
        try
        {
          paramh = paramu.url;
          int i = paramh.trim().lastIndexOf("/");
          if ((i >= 0) && (i < paramh.trim().length() - 1))
          {
            paramh = paramh.trim().substring(i + 1);
            if (x.wb(paramh))
            {
              bc.aCg();
              localObject1 = com.tencent.mm.model.c.azF().BH(paramh);
              if ((localObject1 == null) || ((int)((com.tencent.mm.contact.c)localObject1).ght == 0))
              {
                localObject1 = new an();
                ((an)localObject1).setUsername(paramh);
                bc.aCg();
                com.tencent.mm.model.c.azF().an((an)localObject1);
              }
            }
            Object localObject2 = new Intent(URISpanHandlerSet.a(URISpanHandlerSet.this), ChattingUI.class).putExtra("Chat_User", paramh).putExtra("Chat_Mode", 1);
            if ((URISpanHandlerSet.a(URISpanHandlerSet.this) instanceof Service)) {
              ((Intent)localObject2).addFlags(268435456);
            }
            Object localObject1 = URISpanHandlerSet.a(URISpanHandlerSet.this);
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/app/plugin/URISpanHandlerSet$EnterChatRoomUriSpanHandler", "handleSpanClick", "(Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/app/plugin/URISpanHandlerSet$EnterChatRoomUriSpanHandler", "handleSpanClick", "(Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            if (paramu.fmC == 1)
            {
              localObject1 = bu.bI(paramu.chatroomName, "");
              com.tencent.mm.chatroom.c.b.g(bu.bI(paramh, ""), (String)localObject1, 3);
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.URISpanHandlerSet", "handleClickEnterChatRoomSystemMsgUrl migrate(%s -> %s)", new Object[] { localObject1, bu.bI(paramh, "") });
            }
            AppMethodBeat.o(186316);
            return true;
          }
        }
        catch (Exception paramh)
        {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.URISpanHandlerSet", "handle click link error: %s, url: %s", new Object[] { paramh.getMessage(), paramu.url });
        }
      }
      AppMethodBeat.o(186316);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u fL(String paramString)
    {
      AppMethodBeat.i(186315);
      if (paramString.trim().toLowerCase().startsWith("weixin://jump/chatroom/"))
      {
        paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 55, null);
        AppMethodBeat.o(186315);
        return paramString;
      }
      AppMethodBeat.o(186315);
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
    
    final int[] Nd()
    {
      return new int[0];
    }
    
    final boolean a(com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.h paramh)
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
          if (x.wb(paramString))
          {
            bc.aCg();
            paramu = com.tencent.mm.model.c.azF().BH(paramString);
            if ((paramu == null) || ((int)paramu.ght == 0))
            {
              paramu = new an();
              paramu.setUsername(paramString);
              bc.aCg();
              com.tencent.mm.model.c.azF().an(paramu);
            }
          }
          paramu = new Intent(URISpanHandlerSet.a(URISpanHandlerSet.this), ChattingUI.class).putExtra("Chat_User", paramString).putExtra("Chat_Mode", 1);
          if ((URISpanHandlerSet.a(URISpanHandlerSet.this) instanceof Service)) {
            paramu.addFlags(268435456);
          }
          paramString = URISpanHandlerSet.a(URISpanHandlerSet.this);
          paramu = new com.tencent.mm.hellhoundlib.b.a().bc(paramu);
          com.tencent.mm.hellhoundlib.a.a.a(paramString, paramu.ahE(), "com/tencent/mm/app/plugin/URISpanHandlerSet$EnterRoomUriSpanHandler", "handleUriJump", "(Ljava/lang/String;ZLcom/tencent/mm/pluginsdk/UriJumpCallback;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramString.startActivity((Intent)paramu.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/app/plugin/URISpanHandlerSet$EnterRoomUriSpanHandler", "handleUriJump", "(Ljava/lang/String;ZLcom/tencent/mm/pluginsdk/UriJumpCallback;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(19699);
          return true;
        }
      }
      AppMethodBeat.o(19699);
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u fL(String paramString)
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
    
    final int[] Nd()
    {
      return new int[] { 31 };
    }
    
    final boolean a(com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.h paramh)
    {
      AppMethodBeat.i(19701);
      Intent localIntent;
      if (paramu.type == 31)
      {
        localIntent = new Intent();
        if (paramh == null)
        {
          AppMethodBeat.o(19701);
          return false;
        }
        paramu = (String)paramh.a(paramu);
        localIntent.putExtra("k_username", paramu);
        if ((bu.isNullOrNil(paramu)) || (!paramu.endsWith("@chatroom"))) {
          break label140;
        }
      }
      label140:
      for (int i = 36;; i = 39)
      {
        localIntent.putExtra("showShare", false);
        localIntent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(i) }));
        com.tencent.mm.br.d.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "webview", ".ui.tools.WebViewUI", localIntent);
        AppMethodBeat.o(19701);
        return true;
        AppMethodBeat.o(19701);
        return false;
      }
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u fL(String paramString)
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
    
    final int[] Nd()
    {
      return new int[] { 34 };
    }
    
    final boolean a(com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.h paramh)
    {
      AppMethodBeat.i(19703);
      if (paramu.type == 34)
      {
        paramh = paramu.url.trim().replace("weixin://feedback/next/", "");
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.URISpanHandlerSet", "FeedbackUriSpanHandler, url:%s, content:%s", new Object[] { paramu.url, paramh });
        bc.ajj().a(new com.tencent.mm.plugin.setting.model.l(com.tencent.mm.compatible.deviceinfo.q.aaM(), paramh, 8), 0);
        AppMethodBeat.o(19703);
        return true;
      }
      AppMethodBeat.o(19703);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u fL(String paramString)
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
    
    final int[] Nd()
    {
      return new int[] { 50 };
    }
    
    final boolean a(com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.h paramh)
    {
      AppMethodBeat.i(19704);
      if (paramu.type == 50)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.URISpanHandlerSet", "FlightNumberSpanHandler click %s", new Object[] { paramu.url });
        if ((paramu.data == null) || (!(paramu.data instanceof Bundle))) {
          break label96;
        }
      }
      label96:
      for (long l = ((Bundle)paramu.data).getLong("msgSvrId");; l = 0L)
      {
        ((com.tencent.mm.plugin.box.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.box.a.b.class)).b(URISpanHandlerSet.a(URISpanHandlerSet.this), paramu.url, l);
        AppMethodBeat.o(19704);
        return true;
      }
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u fL(String paramString)
    {
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class FlowStatUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    FlowStatUriSpanHandler()
    {
      super();
    }
    
    final int[] Nd()
    {
      return new int[] { 16 };
    }
    
    final boolean a(com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.h paramh)
    {
      AppMethodBeat.i(19706);
      if (paramu.type == 16)
      {
        if (paramh != null) {
          paramh.a(paramu);
        }
        LauncherUI localLauncherUI = LauncherUI.getInstance();
        if (localLauncherUI != null) {
          localLauncherUI.Jty.getMainTabUI().aWU("tab_settings");
        }
        if (paramh != null) {
          paramh.b(paramu);
        }
        AppMethodBeat.o(19706);
        return true;
      }
      AppMethodBeat.o(19706);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      AppMethodBeat.i(19707);
      if (paramString.equals("weixin://flowstat"))
      {
        paramString = LauncherUI.getInstance();
        if (paramString != null) {
          paramString.Jty.getMainTabUI().aWU("tab_settings");
        }
        AppMethodBeat.o(19707);
        return true;
      }
      AppMethodBeat.o(19707);
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u fL(String paramString)
    {
      AppMethodBeat.i(19705);
      if (paramString.trim().startsWith("weixin://flowstat"))
      {
        paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 16, null);
        AppMethodBeat.o(19705);
        return paramString;
      }
      AppMethodBeat.o(19705);
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
    
    final int[] Nd()
    {
      return new int[] { 20 };
    }
    
    final boolean a(com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.h paramh)
    {
      AppMethodBeat.i(19709);
      if (paramu.type == 20)
      {
        if (paramh != null) {
          paramh.a(paramu);
        }
        Object localObject = new Intent(URISpanHandlerSet.a(URISpanHandlerSet.this), MobileFriendUI.class);
        Context localContext = URISpanHandlerSet.a(URISpanHandlerSet.this);
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/app/plugin/URISpanHandlerSet$FriendMobileUriSpanHandler", "handleSpanClick", "(Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/app/plugin/URISpanHandlerSet$FriendMobileUriSpanHandler", "handleSpanClick", "(Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        if (paramh != null) {
          paramh.b(paramu);
        }
        AppMethodBeat.o(19709);
        return true;
      }
      AppMethodBeat.o(19709);
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
        paramu = new com.tencent.mm.hellhoundlib.b.a().bc(paramu);
        com.tencent.mm.hellhoundlib.a.a.a(paramString, paramu.ahE(), "com/tencent/mm/app/plugin/URISpanHandlerSet$FriendMobileUriSpanHandler", "handleUriJump", "(Ljava/lang/String;ZLcom/tencent/mm/pluginsdk/UriJumpCallback;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)paramu.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/app/plugin/URISpanHandlerSet$FriendMobileUriSpanHandler", "handleUriJump", "(Ljava/lang/String;ZLcom/tencent/mm/pluginsdk/UriJumpCallback;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(19710);
        return true;
      }
      AppMethodBeat.o(19710);
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u fL(String paramString)
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
    
    final int[] Nd()
    {
      return new int[] { 17 };
    }
    
    final boolean a(com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.h paramh)
    {
      AppMethodBeat.i(19712);
      if (paramu.type == 17)
      {
        if (paramh != null) {
          paramh.a(paramu);
        }
        com.tencent.mm.br.d.Q(URISpanHandlerSet.a(URISpanHandlerSet.this), "subapp", ".ui.pluginapp.ContactSearchUI");
        if (paramh != null) {
          paramh.b(paramu);
        }
        AppMethodBeat.o(19712);
        return true;
      }
      AppMethodBeat.o(19712);
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
        com.tencent.mm.br.d.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "subapp", ".ui.pluginapp.ContactSearchUI", paramString);
        AppMethodBeat.o(19713);
        return true;
      }
      AppMethodBeat.o(19713);
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u fL(String paramString)
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
    
    final int[] Nd()
    {
      return new int[] { 18 };
    }
    
    final boolean a(com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.h paramh)
    {
      AppMethodBeat.i(19715);
      if (paramu.type == 18)
      {
        if (paramh != null) {
          paramh.a(paramu);
        }
        com.tencent.mm.br.d.Q(URISpanHandlerSet.a(URISpanHandlerSet.this), "setting", ".ui.qrcode.ShareMicroMsgChoiceUI");
        if (paramh != null) {
          paramh.b(paramu);
        }
        AppMethodBeat.o(19715);
        return true;
      }
      AppMethodBeat.o(19715);
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
        com.tencent.mm.br.d.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "setting", ".ui.qrcode.ShareMicroMsgChoiceUI", paramString);
        AppMethodBeat.o(19716);
        return true;
      }
      AppMethodBeat.o(19716);
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u fL(String paramString)
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
    
    final int[] Nd()
    {
      return new int[] { 46, 47 };
    }
    
    final boolean a(com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.h paramh)
    {
      AppMethodBeat.i(19718);
      if (paramu.type == 46)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.URISpanHandlerSet", "go to honey pay proxy");
        if ((paramu.data != null) && ((paramu.data instanceof Bundle)))
        {
          paramh = Uri.parse(paramu.url);
          paramu = paramh.getQueryParameter("cardNo");
          boolean bool = paramh.getQueryParameter("isPayer").equals("1");
          paramh = new Intent();
          paramh.putExtra("key_card_no", paramu);
          paramh.putExtra("key_is_payer", bool);
          com.tencent.mm.br.d.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "honey_pay", ".ui.HoneyPayProxyUI", paramh);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(19718);
        return false;
        if (paramu.type == 47)
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.URISpanHandlerSet", "go to bank card list");
          paramu = new Intent();
          paramu.putExtra("intent_finish_self", true);
          com.tencent.mm.br.d.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "wallet", ".bind.ui.WalletBankcardManageUI", paramu);
          com.tencent.mm.plugin.report.service.g.yxI.f(15191, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
        }
      }
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u fL(String paramString)
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
  class HttpUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    HttpUriSpanHandler()
    {
      super();
    }
    
    final int[] Nd()
    {
      return new int[] { 1 };
    }
    
    final boolean a(com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.h paramh)
    {
      AppMethodBeat.i(19720);
      int i;
      if (paramu.type == 1) {
        if ((URISpanHandlerSet.a(URISpanHandlerSet.this) != null) && ((URISpanHandlerSet.a(URISpanHandlerSet.this) instanceof WebViewUI)))
        {
          i = 1;
          paramu.aY(ad.class);
          if ((URISpanHandlerSet.a(URISpanHandlerSet.this) == null) || ((i != 0) && (!ak.cpe()))) {
            break label468;
          }
        }
      }
      label440:
      label443:
      label468:
      for (Object localObject1 = com.tencent.mm.model.ae.aL("@" + paramu.url, URISpanHandlerSet.a(URISpanHandlerSet.this).getString(2131760085));; localObject1 = null)
      {
        if (paramh != null) {}
        for (String str1 = (String)paramh.a(paramu);; str1 = null)
        {
          Object localObject2;
          if ((localObject1 == null) || (!((ad)localObject1).enable))
          {
            localObject2 = paramu.url;
            localObject1 = localObject2;
            if (!((String)localObject2).toLowerCase().startsWith("http")) {
              localObject1 = "http://".concat(String.valueOf(localObject2));
            }
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("rawUrl", (String)localObject1);
            if ((paramu.data != null) && ((paramu.data instanceof Bundle))) {
              ((Intent)localObject2).putExtra("geta8key_scene", ((Bundle)paramu.data).getInt("geta8key_scene"));
            }
            localObject1 = paramu.mSessionId;
            if (!bu.isNullOrNil((String)localObject1))
            {
              Object localObject3 = com.tencent.mm.model.z.aBG().Bp((String)localObject1);
              if (localObject3 != null)
              {
                String str2 = ((z.b)localObject3).getString("prePublishId", null);
                String str3 = ((z.b)localObject3).getString("preUsername", null);
                localObject3 = ((z.b)localObject3).getString("preChatName", null);
                ((Intent)localObject2).putExtra("reportSessionId", (String)localObject1);
                ((Intent)localObject2).putExtra("KPublisherId", str2);
                ((Intent)localObject2).putExtra("geta8key_username", (String)localObject3);
                ((Intent)localObject2).putExtra("pre_username", str3);
                ((Intent)localObject2).putExtra("prePublishId", str2);
                ((Intent)localObject2).putExtra("preUsername", str3);
                ((Intent)localObject2).putExtra("preChatName", (String)localObject3);
                ((Intent)localObject2).putExtra("preChatTYPE", com.tencent.mm.model.y.aH(str3, (String)localObject3));
              }
            }
            if (!bu.isNullOrNil(str1)) {
              break label440;
            }
            str1 = null;
            label377:
            ((Intent)localObject2).putExtra("geta8key_username", str1);
            if (i == 0) {
              break label443;
            }
            ((Intent)localObject2).addFlags(268435456);
          }
          for (;;)
          {
            com.tencent.mm.br.d.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "webview", ".ui.tools.WebViewUI", (Intent)localObject2);
            if (paramh != null) {
              paramh.b(paramu);
            }
            AppMethodBeat.o(19720);
            return true;
            i = 0;
            break;
            break label377;
            ((Intent)localObject2).addFlags(536870912);
          }
          AppMethodBeat.o(19720);
          return false;
        }
      }
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u fL(String paramString)
    {
      AppMethodBeat.i(19719);
      if (paramString.trim().toLowerCase().startsWith("http")) {}
      for (paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 1, null);; paramString = null)
      {
        AppMethodBeat.o(19719);
        return paramString;
      }
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
    
    final int[] Nd()
    {
      return new int[0];
    }
    
    final boolean a(com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.h paramh)
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
          paramu = new com.tencent.mm.hellhoundlib.b.a().bc(paramu);
          com.tencent.mm.hellhoundlib.a.a.a(paramString, paramu.ahE(), "com/tencent/mm/app/plugin/URISpanHandlerSet$JumpActivityUriSpanHandler", "handleUriJump", "(Ljava/lang/String;ZLcom/tencent/mm/pluginsdk/UriJumpCallback;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramString.startActivity((Intent)paramu.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/app/plugin/URISpanHandlerSet$JumpActivityUriSpanHandler", "handleUriJump", "(Ljava/lang/String;ZLcom/tencent/mm/pluginsdk/UriJumpCallback;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        for (;;)
        {
          AppMethodBeat.o(19721);
          return true;
          if ("shake".equalsIgnoreCase(paramString))
          {
            com.tencent.mm.plugin.report.service.g.yxI.kvStat(10221, "1");
            paramString = new Intent();
            paramString.addFlags(67108864);
            if ((URISpanHandlerSet.a(URISpanHandlerSet.this) instanceof Service)) {
              paramString.addFlags(268435456);
            }
            com.tencent.mm.br.d.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "shake", ".ui.ShakeReportUI", paramString);
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
            com.tencent.mm.br.d.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "scanner", ".ui.BaseScanUI", paramString);
          }
        }
      }
      AppMethodBeat.o(19721);
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u fL(String paramString)
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
    
    final int[] Nd()
    {
      return new int[] { 57 };
    }
    
    final boolean a(com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.h paramh)
    {
      AppMethodBeat.i(186319);
      if (paramu.type == 57)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.URISpanHandlerSet", "handleClickJumpToPatSetting");
        paramh = new Intent();
        paramh.setClass(URISpanHandlerSet.a(URISpanHandlerSet.this), SettingsPersonalInfoUI.class);
        paramh.putExtra("jumptoPat", true);
        paramu = URISpanHandlerSet.a(URISpanHandlerSet.this);
        paramh = new com.tencent.mm.hellhoundlib.b.a().bc(paramh);
        com.tencent.mm.hellhoundlib.a.a.a(paramu, paramh.ahE(), "com/tencent/mm/app/plugin/URISpanHandlerSet$JumpPatSettingUriSpanHandler", "handleSpanClick", "(Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramu.startActivity((Intent)paramh.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramu, "com/tencent/mm/app/plugin/URISpanHandlerSet$JumpPatSettingUriSpanHandler", "handleSpanClick", "(Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      new aq().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(186317);
          LauncherUI localLauncherUI = LauncherUI.getInstance();
          if (localLauncherUI != null)
          {
            localLauncherUI.closeChatting(false);
            localLauncherUI.Jty.getMainTabUI().aWU("tab_settings");
          }
          AppMethodBeat.o(186317);
        }
      }, 2000L);
      AppMethodBeat.o(186319);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u fL(String paramString)
    {
      AppMethodBeat.i(186318);
      if (paramString.trim().toLowerCase().startsWith("weixin://jump/setpat/"))
      {
        paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 57, null);
        AppMethodBeat.o(186318);
        return paramString;
      }
      AppMethodBeat.o(186318);
      return null;
    }
  }
  
  @URISpanHandlerSet.a(Ne=URISpanHandlerSet.PRIORITY.HIGH)
  class LuckyMoneyUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    LuckyMoneyUriSpanHandler()
    {
      super();
    }
    
    final int[] Nd()
    {
      return new int[] { 33 };
    }
    
    final boolean a(com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.h paramh)
    {
      AppMethodBeat.i(19723);
      if (paramu.type == 33)
      {
        if (paramh == null)
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.URISpanHandlerSet", "LuckyMoneyUriSpanHandler handleSpanClick() clickCallback == null");
          AppMethodBeat.o(19723);
          return false;
        }
        Intent localIntent = new Intent();
        localIntent.putExtra("key_native_url", paramu.url);
        localIntent.putExtra("key_username", (String)paramh.a(paramu));
        localIntent.putExtra("key_lucky_money_can_received", true);
        localIntent.putExtra("key_jump_from", 4);
        com.tencent.mm.br.d.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "luckymoney", ".ui.LuckyMoneyBeforeDetailUI", localIntent);
        com.tencent.mm.plugin.report.service.g.yxI.f(12097, new Object[] { Integer.valueOf(11), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
        com.tencent.mm.plugin.report.service.g.yxI.f(11850, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
        AppMethodBeat.o(19723);
        return true;
      }
      AppMethodBeat.o(19723);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u fL(String paramString)
    {
      AppMethodBeat.i(19722);
      if (paramString.trim().toLowerCase().startsWith("weixin://weixinhongbao/"))
      {
        paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 33, null);
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
    
    final int[] Nd()
    {
      return new int[] { 51 };
    }
    
    final boolean a(com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.h paramh)
    {
      AppMethodBeat.i(169681);
      if (paramu.type == 51)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.URISpanHandlerSet", "go to offline fqf");
        if ((paramu.data != null) && ((paramu.data instanceof Bundle)))
        {
          Object localObject = (Bundle)paramu.data;
          String str = ((Bundle)localObject).getString("repayment_tiny_app_username");
          localObject = ((Bundle)localObject).getString("repayment_tiny_app_path");
          vq localvq = new vq();
          localvq.dKT.userName = str;
          localvq.dKT.dKV = bu.bI((String)localObject, "");
          localvq.dKT.dKW = 0;
          com.tencent.mm.sdk.b.a.IvT.l(localvq);
        }
        if (paramh != null) {
          paramh.b(paramu);
        }
      }
      AppMethodBeat.o(169681);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u fL(String paramString)
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
  
  @URISpanHandlerSet.a
  class PayTransferUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    PayTransferUriSpanHandler()
    {
      super();
    }
    
    final int[] Nd()
    {
      return new int[0];
    }
    
    final boolean a(com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.h paramh)
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
        paramBundle = paramu.fcN().toString();
        paramu = paramu.fcO();
        if (!(paramu instanceof com.tencent.mm.plugin.wallet.a)) {
          break label239;
        }
        paramu = (com.tencent.mm.plugin.wallet.a)paramu;
      }
      for (;;)
      {
        if (bu.isNullOrNil(paramBundle))
        {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.URISpanHandlerSet", "SERVICE_JUMP_TO_PAY fail, null username");
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
          if (bu.getInt(paramString, 0) == 1)
          {
            if ((v.aAS()) || (v.aAT())) {
              com.tencent.mm.pluginsdk.wallet.f.a(URISpanHandlerSet.a(URISpanHandlerSet.this), 5, paramBundle, 11, paramu);
            }
            for (;;)
            {
              AppMethodBeat.o(19727);
              return true;
              com.tencent.mm.pluginsdk.wallet.f.a(URISpanHandlerSet.a(URISpanHandlerSet.this), 2, paramBundle, 11, paramu);
            }
          }
          Toast.makeText(URISpanHandlerSet.a(URISpanHandlerSet.this), URISpanHandlerSet.a(URISpanHandlerSet.this).getString(2131763083), 0).show();
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
    
    final com.tencent.mm.pluginsdk.ui.applet.u fL(String paramString)
    {
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class PayUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    PayUriSpanHandler()
    {
      super();
    }
    
    final int[] Nd()
    {
      return new int[] { 28 };
    }
    
    final boolean a(com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.h paramh)
    {
      AppMethodBeat.i(19728);
      if (paramu.type == 28)
      {
        if (paramh != null) {
          paramh.a(paramu);
        }
        ip localip = new ip();
        localip.dwm.actionCode = 11;
        localip.dwm.result = paramu.url;
        localip.dwm.context = URISpanHandlerSet.a(URISpanHandlerSet.this);
        localip.dwm.dwo = new Bundle();
        localip.dwm.dwo.putInt("pay_channel", 6);
        com.tencent.mm.sdk.b.a.IvT.a(localip, Looper.myLooper());
        if (paramh != null) {
          paramh.b(paramu);
        }
        AppMethodBeat.o(19728);
        return true;
      }
      AppMethodBeat.o(19728);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u fL(String paramString)
    {
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class PhoneEmailUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    PhoneEmailUriSpanHandler()
    {
      super();
    }
    
    final int[] Nd()
    {
      return new int[] { 25, 24 };
    }
    
    final boolean a(com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.h paramh)
    {
      AppMethodBeat.i(19729);
      Bundle localBundle;
      if (paramu.type == 25)
      {
        paramh = paramu.username;
        localBundle = new Bundle();
        if ((paramh != null) && (!paramh.equals(v.aAC())))
        {
          localBundle.putString("Contact_User", paramh);
          paramh = com.tencent.mm.plugin.account.a.getAddrUploadStg().JT(paramh);
          if ((paramh == null) || (bu.isNullOrNil(paramh.Lj()))) {
            break label156;
          }
        }
      }
      label156:
      for (paramh = bu.nullAsNil(paramh.aTc()).replace(" ", "");; paramh = null)
      {
        localBundle.putString("Contact_Mobile_MD5", paramh);
        localBundle.putInt("fromScene", 1);
        m.a(URISpanHandlerSet.a(URISpanHandlerSet.this), paramu.url, null, localBundle);
        AppMethodBeat.o(19729);
        return true;
        if (paramu.type == 24) {
          m.b(URISpanHandlerSet.a(URISpanHandlerSet.this), paramu.url, null);
        }
        AppMethodBeat.o(19729);
        return false;
      }
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u fL(String paramString)
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
    
    final int[] Nd()
    {
      return new int[] { 26 };
    }
    
    final boolean a(com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.h paramh)
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
        com.tencent.mm.br.d.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "setting", ".ui.setting.SettingsPluginsUI", paramString);
        AppMethodBeat.o(19731);
        return true;
      }
      AppMethodBeat.o(19731);
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u fL(String paramString)
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
    
    final int[] Nd()
    {
      return new int[] { 3 };
    }
    
    final boolean a(com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.h paramh)
    {
      AppMethodBeat.i(19733);
      if (paramu.type == 3)
      {
        if (paramh != null) {
          paramh.a(paramu);
        }
        String str = (String)paramu.aY(String.class);
        Intent localIntent = new Intent();
        localIntent.addFlags(268435456);
        localIntent.putExtra("Contact_User", str);
        bc.aCg();
        an localan = com.tencent.mm.model.c.azF().BH(str);
        if ((localan != null) && ((int)localan.ght > 0) && (com.tencent.mm.contact.c.lO(localan.field_type))) {
          com.tencent.mm.ui.contact.e.a(localIntent, str);
        }
        if (bu.nullAsNil(str).length() > 0) {
          com.tencent.mm.br.d.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "profile", ".ui.ContactInfoUI", localIntent);
        }
        if (paramh != null) {
          paramh.b(paramu);
        }
        AppMethodBeat.o(19733);
        return true;
      }
      AppMethodBeat.o(19733);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      AppMethodBeat.i(19734);
      if (paramString.startsWith("weixin://contacts/profile/"))
      {
        paramString = paramString.trim().replace("weixin://contacts/profile/", "").replace("/", "");
        if (bu.isNullOrNil(paramString))
        {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.URISpanHandlerSet", "jumpToActivity fail, user is null");
          AppMethodBeat.o(19734);
          return true;
        }
        paramu = new Intent();
        paramu.addFlags(268435456);
        paramu.putExtra("Contact_User", paramString);
        bc.aCg();
        paramBundle = com.tencent.mm.model.c.azF().BH(paramString);
        if ((paramBundle != null) && ((int)paramBundle.ght > 0) && (com.tencent.mm.contact.c.lO(paramBundle.field_type))) {
          com.tencent.mm.ui.contact.e.a(paramu, paramString);
        }
        com.tencent.mm.br.d.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "profile", ".ui.ContactInfoUI", paramu);
        AppMethodBeat.o(19734);
        return true;
      }
      AppMethodBeat.o(19734);
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u fL(String paramString)
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
    
    final int[] Nd()
    {
      return new int[0];
    }
    
    final boolean a(com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.h paramh)
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
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.URISpanHandlerSet", "jumpToActivity, scan qrcode permission fail");
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
        com.tencent.mm.br.d.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "scanner", ".ui.BaseScanUI", paramString);
        AppMethodBeat.o(19735);
        return true;
      }
      AppMethodBeat.o(19735);
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u fL(String paramString)
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
    
    final int[] Nd()
    {
      return new int[0];
    }
    
    final boolean a(com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.h paramh)
    {
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      AppMethodBeat.i(19736);
      if (paramString.equals("weixin://setting/account/safedevice"))
      {
        bc.aCg();
        paramString = (String)com.tencent.mm.model.c.ajA().get(6, "");
        bc.aCg();
        paramu = (String)com.tencent.mm.model.c.ajA().get(4097, "");
        if (!bu.isNullOrNil(paramString))
        {
          paramString = new Intent();
          if ((URISpanHandlerSet.a(URISpanHandlerSet.this) instanceof Service)) {
            paramString.addFlags(268435456);
          }
          com.tencent.mm.br.d.Q(URISpanHandlerSet.a(URISpanHandlerSet.this), "account", ".security.ui.MySafeDeviceListUI");
        }
        for (;;)
        {
          AppMethodBeat.o(19736);
          return true;
          if (!bu.isNullOrNil(paramu))
          {
            paramString = new Intent(URISpanHandlerSet.a(URISpanHandlerSet.this), BindMContactIntroUI.class);
            paramString.putExtra("bind_scene", 1);
            if ((URISpanHandlerSet.a(URISpanHandlerSet.this) instanceof Service)) {
              paramString.addFlags(268435456);
            }
            MMWizardActivity.al(URISpanHandlerSet.a(URISpanHandlerSet.this), paramString);
          }
          else
          {
            paramString = new Intent();
            if ((URISpanHandlerSet.a(URISpanHandlerSet.this) instanceof Service)) {
              paramString.addFlags(268435456);
            }
            com.tencent.mm.br.d.a(URISpanHandlerSet.a(URISpanHandlerSet.this), "account", ".security.ui.BindSafeDeviceUI", paramString);
          }
        }
      }
      AppMethodBeat.o(19736);
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u fL(String paramString)
    {
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class SettingBindEmailUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    SettingBindEmailUriSpanHandler()
    {
      super();
    }
    
    final int[] Nd()
    {
      return new int[] { 7 };
    }
    
    final boolean a(com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.h paramh)
    {
      AppMethodBeat.i(19738);
      if (paramu.type == 7)
      {
        if (paramh != null) {
          paramh.a(paramu);
        }
        LauncherUI localLauncherUI = LauncherUI.getInstance();
        if (localLauncherUI != null) {
          localLauncherUI.Jty.getMainTabUI().aWU("tab_settings");
        }
        if (paramh != null) {
          paramh.b(paramu);
        }
        AppMethodBeat.o(19738);
        return true;
      }
      AppMethodBeat.o(19738);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u fL(String paramString)
    {
      AppMethodBeat.i(19737);
      if (paramString.trim().startsWith("weixin://setting/bindemail"))
      {
        paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 7, null);
        AppMethodBeat.o(19737);
        return paramString;
      }
      AppMethodBeat.o(19737);
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class SettingBlacklistUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    SettingBlacklistUriSpanHandler()
    {
      super();
    }
    
    final int[] Nd()
    {
      return new int[] { 14 };
    }
    
    final boolean a(com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.h paramh)
    {
      AppMethodBeat.i(19740);
      if (paramu.type == 14)
      {
        if (paramh != null) {
          paramh.a(paramu);
        }
        Object localObject2 = com.tencent.mm.model.ae.Bv(URISpanHandlerSet.a(URISpanHandlerSet.this).getString(2131760084));
        Object localObject1 = new Intent();
        ((Intent)localObject1).setClass(URISpanHandlerSet.a(URISpanHandlerSet.this), SelectContactUI.class);
        ((Intent)localObject1).putExtra("Contact_GroupFilter_Type", ((ad)localObject2).getType());
        ((Intent)localObject1).putExtra("Contact_GroupFilter_DisplayName", ((ad)localObject2).adF());
        ((Intent)localObject1).addFlags(67108864);
        localObject2 = LauncherUI.getInstance();
        if (localObject2 != null) {
          ((LauncherUI)localObject2).Jty.getMainTabUI().aWU("tab_settings");
        }
        localObject2 = URISpanHandlerSet.a(URISpanHandlerSet.this);
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/app/plugin/URISpanHandlerSet$SettingBlacklistUriSpanHandler", "handleSpanClick", "(Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/app/plugin/URISpanHandlerSet$SettingBlacklistUriSpanHandler", "handleSpanClick", "(Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        if (paramh != null) {
          paramh.b(paramu);
        }
        AppMethodBeat.o(19740);
        return true;
      }
      AppMethodBeat.o(19740);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      AppMethodBeat.i(19741);
      if (paramString.equals("weixin://setting/blacklist"))
      {
        paramu = com.tencent.mm.model.ae.Bv(URISpanHandlerSet.a(URISpanHandlerSet.this).getString(2131760084));
        paramString = new Intent();
        paramString.setClass(URISpanHandlerSet.a(URISpanHandlerSet.this), AddressUI.class);
        paramString.putExtra("Contact_GroupFilter_Type", paramu.getType());
        paramString.putExtra("Contact_GroupFilter_DisplayName", paramu.adF());
        paramString.addFlags(67108864);
        if ((URISpanHandlerSet.a(URISpanHandlerSet.this) instanceof Service)) {
          paramString.addFlags(268435456);
        }
        paramu = LauncherUI.getInstance();
        if (paramu != null) {
          paramu.Jty.getMainTabUI().aWU("tab_settings");
        }
        paramu = URISpanHandlerSet.a(URISpanHandlerSet.this);
        paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(paramu, paramString.ahE(), "com/tencent/mm/app/plugin/URISpanHandlerSet$SettingBlacklistUriSpanHandler", "handleUriJump", "(Ljava/lang/String;ZLcom/tencent/mm/pluginsdk/UriJumpCallback;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramu.startActivity((Intent)paramString.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramu, "com/tencent/mm/app/plugin/URISpanHandlerSet$SettingBlacklistUriSpanHandler", "handleUriJump", "(Ljava/lang/String;ZLcom/tencent/mm/pluginsdk/UriJumpCallback;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(19741);
        return true;
      }
      AppMethodBeat.o(19741);
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u fL(String paramString)
    {
      AppMethodBeat.i(19739);
      if (paramString.trim().startsWith("weixin://setting/blacklist"))
      {
        paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 14, null);
        AppMethodBeat.o(19739);
        return paramString;
      }
      AppMethodBeat.o(19739);
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class SettingHeadImgUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    SettingHeadImgUriSpanHandler()
    {
      super();
    }
    
    final int[] Nd()
    {
      return new int[] { 6 };
    }
    
    final boolean a(com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.h paramh)
    {
      AppMethodBeat.i(19743);
      if (paramu.type == 6)
      {
        if (paramh != null) {
          paramh.a(paramu);
        }
        LauncherUI localLauncherUI = LauncherUI.getInstance();
        if (localLauncherUI != null) {
          localLauncherUI.Jty.getMainTabUI().aWU("tab_settings");
        }
        if (paramh != null) {
          paramh.b(paramu);
        }
        AppMethodBeat.o(19743);
        return true;
      }
      AppMethodBeat.o(19743);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      AppMethodBeat.i(19744);
      if (paramString.equals("weixin://setting/setheadimage"))
      {
        paramString = new Intent();
        paramString.putExtra("Contact_User", v.aAC());
        paramString.putExtra("Contact_Nick", v.aAE());
        paramString.putExtra("User_Avatar", true);
        if ((URISpanHandlerSet.a(URISpanHandlerSet.this) instanceof Service)) {
          paramString.addFlags(268435456);
        }
        com.tencent.mm.br.d.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "profile", ".ui.ContactInfoUI", paramString);
        AppMethodBeat.o(19744);
        return true;
      }
      AppMethodBeat.o(19744);
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u fL(String paramString)
    {
      AppMethodBeat.i(19742);
      if (paramString.trim().startsWith("weixin://setting/setheadimage"))
      {
        paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 6, null);
        AppMethodBeat.o(19742);
        return paramString;
      }
      AppMethodBeat.o(19742);
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class SettingNotifyUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    SettingNotifyUriSpanHandler()
    {
      super();
    }
    
    final int[] Nd()
    {
      return new int[] { 9 };
    }
    
    final boolean a(com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.h paramh)
    {
      AppMethodBeat.i(19746);
      if (paramu.type == 9)
      {
        if (paramh != null) {
          paramh.a(paramu);
        }
        LauncherUI localLauncherUI = LauncherUI.getInstance();
        if (localLauncherUI != null) {
          localLauncherUI.Jty.getMainTabUI().aWU("tab_settings");
        }
        com.tencent.mm.br.d.Q(URISpanHandlerSet.a(URISpanHandlerSet.this), "setting", ".ui.setting.SettingsNotificationUI");
        if (paramh != null) {
          paramh.b(paramu);
        }
        AppMethodBeat.o(19746);
        return true;
      }
      AppMethodBeat.o(19746);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      AppMethodBeat.i(19747);
      if (paramString.equals("weixin://setting/notify"))
      {
        paramString = LauncherUI.getInstance();
        if (paramString != null) {
          paramString.Jty.getMainTabUI().aWU("tab_settings");
        }
        paramString = new Intent();
        paramString.addFlags(67108864);
        if ((URISpanHandlerSet.a(URISpanHandlerSet.this) instanceof Service)) {
          paramString.addFlags(268435456);
        }
        com.tencent.mm.br.d.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "setting", ".ui.setting.SettingsNotificationUI", paramString);
        AppMethodBeat.o(19747);
        return true;
      }
      AppMethodBeat.o(19747);
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u fL(String paramString)
    {
      AppMethodBeat.i(19745);
      if (paramString.trim().startsWith("weixin://setting/notify"))
      {
        paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 9, null);
        AppMethodBeat.o(19745);
        return paramString;
      }
      AppMethodBeat.o(19745);
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
    
    final int[] Nd()
    {
      return new int[] { 12 };
    }
    
    final boolean a(com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.h paramh)
    {
      AppMethodBeat.i(19749);
      if (paramu.type == 12)
      {
        if (paramh != null) {
          paramh.a(paramu);
        }
        Intent localIntent = new Intent();
        localIntent.putExtra("Contact_User", "weibo");
        com.tencent.mm.br.d.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "profile", ".ui.ContactInfoUI", localIntent);
        if (paramh != null) {
          paramh.b(paramu);
        }
        AppMethodBeat.o(19749);
        return true;
      }
      AppMethodBeat.o(19749);
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
        com.tencent.mm.br.d.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "profile", ".ui.ContactInfoUI", paramString);
        AppMethodBeat.o(19750);
        return true;
      }
      AppMethodBeat.o(19750);
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u fL(String paramString)
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
    
    final int[] Nd()
    {
      return new int[] { 10 };
    }
    
    final boolean a(com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.h paramh)
    {
      AppMethodBeat.i(19752);
      if (paramu.type == 10)
      {
        if (paramh != null) {
          paramh.a(paramu);
        }
        Intent localIntent = new Intent();
        localIntent.putExtra("Contact_User", "qqmail");
        com.tencent.mm.br.d.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "profile", ".ui.ContactInfoUI", localIntent);
        if (paramh != null) {
          paramh.b(paramu);
        }
        AppMethodBeat.o(19752);
        return true;
      }
      AppMethodBeat.o(19752);
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
        com.tencent.mm.br.d.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "profile", ".ui.ContactInfoUI", paramString);
        AppMethodBeat.o(19753);
        return true;
      }
      AppMethodBeat.o(19753);
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u fL(String paramString)
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
    
    final int[] Nd()
    {
      return new int[] { 13 };
    }
    
    final boolean a(com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.h paramh)
    {
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u fL(String paramString)
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
    
    final int[] Nd()
    {
      return new int[] { 11 };
    }
    
    final boolean a(com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.h paramh)
    {
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u fL(String paramString)
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
  class SettingPrivacyUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    SettingPrivacyUriSpanHandler()
    {
      super();
    }
    
    final int[] Nd()
    {
      return new int[] { 15 };
    }
    
    final boolean a(com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.h paramh)
    {
      AppMethodBeat.i(19757);
      if (paramu.type == 15)
      {
        if (paramh != null) {
          paramh.a(paramu);
        }
        LauncherUI localLauncherUI = LauncherUI.getInstance();
        if (localLauncherUI != null) {
          localLauncherUI.Jty.getMainTabUI().aWU("tab_settings");
        }
        com.tencent.mm.br.d.Q(URISpanHandlerSet.a(URISpanHandlerSet.this), "setting", ".ui.setting.SettingsPrivacyUI");
        if (paramh != null) {
          paramh.b(paramu);
        }
        AppMethodBeat.o(19757);
        return true;
      }
      AppMethodBeat.o(19757);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      AppMethodBeat.i(19758);
      if (paramString.equals("weixin://setting/privacy"))
      {
        paramString = LauncherUI.getInstance();
        if (paramString != null) {
          paramString.Jty.getMainTabUI().aWU("tab_settings");
        }
        paramString = new Intent();
        if ((URISpanHandlerSet.a(URISpanHandlerSet.this) instanceof Service)) {
          paramString.addFlags(268435456);
        }
        com.tencent.mm.br.d.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "setting", ".ui.setting.SettingsPrivacyUI", paramString);
        AppMethodBeat.o(19758);
        return true;
      }
      AppMethodBeat.o(19758);
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u fL(String paramString)
    {
      AppMethodBeat.i(19756);
      if (paramString.trim().startsWith("weixin://setting/privacy"))
      {
        paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 15, null);
        AppMethodBeat.o(19756);
        return paramString;
      }
      AppMethodBeat.o(19756);
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
    
    final int[] Nd()
    {
      return new int[] { 48 };
    }
    
    final boolean a(com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.h paramh)
    {
      AppMethodBeat.i(19759);
      if (paramu.type == 48)
      {
        String str = paramu.username;
        if (TextUtils.isEmpty(str))
        {
          AppMethodBeat.o(19759);
          return false;
        }
        if (com.tencent.mm.plugin.sns.f.a.azH(str)) {
          com.tencent.mm.plugin.story.api.o.bk(URISpanHandlerSet.a(URISpanHandlerSet.this), str);
        }
        if (paramh != null) {
          paramh.b(paramu);
        }
        AppMethodBeat.o(19759);
        return true;
      }
      AppMethodBeat.o(19759);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u fL(String paramString)
    {
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class TodoSystemMsgUrlSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    TodoSystemMsgUrlSpanHandler()
    {
      super();
    }
    
    final int[] Nd()
    {
      return new int[] { 54 };
    }
    
    final boolean a(com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.h paramh)
    {
      AppMethodBeat.i(179564);
      if (paramu.type == 54) {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.URISpanHandlerSet", "handleClickTodoSystemMsgUrl");
      }
      label392:
      label398:
      for (;;)
      {
        boolean bool1;
        try
        {
          localObject1 = Uri.parse(paramu.url);
          paramh = paramu.chatroomName;
          str1 = ((Uri)localObject1).getQueryParameter("todoid");
          ((Uri)localObject1).getQueryParameter("related_msgid");
          str2 = ((Uri)localObject1).getQueryParameter("username");
          localObject2 = ((Uri)localObject1).getQueryParameter("path");
          localObject1 = ((PluginChatroomUI)com.tencent.mm.kernel.g.ad(PluginChatroomUI.class)).getGroupTodoStorage().ag(paramh, str1);
          if (!bu.lX("roomannouncement@app.origin", str2)) {
            continue;
          }
          com.tencent.mm.chatroom.d.y.f(ak.getContext(), paramh, true);
          bool2 = com.tencent.mm.chatroom.d.y.e((com.tencent.mm.chatroom.storage.c)localObject1);
          if (!bool2) {
            break label392;
          }
          bool1 = com.tencent.mm.chatroom.d.y.b((com.tencent.mm.chatroom.storage.c)localObject1);
          if (!bool1) {
            break label398;
          }
          localObject2 = new nc();
          ((nc)localObject2).dCe.op = 3;
          ((nc)localObject2).dCe.dwx = ((com.tencent.mm.chatroom.storage.c)localObject1).field_roomname;
          ((nc)localObject2).dCe.dCf = str1;
          com.tencent.mm.sdk.b.a.IvT.a((com.tencent.mm.sdk.b.b)localObject2, Looper.getMainLooper());
        }
        catch (Exception paramh)
        {
          Object localObject1;
          String str1;
          String str2;
          Object localObject2;
          boolean bool2;
          com.tencent.mm.plugin.appbrand.api.f localf;
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.URISpanHandlerSet", "handle click link error: %s, url: %s", new Object[] { paramh.getMessage(), paramu.url });
          continue;
          int i = 0;
          continue;
        }
        if (bu.lX("roomannouncement@app.origin", str2))
        {
          i = 1;
          com.tencent.mm.chatroom.d.z.a(paramh, i, 2, str1, str2);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.URISpanHandlerSet", "handleClickTodoSystemMsgUrl stoTodo(%s %s %s) update finish(%s)", new Object[] { Boolean.valueOf(bu.isNullOrNil(str1)), Boolean.valueOf(bu.isNullOrNil(str2)), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
          AppMethodBeat.o(179564);
          return true;
          localf = new com.tencent.mm.plugin.appbrand.api.f();
          localf.username = str2;
          localf.jFL = ((String)localObject2);
          localf.scene = 1160;
          localf.jFV = paramh;
          if (localObject1 != null)
          {
            localf.cmw = ((com.tencent.mm.chatroom.storage.c)localObject1).field_shareKey;
            localf.cmv = ((com.tencent.mm.chatroom.storage.c)localObject1).field_shareName;
          }
          ((com.tencent.mm.plugin.appbrand.service.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.p.class)).a(URISpanHandlerSet.a(URISpanHandlerSet.this), localf);
        }
        else
        {
          AppMethodBeat.o(179564);
          return false;
          bool1 = false;
        }
      }
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u fL(String paramString)
    {
      AppMethodBeat.i(179563);
      if (paramString.trim().toLowerCase().startsWith("weixin://roomtoolstodo?"))
      {
        paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 54, null);
        AppMethodBeat.o(179563);
        return paramString;
      }
      AppMethodBeat.o(179563);
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class TransferUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    TransferUriSpanHandler()
    {
      super();
    }
    
    final int[] Nd()
    {
      return new int[] { 39, 40, 41, 42, 49, 56 };
    }
    
    final boolean a(com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.h paramh)
    {
      AppMethodBeat.i(19762);
      if (paramu != null)
      {
        if (paramu.type == 42)
        {
          com.tencent.mm.br.d.Q(URISpanHandlerSet.a(URISpanHandlerSet.this), "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
          AppMethodBeat.o(19762);
          return true;
        }
        if (paramu.type == 41)
        {
          com.tencent.mm.br.d.Q(URISpanHandlerSet.a(URISpanHandlerSet.this), "wallet", ".balance.ui.WalletBalanceManagerUI");
          AppMethodBeat.o(19762);
          return true;
        }
        if (paramu.type == 39)
        {
          if ((paramu.data != null) && ((paramu.data instanceof Bundle)))
          {
            paramu = (Bundle)paramu.data;
            paramh = (ResendMsgInfo)paramu.getParcelable("resend_msg_info");
            ((com.tencent.mm.plugin.wxpaysdk.api.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.wxpaysdk.api.b.class)).a(URISpanHandlerSet.a(URISpanHandlerSet.this), paramh, new URISpanHandlerSet.TransferUriSpanHandler.1(this, paramu));
          }
          AppMethodBeat.o(19762);
          return true;
        }
        if (paramu.type == 40)
        {
          if ((paramu.data != null) && ((paramu.data instanceof Bundle)))
          {
            paramu = (Bundle)paramu.data;
            paramh = new qv();
            paramh.dGu.dmx = paramu.getString("transaction_id");
            paramh.dGu.dyA = paramu.getString("transfer_id");
            paramh.dGu.dGv = paramu.getInt("total_fee");
            paramh.dGu.dGw = paramu.getString("sender_name");
            com.tencent.mm.sdk.b.a.IvT.l(paramh);
          }
          AppMethodBeat.o(19762);
          return true;
        }
        Object localObject;
        if (paramu.type == 49)
        {
          paramh = Uri.parse(paramu.url);
          localObject = paramh.getQueryParameter("transfer_id");
          String str = paramh.getQueryParameter("trans_id");
          paramh = "";
          if ((paramu.data != null) && ((paramu.data instanceof Bundle))) {}
          for (paramu = ((Bundle)paramu.data).getString("sender_name");; paramu = paramh)
          {
            paramh = new Intent();
            paramh.putExtra("transfer_id", (String)localObject);
            paramh.putExtra("transaction_id", str);
            paramh.putExtra("sender_name", paramu);
            com.tencent.mm.br.d.b(ak.getContext(), "remittance", ".ui.RemittanceDetailUI", paramh);
            AppMethodBeat.o(19762);
            return true;
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.URISpanHandlerSet", "hrefInfo.getType() == TYPE_TRANSFER_QUERY_MSG senderName == null");
          }
        }
        if (paramu.type == 56)
        {
          localObject = Uri.parse(paramu.url);
          paramh = ((Uri)localObject).getQueryParameter("transferid");
          paramu = ((Uri)localObject).getQueryParameter("fromusername");
          localObject = ((Uri)localObject).getQueryParameter("transfer_msg_type");
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.URISpanHandlerSet", "click MSpanConstants.Type.TYPE_TRANSFER_REMINDE_RECEIVE_MSG, transferId: %s，msgType:%s", new Object[] { paramh, localObject });
          com.tencent.mm.plugin.report.service.g.yxI.f(20467, new Object[] { "transfer_to_change", "click message", "", "", "", "", Integer.valueOf(3), paramh, localObject });
          if ((!bu.isNullOrNil(paramh)) && (!bu.isNullOrNil(paramu)))
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.URISpanHandlerSet", "handle MSpanConstants.Type.TYPE_TRANSFER_REMINDE_RECEIVE_MSG");
            com.tencent.mm.plugin.remittance.a.c.dLS();
            paramh = com.tencent.mm.plugin.remittance.a.c.dLU().axw(paramh);
            if ((paramh == null) || (paramh.field_locaMsgId <= 0L)) {
              break label720;
            }
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.URISpanHandlerSet", "handle MSpanConstants.Type.TYPE_TRANSFER_REMINDE_RECEIVE_MSG, localMsgId: %s", new Object[] { Long.valueOf(paramh.field_locaMsgId) });
            if (((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().ys(paramh.field_locaMsgId).field_msgId > 0L) {
              break label682;
            }
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.URISpanHandlerSet", "cannot find msg in msg storage!");
            new f.a(ak.getContext()).aZq(ak.getContext().getString(2131762488)).afZ(ak.getContext().getResources().getColor(2131100547)).afY(2131760315).b(new URISpanHandlerSet.TransferUriSpanHandler.2(this)).show();
          }
          for (;;)
          {
            AppMethodBeat.o(19762);
            return true;
            label682:
            localObject = new st();
            ((st)localObject).dIr.msgId = paramh.field_locaMsgId;
            ((st)localObject).dIr.cUA = paramu;
            com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
            continue;
            label720:
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.URISpanHandlerSet", "handle MSpanConstants.Type.TYPE_TRANSFER_REMINDE_RECEIVE_MSG, cannot find local msg");
            new f.a(ak.getContext()).aZq(ak.getContext().getString(2131762488)).afZ(ak.getContext().getResources().getColor(2131100547)).afY(2131760315).b(new URISpanHandlerSet.TransferUriSpanHandler.3(this)).show();
          }
        }
      }
      AppMethodBeat.o(19762);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u fL(String paramString)
    {
      AppMethodBeat.i(19761);
      if (paramString.trim().toLowerCase().startsWith("weixin://wcpay/transfer/retrysendmsg"))
      {
        paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 39, null);
        AppMethodBeat.o(19761);
        return paramString;
      }
      if (paramString.trim().toLowerCase().startsWith("weixin://wcpay/transfer/rebacksendmsg"))
      {
        paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 40, null);
        AppMethodBeat.o(19761);
        return paramString;
      }
      if (paramString.trim().toLowerCase().startsWith("weixin://wcpay/transfer/watchbalance"))
      {
        paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 41, null);
        AppMethodBeat.o(19761);
        return paramString;
      }
      if (paramString.trim().toLowerCase().startsWith("weixin://wcpay/transfer/watchlqt"))
      {
        paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 42, null);
        AppMethodBeat.o(19761);
        return paramString;
      }
      if (paramString.trim().toLowerCase().startsWith("wechat://wcpay/transfer/transferquery"))
      {
        paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 49, null);
        AppMethodBeat.o(19761);
        return paramString;
      }
      if (paramString.trim().toLowerCase().startsWith("weixin://wxpay/transfer/remindrcvmsg"))
      {
        paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 56, null);
        AppMethodBeat.o(19761);
        return paramString;
      }
      AppMethodBeat.o(19761);
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
    
    final int[] Nd()
    {
      return new int[] { 2147483646 };
    }
    
    final boolean a(com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.h paramh)
    {
      AppMethodBeat.i(19763);
      if (paramu.type == 2147483646)
      {
        if ((paramu.data instanceof Bundle))
        {
          paramu = ((Bundle)paramu.data).getString("rawUrl");
          if (bu.isNullOrNil(paramu)) {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.URISpanHandlerSet", "TYPE_UNKNOW_TO_URL url == null");
          }
        }
        for (;;)
        {
          AppMethodBeat.o(19763);
          return true;
          com.tencent.mm.plugin.account.a.b.a.b(ak.getContext(), paramu, 0, true);
          continue;
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.URISpanHandlerSet", "TYPE_UNKNOW_TO_URL hrefInfo.getData() no instanceof Bundle");
        }
      }
      AppMethodBeat.o(19763);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u fL(String paramString)
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
    
    final int[] Nd()
    {
      return new int[] { 53 };
    }
    
    final boolean a(com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.h paramh)
    {
      AppMethodBeat.i(179566);
      if (paramu.type == 53) {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.URISpanHandlerSet", "handleClickUpgradeAssociateChatRoomUrl");
      }
      for (;;)
      {
        Object localObject;
        try
        {
          paramh = Uri.parse(paramu.url).getQueryParameter("roomname");
          if (bu.isNullOrNil(paramh))
          {
            com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.URISpanHandlerSet", "Username is null.");
            AppMethodBeat.o(179566);
            return true;
          }
          if (x.wb(paramh))
          {
            localObject = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(paramh);
            if (localObject == null)
            {
              com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.URISpanHandlerSet", "handleClickUpgradeAssociateChatRoomUrl %s member is null", new Object[] { paramh });
              AppMethodBeat.o(179566);
              return true;
            }
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.URISpanHandlerSet", "handleClickUpgradeAssociateChatRoomUrl room:%s chatroomStatus:%s owener:%s", new Object[] { paramh, Integer.valueOf(((com.tencent.mm.storage.ac)localObject).field_chatroomStatus), bu.bI(((com.tencent.mm.storage.ac)localObject).field_roomowner, "") });
            if (((com.tencent.mm.storage.ac)localObject).field_memberCount >= com.tencent.mm.model.r.aAx())
            {
              i = 1;
              if (!x.zZ(paramh)) {
                break label301;
              }
              if (((com.tencent.mm.storage.ac)localObject).Bj(v.aAC())) {
                break label392;
              }
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.URISpanHandlerSet", "handleClickUpgradeAssociateChatRoomUrl：no owner");
              if (URISpanHandlerSet.a(URISpanHandlerSet.this) != null)
              {
                com.tencent.mm.ui.base.h.a(URISpanHandlerSet.a(URISpanHandlerSet.this), URISpanHandlerSet.a(URISpanHandlerSet.this).getString(2131757110), "", URISpanHandlerSet.a(URISpanHandlerSet.this).getString(2131755792), false, null);
                break label631;
                ManagerRoomByWeworkUI.c(paramh, 2, 2, i);
                AppMethodBeat.o(179566);
                return true;
              }
            }
            else
            {
              i = 0;
              continue;
            }
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.URISpanHandlerSet", "handleClickUpgradeAssociateChatRoomUrl：mContext is null");
          }
        }
        catch (Exception paramh)
        {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.URISpanHandlerSet", "handle click link error: %s, url: %s", new Object[] { paramh.getMessage(), paramu.url });
        }
        for (;;)
        {
          AppMethodBeat.o(179566);
          return true;
          label301:
          if ((x.zX(paramh)) && (!((com.tencent.mm.storage.ac)localObject).Bj(v.aAC())))
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.URISpanHandlerSet", "handleClickUpgradeAssociateChatRoomUrl：isAssociateChatRoom ");
            if (URISpanHandlerSet.a(URISpanHandlerSet.this) != null) {
              com.tencent.mm.ui.base.h.a(URISpanHandlerSet.a(URISpanHandlerSet.this), URISpanHandlerSet.a(URISpanHandlerSet.this).getString(2131757107), "", URISpanHandlerSet.a(URISpanHandlerSet.this).getString(2131755792), false, null);
            }
            for (;;)
            {
              AppMethodBeat.o(179566);
              return true;
              com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.URISpanHandlerSet", "handleClickUpgradeAssociateChatRoomUrl：mContext is null");
            }
          }
          label392:
          if (i != 0)
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.URISpanHandlerSet", "handleClickUpgradeAssociateChatRoomUrl：exceed maxnum");
            if (URISpanHandlerSet.a(URISpanHandlerSet.this) != null) {
              com.tencent.mm.ui.base.h.a(URISpanHandlerSet.a(URISpanHandlerSet.this), URISpanHandlerSet.a(URISpanHandlerSet.this).getString(2131757108), "", URISpanHandlerSet.a(URISpanHandlerSet.this).getString(2131755792), false, null);
            }
            for (;;)
            {
              ManagerRoomByWeworkUI.c(paramh, 2, 2, 2);
              AppMethodBeat.o(179566);
              return true;
              com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.URISpanHandlerSet", "handleClickUpgradeAssociateChatRoomUrl：mContext is null");
            }
          }
          com.tencent.mm.plugin.newtips.a.dxD().Mv(25);
          com.tencent.mm.plugin.newtips.a.dxD().Mv(26);
          com.tencent.mm.plugin.newtips.a.dxD().Mv(27);
          localObject = new Intent();
          ((Intent)localObject).setClass(ak.getContext(), ManagerRoomByWeworkUI.class);
          ((Intent)localObject).addFlags(268435456);
          ((Intent)localObject).putExtra("RoomInfo_Id", paramh);
          ((Intent)localObject).putExtra("upgrade_openim_room_from_scene", 2);
          paramh = ak.getContext();
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramh, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/app/plugin/URISpanHandlerSet$UpgradeAssociateChatRoomUrlSpanHandler", "handleSpanClick", "(Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramh.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramh, "com/tencent/mm/app/plugin/URISpanHandlerSet$UpgradeAssociateChatRoomUrlSpanHandler", "handleSpanClick", "(Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(179566);
        return false;
        label631:
        do
        {
          i = 1;
          break;
        } while (i == 0);
        int i = 3;
      }
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u fL(String paramString)
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
    
    final int[] Nd()
    {
      return new int[] { 4 };
    }
    
    final boolean a(com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.h paramh)
    {
      AppMethodBeat.i(19765);
      if (paramu.type == 4)
      {
        if (paramh != null)
        {
          paramh.a(paramu);
          paramh.b(paramu);
        }
        AppMethodBeat.o(19765);
        return true;
      }
      AppMethodBeat.o(19765);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u fL(String paramString)
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
    
    final int[] Nd()
    {
      return new int[] { 38 };
    }
    
    final boolean a(com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.h paramh)
    {
      AppMethodBeat.i(19767);
      if (paramu.type == 38)
      {
        paramh = Uri.parse(paramu.url);
        paramu = paramh.getQueryParameter("username");
        paramh = paramh.getQueryParameter("isvideocall");
        yh localyh = new yh();
        localyh.dNE.dto = 5;
        localyh.dNE.talker = paramu;
        localyh.dNE.context = URISpanHandlerSet.a(URISpanHandlerSet.this);
        if ((paramu != null) && (!paramu.equals("")))
        {
          if ((paramh != null) && (paramh.equals("true"))) {}
          for (localyh.dNE.dNA = 2;; localyh.dNE.dNA = 4)
          {
            com.tencent.mm.sdk.b.a.IvT.l(localyh);
            AppMethodBeat.o(19767);
            return true;
          }
        }
      }
      AppMethodBeat.o(19767);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u fL(String paramString)
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
    WeWorkUrlSpanHandler()
    {
      super();
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
    
    final int[] Nd()
    {
      return new int[] { 52 };
    }
    
    final boolean a(com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.h paramh)
    {
      AppMethodBeat.i(179568);
      if (paramu.type == 52)
      {
        paramh = new Intent();
        paramh.setAction("android.intent.action.VIEW");
        paramh.setData(Uri.parse(paramu.url));
        paramh.setPackage("com.tencent.wework");
        paramh.setFlags(268435456);
        try
        {
          boolean bool = com.tencent.mm.pluginsdk.model.app.h.b(ak.getContext(), paramh, getAppName(ak.getContext(), "com.tencent.wework"));
          if (!bool) {
            com.tencent.mm.plugin.account.a.b.a.b(ak.getContext(), "https://work.weixin.qq.com/wework_admin/commdownload", 0, true);
          }
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.URISpanHandlerSet", "WeWorkUrlSpanHandler result:%s", new Object[] { Boolean.valueOf(bool) });
          AppMethodBeat.o(179568);
          return true;
        }
        catch (Exception paramu)
        {
          AppMethodBeat.o(179568);
          return false;
        }
      }
      AppMethodBeat.o(179568);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
    {
      return false;
    }
    
    final com.tencent.mm.pluginsdk.ui.applet.u fL(String paramString)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet
 * JD-Core Version:    0.7.0.1
 */