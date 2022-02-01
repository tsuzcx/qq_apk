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
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract.MsgPresenter;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract.MsgViewCallback;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract.MsgViewCallback.UICallbackListener;
import com.tencent.mm.plugin.finder.search.a;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.MMActivity;
import d.g.b.k;
import d.l;
import java.util.HashMap;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/FinderFinderSysMsgUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback$UICallbackListener;", "()V", "TAG", "", "exposeMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/search/FinderExposeItem;", "msgPresenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgPresenter;", "getLayoutId", "", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onItemClick", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "plugin-finder_release"})
public final class FinderFinderSysMsgUI
  extends MMFinderUI
  implements FinderMsgContract.MsgViewCallback.UICallbackListener
{
  private final String TAG;
  private HashMap _$_findViewCache;
  private HashMap<String, a> rAx;
  private final FinderMsgContract.MsgPresenter rHu;
  
  public FinderFinderSysMsgUI()
  {
    AppMethodBeat.i(203192);
    this.TAG = "Finder.FinderFinderSysMsgUI";
    this.rHu = new FinderMsgContract.MsgPresenter(2, new int[] { 4 });
    this.rAx = new HashMap();
    AppMethodBeat.o(203192);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(203193);
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
    AppMethodBeat.o(203193);
    return localView1;
  }
  
  public final void a(u paramu)
  {
    AppMethodBeat.i(203191);
    k.h(paramu, "mention");
    AppMethodBeat.o(203191);
  }
  
  public final int getLayoutId()
  {
    return 2131494128;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(203189);
    setMMTitle(getString(2131766444));
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    Object localObject = (MMActivity)this;
    View localView = getContentView();
    k.g(localView, "contentView");
    localObject = new FinderMsgContract.MsgViewCallback((MMActivity)localObject, localView, this.rHu, (FinderMsgContract.MsgViewCallback.UICallbackListener)this);
    this.rHu.a((FinderMsgContract.MsgViewCallback)localObject);
    ((FinderMsgContract.MsgViewCallback)localObject).initView();
    localObject = g.agR();
    k.g(localObject, "MMKernel.storage()");
    ((e)localObject).agA().set(ah.a.GVM, Integer.valueOf(0));
    AppMethodBeat.o(203189);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(203188);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(203188);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(203190);
    super.onDestroy();
    this.rHu.onDetach();
    AppMethodBeat.o(203190);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderFinderSysMsgUI paramFinderFinderSysMsgUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(203187);
      this.rHA.finish();
      AppMethodBeat.o(203187);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderFinderSysMsgUI
 * JD-Core Version:    0.7.0.1
 */