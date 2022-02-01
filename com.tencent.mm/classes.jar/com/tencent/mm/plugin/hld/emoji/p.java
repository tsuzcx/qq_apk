package com.tencent.mm.plugin.hld.emoji;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.hld.a.f;
import com.tencent.mm.plugin.hld.model.g;
import com.tencent.mm.plugin.hld.view.f;
import com.tencent.mm.protocal.protobuf.gjm;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/emoji/ImeKaoEmojiGridViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "itemView", "Landroid/view/View;", "listener", "Lcom/tencent/mm/plugin/hld/emoji/IEmojiContentViewListener;", "(Landroid/view/View;Lcom/tencent/mm/plugin/hld/emoji/IEmojiContentViewListener;)V", "emojiData", "Lcom/tencent/mm/protocal/protobuf/WxImeEmojiData;", "kaoemojiTv", "Landroid/widget/TextView;", "mListener", "rootView", "Landroid/widget/RelativeLayout;", "fillContent", "", "onClick", "v", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
  extends RecyclerView.v
  implements View.OnClickListener
{
  private RelativeLayout Ikt;
  TextView JpO;
  private final a Jpb;
  gjm Jpq;
  
  public p(View paramView, a parama)
  {
    super(paramView);
    AppMethodBeat.i(312682);
    View localView = paramView.findViewById(a.f.root);
    s.s(localView, "itemView.findViewById(R.id.root)");
    this.Ikt = ((RelativeLayout)localView);
    paramView = paramView.findViewById(a.f.kaoemoji_text);
    s.s(paramView, "itemView.findViewById(R.id.kaoemoji_text)");
    this.JpO = ((TextView)paramView);
    this.Jpb = parama;
    f.JzR.a((View)this.Ikt, (View.OnClickListener)this);
    AppMethodBeat.o(312682);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(312689);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/emoji/ImeKaoEmojiGridViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    paramView = this.Jpq;
    if (paramView == null) {}
    for (paramView = null;; paramView = paramView.content)
    {
      Log.d("WxIme.ImeKaoEmojiGridAdapter", s.X("onClick ", paramView));
      paramView = this.Jpb;
      if (paramView != null)
      {
        paramView.a(this.Jpq);
        g.JuL.Yu(g.fMq());
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/emoji/ImeKaoEmojiGridViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(312689);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.emoji.p
 * JD-Core Version:    0.7.0.1
 */