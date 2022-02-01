package com.tencent.mm.plugin.finder.convert;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.loader.r;
import com.tencent.mm.plugin.finder.loader.t;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.i;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderProfileAtGridConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedRoundCornerConvert;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "username", "", "isSelfFlag", "", "atFeedState", "Lcom/tencent/mm/plugin/finder/viewmodel/atfeed/AtFeedState;", "(Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;Ljava/lang/String;ZLcom/tencent/mm/plugin/finder/viewmodel/atfeed/AtFeedState;)V", "jumpAtTimeline", "", "context", "Landroid/content/Context;", "pos", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "setSelectImage", "isSelect", "selectImage", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "container", "Landroid/view/View;", "Companion", "plugin-finder_release"})
public final class cb
  extends ag
{
  public static final a xoa;
  private final String username;
  private final BaseFinderFeedLoader xnX;
  private final boolean xnY;
  private final com.tencent.mm.plugin.finder.viewmodel.atfeed.a xnZ;
  
  static
  {
    AppMethodBeat.i(267552);
    xoa = new a((byte)0);
    AppMethodBeat.o(267552);
  }
  
  public cb(BaseFinderFeedLoader paramBaseFinderFeedLoader, String paramString, boolean paramBoolean, com.tencent.mm.plugin.finder.viewmodel.atfeed.a parama)
  {
    super(b.g.finder_grid_at_feed_manage_item);
    AppMethodBeat.i(267551);
    this.xnX = paramBaseFinderFeedLoader;
    this.username = paramString;
    this.xnY = paramBoolean;
    this.xnZ = parama;
    AppMethodBeat.o(267551);
  }
  
  @SuppressLint({"ResourceType"})
  private static void a(boolean paramBoolean, WeImageView paramWeImageView, View paramView)
  {
    AppMethodBeat.i(267549);
    if (paramWeImageView != null)
    {
      if (paramBoolean)
      {
        paramWeImageView.setImageResource(b.i.icons_outlined_done);
        if (paramView != null)
        {
          paramView.setBackgroundResource(b.e.finder_at_feed_item_select_bg);
          AppMethodBeat.o(267549);
          return;
        }
        AppMethodBeat.o(267549);
        return;
      }
      paramWeImageView.setImageDrawable(null);
      if (paramView != null)
      {
        paramView.setBackgroundResource(b.e.finder_at_feed_item_un_select_bg);
        AppMethodBeat.o(267549);
        return;
      }
      AppMethodBeat.o(267549);
      return;
    }
    AppMethodBeat.o(267549);
  }
  
  public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
  {
    AppMethodBeat.i(267544);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    AppMethodBeat.o(267544);
  }
  
  @SuppressLint({"ResourceType"})
  public final void a(final i parami, final BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(267547);
    p.k(parami, "holder");
    p.k(paramBaseFinderFeed, "item");
    Object localObject1 = parami.amk.findViewById(b.f.finder_grid_at_manage_select_container);
    final WeImageView localWeImageView = (WeImageView)parami.amk.findViewById(b.f.finder_grid_at_manage_select_iv);
    final View localView1 = parami.amk.findViewById(b.f.finder_grid_at_manage_select_iv_container);
    View localView2 = parami.amk.findViewById(b.f.if_item_image);
    Log.i("Finder.ProfileAtGridConvert", "onBindViewHolder  " + paramBaseFinderFeed.feedObject.getMentionListSelected());
    Object localObject2 = (Collection)paramList;
    if ((localObject2 == null) || (((Collection)localObject2).isEmpty())) {
      paramInt1 = 1;
    }
    label121:
    while (paramInt1 == 0)
    {
      paramList = ((Iterable)paramList).iterator();
      for (;;)
      {
        if (paramList.hasNext())
        {
          localObject2 = paramList.next();
          if ((localObject2 instanceof o)) {
            switch (((Number)((o)localObject2).Mx).intValue())
            {
            default: 
              break;
            case 23: 
              if (!this.xnZ.BhC)
              {
                if (paramBaseFinderFeed.feedObject.getMentionListSelected() == 2)
                {
                  if (localView2 != null)
                  {
                    localView2.setVisibility(0);
                    AppMethodBeat.o(267547);
                    return;
                    paramInt1 = 0;
                    break label121;
                  }
                  AppMethodBeat.o(267547);
                  return;
                }
                if (localView2 != null)
                {
                  localView2.setVisibility(8);
                  AppMethodBeat.o(267547);
                  return;
                }
              }
              AppMethodBeat.o(267547);
              return;
            }
          }
        }
      }
    }
    if (this.xnZ.BhC) {
      if (localObject1 != null)
      {
        ((View)localObject1).setOnClickListener((View.OnClickListener)new b(this, paramBaseFinderFeed, localWeImageView, localView1));
        if (localView1 != null) {
          localView1.setVisibility(0);
        }
        if (paramBaseFinderFeed.feedObject.getMentionListSelected() == 2)
        {
          paramBoolean = true;
          a(paramBoolean, localWeImageView, localView1);
        }
      }
      else if (localView2 != null)
      {
        localView2.setVisibility(8);
      }
    }
    for (;;)
    {
      paramBaseFinderFeed = (csg)j.lo((List)paramBaseFinderFeed.feedObject.getMediaList());
      parami = (ImageView)parami.RD(b.f.finder_grid_at_manage_iv);
      if (paramBaseFinderFeed.mediaType != 4) {
        break label528;
      }
      paramBaseFinderFeed = new r(paramBaseFinderFeed, u.Alz, null, null, 12);
      paramList = t.ztT;
      paramList = t.dJe();
      p.j(parami, "imageView");
      localObject1 = t.ztT;
      paramList.a(paramBaseFinderFeed, parami, t.a(t.a.ztU));
      AppMethodBeat.o(267547);
      return;
      paramBoolean = false;
      break;
      if (localView1 != null) {
        localView1.setVisibility(8);
      }
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener((View.OnClickListener)new c(this, parami, paramBaseFinderFeed));
      }
      if (paramBaseFinderFeed.feedObject.getMentionListSelected() == 2)
      {
        if (localView2 != null) {
          localView2.setVisibility(0);
        }
      }
      else if (localView2 != null) {
        localView2.setVisibility(8);
      }
    }
    label528:
    paramList = t.ztT;
    paramList = t.dJe();
    paramBaseFinderFeed = new r(paramBaseFinderFeed, u.Alz, null, null, 12);
    p.j(parami, "imageView");
    localObject1 = t.ztT;
    paramList.a(paramBaseFinderFeed, parami, t.a(t.a.ztU));
    AppMethodBeat.o(267547);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderProfileAtGridConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderProfileAtGridConvert$onBindViewHolder$2$1"})
  static final class b
    implements View.OnClickListener
  {
    b(cb paramcb, BaseFinderFeed paramBaseFinderFeed, WeImageView paramWeImageView, View paramView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(289612);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderProfileAtGridConvert$onBindViewHolder$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      if (paramBaseFinderFeed.feedObject.getMentionListSelected() == 3)
      {
        cb.b(true, localWeImageView, localView1);
        paramBaseFinderFeed.feedObject.setMentionListSelected(2);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderProfileAtGridConvert$onBindViewHolder$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(289612);
        return;
        cb.b(false, localWeImageView, localView1);
        paramBaseFinderFeed.feedObject.setMentionListSelected(3);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderProfileAtGridConvert$onBindViewHolder$3$1"})
  static final class c
    implements View.OnClickListener
  {
    c(cb paramcb, i parami, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(287269);
      Object localObject1 = new b();
      ((b)localObject1).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderProfileAtGridConvert$onBindViewHolder$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).aFi());
      paramView = this.xob;
      localObject1 = parami.getContext();
      p.j(localObject1, "holder.context");
      Object localObject2 = cb.a(this.xob);
      if (localObject2 != null)
      {
        localObject2 = ((BaseFinderFeedLoader)localObject2).getDataListJustForAdapter();
        if (localObject2 == null) {}
      }
      for (int i = ((DataBuffer)localObject2).indexOf(paramBaseFinderFeed);; i = 0)
      {
        cb.a(paramView, (Context)localObject1, i, paramBaseFinderFeed);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderProfileAtGridConvert$onBindViewHolder$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(287269);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.cb
 * JD-Core Version:    0.7.0.1
 */