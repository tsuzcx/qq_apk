package com.tencent.mm.plugin.hld.emoji;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiContentAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiContentViewHolder;", "context", "Landroid/content/Context;", "emojiSubTypeList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiSubTypeData;", "Lkotlin/collections/ArrayList;", "listener", "Lcom/tencent/mm/plugin/hld/emoji/IEmojiContentViewListener;", "(Landroid/content/Context;Ljava/util/ArrayList;Lcom/tencent/mm/plugin/hld/emoji/IEmojiContentViewListener;)V", "getContext", "()Landroid/content/Context;", "mListener", "getItemCount", "", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "Companion", "plugin-hld_release"})
public final class d
  extends RecyclerView.a<e>
{
  public static final a DvV;
  private final a DvT;
  private ArrayList<k> DvU;
  private final Context context;
  
  static
  {
    AppMethodBeat.i(213078);
    DvV = new a((byte)0);
    AppMethodBeat.o(213078);
  }
  
  public d(Context paramContext, ArrayList<k> paramArrayList, a parama)
  {
    AppMethodBeat.i(213074);
    this.context = paramContext;
    this.DvU = paramArrayList;
    this.DvT = parama;
    AppMethodBeat.o(213074);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(213073);
    int i = this.DvU.size();
    AppMethodBeat.o(213073);
    return i;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiContentAdapter$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.emoji.d
 * JD-Core Version:    0.7.0.1
 */