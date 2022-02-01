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
import com.tencent.mm.plugin.finder.loader.f;
import com.tencent.mm.plugin.finder.loader.h;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.plugin.finder.loader.j;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.m;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.FinderVideoSeekBar;
import com.tencent.mm.plugin.finder.video.i;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.ui.base.a.a;
import com.tencent.mm.ui.z;
import d.g.b.k;
import d.l;
import d.v;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/view/adapter/FinderMediaBannerAdapter;", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "Landroid/view/View;", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "(Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;)V", "banner", "Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "getBanner", "()Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "setBanner", "(Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;)V", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFeed", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFeed", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "attachFinderImage", "Lcom/tencent/mm/plugin/finder/loader/FinderImage;", "mediaObj", "type", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "getItemViewType", "", "position", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "onBindViewHolderImpl", "onCreateItemView", "parent", "Landroid/view/ViewGroup;", "viewType", "onCreateItemViewImpl", "Companion", "plugin-finder_release"})
public class FinderMediaBannerAdapter
  extends a<bqs, View>
{
  public static final FinderMediaBannerAdapter.a sac;
  public FinderItem feed;
  private final i rbo;
  public FinderMediaBanner sab;
  
  static
  {
    AppMethodBeat.i(168454);
    sac = new FinderMediaBannerAdapter.a((byte)0);
    AppMethodBeat.o(168454);
  }
  
  public FinderMediaBannerAdapter(i parami)
  {
    this.rbo = parami;
  }
  
  public final void a(com.tencent.mm.ui.base.a.b paramb, int paramInt)
  {
    AppMethodBeat.i(168451);
    k.h(paramb, "holder");
    super.a(paramb, paramInt);
    paramb.ej(getItemAtPosition(paramInt));
    k.h(paramb, "holder");
    switch (getItemViewType(paramInt))
    {
    }
    Object localObject1;
    Object localObject2;
    do
    {
      AppMethodBeat.o(168451);
      return;
      localObject1 = (bqs)getItemAtPosition(paramInt);
      paramb = (ImageView)paramb.adJ(2131299974);
      localObject2 = new FrameLayout.LayoutParams(-1, -1);
      k.g(paramb, "imageView");
      paramb.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((FrameLayout.LayoutParams)localObject2).gravity = 17;
      paramb.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localObject2 = h.rtK;
      localObject2 = h.cwn();
      k.g(localObject1, "item");
      localObject2 = ((com.tencent.mm.loader.d)localObject2).bG(new f((bqs)localObject1, m.rDQ));
      h localh = h.rtK;
      ((com.tencent.mm.loader.a.b)localObject2).a(h.a(h.a.rtL)).a((com.tencent.mm.loader.f.d)new b((bqs)localObject1)).c(paramb);
      AppMethodBeat.o(168451);
      return;
      localObject1 = (FinderVideoLayout)paramb.adJ(2131299975);
      localObject2 = this.feed;
    } while (localObject2 == null);
    paramb = this.sab;
    if (paramb != null) {}
    for (paramb = (FinderVideoSeekBar)paramb.findViewById(2131307914);; paramb = null)
    {
      ((FinderVideoLayout)localObject1).a(paramInt, (FinderItem)localObject2, paramb);
      AppMethodBeat.o(168451);
      return;
    }
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(168450);
    paramInt = ((bqs)this.bYM.get(paramInt)).mediaType;
    AppMethodBeat.o(168450);
    return paramInt;
  }
  
  public final View l(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(168449);
    k.h(paramViewGroup, "parent");
    k.h(paramViewGroup, "parent");
    if (paramInt == 4)
    {
      paramViewGroup = z.jD(paramViewGroup.getContext()).inflate(2131494065, paramViewGroup, false);
      if (paramViewGroup == null)
      {
        paramViewGroup = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.video.FinderVideoLayout");
        AppMethodBeat.o(168449);
        throw paramViewGroup;
      }
      FinderVideoLayout localFinderVideoLayout = (FinderVideoLayout)paramViewGroup;
      i locali = this.rbo;
      if (locali == null) {
        k.fOy();
      }
      localFinderVideoLayout.setVideoCore(locali);
      AppMethodBeat.o(168449);
      return paramViewGroup;
    }
    if ((paramInt == 2) || (paramInt == 7))
    {
      paramViewGroup = z.jD(paramViewGroup.getContext()).inflate(2131494063, paramViewGroup, false);
      k.g(paramViewGroup, "MMLayoutInflater.getInfl…container, parent, false)");
      AppMethodBeat.o(168449);
      return paramViewGroup;
    }
    paramViewGroup = new View(paramViewGroup.getContext());
    AppMethodBeat.o(168449);
    return paramViewGroup;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "view", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete"})
  static final class b<T, R>
    implements com.tencent.mm.loader.f.d<j, Bitmap>
  {
    b(bqs parambqs) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter
 * JD-Core Version:    0.7.0.1
 */