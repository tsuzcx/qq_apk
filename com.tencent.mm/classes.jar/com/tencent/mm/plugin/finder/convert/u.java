package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.loader.n;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.findersdk.storage.config.base.b;
import com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.dji;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedImageRoundCornerConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedRoundCornerConvert;", "()V", "screenWidth", "", "getScreenWidth", "()I", "screenWidth$delegate", "Lkotlin/Lazy;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public class u
  extends ac
{
  private final kotlin.j AJO;
  
  public u()
  {
    super(e.f.finder_feed_round_corner_media_item);
    AppMethodBeat.i(350527);
    this.AJO = k.cm((a)a.AJP);
    AppMethodBeat.o(350527);
  }
  
  public void a(com.tencent.mm.view.recyclerview.j paramj, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(165396);
    s.u(paramj, "holder");
    s.u(paramBaseFinderFeed, "item");
    super.a(paramj, paramBaseFinderFeed, paramInt1, paramInt2, paramBoolean, paramList);
    Object localObject1 = (dji)kotlin.a.p.oK((List)paramBaseFinderFeed.feedObject.getMediaList());
    paramList = (ImageView)paramj.UH(e.e.thumb_iv);
    Object localObject2 = paramList.getLayoutParams();
    paramInt1 = (((Number)this.AJO.getValue()).intValue() - (int)paramj.context.getResources().getDimension(e.c.Edge_1_5_A)) / 2;
    Object localObject3 = av.GiL;
    paramInt2 = av.a(paramBaseFinderFeed, (dji)localObject1, paramInt1);
    if (paramInt2 > 0)
    {
      ((ViewGroup.LayoutParams)localObject2).width = paramInt1;
      ((ViewGroup.LayoutParams)localObject2).height = paramInt2;
      paramList.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
    localObject2 = com.tencent.mm.plugin.finder.loader.p.ExI;
    localObject2 = com.tencent.mm.plugin.finder.loader.p.eCl();
    localObject1 = new n((dji)localObject1, v.FKZ, null, null, 12);
    s.s(paramList, "thumbIv");
    localObject3 = com.tencent.mm.plugin.finder.loader.p.ExI;
    ((com.tencent.mm.loader.d)localObject2).a(localObject1, paramList, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ));
    paramList = (ImageIndicatorView)paramj.UH(e.e.image_indicator);
    if (paramList != null) {
      paramList.setVisibility(0);
    }
    if (paramList != null) {
      paramList.RVj = paramBaseFinderFeed.feedObject.getMediaList().size();
    }
    i(paramj, paramBaseFinderFeed);
    if ((dXH()) && (paramList != null)) {
      paramList.setBackgroundColor(paramj.context.getResources().getColor(e.b.finder_activity_item_covered_background));
    }
    paramList = (TextView)paramj.UH(e.e.finder_nickname);
    localObject3 = (TextView)paramj.UH(e.e.like_count_tv);
    localObject2 = (TextView)paramj.UH(e.e.finder_desc);
    if (localObject2 != null)
    {
      localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eYb().bmg()).intValue() == 1)
      {
        paramInt1 = 2;
        ((TextView)localObject2).setMaxLines(paramInt1);
      }
    }
    else
    {
      localObject1 = paramj.UH(e.e.feed_round_corner_media_item_container);
      if (localObject1 != null)
      {
        paramInt1 = e.e.finder_accessibility_nickname_tag;
        if (paramList != null) {
          break label481;
        }
        paramj = (CharSequence)"";
        label372:
        ((View)localObject1).setTag(paramInt1, paramj);
        paramInt2 = e.e.finder_accessibility_auth_icon_type_tag;
        paramj = paramBaseFinderFeed.contact;
        if (paramj != null) {
          break label506;
        }
        paramInt1 = 0;
        label395:
        ((View)localObject1).setTag(paramInt2, Integer.valueOf(paramInt1));
        paramInt1 = e.e.finder_accessibility_like_count_tag;
        if (localObject3 != null) {
          break label528;
        }
        paramj = (CharSequence)"0";
        label422:
        ((View)localObject1).setTag(paramInt1, paramj);
        paramInt1 = e.e.finder_accessibility_content_desc_tag;
        if (localObject2 != null) {
          break label553;
        }
        paramj = (CharSequence)"";
      }
    }
    for (;;)
    {
      ((View)localObject1).setTag(paramInt1, paramj);
      ((View)localObject1).setTag(e.e.finder_accessibility_media_type_tag, Integer.valueOf(paramBaseFinderFeed.feedObject.getMediaType()));
      AppMethodBeat.o(165396);
      return;
      paramInt1 = 1;
      break;
      label481:
      paramList = paramList.getText();
      paramj = paramList;
      if (paramList != null) {
        break label372;
      }
      paramj = (CharSequence)"";
      break label372;
      label506:
      paramj = paramj.field_authInfo;
      if (paramj == null)
      {
        paramInt1 = 0;
        break label395;
      }
      paramInt1 = paramj.authIconType;
      break label395;
      label528:
      paramList = ((TextView)localObject3).getText();
      paramj = paramList;
      if (paramList != null) {
        break label422;
      }
      paramj = (CharSequence)"0";
      break label422;
      label553:
      paramList = ((TextView)localObject2).getText();
      paramj = paramList;
      if (paramList == null) {
        paramj = (CharSequence)"";
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements a<Integer>
  {
    public static final a AJP;
    
    static
    {
      AppMethodBeat.i(349564);
      AJP = new a();
      AppMethodBeat.o(349564);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.u
 * JD-Core Version:    0.7.0.1
 */