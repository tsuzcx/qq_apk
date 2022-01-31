package com.tencent.mm.app.plugin;

import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.pluginsdk.v;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.appbrand.b;
import com.tencent.mm.ui.widget.b.e.c;

class URISpanHandlerSet
{
  Context mContext;
  
  public URISpanHandlerSet(Context paramContext)
  {
    AppMethodBeat.i(15722);
    this.mContext = null;
    if (paramContext == null) {}
    for (paramContext = ah.getContext();; paramContext = this.mContext)
    {
      this.mContext = paramContext;
      AppMethodBeat.o(15722);
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
    
    final int[] Cf()
    {
      return new int[] { 35, 36, 37 };
    }
    
    final boolean a(m paramm, g paramg)
    {
      AppMethodBeat.i(15631);
      Object localObject1;
      Object localObject2;
      if (paramm.type == 35) {
        for (;;)
        {
          try
          {
            localObject1 = Uri.parse(paramm.url).getQueryParameter("billno");
            if (bo.isNullOrNil((String)localObject1))
            {
              ab.e("MicroMsg.URISpanHandlerSet", "url error, billno is null");
              AppMethodBeat.o(15631);
              return true;
            }
            if (!(paramm.data instanceof Bundle)) {
              continue;
            }
            paramg = ((Bundle)paramm.data).getString("chatroom_name");
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("bill_no", (String)localObject1);
            ((Intent)localObject2).putExtra("enter_scene", 3);
            ((Intent)localObject2).putExtra("chatroom", paramg);
            d.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "aa", ".ui.PaylistAAUI", (Intent)localObject2);
          }
          catch (Exception paramg)
          {
            ab.e("MicroMsg.URISpanHandlerSet", "handle click new aa open detail link error: %s, url: %s", new Object[] { paramg.getMessage(), paramm.url });
            continue;
          }
          AppMethodBeat.o(15631);
          return true;
          if ((paramm.data instanceof String))
          {
            paramg = paramm.data.toString();
          }
          else
          {
            ab.e("MicroMsg.URISpanHandlerSet", "illegal data type, %s", new Object[] { paramm });
            AppMethodBeat.o(15631);
            return true;
          }
        }
      }
      if (paramm.type == 37) {}
      for (;;)
      {
        long l;
        try
        {
          paramg = Uri.parse(paramm.url).getQueryParameter("billno");
          if (bo.isNullOrNil(paramg))
          {
            ab.e("MicroMsg.URISpanHandlerSet", "url error, billno is null");
            AppMethodBeat.o(15631);
            return true;
          }
          if (!(paramm.data instanceof Bundle))
          {
            ab.e("MicroMsg.URISpanHandlerSet", "error data!");
            AppMethodBeat.o(15631);
            return true;
          }
          localObject1 = (Bundle)paramm.data;
          localObject2 = ((Bundle)localObject1).getString("chatroom_name");
          if (bo.isNullOrNil((String)localObject2))
          {
            ab.e("MicroMsg.URISpanHandlerSet", "empty chatroom!");
            AppMethodBeat.o(15631);
            return true;
          }
          l = ((Bundle)localObject1).getLong("msg_id", -1L);
          if (l < 0L)
          {
            ab.e("MicroMsg.URISpanHandlerSet", "msgId is null");
            AppMethodBeat.o(15631);
            return true;
          }
          com.tencent.mm.ui.base.h.a(URISpanHandlerSet.a(URISpanHandlerSet.this), 2131304075, -1, 2131304078, 2131297837, new URISpanHandlerSet.AAUriSpanHandler.1(this, paramg, (String)localObject2, l), null);
        }
        catch (Exception paramg)
        {
          ab.e("MicroMsg.URISpanHandlerSet", "handle click new aa close link error: %s, url: %s", new Object[] { paramg.getMessage(), paramm.url });
          continue;
        }
        AppMethodBeat.o(15631);
        return false;
        if (paramm.type == 36) {
          try
          {
            localObject1 = Uri.parse(paramm.url).getQueryParameter("billno");
            if (bo.isNullOrNil((String)localObject1))
            {
              ab.e("MicroMsg.URISpanHandlerSet", "url error, billno is null");
              AppMethodBeat.o(15631);
              return true;
            }
            paramg = null;
            if ((paramm.data instanceof Bundle)) {
              paramg = (Bundle)paramm.data;
            }
            if ((paramg == null) || (bo.isNullOrNil(paramg.getString("chatroom_name"))))
            {
              ab.e("MicroMsg.URISpanHandlerSet", "empty chatroom!");
              AppMethodBeat.o(15631);
              return true;
            }
            localObject2 = paramg.getString("chatroom_name");
            l = paramg.getLong("msg_id", -1L);
            com.tencent.mm.ui.base.h.a(URISpanHandlerSet.a(URISpanHandlerSet.this), 2131304076, -1, 2131304077, 2131297837, new URISpanHandlerSet.AAUriSpanHandler.2(this, (String)localObject1, (String)localObject2, l), null);
          }
          catch (Exception paramg)
          {
            ab.e("MicroMsg.URISpanHandlerSet", "handle click new aa urge notify link error: %s, url: %s", new Object[] { paramg.getMessage(), paramm.url });
          }
        }
      }
    }
    
    final boolean a(String paramString, boolean paramBoolean, v paramv, Bundle paramBundle)
    {
      return false;
    }
    
    final m dN(String paramString)
    {
      AppMethodBeat.i(15630);
      if (paramString.trim().toLowerCase().startsWith("weixin://weixinnewaa/opendetail"))
      {
        paramString = new m(paramString, 35, null);
        AppMethodBeat.o(15630);
        return paramString;
      }
      if (paramString.trim().toLowerCase().startsWith("weixin://weixinnewaa/closeurgenotify"))
      {
        paramString = new m(paramString, 36, null);
        AppMethodBeat.o(15630);
        return paramString;
      }
      if (paramString.trim().toLowerCase().startsWith("weixin://weixinnewaa/closeaa"))
      {
        paramString = new m(paramString, 37, null);
        AppMethodBeat.o(15630);
        return paramString;
      }
      AppMethodBeat.o(15630);
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
    
    final int[] Cf()
    {
      return new int[] { 32 };
    }
    
    final boolean a(m paramm, g paramg)
    {
      AppMethodBeat.i(15634);
      if (paramm.type == 32)
      {
        paramm = paramm.url.replace("weixin://alphainstall?", "");
        paramg = Uri.parse(paramm).getQueryParameter("md5");
        paramg = com.tencent.mm.compatible.util.e.eQz + paramg + ".apk";
        if (com.tencent.mm.vfs.e.cN(paramg)) {
          bo.l(paramg, ah.getContext());
        }
        for (;;)
        {
          AppMethodBeat.o(15634);
          return true;
          paramg = new Intent();
          paramg.putExtra("rawUrl", paramm.toString());
          d.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "webview", ".ui.tools.WebViewUI", paramg);
        }
      }
      AppMethodBeat.o(15634);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, v paramv, Bundle paramBundle)
    {
      return false;
    }
    
    final m dN(String paramString)
    {
      AppMethodBeat.i(15633);
      if (paramString.trim().toLowerCase().startsWith("weixin://alphainstall?"))
      {
        paramString = new m(paramString, 32, null);
        AppMethodBeat.o(15633);
        return paramString;
      }
      AppMethodBeat.o(15633);
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
    
    final int[] Cf()
    {
      return new int[] { 5 };
    }
    
    final boolean a(m paramm, g paramg)
    {
      AppMethodBeat.i(15637);
      if (paramm.type == 5)
      {
        if (paramg != null) {
          paramg.a(paramm);
        }
        MMWizardActivity.J(URISpanHandlerSet.a(URISpanHandlerSet.this), new Intent(URISpanHandlerSet.a(URISpanHandlerSet.this), BindMContactIntroUI.class));
        if (paramg != null) {
          paramg.b(paramm);
        }
        AppMethodBeat.o(15637);
        return true;
      }
      AppMethodBeat.o(15637);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, v paramv, Bundle paramBundle)
    {
      AppMethodBeat.i(15638);
      if (paramString.equals("weixin://setting/bindphone"))
      {
        paramString = new Intent(URISpanHandlerSet.a(URISpanHandlerSet.this), BindMContactIntroUI.class);
        if ((URISpanHandlerSet.a(URISpanHandlerSet.this) instanceof Service)) {
          paramString.addFlags(268435456);
        }
        MMWizardActivity.J(URISpanHandlerSet.a(URISpanHandlerSet.this), paramString);
        AppMethodBeat.o(15638);
        return true;
      }
      AppMethodBeat.o(15638);
      return false;
    }
    
    final m dN(String paramString)
    {
      AppMethodBeat.i(15636);
      if (paramString.trim().startsWith("weixin://setting/bindphone"))
      {
        paramString = new m(paramString, 5, null);
        AppMethodBeat.o(15636);
        return paramString;
      }
      AppMethodBeat.o(15636);
      return null;
    }
  }
  
  @URISpanHandlerSet.a(Cg=URISpanHandlerSet.PRIORITY.HIGH)
  class LuckyMoneyUriSpanHandler
    extends URISpanHandlerSet.BaseUriSpanHandler
  {
    LuckyMoneyUriSpanHandler()
    {
      super();
    }
    
    final int[] Cf()
    {
      return new int[] { 33 };
    }
    
    final boolean a(m paramm, g paramg)
    {
      AppMethodBeat.i(15677);
      if (paramm.type == 33)
      {
        if (paramg == null)
        {
          ab.i("MicroMsg.URISpanHandlerSet", "LuckyMoneyUriSpanHandler handleSpanClick() clickCallback == null");
          AppMethodBeat.o(15677);
          return false;
        }
        Intent localIntent = new Intent();
        localIntent.putExtra("key_native_url", paramm.url);
        localIntent.putExtra("key_username", (String)paramg.a(paramm));
        localIntent.putExtra("key_lucky_money_can_received", true);
        d.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "luckymoney", ".ui.LuckyMoneyBeforeDetailUI", localIntent);
        com.tencent.mm.plugin.report.service.h.qsU.e(12097, new Object[] { Integer.valueOf(11), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
        com.tencent.mm.plugin.report.service.h.qsU.e(11850, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
        AppMethodBeat.o(15677);
        return true;
      }
      AppMethodBeat.o(15677);
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, v paramv, Bundle paramBundle)
    {
      return false;
    }
    
    final m dN(String paramString)
    {
      AppMethodBeat.i(15676);
      if (paramString.trim().toLowerCase().startsWith("weixin://weixinhongbao/"))
      {
        paramString = new m(paramString, 33, null);
        AppMethodBeat.o(15676);
        return paramString;
      }
      AppMethodBeat.o(15676);
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
    
    final int[] Cf()
    {
      return new int[] { 11 };
    }
    
    final boolean a(m paramm, g paramg)
    {
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, v paramv, Bundle paramBundle)
    {
      return false;
    }
    
    final m dN(String paramString)
    {
      AppMethodBeat.i(15709);
      if (paramString.trim().startsWith("weixin://setting/plugin/sxmsg"))
      {
        paramString = new m(paramString, 11, null);
        AppMethodBeat.o(15709);
        return paramString;
      }
      AppMethodBeat.o(15709);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet
 * JD-Core Version:    0.7.0.1
 */