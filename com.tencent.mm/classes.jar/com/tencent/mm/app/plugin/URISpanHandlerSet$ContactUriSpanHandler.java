package com.tencent.mm.app.plugin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ah;
import com.tencent.mm.model.ai;
import com.tencent.mm.pluginsdk.ui.span.i;
import com.tencent.mm.storage.ci;
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
  
  final int[] Xp()
  {
    return new int[] { 23, 21, 22, 2 };
  }
  
  final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami)
  {
    AppMethodBeat.i(231421);
    int i = paramu.type;
    if ((i == 23) || (i == 21) || (i == 22) || (i == 2))
    {
      paramView = (ah)paramu.ba(ah.class);
      if (parami != null) {
        parami.a(paramu);
      }
      if (paramView == null)
      {
        h.c(URISpanHandlerSet.a(this.dnW), URISpanHandlerSet.a(this.dnW).getString(2131762223), URISpanHandlerSet.a(this.dnW).getString(2131755998), true);
        AppMethodBeat.o(231421);
        return false;
      }
      if (paramView.getType().equals("@t.qq.com"))
      {
        if (((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSW().aEY("@t.qq.com") == null) {
          break label458;
        }
        i = 1;
        if (i == 0) {
          h.c(URISpanHandlerSet.a(this.dnW), URISpanHandlerSet.a(this.dnW).getString(2131762223), URISpanHandlerSet.a(this.dnW).getString(2131755998), true);
        }
      }
      Object localObject;
      if (paramView.getType().equals("@domain.android"))
      {
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSW().eiS();
        if (((List)localObject).size() <= 0) {
          break label473;
        }
        i = 0;
        label231:
        if (i >= ((List)localObject).size()) {
          break label473;
        }
        if (!((ci)((List)localObject).get(i)).isEnable()) {
          break label464;
        }
      }
      label458:
      label464:
      label473:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          h.c(URISpanHandlerSet.a(this.dnW), URISpanHandlerSet.a(this.dnW).getString(2131762223), URISpanHandlerSet.a(this.dnW).getString(2131755998), true);
        }
        localObject = new Intent();
        ((Intent)localObject).setClass(URISpanHandlerSet.a(this.dnW), SelectContactUI.class);
        ((Intent)localObject).putExtra("Contact_GroupFilter_Type", paramView.getType()).putExtra("Contact_GroupFilter_Str", paramView.aVj()).putExtra("Contact_GroupFilter_DisplayName", paramView.arI());
        ((Intent)localObject).addFlags(268435456);
        paramView = URISpanHandlerSet.a(this.dnW);
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/app/plugin/URISpanHandlerSet$ContactUriSpanHandler", "handleSpanClick", "(Landroid/view/View;Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/app/plugin/URISpanHandlerSet$ContactUriSpanHandler", "handleSpanClick", "(Landroid/view/View;Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        if (parami != null) {
          parami.b(paramu);
        }
        AppMethodBeat.o(231421);
        return true;
        i = 0;
        break;
        i += 1;
        break label231;
      }
    }
    AppMethodBeat.o(231421);
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
  {
    AppMethodBeat.i(19689);
    if ((paramString.equals("weixin://contacts/microblog/")) || (paramString.equals("weixin://contacts/micromessenger/")) || (paramString.equals("weixin://contacts/all/")))
    {
      paramu = ai.Kc(URISpanHandlerSet.a(this.dnW).getString(2131761515));
      if (paramString.equals("weixin://contacts/microblog/")) {
        paramu = ai.Kc(URISpanHandlerSet.a(this.dnW).getString(2131761514));
      }
      if (paramString.equals("weixin://contacts/micromessenger/")) {
        paramu = ai.Kc(URISpanHandlerSet.a(this.dnW).getString(2131761515));
      }
      if (paramString.equals("weixin://contacts/all/")) {
        paramu = ai.Kc(URISpanHandlerSet.a(this.dnW).getString(2131761462));
      }
      paramString = new Intent();
      paramString.setClass(URISpanHandlerSet.a(this.dnW), SelectContactUI.class);
      paramString.putExtra("Contact_GroupFilter_Type", paramu.getType()).putExtra("Contact_GroupFilter_Str", paramu.aVj()).putExtra("Contact_GroupFilter_DisplayName", paramu.arI());
      paramString.addFlags(268435456);
      AppMethodBeat.o(19689);
      return true;
    }
    AppMethodBeat.o(19689);
    return false;
  }
  
  final com.tencent.mm.pluginsdk.ui.applet.u gx(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(19687);
    if (paramString.trim().equals("weixin://contacts/all/")) {
      localObject = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 23, new ah("@all.android", null, URISpanHandlerSet.a(this.dnW).getString(2131761462), null, true, true));
    }
    for (;;)
    {
      AppMethodBeat.o(19687);
      return localObject;
      if (paramString.trim().equals("weixin://contacts/microblog/"))
      {
        localObject = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 22, ai.Kc(URISpanHandlerSet.a(this.dnW).getString(2131761514)));
      }
      else if (paramString.trim().equals("weixin://contacts/micromessenger/"))
      {
        localObject = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 2, new ah("@micromsg.qq.com", null, URISpanHandlerSet.a(this.dnW).getString(2131761515), null, true, true));
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
        localObject = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 21, ai.aN("@".concat(String.valueOf(((String)localObject).substring(i + 1))), URISpanHandlerSet.a(this.dnW).getString(2131761464)));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.ContactUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */