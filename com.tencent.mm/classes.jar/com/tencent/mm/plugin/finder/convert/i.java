package com.tencent.mm.plugin.finder.convert;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.af;
import com.tencent.mm.plugin.finder.model.f;
import com.tencent.mm.plugin.finder.storage.an;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedCommentFailedNotifyConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderCommentFailedNotifyData;", "()V", "getCommentDetail", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "feedId", "", "objectNonceId", "", "getLayoutId", "", "onBindViewHolder", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-finder_release"})
public final class i
  extends e<f>
{
  private static af tzB;
  public static final a tzC;
  
  static
  {
    AppMethodBeat.i(165333);
    tzC = new a((byte)0);
    AppMethodBeat.o(165333);
  }
  
  public final void a(RecyclerView paramRecyclerView, h paramh, int paramInt)
  {
    AppMethodBeat.i(165331);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    AppMethodBeat.o(165331);
  }
  
  public final void a(final h paramh, final f paramf)
  {
    AppMethodBeat.i(242791);
    p.h(paramh, "holder");
    p.h(paramf, "item");
    if (paramf.uNO == 1) {
      paramh.mf(2131304963, 8);
    }
    for (;;)
    {
      paramh.Mn(2131304963).setOnClickListener((View.OnClickListener)new c(this, paramf, paramh));
      AppMethodBeat.o(242791);
      return;
      paramh.mf(2131304963, 0);
    }
  }
  
  public final int getLayoutId()
  {
    return 2131492869;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedCommentFailedNotifyConvert$Companion;", "", "()V", "TAG", "", "curCgi", "Lcom/tencent/mm/plugin/finder/cgi/CgiGetFinderFeedComment;", "getCurCgi", "()Lcom/tencent/mm/plugin/finder/cgi/CgiGetFinderFeedComment;", "setCurCgi", "(Lcom/tencent/mm/plugin/finder/cgi/CgiGetFinderFeedComment;)V", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(h paramh, long paramLong) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(i parami, f paramf, h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165330);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentFailedNotifyConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      paramView = ((PluginFinder)g.ah(PluginFinder.class)).getFinderActionStorage();
      long l = paramf.feedId;
      Log.i(com.tencent.mm.plugin.finder.storage.a.TAG, "markUnsentCommentsCanRemove ".concat(String.valueOf(l)));
      localObject = ((Iterable)((PluginFinder)g.ah(PluginFinder.class)).getFinderActionStorage().Fu(l)).iterator();
      while (((Iterator)localObject).hasNext())
      {
        an localan = (an)((Iterator)localObject).next();
        localan.field_canRemove = 1;
        com.tencent.mm.plugin.finder.storage.a.a(paramView, localan.field_localCommentId, localan);
      }
      paramf.uNO = 1;
      i.a(paramh, paramf.feedId, paramf.objectNonceId);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentFailedNotifyConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(165330);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.i
 * JD-Core Version:    0.7.0.1
 */