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
import com.tencent.mm.plugin.finder.loader.i;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.video.FinderFullSeekBarLayout;
import com.tencent.mm.plugin.finder.video.FinderLongVideoPlayerSeekBar;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout.b;
import com.tencent.mm.plugin.finder.video.FinderVideoSeekBar;
import com.tencent.mm.plugin.finder.video.q;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.a.a;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/adapter/FinderMediaBannerAdapter;", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "Landroid/view/View;", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "(Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;)V", "banner", "Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "getBanner", "()Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "setBanner", "(Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;)V", "feed", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "getFeed", "()Lcom/tencent/mm/plugin/finder/storage/FeedData;", "setFeed", "(Lcom/tencent/mm/plugin/finder/storage/FeedData;)V", "forbidVideoLayoutClickable", "", "getForbidVideoLayoutClickable", "()Z", "setForbidVideoLayoutClickable", "(Z)V", "fullVideoSeekBar", "Lcom/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout;", "getFullVideoSeekBar", "()Lcom/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout;", "setFullVideoSeekBar", "(Lcom/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout;)V", "isEnableFullScreenEnjoy", "setEnableFullScreenEnjoy", "isLongVideo", "setLongVideo", "isSupportBulletSubtitle", "setSupportBulletSubtitle", "isSupportVideoProgress", "setSupportVideoProgress", "pos", "", "getPos", "()I", "setPos", "(I)V", "tabType", "getTabType", "setTabType", "thumbShowCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "isShow", "Lcom/tencent/mm/plugin/finder/video/FinderVideoLayout$PlayInfo;", "playInfo", "", "getThumbShowCallback", "()Lkotlin/jvm/functions/Function2;", "setThumbShowCallback", "(Lkotlin/jvm/functions/Function2;)V", "videoPauseCallback", "isPause", "getVideoPauseCallback", "setVideoPauseCallback", "attachFinderImage", "Lcom/tencent/mm/plugin/finder/loader/FinderImageLoadData;", "mediaObj", "type", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "getItemViewType", "position", "onBindViewHolder", "holder", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "onBindViewHolderImpl", "onCreateItemView", "parent", "Landroid/view/ViewGroup;", "viewType", "onCreateItemViewImpl", "onViewRecycled", "Companion", "plugin-finder_release"})
public class FinderMediaBannerAdapter
  extends a<cjl, View>
{
  public static final a wrr;
  public int dLS;
  public FeedData feed;
  public boolean isLongVideo;
  public int pos;
  private final com.tencent.mm.plugin.finder.video.k tCD;
  public boolean wfg;
  public kotlin.g.a.m<? super Boolean, ? super FinderVideoLayout.b, kotlin.x> wfs;
  public kotlin.g.a.m<? super Boolean, ? super FinderVideoLayout.b, kotlin.x> wft;
  public FinderMediaBanner wrm;
  public boolean wrn;
  public boolean wro;
  public boolean wrp;
  public FinderFullSeekBarLayout wrq;
  
  static
  {
    AppMethodBeat.i(168454);
    wrr = new a((byte)0);
    AppMethodBeat.o(168454);
  }
  
  public FinderMediaBannerAdapter(com.tencent.mm.plugin.finder.video.k paramk)
  {
    this.tCD = paramk;
    this.wro = true;
    this.wrp = true;
  }
  
  public final void a(com.tencent.mm.ui.base.a.b paramb, int paramInt)
  {
    AppMethodBeat.i(168451);
    p.h(paramb, "holder");
    super.a(paramb, paramInt);
    paramb.et(getItemAtPosition(paramInt));
    p.h(paramb, "holder");
    switch (getItemViewType(paramInt))
    {
    }
    Object localObject1;
    label209:
    label245:
    label511:
    do
    {
      AppMethodBeat.o(168451);
      return;
      Object localObject2 = (cjl)getItemAtPosition(paramInt);
      ImageView localImageView = (ImageView)paramb.Mn(2131300775);
      paramb = new FrameLayout.LayoutParams(-1, -1);
      p.g(localImageView, "imageView");
      localImageView.setLayoutParams((ViewGroup.LayoutParams)paramb);
      paramb.gravity = 17;
      localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      if (this.wfg)
      {
        paramb = com.tencent.mm.plugin.finder.loader.m.uJa;
        paramb = com.tencent.mm.plugin.finder.loader.m.djY();
        localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        p.g(localObject2, "item");
        localObject1 = com.tencent.mm.plugin.finder.storage.x.vEn;
        if (!this.wfg) {
          break label320;
        }
        localObject1 = (com.tencent.mm.plugin.finder.loader.k)new i((cjl)localObject2, (com.tencent.mm.plugin.finder.storage.x)localObject1);
        localObject1 = paramb.bQ(localObject1);
        paramb = c.vCb;
        if (((Number)c.dtK().value()).intValue() <= 0) {
          break label338;
        }
        paramb = new com.tencent.mm.loader.e.d(null, null, 3);
        localObject1 = ((com.tencent.mm.loader.a.b)localObject1).a((com.tencent.mm.loader.f.d)paramb);
        if (!this.wfg) {
          break label343;
        }
        paramb = com.tencent.mm.plugin.finder.loader.m.uJa;
      }
      for (paramb = com.tencent.mm.plugin.finder.loader.m.a(m.a.uJc);; paramb = com.tencent.mm.plugin.finder.loader.m.a(m.a.uJb))
      {
        ((com.tencent.mm.loader.b)localObject1).a(paramb).a((e)new b((cjl)localObject2)).c(localImageView);
        AppMethodBeat.o(168451);
        return;
        paramb = com.tencent.mm.plugin.finder.loader.m.uJa;
        paramb = com.tencent.mm.plugin.finder.loader.m.djZ();
        break;
        localObject1 = new com.tencent.mm.plugin.finder.loader.k((cjl)localObject2, (com.tencent.mm.plugin.finder.storage.x)localObject1, null, null, 12);
        break label209;
        paramb = null;
        break label245;
        paramb = com.tencent.mm.plugin.finder.loader.m.uJa;
      }
      localObject1 = (FinderVideoLayout)paramb.Mn(2131300776);
      ((FinderVideoLayout)localObject1).setLongVideo(this.isLongVideo);
      localObject2 = this.feed;
      if (localObject2 != null)
      {
        if (!this.isLongVideo) {
          break label521;
        }
        paramb = this.wrm;
        if (paramb == null) {
          break label511;
        }
        paramb = paramb.getLongVideoSeekBar();
        ((FinderVideoLayout)localObject1).setLongVideoSeekBar(paramb);
        FinderVideoLayout.a((FinderVideoLayout)localObject1, paramInt, (FeedData)localObject2, this.dLS, this.wfg, false, 192);
        paramb = this.wrm;
        if (paramb != null)
        {
          paramb = paramb.getLongVideoSeekBar();
          if (paramb != null)
          {
            localObject2 = (cjl)j.kt((List)((FeedData)localObject2).getMediaList());
            if (localObject2 == null) {
              break label516;
            }
          }
        }
      }
      for (paramInt = ((cjl)localObject2).videoDuration;; paramInt = 0)
      {
        paramb.setVideoTotalTime(paramInt);
        if (!this.wrn) {
          break;
        }
        p.g(localObject1, "videoContainer");
        ((FinderVideoLayout)localObject1).setClickable(false);
        ((FinderVideoLayout)localObject1).setLongClickable(false);
        AppMethodBeat.o(168451);
        return;
        paramb = null;
        break label407;
      }
      paramb = this.wrm;
      if (paramb != null)
      {
        paramb = (FinderVideoSeekBar)paramb.findViewById(2131306117);
        if (this.wrq != null) {
          break label589;
        }
      }
      for (paramb = (q)paramb;; paramb = (q)this.wrq)
      {
        ((FinderVideoLayout)localObject1).a(paramInt, (FeedData)localObject2, paramb, this.dLS, this.wfg, this.wro, this.wfs, this.wft);
        break;
        paramb = null;
        break label541;
      }
      paramb = (FinderVideoLayout)paramb.Mn(2131300776);
      localObject1 = this.feed;
    } while (localObject1 == null);
    label320:
    label338:
    label343:
    paramb.a(paramInt, (FeedData)localObject1, null, this.dLS, this.wfg, this.wro, this.wfs, this.wft);
    label407:
    label541:
    label589:
    AppMethodBeat.o(168451);
    label516:
    label521:
    return;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(168450);
    paramInt = ((cjl)this.cvc.get(paramInt)).mediaType;
    AppMethodBeat.o(168450);
    return paramInt;
  }
  
  public final View l(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(168449);
    p.h(paramViewGroup, "parent");
    p.h(paramViewGroup, "parent");
    if ((paramInt == 4) || (paramInt == 9))
    {
      paramViewGroup = aa.jQ(paramViewGroup.getContext()).inflate(2131494503, paramViewGroup, false);
      if (paramViewGroup == null)
      {
        paramViewGroup = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.video.FinderVideoLayout");
        AppMethodBeat.o(168449);
        throw paramViewGroup;
      }
      FinderVideoLayout localFinderVideoLayout = (FinderVideoLayout)paramViewGroup;
      com.tencent.mm.plugin.finder.video.k localk = this.tCD;
      if (localk == null) {
        p.hyc();
      }
      localFinderVideoLayout.setVideoCore(localk);
      AppMethodBeat.o(168449);
      return paramViewGroup;
    }
    if ((paramInt == 2) || (paramInt == 7))
    {
      paramViewGroup = aa.jQ(paramViewGroup.getContext()).inflate(2131494501, paramViewGroup, false);
      p.g(paramViewGroup, "MMLayoutInflater.getInfl…container, parent, false)");
      AppMethodBeat.o(168449);
      return paramViewGroup;
    }
    paramViewGroup = new View(paramViewGroup.getContext());
    AppMethodBeat.o(168449);
    return paramViewGroup;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/adapter/FinderMediaBannerAdapter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "view", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete"})
  static final class b<T, R>
    implements e<o, Bitmap>
  {
    b(cjl paramcjl) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter
 * JD-Core Version:    0.7.0.1
 */