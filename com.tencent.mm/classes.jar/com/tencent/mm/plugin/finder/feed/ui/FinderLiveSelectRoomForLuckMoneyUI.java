package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.b.k;
import com.tencent.mm.plugin.finder.live.view.adapter.u;
import com.tencent.mm.plugin.finder.live.view.adapter.v;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.contact.r;
import com.tencent.mm.ui.w.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.ag;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveSelectRoomForLuckMoneyUI;", "Lcom/tencent/mm/ui/contact/MMBaseSelectContactUI;", "()V", "inputView", "Lcom/tencent/mm/pluginsdk/ui/MultiSelectContactView;", "maxRoomCount", "", "selectUserSet", "Ljava/util/HashSet;", "", "createInitAdapter", "Lcom/tencent/mm/ui/contact/MMInitContactAdapter;", "createSearchAdapter", "Lcom/tencent/mm/ui/contact/MMBaseSearchContactAdapter;", "fakeDarkMode", "", "getLayoutId", "getSearchRange", "", "getTitleString", "handleItemClick", "parent", "Landroid/widget/AdapterView;", "view", "Landroid/view/View;", "position", "id", "", "handleSelect", "initData", "initMenu", "initSelectView", "initViews", "isItemCheck", "", "item", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "isSearchBarInTop", "isShowAlphabetScrollBar", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSelectChange", "action", "userName", "selectUser", "contact", "Lcom/tencent/mm/storage/Contact;", "username", "setSubTitle", "updateMenu", "Companion", "plugin-finder-live_release"})
public final class FinderLiveSelectRoomForLuckMoneyUI
  extends MMBaseSelectContactUI
{
  private static final String TAG = "Finder.FinderLiveSelectRoomForLuckMoneyUI";
  public static final FinderLiveSelectRoomForLuckMoneyUI.a xPR;
  private HashMap _$_findViewCache;
  private final HashSet<String> mNi;
  private MultiSelectContactView xPP;
  private int xPQ;
  
  static
  {
    AppMethodBeat.i(233179);
    xPR = new FinderLiveSelectRoomForLuckMoneyUI.a((byte)0);
    TAG = "Finder.FinderLiveSelectRoomForLuckMoneyUI";
    AppMethodBeat.o(233179);
  }
  
  public FinderLiveSelectRoomForLuckMoneyUI()
  {
    AppMethodBeat.i(233176);
    this.mNi = new HashSet();
    AppMethodBeat.o(233176);
  }
  
  private final void atk()
  {
    AppMethodBeat.i(233151);
    Object localObject = (Collection)this.mNi;
    if ((localObject == null) || (((Collection)localObject).isEmpty())) {}
    for (int i = 1; i == 0; i = 0)
    {
      enableOptionMenu(1, true);
      localObject = getContext();
      kotlin.g.b.p.j(localObject, "context");
      updateOptionMenuText(1, ((AppCompatActivity)localObject).getResources().getString(b.j.finder_live_visibility_finish_numbers_tips, new Object[] { Integer.valueOf(this.mNi.size()) }));
      AppMethodBeat.o(233151);
      return;
    }
    enableOptionMenu(1, false);
    updateOptionMenuText(1, getString(b.j.finder_live_visibility_finish_btn));
    AppMethodBeat.o(233151);
  }
  
  public final void N(View paramView, int paramInt)
  {
    AppMethodBeat.i(233169);
    paramView = getContentLV();
    kotlin.g.b.p.j(paramView, "getContentLV()");
    int i = paramInt - paramView.getHeaderViewsCount();
    if (i < 0)
    {
      Log.i(TAG, "offsetPosition is Smaller than 0, offsetPosition=%d | position=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
      AppMethodBeat.o(233169);
      return;
    }
    paramView = hUP().awM(i);
    if (paramView == null)
    {
      AppMethodBeat.o(233169);
      return;
    }
    if (paramView.fqR() == null)
    {
      AppMethodBeat.o(233169);
      return;
    }
    Object localObject = paramView.fqR();
    kotlin.g.b.p.j(localObject, "baseContactDataItem.contact");
    if (((as)localObject).app() == 1)
    {
      AppMethodBeat.o(233169);
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
    if (this.mNi.contains(paramView))
    {
      this.mNi.remove(paramView);
      hUR().bqR(paramView);
    }
    for (;;)
    {
      hUZ();
      hUQ().notifyDataSetChanged();
      atk();
      AppMethodBeat.o(233169);
      return;
      if (this.mNi.size() < this.xPQ)
      {
        this.mNi.add(paramView);
        hUR().bqR(paramView);
      }
    }
  }
  
  public final void V(int paramInt, String paramString)
  {
    AppMethodBeat.i(233171);
    if (paramInt == 1)
    {
      Collection localCollection = (Collection)this.mNi;
      if (localCollection == null)
      {
        paramString = new t("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        AppMethodBeat.o(233171);
        throw paramString;
      }
      ag.fc(localCollection).remove(paramString);
      hUP().notifyDataSetChanged();
      atk();
    }
    AppMethodBeat.o(233171);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(233182);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(233182);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(233181);
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
    AppMethodBeat.o(233181);
    return localView1;
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(233175);
    if ((parama != null) && (parama.fJk()) && (parama.fqR() != null))
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
        AppMethodBeat.o(233175);
        return true;
      }
      AppMethodBeat.o(233175);
      return false;
    }
    AppMethodBeat.o(233175);
    return false;
  }
  
  public final void ata()
  {
    AppMethodBeat.i(233153);
    super.ata();
    this.xPQ = getIntent().getIntExtra("KEY_LUCKY_MONEY_CHAT_ROOM_MAX_COUNT", 0);
    Object localObject = getIntent().getStringArrayListExtra("KEY_LUCKY_MONEY_CHAT_ROOM_USERNAME");
    this.mNi.clear();
    if (localObject != null)
    {
      localObject = ((Iterable)localObject).iterator();
      label117:
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        CharSequence localCharSequence = (CharSequence)str;
        if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label117;
          }
          this.mNi.add(str);
          break;
        }
      }
    }
    Log.i(TAG, "initData maxRoomCount:" + this.xPQ + ",selectUserSet size:" + this.mNi.size());
    AppMethodBeat.o(233153);
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
    AppMethodBeat.i(233165);
    String str = getContext().getString(b.j.finder_live_select_room_lucky_money_title);
    kotlin.g.b.p.j(str, "context.getString(R.stri…t_room_lucky_money_title)");
    AppMethodBeat.o(233165);
    return str;
  }
  
  public final r bwK()
  {
    AppMethodBeat.i(233162);
    Object localObject = new u((MMBaseSelectContactUI)this);
    ((u)localObject).hUN();
    localObject = (r)localObject;
    AppMethodBeat.o(233162);
    return localObject;
  }
  
  public final com.tencent.mm.ui.contact.p bwL()
  {
    AppMethodBeat.i(233159);
    com.tencent.mm.ui.contact.p localp = (com.tencent.mm.ui.contact.p)new v((MMBaseSelectContactUI)this);
    AppMethodBeat.o(233159);
    return localp;
  }
  
  public final int[] dvA()
  {
    return new int[] { 131075 };
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_live_select_contact_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(233157);
    super.onCreate(paramBundle);
    setTheme(b.k.AppTheme_DarkMode);
    setActionbarColor(getResources().getColor(b.c.Dark_0));
    setNavigationbarColor(getResources().getColor(b.c.Dark_0));
    hUU();
    hUV();
    addTextOptionMenu(1, getString(b.j.finder_live_visibility_finish_btn), (MenuItem.OnMenuItemClickListener)new b(this), null, w.b.WaE);
    atk();
    this.xPP = ((MultiSelectContactView)findViewById(b.f.contact_multiselect));
    paramBundle = this.xPP;
    if (paramBundle != null) {
      paramBundle.hjD();
    }
    paramBundle = this.xPP;
    if (paramBundle != null) {
      paramBundle.hjE();
    }
    paramBundle = (List)new ArrayList((Collection)this.mNi);
    hUR().jk(paramBundle);
    paramBundle = getMMSubTitle();
    if (paramBundle != null)
    {
      setMMSubTitle(getString(b.j.finder_live_select_room_lucky_money_subtitle));
      paramBundle.setTextColor(getResources().getColor(b.c.BW_100_Alpha_0_5));
    }
    AppMethodBeat.o(233157);
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
    b(FinderLiveSelectRoomForLuckMoneyUI paramFinderLiveSelectRoomForLuckMoneyUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(233443);
      FinderLiveSelectRoomForLuckMoneyUI.a(this.xPS);
      AppMethodBeat.o(233443);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLiveSelectRoomForLuckMoneyUI
 * JD-Core Version:    0.7.0.1
 */