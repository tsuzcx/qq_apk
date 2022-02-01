package com.tencent.mm.app.plugin;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.acn;
import com.tencent.mm.autogen.a.kw;
import com.tencent.mm.autogen.a.kw.a;
import com.tencent.mm.autogen.a.qa;
import com.tencent.mm.autogen.a.ud;
import com.tencent.mm.autogen.a.wk;
import com.tencent.mm.autogen.a.zp;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.autogen.mmdata.rpt.rv;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.ui.ManagerRoomByWeworkUI;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.t.b;
import com.tencent.mm.modelmulti.t.e;
import com.tencent.mm.msgsubscription.api.ISubscribeMsgService;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.bind.ui.MobileFriendUI;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalInfoUI;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.plugin.websearch.api.as;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.wxpaysdk.api.ResendMsgInfo;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.span.m;
import com.tencent.mm.pluginsdk.ui.span.r;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.protobuf.ebg;
import com.tencent.mm.protocal.protobuf.flr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.cm;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.MainTabUI;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.AddressUI;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.e;
import com.tencent.mm.ui.f.f;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.a.g.c;
import com.tencent.mm.vfs.y;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class URISpanHandlerSet
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
    AAUriSpanHandler() {}
    
    public final boolean a(View paramView, u paramu, m paramm)
    {
      AppMethodBeat.i(239387);
      Object localObject;
      if (paramu.type == 35) {
        for (;;)
        {
          try
          {
            paramView = Uri.parse(paramu.url);
            paramm = paramView.getQueryParameter("billno");
            if (Util.isNullOrNil(paramm))
            {
              Log.e("MicroMsg.URISpanHandlerSet", "url error, billno is null");
              AppMethodBeat.o(239387);
              return true;
            }
            int i = Util.getInt(paramView.getQueryParameter("scene"), 3);
            if (!(paramu.cpt instanceof Bundle)) {
              continue;
            }
            paramView = ((Bundle)paramu.cpt).getString("chatroom_name");
            localObject = new Intent();
            ((Intent)localObject).putExtra("bill_no", paramm);
            ((Intent)localObject).putExtra("enter_scene", i);
            ((Intent)localObject).putExtra("chatroom", paramView);
            com.tencent.mm.br.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "aa", ".ui.PaylistAAUI", (Intent)localObject);
          }
          catch (Exception paramView)
          {
            Log.e("MicroMsg.URISpanHandlerSet", "handle click new aa open detail link error: %s, url: %s", new Object[] { paramView.getMessage(), paramu.url });
            continue;
          }
          AppMethodBeat.o(239387);
          return true;
          if ((paramu.cpt instanceof String))
          {
            paramView = paramu.cpt.toString();
          }
          else
          {
            Log.e("MicroMsg.URISpanHandlerSet", "illegal data type, %s", new Object[] { paramu });
            AppMethodBeat.o(239387);
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
          paramView = Uri.parse(paramu.url).getQueryParameter("billno");
          if (Util.isNullOrNil(paramView))
          {
            Log.e("MicroMsg.URISpanHandlerSet", "url error, billno is null");
            AppMethodBeat.o(239387);
            return true;
          }
          if (!(paramu.cpt instanceof Bundle))
          {
            Log.e("MicroMsg.URISpanHandlerSet", "error data!");
            AppMethodBeat.o(239387);
            return true;
          }
          paramm = (Bundle)paramu.cpt;
          localObject = paramm.getString("chatroom_name");
          if (Util.isNullOrNil((String)localObject))
          {
            Log.e("MicroMsg.URISpanHandlerSet", "empty chatroom!");
            AppMethodBeat.o(239387);
            return true;
          }
          l = paramm.getLong("msg_id", -1L);
          if (l < 0L)
          {
            Log.e("MicroMsg.URISpanHandlerSet", "msgId is null");
            AppMethodBeat.o(239387);
            return true;
          }
          k.a(URISpanHandlerSet.a(URISpanHandlerSet.this), R.l.gWq, -1, R.l.gWt, R.l.cancel, new URISpanHandlerSet.AAUriSpanHandler.1(this, paramView, (String)localObject, l), null);
        }
        catch (Exception paramView)
        {
          Log.e("MicroMsg.URISpanHandlerSet", "handle click new aa close link error: %s, url: %s", new Object[] { paramView.getMessage(), paramu.url });
          continue;
        }
        AppMethodBeat.o(239387);
        return false;
        if (paramu.type == 36) {
          try
          {
            paramm = Uri.parse(paramu.url).getQueryParameter("billno");
            if (Util.isNullOrNil(paramm))
            {
              Log.e("MicroMsg.URISpanHandlerSet", "url error, billno is null");
              AppMethodBeat.o(239387);
              return true;
            }
            paramView = null;
            if ((paramu.cpt instanceof Bundle)) {
              paramView = (Bundle)paramu.cpt;
            }
            if ((paramView == null) || (Util.isNullOrNil(paramView.getString("chatroom_name"))))
            {
              Log.e("MicroMsg.URISpanHandlerSet", "empty chatroom!");
              AppMethodBeat.o(239387);
              return true;
            }
            localObject = paramView.getString("chatroom_name");
            l = paramView.getLong("msg_id", -1L);
            k.a(URISpanHandlerSet.a(URISpanHandlerSet.this), R.l.gWr, -1, R.l.gWs, R.l.cancel, new URISpanHandlerSet.AAUriSpanHandler.2(this, paramm, (String)localObject, l), null);
          }
          catch (Exception paramView)
          {
            Log.e("MicroMsg.URISpanHandlerSet", "handle click new aa urge notify link error: %s, url: %s", new Object[] { paramView.getMessage(), paramu.url });
          }
        }
      }
    }
    
    public final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.v paramv, Bundle paramBundle)
    {
      return false;
    }
    
    public final int[] aDQ()
    {
      return new int[] { 35, 36, 37 };
    }
    
    public final u iJ(String paramString)
    {
      AppMethodBeat.i(19675);
      if (paramString.trim().toLowerCase().startsWith("weixin://weixinnewaa/opendetail"))
      {
        paramString = new u(paramString, 35, null);
        AppMethodBeat.o(19675);
        return paramString;
      }
      if (paramString.trim().toLowerCase().startsWith("weixin://weixinnewaa/closeurgenotify"))
      {
        paramString = new u(paramString, 36, null);
        AppMethodBeat.o(19675);
        return paramString;
      }
      if (paramString.trim().toLowerCase().startsWith("weixin://weixinnewaa/closeaa"))
      {
        paramString = new u(paramString, 37, null);
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
    AddressUriSpanHandler() {}
    
    public final boolean a(View paramView, u paramu, m paramm)
    {
      AppMethodBeat.i(239399);
      if (paramu.type == 44)
      {
        paramu = Uri.parse("geo:0,0?q=" + Uri.encode(paramu.url));
        paramView = new Intent("android.intent.action.VIEW");
        paramView.setData(paramu);
        paramView.addFlags(268435456);
        if (paramView.resolveActivity(MMApplicationContext.getContext().getPackageManager()) != null)
        {
          paramu = MMApplicationContext.getContext();
          paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
          com.tencent.mm.hellhoundlib.a.a.b(paramu, paramView.aYi(), "com/tencent/mm/app/plugin/URISpanHandlerSet$AddressUriSpanHandler", "handleSpanClick", "(Landroid/view/View;Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramu.startActivity((Intent)paramView.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramu, "com/tencent/mm/app/plugin/URISpanHandlerSet$AddressUriSpanHandler", "handleSpanClick", "(Landroid/view/View;Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.plugin.report.service.h.OAn.b(12809, new Object[] { Integer.valueOf(9), "" });
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.OAn.b(12809, new Object[] { Integer.valueOf(8), "" });
          AppMethodBeat.o(239399);
          return true;
          Log.w("MicroMsg.URISpanHandlerSet", "Cannot find map app");
        }
      }
      AppMethodBeat.o(239399);
      return false;
    }
    
    public final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.v paramv, Bundle paramBundle)
    {
      return false;
    }
    
    public final int[] aDQ()
    {
      return new int[] { 44 };
    }
    
    public final u iJ(String paramString)
    {
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class AlphaInstallUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    AlphaInstallUriSpanHandler() {}
    
    public final boolean a(View paramView, u paramu, m paramm)
    {
      AppMethodBeat.i(239373);
      if (paramu.type == 32)
      {
        paramView = paramu.url.replace("weixin://alphainstall?", "");
        paramu = Uri.parse(paramView).getQueryParameter("md5");
        paramu = com.tencent.mm.loader.i.b.bmz() + paramu + ".apk";
        if (y.ZC(paramu)) {
          com.tencent.mm.pluginsdk.model.app.v.b(MMApplicationContext.getContext(), paramu, null, false);
        }
        for (;;)
        {
          AppMethodBeat.o(239373);
          return true;
          paramu = new Intent();
          paramu.putExtra("rawUrl", paramView.toString());
          com.tencent.mm.br.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "webview", ".ui.tools.WebViewUI", paramu);
        }
      }
      AppMethodBeat.o(239373);
      return false;
    }
    
    public final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.v paramv, Bundle paramBundle)
    {
      return false;
    }
    
    public final int[] aDQ()
    {
      return new int[] { 32 };
    }
    
    public final u iJ(String paramString)
    {
      AppMethodBeat.i(19678);
      if (paramString.trim().toLowerCase().startsWith("weixin://alphainstall?"))
      {
        paramString = new u(paramString, 32, null);
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
    AppBrandLinkSpanHandler() {}
    
    public final boolean a(View paramView, u paramu, m paramm)
    {
      AppMethodBeat.i(239366);
      if (paramu.type == 45)
      {
        if ((paramu.fromScene == 1) && (paramu.hTm != null)) {
          com.tencent.mm.an.l.ad(paramu.hTm);
        }
        if (paramm != null)
        {
          Log.i("MicroMsg.URISpanHandlerSet", "AppBrandLinkSpanHandler click appbrandlink");
          paramm.b(paramu);
          AppMethodBeat.o(239366);
          return true;
        }
        Log.e("MicroMsg.URISpanHandlerSet", "clickCallback is null, return");
      }
      AppMethodBeat.o(239366);
      return false;
    }
    
    public final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.v paramv, Bundle paramBundle)
    {
      return false;
    }
    
    public final int[] aDQ()
    {
      return new int[] { 45 };
    }
    
    public final u iJ(String paramString)
    {
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class BindMobileUrilSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    BindMobileUrilSpanHandler() {}
    
    public final boolean a(View paramView, u paramu, m paramm)
    {
      AppMethodBeat.i(239394);
      if (paramu.type == 5)
      {
        if (paramm != null) {
          paramm.a(paramu);
        }
        MMWizardActivity.aQ(URISpanHandlerSet.a(URISpanHandlerSet.this), new Intent(URISpanHandlerSet.a(URISpanHandlerSet.this), BindMContactIntroUI.class));
        if (paramm != null) {
          paramm.b(paramu);
        }
        AppMethodBeat.o(239394);
        return true;
      }
      AppMethodBeat.o(239394);
      return false;
    }
    
    public final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.v paramv, Bundle paramBundle)
    {
      AppMethodBeat.i(19683);
      if (paramString.equals("weixin://setting/bindphone"))
      {
        paramString = new Intent(URISpanHandlerSet.a(URISpanHandlerSet.this), BindMContactIntroUI.class);
        if ((URISpanHandlerSet.a(URISpanHandlerSet.this) instanceof Service)) {
          paramString.addFlags(268435456);
        }
        MMWizardActivity.aQ(URISpanHandlerSet.a(URISpanHandlerSet.this), paramString);
        AppMethodBeat.o(19683);
        return true;
      }
      AppMethodBeat.o(19683);
      return false;
    }
    
    public final int[] aDQ()
    {
      return new int[] { 5 };
    }
    
    public final u iJ(String paramString)
    {
      AppMethodBeat.i(19681);
      if (paramString.trim().startsWith("weixin://setting/bindphone"))
      {
        paramString = new u(paramString, 5, null);
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
    BizMsgMenuUriSpanHandler() {}
    
    public final boolean a(View paramView, u paramu, m paramm)
    {
      AppMethodBeat.i(239390);
      if (43 == paramu.type)
      {
        if (Util.isNullOrNil(paramu.username))
        {
          Log.w("MicroMsg.URISpanHandlerSet", "BizMsgMenuUriSpanHandler Username is null.");
          AppMethodBeat.o(239390);
          return true;
        }
        if ((paramu.fromScene == 1) && (paramu.hTm != null)) {
          com.tencent.mm.an.l.ad(paramu.hTm);
        }
        Log.d("MicroMsg.URISpanHandlerSet", "BizMsgMenuUriSpanHandler, url:%s", new Object[] { paramu.url });
        paramm = Uri.parse(paramu.url.trim());
        paramView = paramm.getQueryParameter("msgmenuid");
        paramm = paramm.getQueryParameter("msgmenucontent");
        com.tencent.mm.plugin.report.service.h.OAn.b(14522, new Object[] { Util.nullAsNil(paramView), paramu.username });
        if ((Util.isNullOrNil(paramView)) || (Util.isNullOrNil(paramm)))
        {
          Log.w("MicroMsg.URISpanHandlerSet", "BizMsgMenuUriSpanHandler id or msgContent is null.");
          AppMethodBeat.o(239390);
          return true;
        }
        try
        {
          String str = URLDecoder.decode(paramm, "UTF-8");
          paramm = new HashMap();
          paramm.put("bizmsgmenuid", paramView);
          paramView = com.tencent.mm.modelmulti.t.OH(paramu.username);
          paramView.toUser = paramu.username;
          paramView.content = str;
          paramView = paramView.wF(com.tencent.mm.model.ab.IX(paramu.username));
          paramView.eQp = 1;
          paramView.oNi = paramm;
          paramView.oNj = 5;
          paramView.bKW().aXz();
          AppMethodBeat.o(239390);
          return true;
        }
        catch (UnsupportedEncodingException paramView)
        {
          for (;;)
          {
            Log.w("MicroMsg.URISpanHandlerSet", "BizMsgMenuUriSpanHandler exp, msg = %s", new Object[] { paramView.getMessage() });
          }
        }
      }
      AppMethodBeat.o(239390);
      return false;
    }
    
    public final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.v paramv, Bundle paramBundle)
    {
      return false;
    }
    
    public final int[] aDQ()
    {
      return new int[] { 43 };
    }
    
    public final u iJ(String paramString)
    {
      AppMethodBeat.i(19684);
      if (paramString.trim().startsWith("weixin://bizmsgmenu"))
      {
        paramString = new u(paramString, 43, null);
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
    CardUriSpanHandler() {}
    
    public final boolean a(View paramView, u paramu, m paramm)
    {
      return false;
    }
    
    public final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.v paramv, Bundle paramBundle)
    {
      AppMethodBeat.i(19686);
      if (paramString.startsWith("wxcard://cardjumptype=1"))
      {
        paramString = null;
        if (paramv != null) {
          paramString = paramv.iGK().toString();
        }
        paramv = new Intent();
        paramv.putExtra("user_name", paramString);
        paramv.putExtra("view_type", 1);
        com.tencent.mm.br.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "card", ".ui.CardViewUI", paramv);
        AppMethodBeat.o(19686);
        return true;
      }
      AppMethodBeat.o(19686);
      return false;
    }
    
    public final int[] aDQ()
    {
      return new int[0];
    }
    
    public final u iJ(String paramString)
    {
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class ContactUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    ContactUriSpanHandler() {}
    
    public final boolean a(View paramView, u paramu, m paramm)
    {
      AppMethodBeat.i(239336);
      int i = paramu.type;
      if ((i == 23) || (i == 21) || (i == 22) || (i == 2))
      {
        paramView = (com.tencent.mm.model.ah)paramu.cf(com.tencent.mm.model.ah.class);
        if (paramm != null) {
          paramm.a(paramu);
        }
        if (paramView == null)
        {
          k.c(URISpanHandlerSet.a(URISpanHandlerSet.this), URISpanHandlerSet.a(URISpanHandlerSet.this).getString(R.l.gMF), URISpanHandlerSet.a(URISpanHandlerSet.this).getString(R.l.app_tip), true);
          AppMethodBeat.o(239336);
          return false;
        }
        if (paramView.getType().equals("@t.qq.com"))
        {
          if (((n)com.tencent.mm.kernel.h.ax(n.class)).bzJ().aMh("@t.qq.com") == null) {
            break label436;
          }
          i = 1;
          if (i == 0) {
            k.c(URISpanHandlerSet.a(URISpanHandlerSet.this), URISpanHandlerSet.a(URISpanHandlerSet.this).getString(R.l.gMF), URISpanHandlerSet.a(URISpanHandlerSet.this).getString(R.l.app_tip), true);
          }
        }
        Object localObject;
        if (paramView.getType().equals("@domain.android"))
        {
          localObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzJ().gbs();
          if ((localObject != null) && (((List)localObject).size() > 0)) {
            break label442;
          }
          i = 0;
        }
        for (;;)
        {
          if (i == 0) {
            k.c(URISpanHandlerSet.a(URISpanHandlerSet.this), URISpanHandlerSet.a(URISpanHandlerSet.this).getString(R.l.gMF), URISpanHandlerSet.a(URISpanHandlerSet.this).getString(R.l.app_tip), true);
          }
          localObject = new Intent();
          ((Intent)localObject).setClass(URISpanHandlerSet.a(URISpanHandlerSet.this), SelectContactUI.class);
          ((Intent)localObject).putExtra("Contact_GroupFilter_Type", paramView.getType()).putExtra("Contact_GroupFilter_Str", paramView.bCf()).putExtra("Contact_GroupFilter_DisplayName", paramView.aSU());
          ((Intent)localObject).addFlags(268435456);
          paramView = URISpanHandlerSet.a(URISpanHandlerSet.this);
          localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/app/plugin/URISpanHandlerSet$ContactUriSpanHandler", "handleSpanClick", "(Landroid/view/View;Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/app/plugin/URISpanHandlerSet$ContactUriSpanHandler", "handleSpanClick", "(Landroid/view/View;Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          if (paramm != null) {
            paramm.b(paramu);
          }
          AppMethodBeat.o(239336);
          return true;
          label436:
          i = 0;
          break;
          label442:
          i = 0;
          for (;;)
          {
            if (i >= ((List)localObject).size()) {
              break label490;
            }
            if (((cm)((List)localObject).get(i)).isEnable())
            {
              i = 1;
              break;
            }
            i += 1;
          }
          label490:
          i = 0;
        }
      }
      AppMethodBeat.o(239336);
      return false;
    }
    
    public final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.v paramv, Bundle paramBundle)
    {
      AppMethodBeat.i(19689);
      if ((paramString.equals("weixin://contacts/microblog/")) || (paramString.equals("weixin://contacts/micromessenger/")) || (paramString.equals("weixin://contacts/all/")))
      {
        paramv = ai.Jt(URISpanHandlerSet.a(URISpanHandlerSet.this).getString(R.l.gJp));
        if (paramString.equals("weixin://contacts/microblog/")) {
          paramv = ai.Jt(URISpanHandlerSet.a(URISpanHandlerSet.this).getString(R.l.gJo));
        }
        if (paramString.equals("weixin://contacts/micromessenger/")) {
          paramv = ai.Jt(URISpanHandlerSet.a(URISpanHandlerSet.this).getString(R.l.gJp));
        }
        if (paramString.equals("weixin://contacts/all/")) {
          paramv = ai.Jt(URISpanHandlerSet.a(URISpanHandlerSet.this).getString(R.l.gJe));
        }
        paramString = new Intent();
        paramString.setClass(URISpanHandlerSet.a(URISpanHandlerSet.this), SelectContactUI.class);
        paramString.putExtra("Contact_GroupFilter_Type", paramv.getType()).putExtra("Contact_GroupFilter_Str", paramv.bCf()).putExtra("Contact_GroupFilter_DisplayName", paramv.aSU());
        paramString.addFlags(268435456);
        AppMethodBeat.o(19689);
        return true;
      }
      AppMethodBeat.o(19689);
      return false;
    }
    
    public final int[] aDQ()
    {
      return new int[] { 23, 21, 22, 2 };
    }
    
    public final u iJ(String paramString)
    {
      Object localObject = null;
      AppMethodBeat.i(19687);
      if (paramString.trim().equals("weixin://contacts/all/")) {
        localObject = new u(paramString, 23, new com.tencent.mm.model.ah("@all.android", null, URISpanHandlerSet.a(URISpanHandlerSet.this).getString(R.l.gJe), null, true, true));
      }
      for (;;)
      {
        AppMethodBeat.o(19687);
        return localObject;
        if (paramString.trim().equals("weixin://contacts/microblog/"))
        {
          localObject = new u(paramString, 22, ai.Jt(URISpanHandlerSet.a(URISpanHandlerSet.this).getString(R.l.gJo)));
        }
        else if (paramString.trim().equals("weixin://contacts/micromessenger/"))
        {
          localObject = new u(paramString, 2, new com.tencent.mm.model.ah("@micromsg.qq.com", null, URISpanHandlerSet.a(URISpanHandlerSet.this).getString(R.l.gJp), null, true, true));
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
          localObject = new u(paramString, 21, ai.bb("@".concat(String.valueOf(((String)localObject).substring(i + 1))), URISpanHandlerSet.a(URISpanHandlerSet.this).getString(R.l.gJf)));
        }
      }
    }
  }
  
  @URISpanHandlerSet.a
  class EmotionStoreUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    EmotionStoreUriSpanHandler() {}
    
    public final boolean a(View paramView, u paramu, m paramm)
    {
      AppMethodBeat.i(239382);
      if (paramu.type == 29)
      {
        if (paramm != null) {
          paramm.a(paramu);
        }
        paramView = new Intent();
        paramView.putExtra("download_entrance_scene", 21);
        paramView.putExtra("extra_id", (String)paramu.cf(String.class));
        paramView.putExtra("preceding_scence", 3);
        com.tencent.mm.br.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "emoji", ".ui.EmojiStoreDetailUI", paramView);
        if (paramm != null) {
          paramm.b(paramu);
        }
        AppMethodBeat.o(239382);
        return true;
      }
      AppMethodBeat.o(239382);
      return false;
    }
    
    public final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.v paramv, Bundle paramBundle)
    {
      return false;
    }
    
    public final int[] aDQ()
    {
      return new int[] { 29 };
    }
    
    public final u iJ(String paramString)
    {
      AppMethodBeat.i(19697);
      if (paramString.trim().startsWith("weixin://emoticonstore/"))
      {
        int i = paramString.lastIndexOf("/");
        String str = "";
        if (i != -1) {
          str = paramString.substring(i + 1);
        }
        paramString = new u(paramString, 29, str);
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
    EnterChatRoomUriSpanHandler() {}
    
    public final boolean a(View paramView, u paramu, m paramm)
    {
      AppMethodBeat.i(239403);
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
            if (au.bwE(paramView))
            {
              bh.bCz();
              paramm = com.tencent.mm.model.c.bzA().JE(paramView);
              if ((paramm == null) || ((int)paramm.maN == 0))
              {
                paramm = new au();
                paramm.setUsername(paramView);
                bh.bCz();
                com.tencent.mm.model.c.bzA().aB(paramm);
              }
            }
            Object localObject = new Intent(URISpanHandlerSet.a(URISpanHandlerSet.this), ChattingUI.class).putExtra("Chat_User", paramView).putExtra("Chat_Mode", 1);
            if ((URISpanHandlerSet.a(URISpanHandlerSet.this) instanceof Service)) {
              ((Intent)localObject).addFlags(268435456);
            }
            paramm = URISpanHandlerSet.a(URISpanHandlerSet.this);
            localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramm, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/app/plugin/URISpanHandlerSet$EnterChatRoomUriSpanHandler", "handleSpanClick", "(Landroid/view/View;Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramm.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramm, "com/tencent/mm/app/plugin/URISpanHandlerSet$EnterChatRoomUriSpanHandler", "handleSpanClick", "(Landroid/view/View;Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            if (paramu.kLv == 1)
            {
              paramm = Util.nullAs(paramu.chatroomName, "");
              com.tencent.mm.chatroom.c.b.i(Util.nullAs(paramView, ""), paramm, 3);
              Log.i("MicroMsg.URISpanHandlerSet", "handleClickEnterChatRoomSystemMsgUrl migrate(%s -> %s)", new Object[] { paramm, Util.nullAs(paramView, "") });
            }
            AppMethodBeat.o(239403);
            return true;
          }
        }
        catch (Exception paramView)
        {
          Log.e("MicroMsg.URISpanHandlerSet", "handle click link error: %s, url: %s", new Object[] { paramView.getMessage(), paramu.url });
        }
      }
      AppMethodBeat.o(239403);
      return false;
    }
    
    public final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.v paramv, Bundle paramBundle)
    {
      return false;
    }
    
    public final int[] aDQ()
    {
      return new int[] { 55 };
    }
    
    public final u iJ(String paramString)
    {
      AppMethodBeat.i(239395);
      if (paramString.trim().toLowerCase().startsWith("weixin://jump/chatroom/"))
      {
        paramString = new u(paramString, 55, null);
        AppMethodBeat.o(239395);
        return paramString;
      }
      AppMethodBeat.o(239395);
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class EnterRoomUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    EnterRoomUriSpanHandler() {}
    
    public final boolean a(View paramView, u paramu, m paramm)
    {
      return false;
    }
    
    public final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.v paramv, Bundle paramBundle)
    {
      AppMethodBeat.i(19699);
      if (paramString.startsWith("weixin://jump/mainframe/"))
      {
        int i = paramString.trim().lastIndexOf("/");
        if ((i >= 0) && (i < paramString.trim().length() - 1))
        {
          paramString = paramString.trim().substring(i + 1);
          if (au.bwE(paramString))
          {
            bh.bCz();
            paramv = com.tencent.mm.model.c.bzA().JE(paramString);
            if ((paramv == null) || ((int)paramv.maN == 0))
            {
              paramv = new au();
              paramv.setUsername(paramString);
              bh.bCz();
              com.tencent.mm.model.c.bzA().aB(paramv);
            }
          }
          paramv = new Intent(URISpanHandlerSet.a(URISpanHandlerSet.this), ChattingUI.class).putExtra("Chat_User", paramString).putExtra("Chat_Mode", 1);
          if ((URISpanHandlerSet.a(URISpanHandlerSet.this) instanceof Service)) {
            paramv.addFlags(268435456);
          }
          paramString = URISpanHandlerSet.a(URISpanHandlerSet.this);
          paramv = new com.tencent.mm.hellhoundlib.b.a().cG(paramv);
          com.tencent.mm.hellhoundlib.a.a.b(paramString, paramv.aYi(), "com/tencent/mm/app/plugin/URISpanHandlerSet$EnterRoomUriSpanHandler", "handleUriJump", "(Ljava/lang/String;ZLcom/tencent/mm/pluginsdk/UriJumpCallback;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramString.startActivity((Intent)paramv.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/app/plugin/URISpanHandlerSet$EnterRoomUriSpanHandler", "handleUriJump", "(Ljava/lang/String;ZLcom/tencent/mm/pluginsdk/UriJumpCallback;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(19699);
          return true;
        }
      }
      AppMethodBeat.o(19699);
      return false;
    }
    
    public final int[] aDQ()
    {
      return new int[0];
    }
    
    public final u iJ(String paramString)
    {
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class ExposeUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    ExposeUriSpanHandler() {}
    
    public final boolean a(View paramView, u paramu, m paramm)
    {
      AppMethodBeat.i(239396);
      if (paramu.type == 31)
      {
        paramView = new Intent();
        if (paramm == null)
        {
          AppMethodBeat.o(239396);
          return false;
        }
        paramu = (String)paramm.a(paramu);
        paramView.putExtra("k_username", paramu);
        if ((Util.isNullOrNil(paramu)) || (!paramu.endsWith("@chatroom"))) {
          break label134;
        }
      }
      label134:
      for (int i = 36;; i = 39)
      {
        paramView.putExtra("showShare", false);
        paramView.putExtra("rawUrl", String.format(f.f.adwf, new Object[] { Integer.valueOf(i) }));
        com.tencent.mm.br.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "webview", ".ui.tools.WebViewUI", paramView);
        AppMethodBeat.o(239396);
        return true;
        AppMethodBeat.o(239396);
        return false;
      }
    }
    
    public final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.v paramv, Bundle paramBundle)
    {
      return false;
    }
    
    public final int[] aDQ()
    {
      return new int[] { 31 };
    }
    
    public final u iJ(String paramString)
    {
      AppMethodBeat.i(19700);
      if (paramString.trim().toLowerCase().equals("weixin://expose/"))
      {
        paramString = new u(paramString, 31, null);
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
    FeedbackUriSpanHandler() {}
    
    public final boolean a(View paramView, u paramu, m paramm)
    {
      AppMethodBeat.i(239348);
      if (paramu.type == 34)
      {
        paramView = paramu.url.trim().replace("weixin://feedback/next/", "");
        Log.d("MicroMsg.URISpanHandlerSet", "FeedbackUriSpanHandler, url:%s, content:%s", new Object[] { paramu.url, paramView });
        bh.aZW().a(new com.tencent.mm.plugin.setting.model.o(q.aPl(), paramView, 8), 0);
        AppMethodBeat.o(239348);
        return true;
      }
      AppMethodBeat.o(239348);
      return false;
    }
    
    public final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.v paramv, Bundle paramBundle)
    {
      return false;
    }
    
    public final int[] aDQ()
    {
      return new int[] { 34 };
    }
    
    public final u iJ(String paramString)
    {
      AppMethodBeat.i(19702);
      if (paramString.trim().startsWith("weixin://feedback/next/"))
      {
        paramString = new u(paramString, 34, null);
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
    FlightNumberSpanHandler() {}
    
    public final boolean a(View paramView, u paramu, m paramm)
    {
      AppMethodBeat.i(239389);
      if (paramm != null) {
        paramm.a(paramu);
      }
      if (paramu.type == 50)
      {
        Log.i("MicroMsg.URISpanHandlerSet", "FlightNumberSpanHandler click %s", new Object[] { paramu.url });
        if ((paramu.cpt == null) || (!(paramu.cpt instanceof Bundle))) {
          break label120;
        }
      }
      label120:
      for (long l = ((Bundle)paramu.cpt).getLong("msgSvrId");; l = 0L)
      {
        ((com.tencent.mm.plugin.box.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.box.a.c.class)).b(URISpanHandlerSet.a(URISpanHandlerSet.this), paramu.url, l);
        if (paramm != null) {
          paramm.b(paramu);
        }
        AppMethodBeat.o(239389);
        return true;
      }
    }
    
    public final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.v paramv, Bundle paramBundle)
    {
      return false;
    }
    
    public final int[] aDQ()
    {
      return new int[] { 50 };
    }
    
    public final u iJ(String paramString)
    {
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class FlowStatUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    FlowStatUriSpanHandler() {}
    
    public final boolean a(View paramView, u paramu, m paramm)
    {
      AppMethodBeat.i(239405);
      if (paramu.type == 16)
      {
        if (paramm != null) {
          paramm.a(paramu);
        }
        paramView = LauncherUI.getInstance();
        if (paramView != null) {
          paramView.adBG.getMainTabUI().bzP("tab_settings");
        }
        if (paramm != null) {
          paramm.b(paramu);
        }
        AppMethodBeat.o(239405);
        return true;
      }
      AppMethodBeat.o(239405);
      return false;
    }
    
    public final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.v paramv, Bundle paramBundle)
    {
      AppMethodBeat.i(19707);
      if (paramString.equals("weixin://flowstat"))
      {
        paramString = LauncherUI.getInstance();
        if (paramString != null) {
          paramString.adBG.getMainTabUI().bzP("tab_settings");
        }
        AppMethodBeat.o(19707);
        return true;
      }
      AppMethodBeat.o(19707);
      return false;
    }
    
    public final int[] aDQ()
    {
      return new int[] { 16 };
    }
    
    public final u iJ(String paramString)
    {
      AppMethodBeat.i(19705);
      if (paramString.trim().startsWith("weixin://flowstat"))
      {
        paramString = new u(paramString, 16, null);
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
    FriendMobileUriSpanHandler() {}
    
    public final boolean a(View paramView, u paramu, m paramm)
    {
      AppMethodBeat.i(239422);
      if (paramu.type == 20)
      {
        if (paramm != null) {
          paramm.a(paramu);
        }
        Object localObject = new Intent(URISpanHandlerSet.a(URISpanHandlerSet.this), MobileFriendUI.class);
        paramView = URISpanHandlerSet.a(URISpanHandlerSet.this);
        localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/app/plugin/URISpanHandlerSet$FriendMobileUriSpanHandler", "handleSpanClick", "(Landroid/view/View;Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/app/plugin/URISpanHandlerSet$FriendMobileUriSpanHandler", "handleSpanClick", "(Landroid/view/View;Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        if (paramm != null) {
          paramm.b(paramu);
        }
        AppMethodBeat.o(239422);
        return true;
      }
      AppMethodBeat.o(239422);
      return false;
    }
    
    public final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.v paramv, Bundle paramBundle)
    {
      AppMethodBeat.i(19710);
      if (paramString.equals("weixin://findfriend/mobile"))
      {
        paramv = new Intent(URISpanHandlerSet.a(URISpanHandlerSet.this), MobileFriendUI.class);
        if ((URISpanHandlerSet.a(URISpanHandlerSet.this) instanceof Service)) {
          paramv.addFlags(268435456);
        }
        paramString = URISpanHandlerSet.a(URISpanHandlerSet.this);
        paramv = new com.tencent.mm.hellhoundlib.b.a().cG(paramv);
        com.tencent.mm.hellhoundlib.a.a.b(paramString, paramv.aYi(), "com/tencent/mm/app/plugin/URISpanHandlerSet$FriendMobileUriSpanHandler", "handleUriJump", "(Ljava/lang/String;ZLcom/tencent/mm/pluginsdk/UriJumpCallback;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)paramv.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/app/plugin/URISpanHandlerSet$FriendMobileUriSpanHandler", "handleUriJump", "(Ljava/lang/String;ZLcom/tencent/mm/pluginsdk/UriJumpCallback;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(19710);
        return true;
      }
      AppMethodBeat.o(19710);
      return false;
    }
    
    public final int[] aDQ()
    {
      return new int[] { 20 };
    }
    
    public final u iJ(String paramString)
    {
      AppMethodBeat.i(19708);
      if (paramString.trim().startsWith("weixin://findfriend/mobile"))
      {
        paramString = new u(paramString, 20, null);
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
    FriendSearchUriSpanHandler() {}
    
    public final boolean a(View paramView, u paramu, m paramm)
    {
      AppMethodBeat.i(239397);
      if (paramu.type == 17)
      {
        if (paramm != null) {
          paramm.a(paramu);
        }
        com.tencent.mm.br.c.ai(URISpanHandlerSet.a(URISpanHandlerSet.this), "subapp", ".ui.pluginapp.ContactSearchUI");
        if (paramm != null) {
          paramm.b(paramu);
        }
        AppMethodBeat.o(239397);
        return true;
      }
      AppMethodBeat.o(239397);
      return false;
    }
    
    public final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.v paramv, Bundle paramBundle)
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
    
    public final int[] aDQ()
    {
      return new int[] { 17 };
    }
    
    public final u iJ(String paramString)
    {
      AppMethodBeat.i(19711);
      if (paramString.trim().startsWith("weixin://findfriend/search"))
      {
        paramString = new u(paramString, 17, null);
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
    FriendShareUriSpanHandler() {}
    
    public final boolean a(View paramView, u paramu, m paramm)
    {
      AppMethodBeat.i(239378);
      if (paramu.type == 18)
      {
        if (paramm != null) {
          paramm.a(paramu);
        }
        com.tencent.mm.br.c.ai(URISpanHandlerSet.a(URISpanHandlerSet.this), "setting", ".ui.qrcode.ShareMicroMsgChoiceUI");
        if (paramm != null) {
          paramm.b(paramu);
        }
        AppMethodBeat.o(239378);
        return true;
      }
      AppMethodBeat.o(239378);
      return false;
    }
    
    public final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.v paramv, Bundle paramBundle)
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
    
    public final int[] aDQ()
    {
      return new int[] { 18 };
    }
    
    public final u iJ(String paramString)
    {
      AppMethodBeat.i(19714);
      if (paramString.trim().startsWith("weixin://findfriend/share"))
      {
        paramString = new u(paramString, 18, null);
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
    HoneyPayLinkSpanHandler() {}
    
    public final boolean a(View paramView, u paramu, m paramm)
    {
      AppMethodBeat.i(239383);
      if (paramu.type == 46)
      {
        Log.i("MicroMsg.URISpanHandlerSet", "go to honey pay proxy");
        if ((paramu.cpt != null) && ((paramu.cpt instanceof Bundle)))
        {
          paramm = Uri.parse(paramu.url);
          paramView = paramm.getQueryParameter("cardNo");
          boolean bool = paramm.getQueryParameter("isPayer").equals("1");
          paramm = paramm.getQueryParameter("paymsgid");
          if (!Util.isNullOrNil(paramm)) {
            break label127;
          }
          paramu = new Intent();
          paramu.putExtra("key_card_no", paramView);
          paramu.putExtra("key_is_payer", bool);
          com.tencent.mm.br.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "honey_pay", ".ui.HoneyPayProxyUI", paramu);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(239383);
        return false;
        label127:
        paramView = new com.tencent.mm.plugin.honey_pay.model.a();
        paramView.field_payMsgId = paramm;
        com.tencent.mm.plugin.honey_pay.a.fPu().fPv().get(paramView, new String[0]);
        Log.i("MicroMsg.URISpanHandlerSet", "handleSpanClick: %s,find msg: %s", new Object[] { paramu.url, Long.valueOf(paramView.field_msgId) });
        if (paramView.field_msgId > 0L)
        {
          paramu = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(paramView.field_msgId);
          if (paramu.field_msgId <= 0L)
          {
            Log.i("MicroMsg.URISpanHandlerSet", "cannot find msg in msg storage!");
            new g.a(MMApplicationContext.getContext()).bDE(MMApplicationContext.getContext().getString(R.l.remittance_find_from_jsapi_failed_delete)).aEY(MMApplicationContext.getContext().getResources().getColor(R.e.link_color)).aEX(R.l.i_know_it).b(new g.c()
            {
              public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString) {}
            }).show();
          }
          else
          {
            paramm = new wk();
            paramm.hZY.msgId = paramView.field_msgId;
            paramm.hZY.hgk = paramu.field_talker;
            paramm.publish();
          }
        }
        else
        {
          Log.i("MicroMsg.URISpanHandlerSet", "handle MSpanConstants.Type.TYPE_HONEY_PAY_CARD_MANAGER, cannot find local msg");
          new g.a(MMApplicationContext.getContext()).bDE(MMApplicationContext.getContext().getString(R.l.remittance_find_from_jsapi_failed_delete)).aEY(MMApplicationContext.getContext().getResources().getColor(R.e.link_color)).aEX(R.l.i_know_it).b(new g.c()
          {
            public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString) {}
          }).show();
          continue;
          if (paramu.type == 47)
          {
            Log.i("MicroMsg.URISpanHandlerSet", "go to bank card list");
            paramView = new Intent();
            paramView.putExtra("intent_finish_self", true);
            com.tencent.mm.br.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "wallet", ".bind.ui.WalletBankcardManageUI", paramView);
            com.tencent.mm.plugin.report.service.h.OAn.b(15191, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
          }
        }
      }
    }
    
    public final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.v paramv, Bundle paramBundle)
    {
      return false;
    }
    
    public final int[] aDQ()
    {
      return new int[] { 46, 47 };
    }
    
    public final u iJ(String paramString)
    {
      AppMethodBeat.i(19717);
      if (paramString.trim().startsWith("native://wcpay/honeypay"))
      {
        paramString = new u(paramString, 46, null);
        AppMethodBeat.o(19717);
        return paramString;
      }
      if (paramString.trim().startsWith("weixin://wcpay/bankCardList"))
      {
        paramString = new u(paramString, 47, null);
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
    private final String hkX;
    
    HttpUriSpanHandler()
    {
      AppMethodBeat.i(239360);
      this.hkX = ("https://" + WeChatHosts.domainString(R.l.host_mp_weixin_qq_com) + "/mp/newsubscribemsg?action=subscribepage");
      AppMethodBeat.o(239360);
    }
    
    public final boolean a(View paramView, u paramu, m paramm)
    {
      AppMethodBeat.i(239369);
      Object localObject2;
      Object localObject3;
      Object localObject4;
      int i;
      label210:
      int m;
      if (paramu.type == 1)
      {
        if ((paramu != null) && (paramu.url.trim().startsWith(this.hkX)))
        {
          Log.i("MicroMsg.URISpanHandlerSet", "alvinluo processHttpLink subscribeMsgLink onClick url: %s", new Object[] { paramu.url });
          if (paramm != null)
          {
            if (!Util.isNullOrNil(paramu.AWk)) {
              break label210;
            }
            localObject1 = paramu.username;
            if (!com.tencent.mm.an.g.Mw((String)localObject1)) {
              break label210;
            }
            localObject2 = paramu.url;
            paramView = null;
            if ((paramu.extraData instanceof String)) {
              paramView = (String)paramu.extraData;
            }
            if ((localObject1 != null) && (localObject2 != null))
            {
              Log.i("MicroMsg.URISpanHandlerSet", "alvinluo clickSubscribeMsgSpan bizUsername: %s, url: %s, content: %s", new Object[] { localObject1, localObject2, paramView });
              localObject3 = com.tencent.mm.msgsubscription.api.b.piw;
              localObject3 = com.tencent.mm.msgsubscription.api.b.QW("name_biz");
              localObject4 = new Bundle();
              ((Bundle)localObject4).putString("key_extra_content", paramView);
              if (localObject3 != null) {
                ((ISubscribeMsgService)localObject3).a(URISpanHandlerSet.a(URISpanHandlerSet.this), (String)localObject1, (String)localObject2, (Bundle)localObject4);
              }
            }
          }
        }
        for (i = 1; i != 0; i = 0)
        {
          AppMethodBeat.o(239369);
          return true;
        }
        if ((URISpanHandlerSet.a(URISpanHandlerSet.this) != null) && ((URISpanHandlerSet.a(URISpanHandlerSet.this) instanceof WebViewUI)))
        {
          m = 1;
          paramu.cf(com.tencent.mm.model.ah.class);
          if ((URISpanHandlerSet.a(URISpanHandlerSet.this) == null) || ((m != 0) && (!MMApplicationContext.isMMProcess()))) {
            break label1286;
          }
        }
      }
      label674:
      label709:
      label1105:
      for (Object localObject1 = ai.bb("@" + paramu.url, URISpanHandlerSet.a(URISpanHandlerSet.this).getString(R.l.gJf));; localObject1 = null)
      {
        if (paramm != null) {}
        label471:
        label1117:
        label1246:
        for (paramView = (String)paramm.a(paramu);; paramView = null)
        {
          if ((paramu.fromScene == 1) && (paramu.hTm != null)) {
            com.tencent.mm.an.l.ad(paramu.hTm);
          }
          Object localObject5;
          if ((localObject1 == null) || (!((com.tencent.mm.model.ah)localObject1).enable))
          {
            localObject5 = paramu.url;
            if (((String)localObject5).toLowerCase().startsWith("http")) {
              break label1278;
            }
            localObject5 = "http://".concat(String.valueOf(localObject5));
          }
          label487:
          label1271:
          label1278:
          for (;;)
          {
            Intent localIntent = new Intent();
            localObject2 = "";
            localObject4 = "";
            localObject3 = localObject2;
            localObject1 = localObject4;
            Bundle localBundle;
            if (paramu.cpt != null)
            {
              localObject3 = localObject2;
              localObject1 = localObject4;
              if ((paramu.cpt instanceof Bundle))
              {
                localBundle = (Bundle)paramu.cpt;
                long l = localBundle.getLong("msgSvrId", 0L);
                if (l == 0L) {
                  break label1105;
                }
                localObject2 = String.valueOf(l);
                if (!Util.isNullOrNil(paramu.AWk)) {
                  break label1117;
                }
                localObject4 = paramu.username;
                localObject3 = localObject2;
                localObject1 = localObject4;
                if (Util.isNullOrNil((String)localObject4))
                {
                  localObject1 = localBundle.getString("msgUsername");
                  localObject3 = localObject2;
                }
              }
            }
            localObject2 = localObject3;
            if (Util.isNullOrNil((String)localObject3)) {
              localObject2 = paramu.YcV;
            }
            localIntent.putExtra("serverMsgID", (String)localObject2);
            localIntent.putExtra("msgUsername", (String)localObject1);
            localIntent.putExtra("rawUrl", (String)localObject5);
            i = 0;
            localObject2 = "";
            int j = i;
            localObject1 = localObject2;
            if (paramu.cpt != null)
            {
              j = i;
              localObject1 = localObject2;
              if ((paramu.cpt instanceof Bundle))
              {
                j = ((Bundle)paramu.cpt).getInt("geta8key_scene");
                localObject1 = ((Bundle)paramu.cpt).getString("geta8key_username");
                localIntent.putExtra("geta8key_scene", j);
              }
            }
            int k = 0;
            int i1 = 0;
            int n = j;
            if (j == 0)
            {
              if (paramu.fromScene == 2)
              {
                i = 2;
                k = paramu.YcU;
                localIntent.putExtra("geta8key_scene", i);
                n = i;
              }
            }
            else
            {
              if (k != 0) {
                break label1271;
              }
              if (paramu.hTm == null) {
                break label1246;
              }
              j = paramu.hTm.getType();
              i = j;
              if (j == 0)
              {
                i = j;
                if (paramu.cpt != null)
                {
                  i = j;
                  if ((paramu.cpt instanceof Bundle)) {
                    i = ((Bundle)paramu.cpt).getInt("KMsgType");
                  }
                }
              }
              j = i;
              if (i == 16777265)
              {
                j = 49;
                localIntent.putExtra("KAppMsgType", 1);
              }
            }
            for (;;)
            {
              localIntent.putExtra("KMsgType", j);
              localObject2 = paramu.mSessionId;
              if (!Util.isNullOrNil((String)localObject2))
              {
                localObject5 = ad.bCb().Jm((String)localObject2);
                if (localObject5 != null)
                {
                  localObject3 = ((ad.b)localObject5).getString("prePublishId", null);
                  localObject4 = ((ad.b)localObject5).getString("preUsername", null);
                  localObject5 = ((ad.b)localObject5).getString("preChatName", null);
                  localIntent.putExtra("reportSessionId", (String)localObject2);
                  localIntent.putExtra("KPublisherId", (String)localObject3);
                  localIntent.putExtra("geta8key_username", (String)localObject5);
                  localIntent.putExtra("pre_username", (String)localObject4);
                  localIntent.putExtra("prePublishId", (String)localObject3);
                  localIntent.putExtra("preUsername", (String)localObject4);
                  localIntent.putExtra("preChatName", (String)localObject5);
                  localIntent.putExtra("preChatTYPE", com.tencent.mm.model.ac.aX((String)localObject4, (String)localObject5));
                }
              }
              if (Util.isNullOrNil(localIntent.getStringExtra("geta8key_username")))
              {
                if (!Util.isNullOrNil((String)localObject1)) {
                  paramView = (View)localObject1;
                }
                localIntent.putExtra("geta8key_username", paramView);
              }
              if ((paramu.fromScene == 1) || (paramu.fromScene == 2) || (paramu.fromScene == 3) || (paramu.fromScene == 4) || (paramu.fromScene == 6) || (paramu.fromScene == 5) || (n == 31)) {
                localIntent.putExtra("key_enable_teen_mode_check", true);
              }
              if (m != 0) {
                localIntent.addFlags(268435456);
              }
              for (;;)
              {
                com.tencent.mm.br.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "webview", ".ui.tools.WebViewUI", localIntent);
                if (paramm != null) {
                  paramm.b(paramu);
                }
                AppMethodBeat.o(239369);
                return true;
                m = 0;
                break;
                localObject2 = localBundle.getString("serverMsgID");
                break label471;
                localObject4 = paramu.AWk;
                break label487;
                if (paramu.fromScene == 5)
                {
                  i = 2;
                  k = paramu.YcU;
                  break label674;
                }
                if (paramu.fromScene == 3)
                {
                  i = 14;
                  k = i1;
                  break label674;
                }
                if (paramu.fromScene == 4)
                {
                  i = 71;
                  k = i1;
                  break label674;
                }
                if (paramu.fromScene == 6)
                {
                  i = 72;
                  k = i1;
                  break label674;
                }
                i = j;
                k = i1;
                if (paramu.fromScene != 1) {
                  break label674;
                }
                i = j;
                k = i1;
                if (!com.tencent.mm.model.ab.IS(paramView)) {
                  break label674;
                }
                i = 15;
                k = i1;
                break label674;
                j = 0;
                break label709;
                localIntent.addFlags(536870912);
              }
              AppMethodBeat.o(239369);
              return false;
              j = k;
            }
          }
        }
      }
    }
    
    public final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.v paramv, Bundle paramBundle)
    {
      return false;
    }
    
    public final int[] aDQ()
    {
      return new int[] { 1 };
    }
    
    public final u iJ(String paramString)
    {
      AppMethodBeat.i(19719);
      if (paramString.trim().toLowerCase().startsWith("http")) {}
      for (paramString = new u(paramString, 1, null);; paramString = null)
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
    JumpActivityUriSpanHandler() {}
    
    public final boolean a(View paramView, u paramu, m paramm)
    {
      return false;
    }
    
    public final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.v paramv, Bundle paramBundle)
    {
      AppMethodBeat.i(19721);
      if (paramString.toLowerCase().startsWith("weixin://jump/"))
      {
        paramString = paramString.split("/");
        paramString = paramString[(paramString.length - 1)];
        if ("mainframe".equalsIgnoreCase(paramString))
        {
          paramv = new Intent(URISpanHandlerSet.a(URISpanHandlerSet.this), LauncherUI.class);
          if ((URISpanHandlerSet.a(URISpanHandlerSet.this) instanceof Service)) {
            paramv.addFlags(268435456);
          }
          paramv.addFlags(67108864);
          paramString = URISpanHandlerSet.a(URISpanHandlerSet.this);
          paramv = new com.tencent.mm.hellhoundlib.b.a().cG(paramv);
          com.tencent.mm.hellhoundlib.a.a.b(paramString, paramv.aYi(), "com/tencent/mm/app/plugin/URISpanHandlerSet$JumpActivityUriSpanHandler", "handleUriJump", "(Ljava/lang/String;ZLcom/tencent/mm/pluginsdk/UriJumpCallback;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramString.startActivity((Intent)paramv.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/app/plugin/URISpanHandlerSet$JumpActivityUriSpanHandler", "handleUriJump", "(Ljava/lang/String;ZLcom/tencent/mm/pluginsdk/UriJumpCallback;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        for (;;)
        {
          AppMethodBeat.o(19721);
          return true;
          if ("shake".equalsIgnoreCase(paramString))
          {
            com.tencent.mm.plugin.report.service.h.OAn.kvStat(10221, "1");
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
    
    public final int[] aDQ()
    {
      return new int[0];
    }
    
    public final u iJ(String paramString)
    {
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class JumpPatSettingDialogUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    JumpPatSettingDialogUriSpanHandler() {}
    
    public final boolean a(View paramView, u paramu, m paramm)
    {
      AppMethodBeat.i(239410);
      if (paramu.type == 61)
      {
        paramu = com.tencent.mm.plugin.secdata.ui.a.PlI;
        ((ebg)a.a.c(paramView.getContext(), 4, ebg.class)).abgO = 1;
        paramView = new com.tencent.mm.plugin.patmsg.ui.b(paramView.getContext());
        paramView.show();
        paramView.getWindow().setLayout(-1, -1);
      }
      AppMethodBeat.o(239410);
      return false;
    }
    
    public final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.v paramv, Bundle paramBundle)
    {
      return false;
    }
    
    public final int[] aDQ()
    {
      return new int[] { 61 };
    }
    
    public final u iJ(String paramString)
    {
      AppMethodBeat.i(239406);
      if (paramString.trim().toLowerCase().startsWith("weixin://jump/setpat_bottom_sheet/"))
      {
        paramString = new u(paramString, 61, null);
        AppMethodBeat.o(239406);
        return paramString;
      }
      AppMethodBeat.o(239406);
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class JumpPatSettingUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    JumpPatSettingUriSpanHandler() {}
    
    public final boolean a(View paramView, u paramu, m paramm)
    {
      AppMethodBeat.i(239363);
      if (paramu.type == 57)
      {
        Log.i("MicroMsg.URISpanHandlerSet", "handleClickJumpToPatSetting");
        paramu = new Intent();
        paramu.setClass(URISpanHandlerSet.a(URISpanHandlerSet.this), SettingsPersonalInfoUI.class);
        paramu.putExtra("jumptoPat", true);
        paramView = URISpanHandlerSet.a(URISpanHandlerSet.this);
        paramu = new com.tencent.mm.hellhoundlib.b.a().cG(paramu);
        com.tencent.mm.hellhoundlib.a.a.b(paramView, paramu.aYi(), "com/tencent/mm/app/plugin/URISpanHandlerSet$JumpPatSettingUriSpanHandler", "handleSpanClick", "(Landroid/view/View;Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramView.startActivity((Intent)paramu.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/app/plugin/URISpanHandlerSet$JumpPatSettingUriSpanHandler", "handleSpanClick", "(Landroid/view/View;Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      new MMHandler().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(239370);
          LauncherUI localLauncherUI = LauncherUI.getInstance();
          if (localLauncherUI != null)
          {
            localLauncherUI.closeChatting(false);
            localLauncherUI.adBG.getMainTabUI().bzP("tab_settings");
          }
          AppMethodBeat.o(239370);
        }
      }, 2000L);
      AppMethodBeat.o(239363);
      return false;
    }
    
    public final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.v paramv, Bundle paramBundle)
    {
      return false;
    }
    
    public final int[] aDQ()
    {
      return new int[] { 57 };
    }
    
    public final u iJ(String paramString)
    {
      AppMethodBeat.i(239357);
      if (paramString.trim().toLowerCase().startsWith("weixin://jump/setpat/"))
      {
        paramString = new u(paramString, 57, null);
        AppMethodBeat.o(239357);
        return paramString;
      }
      AppMethodBeat.o(239357);
      return null;
    }
  }
  
  @URISpanHandlerSet.a(aDR=URISpanHandlerSet.PRIORITY.HIGH)
  class LuckyMoneyUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    LuckyMoneyUriSpanHandler() {}
    
    public final boolean a(View paramView, u paramu, m paramm)
    {
      AppMethodBeat.i(239380);
      if (paramu.type == 33)
      {
        Log.i("MicroMsg.URISpanHandlerSet", "hrefInfo.getType() == MMSpanConstants.Type.TYPE_LUCKY_MONEY_NORMAL");
        if (paramm == null)
        {
          Log.i("MicroMsg.URISpanHandlerSet", "LuckyMoneyUriSpanHandler handleSpanClick() clickCallback == null");
          AppMethodBeat.o(239380);
          return false;
        }
        paramView = new Intent();
        paramView.putExtra("key_native_url", paramu.url);
        paramView.putExtra("key_username", (String)paramm.a(paramu));
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
          com.tencent.mm.plugin.report.service.h.OAn.b(12097, new Object[] { Integer.valueOf(11), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
          com.tencent.mm.plugin.report.service.h.OAn.b(11850, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
          AppMethodBeat.o(239380);
          return true;
          com.tencent.mm.br.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "luckymoney", ".ui.LuckyMoneyBeforeDetailUI", paramView);
        }
      }
      if (paramu.type == 59)
      {
        Log.i("MicroMsg.URISpanHandlerSet", "hrefInfo.getType() == MMSpanConstants.Type.TYPE_LUCKY_MONEY_UNION");
        if (paramm == null)
        {
          Log.i("MicroMsg.URISpanHandlerSet", "LuckyMoneyUriSpanHandler handleSpanClick() clickCallback == null");
          AppMethodBeat.o(239380);
          return false;
        }
        paramView = new Intent();
        paramView.putExtra("key_native_url", paramu.url);
        paramView.putExtra("key_username", (String)paramm.a(paramu));
        paramView.putExtra("key_lucky_money_can_received", true);
        paramView.putExtra("key_jump_from", 4);
        paramView.putExtra("scene_id", 1005);
        com.tencent.mm.br.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "luckymoney", ".ui.LuckyMoneyBeforeDetailUI", paramView);
        com.tencent.mm.plugin.report.service.h.OAn.b(12097, new Object[] { Integer.valueOf(11), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
        com.tencent.mm.plugin.report.service.h.OAn.b(11850, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
        AppMethodBeat.o(239380);
        return true;
      }
      AppMethodBeat.o(239380);
      return false;
    }
    
    public final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.v paramv, Bundle paramBundle)
    {
      return false;
    }
    
    public final int[] aDQ()
    {
      return new int[] { 33, 59 };
    }
    
    public final u iJ(String paramString)
    {
      AppMethodBeat.i(19722);
      if ((paramString.trim().toLowerCase().startsWith("weixin://weixinhongbao/")) || (paramString.trim().toLowerCase().startsWith("frhb://c2cbizmessagehandler/hongbao/receivehongbao")))
      {
        paramString = new u(paramString, 33, null);
        AppMethodBeat.o(19722);
        return paramString;
      }
      if (paramString.trim().toLowerCase().startsWith("weixin://weixinunionhongbao/"))
      {
        paramString = new u(paramString, 59, null);
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
    OfflineFQFSpanHandler() {}
    
    public final boolean a(View paramView, u paramu, m paramm)
    {
      AppMethodBeat.i(239392);
      if (paramu.type == 51)
      {
        Log.i("MicroMsg.URISpanHandlerSet", "go to offline fqf");
        if ((paramu.cpt != null) && ((paramu.cpt instanceof Bundle)))
        {
          Object localObject = (Bundle)paramu.cpt;
          paramView = ((Bundle)localObject).getString("repayment_tiny_app_username");
          localObject = ((Bundle)localObject).getString("repayment_tiny_app_path");
          zp localzp = new zp();
          localzp.icM.userName = paramView;
          localzp.icM.icO = Util.nullAs((String)localObject, "");
          localzp.icM.icP = 0;
          localzp.publish();
        }
        if (paramm != null) {
          paramm.b(paramu);
        }
      }
      AppMethodBeat.o(239392);
      return false;
    }
    
    public final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.v paramv, Bundle paramBundle)
    {
      return false;
    }
    
    public final int[] aDQ()
    {
      return new int[] { 51 };
    }
    
    public final u iJ(String paramString)
    {
      AppMethodBeat.i(169680);
      if (paramString.trim().startsWith("weixin://wcpay/fqf/opentinyapp"))
      {
        paramString = new u(paramString, 51, null);
        AppMethodBeat.o(169680);
        return paramString;
      }
      AppMethodBeat.o(169680);
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class OpenIMKefuMsgMenuUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    OpenIMKefuMsgMenuUriSpanHandler() {}
    
    public final boolean a(View paramView, u paramu, m paramm)
    {
      AppMethodBeat.i(239385);
      if (62 == paramu.type)
      {
        if (Util.isNullOrNil(paramu.username))
        {
          Log.w("MicroMsg.URISpanHandlerSet", "BizMsgMenuUriSpanHandler Username is null.");
          AppMethodBeat.o(239385);
          return true;
        }
        Log.d("MicroMsg.URISpanHandlerSet", "OpenIMKefuMsgMenuUriSpanHandler, url:%s", new Object[] { paramu.url });
        paramm = Uri.parse(paramu.url.trim());
        paramView = paramm.getQueryParameter("kefumenuid");
        paramm = paramm.getQueryParameter("kefumenucontent");
        if ((Util.isNullOrNil(paramView)) || (Util.isNullOrNil(paramm)))
        {
          Log.w("MicroMsg.URISpanHandlerSet", "OpenIMKefuMsgMenuUriSpanHandler id or msgContent is null.");
          AppMethodBeat.o(239385);
          return true;
        }
        try
        {
          String str = URLDecoder.decode(paramm, "UTF-8");
          paramm = new HashMap();
          paramm.put("kefumenuid", paramView);
          paramView = com.tencent.mm.modelmulti.t.OH(paramu.username);
          paramView.toUser = paramu.username;
          paramView.content = str;
          paramView = paramView.wF(com.tencent.mm.model.ab.IX(paramu.username));
          paramView.eQp = 1;
          paramView.oNi = paramm;
          paramView.oNj = 5;
          paramView.bKW().aXz();
          AppMethodBeat.o(239385);
          return true;
        }
        catch (UnsupportedEncodingException paramView)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.URISpanHandlerSet", paramView, "OpenIMKefuMsgMenuUriSpanHandler exp, msg = %s", new Object[0]);
          }
        }
      }
      AppMethodBeat.o(239385);
      return false;
    }
    
    public final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.v paramv, Bundle paramBundle)
    {
      return false;
    }
    
    public final int[] aDQ()
    {
      return new int[] { 62 };
    }
    
    public final u iJ(String paramString)
    {
      AppMethodBeat.i(239377);
      if (paramString.trim().startsWith("weixin://kefumenu"))
      {
        paramString = new u(paramString, 62, null);
        AppMethodBeat.o(239377);
        return paramString;
      }
      AppMethodBeat.o(239377);
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class PayTransferUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    PayTransferUriSpanHandler() {}
    
    public final boolean a(View paramView, u paramu, m paramm)
    {
      return false;
    }
    
    public final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.v paramv, Bundle paramBundle)
    {
      AppMethodBeat.i(19727);
      if (paramString.startsWith("wxpay://"))
      {
        if (paramv == null) {
          break label245;
        }
        paramBundle = paramv.iGK().toString();
        paramv = paramv.iGL();
        if (!(paramv instanceof com.tencent.mm.plugin.wallet.a)) {
          break label240;
        }
        paramv = (com.tencent.mm.plugin.wallet.a)paramv;
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
            if ((z.bBj()) || (z.bBk())) {
              f.a(URISpanHandlerSet.a(URISpanHandlerSet.this), 5, paramBundle, 11, paramv);
            }
            for (;;)
            {
              AppMethodBeat.o(19727);
              return true;
              f.a(URISpanHandlerSet.a(URISpanHandlerSet.this), 2, paramBundle, 11, paramv);
            }
          }
          Toast.makeText(URISpanHandlerSet.a(URISpanHandlerSet.this), URISpanHandlerSet.a(URISpanHandlerSet.this).getString(R.l.gUY), 0).show();
          AppMethodBeat.o(19727);
          return false;
          AppMethodBeat.o(19727);
          return false;
        }
        label240:
        paramv = null;
        continue;
        label245:
        paramv = null;
        paramBundle = null;
      }
    }
    
    public final int[] aDQ()
    {
      return new int[0];
    }
    
    public final u iJ(String paramString)
    {
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class PayUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    PayUriSpanHandler() {}
    
    public final boolean a(View paramView, u paramu, m paramm)
    {
      AppMethodBeat.i(239374);
      if (paramu.type == 28)
      {
        if (paramm != null) {
          paramm.a(paramu);
        }
        paramView = new kw();
        paramView.hMB.actionCode = 11;
        paramView.hMB.result = paramu.url;
        paramView.hMB.context = URISpanHandlerSet.a(URISpanHandlerSet.this);
        paramView.hMB.hMD = new Bundle();
        paramView.hMB.hMD.putInt("pay_channel", 6);
        paramView.asyncPublish(Looper.myLooper());
        if (paramm != null) {
          paramm.b(paramu);
        }
        AppMethodBeat.o(239374);
        return true;
      }
      AppMethodBeat.o(239374);
      return false;
    }
    
    public final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.v paramv, Bundle paramBundle)
    {
      return false;
    }
    
    public final int[] aDQ()
    {
      return new int[] { 28 };
    }
    
    public final u iJ(String paramString)
    {
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class PhoneEmailUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    PhoneEmailUriSpanHandler() {}
    
    public final boolean a(View paramView, u paramu, m paramm)
    {
      AppMethodBeat.i(239398);
      if (paramm != null) {
        paramm.a(paramu);
      }
      if (paramu.type == 25)
      {
        paramView = paramu.username;
        paramm = new Bundle();
        if ((paramView != null) && (!paramView.equals(z.bAM())))
        {
          paramm.putString("Contact_User", paramView);
          paramView = com.tencent.mm.plugin.account.b.getAddrUploadStg().SR(paramView);
          if ((paramView == null) || (Util.isNullOrNil(paramView.getMd5()))) {
            break label177;
          }
        }
      }
      label177:
      for (paramView = Util.nullAsNil(paramView.bWN()).replace(" ", "");; paramView = null)
      {
        paramm.putString("Contact_Mobile_MD5", paramView);
        paramm.putInt("fromScene", 1);
        r.a(URISpanHandlerSet.a(URISpanHandlerSet.this), paramu.url, null, paramm);
        AppMethodBeat.o(239398);
        return true;
        if (paramu.type == 24) {
          r.b(URISpanHandlerSet.a(URISpanHandlerSet.this), paramu.url, null);
        }
        if (paramm != null) {
          paramm.b(paramu);
        }
        AppMethodBeat.o(239398);
        return false;
      }
    }
    
    public final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.v paramv, Bundle paramBundle)
    {
      return false;
    }
    
    public final int[] aDQ()
    {
      return new int[] { 25, 24 };
    }
    
    public final u iJ(String paramString)
    {
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class PluginUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    PluginUriSpanHandler() {}
    
    public final boolean a(View paramView, u paramu, m paramm)
    {
      return false;
    }
    
    public final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.v paramv, Bundle paramBundle)
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
    
    public final int[] aDQ()
    {
      return new int[] { 26 };
    }
    
    public final u iJ(String paramString)
    {
      AppMethodBeat.i(19730);
      if (paramString.trim().startsWith("weixin://plugin"))
      {
        paramString = new u(paramString, 26, null);
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
    ProfileUriSpanHandler() {}
    
    public final boolean a(View paramView, u paramu, m paramm)
    {
      AppMethodBeat.i(239416);
      if (paramu.type == 3)
      {
        if (paramm != null) {
          paramm.a(paramu);
        }
        paramView = (String)paramu.cf(String.class);
        Intent localIntent = new Intent();
        localIntent.addFlags(268435456);
        localIntent.putExtra("Contact_User", paramView);
        bh.bCz();
        au localau = com.tencent.mm.model.c.bzA().JE(paramView);
        if ((localau != null) && ((int)localau.maN > 0) && (com.tencent.mm.contact.d.rs(localau.field_type))) {
          e.a(localIntent, paramView);
        }
        if (Util.nullAsNil(paramView).length() > 0) {
          com.tencent.mm.br.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "profile", ".ui.ContactInfoUI", localIntent);
        }
        if (paramm != null) {
          paramm.b(paramu);
        }
        AppMethodBeat.o(239416);
        return true;
      }
      AppMethodBeat.o(239416);
      return false;
    }
    
    public final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.v paramv, Bundle paramBundle)
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
        paramv = new Intent();
        paramv.addFlags(268435456);
        paramv.putExtra("Contact_User", paramString);
        bh.bCz();
        paramBundle = com.tencent.mm.model.c.bzA().JE(paramString);
        if ((paramBundle != null) && ((int)paramBundle.maN > 0) && (com.tencent.mm.contact.d.rs(paramBundle.field_type))) {
          e.a(paramv, paramString);
        }
        com.tencent.mm.br.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "profile", ".ui.ContactInfoUI", paramv);
        AppMethodBeat.o(19734);
        return true;
      }
      AppMethodBeat.o(19734);
      return false;
    }
    
    public final int[] aDQ()
    {
      return new int[] { 3 };
    }
    
    public final u iJ(String paramString)
    {
      AppMethodBeat.i(19732);
      if (paramString.trim().startsWith("weixin://contacts/profile/"))
      {
        paramString = new u(paramString, 3, paramString.trim().replace("weixin://contacts/profile/", "").replace("/", ""));
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
    ScanQrCodeUriSpanHandler() {}
    
    public final boolean a(View paramView, u paramu, m paramm)
    {
      return false;
    }
    
    public final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.v paramv, Bundle paramBundle)
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
    
    public final int[] aDQ()
    {
      return new int[0];
    }
    
    public final u iJ(String paramString)
    {
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class SetSafeDeviceUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    SetSafeDeviceUriSpanHandler() {}
    
    public final boolean a(View paramView, u paramu, m paramm)
    {
      return false;
    }
    
    public final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.v paramv, Bundle paramBundle)
    {
      AppMethodBeat.i(19736);
      if (paramString.equals("weixin://setting/account/safedevice"))
      {
        bh.bCz();
        paramString = (String)com.tencent.mm.model.c.ban().d(6, "");
        bh.bCz();
        paramv = (String)com.tencent.mm.model.c.ban().d(4097, "");
        if (!Util.isNullOrNil(paramString))
        {
          paramString = new Intent();
          if ((URISpanHandlerSet.a(URISpanHandlerSet.this) instanceof Service)) {
            paramString.addFlags(268435456);
          }
          com.tencent.mm.br.c.ai(URISpanHandlerSet.a(URISpanHandlerSet.this), "account", ".security.ui.MySafeDeviceListUI");
        }
        for (;;)
        {
          AppMethodBeat.o(19736);
          return true;
          if (!Util.isNullOrNil(paramv))
          {
            paramString = new Intent(URISpanHandlerSet.a(URISpanHandlerSet.this), BindMContactIntroUI.class);
            paramString.putExtra("bind_scene", 1);
            if ((URISpanHandlerSet.a(URISpanHandlerSet.this) instanceof Service)) {
              paramString.addFlags(268435456);
            }
            MMWizardActivity.aQ(URISpanHandlerSet.a(URISpanHandlerSet.this), paramString);
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
    
    public final int[] aDQ()
    {
      return new int[0];
    }
    
    public final u iJ(String paramString)
    {
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class SettingBindEmailUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    SettingBindEmailUriSpanHandler() {}
    
    public final boolean a(View paramView, u paramu, m paramm)
    {
      AppMethodBeat.i(239386);
      if (paramu.type == 7)
      {
        if (paramm != null) {
          paramm.a(paramu);
        }
        paramView = LauncherUI.getInstance();
        if (paramView != null) {
          paramView.adBG.getMainTabUI().bzP("tab_settings");
        }
        if (paramm != null) {
          paramm.b(paramu);
        }
        AppMethodBeat.o(239386);
        return true;
      }
      AppMethodBeat.o(239386);
      return false;
    }
    
    public final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.v paramv, Bundle paramBundle)
    {
      return false;
    }
    
    public final int[] aDQ()
    {
      return new int[] { 7 };
    }
    
    public final u iJ(String paramString)
    {
      AppMethodBeat.i(19737);
      if (paramString.trim().startsWith("weixin://setting/bindemail"))
      {
        paramString = new u(paramString, 7, null);
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
    SettingBlacklistUriSpanHandler() {}
    
    public final boolean a(View paramView, u paramu, m paramm)
    {
      AppMethodBeat.i(239358);
      if (paramu.type == 14)
      {
        if (paramm != null) {
          paramm.a(paramu);
        }
        Object localObject = ai.Js(URISpanHandlerSet.a(URISpanHandlerSet.this).getString(R.l.group_blacklist));
        paramView = new Intent();
        paramView.setClass(URISpanHandlerSet.a(URISpanHandlerSet.this), SelectContactUI.class);
        paramView.putExtra("Contact_GroupFilter_Type", ((com.tencent.mm.model.ah)localObject).getType());
        paramView.putExtra("Contact_GroupFilter_DisplayName", ((com.tencent.mm.model.ah)localObject).aSU());
        paramView.addFlags(67108864);
        localObject = LauncherUI.getInstance();
        if (localObject != null) {
          ((LauncherUI)localObject).adBG.getMainTabUI().bzP("tab_settings");
        }
        localObject = URISpanHandlerSet.a(URISpanHandlerSet.this);
        paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
        com.tencent.mm.hellhoundlib.a.a.b(localObject, paramView.aYi(), "com/tencent/mm/app/plugin/URISpanHandlerSet$SettingBlacklistUriSpanHandler", "handleSpanClick", "(Landroid/view/View;Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((Context)localObject).startActivity((Intent)paramView.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/app/plugin/URISpanHandlerSet$SettingBlacklistUriSpanHandler", "handleSpanClick", "(Landroid/view/View;Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        if (paramm != null) {
          paramm.b(paramu);
        }
        AppMethodBeat.o(239358);
        return true;
      }
      AppMethodBeat.o(239358);
      return false;
    }
    
    public final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.v paramv, Bundle paramBundle)
    {
      AppMethodBeat.i(19741);
      if (paramString.equals("weixin://setting/blacklist"))
      {
        paramv = ai.Js(URISpanHandlerSet.a(URISpanHandlerSet.this).getString(R.l.group_blacklist));
        paramString = new Intent();
        paramString.setClass(URISpanHandlerSet.a(URISpanHandlerSet.this), AddressUI.class);
        paramString.putExtra("Contact_GroupFilter_Type", paramv.getType());
        paramString.putExtra("Contact_GroupFilter_DisplayName", paramv.aSU());
        paramString.addFlags(67108864);
        if ((URISpanHandlerSet.a(URISpanHandlerSet.this) instanceof Service)) {
          paramString.addFlags(268435456);
        }
        paramv = LauncherUI.getInstance();
        if (paramv != null) {
          paramv.adBG.getMainTabUI().bzP("tab_settings");
        }
        paramv = URISpanHandlerSet.a(URISpanHandlerSet.this);
        paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
        com.tencent.mm.hellhoundlib.a.a.b(paramv, paramString.aYi(), "com/tencent/mm/app/plugin/URISpanHandlerSet$SettingBlacklistUriSpanHandler", "handleUriJump", "(Ljava/lang/String;ZLcom/tencent/mm/pluginsdk/UriJumpCallback;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramv.startActivity((Intent)paramString.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramv, "com/tencent/mm/app/plugin/URISpanHandlerSet$SettingBlacklistUriSpanHandler", "handleUriJump", "(Ljava/lang/String;ZLcom/tencent/mm/pluginsdk/UriJumpCallback;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(19741);
        return true;
      }
      AppMethodBeat.o(19741);
      return false;
    }
    
    public final int[] aDQ()
    {
      return new int[] { 14 };
    }
    
    public final u iJ(String paramString)
    {
      AppMethodBeat.i(19739);
      if (paramString.trim().startsWith("weixin://setting/blacklist"))
      {
        paramString = new u(paramString, 14, null);
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
    SettingHeadImgUriSpanHandler() {}
    
    public final boolean a(View paramView, u paramu, m paramm)
    {
      AppMethodBeat.i(239409);
      if (paramu.type == 6)
      {
        if (paramm != null) {
          paramm.a(paramu);
        }
        paramView = LauncherUI.getInstance();
        if (paramView != null) {
          paramView.adBG.getMainTabUI().bzP("tab_settings");
        }
        if (paramm != null) {
          paramm.b(paramu);
        }
        AppMethodBeat.o(239409);
        return true;
      }
      AppMethodBeat.o(239409);
      return false;
    }
    
    public final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.v paramv, Bundle paramBundle)
    {
      AppMethodBeat.i(19744);
      if (paramString.equals("weixin://setting/setheadimage"))
      {
        paramString = new Intent();
        paramString.putExtra("Contact_User", z.bAM());
        paramString.putExtra("Contact_Nick", z.bAO());
        paramString.putExtra("User_Avatar", true);
        if ((URISpanHandlerSet.a(URISpanHandlerSet.this) instanceof Service)) {
          paramString.addFlags(268435456);
        }
        com.tencent.mm.br.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "profile", ".ui.ContactInfoUI", paramString);
        AppMethodBeat.o(19744);
        return true;
      }
      AppMethodBeat.o(19744);
      return false;
    }
    
    public final int[] aDQ()
    {
      return new int[] { 6 };
    }
    
    public final u iJ(String paramString)
    {
      AppMethodBeat.i(19742);
      if (paramString.trim().startsWith("weixin://setting/setheadimage"))
      {
        paramString = new u(paramString, 6, null);
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
    SettingNotifyUriSpanHandler() {}
    
    public final boolean a(View paramView, u paramu, m paramm)
    {
      AppMethodBeat.i(239384);
      if (paramu.type == 9)
      {
        if (paramm != null) {
          paramm.a(paramu);
        }
        paramView = LauncherUI.getInstance();
        if (paramView != null) {
          paramView.adBG.getMainTabUI().bzP("tab_settings");
        }
        com.tencent.mm.br.c.ai(URISpanHandlerSet.a(URISpanHandlerSet.this), "setting", ".ui.setting.SettingsNotificationUI");
        if (paramm != null) {
          paramm.b(paramu);
        }
        AppMethodBeat.o(239384);
        return true;
      }
      AppMethodBeat.o(239384);
      return false;
    }
    
    public final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.v paramv, Bundle paramBundle)
    {
      AppMethodBeat.i(19747);
      if (paramString.equals("weixin://setting/notify"))
      {
        paramString = LauncherUI.getInstance();
        if (paramString != null) {
          paramString.adBG.getMainTabUI().bzP("tab_settings");
        }
        paramString = new Intent();
        paramString.addFlags(67108864);
        if ((URISpanHandlerSet.a(URISpanHandlerSet.this) instanceof Service)) {
          paramString.addFlags(268435456);
        }
        com.tencent.mm.br.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "setting", ".ui.setting.SettingsNotificationUI", paramString);
        AppMethodBeat.o(19747);
        return true;
      }
      AppMethodBeat.o(19747);
      return false;
    }
    
    public final int[] aDQ()
    {
      return new int[] { 9 };
    }
    
    public final u iJ(String paramString)
    {
      AppMethodBeat.i(19745);
      if (paramString.trim().startsWith("weixin://setting/notify"))
      {
        paramString = new u(paramString, 9, null);
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
    SettingPluginLomoUriSpanHandler() {}
    
    public final boolean a(View paramView, u paramu, m paramm)
    {
      AppMethodBeat.i(239414);
      if (paramu.type == 12)
      {
        if (paramm != null) {
          paramm.a(paramu);
        }
        paramView = new Intent();
        paramView.putExtra("Contact_User", "weibo");
        com.tencent.mm.br.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "profile", ".ui.ContactInfoUI", paramView);
        if (paramm != null) {
          paramm.b(paramu);
        }
        AppMethodBeat.o(239414);
        return true;
      }
      AppMethodBeat.o(239414);
      return false;
    }
    
    public final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.v paramv, Bundle paramBundle)
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
    
    public final int[] aDQ()
    {
      return new int[] { 12 };
    }
    
    public final u iJ(String paramString)
    {
      AppMethodBeat.i(19748);
      if (paramString.trim().startsWith("weixin://setting/plugin/lomo"))
      {
        paramString = new u(paramString, 12, null);
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
    SettingPluginQQMailUriSpanHandler() {}
    
    public final boolean a(View paramView, u paramu, m paramm)
    {
      AppMethodBeat.i(239367);
      if (paramu.type == 10)
      {
        if (paramm != null) {
          paramm.a(paramu);
        }
        paramView = new Intent();
        paramView.putExtra("Contact_User", "qqmail");
        com.tencent.mm.br.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "profile", ".ui.ContactInfoUI", paramView);
        if (paramm != null) {
          paramm.b(paramu);
        }
        AppMethodBeat.o(239367);
        return true;
      }
      AppMethodBeat.o(239367);
      return false;
    }
    
    public final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.v paramv, Bundle paramBundle)
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
    
    public final int[] aDQ()
    {
      return new int[] { 10 };
    }
    
    public final u iJ(String paramString)
    {
      AppMethodBeat.i(19751);
      if (paramString.trim().startsWith("weixin://setting/plugin/qqmail"))
      {
        paramString = new u(paramString, 10, null);
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
    SettingPluginQQMsgUriSpanHandler() {}
    
    public final boolean a(View paramView, u paramu, m paramm)
    {
      return false;
    }
    
    public final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.v paramv, Bundle paramBundle)
    {
      return false;
    }
    
    public final int[] aDQ()
    {
      return new int[] { 13 };
    }
    
    public final u iJ(String paramString)
    {
      AppMethodBeat.i(19754);
      if (paramString.trim().startsWith("weixin://setting/plugin/qqmsg"))
      {
        paramString = new u(paramString, 13, null);
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
    SettingPluginSxMsgUriSpanHandler() {}
    
    public final boolean a(View paramView, u paramu, m paramm)
    {
      return false;
    }
    
    public final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.v paramv, Bundle paramBundle)
    {
      return false;
    }
    
    public final int[] aDQ()
    {
      return new int[] { 11 };
    }
    
    public final u iJ(String paramString)
    {
      AppMethodBeat.i(19755);
      if (paramString.trim().startsWith("weixin://setting/plugin/sxmsg"))
      {
        paramString = new u(paramString, 11, null);
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
    SettingPrivacyUriSpanHandler() {}
    
    public final boolean a(View paramView, u paramu, m paramm)
    {
      AppMethodBeat.i(239421);
      if (paramu.type == 15)
      {
        if (paramm != null) {
          paramm.a(paramu);
        }
        paramView = LauncherUI.getInstance();
        if (paramView != null) {
          paramView.adBG.getMainTabUI().bzP("tab_settings");
        }
        com.tencent.mm.br.c.ai(URISpanHandlerSet.a(URISpanHandlerSet.this), "setting", ".ui.setting.SettingsPrivacyUI");
        if (paramm != null) {
          paramm.b(paramu);
        }
        AppMethodBeat.o(239421);
        return true;
      }
      AppMethodBeat.o(239421);
      return false;
    }
    
    public final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.v paramv, Bundle paramBundle)
    {
      AppMethodBeat.i(19758);
      if (paramString.equals("weixin://setting/privacy"))
      {
        paramString = LauncherUI.getInstance();
        if (paramString != null) {
          paramString.adBG.getMainTabUI().bzP("tab_settings");
        }
        paramString = new Intent();
        if ((URISpanHandlerSet.a(URISpanHandlerSet.this) instanceof Service)) {
          paramString.addFlags(268435456);
        }
        com.tencent.mm.br.c.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "setting", ".ui.setting.SettingsPrivacyUI", paramString);
        AppMethodBeat.o(19758);
        return true;
      }
      AppMethodBeat.o(19758);
      return false;
    }
    
    public final int[] aDQ()
    {
      return new int[] { 15 };
    }
    
    public final u iJ(String paramString)
    {
      AppMethodBeat.i(19756);
      if (paramString.trim().startsWith("weixin://setting/privacy"))
      {
        paramString = new u(paramString, 15, null);
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
    StoryEntranceHandler() {}
    
    public final boolean a(View paramView, u paramu, m paramm)
    {
      AppMethodBeat.i(239338);
      if (paramu.type == 48)
      {
        paramView = paramu.username;
        if (TextUtils.isEmpty(paramView))
        {
          AppMethodBeat.o(239338);
          return false;
        }
        if (com.tencent.mm.plugin.sns.easteregg.a.aXL(paramView)) {
          com.tencent.mm.plugin.story.api.o.bT(URISpanHandlerSet.a(URISpanHandlerSet.this), paramView);
        }
        if (paramm != null) {
          paramm.b(paramu);
        }
        AppMethodBeat.o(239338);
        return true;
      }
      AppMethodBeat.o(239338);
      return false;
    }
    
    public final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.v paramv, Bundle paramBundle)
    {
      return false;
    }
    
    public final int[] aDQ()
    {
      return new int[] { 48 };
    }
    
    public final u iJ(String paramString)
    {
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class TeenModeAgreeAuthorizationSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    TeenModeAgreeAuthorizationSpanHandler() {}
    
    public final boolean a(View paramView, u paramu, m paramm)
    {
      AppMethodBeat.i(239415);
      if (paramu.type == 64)
      {
        Log.i("MicroMsg.URISpanHandlerSet", "TeenModeAgreeAuthorizationSpanHandler");
        Uri.parse(paramu.url);
        paramView = paramu.url;
        long l = Util.getLong(paramView.substring(paramView.trim().lastIndexOf("/") + 1), 0L);
        if (l > 0L)
        {
          paramView = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aU(paramu.username, l);
          if (paramView.field_msgSvrId > 0L)
          {
            if (paramView.field_isSend != 1) {
              break label157;
            }
            ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).a(URISpanHandlerSet.a(URISpanHandlerSet.this), paramu.username, z.bAM(), paramView.getCreateTime(), paramView.field_msgSvrId, paramView.field_content, paramView.field_imgPath, Boolean.TRUE);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(239415);
          return true;
          label157:
          ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).a(URISpanHandlerSet.a(URISpanHandlerSet.this), z.bAM(), paramu.username, paramView.getCreateTime(), paramView.field_msgSvrId, paramView.field_content, paramView.field_imgPath, Boolean.TRUE);
        }
      }
      AppMethodBeat.o(239415);
      return false;
    }
    
    public final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.v paramv, Bundle paramBundle)
    {
      return false;
    }
    
    public final int[] aDQ()
    {
      return new int[] { 64 };
    }
    
    public final u iJ(String paramString)
    {
      AppMethodBeat.i(239412);
      if (paramString.trim().startsWith("weixin://teenagerModeAgreenAuthorization/"))
      {
        paramString = new u(paramString, 64, null);
        AppMethodBeat.o(239412);
        return paramString;
      }
      AppMethodBeat.o(239412);
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class TodoSystemMsgUrlSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    TodoSystemMsgUrlSpanHandler() {}
    
    public final boolean a(View paramView, u paramu, m paramm)
    {
      AppMethodBeat.i(239379);
      if (paramu.type == 54) {
        Log.i("MicroMsg.URISpanHandlerSet", "handleClickTodoSystemMsgUrl");
      }
      label387:
      label393:
      for (;;)
      {
        boolean bool1;
        try
        {
          localObject1 = Uri.parse(paramu.url);
          paramView = paramu.chatroomName;
          paramm = ((Uri)localObject1).getQueryParameter("todoid");
          ((Uri)localObject1).getQueryParameter("related_msgid");
          str = ((Uri)localObject1).getQueryParameter("username");
          localObject2 = ((Uri)localObject1).getQueryParameter("path");
          localObject1 = ((PluginChatroomUI)com.tencent.mm.kernel.h.az(PluginChatroomUI.class)).getGroupTodoStorage().ar(paramView, paramm);
          if (!Util.isEqual("roomannouncement@app.origin", str)) {
            continue;
          }
          com.tencent.mm.chatroom.d.ab.f(MMApplicationContext.getContext(), paramView, true);
          bool2 = com.tencent.mm.chatroom.d.ab.e((com.tencent.mm.chatroom.storage.c)localObject1);
          if (!bool2) {
            break label387;
          }
          bool1 = com.tencent.mm.chatroom.d.ab.b((com.tencent.mm.chatroom.storage.c)localObject1);
          if (!bool1) {
            break label393;
          }
          localObject2 = new qa();
          ((qa)localObject2).hTi.op = 3;
          ((qa)localObject2).hTi.hMM = ((com.tencent.mm.chatroom.storage.c)localObject1).field_roomname;
          ((qa)localObject2).hTi.hTj = paramm;
          ((qa)localObject2).asyncPublish(Looper.getMainLooper());
        }
        catch (Exception paramView)
        {
          Object localObject1;
          String str;
          Object localObject2;
          boolean bool2;
          com.tencent.mm.plugin.appbrand.api.g localg;
          Log.e("MicroMsg.URISpanHandlerSet", "handle click link error: %s, url: %s", new Object[] { paramView.getMessage(), paramu.url });
          continue;
          int i = 0;
          continue;
        }
        if (Util.isEqual("roomannouncement@app.origin", str))
        {
          i = 1;
          com.tencent.mm.chatroom.d.ac.a(paramView, i, 2, paramm, str);
          Log.i("MicroMsg.URISpanHandlerSet", "handleClickTodoSystemMsgUrl stoTodo(%s %s %s) update finish(%s)", new Object[] { Boolean.valueOf(Util.isNullOrNil(paramm)), Boolean.valueOf(Util.isNullOrNil(str)), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
          AppMethodBeat.o(239379);
          return true;
          localg = new com.tencent.mm.plugin.appbrand.api.g();
          localg.username = str;
          localg.qAF = ((String)localObject2);
          localg.scene = 1160;
          localg.icX = paramView;
          if (localObject1 != null)
          {
            localg.eoU = ((com.tencent.mm.chatroom.storage.c)localObject1).field_shareKey;
            localg.eoT = ((com.tencent.mm.chatroom.storage.c)localObject1).field_shareName;
          }
          ((com.tencent.mm.plugin.appbrand.service.t)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.t.class)).a(URISpanHandlerSet.a(URISpanHandlerSet.this), localg);
        }
        else
        {
          AppMethodBeat.o(239379);
          return false;
          bool1 = false;
        }
      }
    }
    
    public final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.v paramv, Bundle paramBundle)
    {
      return false;
    }
    
    public final int[] aDQ()
    {
      return new int[] { 54 };
    }
    
    public final u iJ(String paramString)
    {
      AppMethodBeat.i(179563);
      if (paramString.trim().toLowerCase().startsWith("weixin://roomtoolstodo?"))
      {
        paramString = new u(paramString, 54, null);
        AppMethodBeat.o(179563);
        return paramString;
      }
      AppMethodBeat.o(179563);
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class TopicSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    TopicSpanHandler() {}
    
    private static String a(int paramInt1, String paramString, int paramInt2)
    {
      int i = 0;
      AppMethodBeat.i(239335);
      if ((paramInt1 == 3) && (!TextUtils.isEmpty(paramString)))
      {
        String[] arrayOfString = paramString.split("#");
        if ((arrayOfString != null) && (arrayOfString.length >= 2))
        {
          Object localObject = arrayOfString[1];
          if ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.equals("0", (CharSequence)localObject))) {
            paramInt1 = 1;
          }
          while ((paramInt1 != 0) && (paramInt2 != 0))
          {
            Log.i("MicroMsg.WebSearch.WebSearchReportLogic", "need correct feeId");
            localObject = al.hgB().alB(paramInt2);
            if ((localObject != null) && (((SnsInfo)localObject).field_snsId != 0L))
            {
              arrayOfString[1] = com.tencent.mm.plugin.sns.data.t.uA(((SnsInfo)localObject).field_snsId);
              paramString = new StringBuilder();
              paramInt1 = i;
              for (;;)
              {
                if (paramInt1 < arrayOfString.length)
                {
                  paramString.append(arrayOfString[paramInt1]);
                  if (paramInt1 != arrayOfString.length - 1) {
                    paramString.append("#");
                  }
                  paramInt1 += 1;
                  continue;
                  paramInt1 = 0;
                  break;
                }
              }
              paramString = paramString.toString();
              AppMethodBeat.o(239335);
              return paramString;
            }
          }
        }
      }
      AppMethodBeat.o(239335);
      return paramString;
    }
    
    public static void a(View paramView, u paramu, String paramString)
    {
      AppMethodBeat.i(239331);
      Object localObject = com.tencent.mm.plugin.secdata.ui.a.PlI;
      localObject = (flr)a.a.jb(paramView);
      Log.i("MicroMsg.URISpanHandlerSet", "TopicSpanHandler click %s %s", new Object[] { paramu.url, localObject });
      int j = 0;
      paramView = "";
      long l = cn.getSyncServerTimeSecond();
      int i;
      if (localObject != null)
      {
        j = ((flr)localObject).abMf;
        paramView = ((flr)localObject).abMg;
        l = ((flr)localObject).YKn;
        i = ((flr)localObject).abMh;
        paramView = a(j, paramView, ((flr)localObject).abMj);
      }
      for (;;)
      {
        localObject = paramu.url;
        paramu = new rv();
        paramu.ioV = 1L;
        paramu.izR = cn.getSyncServerTimeSecond();
        paramu.jwF = 1L;
        localObject = paramu.yA(iK((String)localObject));
        ((rv)localObject).jwH = j;
        paramView = ((rv)localObject).yB(paramView);
        paramView.jwJ = l;
        paramView.jwK = i;
        paramView.yC(paramString).bMH();
        as.a(paramu);
        AppMethodBeat.o(239331);
        return;
        i = 0;
      }
    }
    
    private static String iK(String paramString)
    {
      AppMethodBeat.i(239340);
      if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("#")))
      {
        paramString = paramString.substring(1);
        AppMethodBeat.o(239340);
        return paramString;
      }
      AppMethodBeat.o(239340);
      return paramString;
    }
    
    public final boolean a(View paramView, u paramu, m paramm)
    {
      AppMethodBeat.i(239350);
      int m;
      long l2;
      int k;
      int j;
      long l3;
      Object localObject;
      int i;
      if (paramu.type == 58)
      {
        paramm = com.tencent.mm.plugin.secdata.ui.a.PlI;
        paramm = (flr)a.a.jb(paramView);
        Log.i("MicroMsg.URISpanHandlerSet", "TopicSpanHandler click %s %s", new Object[] { paramu.url, paramm });
        long l1 = 0L;
        m = 0;
        paramView = "";
        l2 = cn.getSyncServerTimeSecond();
        k = 0;
        j = 0;
        if (paramm != null)
        {
          l1 = paramm.YKq;
          m = paramm.abMf;
          paramView = paramm.abMg;
          l2 = paramm.YKn;
          k = paramm.abMh;
          j = paramm.abMi;
          paramView = a(m, paramView, paramm.abMj);
        }
        l3 = l1;
        if (paramu.cpt != null)
        {
          l3 = l1;
          if ((paramu.cpt instanceof Bundle)) {
            l3 = ((Bundle)paramu.cpt).getLong("msgSvrId");
          }
        }
        localObject = paramu.url;
        i = 73;
        if ((m != 1) && (m != 2)) {
          break label454;
        }
        i = 73;
      }
      for (;;)
      {
        paramu = com.tencent.mm.plugin.fts.a.d.We(i);
        paramm = new com.tencent.mm.plugin.websearch.api.ah();
        paramm.context = URISpanHandlerSet.a(URISpanHandlerSet.this);
        paramm.scene = i;
        paramm.query = ((String)localObject);
        paramm.title = ((String)localObject);
        paramm.sessionId = paramu;
        paramm.WoH = true;
        paramm.WoI = true;
        paramm.WoJ = true;
        paramm.WoK = 1;
        paramm.WoL = com.tencent.mm.cd.a.w(URISpanHandlerSet.a(URISpanHandlerSet.this), R.e.white);
        paramm.WoM = true;
        paramm.hVt.put("msgSvrId", String.valueOf(l3));
        paramm.hVt.put("parentSearchID", "");
        paramm.hVt.put("fromTagSearch", "1");
        paramm.WoT.put("ShareSceneId", paramView);
        paramm.WoT.put("SnsContentType", String.valueOf(j));
        ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.websearch.api.h.class)).a(paramm);
        paramm = new rv();
        paramm.ioV = 1L;
        paramm.izR = cn.getSyncServerTimeSecond();
        paramm.jwF = 1L;
        localObject = paramm.yA(iK((String)localObject));
        ((rv)localObject).jwH = m;
        paramView = ((rv)localObject).yB(paramView);
        paramView.jwJ = l2;
        paramView.jwK = k;
        paramView.yC(paramu).bMH();
        as.a(paramm);
        AppMethodBeat.o(239350);
        return true;
        label454:
        if (m == 3) {
          i = 79;
        } else if ((m == 4) || (m == 5)) {
          i = 80;
        }
      }
    }
    
    public final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.v paramv, Bundle paramBundle)
    {
      return false;
    }
    
    public final int[] aDQ()
    {
      return new int[] { 58 };
    }
    
    public final u iJ(String paramString)
    {
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class TransferUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    TransferUriSpanHandler() {}
    
    public final boolean a(View paramView, u paramu, m paramm)
    {
      AppMethodBeat.i(239419);
      if (paramu != null)
      {
        if (paramu.type == 42)
        {
          com.tencent.mm.br.c.ai(URISpanHandlerSet.a(URISpanHandlerSet.this), "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
          AppMethodBeat.o(239419);
          return true;
        }
        if (paramu.type == 41)
        {
          com.tencent.mm.br.c.ai(URISpanHandlerSet.a(URISpanHandlerSet.this), "wallet", ".balance.ui.WalletBalanceManagerUI");
          AppMethodBeat.o(239419);
          return true;
        }
        if (paramu.type == 39)
        {
          if ((paramu.cpt != null) && ((paramu.cpt instanceof Bundle)))
          {
            paramView = (Bundle)paramu.cpt;
            paramu = (ResendMsgInfo)paramView.getParcelable("resend_msg_info");
            ((com.tencent.mm.plugin.wxpaysdk.api.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.wxpaysdk.api.b.class)).a(URISpanHandlerSet.a(URISpanHandlerSet.this), paramu, new URISpanHandlerSet.TransferUriSpanHandler.1(this, paramView));
          }
          AppMethodBeat.o(239419);
          return true;
        }
        if (paramu.type == 40)
        {
          if ((paramu.cpt != null) && ((paramu.cpt instanceof Bundle)))
          {
            paramView = (Bundle)paramu.cpt;
            paramu = new ud();
            paramu.hXR.hAU = paramView.getString("transaction_id");
            paramu.hXR.hPj = paramView.getString("transfer_id");
            paramu.hXR.hXS = paramView.getInt("total_fee");
            paramu.hXR.hXT = paramView.getString("sender_name");
            paramu.publish();
          }
          AppMethodBeat.o(239419);
          return true;
        }
        Object localObject;
        if (paramu.type == 49)
        {
          paramView = Uri.parse(paramu.url);
          paramm = paramView.getQueryParameter("transfer_id");
          localObject = paramView.getQueryParameter("trans_id");
          paramView = "";
          if ((paramu.cpt != null) && ((paramu.cpt instanceof Bundle))) {
            paramView = ((Bundle)paramu.cpt).getString("sender_name");
          }
          for (;;)
          {
            paramu = new Intent();
            paramu.putExtra("transfer_id", paramm);
            paramu.putExtra("transaction_id", (String)localObject);
            paramu.putExtra("sender_name", paramView);
            com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "remittance", ".ui.RemittanceDetailUI", paramu);
            AppMethodBeat.o(239419);
            return true;
            Log.i("MicroMsg.URISpanHandlerSet", "hrefInfo.getType() == TYPE_TRANSFER_QUERY_MSG senderName == null");
          }
        }
        if ((paramu.type == 56) || (paramu.type == 63))
        {
          localObject = Uri.parse(paramu.url);
          paramm = ((Uri)localObject).getQueryParameter("transferid");
          paramView = ((Uri)localObject).getQueryParameter("fromusername");
          localObject = ((Uri)localObject).getQueryParameter("transfer_msg_type");
          if (paramu.type == 56)
          {
            Log.i("MicroMsg.URISpanHandlerSet", "click MSpanConstants.Type.TYPE_TRANSFER_REMINDE_RECEIVE_MSG, transferId: %s，msgType:%s", new Object[] { paramm, localObject });
            com.tencent.mm.plugin.report.service.h.OAn.b(20467, new Object[] { "transfer_to_change", "click message", "", "", "", "", Integer.valueOf(3), paramm, localObject });
          }
          if ((!Util.isNullOrNil(paramm)) && (!Util.isNullOrNil(paramView)))
          {
            Log.i("MicroMsg.URISpanHandlerSet", "handle MSpanConstants.Type.TYPE_TRANSFER_REMINDE_RECEIVE_MSG");
            com.tencent.mm.plugin.remittance.app.c.gLv();
            paramu = com.tencent.mm.plugin.remittance.app.c.gLx().aTO(paramm);
            if ((paramu == null) || (paramu.field_locaMsgId <= 0L)) {
              break label730;
            }
            Log.i("MicroMsg.URISpanHandlerSet", "handle MSpanConstants.Type.TYPE_TRANSFER_REMINDE_RECEIVE_MSG, localMsgId: %s", new Object[] { Long.valueOf(paramu.field_locaMsgId) });
            if (((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(paramu.field_locaMsgId).field_msgId > 0L) {
              break label695;
            }
            Log.i("MicroMsg.URISpanHandlerSet", "cannot find msg in msg storage!");
            new g.a(MMApplicationContext.getContext()).bDE(MMApplicationContext.getContext().getString(R.l.remittance_find_from_jsapi_failed_delete)).aEY(MMApplicationContext.getContext().getResources().getColor(R.e.link_color)).aEX(R.l.i_know_it).b(new URISpanHandlerSet.TransferUriSpanHandler.2(this)).show();
          }
          for (;;)
          {
            AppMethodBeat.o(239419);
            return true;
            label695:
            paramm = new wk();
            paramm.hZY.msgId = paramu.field_locaMsgId;
            paramm.hZY.hgk = paramView;
            paramm.publish();
            continue;
            label730:
            Log.i("MicroMsg.URISpanHandlerSet", "handle MSpanConstants.Type.TYPE_TRANSFER_REMINDE_RECEIVE_MSG, cannot find local msg");
            new g.a(MMApplicationContext.getContext()).bDE(MMApplicationContext.getContext().getString(R.l.remittance_find_from_jsapi_failed_delete)).aEY(MMApplicationContext.getContext().getResources().getColor(R.e.link_color)).aEX(R.l.i_know_it).b(new URISpanHandlerSet.TransferUriSpanHandler.3(this)).show();
          }
        }
      }
      AppMethodBeat.o(239419);
      return false;
    }
    
    public final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.v paramv, Bundle paramBundle)
    {
      return false;
    }
    
    public final int[] aDQ()
    {
      return new int[] { 39, 40, 41, 42, 49, 56, 63 };
    }
    
    public final u iJ(String paramString)
    {
      AppMethodBeat.i(19761);
      if (paramString.trim().toLowerCase().startsWith("weixin://wcpay/transfer/retrysendmsg"))
      {
        paramString = new u(paramString, 39, null);
        AppMethodBeat.o(19761);
        return paramString;
      }
      if (paramString.trim().toLowerCase().startsWith("weixin://wcpay/transfer/rebacksendmsg"))
      {
        paramString = new u(paramString, 40, null);
        AppMethodBeat.o(19761);
        return paramString;
      }
      if (paramString.trim().toLowerCase().startsWith("weixin://wcpay/transfer/watchbalance"))
      {
        paramString = new u(paramString, 41, null);
        AppMethodBeat.o(19761);
        return paramString;
      }
      if (paramString.trim().toLowerCase().startsWith("weixin://wcpay/transfer/watchlqt"))
      {
        paramString = new u(paramString, 42, null);
        AppMethodBeat.o(19761);
        return paramString;
      }
      if (paramString.trim().toLowerCase().startsWith("wechat://wcpay/transfer/transferquery"))
      {
        paramString = new u(paramString, 49, null);
        AppMethodBeat.o(19761);
        return paramString;
      }
      if (paramString.trim().toLowerCase().startsWith("weixin://wxpay/transfer/remindrcvmsg"))
      {
        paramString = new u(paramString, 56, null);
        AppMethodBeat.o(19761);
        return paramString;
      }
      if (paramString.trim().toLowerCase().startsWith("weixin://wxpay/transfer/transfer_overtime"))
      {
        paramString = new u(paramString, 63, null);
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
    UnKnowToUrlSpanHandler() {}
    
    public final boolean a(View paramView, u paramu, m paramm)
    {
      AppMethodBeat.i(239371);
      if (paramu.type == 2147483646)
      {
        if ((paramu.cpt instanceof Bundle))
        {
          paramView = ((Bundle)paramu.cpt).getString("rawUrl");
          if (Util.isNullOrNil(paramView)) {
            Log.i("MicroMsg.URISpanHandlerSet", "TYPE_UNKNOW_TO_URL url == null");
          }
        }
        for (;;)
        {
          AppMethodBeat.o(239371);
          return true;
          com.tencent.mm.plugin.account.sdk.c.a.b(MMApplicationContext.getContext(), paramView, 0, true);
          continue;
          Log.i("MicroMsg.URISpanHandlerSet", "TYPE_UNKNOW_TO_URL hrefInfo.getData() no instanceof Bundle");
        }
      }
      AppMethodBeat.o(239371);
      return false;
    }
    
    public final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.v paramv, Bundle paramBundle)
    {
      return false;
    }
    
    public final int[] aDQ()
    {
      return new int[] { 2147483646 };
    }
    
    public final u iJ(String paramString)
    {
      return null;
    }
  }
  
  @URISpanHandlerSet.a
  class UpgradeAssociateChatRoomUrlSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    UpgradeAssociateChatRoomUrlSpanHandler() {}
    
    public final boolean a(View paramView, u paramu, m paramm)
    {
      AppMethodBeat.i(239368);
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
            AppMethodBeat.o(239368);
            return true;
          }
          if (au.bwE(paramView))
          {
            paramm = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(paramView);
            if (paramm == null)
            {
              Log.e("MicroMsg.URISpanHandlerSet", "handleClickUpgradeAssociateChatRoomUrl %s member is null", new Object[] { paramView });
              AppMethodBeat.o(239368);
              return true;
            }
            Log.i("MicroMsg.URISpanHandlerSet", "handleClickUpgradeAssociateChatRoomUrl room:%s chatroomStatus:%s owener:%s", new Object[] { paramView, Integer.valueOf(paramm.field_chatroomStatus), Util.nullAs(paramm.field_roomowner, "") });
            if (paramm.field_memberCount >= com.tencent.mm.model.v.bAH())
            {
              i = 1;
              if (!com.tencent.mm.model.ab.IK(paramView)) {
                break label300;
              }
              if (paramm.Jf(z.bAM())) {
                break label392;
              }
              Log.i("MicroMsg.URISpanHandlerSet", "handleClickUpgradeAssociateChatRoomUrl：no owner");
              if (URISpanHandlerSet.a(URISpanHandlerSet.this) != null)
              {
                k.a(URISpanHandlerSet.a(URISpanHandlerSet.this), URISpanHandlerSet.a(URISpanHandlerSet.this).getString(R.l.chatroom_sys_msg_room_upgrade_to_wework_no_owner), "", URISpanHandlerSet.a(URISpanHandlerSet.this).getString(R.l.app_i_know), false, null);
                break label630;
                ManagerRoomByWeworkUI.d(paramView, 2, 2, j);
                AppMethodBeat.o(239368);
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
          AppMethodBeat.o(239368);
          return true;
          label300:
          if ((com.tencent.mm.model.ab.II(paramView)) && (!paramm.Jf(z.bAM())))
          {
            Log.i("MicroMsg.URISpanHandlerSet", "handleClickUpgradeAssociateChatRoomUrl：isAssociateChatRoom ");
            if (URISpanHandlerSet.a(URISpanHandlerSet.this) != null) {
              k.a(URISpanHandlerSet.a(URISpanHandlerSet.this), URISpanHandlerSet.a(URISpanHandlerSet.this).getString(R.l.chatroom_sys_msg_room_upgrade_to_wework_done), "", URISpanHandlerSet.a(URISpanHandlerSet.this).getString(R.l.app_i_know), false, null);
            }
            for (;;)
            {
              AppMethodBeat.o(239368);
              return true;
              Log.e("MicroMsg.URISpanHandlerSet", "handleClickUpgradeAssociateChatRoomUrl：mContext is null");
            }
          }
          label392:
          if (i != 0)
          {
            Log.i("MicroMsg.URISpanHandlerSet", "handleClickUpgradeAssociateChatRoomUrl：exceed maxnum");
            if (URISpanHandlerSet.a(URISpanHandlerSet.this) != null) {
              k.a(URISpanHandlerSet.a(URISpanHandlerSet.this), URISpanHandlerSet.a(URISpanHandlerSet.this).getString(R.l.chatroom_sys_msg_room_upgrade_to_wework_exceed_max_num), "", URISpanHandlerSet.a(URISpanHandlerSet.this).getString(R.l.app_i_know), false, null);
            }
            for (;;)
            {
              ManagerRoomByWeworkUI.d(paramView, 2, 2, 2);
              AppMethodBeat.o(239368);
              return true;
              Log.e("MicroMsg.URISpanHandlerSet", "handleClickUpgradeAssociateChatRoomUrl：mContext is null");
            }
          }
          com.tencent.mm.plugin.newtips.a.gtf().aeI(25);
          com.tencent.mm.plugin.newtips.a.gtf().aeI(26);
          com.tencent.mm.plugin.newtips.a.gtf().aeI(27);
          paramm = new Intent();
          paramm.setClass(MMApplicationContext.getContext(), ManagerRoomByWeworkUI.class);
          paramm.addFlags(268435456);
          paramm.putExtra("RoomInfo_Id", paramView);
          paramm.putExtra("upgrade_openim_room_from_scene", 2);
          paramView = MMApplicationContext.getContext();
          paramm = new com.tencent.mm.hellhoundlib.b.a().cG(paramm);
          com.tencent.mm.hellhoundlib.a.a.b(paramView, paramm.aYi(), "com/tencent/mm/app/plugin/URISpanHandlerSet$UpgradeAssociateChatRoomUrlSpanHandler", "handleSpanClick", "(Landroid/view/View;Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramView.startActivity((Intent)paramm.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/app/plugin/URISpanHandlerSet$UpgradeAssociateChatRoomUrlSpanHandler", "handleSpanClick", "(Landroid/view/View;Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(239368);
        return false;
        label630:
        int j = 1;
        if (i != 0) {
          j = 3;
        }
      }
    }
    
    public final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.v paramv, Bundle paramBundle)
    {
      return false;
    }
    
    public final int[] aDQ()
    {
      return new int[] { 53 };
    }
    
    public final u iJ(String paramString)
    {
      AppMethodBeat.i(179565);
      if (paramString.trim().toLowerCase().startsWith("weixin://weixingroupupdate?"))
      {
        paramString = new u(paramString, 53, null);
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
    VerifyContactUriSpanHandler() {}
    
    public final boolean a(View paramView, u paramu, m paramm)
    {
      AppMethodBeat.i(239404);
      if (paramu.type == 4)
      {
        if (paramm != null)
        {
          paramm.a(paramu);
          paramm.b(paramu);
        }
        AppMethodBeat.o(239404);
        return true;
      }
      AppMethodBeat.o(239404);
      return false;
    }
    
    public final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.v paramv, Bundle paramBundle)
    {
      return false;
    }
    
    public final int[] aDQ()
    {
      return new int[] { 4 };
    }
    
    public final u iJ(String paramString)
    {
      AppMethodBeat.i(19764);
      if (paramString.trim().startsWith("weixin://findfriend/verifycontact"))
      {
        paramString = new u(paramString, 4, null);
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
    VoipCallAgainUrilSpanHandler() {}
    
    public final boolean a(View paramView, u paramu, m paramm)
    {
      AppMethodBeat.i(239407);
      if (paramu.type == 38)
      {
        paramu = Uri.parse(paramu.url);
        paramView = paramu.getQueryParameter("username");
        paramu = paramu.getQueryParameter("isvideocall");
        paramm = new acn();
        paramm.ifU.hId = 5;
        paramm.ifU.talker = paramView;
        paramm.ifU.context = URISpanHandlerSet.a(URISpanHandlerSet.this);
        if ((paramView != null) && (!paramView.equals("")))
        {
          if ((paramu != null) && (paramu.equals("true"))) {}
          for (paramm.ifU.ifQ = 2;; paramm.ifU.ifQ = 4)
          {
            paramm.publish();
            AppMethodBeat.o(239407);
            return true;
          }
        }
      }
      AppMethodBeat.o(239407);
      return false;
    }
    
    public final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.v paramv, Bundle paramBundle)
    {
      return false;
    }
    
    public final int[] aDQ()
    {
      return new int[] { 38 };
    }
    
    public final u iJ(String paramString)
    {
      AppMethodBeat.i(19766);
      if (paramString.trim().startsWith("weixin://voip/callagain/"))
      {
        paramString = new u(paramString, 38, null);
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
    private final String hlb;
    
    WeWorkUrlSpanHandler()
    {
      AppMethodBeat.i(239339);
      this.hlb = ("https://" + WeChatHosts.domainString(R.l.host_work_weixin_qq_com) + "/wework_admin/commdownload");
      AppMethodBeat.o(239339);
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
    
    public final boolean a(View paramView, u paramu, m paramm)
    {
      AppMethodBeat.i(239349);
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
            com.tencent.mm.plugin.account.sdk.c.a.b(MMApplicationContext.getContext(), this.hlb, 0, true);
          }
          Log.i("MicroMsg.URISpanHandlerSet", "WeWorkUrlSpanHandler result:%s", new Object[] { Boolean.valueOf(bool) });
          AppMethodBeat.o(239349);
          return true;
        }
        catch (Exception paramView)
        {
          AppMethodBeat.o(239349);
          return false;
        }
      }
      AppMethodBeat.o(239349);
      return false;
    }
    
    public final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.v paramv, Bundle paramBundle)
    {
      return false;
    }
    
    public final int[] aDQ()
    {
      return new int[] { 52 };
    }
    
    public final u iJ(String paramString)
    {
      AppMethodBeat.i(179567);
      if (paramString.trim().toLowerCase().startsWith("wxwork://jump?"))
      {
        paramString = new u(paramString, 52, null);
        AppMethodBeat.o(179567);
        return paramString;
      }
      AppMethodBeat.o(179567);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet
 * JD-Core Version:    0.7.0.1
 */