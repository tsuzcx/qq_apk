package com.tencent.mm.plugin.finder.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.g;
import com.tencent.mm.plugin.finder.convert.o;
import com.tencent.mm.plugin.finder.convert.r;
import com.tencent.mm.plugin.finder.feed.a.a;
import com.tencent.mm.plugin.finder.feed.d.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.j;
import com.tencent.mm.plugin.finder.model.n;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.b;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter;", "scene", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "safeMode", "", "(ILcom/tencent/mm/ui/MMActivity;Z)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "checkExposeCommentStrategy", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"})
public final class c
  extends d.a
{
  private String TAG;
  
  public c(int paramInt, MMActivity paramMMActivity, boolean paramBoolean)
  {
    super(paramInt, paramMMActivity, paramBoolean, false, 8);
    AppMethodBeat.i(199475);
    this.TAG = "Finder.FinderShareFeedDetailUI";
    AppMethodBeat.o(199475);
  }
  
  public final com.tencent.mm.view.recyclerview.c clL()
  {
    AppMethodBeat.i(167708);
    com.tencent.mm.view.recyclerview.c localc = (com.tencent.mm.view.recyclerview.c)new a(this);
    AppMethodBeat.o(167708);
    return localc;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/Presenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.view.recyclerview.c
  {
    public final b<?> zm(int paramInt)
    {
      AppMethodBeat.i(167707);
      switch (paramInt)
      {
      case 3: 
      case 5: 
      case 6: 
      default: 
        localb = (b)new f(this, (com.tencent.mm.plugin.finder.feed.c)this.qQv, this.qQv.qqF);
        AppMethodBeat.o(167707);
        return localb;
      case 4: 
        localb = (b)new a(this, this.qQv.qrq, (com.tencent.mm.plugin.finder.feed.c)this.qQv, this.qQv.qqF);
        AppMethodBeat.o(167707);
        return localb;
      case 2: 
        localb = (b)new b(this, (com.tencent.mm.plugin.finder.feed.c)this.qQv, this.qQv.qqF);
        AppMethodBeat.o(167707);
        return localb;
      case 7: 
        localb = (b)new c(this, (com.tencent.mm.plugin.finder.feed.c)this.qQv, this.qQv.qqF);
        AppMethodBeat.o(167707);
        return localb;
      case 8: 
        localb = (b)new d(this, this.qQv.qrq, (com.tencent.mm.plugin.finder.feed.c)this.qQv, this.qQv.qqF);
        AppMethodBeat.o(167707);
        return localb;
      }
      b localb = (b)new e(this, (com.tencent.mm.plugin.finder.feed.c)this.qQv, this.qQv.qqF);
      AppMethodBeat.o(167707);
      return localb;
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/Presenter$buildItemCoverts$1$getItemConvert$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedVideoConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedVideo;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class a
      extends r
    {
      a(com.tencent.mm.plugin.finder.video.c paramc, com.tencent.mm.plugin.finder.feed.c paramc1, boolean paramBoolean)
      {
        super(paramBoolean, bool, 0, 8);
      }
      
      private void a(com.tencent.mm.view.recyclerview.e parame, n paramn, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(167689);
        d.g.b.k.h(parame, "holder");
        d.g.b.k.h(paramn, "item");
        super.a(parame, (BaseFinderFeed)paramn, paramInt1, paramInt2, paramBoolean, paramList);
        c.a(parame, this.qqF);
        parame = parame.abq(2131307380);
        if (parame != null)
        {
          parame.setVisibility(8);
          AppMethodBeat.o(167689);
          return;
        }
        AppMethodBeat.o(167689);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/Presenter$buildItemCoverts$1$getItemConvert$2", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedImageConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedImage;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class b
      extends g
    {
      b(com.tencent.mm.plugin.finder.feed.c paramc, boolean paramBoolean)
      {
        super(bool, 0, 4);
      }
      
      private void a(com.tencent.mm.view.recyclerview.e parame, com.tencent.mm.plugin.finder.model.i parami, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(167692);
        d.g.b.k.h(parame, "holder");
        d.g.b.k.h(parami, "item");
        super.a(parame, (BaseFinderFeed)parami, paramInt1, paramInt2, paramBoolean, paramList);
        c.a(parame, this.qqF);
        parame = parame.abq(2131307380);
        if (parame != null)
        {
          parame.setVisibility(8);
          AppMethodBeat.o(167692);
          return;
        }
        AppMethodBeat.o(167692);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/Presenter$buildItemCoverts$1$getItemConvert$3", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedTextCardConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedImage;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class c
      extends o
    {
      c(com.tencent.mm.plugin.finder.feed.c paramc, boolean paramBoolean)
      {
        super(bool, 0, 4);
      }
      
      public final void a(com.tencent.mm.view.recyclerview.e parame, com.tencent.mm.plugin.finder.model.i parami, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(167695);
        d.g.b.k.h(parame, "holder");
        d.g.b.k.h(parami, "item");
        super.a(parame, parami, paramInt1, paramInt2, paramBoolean, paramList);
        c.a(parame, this.qqF);
        AppMethodBeat.o(167695);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/Presenter$buildItemCoverts$1$getItemConvert$4", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedMixConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedMix;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class d
      extends com.tencent.mm.plugin.finder.convert.i
    {
      d(com.tencent.mm.plugin.finder.video.c paramc, com.tencent.mm.plugin.finder.feed.c paramc1, boolean paramBoolean)
      {
        super(paramBoolean, bool, 0, 8);
      }
      
      private void a(com.tencent.mm.view.recyclerview.e parame, j paramj, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(167698);
        d.g.b.k.h(parame, "holder");
        d.g.b.k.h(paramj, "item");
        super.a(parame, (BaseFinderFeed)paramj, paramInt1, paramInt2, paramBoolean, paramList);
        c.a(parame, this.qqF);
        AppMethodBeat.o(167698);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/Presenter$buildItemCoverts$1$getItemConvert$5", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedPlainTextConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedPlainText;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class e
      extends com.tencent.mm.plugin.finder.convert.l
    {
      e(com.tencent.mm.plugin.finder.feed.c paramc, boolean paramBoolean)
      {
        super(bool, 0, 4);
      }
      
      private void a(com.tencent.mm.view.recyclerview.e parame, com.tencent.mm.plugin.finder.model.k paramk, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(167701);
        d.g.b.k.h(parame, "holder");
        d.g.b.k.h(paramk, "item");
        super.a(parame, (BaseFinderFeed)paramk, paramInt1, paramInt2, paramBoolean, paramList);
        c.a(parame, this.qqF);
        AppMethodBeat.o(167701);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/Presenter$buildItemCoverts$1$getItemConvert$6", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedImageConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedImage;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class f
      extends g
    {
      f(com.tencent.mm.plugin.finder.feed.c paramc, boolean paramBoolean)
      {
        super(bool, 0, 4);
      }
      
      private void a(com.tencent.mm.view.recyclerview.e parame, com.tencent.mm.plugin.finder.model.i parami, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(167704);
        d.g.b.k.h(parame, "holder");
        d.g.b.k.h(parami, "item");
        super.a(parame, (BaseFinderFeed)parami, paramInt1, paramInt2, paramBoolean, paramList);
        c.a(parame, this.qqF);
        AppMethodBeat.o(167704);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.c
 * JD-Core Version:    0.7.0.1
 */