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
import com.tencent.mm.plugin.finder.storage.ac;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.MMActivity;
import d.g.b.p;
import d.l;
import java.util.HashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/FinderFinderSysMsgUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback$UICallbackListener;", "()V", "TAG", "", "exposeMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/search/FinderExposeItem;", "msgPresenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgPresenter;", "getLayoutId", "", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onItemClick", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "onResume", "onStop", "plugin-finder_release"})
public final class FinderFinderSysMsgUI
  extends MMFinderUI
  implements FinderMsgContract.MsgViewCallback.UICallbackListener
{
  private final String TAG;
  private HashMap _$_findViewCache;
  private final FinderMsgContract.MsgPresenter sCy;
  private HashMap<String, a> ssI;
  
  public FinderFinderSysMsgUI()
  {
    AppMethodBeat.i(203982);
    this.TAG = "Finder.FinderFinderSysMsgUI";
    this.sCy = new FinderMsgContract.MsgPresenter(2, new int[] { 4 });
    this.ssI = new HashMap();
    AppMethodBeat.o(203982);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(203983);
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
    AppMethodBeat.o(203983);
    return localView1;
  }
  
  public final void a(ac paramac)
  {
    AppMethodBeat.i(203981);
    p.h(paramac, "mention");
    AppMethodBeat.o(203981);
  }
  
  public final int getLayoutId()
  {
    return 2131494128;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(203979);
    setMMTitle(getString(2131766444));
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    Object localObject = (MMActivity)this;
    View localView = getContentView();
    p.g(localView, "contentView");
    localObject = new FinderMsgContract.MsgViewCallback((MMActivity)localObject, localView, this.sCy, (FinderMsgContract.MsgViewCallback.UICallbackListener)this);
    this.sCy.a((FinderMsgContract.MsgViewCallback)localObject);
    ((FinderMsgContract.MsgViewCallback)localObject).initView();
    localObject = g.ajC();
    p.g(localObject, "MMKernel.storage()");
    ((e)localObject).ajl().set(al.a.IIC, Integer.valueOf(0));
    AppMethodBeat.o(203979);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(203976);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(203976);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(203980);
    super.onDestroy();
    this.sCy.onDetach();
    AppMethodBeat.o(203980);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(203977);
    super.onResume();
    this.sCy.smE = System.currentTimeMillis();
    AppMethodBeat.o(203977);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(203978);
    super.onStop();
    this.sCy.onStop();
    AppMethodBeat.o(203978);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderFinderSysMsgUI paramFinderFinderSysMsgUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(203975);
      this.sCE.finish();
      AppMethodBeat.o(203975);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderFinderSysMsgUI
 * JD-Core Version:    0.7.0.1
 */