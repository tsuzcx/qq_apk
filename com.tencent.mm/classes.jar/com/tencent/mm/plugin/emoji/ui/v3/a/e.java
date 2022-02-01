package com.tencent.mm.plugin.emoji.ui.v3.a;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3BaseHolder;", "I", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/IEmojiStoreTypeItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/IEmojiStoreV3ClickListener;", "(Landroid/view/View;Lcom/tencent/mm/plugin/emoji/ui/v3/model/IEmojiStoreV3ClickListener;)V", "item", "getItem$plugin_emoji_release", "()Lcom/tencent/mm/plugin/emoji/ui/v3/model/IEmojiStoreTypeItem;", "setItem$plugin_emoji_release", "(Lcom/tencent/mm/plugin/emoji/ui/v3/model/IEmojiStoreTypeItem;)V", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/IEmojiStoreTypeItem;", "getOnClick", "()Lcom/tencent/mm/plugin/emoji/ui/v3/model/IEmojiStoreV3ClickListener;", "setOnClick", "(Lcom/tencent/mm/plugin/emoji/ui/v3/model/IEmojiStoreV3ClickListener;)V", "onBind", "", "dataItem", "payloads", "", "", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public class e<I extends t>
  extends RecyclerView.v
{
  private u ybJ;
  private I ybK;
  
  public e(View paramView, u paramu)
  {
    super(paramView);
    AppMethodBeat.i(270630);
    this.ybJ = paramu;
    paramView.setOnClickListener(new e..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(270630);
  }
  
  private static final void a(e parame, View paramView)
  {
    AppMethodBeat.i(270646);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parame);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3BaseHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parame, "this$0");
    paramView = parame.ybJ;
    if (paramView != null) {
      paramView.a(parame, parame.KJ(), parame.ybK);
    }
    a.a(new Object(), "com/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3BaseHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(270646);
  }
  
  public void a(t paramt)
  {
    AppMethodBeat.i(270663);
    s.u(paramt, "dataItem");
    this.ybK = paramt;
    AppMethodBeat.o(270663);
  }
  
  public void a(t paramt, List<Object> paramList)
  {
    AppMethodBeat.i(270668);
    s.u(paramt, "item");
    s.u(paramList, "payloads");
    this.ybK = paramt;
    AppMethodBeat.o(270668);
  }
  
  public final u dDa()
  {
    return this.ybJ;
  }
  
  public final I dDb()
  {
    return this.ybK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v3.a.e
 * JD-Core Version:    0.7.0.1
 */