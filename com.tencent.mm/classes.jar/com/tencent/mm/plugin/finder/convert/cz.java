package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.loader.n;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.loader.t;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.utils.at;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget;
import com.tencent.mm.plugin.findersdk.storage.config.base.b;
import com.tencent.mm.plugin.g;
import com.tencent.mm.plugin.g.a;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bd;
import com.tencent.mm.view.recyclerview.j;
import java.util.List;
import java.util.List<Ljava.lang.Object;>;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/NearbyVideoFeedConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedRoundCornerConvert;", "()V", "screenWidth", "", "getScreenWidth", "()I", "bindLive", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "localFinderMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "onBindViewHolder", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public class cz
  extends ac
{
  private final int sJv;
  
  public cz()
  {
    super(e.f.finder_feed_round_corner_media_item);
    AppMethodBeat.i(349782);
    at localat = at.GiI;
    this.sJv = at.getScreenWidth();
    AppMethodBeat.o(349782);
  }
  
  public void a(j paramj, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(349839);
    kotlin.g.b.s.u(paramj, "holder");
    kotlin.g.b.s.u(paramBaseFinderFeed, "item");
    super.a(paramj, paramBaseFinderFeed, paramInt1, paramInt2, paramBoolean, paramList);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    label105:
    Object localObject4;
    if (paramBaseFinderFeed.feedObject.isLiveFeed())
    {
      localObject1 = (dji)kotlin.a.p.oK((List)paramBaseFinderFeed.feedObject.getLiveMediaList());
      paramList = (ImageView)paramj.UH(e.e.thumb_iv);
      localObject2 = paramList.getLayoutParams();
      if (!aw.ato()) {
        break label746;
      }
      localObject3 = MMApplicationContext.getContext();
      paramInt1 = bd.fromDPToPix((Context)localObject3, ((Context)localObject3).getResources().getConfiguration().screenWidthDp);
      paramInt1 = (paramInt1 - (int)paramj.context.getResources().getDimension(e.c.Edge_1_5_A)) / 2;
      localObject3 = av.GiL;
      paramInt2 = av.a(paramBaseFinderFeed, (dji)localObject1, paramInt1);
      if (paramInt2 > 0)
      {
        ((ViewGroup.LayoutParams)localObject2).width = paramInt1;
        ((ViewGroup.LayoutParams)localObject2).height = paramInt2;
        paramList.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      if (!Util.isNullOrNil(((dji)localObject1).coverUrl)) {
        break label754;
      }
      localObject2 = new n((dji)localObject1, v.FKZ, null, null, 12);
      localObject3 = com.tencent.mm.plugin.finder.loader.p.ExI;
      localObject3 = com.tencent.mm.plugin.finder.loader.p.eCl();
      kotlin.g.b.s.s(paramList, "thumbIv");
      localObject4 = com.tencent.mm.plugin.finder.loader.p.ExI;
      ((com.tencent.mm.loader.d)localObject3).a(localObject2, paramList, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ));
      label229:
      localObject3 = (ImageView)paramj.UH(e.e.thumb_iv);
      localObject2 = ((dji)localObject1).coverUrl;
      paramList = (List<Object>)localObject2;
      if (localObject2 == null) {
        paramList = "";
      }
      if (!Util.isNullOrNil(paramList)) {
        break label1011;
      }
      paramList = kotlin.g.b.s.X(((dji)localObject1).thumbUrl, Util.nullAsNil(((dji)localObject1).thumb_url_token));
    }
    label355:
    label622:
    label754:
    label1011:
    for (;;)
    {
      localObject1 = (FinderLiveOnliveWidget)paramj.UH(e.e.finder_live_mask_view);
      localObject2 = paramj.UH(e.e.finder_live_onlive_widget);
      localObject4 = (TextView)paramj.UH(e.e.finder_desc);
      if (paramBaseFinderFeed.feedObject.isLiveFeed())
      {
        Object localObject5 = paramBaseFinderFeed.feedObject.getLiveInfo();
        if ((localObject5 != null) && (((bip)localObject5).liveStatus == 1))
        {
          paramInt1 = 1;
          if (paramInt1 == 0) {
            break label813;
          }
          localObject5 = com.tencent.mm.plugin.finder.loader.p.ExI;
          localObject5 = com.tencent.mm.plugin.finder.loader.p.eCl();
          paramList = new com.tencent.mm.plugin.finder.loader.s(paramList, v.FKY);
          kotlin.g.b.s.s(localObject3, "thumbIv");
          com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
          ((com.tencent.mm.loader.d)localObject5).a(paramList, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ));
          ((FinderLiveOnliveWidget)localObject1).setVisibility(8);
          ((View)localObject2).setVisibility(0);
          ((TextView)localObject4).setVisibility(8);
          localObject1 = new StringBuilder("mediaType:").append(paramBaseFinderFeed.feedObject.getMediaType()).append(",liveStatus:");
          paramList = paramBaseFinderFeed.feedObject.getLiveInfo();
          if (paramList != null) {
            break label885;
          }
          paramList = null;
          localObject1 = ((StringBuilder)localObject1).append(paramList).append(",contact liveStatus:");
          paramList = paramBaseFinderFeed.feedObject.getRefObjectContact();
          if (paramList != null) {
            break label898;
          }
          paramList = null;
          label507:
          Log.i("FinderFeedVideoRoundCornerConvert", paramList);
          paramList = (TextView)paramj.UH(e.e.finder_nickname);
          localObject3 = (TextView)paramj.UH(e.e.like_count_tv);
          localObject2 = (TextView)paramj.UH(e.e.finder_desc);
          if (localObject2 != null)
          {
            localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
            if (((Number)com.tencent.mm.plugin.finder.storage.d.eYb().bmg()).intValue() != 1) {
              break label911;
            }
            paramInt1 = 2;
            ((TextView)localObject2).setMaxLines(paramInt1);
          }
          localObject1 = paramj.UH(e.e.feed_round_corner_media_item_container);
          if (localObject1 != null)
          {
            paramInt1 = e.e.finder_accessibility_nickname_tag;
            if (paramList != null) {
              break label916;
            }
            paramj = (CharSequence)"";
            ((View)localObject1).setTag(paramInt1, paramj);
            paramInt2 = e.e.finder_accessibility_auth_icon_type_tag;
            paramj = paramBaseFinderFeed.contact;
            if (paramj != null) {
              break label940;
            }
            paramInt1 = 0;
            ((View)localObject1).setTag(paramInt2, Integer.valueOf(paramInt1));
            paramInt1 = e.e.finder_accessibility_like_count_tag;
            if (localObject3 != null) {
              break label962;
            }
            paramj = (CharSequence)"0";
            ((View)localObject1).setTag(paramInt1, paramj);
            paramInt1 = e.e.finder_accessibility_content_desc_tag;
            if (localObject2 != null) {
              break label987;
            }
            paramj = (CharSequence)"";
          }
        }
      }
      for (;;)
      {
        ((View)localObject1).setTag(paramInt1, paramj);
        ((View)localObject1).setTag(e.e.finder_accessibility_media_type_tag, Integer.valueOf(paramBaseFinderFeed.feedObject.getMediaType()));
        AppMethodBeat.o(349839);
        return;
        localObject1 = (dji)kotlin.a.p.oK((List)paramBaseFinderFeed.feedObject.getMediaList());
        break;
        paramInt1 = this.sJv;
        break label105;
        localObject2 = new t((dji)localObject1, v.FKY);
        localObject3 = com.tencent.mm.plugin.finder.loader.p.ExI;
        localObject3 = com.tencent.mm.plugin.finder.loader.p.eCl();
        kotlin.g.b.s.s(paramList, "thumbIv");
        localObject4 = com.tencent.mm.plugin.finder.loader.p.ExI;
        ((com.tencent.mm.loader.d)localObject3).a(localObject2, paramList, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ));
        break label229;
        paramInt1 = 0;
        break label355;
        localObject4 = h.ax(g.class);
        kotlin.g.b.s.s(localObject4, "service(IFinderCommonLiveService::class.java)");
        localObject4 = (g)localObject4;
        kotlin.g.b.s.s(localObject3, "thumbIv");
        g.a.a((g)localObject4, (ImageView)localObject3, paramList);
        ((FinderLiveOnliveWidget)localObject1).setVisibility(0);
        ((View)localObject2).setVisibility(8);
        break label430;
        ((FinderLiveOnliveWidget)localObject1).setVisibility(8);
        ((View)localObject2).setVisibility(8);
        break label430;
        label885:
        paramList = Integer.valueOf(paramList.liveStatus);
        break label475;
        paramList = Integer.valueOf(paramList.liveStatus);
        break label507;
        paramInt1 = 1;
        break label587;
        paramList = paramList.getText();
        paramj = paramList;
        if (paramList != null) {
          break label622;
        }
        paramj = (CharSequence)"";
        break label622;
        paramj = paramj.field_authInfo;
        if (paramj == null)
        {
          paramInt1 = 0;
          break label645;
        }
        paramInt1 = paramj.authIconType;
        break label645;
        paramList = ((TextView)localObject3).getText();
        paramj = paramList;
        if (paramList != null) {
          break label672;
        }
        paramj = (CharSequence)"0";
        break label672;
        paramList = ((TextView)localObject2).getText();
        paramj = paramList;
        if (paramList == null) {
          paramj = (CharSequence)"";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.cz
 * JD-Core Version:    0.7.0.1
 */