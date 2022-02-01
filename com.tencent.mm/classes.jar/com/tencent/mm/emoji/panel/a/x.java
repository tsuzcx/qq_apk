package com.tencent.mm.emoji.panel.a;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.a.ag;
import com.tencent.mm.emoji.a.a.i;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.util.ArrayList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/panel/adapter/SmileyTabAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/emoji/panel/adapter/SmileyTabAdapter$ViewHolder;", "config", "Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "(Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;)V", "mData", "Ljava/util/ArrayList;", "Lcom/tencent/mm/emoji/model/panel/PanelTab;", "onItemClickListener", "Lcom/tencent/mm/emoji/panel/adapter/SmileyTabAdapter$OnItemClickListener;", "selectedPosition", "", "getItem", "position", "getItemCount", "getItemId", "", "getItemViewType", "onBindViewHolder", "", "viewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setOnItemClickListener", "setSelection", "update", "data", "", "Companion", "OnItemClickListener", "ViewHolder", "plugin-emojisdk_release"})
public final class x
  extends RecyclerView.a<c>
{
  public static final String TAG = "MicroMsg.emoji.SmileyPanel.SmileyTabAdapter";
  public static final x.a goh;
  private final i gkN;
  public b gog;
  public final ArrayList<ag> mData;
  private int uT;
  
  static
  {
    AppMethodBeat.i(105703);
    goh = new x.a((byte)0);
    TAG = "MicroMsg.emoji.SmileyPanel.SmileyTabAdapter";
    AppMethodBeat.o(105703);
  }
  
  public x(i parami)
  {
    AppMethodBeat.i(105702);
    this.gkN = parami;
    this.mData = new ArrayList();
    this.uT = -1;
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
    ag localag = me(paramInt);
    if (localag == null) {
      p.gfZ();
    }
    paramInt = localag.type;
    AppMethodBeat.o(105699);
    return paramInt;
  }
  
  public final ag me(int paramInt)
  {
    AppMethodBeat.i(105697);
    if ((this.mData.isEmpty()) || (this.mData.size() < paramInt) || (paramInt < 0))
    {
      AppMethodBeat.o(105697);
      return null;
    }
    ag localag = (ag)this.mData.get(paramInt);
    AppMethodBeat.o(105697);
    return localag;
  }
  
  public final void setSelection(int paramInt)
  {
    AppMethodBeat.i(105696);
    ad.i(TAG, "setSelection: %s", new Object[] { Integer.valueOf(paramInt) });
    if (this.uT != paramInt)
    {
      cj(this.uT);
      this.uT = paramInt;
      cj(this.uT);
    }
    AppMethodBeat.o(105696);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/panel/adapter/SmileyTabAdapter$OnItemClickListener;", "", "onItemClick", "", "position", "", "itemView", "Landroid/view/View;", "plugin-emojisdk_release"})
  public static abstract interface b
  {
    public abstract void b(int paramInt, View paramView);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/panel/adapter/SmileyTabAdapter$ViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/emoji/panel/adapter/SmileyTabAdapter;Landroid/view/View;)V", "dotView", "Landroid/widget/ImageView;", "getDotView", "()Landroid/widget/ImageView;", "setDotView", "(Landroid/widget/ImageView;)V", "imageView", "getImageView", "setImageView", "onClick", "", "v", "plugin-emojisdk_release"})
  public final class c
    extends RecyclerView.w
    implements View.OnClickListener
  {
    ImageView dsD;
    ImageView goi;
    
    public c()
    {
      super();
      AppMethodBeat.i(105693);
      this$1 = localObject.findViewById(2131304867);
      p.g(x.this, "view.findViewById(R.id.smiley_listview_item_view)");
      this.dsD = ((ImageView)x.this);
      this$1 = localObject.findViewById(2131304866);
      p.g(x.this, "view.findViewById(R.id.smiley_listview_item_dot)");
      this.goi = ((ImageView)x.this);
      localObject.setOnClickListener((View.OnClickListener)this);
      AppMethodBeat.o(105693);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(105692);
      Object localObject = new b();
      ((b)localObject).bd(paramView);
      a.b("com/tencent/mm/emoji/panel/adapter/SmileyTabAdapter$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
      p.h(paramView, "v");
      if (x.a(x.this) != null)
      {
        localObject = x.a(x.this);
        if (localObject == null) {
          p.gfZ();
        }
        ((x.b)localObject).b(lN(), paramView);
      }
      a.a(this, "com/tencent/mm/emoji/panel/adapter/SmileyTabAdapter$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(105692);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.x
 * JD-Core Version:    0.7.0.1
 */