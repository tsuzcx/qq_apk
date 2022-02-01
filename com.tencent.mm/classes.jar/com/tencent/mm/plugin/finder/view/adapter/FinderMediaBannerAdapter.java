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
import com.tencent.mm.autogen.a.si;
import com.tencent.mm.loader.d.b.g;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.loader.k;
import com.tencent.mm.plugin.finder.loader.n;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.loader.r;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.video.FinderFullSeekBarLayout;
import com.tencent.mm.plugin.finder.video.FinderLongVideoPlayerSeekBar;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout.b;
import com.tencent.mm.plugin.finder.video.FinderVideoSeekBar;
import com.tencent.mm.plugin.finder.video.l;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.af;
import com.tencent.mm.vfs.y;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/adapter/FinderMediaBannerAdapter;", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "Landroid/view/View;", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "(Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;)V", "banner", "Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "getBanner", "()Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "setBanner", "(Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;)V", "feed", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "getFeed", "()Lcom/tencent/mm/plugin/finder/storage/FeedData;", "setFeed", "(Lcom/tencent/mm/plugin/finder/storage/FeedData;)V", "forbidVideoLayoutClickable", "", "getForbidVideoLayoutClickable", "()Z", "setForbidVideoLayoutClickable", "(Z)V", "fullVideoSeekBar", "Lcom/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout;", "getFullVideoSeekBar", "()Lcom/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout;", "setFullVideoSeekBar", "(Lcom/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout;)V", "isEnableFullScreenEnjoy", "setEnableFullScreenEnjoy", "isLongVideo", "setLongVideo", "isSupportBulletSubtitle", "setSupportBulletSubtitle", "isSupportVideoProgress", "setSupportVideoProgress", "pos", "", "getPos", "()I", "setPos", "(I)V", "tabType", "getTabType", "setTabType", "thumbShowCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "isShow", "Lcom/tencent/mm/plugin/finder/video/FinderVideoLayout$PlayInfo;", "playInfo", "", "getThumbShowCallback", "()Lkotlin/jvm/functions/Function2;", "setThumbShowCallback", "(Lkotlin/jvm/functions/Function2;)V", "getVideoCore", "()Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "setVideoCore", "videoPauseCallback", "isPause", "getVideoPauseCallback", "setVideoPauseCallback", "attachFinderImage", "Lcom/tencent/mm/plugin/finder/loader/FinderImageLoadData;", "mediaObj", "type", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "getItemViewType", "position", "onBindViewHolder", "holder", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "onBindViewHolderImpl", "onCreateItemView", "parent", "Landroid/view/ViewGroup;", "viewType", "onCreateItemViewImpl", "onViewRecycled", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public class FinderMediaBannerAdapter
  extends com.tencent.mm.ui.base.a.a<dji, View>
{
  public static final FinderMediaBannerAdapter.a GGc;
  public l AJn;
  public FinderMediaBanner GGd;
  private boolean GGe;
  public boolean GGf;
  public boolean GGg;
  public FinderFullSeekBarLayout GGh;
  public m<? super Boolean, ? super FinderVideoLayout.b, ah> GqD;
  public m<? super Boolean, ? super FinderVideoLayout.b, ah> GqE;
  public boolean Gqo;
  public FeedData feed;
  public int hJx;
  public boolean isLongVideo;
  
  static
  {
    AppMethodBeat.i(168454);
    GGc = new FinderMediaBannerAdapter.a((byte)0);
    AppMethodBeat.o(168454);
  }
  
  private FinderMediaBannerAdapter(byte paramByte)
  {
    this();
  }
  
  public FinderMediaBannerAdapter(l paraml)
  {
    this.AJn = paraml;
    this.GGf = true;
    this.GGg = true;
  }
  
  private static final void a(dji paramdji, com.tencent.mm.loader.g.a.a parama, g paramg, Bitmap paramBitmap)
  {
    AppMethodBeat.i(345481);
    if (paramBitmap != null)
    {
      paramg = new si();
      int i = (int)y.bEl(((r)parama.bmg()).getPath());
      parama = paramg.hVv;
      parama.mediaId = paramdji.mediaId;
      parama.type = 2;
      parama.size = i;
      paramg.publish();
      Log.i("Finder.MediaBannerAdapter", paramdji.mediaId + " [" + paramBitmap.getWidth() + ':' + paramBitmap.getHeight() + "] fileLength=" + Util.getSizeKB(i) + " allocationByteCount=" + Util.getSizeKB(paramBitmap.getAllocationByteCount()));
    }
    AppMethodBeat.o(345481);
  }
  
  public final void a(com.tencent.mm.ui.base.a.b paramb, int paramInt)
  {
    AppMethodBeat.i(168451);
    kotlin.g.b.s.u(paramb, "holder");
    super.a(paramb, paramInt);
    paramb.CSA = aBc(paramInt);
    kotlin.g.b.s.u(paramb, "holder");
    switch (getItemViewType(paramInt))
    {
    }
    for (;;)
    {
      AppMethodBeat.o(168451);
      return;
      Object localObject2 = (dji)aBc(paramInt);
      ImageView localImageView = (ImageView)paramb.UH(e.e.finder_banner_image_layout);
      paramb = new FrameLayout.LayoutParams(-1, -1);
      localImageView.setLayoutParams((ViewGroup.LayoutParams)paramb);
      paramb.gravity = 17;
      if (this.Gqo)
      {
        paramb = com.tencent.mm.plugin.finder.loader.p.ExI;
        paramb = com.tencent.mm.plugin.finder.loader.p.eCl();
        localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        kotlin.g.b.s.s(localObject2, "item");
        localObject1 = v.FKY;
        if (!this.Gqo) {
          break label311;
        }
        localObject1 = (n)new k((dji)localObject2, (v)localObject1);
        label193:
        localObject1 = paramb.dk(localObject1);
        paramb = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.eTs().bmg()).intValue() <= 0) {
          break label329;
        }
        paramb = new com.tencent.mm.loader.d.d(null, null, 3);
        label229:
        localObject1 = ((com.tencent.mm.loader.a.b)localObject1).a((com.tencent.mm.loader.e.d)paramb);
        if (!this.Gqo) {
          break label334;
        }
        paramb = com.tencent.mm.plugin.finder.loader.p.ExI;
      }
      for (paramb = com.tencent.mm.plugin.finder.loader.p.a(p.a.ExK);; paramb = com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ))
      {
        paramb = ((com.tencent.mm.loader.b)localObject1).a(paramb).a(new FinderMediaBannerAdapter..ExternalSyntheticLambda0((dji)localObject2));
        kotlin.g.b.s.s(localImageView, "imageView");
        paramb.d(localImageView);
        AppMethodBeat.o(168451);
        return;
        paramb = com.tencent.mm.plugin.finder.loader.p.ExI;
        paramb = com.tencent.mm.plugin.finder.loader.p.eCo();
        break;
        label311:
        localObject1 = new n((dji)localObject2, (v)localObject1, null, null, 12);
        break label193;
        label329:
        paramb = null;
        break label229;
        label334:
        paramb = com.tencent.mm.plugin.finder.loader.p.ExI;
      }
      Object localObject1 = (FinderVideoLayout)paramb.UH(e.e.finder_banner_video_layout);
      paramb = this.AJn;
      if (paramb != null) {
        ((FinderVideoLayout)localObject1).setVideoCore(paramb);
      }
      ((FinderVideoLayout)localObject1).setLongVideo(this.isLongVideo);
      localObject2 = this.feed;
      if (localObject2 != null)
      {
        if (!this.isLongVideo) {
          break label532;
        }
        paramb = this.GGd;
        if (paramb != null) {
          break label507;
        }
        paramb = null;
        label410:
        ((FinderVideoLayout)localObject1).setLongVideoSeekBar(paramb);
        kotlin.g.b.s.s(localObject1, "videoContainer");
        FinderVideoLayout.a((FinderVideoLayout)localObject1, paramInt, (FeedData)localObject2, this.hJx, this.Gqo, false, 192);
        paramb = this.GGd;
        if (paramb != null) {
          break label515;
        }
        paramb = null;
        label452:
        if (paramb != null)
        {
          localObject2 = (dji)kotlin.a.p.oL((List)((FeedData)localObject2).getMediaList());
          if (localObject2 != null) {
            break label523;
          }
        }
      }
      label515:
      label523:
      for (paramInt = 0;; paramInt = ((dji)localObject2).videoDuration)
      {
        paramb.setVideoTotalTime(paramInt);
        if (!this.GGe) {
          break;
        }
        ((FinderVideoLayout)localObject1).setClickable(false);
        ((FinderVideoLayout)localObject1).setLongClickable(false);
        AppMethodBeat.o(168451);
        return;
        label507:
        paramb = paramb.getLongVideoSeekBar();
        break label410;
        paramb = paramb.getLongVideoSeekBar();
        break label452;
      }
      label532:
      paramb = this.GGd;
      if (paramb == null)
      {
        paramb = null;
        label543:
        if (this.GGh != null) {
          break label598;
        }
      }
      for (;;)
      {
        ((FinderVideoLayout)localObject1).a(paramInt, (FeedData)localObject2, (com.tencent.mm.plugin.finder.video.s)paramb, this.hJx, this.Gqo, this.GGf, this.GqD, this.GqE);
        break;
        paramb = (FinderVideoSeekBar)paramb.findViewById(e.e.preview_seek_bar_layout);
        break label543;
        label598:
        paramb = this.GGh;
      }
      paramb = (FinderVideoLayout)paramb.UH(e.e.finder_banner_video_layout);
      localObject1 = this.feed;
      if (localObject1 != null)
      {
        localObject2 = this.AJn;
        if (localObject2 != null) {
          paramb.setVideoCore((l)localObject2);
        }
        paramb.a(paramInt, (FeedData)localObject1, null, this.hJx, this.Gqo, this.GGf, this.GqD, this.GqE);
      }
    }
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(168450);
    paramInt = ((dji)this.ell.get(paramInt)).mediaType;
    AppMethodBeat.o(168450);
    return paramInt;
  }
  
  public final View m(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(168449);
    kotlin.g.b.s.u(paramViewGroup, "parent");
    kotlin.g.b.s.u(paramViewGroup, "parent");
    switch (paramInt)
    {
    case 3: 
    case 5: 
    case 6: 
    case 8: 
    default: 
      paramViewGroup = new View(paramViewGroup.getContext());
      AppMethodBeat.o(168449);
      return paramViewGroup;
    case 4: 
    case 9: 
      paramViewGroup = af.mU(paramViewGroup.getContext()).inflate(e.f.finder_media_video_container, paramViewGroup, false);
      kotlin.g.b.s.s(paramViewGroup, "getInflater(parent.conte…container, parent, false)");
      AppMethodBeat.o(168449);
      return paramViewGroup;
    }
    paramViewGroup = af.mU(paramViewGroup.getContext()).inflate(e.f.finder_media_image_container, paramViewGroup, false);
    kotlin.g.b.s.s(paramViewGroup, "getInflater(parent.conte…container, parent, false)");
    AppMethodBeat.o(168449);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter
 * JD-Core Version:    0.7.0.1
 */