package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.c.a.a.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.live.model.ao;
import com.tencent.mm.plugin.findersdk.a.y.b;
import com.tencent.mm.plugin.findersdk.a.y.c;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.e;
import java.util.HashMap;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "msg", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "view", "Landroid/view/View;", "invoke"})
final class aq$2
  extends kotlin.g.b.q
  implements m<ao, View, x>
{
  aq$2(aq paramaq, ViewGroup paramViewGroup)
  {
    super(2);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin$2$8$1", "Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService$PoiRedirectCallBack;", "onPoiRedirect", "", "type", "Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService$FinderPoiRedirectType;", "plugin-finder_release"})
  public static final class a
    implements y.c
  {
    public final void a(y.b paramb)
    {
      AppMethodBeat.i(290344);
      p.k(paramb, "type");
      AppMethodBeat.o(290344);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.aq.2
 * JD-Core Version:    0.7.0.1
 */