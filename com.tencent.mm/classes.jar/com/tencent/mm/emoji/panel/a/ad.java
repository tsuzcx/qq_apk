package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.b.ai;
import com.tencent.mm.emoji.c.b.i;
import com.tencent.mm.emoji.debug.EmojiDebugUI;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.m.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/panel/adapter/SmileyTabAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/emoji/panel/adapter/SmileyTabAdapter$ViewHolder;", "config", "Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "(Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;)V", "mData", "Ljava/util/ArrayList;", "Lcom/tencent/mm/emoji/model/panel/PanelTab;", "Lkotlin/collections/ArrayList;", "onItemClickListener", "Lcom/tencent/mm/emoji/panel/adapter/SmileyTabAdapter$OnItemClickListener;", "selectedId", "", "selectedPosition", "", "getItem", "position", "getItemCount", "getItemId", "", "getItemViewType", "onBindViewHolder", "", "viewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setOnItemClickListener", "setSelection", "update", "data", "", "Companion", "OnItemClickListener", "ViewHolder", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ad
  extends RecyclerView.a<c>
{
  public static final String TAG;
  public static final ad.a mlJ;
  private int dyx;
  private final i mir;
  public final ArrayList<ai> mlK;
  public b mlL;
  public String mlM;
  
  static
  {
    AppMethodBeat.i(105703);
    mlJ = new ad.a((byte)0);
    TAG = "MicroMsg.emoji.SmileyPanel.SmileyTabAdapter";
    AppMethodBeat.o(105703);
  }
  
  public ad(i parami)
  {
    AppMethodBeat.i(105702);
    this.mir = parami;
    this.mlK = new ArrayList();
    this.dyx = -1;
    AppMethodBeat.o(105702);
  }
  
  private static final boolean cY(View paramView)
  {
    AppMethodBeat.i(242422);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/emoji/panel/adapter/SmileyTabAdapter", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject, localb.aYj());
    localObject = new Intent(paramView.getContext(), EmojiDebugUI.class);
    paramView = paramView.getContext();
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/emoji/panel/adapter/SmileyTabAdapter", "onBindViewHolder$lambda-1", "(Landroid/view/View;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/emoji/panel/adapter/SmileyTabAdapter", "onBindViewHolder$lambda-1", "(Landroid/view/View;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.hellhoundlib.a.a.a(true, new Object(), "com/tencent/mm/emoji/panel/adapter/SmileyTabAdapter", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(242422);
    return true;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(105698);
    int i = this.mlK.size();
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
    ai localai = rK(paramInt);
    s.checkNotNull(localai);
    paramInt = localai.type;
    AppMethodBeat.o(105699);
    return paramInt;
  }
  
  public final ai rK(int paramInt)
  {
    AppMethodBeat.i(105697);
    if ((this.mlK.isEmpty()) || (this.mlK.size() < paramInt) || (paramInt < 0))
    {
      AppMethodBeat.o(105697);
      return null;
    }
    ai localai = (ai)this.mlK.get(paramInt);
    AppMethodBeat.o(105697);
    return localai;
  }
  
  public final void setSelection(int paramInt)
  {
    String str = null;
    AppMethodBeat.i(105696);
    Log.i(TAG, "setSelection: %s", new Object[] { Integer.valueOf(paramInt) });
    Object localObject;
    if (this.dyx != paramInt)
    {
      fV(this.dyx);
      this.dyx = paramInt;
      localObject = rK(paramInt);
      if (localObject != null) {
        break label79;
      }
    }
    for (;;)
    {
      this.mlM = str;
      fV(this.dyx);
      AppMethodBeat.o(105696);
      return;
      label79:
      localObject = ((ai)localObject).mgd;
      if (localObject != null) {
        str = ((EmojiGroupInfo)localObject).field_productID;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/panel/adapter/SmileyTabAdapter$OnItemClickListener;", "", "onItemClick", "", "position", "", "itemView", "Landroid/view/View;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void c(int paramInt, View paramView);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/panel/adapter/SmileyTabAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/emoji/panel/adapter/SmileyTabAdapter;Landroid/view/View;)V", "dotView", "Landroid/widget/ImageView;", "getDotView", "()Landroid/widget/ImageView;", "setDotView", "(Landroid/widget/ImageView;)V", "imageView", "getImageView", "setImageView", "onClick", "", "v", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    extends RecyclerView.v
    implements View.OnClickListener
  {
    ImageView hIz;
    ImageView mlN;
    
    public c()
    {
      super();
      AppMethodBeat.i(105693);
      this$1 = localObject.findViewById(a.g.smiley_listview_item_view);
      s.s(ad.this, "view.findViewById(R.id.smiley_listview_item_view)");
      this.hIz = ((ImageView)ad.this);
      this$1 = localObject.findViewById(a.g.smiley_listview_item_dot);
      s.s(ad.this, "view.findViewById(R.id.smiley_listview_item_dot)");
      this.mlN = ((ImageView)ad.this);
      localObject.setOnClickListener((View.OnClickListener)this);
      AppMethodBeat.o(105693);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(105692);
      Object localObject = new b();
      ((b)localObject).cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/emoji/panel/adapter/SmileyTabAdapter$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
      s.u(paramView, "v");
      if (ad.a(ad.this) != null)
      {
        localObject = ad.a(ad.this);
        s.checkNotNull(localObject);
        ((ad.b)localObject).c(KJ(), paramView);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/emoji/panel/adapter/SmileyTabAdapter$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(105692);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.ad
 * JD-Core Version:    0.7.0.1
 */