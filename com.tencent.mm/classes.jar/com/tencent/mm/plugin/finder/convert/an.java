package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.loader.r;
import com.tencent.mm.plugin.finder.loader.t;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.loader.x;
import com.tencent.mm.plugin.finder.loader.y;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.view.recyclerview.i;
import java.util.List;
import java.util.List<Ljava.lang.Object;>;
import kotlin.a.j;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedVideoRoundCornerConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedRoundCornerConvert;", "()V", "screenWidth", "", "getScreenWidth", "()I", "screenWidth$delegate", "Lkotlin/Lazy;", "bindLive", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "localFinderMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "onBindViewHolder", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
public class an
  extends ag
{
  private final f xlu;
  
  public an()
  {
    super(b.g.finder_feed_round_corner_media_item);
    AppMethodBeat.i(289748);
    this.xlu = g.ar((kotlin.g.a.a)an.a.xmK);
    AppMethodBeat.o(289748);
  }
  
  public void a(i parami, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(165436);
    p.k(parami, "holder");
    p.k(paramBaseFinderFeed, "item");
    super.a(parami, paramBaseFinderFeed, paramInt1, paramInt2, paramBoolean, paramList);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (paramBaseFinderFeed.feedObject.isLiveFeed())
    {
      localObject1 = (csg)j.lo((List)paramBaseFinderFeed.feedObject.getLiveMediaList());
      paramList = (ImageView)parami.RD(b.f.thumb_iv);
      p.j(paramList, "thumbIv");
      localObject2 = paramList.getLayoutParams();
      paramInt1 = ((Number)this.xlu.getValue()).intValue();
      localObject3 = parami.getContext();
      p.j(localObject3, "holder.context");
      paramInt1 = (paramInt1 - (int)((Context)localObject3).getResources().getDimension(b.d.Edge_1_5_A)) / 2;
      localObject3 = aj.AGc;
      paramInt2 = aj.a(paramBaseFinderFeed, (csg)localObject1, paramInt1);
      if (paramInt2 > 0)
      {
        ((ViewGroup.LayoutParams)localObject2).width = paramInt1;
        ((ViewGroup.LayoutParams)localObject2).height = paramInt2;
        paramList.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      if (!Util.isNullOrNil(((csg)localObject1).coverUrl)) {
        break label586;
      }
      localObject2 = new r((csg)localObject1, u.Alz, null, null, 12);
      localObject3 = t.ztT;
      localObject3 = t.dJe();
      localObject4 = t.ztT;
      ((d)localObject3).a(localObject2, paramList, t.a(t.a.ztU));
      label228:
      localObject3 = (ImageView)parami.RD(b.f.thumb_iv);
      localObject2 = ((csg)localObject1).coverUrl;
      paramList = (List<Object>)localObject2;
      if (localObject2 == null) {
        paramList = "";
      }
      p.j(paramList, "localFinderMedia.coverUrl ?: \"\"");
      if (!Util.isNullOrNil(paramList)) {
        break label727;
      }
      paramList = p.I(((csg)localObject1).thumbUrl, Util.nullAsNil(((csg)localObject1).thumb_url_token));
    }
    label454:
    label586:
    label717:
    label722:
    label727:
    for (;;)
    {
      localObject1 = (FinderLiveOnliveWidget)parami.RD(b.f.finder_live_mask_view);
      localObject2 = parami.RD(b.f.finder_live_onlive_widget);
      localObject4 = (TextView)parami.RD(b.f.finder_desc);
      if (paramBaseFinderFeed.feedObject.isLiveFeed())
      {
        Object localObject5 = paramBaseFinderFeed.feedObject.getLiveInfo();
        if ((localObject5 != null) && (((bac)localObject5).liveStatus == 1))
        {
          localObject5 = t.ztT;
          localObject5 = t.dJe();
          paramList = new x(paramList, u.Aly);
          p.j(localObject3, "thumbIv");
          t localt = t.ztT;
          ((d)localObject5).a(paramList, (ImageView)localObject3, t.a(t.a.ztU));
          p.j(localObject1, "liveFinishView");
          ((FinderLiveOnliveWidget)localObject1).setVisibility(8);
          p.j(localObject2, "onliveWidget");
          ((View)localObject2).setVisibility(0);
          p.j(localObject4, "desc");
          ((TextView)localObject4).setVisibility(8);
          l(parami, paramBaseFinderFeed);
          paramList = new StringBuilder("mediaType:").append(paramBaseFinderFeed.feedObject.getMediaType()).append(",liveStatus:");
          parami = paramBaseFinderFeed.feedObject.getLiveInfo();
          if (parami == null) {
            break label717;
          }
          parami = Integer.valueOf(parami.liveStatus);
          label507:
          paramList = paramList.append(parami).append(",contact liveStatus:");
          parami = paramBaseFinderFeed.feedObject.getRefObjectContact();
          if (parami == null) {
            break label722;
          }
        }
      }
      for (parami = Integer.valueOf(parami.liveStatus);; parami = null)
      {
        Log.i("FinderFeedVideoRoundCornerConvert", parami.intValue());
        AppMethodBeat.o(165436);
        return;
        localObject1 = (csg)j.lo((List)paramBaseFinderFeed.feedObject.getMediaList());
        break;
        localObject2 = new y((csg)localObject1, u.Aly);
        localObject3 = t.ztT;
        localObject3 = t.dJe();
        localObject4 = t.ztT;
        ((d)localObject3).a(localObject2, paramList, t.a(t.a.ztU));
        break label228;
        localObject4 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
        p.j(localObject3, "thumbIv");
        com.tencent.mm.plugin.finder.live.utils.a.g((ImageView)localObject3, paramList);
        p.j(localObject1, "liveFinishView");
        ((FinderLiveOnliveWidget)localObject1).setVisibility(0);
        p.j(localObject2, "onliveWidget");
        ((View)localObject2).setVisibility(8);
        break label454;
        p.j(localObject1, "liveFinishView");
        ((FinderLiveOnliveWidget)localObject1).setVisibility(8);
        p.j(localObject2, "onliveWidget");
        ((View)localObject2).setVisibility(8);
        break label454;
        parami = null;
        break label507;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.an
 * JD-Core Version:    0.7.0.1
 */