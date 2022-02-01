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
import com.tencent.mm.plugin.finder.feed.ag;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FeedData.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.view.FinderFeedAlbumView.a;
import com.tencent.mm.plugin.finder.view.FinderFeedAlbumView.c;
import com.tencent.mm.protocal.protobuf.cjl;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/adapter/FinderFeedAlbumAdapter;", "Lcom/tencent/mm/plugin/finder/view/FinderFeedAlbumView$Adapter;", "Lcom/tencent/mm/plugin/finder/view/adapter/FinderFeedAlbumAdapter$AlbumHolder;", "mediaList", "", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "isAliveMode", "", "(Ljava/util/List;Z)V", "onItemClick", "Lcom/tencent/mm/plugin/finder/view/adapter/FinderFeedAlbumAdapter$OnItemClickListener;", "getOnItemClick", "()Lcom/tencent/mm/plugin/finder/view/adapter/FinderFeedAlbumAdapter$OnItemClickListener;", "setOnItemClick", "(Lcom/tencent/mm/plugin/finder/view/adapter/FinderFeedAlbumAdapter$OnItemClickListener;)V", "getCardFeed", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "getFinderVideoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "getItemType", "", "position", "getSize", "onBindView", "", "itemView", "Landroid/view/View;", "holder", "Lcom/tencent/mm/plugin/finder/view/FinderFeedAlbumView$Holder;", "onCreateView", "layoutInflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/widget/FrameLayout;", "AlbumHolder", "Companion", "OnItemClickListener", "plugin-finder_release"})
public class b
  extends FinderFeedAlbumView.a<a>
{
  public static final b wrj;
  private final List<cjl> oSb;
  public c wrh;
  private final boolean wri;
  
  static
  {
    AppMethodBeat.i(255151);
    wrj = new b((byte)0);
    AppMethodBeat.o(255151);
  }
  
  public b(List<? extends cjl> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(255150);
    this.oSb = paramList;
    this.wri = paramBoolean;
    AppMethodBeat.o(255150);
  }
  
  public final int Mm(int paramInt)
  {
    AppMethodBeat.i(255149);
    if (paramInt == 0)
    {
      paramInt = ((cjl)this.oSb.get(paramInt)).mediaType;
      AppMethodBeat.o(255149);
      return paramInt;
    }
    AppMethodBeat.o(255149);
    return 2;
  }
  
  public final void a(final View paramView, final int paramInt, FinderFeedAlbumView.c paramc)
  {
    AppMethodBeat.i(255147);
    p.h(paramView, "itemView");
    p.h(paramc, "holder");
    cjl localcjl = (cjl)this.oSb.get(paramInt);
    int i = Mm(paramInt);
    Object localObject1;
    Object localObject2;
    if ((paramInt == 0) && (i == 4) && (this.wri))
    {
      localObject1 = paramView.findViewById(2131300776);
      paramc = (FinderFeedAlbumView.c)localObject1;
      if (!(localObject1 instanceof FinderVideoLayout)) {
        paramc = null;
      }
      paramc = (FinderVideoLayout)paramc;
      localObject1 = cZO();
      if (localObject1 != null)
      {
        localObject1 = ((ag)localObject1).rvFeedList;
        if (localObject1 != null)
        {
          localObject1 = (BaseFinderFeed)((LinkedList)localObject1).getFirst();
          if (localObject1 != null)
          {
            localObject1 = ((BaseFinderFeed)localObject1).feedObject;
            if (localObject1 != null)
            {
              localObject2 = cZP();
              if (localObject2 != null)
              {
                if (paramc != null) {
                  paramc.setVideoCore((com.tencent.mm.plugin.finder.video.k)localObject2);
                }
                if (paramc != null)
                {
                  localObject2 = FeedData.Companion;
                  FinderVideoLayout.a(paramc, paramInt, FeedData.a.i((FinderItem)localObject1), 0, false, false, 220);
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
      paramc = (CharSequence)localcjl.thumbUrl;
      if ((paramc != null) && (paramc.length() != 0)) {
        break label397;
      }
      i = 1;
    }
    for (;;)
    {
      if (i == 0)
      {
        paramc = this.wrh;
        if (paramc != null)
        {
          paramView.setOnClickListener((View.OnClickListener)new d(paramc, paramView, paramInt));
          AppMethodBeat.o(255147);
          return;
          paramc = (ImageView)paramView;
          localObject1 = (CharSequence)localcjl.thumbUrl;
          if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label344;
            }
            localObject1 = paramc.getContext();
            p.g(localObject1, "thumbIv.context");
            paramc.setImageDrawable((Drawable)new ColorDrawable(((Context)localObject1).getResources().getColor(2131099689)));
            break;
          }
          label344:
          localObject1 = m.uJa;
          localObject1 = m.djY();
          localObject2 = new com.tencent.mm.plugin.finder.loader.k(localcjl, x.vEo, null, null, 12);
          m localm = m.uJa;
          ((d)localObject1).a(localObject2, m.a(m.a.uJb)).c(paramc);
          break;
          label397:
          i = 0;
          continue;
        }
        AppMethodBeat.o(255147);
        return;
      }
    }
    paramView.setOnClickListener(null);
    AppMethodBeat.o(255147);
  }
  
  public ag cZO()
  {
    return null;
  }
  
  public com.tencent.mm.plugin.finder.video.k cZP()
  {
    return null;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(255148);
    int i = this.oSb.size();
    AppMethodBeat.o(255148);
    return i;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/adapter/FinderFeedAlbumAdapter$AlbumHolder;", "Lcom/tencent/mm/plugin/finder/view/FinderFeedAlbumView$Holder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "plugin-finder_release"})
  public static final class a
    extends FinderFeedAlbumView.c
  {
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(255144);
      AppMethodBeat.o(255144);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/adapter/FinderFeedAlbumAdapter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class b {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/adapter/FinderFeedAlbumAdapter$OnItemClickListener;", "", "onClick", "", "position", "", "view", "Landroid/view/View;", "plugin-finder_release"})
  public static abstract interface c
  {
    public abstract void f(int paramInt, View paramView);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/view/adapter/FinderFeedAlbumAdapter$onBindView$2$1"})
  static final class d
    implements View.OnClickListener
  {
    d(b.c paramc, View paramView, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(255145);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      a.b("com/tencent/mm/plugin/finder/view/adapter/FinderFeedAlbumAdapter$onBindView$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      localObject = this.wrk;
      int i = paramInt;
      p.g(paramView, "it");
      ((b.c)localObject).f(i, paramView);
      a.a(this, "com/tencent/mm/plugin/finder/view/adapter/FinderFeedAlbumAdapter$onBindView$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(255145);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.adapter.b
 * JD-Core Version:    0.7.0.1
 */