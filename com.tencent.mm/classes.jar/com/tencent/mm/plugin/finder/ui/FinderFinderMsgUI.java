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
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import d.g.b.p;
import java.util.HashMap;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/FinderFinderMsgUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback$UICallbackListener;", "()V", "TAG", "", "msgPresenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgPresenter;", "viewCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback;", "getCommentScene", "", "getLayoutId", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onItemClick", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "onPause", "onResume", "onStop", "Companion", "plugin-finder_release"})
public final class FinderFinderMsgUI
  extends MMFinderUI
  implements FinderMsgContract.MsgViewCallback.UICallbackListener
{
  public static final a sCA;
  private static final int sCz = 1;
  private final String TAG;
  private HashMap _$_findViewCache;
  private final FinderMsgContract.MsgPresenter sCy;
  private FinderMsgContract.MsgViewCallback smC;
  
  static
  {
    AppMethodBeat.i(203973);
    sCA = new a((byte)0);
    sCz = 1;
    AppMethodBeat.o(203973);
  }
  
  public FinderFinderMsgUI()
  {
    AppMethodBeat.i(203972);
    this.TAG = "Finder.FinderFinderMsgUI";
    this.sCy = new FinderMsgContract.MsgPresenter(1, new int[] { 1, 2, 3, 5, 10 });
    AppMethodBeat.o(203972);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(203974);
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
    AppMethodBeat.o(203974);
    return localView1;
  }
  
  public final void a(ac paramac)
  {
    AppMethodBeat.i(203971);
    p.h(paramac, "mention");
    AppMethodBeat.o(203971);
  }
  
  public final int cAZ()
  {
    return 7;
  }
  
  public final int getLayoutId()
  {
    return 2131494128;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(203966);
    setMMTitle(getString(2131766445));
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    Object localObject = (MMActivity)this;
    View localView = getContentView();
    p.g(localView, "contentView");
    localObject = new FinderMsgContract.MsgViewCallback((MMActivity)localObject, localView, this.sCy, (FinderMsgContract.MsgViewCallback.UICallbackListener)this);
    this.sCy.a((FinderMsgContract.MsgViewCallback)localObject);
    ((FinderMsgContract.MsgViewCallback)localObject).initView();
    this.smC = ((FinderMsgContract.MsgViewCallback)localObject);
    addIconOptionMenu(0, 2131233291, (MenuItem.OnMenuItemClickListener)new c(this));
    localObject = g.ajC();
    p.g(localObject, "MMKernel.storage()");
    ((com.tencent.mm.kernel.e)localObject).ajl().set(al.a.IIB, Integer.valueOf(0));
    AppMethodBeat.o(203966);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(203965);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(203965);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(203969);
    super.onDestroy();
    this.sCy.onDetach();
    AppMethodBeat.o(203969);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(203968);
    super.onPause();
    Object localObject = this.smC;
    if (localObject != null)
    {
      localObject = ((FinderMsgContract.MsgViewCallback)localObject).rPu;
      if (localObject != null)
      {
        ((WxRecyclerAdapter)localObject).onPause();
        AppMethodBeat.o(203968);
        return;
      }
    }
    AppMethodBeat.o(203968);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(203967);
    super.onResume();
    this.sCy.smE = System.currentTimeMillis();
    Object localObject = this.smC;
    if (localObject != null)
    {
      localObject = ((FinderMsgContract.MsgViewCallback)localObject).rPu;
      if (localObject != null)
      {
        ((WxRecyclerAdapter)localObject).onResume();
        AppMethodBeat.o(203967);
        return;
      }
    }
    AppMethodBeat.o(203967);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(203970);
    super.onStop();
    this.sCy.onStop();
    AppMethodBeat.o(203970);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/FinderFinderMsgUI$Companion;", "", "()V", "MENU_ID_AT_TIMELINE", "", "getMENU_ID_AT_TIMELINE", "()I", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderFinderMsgUI paramFinderFinderMsgUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(203960);
      this.sCB.finish();
      AppMethodBeat.o(203960);
      return true;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class c
    implements MenuItem.OnMenuItemClickListener
  {
    c(FinderFinderMsgUI paramFinderFinderMsgUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(203964);
      paramMenuItem = new com.tencent.mm.ui.widget.a.e((Context)this.sCB, 1, false);
      paramMenuItem.a((n.d)1.sCC);
      paramMenuItem.a((n.e)new n.e()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(203963);
          p.g(paramAnonymousMenuItem, "menuItem");
          paramAnonymousInt = paramAnonymousMenuItem.getItemId();
          paramAnonymousMenuItem = FinderFinderMsgUI.sCA;
          if (paramAnonymousInt == FinderFinderMsgUI.cJK())
          {
            paramAnonymousMenuItem = new Intent();
            paramAnonymousMenuItem.putExtra("KEY_CACHE_ID", System.currentTimeMillis());
            Object localObject = FinderReporterUIC.tcM;
            FinderReporterUIC.a.a((Context)this.sCD.sCB, paramAnonymousMenuItem, 0L, 0, false, 124);
            localObject = a.sKD;
            a.V((Context)this.sCD.sCB, paramAnonymousMenuItem);
          }
          AppMethodBeat.o(203963);
        }
      });
      paramMenuItem.cMW();
      AppMethodBeat.o(203964);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderFinderMsgUI
 * JD-Core Version:    0.7.0.1
 */