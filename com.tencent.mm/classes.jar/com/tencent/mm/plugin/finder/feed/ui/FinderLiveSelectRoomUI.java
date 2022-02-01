package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.p.i;
import com.tencent.mm.plugin.finder.live.view.adapter.x;
import com.tencent.mm.plugin.finder.live.view.adapter.z;
import com.tencent.mm.plugin.findersdk.a.d;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.contact.r;
import com.tencent.mm.ui.y.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveSelectRoomUI;", "Lcom/tencent/mm/ui/contact/MMBaseSelectContactUI;", "()V", "selectUserSet", "Ljava/util/HashSet;", "", "createInitAdapter", "Lcom/tencent/mm/ui/contact/MMInitContactAdapter;", "createSearchAdapter", "Lcom/tencent/mm/ui/contact/MMBaseSearchContactAdapter;", "fakeDarkMode", "", "getLayoutId", "", "getSearchRange", "", "getSelectedChatroomsUsername", "", "getTitleString", "handleItemClick", "parent", "Landroid/widget/AdapterView;", "view", "Landroid/view/View;", "position", "id", "", "handleSelect", "initData", "initMenu", "isItemCheck", "", "item", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "isSearchBarInTop", "isShowAlphabetScrollBar", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSelectChange", "action", "username", "selectUser", "contact", "Lcom/tencent/mm/storage/Contact;", "setHeaderView", "contentLV", "Landroid/widget/ListView;", "visibility", "updateMenu", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveSelectRoomUI
  extends MMBaseSelectContactUI
{
  public static final FinderLiveSelectRoomUI.a BpI;
  private final HashSet<String> pJQ;
  
  static
  {
    AppMethodBeat.i(365290);
    BpI = new FinderLiveSelectRoomUI.a((byte)0);
    AppMethodBeat.o(365290);
  }
  
  public FinderLiveSelectRoomUI()
  {
    AppMethodBeat.i(365267);
    this.pJQ = new HashSet();
    AppMethodBeat.o(365267);
  }
  
  private static final boolean a(FinderLiveSelectRoomUI paramFinderLiveSelectRoomUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(365283);
    s.u(paramFinderLiveSelectRoomUI, "this$0");
    paramMenuItem = new ArrayList();
    paramMenuItem.addAll((Collection)paramFinderLiveSelectRoomUI.pJQ);
    Intent localIntent = new Intent();
    a.d locald = a.d.HbG;
    localIntent.putStringArrayListExtra(a.d.frj(), paramMenuItem);
    paramFinderLiveSelectRoomUI.setResult(-1, localIntent);
    paramFinderLiveSelectRoomUI.finish();
    paramFinderLiveSelectRoomUI.aNr();
    paramFinderLiveSelectRoomUI.jyE().notifyDataSetChanged();
    AppMethodBeat.o(365283);
    return true;
  }
  
  private final void aNr()
  {
    AppMethodBeat.i(365276);
    int i = this.pJQ.size();
    if (i > 0)
    {
      enableOptionMenu(1, true);
      updateOptionMenuText(1, getString(p.h.Ctu, new Object[] { Integer.valueOf(i) }));
      AppMethodBeat.o(365276);
      return;
    }
    enableOptionMenu(1, false);
    updateOptionMenuText(1, getString(p.h.finder_live_visibility_finish_btn));
    AppMethodBeat.o(365276);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(365389);
    int i = paramInt - getContentLV().getHeaderViewsCount();
    if (i < 0)
    {
      Log.i("MicroMsg.FinderLiveMultiSelectChatRoomUI", "offsetPosition is Smaller than 0, offsetPosition=%d | position=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
      AppMethodBeat.o(365389);
      return;
    }
    paramAdapterView = jyE().aDt(i);
    if (paramAdapterView == null)
    {
      AppMethodBeat.o(365389);
      return;
    }
    if (paramAdapterView.contact == null)
    {
      AppMethodBeat.o(365389);
      return;
    }
    if (paramAdapterView.contact.field_deleteFlag == 1)
    {
      AppMethodBeat.o(365389);
      return;
    }
    paramAdapterView = paramAdapterView.contact;
    s.s(paramAdapterView, "contact");
    paramView = paramAdapterView.field_username;
    paramAdapterView = paramView;
    if (paramView == null) {
      paramAdapterView = "";
    }
    iKA();
    this.KOt.bqG(paramAdapterView);
    if (this.pJQ.contains(paramAdapterView)) {
      this.pJQ.remove(paramAdapterView);
    }
    for (;;)
    {
      jyF().notifyDataSetChanged();
      aNr();
      AppMethodBeat.o(365389);
      return;
      this.pJQ.add(paramAdapterView);
    }
  }
  
  public final void a(ListView paramListView, int paramInt)
  {
    AppMethodBeat.i(365370);
    super.a(paramListView, paramInt);
    AppMethodBeat.o(365370);
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(365396);
    s.u(parama, "item");
    if ((parama.afey) && (parama.contact != null))
    {
      Object localObject1 = (Iterable)this.pJQ;
      Collection localCollection = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if (Util.isEqual((String)localObject2, parama.contact.field_username)) {
          localCollection.add(localObject2);
        }
      }
      if (((Collection)localCollection).isEmpty()) {}
      for (int i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(365396);
        return true;
      }
      AppMethodBeat.o(365396);
      return false;
    }
    AppMethodBeat.o(365396);
    return false;
  }
  
  public final void aNi()
  {
    AppMethodBeat.i(365322);
    super.aNi();
    Object localObject1 = getIntent();
    Object localObject2 = a.d.HbG;
    localObject1 = ((Intent)localObject1).getStringArrayListExtra(a.d.frj());
    localObject2 = (Collection)localObject1;
    if ((localObject2 == null) || (((Collection)localObject2).isEmpty())) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.pJQ.addAll((Collection)localObject1);
      }
      AppMethodBeat.o(365322);
      return;
    }
  }
  
  public final void ad(int paramInt, String paramString)
  {
    AppMethodBeat.i(365378);
    if (paramInt == 1)
    {
      kotlin.a.p.a((Iterable)this.pJQ, (b)new FinderLiveSelectRoomUI.b(paramString));
      jyE().notifyDataSetChanged();
      aNr();
    }
    AppMethodBeat.o(365378);
  }
  
  public final r bVA()
  {
    AppMethodBeat.i(365349);
    r localr = (r)new x((MMBaseSelectContactUI)this, (byte)0);
    AppMethodBeat.o(365349);
    return localr;
  }
  
  public final com.tencent.mm.ui.contact.p bVB()
  {
    AppMethodBeat.i(365355);
    com.tencent.mm.ui.contact.p localp = (com.tencent.mm.ui.contact.p)new z((MMBaseSelectContactUI)this);
    AppMethodBeat.o(365355);
    return localp;
  }
  
  public final boolean bVx()
  {
    return false;
  }
  
  public final boolean bVy()
  {
    return false;
  }
  
  public final String bVz()
  {
    AppMethodBeat.i(365342);
    String str = getContext().getString(p.h.sns_label_group_title);
    s.s(str, "context.getString(R.string.sns_label_group_title)");
    AppMethodBeat.o(365342);
    return str;
  }
  
  public final int[] efu()
  {
    return new int[] { 131075 };
  }
  
  public final int getLayoutId()
  {
    return p.f.CeJ;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(365315);
    super.onCreate(paramBundle);
    setTheme(p.i.AppTheme_DarkMode);
    setActionbarColor(getResources().getColor(p.b.Dark_0));
    setNavigationbarColor(getResources().getColor(p.b.Dark_0));
    jyI();
    jyJ();
    addTextOptionMenu(1, getString(p.h.finder_live_visibility_finish_btn), new FinderLiveSelectRoomUI..ExternalSyntheticLambda0(this), null, y.b.adEZ);
    aNr();
    paramBundle = new ArrayList();
    Iterator localIterator = ((Iterable)this.pJQ).iterator();
    while (localIterator.hasNext()) {
      paramBundle.add((String)localIterator.next());
    }
    paramBundle = (List)paramBundle;
    this.KOt.mv(paramBundle);
    AppMethodBeat.o(365315);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLiveSelectRoomUI
 * JD-Core Version:    0.7.0.1
 */