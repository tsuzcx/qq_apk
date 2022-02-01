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
import com.tencent.mm.plugin.finder.storage.ac;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import d.g.b.p;
import java.util.HashMap;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/FinderFinderMsgUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback$UICallbackListener;", "()V", "TAG", "", "msgPresenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgPresenter;", "viewCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback;", "getCommentScene", "", "getLayoutId", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onItemClick", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "onPause", "onResume", "onStop", "Companion", "plugin-finder_release"})
public final class FinderFinderMsgUI
  extends MMFinderUI
  implements FinderMsgContract.MsgViewCallback.UICallbackListener
{
  private static final int sNy = 1;
  public static final FinderFinderMsgUI.a sNz;
  private final String TAG;
  private HashMap _$_findViewCache;
  private final FinderMsgContract.MsgPresenter sNx;
  private FinderMsgContract.MsgViewCallback swt;
  
  static
  {
    AppMethodBeat.i(204569);
    sNz = new FinderFinderMsgUI.a((byte)0);
    sNy = 1;
    AppMethodBeat.o(204569);
  }
  
  public FinderFinderMsgUI()
  {
    AppMethodBeat.i(204568);
    this.TAG = "Finder.FinderFinderMsgUI";
    this.sNx = new FinderMsgContract.MsgPresenter(1, new int[] { 1, 2, 3, 5, 10 });
    AppMethodBeat.o(204568);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(204570);
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
    AppMethodBeat.o(204570);
    return localView1;
  }
  
  public final void a(ac paramac)
  {
    AppMethodBeat.i(204567);
    p.h(paramac, "mention");
    AppMethodBeat.o(204567);
  }
  
  public final int cCL()
  {
    return 7;
  }
  
  public final int getLayoutId()
  {
    return 2131494128;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(204562);
    setMMTitle(getString(2131766445));
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    Object localObject = (MMActivity)this;
    View localView = getContentView();
    p.g(localView, "contentView");
    localObject = new FinderMsgContract.MsgViewCallback((MMActivity)localObject, localView, this.sNx, (FinderMsgContract.MsgViewCallback.UICallbackListener)this);
    this.sNx.a((FinderMsgContract.MsgViewCallback)localObject);
    ((FinderMsgContract.MsgViewCallback)localObject).initView();
    this.swt = ((FinderMsgContract.MsgViewCallback)localObject);
    addIconOptionMenu(0, 2131233291, (MenuItem.OnMenuItemClickListener)new c(this));
    localObject = g.ajR();
    p.g(localObject, "MMKernel.storage()");
    ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.Jde, Integer.valueOf(0));
    AppMethodBeat.o(204562);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(204561);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(204561);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(204565);
    super.onDestroy();
    this.sNx.onDetach();
    AppMethodBeat.o(204565);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(204564);
    super.onPause();
    Object localObject = this.swt;
    if (localObject != null)
    {
      localObject = ((FinderMsgContract.MsgViewCallback)localObject).rXV;
      if (localObject != null)
      {
        ((WxRecyclerAdapter)localObject).onPause();
        AppMethodBeat.o(204564);
        return;
      }
    }
    AppMethodBeat.o(204564);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(204563);
    super.onResume();
    this.sNx.swv = System.currentTimeMillis();
    Object localObject = this.swt;
    if (localObject != null)
    {
      localObject = ((FinderMsgContract.MsgViewCallback)localObject).rXV;
      if (localObject != null)
      {
        ((WxRecyclerAdapter)localObject).onResume();
        AppMethodBeat.o(204563);
        return;
      }
    }
    AppMethodBeat.o(204563);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(204566);
    super.onStop();
    this.sNx.onStop();
    AppMethodBeat.o(204566);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderFinderMsgUI paramFinderFinderMsgUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(204556);
      this.sNA.finish();
      AppMethodBeat.o(204556);
      return true;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class c
    implements MenuItem.OnMenuItemClickListener
  {
    c(FinderFinderMsgUI paramFinderFinderMsgUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(204560);
      paramMenuItem = new com.tencent.mm.ui.widget.a.e((Context)this.sNA, 1, false);
      paramMenuItem.a((n.d)1.sNB);
      paramMenuItem.a((n.e)new n.e()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(204559);
          p.g(paramAnonymousMenuItem, "menuItem");
          paramAnonymousInt = paramAnonymousMenuItem.getItemId();
          paramAnonymousMenuItem = FinderFinderMsgUI.sNz;
          if (paramAnonymousInt == FinderFinderMsgUI.cMn())
          {
            paramAnonymousMenuItem = new Intent();
            paramAnonymousMenuItem.putExtra("KEY_CACHE_ID", System.currentTimeMillis());
            Object localObject = FinderReporterUIC.tnG;
            FinderReporterUIC.a.a((Context)this.sNC.sNA, paramAnonymousMenuItem, 0L, 0, false, 124);
            localObject = a.sVQ;
            a.V((Context)this.sNC.sNA, paramAnonymousMenuItem);
          }
          AppMethodBeat.o(204559);
        }
      });
      paramMenuItem.cPF();
      AppMethodBeat.o(204560);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderFinderMsgUI
 * JD-Core Version:    0.7.0.1
 */