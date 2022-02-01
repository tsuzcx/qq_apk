package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract.MsgPresenter;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract.MsgViewCallback;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract.MsgViewCallback.UICallbackListener;
import com.tencent.mm.plugin.finder.search.a;
import com.tencent.mm.plugin.finder.storage.ac;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.MMActivity;
import d.g.b.p;
import d.l;
import java.util.HashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/FinderFinderSysMsgUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback$UICallbackListener;", "()V", "TAG", "", "exposeMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/search/FinderExposeItem;", "msgPresenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgPresenter;", "getLayoutId", "", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onItemClick", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "onResume", "onStop", "plugin-finder_release"})
public final class FinderFinderSysMsgUI
  extends MMFinderUI
  implements FinderMsgContract.MsgViewCallback.UICallbackListener
{
  private final String TAG;
  private HashMap _$_findViewCache;
  private HashMap<String, a> sCS;
  private final FinderMsgContract.MsgPresenter sNx;
  
  public FinderFinderSysMsgUI()
  {
    AppMethodBeat.i(204578);
    this.TAG = "Finder.FinderFinderSysMsgUI";
    this.sNx = new FinderMsgContract.MsgPresenter(2, new int[] { 4 });
    this.sCS = new HashMap();
    AppMethodBeat.o(204578);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(204579);
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
    AppMethodBeat.o(204579);
    return localView1;
  }
  
  public final void a(ac paramac)
  {
    AppMethodBeat.i(204577);
    p.h(paramac, "mention");
    AppMethodBeat.o(204577);
  }
  
  public final int getLayoutId()
  {
    return 2131494128;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(204575);
    setMMTitle(getString(2131766444));
    setBackBtn((MenuItem.OnMenuItemClickListener)new FinderFinderSysMsgUI.a(this));
    Object localObject = (MMActivity)this;
    View localView = getContentView();
    p.g(localView, "contentView");
    localObject = new FinderMsgContract.MsgViewCallback((MMActivity)localObject, localView, this.sNx, (FinderMsgContract.MsgViewCallback.UICallbackListener)this);
    this.sNx.a((FinderMsgContract.MsgViewCallback)localObject);
    ((FinderMsgContract.MsgViewCallback)localObject).initView();
    localObject = g.ajR();
    p.g(localObject, "MMKernel.storage()");
    ((e)localObject).ajA().set(am.a.Jdf, Integer.valueOf(0));
    AppMethodBeat.o(204575);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(204572);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(204572);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(204576);
    super.onDestroy();
    this.sNx.onDetach();
    AppMethodBeat.o(204576);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(204573);
    super.onResume();
    this.sNx.swv = System.currentTimeMillis();
    AppMethodBeat.o(204573);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(204574);
    super.onStop();
    this.sNx.onStop();
    AppMethodBeat.o(204574);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderFinderSysMsgUI
 * JD-Core Version:    0.7.0.1
 */