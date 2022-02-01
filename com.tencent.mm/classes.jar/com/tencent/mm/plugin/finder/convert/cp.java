package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.loader.k;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import java.util.List<Ljava.lang.Object;>;
import kotlin.a.j;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/NearbyVideoFeedConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedRoundCornerConvert;", "()V", "screenWidth", "", "getScreenWidth", "()I", "screenWidth$delegate", "Lkotlin/Lazy;", "bindLive", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "localFinderMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "onBindViewHolder", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
public class cp
  extends ae
{
  private final f tCY;
  
  public cp()
  {
    super(2131494301);
    AppMethodBeat.i(243392);
    this.tCY = g.ah((a)a.tHj);
    AppMethodBeat.o(243392);
  }
  
  public void a(h paramh, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(243390);
    kotlin.g.b.p.h(paramh, "holder");
    kotlin.g.b.p.h(paramBaseFinderFeed, "item");
    super.a(paramh, paramBaseFinderFeed, paramInt1, paramInt2, paramBoolean, paramList);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (paramBaseFinderFeed.feedObject.isLiveFeed())
    {
      localObject1 = (cjl)j.ks((List)paramBaseFinderFeed.feedObject.getLiveMediaList());
      paramList = (ImageView)paramh.Mn(2131309073);
      kotlin.g.b.p.g(paramList, "thumbIv");
      localObject2 = paramList.getLayoutParams();
      paramInt1 = ((Number)this.tCY.getValue()).intValue();
      localObject3 = paramh.getContext();
      kotlin.g.b.p.g(localObject3, "holder.context");
      paramInt1 = (paramInt1 - (int)((Context)localObject3).getResources().getDimension(2131165289)) / 2;
      localObject3 = y.vXH;
      paramInt2 = y.a(paramBaseFinderFeed, (cjl)localObject1, paramInt1);
      if (paramInt2 > 0)
      {
        ((ViewGroup.LayoutParams)localObject2).width = paramInt1;
        ((ViewGroup.LayoutParams)localObject2).height = paramInt2;
        paramList.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      if (!Util.isNullOrNil(((cjl)localObject1).coverUrl)) {
        break label572;
      }
      localObject2 = new k((cjl)localObject1, x.vEo, null, null, 12);
      localObject3 = com.tencent.mm.plugin.finder.loader.m.uJa;
      localObject3 = com.tencent.mm.plugin.finder.loader.m.djY();
      localObject4 = com.tencent.mm.plugin.finder.loader.m.uJa;
      ((d)localObject3).a(localObject2, paramList, com.tencent.mm.plugin.finder.loader.m.a(m.a.uJb));
      label226:
      localObject3 = (ImageView)paramh.Mn(2131309073);
      localObject2 = ((cjl)localObject1).coverUrl;
      paramList = (List<Object>)localObject2;
      if (localObject2 == null) {
        paramList = "";
      }
      kotlin.g.b.p.g(paramList, "localFinderMedia.coverUrl ?: \"\"");
      if (!Util.isNullOrNil(paramList)) {
        break label712;
      }
      paramList = kotlin.g.b.p.I(((cjl)localObject1).thumbUrl, Util.nullAsNil(((cjl)localObject1).thumb_url_token));
    }
    label445:
    label702:
    label707:
    label712:
    for (;;)
    {
      localObject1 = (FinderLiveOnliveWidget)paramh.Mn(2131301145);
      localObject2 = paramh.Mn(2131301215);
      paramh = (TextView)paramh.Mn(2131300801);
      if (paramBaseFinderFeed.feedObject.isLiveFeed())
      {
        localObject4 = paramBaseFinderFeed.feedObject.getLiveInfo();
        if ((localObject4 != null) && (((awe)localObject4).liveStatus == 1))
        {
          localObject4 = com.tencent.mm.plugin.finder.loader.m.uJa;
          localObject4 = com.tencent.mm.plugin.finder.loader.m.djY();
          paramList = new com.tencent.mm.plugin.finder.loader.p(paramList, x.vEn);
          kotlin.g.b.p.g(localObject3, "thumbIv");
          com.tencent.mm.plugin.finder.loader.m localm = com.tencent.mm.plugin.finder.loader.m.uJa;
          ((d)localObject4).a(paramList, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.m.a(m.a.uJb));
          kotlin.g.b.p.g(localObject1, "liveFinishView");
          ((FinderLiveOnliveWidget)localObject1).setVisibility(8);
          kotlin.g.b.p.g(localObject2, "onliveWidget");
          ((View)localObject2).setVisibility(0);
          kotlin.g.b.p.g(paramh, "desc");
          paramh.setVisibility(8);
          paramList = new StringBuilder("mediaType:").append(paramBaseFinderFeed.feedObject.getMediaType()).append(",liveStatus:");
          paramh = paramBaseFinderFeed.feedObject.getLiveInfo();
          if (paramh == null) {
            break label702;
          }
          paramh = Integer.valueOf(paramh.liveStatus);
          label493:
          paramList = paramList.append(paramh).append(",contact liveStatus:");
          paramh = paramBaseFinderFeed.feedObject.getRefObjectContact();
          if (paramh == null) {
            break label707;
          }
        }
      }
      for (paramh = Integer.valueOf(paramh.liveStatus);; paramh = null)
      {
        Log.i("FinderFeedVideoRoundCornerConvert", paramh.intValue());
        AppMethodBeat.o(243390);
        return;
        localObject1 = (cjl)j.ks((List)paramBaseFinderFeed.feedObject.getMediaList());
        break;
        localObject2 = new com.tencent.mm.plugin.finder.loader.q((cjl)localObject1, x.vEn);
        localObject3 = com.tencent.mm.plugin.finder.loader.m.uJa;
        localObject3 = com.tencent.mm.plugin.finder.loader.m.djY();
        localObject4 = com.tencent.mm.plugin.finder.loader.m.uJa;
        ((d)localObject3).a(localObject2, paramList, com.tencent.mm.plugin.finder.loader.m.a(m.a.uJb));
        break label226;
        paramh = com.tencent.mm.plugin.finder.utils.m.vVH;
        kotlin.g.b.p.g(localObject3, "thumbIv");
        com.tencent.mm.plugin.finder.utils.m.h((ImageView)localObject3, paramList);
        kotlin.g.b.p.g(localObject1, "liveFinishView");
        ((FinderLiveOnliveWidget)localObject1).setVisibility(0);
        kotlin.g.b.p.g(localObject2, "onliveWidget");
        ((View)localObject2).setVisibility(8);
        break label445;
        kotlin.g.b.p.g(localObject1, "liveFinishView");
        ((FinderLiveOnliveWidget)localObject1).setVisibility(8);
        kotlin.g.b.p.g(localObject2, "onliveWidget");
        ((View)localObject2).setVisibility(8);
        break label445;
        paramh = null;
        break label493;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements a<Integer>
  {
    public static final a tHj;
    
    static
    {
      AppMethodBeat.i(243389);
      tHj = new a();
      AppMethodBeat.o(243389);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.cp
 * JD-Core Version:    0.7.0.1
 */