package com.tencent.mm.app.plugin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R.l;
import com.tencent.mm.model.x;
import com.tencent.mm.model.y;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
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
  
  final boolean a(m paramm, com.tencent.mm.pluginsdk.ui.d.g paramg)
  {
    int k = 0;
    int i = paramm.type;
    x localx;
    if ((i == 23) || (i == 21) || (i == 22) || (i == 2))
    {
      localx = (x)paramm.S(x.class);
      if (paramg != null) {
        paramg.a(paramm);
      }
      if (localx == null) {
        h.b(URISpanHandlerSet.a(this.byk), URISpanHandlerSet.a(this.byk).getString(R.l.link_no_such_group), URISpanHandlerSet.a(this.byk).getString(R.l.app_tip), true);
      }
    }
    else
    {
      return false;
    }
    if (localx.getType().equals("@t.qq.com"))
    {
      if (((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FE().Ic("@t.qq.com") == null) {
        break label397;
      }
      i = 1;
      if (i == 0) {
        h.b(URISpanHandlerSet.a(this.byk), URISpanHandlerSet.a(this.byk).getString(R.l.link_no_such_group), URISpanHandlerSet.a(this.byk).getString(R.l.app_tip), true);
      }
    }
    Object localObject;
    int j;
    if (localx.getType().equals("@domain.android"))
    {
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FE().big();
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
          h.b(URISpanHandlerSet.a(this.byk), URISpanHandlerSet.a(this.byk).getString(R.l.link_no_such_group), URISpanHandlerSet.a(this.byk).getString(R.l.app_tip), true);
        }
        localObject = new Intent();
        ((Intent)localObject).setClass(URISpanHandlerSet.a(this.byk), SelectContactUI.class);
        ((Intent)localObject).putExtra("Contact_GroupFilter_Type", localx.getType()).putExtra("Contact_GroupFilter_Str", localx.Hd()).putExtra("Contact_GroupFilter_DisplayName", localx.Bp());
        ((Intent)localObject).addFlags(268435456);
        URISpanHandlerSet.a(this.byk).startActivity((Intent)localObject);
        if (paramg != null) {
          paramg.b(paramm);
        }
        return true;
        label397:
        i = 0;
        break;
      }
      i += 1;
    }
  }
  
  final boolean a(String paramString, boolean paramBoolean, s params, Bundle paramBundle)
  {
    if ((paramString.equals("weixin://contacts/microblog/")) || (paramString.equals("weixin://contacts/micromessenger/")) || (paramString.equals("weixin://contacts/all/")))
    {
      params = y.im(URISpanHandlerSet.a(this.byk).getString(R.l.group_weixin));
      if (paramString.equals("weixin://contacts/microblog/")) {
        params = y.im(URISpanHandlerSet.a(this.byk).getString(R.l.group_weibo));
      }
      if (paramString.equals("weixin://contacts/micromessenger/")) {
        params = y.im(URISpanHandlerSet.a(this.byk).getString(R.l.group_weixin));
      }
      if (paramString.equals("weixin://contacts/all/")) {
        params = y.im(URISpanHandlerSet.a(this.byk).getString(R.l.group_all));
      }
      paramString = new Intent();
      paramString.setClass(URISpanHandlerSet.a(this.byk), SelectContactUI.class);
      paramString.putExtra("Contact_GroupFilter_Type", params.getType()).putExtra("Contact_GroupFilter_Str", params.Hd()).putExtra("Contact_GroupFilter_DisplayName", params.Bp());
      paramString.addFlags(268435456);
      return true;
    }
    return false;
  }
  
  final m cA(String paramString)
  {
    Object localObject2 = null;
    if (paramString.trim().equals("weixin://contacts/all/")) {
      localObject1 = new m(paramString, 23, new x("@all.android", null, URISpanHandlerSet.a(this.byk).getString(R.l.group_all), null, true, true));
    }
    String str;
    int i;
    do
    {
      do
      {
        return localObject1;
        if (paramString.trim().equals("weixin://contacts/microblog/")) {
          return new m(paramString, 22, y.im(URISpanHandlerSet.a(this.byk).getString(R.l.group_weibo)));
        }
        if (paramString.trim().equals("weixin://contacts/micromessenger/")) {
          return new m(paramString, 2, new x("@micromsg.qq.com", null, URISpanHandlerSet.a(this.byk).getString(R.l.group_weixin), null, true, true));
        }
        localObject1 = localObject2;
      } while (!paramString.trim().startsWith("weixin://contacts/"));
      str = paramString.trim().substring(0, paramString.trim().length() - 1);
      i = str.lastIndexOf("/");
      localObject1 = localObject2;
    } while (i == -1);
    Object localObject1 = str.substring(i + 1);
    return new m(paramString, 21, y.T("@" + (String)localObject1, URISpanHandlerSet.a(this.byk).getString(R.l.group_domainmail_suffix)));
  }
  
  final int[] tA()
  {
    return new int[] { 23, 21, 22, 2 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.ContactUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */