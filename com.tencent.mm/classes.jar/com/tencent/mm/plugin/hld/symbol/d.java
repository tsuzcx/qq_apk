package com.tencent.mm.plugin.hld.symbol;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.f.j;
import com.tencent.mm.plugin.hld.view.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolGridAdapter;", "Lcom/tencent/mm/plugin/hld/view/ImeFourGridBaseAdapter;", "Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolGridViewHolder;", "Lcom/tencent/mm/plugin/hld/utils/WxImeSymbolData;", "context", "Landroid/content/Context;", "symbolList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "symbolType", "", "listener", "Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolGridViewHolder$ISymbolGridViewListener;", "(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolGridViewHolder$ISymbolGridViewListener;)V", "getContext", "()Landroid/content/Context;", "itemWidth", "", "mListener", "textView", "Landroid/widget/TextView;", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "", "viewHolder", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "updateData", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dataList", "", "arg", "holdPosition", "", "Companion", "plugin-hld_release"})
public final class d
  extends f<e, j>
{
  public static final a DFo;
  private ArrayList<j> DFi;
  private final e.a DFm;
  private String DFn;
  private TextView bFR;
  private final Context context;
  private int tHY;
  
  static
  {
    AppMethodBeat.i(210503);
    DFo = new a((byte)0);
    AppMethodBeat.o(210503);
  }
  
  public d(Context paramContext, ArrayList<j> paramArrayList, String paramString, e.a parama)
  {
    AppMethodBeat.i(210501);
    this.context = paramContext;
    this.DFi = paramArrayList;
    this.DFn = paramString;
    this.DFm = parama;
    AppMethodBeat.o(210501);
  }
  
  public final void a(RecyclerView paramRecyclerView, List<j> paramList, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(210499);
    p.k(paramRecyclerView, "recyclerView");
    p.k(paramList, "dataList");
    p.k(paramString, "arg");
    this.DFi.clear();
    this.DFi.addAll((Collection)paramList);
    this.DFn = paramString;
    notifyDataSetChanged();
    fF((List)this.DFi);
    paramList = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(paramRecyclerView, paramList.aFh(), "com/tencent/mm/plugin/hld/symbol/ImeSymbolGridAdapter", "updateData", "(Landroidx/recyclerview/widget/RecyclerView;Ljava/util/List;Ljava/lang/String;Z)V", "Undefined", "scrollToPosition", "(I)V");
    paramRecyclerView.scrollToPosition(((Integer)paramList.sf(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(paramRecyclerView, "com/tencent/mm/plugin/hld/symbol/ImeSymbolGridAdapter", "updateData", "(Landroidx/recyclerview/widget/RecyclerView;Ljava/util/List;Ljava/lang/String;Z)V", "Undefined", "scrollToPosition", "(I)V");
    AppMethodBeat.o(210499);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(210497);
    int i = this.DFi.size();
    AppMethodBeat.o(210497);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(210498);
    if (eHF().containsKey(Integer.valueOf(paramInt)))
    {
      localObject = eHF().get(Integer.valueOf(paramInt));
      if (localObject == null) {
        p.iCn();
      }
      paramInt = ((Number)localObject).intValue();
      AppMethodBeat.o(210498);
      return paramInt;
    }
    if (this.tHY == 0)
    {
      localObject = this.context.getResources();
      p.j(localObject, "context.resources");
      this.tHY = (((Resources)localObject).getDisplayMetrics().widthPixels / 5);
    }
    if (this.bFR == null)
    {
      this.bFR = new TextView(this.context);
      localObject = this.bFR;
      if (localObject == null) {
        p.iCn();
      }
      ((TextView)localObject).setTextSize(0, com.tencent.mm.ci.a.aZ(this.context, a.d.S5_keys_button_text_size));
    }
    Object localObject = ((j)this.DFi.get(paramInt)).content;
    TextView localTextView = this.bFR;
    if (localTextView == null) {
      p.iCn();
    }
    paramInt = (int)localTextView.getPaint().measureText((String)localObject) / this.tHY + 1;
    if (paramInt > 4)
    {
      AppMethodBeat.o(210498);
      return 4;
    }
    AppMethodBeat.o(210498);
    return paramInt;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolGridAdapter$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.symbol.d
 * JD-Core Version:    0.7.0.1
 */