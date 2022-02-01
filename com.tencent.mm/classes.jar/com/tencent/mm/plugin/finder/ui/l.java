package com.tencent.mm.plugin.finder.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.j;
import com.tencent.mm.plugin.finder.convert.t;
import com.tencent.mm.plugin.finder.convert.v;
import com.tencent.mm.plugin.finder.feed.b.a;
import com.tencent.mm.plugin.finder.feed.i.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.o;
import com.tencent.mm.plugin.finder.model.s;
import com.tencent.mm.plugin.finder.video.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.b;
import com.tencent.mm.view.recyclerview.c;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.k;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter;", "scene", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "safeMode", "", "(ILcom/tencent/mm/ui/MMActivity;Z)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "checkExposeCommentStrategy", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"})
public final class l
  extends i.a
{
  private String TAG;
  
  public l(int paramInt, MMActivity paramMMActivity, boolean paramBoolean)
  {
    super(paramInt, paramMMActivity, paramBoolean, false, 8);
    AppMethodBeat.i(203451);
    this.TAG = "Finder.FinderShareFeedDetailUI";
    AppMethodBeat.o(203451);
  }
  
  public final c cut()
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
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/Presenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements c
  {
    public final b<?> Ac(int paramInt)
    {
      AppMethodBeat.i(167707);
      switch (paramInt)
      {
      case 3: 
      case 5: 
      case 6: 
      default: 
        localb = (b)new f(this, (com.tencent.mm.plugin.finder.feed.g)this.rMq, this.rMq.ran);
        AppMethodBeat.o(167707);
        return localb;
      case 4: 
        localb = (b)new a(this, this.rMq.rbo, (com.tencent.mm.plugin.finder.feed.g)this.rMq, this.rMq.ran);
        AppMethodBeat.o(167707);
        return localb;
      case 2: 
        localb = (b)new b(this, (com.tencent.mm.plugin.finder.feed.g)this.rMq, this.rMq.ran);
        AppMethodBeat.o(167707);
        return localb;
      case 7: 
        localb = (b)new c(this, (com.tencent.mm.plugin.finder.feed.g)this.rMq, this.rMq.ran);
        AppMethodBeat.o(167707);
        return localb;
      case 8: 
        localb = (b)new d(this, this.rMq.rbo, (com.tencent.mm.plugin.finder.feed.g)this.rMq, this.rMq.ran);
        AppMethodBeat.o(167707);
        return localb;
      }
      b localb = (b)new e(this, (com.tencent.mm.plugin.finder.feed.g)this.rMq, this.rMq.ran);
      AppMethodBeat.o(167707);
      return localb;
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/Presenter$buildItemCoverts$1$getItemConvert$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedVideoConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedVideo;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class a
      extends v
    {
      a(i parami, com.tencent.mm.plugin.finder.feed.g paramg, boolean paramBoolean)
      {
        super(paramBoolean, bool, 0, 8);
      }
      
      private void a(e parame, s params, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(167689);
        k.h(parame, "holder");
        k.h(params, "item");
        super.a(parame, (BaseFinderFeed)params, paramInt1, paramInt2, paramBoolean, paramList);
        l.a(parame, this.ran);
        parame = parame.adJ(2131307449);
        if (parame != null)
        {
          parame.setVisibility(8);
          AppMethodBeat.o(167689);
          return;
        }
        AppMethodBeat.o(167689);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/Presenter$buildItemCoverts$1$getItemConvert$2", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedImageConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedImage;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class b
      extends j
    {
      b(com.tencent.mm.plugin.finder.feed.g paramg, boolean paramBoolean)
      {
        super(bool, 0, 4);
      }
      
      private void a(e parame, com.tencent.mm.plugin.finder.model.m paramm, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(167692);
        k.h(parame, "holder");
        k.h(paramm, "item");
        super.a(parame, (BaseFinderFeed)paramm, paramInt1, paramInt2, paramBoolean, paramList);
        l.a(parame, this.ran);
        parame = parame.adJ(2131307449);
        if (parame != null)
        {
          parame.setVisibility(8);
          AppMethodBeat.o(167692);
          return;
        }
        AppMethodBeat.o(167692);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/Presenter$buildItemCoverts$1$getItemConvert$3", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedTextCardConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedImage;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class c
      extends t
    {
      c(com.tencent.mm.plugin.finder.feed.g paramg, boolean paramBoolean)
      {
        super(bool, 0, 4);
      }
      
      public final void a(e parame, com.tencent.mm.plugin.finder.model.m paramm, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(167695);
        k.h(parame, "holder");
        k.h(paramm, "item");
        super.a(parame, paramm, paramInt1, paramInt2, paramBoolean, paramList);
        l.a(parame, this.ran);
        AppMethodBeat.o(167695);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/Presenter$buildItemCoverts$1$getItemConvert$4", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedMixConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedMix;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class d
      extends com.tencent.mm.plugin.finder.convert.m
    {
      d(i parami, com.tencent.mm.plugin.finder.feed.g paramg, boolean paramBoolean)
      {
        super(paramBoolean, bool, 0, 8);
      }
      
      private void a(e parame, o paramo, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(167698);
        k.h(parame, "holder");
        k.h(paramo, "item");
        super.a(parame, (BaseFinderFeed)paramo, paramInt1, paramInt2, paramBoolean, paramList);
        l.a(parame, this.ran);
        AppMethodBeat.o(167698);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/Presenter$buildItemCoverts$1$getItemConvert$5", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedPlainTextConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedPlainText;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class e
      extends com.tencent.mm.plugin.finder.convert.p
    {
      e(com.tencent.mm.plugin.finder.feed.g paramg, boolean paramBoolean)
      {
        super(bool, 0, 4);
      }
      
      private void a(e parame, com.tencent.mm.plugin.finder.model.p paramp, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(167701);
        k.h(parame, "holder");
        k.h(paramp, "item");
        super.a(parame, (BaseFinderFeed)paramp, paramInt1, paramInt2, paramBoolean, paramList);
        l.a(parame, this.ran);
        AppMethodBeat.o(167701);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/Presenter$buildItemCoverts$1$getItemConvert$6", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedImageConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedImage;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class f
      extends j
    {
      f(com.tencent.mm.plugin.finder.feed.g paramg, boolean paramBoolean)
      {
        super(bool, 0, 4);
      }
      
      private void a(e parame, com.tencent.mm.plugin.finder.model.m paramm, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(167704);
        k.h(parame, "holder");
        k.h(paramm, "item");
        super.a(parame, (BaseFinderFeed)paramm, paramInt1, paramInt2, paramBoolean, paramList);
        l.a(parame, this.ran);
        AppMethodBeat.o(167704);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.l
 * JD-Core Version:    0.7.0.1
 */