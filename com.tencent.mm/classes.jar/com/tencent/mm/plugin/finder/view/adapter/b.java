package com.tencent.mm.plugin.finder.view.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.feed.an;
import com.tencent.mm.plugin.finder.loader.r;
import com.tencent.mm.plugin.finder.loader.t;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FeedData.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.view.FinderFeedAlbumView.a;
import com.tencent.mm.plugin.finder.view.FinderFeedAlbumView.c;
import com.tencent.mm.protocal.protobuf.csg;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/adapter/FinderFeedAlbumAdapter;", "Lcom/tencent/mm/plugin/finder/view/FinderFeedAlbumView$Adapter;", "Lcom/tencent/mm/plugin/finder/view/adapter/FinderFeedAlbumAdapter$AlbumHolder;", "mediaList", "", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "isAliveMode", "", "(Ljava/util/List;Z)V", "onItemClick", "Lcom/tencent/mm/plugin/finder/view/adapter/FinderFeedAlbumAdapter$OnItemClickListener;", "getOnItemClick", "()Lcom/tencent/mm/plugin/finder/view/adapter/FinderFeedAlbumAdapter$OnItemClickListener;", "setOnItemClick", "(Lcom/tencent/mm/plugin/finder/view/adapter/FinderFeedAlbumAdapter$OnItemClickListener;)V", "getCardFeed", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "getFinderVideoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "getItemType", "", "position", "getSize", "onBindView", "", "itemView", "Landroid/view/View;", "holder", "Lcom/tencent/mm/plugin/finder/view/FinderFeedAlbumView$Holder;", "onCreateView", "layoutInflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/widget/FrameLayout;", "AlbumHolder", "Companion", "OnItemClickListener", "plugin-finder_release"})
public class b
  extends FinderFeedAlbumView.a<a>
{
  public static final b Bdo;
  public c Bdm;
  private final boolean Bdn;
  private final List<csg> rUa;
  
  static
  {
    AppMethodBeat.i(278965);
    Bdo = new b((byte)0);
    AppMethodBeat.o(278965);
  }
  
  public b(List<? extends csg> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(278964);
    this.rUa = paramList;
    this.Bdn = paramBoolean;
    AppMethodBeat.o(278964);
  }
  
  public final int RC(int paramInt)
  {
    AppMethodBeat.i(278962);
    if (paramInt == 0)
    {
      paramInt = ((csg)this.rUa.get(paramInt)).mediaType;
      AppMethodBeat.o(278962);
      return paramInt;
    }
    AppMethodBeat.o(278962);
    return 2;
  }
  
  public final void a(final View paramView, final int paramInt, FinderFeedAlbumView.c paramc)
  {
    AppMethodBeat.i(278960);
    p.k(paramView, "itemView");
    p.k(paramc, "holder");
    csg localcsg = (csg)this.rUa.get(paramInt);
    int i = RC(paramInt);
    Object localObject1;
    Object localObject2;
    if ((paramInt == 0) && (i == 4) && (this.Bdn))
    {
      localObject1 = paramView.findViewById(b.f.finder_banner_video_layout);
      paramc = (FinderFeedAlbumView.c)localObject1;
      if (!(localObject1 instanceof FinderVideoLayout)) {
        paramc = null;
      }
      paramc = (FinderVideoLayout)paramc;
      localObject1 = dpL();
      if (localObject1 != null)
      {
        localObject1 = ((an)localObject1).rvFeedList;
        if (localObject1 != null)
        {
          localObject1 = (BaseFinderFeed)((LinkedList)localObject1).getFirst();
          if (localObject1 != null)
          {
            localObject1 = ((BaseFinderFeed)localObject1).feedObject;
            if (localObject1 != null)
            {
              localObject2 = dpM();
              if (localObject2 != null)
              {
                if (paramc != null) {
                  paramc.setVideoCore((com.tencent.mm.plugin.finder.video.l)localObject2);
                }
                if (paramc != null)
                {
                  localObject2 = FeedData.Companion;
                  FinderVideoLayout.a(paramc, paramInt, FeedData.a.j((FinderItem)localObject1), 0, false, false, 220);
                }
                if (paramc != null) {
                  paramc.setMute(true);
                }
                if (paramc != null) {
                  paramc.setEnableShowLoading(false);
                }
              }
            }
          }
        }
      }
      paramc = (CharSequence)localcsg.thumbUrl;
      if ((paramc != null) && (paramc.length() != 0)) {
        break label398;
      }
      i = 1;
    }
    for (;;)
    {
      if (i == 0)
      {
        paramc = this.Bdm;
        if (paramc != null)
        {
          paramView.setOnClickListener((View.OnClickListener)new d(paramc, paramView, paramInt));
          AppMethodBeat.o(278960);
          return;
          paramc = (ImageView)paramView;
          localObject1 = (CharSequence)localcsg.thumbUrl;
          if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label345;
            }
            localObject1 = paramc.getContext();
            p.j(localObject1, "thumbIv.context");
            paramc.setImageDrawable((Drawable)new ColorDrawable(((Context)localObject1).getResources().getColor(com.tencent.mm.plugin.finder.b.c.BW_93)));
            break;
          }
          label345:
          localObject1 = t.ztT;
          localObject1 = t.dJe();
          localObject2 = new r(localcsg, u.Alz, null, null, 12);
          t localt = t.ztT;
          ((d)localObject1).a(localObject2, t.a(t.a.ztU)).c(paramc);
          break;
          label398:
          i = 0;
          continue;
        }
        AppMethodBeat.o(278960);
        return;
      }
    }
    paramView.setOnClickListener(null);
    AppMethodBeat.o(278960);
  }
  
  public an dpL()
  {
    return null;
  }
  
  public com.tencent.mm.plugin.finder.video.l dpM()
  {
    return null;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(278961);
    int i = this.rUa.size();
    AppMethodBeat.o(278961);
    return i;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/adapter/FinderFeedAlbumAdapter$AlbumHolder;", "Lcom/tencent/mm/plugin/finder/view/FinderFeedAlbumView$Holder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "plugin-finder_release"})
  public static final class a
    extends FinderFeedAlbumView.c
  {
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(291607);
      AppMethodBeat.o(291607);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/adapter/FinderFeedAlbumAdapter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class b {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/adapter/FinderFeedAlbumAdapter$OnItemClickListener;", "", "onClick", "", "position", "", "view", "Landroid/view/View;", "plugin-finder_release"})
  public static abstract interface c
  {
    public abstract void f(int paramInt, View paramView);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/view/adapter/FinderFeedAlbumAdapter$onBindView$2$1"})
  static final class d
    implements View.OnClickListener
  {
    d(b.c paramc, View paramView, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(286421);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      a.c("com/tencent/mm/plugin/finder/view/adapter/FinderFeedAlbumAdapter$onBindView$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      localObject = this.Bdp;
      int i = paramInt;
      p.j(paramView, "it");
      ((b.c)localObject).f(i, paramView);
      a.a(this, "com/tencent/mm/plugin/finder/view/adapter/FinderFeedAlbumAdapter$onBindView$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(286421);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.adapter.b
 * JD-Core Version:    0.7.0.1
 */