package com.tencent.mm.plugin.finder.view.adapter;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.f.e;
import com.tencent.mm.plugin.finder.loader.g;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.plugin.finder.loader.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.FinderVideoSeekBar;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.ui.base.a.a;
import com.tencent.mm.ui.z;
import d.g.b.p;
import d.l;
import d.v;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/adapter/FinderMediaBannerAdapter;", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "Landroid/view/View;", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "(Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;)V", "banner", "Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "getBanner", "()Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "setBanner", "(Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;)V", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFeed", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFeed", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "tabType", "", "getTabType", "()I", "setTabType", "(I)V", "attachFinderImage", "Lcom/tencent/mm/plugin/finder/loader/FinderImage;", "mediaObj", "type", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "getItemViewType", "position", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "onBindViewHolderImpl", "onCreateItemView", "parent", "Landroid/view/ViewGroup;", "viewType", "onCreateItemViewImpl", "Companion", "plugin-finder_release"})
public class FinderMediaBannerAdapter
  extends a<bvf, View>
{
  public static final a sXo;
  public int duh;
  public FinderItem feed;
  private final com.tencent.mm.plugin.finder.video.i rOe;
  public FinderMediaBanner sXn;
  
  static
  {
    AppMethodBeat.i(168454);
    sXo = new a((byte)0);
    AppMethodBeat.o(168454);
  }
  
  public FinderMediaBannerAdapter(com.tencent.mm.plugin.finder.video.i parami)
  {
    this.rOe = parami;
  }
  
  public final void a(com.tencent.mm.ui.base.a.b paramb, int paramInt)
  {
    AppMethodBeat.i(168451);
    p.h(paramb, "holder");
    super.a(paramb, paramInt);
    paramb.em(getItemAtPosition(paramInt));
    p.h(paramb, "holder");
    switch (getItemViewType(paramInt))
    {
    }
    Object localObject1;
    Object localObject2;
    do
    {
      AppMethodBeat.o(168451);
      return;
      localObject1 = (bvf)getItemAtPosition(paramInt);
      localObject2 = (ImageView)paramb.Gd(2131299974);
      paramb = new FrameLayout.LayoutParams(-1, -1);
      p.g(localObject2, "imageView");
      ((ImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)paramb);
      paramb.gravity = 17;
      ((ImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramb = com.tencent.mm.plugin.finder.loader.i.sja;
      paramb = com.tencent.mm.plugin.finder.loader.i.cCB();
      p.g(localObject1, "item");
      Object localObject3 = paramb.bI(new g((bvf)localObject1, r.syD));
      paramb = com.tencent.mm.plugin.finder.storage.b.sxa;
      if (((Number)com.tencent.mm.plugin.finder.storage.b.cHX().value()).intValue() > 0) {}
      for (paramb = new com.tencent.mm.loader.e.d(null, null, 3);; paramb = null)
      {
        paramb = ((com.tencent.mm.loader.a.b)localObject3).a((com.tencent.mm.loader.f.d)paramb);
        localObject3 = com.tencent.mm.plugin.finder.loader.i.sja;
        paramb.a(com.tencent.mm.plugin.finder.loader.i.a(i.a.sjb)).a((e)new b((bvf)localObject1)).c((ImageView)localObject2);
        AppMethodBeat.o(168451);
        return;
      }
      localObject1 = (FinderVideoLayout)paramb.Gd(2131299975);
      localObject2 = this.feed;
    } while (localObject2 == null);
    paramb = this.sXn;
    if (paramb != null) {}
    for (paramb = (FinderVideoSeekBar)paramb.findViewById(2131307914);; paramb = null)
    {
      ((FinderVideoLayout)localObject1).a(paramInt, (FinderItem)localObject2, paramb, this.duh);
      AppMethodBeat.o(168451);
      return;
    }
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(168450);
    paramInt = ((bvf)this.cje.get(paramInt)).mediaType;
    AppMethodBeat.o(168450);
    return paramInt;
  }
  
  public final View m(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(168449);
    p.h(paramViewGroup, "parent");
    p.h(paramViewGroup, "parent");
    if (paramInt == 4)
    {
      paramViewGroup = z.jO(paramViewGroup.getContext()).inflate(2131494065, paramViewGroup, false);
      if (paramViewGroup == null)
      {
        paramViewGroup = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.video.FinderVideoLayout");
        AppMethodBeat.o(168449);
        throw paramViewGroup;
      }
      FinderVideoLayout localFinderVideoLayout = (FinderVideoLayout)paramViewGroup;
      com.tencent.mm.plugin.finder.video.i locali = this.rOe;
      if (locali == null) {
        p.gfZ();
      }
      localFinderVideoLayout.setVideoCore(locali);
      AppMethodBeat.o(168449);
      return paramViewGroup;
    }
    if ((paramInt == 2) || (paramInt == 7))
    {
      paramViewGroup = z.jO(paramViewGroup.getContext()).inflate(2131494063, paramViewGroup, false);
      p.g(paramViewGroup, "MMLayoutInflater.getInfl…container, parent, false)");
      AppMethodBeat.o(168449);
      return paramViewGroup;
    }
    paramViewGroup = new View(paramViewGroup.getContext());
    AppMethodBeat.o(168449);
    return paramViewGroup;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/adapter/FinderMediaBannerAdapter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "view", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete"})
  static final class b<T, R>
    implements e<k, Bitmap>
  {
    b(bvf parambvf) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter
 * JD-Core Version:    0.7.0.1
 */