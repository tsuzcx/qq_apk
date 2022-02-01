package com.tencent.mm.plugin.hld.emoji;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.view.f;
import com.tencent.mm.protocal.protobuf.fmu;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/emoji/ImeKaoEmojiGridAdapter;", "Lcom/tencent/mm/plugin/hld/view/ImeFourGridBaseAdapter;", "Lcom/tencent/mm/plugin/hld/emoji/ImeKaoEmojiGridViewHolder;", "Lcom/tencent/mm/protocal/protobuf/WxImeEmojiData;", "context", "Landroid/content/Context;", "emojiList", "Ljava/util/LinkedList;", "emojiSubType", "", "listener", "Lcom/tencent/mm/plugin/hld/emoji/IEmojiContentViewListener;", "(Landroid/content/Context;Ljava/util/LinkedList;Ljava/lang/String;Lcom/tencent/mm/plugin/hld/emoji/IEmojiContentViewListener;)V", "getContext", "()Landroid/content/Context;", "itemWidth", "", "mListener", "textView", "Landroid/widget/TextView;", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "", "viewHolder", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "updateData", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dataList", "", "arg", "holdPosition", "", "updateViewType", "Companion", "plugin-hld_release"})
public final class o
  extends f<p, fmu>
{
  public static final a DwH;
  private final a DvT;
  LinkedList<fmu> Dwe;
  private String Dwf;
  private TextView bFR;
  private final Context context;
  private int tHY;
  
  static
  {
    AppMethodBeat.i(214781);
    DwH = new a((byte)0);
    AppMethodBeat.o(214781);
  }
  
  public o(Context paramContext, LinkedList<fmu> paramLinkedList, String paramString, a parama)
  {
    AppMethodBeat.i(214780);
    this.context = paramContext;
    this.Dwe = paramLinkedList;
    this.Dwf = paramString;
    this.DvT = parama;
    AppMethodBeat.o(214780);
  }
  
  public final void a(RecyclerView paramRecyclerView, List<? extends fmu> paramList, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(214778);
    kotlin.g.b.p.k(paramRecyclerView, "recyclerView");
    kotlin.g.b.p.k(paramList, "dataList");
    kotlin.g.b.p.k(paramString, "arg");
    this.Dwe.clear();
    this.Dwe.addAll((Collection)paramList);
    fF((List)this.Dwe);
    notifyDataSetChanged();
    paramList = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(paramRecyclerView, paramList.aFh(), "com/tencent/mm/plugin/hld/emoji/ImeKaoEmojiGridAdapter", "updateData", "(Landroidx/recyclerview/widget/RecyclerView;Ljava/util/List;Ljava/lang/String;Z)V", "Undefined", "scrollToPosition", "(I)V");
    paramRecyclerView.scrollToPosition(((Integer)paramList.sf(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(paramRecyclerView, "com/tencent/mm/plugin/hld/emoji/ImeKaoEmojiGridAdapter", "updateData", "(Landroidx/recyclerview/widget/RecyclerView;Ljava/util/List;Ljava/lang/String;Z)V", "Undefined", "scrollToPosition", "(I)V");
    AppMethodBeat.o(214778);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(214775);
    int i = this.Dwe.size();
    AppMethodBeat.o(214775);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(214777);
    if (eHF().containsKey(Integer.valueOf(paramInt)))
    {
      localObject = eHF().get(Integer.valueOf(paramInt));
      if (localObject == null) {
        kotlin.g.b.p.iCn();
      }
      paramInt = ((Number)localObject).intValue();
      AppMethodBeat.o(214777);
      return paramInt;
    }
    if (this.tHY == 0)
    {
      localObject = this.context.getResources();
      kotlin.g.b.p.j(localObject, "context.resources");
      this.tHY = (((Resources)localObject).getDisplayMetrics().widthPixels / 4);
    }
    if (this.bFR == null)
    {
      this.bFR = new TextView(this.context);
      localObject = this.bFR;
      if (localObject == null) {
        kotlin.g.b.p.iCn();
      }
      ((TextView)localObject).setTextSize(0, com.tencent.mm.ci.a.aZ(this.context, a.d.S5_keys_button_text_size));
    }
    Object localObject = ((fmu)this.Dwe.get(paramInt)).content;
    TextView localTextView = this.bFR;
    if (localTextView == null) {
      kotlin.g.b.p.iCn();
    }
    paramInt = (int)localTextView.getPaint().measureText((String)localObject) / this.tHY + 1;
    if (paramInt > 4)
    {
      AppMethodBeat.o(214777);
      return 4;
    }
    AppMethodBeat.o(214777);
    return paramInt;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/emoji/ImeKaoEmojiGridAdapter$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.emoji.o
 * JD-Core Version:    0.7.0.1
 */