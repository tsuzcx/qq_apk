package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.loader.n;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.j;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderProfileAtGridConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedRoundCornerConvert;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "username", "", "isSelfFlag", "", "atFeedState", "Lcom/tencent/mm/plugin/finder/viewmodel/atfeed/AtFeedState;", "(Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;Ljava/lang/String;ZLcom/tencent/mm/plugin/finder/viewmodel/atfeed/AtFeedState;)V", "jumpAtTimeline", "", "context", "Landroid/content/Context;", "pos", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "setSelectImage", "isSelect", "selectImage", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "container", "Landroid/view/View;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bz
  extends ac
{
  public static final a ALG;
  private final BaseFinderFeedLoader ALH;
  private final boolean ALI;
  private final com.tencent.mm.plugin.finder.viewmodel.atfeed.a ALJ;
  private final String username;
  
  static
  {
    AppMethodBeat.i(349820);
    ALG = new a((byte)0);
    AppMethodBeat.o(349820);
  }
  
  public bz(BaseFinderFeedLoader paramBaseFinderFeedLoader, String paramString, boolean paramBoolean, com.tencent.mm.plugin.finder.viewmodel.atfeed.a parama)
  {
    super(e.f.finder_grid_at_feed_manage_item);
    AppMethodBeat.i(349773);
    this.ALH = paramBaseFinderFeedLoader;
    this.username = paramString;
    this.ALI = paramBoolean;
    this.ALJ = parama;
    AppMethodBeat.o(349773);
  }
  
  private static final void a(bz parambz, j paramj, BaseFinderFeed paramBaseFinderFeed, View paramView)
  {
    AppMethodBeat.i(349812);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parambz);
    localb.cH(paramj);
    localb.cH(paramBaseFinderFeed);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderProfileAtGridConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parambz, "this$0");
    s.u(paramj, "$holder");
    s.u(paramBaseFinderFeed, "$item");
    paramj = paramj.context;
    s.s(paramj, "holder.context");
    paramView = parambz.ALH;
    int i;
    if (paramView == null) {
      i = 0;
    }
    for (;;)
    {
      paramView = new Intent();
      localObject = parambz.ALH;
      if (localObject != null) {
        BaseFeedLoader.saveCache$default((BaseFeedLoader)localObject, paramView, i, null, 4, null);
      }
      paramView.putExtra("KEY_FROM_SCENE", 1);
      paramView.putExtra("KEY_USERNAME", parambz.username);
      paramView.putExtra("KEY_FINDER_SELF_FLAG", parambz.ALI);
      paramView.putExtra("KEY_TITLE", paramj.getResources().getString(e.h.finder_be_at_timeline_title));
      paramView.putExtra("force_show_ad_tip", true);
      paramView.putExtra("key_from_page", g.Bkt.value);
      parambz = as.GSQ;
      as.a.a(paramj, paramView, 0L, 0, false, 124);
      parambz = com.tencent.mm.plugin.finder.utils.a.GfO;
      com.tencent.mm.plugin.finder.utils.a.ar(paramj, paramView);
      parambz = z.FrZ;
      z.ab(paramBaseFinderFeed.bZA(), 1);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderProfileAtGridConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(349812);
      return;
      paramView = paramView.getDataListJustForAdapter();
      if (paramView == null) {
        i = 0;
      } else {
        i = paramView.indexOf(paramBaseFinderFeed);
      }
    }
  }
  
  private static final void a(BaseFinderFeed paramBaseFinderFeed, bz parambz, WeImageView paramWeImageView, View paramView1, View paramView2)
  {
    AppMethodBeat.i(349796);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramBaseFinderFeed);
    localb.cH(parambz);
    localb.cH(paramWeImageView);
    localb.cH(paramView1);
    localb.cH(paramView2);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderProfileAtGridConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramBaseFinderFeed, "$item");
    s.u(parambz, "this$0");
    if (paramBaseFinderFeed.feedObject.getMentionListSelected() == 3)
    {
      a(true, paramWeImageView, paramView1);
      paramBaseFinderFeed.feedObject.setMentionListSelected(2);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderProfileAtGridConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(349796);
      return;
      a(false, paramWeImageView, paramView1);
      paramBaseFinderFeed.feedObject.setMentionListSelected(3);
    }
  }
  
  private static void a(boolean paramBoolean, WeImageView paramWeImageView, View paramView)
  {
    AppMethodBeat.i(349783);
    if (paramWeImageView != null) {
      if (paramBoolean)
      {
        paramWeImageView.setImageResource(e.g.icons_outlined_done);
        if (paramView != null)
        {
          paramView.setBackgroundResource(e.d.finder_at_feed_item_select_bg);
          AppMethodBeat.o(349783);
        }
      }
      else
      {
        paramWeImageView.setImageDrawable(null);
        if (paramView != null) {
          paramView.setBackgroundResource(e.d.finder_at_feed_item_un_select_bg);
        }
      }
    }
    AppMethodBeat.o(349783);
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(349844);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(349844);
  }
  
  public final void a(j paramj, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(349866);
    s.u(paramj, "holder");
    s.u(paramBaseFinderFeed, "item");
    Object localObject1 = paramj.caK.findViewById(e.e.finder_grid_at_manage_select_container);
    Object localObject2 = (WeImageView)paramj.caK.findViewById(e.e.finder_grid_at_manage_select_iv);
    Object localObject3 = paramj.caK.findViewById(e.e.finder_grid_at_manage_select_iv_container);
    View localView = paramj.caK.findViewById(e.e.if_item_image);
    Log.i("Finder.ProfileAtGridConvert", s.X("onBindViewHolder  ", Integer.valueOf(paramBaseFinderFeed.feedObject.getMentionListSelected())));
    Object localObject4 = (Collection)paramList;
    if ((localObject4 == null) || (((Collection)localObject4).isEmpty())) {
      paramInt1 = 1;
    }
    while (paramInt1 == 0)
    {
      paramList = ((Iterable)paramList).iterator();
      for (;;)
      {
        if (paramList.hasNext())
        {
          localObject4 = paramList.next();
          if (((localObject4 instanceof r)) && (((Number)((r)localObject4).bsC).intValue() == 23))
          {
            if (!this.ALJ.GLR)
            {
              if (paramBaseFinderFeed.feedObject.getMentionListSelected() == 2)
              {
                if (localView == null) {
                  break label235;
                }
                localView.setVisibility(0);
                AppMethodBeat.o(349866);
                return;
                paramInt1 = 0;
                break;
              }
              if (localView != null) {
                localView.setVisibility(8);
              }
            }
            label235:
            AppMethodBeat.o(349866);
            return;
          }
        }
      }
    }
    if (this.ALJ.GLR) {
      if (localObject1 != null)
      {
        ((View)localObject1).setOnClickListener(new bz..ExternalSyntheticLambda1(paramBaseFinderFeed, this, (WeImageView)localObject2, (View)localObject3));
        if (localObject3 != null) {
          ((View)localObject3).setVisibility(0);
        }
        if (paramBaseFinderFeed.feedObject.getMentionListSelected() == 2)
        {
          paramBoolean = true;
          a(paramBoolean, (WeImageView)localObject2, (View)localObject3);
        }
      }
      else
      {
        if (localView != null) {
          localView.setVisibility(8);
        }
        label321:
        localObject2 = (dji)kotlin.a.p.oK((List)paramBaseFinderFeed.feedObject.getMediaList());
        paramList = (ImageView)paramj.UH(e.e.finder_grid_at_manage_iv);
        if (((dji)localObject2).mediaType != 4) {
          break label563;
        }
        localObject1 = new n((dji)localObject2, v.FKZ, null, null, 12);
        localObject2 = com.tencent.mm.plugin.finder.loader.p.ExI;
        localObject2 = com.tencent.mm.plugin.finder.loader.p.eCl();
        s.s(paramList, "imageView");
        localObject3 = com.tencent.mm.plugin.finder.loader.p.ExI;
        ((d)localObject2).a(localObject1, paramList, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ));
        label416:
        localObject1 = paramj.UH(e.e.finder_grid_at_manage_select_container);
        if (localObject1 != null)
        {
          paramInt1 = e.e.finder_accessibility_nickname_tag;
          paramj = paramBaseFinderFeed.feedObject;
          if (paramj != null) {
            break label622;
          }
          paramj = "";
          label447:
          ((View)localObject1).setTag(paramInt1, paramj);
          paramInt1 = e.e.finder_accessibility_content_desc_tag;
          paramj = paramBaseFinderFeed.feedObject;
          if (paramj != null) {
            break label643;
          }
          paramj = "";
        }
      }
    }
    for (;;)
    {
      ((View)localObject1).setTag(paramInt1, paramj);
      AppMethodBeat.o(349866);
      return;
      paramBoolean = false;
      break;
      if (localObject3 != null) {
        ((View)localObject3).setVisibility(8);
      }
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener(new bz..ExternalSyntheticLambda0(this, paramj, paramBaseFinderFeed));
      }
      if (paramBaseFinderFeed.feedObject.getMentionListSelected() == 2)
      {
        if (localView == null) {
          break label321;
        }
        localView.setVisibility(0);
        break label321;
      }
      if (localView == null) {
        break label321;
      }
      localView.setVisibility(8);
      break label321;
      label563:
      localObject1 = com.tencent.mm.plugin.finder.loader.p.ExI;
      localObject1 = com.tencent.mm.plugin.finder.loader.p.eCl();
      localObject2 = new n((dji)localObject2, v.FKZ, null, null, 12);
      s.s(paramList, "imageView");
      localObject3 = com.tencent.mm.plugin.finder.loader.p.ExI;
      ((d)localObject1).a(localObject2, paramList, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ));
      break label416;
      label622:
      paramList = paramj.getNickName();
      paramj = paramList;
      if (paramList != null) {
        break label447;
      }
      paramj = "";
      break label447;
      label643:
      paramBaseFinderFeed = paramj.getDescription();
      paramj = paramBaseFinderFeed;
      if (paramBaseFinderFeed == null) {
        paramj = "";
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderProfileAtGridConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.bz
 * JD-Core Version:    0.7.0.1
 */