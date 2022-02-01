package com.tencent.mm.plugin.hld.emoji;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.f.g;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiSubTypeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiSubTypeViewHolder;", "typeName", "", "subTypeList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiSubTypeData;", "Lkotlin/collections/ArrayList;", "selectedPosition", "", "listener", "Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiSubTypeViewHolder$IAlternativePyViewListener;", "(Ljava/lang/String;Ljava/util/ArrayList;ILcom/tencent/mm/plugin/hld/emoji/ImeEmojiSubTypeViewHolder$IAlternativePyViewListener;)V", "getListener", "()Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiSubTypeViewHolder$IAlternativePyViewListener;", "getItemCount", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "p1", "setSelection", "context", "Landroid/content/Context;", "Companion", "plugin-hld_release"})
public final class j
  extends RecyclerView.a<l>
{
  public static final a Dwp;
  private final ArrayList<k> Dwn;
  private final l.a Dwo;
  private int bFx;
  private final String typeName;
  
  static
  {
    AppMethodBeat.i(217258);
    Dwp = new a((byte)0);
    AppMethodBeat.o(217258);
  }
  
  public j(String paramString, ArrayList<k> paramArrayList, int paramInt, l.a parama)
  {
    AppMethodBeat.i(217257);
    this.typeName = paramString;
    this.Dwn = paramArrayList;
    this.bFx = paramInt;
    this.Dwo = parama;
    AppMethodBeat.o(217257);
  }
  
  public final void au(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(217256);
    p.k(paramContext, "context");
    Log.i("WxIme.ImeEmojiSubTypeAdapter", "setSelection: %s", new Object[] { Integer.valueOf(paramInt) });
    if (this.bFx != paramInt)
    {
      cL(this.bFx);
      this.bFx = paramInt;
      cL(this.bFx);
      Object localObject = g.DHh;
      localObject = this.typeName;
      g localg = g.DHh;
      g.ir((String)localObject, ((k)g.be(paramContext, this.typeName).get(paramInt)).typeName);
    }
    AppMethodBeat.o(217256);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(217255);
    int i = this.Dwn.size();
    AppMethodBeat.o(217255);
    return i;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiSubTypeAdapter$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.emoji.j
 * JD-Core Version:    0.7.0.1
 */