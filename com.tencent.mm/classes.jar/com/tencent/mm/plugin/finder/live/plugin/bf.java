package com.tencent.mm.plugin.finder.live.plugin;

import android.graphics.Rect;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.live.view.FinderLiveShadeView;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.j;
import com.tencent.mm.plugin.finder.live.widget.aq;
import com.tencent.mm.plugin.finder.live.widget.as;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMicDecoratePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "shadeView", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShadeView;", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShadeView;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "widgetsMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicStateWidget;", "Lkotlin/collections/HashMap;", "canClearScreen", "", "canClearScreenWhenSideBarShow", "checkMuteState", "", "hideLinkMicBottomBar", "onMicUserChanged", "micUserMap", "Ljava/util/LinkedHashMap;", "Landroid/graphics/Rect;", "Lkotlin/collections/LinkedHashMap;", "isPkAnchor", "showLinkMicBottomBar", "updateVideoWidgetCover", "userId", "visibleInCurrentLiveMode", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bf
  extends b
{
  public static final bf.a Dft;
  private static final String TAG;
  private final FinderLiveShadeView Dfo;
  private final HashMap<String, as> Dfp;
  private final com.tencent.mm.live.b.b nfT;
  
  static
  {
    AppMethodBeat.i(355083);
    Dft = new bf.a((byte)0);
    TAG = "Finder.FinderLiveMicDecoratePlugin";
    AppMethodBeat.o(355083);
  }
  
  public bf(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb, FinderLiveShadeView paramFinderLiveShadeView, bui parambui)
  {
    super(paramViewGroup, paramb, parambui);
    AppMethodBeat.i(355053);
    this.nfT = paramb;
    this.Dfo = paramFinderLiveShadeView;
    this.Dfp = new HashMap();
    AppMethodBeat.o(355053);
  }
  
  public final void a(LinkedHashMap<String, Rect> paramLinkedHashMap, boolean paramBoolean)
  {
    AppMethodBeat.i(355142);
    s.u(paramLinkedHashMap, "micUserMap");
    Set localSet = paramLinkedHashMap.keySet();
    s.s(localSet, "micUserMap.keys");
    final boolean bool = p.a((Iterable)localSet, ((e)business(e.class)).eyF());
    Log.i(TAG, "onMicUserChanged: containsSelf:" + bool + ", widegtMap.size:" + this.Dfp.size() + ", audienceLinkMicUserList.size:" + ((j)business(j.class)).Efw.size() + ", micUserMap:" + paramLinkedHashMap + ", isPkAnchor:" + paramBoolean);
    d.uiThread((a)new c(paramLinkedHashMap, this, bool));
    AppMethodBeat.o(355142);
  }
  
  public final void awC(String paramString)
  {
    AppMethodBeat.i(355120);
    d.uiThread((a)new e(paramString, this));
    AppMethodBeat.o(355120);
  }
  
  public final boolean enH()
  {
    return false;
  }
  
  public final boolean eoI()
  {
    return false;
  }
  
  public final boolean eoJ()
  {
    return true;
  }
  
  public final void era()
  {
    AppMethodBeat.i(355092);
    d.uiThread((a)new d(this));
    AppMethodBeat.o(355092);
  }
  
  public final void erb()
  {
    AppMethodBeat.i(355100);
    d.uiThread((a)new b(this));
    AppMethodBeat.o(355100);
  }
  
  public final void erc()
  {
    AppMethodBeat.i(355110);
    Iterator localIterator = ((Map)this.Dfp).entrySet().iterator();
    label73:
    while (localIterator.hasNext())
    {
      Object localObject = ((Map.Entry)localIterator.next()).getValue();
      if ((localObject instanceof aq)) {}
      for (localObject = (aq)localObject;; localObject = null)
      {
        if (localObject == null) {
          break label73;
        }
        aq.a((aq)localObject);
        break;
      }
    }
    AppMethodBeat.o(355110);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<ah>
  {
    b(bf parambf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<ah>
  {
    c(LinkedHashMap<String, Rect> paramLinkedHashMap, bf parambf, boolean paramBoolean)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements a<ah>
  {
    d(bf parambf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements a<ah>
  {
    e(String paramString, bf parambf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.bf
 * JD-Core Version:    0.7.0.1
 */