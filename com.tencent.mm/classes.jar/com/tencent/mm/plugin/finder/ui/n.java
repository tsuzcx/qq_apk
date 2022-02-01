package com.tencent.mm.plugin.finder.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.am;
import com.tencent.mm.plugin.finder.convert.g;
import com.tencent.mm.plugin.finder.convert.o;
import com.tencent.mm.plugin.finder.convert.r;
import com.tencent.mm.plugin.finder.feed.a.a;
import com.tencent.mm.plugin.finder.feed.q.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.j;
import com.tencent.mm.ui.MMActivity;
import d.y;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/ShareRelPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$Presenter;", "scene", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "safeMode", "", "(ILcom/tencent/mm/ui/MMActivity;Z)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "onBindMoreConvert", "Lkotlin/Function1;", "Landroid/view/View;", "", "getOnBindMoreConvert", "()Lkotlin/jvm/functions/Function1;", "setOnBindMoreConvert", "(Lkotlin/jvm/functions/Function1;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "checkExposeCommentStrategy", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onDetach", "plugin-finder_release"})
public final class n
  extends q.a
{
  d.g.a.b<? super View, y> Lac;
  private String TAG;
  
  public n(int paramInt, MMActivity paramMMActivity, boolean paramBoolean)
  {
    super(paramInt, paramMMActivity, paramBoolean, (byte)0);
    AppMethodBeat.i(199499);
    this.TAG = "Finder.FinderShareFeedDetailUI";
    AppMethodBeat.o(199499);
  }
  
  public final com.tencent.mm.view.recyclerview.c clL()
  {
    AppMethodBeat.i(199497);
    com.tencent.mm.view.recyclerview.c localc = (com.tencent.mm.view.recyclerview.c)new a(this);
    AppMethodBeat.o(199497);
    return localc;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(199498);
    super.onDetach();
    AppMethodBeat.o(199498);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/ShareRelPresenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.view.recyclerview.c
  {
    public final com.tencent.mm.view.recyclerview.b<?> zm(int paramInt)
    {
      AppMethodBeat.i(199496);
      switch (paramInt)
      {
      default: 
        localb = (com.tencent.mm.view.recyclerview.b)new g(this, (com.tencent.mm.plugin.finder.feed.c)this.Lad, this.Lad.qqF);
        AppMethodBeat.o(199496);
        return localb;
      case 4: 
        localb = (com.tencent.mm.view.recyclerview.b)new a(this, this.Lad.qrq, (com.tencent.mm.plugin.finder.feed.c)this.Lad, this.Lad.qqF);
        AppMethodBeat.o(199496);
        return localb;
      case 2: 
        localb = (com.tencent.mm.view.recyclerview.b)new b(this, (com.tencent.mm.plugin.finder.feed.c)this.Lad, this.Lad.qqF);
        AppMethodBeat.o(199496);
        return localb;
      case 7: 
        localb = (com.tencent.mm.view.recyclerview.b)new c(this, (com.tencent.mm.plugin.finder.feed.c)this.Lad, this.Lad.qqF);
        AppMethodBeat.o(199496);
        return localb;
      case 8: 
        localb = (com.tencent.mm.view.recyclerview.b)new d(this, this.Lad.qrq, (com.tencent.mm.plugin.finder.feed.c)this.Lad, this.Lad.qqF);
        AppMethodBeat.o(199496);
        return localb;
      case 1: 
        localb = (com.tencent.mm.view.recyclerview.b)new e(this, (com.tencent.mm.plugin.finder.feed.c)this.Lad, this.Lad.qqF);
        AppMethodBeat.o(199496);
        return localb;
      }
      com.tencent.mm.view.recyclerview.b localb = (com.tencent.mm.view.recyclerview.b)new f(this);
      AppMethodBeat.o(199496);
      return localb;
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/ShareRelPresenter$buildItemCoverts$1$getItemConvert$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedVideoConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedVideo;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class a
      extends r
    {
      a(com.tencent.mm.plugin.finder.video.c paramc, com.tencent.mm.plugin.finder.feed.c paramc1, boolean paramBoolean)
      {
        super(paramBoolean, bool, 0, 8);
      }
      
      private void a(com.tencent.mm.view.recyclerview.e parame, com.tencent.mm.plugin.finder.model.n paramn, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(199476);
        d.g.b.k.h(parame, "holder");
        d.g.b.k.h(paramn, "item");
        super.a(parame, (BaseFinderFeed)paramn, paramInt1, paramInt2, paramBoolean, paramList);
        n.b(parame, this.qqF);
        parame = parame.abq(2131307380);
        if (parame != null)
        {
          parame.setVisibility(8);
          AppMethodBeat.o(199476);
          return;
        }
        AppMethodBeat.o(199476);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/ShareRelPresenter$buildItemCoverts$1$getItemConvert$2", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedImageConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedImage;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class b
      extends g
    {
      b(com.tencent.mm.plugin.finder.feed.c paramc, boolean paramBoolean)
      {
        super(bool, 0, 4);
      }
      
      private void a(com.tencent.mm.view.recyclerview.e parame, com.tencent.mm.plugin.finder.model.i parami, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(199479);
        d.g.b.k.h(parame, "holder");
        d.g.b.k.h(parami, "item");
        super.a(parame, (BaseFinderFeed)parami, paramInt1, paramInt2, paramBoolean, paramList);
        n.b(parame, this.qqF);
        parame = parame.abq(2131307380);
        if (parame != null)
        {
          parame.setVisibility(8);
          AppMethodBeat.o(199479);
          return;
        }
        AppMethodBeat.o(199479);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/ShareRelPresenter$buildItemCoverts$1$getItemConvert$3", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedTextCardConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedImage;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class c
      extends o
    {
      c(com.tencent.mm.plugin.finder.feed.c paramc, boolean paramBoolean)
      {
        super(bool, 0, 4);
      }
      
      public final void a(com.tencent.mm.view.recyclerview.e parame, com.tencent.mm.plugin.finder.model.i parami, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(199482);
        d.g.b.k.h(parame, "holder");
        d.g.b.k.h(parami, "item");
        super.a(parame, parami, paramInt1, paramInt2, paramBoolean, paramList);
        n.b(parame, this.qqF);
        AppMethodBeat.o(199482);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/ShareRelPresenter$buildItemCoverts$1$getItemConvert$4", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedMixConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedMix;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class d
      extends com.tencent.mm.plugin.finder.convert.i
    {
      d(com.tencent.mm.plugin.finder.video.c paramc, com.tencent.mm.plugin.finder.feed.c paramc1, boolean paramBoolean)
      {
        super(paramBoolean, bool, 0, 8);
      }
      
      private void a(com.tencent.mm.view.recyclerview.e parame, j paramj, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(199485);
        d.g.b.k.h(parame, "holder");
        d.g.b.k.h(paramj, "item");
        super.a(parame, (BaseFinderFeed)paramj, paramInt1, paramInt2, paramBoolean, paramList);
        n.b(parame, this.qqF);
        AppMethodBeat.o(199485);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/ShareRelPresenter$buildItemCoverts$1$getItemConvert$5", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedPlainTextConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedPlainText;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class e
      extends com.tencent.mm.plugin.finder.convert.l
    {
      e(com.tencent.mm.plugin.finder.feed.c paramc, boolean paramBoolean)
      {
        super(bool, 0, 4);
      }
      
      private void a(com.tencent.mm.view.recyclerview.e parame, com.tencent.mm.plugin.finder.model.k paramk, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(199488);
        d.g.b.k.h(parame, "holder");
        d.g.b.k.h(paramk, "item");
        super.a(parame, (BaseFinderFeed)paramk, paramInt1, paramInt2, paramBoolean, paramList);
        n.b(parame, this.qqF);
        AppMethodBeat.o(199488);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/ShareRelPresenter$buildItemCoverts$1$getItemConvert$6", "Lcom/tencent/mm/plugin/finder/convert/FinderMoreSimilarTopicConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class f
      extends am
    {
      public final void a(com.tencent.mm.view.recyclerview.e parame, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(199491);
        d.g.b.k.h(parame, "holder");
        d.g.b.k.h(paramBaseFinderFeed, "item");
        super.a(parame, paramBaseFinderFeed, paramInt1, paramInt2, paramBoolean, paramList);
        parame.ll(2131307369, 2131766428);
        n.b(parame, this.Lae.Lad.qqF);
        paramBaseFinderFeed = this.Lae.Lad.Lac;
        if (paramBaseFinderFeed != null)
        {
          parame = parame.arI;
          d.g.b.k.g(parame, "holder.itemView");
          paramBaseFinderFeed.aA(parame);
          AppMethodBeat.o(199491);
          return;
        }
        AppMethodBeat.o(199491);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/ShareRelPresenter$buildItemCoverts$1$getItemConvert$7", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedImageConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedImage;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class g
      extends g
    {
      g(com.tencent.mm.plugin.finder.feed.c paramc, boolean paramBoolean)
      {
        super(bool, 0, 4);
      }
      
      private void a(com.tencent.mm.view.recyclerview.e parame, com.tencent.mm.plugin.finder.model.i parami, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(199493);
        d.g.b.k.h(parame, "holder");
        d.g.b.k.h(parami, "item");
        super.a(parame, (BaseFinderFeed)parami, paramInt1, paramInt2, paramBoolean, paramList);
        n.b(parame, this.qqF);
        AppMethodBeat.o(199493);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.n
 * JD-Core Version:    0.7.0.1
 */