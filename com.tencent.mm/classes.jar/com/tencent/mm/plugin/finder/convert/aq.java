package com.tencent.mm.plugin.finder.convert;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.plugin.finder.loader.k;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout.b;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.ui.ar;
import com.tencent.mm.view.recyclerview.h;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderImageFoldedConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFoldedConvert;", "controller", "Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;", "(Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;)V", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
public final class aq
  extends am
{
  public aq(FinderFoldedScrollLayout.b paramb)
  {
    super(paramb, 2131494313);
    AppMethodBeat.i(243145);
    AppMethodBeat.o(243145);
  }
  
  public final void a(h paramh, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(243143);
    p.h(paramh, "holder");
    p.h(paramBaseFinderFeed, "item");
    super.a(paramh, paramBaseFinderFeed, paramInt1, paramInt2, paramBoolean, paramList);
    paramList = (ImageView)paramh.Mn(2131304574);
    if (paramBaseFinderFeed.feedObject.getMediaList().size() > 1)
    {
      p.g(paramList, "mediaIcon");
      paramList.setImageDrawable(ar.m(paramList.getContext(), 2131690479, a.n(paramList.getContext(), 2131099844)));
      paramList.setVisibility(0);
      paramList = (cjl)j.ks((List)paramBaseFinderFeed.feedObject.getMediaList());
      paramBaseFinderFeed = (ImageView)paramh.Mn(2131309073);
      paramh = m.uJa;
      paramh = m.djY();
      paramList = new k(paramList, x.vEo, null, null, 12);
      m localm = m.uJa;
      paramList = paramh.a(paramList, m.a(m.a.uJb));
      paramh = c.vCb;
      if (((Number)c.dtK().value()).intValue() <= 0) {
        break label249;
      }
    }
    label249:
    for (paramh = new com.tencent.mm.loader.e.d(null, new g(paramBaseFinderFeed), 1);; paramh = null)
    {
      paramh = paramList.a((com.tencent.mm.loader.f.d)paramh);
      p.g(paramBaseFinderFeed, "thumbIv");
      paramh.c(paramBaseFinderFeed);
      AppMethodBeat.o(243143);
      return;
      p.g(paramList, "mediaIcon");
      paramList.setVisibility(8);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.aq
 * JD-Core Version:    0.7.0.1
 */