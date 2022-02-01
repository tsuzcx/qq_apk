package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.b.a.dc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.presenter.contract.FinderNotifyContract.NotifyPresenter;
import com.tencent.mm.plugin.finder.viewmodel.FinderTabStateCacheVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderMsgNotifyTabUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderTabUIC;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.a.ak;
import kotlin.a.j;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderFinderMsgUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyPresenter;", "dealContentView", "", "v", "Landroid/view/View;", "getActivityContentView", "getCommentScene", "", "getPresenter", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "Landroid/content/Intent;", "onPause", "onResume", "onStop", "Companion", "plugin-finder_release"})
public final class FinderFinderMsgUI
  extends MMFinderUI
{
  private static final String TAG = "FinderMsgNotifyUI";
  private static final ArrayList<int[]> uYR;
  public static final a vJV;
  private HashMap _$_findViewCache;
  public final FinderNotifyContract.NotifyPresenter uZa;
  
  static
  {
    AppMethodBeat.i(252339);
    vJV = new a((byte)0);
    TAG = "FinderMsgNotifyUI";
    uYR = j.ac(new int[][] { { 2 }, { 3, 5 }, { 1, 10 } });
    AppMethodBeat.o(252339);
  }
  
  public FinderFinderMsgUI()
  {
    AppMethodBeat.i(252338);
    ArrayList localArrayList = uYR;
    this.uZa = new FinderNotifyContract.NotifyPresenter(new int[] { 3, 4, 5 }, localArrayList, (byte)0);
    AppMethodBeat.o(252338);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(252341);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(252341);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(252340);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(252340);
    return localView1;
  }
  
  public final void dealContentView(View paramView)
  {
    AppMethodBeat.i(252337);
    super.dealContentView(paramView);
    AppMethodBeat.o(252337);
  }
  
  public final int getCommentScene()
  {
    return 7;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(252329);
    Set localSet = ak.setOf(FinderMsgNotifyTabUIC.class);
    AppMethodBeat.o(252329);
    return localSet;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(252336);
    setMMTitle(2131759618);
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    AppMethodBeat.o(252336);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(252330);
    super.onCreate(paramBundle);
    initView();
    paramBundle = a.PRN;
    int i = ((FinderTabStateCacheVM)a.bi(PluginFinder.class).get(FinderTabStateCacheVM.class)).dHU();
    paramBundle = a.PRN;
    FinderTabUIC.a((FinderMsgNotifyTabUIC)a.b((AppCompatActivity)this).get(FinderMsgNotifyTabUIC.class), i);
    FinderNotifyContract.NotifyPresenter localNotifyPresenter = this.uZa;
    EventCenter.instance.add((IListener)localNotifyPresenter.uYP);
    g.azz().a(978, (i)localNotifyPresenter);
    if (localNotifyPresenter.scene == 1)
    {
      dc localdc = localNotifyPresenter.uYr;
      String str = ((c)g.af(c.class)).cMD();
      paramBundle = str;
      if (str == null) {
        paramBundle = "";
      }
      localdc.ok(paramBundle);
      localNotifyPresenter.uYr.afb();
    }
    AppMethodBeat.o(252330);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(252335);
    Object localObject = a.PRN;
    int i = ((FinderMsgNotifyTabUIC)a.b((AppCompatActivity)this).get(FinderMsgNotifyTabUIC.class)).dIM();
    super.onDestroy();
    localObject = a.PRN;
    localObject = (FinderTabStateCacheVM)a.bi(PluginFinder.class).get(FinderTabStateCacheVM.class);
    Log.i("Finder.FinderTagCacheVm", "type=1 tabIndex=" + i + ' ');
    ((Map)((FinderTabStateCacheVM)localObject).wtV).put(Integer.valueOf(1), Integer.valueOf(i));
    ((FinderTabStateCacheVM)localObject).wuI = -1;
    this.uZa.onActivityDestroy();
    AppMethodBeat.o(252335);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(252331);
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(252331);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(252333);
    super.onPause();
    h.hkS();
    AppMethodBeat.o(252333);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(252332);
    super.onResume();
    this.uZa.uYq = System.currentTimeMillis();
    h.hkS();
    AppMethodBeat.o(252332);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(252334);
    super.onStop();
    FinderNotifyContract.NotifyPresenter localNotifyPresenter = this.uZa;
    localNotifyPresenter.uYr.iX(System.currentTimeMillis() - localNotifyPresenter.uYq);
    AppMethodBeat.o(252334);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderFinderMsgUI$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "msgTypes", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getMsgTypes", "()Ljava/util/ArrayList;", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderFinderMsgUI paramFinderFinderMsgUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(252328);
      this.vJW.finish();
      AppMethodBeat.o(252328);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderFinderMsgUI
 * JD-Core Version:    0.7.0.1
 */