package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.p.i;
import com.tencent.mm.plugin.finder.live.view.adapter.aa;
import com.tencent.mm.plugin.finder.live.view.adapter.ab;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.contact.r;
import com.tencent.mm.ui.y;
import com.tencent.mm.ui.y.a;
import com.tencent.mm.ui.y.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.an;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveSelectRoomForLuckMoneyUI;", "Lcom/tencent/mm/ui/contact/MMBaseSelectContactUI;", "()V", "inputView", "Lcom/tencent/mm/pluginsdk/ui/MultiSelectContactView;", "maxRoomCount", "", "selectUserSet", "Ljava/util/HashSet;", "", "createInitAdapter", "Lcom/tencent/mm/ui/contact/MMInitContactAdapter;", "createSearchAdapter", "Lcom/tencent/mm/ui/contact/MMBaseSearchContactAdapter;", "fakeDarkMode", "", "getLayoutId", "getSearchRange", "", "getTitleString", "handleItemClick", "parent", "Landroid/widget/AdapterView;", "view", "Landroid/view/View;", "position", "id", "", "handleSelect", "initData", "initMenu", "initSelectView", "initViews", "isItemCheck", "", "item", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "isSearchBarInTop", "isShowAlphabetScrollBar", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSelectChange", "action", "userName", "selectUser", "contact", "Lcom/tencent/mm/storage/Contact;", "username", "setFixTextSize", "setSubTitle", "updateMenu", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveSelectRoomForLuckMoneyUI
  extends MMBaseSelectContactUI
{
  public static final FinderLiveSelectRoomForLuckMoneyUI.a BpF;
  private static final String TAG;
  private MultiSelectContactView BpG;
  private int BpH;
  private final HashSet<String> pJQ;
  
  static
  {
    AppMethodBeat.i(364846);
    BpF = new FinderLiveSelectRoomForLuckMoneyUI.a((byte)0);
    TAG = "Finder.FinderLiveSelectRoomForLuckMoneyUI";
    AppMethodBeat.o(364846);
  }
  
  public FinderLiveSelectRoomForLuckMoneyUI()
  {
    AppMethodBeat.i(364814);
    this.pJQ = new HashSet();
    AppMethodBeat.o(364814);
  }
  
  private static final void a(FinderLiveSelectRoomForLuckMoneyUI paramFinderLiveSelectRoomForLuckMoneyUI)
  {
    AppMethodBeat.i(364840);
    s.u(paramFinderLiveSelectRoomForLuckMoneyUI, "this$0");
    Object localObject = paramFinderLiveSelectRoomForLuckMoneyUI.mController.aAm(1);
    if (localObject != null)
    {
      if (((y.a)localObject).advs == null) {
        break label90;
      }
      localObject = ((y.a)localObject).advs;
    }
    for (;;)
    {
      if (localObject != null)
      {
        localObject = (Button)((View)localObject).findViewById(a.g.action_option_btn);
        if (localObject != null)
        {
          com.tencent.mm.plugin.finder.accessibility.a locala = com.tencent.mm.plugin.finder.accessibility.a.Ate;
          paramFinderLiveSelectRoomForLuckMoneyUI = paramFinderLiveSelectRoomForLuckMoneyUI.getContext();
          s.s(paramFinderLiveSelectRoomForLuckMoneyUI, "context");
          ((Button)localObject).setTextSize(1, com.tencent.mm.plugin.finder.accessibility.a.g((Context)paramFinderLiveSelectRoomForLuckMoneyUI, 16.0F));
        }
      }
      AppMethodBeat.o(364840);
      return;
      label90:
      if (((y.a)localObject).advr != null) {
        localObject = ((y.a)localObject).advr;
      } else {
        localObject = null;
      }
    }
  }
  
  private static final boolean a(FinderLiveSelectRoomForLuckMoneyUI paramFinderLiveSelectRoomForLuckMoneyUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(364832);
    s.u(paramFinderLiveSelectRoomForLuckMoneyUI, "this$0");
    paramMenuItem = new ArrayList();
    paramMenuItem.addAll((Collection)paramFinderLiveSelectRoomForLuckMoneyUI.pJQ);
    Intent localIntent = new Intent();
    localIntent.putStringArrayListExtra("KEY_LUCKY_MONEY_CHAT_ROOM_USERNAME", paramMenuItem);
    paramFinderLiveSelectRoomForLuckMoneyUI.setResult(-1, localIntent);
    paramFinderLiveSelectRoomForLuckMoneyUI.finish();
    paramFinderLiveSelectRoomForLuckMoneyUI.aNr();
    paramFinderLiveSelectRoomForLuckMoneyUI.jyE().notifyDataSetChanged();
    AppMethodBeat.o(364832);
    return true;
  }
  
  private final void aNr()
  {
    AppMethodBeat.i(364821);
    Collection localCollection = (Collection)this.pJQ;
    if ((localCollection == null) || (localCollection.isEmpty())) {}
    for (int i = 1; i == 0; i = 0)
    {
      enableOptionMenu(1, true);
      updateOptionMenuText(1, getContext().getResources().getString(p.h.Ctu, new Object[] { Integer.valueOf(this.pJQ.size()) }));
      AppMethodBeat.o(364821);
      return;
    }
    enableOptionMenu(1, false);
    updateOptionMenuText(1, getString(p.h.finder_live_visibility_finish_btn));
    AppMethodBeat.o(364821);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(364915);
    int i = paramInt - getContentLV().getHeaderViewsCount();
    if (i < 0)
    {
      Log.i(TAG, "offsetPosition is Smaller than 0, offsetPosition=%d | position=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
      AppMethodBeat.o(364915);
      return;
    }
    paramAdapterView = jyE().aDt(i);
    if (paramAdapterView == null)
    {
      AppMethodBeat.o(364915);
      return;
    }
    if (paramAdapterView.contact == null)
    {
      AppMethodBeat.o(364915);
      return;
    }
    if (paramAdapterView.contact.field_deleteFlag == 1)
    {
      AppMethodBeat.o(364915);
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
    if (this.pJQ.contains(paramAdapterView))
    {
      this.pJQ.remove(paramAdapterView);
      this.KOt.bqG(paramAdapterView);
    }
    for (;;)
    {
      iKA();
      jyF().notifyDataSetChanged();
      aNr();
      AppMethodBeat.o(364915);
      return;
      if (this.pJQ.size() < this.BpH)
      {
        this.pJQ.add(paramAdapterView);
        this.KOt.bqG(paramAdapterView);
      }
    }
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(364936);
    if ((parama != null) && (parama.afey) && (parama.contact != null))
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
        AppMethodBeat.o(364936);
        return true;
      }
      AppMethodBeat.o(364936);
      return false;
    }
    AppMethodBeat.o(364936);
    return false;
  }
  
  public final void aNi()
  {
    AppMethodBeat.i(364872);
    super.aNi();
    this.BpH = getIntent().getIntExtra("KEY_LUCKY_MONEY_CHAT_ROOM_MAX_COUNT", 0);
    Object localObject = getIntent().getStringArrayListExtra("KEY_LUCKY_MONEY_CHAT_ROOM_USERNAME");
    this.pJQ.clear();
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
          this.pJQ.add(str);
          break;
        }
      }
    }
    Log.i(TAG, "initData maxRoomCount:" + this.BpH + ",selectUserSet size:" + this.pJQ.size());
    AppMethodBeat.o(364872);
  }
  
  public final void ad(int paramInt, String paramString)
  {
    AppMethodBeat.i(364920);
    if (paramInt == 1)
    {
      Collection localCollection = (Collection)this.pJQ;
      if (localCollection == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        AppMethodBeat.o(364920);
        throw paramString;
      }
      an.hA(localCollection).remove(paramString);
      jyE().notifyDataSetChanged();
      aNr();
    }
    AppMethodBeat.o(364920);
  }
  
  public final r bVA()
  {
    AppMethodBeat.i(364896);
    Object localObject = new aa((MMBaseSelectContactUI)this);
    ((q)localObject).afey = true;
    localObject = (r)localObject;
    AppMethodBeat.o(364896);
    return localObject;
  }
  
  public final p bVB()
  {
    AppMethodBeat.i(364886);
    p localp = (p)new ab((MMBaseSelectContactUI)this);
    AppMethodBeat.o(364886);
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
    AppMethodBeat.i(364905);
    String str = getContext().getString(p.h.Csn);
    s.s(str, "context.getString(R.stri…t_room_lucky_money_title)");
    AppMethodBeat.o(364905);
    return str;
  }
  
  public final int[] efu()
  {
    return new int[] { 131075 };
  }
  
  public final int getLayoutId()
  {
    return p.f.Cfx;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(364883);
    super.onCreate(paramBundle);
    setTheme(p.i.AppTheme_DarkMode);
    setActionbarColor(getResources().getColor(p.b.Dark_0));
    setNavigationbarColor(getResources().getColor(p.b.Dark_0));
    jyI();
    jyJ();
    addTextOptionMenu(1, getString(p.h.finder_live_visibility_finish_btn), new FinderLiveSelectRoomForLuckMoneyUI..ExternalSyntheticLambda0(this), null, y.b.adEZ);
    aNr();
    this.BpG = ((MultiSelectContactView)findViewById(p.e.contact_multiselect));
    paramBundle = this.BpG;
    if (paramBundle != null) {
      paramBundle.iKv();
    }
    paramBundle = this.BpG;
    if (paramBundle != null) {
      paramBundle.iKw();
    }
    paramBundle = (List)new ArrayList((Collection)this.pJQ);
    this.KOt.mv(paramBundle);
    paramBundle = getMMSubTitle();
    if (paramBundle != null)
    {
      setMMSubTitle(getString(p.h.Csm));
      paramBundle.setTextColor(getResources().getColor(p.b.BW_100_Alpha_0_5));
    }
    paramBundle = this.BpG;
    if (paramBundle != null) {
      paramBundle.post(new FinderLiveSelectRoomForLuckMoneyUI..ExternalSyntheticLambda1(this));
    }
    AppMethodBeat.o(364883);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLiveSelectRoomForLuckMoneyUI
 * JD-Core Version:    0.7.0.1
 */