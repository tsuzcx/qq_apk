package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract.MsgPresenter;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract.MsgViewCallback;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract.MsgViewCallback.UICallbackListener;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import d.g.b.k;
import java.util.HashMap;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/FinderFinderMsgUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback$UICallbackListener;", "()V", "TAG", "", "msgPresenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgPresenter;", "viewCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback;", "getCommentScene", "", "getLayoutId", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onItemClick", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "onPause", "onResume", "Companion", "plugin-finder_release"})
public final class FinderFinderMsgUI
  extends MMFinderUI
  implements FinderMsgContract.MsgViewCallback.UICallbackListener
{
  private static final int rHv = 1;
  public static final FinderFinderMsgUI.a rHw;
  private final String TAG;
  private HashMap _$_findViewCache;
  private final FinderMsgContract.MsgPresenter rHu;
  private FinderMsgContract.MsgViewCallback rwH;
  
  static
  {
    AppMethodBeat.i(203185);
    rHw = new FinderFinderMsgUI.a((byte)0);
    rHv = 1;
    AppMethodBeat.o(203185);
  }
  
  public FinderFinderMsgUI()
  {
    AppMethodBeat.i(203184);
    this.TAG = "Finder.FinderFinderMsgUI";
    this.rHu = new FinderMsgContract.MsgPresenter(1, new int[] { 1, 2, 3, 5 });
    AppMethodBeat.o(203184);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(203186);
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
    AppMethodBeat.o(203186);
    return localView1;
  }
  
  public final void a(u paramu)
  {
    AppMethodBeat.i(203183);
    k.h(paramu, "mention");
    AppMethodBeat.o(203183);
  }
  
  public final int cuI()
  {
    return 7;
  }
  
  public final int getLayoutId()
  {
    return 2131494128;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(203179);
    setMMTitle(getString(2131766445));
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    Object localObject = (MMActivity)this;
    View localView = getContentView();
    k.g(localView, "contentView");
    localObject = new FinderMsgContract.MsgViewCallback((MMActivity)localObject, localView, this.rHu, (FinderMsgContract.MsgViewCallback.UICallbackListener)this);
    this.rHu.a((FinderMsgContract.MsgViewCallback)localObject);
    ((FinderMsgContract.MsgViewCallback)localObject).initView();
    this.rwH = ((FinderMsgContract.MsgViewCallback)localObject);
    addIconOptionMenu(0, 2131233291, (MenuItem.OnMenuItemClickListener)new c(this));
    localObject = g.agR();
    k.g(localObject, "MMKernel.storage()");
    ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GVL, Integer.valueOf(0));
    AppMethodBeat.o(203179);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(203178);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(203178);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(203182);
    super.onDestroy();
    this.rHu.onDetach();
    AppMethodBeat.o(203182);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(203181);
    super.onPause();
    Object localObject = this.rwH;
    if (localObject != null)
    {
      localObject = ((FinderMsgContract.MsgViewCallback)localObject).rfX;
      if (localObject != null)
      {
        ((WxRecyclerAdapter)localObject).onPause();
        AppMethodBeat.o(203181);
        return;
      }
    }
    AppMethodBeat.o(203181);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(203180);
    super.onResume();
    Object localObject = this.rwH;
    if (localObject != null)
    {
      localObject = ((FinderMsgContract.MsgViewCallback)localObject).rfX;
      if (localObject != null)
      {
        ((WxRecyclerAdapter)localObject).onResume();
        AppMethodBeat.o(203180);
        return;
      }
    }
    AppMethodBeat.o(203180);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderFinderMsgUI paramFinderFinderMsgUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(203173);
      this.rHx.finish();
      AppMethodBeat.o(203173);
      return true;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class c
    implements MenuItem.OnMenuItemClickListener
  {
    c(FinderFinderMsgUI paramFinderFinderMsgUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(203177);
      paramMenuItem = new com.tencent.mm.ui.widget.a.e((Context)this.rHx, 1, false);
      paramMenuItem.a((n.c)1.rHy);
      paramMenuItem.a((n.d)new n.d()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(203176);
          k.g(paramAnonymousMenuItem, "menuItem");
          paramAnonymousInt = paramAnonymousMenuItem.getItemId();
          paramAnonymousMenuItem = FinderFinderMsgUI.rHw;
          if (paramAnonymousInt == FinderFinderMsgUI.cBH())
          {
            paramAnonymousMenuItem = new Intent();
            paramAnonymousMenuItem.putExtra("KEY_CACHE_ID", System.currentTimeMillis());
            Object localObject = FinderReporterUIC.seQ;
            FinderReporterUIC.a.a((Context)this.rHz.rHx, paramAnonymousMenuItem, 0L, 0, false, 124);
            localObject = a.rOv;
            a.U((Context)this.rHz.rHx, paramAnonymousMenuItem);
          }
          AppMethodBeat.o(203176);
        }
      });
      paramMenuItem.cED();
      AppMethodBeat.o(203177);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderFinderMsgUI
 * JD-Core Version:    0.7.0.1
 */