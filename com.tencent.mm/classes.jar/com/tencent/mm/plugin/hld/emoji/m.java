package com.tencent.mm.plugin.hld.emoji;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/emoji/ImeKaoEmojiContentAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/hld/emoji/ImeKaoEmojiContentViewHolder;", "context", "Landroid/content/Context;", "kaoemojiSubTypeList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiSubTypeData;", "Lkotlin/collections/ArrayList;", "listener", "Lcom/tencent/mm/plugin/hld/emoji/IEmojiContentViewListener;", "(Landroid/content/Context;Ljava/util/ArrayList;Lcom/tencent/mm/plugin/hld/emoji/IEmojiContentViewListener;)V", "getContext", "()Landroid/content/Context;", "mListener", "getItemCount", "", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "Companion", "plugin-hld_release"})
public final class m
  extends RecyclerView.a<n>
{
  public static final a DwC;
  private final a DvT;
  private ArrayList<k> DwB;
  private final Context context;
  
  static
  {
    AppMethodBeat.i(214665);
    DwC = new a((byte)0);
    AppMethodBeat.o(214665);
  }
  
  public m(Context paramContext, ArrayList<k> paramArrayList, a parama)
  {
    AppMethodBeat.i(214662);
    this.context = paramContext;
    this.DwB = paramArrayList;
    this.DvT = parama;
    AppMethodBeat.o(214662);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(214661);
    int i = this.DwB.size();
    AppMethodBeat.o(214661);
    return i;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/emoji/ImeKaoEmojiContentAdapter$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.emoji.m
 * JD-Core Version:    0.7.0.1
 */