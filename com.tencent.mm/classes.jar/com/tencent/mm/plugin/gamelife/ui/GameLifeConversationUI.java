package com.tencent.mm.plugin.gamelife.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.gamelife.d.c;
import com.tencent.mm.plugin.gamelife.d.d;
import com.tencent.mm.plugin.gamelife.d.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.TouchableLayout;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI;", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeChattingCompatUI;", "Lcom/tencent/mm/plugin/gamelife/ui/IGameLifeContract$IConversationView;", "()V", "conversationAdapter", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter;", "emptyCoverView", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeEmptyCoverView;", "enableLoadMore", "", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "getLayoutManager", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager$delegate", "Lkotlin/Lazy;", "loadingCoverView", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeLoadingCoverView;", "presenter", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationPresenter;", "disableLoadMore", "", "now", "dismissLoadingView", "finishLoadMore", "size", "", "getLayoutId", "getVisibleItemRange", "Lkotlin/Pair;", "initialLoadFailed", "isChattingClosed", "loadMoreFailed", "onBottomTabWidgetInstalled", "bottomMargin", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinish", "onNewIntent", "intent", "Landroid/content/Intent;", "onResume", "refreshGameCenterMsg", "showEmptyView", "show", "startChatting", "sessionId", "", "selfUsername", "talker", "Companion", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
public class GameLifeConversationUI
  extends GameLifeChattingCompatUI
  implements h.a
{
  public static final GameLifeConversationUI.a Jcu;
  private final j EKZ;
  private final b Jcv;
  private final e Jcw;
  private boolean Jcx;
  private GameLifeLoadingCoverView Jcy;
  private GameLifeEmptyCoverView Jcz;
  
  static
  {
    AppMethodBeat.i(267864);
    Jcu = new GameLifeConversationUI.a((byte)0);
    AppMethodBeat.o(267864);
  }
  
  public GameLifeConversationUI()
  {
    AppMethodBeat.i(267837);
    this.Jcv = new b();
    this.Jcw = new e((h.a)this, this.Jcv);
    this.EKZ = k.cm((kotlin.g.a.a)new d(this));
    this.Jcx = true;
    AppMethodBeat.o(267837);
  }
  
  private final LinearLayoutManager getLayoutManager()
  {
    AppMethodBeat.i(267840);
    LinearLayoutManager localLinearLayoutManager = (LinearLayoutManager)this.EKZ.getValue();
    AppMethodBeat.o(267840);
    return localLinearLayoutManager;
  }
  
  public final void XV(int paramInt)
  {
    AppMethodBeat.i(267890);
    Object localObject1 = ((TouchableLayout)findViewById(d.c.container)).getLayoutParams();
    if ((localObject1 instanceof FrameLayout.LayoutParams)) {}
    for (localObject1 = (FrameLayout.LayoutParams)localObject1;; localObject1 = null)
    {
      if (localObject1 != null) {
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = paramInt;
      }
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      localLayoutParams.topMargin = com.tencent.mm.cd.a.fromDPToPix((Context)this, 152);
      FrameLayout localFrameLayout = (FrameLayout)findViewById(d.c.IZB);
      Object localObject2 = this.Jcy;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("loadingCoverView");
        localObject1 = null;
      }
      localFrameLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localLayoutParams);
      localFrameLayout = (FrameLayout)findViewById(d.c.IZB);
      localObject2 = this.Jcz;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("emptyCoverView");
        localObject1 = null;
      }
      localFrameLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localLayoutParams);
      AppMethodBeat.o(267890);
      return;
    }
  }
  
  public final void XW(int paramInt)
  {
    AppMethodBeat.i(267962);
    ((RefreshLoadMoreLayout)findViewById(d.c.rl_layout)).aFW(paramInt);
    AppMethodBeat.o(267962);
  }
  
  public void _$_clearFindViewByIdCache() {}
  
  public final boolean aNU()
  {
    AppMethodBeat.i(267990);
    com.tencent.mm.chatting.a locala = fIx();
    if (locala == null)
    {
      AppMethodBeat.o(267990);
      return true;
    }
    boolean bool = locala.aNU();
    AppMethodBeat.o(267990);
    return bool;
  }
  
  public final void ax(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(267905);
    s.u(paramString1, "sessionId");
    s.u(paramString2, "selfUsername");
    s.u(paramString3, "talker");
    Intent localIntent = new Intent();
    localIntent.putExtra("Chat_Self", paramString2);
    localIntent.putExtra("Chat_User", paramString1);
    localIntent.putExtra("finish_direct", true);
    com.tencent.mm.br.c.g((Context)getContext(), ".ui.chatting.ChattingUI", localIntent);
    ((com.tencent.mm.plugin.gamelife.a.b)h.ax(com.tencent.mm.plugin.gamelife.a.b.class)).aHv(paramString3);
    ((com.tencent.mm.plugin.gamelife.a.b)h.ax(com.tencent.mm.plugin.gamelife.a.b.class)).aHv(paramString2);
    AppMethodBeat.o(267905);
  }
  
  public final void fIB()
  {
    AppMethodBeat.i(267955);
    d.uiThread((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(267955);
  }
  
  public final void fIC()
  {
    AppMethodBeat.i(267968);
    d.uiThread((kotlin.g.a.a)new e(this));
    AppMethodBeat.o(267968);
  }
  
  public final r<Integer, Integer> fID()
  {
    AppMethodBeat.i(267983);
    r localr = new r(Integer.valueOf(getLayoutManager().Ju()), Integer.valueOf(getLayoutManager().Jw()));
    Log.d("GameLife.ConversationUI", "range " + ((Number)localr.bsC).intValue() + " - " + ((Number)localr.bsD).intValue());
    AppMethodBeat.o(267983);
    return localr;
  }
  
  public final void faJ()
  {
    AppMethodBeat.i(267946);
    d.uiThread((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(267946);
  }
  
  public int getLayoutId()
  {
    return d.d.Jac;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(267874);
    super.onCreate(paramBundle);
    setMMTitle(d.f.Jaz);
    paramBundle = (RecyclerView)findViewById(d.c.IZC);
    paramBundle.setLayoutManager((RecyclerView.LayoutManager)getLayoutManager());
    paramBundle.setAdapter((RecyclerView.a)this.Jcv);
    paramBundle.setItemAnimator(null);
    ((RefreshLoadMoreLayout)findViewById(d.c.rl_layout)).setActionCallback((RefreshLoadMoreLayout.b)new f(this));
    paramBundle = new GameLifeLoadingCoverView((Context)this, null, 6, (byte)0);
    paramBundle.setOnClickListener((kotlin.g.a.a)new g(this));
    Object localObject1 = ah.aiuX;
    this.Jcy = paramBundle;
    paramBundle = new GameLifeEmptyCoverView((Context)this, null, 6, (byte)0);
    paramBundle.setVisibility(8);
    localObject1 = ah.aiuX;
    this.Jcz = paramBundle;
    paramBundle = com.tencent.mm.plugin.gamelife.j.a.JbN;
    com.tencent.mm.plugin.gamelife.j.a.rK(getIntent().getIntExtra("game_report_from_scene", 0));
    paramBundle = this.Jcw;
    localObject1 = paramBundle.Jcm;
    Object localObject2 = (b.c)paramBundle.Jcp;
    ((b)localObject1).JbX.Jcb = ((b.c)localObject2);
    ((b)localObject1).Jcb = ((b.c)localObject2);
    localObject1 = paramBundle.Jcm;
    localObject2 = (b.d)new c((kotlin.g.a.a)e.h.Jct);
    ((b)localObject1).JbX.Jcc = ((b.d)localObject2);
    ((b)localObject1).Jcc = ((b.d)localObject2);
    paramBundle.Jco.m(paramBundle.Jcq);
    ((com.tencent.mm.plugin.gamelife.a.b)h.ax(com.tencent.mm.plugin.gamelife.a.b.class)).m(paramBundle.Jcr);
    paramBundle.fIz();
    AppMethodBeat.o(267874);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(267923);
    super.onDestroy();
    e locale = this.Jcw;
    locale.Jcl = null;
    locale.Jco.l(locale.Jcq);
    ((com.tencent.mm.plugin.gamelife.a.b)h.ax(com.tencent.mm.plugin.gamelife.a.b.class)).l(locale.Jcr);
    AppMethodBeat.o(267923);
  }
  
  public void onFinish() {}
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(267881);
    super.onNewIntent(paramIntent);
    if (paramIntent != null)
    {
      com.tencent.mm.plugin.gamelife.j.a locala = com.tencent.mm.plugin.gamelife.j.a.JbN;
      com.tencent.mm.plugin.gamelife.j.a.rK(paramIntent.getIntExtra("game_report_from_scene", 0));
    }
    AppMethodBeat.o(267881);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(267913);
    super.onResume();
    this.Jcw.onResume();
    AppMethodBeat.o(267913);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void po(final boolean paramBoolean)
  {
    AppMethodBeat.i(267937);
    d.uiThread((kotlin.g.a.a)new h(this, paramBoolean));
    AppMethodBeat.o(267937);
  }
  
  public final void wB(boolean paramBoolean)
  {
    AppMethodBeat.i(267972);
    this.Jcx = false;
    if (paramBoolean) {
      ((RefreshLoadMoreLayout)findViewById(d.c.rl_layout)).setEnableLoadMore(false);
    }
    AppMethodBeat.o(267972);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(GameLifeConversationUI paramGameLifeConversationUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(GameLifeConversationUI paramGameLifeConversationUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/recyclerview/widget/LinearLayoutManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<LinearLayoutManager>
  {
    d(GameLifeConversationUI paramGameLifeConversationUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(GameLifeConversationUI paramGameLifeConversationUI)
    {
      super();
    }
    
    private static final void a(GameLifeConversationUI paramGameLifeConversationUI, View paramView)
    {
      AppMethodBeat.i(267876);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramGameLifeConversationUI);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$loadMoreFailed$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramGameLifeConversationUI, "this$0");
      GameLifeConversationUI.a(paramGameLifeConversationUI).onLoadMore();
      paramView.setVisibility(8);
      paramGameLifeConversationUI = ((RefreshLoadMoreLayout)paramGameLifeConversationUI.findViewById(d.c.rl_layout)).getLoadMoreFooter();
      if (paramGameLifeConversationUI == null) {}
      for (paramGameLifeConversationUI = null;; paramGameLifeConversationUI = paramGameLifeConversationUI.findViewById(d.c.loading))
      {
        if (paramGameLifeConversationUI != null) {
          paramGameLifeConversationUI.setVisibility(0);
        }
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$loadMoreFailed$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(267876);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$onCreate$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback2;", "onLoadMoreBegin", "", "loadMoreType", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    extends RefreshLoadMoreLayout.b
  {
    f(GameLifeConversationUI paramGameLifeConversationUI) {}
    
    public final void a(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(267880);
      s.u(paramd, "reason");
      ((RefreshLoadMoreLayout)this.JcA.findViewById(d.c.rl_layout)).setEnableLoadMore(GameLifeConversationUI.b(this.JcA));
      AppMethodBeat.o(267880);
    }
    
    public final void qI(int paramInt)
    {
      AppMethodBeat.i(267871);
      GameLifeConversationUI.a(this.JcA).onLoadMore();
      AppMethodBeat.o(267871);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ah>
  {
    g(GameLifeConversationUI paramGameLifeConversationUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<ah>
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