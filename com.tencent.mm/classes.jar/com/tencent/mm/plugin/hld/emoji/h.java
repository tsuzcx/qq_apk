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
import com.tencent.mm.plugin.hld.f.d;
import com.tencent.mm.plugin.hld.f.e;
import com.tencent.mm.plugin.hld.f.l;
import com.tencent.mm.plugin.hld.view.f;
import com.tencent.mm.protocal.protobuf.gjm;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiGridViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "itemView", "Landroid/view/View;", "listener", "Lcom/tencent/mm/plugin/hld/emoji/IEmojiContentViewListener;", "(Landroid/view/View;Lcom/tencent/mm/plugin/hld/emoji/IEmojiContentViewListener;)V", "emojiData", "Lcom/tencent/mm/protocal/protobuf/WxImeEmojiData;", "emojiIv", "Landroid/widget/ImageView;", "emojiTv", "Landroid/widget/TextView;", "mListener", "rootView", "Landroid/widget/RelativeLayout;", "fillContent", "", "onClick", "v", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends RecyclerView.v
  implements View.OnClickListener
{
  RelativeLayout Ikt;
  private final a Jpb;
  TextView Jpo;
  ImageView Jpp;
  gjm Jpq;
  
  public h(View paramView, a parama)
  {
    super(paramView);
    AppMethodBeat.i(312702);
    View localView = paramView.findViewById(a.f.root);
    s.s(localView, "itemView.findViewById(R.id.root)");
    this.Ikt = ((RelativeLayout)localView);
    localView = paramView.findViewById(a.f.emoji_text);
    s.s(localView, "itemView.findViewById(R.id.emoji_text)");
    this.Jpo = ((TextView)localView);
    paramView = paramView.findViewById(a.f.emoji_icon);
    s.s(paramView, "itemView.findViewById(R.id.emoji_icon)");
    this.Jpp = ((ImageView)paramView);
    this.Jpb = parama;
    f.JzR.a((View)this.Ikt, (View.OnClickListener)this);
    AppMethodBeat.o(312702);
  }
  
  public final void onClick(View paramView)
  {
    Object localObject = null;
    AppMethodBeat.i(312711);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/emoji/ImeEmojiGridViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    paramView = l.JyV;
    paramView = this.Jpq;
    if (paramView == null)
    {
      paramView = null;
      l.jC("WxIme.ImeEmojiGridAdapter", s.X("onClick ", paramView));
      paramView = e.Jym;
      if (e.fNV())
      {
        paramView = d.Jyl;
        paramView = this.Jpq;
        if (paramView != null) {
          break label136;
        }
      }
    }
    label136:
    for (paramView = localObject;; paramView = paramView.Trr)
    {
      d.aIy(paramView);
      paramView = this.Jpb;
      if (paramView != null) {
        paramView.a(this.Jpq);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/emoji/ImeEmojiGridViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(312711);
      return;
      paramView = paramView.Trr;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.emoji.h
 * JD-Core Version:    0.7.0.1
 */