package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.b.k;
import com.tencent.mm.plugin.finder.live.view.adapter.t;
import com.tencent.mm.plugin.findersdk.a.d;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.w.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.b;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveSelectRoomUI;", "Lcom/tencent/mm/ui/contact/MMBaseSelectContactUI;", "()V", "selectUserSet", "Ljava/util/HashSet;", "", "createInitAdapter", "Lcom/tencent/mm/ui/contact/MMInitContactAdapter;", "createSearchAdapter", "Lcom/tencent/mm/ui/contact/MMBaseSearchContactAdapter;", "fakeDarkMode", "", "getLayoutId", "", "getSearchRange", "", "getSelectedChatroomsUsername", "", "getTitleString", "handleItemClick", "parent", "Landroid/widget/AdapterView;", "view", "Landroid/view/View;", "position", "id", "", "handleSelect", "initData", "initMenu", "isItemCheck", "", "item", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "isSearchBarInTop", "isShowAlphabetScrollBar", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSelectChange", "action", "username", "selectUser", "contact", "Lcom/tencent/mm/storage/Contact;", "setHeaderView", "contentLV", "Landroid/widget/ListView;", "visibility", "updateMenu", "Companion", "plugin-finder-live_release"})
public final class FinderLiveSelectRoomUI
  extends MMBaseSelectContactUI
{
  public static final FinderLiveSelectRoomUI.a xPT;
  private HashMap _$_findViewCache;
  private final HashSet<String> mNi;
  
  static
  {
    AppMethodBeat.i(232497);
    xPT = new FinderLiveSelectRoomUI.a((byte)0);
    AppMethodBeat.o(232497);
  }
  
  public FinderLiveSelectRoomUI()
  {
    AppMethodBeat.i(232496);
    this.mNi = new HashSet();
    AppMethodBeat.o(232496);
  }
  
  private final void atk()
  {
    AppMethodBeat.i(232477);
    int i = this.mNi.size();
    if (i > 0)
    {
      enableOptionMenu(1, true);
      updateOptionMenuText(1, getString(b.j.finder_live_visibility_finish_numbers_tips, new Object[] { Integer.valueOf(i) }));
      AppMethodBeat.o(232477);
      return;
    }
    enableOptionMenu(1, false);
    updateOptionMenuText(1, getString(b.j.finder_live_visibility_finish_btn));
    AppMethodBeat.o(232477);
  }
  
  public final void N(View paramView, int paramInt)
  {
    AppMethodBeat.i(232491);
    paramView = getContentLV();
    kotlin.g.b.p.j(paramView, "getContentLV()");
    int i = paramInt - paramView.getHeaderViewsCount();
    if (i < 0)
    {
      Log.i("MicroMsg.FinderLiveMultiSelectChatRoomUI", "offsetPosition is Smaller than 0, offsetPosition=%d | position=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
      AppMethodBeat.o(232491);
      return;
    }
    paramView = hUP().awM(i);
    if (paramView == null)
    {
      AppMethodBeat.o(232491);
      return;
    }
    if (paramView.fqR() == null)
    {
      AppMethodBeat.o(232491);
      return;
    }
    Object localObject = paramView.fqR();
    kotlin.g.b.p.j(localObject, "baseContactDataItem.contact");
    if (((as)localObject).app() == 1)
    {
      AppMethodBeat.o(232491);
      return;
    }
    paramView = paramView.fqR();
    kotlin.g.b.p.j(paramView, "contact");
    localObject = paramView.getUsername();
    paramView = (View)localObject;
    if (localObject == null) {
      paramView = "";
    }
    hUZ();
    hUR().bqR(paramView);
    if (this.mNi.contains(paramView)) {
      this.mNi.remove(paramView);
    }
    for (;;)
    {
      hUQ().notifyDataSetChanged();
      atk();
      AppMethodBeat.o(232491);
      return;
      this.mNi.add(paramView);
    }
  }
  
  public final void V(int paramInt, String paramString)
  {
    AppMethodBeat.i(232490);
    if (paramInt == 1)
    {
      j.a((Iterable)this.mNi, (b)new FinderLiveSelectRoomUI.c(paramString));
      hUP().notifyDataSetChanged();
      atk();
    }
    AppMethodBeat.o(232490);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(232501);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(232501);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(232499);
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
    AppMethodBeat.o(232499);
    return localView1;
  }
  
  public final void a(ListView paramListView, int paramInt)
  {
    AppMethodBeat.i(232489);
    super.a(paramListView, paramInt);
    AppMethodBeat.o(232489);
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(232493);
    kotlin.g.b.p.k(parama, "item");
    if ((parama.fJk()) && (parama.fqR() != null))
    {
      Object localObject1 = (Iterable)this.mNi;
      Collection localCollection = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        String str = (String)localObject2;
        as localas = parama.fqR();
        kotlin.g.b.p.j(localas, "item.contact");
        if (Util.isEqual(str, localas.getUsername())) {
          localCollection.add(localObject2);
        }
      }
      if (((Collection)localCollection).isEmpty()) {}
      for (int i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(232493);
        return true;
      }
      AppMethodBeat.o(232493);
      return false;
    }
    AppMethodBeat.o(232493);
    return false;
  }
  
  public final void ata()
  {
    AppMethodBeat.i(232482);
    super.ata();
    Object localObject1 = getIntent();
    Object localObject2 = a.d.BuY;
    localObject1 = ((Intent)localObject1).getStringArrayListExtra(a.d.ena());
    localObject2 = (Collection)localObject1;
    if ((localObject2 == null) || (((Collection)localObject2).isEmpty())) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.mNi.addAll((Collection)localObject1);
      }
      AppMethodBeat.o(232482);
      return;
    }
  }
  
  public final boolean bwH()
  {
    return false;
  }
  
  public final boolean bwI()
  {
    return false;
  }
  
  public final String bwJ()
  {
    AppMethodBeat.i(232484);
    String str = getContext().getString(b.j.sns_label_group_title);
    kotlin.g.b.p.j(str, "context.getString(R.string.sns_label_group_title)");
    AppMethodBeat.o(232484);
    return str;
  }
  
  public final com.tencent.mm.ui.contact.r bwK()
  {
    AppMethodBeat.i(232486);
    com.tencent.mm.ui.contact.r localr = (com.tencent.mm.ui.contact.r)new com.tencent.mm.plugin.finder.live.view.adapter.r((MMBaseSelectContactUI)this, (byte)0);
    AppMethodBeat.o(232486);
    return localr;
  }
  
  public final com.tencent.mm.ui.contact.p bwL()
  {
    AppMethodBeat.i(232487);
    com.tencent.mm.ui.contact.p localp = (com.tencent.mm.ui.contact.p)new t((MMBaseSelectContactUI)this);
    AppMethodBeat.o(232487);
    return localp;
  }
  
  public final int[] dvA()
  {
    return new int[] { 131075 };
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_live_multi_select_contact_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(232479);
    super.onCreate(paramBundle);
    setTheme(b.k.AppTheme_DarkMode);
    setActionbarColor(getResources().getColor(b.c.Dark_0));
    setNavigationbarColor(getResources().getColor(b.c.Dark_0));
    hUU();
    hUV();
    addTextOptionMenu(1, getString(b.j.finder_live_visibility_finish_btn), (MenuItem.OnMenuItemClickListener)new b(this), null, w.b.WaE);
    atk();
    paramBundle = new ArrayList();
    Iterator localIterator = ((Iterable)this.mNi).iterator();
    while (localIterator.hasNext()) {
      paramBundle.add((String)localIterator.next());
    }
    paramBundle = (List)paramBundle;
    hUR().jk(paramBundle);
    AppMethodBeat.o(232479);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderLiveSelectRoomUI paramFinderLiveSelectRoomUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(233092);
      FinderLiveSelectRoomUI.a(this.xPU);
      AppMethodBeat.o(233092);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLiveSelectRoomUI
 * JD-Core Version:    0.7.0.1
 */