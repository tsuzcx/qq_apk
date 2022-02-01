package com.tencent.mm.emoji.debug;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$DebugAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI$DebugViewHolder;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI;", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class EmojiDebugUI$e
  extends RecyclerView.a<EmojiDebugUI.f>
{
  public EmojiDebugUI$e()
  {
    AppMethodBeat.i(242226);
    AppMethodBeat.o(242226);
  }
  
  private static final void a(EmojiDebugUI paramEmojiDebugUI, int paramInt, View paramView)
  {
    AppMethodBeat.i(242231);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramEmojiDebugUI);
    localb.sc(paramInt);
    localb.cH(paramView);
    a.c("com/tencent/mm/emoji/debug/EmojiDebugUI$DebugAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramEmojiDebugUI, "this$0");
    ((EmojiDebugUI.a)EmojiDebugUI.c(paramEmojiDebugUI).get(paramInt)).onClick();
    a.a(new Object(), "com/tencent/mm/emoji/debug/EmojiDebugUI$DebugAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(242231);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(105339);
    int i = EmojiDebugUI.c(this.meA).size();
    AppMethodBeat.o(105339);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.debug.EmojiDebugUI.e
 * JD-Core Version:    0.7.0.1
 */