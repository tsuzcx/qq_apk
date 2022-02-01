package com.tencent.mm.plugin.finder.live.plugin;

import android.graphics.Rect;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.live.view.FinderLiveShadeView;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.j;
import com.tencent.mm.plugin.finder.live.viewmodel.data.h;
import com.tencent.mm.plugin.finder.live.widget.ao;
import com.tencent.mm.plugin.finder.live.widget.as;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMicAudioPreviewPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "shadeView", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShadeView;", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShadeView;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "widgetsMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicStateWidget;", "Lkotlin/collections/HashMap;", "canClearScreenWhenSideBarShow", "", "hideLinkMicBottomBar", "", "onMicUserChanged", "micUserMap", "Ljava/util/LinkedHashMap;", "Landroid/graphics/Rect;", "Lkotlin/collections/LinkedHashMap;", "isPkAnchor", "onNotifyMicUserVolume", "showLinkMicBottomBar", "visibleInCurrentLiveMode", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class be
  extends b
{
  public static final be.a Dfn;
  private static final String TAG;
  private final FinderLiveShadeView Dfo;
  private final HashMap<String, as> Dfp;
  private final com.tencent.mm.live.b.b nfT;
  
  static
  {
    AppMethodBeat.i(355041);
    Dfn = new be.a((byte)0);
    TAG = "Finder.FinderLiveMicAudioPreviewPlugin";
    AppMethodBeat.o(355041);
  }
  
  private be(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb, FinderLiveShadeView paramFinderLiveShadeView)
  {
    super(paramViewGroup, paramb, null);
    AppMethodBeat.i(355014);
    this.nfT = paramb;
    this.Dfo = paramFinderLiveShadeView;
    this.Dfp = new HashMap();
    AppMethodBeat.o(355014);
  }
  
  public final void a(final LinkedHashMap<String, Rect> paramLinkedHashMap, boolean paramBoolean)
  {
    AppMethodBeat.i(355076);
    s.u(paramLinkedHashMap, "micUserMap");
    Set localSet = paramLinkedHashMap.keySet();
    s.s(localSet, "micUserMap.keys");
    final boolean bool = p.a((Iterable)localSet, ((e)business(e.class)).eyF());
    Log.i(TAG, "onMicUserChanged: containsSelf:" + bool + ", widegtMap.size:" + this.Dfp.size() + ", audienceLinkMicUserList.size:" + ((j)business(j.class)).Efw.size() + ", micUserMap:" + paramLinkedHashMap + ", isPkAnchor:" + paramBoolean);
    d.uiThread((a)new c(this, paramLinkedHashMap, bool));
    AppMethodBeat.o(355076);
  }
  
  public final void emv()
  {
    AppMethodBeat.i(355064);
    Iterator localIterator1 = ((Map)this.Dfp).entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      if ((localEntry.getValue() instanceof ao))
      {
        Object localObject1 = ((j)business(j.class)).Efw;
        s.s(localObject1, "business(LiveLinkMicSlic…).audienceLinkMicUserList");
        synchronized ((Iterable)localObject1)
        {
          Iterator localIterator2 = ???.iterator();
          for (;;)
          {
            if (localIterator2.hasNext())
            {
              localObject1 = localIterator2.next();
              boolean bool = Util.isEqual(((h)localObject1).mXL, (String)localEntry.getKey());
              if (bool)
              {
                localObject1 = (h)localObject1;
                if (localObject1 == null) {
                  break;
                }
                ((ao)localEntry.getValue()).bG((String)localEntry.getKey(), ((h)localObject1).EbG);
                break;
              }
            }
          }
          localObject1 = null;
        }
      }
    }
    AppMethodBeat.o(355064);
  }
  
  public final boolean enH()
  {
    return false;
  }
  
  public final boolean eoJ()
  {
    return true;
  }
  
  public final void era()
  {
    AppMethodBeat.i(355046);
    d.uiThread((a)new d(this));
    AppMethodBeat.o(355046);
  }
  
  public final void erb()
  {
    AppMethodBeat.i(355054);
    d.uiThread((a)new b(this));
    AppMethodBeat.o(355054);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<ah>
  {
    b(be parambe)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<ah>
  {
    c(be parambe, LinkedHashMap<String, Rect> paramLinkedHashMap, boolean paramBoolean)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements a<ah>
  {
    d(be parambe)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.be
 * JD-Core Version:    0.7.0.1
 */