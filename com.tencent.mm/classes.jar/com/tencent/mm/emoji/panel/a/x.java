package com.tencent.mm.emoji.panel.a;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.a.ac;
import com.tencent.mm.emoji.a.a.i;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import java.util.ArrayList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/panel/adapter/SmileyTabAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/emoji/panel/adapter/SmileyTabAdapter$ViewHolder;", "config", "Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "(Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;)V", "mData", "Ljava/util/ArrayList;", "Lcom/tencent/mm/emoji/model/panel/PanelTab;", "onItemClickListener", "Lcom/tencent/mm/emoji/panel/adapter/SmileyTabAdapter$OnItemClickListener;", "selectedPosition", "", "getItem", "position", "getItemCount", "getItemId", "", "getItemViewType", "onBindViewHolder", "", "viewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setOnItemClickListener", "setSelection", "update", "data", "", "Companion", "OnItemClickListener", "ViewHolder", "plugin-emojisdk_release"})
public final class x
  extends RecyclerView.a<c>
{
  public static final String TAG = "MicroMsg.emoji.SmileyPanel.SmileyTabAdapter";
  public static final a fQK;
  private final i fNC;
  public b fQJ;
  public final ArrayList<ac> mData;
  private int rZ;
  
  static
  {
    AppMethodBeat.i(105703);
    fQK = new a((byte)0);
    TAG = "MicroMsg.emoji.SmileyPanel.SmileyTabAdapter";
    AppMethodBeat.o(105703);
  }
  
  public x(i parami)
  {
    AppMethodBeat.i(105702);
    this.fNC = parami;
    this.mData = new ArrayList();
    this.rZ = -1;
    AppMethodBeat.o(105702);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(105698);
    int i = this.mData.size();
    AppMethodBeat.o(105698);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(105699);
    ac localac = lH(paramInt);
    if (localac == null) {
      k.fvU();
    }
    paramInt = localac.type;
    AppMethodBeat.o(105699);
    return paramInt;
  }
  
  public final ac lH(int paramInt)
  {
    AppMethodBeat.i(105697);
    if ((this.mData.isEmpty()) || (this.mData.size() < paramInt) || (paramInt < 0))
    {
      AppMethodBeat.o(105697);
      return null;
    }
    ac localac = (ac)this.mData.get(paramInt);
    AppMethodBeat.o(105697);
    return localac;
  }
  
  public final void setSelection(int paramInt)
  {
    AppMethodBeat.i(105696);
    ad.i(TAG, "setSelection: %s", new Object[] { Integer.valueOf(paramInt) });
    if (this.rZ != paramInt)
    {
      ck(this.rZ);
      this.rZ = paramInt;
      ck(this.rZ);
    }
    AppMethodBeat.o(105696);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/panel/adapter/SmileyTabAdapter$Companion;", "", "()V", "TAG", "", "plugin-emojisdk_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/panel/adapter/SmileyTabAdapter$OnItemClickListener;", "", "onItemClick", "", "position", "", "itemView", "Landroid/view/View;", "plugin-emojisdk_release"})
  public static abstract interface b
  {
    public abstract void b(int paramInt, View paramView);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/panel/adapter/SmileyTabAdapter$ViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/emoji/panel/adapter/SmileyTabAdapter;Landroid/view/View;)V", "dotView", "Landroid/widget/ImageView;", "getDotView", "()Landroid/widget/ImageView;", "setDotView", "(Landroid/widget/ImageView;)V", "imageView", "getImageView", "setImageView", "onClick", "", "v", "plugin-emojisdk_release"})
  public final class c
    extends RecyclerView.v
    implements View.OnClickListener
  {
    ImageView djK;
    ImageView fQL;
    
    public c()
    {
      super();
      AppMethodBeat.i(105693);
      this$1 = localObject.findViewById(2131304867);
      k.g(x.this, "view.findViewById(R.id.smiley_listview_item_view)");
      this.djK = ((ImageView)x.this);
      this$1 = localObject.findViewById(2131304866);
      k.g(x.this, "view.findViewById(R.id.smiley_listview_item_dot)");
      this.fQL = ((ImageView)x.this);
      localObject.setOnClickListener((View.OnClickListener)this);
      AppMethodBeat.o(105693);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(105692);
      k.h(paramView, "v");
      if (x.a(x.this) != null)
      {
        x.b localb = x.a(x.this);
        if (localb == null) {
          k.fvU();
        }
        localb.b(ln(), paramView);
      }
      AppMethodBeat.o(105692);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.x
 * JD-Core Version:    0.7.0.1
 */