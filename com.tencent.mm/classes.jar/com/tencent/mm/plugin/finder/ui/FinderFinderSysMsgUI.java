package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.f;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract.MsgPresenter;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract.MsgViewCallback;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract.MsgViewCallback.UICallbackListener;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderFinderSysMsgUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback$UICallbackListener;", "()V", "TAG", "", "exposeMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/search/FinderExposeItem;", "msgPresenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgPresenter;", "getLayoutId", "", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onItemClick", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "onResume", "onStop", "plugin-finder_release"})
public final class FinderFinderSysMsgUI
  extends MMFinderUI
  implements FinderMsgContract.MsgViewCallback.UICallbackListener
{
  private final String TAG;
  private HashMap _$_findViewCache;
  private final FinderMsgContract.MsgPresenter vJX;
  private HashMap<String, com.tencent.mm.plugin.finder.search.a> vtH;
  
  public FinderFinderSysMsgUI()
  {
    AppMethodBeat.i(252365);
    this.TAG = "Finder.FinderFinderSysMsgUI";
    this.vJX = new FinderMsgContract.MsgPresenter(2, new int[] { 4 });
    this.vtH = new HashMap();
    AppMethodBeat.o(252365);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(252367);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(252367);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(252366);
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
    AppMethodBeat.o(252366);
    return localView1;
  }
  
  public final void a(com.tencent.mm.plugin.finder.storage.ao paramao)
  {
    AppMethodBeat.i(252364);
    p.h(paramao, "mention");
    AppMethodBeat.o(252364);
  }
  
  public final int getLayoutId()
  {
    return 2131494679;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(252362);
    setMMTitle(getString(2131759618));
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    Object localObject = (MMActivity)this;
    View localView = getContentView();
    p.g(localView, "contentView");
    localObject = new FinderMsgContract.MsgViewCallback((MMActivity)localObject, localView, this.vJX, (FinderMsgContract.MsgViewCallback.UICallbackListener)this);
    this.vJX.a((FinderMsgContract.MsgViewCallback)localObject);
    ((FinderMsgContract.MsgViewCallback)localObject).initView();
    localObject = g.aAh();
    p.g(localObject, "MMKernel.storage()");
    ((e)localObject).azQ().set(ar.a.Oms, Integer.valueOf(0));
    localObject = g.ah(PluginFinder.class);
    p.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)localObject).getRedDotManager().tJB.dau();
    AppMethodBeat.o(252362);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(252359);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(252359);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(252363);
    super.onDestroy();
    this.vJX.onDetach();
    AppMethodBeat.o(252363);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(252360);
    super.onResume();
    this.vJX.uYq = System.currentTimeMillis();
    AppMethodBeat.o(252360);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(252361);
    super.onStop();
    this.vJX.onStop();
    AppMethodBeat.o(252361);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderFinderSysMsgUI paramFinderFinderSysMsgUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(252358);
      this.vKd.finish();
      AppMethodBeat.o(252358);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderFinderSysMsgUI
 * JD-Core Version:    0.7.0.1
 */