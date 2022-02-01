package com.tencent.mm.plugin.hld.symbol;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.f.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolGridAdapter;", "Lcom/tencent/mm/plugin/hld/view/ImeFourGridBaseAdapter;", "Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolGridViewHolder;", "Lcom/tencent/mm/plugin/hld/utils/WxImeSymbolData;", "context", "Landroid/content/Context;", "symbolList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "symbolType", "", "listener", "Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolGridViewHolder$ISymbolGridViewListener;", "(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolGridViewHolder$ISymbolGridViewListener;)V", "getContext", "()Landroid/content/Context;", "itemWidth", "", "mListener", "textView", "Landroid/widget/TextView;", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "", "viewHolder", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "updateData", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dataList", "", "arg", "holdPosition", "", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends com.tencent.mm.plugin.hld.view.e<e, j>
{
  public static final d.a JwT;
  private ArrayList<j> JwQ;
  private String JwU;
  private final e.a JwV;
  private final Context context;
  private TextView dyR;
  private int wLI;
  
  static
  {
    AppMethodBeat.i(312182);
    JwT = new d.a((byte)0);
    AppMethodBeat.o(312182);
  }
  
  public d(Context paramContext, ArrayList<j> paramArrayList, String paramString, e.a parama)
  {
    AppMethodBeat.i(312171);
    this.context = paramContext;
    this.JwQ = paramArrayList;
    this.JwU = paramString;
    this.JwV = parama;
    AppMethodBeat.o(312171);
  }
  
  public final void a(RecyclerView paramRecyclerView, List<j> paramList, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(312226);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramList, "dataList");
    s.u(paramString, "arg");
    this.JwQ.clear();
    this.JwQ.addAll((Collection)paramList);
    this.JwU = paramString;
    this.bZE.notifyChanged();
    iC((List)this.JwQ);
    paramList = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(paramRecyclerView, paramList.aYi(), "com/tencent/mm/plugin/hld/symbol/ImeSymbolGridAdapter", "updateData", "(Landroidx/recyclerview/widget/RecyclerView;Ljava/util/List;Ljava/lang/String;Z)V", "Undefined", "scrollToPosition", "(I)V");
    paramRecyclerView.scrollToPosition(((Integer)paramList.sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(paramRecyclerView, "com/tencent/mm/plugin/hld/symbol/ImeSymbolGridAdapter", "updateData", "(Landroidx/recyclerview/widget/RecyclerView;Ljava/util/List;Ljava/lang/String;Z)V", "Undefined", "scrollToPosition", "(I)V");
    AppMethodBeat.o(312226);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(312194);
    int i = this.JwQ.size();
    AppMethodBeat.o(312194);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(312205);
    if (fPr().containsKey(Integer.valueOf(paramInt)))
    {
      localObject = fPr().get(Integer.valueOf(paramInt));
      s.checkNotNull(localObject);
      s.s(localObject, "viewTypeCacheMap[position]!!");
      paramInt = ((Number)localObject).intValue();
      AppMethodBeat.o(312205);
      return paramInt;
    }
    if (this.wLI == 0) {
      this.wLI = (this.context.getResources().getDisplayMetrics().widthPixels / 5);
    }
    if (this.dyR == null)
    {
      this.dyR = new TextView(this.context);
      localObject = this.dyR;
      s.checkNotNull(localObject);
      ((TextView)localObject).setTextSize(0, com.tencent.mm.cd.a.bs(this.context, a.d.S5_keys_button_text_size));
    }
    Object localObject = ((j)this.JwQ.get(paramInt)).content;
    TextView localTextView = this.dyR;
    s.checkNotNull(localTextView);
    paramInt = (int)localTextView.getPaint().measureText((String)localObject) / this.wLI + 1;
    if (paramInt > 4)
    {
      AppMethodBeat.o(312205);
      return 4;
    }
    AppMethodBeat.o(312205);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.symbol.d
 * JD-Core Version:    0.7.0.1
 */