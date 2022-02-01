package com.tencent.mm.plugin.finder.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.ai;
import com.tencent.mm.plugin.finder.convert.ak;
import com.tencent.mm.plugin.finder.feed.b.a;
import com.tencent.mm.plugin.finder.feed.k.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ab;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.video.k;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter;", "scene", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "safeMode", "", "(ILcom/tencent/mm/ui/MMActivity;Z)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "checkExposeCommentStrategy", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"})
public final class i
  extends k.a
{
  String TAG;
  
  public i(int paramInt, MMActivity paramMMActivity, boolean paramBoolean)
  {
    super(paramInt, paramMMActivity, paramBoolean, false, 8);
    AppMethodBeat.i(252808);
    this.TAG = "Finder.FinderShareFeedDetailUI";
    AppMethodBeat.o(252808);
  }
  
  public final com.tencent.mm.view.recyclerview.f dce()
  {
    AppMethodBeat.i(167708);
    com.tencent.mm.view.recyclerview.f localf = (com.tencent.mm.view.recyclerview.f)new a(this);
    AppMethodBeat.o(167708);
    return localf;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/Presenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "getLikeBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.view.recyclerview.f
  {
    public final e<?> EC(int paramInt)
    {
      AppMethodBeat.i(167707);
      switch (paramInt)
      {
      default: 
        localObject = y.vXH;
        y.dQ(this.vPZ.TAG, paramInt);
        localObject = (e)new com.tencent.mm.plugin.finder.convert.f();
        AppMethodBeat.o(167707);
        return localObject;
      case 4: 
      case 3002: 
        localObject = (e)new a(this, this.vPZ.tCD, (com.tencent.mm.plugin.finder.feed.i)this.vPZ, this.vPZ.tAj);
        AppMethodBeat.o(167707);
        return localObject;
      case 2: 
      case 3001: 
        localObject = (e)new b(this, (com.tencent.mm.plugin.finder.feed.i)this.vPZ, this.vPZ.tAj);
        AppMethodBeat.o(167707);
        return localObject;
      case 7: 
        localObject = (e)new c(this, (com.tencent.mm.plugin.finder.feed.i)this.vPZ, this.vPZ.tAj);
        AppMethodBeat.o(167707);
        return localObject;
      case 8: 
        localObject = (e)new d(this, this.vPZ.tCD, (com.tencent.mm.plugin.finder.feed.i)this.vPZ, this.vPZ.tAj);
        AppMethodBeat.o(167707);
        return localObject;
      }
      Object localObject = (e)new e(this, (com.tencent.mm.plugin.finder.feed.i)this.vPZ, this.vPZ.tAj);
      AppMethodBeat.o(167707);
      return localObject;
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/Presenter$buildItemCoverts$1$getItemConvert$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedVideoConvert;", "getLikeBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedVideo;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class a
      extends ak
    {
      a(k paramk, com.tencent.mm.plugin.finder.feed.i parami, boolean paramBoolean)
      {
        super(paramBoolean, bool, 0, 8);
      }
      
      public final void a(h paramh, com.tencent.mm.plugin.finder.model.ad paramad, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(167689);
        p.h(paramh, "holder");
        p.h(paramad, "item");
        super.a(paramh, paramad, paramInt1, paramInt2, paramBoolean, paramList);
        i.c(paramh, this.tAj);
        paramh = paramh.Mn(2131301631);
        if (paramh != null)
        {
          paramh.setVisibility(8);
          AppMethodBeat.o(167689);
          return;
        }
        AppMethodBeat.o(167689);
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/Presenter$buildItemCoverts$1$getItemConvert$2", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedImageConvert;", "getLikeBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedImage;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class b
      extends com.tencent.mm.plugin.finder.convert.u
    {
      b(com.tencent.mm.plugin.finder.feed.i parami, boolean paramBoolean)
      {
        super(bool, 0, 4);
      }
      
      public final void a(h paramh, com.tencent.mm.plugin.finder.model.u paramu, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(167692);
        p.h(paramh, "holder");
        p.h(paramu, "item");
        super.a(paramh, paramu, paramInt1, paramInt2, paramBoolean, paramList);
        i.c(paramh, this.tAj);
        paramh = paramh.Mn(2131301631);
        if (paramh != null)
        {
          paramh.setVisibility(8);
          AppMethodBeat.o(167692);
          return;
        }
        AppMethodBeat.o(167692);
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/Presenter$buildItemCoverts$1$getItemConvert$3", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedTextCardConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedImage;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class c
      extends ai
    {
      c(com.tencent.mm.plugin.finder.feed.i parami, boolean paramBoolean)
      {
        super(bool, 0, 4);
      }
      
      public final void a(h paramh, com.tencent.mm.plugin.finder.model.u paramu, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(167695);
        p.h(paramh, "holder");
        p.h(paramu, "item");
        super.a(paramh, paramu, paramInt1, paramInt2, paramBoolean, paramList);
        i.c(paramh, this.tAj);
        AppMethodBeat.o(167695);
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/Presenter$buildItemCoverts$1$getItemConvert$4", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedMixConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedMix;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class d
      extends com.tencent.mm.plugin.finder.convert.aa
    {
      d(k paramk, com.tencent.mm.plugin.finder.feed.i parami, boolean paramBoolean)
      {
        super(paramBoolean, bool, 0, 8);
      }
      
      private void a(h paramh, com.tencent.mm.plugin.finder.model.aa paramaa, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(167698);
        p.h(paramh, "holder");
        p.h(paramaa, "item");
        super.a(paramh, (BaseFinderFeed)paramaa, paramInt1, paramInt2, paramBoolean, paramList);
        i.c(paramh, this.tAj);
        AppMethodBeat.o(167698);
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/Presenter$buildItemCoverts$1$getItemConvert$5", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedPlainTextConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedPlainText;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class e
      extends com.tencent.mm.plugin.finder.convert.ad
    {
      e(com.tencent.mm.plugin.finder.feed.i parami, boolean paramBoolean)
      {
        super(bool, 0, 4);
      }
      
      private void a(h paramh, ab paramab, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(167701);
        p.h(paramh, "holder");
        p.h(paramab, "item");
        super.a(paramh, (BaseFinderFeed)paramab, paramInt1, paramInt2, paramBoolean, paramList);
        i.c(paramh, this.tAj);
        AppMethodBeat.o(167701);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.i
 * JD-Core Version:    0.7.0.1
 */