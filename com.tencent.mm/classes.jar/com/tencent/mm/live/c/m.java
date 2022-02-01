package com.tencent.mm.live.c;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.h.c.a;
import android.support.v7.h.c.b;
import android.support.v7.h.d;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.e.c;
import com.tencent.mm.live.b.f;
import com.tencent.mm.protocal.protobuf.eas;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.ap;
import d.g.b.k;
import d.g.b.z;
import d.k.h;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/plugin/LiveCommentPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "BAN_COMMENT_TIP_TIMEOUT", "", "BAN_COMMENT_TIP_TIMEOUT$1", "banCommentCallback", "Lkotlin/Function1;", "", "", "commentAdapter", "Lcom/tencent/mm/live/view/adapter/LiveCommentAdapter;", "commentListView", "Landroid/support/v7/widget/RecyclerView;", "enable", "", "isAnchor", "linkMicCallback", "Lkotlin/Function2;", "newTipGroup", "newTipTv", "Landroid/widget/TextView;", "readCount", "", "hideNewCommentTip", "keyboardChange", "show", "height", "onMsgPosted", "setVisible", "visible", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "showNewCommentTip", "count", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "updateComments", "newDatas", "", "Lcom/tencent/mm/live/view/adapter/CommentData;", "updateMessages", "Companion", "plugin-logic_release"})
public final class m
  extends a
{
  public static final a KuB;
  private final b IIz;
  private final d.g.a.m<Boolean, String, y> KuA;
  private final ViewGroup Kuu;
  private final TextView Kuv;
  private final RecyclerView Kuw;
  private final com.tencent.mm.live.view.a.c Kux;
  private final long Kuy;
  private final d.g.a.b<String, y> Kuz;
  private boolean aWl;
  private boolean enable;
  private int readCount;
  
  static
  {
    AppMethodBeat.i(202895);
    KuB = new a((byte)0);
    AppMethodBeat.o(202895);
  }
  
  public m(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(202894);
    this.IIz = paramb;
    paramb = paramViewGroup.findViewById(2131307523);
    k.g(paramb, "root.findViewById(R.id.l…e_comment_list_tip_group)");
    this.Kuu = ((ViewGroup)paramb);
    paramb = paramViewGroup.findViewById(2131307524);
    k.g(paramb, "root.findViewById(R.id.live_comment_list_tip_tv)");
    this.Kuv = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(2131307522);
    k.g(paramb, "root.findViewById(R.id.live_comment_list)");
    this.Kuw = ((RecyclerView)paramb);
    this.Kux = new com.tencent.mm.live.view.a.c();
    this.Kuy = 3000L;
    this.Kuz = ((d.g.a.b)new b(this));
    this.KuA = ((d.g.a.m)new c(this));
    paramb = this.Kuw;
    paramViewGroup.getContext();
    paramb.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    this.Kuw.setAdapter((RecyclerView.a)this.Kux);
    paramb = com.tencent.mm.live.b.c.qYi;
    com.tencent.mm.live.b.c.E(this.Kuz);
    paramb = com.tencent.mm.live.b.c.qYi;
    com.tencent.mm.live.b.c.g(this.KuA);
    this.Kuu.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(202869);
        m.c(this.KuC);
        paramAnonymousView = m.a(this.KuC);
        Object localObject = f.rGw;
        localObject = com.tencent.mm.hellhoundlib.b.c.a(f.eNE().size() - 1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/live/plugin/LiveCommentPlugin$1", "onClick", "(Landroid/view/View;)V", "Undefined", "smoothScrollToPosition", "(I)V");
        paramAnonymousView.smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/live/plugin/LiveCommentPlugin$1", "onClick", "(Landroid/view/View;)V", "Undefined", "smoothScrollToPosition", "(I)V");
        AppMethodBeat.o(202869);
      }
    });
    this.Kuw.a((RecyclerView.m)new RecyclerView.m()
    {
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(202870);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.be(paramAnonymousRecyclerView);
        localb.lT(paramAnonymousInt1);
        localb.lT(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveCommentPlugin$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ado());
        k.h(paramAnonymousRecyclerView, "recyclerView");
        paramAnonymousRecyclerView = m.a(this.KuC).getLayoutManager();
        if (paramAnonymousRecyclerView == null)
        {
          paramAnonymousRecyclerView = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
          AppMethodBeat.o(202870);
          throw paramAnonymousRecyclerView;
        }
        paramAnonymousInt1 = ((LinearLayoutManager)paramAnonymousRecyclerView).jQ();
        paramAnonymousRecyclerView = this.KuC;
        m.a(paramAnonymousRecyclerView, h.kK(paramAnonymousInt1, m.e(paramAnonymousRecyclerView)));
        if (paramAnonymousInt1 == m.b(this.KuC).getItemCount() - 1) {}
        for (paramAnonymousInt1 = 1;; paramAnonymousInt1 = 0)
        {
          if (paramAnonymousInt1 != 0) {
            m.c(this.KuC);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveCommentPlugin$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(202870);
          return;
        }
      }
      
      public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(202871);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.be(paramAnonymousRecyclerView);
        localb.lT(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveCommentPlugin$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ado());
        super.b(paramAnonymousRecyclerView, paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveCommentPlugin$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(202871);
      }
    });
    if (paramViewGroup.findViewById(2131298772) != null)
    {
      paramb = new RelativeLayout.LayoutParams(-2, -2);
      paramb.bottomMargin = ap.eb(paramViewGroup.getContext());
      paramViewGroup = paramViewGroup.findViewById(2131298772);
      k.g(paramViewGroup, "root.findViewById<Relati…>(R.id.content_root_view)");
      ((RelativeLayout)paramViewGroup).setLayoutParams((ViewGroup.LayoutParams)paramb);
    }
    AppMethodBeat.o(202894);
  }
  
  private final void fOT()
  {
    AppMethodBeat.i(202888);
    this.Kuu.setVisibility(8);
    AppMethodBeat.o(202888);
  }
  
  public final void X(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(202891);
    if (paramBoolean)
    {
      this.Kuw.setVisibility(4);
      AppMethodBeat.o(202891);
      return;
    }
    if (this.enable) {
      this.Kuw.setVisibility(0);
    }
    AppMethodBeat.o(202891);
  }
  
  public final void a(LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(202889);
    k.h(paramLiveConfig, "config");
    if (paramLiveConfig.ckz() == LiveConfig.qsH) {}
    for (boolean bool = true;; bool = false)
    {
      this.aWl = bool;
      AppMethodBeat.o(202889);
      return;
    }
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(202893);
    k.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (n.ciE[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(202893);
      return;
      agK(8);
      this.enable = false;
      AppMethodBeat.o(202893);
      return;
      paramc = f.rGw;
      f.agC(f.fOq() + 1);
      fOT();
      paramc = this.Kuw;
      paramBundle = f.rGw;
      paramBundle = com.tencent.mm.hellhoundlib.b.c.a(f.eNE().size() - 1, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(paramc, paramBundle.adn(), "com/tencent/mm/live/plugin/LiveCommentPlugin", "onMsgPosted", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      paramc.smoothScrollToPosition(((Integer)paramBundle.lS(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(paramc, "com/tencent/mm/live/plugin/LiveCommentPlugin", "onMsgPosted", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      AppMethodBeat.o(202893);
      return;
      agK(0);
      this.enable = true;
    }
  }
  
  public final void agK(int paramInt)
  {
    AppMethodBeat.i(202892);
    super.agK(paramInt);
    this.Kuw.setVisibility(0);
    AppMethodBeat.o(202892);
  }
  
  public final void fOU()
  {
    AppMethodBeat.i(202890);
    if (this.pTc.getVisibility() == 0)
    {
      Object localObject1 = f.rGw;
      localObject1 = (Collection)f.eNE();
      int i;
      if ((localObject1 == null) || (((Collection)localObject1).isEmpty())) {
        i = 1;
      }
      while (i == 0)
      {
        localObject1 = new StringBuilder("liveMessageCallback msgListCount:");
        Object localObject2 = f.rGw;
        localObject1 = ((StringBuilder)localObject1).append(f.eNE().size()).append(" readCount:").append(this.readCount).append(" enable_comment:");
        localObject2 = f.rGw;
        localObject1 = ((StringBuilder)localObject1).append(f.eNG().LwF).append(" msgFilterTime:");
        localObject2 = f.rGw;
        ad.i("MicroMsg.LiveCommentPlugin", f.eNJ());
        localObject1 = this.Kuw.getLayoutManager();
        if (localObject1 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
          AppMethodBeat.o(202890);
          throw ((Throwable)localObject1);
          i = 0;
        }
        else
        {
          int k;
          if (((LinearLayoutManager)localObject1).jQ() == this.Kux.getItemCount() - 1)
          {
            i = 1;
            localObject1 = f.rGw;
            k = f.eNE().size() - this.readCount - 1;
            localObject1 = f.rGw;
            if (!f.eNG().LwF) {
              break label343;
            }
            localObject1 = f.rGw;
          }
          for (localObject1 = (List)f.eNE();; localObject1 = (List)localObject1)
          {
            localObject2 = android.support.v7.h.c.a((c.a)new e(this, (List)localObject1), false);
            k.g(localObject2, "DiffUtil.calculateDiff(o…      }\n        }, false)");
            ((c.b)localObject2).a((d)new d(this, (List)localObject1));
            if (this.Kux.getItemCount() <= 0) {
              break label574;
            }
            if (i == 0) {
              break label473;
            }
            this.Kuw.post((Runnable)new f(this));
            AppMethodBeat.o(202890);
            return;
            i = 0;
            break;
            label343:
            localObject1 = f.rGw;
            localObject2 = (Iterable)f.eNE();
            localObject1 = (Collection)new ArrayList();
            localObject2 = ((Iterable)localObject2).iterator();
            label461:
            while (((Iterator)localObject2).hasNext())
            {
              Object localObject3 = ((Iterator)localObject2).next();
              Object localObject4 = (com.tencent.mm.live.view.a.a)localObject3;
              int j = ((com.tencent.mm.live.view.a.a)localObject4).msgType;
              e.c localc = e.c.qYs;
              if (j == e.c.emb())
              {
                j = ((com.tencent.mm.live.view.a.a)localObject4).tGD;
                localObject4 = f.rGw;
                if (j < f.eNJ()) {}
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
            this.Kuu.setVisibility(0);
            localObject1 = this.Kuv;
            localObject2 = z.Jhz;
            localObject2 = this.pTc.getContext();
            k.g(localObject2, "root.context");
            localObject2 = ((Context)localObject2).getResources().getString(2131766615);
            k.g(localObject2, "root.context.resources.g…ing.live_new_comment_tip)");
            localObject2 = String.format((String)localObject2, Arrays.copyOf(new Object[] { Integer.valueOf(k) }, 1));
            k.g(localObject2, "java.lang.String.format(format, *args)");
            ((TextView)localObject1).setText((CharSequence)localObject2);
          }
        }
      }
    }
    label574:
    AppMethodBeat.o(202890);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/plugin/LiveCommentPlugin$Companion;", "", "()V", "BAN_COMMENT_TIP_TIMEOUT", "", "TAG", "", "plugin-logic_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "wording", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.b<String, y>
  {
    b(m paramm)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "linked", "", "callingUser", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.m<Boolean, String, y>
  {
    c(m paramm)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/live/plugin/LiveCommentPlugin$updateComments$1", "Landroid/support/v7/util/ListUpdateCallback;", "onChanged", "", "position", "", "count", "payload", "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "plugin-logic_release"})
  public static final class d
    implements d
  {
    d(List paramList) {}
    
    public final void E(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(202881);
      ad.d("MicroMsg.LiveCommentPlugin", "onInserted position:" + paramInt1 + ", count:" + paramInt2);
      m.b(this.KuC).BvI.clear();
      m.b(this.KuC).BvI.addAll((Collection)this.KuH);
      m.b(this.KuC).aq(paramInt1, paramInt2);
      AppMethodBeat.o(202881);
    }
    
    public final void F(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(202882);
      ad.d("MicroMsg.LiveCommentPlugin", "onRemoved position:" + paramInt1 + ", count:" + paramInt2);
      m.b(this.KuC).BvI.clear();
      m.b(this.KuC).BvI.addAll((Collection)this.KuH);
      m.b(this.KuC).ar(paramInt1, paramInt2);
      AppMethodBeat.o(202882);
    }
    
    public final void G(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(202880);
      ad.d("MicroMsg.LiveCommentPlugin", "onMoved fromPosition:" + paramInt1 + ", toPosition:" + paramInt2);
      m.b(this.KuC).ap(paramInt1, paramInt2);
      AppMethodBeat.o(202880);
    }
    
    public final void c(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(202879);
      ad.d("MicroMsg.LiveCommentPlugin", "onChanged position:" + paramInt1 + ", count:" + paramInt2);
      m.b(this.KuC).BvI.clear();
      m.b(this.KuC).BvI.addAll((Collection)this.KuH);
      m.b(this.KuC).ao(paramInt1, paramInt2);
      AppMethodBeat.o(202879);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/live/plugin/LiveCommentPlugin$updateComments$result$1", "Landroid/support/v7/util/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-logic_release"})
  public static final class e
    extends c.a
  {
    e(List paramList) {}
    
    public final boolean H(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(202885);
      boolean bool = k.g((com.tencent.mm.live.view.a.a)m.b(this.KuC).BvI.get(paramInt1), (com.tencent.mm.live.view.a.a)this.KuH.get(paramInt2));
      AppMethodBeat.o(202885);
      return bool;
    }
    
    public final boolean I(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(202886);
      boolean bool = k.g((com.tencent.mm.live.view.a.a)m.b(this.KuC).BvI.get(paramInt1), (com.tencent.mm.live.view.a.a)this.KuH.get(paramInt2));
      AppMethodBeat.o(202886);
      return bool;
    }
    
    public final int gR()
    {
      AppMethodBeat.i(202883);
      int i = m.b(this.KuC).BvI.size();
      AppMethodBeat.o(202883);
      return i;
    }
    
    public final int gS()
    {
      AppMethodBeat.i(202884);
      int i = this.KuH.size();
      AppMethodBeat.o(202884);
      return i;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(m paramm) {}
    
    public final void run()
    {
      AppMethodBeat.i(202887);
      RecyclerView localRecyclerView = m.a(this.KuC);
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(h.kK(m.b(this.KuC).getItemCount() - 1, 0), new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.adn(), "com/tencent/mm/live/plugin/LiveCommentPlugin$updateMessages$1", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      localRecyclerView.smoothScrollToPosition(((Integer)locala.lS(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/live/plugin/LiveCommentPlugin$updateMessages$1", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      AppMethodBeat.o(202887);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.c.m
 * JD-Core Version:    0.7.0.1
 */