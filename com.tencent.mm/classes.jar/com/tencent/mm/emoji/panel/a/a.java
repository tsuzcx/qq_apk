package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.b.t;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.m.a.g;
import com.tencent.mm.plugin.m.a.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/panel/adapter/CaptureEmptyViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/GroupExpandItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "icon", "kotlin.jvm.PlatformType", "getIcon", "()Landroid/view/View;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends q<t>
{
  private final View mkH;
  
  public a(View paramView, n paramn)
  {
    super(paramView, paramn);
    AppMethodBeat.i(105627);
    this.mkH = paramView.findViewById(a.g.capture_emoji_empty_btn);
    paramView.setOnClickListener(null);
    this.mkH.setOnClickListener(new a..ExternalSyntheticLambda0(this));
    this.mkH.setContentDescription((CharSequence)this.mkH.getContext().getString(a.j.capture_my_emoji));
    AppMethodBeat.o(105627);
  }
  
  private static final void a(a parama, View paramView)
  {
    AppMethodBeat.i(242464);
    Object localObject1 = new Object();
    Object localObject2 = new b();
    ((b)localObject2).cH(parama);
    ((b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/emoji/panel/adapter/CaptureEmptyViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((b)localObject2).aYj());
    s.u(parama, "this$0");
    localObject1 = parama.aVS();
    if (localObject1 != null)
    {
      localObject2 = paramView.getContext();
      s.s(localObject2, "it.context");
      ((n)localObject1).a(paramView, (Context)localObject2, parama.KJ(), parama.aVT());
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/emoji/panel/adapter/CaptureEmptyViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(242464);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.a
 * JD-Core Version:    0.7.0.1
 */