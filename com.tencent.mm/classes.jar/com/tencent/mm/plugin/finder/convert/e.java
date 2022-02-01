package com.tencent.mm.plugin.finder.convert;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.m;
import com.tencent.mm.plugin.finder.model.d;
import com.tencent.mm.plugin.finder.storage.t;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.view.recyclerview.b;
import d.g.b.k;
import d.l;
import java.util.Iterator;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedCommentFailedNotifyConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderCommentFailedNotifyData;", "()V", "getCommentDetail", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "feedId", "", "objectNonceId", "", "getLayoutId", "", "onBindViewHolder", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-finder_release"})
public final class e
  extends b<d>
{
  private static m rab;
  public static final e.a rac;
  
  static
  {
    AppMethodBeat.i(165333);
    rac = new e.a((byte)0);
    AppMethodBeat.o(165333);
  }
  
  public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.e parame, int paramInt)
  {
    AppMethodBeat.i(165331);
    k.h(paramRecyclerView, "recyclerView");
    k.h(parame, "holder");
    AppMethodBeat.o(165331);
  }
  
  public final int getLayoutId()
  {
    return 2131492866;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(com.tencent.mm.view.recyclerview.e parame, long paramLong) {}
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(e parame, d paramd, com.tencent.mm.view.recyclerview.e parame1) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165330);
      paramView = ((PluginFinder)g.ad(PluginFinder.class)).getFinderActionStorage();
      long l = this.rae.dig;
      ac.i(com.tencent.mm.plugin.finder.storage.a.TAG, "markUnsentCommentsCanRemove ".concat(String.valueOf(l)));
      Iterator localIterator = ((Iterable)((PluginFinder)g.ad(PluginFinder.class)).getFinderActionStorage().uL(l)).iterator();
      while (localIterator.hasNext())
      {
        t localt = (t)localIterator.next();
        localt.field_canRemove = 1;
        com.tencent.mm.plugin.finder.storage.a.a(paramView, localt.field_localCommentId, localt);
      }
      this.rae.ruz = 1;
      e.a(this.ojH, this.rae.dig, this.rae.objectNonceId);
      AppMethodBeat.o(165330);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.e
 * JD-Core Version:    0.7.0.1
 */