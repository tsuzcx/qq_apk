package com.tencent.mm.plugin.finder.live.plugin;

import android.graphics.Rect;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.finder.live.view.FinderLiveShadeView;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.plugin.finder.live.widget.ac;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMicDecoratePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "shadeView", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShadeView;", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShadeView;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "widgetsMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicStateWidget;", "Lkotlin/collections/HashMap;", "canClearScreen", "", "hideLinkMicBottomBar", "", "onMicUserChanged", "micUserMap", "Ljava/util/LinkedHashMap;", "Landroid/graphics/Rect;", "Lkotlin/collections/LinkedHashMap;", "isPkAnchor", "showLinkMicBottomBar", "updateVideoWidgetCover", "userId", "Companion", "plugin-finder_release"})
public final class bs
  extends d
{
  private static final String TAG = "Finder.FinderLiveMicDecoratePlugin";
  public static final a yuY;
  private final b kCL;
  private final HashMap<String, ac> yuS;
  private final FinderLiveShadeView yuT;
  
  static
  {
    AppMethodBeat.i(290836);
    yuY = new a((byte)0);
    TAG = "Finder.FinderLiveMicDecoratePlugin";
    AppMethodBeat.o(290836);
  }
  
  public bs(ViewGroup paramViewGroup, b paramb, FinderLiveShadeView paramFinderLiveShadeView, bid parambid)
  {
    super(paramViewGroup, paramb, parambid);
    AppMethodBeat.i(290835);
    this.kCL = paramb;
    this.yuT = paramFinderLiveShadeView;
    this.yuS = new HashMap();
    AppMethodBeat.o(290835);
  }
  
  public final void a(final LinkedHashMap<String, Rect> paramLinkedHashMap, final boolean paramBoolean)
  {
    AppMethodBeat.i(290834);
    p.k(paramLinkedHashMap, "micUserMap");
    Log.i(TAG, "onMicUserChanged widegtMap.size:" + this.yuS.size() + " audienceLinkMicUserList.size:" + ((f)business(f.class)).zhm.size() + " micUserMap:" + paramLinkedHashMap);
    com.tencent.mm.ae.d.uiThread((a)new c(this, paramBoolean, paramLinkedHashMap));
    AppMethodBeat.o(290834);
  }
  
  public final void aCt(final String paramString)
  {
    AppMethodBeat.i(290833);
    com.tencent.mm.ae.d.uiThread((a)new e(this, paramString));
    AppMethodBeat.o(290833);
  }
  
  public final boolean dAo()
  {
    return false;
  }
  
  public final void dCa()
  {
    AppMethodBeat.i(290831);
    com.tencent.mm.ae.d.uiThread((a)new d(this));
    AppMethodBeat.o(290831);
  }
  
  public final void dCb()
  {
    AppMethodBeat.i(290832);
    com.tencent.mm.ae.d.uiThread((a)new b(this));
    AppMethodBeat.o(290832);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMicDecoratePlugin$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<x>
  {
    b(bs parambs)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<x>
  {
    c(bs parambs, boolean paramBoolean, LinkedHashMap paramLinkedHashMap)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements a<x>
  {
    d(bs parambs)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements a<x>
  {
    e(bs parambs, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.bs
 * JD-Core Version:    0.7.0.1
 */