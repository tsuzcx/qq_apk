package com.tencent.mm.plugin.finder.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.f.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.loader.t;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.plugin.finder.video.FinderFullSeekBarLayout;
import com.tencent.mm.plugin.finder.video.FinderLongVideoPlayerSeekBar;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout.b;
import com.tencent.mm.plugin.finder.video.FinderVideoSeekBar;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.base.a.a;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/adapter/FinderMediaBannerAdapter;", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "Landroid/view/View;", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "(Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;)V", "banner", "Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "getBanner", "()Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "setBanner", "(Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;)V", "feed", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "getFeed", "()Lcom/tencent/mm/plugin/finder/storage/FeedData;", "setFeed", "(Lcom/tencent/mm/plugin/finder/storage/FeedData;)V", "forbidVideoLayoutClickable", "", "getForbidVideoLayoutClickable", "()Z", "setForbidVideoLayoutClickable", "(Z)V", "fullVideoSeekBar", "Lcom/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout;", "getFullVideoSeekBar", "()Lcom/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout;", "setFullVideoSeekBar", "(Lcom/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout;)V", "isEnableFullScreenEnjoy", "setEnableFullScreenEnjoy", "isLongVideo", "setLongVideo", "isSupportBulletSubtitle", "setSupportBulletSubtitle", "isSupportVideoProgress", "setSupportVideoProgress", "pos", "", "getPos", "()I", "setPos", "(I)V", "tabType", "getTabType", "setTabType", "thumbShowCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "isShow", "Lcom/tencent/mm/plugin/finder/video/FinderVideoLayout$PlayInfo;", "playInfo", "", "getThumbShowCallback", "()Lkotlin/jvm/functions/Function2;", "setThumbShowCallback", "(Lkotlin/jvm/functions/Function2;)V", "getVideoCore", "()Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "setVideoCore", "videoPauseCallback", "isPause", "getVideoPauseCallback", "setVideoPauseCallback", "attachFinderImage", "Lcom/tencent/mm/plugin/finder/loader/FinderImageLoadData;", "mediaObj", "type", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "getItemViewType", "position", "onBindViewHolder", "holder", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "onBindViewHolderImpl", "onCreateItemView", "parent", "Landroid/view/ViewGroup;", "viewType", "onCreateItemViewImpl", "onViewRecycled", "Companion", "plugin-finder_release"})
public class FinderMediaBannerAdapter
  extends a<csg, View>
{
  public static final a Bdw;
  public boolean ANP;
  public m<? super Boolean, ? super FinderVideoLayout.b, x> AOb;
  public m<? super Boolean, ? super FinderVideoLayout.b, x> AOc;
  public FinderMediaBanner Bdr;
  private boolean Bds;
  public boolean Bdt;
  public boolean Bdu;
  public FinderFullSeekBarLayout Bdv;
  public int fEH;
  public FeedData feed;
  public boolean isLongVideo;
  public int pos;
  public com.tencent.mm.plugin.finder.video.l xkW;
  
  static
  {
    AppMethodBeat.i(168454);
    Bdw = new a((byte)0);
    AppMethodBeat.o(168454);
  }
  
  private FinderMediaBannerAdapter(byte paramByte)
  {
    this();
  }
  
  public FinderMediaBannerAdapter(com.tencent.mm.plugin.finder.video.l paraml)
  {
    this.xkW = paraml;
    this.Bdt = true;
    this.Bdu = true;
  }
  
  public final void a(com.tencent.mm.ui.base.a.b paramb, int paramInt)
  {
    AppMethodBeat.i(168451);
    p.k(paramb, "holder");
    super.a(paramb, paramInt);
    paramb.ez(auB(paramInt));
    p.k(paramb, "holder");
    switch (getItemViewType(paramInt))
    {
    }
    Object localObject1;
    label207:
    label243:
    do
    {
      AppMethodBeat.o(168451);
      return;
      localObject2 = (csg)auB(paramInt);
      ImageView localImageView = (ImageView)paramb.RD(b.f.finder_banner_image_layout);
      paramb = new FrameLayout.LayoutParams(-1, -1);
      p.j(localImageView, "imageView");
      localImageView.setLayoutParams((ViewGroup.LayoutParams)paramb);
      paramb.gravity = 17;
      localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      if (this.ANP)
      {
        paramb = t.ztT;
        paramb = t.dJe();
        localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        p.j(localObject2, "item");
        localObject1 = u.Aly;
        if (!this.ANP) {
          break label318;
        }
        localObject1 = (com.tencent.mm.plugin.finder.loader.r)new o((csg)localObject2, (u)localObject1);
        localObject1 = paramb.bQ(localObject1);
        paramb = com.tencent.mm.plugin.finder.storage.d.AjH;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.dUT().aSr()).intValue() <= 0) {
          break label336;
        }
        paramb = new com.tencent.mm.loader.e.d(null, null, 3);
        localObject1 = ((com.tencent.mm.loader.a.b)localObject1).a((com.tencent.mm.loader.f.d)paramb);
        if (!this.ANP) {
          break label341;
        }
        paramb = t.ztT;
      }
      for (paramb = t.a(t.a.ztV);; paramb = t.a(t.a.ztU))
      {
        ((com.tencent.mm.loader.b)localObject1).a(paramb).a((e)new FinderMediaBannerAdapter.b((csg)localObject2)).c(localImageView);
        AppMethodBeat.o(168451);
        return;
        paramb = t.ztT;
        paramb = t.dJg();
        break;
        localObject1 = new com.tencent.mm.plugin.finder.loader.r((csg)localObject2, (u)localObject1, null, null, 12);
        break label207;
        paramb = null;
        break label243;
        paramb = t.ztT;
      }
      localObject1 = (FinderVideoLayout)paramb.RD(b.f.finder_banner_video_layout);
      paramb = this.xkW;
      if (paramb != null) {
        ((FinderVideoLayout)localObject1).setVideoCore(paramb);
      }
      ((FinderVideoLayout)localObject1).setLongVideo(this.isLongVideo);
      localObject2 = this.feed;
      if (localObject2 != null)
      {
        if (!this.isLongVideo) {
          break label534;
        }
        paramb = this.Bdr;
        if (paramb == null) {
          break label524;
        }
        paramb = paramb.getLongVideoSeekBar();
        ((FinderVideoLayout)localObject1).setLongVideoSeekBar(paramb);
        FinderVideoLayout.a((FinderVideoLayout)localObject1, paramInt, (FeedData)localObject2, this.fEH, this.ANP, false, 192);
        paramb = this.Bdr;
        if (paramb != null)
        {
          paramb = paramb.getLongVideoSeekBar();
          if (paramb != null)
          {
            localObject2 = (csg)j.lp((List)((FeedData)localObject2).getMediaList());
            if (localObject2 == null) {
              break label529;
            }
          }
        }
      }
      for (paramInt = ((csg)localObject2).videoDuration;; paramInt = 0)
      {
        paramb.setVideoTotalTime(paramInt);
        if (!this.Bds) {
          break;
        }
        p.j(localObject1, "videoContainer");
        ((FinderVideoLayout)localObject1).setClickable(false);
        ((FinderVideoLayout)localObject1).setLongClickable(false);
        AppMethodBeat.o(168451);
        return;
        paramb = null;
        break label420;
      }
      paramb = this.Bdr;
      if (paramb != null)
      {
        paramb = (FinderVideoSeekBar)paramb.findViewById(b.f.preview_seek_bar_layout);
        if (this.Bdv != null) {
          break label602;
        }
      }
      for (paramb = (com.tencent.mm.plugin.finder.video.r)paramb;; paramb = (com.tencent.mm.plugin.finder.video.r)this.Bdv)
      {
        ((FinderVideoLayout)localObject1).a(paramInt, (FeedData)localObject2, paramb, this.fEH, this.ANP, this.Bdt, this.AOb, this.AOc);
        break;
        paramb = null;
        break label554;
      }
      paramb = (FinderVideoLayout)paramb.RD(b.f.finder_banner_video_layout);
      localObject1 = this.feed;
    } while (localObject1 == null);
    label318:
    label336:
    label341:
    label602:
    Object localObject2 = this.xkW;
    label420:
    label554:
    if (localObject2 != null) {
      paramb.setVideoCore((com.tencent.mm.plugin.finder.video.l)localObject2);
    }
    label524:
    label529:
    label534:
    paramb.a(paramInt, (FeedData)localObject1, null, this.fEH, this.ANP, this.Bdt, this.AOb, this.AOc);
    AppMethodBeat.o(168451);
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(168450);
    paramInt = ((csg)this.ctq.get(paramInt)).mediaType;
    AppMethodBeat.o(168450);
    return paramInt;
  }
  
  public final View m(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(168449);
    p.k(paramViewGroup, "parent");
    p.k(paramViewGroup, "parent");
    if ((paramInt == 4) || (paramInt == 9))
    {
      paramViewGroup = ad.kS(paramViewGroup.getContext()).inflate(b.g.finder_media_video_container, paramViewGroup, false);
      p.j(paramViewGroup, "MMLayoutInflater.getInfl…container, parent, false)");
      AppMethodBeat.o(168449);
      return paramViewGroup;
    }
    if ((paramInt == 2) || (paramInt == 7))
    {
      paramViewGroup = ad.kS(paramViewGroup.getContext()).inflate(b.g.finder_media_image_container, paramViewGroup, false);
      p.j(paramViewGroup, "MMLayoutInflater.getInfl…container, parent, false)");
      AppMethodBeat.o(168449);
      return paramViewGroup;
    }
    paramViewGroup = new View(paramViewGroup.getContext());
    AppMethodBeat.o(168449);
    return paramViewGroup;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/adapter/FinderMediaBannerAdapter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter
 * JD-Core Version:    0.7.0.1
 */