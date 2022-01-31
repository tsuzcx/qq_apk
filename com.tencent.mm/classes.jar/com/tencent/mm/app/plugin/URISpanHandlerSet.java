package com.tencent.mm.app.plugin;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.p;
import com.tencent.mm.br.d;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.model.au;
import com.tencent.mm.model.t;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.setting.model.j;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.appbrand.b;
import com.tencent.mm.ui.base.h;

class URISpanHandlerSet
{
  Context mContext = null;
  
  public URISpanHandlerSet(Context paramContext)
  {
    if (paramContext == null) {}
    for (paramContext = ae.getContext();; paramContext = this.mContext)
    {
      this.mContext = paramContext;
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
    
    final boolean a(m paramm, g paramg)
    {
      Object localObject1;
      Object localObject2;
      if (paramm.type == 35)
      {
        try
        {
          localObject1 = Uri.parse(paramm.url).getQueryParameter("billno");
          if (bk.bl((String)localObject1))
          {
            com.tencent.mm.sdk.platformtools.y.e("MicroMsg.URISpanHandlerSet", "url error, billno is null");
            return true;
          }
          if ((paramm.data instanceof Bundle)) {}
          for (paramg = ((Bundle)paramm.data).getString("chatroom_name");; paramg = paramm.data.toString())
          {
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("bill_no", (String)localObject1);
            ((Intent)localObject2).putExtra("enter_scene", 3);
            ((Intent)localObject2).putExtra("chatroom", paramg);
            d.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "aa", ".ui.PaylistAAUI", (Intent)localObject2);
            break label539;
            if (!(paramm.data instanceof String)) {
              break;
            }
          }
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.URISpanHandlerSet", "illegal data type, %s", new Object[] { paramm });
          return true;
        }
        catch (Exception paramg)
        {
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.URISpanHandlerSet", "handle click new aa open detail link error: %s, url: %s", new Object[] { paramg.getMessage(), paramm.url });
        }
      }
      else
      {
        if (paramm.type == 37) {}
        for (;;)
        {
          long l;
          try
          {
            paramg = Uri.parse(paramm.url).getQueryParameter("billno");
            if (bk.bl(paramg))
            {
              com.tencent.mm.sdk.platformtools.y.e("MicroMsg.URISpanHandlerSet", "url error, billno is null");
              return true;
            }
            if (!(paramm.data instanceof Bundle))
            {
              com.tencent.mm.sdk.platformtools.y.e("MicroMsg.URISpanHandlerSet", "error data!");
              return true;
            }
            localObject1 = (Bundle)paramm.data;
            localObject2 = ((Bundle)localObject1).getString("chatroom_name");
            if (bk.bl((String)localObject2))
            {
              com.tencent.mm.sdk.platformtools.y.e("MicroMsg.URISpanHandlerSet", "empty chatroom!");
              return true;
            }
            l = ((Bundle)localObject1).getLong("msg_id", -1L);
            if (l < 0L)
            {
              com.tencent.mm.sdk.platformtools.y.e("MicroMsg.URISpanHandlerSet", "msgId is null");
              return true;
            }
            h.a(URISpanHandlerSet.a(URISpanHandlerSet.this), R.l.span_aa_close_confirm, -1, R.l.span_aa_close_wording, R.l.cancel, new URISpanHandlerSet.AAUriSpanHandler.1(this, paramg, (String)localObject2, l), null);
          }
          catch (Exception paramg)
          {
            com.tencent.mm.sdk.platformtools.y.e("MicroMsg.URISpanHandlerSet", "handle click new aa close link error: %s, url: %s", new Object[] { paramg.getMessage(), paramm.url });
            continue;
          }
          return false;
          if (paramm.type == 36) {
            try
            {
              localObject1 = Uri.parse(paramm.url).getQueryParameter("billno");
              if (bk.bl((String)localObject1))
              {
                com.tencent.mm.sdk.platformtools.y.e("MicroMsg.URISpanHandlerSet", "url error, billno is null");
                return true;
              }
              paramg = null;
              if ((paramm.data instanceof Bundle)) {
                paramg = (Bundle)paramm.data;
              }
              if ((paramg == null) || (bk.bl(paramg.getString("chatroom_name"))))
              {
                com.tencent.mm.sdk.platformtools.y.e("MicroMsg.URISpanHandlerSet", "empty chatroom!");
                return true;
              }
              localObject2 = paramg.getString("chatroom_name");
              l = paramg.getLong("msg_id", -1L);
              h.a(URISpanHandlerSet.a(URISpanHandlerSet.this), R.l.span_aa_close_urge_notify_confirm, -1, R.l.span_aa_close_urge_notify_wording, R.l.cancel, new URISpanHandlerSet.AAUriSpanHandler.2(this, (String)localObject1, (String)localObject2, l), null);
            }
            catch (Exception paramg)
            {
              com.tencent.mm.sdk.platformtools.y.e("MicroMsg.URISpanHandlerSet", "handle click new aa urge notify link error: %s, url: %s", new Object[] { paramg.getMessage(), paramm.url });
            }
          }
        }
      }
      label539:
      return true;
    }
    
    final boolean a(String paramString, boolean paramBoolean, s params, Bundle paramBundle)
    {
      return false;
    }
    
    final m cA(String paramString)
    {
      if (paramString.trim().toLowerCase().startsWith("weixin://weixinnewaa/opendetail")) {
        return new m(paramString, 35, null);
      }
      if (paramString.trim().toLowerCase().startsWith("weixin://weixinnewaa/closeurgenotify")) {
        return new m(paramString, 36, null);
      }
      if (paramString.trim().toLowerCase().startsWith("weixin://weixinnewaa/closeaa")) {
        return new m(paramString, 37, null);
      }
      return null;
    }
    
    final int[] tA()
    {
      return new int[] { 35, 36, 37 };
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
    
    final boolean a(m paramm, g paramg)
    {
      if (paramm.type == 34)
      {
        paramg = paramm.url.trim().replace("weixin://feedback/next/", "");
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.URISpanHandlerSet", "FeedbackUriSpanHandler, url:%s, content:%s", new Object[] { paramm.url, paramg });
        au.Dk().a(new j(q.zv(), paramg, 8), 0);
        return true;
      }
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, s params, Bundle paramBundle)
    {
      return false;
    }
    
    final m cA(String paramString)
    {
      if (paramString.trim().startsWith("weixin://feedback/next/")) {
        return new m(paramString, 34, null);
      }
      return null;
    }
    
    final int[] tA()
    {
      return new int[] { 34 };
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
    
    final boolean a(m paramm, g paramg)
    {
      Object localObject1;
      if (paramm.type == 1)
      {
        paramm.S(x.class);
        localObject1 = com.tencent.mm.model.y.T("@" + paramm.url, URISpanHandlerSet.a(URISpanHandlerSet.this).getString(R.l.group_domainmail_suffix));
        if (paramg == null) {
          break label381;
        }
      }
      label376:
      label381:
      for (String str1 = (String)paramg.a(paramm);; str1 = null)
      {
        Object localObject2;
        if ((localObject1 == null) || (!((x)localObject1).bIU))
        {
          localObject2 = paramm.url;
          localObject1 = localObject2;
          if (!((String)localObject2).toLowerCase().startsWith("http")) {
            localObject1 = "http://" + (String)localObject2;
          }
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("rawUrl", (String)localObject1);
          if ((paramm.data != null) && ((paramm.data instanceof Integer))) {
            ((Intent)localObject2).putExtra("geta8key_scene", ((Integer)paramm.data).intValue());
          }
          localObject1 = paramm.fKV;
          if (!bk.bl((String)localObject1))
          {
            Object localObject3 = u.Hc().ii((String)localObject1);
            if (localObject3 != null)
            {
              String str2 = ((u.b)localObject3).getString("prePublishId", null);
              String str3 = ((u.b)localObject3).getString("preUsername", null);
              localObject3 = ((u.b)localObject3).getString("preChatName", null);
              ((Intent)localObject2).putExtra("reportSessionId", (String)localObject1);
              ((Intent)localObject2).putExtra("KPublisherId", str2);
              ((Intent)localObject2).putExtra("geta8key_username", (String)localObject3);
              ((Intent)localObject2).putExtra("pre_username", str3);
              ((Intent)localObject2).putExtra("prePublishId", str2);
              ((Intent)localObject2).putExtra("preUsername", str3);
              ((Intent)localObject2).putExtra("preChatName", (String)localObject3);
              ((Intent)localObject2).putExtra("preChatTYPE", t.R(str3, (String)localObject3));
            }
          }
          if (!bk.bl(str1)) {
            break label376;
          }
          str1 = null;
        }
        for (;;)
        {
          ((Intent)localObject2).putExtra("geta8key_username", str1);
          ((Intent)localObject2).addFlags(536870912);
          d.b(URISpanHandlerSet.a(URISpanHandlerSet.this), "webview", ".ui.tools.WebViewUI", (Intent)localObject2);
          if (paramg != null) {
            paramg.b(paramm);
          }
          return true;
        }
        return false;
      }
    }
    
    final boolean a(String paramString, boolean paramBoolean, s params, Bundle paramBundle)
    {
      return false;
    }
    
    final m cA(String paramString)
    {
      if (paramString.trim().toLowerCase().startsWith("http")) {
        return new m(paramString, 1, null);
      }
      return null;
    }
    
    final int[] tA()
    {
      return new int[] { 1 };
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
    
    final boolean a(m paramm, g paramg)
    {
      return false;
    }
    
    final boolean a(String paramString, boolean paramBoolean, s params, Bundle paramBundle)
    {
      return false;
    }
    
    final m cA(String paramString)
    {
      if (paramString.trim().startsWith("weixin://setting/plugin/qqmsg")) {
        return new m(paramString, 13, null);
      }
      return null;
    }
    
    final int[] tA()
    {
      return new int[] { 13 };
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet
 * JD-Core Version:    0.7.0.1
 */