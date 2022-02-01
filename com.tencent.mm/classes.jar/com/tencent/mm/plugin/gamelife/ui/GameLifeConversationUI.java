package com.tencent.mm.plugin.gamelife.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.b.a.eq;
import com.tencent.mm.game.report.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import java.util.HashMap;
import java.util.LinkedList;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.o;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI;", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeChattingCompatUI;", "Lcom/tencent/mm/plugin/gamelife/ui/IGameLifeContract$IConversationView;", "()V", "conversationAdapter", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter;", "emptyCoverView", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeEmptyCoverView;", "enableLoadMore", "", "layoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "getLayoutManager", "()Landroid/support/v7/widget/LinearLayoutManager;", "layoutManager$delegate", "Lkotlin/Lazy;", "loadingCoverView", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeLoadingCoverView;", "presenter", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationPresenter;", "disableLoadMore", "", "now", "dismissLoadingView", "finishLoadMore", "size", "", "getLayoutId", "getVisibleItemRange", "Lkotlin/Pair;", "initialLoadFailed", "isChattingClosed", "loadMoreFailed", "onBottomTabWidgetInstalled", "bottomMargin", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinish", "onNewIntent", "intent", "Landroid/content/Intent;", "onResume", "refreshGameCenterMsg", "showEmptyView", "show", "startChatting", "sessionId", "", "selfUsername", "talker", "Companion", "plugin-gamelife_release"})
public class GameLifeConversationUI
  extends GameLifeChattingCompatUI
  implements h.a
{
  public static final GameLifeConversationUI.a ydm;
  private HashMap _$_findViewCache;
  private final f vat;
  private final b ydh;
  public final e ydi;
  private boolean ydj;
  public GameLifeLoadingCoverView ydk;
  public GameLifeEmptyCoverView ydl;
  
  static
  {
    AppMethodBeat.i(241517);
    ydm = new GameLifeConversationUI.a((byte)0);
    AppMethodBeat.o(241517);
  }
  
  public GameLifeConversationUI()
  {
    AppMethodBeat.i(241516);
    this.ydh = new b();
    this.ydi = new e((h.a)this, this.ydh);
    this.vat = kotlin.g.ah((kotlin.g.a.a)new d(this));
    this.ydj = true;
    AppMethodBeat.o(241516);
  }
  
  private final LinearLayoutManager getLayoutManager()
  {
    AppMethodBeat.i(241502);
    LinearLayoutManager localLinearLayoutManager = (LinearLayoutManager)this.vat.getValue();
    AppMethodBeat.o(241502);
    return localLinearLayoutManager;
  }
  
  public final void OF(int paramInt)
  {
    AppMethodBeat.i(241511);
    ((RefreshLoadMoreLayout)_$_findCachedViewById(2131307118)).apT(paramInt);
    AppMethodBeat.o(241511);
  }
  
  public void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(241521);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(241521);
  }
  
  public View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(241520);
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
    AppMethodBeat.o(241520);
    return localView1;
  }
  
  public final boolean anw()
  {
    AppMethodBeat.i(241515);
    com.tencent.mm.j.a locala = this.vQb;
    if (locala != null)
    {
      boolean bool = locala.anw();
      AppMethodBeat.o(241515);
      return bool;
    }
    AppMethodBeat.o(241515);
    return true;
  }
  
  public final void at(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(241505);
    p.h(paramString1, "sessionId");
    p.h(paramString2, "selfUsername");
    p.h(paramString3, "talker");
    Intent localIntent = new Intent();
    localIntent.putExtra("Chat_Self", paramString2);
    localIntent.putExtra("Chat_User", paramString1);
    localIntent.putExtra("finish_direct", true);
    com.tencent.mm.br.c.f((Context)getContext(), ".ui.chatting.ChattingUI", localIntent);
    ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.b.class)).aAS(paramString3);
    ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.b.class)).aAS(paramString2);
    AppMethodBeat.o(241505);
  }
  
  public final void dXr()
  {
    AppMethodBeat.i(241509);
    d.h((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(241509);
  }
  
  public final void dXs()
  {
    AppMethodBeat.i(241510);
    d.h((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(241510);
  }
  
  public final void dXt()
  {
    AppMethodBeat.i(241512);
    d.h((kotlin.g.a.a)new e(this));
    AppMethodBeat.o(241512);
  }
  
  public final o<Integer, Integer> dXu()
  {
    AppMethodBeat.i(241514);
    o localo = new o(Integer.valueOf(getLayoutManager().ks()), Integer.valueOf(getLayoutManager().ku()));
    Log.d("GameLife.ConversationUI", "range " + ((Number)localo.first).intValue() + " - " + ((Number)localo.second).intValue());
    AppMethodBeat.o(241514);
    return localo;
  }
  
  public int getLayoutId()
  {
    return 2131494977;
  }
  
  public final void mB(final boolean paramBoolean)
  {
    AppMethodBeat.i(241508);
    d.h((kotlin.g.a.a)new h(this, paramBoolean));
    AppMethodBeat.o(241508);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(241503);
    super.onCreate(paramBundle);
    paramBundle = (RecyclerView)_$_findCachedViewById(2131299247);
    paramBundle.setLayoutManager((RecyclerView.LayoutManager)getLayoutManager());
    paramBundle.setAdapter((RecyclerView.a)this.ydh);
    paramBundle.setItemAnimator(null);
    ((RefreshLoadMoreLayout)_$_findCachedViewById(2131307118)).setActionCallback((RefreshLoadMoreLayout.a)new g(this));
    paramBundle = new GameLifeLoadingCoverView((Context)this, null, 6, (byte)0);
    paramBundle.setOnClickListener((kotlin.g.a.a)new f(this));
    this.ydk = paramBundle;
    paramBundle = new GameLifeEmptyCoverView((Context)this, null, 6, (byte)0);
    paramBundle.setVisibility(8);
    this.ydl = paramBundle;
    paramBundle = com.tencent.mm.plugin.gamelife.i.a.ycs;
    com.tencent.mm.plugin.gamelife.i.a.GN(getIntent().getIntExtra("game_report_from_scene", 0));
    paramBundle = this.ydi;
    b localb = paramBundle.ydb;
    Object localObject = (b.c)paramBundle.ycY;
    localb.ycB.ycF = ((b.c)localObject);
    localb.ycF = ((b.c)localObject);
    localb = paramBundle.ydb;
    localObject = (b.d)new c((kotlin.g.a.a)e.g.ydg);
    localb.ycB.ycG = ((b.d)localObject);
    localb.ycG = ((b.d)localObject);
    paramBundle.ycX.m(paramBundle.vHQ);
    ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.b.class)).m(paramBundle.ycZ);
    paramBundle.dXp();
    AppMethodBeat.o(241503);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(241507);
    super.onDestroy();
    e locale = this.ydi;
    locale.yda = null;
    locale.ycX.l(locale.vHQ);
    ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.b.class)).l(locale.ycZ);
    AppMethodBeat.o(241507);
  }
  
  public void onFinish() {}
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(241504);
    super.onNewIntent(paramIntent);
    if (paramIntent != null)
    {
      com.tencent.mm.plugin.gamelife.i.a locala = com.tencent.mm.plugin.gamelife.i.a.ycs;
      com.tencent.mm.plugin.gamelife.i.a.GN(paramIntent.getIntExtra("game_report_from_scene", 0));
    }
    AppMethodBeat.o(241504);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(241506);
    super.onResume();
    e locale = this.ydi;
    Object localObject1 = com.tencent.mm.game.report.c.hhl;
    localObject1 = com.tencent.mm.plugin.gamelife.i.a.ycs;
    long l1 = com.tencent.mm.plugin.gamelife.i.a.dXm();
    c.a.a(2L, 0L, 0L, 1L, l1).bfK();
    c.a.a(2L, 201L, 0L, 1L, l1).bfK();
    if (locale.ycW)
    {
      locale.ycW = false;
      AppMethodBeat.o(241506);
      return;
    }
    localObject1 = com.tencent.mm.plugin.gamelife.i.a.ycs;
    com.tencent.mm.plugin.gamelife.i.a.GN(301L);
    locale.dXq();
    locale.ydb.dXn();
    localObject1 = locale.yda;
    if (localObject1 != null)
    {
      if (((h.a)localObject1).anw() != true) {
        break label487;
      }
      localObject1 = locale.yda;
      if (localObject1 == null) {
        break label171;
      }
    }
    label171:
    for (localObject1 = ((h.a)localObject1).dXu(); localObject1 == null; localObject1 = null)
    {
      AppMethodBeat.o(241506);
      return;
      AppMethodBeat.o(241506);
      return;
    }
    int i;
    int j;
    label211:
    Object localObject2;
    int k;
    if (((Number)((o)localObject1).first).intValue() < 2)
    {
      i = 2;
      j = ((Number)((o)localObject1).second).intValue();
      if (i > j) {
        break label487;
      }
      localObject1 = locale.ydb.OD(i);
      if (((com.tencent.mm.plugin.gamelife.e.a)localObject1).dXj()) {
        break label415;
      }
      Object localObject3 = ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.b.class)).aAR(((com.tencent.mm.plugin.gamelife.e.a)localObject1).field_selfUserName);
      if (localObject3 != null)
      {
        localObject2 = com.tencent.mm.game.report.c.hhl;
        k = locale.ydb.ppH.size();
        localObject2 = ((com.tencent.mm.plugin.gamelife.e.a)localObject1).field_sessionId;
        p.g(localObject2, "item.field_sessionId");
        l1 = ((com.tencent.mm.plugin.gamelife.a.a)localObject3).dWY();
        localObject3 = ((com.tencent.mm.plugin.gamelife.e.a)localObject1).field_selfUserName;
        p.g(localObject3, "item.field_selfUserName");
        Object localObject4 = ((com.tencent.mm.plugin.gamelife.e.a)localObject1).ybV;
        if (localObject4 == null) {
          p.hyc();
        }
        long l2 = ((com.tencent.mm.plugin.gamelife.d.a)localObject4).field_accountType;
        localObject4 = ((com.tencent.mm.plugin.gamelife.e.a)localObject1).field_talker;
        p.g(localObject4, "item.field_talker");
        long l3 = ((com.tencent.mm.plugin.gamelife.e.a)localObject1).dXi();
        localObject1 = com.tencent.mm.plugin.gamelife.i.a.ycs;
        c.a.a(i - 2 + 1, 1L, k, (String)localObject2, l1, (String)localObject3, l2, (String)localObject4, l3, com.tencent.mm.plugin.gamelife.i.a.dXm());
      }
    }
    for (;;)
    {
      if (i == j) {
        break label487;
      }
      i += 1;
      break label211;
      i = ((Number)((o)localObject1).first).intValue();
      break;
      label415:
      localObject2 = com.tencent.mm.game.report.c.hhl;
      k = locale.ydb.ppH.size();
      localObject2 = ((com.tencent.mm.plugin.gamelife.e.a)localObject1).field_sessionId;
      p.g(localObject2, "item.field_sessionId");
      l1 = ((com.tencent.mm.plugin.gamelife.e.a)localObject1).dXi();
      localObject1 = com.tencent.mm.plugin.gamelife.i.a.ycs;
      c.a.a(i - 2 + 1, 1L, k, (String)localObject2, 0L, "", 0L, "", l1, com.tencent.mm.plugin.gamelife.i.a.dXm());
    }
    label487:
    AppMethodBeat.o(241506);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void pY(boolean paramBoolean)
  {
    AppMethodBeat.i(241513);
    this.ydj = false;
    if (paramBoolean) {
      ((RefreshLoadMoreLayout)_$_findCachedViewById(2131307118)).setEnableLoadMore(false);
    }
    AppMethodBeat.o(241513);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(GameLifeConversationUI paramGameLifeConversationUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(GameLifeConversationUI paramGameLifeConversationUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/support/v7/widget/LinearLayoutManager;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<LinearLayoutManager>
  {
    d(GameLifeConversationUI paramGameLifeConversationUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    e(GameLifeConversationUI paramGameLifeConversationUI)
    {
      super();
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$loadMoreFailed$1$1$1"})
    static final class a
      implements View.OnClickListener
    {
      a(GameLifeConversationUI.e parame) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(241494);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$loadMoreFailed$1$$special$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        GameLifeConversationUI.a(this.ydo.ydn).onLoadMore();
        p.g(paramView, "it");
        paramView.setVisibility(8);
        paramView = ((RefreshLoadMoreLayout)this.ydo.ydn._$_findCachedViewById(2131307118)).getLoadMoreFooter();
        if (paramView != null)
        {
          paramView = paramView.findViewById(2131303690);
          if (paramView != null) {
            paramView.setVisibility(0);
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$loadMoreFailed$1$$special$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(241494);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$onCreate$3$1"})
  static final class f
    extends q
    implements kotlin.g.a.a<x>
  {
    f(GameLifeConversationUI paramGameLifeConversationUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$onCreate$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-gamelife_release"})
  public static final class g
    extends RefreshLoadMoreLayout.a
  {
    public final void ED(int paramInt)
    {
      AppMethodBeat.i(241499);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.axR());
      super.ED(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(241499);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(241498);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.axR());
      p.h(paramc, "reason");
      ((RefreshLoadMoreLayout)this.ydn._$_findCachedViewById(2131307118)).setEnableLoadMore(GameLifeConversationUI.b(this.ydn));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(241498);
    }
    
    public final void cxo()
    {
      AppMethodBeat.i(241497);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      GameLifeConversationUI.a(this.ydn).onLoadMore();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(241497);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(241500);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.axR());
      super.onRefreshEnd(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(241500);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.ui.GameLifeConversationUI
 * JD-Core Version:    0.7.0.1
 */