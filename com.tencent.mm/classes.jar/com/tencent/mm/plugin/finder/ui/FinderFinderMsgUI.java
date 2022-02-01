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
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import d.g.b.k;
import java.util.HashMap;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/FinderFinderMsgUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback$UICallbackListener;", "()V", "TAG", "", "msgPresenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgPresenter;", "viewCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback;", "getCommentScene", "", "getLayoutId", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onItemClick", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "onPause", "onResume", "Companion", "plugin-finder_release"})
public final class FinderFinderMsgUI
  extends MMFinderUI
  implements FinderMsgContract.MsgViewCallback.UICallbackListener
{
  private static final int KYn = 1;
  public static final a KYo;
  private final String TAG;
  private HashMap _$_findViewCache;
  private FinderMsgContract.MsgViewCallback qEY;
  private final FinderMsgContract.MsgPresenter qQp;
  
  static
  {
    AppMethodBeat.i(199215);
    KYo = new a((byte)0);
    KYn = 1;
    AppMethodBeat.o(199215);
  }
  
  public FinderFinderMsgUI()
  {
    AppMethodBeat.i(199214);
    this.TAG = "Finder.FinderFinderMsgUI";
    this.qQp = new FinderMsgContract.MsgPresenter(1, new int[] { 1, 2, 3, 5 });
    AppMethodBeat.o(199214);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(199216);
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
    AppMethodBeat.o(199216);
    return localView1;
  }
  
  public final void a(com.tencent.mm.plugin.finder.storage.l paraml)
  {
    AppMethodBeat.i(199213);
    k.h(paraml, "mention");
    AppMethodBeat.o(199213);
  }
  
  public final int getCommentScene()
  {
    return 7;
  }
  
  public final int getLayoutId()
  {
    return 2131494128;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(199209);
    setMMTitle(getString(2131766432));
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    Object localObject = (MMActivity)this;
    View localView = getContentView();
    k.g(localView, "contentView");
    localObject = new FinderMsgContract.MsgViewCallback((MMActivity)localObject, localView, this.qQp, (FinderMsgContract.MsgViewCallback.UICallbackListener)this);
    this.qQp.a((FinderMsgContract.MsgViewCallback)localObject);
    ((FinderMsgContract.MsgViewCallback)localObject).initView();
    this.qEY = ((FinderMsgContract.MsgViewCallback)localObject);
    addIconOptionMenu(0, 2131233291, (MenuItem.OnMenuItemClickListener)new c(this));
    localObject = g.afB();
    k.g(localObject, "MMKernel.storage()");
    ((com.tencent.mm.kernel.e)localObject).afk().set(ae.a.LBn, Integer.valueOf(0));
    AppMethodBeat.o(199209);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(199208);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(199208);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(199212);
    super.onDestroy();
    this.qQp.onDetach();
    AppMethodBeat.o(199212);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(199211);
    super.onPause();
    Object localObject = this.qEY;
    if (localObject != null)
    {
      localObject = ((FinderMsgContract.MsgViewCallback)localObject).qul;
      if (localObject != null)
      {
        ((WxRecyclerAdapter)localObject).onPause();
        AppMethodBeat.o(199211);
        return;
      }
    }
    AppMethodBeat.o(199211);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(199210);
    super.onResume();
    Object localObject = this.qEY;
    if (localObject != null)
    {
      localObject = ((FinderMsgContract.MsgViewCallback)localObject).qul;
      if (localObject != null)
      {
        ((WxRecyclerAdapter)localObject).onResume();
        AppMethodBeat.o(199210);
        return;
      }
    }
    AppMethodBeat.o(199210);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/FinderFinderMsgUI$Companion;", "", "()V", "MENU_ID_AT_TIMELINE", "", "getMENU_ID_AT_TIMELINE", "()I", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderFinderMsgUI paramFinderFinderMsgUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(199203);
      this.KYp.finish();
      AppMethodBeat.o(199203);
      return true;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class c
    implements MenuItem.OnMenuItemClickListener
  {
    c(FinderFinderMsgUI paramFinderFinderMsgUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(199207);
      paramMenuItem = new com.tencent.mm.ui.widget.a.e((Context)this.KYp, 1, false);
      paramMenuItem.a((n.c)1.KYq);
      paramMenuItem.a((n.d)new n.d()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(199206);
          k.g(paramAnonymousMenuItem, "menuItem");
          paramAnonymousInt = paramAnonymousMenuItem.getItemId();
          paramAnonymousMenuItem = FinderFinderMsgUI.KYo;
          if (paramAnonymousInt == FinderFinderMsgUI.fVr())
          {
            paramAnonymousMenuItem = new Intent();
            paramAnonymousMenuItem.putExtra("KEY_CACHE_ID", System.currentTimeMillis());
            Object localObject = FinderReporterUIC.Ljl;
            FinderReporterUIC.a.a((Context)this.KYr.KYp, paramAnonymousMenuItem, 0L, 0, false, 124);
            localObject = a.qSb;
            a.al((Context)this.KYr.KYp, paramAnonymousMenuItem);
          }
          AppMethodBeat.o(199206);
        }
      });
      paramMenuItem.csG();
      AppMethodBeat.o(199207);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderFinderMsgUI
 * JD-Core Version:    0.7.0.1
 */