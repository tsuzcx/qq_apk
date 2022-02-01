package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.p.i;
import com.tencent.mm.plugin.finder.live.view.adapter.x;
import com.tencent.mm.plugin.finder.live.view.adapter.z;
import com.tencent.mm.plugin.findersdk.a.d;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.protocal.protobuf.boe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.contact.r;
import com.tencent.mm.ui.contact.w;
import com.tencent.mm.ui.y.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI20;", "Lcom/tencent/mm/ui/contact/MMBaseSelectContactUI;", "()V", "maxUserCount", "", "selectAllContact", "Ljava/util/ArrayList;", "", "selectRoom", "selectUser", "createInitAdapter", "Lcom/tencent/mm/ui/contact/MMInitContactAdapter;", "createSearchAdapter", "Lcom/tencent/mm/ui/contact/MMBaseSearchContactAdapter;", "fakeDarkMode", "", "getLayoutId", "getSearchRange", "", "getTitleString", "goToSelectUser", "handleItemClick", "parent", "Landroid/widget/AdapterView;", "view", "Landroid/view/View;", "position", "id", "", "handleSelect", "initData", "initMenu", "initView", "isItemCheck", "", "item", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "isSearchBarInTop", "isShowAlphabetScrollBar", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSelectChange", "action", "username", "onSelectRoom", "contact", "Lcom/tencent/mm/storage/Contact;", "onSelectUser", "userList", "Ljava/util/LinkedList;", "updateMenu", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class OccupyFinderUI20
  extends MMBaseSelectContactUI
{
  public static final OccupyFinderUI20.a BsN;
  private ArrayList<String> BsO;
  private ArrayList<String> BsP;
  private ArrayList<String> BsQ;
  private int BsR;
  
  static
  {
    AppMethodBeat.i(364282);
    BsN = new OccupyFinderUI20.a((byte)0);
    AppMethodBeat.o(364282);
  }
  
  public OccupyFinderUI20()
  {
    AppMethodBeat.i(364228);
    this.BsO = new ArrayList();
    this.BsP = new ArrayList();
    this.BsQ = new ArrayList();
    AppMethodBeat.o(364228);
  }
  
  private static final void a(View paramView, OccupyFinderUI20 paramOccupyFinderUI20)
  {
    AppMethodBeat.i(364270);
    s.u(paramView, "$selectUserEntrance");
    s.u(paramOccupyFinderUI20, "this$0");
    paramView.setVisibility(0);
    paramView.setOnClickListener(new OccupyFinderUI20..ExternalSyntheticLambda1(paramOccupyFinderUI20));
    Log.i("FinderLiveSelectContactUI", s.X("before init view holderView height:", Integer.valueOf(paramOccupyFinderUI20.afeF.getLayoutParams().height)));
    ViewGroup.LayoutParams localLayoutParams = paramOccupyFinderUI20.afeF.getLayoutParams();
    int j = localLayoutParams.height;
    if (paramView.getMeasuredHeight() > 0) {}
    for (int i = paramView.getMeasuredHeight();; i = MMApplicationContext.getContext().getResources().getDimensionPixelOffset(p.c.Edge_7A))
    {
      localLayoutParams.height = (i + j);
      Log.i("FinderLiveSelectContactUI", s.X("after init view holderView height:", Integer.valueOf(paramOccupyFinderUI20.afeF.getLayoutParams().height)));
      paramOccupyFinderUI20.afeF.requestLayout();
      AppMethodBeat.o(364270);
      return;
    }
  }
  
  private static final void a(OccupyFinderUI20 paramOccupyFinderUI20, View paramView)
  {
    AppMethodBeat.i(364260);
    s.u(paramOccupyFinderUI20, "this$0");
    paramView = new Intent();
    paramView.setClassName((Context)paramOccupyFinderUI20, "com.tencent.mm.ui.contact.SelectContactUI");
    paramView.putExtra("list_type", 1);
    paramView.putExtra("titile", paramOccupyFinderUI20.getString(p.h.finder_mod_block_select_user));
    paramView.putExtra("without_openim", true);
    paramView.putExtra("list_attr", w.R(new int[] { w.ow(w.affp, 16777216), 131072 }));
    paramView.putExtra("already_select_contact", Util.listToString((List)paramOccupyFinderUI20.BsQ, ","));
    if (paramOccupyFinderUI20.BsR > 0) {}
    for (int i = paramOccupyFinderUI20.BsR;; i = 500)
    {
      paramView.putExtra("max_limit_num", i);
      paramView.putExtra("Forbid_SelectChatRoom", true);
      paramView.putExtra("KForceDarkMode", true);
      paramOccupyFinderUI20.startActivityForResult(paramView, 2);
      AppMethodBeat.o(364260);
      return;
    }
  }
  
  private static final boolean a(OccupyFinderUI20 paramOccupyFinderUI20, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(364249);
    s.u(paramOccupyFinderUI20, "this$0");
    Log.i("FinderLiveSelectContactUI", "select_contact_step100,selectRoom:" + paramOccupyFinderUI20.BsP + ", selectUser:" + paramOccupyFinderUI20.BsQ + ", selectAllContact:" + paramOccupyFinderUI20.BsO);
    paramMenuItem = new Intent();
    boe localboe = new boe();
    localboe.ZWz.addAll((Collection)paramOccupyFinderUI20.BsO);
    localboe.ZWy.addAll((Collection)paramOccupyFinderUI20.BsP);
    localboe.username_list.addAll((Collection)paramOccupyFinderUI20.BsQ);
    a.d locald = a.d.HbG;
    paramMenuItem.putExtra(a.d.frh(), localboe.toByteArray());
    paramOccupyFinderUI20.setResult(-1, paramMenuItem);
    paramOccupyFinderUI20.finish();
    paramOccupyFinderUI20.aNr();
    paramOccupyFinderUI20.jyE().notifyDataSetChanged();
    AppMethodBeat.o(364249);
    return true;
  }
  
  private final void aNr()
  {
    AppMethodBeat.i(364237);
    int i = this.BsO.size();
    if (i > 0)
    {
      updateOptionMenuText(1, getString(p.h.Ctu, new Object[] { Integer.valueOf(i) }));
      AppMethodBeat.o(364237);
      return;
    }
    updateOptionMenuText(1, getString(p.h.finder_live_visibility_finish_btn));
    AppMethodBeat.o(364237);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(364409);
    int i = paramInt - getContentLV().getHeaderViewsCount();
    if (i < 0)
    {
      Log.i("FinderLiveSelectContactUI", "offsetPosition is Smaller than 0, offsetPosition=%d | position=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
      AppMethodBeat.o(364409);
      return;
    }
    paramAdapterView = jyE().aDt(i);
    if (paramAdapterView == null)
    {
      AppMethodBeat.o(364409);
      return;
    }
    if (paramAdapterView.contact == null)
    {
      AppMethodBeat.o(364409);
      return;
    }
    if (paramAdapterView.contact.field_deleteFlag == 1)
    {
      AppMethodBeat.o(364409);
      return;
    }
    au localau = paramAdapterView.contact;
    s.s(localau, "contact");
    paramView = localau.field_username;
    paramAdapterView = paramView;
    if (paramView == null) {
      paramAdapterView = "";
    }
    iKA();
    this.KOt.bqG(paramAdapterView);
    if (this.BsP.contains(paramAdapterView))
    {
      this.BsP.remove(paramAdapterView);
      Log.i("FinderLiveSelectContactUI", "remove room:" + localau.acDG + ',' + this.BsP);
      Log.i("FinderLiveSelectContactUI", s.X("before select room,selectAllContact:", this.BsO));
      if (!this.BsO.contains(paramAdapterView)) {
        break label382;
      }
      this.BsO.remove(paramAdapterView);
    }
    for (;;)
    {
      Log.i("FinderLiveSelectContactUI", s.X("after select room,selectAllContact:", this.BsO));
      Log.i("FinderLiveSelectContactUI", "select_contact_step2-1,onSelectRoom selectRoom:" + this.BsP + ", selectUser:" + this.BsQ + ", selectAllContact:" + this.BsO);
      aNr();
      jyF().notifyDataSetChanged();
      aNr();
      AppMethodBeat.o(364409);
      return;
      this.BsP.add(paramAdapterView);
      Log.i("FinderLiveSelectContactUI", "add room:" + localau.acDG + ',' + this.BsP);
      break;
      label382:
      this.BsO.add(paramAdapterView);
    }
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(364419);
    s.u(parama, "item");
    if ((parama.afey) && (parama.contact != null))
    {
      Object localObject1 = (Iterable)this.BsO;
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
        AppMethodBeat.o(364419);
        return true;
      }
      AppMethodBeat.o(364419);
      return false;
    }
    AppMethodBeat.o(364419);
    return false;
  }
  
  public final void aNi()
  {
    AppMethodBeat.i(364325);
    super.aNi();
    Object localObject1 = getIntent();
    Object localObject2 = a.d.HbG;
    this.BsR = ((Intent)localObject1).getIntExtra(a.d.frl(), 0);
    localObject1 = getIntent();
    localObject2 = a.d.HbG;
    localObject1 = ((Intent)localObject1).getByteArrayExtra(a.d.frh());
    if (localObject1 != null)
    {
      localObject2 = new boe();
      ((boe)localObject2).parseFrom((byte[])localObject1);
      this.BsO.addAll((Collection)((boe)localObject2).ZWz);
      this.BsP.addAll((Collection)((boe)localObject2).ZWy);
      this.BsQ.addAll((Collection)((boe)localObject2).username_list);
    }
    Log.i("FinderLiveSelectContactUI", "select_contact_step1,init selectRoom:" + this.BsP + ", selectUser:" + this.BsQ + ", selectAllContact:" + this.BsO);
    AppMethodBeat.o(364325);
  }
  
  public final void ad(int paramInt, String paramString)
  {
    AppMethodBeat.i(364349);
    if (paramInt == 1)
    {
      kotlin.a.p.e((List)this.BsQ, (b)new OccupyFinderUI20.b(paramString));
      kotlin.a.p.e((List)this.BsP, (b)new OccupyFinderUI20.c(paramString));
      kotlin.a.p.e((List)this.BsO, (b)new OccupyFinderUI20.d(paramString));
      jyE().notifyDataSetChanged();
      aNr();
      Log.i("FinderLiveSelectContactUI", "select_contact_step2-2,onSelectChange selectRoom:" + this.BsP + ", selectUser:" + this.BsQ + ", selectAllContact:" + this.BsO);
    }
    AppMethodBeat.o(364349);
  }
  
  public final r bVA()
  {
    AppMethodBeat.i(364379);
    r localr = (r)new x((MMBaseSelectContactUI)this, (byte)0);
    AppMethodBeat.o(364379);
    return localr;
  }
  
  public final com.tencent.mm.ui.contact.p bVB()
  {
    AppMethodBeat.i(364386);
    com.tencent.mm.ui.contact.p localp = (com.tencent.mm.ui.contact.p)new z((MMBaseSelectContactUI)this);
    AppMethodBeat.o(364386);
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
    AppMethodBeat.i(364369);
    String str = getString(p.h.CtZ);
    s.s(str, "getString(R.string.finde…white_list_multi_contact)");
    AppMethodBeat.o(364369);
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
  
  public final void initView()
  {
    AppMethodBeat.i(364333);
    super.initView();
    View localView = findViewById(p.e.CaI);
    if (localView != null) {
      localView.post(new OccupyFinderUI20..ExternalSyntheticLambda2(localView, this));
    }
    AppMethodBeat.o(364333);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(364342);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 2)
    {
      if (paramIntent != null) {
        break label237;
      }
      paramIntent = null;
      paramIntent = Util.stringToList(paramIntent, ",");
      Collection localCollection = (Collection)paramIntent;
      if ((localCollection != null) && (!localCollection.isEmpty())) {
        break label248;
      }
    }
    label237:
    label248:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 == 0)
      {
        paramIntent = new LinkedList((Collection)paramIntent);
        Log.i("FinderLiveSelectContactUI", s.X("select user:", paramIntent));
        paramIntent.removeAll((Collection)this.BsQ);
        Log.i("FinderLiveSelectContactUI", s.X("after drop exist item, select user:", paramIntent));
        Log.i("FinderLiveSelectContactUI", s.X("before select user,selectAllContact:", this.BsO));
        this.BsO.addAll((Collection)paramIntent);
        Log.i("FinderLiveSelectContactUI", s.X("after select user,selectAllContact:", this.BsO));
        this.BsQ.addAll((Collection)paramIntent);
        this.KOt.mv((List)this.BsO);
        Log.i("FinderLiveSelectContactUI", "select_contact_step3,onSelectChange selectRoom:" + this.BsP + ", selectUser:" + this.BsQ + ", selectAllContact:" + this.BsO);
        aNr();
      }
      AppMethodBeat.o(364342);
      return;
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      break;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(364312);
    super.onCreate(paramBundle);
    setTheme(p.i.AppTheme_DarkMode);
    setActionbarColor(getResources().getColor(p.b.Dark_0));
    setNavigationbarColor(getResources().getColor(p.b.Dark_0));
    jyI();
    jyJ();
    addTextOptionMenu(1, getString(p.h.finder_live_visibility_finish_btn), new OccupyFinderUI20..ExternalSyntheticLambda0(this), null, y.b.adEZ);
    enableOptionMenu(1, true);
    this.KOt.mv((List)this.BsO);
    AppMethodBeat.o(364312);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI20
 * JD-Core Version:    0.7.0.1
 */