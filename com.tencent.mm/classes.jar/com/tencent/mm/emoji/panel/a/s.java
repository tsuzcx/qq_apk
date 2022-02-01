package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.b.ae;
import com.tencent.mm.emoji.c.b.h;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.m.a.g;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/panel/adapter/SearchEmojiHeadViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "searchMore", "kotlin.jvm.PlatformType", "getSearchMore", "()Landroid/view/View;", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class s
  extends q<h>
{
  private final View mlw;
  
  public s(View paramView, n paramn)
  {
    super(paramView, paramn);
    AppMethodBeat.i(242415);
    this.mlw = paramView.findViewById(a.g.search_more_emoji);
    AppMethodBeat.o(242415);
  }
  
  private static final void a(s params, View paramView)
  {
    AppMethodBeat.i(242423);
    Object localObject1 = new Object();
    Object localObject2 = new b();
    ((b)localObject2).cH(params);
    ((b)localObject2).cH(paramView);
    a.c("com/tencent/mm/emoji/panel/adapter/SearchEmojiHeadViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((b)localObject2).aYj());
    kotlin.g.b.s.u(params, "this$0");
    localObject1 = params.aVS();
    if (localObject1 != null)
    {
      localObject2 = paramView.getContext();
      kotlin.g.b.s.s(localObject2, "it.context");
      ((n)localObject1).a(paramView, (Context)localObject2, params.KJ(), params.aVT());
    }
    a.a(new Object(), "com/tencent/mm/emoji/panel/adapter/SearchEmojiHeadViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(242423);
  }
  
  public final void a(ae paramae)
  {
    AppMethodBeat.i(242428);
    kotlin.g.b.s.u(paramae, "item");
    super.a(paramae);
    this.mlw.setVisibility(0);
    this.mlw.setOnClickListener(new s..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(242428);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.s
 * JD-Core Version:    0.7.0.1
 */