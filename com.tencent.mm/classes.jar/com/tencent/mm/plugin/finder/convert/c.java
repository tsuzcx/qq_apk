package com.tencent.mm.plugin.finder.convert;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.view.recyclerview.e;
import d.l;
import java.util.Iterator;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedCommentFailedNotifyConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderCommentFailedNotifyData;", "()V", "getCommentDetail", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "feedId", "", "objectNonceId", "", "getLayoutId", "", "onBindViewHolder", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-finder_release"})
public final class c
  extends com.tencent.mm.view.recyclerview.b<com.tencent.mm.plugin.finder.model.b>
{
  private static h qqr;
  public static final a qqs;
  
  static
  {
    AppMethodBeat.i(165333);
    qqs = new a((byte)0);
    AppMethodBeat.o(165333);
  }
  
  public final void a(RecyclerView paramRecyclerView, e parame, int paramInt)
  {
    AppMethodBeat.i(165331);
    d.g.b.k.h(paramRecyclerView, "recyclerView");
    d.g.b.k.h(parame, "holder");
    AppMethodBeat.o(165331);
  }
  
  public final int getLayoutId()
  {
    return 2131492866;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedCommentFailedNotifyConvert$Companion;", "", "()V", "TAG", "", "curCgi", "Lcom/tencent/mm/plugin/finder/cgi/CgiGetFinderFeedComment;", "getCurCgi", "()Lcom/tencent/mm/plugin/finder/cgi/CgiGetFinderFeedComment;", "setCurCgi", "(Lcom/tencent/mm/plugin/finder/cgi/CgiGetFinderFeedComment;)V", "plugin-finder_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(e parame, long paramLong) {}
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(c paramc, com.tencent.mm.plugin.finder.model.b paramb, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165330);
      paramView = ((PluginFinder)g.ad(PluginFinder.class)).getFinderActionStorage();
      long l = this.qqv.feedId;
      ad.i(com.tencent.mm.plugin.finder.storage.a.TAG, "markUnsentCommentsCanRemove ".concat(String.valueOf(l)));
      Iterator localIterator = ((Iterable)((PluginFinder)g.ad(PluginFinder.class)).getFinderActionStorage().qv(l)).iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.finder.storage.k localk = (com.tencent.mm.plugin.finder.storage.k)localIterator.next();
        localk.field_canRemove = 1;
        com.tencent.mm.plugin.finder.storage.a.a(paramView, localk.field_localCommentId, localk);
      }
      this.qqv.qDq = 1;
      c.a(this.nGG, this.qqv.feedId, this.qqv.objectNonceId);
      AppMethodBeat.o(165330);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.c
 * JD-Core Version:    0.7.0.1
 */