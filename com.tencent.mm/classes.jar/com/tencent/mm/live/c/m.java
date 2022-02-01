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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.a.s;
import com.tencent.mm.live.b.f.c;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.ar;
import d.g.b.ad;
import d.g.b.p;
import d.l;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/plugin/LiveCommentPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "BAN_COMMENT_TIP_TIMEOUT", "", "BAN_COMMENT_TIP_TIMEOUT$1", "banCommentCallback", "Lkotlin/Function1;", "", "", "commentAdapter", "Lcom/tencent/mm/live/view/adapter/LiveCommentAdapter;", "commentListView", "Landroid/support/v7/widget/RecyclerView;", "enable", "", "isAnchor", "linkMicCallback", "Lkotlin/Function2;", "newTipGroup", "newTipTv", "Landroid/widget/TextView;", "readCount", "", "hideNewCommentTip", "keyboardChange", "show", "height", "mount", "onMsgPosted", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setVisible", "visible", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "showNewCommentTip", "count", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "updateComments", "newDatas", "", "Lcom/tencent/mm/live/view/adapter/CommentData;", "updateMessages", "Companion", "plugin-logic_release"})
public final class m
  extends a
  implements f
{
  public static final m.a gWD;
  private boolean dzz;
  private boolean enable;
  private final b gVE;
  private final long gWA;
  private final d.g.a.b<String, z> gWB;
  private final d.g.a.m<Boolean, String, z> gWC;
  private final ViewGroup gWw;
  private final TextView gWx;
  private final RecyclerView gWy;
  private final com.tencent.mm.live.view.a.c gWz;
  private int readCount;
  
  static
  {
    AppMethodBeat.i(216016);
    gWD = new m.a((byte)0);
    AppMethodBeat.o(216016);
  }
  
  public m(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(216015);
    this.gVE = paramb;
    paramb = paramViewGroup.findViewById(2131307604);
    p.g(paramb, "root.findViewById(R.id.l…e_comment_list_tip_group)");
    this.gWw = ((ViewGroup)paramb);
    paramb = paramViewGroup.findViewById(2131307605);
    p.g(paramb, "root.findViewById(R.id.live_comment_list_tip_tv)");
    this.gWx = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(2131307603);
    p.g(paramb, "root.findViewById(R.id.live_comment_list)");
    this.gWy = ((RecyclerView)paramb);
    this.gWz = new com.tencent.mm.live.view.a.c();
    this.gWA = 3000L;
    this.gWB = ((d.g.a.b)new b(this));
    this.gWC = ((d.g.a.m)new c(this));
    paramb = this.gWy;
    paramViewGroup.getContext();
    paramb.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    this.gWy.setAdapter((RecyclerView.a)this.gWz);
    paramb = com.tencent.mm.live.b.c.gPx;
    com.tencent.mm.live.b.c.a(name(), this.gWB);
    paramb = com.tencent.mm.live.b.c.gPx;
    com.tencent.mm.live.b.c.a(name(), this.gWC);
    this.gWw.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(215986);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveCommentPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        m.c(this.gWE);
        paramAnonymousView = m.a(this.gWE);
        localObject = com.tencent.mm.live.b.g.gQZ;
        localObject = com.tencent.mm.hellhoundlib.b.c.a(com.tencent.mm.live.b.g.anF().size() - 1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/live/plugin/LiveCommentPlugin$1", "onClick", "(Landroid/view/View;)V", "Undefined", "smoothScrollToPosition", "(I)V");
        paramAnonymousView.smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/live/plugin/LiveCommentPlugin$1", "onClick", "(Landroid/view/View;)V", "Undefined", "smoothScrollToPosition", "(I)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveCommentPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(215986);
      }
    });
    this.gWy.a((RecyclerView.m)new RecyclerView.m()
    {
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(215987);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousRecyclerView);
        localb.mu(paramAnonymousInt1);
        localb.mu(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveCommentPlugin$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahF());
        p.h(paramAnonymousRecyclerView, "recyclerView");
        paramAnonymousRecyclerView = m.a(this.gWE).getLayoutManager();
        if (paramAnonymousRecyclerView == null)
        {
          paramAnonymousRecyclerView = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
          AppMethodBeat.o(215987);
          throw paramAnonymousRecyclerView;
        }
        paramAnonymousInt1 = ((LinearLayoutManager)paramAnonymousRecyclerView).ko();
        paramAnonymousRecyclerView = this.gWE;
        m.a(paramAnonymousRecyclerView, d.k.j.lw(paramAnonymousInt1, m.e(paramAnonymousRecyclerView)));
        if (paramAnonymousInt1 == m.b(this.gWE).getItemCount() - 1) {}
        for (paramAnonymousInt1 = 1;; paramAnonymousInt1 = 0)
        {
          if (paramAnonymousInt1 != 0) {
            m.c(this.gWE);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveCommentPlugin$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(215987);
          return;
        }
      }
      
      public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(215988);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousRecyclerView);
        localb.mu(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveCommentPlugin$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahF());
        super.b(paramAnonymousRecyclerView, paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveCommentPlugin$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(215988);
      }
    });
    if (aoA())
    {
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(216015);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).width = (ar.ck(paramViewGroup.getContext()).x * 35 / 100);
    }
    AppMethodBeat.o(216015);
  }
  
  private final void aoX()
  {
    AppMethodBeat.i(216007);
    this.gWw.setVisibility(8);
    AppMethodBeat.o(216007);
  }
  
  public final void a(LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(216008);
    p.h(paramLiveConfig, "config");
    if (paramLiveConfig.alj() == LiveConfig.gJa) {}
    for (boolean bool = true;; bool = false)
    {
      this.dzz = bool;
      AppMethodBeat.o(216008);
      return;
    }
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(216011);
    p.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (n.cqt[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(216011);
      return;
      nL(8);
      this.enable = false;
      AppMethodBeat.o(216011);
      return;
      paramc = com.tencent.mm.live.b.g.gQZ;
      com.tencent.mm.live.b.g.nC(com.tencent.mm.live.b.g.aoi() + 1);
      aoX();
      paramc = this.gWy;
      paramBundle = com.tencent.mm.live.b.g.gQZ;
      paramBundle = com.tencent.mm.hellhoundlib.b.c.a(com.tencent.mm.live.b.g.anF().size() - 1, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(paramc, paramBundle.ahE(), "com/tencent/mm/live/plugin/LiveCommentPlugin", "onMsgPosted", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      paramc.smoothScrollToPosition(((Integer)paramBundle.mt(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(paramc, "com/tencent/mm/live/plugin/LiveCommentPlugin", "onMsgPosted", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      AppMethodBeat.o(216011);
      return;
      nL(0);
      this.enable = true;
    }
  }
  
  public final void aoO()
  {
    AppMethodBeat.i(216012);
    super.aoO();
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.ajQ();
    p.g(localb, "MMKernel.network()");
    localb.ajj().a(904, (f)this);
    AppMethodBeat.o(216012);
  }
  
  public final void aoP()
  {
    AppMethodBeat.i(216013);
    super.aoP();
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.ajQ();
    p.g(localb, "MMKernel.network()");
    localb.ajj().b(904, (f)this);
    AppMethodBeat.o(216013);
  }
  
  public final void aoY()
  {
    AppMethodBeat.i(216009);
    if (this.gJt.getVisibility() == 0)
    {
      Object localObject1 = com.tencent.mm.live.b.g.gQZ;
      localObject1 = (Collection)com.tencent.mm.live.b.g.anF();
      int i;
      if ((localObject1 == null) || (((Collection)localObject1).isEmpty())) {
        i = 1;
      }
      while (i == 0)
      {
        localObject1 = new StringBuilder("liveMessageCallback msgListCount:");
        Object localObject2 = com.tencent.mm.live.b.g.gQZ;
        localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.live.b.g.anF().size()).append(" readCount:").append(this.readCount).append(" enable_comment:");
        localObject2 = com.tencent.mm.live.b.g.gQZ;
        localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.live.b.g.anH().FTM).append(" msgFilterTime:");
        localObject2 = com.tencent.mm.live.b.g.gQZ;
        ae.i("MicroMsg.LiveCommentPlugin", com.tencent.mm.live.b.g.anK());
        localObject1 = this.gWy.getLayoutManager();
        if (localObject1 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
          AppMethodBeat.o(216009);
          throw ((Throwable)localObject1);
          i = 0;
        }
        else
        {
          int k;
          if (((LinearLayoutManager)localObject1).ko() == this.gWz.getItemCount() - 1)
          {
            i = 1;
            localObject1 = com.tencent.mm.live.b.g.gQZ;
            k = com.tencent.mm.live.b.g.anF().size() - this.readCount - 1;
            localObject1 = com.tencent.mm.live.b.g.gQZ;
            if (!com.tencent.mm.live.b.g.anH().FTM) {
              break label343;
            }
            localObject1 = com.tencent.mm.live.b.g.gQZ;
          }
          for (localObject1 = (List)com.tencent.mm.live.b.g.anF();; localObject1 = (List)localObject1)
          {
            localObject2 = android.support.v7.h.c.a((c.a)new g(this, (List)localObject1), false);
            p.g(localObject2, "DiffUtil.calculateDiff(o…      }\n        }, false)");
            ((c.b)localObject2).a((d)new f(this, (List)localObject1));
            if (this.gWz.getItemCount() <= 0) {
              break label574;
            }
            if (i == 0) {
              break label473;
            }
            this.gWy.post((Runnable)new h(this));
            AppMethodBeat.o(216009);
            return;
            i = 0;
            break;
            label343:
            localObject1 = com.tencent.mm.live.b.g.gQZ;
            localObject2 = (Iterable)com.tencent.mm.live.b.g.anF();
            localObject1 = (Collection)new ArrayList();
            localObject2 = ((Iterable)localObject2).iterator();
            label461:
            while (((Iterator)localObject2).hasNext())
            {
              Object localObject3 = ((Iterator)localObject2).next();
              Object localObject4 = (com.tencent.mm.live.view.a.a)localObject3;
              int j = ((com.tencent.mm.live.view.a.a)localObject4).msgType;
              f.c localc = f.c.gPJ;
              if (j == f.c.ann())
              {
                j = ((com.tencent.mm.live.view.a.a)localObject4).heF;
                localObject4 = com.tencent.mm.live.b.g.gQZ;
                if (j < com.tencent.mm.live.b.g.anK()) {}
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
            this.gWw.setVisibility(0);
            localObject1 = this.gWx;
            localObject2 = ad.Njc;
            localObject2 = this.gJt.getContext();
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
    AppMethodBeat.o(216009);
  }
  
  public final void i(boolean paramBoolean, int paramInt) {}
  
  public final void nL(int paramInt)
  {
    AppMethodBeat.i(216010);
    super.nL(paramInt);
    this.gWy.setVisibility(0);
    AppMethodBeat.o(216010);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(216014);
    if (((paramn instanceof s)) && (paramInt1 == 4) && (paramInt2 == -100048))
    {
      paramString = com.tencent.mm.live.b.g.gQZ;
      d.a.j.c((List)com.tencent.mm.live.b.g.anF(), (d.g.a.b)new m.d(paramn));
      com.tencent.mm.ac.c.h((d.g.a.a)new e(this));
    }
    AppMethodBeat.o(216014);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "wording", "", "invoke"})
  static final class b
    extends d.g.b.q
    implements d.g.a.b<String, z>
  {
    b(m paramm)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "linked", "", "callingUser", "", "invoke"})
  static final class c
    extends d.g.b.q
    implements d.g.a.m<Boolean, String, z>
  {
    c(m paramm)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    e(m paramm)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/live/plugin/LiveCommentPlugin$updateComments$1", "Landroid/support/v7/util/ListUpdateCallback;", "onChanged", "", "position", "", "count", "payload", "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "plugin-logic_release"})
  public static final class f
    implements d
  {
    f(List paramList) {}
    
    public final void c(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(215998);
      ae.d("MicroMsg.LiveCommentPlugin", "onChanged position:" + paramInt1 + ", count:" + paramInt2);
      m.b(this.gWE).heL.clear();
      m.b(this.gWE).heL.addAll((Collection)this.gWJ);
      m.b(this.gWE).ap(paramInt1, paramInt2);
      AppMethodBeat.o(215998);
    }
    
    public final void f(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(216000);
      ae.d("MicroMsg.LiveCommentPlugin", "onInserted position:" + paramInt1 + ", count:" + paramInt2);
      m.b(this.gWE).heL.clear();
      m.b(this.gWE).heL.addAll((Collection)this.gWJ);
      m.b(this.gWE).ar(paramInt1, paramInt2);
      AppMethodBeat.o(216000);
    }
    
    public final void k(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(216001);
      ae.d("MicroMsg.LiveCommentPlugin", "onRemoved position:" + paramInt1 + ", count:" + paramInt2);
      m.b(this.gWE).heL.clear();
      m.b(this.gWE).heL.addAll((Collection)this.gWJ);
      m.b(this.gWE).as(paramInt1, paramInt2);
      AppMethodBeat.o(216001);
    }
    
    public final void l(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(215999);
      ae.d("MicroMsg.LiveCommentPlugin", "onMoved fromPosition:" + paramInt1 + ", toPosition:" + paramInt2);
      m.b(this.gWE).aq(paramInt1, paramInt2);
      AppMethodBeat.o(215999);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/live/plugin/LiveCommentPlugin$updateComments$result$1", "Landroid/support/v7/util/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-logic_release"})
  public static final class g
    extends c.a
  {
    g(List paramList) {}
    
    public final int aA()
    {
      AppMethodBeat.i(216003);
      int i = this.gWJ.size();
      AppMethodBeat.o(216003);
      return i;
    }
    
    public final int az()
    {
      AppMethodBeat.i(216002);
      int i = m.b(this.gWE).heL.size();
      AppMethodBeat.o(216002);
      return i;
    }
    
    public final boolean i(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(216004);
      boolean bool = p.i((com.tencent.mm.live.view.a.a)m.b(this.gWE).heL.get(paramInt1), (com.tencent.mm.live.view.a.a)this.gWJ.get(paramInt2));
      AppMethodBeat.o(216004);
      return bool;
    }
    
    public final boolean j(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(216005);
      boolean bool = p.i((com.tencent.mm.live.view.a.a)m.b(this.gWE).heL.get(paramInt1), (com.tencent.mm.live.view.a.a)this.gWJ.get(paramInt2));
      AppMethodBeat.o(216005);
      return bool;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(m paramm) {}
    
    public final void run()
    {
      AppMethodBeat.i(216006);
      RecyclerView localRecyclerView = m.a(this.gWE);
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(d.k.j.lw(m.b(this.gWE).getItemCount() - 1, 0), new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.ahE(), "com/tencent/mm/live/plugin/LiveCommentPlugin$updateMessages$1", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      localRecyclerView.smoothScrollToPosition(((Integer)locala.mt(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/live/plugin/LiveCommentPlugin$updateMessages$1", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      AppMethodBeat.o(216006);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.c.m
 * JD-Core Version:    0.7.0.1
 */