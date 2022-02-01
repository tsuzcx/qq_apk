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
import com.tencent.mm.emoji.a.a.aa;
import com.tencent.mm.emoji.a.a.ab;
import com.tencent.mm.emoji.a.a.af;
import com.tencent.mm.emoji.a.a.ak;
import com.tencent.mm.emoji.a.a.am;
import com.tencent.mm.emoji.a.a.f;
import com.tencent.mm.emoji.a.a.w;
import com.tencent.mm.emoji.panel.EmojiPanelRecyclerView;
import com.tencent.mm.emoji.panel.SmileyPanelView;
import com.tencent.mm.emoji.panel.layout.SmileyLayoutManager;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.vending.e.b;
import d.l;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter$AbsPanelGroupViewHolder;", "config", "Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "lifeCycle", "Lcom/tencent/mm/emoji/model/panel/PanelLifeCycle;", "(Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;Lcom/tencent/mm/emoji/model/panel/PanelLifeCycle;)V", "TAG", "", "clickListener", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "getClickListener", "()Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "setClickListener", "(Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "getConfig", "()Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "groupList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "Lkotlin/collections/ArrayList;", "groupModelList", "Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "getLifeCycle", "()Lcom/tencent/mm/emoji/model/panel/PanelLifeCycle;", "pool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "textOperationListener", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "getTextOperationListener", "()Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "setTextOperationListener", "(Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewRecycled", "updateData", "groups", "", "models", "AbsPanelGroupViewHolder", "Companion", "EmojiPanelGroupViewHolder", "SmileyPanelGroupViewHolder", "plugin-emojisdk_release"})
public final class g
  extends RecyclerView.a<a>
{
  public static final g.b gnx;
  private final String TAG;
  final com.tencent.mm.emoji.a.a.i gkN;
  public ChatFooterPanel.a gnc;
  public final ArrayList<EmojiGroupInfo> gns;
  public final ArrayList<ab<?>> gnt;
  private final RecyclerView.n gnu;
  public n gnv;
  final af gnw;
  
  static
  {
    AppMethodBeat.i(105649);
    gnx = new g.b((byte)0);
    AppMethodBeat.o(105649);
  }
  
  public g(com.tencent.mm.emoji.a.a.i parami, af paramaf)
  {
    AppMethodBeat.i(218988);
    this.gkN = parami;
    this.gnw = paramaf;
    this.TAG = "MicroMsg.EmojiPanelGroupAdapter";
    this.gns = new ArrayList();
    this.gnt = new ArrayList();
    this.gnu = new RecyclerView.n();
    this.gnu.aC(0, 50);
    this.gnu.aC(1, 30);
    this.gnu.aC(2, 3);
    this.gnu.aC(3, 1);
    this.gnu.aC(4, 2);
    this.gnu.aC(5, 3);
    AppMethodBeat.o(218988);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(105645);
    int i = this.gns.size();
    AppMethodBeat.o(105645);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(105643);
    Object localObject = this.gns.get(paramInt);
    d.g.b.p.g(localObject, "groupList[position]");
    if (d.g.b.p.i(((EmojiGroupInfo)localObject).fxi(), com.tencent.mm.emoji.a.a.ad.afz()))
    {
      AppMethodBeat.o(105643);
      return 1;
    }
    AppMethodBeat.o(105643);
    return 0;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter$AbsPanelGroupViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "sizeResolver", "Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "layoutManager", "Landroid/support/v7/widget/GridLayoutManager;", "(Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter;Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;Landroid/support/v7/widget/GridLayoutManager;)V", "adapter", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter;", "getAdapter", "()Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter;", "getLayoutManager", "()Landroid/support/v7/widget/GridLayoutManager;", "listener", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter$ListenerToAdapter;", "getListener", "()Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter$ListenerToAdapter;", "model", "Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "getModel", "()Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "setModel", "(Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;)V", "recycler", "Lcom/tencent/mm/emoji/panel/EmojiPanelRecyclerView;", "getRecycler", "()Lcom/tencent/mm/emoji/panel/EmojiPanelRecyclerView;", "sizeLookup", "Lcom/tencent/mm/emoji/panel/adapter/PanelSpanSizeLookup;", "getSizeLookup", "()Lcom/tencent/mm/emoji/panel/adapter/PanelSpanSizeLookup;", "getSizeResolver", "()Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "onBind", "", "groupModel", "onUnbind", "plugin-emojisdk_release"})
  public abstract class a
    extends RecyclerView.w
  {
    private final o gmS;
    private final h.a gnA;
    private final p gnB;
    private ab<?> gnC;
    private final GridLayoutManager gnD;
    private final EmojiPanelRecyclerView gny;
    private final h gnz;
    
    public a(o paramo, GridLayoutManager paramGridLayoutManager)
    {
      super();
      this.gmS = paramGridLayoutManager;
      this.gnD = localObject;
      paramo = paramo.findViewById(2131299398);
      d.g.b.p.g(paramo, "itemView.findViewById(R.…oji_panel_group_recycler)");
      this.gny = ((EmojiPanelRecyclerView)paramo);
      this.gnz = new h();
      this.gnA = new h.a(this.gnz);
      this.gnB = new p((RecyclerView.a)this.gnz, this.gnD);
      this.gny.setRecycledViewPool(g.b(g.this));
      this.gny.setHasFixedSize(true);
      this.gny.setAdapter((RecyclerView.a)this.gnz);
      this.gny.setSizeResolver(this.gmS);
      this.gny.setPanelLifeCycle((b)g.this.gnw);
      this.gny.b((RecyclerView.h)new i(this.gmS));
      this.gnD.a((GridLayoutManager.b)this.gnB);
      this.gny.setLayoutManager((RecyclerView.i)this.gnD);
      this.gny.setFocusable(false);
      this.gny.setItemAnimator(null);
      this.gnz.gnv = g.this.gnv;
    }
    
    public void a(ab<?> paramab)
    {
      d.g.b.p.h(paramab, "groupModel");
      com.tencent.mm.sdk.platformtools.ad.i(g.a(g.this), "onBind: " + paramab.afn().afk().fxi() + ' ' + paramab.afn().afl().size());
      this.gnD.bV(this.gmS.atv);
      this.gnz.V(paramab.afn().afl());
      this.gnz.notifyDataSetChanged();
      if ((d.g.b.p.i(this.gnC, paramab) ^ true))
      {
        localObject = this.gnC;
        if (localObject != null) {
          ((ab)localObject).a(null);
        }
        this.gnC = paramab;
      }
      Object localObject = this.gnC;
      if (localObject != null) {
        ((ab)localObject).a((aa)this.gnA);
      }
      localObject = this.gny;
      d.g.b.p.h(paramab, "groupModel");
      if ((paramab instanceof ak))
      {
        paramab = ((EmojiPanelRecyclerView)localObject).getContext();
        d.g.b.p.g(paramab, "context");
        ((EmojiPanelRecyclerView)localObject).gmQ = ((com.tencent.mm.view.popview.a)new com.tencent.mm.view.popview.d(paramab));
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
        if ((paramab instanceof com.tencent.mm.emoji.a.a.d)) {
          i = 1;
        } else if ((paramab instanceof am)) {
          i = 2;
        } else {
          i = -1;
        }
      }
    }
    
    public void afP()
    {
      String str = g.a(g.this);
      StringBuilder localStringBuilder = new StringBuilder("onUnbind: ");
      Object localObject = this.gnC;
      if (localObject != null)
      {
        localObject = ((ab)localObject).afn();
        if (localObject != null)
        {
          localObject = ((w)localObject).afk();
          if (localObject == null) {}
        }
      }
      for (localObject = ((EmojiGroupInfo)localObject).fxi();; localObject = null)
      {
        com.tencent.mm.sdk.platformtools.ad.i(str, (String)localObject);
        localObject = this.gnC;
        if (localObject != null) {
          ((ab)localObject).a(null);
        }
        this.gnC = null;
        return;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter$EmojiPanelGroupViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter$AbsPanelGroupViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter;Landroid/view/View;)V", "plugin-emojisdk_release"})
  public final class c
    extends g.a
  {
    public c()
    {
      super(localObject, localo, new GridLayoutManager(j.gnL.atv));
      AppMethodBeat.i(105639);
      AppMethodBeat.o(105639);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter$SmileyPanelGroupViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter$AbsPanelGroupViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter;Landroid/view/View;)V", "smileyView", "Lcom/tencent/mm/emoji/panel/SmileyPanelView;", "getSmileyView", "()Lcom/tencent/mm/emoji/panel/SmileyPanelView;", "onBind", "", "groupModel", "Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "onUnbind", "plugin-emojisdk_release"})
  public final class d
    extends g.a
  {
    private final SmileyPanelView gnF;
    
    public d()
    {
      super((View)localObject, localo, (GridLayoutManager)new SmileyLayoutManager(localContext, v.gof.atv));
      AppMethodBeat.i(105642);
      Object localObject = ((View)localObject).findViewById(2131299404);
      d.g.b.p.g(localObject, "itemView.findViewById(R.…_panel_smiley_panel_view)");
      this.gnF = ((SmileyPanelView)localObject);
      this.gnF.setTextOperationListener(g.this.gnc);
      AppMethodBeat.o(105642);
    }
    
    public final void a(ab<?> paramab)
    {
      AppMethodBeat.i(105640);
      d.g.b.p.h(paramab, "groupModel");
      super.a(paramab);
      paramab = this.gnF;
      com.tencent.mm.emoji.a.a.i locali = g.this.gkN;
      d.g.b.p.h(locali, "config");
      Object localObject = paramab.gkN;
      if (localObject != null) {
        ((com.tencent.mm.emoji.a.a.i)localObject).f(paramab.gna);
      }
      paramab.gkN = locali;
      locali = paramab.gkN;
      if (locali != null)
      {
        localObject = paramab.gna;
        d.g.b.p.h(localObject, "listener");
        locali.gla.add(localObject);
      }
      paramab.gna.invoke();
      AppMethodBeat.o(105640);
    }
    
    public final void afP()
    {
      AppMethodBeat.i(105641);
      super.afP();
      SmileyPanelView localSmileyPanelView = this.gnF;
      com.tencent.mm.emoji.a.a.i locali = localSmileyPanelView.gkN;
      if (locali != null)
      {
        locali.f(localSmileyPanelView.gna);
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