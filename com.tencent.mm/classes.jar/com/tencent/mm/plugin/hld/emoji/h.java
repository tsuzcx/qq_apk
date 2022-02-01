package com.tencent.mm.plugin.hld.emoji;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.hld.a.f;
import com.tencent.mm.plugin.hld.f.e;
import com.tencent.mm.plugin.hld.view.g;
import com.tencent.mm.protocal.protobuf.fmu;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiGridViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "itemView", "Landroid/view/View;", "listener", "Lcom/tencent/mm/plugin/hld/emoji/IEmojiContentViewListener;", "(Landroid/view/View;Lcom/tencent/mm/plugin/hld/emoji/IEmojiContentViewListener;)V", "emojiData", "Lcom/tencent/mm/protocal/protobuf/WxImeEmojiData;", "emojiIv", "Landroid/widget/ImageView;", "emojiTv", "Landroid/widget/TextView;", "mListener", "rootView", "Landroid/widget/RelativeLayout;", "fillContent", "", "onClick", "v", "plugin-hld_release"})
public final class h
  extends RecyclerView.v
  implements View.OnClickListener
{
  RelativeLayout DtO;
  private final a DvT;
  TextView Dwi;
  ImageView Dwj;
  fmu Dwk;
  
  public h(View paramView, a parama)
  {
    super(paramView);
    AppMethodBeat.i(217135);
    View localView = paramView.findViewById(a.f.root);
    p.j(localView, "itemView.findViewById(R.id.root)");
    this.DtO = ((RelativeLayout)localView);
    localView = paramView.findViewById(a.f.emoji_text);
    p.j(localView, "itemView.findViewById(R.id.emoji_text)");
    this.Dwi = ((TextView)localView);
    paramView = paramView.findViewById(a.f.emoji_icon);
    p.j(paramView, "itemView.findViewById(R.id.emoji_icon)");
    this.Dwj = ((ImageView)paramView);
    this.DvT = parama;
    paramView = g.DIP;
    g.a((View)this.DtO, (View.OnClickListener)this);
    AppMethodBeat.o(217135);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(217133);
    Object localObject = new b();
    ((b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/emoji/ImeEmojiGridViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
    paramView = com.tencent.mm.plugin.hld.f.l.DHK;
    localObject = new StringBuilder("onClick ");
    paramView = this.Dwk;
    if (paramView != null) {}
    for (paramView = paramView.MGH;; paramView = null)
    {
      com.tencent.mm.plugin.hld.f.l.it("WxIme.ImeEmojiGridAdapter", paramView);
      paramView = e.DGW;
      paramView = this.DvT;
      if (paramView != null) {
        paramView.a(this.Dwk);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/emoji/ImeEmojiGridViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(217133);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.emoji.h
 * JD-Core Version:    0.7.0.1
 */