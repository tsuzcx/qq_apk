package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.loader.k;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.view.recyclerview.h;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedImageRoundCornerConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedRoundCornerConvert;", "()V", "screenWidth", "", "getScreenWidth", "()I", "screenWidth$delegate", "Lkotlin/Lazy;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
public class v
  extends ae
{
  private final f tCY;
  
  public v()
  {
    super(2131494301);
    AppMethodBeat.i(243024);
    this.tCY = g.ah((a)a.tCZ);
    AppMethodBeat.o(243024);
  }
  
  public void a(h paramh, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(165396);
    p.h(paramh, "holder");
    p.h(paramBaseFinderFeed, "item");
    super.a(paramh, paramBaseFinderFeed, paramInt1, paramInt2, paramBoolean, paramList);
    Object localObject1 = (cjl)j.ks((List)paramBaseFinderFeed.feedObject.getMediaList());
    paramList = (ImageView)paramh.Mn(2131309073);
    p.g(paramList, "thumbIv");
    Object localObject2 = paramList.getLayoutParams();
    paramInt1 = ((Number)this.tCY.getValue()).intValue();
    Object localObject3 = paramh.getContext();
    p.g(localObject3, "holder.context");
    paramInt1 = (paramInt1 - (int)((Context)localObject3).getResources().getDimension(2131165289)) / 2;
    localObject3 = y.vXH;
    paramInt2 = y.a(paramBaseFinderFeed, (cjl)localObject1, paramInt1);
    if (paramInt2 > 0)
    {
      ((ViewGroup.LayoutParams)localObject2).width = paramInt1;
      ((ViewGroup.LayoutParams)localObject2).height = paramInt2;
      paramList.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
    localObject2 = m.uJa;
    localObject2 = m.djY();
    localObject1 = new k((cjl)localObject1, x.vEo, null, null, 12);
    localObject3 = m.uJa;
    ((d)localObject2).a(localObject1, paramList, m.a(m.a.uJb));
    paramList = (ImageIndicatorView)paramh.Mn(2131302571);
    if (paramList != null) {
      paramList.setVisibility(0);
    }
    if (paramList != null) {
      paramList.aan(paramBaseFinderFeed.feedObject.getMediaList().size());
    }
    j(paramh, paramBaseFinderFeed);
    AppMethodBeat.o(165396);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<Integer>
  {
    public static final a tCZ;
    
    static
    {
      AppMethodBeat.i(243023);
      tCZ = new a();
      AppMethodBeat.o(243023);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.v
 * JD-Core Version:    0.7.0.1
 */