package com.tencent.mm.plugin.hld.alternative;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.view.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.wxhld.info.Candidate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/alternative/ImeAlternativeWordGridAdapter;", "Lcom/tencent/mm/plugin/hld/view/ImeFourGridBaseAdapter;", "Lcom/tencent/mm/plugin/hld/alternative/ImeAlternativeWordGridViewHolder;", "Lcom/tencent/wxhld/info/Candidate;", "context", "Landroid/content/Context;", "candidateList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "listener", "Lcom/tencent/mm/plugin/hld/alternative/ImeAlternativeWordGridViewHolder$IAlternativeWordViewListener;", "(Landroid/content/Context;Ljava/util/ArrayList;Lcom/tencent/mm/plugin/hld/alternative/ImeAlternativeWordGridViewHolder$IAlternativeWordViewListener;)V", "getContext", "()Landroid/content/Context;", "footView", "Landroid/view/View;", "itemWidth", "", "mListener", "textView", "Landroid/widget/TextView;", "getFootView", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "", "viewHolder", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "setFootView", "view", "updateData", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dataList", "", "arg", "", "holdPosition", "", "Companion", "plugin-hld_release"})
public final class d
  extends f<e, Candidate>
{
  public static final a DtT;
  private final e.a DtR;
  private ArrayList<Candidate> DtS;
  private TextView bFR;
  private final Context context;
  View nnu;
  private int tHY;
  
  static
  {
    AppMethodBeat.i(217448);
    DtT = new a((byte)0);
    AppMethodBeat.o(217448);
  }
  
  public d(Context paramContext, ArrayList<Candidate> paramArrayList, e.a parama)
  {
    AppMethodBeat.i(217446);
    this.context = paramContext;
    this.DtS = paramArrayList;
    this.DtR = parama;
    AppMethodBeat.o(217446);
  }
  
  public final void a(RecyclerView paramRecyclerView, List<? extends Candidate> paramList, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(217441);
    p.k(paramRecyclerView, "recyclerView");
    p.k(paramList, "dataList");
    p.k(paramString, "arg");
    this.DtS.clear();
    if (!paramBoolean)
    {
      paramString = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(paramRecyclerView, paramString.aFh(), "com/tencent/mm/plugin/hld/alternative/ImeAlternativeWordGridAdapter", "updateData", "(Landroidx/recyclerview/widget/RecyclerView;Ljava/util/List;Ljava/lang/String;Z)V", "Undefined", "scrollToPosition", "(I)V");
      paramRecyclerView.scrollToPosition(((Integer)paramString.sf(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramRecyclerView, "com/tencent/mm/plugin/hld/alternative/ImeAlternativeWordGridAdapter", "updateData", "(Landroidx/recyclerview/widget/RecyclerView;Ljava/util/List;Ljava/lang/String;Z)V", "Undefined", "scrollToPosition", "(I)V");
    }
    this.DtS.addAll((Collection)paramList);
    fF((List)this.DtS);
    notifyDataSetChanged();
    AppMethodBeat.o(217441);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(217437);
    if (this.nnu != null)
    {
      i = this.DtS.size();
      AppMethodBeat.o(217437);
      return i + 1;
    }
    int i = this.DtS.size();
    AppMethodBeat.o(217437);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(217443);
    Object localObject1;
    if (eHF().containsKey(Integer.valueOf(paramInt)))
    {
      localObject1 = eHF().get(Integer.valueOf(paramInt));
      if (localObject1 == null) {
        p.iCn();
      }
      paramInt = ((Number)localObject1).intValue();
      AppMethodBeat.o(217443);
      return paramInt;
    }
    for (;;)
    {
      try
      {
        if (this.tHY == 0)
        {
          localObject1 = this.context.getResources();
          p.j(localObject1, "context.resources");
          this.tHY = (((Resources)localObject1).getDisplayMetrics().widthPixels / 5);
        }
        if (this.bFR == null)
        {
          this.bFR = new TextView(this.context);
          localObject1 = this.bFR;
          if (localObject1 == null) {
            p.iCn();
          }
          ((TextView)localObject1).setTextSize(0, com.tencent.mm.ci.a.aZ(this.context, a.d.S5_keys_button_text_size));
        }
        if (paramInt < this.DtS.size())
        {
          localObject1 = ((Candidate)this.DtS.get(paramInt)).text;
          if (paramInt >= this.DtS.size()) {
            break label283;
          }
          TextView localTextView = this.bFR;
          if (localTextView == null) {
            p.iCn();
          }
          paramInt = (int)localTextView.getPaint().measureText((String)localObject1) / this.tHY + 1;
          if (paramInt > 4)
          {
            AppMethodBeat.o(217443);
            return 4;
          }
          AppMethodBeat.o(217443);
          return paramInt;
        }
      }
      catch (Exception localException)
      {
        Log.e("WxIme.ImeAlternativeWordGridAdapter", "getItemViewType " + localException.getClass().getSimpleName() + ", " + localException.getMessage());
        AppMethodBeat.o(217443);
        return 1;
      }
      Object localObject2 = null;
      continue;
      label283:
      paramInt = 4;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/alternative/ImeAlternativeWordGridAdapter$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.alternative.d
 * JD-Core Version:    0.7.0.1
 */