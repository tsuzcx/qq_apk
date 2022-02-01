package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.f.b.a.dt;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.presenter.contract.FinderNotifyContract.NotifyPresenter;
import com.tencent.mm.plugin.finder.viewmodel.component.af;
import com.tencent.mm.plugin.finder.viewmodel.e;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.a.ak;
import kotlin.a.j;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderFinderMsgUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyPresenter;", "dealContentView", "", "v", "Landroid/view/View;", "getActivityContentView", "getCommentScene", "", "getPresenter", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "Landroid/content/Intent;", "onPause", "onResume", "onStop", "Companion", "plugin-finder_release"})
public final class FinderFinderMsgUI
  extends MMFinderUI
{
  public static final a AqN;
  private static final String TAG = "FinderMsgNotifyUI";
  private static final ArrayList<int[]> zPj;
  private HashMap _$_findViewCache;
  public final FinderNotifyContract.NotifyPresenter zPr;
  
  static
  {
    AppMethodBeat.i(288481);
    AqN = new a((byte)0);
    TAG = "FinderMsgNotifyUI";
    zPj = j.ag(new int[][] { { 2 }, { 3, 5 }, { 1, 10 } });
    AppMethodBeat.o(288481);
  }
  
  public FinderFinderMsgUI()
  {
    AppMethodBeat.i(288480);
    ArrayList localArrayList = zPj;
    this.zPr = new FinderNotifyContract.NotifyPresenter(new int[] { 3, 4, 5 }, localArrayList, (byte)0);
    AppMethodBeat.o(288480);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(288483);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(288483);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(288482);
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
    AppMethodBeat.o(288482);
    return localView1;
  }
  
  public final void dealContentView(View paramView)
  {
    AppMethodBeat.i(288479);
    super.dealContentView(paramView);
    AppMethodBeat.o(288479);
  }
  
  public final int getCommentScene()
  {
    return 7;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(288471);
    Set localSet = ak.setOf(af.class);
    AppMethodBeat.o(288471);
    return localSet;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(288478);
    setMMTitle(b.j.finder_conversation_finder_team);
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    AppMethodBeat.o(288478);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(288472);
    super.onCreate(paramBundle);
    initView();
    FinderNotifyContract.NotifyPresenter localNotifyPresenter = this.zPr;
    EventCenter.instance.add((IListener)localNotifyPresenter.zPh);
    com.tencent.mm.kernel.h.aGY().a(978, (i)localNotifyPresenter);
    if (localNotifyPresenter.scene == 1)
    {
      dt localdt = localNotifyPresenter.zOF;
      String str = ((c)com.tencent.mm.kernel.h.ae(c.class)).dbr();
      paramBundle = str;
      if (str == null) {
        paramBundle = "";
      }
      localdt.qN(paramBundle);
      localNotifyPresenter.zOF.ajV();
    }
    AppMethodBeat.o(288472);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(288477);
    Object localObject = g.Xox;
    int i = ((af)g.b((AppCompatActivity)this).i(af.class)).elu();
    super.onDestroy();
    localObject = g.Xox;
    localObject = (e)g.bD(PluginFinder.class).i(e.class);
    Log.i("Finder.FinderTagCacheVm", "type=1 tabIndex=" + i + ' ');
    ((Map)((e)localObject).Bgm).put(Integer.valueOf(1), Integer.valueOf(i));
    ((e)localObject).Bhh = -1;
    this.zPr.onActivityDestroy();
    AppMethodBeat.o(288477);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(288473);
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(288473);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(288475);
    super.onPause();
    com.tencent.d.f.h.ioq();
    AppMethodBeat.o(288475);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(288474);
    super.onResume();
    this.zPr.zOE = System.currentTimeMillis();
    com.tencent.d.f.h.ioq();
    AppMethodBeat.o(288474);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(288476);
    super.onStop();
    FinderNotifyContract.NotifyPresenter localNotifyPresenter = this.zPr;
    localNotifyPresenter.zOF.jR(System.currentTimeMillis() - localNotifyPresenter.zOE);
    AppMethodBeat.o(288476);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderFinderMsgUI$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "msgTypes", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getMsgTypes", "()Ljava/util/ArrayList;", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderFinderMsgUI paramFinderFinderMsgUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(273238);
      this.AqO.finish();
      AppMethodBeat.o(273238);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderFinderMsgUI
 * JD-Core Version:    0.7.0.1
 */