package com.tencent.mm.plugin.hld.emoji;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/emoji/ImeKaoEmojiContentAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/hld/emoji/ImeKaoEmojiContentViewHolder;", "context", "Landroid/content/Context;", "kaoemojiSubTypeList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiSubTypeData;", "Lkotlin/collections/ArrayList;", "listener", "Lcom/tencent/mm/plugin/hld/emoji/IEmojiContentViewListener;", "(Landroid/content/Context;Ljava/util/ArrayList;Lcom/tencent/mm/plugin/hld/emoji/IEmojiContentViewListener;)V", "getContext", "()Landroid/content/Context;", "mListener", "getItemCount", "", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends RecyclerView.a<n>
{
  public static final m.a JpH;
  private ArrayList<k> JpI;
  private final a Jpb;
  private final Context context;
  
  static
  {
    AppMethodBeat.i(312691);
    JpH = new m.a((byte)0);
    AppMethodBeat.o(312691);
  }
  
  public m(Context paramContext, ArrayList<k> paramArrayList, a parama)
  {
    AppMethodBeat.i(312683);
    this.context = paramContext;
    this.JpI = paramArrayList;
    this.Jpb = parama;
    AppMethodBeat.o(312683);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(312696);
    int i = this.JpI.size();
    AppMethodBeat.o(312696);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.emoji.m
 * JD-Core Version:    0.7.0.1
 */