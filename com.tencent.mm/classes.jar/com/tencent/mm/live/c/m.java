package com.tencent.mm.live.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.h.c.a;
import android.support.v7.h.c.b;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.l;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.a.s;
import com.tencent.mm.live.b.o.d;
import com.tencent.mm.protocal.protobuf.civ;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.au;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/plugin/LiveCommentPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "BAN_COMMENT_TIP_TIMEOUT", "", "BAN_COMMENT_TIP_TIMEOUT$1", "banCommentCallback", "Lkotlin/Function1;", "", "", "commentAdapter", "Lcom/tencent/mm/live/view/adapter/LiveCommentAdapter;", "commentListView", "Landroid/support/v7/widget/RecyclerView;", "enable", "", "isAnchor", "linkMicCallback", "Lkotlin/Function2;", "newTipGroup", "newTipTv", "Landroid/widget/TextView;", "readCount", "", "hideNewCommentTip", "keyboardChange", "show", "height", "mount", "onMsgPosted", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setVisible", "visible", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "showNewCommentTip", "count", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "updateComments", "newDatas", "", "Lcom/tencent/mm/live/view/adapter/CommentData;", "updateMessages", "Companion", "plugin-logic_release"})
public final class m
  extends a
  implements i
{
  public static final a hPx;
  private boolean dMz;
  private boolean enable;
  private final b hOy;
  private final ViewGroup hPq;
  private final TextView hPr;
  private final RecyclerView hPs;
  private final com.tencent.mm.live.view.a.c hPt;
  private final long hPu;
  private final kotlin.g.a.b<String, kotlin.x> hPv;
  private final kotlin.g.a.m<Boolean, String, kotlin.x> hPw;
  private int readCount;
  
  static
  {
    AppMethodBeat.i(207978);
    hPx = new a((byte)0);
    AppMethodBeat.o(207978);
  }
  
  public m(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(207977);
    this.hOy = paramb;
    paramb = paramViewGroup.findViewById(2131303366);
    p.g(paramb, "root.findViewById(R.id.l…e_comment_list_tip_group)");
    this.hPq = ((ViewGroup)paramb);
    paramb = paramViewGroup.findViewById(2131303367);
    p.g(paramb, "root.findViewById(R.id.live_comment_list_tip_tv)");
    this.hPr = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(2131303365);
    p.g(paramb, "root.findViewById(R.id.live_comment_list)");
    this.hPs = ((RecyclerView)paramb);
    this.hPt = new com.tencent.mm.live.view.a.c();
    this.hPu = 3000L;
    this.hPv = ((kotlin.g.a.b)new b(this));
    this.hPw = ((kotlin.g.a.m)new c(this));
    paramb = this.hPs;
    paramViewGroup.getContext();
    paramb.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    this.hPs.setAdapter((RecyclerView.a)this.hPt);
    paramb = com.tencent.mm.live.b.m.hGg;
    com.tencent.mm.live.b.m.a(name(), this.hPv);
    paramb = com.tencent.mm.live.b.m.hGg;
    com.tencent.mm.live.b.m.a(name(), this.hPw);
    this.hPq.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(207948);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveCommentPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        m.c(this.hPy);
        paramAnonymousView = m.a(this.hPy);
        localObject = com.tencent.mm.live.b.x.hJf;
        localObject = com.tencent.mm.hellhoundlib.b.c.a(com.tencent.mm.live.b.x.aGp().size() - 1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/live/plugin/LiveCommentPlugin$1", "onClick", "(Landroid/view/View;)V", "Undefined", "smoothScrollToPosition", "(I)V");
        paramAnonymousView.smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/live/plugin/LiveCommentPlugin$1", "onClick", "(Landroid/view/View;)V", "Undefined", "smoothScrollToPosition", "(I)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveCommentPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(207948);
      }
    });
    this.hPs.a((RecyclerView.l)new RecyclerView.l()
    {
      public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(207950);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousRecyclerView);
        localb.pH(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveCommentPlugin$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
        super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveCommentPlugin$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(207950);
      }
      
      public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(207949);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousRecyclerView);
        localb.pH(paramAnonymousInt1);
        localb.pH(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveCommentPlugin$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
        p.h(paramAnonymousRecyclerView, "recyclerView");
        paramAnonymousRecyclerView = m.a(this.hPy).getLayoutManager();
        if (paramAnonymousRecyclerView == null)
        {
          paramAnonymousRecyclerView = new kotlin.t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
          AppMethodBeat.o(207949);
          throw paramAnonymousRecyclerView;
        }
        paramAnonymousInt1 = ((LinearLayoutManager)paramAnonymousRecyclerView).ku();
        paramAnonymousRecyclerView = this.hPy;
        m.a(paramAnonymousRecyclerView, kotlin.k.j.mZ(paramAnonymousInt1, m.e(paramAnonymousRecyclerView)));
        if (paramAnonymousInt1 == m.b(this.hPy).getItemCount() - 1) {}
        for (paramAnonymousInt1 = 1;; paramAnonymousInt1 = 0)
        {
          if (paramAnonymousInt1 != 0) {
            m.c(this.hPy);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveCommentPlugin$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(207949);
          return;
        }
      }
    });
    if (isLandscape())
    {
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(207977);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).width = (au.az(paramViewGroup.getContext()).x * 35 / 100);
    }
    AppMethodBeat.o(207977);
  }
  
  private final void aHw()
  {
    AppMethodBeat.i(207969);
    this.hPq.setVisibility(8);
    AppMethodBeat.o(207969);
  }
  
  public final void a(LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(207970);
    p.h(paramLiveConfig, "config");
    if (paramLiveConfig.aBC() == LiveConfig.hvT) {}
    for (boolean bool = true;; bool = false)
    {
      this.dMz = bool;
      AppMethodBeat.o(207970);
      return;
    }
  }
  
  public final void aHx()
  {
    AppMethodBeat.i(207971);
    if (this.hwr.getVisibility() == 0)
    {
      Object localObject1 = com.tencent.mm.live.b.x.hJf;
      localObject1 = (Collection)com.tencent.mm.live.b.x.aGp();
      int i;
      if ((localObject1 == null) || (((Collection)localObject1).isEmpty())) {
        i = 1;
      }
      while (i == 0)
      {
        localObject1 = new StringBuilder("liveMessageCallback msgListCount:");
        Object localObject2 = com.tencent.mm.live.b.x.hJf;
        localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.live.b.x.aGp().size()).append(" readCount:").append(this.readCount).append(" enable_comment:");
        localObject2 = com.tencent.mm.live.b.x.hJf;
        localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.live.b.x.aGr().KNv).append(" msgFilterTime:");
        localObject2 = com.tencent.mm.live.b.x.hJf;
        Log.i("MicroMsg.LiveCommentPlugin", com.tencent.mm.live.b.x.aGu());
        localObject1 = this.hPs.getLayoutManager();
        if (localObject1 == null)
        {
          localObject1 = new kotlin.t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
          AppMethodBeat.o(207971);
          throw ((Throwable)localObject1);
          i = 0;
        }
        else
        {
          int k;
          if (((LinearLayoutManager)localObject1).ku() == this.hPt.getItemCount() - 1)
          {
            i = 1;
            localObject1 = com.tencent.mm.live.b.x.hJf;
            k = com.tencent.mm.live.b.x.aGp().size() - this.readCount - 1;
            localObject1 = com.tencent.mm.live.b.x.hJf;
            if (!com.tencent.mm.live.b.x.aGr().KNv) {
              break label343;
            }
            localObject1 = com.tencent.mm.live.b.x.hJf;
          }
          for (localObject1 = (List)com.tencent.mm.live.b.x.aGp();; localObject1 = (List)localObject1)
          {
            localObject2 = android.support.v7.h.c.a((c.a)new g(this, (List)localObject1), false);
            p.g(localObject2, "DiffUtil.calculateDiff(o…      }\n        }, false)");
            ((c.b)localObject2).a((android.support.v7.h.d)new f(this, (List)localObject1));
            if (this.hPt.getItemCount() <= 0) {
              break label574;
            }
            if (i == 0) {
              break label473;
            }
            this.hPs.post((Runnable)new h(this));
            AppMethodBeat.o(207971);
            return;
            i = 0;
            break;
            label343:
            localObject1 = com.tencent.mm.live.b.x.hJf;
            localObject2 = (Iterable)com.tencent.mm.live.b.x.aGp();
            localObject1 = (Collection)new ArrayList();
            localObject2 = ((Iterable)localObject2).iterator();
            label461:
            while (((Iterator)localObject2).hasNext())
            {
              Object localObject3 = ((Iterator)localObject2).next();
              Object localObject4 = (com.tencent.mm.live.view.a.a)localObject3;
              int j = ((com.tencent.mm.live.view.a.a)localObject4).msgType;
              o.d locald = o.d.hGL;
              if (j == o.d.aFz())
              {
                j = ((com.tencent.mm.live.view.a.a)localObject4).hXs;
                localObject4 = com.tencent.mm.live.b.x.hJf;
                if (j < com.tencent.mm.live.b.x.aGu()) {}
              }
              for (j = 1;; j = 0)
              {
                if (j == 0) {
                  break label461;
                }
                ((Collection)localObject1).add(localObject3);
                break;
              }
            }
          }
          label473:
          if (k > 0)
          {
            this.hPq.setVisibility(0);
            localObject1 = this.hPr;
            localObject2 = ae.SYK;
            localObject2 = this.hwr.getContext();
            p.g(localObject2, "root.context");
            localObject2 = ((Context)localObject2).getResources().getString(2131762343);
            p.g(localObject2, "root.context.resources.g…ing.live_new_comment_tip)");
            localObject2 = String.format((String)localObject2, Arrays.copyOf(new Object[] { Integer.valueOf(k) }, 1));
            p.g(localObject2, "java.lang.String.format(format, *args)");
            ((TextView)localObject1).setText((CharSequence)localObject2);
          }
        }
      }
    }
    label574:
    AppMethodBeat.o(207971);
  }
  
  public final void keyboardChange(boolean paramBoolean, int paramInt) {}
  
  public final void mount()
  {
    AppMethodBeat.i(207974);
    super.mount();
    com.tencent.mm.kernel.b localb = g.aAg();
    p.g(localb, "MMKernel.network()");
    localb.azz().a(904, (i)this);
    AppMethodBeat.o(207974);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(207976);
    if (((paramq instanceof s)) && (paramInt1 == 4) && (paramInt2 == -100048))
    {
      paramString = com.tencent.mm.live.b.x.hJf;
      kotlin.a.j.c((List)com.tencent.mm.live.b.x.aGp(), (kotlin.g.a.b)new d(paramq));
      com.tencent.mm.ac.d.h((kotlin.g.a.a)new e(this));
    }
    AppMethodBeat.o(207976);
  }
  
  public final void rg(int paramInt)
  {
    AppMethodBeat.i(207972);
    super.rg(paramInt);
    this.hPs.setVisibility(0);
    AppMethodBeat.o(207972);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(207973);
    p.h(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (n.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(207973);
      return;
      rg(8);
      this.enable = false;
      AppMethodBeat.o(207973);
      return;
      paramc = com.tencent.mm.live.b.x.hJf;
      com.tencent.mm.live.b.x.qY(com.tencent.mm.live.b.x.aGQ() + 1);
      aHw();
      paramc = this.hPs;
      paramBundle = com.tencent.mm.live.b.x.hJf;
      paramBundle = com.tencent.mm.hellhoundlib.b.c.a(com.tencent.mm.live.b.x.aGp().size() - 1, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(paramc, paramBundle.axQ(), "com/tencent/mm/live/plugin/LiveCommentPlugin", "onMsgPosted", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      paramc.smoothScrollToPosition(((Integer)paramBundle.pG(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(paramc, "com/tencent/mm/live/plugin/LiveCommentPlugin", "onMsgPosted", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      AppMethodBeat.o(207973);
      return;
      rg(0);
      this.enable = true;
    }
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(207975);
    super.unMount();
    com.tencent.mm.kernel.b localb = g.aAg();
    p.g(localb, "MMKernel.network()");
    localb.azz().b(904, (i)this);
    AppMethodBeat.o(207975);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/plugin/LiveCommentPlugin$Companion;", "", "()V", "BAN_COMMENT_TIP_TIMEOUT", "", "TAG", "", "plugin-logic_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "wording", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, kotlin.x>
  {
    b(m paramm)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "linked", "", "callingUser", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.m<Boolean, String, kotlin.x>
  {
    c(m paramm)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/live/view/adapter/CommentData;", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.b<com.tencent.mm.live.view.a.a, Boolean>
  {
    d(com.tencent.mm.ak.q paramq)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<kotlin.x>
  {
    e(m paramm)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/live/plugin/LiveCommentPlugin$updateComments$1", "Landroid/support/v7/util/ListUpdateCallback;", "onChanged", "", "position", "", "count", "payload", "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "plugin-logic_release"})
  public static final class f
    implements android.support.v7.h.d
  {
    f(List paramList) {}
    
    public final void c(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(207960);
      Log.d("MicroMsg.LiveCommentPlugin", "onChanged position:" + paramInt1 + ", count:" + paramInt2);
      m.b(this.hPy).hXy.clear();
      m.b(this.hPy).hXy.addAll((Collection)this.hPD);
      m.b(this.hPy).aq(paramInt1, paramInt2);
      AppMethodBeat.o(207960);
    }
    
    public final void f(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(207962);
      Log.d("MicroMsg.LiveCommentPlugin", "onInserted position:" + paramInt1 + ", count:" + paramInt2);
      m.b(this.hPy).hXy.clear();
      m.b(this.hPy).hXy.addAll((Collection)this.hPD);
      m.b(this.hPy).as(paramInt1, paramInt2);
      AppMethodBeat.o(207962);
    }
    
    public final void k(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(207963);
      Log.d("MicroMsg.LiveCommentPlugin", "onRemoved position:" + paramInt1 + ", count:" + paramInt2);
      m.b(this.hPy).hXy.clear();
      m.b(this.hPy).hXy.addAll((Collection)this.hPD);
      m.b(this.hPy).at(paramInt1, paramInt2);
      AppMethodBeat.o(207963);
    }
    
    public final void l(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(207961);
      Log.d("MicroMsg.LiveCommentPlugin", "onMoved fromPosition:" + paramInt1 + ", toPosition:" + paramInt2);
      m.b(this.hPy).ar(paramInt1, paramInt2);
      AppMethodBeat.o(207961);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/live/plugin/LiveCommentPlugin$updateComments$result$1", "Landroid/support/v7/util/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-logic_release"})
  public static final class g
    extends c.a
  {
    g(List paramList) {}
    
    public final int aB()
    {
      AppMethodBeat.i(207964);
      int i = m.b(this.hPy).hXy.size();
      AppMethodBeat.o(207964);
      return i;
    }
    
    public final int aC()
    {
      AppMethodBeat.i(207965);
      int i = this.hPD.size();
      AppMethodBeat.o(207965);
      return i;
    }
    
    public final boolean i(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(207966);
      boolean bool = p.j((com.tencent.mm.live.view.a.a)m.b(this.hPy).hXy.get(paramInt1), (com.tencent.mm.live.view.a.a)this.hPD.get(paramInt2));
      AppMethodBeat.o(207966);
      return bool;
    }
    
    public final boolean j(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(207967);
      boolean bool = p.j((com.tencent.mm.live.view.a.a)m.b(this.hPy).hXy.get(paramInt1), (com.tencent.mm.live.view.a.a)this.hPD.get(paramInt2));
      AppMethodBeat.o(207967);
      return bool;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(m paramm) {}
    
    public final void run()
    {
      AppMethodBeat.i(207968);
      RecyclerView localRecyclerView = m.a(this.hPy);
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(kotlin.k.j.mZ(m.b(this.hPy).getItemCount() - 1, 0), new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.axQ(), "com/tencent/mm/live/plugin/LiveCommentPlugin$updateMessages$1", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      localRecyclerView.smoothScrollToPosition(((Integer)locala.pG(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/live/plugin/LiveCommentPlugin$updateMessages$1", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      AppMethodBeat.o(207968);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.c.m
 * JD-Core Version:    0.7.0.1
 */