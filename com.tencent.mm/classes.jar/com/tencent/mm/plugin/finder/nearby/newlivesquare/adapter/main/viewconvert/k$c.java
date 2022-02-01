package com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.viewconvert;

import android.view.View;
import android.widget.ImageView;
import com.tencent.d.a.a.a.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.base.b;
import com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.l;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget;
import com.tencent.mm.plugin.g;
import com.tencent.mm.plugin.g.a;
import com.tencent.mm.protocal.protobuf.azl;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.view.recyclerview.j;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/RelatedLivingConvert$refreshLiveStatusInfo$1", "Lcom/tencent/plugin/finder/live/api/IPluginFinderLive$FinderLiveStatusCallback;", "onLiveStatusCallback", "", "respLiveId", "", "status", "", "liveInfoResp", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k$c
  implements b.d
{
  k$c(k.a parama, l paraml, j paramj, k paramk) {}
  
  public final void onLiveStatusCallback(long paramLong, int paramInt, Object paramObject)
  {
    long l2 = 0L;
    Object localObject2 = null;
    paramInt = 1;
    AppMethodBeat.i(370528);
    Object localObject1 = this.akhY.akhV;
    long l1;
    if (localObject1 == null) {
      l1 = l2;
    }
    while (l1 != paramLong)
    {
      Log.i("Finder.Loader", "#refreshLiveStatus oh, return live id " + paramLong + " is not you.");
      AppMethodBeat.o(370528);
      return;
      localObject1 = ((BaseFinderFeed)localObject1).feedObject;
      l1 = l2;
      if (localObject1 != null)
      {
        localObject1 = ((FinderItem)localObject1).getLiveInfo();
        l1 = l2;
        if (localObject1 != null) {
          l1 = ((bip)localObject1).liveId;
        }
      }
    }
    if (!(paramObject instanceof azl))
    {
      AppMethodBeat.o(370528);
      return;
    }
    localObject1 = this.akhY.akhV;
    label167:
    boolean bool;
    label227:
    Object localObject3;
    j localj;
    k localk;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null)
      {
        paramObject = ((azl)paramObject).liveInfo;
        if (paramObject != null) {
          break label534;
        }
        paramObject = localObject2;
        ((bip)localObject1).liveStatus = paramObject.intValue();
      }
      paramObject = this.akhY.akhV;
      if (paramObject == null) {
        break label547;
      }
      paramObject = paramObject.feedObject;
      if (paramObject == null) {
        break label547;
      }
      paramObject = paramObject.getLiveInfo();
      if ((paramObject == null) || (paramObject.liveStatus != 1)) {
        break label547;
      }
      bool = true;
      localObject3 = this.akhX;
      localj = this.wHm;
      localk = this.akhW;
      if (!((BaseFinderFeed)localObject3).feedObject.isLiveFeed()) {
        break label553;
      }
      localObject1 = (dji)kotlin.a.p.oK((List)((BaseFinderFeed)localObject3).feedObject.getLiveMediaList());
      label275:
      localObject2 = ((b)localObject3).ENz;
      paramObject = localObject2;
      if (localObject2 == null) {
        paramObject = "";
      }
      if (((CharSequence)paramObject).length() != 0) {
        break label575;
      }
      label308:
      if (paramInt == 0) {
        break label644;
      }
      localObject2 = ((b)localObject3).ENz;
      paramObject = localObject2;
      if (localObject2 == null)
      {
        localObject2 = ((dji)localObject1).coverUrl;
        paramObject = localObject2;
        if (localObject2 == null) {
          paramObject = "";
        }
      }
    }
    label644:
    for (;;)
    {
      if (Util.isNullOrNil(paramObject)) {
        paramObject = kotlin.g.b.s.X(((dji)localObject1).thumbUrl, Util.nullAsNil(((dji)localObject1).thumb_url_token));
      }
      for (;;)
      {
        localObject2 = (FinderLiveOnliveWidget)localj.UH(e.e.finder_live_mask_view);
        localObject3 = localj.UH(e.e.finder_live_online_layout);
        localObject1 = (ImageView)localj.UH(e.e.thumb_iv);
        if (!bool)
        {
          if (localObject2 != null) {
            ((FinderLiveOnliveWidget)localObject2).setVisibility(0);
          }
          if (localObject3 != null) {
            ((View)localObject3).setVisibility(8);
          }
          if (localObject1 != null)
          {
            localObject2 = h.ax(g.class);
            kotlin.g.b.s.s(localObject2, "service(IFinderCommonLiveService::class.java)");
            g.a.a((g)localObject2, (ImageView)localObject1, paramObject);
          }
        }
        for (;;)
        {
          Log.i("Finder.Loader", "#refreshLiveStatus return live id " + paramLong + " is you. is living? " + bool);
          AppMethodBeat.o(370528);
          return;
          localObject1 = ((BaseFinderFeed)localObject1).feedObject;
          if (localObject1 == null)
          {
            localObject1 = null;
            break;
          }
          localObject1 = ((FinderItem)localObject1).getLiveInfo();
          break;
          label534:
          paramObject = Integer.valueOf(paramObject.liveStatus);
          break label167;
          label547:
          bool = false;
          break label227;
          label553:
          localObject1 = (dji)kotlin.a.p.oK((List)((BaseFinderFeed)localObject3).feedObject.getMediaList());
          break label275;
          label575:
          paramInt = 0;
          break label308;
          if (localObject2 != null) {
            ((FinderLiveOnliveWidget)localObject2).setVisibility(8);
          }
          if (localObject3 != null) {
            ((View)localObject3).setVisibility(0);
          }
          if (localObject1 != null)
          {
            localObject2 = com.tencent.mm.plugin.finder.loader.p.ExI;
            com.tencent.mm.plugin.finder.loader.p.eCl().a(new com.tencent.mm.plugin.finder.loader.s(paramObject, v.FKY), (ImageView)localObject1, localk.kLv());
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.viewconvert.k.c
 * JD-Core Version:    0.7.0.1
 */