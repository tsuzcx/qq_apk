package com.tencent.mm.plugin.finder.live.plugin;

import android.graphics.Rect;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.finder.live.view.FinderLiveShadeView;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.plugin.finder.live.viewmodel.data.h;
import com.tencent.mm.plugin.finder.live.widget.ac;
import com.tencent.mm.plugin.finder.live.widget.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import org.libpag.PAGView;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMicAudioPreviewPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "shadeView", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShadeView;", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShadeView;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "widgetsMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicStateWidget;", "Lkotlin/collections/HashMap;", "hideLinkMicBottomBar", "", "onMicUserChanged", "micUserMap", "Ljava/util/LinkedHashMap;", "Landroid/graphics/Rect;", "Lkotlin/collections/LinkedHashMap;", "isPkAnchor", "", "onNotifyMicUserVolume", "showLinkMicBottomBar", "Companion", "plugin-finder_release"})
public final class br
  extends d
{
  private static final String TAG = "Finder.FinderLiveMicAudioPreviewPlugin";
  public static final a yuU;
  private final b kCL;
  private final HashMap<String, ac> yuS;
  private final FinderLiveShadeView yuT;
  
  static
  {
    AppMethodBeat.i(272906);
    yuU = new a((byte)0);
    TAG = "Finder.FinderLiveMicAudioPreviewPlugin";
    AppMethodBeat.o(272906);
  }
  
  private br(ViewGroup paramViewGroup, b paramb, FinderLiveShadeView paramFinderLiveShadeView)
  {
    super(paramViewGroup, paramb, null);
    AppMethodBeat.i(272905);
    this.kCL = paramb;
    this.yuT = paramFinderLiveShadeView;
    this.yuS = new HashMap();
    AppMethodBeat.o(272905);
  }
  
  public final void a(final LinkedHashMap<String, Rect> paramLinkedHashMap, final boolean paramBoolean)
  {
    AppMethodBeat.i(272904);
    p.k(paramLinkedHashMap, "micUserMap");
    Log.i(TAG, "onMicUserChanged widegtMap.size:" + this.yuS.size() + " audienceLinkMicUserList.size:" + ((f)business(f.class)).zhm.size() + " micUserMap:" + paramLinkedHashMap);
    com.tencent.mm.ae.d.uiThread((a)new c(this, paramBoolean, paramLinkedHashMap));
    AppMethodBeat.o(272904);
  }
  
  public final void dCa()
  {
    AppMethodBeat.i(272900);
    com.tencent.mm.ae.d.uiThread((a)new d(this));
    AppMethodBeat.o(272900);
  }
  
  public final void dCb()
  {
    AppMethodBeat.i(272901);
    com.tencent.mm.ae.d.uiThread((a)new b(this));
    AppMethodBeat.o(272901);
  }
  
  public final void dCc()
  {
    AppMethodBeat.i(272903);
    Iterator localIterator1 = ((Map)this.yuS).entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Object localObject3 = (Map.Entry)localIterator1.next();
      if ((((Map.Entry)localObject3).getValue() instanceof z))
      {
        Object localObject1 = ((f)business(f.class)).zhm;
        p.j(localObject1, "business(LiveLinkMicSlic…).audienceLinkMicUserList");
        synchronized ((Iterable)localObject1)
        {
          Iterator localIterator2 = ((Iterable)???).iterator();
          for (;;)
          {
            if (localIterator2.hasNext())
            {
              localObject1 = localIterator2.next();
              bool = Util.isEqual(((h)localObject1).ktR, (String)((Map.Entry)localObject3).getKey());
              if (bool)
              {
                localObject1 = (h)localObject1;
                if (localObject1 == null) {
                  break;
                }
                ??? = ((Map.Entry)localObject3).getValue();
                if (??? != null) {
                  break label195;
                }
                localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.widget.FinderLiveMicAudioPreviewWidget");
                AppMethodBeat.o(272903);
                throw ((Throwable)localObject1);
              }
            }
          }
          localObject1 = null;
        }
        label195:
        ??? = (z)???;
        localObject3 = (String)((Map.Entry)localObject3).getKey();
        boolean bool = localObject2.zeI;
        if (((z)???).zpC != bool)
        {
          Log.i(((z)???).TAG, "sdkUserId:" + (String)localObject3 + " notTalking:" + bool);
          ((z)???).zpC = bool;
          if (bool)
          {
            ((z)???).ymH.stop();
            ((z)???).ymH.setVisibility(8);
          }
          else
          {
            ((z)???).ymH.setVisibility(0);
            ((z)???).ymH.play();
          }
        }
      }
    }
    AppMethodBeat.o(272903);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMicAudioPreviewPlugin$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<x>
  {
    b(br parambr)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<x>
  {
    c(br parambr, boolean paramBoolean, LinkedHashMap paramLinkedHashMap)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements a<x>
  {
    d(br parambr)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.br
 * JD-Core Version:    0.7.0.1
 */