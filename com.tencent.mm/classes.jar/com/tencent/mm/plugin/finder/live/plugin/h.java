package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.plugin.finder.live.widget.c;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.au;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorBottomOptionPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "linkMicWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMicEntranceWidget;", "lotteryWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorLotteryEntranceWidget;", "shoppingWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorShoppingEntranceWidget;", "canClearScreen", "", "checkLinkMicGroupState", "", "checkOptionsVisible", "hideOption", "option", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onPortraitAction", "extraMsg", "Landroid/os/Bundle;", "shoppingEntranceView", "showOption", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "updateApplyLinkInfo", "Companion", "plugin-finder_release"})
public final class h
  extends d
{
  private static final int ums = 1;
  private static final int umt = 2;
  public static final a umu;
  private final String TAG;
  private final com.tencent.mm.live.c.b hOp;
  public final c ump;
  private final com.tencent.mm.plugin.finder.live.widget.b umq;
  private final com.tencent.mm.plugin.finder.live.widget.a umr;
  
  static
  {
    AppMethodBeat.i(246421);
    umu = new a((byte)0);
    ums = 1;
    umt = 2;
    AppMethodBeat.o(246421);
  }
  
  public h(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(246420);
    this.hOp = paramb;
    this.TAG = "Finder.FinderLiveAnchorBottomOptionPlugin";
    paramb = paramViewGroup.findViewById(2131307850);
    p.g(paramb, "root.findViewById(R.id.s…pping_entrance_container)");
    this.ump = new c((ViewGroup)paramb, this.hOp, (d)this);
    paramb = paramViewGroup.findViewById(2131303215);
    p.g(paramb, "root.findViewById(R.id.link_entrance_container)");
    this.umq = new com.tencent.mm.plugin.finder.live.widget.b((ViewGroup)paramb, this.hOp, (d)this);
    paramb = paramViewGroup.findViewById(2131303852);
    p.g(paramb, "root.findViewById(R.id.lottery_entrance_container)");
    this.umr = new com.tencent.mm.plugin.finder.live.widget.a((ViewGroup)paramb, this.hOp, (d)this);
    if (!isLandscape()) {
      paramViewGroup.post((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(246411);
          Object localObject = this.hOA.getLayoutParams();
          if (localObject == null)
          {
            localObject = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(246411);
            throw ((Throwable)localObject);
          }
          localObject = (ViewGroup.MarginLayoutParams)localObject;
          ((ViewGroup.MarginLayoutParams)localObject).bottomMargin += au.aD(this.hOA.getContext());
          AppMethodBeat.o(246411);
        }
      });
    }
    AppMethodBeat.o(246420);
  }
  
  public final void ai(Bundle paramBundle)
  {
    AppMethodBeat.i(246418);
    com.tencent.mm.plugin.finder.live.widget.a locala = this.umr;
    if (paramBundle != null)
    {
      String str = paramBundle.getString("POST_PORTRAIT_ACTION", "");
      paramBundle = str;
      if (str != null) {}
    }
    else
    {
      paramBundle = "";
    }
    if (p.j(paramBundle, com.tencent.mm.plugin.finder.live.widget.a.uFx)) {
      locala.djt();
    }
    AppMethodBeat.o(246418);
  }
  
  public final boolean dgK()
  {
    return true;
  }
  
  public final void dgN()
  {
    int j = 1;
    AppMethodBeat.i(246414);
    Object localObject = this.ump;
    if (((c)localObject).uFw.getLiveData().uit)
    {
      ((c)localObject).rg(0);
      this.umq.dju();
      localObject = this.umr;
      if (!((com.tencent.mm.plugin.finder.live.widget.a)localObject).uFw.getLiveData().uEe) {
        break label169;
      }
      ((com.tencent.mm.plugin.finder.live.widget.a)localObject).rg(0);
      label60:
      Log.i(((com.tencent.mm.plugin.finder.live.widget.a)localObject).TAG, "checkVisible:" + ((com.tencent.mm.plugin.finder.live.widget.a)localObject).uFw.getLiveData().uEe);
      if (this.ump.hwr.getVisibility() != 0) {
        break label178;
      }
      i = 1;
      label107:
      if (i == 0)
      {
        if (this.umq.hwr.getVisibility() != 0) {
          break label183;
        }
        i = 1;
        label126:
        if (i == 0) {
          if (this.umr.hwr.getVisibility() != 0) {
            break label188;
          }
        }
      }
    }
    label169:
    label178:
    label183:
    label188:
    for (int i = j;; i = 0)
    {
      if (i == 0) {
        break label193;
      }
      rg(0);
      AppMethodBeat.o(246414);
      return;
      ((c)localObject).rg(8);
      break;
      ((com.tencent.mm.plugin.finder.live.widget.a)localObject).rg(8);
      break label60;
      i = 0;
      break label107;
      i = 0;
      break label126;
    }
    label193:
    rg(8);
    AppMethodBeat.o(246414);
  }
  
  public final void dgO()
  {
    AppMethodBeat.i(246415);
    com.tencent.mm.plugin.finder.live.widget.b localb = this.umq;
    Object localObject = localb.uFw.getLiveData().uEB;
    Log.i(localb.TAG, "updateApplyLinkInfo newApplyCount:" + localb.uFw.getLiveData().uEA.size() + ", curLinkUser:" + localObject);
    if ((localb.uFw.getLiveData().uEA.size() > 0) && (localObject == null))
    {
      localObject = localb.uFB;
      p.g(localObject, "linkMicTip");
      y localy = y.vXH;
      ((TextView)localObject).setText((CharSequence)y.LU(localb.uFw.getLiveData().uEA.size()));
      localObject = localb.uFB;
      p.g(localObject, "linkMicTip");
      ((TextView)localObject).setVisibility(0);
    }
    for (;;)
    {
      localb.djv();
      AppMethodBeat.o(246415);
      return;
      localObject = localb.uFB;
      p.g(localObject, "linkMicTip");
      ((TextView)localObject).setVisibility(4);
    }
  }
  
  public final void dgP()
  {
    AppMethodBeat.i(246416);
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(246416);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool2 = true;
    AppMethodBeat.i(246419);
    paramIntent = this.TAG;
    Object localObject = new StringBuilder("onActivityResult requestCode:").append(paramInt1).append(",resultCode is ok:");
    StringBuilder localStringBuilder;
    if (paramInt2 == -1)
    {
      bool1 = true;
      Log.i(paramIntent, bool1);
      paramIntent = this.umr;
      localObject = paramIntent.TAG;
      localStringBuilder = new StringBuilder("onActivityResult requestCode:").append(paramInt1).append(",resultCode is ok:");
      if (paramInt2 != -1) {
        break label150;
      }
    }
    label150:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Log.i((String)localObject, bool1);
      if ((paramInt1 == 1002) && (paramInt2 == -1)) {
        b.b.a(paramIntent.hOp, b.c.hNA);
      }
      AppMethodBeat.o(246419);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(246417);
    p.h(paramc, "status");
    switch (i.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(246417);
      return;
      this.umq.dju();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorBottomOptionPlugin$Companion;", "", "()V", "OPTION_LOTTERY", "", "getOPTION_LOTTERY", "()I", "OPTION_MIC", "getOPTION_MIC", "OPTION_SHOPPING", "getOPTION_SHOPPING", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(h paramh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.h
 * JD-Core Version:    0.7.0.1
 */