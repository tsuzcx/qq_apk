package com.tencent.mm.emoji.panel.a;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.ag;
import com.tencent.mm.emoji.b.b.i;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/panel/adapter/SmileyTabAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/emoji/panel/adapter/SmileyTabAdapter$ViewHolder;", "config", "Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "(Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;)V", "mData", "Ljava/util/ArrayList;", "Lcom/tencent/mm/emoji/model/panel/PanelTab;", "onItemClickListener", "Lcom/tencent/mm/emoji/panel/adapter/SmileyTabAdapter$OnItemClickListener;", "selectedPosition", "", "getItem", "position", "getItemCount", "getItemId", "", "getItemViewType", "onBindViewHolder", "", "viewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setOnItemClickListener", "setSelection", "update", "data", "", "Companion", "OnItemClickListener", "ViewHolder", "plugin-emojisdk_release"})
public final class ad
  extends RecyclerView.a<c>
{
  public static final String TAG = "MicroMsg.emoji.SmileyPanel.SmileyTabAdapter";
  public static final ad.a hbC;
  private final i gYa;
  public b hbB;
  public final ArrayList<ag> mData;
  private int va;
  
  static
  {
    AppMethodBeat.i(105703);
    hbC = new ad.a((byte)0);
    TAG = "MicroMsg.emoji.SmileyPanel.SmileyTabAdapter";
    AppMethodBeat.o(105703);
  }
  
  public ad(i parami)
  {
    AppMethodBeat.i(105702);
    this.gYa = parami;
    this.mData = new ArrayList();
    this.va = -1;
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
    ag localag = pp(paramInt);
    if (localag == null) {
      p.hyc();
    }
    paramInt = localag.type;
    AppMethodBeat.o(105699);
    return paramInt;
  }
  
  public final ag pp(int paramInt)
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
    Log.i(TAG, "setSelection: %s", new Object[] { Integer.valueOf(paramInt) });
    if (this.va != paramInt)
    {
      ci(this.va);
      this.va = paramInt;
      ci(this.va);
    }
    AppMethodBeat.o(105696);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/panel/adapter/SmileyTabAdapter$OnItemClickListener;", "", "onItemClick", "", "position", "", "itemView", "Landroid/view/View;", "plugin-emojisdk_release"})
  public static abstract interface b
  {
    public abstract void b(int paramInt, View paramView);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/panel/adapter/SmileyTabAdapter$ViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/emoji/panel/adapter/SmileyTabAdapter;Landroid/view/View;)V", "dotView", "Landroid/widget/ImageView;", "getDotView", "()Landroid/widget/ImageView;", "setDotView", "(Landroid/widget/ImageView;)V", "imageView", "getImageView", "setImageView", "onClick", "", "v", "plugin-emojisdk_release"})
  public final class c
    extends RecyclerView.v
    implements View.OnClickListener
  {
    ImageView dKU;
    ImageView hbD;
    
    public c()
    {
      super();
      AppMethodBeat.i(105693);
      this$1 = localObject.findViewById(2131307953);
      p.g(ad.this, "view.findViewById(R.id.smiley_listview_item_view)");
      this.dKU = ((ImageView)ad.this);
      this$1 = localObject.findViewById(2131307952);
      p.g(ad.this, "view.findViewById(R.id.smiley_listview_item_dot)");
      this.hbD = ((ImageView)ad.this);
      localObject.setOnClickListener((View.OnClickListener)this);
      AppMethodBeat.o(105693);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(105692);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      a.b("com/tencent/mm/emoji/panel/adapter/SmileyTabAdapter$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      p.h(paramView, "v");
      if (ad.a(ad.this) != null)
      {
        localObject = ad.a(ad.this);
        if (localObject == null) {
          p.hyc();
        }
        ((ad.b)localObject).b(lR(), paramView);
      }
      a.a(this, "com/tencent/mm/emoji/panel/adapter/SmileyTabAdapter$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(105692);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.ad
 * JD-Core Version:    0.7.0.1
 */