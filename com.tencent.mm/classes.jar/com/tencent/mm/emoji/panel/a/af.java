package com.tencent.mm.emoji.panel.a;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.ai;
import com.tencent.mm.emoji.b.b.i;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.m.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/panel/adapter/SmileyTabAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/emoji/panel/adapter/SmileyTabAdapter$ViewHolder;", "config", "Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "(Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;)V", "mData", "Ljava/util/ArrayList;", "Lcom/tencent/mm/emoji/model/panel/PanelTab;", "onItemClickListener", "Lcom/tencent/mm/emoji/panel/adapter/SmileyTabAdapter$OnItemClickListener;", "selectedPosition", "", "getItem", "position", "getItemCount", "getItemId", "", "getItemViewType", "onBindViewHolder", "", "viewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setOnItemClickListener", "setSelection", "update", "data", "", "Companion", "OnItemClickListener", "ViewHolder", "plugin-emojisdk_release"})
public final class af
  extends RecyclerView.a<c>
{
  public static final String TAG = "MicroMsg.emoji.SmileyPanel.SmileyTabAdapter";
  public static final a jMM;
  private int bFx;
  private final i jJa;
  public b jML;
  public final ArrayList<ai> mData;
  
  static
  {
    AppMethodBeat.i(105703);
    jMM = new a((byte)0);
    TAG = "MicroMsg.emoji.SmileyPanel.SmileyTabAdapter";
    AppMethodBeat.o(105703);
  }
  
  public af(i parami)
  {
    AppMethodBeat.i(105702);
    this.jJa = parami;
    this.mData = new ArrayList();
    this.bFx = -1;
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
    ai localai = rI(paramInt);
    if (localai == null) {
      p.iCn();
    }
    paramInt = localai.type;
    AppMethodBeat.o(105699);
    return paramInt;
  }
  
  public final ai rI(int paramInt)
  {
    AppMethodBeat.i(105697);
    if ((this.mData.isEmpty()) || (this.mData.size() < paramInt) || (paramInt < 0))
    {
      AppMethodBeat.o(105697);
      return null;
    }
    ai localai = (ai)this.mData.get(paramInt);
    AppMethodBeat.o(105697);
    return localai;
  }
  
  public final void setSelection(int paramInt)
  {
    AppMethodBeat.i(105696);
    Log.i(TAG, "setSelection: %s", new Object[] { Integer.valueOf(paramInt) });
    if (this.bFx != paramInt)
    {
      cL(this.bFx);
      this.bFx = paramInt;
      cL(this.bFx);
    }
    AppMethodBeat.o(105696);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/panel/adapter/SmileyTabAdapter$Companion;", "", "()V", "TAG", "", "plugin-emojisdk_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/panel/adapter/SmileyTabAdapter$OnItemClickListener;", "", "onItemClick", "", "position", "", "itemView", "Landroid/view/View;", "plugin-emojisdk_release"})
  public static abstract interface b
  {
    public abstract void b(int paramInt, View paramView);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/panel/adapter/SmileyTabAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/emoji/panel/adapter/SmileyTabAdapter;Landroid/view/View;)V", "dotView", "Landroid/widget/ImageView;", "getDotView", "()Landroid/widget/ImageView;", "setDotView", "(Landroid/widget/ImageView;)V", "imageView", "getImageView", "setImageView", "onClick", "", "v", "plugin-emojisdk_release"})
  public final class c
    extends RecyclerView.v
    implements View.OnClickListener
  {
    ImageView fDJ;
    ImageView jMN;
    
    public c()
    {
      super();
      AppMethodBeat.i(105693);
      this$1 = localObject.findViewById(a.g.smiley_listview_item_view);
      p.j(af.this, "view.findViewById(R.id.smiley_listview_item_view)");
      this.fDJ = ((ImageView)af.this);
      this$1 = localObject.findViewById(a.g.smiley_listview_item_dot);
      p.j(af.this, "view.findViewById(R.id.smiley_listview_item_dot)");
      this.jMN = ((ImageView)af.this);
      localObject.setOnClickListener((View.OnClickListener)this);
      AppMethodBeat.o(105693);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(105692);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      a.c("com/tencent/mm/emoji/panel/adapter/SmileyTabAdapter$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      p.k(paramView, "v");
      if (af.a(af.this) != null)
      {
        localObject = af.a(af.this);
        if (localObject == null) {
          p.iCn();
        }
        ((af.b)localObject).b(md(), paramView);
      }
      a.a(this, "com/tencent/mm/emoji/panel/adapter/SmileyTabAdapter$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(105692);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.af
 * JD-Core Version:    0.7.0.1
 */