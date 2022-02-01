package com.tencent.mm.plugin.finder.ui;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.convert.a;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.storage.ae;
import com.tencent.mm.plugin.finder.storage.af;
import com.tencent.mm.plugin.finder.storage.ar;
import com.tencent.mm.plugin.finder.storage.ar.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.c;
import com.tencent.mm.ui.search.FTSEditTextView.d;
import com.tencent.mm.ui.search.FTSSearchView;
import com.tencent.mm.ui.search.FTSSearchView.b;
import com.tencent.mm.ui.search.FTSSearchView.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.i;
import com.tencent.mm.view.recyclerview.i.c;
import com.tencent.mm.view.recyclerview.i.d;
import com.tencent.mm.view.recyclerview.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderBlockListSearchUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/ui/search/FTSSearchView$FTSSearchViewListener;", "Lcom/tencent/mm/ui/search/FTSEditTextView$FTSEditTextListener;", "()V", "DEL_MENU_ID", "", "getDEL_MENU_ID", "()I", "TAG", "", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/FinderContactConvertData;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "config", "Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig;", "setConfig", "(Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig;)V", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getData", "()Ljava/util/ArrayList;", "fillType", "getFillType", "()Ljava/lang/String;", "setFillType", "(Ljava/lang/String;)V", "netSceneFinderSearch", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSearch;", "searchView", "Lcom/tencent/mm/ui/search/FTSSearchView;", "getLayoutId", "initData", "", "initSearchView", "initView", "onClickBackBtn", "view", "Landroid/view/View;", "onClickCancelBtn", "onClickClearTextBtn", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onEditTextChange", "totalText", "inEditText", "tagList", "", "Lcom/tencent/mm/ui/search/FTSSearchView$IFTSTagModel;", "textChangeStatus", "Lcom/tencent/mm/ui/search/FTSEditTextView$TextChangeStatus;", "onEditTextFocusChange", "hasFocus", "", "onSearchKeyDown", "onTagClick", "index", "tag", "startSearch", "query", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderBlockListSearchUI
  extends MMFinderUI
  implements FTSEditTextView.c, FTSSearchView.b
{
  public static final a FOH;
  private static final String FOJ;
  private WxRecyclerAdapter<com.tencent.mm.plugin.finder.model.p> ALE;
  private FTSSearchView Bny;
  ar ECo;
  final int EXA;
  private String FOI;
  private final String TAG;
  final ArrayList<com.tencent.mm.plugin.finder.model.p> data;
  
  static
  {
    AppMethodBeat.i(346793);
    FOH = new a((byte)0);
    FOJ = "BLOCK_LIST_SEARCH_TYPE";
    AppMethodBeat.o(346793);
  }
  
  public FinderBlockListSearchUI()
  {
    AppMethodBeat.i(346772);
    this.TAG = "Finder.FinderBlockListSearchUI";
    this.data = new ArrayList();
    this.FOI = "";
    AppMethodBeat.o(346772);
  }
  
  private final void awg(String paramString)
  {
    AppMethodBeat.i(346781);
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().d(null, paramString, this.FOI, "", null);
    Object localObject1 = new LinkedList();
    while (paramString.moveToNext())
    {
      Object localObject2 = new au();
      ((au)localObject2).convertFrom(paramString);
      FinderContact localFinderContact = new FinderContact();
      localFinderContact.username = ((az)localObject2).field_username;
      localObject2 = ah.aiuX;
      ((LinkedList)localObject1).add(localFinderContact);
    }
    localObject1 = (Iterable)localObject1;
    paramString = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      paramString.add(new com.tencent.mm.plugin.finder.model.p((FinderContact)((Iterator)localObject1).next()));
    }
    paramString = (List)paramString;
    this.data.clear();
    this.data.addAll((Collection)paramString);
    paramString = this.ALE;
    if (paramString != null) {
      paramString.bZE.notifyChanged();
    }
    ((WxRecyclerView)findViewById(e.e.finder_block_list_search)).setVisibility(0);
    AppMethodBeat.o(346781);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final boolean aWU()
  {
    AppMethodBeat.i(346843);
    hideVKB();
    Object localObject2 = this.Bny;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("searchView");
      localObject1 = null;
    }
    localObject1 = ((FTSSearchView)localObject1).getFtsEditText().getTotalQuery();
    if (localObject1 == null) {
      localObject1 = "";
    }
    while (Util.isNullOrNil((String)localObject1))
    {
      AppMethodBeat.o(346843);
      return true;
      localObject2 = kotlin.n.n.bq((CharSequence)localObject1).toString();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
    }
    awg((String)localObject1);
    AppMethodBeat.o(346843);
    return false;
  }
  
  public final void eeU() {}
  
  public final void fq(boolean paramBoolean) {}
  
  public final int getLayoutId()
  {
    return e.f.finder_block_list_search;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(346823);
    Object localObject = (WxRecyclerView)findViewById(e.e.finder_block_list_search);
    getContext();
    ((WxRecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    this.ALE = new WxRecyclerAdapter((g)new b(), this.data, true);
    ((WxRecyclerView)findViewById(e.e.finder_block_list_search)).setAdapter((RecyclerView.a)this.ALE);
    localObject = this.ALE;
    if (localObject != null) {
      ((i)localObject).agOd = ((i.d)new c(this));
    }
    localObject = this.ALE;
    if (localObject != null) {
      ((i)localObject).agOe = ((i.c)new d(this));
    }
    AppMethodBeat.o(346823);
  }
  
  public final void onClickBackBtn(View paramView)
  {
    AppMethodBeat.i(346836);
    hideVKB();
    finish();
    AppMethodBeat.o(346836);
  }
  
  public final void onClickCancelBtn(View paramView)
  {
    AppMethodBeat.i(346826);
    hideVKB();
    finish();
    AppMethodBeat.o(346826);
  }
  
  public final void onClickClearTextBtn(View paramView)
  {
    AppMethodBeat.i(346861);
    FTSSearchView localFTSSearchView = this.Bny;
    paramView = localFTSSearchView;
    if (localFTSSearchView == null)
    {
      s.bIx("searchView");
      paramView = null;
    }
    paramView.getFtsEditText().aWT();
    showVKB();
    AppMethodBeat.o(346861);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(346815);
    super.onCreate(paramBundle);
    this.Bny = new FTSSearchView((Context)this);
    paramBundle = this.Bny;
    if (paramBundle == null)
    {
      s.bIx("searchView");
      paramBundle = null;
      paramBundle.setSearchViewListener((FTSSearchView.b)this);
      FTSSearchView localFTSSearchView = this.Bny;
      paramBundle = localFTSSearchView;
      if (localFTSSearchView == null)
      {
        s.bIx("searchView");
        paramBundle = null;
      }
      paramBundle.getFtsEditText().setHint(getString(e.h.app_search));
      localFTSSearchView = this.Bny;
      paramBundle = localFTSSearchView;
      if (localFTSSearchView == null)
      {
        s.bIx("searchView");
        paramBundle = null;
      }
      paramBundle.getFtsEditText().setFtsEditTextListener((FTSEditTextView.c)this);
      localFTSSearchView = this.Bny;
      paramBundle = localFTSSearchView;
      if (localFTSSearchView == null)
      {
        s.bIx("searchView");
        paramBundle = null;
      }
      paramBundle.getFtsEditText().setCanDeleteTag(false);
      localFTSSearchView = this.Bny;
      paramBundle = localFTSSearchView;
      if (localFTSSearchView == null)
      {
        s.bIx("searchView");
        paramBundle = null;
      }
      paramBundle.getFtsEditText().jBL();
      ActionBar localActionBar = getSupportActionBar();
      s.checkNotNull(localActionBar);
      localFTSSearchView = this.Bny;
      paramBundle = localFTSSearchView;
      if (localFTSSearchView == null)
      {
        s.bIx("searchView");
        paramBundle = null;
      }
      localActionBar.setCustomView((View)paramBundle);
      localFTSSearchView = this.Bny;
      paramBundle = localFTSSearchView;
      if (localFTSSearchView == null)
      {
        s.bIx("searchView");
        paramBundle = null;
      }
      paramBundle.getFtsEditText().aWT();
      localFTSSearchView = this.Bny;
      paramBundle = localFTSSearchView;
      if (localFTSSearchView == null)
      {
        s.bIx("searchView");
        paramBundle = null;
      }
      paramBundle.getFtsEditText().aWS();
      initView();
      paramBundle = getIntent().getStringExtra(FOJ);
      s.checkNotNull(paramBundle);
      s.s(paramBundle, "intent.getStringExtra(BLOCK_LIST_SEARCH_TYPE)!!");
      this.FOI = paramBundle;
      paramBundle = this.FOI;
      if (!s.p(paramBundle, "@finder.block.my.liked.android")) {
        break label333;
      }
      paramBundle = (ar)new af();
    }
    for (;;)
    {
      this.ECo = paramBundle;
      awg("");
      AppMethodBeat.o(346815);
      return;
      break;
      label333:
      if (s.p(paramBundle, "@finder.block.his.liked.android")) {
        paramBundle = (ar)new ae();
      } else {
        paramBundle = null;
      }
    }
  }
  
  public final void onEditTextChange(String paramString1, String paramString2, List<FTSSearchView.c> paramList, FTSEditTextView.d paramd)
  {
    AppMethodBeat.i(346849);
    if (paramString1 == null) {
      paramString1 = "";
    }
    for (;;)
    {
      if (Util.isNullOrNil(paramString1)) {
        awg("");
      }
      AppMethodBeat.o(346849);
      return;
      paramString2 = kotlin.n.n.bq((CharSequence)paramString1).toString();
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderBlockListSearchUI$Companion;", "", "()V", "BLOCK_LIST_SEARCH_TYPE", "", "getBLOCK_LIST_SEARCH_TYPE", "()Ljava/lang/String;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/FinderBlockListSearchUI$initView$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements g
  {
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(346419);
      if (paramInt == com.tencent.mm.plugin.finder.model.p.class.getName().hashCode())
      {
        localObject = (com.tencent.mm.view.recyclerview.f)new a();
        AppMethodBeat.o(346419);
        return localObject;
      }
      s.checkNotNull(null);
      Object localObject = new kotlin.f();
      AppMethodBeat.o(346419);
      throw ((Throwable)localObject);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/FinderBlockListSearchUI$initView$2", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemLongClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements i.d<j>
  {
    c(FinderBlockListSearchUI paramFinderBlockListSearchUI) {}
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/FinderBlockListSearchUI$initView$2$onItemLongClick$1", "Landroid/view/View$OnCreateContextMenuListener;", "onCreateContextMenu", "", "menu", "Landroid/view/ContextMenu;", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements View.OnCreateContextMenuListener
    {
      a(FinderBlockListSearchUI paramFinderBlockListSearchUI) {}
      
      public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
      {
        AppMethodBeat.i(347263);
        if (paramContextMenu != null) {
          paramContextMenu.add(0, this.FOK.EXA, 0, e.h.finder_mod_block_poster_del);
        }
        AppMethodBeat.o(347263);
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/FinderBlockListSearchUI$initView$2$onItemLongClick$2", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "onMMMenuItemSelected", "", "menuItem", "Landroid/view/MenuItem;", "index", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      implements u.i
    {
      b(int paramInt, FinderBlockListSearchUI paramFinderBlockListSearchUI, RecyclerView.a<j> parama) {}
      
      public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
      {
        AppMethodBeat.i(347252);
        if ((this.EXC >= 0) && (this.EXC < this.FOK.data.size()))
        {
          paramMenuItem = this.FOK.ECo;
          if (paramMenuItem != null) {
            paramMenuItem.a(((com.tencent.mm.plugin.finder.model.p)this.FOK.data.get(this.EXC)).contact, (ar.a)new a(this.FOK, this.EXC, this.AYm));
          }
        }
        AppMethodBeat.o(347252);
      }
      
      @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/FinderBlockListSearchUI$initView$2$onItemLongClick$2$onMMMenuItemSelected$1", "Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig$OnItemDelCallBack;", "onDel", "", "success", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
      public static final class a
        implements ar.a
      {
        a(FinderBlockListSearchUI paramFinderBlockListSearchUI, int paramInt, RecyclerView.a<j> parama) {}
        
        public final void tb(boolean paramBoolean)
        {
          AppMethodBeat.i(346837);
          if (paramBoolean)
          {
            this.FOK.data.remove(this.EXC);
            this.AYm.fX(((i)this.AYm).agOb.size() + this.EXC);
            AppMethodBeat.o(346837);
            return;
          }
          aa.makeText((Context)this.FOK.getContext(), (CharSequence)"failed", 0).show();
          AppMethodBeat.o(346837);
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/FinderBlockListSearchUI$initView$3", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements i.c<j>
  {
    d(FinderBlockListSearchUI paramFinderBlockListSearchUI) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderBlockListSearchUI
 * JD-Core Version:    0.7.0.1
 */