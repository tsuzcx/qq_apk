package com.tencent.mm.plugin.finder.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.af;
import com.tencent.mm.plugin.finder.convert.j;
import com.tencent.mm.plugin.finder.convert.t;
import com.tencent.mm.plugin.finder.convert.v;
import com.tencent.mm.plugin.finder.feed.b.a;
import com.tencent.mm.plugin.finder.feed.h.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.o;
import com.tencent.mm.plugin.finder.model.s;
import com.tencent.mm.plugin.finder.video.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.c;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.k;
import d.l;
import d.y;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/ShareRelPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$Presenter;", "scene", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "safeMode", "", "(ILcom/tencent/mm/ui/MMActivity;Z)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "onBindMoreConvert", "Lkotlin/Function1;", "Landroid/view/View;", "", "getOnBindMoreConvert", "()Lkotlin/jvm/functions/Function1;", "setOnBindMoreConvert", "(Lkotlin/jvm/functions/Function1;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "checkExposeCommentStrategy", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onDetach", "plugin-finder_release"})
public final class n
  extends h.a
{
  private String TAG;
  d.g.a.b<? super View, y> rMs;
  
  public n(int paramInt, MMActivity paramMMActivity, boolean paramBoolean)
  {
    super(paramInt, paramMMActivity, paramBoolean, (byte)0);
    AppMethodBeat.i(203475);
    this.TAG = "Finder.FinderShareFeedDetailUI";
    AppMethodBeat.o(203475);
  }
  
  public final c cut()
  {
    AppMethodBeat.i(203473);
    c localc = (c)new a(this);
    AppMethodBeat.o(203473);
    return localc;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(203474);
    super.onDetach();
    AppMethodBeat.o(203474);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/ShareRelPresenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements c
  {
    public final com.tencent.mm.view.recyclerview.b<?> Ac(int paramInt)
    {
      AppMethodBeat.i(203472);
      switch (paramInt)
      {
      default: 
        localb = (com.tencent.mm.view.recyclerview.b)new g(this, (com.tencent.mm.plugin.finder.feed.g)this.rMt, this.rMt.ran);
        AppMethodBeat.o(203472);
        return localb;
      case 4: 
        localb = (com.tencent.mm.view.recyclerview.b)new a(this, this.rMt.rbo, (com.tencent.mm.plugin.finder.feed.g)this.rMt, this.rMt.ran);
        AppMethodBeat.o(203472);
        return localb;
      case 2: 
        localb = (com.tencent.mm.view.recyclerview.b)new b(this, (com.tencent.mm.plugin.finder.feed.g)this.rMt, this.rMt.ran);
        AppMethodBeat.o(203472);
        return localb;
      case 7: 
        localb = (com.tencent.mm.view.recyclerview.b)new c(this, (com.tencent.mm.plugin.finder.feed.g)this.rMt, this.rMt.ran);
        AppMethodBeat.o(203472);
        return localb;
      case 8: 
        localb = (com.tencent.mm.view.recyclerview.b)new d(this, this.rMt.rbo, (com.tencent.mm.plugin.finder.feed.g)this.rMt, this.rMt.ran);
        AppMethodBeat.o(203472);
        return localb;
      case 1: 
        localb = (com.tencent.mm.view.recyclerview.b)new e(this, (com.tencent.mm.plugin.finder.feed.g)this.rMt, this.rMt.ran);
        AppMethodBeat.o(203472);
        return localb;
      }
      com.tencent.mm.view.recyclerview.b localb = (com.tencent.mm.view.recyclerview.b)new f(this);
      AppMethodBeat.o(203472);
      return localb;
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/ShareRelPresenter$buildItemCoverts$1$getItemConvert$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedVideoConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedVideo;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class a
      extends v
    {
      a(i parami, com.tencent.mm.plugin.finder.feed.g paramg, boolean paramBoolean)
      {
        super(paramBoolean, bool, 0, 8);
      }
      
      private void a(e parame, s params, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(203452);
        k.h(parame, "holder");
        k.h(params, "item");
        super.a(parame, (BaseFinderFeed)params, paramInt1, paramInt2, paramBoolean, paramList);
        n.b(parame, this.ran);
        parame = parame.adJ(2131307449);
        if (parame != null)
        {
          parame.setVisibility(8);
          AppMethodBeat.o(203452);
          return;
        }
        AppMethodBeat.o(203452);
      }
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/ShareRelPresenter$buildItemCoverts$1$getItemConvert$2", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedImageConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedImage;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class b
      extends j
    {
      b(com.tencent.mm.plugin.finder.feed.g paramg, boolean paramBoolean)
      {
        super(bool, 0, 4);
      }
      
      private void a(e parame, com.tencent.mm.plugin.finder.model.m paramm, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(203455);
        k.h(parame, "holder");
        k.h(paramm, "item");
        super.a(parame, (BaseFinderFeed)paramm, paramInt1, paramInt2, paramBoolean, paramList);
        n.b(parame, this.ran);
        parame = parame.adJ(2131307449);
        if (parame != null)
        {
          parame.setVisibility(8);
          AppMethodBeat.o(203455);
          return;
        }
        AppMethodBeat.o(203455);
      }
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/ShareRelPresenter$buildItemCoverts$1$getItemConvert$3", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedTextCardConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedImage;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class c
      extends t
    {
      c(com.tencent.mm.plugin.finder.feed.g paramg, boolean paramBoolean)
      {
        super(bool, 0, 4);
      }
      
      public final void a(e parame, com.tencent.mm.plugin.finder.model.m paramm, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(203458);
        k.h(parame, "holder");
        k.h(paramm, "item");
        super.a(parame, paramm, paramInt1, paramInt2, paramBoolean, paramList);
        n.b(parame, this.ran);
        AppMethodBeat.o(203458);
      }
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/ShareRelPresenter$buildItemCoverts$1$getItemConvert$4", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedMixConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedMix;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class d
      extends com.tencent.mm.plugin.finder.convert.m
    {
      d(i parami, com.tencent.mm.plugin.finder.feed.g paramg, boolean paramBoolean)
      {
        super(paramBoolean, bool, 0, 8);
      }
      
      private void a(e parame, o paramo, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(203461);
        k.h(parame, "holder");
        k.h(paramo, "item");
        super.a(parame, (BaseFinderFeed)paramo, paramInt1, paramInt2, paramBoolean, paramList);
        n.b(parame, this.ran);
        AppMethodBeat.o(203461);
      }
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/ShareRelPresenter$buildItemCoverts$1$getItemConvert$5", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedPlainTextConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedPlainText;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class e
      extends com.tencent.mm.plugin.finder.convert.p
    {
      e(com.tencent.mm.plugin.finder.feed.g paramg, boolean paramBoolean)
      {
        super(bool, 0, 4);
      }
      
      private void a(e parame, com.tencent.mm.plugin.finder.model.p paramp, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(203464);
        k.h(parame, "holder");
        k.h(paramp, "item");
        super.a(parame, (BaseFinderFeed)paramp, paramInt1, paramInt2, paramBoolean, paramList);
        n.b(parame, this.ran);
        AppMethodBeat.o(203464);
      }
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/ShareRelPresenter$buildItemCoverts$1$getItemConvert$6", "Lcom/tencent/mm/plugin/finder/convert/FinderMoreSimilarTopicConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class f
      extends af
    {
      public final void a(e parame, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(203467);
        k.h(parame, "holder");
        k.h(paramBaseFinderFeed, "item");
        super.a(parame, paramBaseFinderFeed, paramInt1, paramInt2, paramBoolean, paramList);
        parame.kj(2131307438, 2131766441);
        n.b(parame, this.rMu.rMt.ran);
        paramBaseFinderFeed = this.rMu.rMt.rMs;
        if (paramBaseFinderFeed != null)
        {
          parame = parame.asD;
          k.g(parame, "holder.itemView");
          paramBaseFinderFeed.ay(parame);
          AppMethodBeat.o(203467);
          return;
        }
        AppMethodBeat.o(203467);
      }
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/ShareRelPresenter$buildItemCoverts$1$getItemConvert$7", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedImageConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedImage;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class g
      extends j
    {
      g(com.tencent.mm.plugin.finder.feed.g paramg, boolean paramBoolean)
      {
        super(bool, 0, 4);
      }
      
      private void a(e parame, com.tencent.mm.plugin.finder.model.m paramm, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(203469);
        k.h(parame, "holder");
        k.h(paramm, "item");
        super.a(parame, (BaseFinderFeed)paramm, paramInt1, paramInt2, paramBoolean, paramList);
        n.b(parame, this.ran);
        AppMethodBeat.o(203469);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.n
 * JD-Core Version:    0.7.0.1
 */