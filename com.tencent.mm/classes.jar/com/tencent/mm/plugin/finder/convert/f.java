package com.tencent.mm.plugin.finder.convert;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.q;
import com.tencent.mm.plugin.finder.storage.ab;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.Iterator;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedCommentFailedNotifyConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderCommentFailedNotifyData;", "()V", "getCommentDetail", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "feedId", "", "objectNonceId", "", "getLayoutId", "", "onBindViewHolder", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-finder_release"})
public final class f
  extends com.tencent.mm.view.recyclerview.b<com.tencent.mm.plugin.finder.model.e>
{
  private static q rUF;
  public static final f.a rUG;
  
  static
  {
    AppMethodBeat.i(165333);
    rUG = new f.a((byte)0);
    AppMethodBeat.o(165333);
  }
  
  public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.e parame, int paramInt)
  {
    AppMethodBeat.i(165331);
    p.h(paramRecyclerView, "recyclerView");
    p.h(parame, "holder");
    AppMethodBeat.o(165331);
  }
  
  public final int getLayoutId()
  {
    return 2131492866;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(com.tencent.mm.view.recyclerview.e parame, long paramLong) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(f paramf, com.tencent.mm.plugin.finder.model.e parame, com.tencent.mm.view.recyclerview.e parame1) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165330);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentFailedNotifyConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      paramView = ((PluginFinder)g.ad(PluginFinder.class)).getFinderActionStorage();
      long l = this.rUI.duw;
      ae.i(com.tencent.mm.plugin.finder.storage.a.TAG, "markUnsentCommentsCanRemove ".concat(String.valueOf(l)));
      localObject = ((Iterable)((PluginFinder)g.ad(PluginFinder.class)).getFinderActionStorage().xd(l)).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ab localab = (ab)((Iterator)localObject).next();
        localab.field_canRemove = 1;
        com.tencent.mm.plugin.finder.storage.a.a(paramView, localab.field_localCommentId, localab);
      }
      this.rUI.ssP = 1;
      f.a(this.oTF, this.rUI.duw, this.rUI.objectNonceId);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentFailedNotifyConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(165330);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.f
 * JD-Core Version:    0.7.0.1
 */