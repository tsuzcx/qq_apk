package com.tencent.mm.plugin.finder.live.plugin;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.live.model.ao;
import com.tencent.mm.plugin.finder.live.report.m;
import com.tencent.mm.plugin.finder.live.report.s.bf;
import com.tencent.mm.plugin.finder.live.report.s.m;
import com.tencent.mm.plugin.finder.view.j;
import com.tencent.mm.protocal.protobuf.aza;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.base.w.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
final class aq$2$5
  implements q.g
{
  aq$2$5(aq.2 param2, ao paramao, View paramView) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(252663);
    p.j(paramMenuItem, "menuItem");
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      this.kqJ.setBackground(aq.f(this.yoS.yoR));
      paramMenuItem = j.AYq;
      j.eiN();
      AppMethodBeat.o(252663);
      return;
      Log.i("Finder.LiveCommentPlugin", "[LONGCLICK_MENU_FINDER_LIVE_REPLY],riskControlEnableComment:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.yoS.yoR.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfb + ",enableLiveRoomComment:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.yoS.yoR.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfd + ", enableCustomerComment:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.yoS.yoR.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfc);
      if ((((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.yoS.yoR.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfb) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.yoS.yoR.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfd) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.yoS.yoR.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfc))
      {
        localObject = new Bundle();
        ((Bundle)localObject).putBoolean("PARAM_IS_ENTERING_COMMENT", true);
        paramMenuItem = this.yoT.dye();
        if (paramMenuItem != null) {}
        for (paramMenuItem = paramMenuItem.toByteArray();; paramMenuItem = null)
        {
          ((Bundle)localObject).putByteArray("PARAM_ENTER_COMMENT_AT_NAME", paramMenuItem);
          aq.g(this.yoS.yoR).statusChange(b.c.kzy, (Bundle)localObject);
          break;
        }
      }
      paramMenuItem = this.yoS.kCW.getContext();
      Object localObject = MMApplicationContext.getContext();
      p.j(localObject, "MMApplicationContext.getContext()");
      w.a(paramMenuItem, ((Context)localObject).getResources().getString(b.j.finder_live_reply_disable_comment), (w.b)1.yoW);
      continue;
      paramMenuItem = MMApplicationContext.getContext().getSystemService("clipboard");
      if (paramMenuItem == null)
      {
        paramMenuItem = new t("null cannot be cast to non-null type android.content.ClipboardManager");
        AppMethodBeat.o(252663);
        throw paramMenuItem;
      }
      ((ClipboardManager)paramMenuItem).setText((CharSequence)this.yoT.getContent());
      if (aq.g(this.yoS.yoR).getLiveRole() == 0)
      {
        paramMenuItem = m.yCt;
        m.a(s.bf.yLh, null);
        continue;
        aq.b(this.yoS.yoR, this.yoT.cGy());
        continue;
        aq.a(this.yoS.yoR, this.yoT);
        if (aq.g(this.yoS.yoR).getLiveRole() == 0)
        {
          paramMenuItem = m.yCt;
          localObject = this.yoT.cGy();
          s.m localm = s.m.yGh;
          p.k(localm, "source");
          JSONObject localJSONObject = new JSONObject();
          paramMenuItem = (MenuItem)localObject;
          if (localObject == null) {
            paramMenuItem = "";
          }
          localJSONObject.put("username", paramMenuItem);
          localJSONObject.put("source", localm.source);
          m.a(s.bf.yLb, localJSONObject.toString());
          m.yBE += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.aq.2.5
 * JD-Core Version:    0.7.0.1
 */