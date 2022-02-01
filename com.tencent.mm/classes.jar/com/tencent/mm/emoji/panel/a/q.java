package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.b.ae;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "I", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "getOnClick", "()Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "setOnClick", "(Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "panelItem", "getPanelItem", "()Lcom/tencent/mm/emoji/model/panel/PanelItem;", "setPanelItem", "(Lcom/tencent/mm/emoji/model/panel/PanelItem;)V", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "onBind", "", "item", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public class q<I extends ae>
  extends RecyclerView.v
{
  private n mlu;
  private I mlv;
  
  public q(View paramView, n paramn)
  {
    super(paramView);
    AppMethodBeat.i(105679);
    this.mlu = paramn;
    paramView.setOnClickListener(new q..ExternalSyntheticLambda0(this));
    paramView.setOnLongClickListener(new q..ExternalSyntheticLambda1(this));
    AppMethodBeat.o(105679);
  }
  
  private static final void a(q paramq, View paramView)
  {
    AppMethodBeat.i(242394);
    Object localObject1 = new Object();
    Object localObject2 = new b();
    ((b)localObject2).cH(paramq);
    ((b)localObject2).cH(paramView);
    a.c("com/tencent/mm/emoji/panel/adapter/PanelViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((b)localObject2).aYj());
    s.u(paramq, "this$0");
    localObject1 = paramq.mlu;
    if (localObject1 != null)
    {
      localObject2 = paramView.getContext();
      s.s(localObject2, "it.context");
      ((n)localObject1).a(paramView, (Context)localObject2, paramq.KJ(), paramq.mlv);
    }
    a.a(new Object(), "com/tencent/mm/emoji/panel/adapter/PanelViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(242394);
  }
  
  private static final boolean b(q paramq, View paramView)
  {
    AppMethodBeat.i(242401);
    Object localObject1 = new Object();
    Object localObject2 = new b();
    ((b)localObject2).cH(paramq);
    ((b)localObject2).cH(paramView);
    a.c("com/tencent/mm/emoji/panel/adapter/PanelViewHolder", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject1, ((b)localObject2).aYj());
    s.u(paramq, "this$0");
    localObject1 = paramq.mlu;
    if (localObject1 != null)
    {
      localObject2 = paramView.getContext();
      s.s(localObject2, "it.context");
      ((n)localObject1).a(paramView, (Context)localObject2, paramq.KJ());
    }
    a.a(true, new Object(), "com/tencent/mm/emoji/panel/adapter/PanelViewHolder", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(242401);
    return true;
  }
  
  public void a(ae paramae)
  {
    AppMethodBeat.i(105678);
    s.u(paramae, "item");
    this.mlv = paramae;
    AppMethodBeat.o(105678);
  }
  
  public final n aVS()
  {
    return this.mlu;
  }
  
  protected final I aVT()
  {
    return this.mlv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.q
 * JD-Core Version:    0.7.0.1
 */