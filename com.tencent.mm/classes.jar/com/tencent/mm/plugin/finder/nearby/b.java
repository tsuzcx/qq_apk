package com.tencent.mm.plugin.finder.nearby;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.c.a.b.a.d;
import com.tencent.c.a.b.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.nearby.abtest.a;
import com.tencent.mm.plugin.finder.viewmodel.b.a;
import com.tencent.mm.plugin.finder.viewmodel.b.e;
import com.tencent.mm.plugin.finder.viewmodel.component.ai;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.findersdk.a.z;
import com.tencent.mm.protocal.protobuf.bhx;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/NearByRedDotUIJumpUIC;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderRedDotUIJumpUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "getEnterPath", "", "isIgnore", "", "markHardRefresh", "", "plugin-finder_release"})
public final class b
  extends ai
{
  public b(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(279044);
    AppMethodBeat.o(279044);
  }
  
  public b(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(279045);
    AppMethodBeat.o(279045);
  }
  
  public final String dLg()
  {
    AppMethodBeat.i(279040);
    a locala = a.zDp;
    if (!a.dLo())
    {
      AppMethodBeat.o(279040);
      return "NearbyEntrance";
    }
    AppMethodBeat.o(279040);
    return "FinderLiveEntrance";
  }
  
  public final void dLh()
  {
    AppMethodBeat.i(279042);
    Object localObject = ekS();
    if (localObject != null) {}
    for (int i = ((bhx)localObject).SSv;; i = 0)
    {
      int j = i;
      if (i == 0)
      {
        j = ((e)h.ag(e.class)).getExitLiveTabId();
        Log.i("Finder.RedDotUIJumpUIC", "prepareLiveSquare use last cache targetTabId=".concat(String.valueOf(j)));
      }
      i = ((d)h.ag(d.class)).getTargetCommentScene(94);
      i = ((e)h.ag(e.class)).parseTabIdFlag(i, j);
      if (!dLi())
      {
        localObject = dMI().RI(i);
        ((b.a)localObject).a(b.e.BgO);
        ((b.a)localObject).BgA = 0L;
        ((e)h.ag(e.class)).resetLiveFirstPagePreload(j);
      }
      AppMethodBeat.o(279042);
      return;
    }
  }
  
  public final boolean dLi()
  {
    AppMethodBeat.i(279043);
    Object localObject = a.zDp;
    if (!a.dLo())
    {
      localObject = h.ag(ak.class);
      p.j(localObject, "MMKernel.plugin(IPluginFinder::class.java)");
      localObject = ((ak)localObject).getRedDotManager();
      p.j(localObject, "MMKernel.plugin(IPluginF…class.java).redDotManager");
      bool = ((z)localObject).dqJ();
      Log.i("Finder.RedDotUIJumpUIC", "[isIgnore] isEnableShowNearByEntranceRedDot=".concat(String.valueOf(bool)));
      if (!bool)
      {
        AppMethodBeat.o(279043);
        return true;
      }
      AppMethodBeat.o(279043);
      return false;
    }
    localObject = h.ag(ak.class);
    p.j(localObject, "MMKernel.plugin(IPluginFinder::class.java)");
    localObject = ((ak)localObject).getRedDotManager();
    p.j(localObject, "MMKernel.plugin(IPluginF…class.java).redDotManager");
    boolean bool = ((z)localObject).dqK();
    Log.i("Finder.RedDotUIJumpUIC", "[isIgnore] isEnableShowFinderLiveEntranceRedDot=".concat(String.valueOf(bool)));
    if (!bool)
    {
      AppMethodBeat.o(279043);
      return true;
    }
    AppMethodBeat.o(279043);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.b
 * JD-Core Version:    0.7.0.1
 */