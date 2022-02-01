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
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract.MsgPresenter;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract.MsgViewCallback;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract.MsgViewCallback.UICallbackListener;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderFinderMsgUIBak;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback$UICallbackListener;", "()V", "TAG", "", "msgPresenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgPresenter;", "viewCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback;", "getCommentScene", "", "getLayoutId", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onItemClick", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "onPause", "onResume", "onStop", "Companion", "plugin-finder_release"})
public final class FinderFinderMsgUIBak
  extends MMFinderUI
  implements FinderMsgContract.MsgViewCallback.UICallbackListener
{
  private static final int vJY = 1;
  public static final a vJZ;
  private final String TAG;
  private HashMap _$_findViewCache;
  private FinderMsgContract.MsgViewCallback uYo;
  private final FinderMsgContract.MsgPresenter vJX;
  
  static
  {
    AppMethodBeat.i(252355);
    vJZ = new a((byte)0);
    vJY = 1;
    AppMethodBeat.o(252355);
  }
  
  public FinderFinderMsgUIBak()
  {
    AppMethodBeat.i(252354);
    this.TAG = "Finder.FinderFinderMsgUI";
    this.vJX = new FinderMsgContract.MsgPresenter(1, new int[] { 1, 2, 3, 5, 10 });
    AppMethodBeat.o(252354);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(252357);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(252357);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(252356);
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
    AppMethodBeat.o(252356);
    return localView1;
  }
  
  public final void a(com.tencent.mm.plugin.finder.storage.ao paramao)
  {
    AppMethodBeat.i(252353);
    p.h(paramao, "mention");
    AppMethodBeat.o(252353);
  }
  
  public final int getCommentScene()
  {
    return 7;
  }
  
  public final int getLayoutId()
  {
    return 2131494679;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(252348);
    setMMTitle(getString(2131760302));
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    Object localObject = (MMActivity)this;
    View localView = getContentView();
    p.g(localView, "contentView");
    localObject = new FinderMsgContract.MsgViewCallback((MMActivity)localObject, localView, this.vJX, (FinderMsgContract.MsgViewCallback.UICallbackListener)this);
    this.vJX.a((FinderMsgContract.MsgViewCallback)localObject);
    ((FinderMsgContract.MsgViewCallback)localObject).initView();
    this.uYo = ((FinderMsgContract.MsgViewCallback)localObject);
    addIconOptionMenu(0, 2131233966, (MenuItem.OnMenuItemClickListener)new c(this));
    localObject = g.aAh();
    p.g(localObject, "MMKernel.storage()");
    ((com.tencent.mm.kernel.e)localObject).azQ().set(ar.a.Omr, Integer.valueOf(0));
    AppMethodBeat.o(252348);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(252347);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(252347);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(252351);
    super.onDestroy();
    this.vJX.onDetach();
    AppMethodBeat.o(252351);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(252350);
    super.onPause();
    Object localObject = this.uYo;
    if (localObject != null)
    {
      localObject = ((FinderMsgContract.MsgViewCallback)localObject).tFp;
      if (localObject != null)
      {
        ((WxRecyclerAdapter)localObject).onPause();
        AppMethodBeat.o(252350);
        return;
      }
    }
    AppMethodBeat.o(252350);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(252349);
    super.onResume();
    this.vJX.uYq = System.currentTimeMillis();
    Object localObject = this.uYo;
    if (localObject != null)
    {
      localObject = ((FinderMsgContract.MsgViewCallback)localObject).tFp;
      if (localObject != null)
      {
        ((WxRecyclerAdapter)localObject).onResume();
        AppMethodBeat.o(252349);
        return;
      }
    }
    AppMethodBeat.o(252349);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(252352);
    super.onStop();
    this.vJX.onStop();
    AppMethodBeat.o(252352);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderFinderMsgUIBak$Companion;", "", "()V", "MENU_ID_AT_TIMELINE", "", "getMENU_ID_AT_TIMELINE", "()I", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderFinderMsgUIBak paramFinderFinderMsgUIBak) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(252342);
      this.vKa.finish();
      AppMethodBeat.o(252342);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class c
    implements MenuItem.OnMenuItemClickListener
  {
    c(FinderFinderMsgUIBak paramFinderFinderMsgUIBak) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(252346);
      paramMenuItem = new com.tencent.mm.ui.widget.a.e((Context)this.vKa, 1, false);
      paramMenuItem.a((o.f)1.vKb);
      paramMenuItem.a((o.g)new o.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(252345);
          p.g(paramAnonymousMenuItem, "menuItem");
          paramAnonymousInt = paramAnonymousMenuItem.getItemId();
          paramAnonymousMenuItem = FinderFinderMsgUIBak.vJZ;
          if (paramAnonymousInt == FinderFinderMsgUIBak.dzv())
          {
            paramAnonymousMenuItem = new Intent();
            paramAnonymousMenuItem.putExtra("KEY_CACHE_ID", System.currentTimeMillis());
            paramAnonymousMenuItem.putExtra("KEY_FROM_SCENE", 2);
            paramAnonymousMenuItem.putExtra("KEY_USERNAME", z.aUg());
            Object localObject = FinderReporterUIC.wzC;
            FinderReporterUIC.a.a((Context)this.vKc.vKa, paramAnonymousMenuItem, 0L, 0, false, 124);
            localObject = a.vUU;
            a.ab((Context)this.vKc.vKa, paramAnonymousMenuItem);
          }
          AppMethodBeat.o(252345);
        }
      });
      paramMenuItem.dGm();
      AppMethodBeat.o(252346);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderFinderMsgUIBak
 * JD-Core Version:    0.7.0.1
 */