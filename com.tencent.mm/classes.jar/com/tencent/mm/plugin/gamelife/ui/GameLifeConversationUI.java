package com.tencent.mm.plugin.gamelife.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.f.b.a.fq;
import com.tencent.mm.game.report.c.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.gamelife.d.c;
import com.tencent.mm.plugin.gamelife.d.d;
import com.tencent.mm.plugin.gamelife.d.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.TouchableLayout;
import java.util.HashMap;
import java.util.LinkedList;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.o;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI;", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeChattingCompatUI;", "Lcom/tencent/mm/plugin/gamelife/ui/IGameLifeContract$IConversationView;", "()V", "conversationAdapter", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter;", "emptyCoverView", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeEmptyCoverView;", "enableLoadMore", "", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "getLayoutManager", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager$delegate", "Lkotlin/Lazy;", "loadingCoverView", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeLoadingCoverView;", "presenter", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationPresenter;", "disableLoadMore", "", "now", "dismissLoadingView", "finishLoadMore", "size", "", "getLayoutId", "getVisibleItemRange", "Lkotlin/Pair;", "initialLoadFailed", "isChattingClosed", "loadMoreFailed", "onBottomTabWidgetInstalled", "bottomMargin", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinish", "onNewIntent", "intent", "Landroid/content/Intent;", "onResume", "refreshGameCenterMsg", "showEmptyView", "show", "startChatting", "sessionId", "", "selfUsername", "talker", "Companion", "plugin-gamelife_release"})
public class GameLifeConversationUI
  extends GameLifeChattingCompatUI
  implements h.a
{
  public static final GameLifeConversationUI.a DiQ;
  private final b DiL;
  private final e DiM;
  private boolean DiN;
  private GameLifeLoadingCoverView DiO;
  private GameLifeEmptyCoverView DiP;
  private HashMap _$_findViewCache;
  private final f zQC;
  
  static
  {
    AppMethodBeat.i(203861);
    DiQ = new GameLifeConversationUI.a((byte)0);
    AppMethodBeat.o(203861);
  }
  
  public GameLifeConversationUI()
  {
    AppMethodBeat.i(203860);
    this.DiL = new b();
    this.DiM = new e((h.a)this, this.DiL);
    this.zQC = kotlin.g.ar((kotlin.g.a.a)new GameLifeConversationUI.d(this));
    this.DiN = true;
    AppMethodBeat.o(203860);
  }
  
  private final LinearLayoutManager getLayoutManager()
  {
    AppMethodBeat.i(203826);
    LinearLayoutManager localLinearLayoutManager = (LinearLayoutManager)this.zQC.getValue();
    AppMethodBeat.o(203826);
    return localLinearLayoutManager;
  }
  
  public final void Ua(int paramInt)
  {
    AppMethodBeat.i(203835);
    Object localObject1 = (TouchableLayout)_$_findCachedViewById(d.c.container);
    p.j(localObject1, "container");
    Object localObject2 = ((TouchableLayout)localObject1).getLayoutParams();
    localObject1 = localObject2;
    if (!(localObject2 instanceof FrameLayout.LayoutParams)) {
      localObject1 = null;
    }
    localObject1 = (FrameLayout.LayoutParams)localObject1;
    if (localObject1 != null) {
      ((FrameLayout.LayoutParams)localObject1).bottomMargin = paramInt;
    }
    localObject1 = new FrameLayout.LayoutParams(-1, -1);
    ((FrameLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.ci.a.fromDPToPix((Context)this, 152);
    localObject2 = (FrameLayout)_$_findCachedViewById(d.c.DfG);
    Object localObject3 = this.DiO;
    if (localObject3 == null) {
      p.bGy("loadingCoverView");
    }
    ((FrameLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject1);
    localObject2 = (FrameLayout)_$_findCachedViewById(d.c.DfG);
    localObject3 = this.DiP;
    if (localObject3 == null) {
      p.bGy("emptyCoverView");
    }
    ((FrameLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject1);
    AppMethodBeat.o(203835);
  }
  
  public final void Ub(int paramInt)
  {
    AppMethodBeat.i(203852);
    ((RefreshLoadMoreLayout)_$_findCachedViewById(d.c.rl_layout)).azs(paramInt);
    AppMethodBeat.o(203852);
  }
  
  public void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(203867);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(203867);
  }
  
  public View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(203866);
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
    AppMethodBeat.o(203866);
    return localView1;
  }
  
  public final void an(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(203838);
    p.k(paramString1, "sessionId");
    p.k(paramString2, "selfUsername");
    p.k(paramString3, "talker");
    Intent localIntent = new Intent();
    localIntent.putExtra("Chat_Self", paramString2);
    localIntent.putExtra("Chat_User", paramString1);
    localIntent.putExtra("finish_direct", true);
    com.tencent.mm.by.c.f((Context)getContext(), ".ui.chatting.ChattingUI", localIntent);
    ((com.tencent.mm.plugin.gamelife.a.b)h.ae(com.tencent.mm.plugin.gamelife.a.b.class)).aKF(paramString3);
    ((com.tencent.mm.plugin.gamelife.a.b)h.ae(com.tencent.mm.plugin.gamelife.a.b.class)).aKF(paramString2);
    AppMethodBeat.o(203838);
  }
  
  public final boolean atx()
  {
    AppMethodBeat.i(203859);
    com.tencent.mm.j.a locala = eAw();
    if (locala != null)
    {
      boolean bool = locala.atx();
      AppMethodBeat.o(203859);
      return bool;
    }
    AppMethodBeat.o(203859);
    return true;
  }
  
  public final void dZL()
  {
    AppMethodBeat.i(203848);
    d.uiThread((kotlin.g.a.a)new GameLifeConversationUI.b(this));
    AppMethodBeat.o(203848);
  }
  
  public final void eAA()
  {
    AppMethodBeat.i(203851);
    d.uiThread((kotlin.g.a.a)new GameLifeConversationUI.c(this));
    AppMethodBeat.o(203851);
  }
  
  public final void eAB()
  {
    AppMethodBeat.i(203854);
    d.uiThread((kotlin.g.a.a)new GameLifeConversationUI.e(this));
    AppMethodBeat.o(203854);
  }
  
  public final o<Integer, Integer> eAC()
  {
    AppMethodBeat.i(203858);
    o localo = new o(Integer.valueOf(getLayoutManager().kJ()), Integer.valueOf(getLayoutManager().kL()));
    Log.d("GameLife.ConversationUI", "range " + ((Number)localo.Mx).intValue() + " - " + ((Number)localo.My).intValue());
    AppMethodBeat.o(203858);
    return localo;
  }
  
  public int getLayoutId()
  {
    return d.d.Dgh;
  }
  
  public final void nO(final boolean paramBoolean)
  {
    AppMethodBeat.i(203845);
    d.uiThread((kotlin.g.a.a)new h(this, paramBoolean));
    AppMethodBeat.o(203845);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(203830);
    super.onCreate(paramBundle);
    setMMTitle(d.f.DgF);
    paramBundle = (RecyclerView)_$_findCachedViewById(d.c.DfH);
    paramBundle.setLayoutManager((RecyclerView.LayoutManager)getLayoutManager());
    paramBundle.setAdapter((RecyclerView.a)this.DiL);
    paramBundle.setItemAnimator(null);
    ((RefreshLoadMoreLayout)_$_findCachedViewById(d.c.rl_layout)).setActionCallback((RefreshLoadMoreLayout.a)new GameLifeConversationUI.g(this));
    paramBundle = new GameLifeLoadingCoverView((Context)this, null, 6, (byte)0);
    paramBundle.setOnClickListener((kotlin.g.a.a)new GameLifeConversationUI.f(this));
    this.DiO = paramBundle;
    paramBundle = new GameLifeEmptyCoverView((Context)this, null, 6, (byte)0);
    paramBundle.setVisibility(8);
    this.DiP = paramBundle;
    paramBundle = com.tencent.mm.plugin.gamelife.i.a.DhX;
    com.tencent.mm.plugin.gamelife.i.a.NT(getIntent().getIntExtra("game_report_from_scene", 0));
    paramBundle = this.DiM;
    b localb = paramBundle.DiF;
    Object localObject = (b.c)paramBundle.DiC;
    localb.Dig.Dik = ((b.c)localObject);
    localb.Dik = ((b.c)localObject);
    localb = paramBundle.DiF;
    localObject = (b.d)new c((kotlin.g.a.a)e.g.DiK);
    localb.Dig.Dil = ((b.d)localObject);
    localb.Dil = ((b.d)localObject);
    paramBundle.DiB.m(paramBundle.AoN);
    ((com.tencent.mm.plugin.gamelife.a.b)h.ae(com.tencent.mm.plugin.gamelife.a.b.class)).m(paramBundle.DiD);
    paramBundle.eAy();
    AppMethodBeat.o(203830);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(203843);
    super.onDestroy();
    e locale = this.DiM;
    locale.DiE = null;
    locale.DiB.l(locale.AoN);
    ((com.tencent.mm.plugin.gamelife.a.b)h.ae(com.tencent.mm.plugin.gamelife.a.b.class)).l(locale.DiD);
    AppMethodBeat.o(203843);
  }
  
  public void onFinish() {}
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(203832);
    super.onNewIntent(paramIntent);
    if (paramIntent != null)
    {
      com.tencent.mm.plugin.gamelife.i.a locala = com.tencent.mm.plugin.gamelife.i.a.DhX;
      com.tencent.mm.plugin.gamelife.i.a.NT(paramIntent.getIntExtra("game_report_from_scene", 0));
    }
    AppMethodBeat.o(203832);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(203842);
    super.onResume();
    e locale = this.DiM;
    Object localObject1 = com.tencent.mm.game.report.c.jTf;
    localObject1 = com.tencent.mm.plugin.gamelife.i.a.DhX;
    long l1 = com.tencent.mm.plugin.gamelife.i.a.eAv();
    c.a.a(2L, 0L, 0L, 1L, l1).bpa();
    c.a.a(2L, 201L, 0L, 1L, l1).bpa();
    if (locale.DiA)
    {
      locale.DiA = false;
      AppMethodBeat.o(203842);
      return;
    }
    localObject1 = com.tencent.mm.plugin.gamelife.i.a.DhX;
    com.tencent.mm.plugin.gamelife.i.a.NT(301L);
    locale.eAz();
    localObject1 = locale.DiF;
    Object localObject2 = ((b)localObject1).Dih;
    Object localObject3 = ((a)localObject2).Did;
    if (localObject3 != null) {
      ((a)localObject2).a((b.b)localObject3, 0);
    }
    localObject1 = ((b)localObject1).Dii;
    localObject2 = ((g)localObject1).Did;
    if (localObject2 != null) {
      ((g)localObject1).a((b.b)localObject2, 0);
    }
    localObject1 = locale.DiE;
    if (localObject1 != null)
    {
      if (((h.a)localObject1).atx() != true) {
        break label540;
      }
      localObject1 = locale.DiE;
      if (localObject1 == null) {
        break label224;
      }
    }
    label224:
    for (localObject1 = ((h.a)localObject1).eAC(); localObject1 == null; localObject1 = null)
    {
      AppMethodBeat.o(203842);
      return;
      AppMethodBeat.o(203842);
      return;
    }
    int i;
    int j;
    label264:
    int k;
    if (((Number)((o)localObject1).Mx).intValue() < 2)
    {
      i = 2;
      j = ((Number)((o)localObject1).My).intValue();
      if (i > j) {
        break label540;
      }
      localObject1 = locale.DiF.TY(i);
      if (((com.tencent.mm.plugin.gamelife.e.a)localObject1).eAs()) {
        break label468;
      }
      localObject3 = ((com.tencent.mm.plugin.gamelife.a.b)h.ae(com.tencent.mm.plugin.gamelife.a.b.class)).aKE(((com.tencent.mm.plugin.gamelife.e.a)localObject1).field_selfUserName);
      if (localObject3 != null)
      {
        localObject2 = com.tencent.mm.game.report.c.jTf;
        k = locale.DiF.syG.size();
        localObject2 = ((com.tencent.mm.plugin.gamelife.e.a)localObject1).field_sessionId;
        p.j(localObject2, "item.field_sessionId");
        l1 = ((com.tencent.mm.plugin.gamelife.a.a)localObject3).eAh();
        localObject3 = ((com.tencent.mm.plugin.gamelife.e.a)localObject1).field_selfUserName;
        p.j(localObject3, "item.field_selfUserName");
        Object localObject4 = ((com.tencent.mm.plugin.gamelife.e.a)localObject1).DhA;
        if (localObject4 == null) {
          p.iCn();
        }
        long l2 = ((com.tencent.mm.plugin.gamelife.d.a)localObject4).field_accountType;
        localObject4 = ((com.tencent.mm.plugin.gamelife.e.a)localObject1).field_talker;
        p.j(localObject4, "item.field_talker");
        long l3 = ((com.tencent.mm.plugin.gamelife.e.a)localObject1).eAr();
        localObject1 = com.tencent.mm.plugin.gamelife.i.a.DhX;
        c.a.a(i - 2 + 1, 1L, k, (String)localObject2, l1, (String)localObject3, l2, (String)localObject4, l3, com.tencent.mm.plugin.gamelife.i.a.eAv());
      }
    }
    for (;;)
    {
      if (i == j) {
        break label540;
      }
      i += 1;
      break label264;
      i = ((Number)((o)localObject1).Mx).intValue();
      break;
      label468:
      localObject2 = com.tencent.mm.game.report.c.jTf;
      k = locale.DiF.syG.size();
      localObject2 = ((com.tencent.mm.plugin.gamelife.e.a)localObject1).field_sessionId;
      p.j(localObject2, "item.field_sessionId");
      l1 = ((com.tencent.mm.plugin.gamelife.e.a)localObject1).eAr();
      localObject1 = com.tencent.mm.plugin.gamelife.i.a.DhX;
      c.a.a(i - 2 + 1, 1L, k, (String)localObject2, 0L, "", 0L, "", l1, com.tencent.mm.plugin.gamelife.i.a.eAv());
    }
    label540:
    AppMethodBeat.o(203842);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void sv(boolean paramBoolean)
  {
    AppMethodBeat.i(203856);
    this.DiN = false;
    if (paramBoolean) {
      ((RefreshLoadMoreLayout)_$_findCachedViewById(d.c.rl_layout)).setEnableLoadMore(false);
    }
    AppMethodBeat.o(203856);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<x>
  {
    h(GameLifeConversationUI paramGameLifeConversationUI, boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.ui.GameLifeConversationUI
 * JD-Core Version:    0.7.0.1
 */