package com.tencent.mm.live.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
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
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.a.s;
import com.tencent.mm.live.b.f.c;
import com.tencent.mm.protocal.protobuf.bqd;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.ap;
import d.a.j;
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

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/plugin/LiveCommentPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "BAN_COMMENT_TIP_TIMEOUT", "", "BAN_COMMENT_TIP_TIMEOUT$1", "banCommentCallback", "Lkotlin/Function1;", "", "", "commentAdapter", "Lcom/tencent/mm/live/view/adapter/LiveCommentAdapter;", "commentListView", "Landroid/support/v7/widget/RecyclerView;", "enable", "", "isAnchor", "linkMicCallback", "Lkotlin/Function2;", "newTipGroup", "newTipTv", "Landroid/widget/TextView;", "readCount", "", "hideNewCommentTip", "keyboardChange", "show", "height", "mount", "onMsgPosted", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setVisible", "visible", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "showNewCommentTip", "count", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "updateComments", "newDatas", "", "Lcom/tencent/mm/live/view/adapter/CommentData;", "updateMessages", "Companion", "plugin-logic_release"})
public final class m
  extends a
  implements com.tencent.mm.ak.g
{
  public static final m.a gAi;
  private boolean dmG;
  private boolean enable;
  private final ViewGroup gAb;
  private final TextView gAc;
  private final RecyclerView gAd;
  private final com.tencent.mm.live.view.a.c gAe;
  private final long gAf;
  private final d.g.a.b<String, y> gAg;
  private final d.g.a.m<Boolean, String, y> gAh;
  private final b gzk;
  private int readCount;
  
  static
  {
    AppMethodBeat.i(190108);
    gAi = new m.a((byte)0);
    AppMethodBeat.o(190108);
  }
  
  public m(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(190107);
    this.gzk = paramb;
    paramb = paramViewGroup.findViewById(2131307604);
    k.g(paramb, "root.findViewById(R.id.l…e_comment_list_tip_group)");
    this.gAb = ((ViewGroup)paramb);
    paramb = paramViewGroup.findViewById(2131307605);
    k.g(paramb, "root.findViewById(R.id.live_comment_list_tip_tv)");
    this.gAc = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(2131307603);
    k.g(paramb, "root.findViewById(R.id.live_comment_list)");
    this.gAd = ((RecyclerView)paramb);
    this.gAe = new com.tencent.mm.live.view.a.c();
    this.gAf = 3000L;
    this.gAg = ((d.g.a.b)new b(this));
    this.gAh = ((d.g.a.m)new c(this));
    paramb = this.gAd;
    paramViewGroup.getContext();
    paramb.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    this.gAd.setAdapter((RecyclerView.a)this.gAe);
    paramb = com.tencent.mm.live.b.c.gtd;
    com.tencent.mm.live.b.c.a(name(), this.gAg);
    paramb = com.tencent.mm.live.b.c.gtd;
    com.tencent.mm.live.b.c.a(name(), this.gAh);
    this.gAb.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(190078);
        m.c(this.gAj);
        paramAnonymousView = m.a(this.gAj);
        Object localObject = com.tencent.mm.live.b.g.guG;
        localObject = com.tencent.mm.hellhoundlib.b.c.a(com.tencent.mm.live.b.g.akD().size() - 1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/live/plugin/LiveCommentPlugin$1", "onClick", "(Landroid/view/View;)V", "Undefined", "smoothScrollToPosition", "(I)V");
        paramAnonymousView.smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/live/plugin/LiveCommentPlugin$1", "onClick", "(Landroid/view/View;)V", "Undefined", "smoothScrollToPosition", "(I)V");
        AppMethodBeat.o(190078);
      }
    });
    this.gAd.a((RecyclerView.m)new RecyclerView.m()
    {
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(190079);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bb(paramAnonymousRecyclerView);
        localb.lS(paramAnonymousInt1);
        localb.lS(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveCommentPlugin$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.aeE());
        k.h(paramAnonymousRecyclerView, "recyclerView");
        paramAnonymousRecyclerView = m.a(this.gAj).getLayoutManager();
        if (paramAnonymousRecyclerView == null)
        {
          paramAnonymousRecyclerView = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
          AppMethodBeat.o(190079);
          throw paramAnonymousRecyclerView;
        }
        paramAnonymousInt1 = ((LinearLayoutManager)paramAnonymousRecyclerView).jY();
        paramAnonymousRecyclerView = this.gAj;
        m.a(paramAnonymousRecyclerView, h.la(paramAnonymousInt1, m.e(paramAnonymousRecyclerView)));
        if (paramAnonymousInt1 == m.b(this.gAj).getItemCount() - 1) {}
        for (paramAnonymousInt1 = 1;; paramAnonymousInt1 = 0)
        {
          if (paramAnonymousInt1 != 0) {
            m.c(this.gAj);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveCommentPlugin$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(190079);
          return;
        }
      }
      
      public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(190080);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bb(paramAnonymousRecyclerView);
        localb.lS(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveCommentPlugin$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.aeE());
        super.b(paramAnonymousRecyclerView, paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveCommentPlugin$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(190080);
      }
    });
    if (aly())
    {
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(190107);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).width = (ap.cl(paramViewGroup.getContext()).x * 35 / 100);
    }
    AppMethodBeat.o(190107);
  }
  
  private final void alW()
  {
    AppMethodBeat.i(190099);
    this.gAb.setVisibility(8);
    AppMethodBeat.o(190099);
  }
  
  public final void a(LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(190100);
    k.h(paramLiveConfig, "config");
    if (paramLiveConfig.aii() == LiveConfig.gmI) {}
    for (boolean bool = true;; bool = false)
    {
      this.dmG = bool;
      AppMethodBeat.o(190100);
      return;
    }
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(190103);
    k.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (n.cfA[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(190103);
      return;
      nj(8);
      this.enable = false;
      AppMethodBeat.o(190103);
      return;
      paramc = com.tencent.mm.live.b.g.guG;
      com.tencent.mm.live.b.g.na(com.tencent.mm.live.b.g.alg() + 1);
      alW();
      paramc = this.gAd;
      paramBundle = com.tencent.mm.live.b.g.guG;
      paramBundle = com.tencent.mm.hellhoundlib.b.c.a(com.tencent.mm.live.b.g.akD().size() - 1, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(paramc, paramBundle.aeD(), "com/tencent/mm/live/plugin/LiveCommentPlugin", "onMsgPosted", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      paramc.smoothScrollToPosition(((Integer)paramBundle.lR(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(paramc, "com/tencent/mm/live/plugin/LiveCommentPlugin", "onMsgPosted", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      AppMethodBeat.o(190103);
      return;
      nj(0);
      this.enable = true;
    }
  }
  
  public final void alM()
  {
    AppMethodBeat.i(190104);
    super.alM();
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.agQ();
    k.g(localb, "MMKernel.network()");
    localb.agi().a(904, (com.tencent.mm.ak.g)this);
    AppMethodBeat.o(190104);
  }
  
  public final void alN()
  {
    AppMethodBeat.i(190105);
    super.alN();
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.agQ();
    k.g(localb, "MMKernel.network()");
    localb.agi().b(904, (com.tencent.mm.ak.g)this);
    AppMethodBeat.o(190105);
  }
  
  public final void alX()
  {
    AppMethodBeat.i(190101);
    if (this.gnb.getVisibility() == 0)
    {
      Object localObject1 = com.tencent.mm.live.b.g.guG;
      localObject1 = (Collection)com.tencent.mm.live.b.g.akD();
      int i;
      if ((localObject1 == null) || (((Collection)localObject1).isEmpty())) {
        i = 1;
      }
      while (i == 0)
      {
        localObject1 = new StringBuilder("liveMessageCallback msgListCount:");
        Object localObject2 = com.tencent.mm.live.b.g.guG;
        localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.live.b.g.akD().size()).append(" readCount:").append(this.readCount).append(" enable_comment:");
        localObject2 = com.tencent.mm.live.b.g.guG;
        localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.live.b.g.akF().DVV).append(" msgFilterTime:");
        localObject2 = com.tencent.mm.live.b.g.guG;
        ac.i("MicroMsg.LiveCommentPlugin", com.tencent.mm.live.b.g.akI());
        localObject1 = this.gAd.getLayoutManager();
        if (localObject1 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
          AppMethodBeat.o(190101);
          throw ((Throwable)localObject1);
          i = 0;
        }
        else
        {
          int k;
          if (((LinearLayoutManager)localObject1).jY() == this.gAe.getItemCount() - 1)
          {
            i = 1;
            localObject1 = com.tencent.mm.live.b.g.guG;
            k = com.tencent.mm.live.b.g.akD().size() - this.readCount - 1;
            localObject1 = com.tencent.mm.live.b.g.guG;
            if (!com.tencent.mm.live.b.g.akF().DVV) {
              break label343;
            }
            localObject1 = com.tencent.mm.live.b.g.guG;
          }
          for (localObject1 = (List)com.tencent.mm.live.b.g.akD();; localObject1 = (List)localObject1)
          {
            localObject2 = android.support.v7.h.c.a((c.a)new g(this, (List)localObject1), false);
            k.g(localObject2, "DiffUtil.calculateDiff(o…      }\n        }, false)");
            ((c.b)localObject2).a((d)new f(this, (List)localObject1));
            if (this.gAe.getItemCount() <= 0) {
              break label574;
            }
            if (i == 0) {
              break label473;
            }
            this.gAd.post((Runnable)new h(this));
            AppMethodBeat.o(190101);
            return;
            i = 0;
            break;
            label343:
            localObject1 = com.tencent.mm.live.b.g.guG;
            localObject2 = (Iterable)com.tencent.mm.live.b.g.akD();
            localObject1 = (Collection)new ArrayList();
            localObject2 = ((Iterable)localObject2).iterator();
            label461:
            while (((Iterator)localObject2).hasNext())
            {
              Object localObject3 = ((Iterator)localObject2).next();
              Object localObject4 = (com.tencent.mm.live.view.a.a)localObject3;
              int j = ((com.tencent.mm.live.view.a.a)localObject4).msgType;
              f.c localc = f.c.gtp;
              if (j == f.c.akm())
              {
                j = ((com.tencent.mm.live.view.a.a)localObject4).gIh;
                localObject4 = com.tencent.mm.live.b.g.guG;
                if (j < com.tencent.mm.live.b.g.akI()) {}
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
            this.gAb.setVisibility(0);
            localObject1 = this.gAc;
            localObject2 = z.KUT;
            localObject2 = this.gnb.getContext();
            k.g(localObject2, "root.context");
            localObject2 = ((Context)localObject2).getResources().getString(2131766648);
            k.g(localObject2, "root.context.resources.g…ing.live_new_comment_tip)");
            localObject2 = String.format((String)localObject2, Arrays.copyOf(new Object[] { Integer.valueOf(k) }, 1));
            k.g(localObject2, "java.lang.String.format(format, *args)");
            ((TextView)localObject1).setText((CharSequence)localObject2);
          }
        }
      }
    }
    label574:
    AppMethodBeat.o(190101);
  }
  
  public final void i(boolean paramBoolean, int paramInt) {}
  
  public final void nj(int paramInt)
  {
    AppMethodBeat.i(190102);
    super.nj(paramInt);
    this.gAd.setVisibility(0);
    AppMethodBeat.o(190102);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(190106);
    if (((paramn instanceof s)) && (paramInt1 == 4) && (paramInt2 == -100048))
    {
      paramString = com.tencent.mm.live.b.g.guG;
      j.a((List)com.tencent.mm.live.b.g.akD(), (d.g.a.b)new d(paramn));
      com.tencent.mm.ac.c.g((d.g.a.a)new e(this));
    }
    AppMethodBeat.o(190106);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "wording", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.b<String, y>
  {
    b(m paramm)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "linked", "", "callingUser", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.m<Boolean, String, y>
  {
    c(m paramm)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/live/view/adapter/CommentData;", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.b<com.tencent.mm.live.view.a.a, Boolean>
  {
    d(n paramn)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    e(m paramm)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/live/plugin/LiveCommentPlugin$updateComments$1", "Landroid/support/v7/util/ListUpdateCallback;", "onChanged", "", "position", "", "count", "payload", "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "plugin-logic_release"})
  public static final class f
    implements d
  {
    f(List paramList) {}
    
    public final void E(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(190092);
      ac.d("MicroMsg.LiveCommentPlugin", "onInserted position:" + paramInt1 + ", count:" + paramInt2);
      m.b(this.gAj).gIn.clear();
      m.b(this.gAj).gIn.addAll((Collection)this.gAq);
      m.b(this.gAj).aq(paramInt1, paramInt2);
      AppMethodBeat.o(190092);
    }
    
    public final void F(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(190093);
      ac.d("MicroMsg.LiveCommentPlugin", "onRemoved position:" + paramInt1 + ", count:" + paramInt2);
      m.b(this.gAj).gIn.clear();
      m.b(this.gAj).gIn.addAll((Collection)this.gAq);
      m.b(this.gAj).ar(paramInt1, paramInt2);
      AppMethodBeat.o(190093);
    }
    
    public final void G(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(190091);
      ac.d("MicroMsg.LiveCommentPlugin", "onMoved fromPosition:" + paramInt1 + ", toPosition:" + paramInt2);
      m.b(this.gAj).ap(paramInt1, paramInt2);
      AppMethodBeat.o(190091);
    }
    
    public final void c(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(190090);
      ac.d("MicroMsg.LiveCommentPlugin", "onChanged position:" + paramInt1 + ", count:" + paramInt2);
      m.b(this.gAj).gIn.clear();
      m.b(this.gAj).gIn.addAll((Collection)this.gAq);
      m.b(this.gAj).ao(paramInt1, paramInt2);
      AppMethodBeat.o(190090);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/live/plugin/LiveCommentPlugin$updateComments$result$1", "Landroid/support/v7/util/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-logic_release"})
  public static final class g
    extends c.a
  {
    g(List paramList) {}
    
    public final boolean H(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(190096);
      boolean bool = k.g((com.tencent.mm.live.view.a.a)m.b(this.gAj).gIn.get(paramInt1), (com.tencent.mm.live.view.a.a)this.gAq.get(paramInt2));
      AppMethodBeat.o(190096);
      return bool;
    }
    
    public final boolean I(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(190097);
      boolean bool = k.g((com.tencent.mm.live.view.a.a)m.b(this.gAj).gIn.get(paramInt1), (com.tencent.mm.live.view.a.a)this.gAq.get(paramInt2));
      AppMethodBeat.o(190097);
      return bool;
    }
    
    public final int gZ()
    {
      AppMethodBeat.i(190094);
      int i = m.b(this.gAj).gIn.size();
      AppMethodBeat.o(190094);
      return i;
    }
    
    public final int ha()
    {
      AppMethodBeat.i(190095);
      int i = this.gAq.size();
      AppMethodBeat.o(190095);
      return i;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(m paramm) {}
    
    public final void run()
    {
      AppMethodBeat.i(190098);
      RecyclerView localRecyclerView = m.a(this.gAj);
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(h.la(m.b(this.gAj).getItemCount() - 1, 0), new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.aeD(), "com/tencent/mm/live/plugin/LiveCommentPlugin$updateMessages$1", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      localRecyclerView.smoothScrollToPosition(((Integer)locala.lR(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/live/plugin/LiveCommentPlugin$updateMessages$1", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      AppMethodBeat.o(190098);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.m
 * JD-Core Version:    0.7.0.1
 */