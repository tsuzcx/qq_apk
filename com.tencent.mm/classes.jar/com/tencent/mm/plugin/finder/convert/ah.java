package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.loader.f;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.v;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.ui.am;
import com.tencent.mm.view.recyclerview.e;
import d.a.j;
import d.g.b.k;
import d.l;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/convert/FinderMixFeedImageRoundCornerConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderMixFeedRoundCornerConvert;", "()V", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "baseItem", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
public final class ah
  extends ai
{
  public final void a(e parame, v paramv, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(197459);
    k.h(parame, "holder");
    k.h(paramv, "baseItem");
    super.a(parame, paramv, paramInt1, paramInt2, paramBoolean, paramList);
    paramv = paramv.KTl;
    if (paramv != null)
    {
      paramList = (ImageView)parame.abq(2131302222);
      if (paramv.feedObject.getMediaList().size() > 1)
      {
        k.g(paramList, "mediaIcon");
        paramList.setImageDrawable(am.i(paramList.getContext(), 2131690348, a.n(paramList.getContext(), 2131099828)));
        paramList.setVisibility(0);
      }
      for (;;)
      {
        paramList = (bmd)j.iy((List)paramv.feedObject.getMediaList());
        paramv = (ImageView)parame.abq(2131305798);
        k.g(paramv, "thumbIv");
        Object localObject1 = paramv.getLayoutParams();
        Object localObject2 = parame.getContext();
        k.g(localObject2, "holder.context");
        localObject2 = ((Context)localObject2).getResources();
        k.g(localObject2, "holder.context.resources");
        paramInt1 = ((Resources)localObject2).getDisplayMetrics().widthPixels;
        parame = parame.getContext();
        k.g(parame, "holder.context");
        int i = (paramInt1 - (int)parame.getResources().getDimension(2131165284)) / 2;
        if (i > 0)
        {
          paramInt2 = (int)(paramList.height * i / paramList.width);
          paramInt1 = paramInt2;
          if (paramInt2 > i * 1.166666666666667D) {
            paramInt1 = (int)(i * 1.166666666666667D);
          }
          ((ViewGroup.LayoutParams)localObject1).width = i;
          ((ViewGroup.LayoutParams)localObject1).height = paramInt1;
          paramv.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        parame = com.tencent.mm.plugin.finder.loader.h.qCF;
        parame = com.tencent.mm.plugin.finder.loader.h.cmU();
        paramList = new f(paramList, com.tencent.mm.plugin.finder.storage.h.qJZ);
        localObject1 = com.tencent.mm.plugin.finder.loader.h.qCF;
        parame.a(paramList, paramv, com.tencent.mm.plugin.finder.loader.h.a(h.a.qCG));
        AppMethodBeat.o(197459);
        return;
        k.g(paramList, "mediaIcon");
        paramList.setVisibility(8);
      }
    }
    AppMethodBeat.o(197459);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ah
 * JD-Core Version:    0.7.0.1
 */