package com.tencent.mm.plugin.finder.convert;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.loader.r;
import com.tencent.mm.plugin.finder.loader.t;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout.b;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.ui.au;
import com.tencent.mm.view.recyclerview.i;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderImageFoldedConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFoldedConvert;", "controller", "Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;", "(Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;)V", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
public final class as
  extends ao
{
  public as(FinderFoldedScrollLayout.b paramb)
  {
    super(paramb, b.g.finder_folded_media_item);
    AppMethodBeat.i(286358);
    AppMethodBeat.o(286358);
  }
  
  public final void a(i parami, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(286356);
    p.k(parami, "holder");
    p.k(paramBaseFinderFeed, "item");
    super.a(parami, paramBaseFinderFeed, paramInt1, paramInt2, paramBoolean, paramList);
    paramList = (ImageView)parami.RD(b.f.media_type_icon);
    if (paramBaseFinderFeed.feedObject.getMediaList().size() > 1)
    {
      p.j(paramList, "mediaIcon");
      paramList.setImageDrawable(au.o(paramList.getContext(), b.i.icons_filled_album, a.w(paramList.getContext(), b.c.White)));
      paramList.setVisibility(0);
      paramList = (csg)j.lo((List)paramBaseFinderFeed.feedObject.getMediaList());
      paramBaseFinderFeed = (ImageView)parami.RD(b.f.thumb_iv);
      parami = t.ztT;
      parami = t.dJe();
      paramList = new r(paramList, u.Alz, null, null, 12);
      t localt = t.ztT;
      paramList = parami.a(paramList, t.a(t.a.ztU));
      parami = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.dUT().aSr()).intValue() <= 0) {
        break label253;
      }
    }
    label253:
    for (parami = new com.tencent.mm.loader.e.d(null, new g(paramBaseFinderFeed), 1);; parami = null)
    {
      parami = paramList.a((com.tencent.mm.loader.f.d)parami);
      p.j(paramBaseFinderFeed, "thumbIv");
      parami.c(paramBaseFinderFeed);
      AppMethodBeat.o(286356);
      return;
      p.j(paramList, "mediaIcon");
      paramList.setVisibility(8);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.as
 * JD-Core Version:    0.7.0.1
 */