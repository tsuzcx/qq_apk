package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.storage.ab;
import com.tencent.mm.plugin.finder.storage.ac;
import com.tencent.mm.plugin.finder.storage.aj;
import com.tencent.mm.plugin.finder.storage.aj.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.b;
import com.tencent.mm.ui.search.FTSEditTextView.c;
import com.tencent.mm.ui.search.a.b;
import com.tencent.mm.ui.search.a.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.h.c;
import com.tencent.mm.view.recyclerview.h.d;
import com.tencent.mm.view.recyclerview.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderBlockListSearchUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/ui/search/FTSSearchView$FTSSearchViewListener;", "Lcom/tencent/mm/ui/search/FTSEditTextView$FTSEditTextListener;", "()V", "DEL_MENU_ID", "", "getDEL_MENU_ID", "()I", "TAG", "", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/FinderContactConvertData;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "config", "Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig;", "setConfig", "(Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig;)V", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getData", "()Ljava/util/ArrayList;", "fillType", "getFillType", "()Ljava/lang/String;", "setFillType", "(Ljava/lang/String;)V", "netSceneFinderSearch", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSearch;", "searchView", "Lcom/tencent/mm/ui/search/FTSSearchView;", "getLayoutId", "initData", "", "initSearchView", "initView", "onClickBackBtn", "view", "Landroid/view/View;", "onClickCancelBtn", "onClickClearTextBtn", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onEditTextChange", "totalText", "inEditText", "tagList", "", "Lcom/tencent/mm/ui/search/FTSSearchView$IFTSTagModel;", "textChangeStatus", "Lcom/tencent/mm/ui/search/FTSEditTextView$TextChangeStatus;", "onEditTextFocusChange", "hasFocus", "", "onSearchKeyDown", "onTagClick", "index", "tag", "startSearch", "query", "Companion", "plugin-finder_release"})
public final class FinderBlockListSearchUI
  extends MMFinderUI
  implements FTSEditTextView.b, a.b
{
  private static final String Aor = "BLOCK_LIST_SEARCH_TYPE";
  public static final a Aos;
  private String Aoq;
  private final String TAG;
  private HashMap _$_findViewCache;
  final ArrayList<com.tencent.mm.plugin.finder.model.p> data;
  private com.tencent.mm.ui.search.a xNC;
  private WxRecyclerAdapter<com.tencent.mm.plugin.finder.model.p> xnR;
  aj zAg;
  final int zMI;
  
  static
  {
    AppMethodBeat.i(289428);
    Aos = new a((byte)0);
    Aor = "BLOCK_LIST_SEARCH_TYPE";
    AppMethodBeat.o(289428);
  }
  
  public FinderBlockListSearchUI()
  {
    AppMethodBeat.i(289427);
    this.TAG = "Finder.FinderBlockListSearchUI";
    this.data = new ArrayList();
    this.Aoq = "";
    AppMethodBeat.o(289427);
  }
  
  private final void aEi(String paramString)
  {
    AppMethodBeat.i(289424);
    Object localObject = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class);
    kotlin.g.b.p.j(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.n)localObject).bbL().d(null, paramString, this.Aoq, "", null);
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
    paramString = this.xnR;
    if (paramString != null) {
      paramString.notifyDataSetChanged();
    }
    paramString = (WxRecyclerView)_$_findCachedViewById(b.f.finder_block_list_search);
    kotlin.g.b.p.j(paramString, "finder_block_list_search");
    paramString.setVisibility(0);
    AppMethodBeat.o(289424);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(289431);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(289431);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(289430);
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
    AppMethodBeat.o(289430);
    return localView1;
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.c paramc)
  {
    AppMethodBeat.i(289425);
    if (paramString1 != null)
    {
      if (paramString1 == null)
      {
        paramString1 = new t("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(289425);
        throw paramString1;
      }
      paramString2 = kotlin.n.n.bb((CharSequence)paramString1).toString();
      paramString1 = paramString2;
      if (paramString2 != null) {}
    }
    else
    {
      paramString1 = "";
    }
    if (Util.isNullOrNil(paramString1)) {
      aEi("");
    }
    AppMethodBeat.o(289425);
  }
  
  public final boolean aDV()
  {
    AppMethodBeat.i(289423);
    hideVKB();
    Object localObject = this.xNC;
    if (localObject == null) {
      kotlin.g.b.p.bGy("searchView");
    }
    localObject = ((com.tencent.mm.ui.search.a)localObject).getFtsEditText();
    kotlin.g.b.p.j(localObject, "searchView.ftsEditText");
    localObject = ((FTSEditTextView)localObject).getTotalQuery();
    if (localObject != null)
    {
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(289423);
        throw ((Throwable)localObject);
      }
      String str = kotlin.n.n.bb((CharSequence)localObject).toString();
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    if (Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(289423);
      return true;
    }
    aEi((String)localObject);
    AppMethodBeat.o(289423);
    return false;
  }
  
  public final void dvg() {}
  
  public final void eF(boolean paramBoolean) {}
  
  public final int getLayoutId()
  {
    return b.g.finder_block_list_search;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(289420);
    Object localObject = (WxRecyclerView)_$_findCachedViewById(b.f.finder_block_list_search);
    kotlin.g.b.p.j(localObject, "finder_block_list_search");
    getContext();
    ((WxRecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    this.xnR = new WxRecyclerAdapter((f)new b(), this.data, true);
    localObject = (WxRecyclerView)_$_findCachedViewById(b.f.finder_block_list_search);
    kotlin.g.b.p.j(localObject, "finder_block_list_search");
    ((WxRecyclerView)localObject).setAdapter((RecyclerView.a)this.xnR);
    localObject = this.xnR;
    if (localObject != null) {
      ((com.tencent.mm.view.recyclerview.h)localObject).YSm = ((h.d)new c(this));
    }
    localObject = this.xnR;
    if (localObject != null)
    {
      ((com.tencent.mm.view.recyclerview.h)localObject).YSn = ((h.c)new d(this));
      AppMethodBeat.o(289420);
      return;
    }
    AppMethodBeat.o(289420);
  }
  
  public final void onClickBackBtn(View paramView)
  {
    AppMethodBeat.i(289422);
    hideVKB();
    finish();
    AppMethodBeat.o(289422);
  }
  
  public final void onClickCancelBtn(View paramView)
  {
    AppMethodBeat.i(289421);
    hideVKB();
    finish();
    AppMethodBeat.o(289421);
  }
  
  public final void onClickClearTextBtn(View paramView)
  {
    AppMethodBeat.i(289426);
    paramView = this.xNC;
    if (paramView == null) {
      kotlin.g.b.p.bGy("searchView");
    }
    paramView.getFtsEditText().aDU();
    showVKB();
    AppMethodBeat.o(289426);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(289419);
    super.onCreate(paramBundle);
    this.xNC = new com.tencent.mm.ui.search.a((Context)this);
    paramBundle = this.xNC;
    if (paramBundle == null) {
      kotlin.g.b.p.bGy("searchView");
    }
    paramBundle.setSearchViewListener((a.b)this);
    paramBundle = this.xNC;
    if (paramBundle == null) {
      kotlin.g.b.p.bGy("searchView");
    }
    paramBundle.getFtsEditText().setHint(getString(b.j.app_search));
    paramBundle = this.xNC;
    if (paramBundle == null) {
      kotlin.g.b.p.bGy("searchView");
    }
    paramBundle.getFtsEditText().setFtsEditTextListener((FTSEditTextView.b)this);
    paramBundle = this.xNC;
    if (paramBundle == null) {
      kotlin.g.b.p.bGy("searchView");
    }
    paramBundle.getFtsEditText().setCanDeleteTag(false);
    paramBundle = this.xNC;
    if (paramBundle == null) {
      kotlin.g.b.p.bGy("searchView");
    }
    paramBundle.getFtsEditText().hXB();
    paramBundle = getSupportActionBar();
    if (paramBundle == null) {
      kotlin.g.b.p.iCn();
    }
    kotlin.g.b.p.j(paramBundle, "supportActionBar!!");
    com.tencent.mm.ui.search.a locala = this.xNC;
    if (locala == null) {
      kotlin.g.b.p.bGy("searchView");
    }
    paramBundle.setCustomView((View)locala);
    paramBundle = this.xNC;
    if (paramBundle == null) {
      kotlin.g.b.p.bGy("searchView");
    }
    paramBundle.getFtsEditText().aDU();
    paramBundle = this.xNC;
    if (paramBundle == null) {
      kotlin.g.b.p.bGy("searchView");
    }
    paramBundle.getFtsEditText().aDT();
    initView();
    paramBundle = getIntent().getStringExtra(Aor);
    kotlin.g.b.p.j(paramBundle, "intent.getStringExtra(BLOCK_LIST_SEARCH_TYPE)");
    this.Aoq = paramBundle;
    paramBundle = this.Aoq;
    switch (paramBundle.hashCode())
    {
    default: 
      paramBundle = null;
    }
    for (;;)
    {
      this.zAg = paramBundle;
      aEi("");
      AppMethodBeat.o(289419);
      return;
      if (!paramBundle.equals("@finder.block.my.liked.android")) {
        break;
      }
      paramBundle = (aj)new ac();
      continue;
      if (!paramBundle.equals("@finder.block.his.liked.android")) {
        break;
      }
      paramBundle = (aj)new ab();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderBlockListSearchUI$Companion;", "", "()V", "BLOCK_LIST_SEARCH_TYPE", "", "getBLOCK_LIST_SEARCH_TYPE", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/FinderBlockListSearchUI$initView$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class b
    implements f
  {
    public final e<?> yx(int paramInt)
    {
      AppMethodBeat.i(272213);
      if (paramInt == com.tencent.mm.plugin.finder.model.p.class.getName().hashCode())
      {
        e locale = (e)new com.tencent.mm.plugin.finder.convert.a();
        AppMethodBeat.o(272213);
        return locale;
      }
      kotlin.g.b.p.iCn();
      AppMethodBeat.o(272213);
      return null;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/FinderBlockListSearchUI$initView$2", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemLongClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
  public static final class c
    implements h.d<i>
  {
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/FinderBlockListSearchUI$initView$2$onItemLongClick$1", "Landroid/view/View$OnCreateContextMenuListener;", "onCreateContextMenu", "", "menu", "Landroid/view/ContextMenu;", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "plugin-finder_release"})
    public static final class a
      implements View.OnCreateContextMenuListener
    {
      public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
      {
        AppMethodBeat.i(266761);
        if (paramContextMenu != null)
        {
          paramContextMenu.add(0, this.Aou.Aot.zMI, 0, b.j.finder_mod_block_poster_del);
          AppMethodBeat.o(266761);
          return;
        }
        AppMethodBeat.o(266761);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/FinderBlockListSearchUI$initView$2$onItemLongClick$2", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "onMMMenuItemSelected", "", "menuItem", "Landroid/view/MenuItem;", "index", "", "plugin-finder_release"})
    public static final class b
      implements q.g
    {
      b(int paramInt, RecyclerView.a parama) {}
      
      public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
      {
        AppMethodBeat.i(287681);
        if ((this.zMM >= 0) && (this.zMM < this.Aou.Aot.data.size()))
        {
          paramMenuItem = this.Aou.Aot.zAg;
          if (paramMenuItem != null)
          {
            paramMenuItem.a(((com.tencent.mm.plugin.finder.model.p)this.Aou.Aot.data.get(this.zMM)).contact, (aj.a)new a(this));
            AppMethodBeat.o(287681);
            return;
          }
        }
        AppMethodBeat.o(287681);
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/FinderBlockListSearchUI$initView$2$onItemLongClick$2$onMMMenuItemSelected$1", "Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig$OnItemDelCallBack;", "onDel", "", "success", "", "plugin-finder_release"})
      public static final class a
        implements aj.a
      {
        public final void pX(boolean paramBoolean)
        {
          AppMethodBeat.i(288821);
          if (paramBoolean)
          {
            this.Aov.Aou.Aot.data.remove(this.Aov.zMM);
            this.Aov.xAF.cN(((com.tencent.mm.view.recyclerview.h)this.Aov.xAF).YSk.size() + this.Aov.zMM);
            AppMethodBeat.o(288821);
            return;
          }
          w.makeText((Context)this.Aov.Aou.Aot.getContext(), (CharSequence)"failed", 0).show();
          AppMethodBeat.o(288821);
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/FinderBlockListSearchUI$initView$3", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
  public static final class d
    implements h.c<i>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderBlockListSearchUI
 * JD-Core Version:    0.7.0.1
 */