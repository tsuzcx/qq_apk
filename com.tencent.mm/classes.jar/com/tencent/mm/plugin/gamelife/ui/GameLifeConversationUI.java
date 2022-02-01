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
import com.tencent.mm.br.d;
import com.tencent.mm.g.b.a.cf;
import com.tencent.mm.game.report.c.a;
import com.tencent.mm.sdk.platformtools.ae;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI;", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeChattingCompatUI;", "Lcom/tencent/mm/plugin/gamelife/ui/IGameLifeContract$IConversationView;", "()V", "conversationAdapter", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter;", "emptyCoverView", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeEmptyCoverView;", "enableLoadMore", "", "layoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "getLayoutManager", "()Landroid/support/v7/widget/LinearLayoutManager;", "layoutManager$delegate", "Lkotlin/Lazy;", "loadingCoverView", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeLoadingCoverView;", "presenter", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationPresenter;", "disableLoadMore", "", "dismissLoadingView", "finishLoadMore", "size", "", "getLayoutId", "getVisibleItemRange", "Lkotlin/Pair;", "initialLoadFailed", "isChattingClosed", "loadMoreFailed", "onBottomTabWidgetInstalled", "bottomMargin", "onChattingUIExit", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinish", "onNewIntent", "intent", "Landroid/content/Intent;", "onResume", "showEmptyView", "show", "startChatting", "sessionId", "", "selfUsername", "talker", "Companion", "plugin-gamelife_release"})
public class GameLifeConversationUI
  extends GameLifeChattingCompatUI
  implements h.a
{
  public static final GameLifeConversationUI.a uKS;
  private HashMap _$_findViewCache;
  private final b uKM;
  private final e uKN;
  private final f uKO;
  private boolean uKP;
  public GameLifeLoadingCoverView uKQ;
  public GameLifeEmptyCoverView uKR;
  
  static
  {
    AppMethodBeat.i(212275);
    uKS = new GameLifeConversationUI.a((byte)0);
    AppMethodBeat.o(212275);
  }
  
  public GameLifeConversationUI()
  {
    AppMethodBeat.i(212274);
    this.uKM = new b();
    this.uKN = new e((h.a)this, this.uKM);
    this.uKO = d.g.O((d.g.a.a)new GameLifeConversationUI.d(this));
    this.uKP = true;
    AppMethodBeat.o(212274);
  }
  
  private final LinearLayoutManager ddG()
  {
    AppMethodBeat.i(212260);
    LinearLayoutManager localLinearLayoutManager = (LinearLayoutManager)this.uKO.getValue();
    AppMethodBeat.o(212260);
    return localLinearLayoutManager;
  }
  
  public final void IE(int paramInt)
  {
    AppMethodBeat.i(212269);
    ((RefreshLoadMoreLayout)_$_findCachedViewById(2131304203)).agI(paramInt);
    AppMethodBeat.o(212269);
  }
  
  public final boolean ZJ()
  {
    AppMethodBeat.i(212273);
    com.tencent.mm.j.a locala = this.sTw;
    if (locala != null)
    {
      boolean bool = locala.ZJ();
      AppMethodBeat.o(212273);
      return bool;
    }
    AppMethodBeat.o(212273);
    return true;
  }
  
  public final boolean ZL()
  {
    AppMethodBeat.i(212272);
    com.tencent.mm.plugin.gamelife.i.a locala = com.tencent.mm.plugin.gamelife.i.a.uJX;
    com.tencent.mm.plugin.gamelife.i.a.yd(301L);
    this.uKN.b(ddL());
    boolean bool = super.ZL();
    AppMethodBeat.o(212272);
    return bool;
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(212278);
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
    AppMethodBeat.o(212278);
    return localView1;
  }
  
  public final void al(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(212263);
    p.h(paramString1, "sessionId");
    p.h(paramString2, "selfUsername");
    p.h(paramString3, "talker");
    Intent localIntent = new Intent();
    localIntent.putExtra("Chat_Self", paramString2);
    localIntent.putExtra("Chat_User", paramString1);
    localIntent.putExtra("finish_direct", true);
    d.f((Context)getContext(), ".ui.chatting.ChattingUI", localIntent);
    ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.b.class)).anz(paramString3);
    ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.b.class)).anz(paramString2);
    AppMethodBeat.o(212263);
  }
  
  public final void ddH()
  {
    AppMethodBeat.i(212267);
    com.tencent.mm.ac.c.h((d.g.a.a)new GameLifeConversationUI.b(this));
    AppMethodBeat.o(212267);
  }
  
  public final void ddI()
  {
    AppMethodBeat.i(212268);
    com.tencent.mm.ac.c.h((d.g.a.a)new GameLifeConversationUI.c(this));
    AppMethodBeat.o(212268);
  }
  
  public final void ddJ()
  {
    AppMethodBeat.i(212270);
    com.tencent.mm.ac.c.h((d.g.a.a)new e(this));
    AppMethodBeat.o(212270);
  }
  
  public final void ddK()
  {
    this.uKP = false;
  }
  
  public final o<Integer, Integer> ddL()
  {
    AppMethodBeat.i(212271);
    o localo = new o(Integer.valueOf(ddG().km()), Integer.valueOf(ddG().ko()));
    ae.d("GameLife.ConversationUI", "range " + ((Number)localo.first).intValue() + " - " + ((Number)localo.second).intValue());
    AppMethodBeat.o(212271);
    return localo;
  }
  
  public int getLayoutId()
  {
    return 2131496408;
  }
  
  public final void id(final boolean paramBoolean)
  {
    AppMethodBeat.i(212266);
    com.tencent.mm.ac.c.h((d.g.a.a)new h(this, paramBoolean));
    AppMethodBeat.o(212266);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(212261);
    super.onCreate(paramBundle);
    paramBundle = (RecyclerView)_$_findCachedViewById(2131308078);
    paramBundle.setLayoutManager((RecyclerView.i)ddG());
    paramBundle.setAdapter((RecyclerView.a)this.uKM);
    paramBundle.setItemAnimator(null);
    ((RefreshLoadMoreLayout)_$_findCachedViewById(2131304203)).setActionCallback((RefreshLoadMoreLayout.a)new g(this));
    paramBundle = new GameLifeLoadingCoverView((Context)this, null, 6, (byte)0);
    paramBundle.setOnClickListener((d.g.a.a)new f(this));
    this.uKQ = paramBundle;
    paramBundle = new GameLifeEmptyCoverView((Context)this, null, 6, (byte)0);
    paramBundle.setVisibility(8);
    this.uKR = paramBundle;
    paramBundle = com.tencent.mm.plugin.gamelife.i.a.uJX;
    com.tencent.mm.plugin.gamelife.i.a.yd(getIntent().getIntExtra("game_report_from_scene", 0));
    paramBundle = this.uKN;
    b localb = paramBundle.uKH;
    Object localObject = (b.c)paramBundle.uKE;
    localb.uKg.uKk = ((b.c)localObject);
    localb.uKk = ((b.c)localObject);
    localb = paramBundle.uKH;
    localObject = (b.d)new c((d.g.a.a)e.g.uKL);
    localb.uKg.uKl = ((b.d)localObject);
    localb.uKl = ((b.d)localObject);
    paramBundle.uKD.m(paramBundle.sMa);
    ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.b.class)).m(paramBundle.uKF);
    paramBundle.ddE();
    AppMethodBeat.o(212261);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(212265);
    super.onDestroy();
    e locale = this.uKN;
    locale.uKG = null;
    locale.uKD.l(locale.sMa);
    ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.b.class)).l(locale.uKF);
    AppMethodBeat.o(212265);
  }
  
  public void onFinish() {}
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(212262);
    super.onNewIntent(paramIntent);
    if (paramIntent != null)
    {
      com.tencent.mm.plugin.gamelife.i.a locala = com.tencent.mm.plugin.gamelife.i.a.uJX;
      com.tencent.mm.plugin.gamelife.i.a.yd(paramIntent.getIntExtra("game_report_from_scene", 0));
    }
    AppMethodBeat.o(212262);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(212264);
    super.onResume();
    e locale = this.uKN;
    Object localObject1 = com.tencent.mm.game.report.c.guw;
    localObject1 = com.tencent.mm.plugin.gamelife.i.a.uJX;
    long l = com.tencent.mm.plugin.gamelife.i.a.ddC();
    c.a.a(2L, 0L, 0L, 1L, l).aLH();
    c.a.a(2L, 201L, 0L, 1L, l).aLH();
    if (locale.uKC)
    {
      locale.uKC = false;
      AppMethodBeat.o(212264);
      return;
    }
    locale.ddF();
    localObject1 = locale.uKH;
    Object localObject2 = ((b)localObject1).uKh;
    b.b localb = ((a)localObject2).uKd;
    if (localb != null) {
      ((a)localObject2).a(localb, 0);
    }
    localObject1 = ((b)localObject1).uKi;
    localObject2 = ((g)localObject1).uKd;
    if (localObject2 != null) {
      ((g)localObject1).a((b.b)localObject2, 0);
    }
    localObject1 = locale.uKG;
    if (localObject1 != null) {
      if (((h.a)localObject1).ZJ() == true)
      {
        localObject1 = locale.uKG;
        if (localObject1 == null) {
          break label196;
        }
      }
    }
    label196:
    for (localObject1 = ((h.a)localObject1).ddL();; localObject1 = null)
    {
      locale.b((o)localObject1);
      AppMethodBeat.o(212264);
      return;
      AppMethodBeat.o(212264);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements d.g.a.a<z>
  {
    e(GameLifeConversationUI paramGameLifeConversationUI)
    {
      super();
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$loadMoreFailed$1$1$1"})
    static final class a
      implements View.OnClickListener
    {
      a(GameLifeConversationUI.e parame) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(212252);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$loadMoreFailed$1$$special$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        GameLifeConversationUI.a(this.uKU.uKT).ZC();
        p.g(paramView, "it");
        paramView.setVisibility(8);
        paramView = ((RefreshLoadMoreLayout)this.uKU.uKT._$_findCachedViewById(2131304203)).getLoadMoreFooter();
        if (paramView != null)
        {
          paramView = paramView.findViewById(2131301491);
          if (paramView != null) {
            paramView.setVisibility(0);
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$loadMoreFailed$1$$special$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(212252);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$onCreate$3$1"})
  static final class f
    extends q
    implements d.g.a.a<z>
  {
    f(GameLifeConversationUI paramGameLifeConversationUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$onCreate$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-gamelife_release"})
  public static final class g
    extends RefreshLoadMoreLayout.a
  {
    public final void AY(int paramInt)
    {
      AppMethodBeat.i(212257);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.mu(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.ahF());
      super.AY(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(212257);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(212256);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahF());
      p.h(paramc, "reason");
      ((RefreshLoadMoreLayout)this.uKT._$_findCachedViewById(2131304203)).setEnableLoadMore(GameLifeConversationUI.b(this.uKT));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(212256);
    }
    
    public final void b(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(212258);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahF());
      super.b(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(212258);
    }
    
    public final void bZA()
    {
      AppMethodBeat.i(212255);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      GameLifeConversationUI.a(this.uKT).ZC();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(212255);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements d.g.a.a<z>
  {
    h(GameLifeConversationUI paramGameLifeConversationUI, boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.ui.GameLifeConversationUI
 * JD-Core Version:    0.7.0.1
 */