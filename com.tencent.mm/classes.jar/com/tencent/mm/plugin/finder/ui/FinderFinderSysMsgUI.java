package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract.MsgPresenter;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract.MsgViewCallback;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract.MsgViewCallback.UICallbackListener;
import com.tencent.mm.plugin.finder.storage.an;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderFinderSysMsgUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback$UICallbackListener;", "()V", "TAG", "", "exposeMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/search/FinderExposeItem;", "msgPresenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgPresenter;", "getLayoutId", "", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onItemClick", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "onResume", "onStop", "plugin-finder_release"})
public final class FinderFinderSysMsgUI
  extends MMFinderUI
  implements FinderMsgContract.MsgViewCallback.UICallbackListener
{
  private final FinderMsgContract.MsgPresenter AqP;
  private final String TAG;
  private HashMap _$_findViewCache;
  private HashMap<String, com.tencent.mm.plugin.finder.search.a> zZV;
  
  public FinderFinderSysMsgUI()
  {
    AppMethodBeat.i(279239);
    this.TAG = "Finder.FinderFinderSysMsgUI";
    this.AqP = new FinderMsgContract.MsgPresenter(2, new int[] { 4 });
    this.zZV = new HashMap();
    AppMethodBeat.o(279239);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(279242);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(279242);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(279240);
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
    AppMethodBeat.o(279240);
    return localView1;
  }
  
  public final void a(an paraman)
  {
    AppMethodBeat.i(279238);
    p.k(paraman, "mention");
    AppMethodBeat.o(279238);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_wx_msg_ui;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(279236);
    setMMTitle(getString(b.j.finder_conversation_finder_team));
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    Object localObject = (MMActivity)this;
    View localView = getContentView();
    p.j(localView, "contentView");
    localObject = new FinderMsgContract.MsgViewCallback((MMActivity)localObject, localView, this.AqP, (FinderMsgContract.MsgViewCallback.UICallbackListener)this);
    this.AqP.a((FinderMsgContract.MsgViewCallback)localObject);
    ((FinderMsgContract.MsgViewCallback)localObject).initView();
    localObject = h.aHG();
    p.j(localObject, "MMKernel.storage()");
    ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VBp, Integer.valueOf(0));
    localObject = h.ag(PluginFinder.class);
    p.j(localObject, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)localObject).getRedDotManager().xsM.dqu();
    AppMethodBeat.o(279236);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(279231);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(279231);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(279237);
    super.onDestroy();
    this.AqP.onDetach();
    AppMethodBeat.o(279237);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(279232);
    super.onResume();
    this.AqP.zOE = System.currentTimeMillis();
    AppMethodBeat.o(279232);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(279234);
    super.onStop();
    this.AqP.onStop();
    AppMethodBeat.o(279234);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderFinderSysMsgUI paramFinderFinderSysMsgUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(223252);
      this.AqV.finish();
      AppMethodBeat.o(223252);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderFinderSysMsgUI
 * JD-Core Version:    0.7.0.1
 */