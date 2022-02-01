package com.tencent.mm.plugin.finder.nearby;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.d.a.b.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.extension.reddot.p;
import com.tencent.mm.plugin.finder.nearby.abtest.a;
import com.tencent.mm.plugin.finder.viewmodel.component.ar;
import com.tencent.mm.plugin.finder.viewmodel.d.a;
import com.tencent.mm.plugin.finder.viewmodel.d.d;
import com.tencent.mm.plugin.findersdk.a.bl;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.protocal.protobuf.btx;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/NearByRedDotUIJumpUIC;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderRedDotUIJumpUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "ctrInfoNullable", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "getCtrInfoNullable", "()Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "setCtrInfoNullable", "(Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;)V", "showInfoNullable", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "getShowInfoNullable", "()Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "setShowInfoNullable", "(Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;)V", "getEnterPath", "", "isIgnore", "", "markHardRefresh", "", "setupRedInfo", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends ar
{
  public bxq EFi;
  public p EFj;
  
  public b(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(339580);
    AppMethodBeat.o(339580);
  }
  
  public b(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(339585);
    AppMethodBeat.o(339585);
  }
  
  public final String eDX()
  {
    AppMethodBeat.i(339593);
    a locala = a.EHr;
    if (!a.eEi())
    {
      AppMethodBeat.o(339593);
      return "NearbyEntrance";
    }
    AppMethodBeat.o(339593);
    return "FinderLiveEntrance";
  }
  
  public final void eDY()
  {
    AppMethodBeat.i(339603);
    Object localObject = fon();
    if (localObject == null) {}
    for (int i = 0;; i = ((btx)localObject).aabK)
    {
      int j = i;
      if (i == 0)
      {
        j = ((e)h.az(e.class)).getExitLiveTabId(94);
        Log.i("Finder.RedDotUIJumpUIC", s.X("prepareLiveSquare use last cache targetTabId=", Integer.valueOf(j)));
      }
      i = ((com.tencent.d.a.b.a.d)h.az(com.tencent.d.a.b.a.d.class)).getTargetCommentScene(94);
      i = ((e)h.az(e.class)).parseTabIdFlag(i, j);
      if (!eDZ())
      {
        localObject = eHM().UV(i);
        ((d.a)localObject).a(d.d.GKM);
        ((d.a)localObject).GKz = 0L;
        ((e)h.az(e.class)).resetLiveFirstPagePreload(j);
      }
      AppMethodBeat.o(339603);
      return;
    }
  }
  
  public final boolean eDZ()
  {
    AppMethodBeat.i(339614);
    a locala = a.EHr;
    if (!a.eEi())
    {
      bool = ((cn)h.az(cn.class)).getRedDotManager().dZt();
      Log.i("Finder.RedDotUIJumpUIC", s.X("[isIgnore] isEnableShowNearByEntranceRedDot=", Boolean.valueOf(bool)));
      if (!bool)
      {
        AppMethodBeat.o(339614);
        return true;
      }
      AppMethodBeat.o(339614);
      return false;
    }
    boolean bool = ((cn)h.az(cn.class)).getRedDotManager().dZv();
    Log.i("Finder.RedDotUIJumpUIC", s.X("[isIgnore] isEnableShowFinderLiveEntranceRedDot=", Boolean.valueOf(bool)));
    if (!bool)
    {
      AppMethodBeat.o(339614);
      return true;
    }
    AppMethodBeat.o(339614);
    return false;
  }
  
  public final void eEa()
  {
    Object localObject3 = null;
    Object localObject2 = null;
    AppMethodBeat.i(339621);
    Object localObject1 = a.EHr;
    if (a.eEi())
    {
      localObject1 = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager();
      if (localObject1 == null)
      {
        localObject1 = null;
        this.EFi = ((bxq)localObject1);
        localObject1 = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager();
        if (localObject1 != null) {
          break label81;
        }
      }
      label81:
      for (localObject1 = localObject2;; localObject1 = ((i)localObject1).Su("FinderLiveEntrance"))
      {
        this.EFj = ((p)localObject1);
        AppMethodBeat.o(339621);
        return;
        localObject1 = ((i)localObject1).avp("FinderLiveEntrance");
        break;
      }
    }
    localObject1 = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager();
    if (localObject1 == null)
    {
      localObject1 = null;
      this.EFi = ((bxq)localObject1);
      localObject1 = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager();
      if (localObject1 != null) {
        break label153;
      }
    }
    label153:
    for (localObject1 = localObject3;; localObject1 = ((i)localObject1).Su("NearbyEntrance"))
    {
      this.EFj = ((p)localObject1);
      AppMethodBeat.o(339621);
      return;
      localObject1 = ((i)localObject1).avp("NearbyEntrance");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.b
 * JD-Core Version:    0.7.0.1
 */