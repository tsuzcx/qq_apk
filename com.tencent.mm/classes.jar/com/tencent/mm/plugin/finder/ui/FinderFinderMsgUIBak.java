package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract.MsgPresenter;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract.MsgViewCallback;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract.MsgViewCallback.UICallbackListener;
import com.tencent.mm.plugin.finder.storage.an;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderFinderMsgUIBak;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback$UICallbackListener;", "()V", "TAG", "", "msgPresenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgPresenter;", "viewCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback;", "getCommentScene", "", "getLayoutId", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onItemClick", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "onPause", "onResume", "onStop", "Companion", "plugin-finder_release"})
public final class FinderFinderMsgUIBak
  extends MMFinderUI
  implements FinderMsgContract.MsgViewCallback.UICallbackListener
{
  private static final int AqQ = 1;
  public static final a AqR;
  private final FinderMsgContract.MsgPresenter AqP;
  private final String TAG;
  private HashMap _$_findViewCache;
  private FinderMsgContract.MsgViewCallback zOC;
  
  static
  {
    AppMethodBeat.i(285028);
    AqR = new a((byte)0);
    AqQ = 1;
    AppMethodBeat.o(285028);
  }
  
  public FinderFinderMsgUIBak()
  {
    AppMethodBeat.i(285027);
    this.TAG = "Finder.FinderFinderMsgUI";
    this.AqP = new FinderMsgContract.MsgPresenter(1, new int[] { 1, 2, 3, 5, 10 });
    AppMethodBeat.o(285027);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(285030);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(285030);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(285029);
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
    AppMethodBeat.o(285029);
    return localView1;
  }
  
  public final void a(an paraman)
  {
    AppMethodBeat.i(285026);
    p.k(paraman, "mention");
    AppMethodBeat.o(285026);
  }
  
  public final int getCommentScene()
  {
    return 7;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_wx_msg_ui;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(285021);
    setMMTitle(getString(b.j.finder_msg_of_finder_title));
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    Object localObject = (MMActivity)this;
    View localView = getContentView();
    p.j(localView, "contentView");
    localObject = new FinderMsgContract.MsgViewCallback((MMActivity)localObject, localView, this.AqP, (FinderMsgContract.MsgViewCallback.UICallbackListener)this);
    this.AqP.a((FinderMsgContract.MsgViewCallback)localObject);
    ((FinderMsgContract.MsgViewCallback)localObject).initView();
    this.zOC = ((FinderMsgContract.MsgViewCallback)localObject);
    addIconOptionMenu(0, b.e.mm_title_btn_menu, (MenuItem.OnMenuItemClickListener)new c(this));
    localObject = h.aHG();
    p.j(localObject, "MMKernel.storage()");
    ((f)localObject).aHp().set(ar.a.VBo, Integer.valueOf(0));
    AppMethodBeat.o(285021);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(285020);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(285020);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(285024);
    super.onDestroy();
    this.AqP.onDetach();
    AppMethodBeat.o(285024);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(285023);
    super.onPause();
    Object localObject = this.zOC;
    if (localObject != null)
    {
      localObject = ((FinderMsgContract.MsgViewCallback)localObject).xnR;
      if (localObject != null)
      {
        ((WxRecyclerAdapter)localObject).onPause();
        AppMethodBeat.o(285023);
        return;
      }
    }
    AppMethodBeat.o(285023);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(285022);
    super.onResume();
    this.AqP.zOE = System.currentTimeMillis();
    Object localObject = this.zOC;
    if (localObject != null)
    {
      localObject = ((FinderMsgContract.MsgViewCallback)localObject).xnR;
      if (localObject != null)
      {
        ((WxRecyclerAdapter)localObject).onResume();
        AppMethodBeat.o(285022);
        return;
      }
    }
    AppMethodBeat.o(285022);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(285025);
    super.onStop();
    this.AqP.onStop();
    AppMethodBeat.o(285025);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderFinderMsgUIBak$Companion;", "", "()V", "MENU_ID_AT_TIMELINE", "", "getMENU_ID_AT_TIMELINE", "()I", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderFinderMsgUIBak paramFinderFinderMsgUIBak) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(290820);
      this.AqS.finish();
      AppMethodBeat.o(290820);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class c
    implements MenuItem.OnMenuItemClickListener
  {
    c(FinderFinderMsgUIBak paramFinderFinderMsgUIBak) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(274668);
      paramMenuItem = new e((Context)this.AqS, 1, false);
      paramMenuItem.a((q.f)1.AqT);
      paramMenuItem.a((q.g)new q.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(271653);
          p.j(paramAnonymousMenuItem, "menuItem");
          paramAnonymousInt = paramAnonymousMenuItem.getItemId();
          paramAnonymousMenuItem = FinderFinderMsgUIBak.AqR;
          if (paramAnonymousInt == FinderFinderMsgUIBak.eap())
          {
            paramAnonymousMenuItem = new Intent();
            paramAnonymousMenuItem.putExtra("KEY_CACHE_ID", System.currentTimeMillis());
            paramAnonymousMenuItem.putExtra("KEY_FROM_SCENE", 2);
            paramAnonymousMenuItem.putExtra("KEY_USERNAME", z.bdh());
            Object localObject = aj.Bnu;
            aj.a.a((Context)this.AqU.AqS, paramAnonymousMenuItem, 0L, 0, false, 124);
            localObject = a.ACH;
            a.ab((Context)this.AqU.AqS, paramAnonymousMenuItem);
          }
          AppMethodBeat.o(271653);
        }
      });
      paramMenuItem.eik();
      AppMethodBeat.o(274668);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderFinderMsgUIBak
 * JD-Core Version:    0.7.0.1
 */