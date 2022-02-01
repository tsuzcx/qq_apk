package com.tencent.mm.plugin.finder.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.k;
import com.tencent.mm.plugin.finder.convert.n;
import com.tencent.mm.plugin.finder.convert.u;
import com.tencent.mm.plugin.finder.convert.w;
import com.tencent.mm.plugin.finder.feed.a.a;
import com.tencent.mm.plugin.finder.feed.j.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.o;
import com.tencent.mm.plugin.finder.model.r;
import com.tencent.mm.plugin.finder.model.t;
import com.tencent.mm.plugin.finder.video.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.b;
import com.tencent.mm.view.recyclerview.c;
import d.g.b.p;
import d.l;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter;", "scene", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "safeMode", "", "(ILcom/tencent/mm/ui/MMActivity;Z)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "checkExposeCommentStrategy", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"})
public final class e
  extends j.a
{
  private String TAG;
  
  public e(int paramInt, MMActivity paramMMActivity, boolean paramBoolean)
  {
    super(paramInt, paramMMActivity, paramBoolean, false, 8);
    AppMethodBeat.i(204877);
    this.TAG = "Finder.FinderShareFeedDetailUI";
    AppMethodBeat.o(204877);
  }
  
  public final c cCq()
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/ui/Presenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "getLikeBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "plugin-finder_release"})
  public static final class a
    implements c
  {
    public final b<?> AX(int paramInt)
    {
      AppMethodBeat.i(167707);
      switch (paramInt)
      {
      default: 
        localb = (b)new f(this, (com.tencent.mm.plugin.finder.feed.h)this.sTu, this.sTu.rUX);
        AppMethodBeat.o(167707);
        return localb;
      case 4: 
      case 3002: 
        localb = (b)new a(this, this.sTu.rWB, (com.tencent.mm.plugin.finder.feed.h)this.sTu, this.sTu.rUX);
        AppMethodBeat.o(167707);
        return localb;
      case 2: 
      case 3001: 
        localb = (b)new b(this, (com.tencent.mm.plugin.finder.feed.h)this.sTu, this.sTu.rUX);
        AppMethodBeat.o(167707);
        return localb;
      case 7: 
        localb = (b)new c(this, (com.tencent.mm.plugin.finder.feed.h)this.sTu, this.sTu.rUX);
        AppMethodBeat.o(167707);
        return localb;
      case 8: 
        localb = (b)new d(this, this.sTu.rWB, (com.tencent.mm.plugin.finder.feed.h)this.sTu, this.sTu.rUX);
        AppMethodBeat.o(167707);
        return localb;
      }
      b localb = (b)new e(this, (com.tencent.mm.plugin.finder.feed.h)this.sTu, this.sTu.rUX);
      AppMethodBeat.o(167707);
      return localb;
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/ui/Presenter$buildItemCoverts$1$getItemConvert$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedVideoConvert;", "getLikeBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedVideo;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class a
      extends w
    {
      a(i parami, com.tencent.mm.plugin.finder.feed.h paramh, boolean paramBoolean)
      {
        super(paramBoolean, bool, 0, 8);
      }
      
      private void a(com.tencent.mm.view.recyclerview.e parame, t paramt, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(167689);
        p.h(parame, "holder");
        p.h(paramt, "item");
        super.a(parame, (BaseFinderFeed)paramt, paramInt1, paramInt2, paramBoolean, paramList);
        e.c(parame, this.rUX);
        parame = parame.GD(2131307449);
        if (parame != null)
        {
          parame.setVisibility(8);
          AppMethodBeat.o(167689);
          return;
        }
        AppMethodBeat.o(167689);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/ui/Presenter$buildItemCoverts$1$getItemConvert$2", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedImageConvert;", "getLikeBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedImage;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class b
      extends k
    {
      b(com.tencent.mm.plugin.finder.feed.h paramh, boolean paramBoolean)
      {
        super(bool, 0, 4);
      }
      
      private void a(com.tencent.mm.view.recyclerview.e parame, o paramo, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(167692);
        p.h(parame, "holder");
        p.h(paramo, "item");
        super.a(parame, (BaseFinderFeed)paramo, paramInt1, paramInt2, paramBoolean, paramList);
        e.c(parame, this.rUX);
        parame = parame.GD(2131307449);
        if (parame != null)
        {
          parame.setVisibility(8);
          AppMethodBeat.o(167692);
          return;
        }
        AppMethodBeat.o(167692);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/ui/Presenter$buildItemCoverts$1$getItemConvert$3", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedTextCardConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedImage;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class c
      extends u
    {
      c(com.tencent.mm.plugin.finder.feed.h paramh, boolean paramBoolean)
      {
        super(bool, 0, 4);
      }
      
      public final void a(com.tencent.mm.view.recyclerview.e parame, o paramo, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(167695);
        p.h(parame, "holder");
        p.h(paramo, "item");
        super.a(parame, paramo, paramInt1, paramInt2, paramBoolean, paramList);
        e.c(parame, this.rUX);
        AppMethodBeat.o(167695);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/ui/Presenter$buildItemCoverts$1$getItemConvert$4", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedMixConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedMix;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class d
      extends n
    {
      d(i parami, com.tencent.mm.plugin.finder.feed.h paramh, boolean paramBoolean)
      {
        super(paramBoolean, bool, 0, 8);
      }
      
      private void a(com.tencent.mm.view.recyclerview.e parame, com.tencent.mm.plugin.finder.model.q paramq, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(167698);
        p.h(parame, "holder");
        p.h(paramq, "item");
        super.a(parame, (BaseFinderFeed)paramq, paramInt1, paramInt2, paramBoolean, paramList);
        e.c(parame, this.rUX);
        AppMethodBeat.o(167698);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/ui/Presenter$buildItemCoverts$1$getItemConvert$5", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedPlainTextConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedPlainText;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class e
      extends com.tencent.mm.plugin.finder.convert.q
    {
      e(com.tencent.mm.plugin.finder.feed.h paramh, boolean paramBoolean)
      {
        super(bool, 0, 4);
      }
      
      private void a(com.tencent.mm.view.recyclerview.e parame, r paramr, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(167701);
        p.h(parame, "holder");
        p.h(paramr, "item");
        super.a(parame, (BaseFinderFeed)paramr, paramInt1, paramInt2, paramBoolean, paramList);
        e.c(parame, this.rUX);
        AppMethodBeat.o(167701);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/ui/Presenter$buildItemCoverts$1$getItemConvert$6", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedImageConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedImage;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class f
      extends k
    {
      f(com.tencent.mm.plugin.finder.feed.h paramh, boolean paramBoolean)
      {
        super(bool, 0, 4);
      }
      
      private void a(com.tencent.mm.view.recyclerview.e parame, o paramo, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(167704);
        p.h(parame, "holder");
        p.h(paramo, "item");
        super.a(parame, (BaseFinderFeed)paramo, paramInt1, paramInt2, paramBoolean, paramList);
        e.c(parame, this.rUX);
        AppMethodBeat.o(167704);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.e
 * JD-Core Version:    0.7.0.1
 */