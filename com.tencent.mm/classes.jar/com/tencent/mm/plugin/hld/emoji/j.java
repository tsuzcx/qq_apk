package com.tencent.mm.plugin.hld.emoji;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.f.g;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiSubTypeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiSubTypeViewHolder;", "typeName", "", "subTypeList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiSubTypeData;", "Lkotlin/collections/ArrayList;", "selectedPosition", "", "listener", "Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiSubTypeViewHolder$IAlternativePyViewListener;", "(Ljava/lang/String;Ljava/util/ArrayList;ILcom/tencent/mm/plugin/hld/emoji/ImeEmojiSubTypeViewHolder$IAlternativePyViewListener;)V", "getListener", "()Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiSubTypeViewHolder$IAlternativePyViewListener;", "getItemCount", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "p1", "setSelection", "context", "Landroid/content/Context;", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends RecyclerView.a<l>
{
  public static final j.a Jpt;
  private final ArrayList<k> Jpu;
  private final l.a Jpv;
  private int dyx;
  private final String typeName;
  
  static
  {
    AppMethodBeat.i(312714);
    Jpt = new j.a((byte)0);
    AppMethodBeat.o(312714);
  }
  
  public j(String paramString, ArrayList<k> paramArrayList, int paramInt, l.a parama)
  {
    AppMethodBeat.i(312706);
    this.typeName = paramString;
    this.Jpu = paramArrayList;
    this.dyx = paramInt;
    this.Jpv = parama;
    AppMethodBeat.o(312706);
  }
  
  public final void aH(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(312726);
    s.u(paramContext, "context");
    Log.i("WxIme.ImeEmojiSubTypeAdapter", "setSelection: %s", new Object[] { Integer.valueOf(paramInt) });
    if (this.dyx != paramInt)
    {
      fV(this.dyx);
      this.dyx = paramInt;
      fV(this.dyx);
      Object localObject = g.Jyo;
      localObject = this.typeName;
      g localg = g.Jyo;
      g.jA((String)localObject, ((k)g.bg(paramContext, this.typeName).get(paramInt)).typeName);
    }
    AppMethodBeat.o(312726);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(312720);
    int i = this.Jpu.size();
    AppMethodBeat.o(312720);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.emoji.j
 * JD-Core Version:    0.7.0.1
 */