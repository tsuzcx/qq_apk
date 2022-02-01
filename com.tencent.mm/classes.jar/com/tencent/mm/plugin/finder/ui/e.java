package com.tencent.mm.plugin.finder.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.k;
import com.tencent.mm.plugin.finder.convert.u;
import com.tencent.mm.plugin.finder.convert.w;
import com.tencent.mm.plugin.finder.feed.a.a;
import com.tencent.mm.plugin.finder.feed.j.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.s;
import com.tencent.mm.plugin.finder.video.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.b;
import com.tencent.mm.view.recyclerview.c;
import d.l;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter;", "scene", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "safeMode", "", "(ILcom/tencent/mm/ui/MMActivity;Z)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "checkExposeCommentStrategy", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"})
public final class e
  extends j.a
{
  private String TAG;
  
  public e(int paramInt, MMActivity paramMMActivity, boolean paramBoolean)
  {
    super(paramInt, paramMMActivity, paramBoolean, false, 8);
    AppMethodBeat.i(204259);
    this.TAG = "Finder.FinderShareFeedDetailUI";
    AppMethodBeat.o(204259);
  }
  
  public final c cAE()
  {
    AppMethodBeat.i(167708);
    c localc = (c)new a(this);
    AppMethodBeat.o(167708);
    return localc;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/ui/Presenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "getLikeBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "plugin-finder_release"})
  public static final class a
    implements c
  {
    public final b<?> AL(int paramInt)
    {
      AppMethodBeat.i(167707);
      switch (paramInt)
      {
      default: 
        localb = (b)new f(this, (com.tencent.mm.plugin.finder.feed.h)this.sIi, this.sIi.rMJ);
        AppMethodBeat.o(167707);
        return localb;
      case 4: 
      case 3002: 
        localb = (b)new a(this, this.sIi.rOe, (com.tencent.mm.plugin.finder.feed.h)this.sIi, this.sIi.rMJ);
        AppMethodBeat.o(167707);
        return localb;
      case 2: 
      case 3001: 
        localb = (b)new b(this, (com.tencent.mm.plugin.finder.feed.h)this.sIi, this.sIi.rMJ);
        AppMethodBeat.o(167707);
        return localb;
      case 7: 
        localb = (b)new c(this, (com.tencent.mm.plugin.finder.feed.h)this.sIi, this.sIi.rMJ);
        AppMethodBeat.o(167707);
        return localb;
      case 8: 
        localb = (b)new d(this, this.sIi.rOe, (com.tencent.mm.plugin.finder.feed.h)this.sIi, this.sIi.rMJ);
        AppMethodBeat.o(167707);
        return localb;
      }
      b localb = (b)new e(this, (com.tencent.mm.plugin.finder.feed.h)this.sIi, this.sIi.rMJ);
      AppMethodBeat.o(167707);
      return localb;
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/ui/Presenter$buildItemCoverts$1$getItemConvert$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedVideoConvert;", "getLikeBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedVideo;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class a
      extends w
    {
      a(i parami, com.tencent.mm.plugin.finder.feed.h paramh, boolean paramBoolean)
      {
        super(paramBoolean, bool, 0, 8);
      }
      
      private void a(com.tencent.mm.view.recyclerview.e parame, s params, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(167689);
        d.g.b.p.h(parame, "holder");
        d.g.b.p.h(params, "item");
        super.a(parame, (BaseFinderFeed)params, paramInt1, paramInt2, paramBoolean, paramList);
        e.c(parame, this.rMJ);
        parame = parame.Gd(2131307449);
        if (parame != null)
        {
          parame.setVisibility(8);
          AppMethodBeat.o(167689);
          return;
        }
        AppMethodBeat.o(167689);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/ui/Presenter$buildItemCoverts$1$getItemConvert$2", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedImageConvert;", "getLikeBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedImage;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class b
      extends k
    {
      b(com.tencent.mm.plugin.finder.feed.h paramh, boolean paramBoolean)
      {
        super(bool, 0, 4);
      }
      
      private void a(com.tencent.mm.view.recyclerview.e parame, com.tencent.mm.plugin.finder.model.n paramn, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(167692);
        d.g.b.p.h(parame, "holder");
        d.g.b.p.h(paramn, "item");
        super.a(parame, (BaseFinderFeed)paramn, paramInt1, paramInt2, paramBoolean, paramList);
        e.c(parame, this.rMJ);
        parame = parame.Gd(2131307449);
        if (parame != null)
        {
          parame.setVisibility(8);
          AppMethodBeat.o(167692);
          return;
        }
        AppMethodBeat.o(167692);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/ui/Presenter$buildItemCoverts$1$getItemConvert$3", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedTextCardConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedImage;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class c
      extends u
    {
      c(com.tencent.mm.plugin.finder.feed.h paramh, boolean paramBoolean)
      {
        super(bool, 0, 4);
      }
      
      public final void a(com.tencent.mm.view.recyclerview.e parame, com.tencent.mm.plugin.finder.model.n paramn, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(167695);
        d.g.b.p.h(parame, "holder");
        d.g.b.p.h(paramn, "item");
        super.a(parame, paramn, paramInt1, paramInt2, paramBoolean, paramList);
        e.c(parame, this.rMJ);
        AppMethodBeat.o(167695);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/ui/Presenter$buildItemCoverts$1$getItemConvert$4", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedMixConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedMix;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class d
      extends com.tencent.mm.plugin.finder.convert.n
    {
      d(i parami, com.tencent.mm.plugin.finder.feed.h paramh, boolean paramBoolean)
      {
        super(paramBoolean, bool, 0, 8);
      }
      
      private void a(com.tencent.mm.view.recyclerview.e parame, com.tencent.mm.plugin.finder.model.p paramp, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(167698);
        d.g.b.p.h(parame, "holder");
        d.g.b.p.h(paramp, "item");
        super.a(parame, (BaseFinderFeed)paramp, paramInt1, paramInt2, paramBoolean, paramList);
        e.c(parame, this.rMJ);
        AppMethodBeat.o(167698);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/ui/Presenter$buildItemCoverts$1$getItemConvert$5", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedPlainTextConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedPlainText;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class e
      extends com.tencent.mm.plugin.finder.convert.q
    {
      e(com.tencent.mm.plugin.finder.feed.h paramh, boolean paramBoolean)
      {
        super(bool, 0, 4);
      }
      
      private void a(com.tencent.mm.view.recyclerview.e parame, com.tencent.mm.plugin.finder.model.q paramq, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(167701);
        d.g.b.p.h(parame, "holder");
        d.g.b.p.h(paramq, "item");
        super.a(parame, (BaseFinderFeed)paramq, paramInt1, paramInt2, paramBoolean, paramList);
        e.c(parame, this.rMJ);
        AppMethodBeat.o(167701);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/ui/Presenter$buildItemCoverts$1$getItemConvert$6", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedImageConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedImage;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class f
      extends k
    {
      f(com.tencent.mm.plugin.finder.feed.h paramh, boolean paramBoolean)
      {
        super(bool, 0, 4);
      }
      
      private void a(com.tencent.mm.view.recyclerview.e parame, com.tencent.mm.plugin.finder.model.n paramn, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(167704);
        d.g.b.p.h(parame, "holder");
        d.g.b.p.h(paramn, "item");
        super.a(parame, (BaseFinderFeed)paramn, paramInt1, paramInt2, paramBoolean, paramList);
        e.c(parame, this.rMJ);
        AppMethodBeat.o(167704);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.e
 * JD-Core Version:    0.7.0.1
 */