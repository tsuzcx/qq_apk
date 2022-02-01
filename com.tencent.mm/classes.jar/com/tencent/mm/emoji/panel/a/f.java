package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager.b;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.m;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.b.ac;
import com.tencent.mm.emoji.c.b.ad;
import com.tencent.mm.emoji.c.b.af;
import com.tencent.mm.emoji.c.b.ah;
import com.tencent.mm.emoji.c.b.am;
import com.tencent.mm.emoji.c.b.ao;
import com.tencent.mm.emoji.c.b.i;
import com.tencent.mm.emoji.c.b.y;
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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter$AbsPanelGroupViewHolder;", "config", "Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "lifeCycle", "Lcom/tencent/mm/emoji/model/panel/PanelLifeCycle;", "smileyItemSize", "Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "emojiItemSize", "(Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;Lcom/tencent/mm/emoji/model/panel/PanelLifeCycle;Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;)V", "TAG", "", "clickListener", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "getClickListener", "()Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "setClickListener", "(Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "getConfig", "()Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "groupList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "Lkotlin/collections/ArrayList;", "groupModelList", "Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "getLifeCycle", "()Lcom/tencent/mm/emoji/model/panel/PanelLifeCycle;", "pool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "textOperationListener", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "getTextOperationListener", "()Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "setTextOperationListener", "(Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewRecycled", "updateData", "groups", "", "models", "AbsPanelGroupViewHolder", "Companion", "EmojiPanelGroupViewHolder", "SmileyPanelGroupViewHolder", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends RecyclerView.a<a>
{
  public static final f.b mkR;
  private final String TAG;
  final i mir;
  public ChatFooterPanel.a mkD;
  final ah mkS;
  private final o mkT;
  private final o mkU;
  public final ArrayList<EmojiGroupInfo> mkV;
  public final ArrayList<ad<?>> mkW;
  private final RecyclerView.m mkX;
  public n mkY;
  
  static
  {
    AppMethodBeat.i(105649);
    mkR = new f.b((byte)0);
    AppMethodBeat.o(105649);
  }
  
  public f(i parami, ah paramah, o paramo1, o paramo2)
  {
    AppMethodBeat.i(242425);
    this.mir = parami;
    this.mkS = paramah;
    this.mkT = paramo1;
    this.mkU = paramo2;
    this.TAG = "MicroMsg.EmojiPanelGroupAdapter";
    this.mkV = new ArrayList();
    this.mkW = new ArrayList();
    this.mkX = new RecyclerView.m();
    this.mkX.bD(0, 50);
    this.mkX.bD(1, 30);
    this.mkX.bD(2, 3);
    this.mkX.bD(3, 1);
    this.mkX.bD(4, 2);
    this.mkX.bD(5, 3);
    AppMethodBeat.o(242425);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(105645);
    int i = this.mkV.size();
    AppMethodBeat.o(105645);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(105643);
    if (s.p(((EmojiGroupInfo)this.mkV.get(paramInt)).field_productID, af.aVt()))
    {
      AppMethodBeat.o(105643);
      return 1;
    }
    AppMethodBeat.o(105643);
    return 0;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter$AbsPanelGroupViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "sizeResolver", "Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "layoutManager", "Landroidx/recyclerview/widget/GridLayoutManager;", "(Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter;Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;Landroidx/recyclerview/widget/GridLayoutManager;)V", "adapter", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter;", "getAdapter", "()Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter;", "getLayoutManager", "()Landroidx/recyclerview/widget/GridLayoutManager;", "listener", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter$ListenerToAdapter;", "getListener", "()Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter$ListenerToAdapter;", "model", "Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "getModel", "()Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "setModel", "(Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;)V", "recycler", "Lcom/tencent/mm/emoji/panel/EmojiPanelRecyclerView;", "getRecycler", "()Lcom/tencent/mm/emoji/panel/EmojiPanelRecyclerView;", "sizeLookup", "Lcom/tencent/mm/emoji/panel/adapter/PanelSpanSizeLookup;", "getSizeLookup", "()Lcom/tencent/mm/emoji/panel/adapter/PanelSpanSizeLookup;", "getSizeResolver", "()Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "onBind", "", "groupModel", "onUnbind", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public abstract class a
    extends RecyclerView.v
  {
    private final GridLayoutManager mkZ;
    private final o mku;
    private final EmojiPanelRecyclerView mla;
    private final g mlb;
    private final g.a mlc;
    private final p mld;
    private ad<?> mle;
    
    public a(o paramo, GridLayoutManager paramGridLayoutManager)
    {
      super();
      this.mku = paramGridLayoutManager;
      this.mkZ = localObject;
      this$1 = paramo.findViewById(a.g.emoji_panel_group_recycler);
      s.s(f.this, "itemView.findViewById(R.…oji_panel_group_recycler)");
      this.mla = ((EmojiPanelRecyclerView)f.this);
      this.mlb = new g();
      this.mlc = new g.a(this.mlb);
      this.mld = new p((RecyclerView.a)this.mlb, this.mkZ);
      this.mla.setRecycledViewPool(f.a(f.this));
      this.mla.setHasFixedSize(true);
      this.mla.setAdapter((RecyclerView.a)this.mlb);
      this.mla.setSizeResolver(this.mku);
      this.mla.setPanelLifeCycle((b)f.this.mkS);
      this.mla.a((RecyclerView.h)new h(this.mku));
      this.mkZ.bWq = ((GridLayoutManager.b)this.mld);
      this.mla.setLayoutManager((RecyclerView.LayoutManager)this.mkZ);
      this.mla.setFocusable(false);
      this.mla.setItemAnimator(null);
      this.mlb.mkY = f.this.mkY;
    }
    
    public void a(ad<?> paramad)
    {
      s.u(paramad, "groupModel");
      Log.i(f.b(f.this), "onBind: " + paramad.aVh().aVe().field_productID + ' ' + paramad.aVh().aVf().size());
      this.mkZ.fI(this.mku.spanCount);
      this.mlb.bz(paramad.aVh().aVf());
      this.mlb.bZE.notifyChanged();
      if (!s.p(this.mle, paramad))
      {
        localObject = this.mle;
        if (localObject != null) {
          ((ad)localObject).a(null);
        }
        this.mle = paramad;
      }
      Object localObject = this.mle;
      if (localObject != null) {
        ((ad)localObject).a((ac)this.mlc);
      }
      localObject = this.mla;
      s.u(paramad, "groupModel");
      if ((paramad instanceof am))
      {
        paramad = ((EmojiPanelRecyclerView)localObject).getContext();
        s.s(paramad, "context");
        ((EmojiPanelRecyclerView)localObject).mks = ((com.tencent.mm.view.popview.a)new com.tencent.mm.view.popview.d(paramad));
        return;
      }
      int i;
      if ((paramad instanceof com.tencent.mm.emoji.c.b.f)) {
        i = 0;
      }
      for (;;)
      {
        ((EmojiPanelRecyclerView)localObject).setEmojiPopupType(i);
        return;
        if ((paramad instanceof com.tencent.mm.emoji.c.b.d)) {
          i = 1;
        } else if ((paramad instanceof ao)) {
          i = 2;
        } else {
          i = -1;
        }
      }
    }
    
    public void aVM()
    {
      String str = f.b(f.this);
      Object localObject = this.mle;
      if (localObject == null) {
        localObject = null;
      }
      for (;;)
      {
        Log.i(str, s.X("onUnbind: ", localObject));
        localObject = this.mle;
        if (localObject != null) {
          ((ad)localObject).a(null);
        }
        this.mle = null;
        return;
        localObject = ((ad)localObject).aVh();
        if (localObject == null)
        {
          localObject = null;
        }
        else
        {
          localObject = ((y)localObject).aVe();
          if (localObject == null) {
            localObject = null;
          } else {
            localObject = ((EmojiGroupInfo)localObject).field_productID;
          }
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter$EmojiPanelGroupViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter$AbsPanelGroupViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter;Landroid/view/View;)V", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    extends f.a
  {
    public c()
    {
      super(localObject, localo, new GridLayoutManager(f.c(f.this).spanCount));
      AppMethodBeat.i(105639);
      AppMethodBeat.o(105639);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter$SmileyPanelGroupViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter$AbsPanelGroupViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter;Landroid/view/View;)V", "smileyView", "Lcom/tencent/mm/emoji/panel/SmileyPanelView;", "getSmileyView", "()Lcom/tencent/mm/emoji/panel/SmileyPanelView;", "onBind", "", "groupModel", "Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "onUnbind", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class d
    extends f.a
  {
    private final SmileyPanelView mlg;
    
    public d()
    {
      super(localObject, localo, (GridLayoutManager)new SmileyLayoutManager(localContext, f.d(f.this).spanCount));
      AppMethodBeat.i(105642);
      this$1 = localObject.findViewById(a.g.emoji_panel_smiley_panel_view);
      s.s(f.this, "itemView.findViewById(R.…_panel_smiley_panel_view)");
      this.mlg = ((SmileyPanelView)f.this);
      this.mlg.setTextOperationListener(f.this.mkD);
      AppMethodBeat.o(105642);
    }
    
    public final void a(ad<?> paramad)
    {
      AppMethodBeat.i(105640);
      s.u(paramad, "groupModel");
      super.a(paramad);
      paramad = this.mlg;
      i locali = f.this.mir;
      s.u(locali, "config");
      Object localObject = paramad.mir;
      if (localObject != null) {
        ((i)localObject).y(paramad.mkB);
      }
      paramad.mir = locali;
      locali = paramad.mir;
      if (locali != null)
      {
        localObject = paramad.mkB;
        s.u(localObject, "listener");
        locali.miJ.add(localObject);
      }
      paramad.mkB.invoke();
      AppMethodBeat.o(105640);
    }
    
    public final void aVM()
    {
      AppMethodBeat.i(105641);
      super.aVM();
      SmileyPanelView localSmileyPanelView = this.mlg;
      i locali = localSmileyPanelView.mir;
      if (locali != null) {
        locali.y(localSmileyPanelView.mkB);
      }
      AppMethodBeat.o(105641);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.f
 * JD-Core Version:    0.7.0.1
 */