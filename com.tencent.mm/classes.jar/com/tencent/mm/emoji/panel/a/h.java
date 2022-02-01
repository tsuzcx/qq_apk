package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager.b;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.m;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.ac;
import com.tencent.mm.emoji.b.b.ad;
import com.tencent.mm.emoji.b.b.af;
import com.tencent.mm.emoji.b.b.ah;
import com.tencent.mm.emoji.b.b.am;
import com.tencent.mm.emoji.b.b.ao;
import com.tencent.mm.emoji.b.b.f;
import com.tencent.mm.emoji.b.b.y;
import com.tencent.mm.emoji.panel.EmojiPanelRecyclerView;
import com.tencent.mm.emoji.panel.SmileyPanelView;
import com.tencent.mm.emoji.panel.layout.SmileyLayoutManager;
import com.tencent.mm.plugin.m.a.g;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.vending.e.b;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter$AbsPanelGroupViewHolder;", "config", "Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "lifeCycle", "Lcom/tencent/mm/emoji/model/panel/PanelLifeCycle;", "smileyItemSize", "Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "emojiItemSize", "(Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;Lcom/tencent/mm/emoji/model/panel/PanelLifeCycle;Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;)V", "TAG", "", "clickListener", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "getClickListener", "()Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "setClickListener", "(Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "getConfig", "()Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "groupList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "Lkotlin/collections/ArrayList;", "groupModelList", "Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "getLifeCycle", "()Lcom/tencent/mm/emoji/model/panel/PanelLifeCycle;", "pool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "textOperationListener", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "getTextOperationListener", "()Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "setTextOperationListener", "(Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewRecycled", "updateData", "groups", "", "models", "AbsPanelGroupViewHolder", "Companion", "EmojiPanelGroupViewHolder", "SmileyPanelGroupViewHolder", "plugin-emojisdk_release"})
public final class h
  extends RecyclerView.a<a>
{
  public static final b jLT;
  private final String TAG;
  final com.tencent.mm.emoji.b.b.i jJa;
  public final ArrayList<EmojiGroupInfo> jLM;
  public final ArrayList<ad<?>> jLN;
  private final RecyclerView.m jLO;
  public p jLP;
  final ah jLQ;
  private final q jLR;
  private final q jLS;
  public ChatFooterPanel.a jLs;
  
  static
  {
    AppMethodBeat.i(105649);
    jLT = new b((byte)0);
    AppMethodBeat.o(105649);
  }
  
  public h(com.tencent.mm.emoji.b.b.i parami, ah paramah, q paramq1, q paramq2)
  {
    AppMethodBeat.i(230683);
    this.jJa = parami;
    this.jLQ = paramah;
    this.jLR = paramq1;
    this.jLS = paramq2;
    this.TAG = "MicroMsg.EmojiPanelGroupAdapter";
    this.jLM = new ArrayList();
    this.jLN = new ArrayList();
    this.jLO = new RecyclerView.m();
    this.jLO.aJ(0, 50);
    this.jLO.aJ(1, 30);
    this.jLO.aJ(2, 3);
    this.jLO.aJ(3, 1);
    this.jLO.aJ(4, 2);
    this.jLO.aJ(5, 3);
    AppMethodBeat.o(230683);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(105645);
    int i = this.jLM.size();
    AppMethodBeat.o(105645);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(105643);
    Object localObject = this.jLM.get(paramInt);
    kotlin.g.b.p.j(localObject, "groupList[position]");
    if (kotlin.g.b.p.h(((EmojiGroupInfo)localObject).hBl(), af.aCw()))
    {
      AppMethodBeat.o(105643);
      return 1;
    }
    AppMethodBeat.o(105643);
    return 0;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter$AbsPanelGroupViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "sizeResolver", "Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "layoutManager", "Landroidx/recyclerview/widget/GridLayoutManager;", "(Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter;Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;Landroidx/recyclerview/widget/GridLayoutManager;)V", "adapter", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter;", "getAdapter", "()Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter;", "getLayoutManager", "()Landroidx/recyclerview/widget/GridLayoutManager;", "listener", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter$ListenerToAdapter;", "getListener", "()Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter$ListenerToAdapter;", "model", "Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "getModel", "()Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "setModel", "(Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;)V", "recycler", "Lcom/tencent/mm/emoji/panel/EmojiPanelRecyclerView;", "getRecycler", "()Lcom/tencent/mm/emoji/panel/EmojiPanelRecyclerView;", "sizeLookup", "Lcom/tencent/mm/emoji/panel/adapter/PanelSpanSizeLookup;", "getSizeLookup", "()Lcom/tencent/mm/emoji/panel/adapter/PanelSpanSizeLookup;", "getSizeResolver", "()Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "onBind", "", "groupModel", "onUnbind", "plugin-emojisdk_release"})
  public abstract class a
    extends RecyclerView.v
  {
    private final EmojiPanelRecyclerView jLU;
    private final i jLV;
    private final i.a jLW;
    private final r jLX;
    private ad<?> jLY;
    private final GridLayoutManager jLZ;
    private final q jLi;
    
    public a(q paramq, GridLayoutManager paramGridLayoutManager)
    {
      super();
      this.jLi = paramGridLayoutManager;
      this.jLZ = localObject;
      paramq = paramq.findViewById(a.g.emoji_panel_group_recycler);
      kotlin.g.b.p.j(paramq, "itemView.findViewById(R.…oji_panel_group_recycler)");
      this.jLU = ((EmojiPanelRecyclerView)paramq);
      this.jLV = new i();
      this.jLW = new i.a(this.jLV);
      this.jLX = new r((RecyclerView.a)this.jLV, this.jLZ);
      this.jLU.setRecycledViewPool(h.b(h.this));
      this.jLU.setHasFixedSize(true);
      this.jLU.setAdapter((RecyclerView.a)this.jLV);
      this.jLU.setSizeResolver(this.jLi);
      this.jLU.setPanelLifeCycle((b)h.this.jLQ);
      this.jLU.b((RecyclerView.h)new j(this.jLi));
      this.jLZ.a((GridLayoutManager.b)this.jLX);
      this.jLU.setLayoutManager((RecyclerView.LayoutManager)this.jLZ);
      this.jLU.setFocusable(false);
      this.jLU.setItemAnimator(null);
      this.jLV.jLP = h.this.jLP;
    }
    
    public void a(ad<?> paramad)
    {
      kotlin.g.b.p.k(paramad, "groupModel");
      Log.i(h.a(h.this), "onBind: " + paramad.aCk().aCi().hBl() + ' ' + paramad.aCk().aCj().size());
      this.jLZ.cw(this.jLi.spanCount);
      this.jLV.aa(paramad.aCk().aCj());
      this.jLV.notifyDataSetChanged();
      if ((kotlin.g.b.p.h(this.jLY, paramad) ^ true))
      {
        localObject = this.jLY;
        if (localObject != null) {
          ((ad)localObject).a(null);
        }
        this.jLY = paramad;
      }
      Object localObject = this.jLY;
      if (localObject != null) {
        ((ad)localObject).a((ac)this.jLW);
      }
      localObject = this.jLU;
      kotlin.g.b.p.k(paramad, "groupModel");
      if ((paramad instanceof am))
      {
        paramad = ((EmojiPanelRecyclerView)localObject).getContext();
        kotlin.g.b.p.j(paramad, "context");
        ((EmojiPanelRecyclerView)localObject).jLg = ((com.tencent.mm.view.popview.a)new com.tencent.mm.view.popview.d(paramad));
        return;
      }
      int i;
      if ((paramad instanceof f)) {
        i = 0;
      }
      for (;;)
      {
        ((EmojiPanelRecyclerView)localObject).setEmojiPopupType(i);
        return;
        if ((paramad instanceof com.tencent.mm.emoji.b.b.d)) {
          i = 1;
        } else if ((paramad instanceof ao)) {
          i = 2;
        } else {
          i = -1;
        }
      }
    }
    
    public void aCO()
    {
      String str = h.a(h.this);
      StringBuilder localStringBuilder = new StringBuilder("onUnbind: ");
      Object localObject = this.jLY;
      if (localObject != null)
      {
        localObject = ((ad)localObject).aCk();
        if (localObject != null)
        {
          localObject = ((y)localObject).aCi();
          if (localObject == null) {}
        }
      }
      for (localObject = ((EmojiGroupInfo)localObject).hBl();; localObject = null)
      {
        Log.i(str, (String)localObject);
        localObject = this.jLY;
        if (localObject != null) {
          ((ad)localObject).a(null);
        }
        this.jLY = null;
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter$Companion;", "", "()V", "ViewTypeEmoji", "", "ViewTypeSmiley", "plugin-emojisdk_release"})
  public static final class b {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter$EmojiPanelGroupViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter$AbsPanelGroupViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter;Landroid/view/View;)V", "plugin-emojisdk_release"})
  public final class c
    extends h.a
  {
    public c()
    {
      super(localObject, localq, new GridLayoutManager(h.c(h.this).spanCount));
      AppMethodBeat.i(105639);
      AppMethodBeat.o(105639);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter$SmileyPanelGroupViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter$AbsPanelGroupViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter;Landroid/view/View;)V", "smileyView", "Lcom/tencent/mm/emoji/panel/SmileyPanelView;", "getSmileyView", "()Lcom/tencent/mm/emoji/panel/SmileyPanelView;", "onBind", "", "groupModel", "Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "onUnbind", "plugin-emojisdk_release"})
  public final class d
    extends h.a
  {
    private final SmileyPanelView jMb;
    
    public d()
    {
      super((View)localObject, localq, (GridLayoutManager)new SmileyLayoutManager(localContext, h.d(h.this).spanCount));
      AppMethodBeat.i(105642);
      Object localObject = ((View)localObject).findViewById(a.g.emoji_panel_smiley_panel_view);
      kotlin.g.b.p.j(localObject, "itemView.findViewById(R.…_panel_smiley_panel_view)");
      this.jMb = ((SmileyPanelView)localObject);
      this.jMb.setTextOperationListener(h.this.jLs);
      AppMethodBeat.o(105642);
    }
    
    public final void a(ad<?> paramad)
    {
      AppMethodBeat.i(105640);
      kotlin.g.b.p.k(paramad, "groupModel");
      super.a(paramad);
      paramad = this.jMb;
      com.tencent.mm.emoji.b.b.i locali = h.this.jJa;
      kotlin.g.b.p.k(locali, "config");
      Object localObject = paramad.jJa;
      if (localObject != null) {
        ((com.tencent.mm.emoji.b.b.i)localObject).g(paramad.jLq);
      }
      paramad.jJa = locali;
      locali = paramad.jJa;
      if (locali != null)
      {
        localObject = paramad.jLq;
        kotlin.g.b.p.k(localObject, "listener");
        locali.jJq.add(localObject);
      }
      paramad.jLq.invoke();
      AppMethodBeat.o(105640);
    }
    
    public final void aCO()
    {
      AppMethodBeat.i(105641);
      super.aCO();
      SmileyPanelView localSmileyPanelView = this.jMb;
      com.tencent.mm.emoji.b.b.i locali = localSmileyPanelView.jJa;
      if (locali != null)
      {
        locali.g(localSmileyPanelView.jLq);
        AppMethodBeat.o(105641);
        return;
      }
      AppMethodBeat.o(105641);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.h
 * JD-Core Version:    0.7.0.1
 */