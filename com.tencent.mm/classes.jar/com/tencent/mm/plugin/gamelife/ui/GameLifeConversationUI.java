package com.tencent.mm.plugin.gamelife.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.b.a.cf;
import com.tencent.mm.game.report.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import d.f;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.o;
import d.z;
import java.util.HashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI;", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeChattingCompatUI;", "Lcom/tencent/mm/plugin/gamelife/ui/IGameLifeContract$IConversationView;", "()V", "conversationAdapter", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter;", "enableLoadMore", "", "layoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "getLayoutManager", "()Landroid/support/v7/widget/LinearLayoutManager;", "layoutManager$delegate", "Lkotlin/Lazy;", "loadingCoverView", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeLoadingCoverView;", "presenter", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationPresenter;", "disableLoadMore", "", "dismissLoadingView", "finishLoadMore", "size", "", "getLayoutId", "getVisibleItemRange", "Lkotlin/Pair;", "initialLoadFailed", "isChattingClosed", "loadMoreFailed", "onBottomTabWidgetInstalled", "bottomMargin", "onChattingUIExit", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinish", "onNewIntent", "intent", "Landroid/content/Intent;", "onResume", "startChatting", "sessionId", "", "selfUsername", "talker", "Companion", "plugin-gamelife_release"})
public class GameLifeConversationUI
  extends GameLifeChattingCompatUI
  implements h.a
{
  public static final a uzn;
  private HashMap _$_findViewCache;
  private final b uzi;
  private final e uzj;
  private final f uzk;
  private boolean uzl;
  public GameLifeLoadingCoverView uzm;
  
  static
  {
    AppMethodBeat.i(211489);
    uzn = new a((byte)0);
    AppMethodBeat.o(211489);
  }
  
  public GameLifeConversationUI()
  {
    AppMethodBeat.i(211488);
    this.uzi = new b();
    this.uzj = new e((h.a)this, this.uzi);
    this.uzk = d.g.O((d.g.a.a)new d(this));
    this.uzl = true;
    AppMethodBeat.o(211488);
  }
  
  private final LinearLayoutManager daP()
  {
    AppMethodBeat.i(211475);
    LinearLayoutManager localLinearLayoutManager = (LinearLayoutManager)this.uzk.getValue();
    AppMethodBeat.o(211475);
    return localLinearLayoutManager;
  }
  
  public final void Ig(int paramInt)
  {
    AppMethodBeat.i(211483);
    ((RefreshLoadMoreLayout)_$_findCachedViewById(2131304203)).afZ(paramInt);
    AppMethodBeat.o(211483);
  }
  
  public final boolean ZA()
  {
    AppMethodBeat.i(211487);
    com.tencent.mm.j.a locala = this.sIk;
    if (locala != null)
    {
      boolean bool = locala.ZA();
      AppMethodBeat.o(211487);
      return bool;
    }
    AppMethodBeat.o(211487);
    return true;
  }
  
  public final boolean ZC()
  {
    AppMethodBeat.i(211486);
    com.tencent.mm.plugin.gamelife.h.a locala = com.tencent.mm.plugin.gamelife.h.a.uyu;
    com.tencent.mm.plugin.gamelife.h.a.xJ(301L);
    this.uzj.b(daU());
    boolean bool = super.ZC();
    AppMethodBeat.o(211486);
    return bool;
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(211491);
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
    AppMethodBeat.o(211491);
    return localView1;
  }
  
  public final void al(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(211478);
    p.h(paramString1, "sessionId");
    p.h(paramString2, "selfUsername");
    p.h(paramString3, "talker");
    Intent localIntent = new Intent();
    localIntent.putExtra("Chat_Self", paramString2);
    localIntent.putExtra("Chat_User", paramString1);
    localIntent.putExtra("finish_direct", true);
    d.f((Context)getContext(), ".ui.chatting.ChattingUI", localIntent);
    ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.b.class)).aic(paramString3);
    ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.b.class)).aic(paramString2);
    AppMethodBeat.o(211478);
  }
  
  public final void daQ()
  {
    AppMethodBeat.i(211481);
    com.tencent.mm.ad.c.g((d.g.a.a)new b(this));
    AppMethodBeat.o(211481);
  }
  
  public final void daR()
  {
    AppMethodBeat.i(211482);
    com.tencent.mm.ad.c.g((d.g.a.a)new c(this));
    AppMethodBeat.o(211482);
  }
  
  public final void daS()
  {
    AppMethodBeat.i(211484);
    com.tencent.mm.ad.c.g((d.g.a.a)new e(this));
    AppMethodBeat.o(211484);
  }
  
  public final void daT()
  {
    this.uzl = false;
  }
  
  public final o<Integer, Integer> daU()
  {
    AppMethodBeat.i(211485);
    o localo = new o(Integer.valueOf(daP().km()), Integer.valueOf(daP().ko()));
    ad.d("GameLife.ConversationUI", "range " + ((Number)localo.first).intValue() + " - " + ((Number)localo.second).intValue());
    AppMethodBeat.o(211485);
    return localo;
  }
  
  public int getLayoutId()
  {
    return 2131496408;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(211476);
    super.onCreate(paramBundle);
    paramBundle = (RecyclerView)_$_findCachedViewById(2131308078);
    paramBundle.setLayoutManager((RecyclerView.i)daP());
    paramBundle.setAdapter((RecyclerView.a)this.uzi);
    paramBundle.setItemAnimator(null);
    ((RefreshLoadMoreLayout)_$_findCachedViewById(2131304203)).setActionCallback((RefreshLoadMoreLayout.a)new g(this));
    paramBundle = new GameLifeLoadingCoverView((Context)this, null, 6, (byte)0);
    paramBundle.setOnClickListener((d.g.a.a)new f(this));
    this.uzm = paramBundle;
    paramBundle = com.tencent.mm.plugin.gamelife.h.a.uyu;
    com.tencent.mm.plugin.gamelife.h.a.xJ(getIntent().getIntExtra("game_report_from_scene", 0));
    paramBundle = this.uzj;
    b localb = paramBundle.uzd;
    Object localObject = (b.c)paramBundle.uzb;
    localb.uyD.uyH = ((b.c)localObject);
    localb.uyH = ((b.c)localObject);
    localb = paramBundle.uzd;
    localObject = (b.d)new c((d.g.a.a)e.e.uzh);
    localb.uyD.uyI = ((b.d)localObject);
    localb.uyI = ((b.d)localObject);
    paramBundle.uza.m(paramBundle.sBa);
    paramBundle.daN();
    AppMethodBeat.o(211476);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(211480);
    super.onDestroy();
    e locale = this.uzj;
    locale.uzc = null;
    locale.uza.l(locale.sBa);
    AppMethodBeat.o(211480);
  }
  
  public void onFinish() {}
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(211477);
    super.onNewIntent(paramIntent);
    if (paramIntent != null)
    {
      com.tencent.mm.plugin.gamelife.h.a locala = com.tencent.mm.plugin.gamelife.h.a.uyu;
      com.tencent.mm.plugin.gamelife.h.a.xJ(paramIntent.getIntExtra("game_report_from_scene", 0));
    }
    AppMethodBeat.o(211477);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(211479);
    super.onResume();
    e locale = this.uzj;
    Object localObject1 = com.tencent.mm.game.report.c.grV;
    localObject1 = com.tencent.mm.plugin.gamelife.h.a.uyu;
    long l = com.tencent.mm.plugin.gamelife.h.a.daL();
    c.a.a(2L, 0L, 0L, 1L, l).aLk();
    c.a.a(2L, 201L, 0L, 1L, l).aLk();
    if (locale.uyZ)
    {
      locale.uyZ = false;
      AppMethodBeat.o(211479);
      return;
    }
    locale.daO();
    localObject1 = locale.uzd;
    Object localObject2 = ((b)localObject1).uyE;
    b.b localb = ((a)localObject2).uyA;
    if (localb != null) {
      ((a)localObject2).a(localb, 0);
    }
    localObject1 = ((b)localObject1).uyF;
    localObject2 = ((g)localObject1).uyA;
    if (localObject2 != null) {
      ((g)localObject1).a((b.b)localObject2, 0);
    }
    localObject1 = locale.uzc;
    if (localObject1 != null) {
      if (((h.a)localObject1).ZA() == true)
      {
        localObject1 = locale.uzc;
        if (localObject1 == null) {
          break label196;
        }
      }
    }
    label196:
    for (localObject1 = ((h.a)localObject1).daU();; localObject1 = null)
    {
      locale.b((o)localObject1);
      AppMethodBeat.o(211479);
      return;
      AppMethodBeat.o(211479);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$Companion;", "", "()V", "GAME_CENTER_ITEM_AREA_HEIGHT", "", "TAG", "", "plugin-gamelife_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<z>
  {
    b(GameLifeConversationUI paramGameLifeConversationUI)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<z>
  {
    c(GameLifeConversationUI paramGameLifeConversationUI)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/support/v7/widget/LinearLayoutManager;", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<LinearLayoutManager>
  {
    d(GameLifeConversationUI paramGameLifeConversationUI)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements d.g.a.a<z>
  {
    e(GameLifeConversationUI paramGameLifeConversationUI)
    {
      super();
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$loadMoreFailed$1$1$1"})
    static final class a
      implements View.OnClickListener
    {
      a(GameLifeConversationUI.e parame) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(211468);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$loadMoreFailed$1$$special$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        GameLifeConversationUI.a(this.uzp.uzo).Zt();
        p.g(paramView, "it");
        paramView.setVisibility(8);
        paramView = ((RefreshLoadMoreLayout)this.uzp.uzo._$_findCachedViewById(2131304203)).getLoadMoreFooter();
        if (paramView != null)
        {
          paramView = paramView.findViewById(2131301491);
          if (paramView != null) {
            paramView.setVisibility(0);
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$loadMoreFailed$1$$special$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(211468);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$onCreate$3$1"})
  static final class f
    extends q
    implements d.g.a.a<z>
  {
    f(GameLifeConversationUI paramGameLifeConversationUI)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$onCreate$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-gamelife_release"})
  public static final class g
    extends RefreshLoadMoreLayout.a
  {
    public final void AM(int paramInt)
    {
      AppMethodBeat.i(211473);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.mr(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.ahq());
      super.AM(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(211473);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(211472);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahq());
      p.h(paramc, "reason");
      ((RefreshLoadMoreLayout)this.uzo._$_findCachedViewById(2131304203)).setEnableLoadMore(GameLifeConversationUI.b(this.uzo));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(211472);
    }
    
    public final void b(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(211474);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahq());
      super.b(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(211474);
    }
    
    public final void bYl()
    {
      AppMethodBeat.i(211471);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      GameLifeConversationUI.a(this.uzo).Zt();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(211471);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.ui.GameLifeConversationUI
 * JD-Core Version:    0.7.0.1
 */