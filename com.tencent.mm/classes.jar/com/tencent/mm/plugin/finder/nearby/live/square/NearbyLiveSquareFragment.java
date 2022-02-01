package com.tencent.mm.plugin.finder.nearby.live.square;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.extension.reddot.f;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.s.aq;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.nearby.live.square.page.NearbyLiveSquareTabFragment;
import com.tencent.mm.plugin.finder.nearby.live.square.tab.c;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.protocal.protobuf.bhw;
import com.tencent.mm.protocal.protobuf.bhx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareFragment;", "Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "()V", "getClickTabId", "", "getCommentScene", "", "getPageName", "getReportType", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActionbarDoubleClick", "", "onDestroy", "onMenuClick", "onPause", "onResume", "onUserVisibleFocused", "onUserVisibleUnFocused", "prepareLiveSquare", "activity", "Landroid/app/Activity;", "Companion", "plugin-finder-nearby_release"})
public class NearbyLiveSquareFragment
  extends AbsNearByFragment
{
  public static final a zGe;
  private HashMap _$_findViewCache;
  
  static
  {
    AppMethodBeat.i(199463);
    zGe = new a((byte)0);
    AppMethodBeat.o(199463);
  }
  
  public NearbyLiveSquareFragment()
  {
    super(b.j.nearby_tab_live, 1001);
  }
  
  public void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(199465);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(199465);
  }
  
  public final String akA()
  {
    return "";
  }
  
  public final void ar(Activity paramActivity)
  {
    AppMethodBeat.i(199445);
    p.k(paramActivity, "activity");
    Object localObject1 = com.tencent.mm.plugin.finder.nearby.abtest.a.zDp;
    Object localObject2;
    Object localObject4;
    int i;
    int j;
    long l1;
    Bundle localBundle;
    long l2;
    int m;
    int k;
    if (com.tencent.mm.plugin.finder.nearby.abtest.a.dLo())
    {
      localObject1 = "FinderLiveEntrance";
      localObject2 = h.ag(PluginFinder.class);
      p.j(localObject2, "MMKernel.plugin(PluginFinder::class.java)");
      localObject4 = ((PluginFinder)localObject2).getRedDotManager();
      i = 0;
      int n = 0;
      j = 0;
      l1 = 0L;
      localBundle = new Bundle();
      localObject2 = ((f)localObject4).aBf((String)localObject1);
      if (localObject2 == null) {
        break label717;
      }
      l2 = l1;
      m = i;
      k = n;
      if (((com.tencent.mm.plugin.finder.extension.reddot.l)localObject2).aBy((String)localObject1) == null) {
        break label704;
      }
      l2 = l1;
      m = i;
      k = n;
      if (((com.tencent.mm.plugin.finder.extension.reddot.l)localObject2).field_ctrInfo.type != 16) {
        break label704;
      }
      ((f)localObject4).b((com.tencent.mm.plugin.finder.extension.reddot.l)localObject2);
      localObject1 = ((f)localObject4).aBi("NearbyLiveTab");
      if (localObject1 == null) {
        break label670;
      }
      i = ((bhx)localObject1).SSv;
      label155:
      localObject1 = ((f)localObject4).aBi("NearbyLiveTab");
      if (localObject1 == null) {
        break label675;
      }
      j = ((bhx)localObject1).SSw;
      label175:
      localObject1 = ((f)localObject4).aBi("NearbyLiveTab");
      if (localObject1 == null) {
        break label680;
      }
      l1 = ((bhx)localObject1).object_id;
      label196:
      localObject1 = ((f)localObject4).aBi("NearbyLiveTab");
      if (localObject1 == null) {
        break label686;
      }
      localObject1 = ((bhx)localObject1).object_nonce_id;
      label217:
      localObject2 = ((f)localObject4).aBi("NearbyLiveTab");
      if (localObject2 != null)
      {
        localObject2 = ((bhx)localObject2).RLN;
        if (localObject2 != null) {
          break label760;
        }
      }
      localObject2 = "";
    }
    label355:
    label360:
    label760:
    for (;;)
    {
      p.j(localObject2, "redDotManager.getEnterTa…AB)?.finder_username ?:\"\"");
      Object localObject3 = ((f)localObject4).aBi("NearbyLiveTab");
      if (localObject3 != null)
      {
        localObject3 = ((bhx)localObject3).SSx;
        if (localObject3 != null) {}
      }
      else
      {
        localObject3 = "";
      }
      for (;;)
      {
        p.j(localObject3, "redDotManager.getEnterTa…AB)?.finder_nickname ?:\"\"");
        localObject4 = ((f)localObject4).aBi("NearbyLiveTab");
        if (localObject4 != null)
        {
          localObject5 = ((bhx)localObject4).SSy;
          localObject4 = localObject5;
          if (localObject5 != null) {}
        }
        else
        {
          localObject4 = "";
        }
        p.j(localObject4, "redDotManager.getEnterTa…TAB)?.live_cover_url ?:\"\"");
        Object localObject5 = Integer.valueOf(j);
        ((Number)localObject5).intValue();
        if (j == 1)
        {
          k = 1;
          if (k == 0) {
            break label698;
          }
          l2 = l1;
          m = i;
          k = j;
          if (localObject5 == null) {
            break label704;
          }
          ((Number)localObject5).intValue();
          if (l1 != 0L)
          {
            localBundle.putLong("nearby_live_target_object_id_params_key", l1);
            localBundle.putString("nearby_live_target_nonce_id_params_key", (String)localObject1);
            localBundle.putString("nearby_live_target_user_name_params_key", (String)localObject2);
            localBundle.putString("nearby_live_target_nick_name_params_key", (String)localObject3);
            localBundle.putString("nearby_live_target_cover_url_params_key", (String)localObject4);
            localObject5 = com.tencent.mm.plugin.finder.nearby.live.base.b.zET;
            if (localObject1 == null) {
              p.iCn();
            }
            ((com.tencent.mm.plugin.finder.nearby.live.base.b)localObject5).a(l1, (String)localObject1, getCommentScene(), null);
            localObject5 = com.tencent.mm.plugin.finder.nearby.live.base.b.zET;
            com.tencent.mm.plugin.finder.nearby.live.base.b.a(paramActivity, l1, (String)localObject1, (String)localObject2, (String)localObject3, (String)localObject4);
          }
          k = i;
          if (i == 0)
          {
            localObject1 = com.tencent.mm.plugin.finder.nearby.d.zCK;
            k = com.tencent.mm.plugin.finder.nearby.d.getExitLiveTabId();
            Log.i("NearbyLiveSquareFragment", "prepareLiveSquare use last cache targetTabId=".concat(String.valueOf(k)));
          }
          localObject1 = Integer.valueOf(k);
          ((Number)localObject1).intValue();
          if (k == 0) {
            break label725;
          }
          i = 1;
          if (i == 0) {
            break label730;
          }
          if (localObject1 != null)
          {
            ((Number)localObject1).intValue();
            localObject1 = new bcz();
            ((bcz)localObject1).SOa = k;
            localBundle.putByteArray("nearby_live_target_square_page_params_key", ((bcz)localObject1).toByteArray());
          }
          if (getArguments() != null) {
            break label736;
          }
          setArguments(localBundle);
        }
        for (;;)
        {
          Log.i("NearbyLiveSquareFragment", "prepareLiveSquare targetTabId=" + k + ' ' + "enterLiveAction:" + j + " targetObjectId:" + l1 + " activity:" + paramActivity);
          AppMethodBeat.o(199445);
          return;
          localObject1 = "NearbyEntrance";
          break;
          i = 0;
          break label155;
          j = 0;
          break label175;
          l1 = 0L;
          break label196;
          localObject1 = null;
          break label217;
          k = 0;
          break label355;
          localObject5 = null;
          break label360;
          l1 = l2;
          i = m;
          j = k;
          break label482;
          l1 = 0L;
          i = 0;
          break label482;
          i = 0;
          break label537;
          localObject1 = null;
          break label541;
          localObject1 = getArguments();
          if (localObject1 != null) {
            ((Bundle)localObject1).putAll(localBundle);
          }
        }
      }
    }
  }
  
  public final void dLs()
  {
    AppMethodBeat.i(199446);
    super.dLs();
    Object localObject = ((b)component(b.class)).zGg;
    if (localObject == null) {
      p.bGy("livePostHelper");
    }
    ((com.tencent.mm.plugin.finder.live.ui.livepost.b)localObject).prepare();
    localObject = k.yBj;
    k.a(s.aq.yJC);
    AppMethodBeat.o(199446);
  }
  
  public final void dLu()
  {
    AppMethodBeat.i(199447);
    super.dLu();
    NearbyLiveSquareTabFragment localNearbyLiveSquareTabFragment = ((b)component(b.class)).dMe();
    if (localNearbyLiveSquareTabFragment != null)
    {
      localNearbyLiveSquareTabFragment.dLu();
      AppMethodBeat.o(199447);
      return;
    }
    AppMethodBeat.o(199447);
  }
  
  public String dLv()
  {
    return "1001";
  }
  
  public int duR()
  {
    return 3;
  }
  
  public int getCommentScene()
  {
    return 94;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(199433);
    Set localSet = ak.setOf(new Class[] { aj.class, com.tencent.mm.plugin.finder.nearby.live.square.tab.d.class, c.class, b.class });
    AppMethodBeat.o(199433);
    return localSet;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(199459);
    super.onDestroy();
    com.tencent.mm.plugin.finder.nearby.report.a locala = com.tencent.mm.plugin.finder.nearby.report.a.zIZ;
    com.tencent.mm.plugin.finder.nearby.report.a.reset();
    AppMethodBeat.o(199459);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(199454);
    super.onPause();
    Log.i("NearbyLiveSquareFragment", "onPause()");
    Object localObject = getActivity();
    if (localObject != null)
    {
      g localg = g.Xox;
      p.j(localObject, "it");
      if ((((com.tencent.mm.plugin.finder.nearby.e)g.lm((Context)localObject).i(com.tencent.mm.plugin.finder.nearby.e.class)).dLn() instanceof NearbyLiveSquareFragment))
      {
        localObject = com.tencent.mm.plugin.finder.nearby.report.e.zJs;
        com.tencent.mm.plugin.finder.nearby.report.e.e((AbsNearByFragment)((b)component(b.class)).dMe());
      }
    }
    localObject = com.tencent.mm.plugin.finder.nearby.live.report.a.zGc;
    com.tencent.mm.plugin.finder.nearby.live.report.a.onPause();
    AppMethodBeat.o(199454);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(199456);
    super.onResume();
    Log.i("NearbyLiveSquareFragment", "onResume()");
    Object localObject = com.tencent.mm.plugin.finder.nearby.report.e.zJs;
    com.tencent.mm.plugin.finder.nearby.report.e.dMA();
    localObject = com.tencent.mm.plugin.finder.nearby.live.report.a.zGc;
    com.tencent.mm.plugin.finder.nearby.live.report.a.onResume();
    AppMethodBeat.o(199456);
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(199451);
    super.onUserVisibleFocused();
    if (getActivity() != null)
    {
      NearbyLiveSquareTabFragment localNearbyLiveSquareTabFragment = ((b)component(b.class)).dMe();
      if (localNearbyLiveSquareTabFragment != null)
      {
        localNearbyLiveSquareTabFragment.onUserVisibleFocused();
        AppMethodBeat.o(199451);
        return;
      }
    }
    AppMethodBeat.o(199451);
  }
  
  public final void onUserVisibleUnFocused()
  {
    AppMethodBeat.i(199453);
    super.onUserVisibleUnFocused();
    NearbyLiveSquareTabFragment localNearbyLiveSquareTabFragment = ((b)component(b.class)).dMe();
    if (localNearbyLiveSquareTabFragment != null)
    {
      localNearbyLiveSquareTabFragment.onUserVisibleUnFocused();
      AppMethodBeat.o(199453);
      return;
    }
    AppMethodBeat.o(199453);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareFragment$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.square.NearbyLiveSquareFragment
 * JD-Core Version:    0.7.0.1
 */