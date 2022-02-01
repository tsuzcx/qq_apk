package com.tencent.mm.plugin.finder.convert;

import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.ui.aj;
import com.tencent.mm.view.recyclerview.b;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.k;
import d.l;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/convert/FinderMoreSimilarTopicConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "()V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-finder_release"})
public class af
  extends b<BaseFinderFeed>
{
  private static int rci;
  public static final af.a rcj;
  
  static
  {
    AppMethodBeat.i(201351);
    rcj = new af.a((byte)0);
    rci = -2;
    AppMethodBeat.o(201351);
  }
  
  public final void a(RecyclerView paramRecyclerView, e parame, int paramInt)
  {
    AppMethodBeat.i(201348);
    k.h(paramRecyclerView, "recyclerView");
    k.h(parame, "holder");
    parame.setTag(Integer.valueOf(rci));
    parame.asD.setTag(Integer.valueOf(rci));
    paramRecyclerView = (TextView)parame.adJ(2131307438);
    k.g(paramRecyclerView, "tipsTv");
    aj.a((Paint)paramRecyclerView.getPaint(), 0.8F);
    AppMethodBeat.o(201348);
  }
  
  public void a(e parame, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(201349);
    k.h(parame, "holder");
    k.h(paramBaseFinderFeed, "item");
    AppMethodBeat.o(201349);
  }
  
  public final int getLayoutId()
  {
    return 2131496229;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.af
 * JD-Core Version:    0.7.0.1
 */