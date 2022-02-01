package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.ad;
import com.tencent.mm.plugin.finder.storage.ae;
import com.tencent.mm.plugin.finder.storage.ak;
import com.tencent.mm.plugin.finder.storage.ak.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.a;
import com.tencent.mm.ui.search.FTSEditTextView.b;
import com.tencent.mm.ui.search.a;
import com.tencent.mm.ui.search.a.b;
import com.tencent.mm.ui.search.a.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.g.c;
import com.tencent.mm.view.recyclerview.g.d;
import com.tencent.mm.view.recyclerview.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.n.n;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderBlockListSearchUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/ui/search/FTSSearchView$FTSSearchViewListener;", "Lcom/tencent/mm/ui/search/FTSEditTextView$FTSEditTextListener;", "()V", "DEL_MENU_ID", "", "getDEL_MENU_ID", "()I", "TAG", "", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/FinderContactConvertData;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "config", "Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig;", "setConfig", "(Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig;)V", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getData", "()Ljava/util/ArrayList;", "fillType", "getFillType", "()Ljava/lang/String;", "setFillType", "(Ljava/lang/String;)V", "netSceneFinderSearch", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSearch;", "searchView", "Lcom/tencent/mm/ui/search/FTSSearchView;", "getLayoutId", "initData", "", "initSearchView", "initView", "onClickBackBtn", "view", "Landroid/view/View;", "onClickCancelBtn", "onClickClearTextBtn", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onEditTextChange", "totalText", "inEditText", "tagList", "", "Lcom/tencent/mm/ui/search/FTSSearchView$IFTSTagModel;", "textChangeStatus", "Lcom/tencent/mm/ui/search/FTSEditTextView$TextChangeStatus;", "onEditTextFocusChange", "hasFocus", "", "onSearchKeyDown", "onTagClick", "index", "tag", "startSearch", "query", "Companion", "plugin-finder_release"})
public final class FinderBlockListSearchUI
  extends MMFinderUI
  implements FTSEditTextView.a, a.b
{
  private static final String vHu = "BLOCK_LIST_SEARCH_TYPE";
  public static final a vHv;
  private final String TAG;
  private HashMap _$_findViewCache;
  final ArrayList<com.tencent.mm.plugin.finder.model.p> data;
  private WxRecyclerAdapter<com.tencent.mm.plugin.finder.model.p> tFp;
  ak uWp;
  final int uWt;
  private a ubO;
  private String vHt;
  
  static
  {
    AppMethodBeat.i(252151);
    vHv = new a((byte)0);
    vHu = "BLOCK_LIST_SEARCH_TYPE";
    AppMethodBeat.o(252151);
  }
  
  public FinderBlockListSearchUI()
  {
    AppMethodBeat.i(252150);
    this.TAG = "Finder.FinderBlockListSearchUI";
    this.data = new ArrayList();
    this.vHt = "";
    AppMethodBeat.o(252150);
  }
  
  private final void auV(String paramString)
  {
    AppMethodBeat.i(252147);
    Object localObject = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    kotlin.g.b.p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).aSN().d(null, paramString, this.vHt, "", null);
    localObject = new LinkedList();
    while (paramString.moveToNext())
    {
      as localas = new as();
      localas.convertFrom(paramString);
      FinderContact localFinderContact = new FinderContact();
      localFinderContact.username = localas.getUsername();
      ((LinkedList)localObject).add(localFinderContact);
    }
    localObject = (Iterable)localObject;
    paramString = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramString.add(new com.tencent.mm.plugin.finder.model.p((FinderContact)((Iterator)localObject).next()));
    }
    paramString = (List)paramString;
    this.data.clear();
    this.data.addAll((Collection)paramString);
    paramString = this.tFp;
    if (paramString != null) {
      paramString.notifyDataSetChanged();
    }
    paramString = (WxRecyclerView)_$_findCachedViewById(2131300780);
    kotlin.g.b.p.g(paramString, "finder_block_list_search");
    paramString.setVisibility(0);
    AppMethodBeat.o(252147);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(252153);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(252153);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(252152);
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
    AppMethodBeat.o(252152);
    return localView1;
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(252148);
    if (paramString1 != null)
    {
      if (paramString1 == null)
      {
        paramString1 = new t("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(252148);
        throw paramString1;
      }
      paramString2 = n.trim((CharSequence)paramString1).toString();
      paramString1 = paramString2;
      if (paramString2 != null) {}
    }
    else
    {
      paramString1 = "";
    }
    if (Util.isNullOrNil(paramString1)) {
      auV("");
    }
    AppMethodBeat.o(252148);
  }
  
  public final boolean awE()
  {
    AppMethodBeat.i(252146);
    hideVKB();
    Object localObject = this.ubO;
    if (localObject == null) {
      kotlin.g.b.p.btv("searchView");
    }
    localObject = ((a)localObject).getFtsEditText();
    kotlin.g.b.p.g(localObject, "searchView.ftsEditText");
    localObject = ((FTSEditTextView)localObject).getTotalQuery();
    if (localObject != null)
    {
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(252146);
        throw ((Throwable)localObject);
      }
      String str = n.trim((CharSequence)localObject).toString();
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    if (Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(252146);
      return true;
    }
    auV((String)localObject);
    AppMethodBeat.o(252146);
    return false;
  }
  
  public final void dpw() {}
  
  public final void eh(boolean paramBoolean) {}
  
  public final int getLayoutId()
  {
    return 2131494205;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(252143);
    Object localObject = (WxRecyclerView)_$_findCachedViewById(2131300780);
    kotlin.g.b.p.g(localObject, "finder_block_list_search");
    getContext();
    ((WxRecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    this.tFp = new WxRecyclerAdapter((f)new FinderBlockListSearchUI.b(), this.data, true);
    localObject = (WxRecyclerView)_$_findCachedViewById(2131300780);
    kotlin.g.b.p.g(localObject, "finder_block_list_search");
    ((WxRecyclerView)localObject).setAdapter((RecyclerView.a)this.tFp);
    localObject = this.tFp;
    if (localObject != null) {
      ((com.tencent.mm.view.recyclerview.g)localObject).RqO = ((g.d)new c(this));
    }
    localObject = this.tFp;
    if (localObject != null)
    {
      ((com.tencent.mm.view.recyclerview.g)localObject).RqP = ((g.c)new d(this));
      AppMethodBeat.o(252143);
      return;
    }
    AppMethodBeat.o(252143);
  }
  
  public final void onClickBackBtn(View paramView)
  {
    AppMethodBeat.i(252145);
    hideVKB();
    finish();
    AppMethodBeat.o(252145);
  }
  
  public final void onClickCancelBtn(View paramView)
  {
    AppMethodBeat.i(252144);
    hideVKB();
    finish();
    AppMethodBeat.o(252144);
  }
  
  public final void onClickClearTextBtn(View paramView)
  {
    AppMethodBeat.i(252149);
    paramView = this.ubO;
    if (paramView == null) {
      kotlin.g.b.p.btv("searchView");
    }
    paramView.getFtsEditText().awD();
    showVKB();
    AppMethodBeat.o(252149);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(252142);
    super.onCreate(paramBundle);
    this.ubO = new a((Context)this);
    paramBundle = this.ubO;
    if (paramBundle == null) {
      kotlin.g.b.p.btv("searchView");
    }
    paramBundle.setSearchViewListener((a.b)this);
    paramBundle = this.ubO;
    if (paramBundle == null) {
      kotlin.g.b.p.btv("searchView");
    }
    paramBundle.getFtsEditText().setHint(getString(2131755972));
    paramBundle = this.ubO;
    if (paramBundle == null) {
      kotlin.g.b.p.btv("searchView");
    }
    paramBundle.getFtsEditText().setFtsEditTextListener((FTSEditTextView.a)this);
    paramBundle = this.ubO;
    if (paramBundle == null) {
      kotlin.g.b.p.btv("searchView");
    }
    paramBundle.getFtsEditText().setCanDeleteTag(false);
    paramBundle = this.ubO;
    if (paramBundle == null) {
      kotlin.g.b.p.btv("searchView");
    }
    paramBundle.getFtsEditText().gWY();
    paramBundle = getSupportActionBar();
    if (paramBundle == null) {
      kotlin.g.b.p.hyc();
    }
    kotlin.g.b.p.g(paramBundle, "supportActionBar!!");
    a locala = this.ubO;
    if (locala == null) {
      kotlin.g.b.p.btv("searchView");
    }
    paramBundle.setCustomView((View)locala);
    paramBundle = this.ubO;
    if (paramBundle == null) {
      kotlin.g.b.p.btv("searchView");
    }
    paramBundle.getFtsEditText().awD();
    paramBundle = this.ubO;
    if (paramBundle == null) {
      kotlin.g.b.p.btv("searchView");
    }
    paramBundle.getFtsEditText().awC();
    initView();
    paramBundle = getIntent().getStringExtra(vHu);
    kotlin.g.b.p.g(paramBundle, "intent.getStringExtra(BLOCK_LIST_SEARCH_TYPE)");
    this.vHt = paramBundle;
    paramBundle = this.vHt;
    switch (paramBundle.hashCode())
    {
    default: 
      paramBundle = null;
    }
    for (;;)
    {
      this.uWp = paramBundle;
      auV("");
      AppMethodBeat.o(252142);
      return;
      if (!paramBundle.equals("@finder.block.my.liked.android")) {
        break;
      }
      paramBundle = (ak)new ae();
      continue;
      if (!paramBundle.equals("@finder.block.his.liked.android")) {
        break;
      }
      paramBundle = (ak)new ad();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderBlockListSearchUI$Companion;", "", "()V", "BLOCK_LIST_SEARCH_TYPE", "", "getBLOCK_LIST_SEARCH_TYPE", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderBlockListSearchUI$initView$2", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemLongClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
  public static final class c
    implements g.d<h>
  {
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderBlockListSearchUI$initView$2$onItemLongClick$1", "Landroid/view/View$OnCreateContextMenuListener;", "onCreateContextMenu", "", "menu", "Landroid/view/ContextMenu;", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "plugin-finder_release"})
    public static final class a
      implements View.OnCreateContextMenuListener
    {
      public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
      {
        AppMethodBeat.i(252137);
        if (paramContextMenu != null)
        {
          paramContextMenu.add(0, this.vHx.vHw.uWt, 0, 2131760270);
          AppMethodBeat.o(252137);
          return;
        }
        AppMethodBeat.o(252137);
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderBlockListSearchUI$initView$2$onItemLongClick$2", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "onMMMenuItemSelected", "", "menuItem", "Landroid/view/MenuItem;", "index", "", "plugin-finder_release"})
    public static final class b
      implements o.g
    {
      b(int paramInt, RecyclerView.a parama) {}
      
      public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
      {
        AppMethodBeat.i(252139);
        if ((this.uWy >= 0) && (this.uWy < this.vHx.vHw.data.size()))
        {
          paramMenuItem = this.vHx.vHw.uWp;
          if (paramMenuItem != null)
          {
            paramMenuItem.a(((com.tencent.mm.plugin.finder.model.p)this.vHx.vHw.data.get(this.uWy)).contact, (ak.a)new a(this));
            AppMethodBeat.o(252139);
            return;
          }
        }
        AppMethodBeat.o(252139);
      }
      
      @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderBlockListSearchUI$initView$2$onItemLongClick$2$onMMMenuItemSelected$1", "Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig$OnItemDelCallBack;", "onDel", "", "success", "", "plugin-finder_release"})
      public static final class a
        implements ak.a
      {
        public final void nN(boolean paramBoolean)
        {
          AppMethodBeat.i(252138);
          if (paramBoolean)
          {
            this.vHy.vHx.vHw.data.remove(this.vHy.uWy);
            this.vHy.tPP.ck(((com.tencent.mm.view.recyclerview.g)this.vHy.tPP).RqM.size() + this.vHy.uWy);
            AppMethodBeat.o(252138);
            return;
          }
          u.makeText((Context)this.vHy.vHx.vHw.getContext(), (CharSequence)"failed", 0).show();
          AppMethodBeat.o(252138);
        }
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderBlockListSearchUI$initView$3", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
  public static final class d
    implements g.c<h>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderBlockListSearchUI
 * JD-Core Version:    0.7.0.1
 */