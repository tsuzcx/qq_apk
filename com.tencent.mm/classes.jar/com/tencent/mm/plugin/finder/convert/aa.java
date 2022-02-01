package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.loader.f;
import com.tencent.mm.plugin.finder.loader.h;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.b;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.m;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.ui.am;
import com.tencent.mm.view.recyclerview.e;
import d.a.j;
import d.g.b.k;
import d.l;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/convert/FinderMixFeedImageRoundCornerConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderMixFeedRoundCornerConvert;", "()V", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "baseItem", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
public final class aa
  extends ab
{
  public final void a(e parame, b paramb, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(201334);
    k.h(parame, "holder");
    k.h(paramb, "baseItem");
    super.a(parame, paramb, paramInt1, paramInt2, paramBoolean, paramList);
    paramb = paramb.rux;
    if (paramb != null)
    {
      paramList = (ImageView)parame.adJ(2131302222);
      if (paramb.feedObject.getMediaList().size() > 1)
      {
        k.g(paramList, "mediaIcon");
        paramList.setImageDrawable(am.k(paramList.getContext(), 2131690348, a.n(paramList.getContext(), 2131099828)));
        paramList.setVisibility(0);
      }
      for (;;)
      {
        paramList = (bqs)j.iO((List)paramb.feedObject.getMediaList());
        paramb = (ImageView)parame.adJ(2131305798);
        k.g(paramb, "thumbIv");
        Object localObject1 = paramb.getLayoutParams();
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
          paramb.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        parame = h.rtK;
        parame = h.cwn();
        paramList = new f(paramList, m.rDR);
        localObject1 = h.rtK;
        parame.a(paramList, paramb, h.a(h.a.rtL));
        AppMethodBeat.o(201334);
        return;
        k.g(paramList, "mediaIcon");
        paramList.setVisibility(8);
      }
    }
    AppMethodBeat.o(201334);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.aa
 * JD-Core Version:    0.7.0.1
 */