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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.a.s;
import com.tencent.mm.live.b.f.c;
import com.tencent.mm.protocal.protobuf.buq;
import com.tencent.mm.ui.ar;
import d.a.j;
import d.g.b.p;
import d.k.h;
import d.l;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/plugin/LiveCommentPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "BAN_COMMENT_TIP_TIMEOUT", "", "BAN_COMMENT_TIP_TIMEOUT$1", "banCommentCallback", "Lkotlin/Function1;", "", "", "commentAdapter", "Lcom/tencent/mm/live/view/adapter/LiveCommentAdapter;", "commentListView", "Landroid/support/v7/widget/RecyclerView;", "enable", "", "isAnchor", "linkMicCallback", "Lkotlin/Function2;", "newTipGroup", "newTipTv", "Landroid/widget/TextView;", "readCount", "", "hideNewCommentTip", "keyboardChange", "show", "height", "mount", "onMsgPosted", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setVisible", "visible", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "showNewCommentTip", "count", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "updateComments", "newDatas", "", "Lcom/tencent/mm/live/view/adapter/CommentData;", "updateMessages", "Companion", "plugin-logic_release"})
public final class m
  extends a
  implements f
{
  public static final m.a gTT;
  private boolean dyu;
  private boolean enable;
  private final b gSV;
  private final ViewGroup gTM;
  private final TextView gTN;
  private final RecyclerView gTO;
  private final com.tencent.mm.live.view.a.c gTP;
  private final long gTQ;
  private final d.g.a.b<String, z> gTR;
  private final d.g.a.m<Boolean, String, z> gTS;
  private int readCount;
  
  static
  {
    AppMethodBeat.i(212396);
    gTT = new m.a((byte)0);
    AppMethodBeat.o(212396);
  }
  
  public m(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(212395);
    this.gSV = paramb;
    paramb = paramViewGroup.findViewById(2131307604);
    p.g(paramb, "root.findViewById(R.id.l…e_comment_list_tip_group)");
    this.gTM = ((ViewGroup)paramb);
    paramb = paramViewGroup.findViewById(2131307605);
    p.g(paramb, "root.findViewById(R.id.live_comment_list_tip_tv)");
    this.gTN = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(2131307603);
    p.g(paramb, "root.findViewById(R.id.live_comment_list)");
    this.gTO = ((RecyclerView)paramb);
    this.gTP = new com.tencent.mm.live.view.a.c();
    this.gTQ = 3000L;
    this.gTR = ((d.g.a.b)new b(this));
    this.gTS = ((d.g.a.m)new c(this));
    paramb = this.gTO;
    paramViewGroup.getContext();
    paramb.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    this.gTO.setAdapter((RecyclerView.a)this.gTP);
    paramb = com.tencent.mm.live.b.c.gMO;
    com.tencent.mm.live.b.c.a(name(), this.gTR);
    paramb = com.tencent.mm.live.b.c.gMO;
    com.tencent.mm.live.b.c.a(name(), this.gTS);
    this.gTM.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(212366);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveCommentPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        m.c(this.gTU);
        paramAnonymousView = m.a(this.gTU);
        localObject = com.tencent.mm.live.b.g.gOr;
        localObject = com.tencent.mm.hellhoundlib.b.c.a(com.tencent.mm.live.b.g.anp().size() - 1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/live/plugin/LiveCommentPlugin$1", "onClick", "(Landroid/view/View;)V", "Undefined", "smoothScrollToPosition", "(I)V");
        paramAnonymousView.smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/live/plugin/LiveCommentPlugin$1", "onClick", "(Landroid/view/View;)V", "Undefined", "smoothScrollToPosition", "(I)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveCommentPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(212366);
      }
    });
    this.gTO.a((RecyclerView.m)new RecyclerView.m()
    {
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(212367);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousRecyclerView);
        localb.mr(paramAnonymousInt1);
        localb.mr(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveCommentPlugin$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahq());
        p.h(paramAnonymousRecyclerView, "recyclerView");
        paramAnonymousRecyclerView = m.a(this.gTU).getLayoutManager();
        if (paramAnonymousRecyclerView == null)
        {
          paramAnonymousRecyclerView = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
          AppMethodBeat.o(212367);
          throw paramAnonymousRecyclerView;
        }
        paramAnonymousInt1 = ((LinearLayoutManager)paramAnonymousRecyclerView).ko();
        paramAnonymousRecyclerView = this.gTU;
        m.a(paramAnonymousRecyclerView, h.lp(paramAnonymousInt1, m.e(paramAnonymousRecyclerView)));
        if (paramAnonymousInt1 == m.b(this.gTU).getItemCount() - 1) {}
        for (paramAnonymousInt1 = 1;; paramAnonymousInt1 = 0)
        {
          if (paramAnonymousInt1 != 0) {
            m.c(this.gTU);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveCommentPlugin$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(212367);
          return;
        }
      }
      
      public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(212368);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousRecyclerView);
        localb.mr(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveCommentPlugin$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahq());
        super.b(paramAnonymousRecyclerView, paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveCommentPlugin$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(212368);
      }
    });
    if (aol())
    {
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(212395);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).width = (ar.ci(paramViewGroup.getContext()).x * 35 / 100);
    }
    AppMethodBeat.o(212395);
  }
  
  private final void aoJ()
  {
    AppMethodBeat.i(212387);
    this.gTM.setVisibility(8);
    AppMethodBeat.o(212387);
  }
  
  public final void a(LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(212388);
    p.h(paramLiveConfig, "config");
    if (paramLiveConfig.akU() == LiveConfig.gGr) {}
    for (boolean bool = true;; bool = false)
    {
      this.dyu = bool;
      AppMethodBeat.o(212388);
      return;
    }
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(212391);
    p.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (n.cpQ[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(212391);
      return;
      nI(8);
      this.enable = false;
      AppMethodBeat.o(212391);
      return;
      paramc = com.tencent.mm.live.b.g.gOr;
      com.tencent.mm.live.b.g.nz(com.tencent.mm.live.b.g.anT() + 1);
      aoJ();
      paramc = this.gTO;
      paramBundle = com.tencent.mm.live.b.g.gOr;
      paramBundle = com.tencent.mm.hellhoundlib.b.c.a(com.tencent.mm.live.b.g.anp().size() - 1, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(paramc, paramBundle.ahp(), "com/tencent/mm/live/plugin/LiveCommentPlugin", "onMsgPosted", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      paramc.smoothScrollToPosition(((Integer)paramBundle.mq(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(paramc, "com/tencent/mm/live/plugin/LiveCommentPlugin", "onMsgPosted", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      AppMethodBeat.o(212391);
      return;
      nI(0);
      this.enable = true;
    }
  }
  
  public final void aoA()
  {
    AppMethodBeat.i(212393);
    super.aoA();
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.ajB();
    p.g(localb, "MMKernel.network()");
    localb.aiU().b(904, (f)this);
    AppMethodBeat.o(212393);
  }
  
  public final void aoK()
  {
    AppMethodBeat.i(212389);
    if (this.gGK.getVisibility() == 0)
    {
      Object localObject1 = com.tencent.mm.live.b.g.gOr;
      localObject1 = (Collection)com.tencent.mm.live.b.g.anp();
      int i;
      if ((localObject1 == null) || (((Collection)localObject1).isEmpty())) {
        i = 1;
      }
      while (i == 0)
      {
        localObject1 = new StringBuilder("liveMessageCallback msgListCount:");
        Object localObject2 = com.tencent.mm.live.b.g.gOr;
        localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.live.b.g.anp().size()).append(" readCount:").append(this.readCount).append(" enable_comment:");
        localObject2 = com.tencent.mm.live.b.g.gOr;
        localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.live.b.g.ans().FBr).append(" msgFilterTime:");
        localObject2 = com.tencent.mm.live.b.g.gOr;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LiveCommentPlugin", com.tencent.mm.live.b.g.anv());
        localObject1 = this.gTO.getLayoutManager();
        if (localObject1 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
          AppMethodBeat.o(212389);
          throw ((Throwable)localObject1);
          i = 0;
        }
        else
        {
          int k;
          if (((LinearLayoutManager)localObject1).ko() == this.gTP.getItemCount() - 1)
          {
            i = 1;
            localObject1 = com.tencent.mm.live.b.g.gOr;
            k = com.tencent.mm.live.b.g.anp().size() - this.readCount - 1;
            localObject1 = com.tencent.mm.live.b.g.gOr;
            if (!com.tencent.mm.live.b.g.ans().FBr) {
              break label343;
            }
            localObject1 = com.tencent.mm.live.b.g.gOr;
          }
          for (localObject1 = (List)com.tencent.mm.live.b.g.anp();; localObject1 = (List)localObject1)
          {
            localObject2 = android.support.v7.h.c.a((c.a)new g(this, (List)localObject1), false);
            p.g(localObject2, "DiffUtil.calculateDiff(o…      }\n        }, false)");
            ((c.b)localObject2).a((d)new f(this, (List)localObject1));
            if (this.gTP.getItemCount() <= 0) {
              break label574;
            }
            if (i == 0) {
              break label473;
            }
            this.gTO.post((Runnable)new h(this));
            AppMethodBeat.o(212389);
            return;
            i = 0;
            break;
            label343:
            localObject1 = com.tencent.mm.live.b.g.gOr;
            localObject2 = (Iterable)com.tencent.mm.live.b.g.anp();
            localObject1 = (Collection)new ArrayList();
            localObject2 = ((Iterable)localObject2).iterator();
            label461:
            while (((Iterator)localObject2).hasNext())
            {
              Object localObject3 = ((Iterator)localObject2).next();
              Object localObject4 = (com.tencent.mm.live.view.a.a)localObject3;
              int j = ((com.tencent.mm.live.view.a.a)localObject4).msgType;
              f.c localc = f.c.gNa;
              if (j == f.c.amY())
              {
                j = ((com.tencent.mm.live.view.a.a)localObject4).hbR;
                localObject4 = com.tencent.mm.live.b.g.gOr;
                if (j < com.tencent.mm.live.b.g.anv()) {}
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
            this.gTM.setVisibility(0);
            localObject1 = this.gTN;
            localObject2 = d.g.b.ad.MLZ;
            localObject2 = this.gGK.getContext();
            p.g(localObject2, "root.context");
            localObject2 = ((Context)localObject2).getResources().getString(2131766648);
            p.g(localObject2, "root.context.resources.g…ing.live_new_comment_tip)");
            localObject2 = String.format((String)localObject2, Arrays.copyOf(new Object[] { Integer.valueOf(k) }, 1));
            p.g(localObject2, "java.lang.String.format(format, *args)");
            ((TextView)localObject1).setText((CharSequence)localObject2);
          }
        }
      }
    }
    label574:
    AppMethodBeat.o(212389);
  }
  
  public final void aoz()
  {
    AppMethodBeat.i(212392);
    super.aoz();
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.ajB();
    p.g(localb, "MMKernel.network()");
    localb.aiU().a(904, (f)this);
    AppMethodBeat.o(212392);
  }
  
  public final void i(boolean paramBoolean, int paramInt) {}
  
  public final void nI(int paramInt)
  {
    AppMethodBeat.i(212390);
    super.nI(paramInt);
    this.gTO.setVisibility(0);
    AppMethodBeat.o(212390);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(212394);
    if (((paramn instanceof s)) && (paramInt1 == 4) && (paramInt2 == -100048))
    {
      paramString = com.tencent.mm.live.b.g.gOr;
      j.b((List)com.tencent.mm.live.b.g.anp(), (d.g.a.b)new m.d(paramn));
      com.tencent.mm.ad.c.g((d.g.a.a)new e(this));
    }
    AppMethodBeat.o(212394);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "wording", "", "invoke"})
  static final class b
    extends d.g.b.q
    implements d.g.a.b<String, z>
  {
    b(m paramm)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "linked", "", "callingUser", "", "invoke"})
  static final class c
    extends d.g.b.q
    implements d.g.a.m<Boolean, String, z>
  {
    c(m paramm)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    e(m paramm)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/live/plugin/LiveCommentPlugin$updateComments$1", "Landroid/support/v7/util/ListUpdateCallback;", "onChanged", "", "position", "", "count", "payload", "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "plugin-logic_release"})
  public static final class f
    implements d
  {
    f(List paramList) {}
    
    public final void c(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(212378);
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.LiveCommentPlugin", "onChanged position:" + paramInt1 + ", count:" + paramInt2);
      m.b(this.gTU).hbX.clear();
      m.b(this.gTU).hbX.addAll((Collection)this.gUa);
      m.b(this.gTU).ap(paramInt1, paramInt2);
      AppMethodBeat.o(212378);
    }
    
    public final void f(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(212380);
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.LiveCommentPlugin", "onInserted position:" + paramInt1 + ", count:" + paramInt2);
      m.b(this.gTU).hbX.clear();
      m.b(this.gTU).hbX.addAll((Collection)this.gUa);
      m.b(this.gTU).ar(paramInt1, paramInt2);
      AppMethodBeat.o(212380);
    }
    
    public final void k(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(212381);
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.LiveCommentPlugin", "onRemoved position:" + paramInt1 + ", count:" + paramInt2);
      m.b(this.gTU).hbX.clear();
      m.b(this.gTU).hbX.addAll((Collection)this.gUa);
      m.b(this.gTU).as(paramInt1, paramInt2);
      AppMethodBeat.o(212381);
    }
    
    public final void l(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(212379);
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.LiveCommentPlugin", "onMoved fromPosition:" + paramInt1 + ", toPosition:" + paramInt2);
      m.b(this.gTU).aq(paramInt1, paramInt2);
      AppMethodBeat.o(212379);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/live/plugin/LiveCommentPlugin$updateComments$result$1", "Landroid/support/v7/util/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-logic_release"})
  public static final class g
    extends c.a
  {
    g(List paramList) {}
    
    public final int aA()
    {
      AppMethodBeat.i(212383);
      int i = this.gUa.size();
      AppMethodBeat.o(212383);
      return i;
    }
    
    public final int az()
    {
      AppMethodBeat.i(212382);
      int i = m.b(this.gTU).hbX.size();
      AppMethodBeat.o(212382);
      return i;
    }
    
    public final boolean i(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(212384);
      boolean bool = p.i((com.tencent.mm.live.view.a.a)m.b(this.gTU).hbX.get(paramInt1), (com.tencent.mm.live.view.a.a)this.gUa.get(paramInt2));
      AppMethodBeat.o(212384);
      return bool;
    }
    
    public final boolean j(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(212385);
      boolean bool = p.i((com.tencent.mm.live.view.a.a)m.b(this.gTU).hbX.get(paramInt1), (com.tencent.mm.live.view.a.a)this.gUa.get(paramInt2));
      AppMethodBeat.o(212385);
      return bool;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(m paramm) {}
    
    public final void run()
    {
      AppMethodBeat.i(212386);
      RecyclerView localRecyclerView = m.a(this.gTU);
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(h.lp(m.b(this.gTU).getItemCount() - 1, 0), new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.ahp(), "com/tencent/mm/live/plugin/LiveCommentPlugin$updateMessages$1", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      localRecyclerView.smoothScrollToPosition(((Integer)locala.mq(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/live/plugin/LiveCommentPlugin$updateMessages$1", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      AppMethodBeat.o(212386);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.m
 * JD-Core Version:    0.7.0.1
 */