package com.tencent.mm.plugin.hld.emoji;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiContentAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiContentViewHolder;", "context", "Landroid/content/Context;", "emojiSubTypeList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiSubTypeData;", "Lkotlin/collections/ArrayList;", "listener", "Lcom/tencent/mm/plugin/hld/emoji/IEmojiContentViewListener;", "(Landroid/content/Context;Ljava/util/ArrayList;Lcom/tencent/mm/plugin/hld/emoji/IEmojiContentViewListener;)V", "getContext", "()Landroid/content/Context;", "mListener", "getItemCount", "", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends RecyclerView.a<e>
{
  public static final d.a JoZ;
  private ArrayList<k> Jpa;
  private final a Jpb;
  private final Context context;
  
  static
  {
    AppMethodBeat.i(312705);
    JoZ = new d.a((byte)0);
    AppMethodBeat.o(312705);
  }
  
  public d(Context paramContext, ArrayList<k> paramArrayList, a parama)
  {
    AppMethodBeat.i(312699);
    this.context = paramContext;
    this.Jpa = paramArrayList;
    this.Jpb = parama;
    AppMethodBeat.o(312699);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(312713);
    int i = this.Jpa.size();
    AppMethodBeat.o(312713);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.emoji.d
 * JD-Core Version:    0.7.0.1
 */