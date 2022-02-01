package com.tencent.mm.live.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.g;
import androidx.recyclerview.widget.g.a;
import androidx.recyclerview.widget.g.b;
import androidx.recyclerview.widget.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.h;
import com.tencent.mm.live.model.j;
import com.tencent.mm.live.model.l.c;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.bf;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.am;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/plugin/LiveCommentPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "BAN_COMMENT_TIP_TIMEOUT", "", "BAN_COMMENT_TIP_TIMEOUT$1", "banCommentCallback", "Lkotlin/Function1;", "", "", "commentAdapter", "Lcom/tencent/mm/live/view/adapter/LiveCommentAdapter;", "commentListView", "Landroidx/recyclerview/widget/RecyclerView;", "enable", "", "isAnchor", "linkMicCallback", "Lkotlin/Function2;", "newTipGroup", "newTipTv", "Landroid/widget/TextView;", "readCount", "", "hideNewCommentTip", "keyboardChange", "show", "height", "mount", "onMsgPosted", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setVisible", "visible", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "showNewCommentTip", "count", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "updateComments", "newDatas", "", "Lcom/tencent/mm/live/view/adapter/CommentData;", "updateMessages", "Companion", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends a
  implements com.tencent.mm.am.h
{
  public static final h.a nhb;
  private boolean enable;
  private boolean hKC;
  private final b ngl;
  private final ViewGroup nhc;
  private final TextView nhd;
  private final RecyclerView nhe;
  private final com.tencent.mm.live.view.a.c nhf;
  private final long nhg;
  private final kotlin.g.a.b<String, ah> nhh;
  private final m<Boolean, String, ah> nhi;
  private int readCount;
  
  static
  {
    AppMethodBeat.i(247124);
    nhb = new h.a((byte)0);
    AppMethodBeat.o(247124);
  }
  
  public h(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(247043);
    this.ngl = paramb;
    paramb = paramViewGroup.findViewById(b.e.live_comment_list_tip_group);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.l…e_comment_list_tip_group)");
    this.nhc = ((ViewGroup)paramb);
    paramb = paramViewGroup.findViewById(b.e.live_comment_list_tip_tv);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.live_comment_list_tip_tv)");
    this.nhd = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(b.e.live_comment_list);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.live_comment_list)");
    this.nhe = ((RecyclerView)paramb);
    this.nhf = new com.tencent.mm.live.view.a.c();
    this.nhg = 3000L;
    this.nhh = ((kotlin.g.a.b)new c(this));
    this.nhi = ((m)new d(this));
    paramb = this.nhe;
    paramViewGroup.getContext();
    paramb.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    this.nhe.setAdapter((RecyclerView.a)this.nhf);
    paramb = j.mXT;
    j.a(name(), this.nhh);
    paramb = j.mXT;
    j.b(name(), this.nhi);
    this.nhc.setOnClickListener(new h..ExternalSyntheticLambda0(this));
    this.nhe.a((RecyclerView.l)new RecyclerView.l()
    {
      public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(247149);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousRecyclerView);
        localb.sc(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveCommentPlugin$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
        super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveCommentPlugin$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(247149);
      }
      
      public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(247137);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousRecyclerView);
        localb.sc(paramAnonymousInt1);
        localb.sc(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveCommentPlugin$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
        kotlin.g.b.s.u(paramAnonymousRecyclerView, "recyclerView");
        paramAnonymousRecyclerView = h.c(this.nhj).getLayoutManager();
        if (paramAnonymousRecyclerView == null)
        {
          paramAnonymousRecyclerView = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
          AppMethodBeat.o(247137);
          throw paramAnonymousRecyclerView;
        }
        paramAnonymousInt1 = ((LinearLayoutManager)paramAnonymousRecyclerView).Jw();
        paramAnonymousRecyclerView = this.nhj;
        h.a(paramAnonymousRecyclerView, k.qu(paramAnonymousInt1, h.f(paramAnonymousRecyclerView)));
        if (paramAnonymousInt1 == h.b(this.nhj).getItemCount() - 1) {}
        for (paramAnonymousInt1 = 1;; paramAnonymousInt1 = 0)
        {
          if (paramAnonymousInt1 != 0) {
            h.d(this.nhj);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveCommentPlugin$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
          AppMethodBeat.o(247137);
          return;
        }
      }
    });
    if (isLandscape())
    {
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(247043);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).width = (bf.bf(paramViewGroup.getContext()).x * 35 / 100);
    }
    AppMethodBeat.o(247043);
  }
  
  private static final void a(h paramh)
  {
    AppMethodBeat.i(247068);
    kotlin.g.b.s.u(paramh, "this$0");
    RecyclerView localRecyclerView = paramh.nhe;
    paramh = com.tencent.mm.hellhoundlib.b.c.a(k.qu(paramh.nhf.getItemCount() - 1, 0), new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(localRecyclerView, paramh.aYi(), "com/tencent/mm/live/plugin/LiveCommentPlugin", "updateMessages$lambda-2", "(Lcom/tencent/mm/live/plugin/LiveCommentPlugin;)V", "Undefined", "smoothScrollToPosition", "(I)V");
    localRecyclerView.smoothScrollToPosition(((Integer)paramh.sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localRecyclerView, "com/tencent/mm/live/plugin/LiveCommentPlugin", "updateMessages$lambda-2", "(Lcom/tencent/mm/live/plugin/LiveCommentPlugin;)V", "Undefined", "smoothScrollToPosition", "(I)V");
    AppMethodBeat.o(247068);
  }
  
  private static final void a(h paramh, View paramView)
  {
    AppMethodBeat.i(247063);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramh);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveCommentPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramh, "this$0");
    paramh.bjj();
    paramh = paramh.nhe;
    paramView = com.tencent.mm.live.model.u.mZl;
    paramView = com.tencent.mm.hellhoundlib.b.c.a(com.tencent.mm.live.model.u.bic().size() - 1, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(paramh, paramView.aYi(), "com/tencent/mm/live/plugin/LiveCommentPlugin", "_init_$lambda-0", "(Lcom/tencent/mm/live/plugin/LiveCommentPlugin;Landroid/view/View;)V", "Undefined", "smoothScrollToPosition", "(I)V");
    paramh.smoothScrollToPosition(((Integer)paramView.sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(paramh, "com/tencent/mm/live/plugin/LiveCommentPlugin", "_init_$lambda-0", "(Lcom/tencent/mm/live/plugin/LiveCommentPlugin;Landroid/view/View;)V", "Undefined", "smoothScrollToPosition", "(I)V");
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/plugin/LiveCommentPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(247063);
  }
  
  private final void bjj()
  {
    AppMethodBeat.i(247048);
    this.nhc.setVisibility(8);
    AppMethodBeat.o(247048);
  }
  
  public final void a(LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(247153);
    kotlin.g.b.s.u(paramLiveConfig, "config");
    if (paramLiveConfig.mIy == LiveConfig.mIs) {}
    for (boolean bool = true;; bool = false)
    {
      this.hKC = bool;
      AppMethodBeat.o(247153);
      return;
    }
  }
  
  public final void bjk()
  {
    AppMethodBeat.i(247174);
    if (this.mJe.getVisibility() == 0)
    {
      Object localObject1 = com.tencent.mm.live.model.u.mZl;
      localObject1 = (Collection)com.tencent.mm.live.model.u.bic();
      int i;
      if ((localObject1 == null) || (((Collection)localObject1).isEmpty())) {
        i = 1;
      }
      while (i == 0)
      {
        localObject1 = new StringBuilder("liveMessageCallback msgListCount:");
        Object localObject2 = com.tencent.mm.live.model.u.mZl;
        localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.live.model.u.bic().size()).append(" readCount:").append(this.readCount).append(" enable_comment:");
        localObject2 = com.tencent.mm.live.model.u.mZl;
        localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.live.model.u.bie().YLD).append(" msgFilterTime:");
        localObject2 = com.tencent.mm.live.model.u.mZl;
        Log.i("MicroMsg.LiveCommentPlugin", com.tencent.mm.live.model.u.bih());
        localObject1 = this.nhe.getLayoutManager();
        if (localObject1 == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
          AppMethodBeat.o(247174);
          throw ((Throwable)localObject1);
          i = 0;
        }
        else
        {
          int k;
          if (((LinearLayoutManager)localObject1).Jw() == this.nhf.getItemCount() - 1)
          {
            i = 1;
            localObject1 = com.tencent.mm.live.model.u.mZl;
            k = com.tencent.mm.live.model.u.bic().size() - this.readCount - 1;
            localObject1 = com.tencent.mm.live.model.u.mZl;
            if (!com.tencent.mm.live.model.u.bie().YLD) {
              break label340;
            }
            localObject1 = com.tencent.mm.live.model.u.mZl;
          }
          for (localObject1 = (List)com.tencent.mm.live.model.u.bic();; localObject1 = (List)localObject1)
          {
            localObject2 = g.a((g.a)new h(this, (List)localObject1), false);
            kotlin.g.b.s.s(localObject2, "private fun updateCommen…      }\n\n        })\n    }");
            ((g.b)localObject2).a((q)new g(this, (List)localObject1));
            if (this.nhf.getItemCount() <= 0) {
              break label559;
            }
            if (i == 0) {
              break label470;
            }
            this.nhe.post(new h..ExternalSyntheticLambda1(this));
            AppMethodBeat.o(247174);
            return;
            i = 0;
            break;
            label340:
            localObject1 = com.tencent.mm.live.model.u.mZl;
            localObject2 = (Iterable)com.tencent.mm.live.model.u.bic();
            localObject1 = (Collection)new ArrayList();
            localObject2 = ((Iterable)localObject2).iterator();
            label458:
            while (((Iterator)localObject2).hasNext())
            {
              Object localObject3 = ((Iterator)localObject2).next();
              Object localObject4 = (com.tencent.mm.live.view.a.a)localObject3;
              int j = ((com.tencent.mm.live.view.a.a)localObject4).msgType;
              l.c localc = l.c.mYi;
              if (j == l.c.bhq())
              {
                j = ((com.tencent.mm.live.view.a.a)localObject4).time;
                localObject4 = com.tencent.mm.live.model.u.mZl;
                if (j < com.tencent.mm.live.model.u.bih()) {}
              }
              for (j = 1;; j = 0)
              {
                if (j == 0) {
                  break label458;
                }
                ((Collection)localObject1).add(localObject3);
                break;
              }
            }
          }
          label470:
          if (k > 0)
          {
            this.nhc.setVisibility(0);
            localObject1 = this.nhd;
            localObject2 = am.aixg;
            localObject2 = this.mJe.getContext().getResources().getString(b.h.live_new_comment_tip);
            kotlin.g.b.s.s(localObject2, "root.context.resources.g…ing.live_new_comment_tip)");
            localObject2 = String.format((String)localObject2, Arrays.copyOf(new Object[] { Integer.valueOf(k) }, 1));
            kotlin.g.b.s.s(localObject2, "java.lang.String.format(format, *args)");
            ((TextView)localObject1).setText((CharSequence)localObject2);
          }
        }
      }
    }
    label559:
    AppMethodBeat.o(247174);
  }
  
  public final void keyboardChange(boolean paramBoolean, int paramInt) {}
  
  public final void mount()
  {
    AppMethodBeat.i(247214);
    super.mount();
    com.tencent.mm.kernel.h.baD().mCm.a(904, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(247214);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(247233);
    if (((paramp instanceof com.tencent.mm.live.model.a.s)) && (paramInt1 == 4) && (paramInt2 == -100048))
    {
      paramString = com.tencent.mm.live.model.u.mZl;
      kotlin.a.p.e((List)com.tencent.mm.live.model.u.bic(), (kotlin.g.a.b)new e(paramp));
      d.uiThread((kotlin.g.a.a)new f(this));
    }
    AppMethodBeat.o(247233);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(247203);
    kotlin.g.b.s.u(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(247203);
      return;
      tO(8);
      this.enable = false;
      AppMethodBeat.o(247203);
      return;
      paramc = com.tencent.mm.live.model.u.mZl;
      com.tencent.mm.live.model.u.tH(com.tencent.mm.live.model.u.biD() + 1);
      bjj();
      paramc = this.nhe;
      paramBundle = com.tencent.mm.live.model.u.mZl;
      paramBundle = com.tencent.mm.hellhoundlib.b.c.a(com.tencent.mm.live.model.u.bic().size() - 1, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(paramc, paramBundle.aYi(), "com/tencent/mm/live/plugin/LiveCommentPlugin", "onMsgPosted", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      paramc.smoothScrollToPosition(((Integer)paramBundle.sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramc, "com/tencent/mm/live/plugin/LiveCommentPlugin", "onMsgPosted", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      AppMethodBeat.o(247203);
      return;
      tO(0);
      this.enable = true;
    }
  }
  
  public final void tO(int paramInt)
  {
    AppMethodBeat.i(247193);
    super.tO(paramInt);
    this.nhe.setVisibility(0);
    AppMethodBeat.o(247193);
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(247220);
    super.unMount();
    com.tencent.mm.kernel.h.baD().mCm.b(904, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(247220);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "wording", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.b<String, ah>
  {
    c(h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "linked", "", "callingUser", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements m<Boolean, String, ah>
  {
    d(h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/live/view/adapter/CommentData;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.b<com.tencent.mm.live.view.a.a, Boolean>
  {
    e(com.tencent.mm.am.p paramp)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    f(h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/live/plugin/LiveCommentPlugin$updateComments$1", "Landroidx/recyclerview/widget/ListUpdateCallback;", "onChanged", "", "position", "", "count", "payload", "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements q
  {
    g(h paramh, List<com.tencent.mm.live.view.a.a> paramList) {}
    
    public final void aR(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(246990);
      Log.d("MicroMsg.LiveCommentPlugin", "onInserted position:" + paramInt1 + ", count:" + paramInt2);
      h.b(this.nhj).nnY.clear();
      h.b(this.nhj).nnY.addAll((Collection)this.nhn);
      h.b(this.nhj).bA(paramInt1, paramInt2);
      AppMethodBeat.o(246990);
    }
    
    public final void aS(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(246999);
      Log.d("MicroMsg.LiveCommentPlugin", "onRemoved position:" + paramInt1 + ", count:" + paramInt2);
      h.b(this.nhj).nnY.clear();
      h.b(this.nhj).nnY.addAll((Collection)this.nhn);
      h.b(this.nhj).bB(paramInt1, paramInt2);
      AppMethodBeat.o(246999);
    }
    
    public final void aW(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(246982);
      Log.d("MicroMsg.LiveCommentPlugin", "onMoved fromPosition:" + paramInt1 + ", toPosition:" + paramInt2);
      h.b(this.nhj).bz(paramInt1, paramInt2);
      AppMethodBeat.o(246982);
    }
    
    public final void c(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(246978);
      Log.d("MicroMsg.LiveCommentPlugin", "onChanged position:" + paramInt1 + ", count:" + paramInt2);
      h.b(this.nhj).nnY.clear();
      h.b(this.nhj).nnY.addAll((Collection)this.nhn);
      h.b(this.nhj).by(paramInt1, paramInt2);
      AppMethodBeat.o(246978);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/live/plugin/LiveCommentPlugin$updateComments$result$1", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    extends g.a
  {
    h(h paramh, List<com.tencent.mm.live.view.a.a> paramList) {}
    
    public final int If()
    {
      AppMethodBeat.i(246971);
      int i = h.b(this.nhj).nnY.size();
      AppMethodBeat.o(246971);
      return i;
    }
    
    public final int Ig()
    {
      AppMethodBeat.i(246977);
      int i = this.nhn.size();
      AppMethodBeat.o(246977);
      return i;
    }
    
    public final boolean aU(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(246986);
      boolean bool = kotlin.g.b.s.p(h.b(this.nhj).nnY.get(paramInt1), this.nhn.get(paramInt2));
      AppMethodBeat.o(246986);
      return bool;
    }
    
    public final boolean aV(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(246992);
      boolean bool = kotlin.g.b.s.p(h.b(this.nhj).nnY.get(paramInt1), this.nhn.get(paramInt2));
      AppMethodBeat.o(246992);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.h
 * JD-Core Version:    0.7.0.1
 */