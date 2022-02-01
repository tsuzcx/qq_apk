package com.tencent.mm.plugin.finder.viewmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bvq;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderGuideConfigVM;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "()V", "configList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderSlideUpGuideConfig;", "getConfig", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderGuideConfigVM$Config;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "toConfig", "server", "updateConfig", "", "configs", "Companion", "Config", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends com.tencent.mm.ui.component.n<PluginFinder>
{
  public static final a GKe;
  private final LinkedList<bvq> obH;
  
  static
  {
    AppMethodBeat.i(337225);
    GKe = new a((byte)0);
    AppMethodBeat.o(337225);
  }
  
  public c()
  {
    AppMethodBeat.i(337218);
    this.obH = new LinkedList();
    AppMethodBeat.o(337218);
  }
  
  public final void bj(LinkedList<bvq> paramLinkedList)
  {
    AppMethodBeat.i(337258);
    s.u(paramLinkedList, "configs");
    Object localObject = (Iterable)paramLinkedList;
    Collection localCollection = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      bvq localbvq = (bvq)((Iterator)localObject).next();
      localCollection.add(localbvq.type + ',' + localbvq.aadu + ',' + localbvq.aadx + ',' + localbvq.aady + ',' + localbvq.aadv + ',' + localbvq.aadz + ',' + localbvq.aadw + ',' + localbvq.aadA);
    }
    Log.i("Finder.GuideConfigVM", s.X("[updateConfig] ", (List)localCollection));
    this.obH.clear();
    this.obH.addAll((Collection)paramLinkedList);
    AppMethodBeat.o(337258);
  }
  
  public final b j(bui parambui)
  {
    AppMethodBeat.i(337243);
    s.u(parambui, "contextObj");
    Log.i("Finder.GuideConfigVM", s.X("[getConfig] contextId=", parambui.zIO));
    Object localObject = parambui.zIO;
    int i;
    if ((localObject != null) && (kotlin.n.n.U((String)localObject, "34-", false) == true))
    {
      i = 1;
      if (i == 0) {
        break label136;
      }
      localObject = ((Iterable)this.obH).iterator();
      label64:
      if (!((Iterator)localObject).hasNext()) {
        break label131;
      }
      parambui = ((Iterator)localObject).next();
      if (((bvq)parambui).type != 1) {
        break label126;
      }
      i = 1;
      label93:
      if (i == 0) {
        break label129;
      }
    }
    for (;;)
    {
      parambui = (bvq)parambui;
      localObject = new b();
      if (parambui != null) {
        break label295;
      }
      AppMethodBeat.o(337243);
      return localObject;
      i = 0;
      break;
      label126:
      i = 0;
      break label93;
      label129:
      break label64;
      label131:
      parambui = null;
    }
    label136:
    parambui = parambui.zIO;
    if ((parambui != null) && (kotlin.n.n.U(parambui, "29-", false) == true))
    {
      i = 1;
      label158:
      if (i == 0) {
        break label231;
      }
      localObject = ((Iterable)this.obH).iterator();
      label175:
      if (!((Iterator)localObject).hasNext()) {
        break label226;
      }
      parambui = ((Iterator)localObject).next();
      if (((bvq)parambui).type != 2) {
        break label221;
      }
      i = 1;
      label204:
      if (i == 0) {
        break label224;
      }
    }
    for (;;)
    {
      parambui = (bvq)parambui;
      break;
      i = 0;
      break label158;
      label221:
      i = 0;
      break label204;
      label224:
      break label175;
      label226:
      parambui = null;
    }
    label231:
    localObject = ((Iterable)this.obH).iterator();
    label244:
    if (((Iterator)localObject).hasNext())
    {
      parambui = ((Iterator)localObject).next();
      if (((bvq)parambui).type == 3)
      {
        i = 1;
        if (i == 0) {
          break label288;
        }
      }
    }
    for (;;)
    {
      label273:
      parambui = (bvq)parambui;
      break;
      i = 0;
      break label273;
      label288:
      break label244;
      parambui = null;
    }
    label295:
    ((b)localObject).scene = parambui.type;
    ((b)localObject).phI = parambui.aadu;
    ((b)localObject).GKf = parambui.aadx;
    ((b)localObject).GKg = parambui.aady;
    ((b)localObject).GKh = parambui.aadv;
    ((b)localObject).GKi = parambui.aadz;
    ((b)localObject).GKj = parambui.aadw;
    ((b)localObject).wDI = parambui.aadA;
    AppMethodBeat.o(337243);
    return localObject;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderGuideConfigVM$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderGuideConfigVM$Config;", "", "()V", "countStyle", "", "getCountStyle", "()I", "setCountStyle", "(I)V", "dismissAfterSeconds", "getDismissAfterSeconds", "setDismissAfterSeconds", "dismissStyle", "getDismissStyle", "setDismissStyle", "scene", "getScene", "setScene", "showAfterPercent", "getShowAfterPercent", "setShowAfterPercent", "showAfterSeconds", "getShowAfterSeconds", "setShowAfterSeconds", "showCount", "getShowCount", "setShowCount", "showStyle", "getShowStyle", "setShowStyle", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public int GKf;
    public int GKg;
    public int GKh;
    public int GKi;
    public int GKj;
    public int phI;
    public int scene;
    public int wDI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.c
 * JD-Core Version:    0.7.0.1
 */