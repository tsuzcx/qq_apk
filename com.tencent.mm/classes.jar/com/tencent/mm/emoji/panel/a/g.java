package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.b;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.aa;
import com.tencent.mm.emoji.b.b.ab;
import com.tencent.mm.emoji.b.b.ad;
import com.tencent.mm.emoji.b.b.af;
import com.tencent.mm.emoji.b.b.ak;
import com.tencent.mm.emoji.b.b.am;
import com.tencent.mm.emoji.b.b.f;
import com.tencent.mm.emoji.b.b.w;
import com.tencent.mm.emoji.panel.EmojiPanelRecyclerView;
import com.tencent.mm.emoji.panel.SmileyPanelView;
import com.tencent.mm.emoji.panel.layout.SmileyLayoutManager;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.vending.e.b;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter$AbsPanelGroupViewHolder;", "config", "Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "lifeCycle", "Lcom/tencent/mm/emoji/model/panel/PanelLifeCycle;", "smileyItemSize", "Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "emojiItemSize", "(Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;Lcom/tencent/mm/emoji/model/panel/PanelLifeCycle;Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;)V", "TAG", "", "clickListener", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "getClickListener", "()Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "setClickListener", "(Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "getConfig", "()Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "groupList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "Lkotlin/collections/ArrayList;", "groupModelList", "Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "getLifeCycle", "()Lcom/tencent/mm/emoji/model/panel/PanelLifeCycle;", "pool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "textOperationListener", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "getTextOperationListener", "()Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "setTextOperationListener", "(Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewRecycled", "updateData", "groups", "", "models", "AbsPanelGroupViewHolder", "Companion", "EmojiPanelGroupViewHolder", "SmileyPanelGroupViewHolder", "plugin-emojisdk_release"})
public final class g
  extends RecyclerView.a<a>
{
  public static final g.b haO;
  private final String TAG;
  final com.tencent.mm.emoji.b.b.i gYa;
  public final ArrayList<EmojiGroupInfo> haH;
  public final ArrayList<ab<?>> haI;
  private final RecyclerView.m haJ;
  public n haK;
  final af haL;
  private final o haM;
  private final o haN;
  public ChatFooterPanel.a har;
  
  static
  {
    AppMethodBeat.i(105649);
    haO = new g.b((byte)0);
    AppMethodBeat.o(105649);
  }
  
  public g(com.tencent.mm.emoji.b.b.i parami, af paramaf, o paramo1, o paramo2)
  {
    AppMethodBeat.i(199967);
    this.gYa = parami;
    this.haL = paramaf;
    this.haM = paramo1;
    this.haN = paramo2;
    this.TAG = "MicroMsg.EmojiPanelGroupAdapter";
    this.haH = new ArrayList();
    this.haI = new ArrayList();
    this.haJ = new RecyclerView.m();
    this.haJ.aw(0, 50);
    this.haJ.aw(1, 30);
    this.haJ.aw(2, 3);
    this.haJ.aw(3, 1);
    this.haJ.aw(4, 2);
    this.haJ.aw(5, 3);
    AppMethodBeat.o(199967);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(105645);
    int i = this.haH.size();
    AppMethodBeat.o(105645);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(105643);
    Object localObject = this.haH.get(paramInt);
    kotlin.g.b.p.g(localObject, "groupList[position]");
    if (kotlin.g.b.p.j(((EmojiGroupInfo)localObject).hRu(), ad.avB()))
    {
      AppMethodBeat.o(105643);
      return 1;
    }
    AppMethodBeat.o(105643);
    return 0;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter$AbsPanelGroupViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "sizeResolver", "Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "layoutManager", "Landroid/support/v7/widget/GridLayoutManager;", "(Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter;Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;Landroid/support/v7/widget/GridLayoutManager;)V", "adapter", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter;", "getAdapter", "()Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter;", "getLayoutManager", "()Landroid/support/v7/widget/GridLayoutManager;", "listener", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter$ListenerToAdapter;", "getListener", "()Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter$ListenerToAdapter;", "model", "Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "getModel", "()Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "setModel", "(Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;)V", "recycler", "Lcom/tencent/mm/emoji/panel/EmojiPanelRecyclerView;", "getRecycler", "()Lcom/tencent/mm/emoji/panel/EmojiPanelRecyclerView;", "sizeLookup", "Lcom/tencent/mm/emoji/panel/adapter/PanelSpanSizeLookup;", "getSizeLookup", "()Lcom/tencent/mm/emoji/panel/adapter/PanelSpanSizeLookup;", "getSizeResolver", "()Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "onBind", "", "groupModel", "onUnbind", "plugin-emojisdk_release"})
  public abstract class a
    extends RecyclerView.v
  {
    private final EmojiPanelRecyclerView haP;
    private final h haQ;
    private final h.a haR;
    private final p haS;
    private ab<?> haT;
    private final GridLayoutManager haU;
    private final o hah;
    
    public a(o paramo, GridLayoutManager paramGridLayoutManager)
    {
      super();
      this.hah = paramGridLayoutManager;
      this.haU = localObject;
      paramo = paramo.findViewById(2131300011);
      kotlin.g.b.p.g(paramo, "itemView.findViewById(R.…oji_panel_group_recycler)");
      this.haP = ((EmojiPanelRecyclerView)paramo);
      this.haQ = new h();
      this.haR = new h.a(this.haQ);
      this.haS = new p((RecyclerView.a)this.haQ, this.haU);
      this.haP.setRecycledViewPool(g.b(g.this));
      this.haP.setHasFixedSize(true);
      this.haP.setAdapter((RecyclerView.a)this.haQ);
      this.haP.setSizeResolver(this.hah);
      this.haP.setPanelLifeCycle((b)g.this.haL);
      this.haP.b((RecyclerView.h)new i(this.hah));
      this.haU.a((GridLayoutManager.b)this.haS);
      this.haP.setLayoutManager((RecyclerView.LayoutManager)this.haU);
      this.haP.setFocusable(false);
      this.haP.setItemAnimator(null);
      this.haQ.haK = g.this.haK;
    }
    
    public void a(ab<?> paramab)
    {
      kotlin.g.b.p.h(paramab, "groupModel");
      Log.i(g.a(g.this), "onBind: " + paramab.avp().avm().hRu() + ' ' + paramab.avp().avn().size());
      this.haU.bW(this.hah.att);
      this.haQ.ad(paramab.avp().avn());
      this.haQ.notifyDataSetChanged();
      if ((kotlin.g.b.p.j(this.haT, paramab) ^ true))
      {
        localObject = this.haT;
        if (localObject != null) {
          ((ab)localObject).a(null);
        }
        this.haT = paramab;
      }
      Object localObject = this.haT;
      if (localObject != null) {
        ((ab)localObject).a((aa)this.haR);
      }
      localObject = this.haP;
      kotlin.g.b.p.h(paramab, "groupModel");
      if ((paramab instanceof ak))
      {
        paramab = ((EmojiPanelRecyclerView)localObject).getContext();
        kotlin.g.b.p.g(paramab, "context");
        ((EmojiPanelRecyclerView)localObject).haf = ((com.tencent.mm.view.popview.a)new com.tencent.mm.view.popview.d(paramab));
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
        if ((paramab instanceof com.tencent.mm.emoji.b.b.d)) {
          i = 1;
        } else if ((paramab instanceof am)) {
          i = 2;
        } else {
          i = -1;
        }
      }
    }
    
    public void avR()
    {
      String str = g.a(g.this);
      StringBuilder localStringBuilder = new StringBuilder("onUnbind: ");
      Object localObject = this.haT;
      if (localObject != null)
      {
        localObject = ((ab)localObject).avp();
        if (localObject != null)
        {
          localObject = ((w)localObject).avm();
          if (localObject == null) {}
        }
      }
      for (localObject = ((EmojiGroupInfo)localObject).hRu();; localObject = null)
      {
        Log.i(str, (String)localObject);
        localObject = this.haT;
        if (localObject != null) {
          ((ab)localObject).a(null);
        }
        this.haT = null;
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter$EmojiPanelGroupViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter$AbsPanelGroupViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter;Landroid/view/View;)V", "plugin-emojisdk_release"})
  public final class c
    extends g.a
  {
    public c()
    {
      super(localObject, localo, new GridLayoutManager(g.c(g.this).att));
      AppMethodBeat.i(105639);
      AppMethodBeat.o(105639);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter$SmileyPanelGroupViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter$AbsPanelGroupViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter;Landroid/view/View;)V", "smileyView", "Lcom/tencent/mm/emoji/panel/SmileyPanelView;", "getSmileyView", "()Lcom/tencent/mm/emoji/panel/SmileyPanelView;", "onBind", "", "groupModel", "Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "onUnbind", "plugin-emojisdk_release"})
  public final class d
    extends g.a
  {
    private final SmileyPanelView haW;
    
    public d()
    {
      super((View)localObject, localo, (GridLayoutManager)new SmileyLayoutManager(localContext, g.d(g.this).att));
      AppMethodBeat.i(105642);
      Object localObject = ((View)localObject).findViewById(2131300017);
      kotlin.g.b.p.g(localObject, "itemView.findViewById(R.…_panel_smiley_panel_view)");
      this.haW = ((SmileyPanelView)localObject);
      this.haW.setTextOperationListener(g.this.har);
      AppMethodBeat.o(105642);
    }
    
    public final void a(ab<?> paramab)
    {
      AppMethodBeat.i(105640);
      kotlin.g.b.p.h(paramab, "groupModel");
      super.a(paramab);
      paramab = this.haW;
      com.tencent.mm.emoji.b.b.i locali = g.this.gYa;
      kotlin.g.b.p.h(locali, "config");
      Object localObject = paramab.gYa;
      if (localObject != null) {
        ((com.tencent.mm.emoji.b.b.i)localObject).g(paramab.hap);
      }
      paramab.gYa = locali;
      locali = paramab.gYa;
      if (locali != null)
      {
        localObject = paramab.hap;
        kotlin.g.b.p.h(localObject, "listener");
        locali.gYq.add(localObject);
      }
      paramab.hap.invoke();
      AppMethodBeat.o(105640);
    }
    
    public final void avR()
    {
      AppMethodBeat.i(105641);
      super.avR();
      SmileyPanelView localSmileyPanelView = this.haW;
      com.tencent.mm.emoji.b.b.i locali = localSmileyPanelView.gYa;
      if (locali != null)
      {
        locali.g(localSmileyPanelView.hap);
        AppMethodBeat.o(105641);
        return;
      }
      AppMethodBeat.o(105641);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.g
 * JD-Core Version:    0.7.0.1
 */