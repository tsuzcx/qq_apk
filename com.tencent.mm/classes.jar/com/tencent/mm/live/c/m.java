package com.tencent.mm.live.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.h.a;
import androidx.recyclerview.widget.h.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.h;
import com.tencent.mm.live.b.l.c;
import com.tencent.mm.live.b.u;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ax;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/plugin/LiveCommentPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "BAN_COMMENT_TIP_TIMEOUT", "", "BAN_COMMENT_TIP_TIMEOUT$1", "banCommentCallback", "Lkotlin/Function1;", "", "", "commentAdapter", "Lcom/tencent/mm/live/view/adapter/LiveCommentAdapter;", "commentListView", "Landroidx/recyclerview/widget/RecyclerView;", "enable", "", "isAnchor", "linkMicCallback", "Lkotlin/Function2;", "newTipGroup", "newTipTv", "Landroid/widget/TextView;", "readCount", "", "hideNewCommentTip", "keyboardChange", "show", "height", "mount", "onMsgPosted", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setVisible", "visible", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "showNewCommentTip", "count", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "updateComments", "newDatas", "", "Lcom/tencent/mm/live/view/adapter/CommentData;", "updateMessages", "Companion", "plugin-logic_release"})
public final class m
  extends a
  implements com.tencent.mm.an.i
{
  public static final a kDT;
  private boolean enable;
  private boolean fFE;
  private final b kCU;
  private final ViewGroup kDM;
  private final TextView kDN;
  private final RecyclerView kDO;
  private final com.tencent.mm.live.view.a.c kDP;
  private final long kDQ;
  private final kotlin.g.a.b<String, x> kDR;
  private final kotlin.g.a.m<Boolean, String, x> kDS;
  private int readCount;
  
  static
  {
    AppMethodBeat.i(191656);
    kDT = new a((byte)0);
    AppMethodBeat.o(191656);
  }
  
  public m(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(191650);
    this.kCU = paramb;
    paramb = paramViewGroup.findViewById(b.e.live_comment_list_tip_group);
    p.j(paramb, "root.findViewById(R.id.l…e_comment_list_tip_group)");
    this.kDM = ((ViewGroup)paramb);
    paramb = paramViewGroup.findViewById(b.e.live_comment_list_tip_tv);
    p.j(paramb, "root.findViewById(R.id.live_comment_list_tip_tv)");
    this.kDN = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(b.e.live_comment_list);
    p.j(paramb, "root.findViewById(R.id.live_comment_list)");
    this.kDO = ((RecyclerView)paramb);
    this.kDP = new com.tencent.mm.live.view.a.c();
    this.kDQ = 3000L;
    this.kDR = ((kotlin.g.a.b)new b(this));
    this.kDS = ((kotlin.g.a.m)new c(this));
    paramb = this.kDO;
    paramViewGroup.getContext();
    paramb.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    this.kDO.setAdapter((RecyclerView.a)this.kDP);
    paramb = com.tencent.mm.live.b.j.kue;
    com.tencent.mm.live.b.j.a(name(), this.kDR);
    paramb = com.tencent.mm.live.b.j.kue;
    com.tencent.mm.live.b.j.a(name(), this.kDS);
    this.kDM.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(192526);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveCommentPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        m.c(this.kDU);
        paramAnonymousView = m.a(this.kDU);
        localObject = u.kwz;
        localObject = com.tencent.mm.hellhoundlib.b.c.a(u.aOp().size() - 1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/live/plugin/LiveCommentPlugin$1", "onClick", "(Landroid/view/View;)V", "Undefined", "smoothScrollToPosition", "(I)V");
        paramAnonymousView.smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/live/plugin/LiveCommentPlugin$1", "onClick", "(Landroid/view/View;)V", "Undefined", "smoothScrollToPosition", "(I)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveCommentPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(192526);
      }
    });
    this.kDO.a((RecyclerView.l)new RecyclerView.l()
    {
      public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(193952);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousRecyclerView);
        localb.sg(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveCommentPlugin$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
        super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveCommentPlugin$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(193952);
      }
      
      public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(193948);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousRecyclerView);
        localb.sg(paramAnonymousInt1);
        localb.sg(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveCommentPlugin$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
        p.k(paramAnonymousRecyclerView, "recyclerView");
        paramAnonymousRecyclerView = m.a(this.kDU).getLayoutManager();
        if (paramAnonymousRecyclerView == null)
        {
          paramAnonymousRecyclerView = new kotlin.t("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
          AppMethodBeat.o(193948);
          throw paramAnonymousRecyclerView;
        }
        paramAnonymousInt1 = ((LinearLayoutManager)paramAnonymousRecyclerView).kL();
        paramAnonymousRecyclerView = this.kDU;
        m.a(paramAnonymousRecyclerView, kotlin.k.i.ov(paramAnonymousInt1, m.e(paramAnonymousRecyclerView)));
        if (paramAnonymousInt1 == m.b(this.kDU).getItemCount() - 1) {}
        for (paramAnonymousInt1 = 1;; paramAnonymousInt1 = 0)
        {
          if (paramAnonymousInt1 != 0) {
            m.c(this.kDU);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveCommentPlugin$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
          AppMethodBeat.o(193948);
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
        AppMethodBeat.o(191650);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).width = (ax.au(paramViewGroup.getContext()).x * 35 / 100);
    }
    AppMethodBeat.o(191650);
  }
  
  private final void aPw()
  {
    AppMethodBeat.i(191599);
    this.kDM.setVisibility(8);
    AppMethodBeat.o(191599);
  }
  
  public final void a(LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(191603);
    p.k(paramLiveConfig, "config");
    if (paramLiveConfig.aJf() == LiveConfig.khW) {}
    for (boolean bool = true;; bool = false)
    {
      this.fFE = bool;
      AppMethodBeat.o(191603);
      return;
    }
  }
  
  public final void aPx()
  {
    AppMethodBeat.i(191613);
    if (this.kiF.getVisibility() == 0)
    {
      Object localObject1 = u.kwz;
      localObject1 = (Collection)u.aOp();
      int i;
      if ((localObject1 == null) || (((Collection)localObject1).isEmpty())) {
        i = 1;
      }
      while (i == 0)
      {
        localObject1 = new StringBuilder("liveMessageCallback msgListCount:");
        Object localObject2 = u.kwz;
        localObject1 = ((StringBuilder)localObject1).append(u.aOp().size()).append(" readCount:").append(this.readCount).append(" enable_comment:");
        localObject2 = u.kwz;
        localObject1 = ((StringBuilder)localObject1).append(u.aOr().ROp).append(" msgFilterTime:");
        localObject2 = u.kwz;
        Log.i("MicroMsg.LiveCommentPlugin", u.aOu());
        localObject1 = this.kDO.getLayoutManager();
        if (localObject1 == null)
        {
          localObject1 = new kotlin.t("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
          AppMethodBeat.o(191613);
          throw ((Throwable)localObject1);
          i = 0;
        }
        else
        {
          int k;
          if (((LinearLayoutManager)localObject1).kL() == this.kDP.getItemCount() - 1)
          {
            i = 1;
            localObject1 = u.kwz;
            k = u.aOp().size() - this.readCount - 1;
            localObject1 = u.kwz;
            if (!u.aOr().ROp) {
              break label343;
            }
            localObject1 = u.kwz;
          }
          for (localObject1 = (List)u.aOp();; localObject1 = (List)localObject1)
          {
            localObject2 = androidx.recyclerview.widget.h.a((h.a)new g(this, (List)localObject1), false);
            p.j(localObject2, "DiffUtil.calculateDiff(o…      }\n        }, false)");
            ((h.b)localObject2).a((androidx.recyclerview.widget.s)new f(this, (List)localObject1));
            if (this.kDP.getItemCount() <= 0) {
              break label574;
            }
            if (i == 0) {
              break label473;
            }
            this.kDO.post((Runnable)new h(this));
            AppMethodBeat.o(191613);
            return;
            i = 0;
            break;
            label343:
            localObject1 = u.kwz;
            localObject2 = (Iterable)u.aOp();
            localObject1 = (Collection)new ArrayList();
            localObject2 = ((Iterable)localObject2).iterator();
            label461:
            while (((Iterator)localObject2).hasNext())
            {
              Object localObject3 = ((Iterator)localObject2).next();
              Object localObject4 = (com.tencent.mm.live.view.a.a)localObject3;
              int j = ((com.tencent.mm.live.view.a.a)localObject4).msgType;
              l.c localc = l.c.kuq;
              if (j == l.c.aNF())
              {
                j = ((com.tencent.mm.live.view.a.a)localObject4).time;
                localObject4 = u.kwz;
                if (j < u.aOu()) {}
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
            this.kDM.setVisibility(0);
            localObject1 = this.kDN;
            localObject2 = af.aaBG;
            localObject2 = this.kiF.getContext();
            p.j(localObject2, "root.context");
            localObject2 = ((Context)localObject2).getResources().getString(b.h.live_new_comment_tip);
            p.j(localObject2, "root.context.resources.g…ing.live_new_comment_tip)");
            localObject2 = String.format((String)localObject2, Arrays.copyOf(new Object[] { Integer.valueOf(k) }, 1));
            p.j(localObject2, "java.lang.String.format(format, *args)");
            ((TextView)localObject1).setText((CharSequence)localObject2);
          }
        }
      }
    }
    label574:
    AppMethodBeat.o(191613);
  }
  
  public final void keyboardChange(boolean paramBoolean, int paramInt) {}
  
  public final void mount()
  {
    AppMethodBeat.i(191635);
    super.mount();
    com.tencent.mm.kernel.c localc = com.tencent.mm.kernel.h.aHF();
    p.j(localc, "MMKernel.network()");
    localc.aGY().a(904, (com.tencent.mm.an.i)this);
    AppMethodBeat.o(191635);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(191643);
    if (((paramq instanceof com.tencent.mm.live.b.a.s)) && (paramInt1 == 4) && (paramInt2 == -100048))
    {
      paramString = u.kwz;
      kotlin.a.j.c((List)u.aOp(), (kotlin.g.a.b)new m.d(paramq));
      d.uiThread((kotlin.g.a.a)new e(this));
    }
    AppMethodBeat.o(191643);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(191633);
    p.k(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (n.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(191633);
      return;
      tU(8);
      this.enable = false;
      AppMethodBeat.o(191633);
      return;
      paramc = u.kwz;
      u.tN(u.aOQ() + 1);
      aPw();
      paramc = this.kDO;
      paramBundle = u.kwz;
      paramBundle = com.tencent.mm.hellhoundlib.b.c.a(u.aOp().size() - 1, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(paramc, paramBundle.aFh(), "com/tencent/mm/live/plugin/LiveCommentPlugin", "onMsgPosted", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      paramc.smoothScrollToPosition(((Integer)paramBundle.sf(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramc, "com/tencent/mm/live/plugin/LiveCommentPlugin", "onMsgPosted", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      AppMethodBeat.o(191633);
      return;
      tU(0);
      this.enable = true;
    }
  }
  
  public final void tU(int paramInt)
  {
    AppMethodBeat.i(191624);
    super.tU(paramInt);
    this.kDO.setVisibility(0);
    AppMethodBeat.o(191624);
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(191638);
    super.unMount();
    com.tencent.mm.kernel.c localc = com.tencent.mm.kernel.h.aHF();
    p.j(localc, "MMKernel.network()");
    localc.aGY().b(904, (com.tencent.mm.an.i)this);
    AppMethodBeat.o(191638);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/plugin/LiveCommentPlugin$Companion;", "", "()V", "BAN_COMMENT_TIP_TIMEOUT", "", "TAG", "", "plugin-logic_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "wording", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, x>
  {
    b(m paramm)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "linked", "", "callingUser", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.m<Boolean, String, x>
  {
    c(m paramm)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    e(m paramm)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/live/plugin/LiveCommentPlugin$updateComments$1", "Landroidx/recyclerview/widget/ListUpdateCallback;", "onChanged", "", "position", "", "count", "payload", "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "plugin-logic_release"})
  public static final class f
    implements androidx.recyclerview.widget.s
  {
    f(List paramList) {}
    
    public final void W(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(199034);
      Log.d("MicroMsg.LiveCommentPlugin", "onInserted position:" + paramInt1 + ", count:" + paramInt2);
      m.b(this.kDU).kMd.clear();
      m.b(this.kDU).kMd.addAll((Collection)this.kDZ);
      m.b(this.kDU).aG(paramInt1, paramInt2);
      AppMethodBeat.o(199034);
    }
    
    public final void ac(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(199036);
      Log.d("MicroMsg.LiveCommentPlugin", "onRemoved position:" + paramInt1 + ", count:" + paramInt2);
      m.b(this.kDU).kMd.clear();
      m.b(this.kDU).kMd.addAll((Collection)this.kDZ);
      m.b(this.kDU).aH(paramInt1, paramInt2);
      AppMethodBeat.o(199036);
    }
    
    public final void ad(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(199033);
      Log.d("MicroMsg.LiveCommentPlugin", "onMoved fromPosition:" + paramInt1 + ", toPosition:" + paramInt2);
      m.b(this.kDU).aF(paramInt1, paramInt2);
      AppMethodBeat.o(199033);
    }
    
    public final void c(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(199032);
      Log.d("MicroMsg.LiveCommentPlugin", "onChanged position:" + paramInt1 + ", count:" + paramInt2);
      m.b(this.kDU).kMd.clear();
      m.b(this.kDU).kMd.addAll((Collection)this.kDZ);
      m.b(this.kDU).aE(paramInt1, paramInt2);
      AppMethodBeat.o(199032);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/live/plugin/LiveCommentPlugin$updateComments$result$1", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-logic_release"})
  public static final class g
    extends h.a
  {
    g(List paramList) {}
    
    public final boolean Z(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(190781);
      boolean bool = p.h((com.tencent.mm.live.view.a.a)m.b(this.kDU).kMd.get(paramInt1), (com.tencent.mm.live.view.a.a)this.kDZ.get(paramInt2));
      AppMethodBeat.o(190781);
      return bool;
    }
    
    public final boolean ab(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(190784);
      boolean bool = p.h((com.tencent.mm.live.view.a.a)m.b(this.kDU).kMd.get(paramInt1), (com.tencent.mm.live.view.a.a)this.kDZ.get(paramInt2));
      AppMethodBeat.o(190784);
      return bool;
    }
    
    public final int jL()
    {
      AppMethodBeat.i(190774);
      int i = m.b(this.kDU).kMd.size();
      AppMethodBeat.o(190774);
      return i;
    }
    
    public final int jM()
    {
      AppMethodBeat.i(190776);
      int i = this.kDZ.size();
      AppMethodBeat.o(190776);
      return i;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(m paramm) {}
    
    public final void run()
    {
      AppMethodBeat.i(191064);
      RecyclerView localRecyclerView = m.a(this.kDU);
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(kotlin.k.i.ov(m.b(this.kDU).getItemCount() - 1, 0), new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(localRecyclerView, locala.aFh(), "com/tencent/mm/live/plugin/LiveCommentPlugin$updateMessages$1", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      localRecyclerView.smoothScrollToPosition(((Integer)locala.sf(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localRecyclerView, "com/tencent/mm/live/plugin/LiveCommentPlugin$updateMessages$1", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      AppMethodBeat.o(191064);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.m
 * JD-Core Version:    0.7.0.1
 */