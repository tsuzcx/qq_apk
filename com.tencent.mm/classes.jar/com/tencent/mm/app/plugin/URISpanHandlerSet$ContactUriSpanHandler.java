package com.tencent.mm.app.plugin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.model.ah;
import com.tencent.mm.model.ai;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.span.i;
import com.tencent.mm.storage.cj;
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
  
  final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami)
  {
    AppMethodBeat.i(280359);
    int i = paramu.type;
    if ((i == 23) || (i == 21) || (i == 22) || (i == 2))
    {
      paramView = (ah)paramu.bv(ah.class);
      if (parami != null) {
        parami.a(paramu);
      }
      if (paramView == null)
      {
        com.tencent.mm.ui.base.h.c(URISpanHandlerSet.a(this.fgB), URISpanHandlerSet.a(this.fgB).getString(R.l.eKM), URISpanHandlerSet.a(this.fgB).getString(R.l.app_tip), true);
        AppMethodBeat.o(280359);
        return false;
      }
      if (paramView.getType().equals("@t.qq.com"))
      {
        if (((n)com.tencent.mm.kernel.h.ae(n.class)).bbU().aPi("@t.qq.com") == null) {
          break label464;
        }
        i = 1;
        if (i == 0) {
          com.tencent.mm.ui.base.h.c(URISpanHandlerSet.a(this.fgB), URISpanHandlerSet.a(this.fgB).getString(R.l.eKM), URISpanHandlerSet.a(this.fgB).getString(R.l.app_tip), true);
        }
      }
      Object localObject;
      if (paramView.getType().equals("@domain.android"))
      {
        localObject = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbU().eSy();
        if (((List)localObject).size() <= 0) {
          break label479;
        }
        i = 0;
        label235:
        if (i >= ((List)localObject).size()) {
          break label479;
        }
        if (!((cj)((List)localObject).get(i)).isEnable()) {
          break label470;
        }
      }
      label464:
      label470:
      label479:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          com.tencent.mm.ui.base.h.c(URISpanHandlerSet.a(this.fgB), URISpanHandlerSet.a(this.fgB).getString(R.l.eKM), URISpanHandlerSet.a(this.fgB).getString(R.l.app_tip), true);
        }
        localObject = new Intent();
        ((Intent)localObject).setClass(URISpanHandlerSet.a(this.fgB), SelectContactUI.class);
        ((Intent)localObject).putExtra("Contact_GroupFilter_Type", paramView.getType()).putExtra("Contact_GroupFilter_Str", paramView.bem()).putExtra("Contact_GroupFilter_DisplayName", paramView.ayr());
        ((Intent)localObject).addFlags(268435456);
        paramView = URISpanHandlerSet.a(this.fgB);
        localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/app/plugin/URISpanHandlerSet$ContactUriSpanHandler", "handleSpanClick", "(Landroid/view/View;Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/app/plugin/URISpanHandlerSet$ContactUriSpanHandler", "handleSpanClick", "(Landroid/view/View;Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        if (parami != null) {
          parami.b(paramu);
        }
        AppMethodBeat.o(280359);
        return true;
        i = 0;
        break;
        i += 1;
        break label235;
      }
    }
    AppMethodBeat.o(280359);
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
  {
    AppMethodBeat.i(19689);
    if ((paramString.equals("weixin://contacts/microblog/")) || (paramString.equals("weixin://contacts/micromessenger/")) || (paramString.equals("weixin://contacts/all/")))
    {
      paramu = ai.Ru(URISpanHandlerSet.a(this.fgB).getString(R.l.eGu));
      if (paramString.equals("weixin://contacts/microblog/")) {
        paramu = ai.Ru(URISpanHandlerSet.a(this.fgB).getString(R.l.eGt));
      }
      if (paramString.equals("weixin://contacts/micromessenger/")) {
        paramu = ai.Ru(URISpanHandlerSet.a(this.fgB).getString(R.l.eGu));
      }
      if (paramString.equals("weixin://contacts/all/")) {
        paramu = ai.Ru(URISpanHandlerSet.a(this.fgB).getString(R.l.eGj));
      }
      paramString = new Intent();
      paramString.setClass(URISpanHandlerSet.a(this.fgB), SelectContactUI.class);
      paramString.putExtra("Contact_GroupFilter_Type", paramu.getType()).putExtra("Contact_GroupFilter_Str", paramu.bem()).putExtra("Contact_GroupFilter_DisplayName", paramu.ayr());
      paramString.addFlags(268435456);
      AppMethodBeat.o(19689);
      return true;
    }
    AppMethodBeat.o(19689);
    return false;
  }
  
  final int[] abR()
  {
    return new int[] { 23, 21, 22, 2 };
  }
  
  final com.tencent.mm.pluginsdk.ui.applet.u hi(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(19687);
    if (paramString.trim().equals("weixin://contacts/all/")) {
      localObject = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 23, new ah("@all.android", null, URISpanHandlerSet.a(this.fgB).getString(R.l.eGj), null, true, true));
    }
    for (;;)
    {
      AppMethodBeat.o(19687);
      return localObject;
      if (paramString.trim().equals("weixin://contacts/microblog/"))
      {
        localObject = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 22, ai.Ru(URISpanHandlerSet.a(this.fgB).getString(R.l.eGt)));
      }
      else if (paramString.trim().equals("weixin://contacts/micromessenger/"))
      {
        localObject = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 2, new ah("@micromsg.qq.com", null, URISpanHandlerSet.a(this.fgB).getString(R.l.eGu), null, true, true));
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
        localObject = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 21, ai.aR("@".concat(String.valueOf(((String)localObject).substring(i + 1))), URISpanHandlerSet.a(this.fgB).getString(R.l.eGk)));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.ContactUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */