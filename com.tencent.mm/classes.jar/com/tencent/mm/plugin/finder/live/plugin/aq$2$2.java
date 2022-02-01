package com.tencent.mm.plugin.finder.live.plugin;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.finder.live.model.ak;
import com.tencent.mm.plugin.finder.live.model.ao;
import com.tencent.mm.plugin.finder.live.model.cgi.al;
import com.tencent.mm.plugin.finder.live.model.q;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.s;
import com.tencent.mm.plugin.finder.live.report.s.al;
import com.tencent.mm.plugin.finder.live.report.s.c;
import com.tencent.mm.plugin.finder.live.report.u;
import com.tencent.mm.plugin.finder.view.j;
import com.tencent.mm.protocal.protobuf.axe;
import com.tencent.mm.protocal.protobuf.bbd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.q.g;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
final class aq$2$2
  implements q.g
{
  aq$2$2(aq.2 param2, ao paramao, String paramString, View paramView) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(272619);
    p.j(paramMenuItem, "menuItem");
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      this.kqJ.setBackground(aq.f(this.yoS.yoR));
      paramMenuItem = j.AYq;
      j.eiN();
      AppMethodBeat.o(272619);
      return;
      paramMenuItem = this.yoT.dye();
      if (paramMenuItem != null)
      {
        aq.a(this.yoS.yoR, paramMenuItem);
        continue;
        if (this.yoT.getType() == 1)
        {
          paramMenuItem = this.yoT;
          if (paramMenuItem == null)
          {
            paramMenuItem = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.model.FinderLiveTextMsg");
            AppMethodBeat.o(272619);
            throw paramMenuItem;
          }
          paramMenuItem = ((ak)paramMenuItem).yig;
        }
        while (paramMenuItem != null)
        {
          localObject = new Bundle();
          ((Bundle)localObject).putByteArray("PARAM_FINDER_LIVE_TOP_COMMENT", paramMenuItem.toByteArray());
          aq.g(this.yoS.yoR).statusChange(b.c.kAH, (Bundle)localObject);
          new al(this.yoS.yoR.getBuContext(), paramMenuItem).bhW();
          localObject = this.yoS.yoR;
          p.k(paramMenuItem, "msg");
          if (((aq)localObject).kCL.getLiveRole() != 1) {
            break;
          }
          localObject = new i();
          ((i)localObject).g("content", paramMenuItem.content);
          ((i)localObject).al("msgtype", paramMenuItem.type);
          paramMenuItem = k.yBj;
          k.a(s.c.yEr, ((i)localObject).toString());
          break;
          if (this.yoT.getType() == 20002)
          {
            paramMenuItem = this.yoT;
            if (paramMenuItem == null)
            {
              paramMenuItem = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.model.FinderLiveInteractiveMsg");
              AppMethodBeat.o(272619);
              throw paramMenuItem;
            }
            localObject = (q)paramMenuItem;
            paramMenuItem = new bbd();
            paramMenuItem.nickname = ((q)localObject).dyd();
            paramMenuItem.content = ((q)localObject).getContent();
            paramMenuItem.type = 1;
            paramMenuItem.username = ((q)localObject).cGy();
            paramMenuItem.seq = ((q)localObject).yet.seq;
            paramMenuItem.ilo = ((q)localObject).yet.SJs;
            paramMenuItem.zeL = ((q)localObject).yet.SJH;
            paramMenuItem.SMO = ((q)localObject).yet.SJC;
            paramMenuItem.SMN = ((q)localObject).yet.SJI;
          }
          else
          {
            paramMenuItem = null;
          }
        }
        paramMenuItem = new Bundle();
        paramMenuItem.putString("PARAM_MEMBERS_PROFILE_USERNAME", this.yoT.cGy());
        paramMenuItem.putInt("PARAM_MEMBERS_PROFILE_SOURCE_TYPE", 2);
        aq.g(this.yoS.yoR).statusChange(b.c.kzF, paramMenuItem);
        continue;
        Object localObject = (Boolean)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.yoS.yoR.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfs.get(this.kyF);
        paramMenuItem = (MenuItem)localObject;
        if (localObject == null) {
          paramMenuItem = Boolean.FALSE;
        }
        p.j(paramMenuItem, "business(LiveCommonSlice…cheMap[username] ?: false");
        boolean bool = paramMenuItem.booleanValue();
        Log.i("Finder.LiveCommentPlugin", "LONGCLICK_MENU_FINDER_LIVE_ANCHOR_BAN username:" + this.kyF + " disableComment:" + bool);
        localObject = this.kyF;
        if (localObject != null)
        {
          aq.a(this.yoS.yoR, bool, (String)localObject);
          if (aq.g(this.yoS.yoR).getLiveRole() == 1)
          {
            paramMenuItem = k.yBj;
            paramMenuItem = k.dDm().yDw;
            paramMenuItem.yNE += 1L;
            JSONObject localJSONObject = new JSONObject();
            paramInt = s.al.yJh.action;
            paramMenuItem = (MenuItem)localObject;
            if (localObject == null) {
              paramMenuItem = "";
            }
            localJSONObject.put(String.valueOf(paramInt), paramMenuItem);
            paramMenuItem = s.c.yEm;
            localObject = k.yBj;
            if (k.dDm().yDz) {
              paramMenuItem = s.c.yEo;
            }
            localObject = k.yBj;
            k.a(paramMenuItem, localJSONObject.toString());
            continue;
            aq.a(this.yoS.yoR, this.kyF);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.aq.2.2
 * JD-Core Version:    0.7.0.1
 */