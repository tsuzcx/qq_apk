package com.tencent.mm.plugin.finder.preload;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.cp.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.bd;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.a.bq;
import com.tencent.mm.plugin.findersdk.a.bq.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.dne;
import com.tencent.mm.protocal.protobuf.dnj;
import com.tencent.mm.protocal.protobuf.dno;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/preload/FinderShareInfoService;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderShareInfoService;", "()V", "getDetail", "", "objectId", "", "nonceId", "", "commentScene", "", "reportContextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "username", "context", "Landroid/content/Context;", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderShareInfoService$ResultCallback;", "getMegaVideoDetail", "hasExtStatusFlag", "", "flag", "isBizToTimeline", "isShareToTimeline", "isShowFinderEntrance", "preloadShareFeed", "isMegaVideo", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements bq
{
  private static final ah a(c paramc, int paramInt, long paramLong, bq.a parama, b.a parama1)
  {
    long l2 = 0L;
    AppMethodBeat.i(346258);
    s.u(paramc, "$finderSharePreloadCore");
    if ((parama1.errType == 0) && (parama1.errCode == 0))
    {
      Object localObject = ((dnj)parama1.ott).ZXx;
      long l1;
      if (localObject == null)
      {
        l1 = 0L;
        if (l1 == 0L) {
          break label241;
        }
        localObject = ((dnj)parama1.ott).ZXx;
        if (localObject != null) {
          break label152;
        }
        l1 = l2;
        label80:
        parama1 = ((dnj)parama1.ott).ZXx;
        if (parama1 != null) {
          break label178;
        }
        parama1 = "";
      }
      for (;;)
      {
        paramc.a(l1, paramInt, paramLong, true, 1);
        if (parama != null) {
          break label219;
        }
        AppMethodBeat.o(346258);
        return null;
        localObject = ((dne)localObject).aaUv;
        if (localObject == null)
        {
          l1 = 0L;
          break;
        }
        l1 = ((dno)localObject).hKN;
        break;
        label152:
        localObject = ((dne)localObject).aaUv;
        l1 = l2;
        if (localObject == null) {
          break label80;
        }
        l1 = ((dno)localObject).hKN;
        break label80;
        label178:
        parama1 = parama1.aaUv;
        if (parama1 == null)
        {
          parama1 = "";
        }
        else
        {
          parama1 = parama1.objectNonceId;
          if (parama1 == null) {
            parama1 = "";
          }
        }
      }
      label219:
      parama.onFinish(l1, parama1);
      paramc = ah.aiuX;
      AppMethodBeat.o(346258);
      return paramc;
    }
    label241:
    paramc.a(0L, paramInt, paramLong, true, 1);
    paramc = ah.aiuX;
    AppMethodBeat.o(346258);
    return paramc;
  }
  
  private static void b(long paramLong, String paramString1, bui parambui, String paramString2, Context paramContext, bq.a parama)
  {
    AppMethodBeat.i(346241);
    Object localObject = k.aeZF;
    localObject = k.cn(PluginFinder.class).q(c.class);
    s.s(localObject, "UICProvider.of(PluginFin…ePreloadCore::class.java)");
    localObject = (c)localObject;
    if ((!((c)localObject).o(paramLong, 4, 1)) && (paramContext != null))
    {
      ((c)localObject).p(paramLong, 4, 1);
      if (paramString2 != null) {
        break label119;
      }
      paramString2 = "";
    }
    label119:
    for (;;)
    {
      com.tencent.mm.plugin.findersdk.b.c.a((com.tencent.mm.plugin.findersdk.b.c)new bd(paramLong, paramString2, paramString1, 4, parambui), paramContext, 0L, 6).bFJ().b(new b..ExternalSyntheticLambda0((c)localObject, 4, paramLong, parama));
      AppMethodBeat.o(346241);
      return;
    }
  }
  
  private static boolean eHF()
  {
    AppMethodBeat.i(346248);
    if ((z.bAR() & 0x0) != 0L)
    {
      AppMethodBeat.o(346248);
      return true;
    }
    AppMethodBeat.o(346248);
    return false;
  }
  
  public final void a(long paramLong, String paramString1, int paramInt, bui parambui, Context paramContext, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(346273);
    Object localObject1;
    Object localObject2;
    if ((ecY()) && (bZX()))
    {
      localObject1 = k.aeZF;
      localObject1 = k.cn(PluginFinder.class).q(c.class);
      s.s(localObject1, "UICProvider.of(PluginFin…ePreloadCore::class.java)");
      localObject1 = (c)localObject1;
      localObject2 = e.FMN;
      localObject2 = e.a.jn(paramLong);
      if ((parambui != null) || (paramContext == null)) {
        break label283;
      }
      parambui = as.GSQ;
      parambui = as.a.hu(paramContext);
      if (parambui != null) {
        break label204;
      }
      parambui = null;
    }
    label138:
    label280:
    label283:
    for (;;)
    {
      if (localObject2 != null)
      {
        if ((((FinderItem)localObject2).getTimestamps() <= 0L) || (com.tencent.mm.model.cn.bDw() < ((FinderItem)localObject2).getTimestamps() + ((FinderItem)localObject2).getFeedObject().urlValidDuration * 1000L)) {
          c.a(paramLong, (FinderItem)localObject2);
        }
      }
      else if ((localObject2 == null) && (c.eHG()) && (!((c)localObject1).o(paramLong, paramInt, 4)))
      {
        ((c)localObject1).p(paramLong, paramInt, 4);
        c.pp(paramLong);
        if (paramString1 != null) {
          break label280;
        }
        paramString1 = "";
      }
      for (;;)
      {
        ((c)localObject1).a(paramLong, paramString1, paramInt, parambui, paramBoolean, paramString2, null, 4);
        AppMethodBeat.o(346273);
        return;
        label204:
        parambui = parambui.fou();
        break;
        if ((!c.eHG()) || (((c)localObject1).o(paramLong, paramInt, 4))) {
          break label138;
        }
        ((c)localObject1).p(paramLong, paramInt, 4);
        c.pp(paramLong);
        if (paramString1 == null) {}
        for (paramContext = "";; paramContext = paramString1)
        {
          ((c)localObject1).a(paramLong, paramContext, paramInt, parambui, paramBoolean, paramString2, null, 4);
          break;
        }
      }
    }
  }
  
  public final void a(long paramLong, String paramString1, bui parambui, String paramString2, Context paramContext, bq.a parama)
  {
    AppMethodBeat.i(346278);
    Object localObject1 = k.aeZF;
    s.s(k.cn(PluginFinder.class).q(c.class), "UICProvider.of(PluginFin…ePreloadCore::class.java)");
    Object localObject2 = c.po(paramLong);
    if (localObject2 == null)
    {
      localObject1 = null;
      if (localObject1 == null)
      {
        if (paramString1 != null) {
          break label241;
        }
        paramString1 = "";
      }
    }
    label87:
    label102:
    label241:
    for (;;)
    {
      b(paramLong, paramString1, parambui, paramString2, paramContext, parama);
      AppMethodBeat.o(346278);
      return;
      localObject1 = ((FinderItem)localObject2).getMegaVideo();
      int i;
      if (localObject1 == null)
      {
        localObject1 = null;
        localObject2 = ((FinderItem)localObject2).getMegaVideo();
        if (localObject2 != null) {
          break label167;
        }
        localObject2 = null;
        if ((localObject1 == null) || (((Long)localObject1).longValue() == 0L) || (localObject2 == null)) {
          break label205;
        }
        if (((CharSequence)localObject2).length() <= 0) {
          break label177;
        }
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          if (parama == null)
          {
            localObject1 = null;
            break;
            localObject1 = Long.valueOf(((dne)localObject1).id);
            break label87;
            localObject2 = ((dne)localObject2).aahV;
            break label102;
            i = 0;
            continue;
          }
          parama.onFinish(((Long)localObject1).longValue(), (String)localObject2);
          localObject1 = ah.aiuX;
          break;
        }
      }
      if (paramString1 == null) {}
      for (localObject1 = "";; localObject1 = paramString1)
      {
        b(paramLong, (String)localObject1, parambui, paramString2, paramContext, parama);
        localObject1 = ah.aiuX;
        break;
      }
    }
  }
  
  public final boolean bZX()
  {
    AppMethodBeat.i(346284);
    boolean bool1 = ((com.tencent.mm.plugin.findersdk.a.cn)h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).showFinderEntry();
    if (!eHF()) {}
    for (int i = 1;; i = 0)
    {
      boolean bool2 = ((com.tencent.mm.plugin.teenmode.a.d)h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu();
      if ((!bool1) || (i == 0) || (bool2)) {
        break;
      }
      AppMethodBeat.o(346284);
      return true;
    }
    AppMethodBeat.o(346284);
    return false;
  }
  
  public final boolean eHE()
  {
    AppMethodBeat.i(346295);
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eYD().bmg()).intValue() == 1)
    {
      AppMethodBeat.o(346295);
      return true;
    }
    AppMethodBeat.o(346295);
    return false;
  }
  
  public final boolean ecY()
  {
    AppMethodBeat.i(346290);
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eYt().bmg()).intValue() == 1)
    {
      AppMethodBeat.o(346290);
      return true;
    }
    AppMethodBeat.o(346290);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.b
 * JD-Core Version:    0.7.0.1
 */