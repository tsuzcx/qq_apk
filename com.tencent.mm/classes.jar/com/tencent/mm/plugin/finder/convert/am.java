package com.tencent.mm.plugin.finder.convert;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.loader.d.b.g;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.loader.n;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout.b;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.ui.bb;
import com.tencent.mm.view.recyclerview.j;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderImageFoldedConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFoldedConvert;", "controller", "Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;", "(Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;)V", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class am
  extends ai
{
  public am(FinderFoldedScrollLayout.b paramb)
  {
    super(paramb, e.f.finder_folded_media_item);
    AppMethodBeat.i(350197);
    AppMethodBeat.o(350197);
  }
  
  public final void a(j paramj, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(350205);
    s.u(paramj, "holder");
    s.u(paramBaseFinderFeed, "item");
    super.a(paramj, paramBaseFinderFeed, paramInt1, paramInt2, paramBoolean, paramList);
    paramList = (ImageView)paramj.UH(e.e.media_type_icon);
    if (paramBaseFinderFeed.feedObject.getMediaList().size() > 1)
    {
      paramList.setImageDrawable(bb.m(paramList.getContext(), e.g.icons_filled_album, a.w(paramList.getContext(), e.b.White)));
      paramList.setVisibility(0);
      paramList = (dji)kotlin.a.p.oK((List)paramBaseFinderFeed.feedObject.getMediaList());
      paramBaseFinderFeed = (ImageView)paramj.UH(e.e.thumb_iv);
      paramj = com.tencent.mm.plugin.finder.loader.p.ExI;
      paramj = com.tencent.mm.plugin.finder.loader.p.eCl();
      paramList = new n(paramList, v.FKZ, null, null, 12);
      com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
      paramList = paramj.a(paramList, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ));
      paramj = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eTs().bmg()).intValue() <= 0) {
        break label239;
      }
    }
    label239:
    for (paramj = new com.tencent.mm.loader.d.d(null, new g(paramBaseFinderFeed), 1);; paramj = null)
    {
      paramj = paramList.a((com.tencent.mm.loader.e.d)paramj);
      s.s(paramBaseFinderFeed, "thumbIv");
      paramj.d(paramBaseFinderFeed);
      AppMethodBeat.o(350205);
      return;
      paramList.setVisibility(8);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.am
 * JD-Core Version:    0.7.0.1
 */