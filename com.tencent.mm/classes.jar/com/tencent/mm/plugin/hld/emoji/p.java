package com.tencent.mm.plugin.hld.emoji;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.hld.a.f;
import com.tencent.mm.protocal.protobuf.fmu;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/emoji/ImeKaoEmojiGridViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "itemView", "Landroid/view/View;", "listener", "Lcom/tencent/mm/plugin/hld/emoji/IEmojiContentViewListener;", "(Landroid/view/View;Lcom/tencent/mm/plugin/hld/emoji/IEmojiContentViewListener;)V", "emojiData", "Lcom/tencent/mm/protocal/protobuf/WxImeEmojiData;", "kaoemojiTv", "Landroid/widget/TextView;", "mListener", "rootView", "Landroid/widget/RelativeLayout;", "fillContent", "", "onClick", "v", "plugin-hld_release"})
public final class p
  extends RecyclerView.v
  implements View.OnClickListener
{
  private RelativeLayout DtO;
  private final a DvT;
  TextView DwI;
  fmu Dwk;
  
  public p(View paramView, a parama)
  {
    super(paramView);
    AppMethodBeat.i(211082);
    View localView = paramView.findViewById(a.f.root);
    kotlin.g.b.p.j(localView, "itemView.findViewById(R.id.root)");
    this.DtO = ((RelativeLayout)localView);
    paramView = paramView.findViewById(a.f.kaoemoji_text);
    kotlin.g.b.p.j(paramView, "itemView.findViewById(R.id.kaoemoji_text)");
    this.DwI = ((TextView)paramView);
    this.DvT = parama;
    paramView = com.tencent.mm.plugin.hld.view.g.DIP;
    com.tencent.mm.plugin.hld.view.g.a((View)this.DtO, (View.OnClickListener)this);
    AppMethodBeat.o(211082);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(211081);
    Object localObject = new b();
    ((b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/emoji/ImeKaoEmojiGridViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
    localObject = new StringBuilder("onClick ");
    paramView = this.Dwk;
    if (paramView != null) {}
    for (paramView = paramView.content;; paramView = null)
    {
      Log.d("WxIme.ImeKaoEmojiGridAdapter", paramView);
      paramView = this.DvT;
      if (paramView != null)
      {
        paramView.a(this.Dwk);
        com.tencent.mm.plugin.hld.model.g.DCm.Ux(com.tencent.mm.plugin.hld.model.g.eEo());
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/emoji/ImeKaoEmojiGridViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(211081);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.emoji.p
 * JD-Core Version:    0.7.0.1
 */