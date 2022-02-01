package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.presenter.contract.FinderBlockListContract.BlockListPresenter;
import com.tencent.mm.plugin.finder.presenter.contract.FinderBlockListContract.BlockListViewCallback;
import com.tencent.mm.plugin.finder.storage.ab;
import com.tencent.mm.plugin.finder.storage.ac;
import com.tencent.mm.plugin.finder.storage.aj;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.contact.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderBlockListUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "config", "Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig;", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderBlockListContract$BlockListPresenter;", "type", "", "viewCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderBlockListContract$BlockListViewCallback;", "getLayoutId", "initView", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "Companion", "plugin-finder_release"})
public final class FinderBlockListUI
  extends MMFinderUI
{
  private static final int Aow = 1;
  private static final int Aox = 20;
  private static final int Aoy = 1;
  public static final a Aoz;
  private final String TAG = "Finder.FinderBlockListUI";
  private HashMap _$_findViewCache;
  private int type;
  private aj zAg;
  private FinderBlockListContract.BlockListViewCallback zME;
  private FinderBlockListContract.BlockListPresenter zMG;
  
  static
  {
    AppMethodBeat.i(281782);
    Aoz = new a((byte)0);
    Aow = 1;
    Aox = 20;
    Aoy = 1;
    AppMethodBeat.o(281782);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(281786);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(281786);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(281785);
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
    AppMethodBeat.o(281785);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_block_list_layout;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(281777);
    this.type = getIntent().getIntExtra("BLOCK_LIST_TYPE", 0);
    Object localObject1;
    switch (this.type)
    {
    default: 
      localObject1 = null;
    }
    for (;;)
    {
      this.zAg = ((aj)localObject1);
      if (this.zAg == null) {
        finish();
      }
      localObject1 = this.zAg;
      if (localObject1 == null) {
        kotlin.g.b.p.iCn();
      }
      setMMTitle(((aj)localObject1).dRw());
      setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
      localObject1 = this.zAg;
      if (localObject1 == null) {
        kotlin.g.b.p.iCn();
      }
      this.zMG = new FinderBlockListContract.BlockListPresenter((aj)localObject1);
      localObject1 = (MMActivity)this;
      Object localObject2 = getContentView();
      kotlin.g.b.p.j(localObject2, "contentView");
      FinderBlockListContract.BlockListPresenter localBlockListPresenter = this.zMG;
      if (localBlockListPresenter == null) {
        kotlin.g.b.p.iCn();
      }
      localObject1 = new FinderBlockListContract.BlockListViewCallback((MMActivity)localObject1, (View)localObject2, localBlockListPresenter);
      localObject2 = this.zMG;
      if (localObject2 == null) {
        kotlin.g.b.p.iCn();
      }
      ((FinderBlockListContract.BlockListPresenter)localObject2).a((FinderBlockListContract.BlockListViewCallback)localObject1);
      ((FinderBlockListContract.BlockListViewCallback)localObject1).initView();
      this.zME = ((FinderBlockListContract.BlockListViewCallback)localObject1);
      localObject1 = this.zAg;
      if (localObject1 == null) {
        kotlin.g.b.p.iCn();
      }
      if (((aj)localObject1).dRz()) {
        addIconOptionMenu(0, b.i.icons_outlined_add_friends, (MenuItem.OnMenuItemClickListener)new c(this));
      }
      AppMethodBeat.o(281777);
      return;
      localObject1 = (aj)new c();
      continue;
      localObject1 = (aj)new ab();
      continue;
      localObject1 = (aj)new ac();
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(281778);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == Aoy)
    {
      if (paramIntent != null) {}
      for (paramIntent = paramIntent.getStringExtra("Select_Contact");; paramIntent = null)
      {
        paramIntent = Util.stringToList(paramIntent, ",");
        kotlin.g.b.p.j(paramIntent, "nameList");
        localObject = (Iterable)paramIntent;
        paramIntent = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          FinderContact localFinderContact = new FinderContact();
          localFinderContact.username = str;
          paramIntent.add(localFinderContact);
        }
      }
      paramIntent = (List)paramIntent;
      Object localObject = this.zMG;
      if (localObject != null)
      {
        ((FinderBlockListContract.BlockListPresenter)localObject).eF(paramIntent);
        AppMethodBeat.o(281778);
        return;
      }
    }
    AppMethodBeat.o(281778);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(281775);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(281775);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(281780);
    super.onDestroy();
    FinderBlockListContract.BlockListPresenter localBlockListPresenter = this.zMG;
    if (localBlockListPresenter != null)
    {
      localBlockListPresenter.onDetach();
      AppMethodBeat.o(281780);
      return;
    }
    AppMethodBeat.o(281780);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(281781);
    super.onResume();
    FinderBlockListContract.BlockListPresenter localBlockListPresenter = this.zMG;
    if (localBlockListPresenter != null)
    {
      localBlockListPresenter.ata();
      AppMethodBeat.o(281781);
      return;
    }
    AppMethodBeat.o(281781);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderBlockListUI$Companion;", "", "()V", "MAX_MULTI_SELECTED_USER", "", "getMAX_MULTI_SELECTED_USER", "()I", "MENU_ID_ADD_USER", "getMENU_ID_ADD_USER", "REQUEST_CODE_MULTI_ADDR", "getREQUEST_CODE_MULTI_ADDR", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderBlockListUI paramFinderBlockListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(276184);
      this.AoA.finish();
      AppMethodBeat.o(276184);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class c
    implements MenuItem.OnMenuItemClickListener
  {
    c(FinderBlockListUI paramFinderBlockListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(290461);
      Log.i(FinderBlockListUI.a(this.AoA), "doCallSelectContactUIForMultiRetransmit");
      paramMenuItem = new Intent();
      paramMenuItem.setClassName((Context)this.AoA, "com.tencent.mm.ui.contact.SelectContactUI");
      paramMenuItem.putExtra("list_type", 1);
      paramMenuItem.putExtra("titile", this.AoA.getString(b.j.finder_mod_block_select_user));
      paramMenuItem.putExtra("list_attr", w.XtL);
      Object localObject1 = FinderBlockListUI.b(this.AoA);
      if (localObject1 == null) {
        kotlin.g.b.p.iCn();
      }
      Object localObject2 = (Iterable)((FinderBlockListContract.BlockListPresenter)localObject1).mXB;
      localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add(((com.tencent.mm.plugin.finder.model.p)((Iterator)localObject2).next()).contact.username);
      }
      paramMenuItem.putExtra("always_select_contact", Util.listToString((List)localObject1, ","));
      paramMenuItem.putExtra("block_contact", z.bcZ());
      localObject1 = FinderBlockListUI.Aoz;
      paramMenuItem.putExtra("max_limit_num", FinderBlockListUI.dZO());
      paramMenuItem.putExtra("Forbid_SelectChatRoom", true);
      paramMenuItem.putExtra("show_too_many_member", false);
      localObject1 = this.AoA.getContext();
      localObject2 = FinderBlockListUI.Aoz;
      ((AppCompatActivity)localObject1).startActivityForResult(paramMenuItem, FinderBlockListUI.dZP());
      AppMethodBeat.o(290461);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderBlockListUI
 * JD-Core Version:    0.7.0.1
 */