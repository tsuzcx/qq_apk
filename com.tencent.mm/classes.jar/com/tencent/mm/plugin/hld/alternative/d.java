package com.tencent.mm.plugin.hld.alternative;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.wxhld.info.Candidate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/alternative/ImeAlternativeWordGridAdapter;", "Lcom/tencent/mm/plugin/hld/view/ImeFourGridBaseAdapter;", "Lcom/tencent/mm/plugin/hld/alternative/ImeAlternativeWordGridViewHolder;", "Lcom/tencent/wxhld/info/Candidate;", "context", "Landroid/content/Context;", "candidateList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "listener", "Lcom/tencent/mm/plugin/hld/alternative/ImeAlternativeWordGridViewHolder$IAlternativeWordViewListener;", "(Landroid/content/Context;Ljava/util/ArrayList;Lcom/tencent/mm/plugin/hld/alternative/ImeAlternativeWordGridViewHolder$IAlternativeWordViewListener;)V", "getContext", "()Landroid/content/Context;", "footView", "Landroid/view/View;", "itemWidth", "", "mListener", "textView", "Landroid/widget/TextView;", "getFootView", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "", "viewHolder", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "setFootView", "view", "updateData", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dataList", "", "arg", "", "holdPosition", "", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends com.tencent.mm.plugin.hld.view.e<e, Candidate>
{
  public static final d.a Jnr;
  private ArrayList<Candidate> Jns;
  private final e.a Jnt;
  private final Context context;
  private TextView dyR;
  View qkB;
  private int wLI;
  
  static
  {
    AppMethodBeat.i(311693);
    Jnr = new d.a((byte)0);
    AppMethodBeat.o(311693);
  }
  
  public d(Context paramContext, ArrayList<Candidate> paramArrayList, e.a parama)
  {
    AppMethodBeat.i(311680);
    this.context = paramContext;
    this.Jns = paramArrayList;
    this.Jnt = parama;
    AppMethodBeat.o(311680);
  }
  
  public final void a(RecyclerView paramRecyclerView, List<? extends Candidate> paramList, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(311716);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramList, "dataList");
    s.u(paramString, "arg");
    this.Jns.clear();
    if (!paramBoolean)
    {
      paramString = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(paramRecyclerView, paramString.aYi(), "com/tencent/mm/plugin/hld/alternative/ImeAlternativeWordGridAdapter", "updateData", "(Landroidx/recyclerview/widget/RecyclerView;Ljava/util/List;Ljava/lang/String;Z)V", "Undefined", "scrollToPosition", "(I)V");
      paramRecyclerView.scrollToPosition(((Integer)paramString.sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramRecyclerView, "com/tencent/mm/plugin/hld/alternative/ImeAlternativeWordGridAdapter", "updateData", "(Landroidx/recyclerview/widget/RecyclerView;Ljava/util/List;Ljava/lang/String;Z)V", "Undefined", "scrollToPosition", "(I)V");
    }
    this.Jns.addAll((Collection)paramList);
    iC((List)this.Jns);
    this.bZE.notifyChanged();
    AppMethodBeat.o(311716);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(311705);
    if (this.qkB != null)
    {
      i = this.Jns.size();
      AppMethodBeat.o(311705);
      return i + 1;
    }
    int i = this.Jns.size();
    AppMethodBeat.o(311705);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(311734);
    Object localObject1;
    if (fPr().containsKey(Integer.valueOf(paramInt)))
    {
      localObject1 = fPr().get(Integer.valueOf(paramInt));
      s.checkNotNull(localObject1);
      s.s(localObject1, "viewTypeCacheMap[position]!!");
      paramInt = ((Number)localObject1).intValue();
      AppMethodBeat.o(311734);
      return paramInt;
    }
    for (;;)
    {
      try
      {
        if (this.wLI == 0) {
          this.wLI = (this.context.getResources().getDisplayMetrics().widthPixels / 5);
        }
        if (this.dyR == null)
        {
          this.dyR = new TextView(this.context);
          localObject1 = this.dyR;
          s.checkNotNull(localObject1);
          ((TextView)localObject1).setTextSize(0, com.tencent.mm.cd.a.bs(this.context, a.d.S5_keys_button_text_size));
        }
        if (paramInt < this.Jns.size())
        {
          localObject1 = ((Candidate)this.Jns.get(paramInt)).text;
          if (paramInt >= this.Jns.size()) {
            break label272;
          }
          TextView localTextView = this.dyR;
          s.checkNotNull(localTextView);
          paramInt = (int)localTextView.getPaint().measureText((String)localObject1) / this.wLI + 1;
          if (paramInt > 4)
          {
            AppMethodBeat.o(311734);
            return 4;
          }
          AppMethodBeat.o(311734);
          return paramInt;
        }
      }
      catch (Exception localException)
      {
        Log.e("WxIme.ImeAlternativeWordGridAdapter", "getItemViewType " + localException.getClass().getSimpleName() + ", " + localException.getMessage());
        AppMethodBeat.o(311734);
        return 1;
      }
      Object localObject2 = null;
      continue;
      label272:
      paramInt = 4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.alternative.d
 * JD-Core Version:    0.7.0.1
 */