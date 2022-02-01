package com.tencent.mm.plugin.finder.convert;

import android.graphics.Paint;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.model.b;
import com.tencent.mm.ui.aw;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderMoreSimilarTopicConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/BaseLocalFeed;", "()V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bc
  extends f<b>
{
  public static final a ALi;
  private static int ALj;
  
  static
  {
    AppMethodBeat.i(350274);
    ALi = new a((byte)0);
    ALj = -2;
    AppMethodBeat.o(350274);
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(350285);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    paramj.tag = Integer.valueOf(ALj);
    paramj.caK.setTag(Integer.valueOf(ALj));
    aw.a((Paint)((TextView)paramj.UH(e.e.finder_similar_feed_tv)).getPaint(), 0.8F);
    AppMethodBeat.o(350285);
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_more_similar_feed_layout;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderMoreSimilarTopicConvert$Companion;", "", "()V", "VIEW_TYPE_MORE_SIMILAR", "", "getVIEW_TYPE_MORE_SIMILAR", "()I", "setVIEW_TYPE_MORE_SIMILAR", "(I)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.bc
 * JD-Core Version:    0.7.0.1
 */