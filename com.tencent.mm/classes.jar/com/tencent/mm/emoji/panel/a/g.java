package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.b;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.n;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.a.ab;
import com.tencent.mm.emoji.a.a.ag;
import com.tencent.mm.emoji.a.a.ai;
import com.tencent.mm.emoji.a.a.f;
import com.tencent.mm.emoji.a.a.s;
import com.tencent.mm.emoji.a.a.w;
import com.tencent.mm.emoji.a.a.x;
import com.tencent.mm.emoji.a.a.z;
import com.tencent.mm.emoji.panel.EmojiPanelRecyclerView;
import com.tencent.mm.emoji.panel.SmileyPanelView;
import com.tencent.mm.emoji.panel.layout.SmileyLayoutManager;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.vending.e.b;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter$AbsPanelGroupViewHolder;", "config", "Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "lifeCycle", "Lcom/tencent/mm/emoji/model/panel/PanelLifeCycle;", "(Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;Lcom/tencent/mm/emoji/model/panel/PanelLifeCycle;)V", "TAG", "", "clickListener", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "getClickListener", "()Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "setClickListener", "(Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "getConfig", "()Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "groupList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "Lkotlin/collections/ArrayList;", "groupModelList", "Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "getLifeCycle", "()Lcom/tencent/mm/emoji/model/panel/PanelLifeCycle;", "pool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "textOperationListener", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "getTextOperationListener", "()Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "setTextOperationListener", "(Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewRecycled", "updateData", "groups", "", "models", "AbsPanelGroupViewHolder", "Companion", "EmojiPanelGroupViewHolder", "SmileyPanelGroupViewHolder", "plugin-emojisdk_release"})
public final class g
  extends RecyclerView.a<a>
{
  public static final b fPY;
  private final String TAG;
  final com.tencent.mm.emoji.a.a.i fNC;
  public ChatFooterPanel.a fPD;
  public final ArrayList<EmojiGroupInfo> fPT;
  public final ArrayList<x<?>> fPU;
  private final RecyclerView.n fPV;
  public n fPW;
  final ab fPX;
  
  static
  {
    AppMethodBeat.i(105649);
    fPY = new b((byte)0);
    AppMethodBeat.o(105649);
  }
  
  public g(com.tencent.mm.emoji.a.a.i parami, ab paramab)
  {
    AppMethodBeat.i(193412);
    this.fNC = parami;
    this.fPX = paramab;
    this.TAG = "MicroMsg.EmojiPanelGroupAdapter";
    this.fPT = new ArrayList();
    this.fPU = new ArrayList();
    this.fPV = new RecyclerView.n();
    this.fPV.aB(0, 50);
    this.fPV.aB(1, 30);
    this.fPV.aB(2, 3);
    this.fPV.aB(3, 1);
    this.fPV.aB(4, 2);
    this.fPV.aB(5, 3);
    AppMethodBeat.o(193412);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(105645);
    int i = this.fPT.size();
    AppMethodBeat.o(105645);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(105643);
    Object localObject = this.fPT.get(paramInt);
    k.g(localObject, "groupList[position]");
    if (k.g(((EmojiGroupInfo)localObject).fZJ(), z.abS()))
    {
      AppMethodBeat.o(105643);
      return 1;
    }
    AppMethodBeat.o(105643);
    return 0;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter$AbsPanelGroupViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "sizeResolver", "Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "layoutManager", "Landroid/support/v7/widget/GridLayoutManager;", "(Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter;Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;Landroid/support/v7/widget/GridLayoutManager;)V", "adapter", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter;", "getAdapter", "()Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter;", "getLayoutManager", "()Landroid/support/v7/widget/GridLayoutManager;", "listener", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter$ListenerToAdapter;", "getListener", "()Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter$ListenerToAdapter;", "model", "Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "getModel", "()Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "setModel", "(Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;)V", "recycler", "Lcom/tencent/mm/emoji/panel/EmojiPanelRecyclerView;", "getRecycler", "()Lcom/tencent/mm/emoji/panel/EmojiPanelRecyclerView;", "sizeLookup", "Lcom/tencent/mm/emoji/panel/adapter/PanelSpanSizeLookup;", "getSizeLookup", "()Lcom/tencent/mm/emoji/panel/adapter/PanelSpanSizeLookup;", "getSizeResolver", "()Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "onBind", "", "groupModel", "onUnbind", "plugin-emojisdk_release"})
  public abstract class a
    extends RecyclerView.v
  {
    private final EmojiPanelRecyclerView fPZ;
    private final o fPt;
    private final h fQa;
    private final h.a fQb;
    private final p fQc;
    private x<?> fQd;
    private final GridLayoutManager fQe;
    
    public a(o paramo, GridLayoutManager paramGridLayoutManager)
    {
      super();
      this.fPt = paramGridLayoutManager;
      this.fQe = localObject;
      paramo = paramo.findViewById(2131299398);
      k.g(paramo, "itemView.findViewById(R.…oji_panel_group_recycler)");
      this.fPZ = ((EmojiPanelRecyclerView)paramo);
      this.fQa = new h();
      this.fQb = new h.a(this.fQa);
      this.fQc = new p((RecyclerView.a)this.fQa, this.fQe);
      this.fPZ.setRecycledViewPool(g.b(g.this));
      this.fPZ.setHasFixedSize(true);
      this.fPZ.setAdapter((RecyclerView.a)this.fQa);
      this.fPZ.setSizeResolver(this.fPt);
      this.fPZ.setPanelLifeCycle((b)g.this.fPX);
      this.fPZ.b((RecyclerView.h)new i(this.fPt));
      this.fQe.a((GridLayoutManager.b)this.fQc);
      this.fPZ.setLayoutManager((RecyclerView.i)this.fQe);
      this.fPZ.setFocusable(false);
      this.fPZ.setItemAnimator(null);
      this.fQa.fPW = g.this.fPW;
    }
    
    public void a(x<?> paramx)
    {
      k.h(paramx, "groupModel");
      ad.i(g.a(g.this), "onBind: " + paramx.abJ().abH().fZJ() + ' ' + paramx.abJ().getItemList().size());
      this.fQe.bV(this.fPt.aqI);
      this.fQa.ad(paramx.abJ().getItemList());
      if ((k.g(this.fQd, paramx) ^ true))
      {
        this.fQa.notifyDataSetChanged();
        this.fQd = paramx;
      }
      Object localObject = this.fQd;
      if (localObject != null) {
        ((x)localObject).a((w)this.fQb);
      }
      localObject = this.fPZ;
      k.h(paramx, "groupModel");
      if ((paramx instanceof ag))
      {
        paramx = ((EmojiPanelRecyclerView)localObject).getContext();
        k.g(paramx, "context");
        ((EmojiPanelRecyclerView)localObject).fPr = ((com.tencent.mm.view.popview.a)new com.tencent.mm.view.popview.d(paramx));
        return;
      }
      int i;
      if ((paramx instanceof f)) {
        i = 0;
      }
      for (;;)
      {
        ((EmojiPanelRecyclerView)localObject).setEmojiPopupType(i);
        return;
        if ((paramx instanceof com.tencent.mm.emoji.a.a.d)) {
          i = 1;
        } else if ((paramx instanceof ai)) {
          i = 2;
        } else {
          i = -1;
        }
      }
    }
    
    public void acd()
    {
      String str = g.a(g.this);
      StringBuilder localStringBuilder = new StringBuilder("onUnbind: ");
      Object localObject = this.fQd;
      if (localObject != null)
      {
        localObject = ((x)localObject).abJ();
        if (localObject != null)
        {
          localObject = ((s)localObject).abH();
          if (localObject == null) {}
        }
      }
      for (localObject = ((EmojiGroupInfo)localObject).fZJ();; localObject = null)
      {
        ad.i(str, (String)localObject);
        localObject = this.fQd;
        if (localObject != null) {
          ((x)localObject).a(null);
        }
        this.fQd = null;
        return;
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter$Companion;", "", "()V", "ViewTypeEmoji", "", "ViewTypeSmiley", "plugin-emojisdk_release"})
  public static final class b {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter$EmojiPanelGroupViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter$AbsPanelGroupViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter;Landroid/view/View;)V", "plugin-emojisdk_release"})
  public final class c
    extends g.a
  {
    public c()
    {
      super(localObject, localo, new GridLayoutManager(j.fQo.aqI));
      AppMethodBeat.i(105639);
      AppMethodBeat.o(105639);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter$SmileyPanelGroupViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter$AbsPanelGroupViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter;Landroid/view/View;)V", "smileyView", "Lcom/tencent/mm/emoji/panel/SmileyPanelView;", "getSmileyView", "()Lcom/tencent/mm/emoji/panel/SmileyPanelView;", "onBind", "", "groupModel", "Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "onUnbind", "plugin-emojisdk_release"})
  public final class d
    extends g.a
  {
    private final SmileyPanelView fQg;
    
    public d()
    {
      super((View)localObject, localo, (GridLayoutManager)new SmileyLayoutManager(localContext, v.fQI.aqI));
      AppMethodBeat.i(105642);
      Object localObject = ((View)localObject).findViewById(2131299404);
      k.g(localObject, "itemView.findViewById(R.…_panel_smiley_panel_view)");
      this.fQg = ((SmileyPanelView)localObject);
      this.fQg.setTextOperationListener(g.this.fPD);
      AppMethodBeat.o(105642);
    }
    
    public final void a(x<?> paramx)
    {
      AppMethodBeat.i(105640);
      k.h(paramx, "groupModel");
      super.a(paramx);
      paramx = this.fQg;
      com.tencent.mm.emoji.a.a.i locali = g.this.fNC;
      k.h(locali, "config");
      Object localObject = paramx.fNC;
      if (localObject != null) {
        ((com.tencent.mm.emoji.a.a.i)localObject).f(paramx.fPB);
      }
      paramx.fNC = locali;
      locali = paramx.fNC;
      if (locali != null)
      {
        localObject = paramx.fPB;
        k.h(localObject, "listener");
        locali.fNP.add(localObject);
      }
      paramx.fPB.invoke();
      AppMethodBeat.o(105640);
    }
    
    public final void acd()
    {
      AppMethodBeat.i(105641);
      super.acd();
      SmileyPanelView localSmileyPanelView = this.fQg;
      com.tencent.mm.emoji.a.a.i locali = localSmileyPanelView.fNC;
      if (locali != null)
      {
        locali.f(localSmileyPanelView.fPB);
        AppMethodBeat.o(105641);
        return;
      }
      AppMethodBeat.o(105641);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.g
 * JD-Core Version:    0.7.0.1
 */