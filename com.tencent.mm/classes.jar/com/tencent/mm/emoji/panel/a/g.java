package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.b;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.n;
import android.support.v7.widget.RecyclerView.w;
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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.vending.e.b;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter$AbsPanelGroupViewHolder;", "config", "Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "lifeCycle", "Lcom/tencent/mm/emoji/model/panel/PanelLifeCycle;", "(Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;Lcom/tencent/mm/emoji/model/panel/PanelLifeCycle;)V", "TAG", "", "clickListener", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "getClickListener", "()Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "setClickListener", "(Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "getConfig", "()Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "groupList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "Lkotlin/collections/ArrayList;", "groupModelList", "Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "getLifeCycle", "()Lcom/tencent/mm/emoji/model/panel/PanelLifeCycle;", "pool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "textOperationListener", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "getTextOperationListener", "()Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "setTextOperationListener", "(Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewRecycled", "updateData", "groups", "", "models", "AbsPanelGroupViewHolder", "Companion", "EmojiPanelGroupViewHolder", "SmileyPanelGroupViewHolder", "plugin-emojisdk_release"})
public final class g
  extends RecyclerView.a<a>
{
  public static final g.b fTT;
  private final String TAG;
  final com.tencent.mm.emoji.a.a.i fRn;
  public final ArrayList<EmojiGroupInfo> fTO;
  public final ArrayList<x<?>> fTP;
  private final RecyclerView.n fTQ;
  public n fTR;
  final ab fTS;
  public ChatFooterPanel.a fTy;
  
  static
  {
    AppMethodBeat.i(105649);
    fTT = new g.b((byte)0);
    AppMethodBeat.o(105649);
  }
  
  public g(com.tencent.mm.emoji.a.a.i parami, ab paramab)
  {
    AppMethodBeat.i(209863);
    this.fRn = parami;
    this.fTS = paramab;
    this.TAG = "MicroMsg.EmojiPanelGroupAdapter";
    this.fTO = new ArrayList();
    this.fTP = new ArrayList();
    this.fTQ = new RecyclerView.n();
    this.fTQ.aB(0, 50);
    this.fTQ.aB(1, 30);
    this.fTQ.aB(2, 3);
    this.fTQ.aB(3, 1);
    this.fTQ.aB(4, 2);
    this.fTQ.aB(5, 3);
    AppMethodBeat.o(209863);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(105645);
    int i = this.fTO.size();
    AppMethodBeat.o(105645);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(105643);
    Object localObject = this.fTO.get(paramInt);
    k.g(localObject, "groupList[position]");
    if (k.g(((EmojiGroupInfo)localObject).fdm(), z.acS()))
    {
      AppMethodBeat.o(105643);
      return 1;
    }
    AppMethodBeat.o(105643);
    return 0;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter$AbsPanelGroupViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "sizeResolver", "Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "layoutManager", "Landroid/support/v7/widget/GridLayoutManager;", "(Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter;Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;Landroid/support/v7/widget/GridLayoutManager;)V", "adapter", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter;", "getAdapter", "()Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter;", "getLayoutManager", "()Landroid/support/v7/widget/GridLayoutManager;", "listener", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter$ListenerToAdapter;", "getListener", "()Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter$ListenerToAdapter;", "model", "Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "getModel", "()Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "setModel", "(Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;)V", "recycler", "Lcom/tencent/mm/emoji/panel/EmojiPanelRecyclerView;", "getRecycler", "()Lcom/tencent/mm/emoji/panel/EmojiPanelRecyclerView;", "sizeLookup", "Lcom/tencent/mm/emoji/panel/adapter/PanelSpanSizeLookup;", "getSizeLookup", "()Lcom/tencent/mm/emoji/panel/adapter/PanelSpanSizeLookup;", "getSizeResolver", "()Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "onBind", "", "groupModel", "onUnbind", "plugin-emojisdk_release"})
  public abstract class a
    extends RecyclerView.w
  {
    private final EmojiPanelRecyclerView fTU;
    private final h fTV;
    private final h.a fTW;
    private final p fTX;
    private x<?> fTY;
    private final GridLayoutManager fTZ;
    private final o fTo;
    
    public a(o paramo, GridLayoutManager paramGridLayoutManager)
    {
      super();
      this.fTo = paramGridLayoutManager;
      this.fTZ = localObject;
      paramo = paramo.findViewById(2131299398);
      k.g(paramo, "itemView.findViewById(R.…oji_panel_group_recycler)");
      this.fTU = ((EmojiPanelRecyclerView)paramo);
      this.fTV = new h();
      this.fTW = new h.a(this.fTV);
      this.fTX = new p((RecyclerView.a)this.fTV, this.fTZ);
      this.fTU.setRecycledViewPool(g.b(g.this));
      this.fTU.setHasFixedSize(true);
      this.fTU.setAdapter((RecyclerView.a)this.fTV);
      this.fTU.setSizeResolver(this.fTo);
      this.fTU.setPanelLifeCycle((b)g.this.fTS);
      this.fTU.b((RecyclerView.h)new i(this.fTo));
      this.fTZ.a((GridLayoutManager.b)this.fTX);
      this.fTU.setLayoutManager((RecyclerView.i)this.fTZ);
      this.fTU.setFocusable(false);
      this.fTU.setItemAnimator(null);
      this.fTV.fTR = g.this.fTR;
    }
    
    public void a(x<?> paramx)
    {
      k.h(paramx, "groupModel");
      ac.i(g.a(g.this), "onBind: " + paramx.acJ().acG().fdm() + ' ' + paramx.acJ().acH().size());
      this.fTZ.bV(this.fTo.arE);
      this.fTV.U(paramx.acJ().acH());
      if ((k.g(this.fTY, paramx) ^ true))
      {
        this.fTV.notifyDataSetChanged();
        this.fTY = paramx;
      }
      Object localObject = this.fTY;
      if (localObject != null) {
        ((x)localObject).a((w)this.fTW);
      }
      localObject = this.fTU;
      k.h(paramx, "groupModel");
      if ((paramx instanceof ag))
      {
        paramx = ((EmojiPanelRecyclerView)localObject).getContext();
        k.g(paramx, "context");
        ((EmojiPanelRecyclerView)localObject).fTm = ((com.tencent.mm.view.popview.a)new com.tencent.mm.view.popview.d(paramx));
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
    
    public void adj()
    {
      String str = g.a(g.this);
      StringBuilder localStringBuilder = new StringBuilder("onUnbind: ");
      Object localObject = this.fTY;
      if (localObject != null)
      {
        localObject = ((x)localObject).acJ();
        if (localObject != null)
        {
          localObject = ((s)localObject).acG();
          if (localObject == null) {}
        }
      }
      for (localObject = ((EmojiGroupInfo)localObject).fdm();; localObject = null)
      {
        ac.i(str, (String)localObject);
        localObject = this.fTY;
        if (localObject != null) {
          ((x)localObject).a(null);
        }
        this.fTY = null;
        return;
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter$EmojiPanelGroupViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter$AbsPanelGroupViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter;Landroid/view/View;)V", "plugin-emojisdk_release"})
  public final class c
    extends g.a
  {
    public c()
    {
      super(localObject, localo, new GridLayoutManager(j.fUj.arE));
      AppMethodBeat.i(105639);
      AppMethodBeat.o(105639);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter$SmileyPanelGroupViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter$AbsPanelGroupViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter;Landroid/view/View;)V", "smileyView", "Lcom/tencent/mm/emoji/panel/SmileyPanelView;", "getSmileyView", "()Lcom/tencent/mm/emoji/panel/SmileyPanelView;", "onBind", "", "groupModel", "Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "onUnbind", "plugin-emojisdk_release"})
  public final class d
    extends g.a
  {
    private final SmileyPanelView fUb;
    
    public d()
    {
      super((View)localObject, localo, (GridLayoutManager)new SmileyLayoutManager(localContext, v.fUD.arE));
      AppMethodBeat.i(105642);
      Object localObject = ((View)localObject).findViewById(2131299404);
      k.g(localObject, "itemView.findViewById(R.…_panel_smiley_panel_view)");
      this.fUb = ((SmileyPanelView)localObject);
      this.fUb.setTextOperationListener(g.this.fTy);
      AppMethodBeat.o(105642);
    }
    
    public final void a(x<?> paramx)
    {
      AppMethodBeat.i(105640);
      k.h(paramx, "groupModel");
      super.a(paramx);
      paramx = this.fUb;
      com.tencent.mm.emoji.a.a.i locali = g.this.fRn;
      k.h(locali, "config");
      Object localObject = paramx.fRn;
      if (localObject != null) {
        ((com.tencent.mm.emoji.a.a.i)localObject).f(paramx.fTw);
      }
      paramx.fRn = locali;
      locali = paramx.fRn;
      if (locali != null)
      {
        localObject = paramx.fTw;
        k.h(localObject, "listener");
        locali.fRA.add(localObject);
      }
      paramx.fTw.invoke();
      AppMethodBeat.o(105640);
    }
    
    public final void adj()
    {
      AppMethodBeat.i(105641);
      super.adj();
      SmileyPanelView localSmileyPanelView = this.fUb;
      com.tencent.mm.emoji.a.a.i locali = localSmileyPanelView.fRn;
      if (locali != null)
      {
        locali.f(localSmileyPanelView.fTw);
        AppMethodBeat.o(105641);
        return;
      }
      AppMethodBeat.o(105641);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.g
 * JD-Core Version:    0.7.0.1
 */