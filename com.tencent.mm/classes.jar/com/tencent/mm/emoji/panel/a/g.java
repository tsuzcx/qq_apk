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
import com.tencent.mm.emoji.a.b.aa;
import com.tencent.mm.emoji.a.b.ab;
import com.tencent.mm.emoji.a.b.ad;
import com.tencent.mm.emoji.a.b.af;
import com.tencent.mm.emoji.a.b.ak;
import com.tencent.mm.emoji.a.b.am;
import com.tencent.mm.emoji.a.b.f;
import com.tencent.mm.emoji.a.b.w;
import com.tencent.mm.emoji.panel.EmojiPanelRecyclerView;
import com.tencent.mm.emoji.panel.SmileyPanelView;
import com.tencent.mm.emoji.panel.layout.SmileyLayoutManager;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.vending.e.b;
import d.l;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter$AbsPanelGroupViewHolder;", "config", "Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "lifeCycle", "Lcom/tencent/mm/emoji/model/panel/PanelLifeCycle;", "(Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;Lcom/tencent/mm/emoji/model/panel/PanelLifeCycle;)V", "TAG", "", "clickListener", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "getClickListener", "()Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "setClickListener", "(Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "getConfig", "()Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "groupList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "Lkotlin/collections/ArrayList;", "groupModelList", "Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "getLifeCycle", "()Lcom/tencent/mm/emoji/model/panel/PanelLifeCycle;", "pool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "textOperationListener", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "getTextOperationListener", "()Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "setTextOperationListener", "(Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewRecycled", "updateData", "groups", "", "models", "AbsPanelGroupViewHolder", "Companion", "EmojiPanelGroupViewHolder", "SmileyPanelGroupViewHolder", "plugin-emojisdk_release"})
public final class g
  extends RecyclerView.a<a>
{
  public static final g.b gpT;
  private final String TAG;
  final com.tencent.mm.emoji.a.b.i gni;
  public final ArrayList<EmojiGroupInfo> gpO;
  public final ArrayList<ab<?>> gpP;
  private final RecyclerView.n gpQ;
  public n gpR;
  final af gpS;
  public ChatFooterPanel.a gpy;
  
  static
  {
    AppMethodBeat.i(105649);
    gpT = new g.b((byte)0);
    AppMethodBeat.o(105649);
  }
  
  public g(com.tencent.mm.emoji.a.b.i parami, af paramaf)
  {
    AppMethodBeat.i(188602);
    this.gni = parami;
    this.gpS = paramaf;
    this.TAG = "MicroMsg.EmojiPanelGroupAdapter";
    this.gpO = new ArrayList();
    this.gpP = new ArrayList();
    this.gpQ = new RecyclerView.n();
    this.gpQ.aC(0, 50);
    this.gpQ.aC(1, 30);
    this.gpQ.aC(2, 3);
    this.gpQ.aC(3, 1);
    this.gpQ.aC(4, 2);
    this.gpQ.aC(5, 3);
    AppMethodBeat.o(188602);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(105645);
    int i = this.gpO.size();
    AppMethodBeat.o(105645);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(105643);
    Object localObject = this.gpO.get(paramInt);
    d.g.b.p.g(localObject, "groupList[position]");
    if (d.g.b.p.i(((EmojiGroupInfo)localObject).fxk(), ad.afN()))
    {
      AppMethodBeat.o(105643);
      return 1;
    }
    AppMethodBeat.o(105643);
    return 0;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter$AbsPanelGroupViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "sizeResolver", "Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "layoutManager", "Landroid/support/v7/widget/GridLayoutManager;", "(Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter;Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;Landroid/support/v7/widget/GridLayoutManager;)V", "adapter", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter;", "getAdapter", "()Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter;", "getLayoutManager", "()Landroid/support/v7/widget/GridLayoutManager;", "listener", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter$ListenerToAdapter;", "getListener", "()Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter$ListenerToAdapter;", "model", "Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "getModel", "()Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "setModel", "(Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;)V", "recycler", "Lcom/tencent/mm/emoji/panel/EmojiPanelRecyclerView;", "getRecycler", "()Lcom/tencent/mm/emoji/panel/EmojiPanelRecyclerView;", "sizeLookup", "Lcom/tencent/mm/emoji/panel/adapter/PanelSpanSizeLookup;", "getSizeLookup", "()Lcom/tencent/mm/emoji/panel/adapter/PanelSpanSizeLookup;", "getSizeResolver", "()Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "onBind", "", "groupModel", "onUnbind", "plugin-emojisdk_release"})
  public abstract class a
    extends RecyclerView.w
  {
    private final EmojiPanelRecyclerView gpU;
    private final h gpV;
    private final h.a gpW;
    private final p gpX;
    private ab<?> gpY;
    private final GridLayoutManager gpZ;
    private final o gpo;
    
    public a(o paramo, GridLayoutManager paramGridLayoutManager)
    {
      super();
      this.gpo = paramGridLayoutManager;
      this.gpZ = localObject;
      paramo = paramo.findViewById(2131299398);
      d.g.b.p.g(paramo, "itemView.findViewById(R.…oji_panel_group_recycler)");
      this.gpU = ((EmojiPanelRecyclerView)paramo);
      this.gpV = new h();
      this.gpW = new h.a(this.gpV);
      this.gpX = new p((RecyclerView.a)this.gpV, this.gpZ);
      this.gpU.setRecycledViewPool(g.b(g.this));
      this.gpU.setHasFixedSize(true);
      this.gpU.setAdapter((RecyclerView.a)this.gpV);
      this.gpU.setSizeResolver(this.gpo);
      this.gpU.setPanelLifeCycle((b)g.this.gpS);
      this.gpU.b((RecyclerView.h)new i(this.gpo));
      this.gpZ.a((GridLayoutManager.b)this.gpX);
      this.gpU.setLayoutManager((RecyclerView.i)this.gpZ);
      this.gpU.setFocusable(false);
      this.gpU.setItemAnimator(null);
      this.gpV.gpR = g.this.gpR;
    }
    
    public void a(ab<?> paramab)
    {
      d.g.b.p.h(paramab, "groupModel");
      ae.i(g.a(g.this), "onBind: " + paramab.afB().afy().fxk() + ' ' + paramab.afB().afz().size());
      this.gpZ.bV(this.gpo.atv);
      this.gpV.V(paramab.afB().afz());
      this.gpV.notifyDataSetChanged();
      if ((d.g.b.p.i(this.gpY, paramab) ^ true))
      {
        localObject = this.gpY;
        if (localObject != null) {
          ((ab)localObject).a(null);
        }
        this.gpY = paramab;
      }
      Object localObject = this.gpY;
      if (localObject != null) {
        ((ab)localObject).a((aa)this.gpW);
      }
      localObject = this.gpU;
      d.g.b.p.h(paramab, "groupModel");
      if ((paramab instanceof ak))
      {
        paramab = ((EmojiPanelRecyclerView)localObject).getContext();
        d.g.b.p.g(paramab, "context");
        ((EmojiPanelRecyclerView)localObject).gpm = ((com.tencent.mm.view.popview.a)new com.tencent.mm.view.popview.d(paramab));
        return;
      }
      int i;
      if ((paramab instanceof f)) {
        i = 0;
      }
      for (;;)
      {
        ((EmojiPanelRecyclerView)localObject).setEmojiPopupType(i);
        return;
        if ((paramab instanceof com.tencent.mm.emoji.a.b.d)) {
          i = 1;
        } else if ((paramab instanceof am)) {
          i = 2;
        } else {
          i = -1;
        }
      }
    }
    
    public void agd()
    {
      String str = g.a(g.this);
      StringBuilder localStringBuilder = new StringBuilder("onUnbind: ");
      Object localObject = this.gpY;
      if (localObject != null)
      {
        localObject = ((ab)localObject).afB();
        if (localObject != null)
        {
          localObject = ((w)localObject).afy();
          if (localObject == null) {}
        }
      }
      for (localObject = ((EmojiGroupInfo)localObject).fxk();; localObject = null)
      {
        ae.i(str, (String)localObject);
        localObject = this.gpY;
        if (localObject != null) {
          ((ab)localObject).a(null);
        }
        this.gpY = null;
        return;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter$EmojiPanelGroupViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter$AbsPanelGroupViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter;Landroid/view/View;)V", "plugin-emojisdk_release"})
  public final class c
    extends g.a
  {
    public c()
    {
      super(localObject, localo, new GridLayoutManager(j.gqh.atv));
      AppMethodBeat.i(105639);
      AppMethodBeat.o(105639);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter$SmileyPanelGroupViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter$AbsPanelGroupViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter;Landroid/view/View;)V", "smileyView", "Lcom/tencent/mm/emoji/panel/SmileyPanelView;", "getSmileyView", "()Lcom/tencent/mm/emoji/panel/SmileyPanelView;", "onBind", "", "groupModel", "Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "onUnbind", "plugin-emojisdk_release"})
  public final class d
    extends g.a
  {
    private final SmileyPanelView gqb;
    
    public d()
    {
      super((View)localObject, localo, (GridLayoutManager)new SmileyLayoutManager(localContext, v.gqB.atv));
      AppMethodBeat.i(105642);
      Object localObject = ((View)localObject).findViewById(2131299404);
      d.g.b.p.g(localObject, "itemView.findViewById(R.…_panel_smiley_panel_view)");
      this.gqb = ((SmileyPanelView)localObject);
      this.gqb.setTextOperationListener(g.this.gpy);
      AppMethodBeat.o(105642);
    }
    
    public final void a(ab<?> paramab)
    {
      AppMethodBeat.i(105640);
      d.g.b.p.h(paramab, "groupModel");
      super.a(paramab);
      paramab = this.gqb;
      com.tencent.mm.emoji.a.b.i locali = g.this.gni;
      d.g.b.p.h(locali, "config");
      Object localObject = paramab.gni;
      if (localObject != null) {
        ((com.tencent.mm.emoji.a.b.i)localObject).g(paramab.gpw);
      }
      paramab.gni = locali;
      locali = paramab.gni;
      if (locali != null)
      {
        localObject = paramab.gpw;
        d.g.b.p.h(localObject, "listener");
        locali.gnv.add(localObject);
      }
      paramab.gpw.invoke();
      AppMethodBeat.o(105640);
    }
    
    public final void agd()
    {
      AppMethodBeat.i(105641);
      super.agd();
      SmileyPanelView localSmileyPanelView = this.gqb;
      com.tencent.mm.emoji.a.b.i locali = localSmileyPanelView.gni;
      if (locali != null)
      {
        locali.g(localSmileyPanelView.gpw);
        AppMethodBeat.o(105641);
        return;
      }
      AppMethodBeat.o(105641);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.g
 * JD-Core Version:    0.7.0.1
 */