package com.tencent.mm.plugin.finder.view.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.feed.au;
import com.tencent.mm.plugin.finder.loader.n;
import com.tencent.mm.plugin.finder.loader.p;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FeedData.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.l;
import com.tencent.mm.plugin.finder.view.FinderFeedAlbumView.a;
import com.tencent.mm.plugin.finder.view.FinderFeedAlbumView.c;
import com.tencent.mm.protocal.protobuf.dji;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/adapter/FinderFeedAlbumAdapter;", "Lcom/tencent/mm/plugin/finder/view/FinderFeedAlbumView$Adapter;", "Lcom/tencent/mm/plugin/finder/view/adapter/FinderFeedAlbumAdapter$AlbumHolder;", "mediaList", "", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "isAliveMode", "", "(Ljava/util/List;Z)V", "onItemClick", "Lcom/tencent/mm/plugin/finder/view/adapter/FinderFeedAlbumAdapter$OnItemClickListener;", "getOnItemClick", "()Lcom/tencent/mm/plugin/finder/view/adapter/FinderFeedAlbumAdapter$OnItemClickListener;", "setOnItemClick", "(Lcom/tencent/mm/plugin/finder/view/adapter/FinderFeedAlbumAdapter$OnItemClickListener;)V", "getCardFeed", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "getFinderVideoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "getItemType", "", "position", "getSize", "onBindView", "", "itemView", "Landroid/view/View;", "holder", "Lcom/tencent/mm/plugin/finder/view/FinderFeedAlbumView$Holder;", "onCreateView", "layoutInflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/widget/FrameLayout;", "AlbumHolder", "Companion", "OnItemClickListener", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public class b
  extends FinderFeedAlbumView.a<a>
{
  public static final b GFZ;
  private final boolean GGa;
  public c GGb;
  private final List<dji> nZr;
  
  static
  {
    AppMethodBeat.i(345466);
    GFZ = new b((byte)0);
    AppMethodBeat.o(345466);
  }
  
  public b(List<? extends dji> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(345455);
    this.nZr = paramList;
    this.GGa = paramBoolean;
    AppMethodBeat.o(345455);
  }
  
  private static final void a(c paramc, int paramInt, View paramView)
  {
    AppMethodBeat.i(345460);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramc);
    localb.sc(paramInt);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/view/adapter/FinderFeedAlbumAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramc, "$listener");
    s.s(paramView, "it");
    paramc.h(paramInt, paramView);
    a.a(new Object(), "com/tencent/mm/plugin/finder/view/adapter/FinderFeedAlbumAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(345460);
  }
  
  public final int UG(int paramInt)
  {
    AppMethodBeat.i(345506);
    if (paramInt == 0)
    {
      paramInt = ((dji)this.nZr.get(paramInt)).mediaType;
      AppMethodBeat.o(345506);
      return paramInt;
    }
    AppMethodBeat.o(345506);
    return 2;
  }
  
  public final void a(View paramView, int paramInt, FinderFeedAlbumView.c paramc)
  {
    AppMethodBeat.i(345492);
    s.u(paramView, "itemView");
    s.u(paramc, "holder");
    dji localdji = (dji)this.nZr.get(paramInt);
    int i = UG(paramInt);
    Object localObject1;
    Object localObject2;
    if ((paramInt == 0) && (i == 4) && (this.GGa))
    {
      paramc = paramView.findViewById(e.e.finder_banner_video_layout);
      if ((paramc instanceof FinderVideoLayout))
      {
        paramc = (FinderVideoLayout)paramc;
        localObject1 = dYd();
        if (localObject1 != null)
        {
          localObject1 = ((au)localObject1).rvFeedList;
          if (localObject1 != null)
          {
            localObject1 = (BaseFinderFeed)((LinkedList)localObject1).getFirst();
            if (localObject1 != null)
            {
              localObject1 = ((BaseFinderFeed)localObject1).feedObject;
              if (localObject1 != null)
              {
                localObject2 = dYe();
                if (localObject2 != null)
                {
                  if (paramc != null) {
                    paramc.setVideoCore((l)localObject2);
                  }
                  if (paramc != null)
                  {
                    localObject2 = FeedData.Companion;
                    FinderVideoLayout.a(paramc, paramInt, FeedData.a.n((FinderItem)localObject1), 0, false, false, 220);
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
        label190:
        paramc = (CharSequence)localdji.thumbUrl;
        if ((paramc != null) && (paramc.length() != 0)) {
          break label380;
        }
      }
    }
    label327:
    label380:
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        break label386;
      }
      paramc = this.GGb;
      if (paramc == null) {
        break label391;
      }
      paramView.setOnClickListener(new b..ExternalSyntheticLambda0(paramc, paramInt));
      AppMethodBeat.o(345492);
      return;
      paramc = null;
      break;
      paramc = (ImageView)paramView;
      localObject1 = (CharSequence)localdji.thumbUrl;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label327;
        }
        paramc.setImageDrawable((Drawable)new ColorDrawable(paramc.getContext().getResources().getColor(e.b.BW_93)));
        break;
      }
      localObject1 = p.ExI;
      localObject1 = p.eCl();
      localObject2 = new n(localdji, v.FKZ, null, null, 12);
      p localp = p.ExI;
      ((d)localObject1).a(localObject2, p.a(p.a.ExJ)).d(paramc);
      break label190;
    }
    label386:
    paramView.setOnClickListener(null);
    label391:
    AppMethodBeat.o(345492);
  }
  
  public au dYd()
  {
    return null;
  }
  
  public l dYe()
  {
    return null;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(345499);
    int i = this.nZr.size();
    AppMethodBeat.o(345499);
    return i;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/adapter/FinderFeedAlbumAdapter$AlbumHolder;", "Lcom/tencent/mm/plugin/finder/view/FinderFeedAlbumView$Holder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends FinderFeedAlbumView.c
  {
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(345456);
      AppMethodBeat.o(345456);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/adapter/FinderFeedAlbumAdapter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/adapter/FinderFeedAlbumAdapter$OnItemClickListener;", "", "onClick", "", "position", "", "view", "Landroid/view/View;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface c
  {
    public abstract void h(int paramInt, View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.adapter.b
 * JD-Core Version:    0.7.0.1
 */