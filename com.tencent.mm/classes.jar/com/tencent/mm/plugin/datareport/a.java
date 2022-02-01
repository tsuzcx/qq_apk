package com.tencent.mm.plugin.datareport;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.datareport.a.b.a.a;
import com.tencent.mm.plugin.datareport.c.d;
import com.tencent.mm.plugin.datareport.sample.KtSampleUI;
import com.tencent.mm.plugin.datareport.sample.SampleUI;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.commons.c.i;

public class a
  implements com.tencent.mm.plugin.datareport.a.b
{
  private static volatile a xgh;
  List<com.tencent.mm.plugin.datareport.a.a> cQ;
  private final Boolean xfY;
  private Boolean xfZ;
  com.tencent.mm.plugin.datareport.c.a xga;
  private Map<String, Object> xgb;
  private Map<String, Object> xgc;
  public Map<String, List<com.tencent.mm.plugin.datareport.a.b.b>> xgd;
  public d xge;
  private int xgf;
  private Map<String, Integer> xgg;
  
  private a()
  {
    AppMethodBeat.i(262822);
    this.xfY = Boolean.TRUE;
    this.xfZ = null;
    this.xgb = new HashMap();
    this.xgc = new HashMap();
    this.xgd = new ConcurrentHashMap();
    this.cQ = new ArrayList();
    this.xge = new d();
    this.xgf = 0;
    this.xgg = new HashMap();
    AppMethodBeat.o(262822);
  }
  
  private static com.tencent.mm.plugin.datareport.f.a C(String paramString, Object paramObject)
  {
    AppMethodBeat.i(262908);
    if ((i.hm(paramString)) || (paramObject == null))
    {
      AppMethodBeat.o(262908);
      return null;
    }
    int i = eC(paramObject);
    if (i <= 0)
    {
      AppMethodBeat.o(262908);
      return null;
    }
    com.tencent.mm.plugin.datareport.f.a locala = new com.tencent.mm.plugin.datareport.f.a();
    locala.cui = String.valueOf(i);
    com.tencent.mm.plugin.datareport.d.a.a locala1 = com.tencent.mm.plugin.datareport.d.a.g(paramObject, false);
    Object localObject;
    if (locala1 != null)
    {
      if (locala1.hJW != null) {
        break label312;
      }
      localObject = "";
      locala.putParam("page_name", localObject);
      if (locala1.xhb != null) {
        break label321;
      }
      localObject = "";
      label99:
      locala.putParam("page_content_id", localObject);
      locala.putParam("page_stp", Integer.valueOf(locala1.xhh));
      if ((locala1.xhc != null) && (locala1.xhc.size() > 0)) {
        locala.ae(locala1.xhc);
      }
    }
    paramString = com.tencent.mm.plugin.datareport.d.a.l(paramObject, paramString);
    if ((paramString != null) && (paramString.size() > 0)) {
      locala.ae(paramString);
    }
    paramObject = com.tencent.mm.plugin.datareport.d.a.eP(paramObject);
    if (paramObject != null)
    {
      localObject = new HashMap();
      ((Map)localObject).put("page_id", Integer.valueOf(paramObject.tBy));
      if (paramObject.hJW != null) {
        break label330;
      }
      paramString = "";
      label221:
      ((Map)localObject).put("page_name", paramString);
      if (paramObject.xhb != null) {
        break label338;
      }
    }
    label312:
    label321:
    label330:
    label338:
    for (paramString = "";; paramString = paramObject.xhb)
    {
      ((Map)localObject).put("page_content_id", paramString);
      ((Map)localObject).put("page_stp", Integer.valueOf(paramObject.xhh));
      if ((paramObject.xhc != null) && (paramObject.xhc.size() > 0)) {
        ((Map)localObject).putAll(paramObject.xhc);
      }
      locala.putParam("ref_page", localObject);
      AppMethodBeat.o(262908);
      return locala;
      localObject = locala1.hJW;
      break;
      localObject = locala1.xhb;
      break label99;
      paramString = paramObject.hJW;
      break label221;
    }
  }
  
  private static List<com.tencent.mm.plugin.datareport.f.a> a(String paramString, com.tencent.mm.plugin.datareport.b.a parama)
  {
    AppMethodBeat.i(262894);
    if ((i.hm(paramString)) || (parama == null))
    {
      AppMethodBeat.o(262894);
      return null;
    }
    parama = parama.iterator();
    if (parama == null)
    {
      AppMethodBeat.o(262894);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    while (parama.hasNext())
    {
      Object localObject1 = (com.tencent.mm.plugin.datareport.d.a.b)parama.next();
      if (localObject1 != null)
      {
        Object localObject2 = com.tencent.mm.plugin.datareport.d.c.b.c((com.tencent.mm.plugin.datareport.d.a.b)localObject1);
        if (!i.hm((String)localObject2))
        {
          com.tencent.mm.plugin.datareport.f.a locala = new com.tencent.mm.plugin.datareport.f.a();
          locala.cui = ((String)localObject2);
          localObject2 = com.tencent.mm.plugin.datareport.d.c.b.d((com.tencent.mm.plugin.datareport.d.a.b)localObject1);
          if ((localObject2 != null) && (((Map)localObject2).size() > 0)) {
            locala.ae((Map)localObject2);
          }
          localObject1 = com.tencent.mm.plugin.datareport.d.c.b.a(paramString, (com.tencent.mm.plugin.datareport.d.a.b)localObject1);
          if ((localObject1 != null) && (((Map)localObject1).size() > 0)) {
            locala.ae((Map)localObject1);
          }
          localArrayList.add(locala);
        }
      }
    }
    AppMethodBeat.o(262894);
    return localArrayList;
  }
  
  private void a(long paramLong, Object paramObject, com.tencent.mm.plugin.datareport.f.b paramb)
  {
    AppMethodBeat.i(262917);
    ??? = new HashMap();
    Object localObject2 = dtn().dtp();
    if ((localObject2 != null) && (((Map)localObject2).size() > 0)) {
      ((Map)???).putAll((Map)localObject2);
    }
    localObject2 = dtn().dtr();
    if ((localObject2 != null) && (((Map)localObject2).size() > 0)) {
      ((Map)???).putAll((Map)localObject2);
    }
    localObject2 = this.xga.xgS;
    if (localObject2 != null)
    {
      ((com.tencent.mm.plugin.datareport.a.c.b)localObject2).ad((Map)???);
      ((com.tencent.mm.plugin.datareport.a.c.b)localObject2).amw(paramb.eventId);
    }
    s(paramb.eventId, (Map)???);
    localObject2 = this.xga.xgT;
    if (localObject2 != null)
    {
      localObject2 = ((com.tencent.mm.plugin.datareport.e.b)localObject2).a(paramb.eventId, (Map)???, paramb.params);
      if ((localObject2 != null) && (((Map)localObject2).size() > 0)) {
        synchronized (this.cQ)
        {
          Iterator localIterator = this.cQ.iterator();
          com.tencent.mm.plugin.datareport.a.a locala;
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            locala = (com.tencent.mm.plugin.datareport.a.a)localIterator.next();
          } while ((locala == null) || (!locala.a(paramLong, paramObject, paramb.eventId, (Map)localObject2)));
          AppMethodBeat.o(262917);
          return;
        }
      }
    }
    AppMethodBeat.o(262917);
  }
  
  private void a(com.tencent.mm.plugin.datareport.a.b.a parama)
  {
    AppMethodBeat.i(262869);
    if ((parama == null) || (i.hm(parama.xgD)) || (!dto()))
    {
      AppMethodBeat.o(262869);
      return;
    }
    long l = System.currentTimeMillis();
    Object localObject1 = parama.xgF;
    int i;
    Object localObject2;
    com.tencent.mm.plugin.datareport.a.b.b localb1;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      Iterator localIterator = ((List)localObject1).iterator();
      while (localIterator.hasNext())
      {
        i = ((Integer)localIterator.next()).intValue();
        localObject2 = parama.xgD;
        if ((dto()) && (dto()) && (!i.hm((String)localObject2)))
        {
          localb1 = new com.tencent.mm.plugin.datareport.a.b.b();
          localb1.eventId = ((String)localObject2);
          localb1.xgH = i;
          localb1.xgI = false;
          localObject1 = (List)this.xgd.get(localObject2);
          if (localObject1 != null) {
            break label357;
          }
          localObject1 = new CopyOnWriteArrayList();
          this.xgd.put(localObject2, localObject1);
        }
      }
    }
    label355:
    label357:
    for (;;)
    {
      localObject2 = ((List)localObject1).iterator();
      com.tencent.mm.plugin.datareport.a.b.b localb2;
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localb2 = (com.tencent.mm.plugin.datareport.a.b.b)((Iterator)localObject2).next();
      } while ((localb2.xgH != i) || (localb2.xgI));
      for (i = 0;; i = 1)
      {
        if (i == 0) {
          break label355;
        }
        ((List)localObject1).add(localb1);
        break;
        if (parama.mTarget == null)
        {
          localObject1 = new com.tencent.mm.plugin.datareport.f.b();
          ((com.tencent.mm.plugin.datareport.f.b)localObject1).eventId = parama.xgD;
          ((com.tencent.mm.plugin.datareport.f.b)localObject1).ae(parama.xgE);
          a(l, null, (com.tencent.mm.plugin.datareport.f.b)localObject1);
        }
        if ((parama.mTarget instanceof View)) {
          c(l, parama);
        }
        if (eF(parama.mTarget)) {
          b(l, parama);
        }
        t(parama.xgD, parama.xgF);
        AppMethodBeat.o(262869);
        return;
      }
      break;
    }
  }
  
  private static boolean a(Object paramObject, int paramInt, String paramString)
  {
    AppMethodBeat.i(262944);
    if ((paramObject == null) || (!eF(paramObject)))
    {
      AppMethodBeat.o(262944);
      return true;
    }
    if ((paramInt & 0x1) != 0)
    {
      AppMethodBeat.o(262944);
      return true;
    }
    if ((paramInt & 0x2) != 0)
    {
      AppMethodBeat.o(262944);
      return false;
    }
    if ((com.tencent.mm.plugin.datareport.j.b.amy(paramString) & paramInt) != 0)
    {
      AppMethodBeat.o(262944);
      return false;
    }
    AppMethodBeat.o(262944);
    return true;
  }
  
  private boolean amv(String paramString)
  {
    AppMethodBeat.i(262937);
    if (i.hm(paramString))
    {
      AppMethodBeat.o(262937);
      return true;
    }
    paramString = (List)this.xgd.get(paramString);
    if ((paramString != null) && (paramString.size() > 0))
    {
      AppMethodBeat.o(262937);
      return false;
    }
    AppMethodBeat.o(262937);
    return true;
  }
  
  private void b(long paramLong, com.tencent.mm.plugin.datareport.a.b.a parama)
  {
    AppMethodBeat.i(262877);
    if ((parama == null) || (i.hm(parama.xgD)))
    {
      AppMethodBeat.o(262877);
      return;
    }
    if (com.tencent.mm.plugin.datareport.d.a.eC(parama.mTarget) <= 0)
    {
      AppMethodBeat.o(262877);
      return;
    }
    com.tencent.mm.plugin.datareport.f.b localb = new com.tencent.mm.plugin.datareport.f.b();
    localb.eventId = parama.xgD;
    if ((this.xga != null) && (this.xga.xgT != null))
    {
      Object localObject = C(parama.xgD, parama.mTarget);
      localObject = this.xga.xgT.a((com.tencent.mm.plugin.datareport.f.a)localObject, parama.xgE);
      if ((localObject != null) && (((Map)localObject).size() > 0)) {
        localb.ae((Map)localObject);
      }
    }
    a(paramLong, parama.mTarget, localb);
    AppMethodBeat.o(262877);
  }
  
  private static boolean b(Object paramObject, int paramInt, String paramString)
  {
    AppMethodBeat.i(262956);
    if ((paramObject == null) || (!(paramObject instanceof View)))
    {
      AppMethodBeat.o(262956);
      return true;
    }
    if ((paramInt & 0x1) != 0)
    {
      AppMethodBeat.o(262956);
      return true;
    }
    if ((paramInt & 0x2) != 0)
    {
      AppMethodBeat.o(262956);
      return false;
    }
    if ((paramInt & 0x4) != 0)
    {
      if (com.tencent.mm.plugin.datareport.d.a.k(paramObject, "view_clk_count") > 0)
      {
        AppMethodBeat.o(262956);
        return true;
      }
    }
    else if ((paramInt & 0x10) != 0)
    {
      if (com.tencent.mm.plugin.datareport.d.a.k(paramObject, "view_unexp_policy") > 0)
      {
        AppMethodBeat.o(262956);
        return true;
      }
    }
    else if (((paramInt & 0x40) != 0) && (com.tencent.mm.plugin.datareport.d.a.k(paramObject, "view_clk_count") > 0))
    {
      AppMethodBeat.o(262956);
      return true;
    }
    if ((com.tencent.mm.plugin.datareport.j.b.amz(paramString) & paramInt) != 0)
    {
      AppMethodBeat.o(262956);
      return false;
    }
    AppMethodBeat.o(262956);
    return true;
  }
  
  private void c(long paramLong, com.tencent.mm.plugin.datareport.a.b.a parama)
  {
    AppMethodBeat.i(262886);
    if ((parama == null) || (i.hm(parama.xgD)))
    {
      AppMethodBeat.o(262886);
      return;
    }
    if (i.hm(com.tencent.mm.plugin.datareport.d.a.eK(parama.mTarget)))
    {
      AppMethodBeat.o(262886);
      return;
    }
    Object localObject2 = com.tencent.mm.plugin.datareport.b.b.eH(parama.mTarget);
    if (localObject2 == null)
    {
      AppMethodBeat.o(262886);
      return;
    }
    com.tencent.mm.plugin.datareport.f.b localb = new com.tencent.mm.plugin.datareport.f.b();
    localb.eventId = parama.xgD;
    if ((this.xga != null) && (this.xga.xgT != null))
    {
      Object localObject1 = a(parama.xgD, (com.tencent.mm.plugin.datareport.b.a)localObject2);
      localObject2 = C(parama.xgD, ((com.tencent.mm.plugin.datareport.b.a)localObject2).xgJ);
      localObject1 = this.xga.xgT.a((List)localObject1, (com.tencent.mm.plugin.datareport.f.a)localObject2, parama.xgE);
      if ((localObject1 != null) && (((Map)localObject1).size() > 0)) {
        localb.ae((Map)localObject1);
      }
    }
    a(paramLong, parama.mTarget, localb);
    AppMethodBeat.o(262886);
  }
  
  public static a dtn()
  {
    AppMethodBeat.i(262830);
    if (xgh == null) {}
    try
    {
      if (xgh == null) {
        xgh = new a();
      }
      a locala = xgh;
      AppMethodBeat.o(262830);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(262830);
    }
  }
  
  private Map<String, Object> dtp()
  {
    AppMethodBeat.i(262836);
    HashMap localHashMap = new HashMap();
    synchronized (this.xgb)
    {
      Iterator localIterator = this.xgb.keySet().iterator();
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localHashMap.put(str, this.xgb.get(str));
      }
    }
    AppMethodBeat.o(262836);
    return localMap1;
  }
  
  private Map<String, Object> dtr()
  {
    AppMethodBeat.i(262844);
    HashMap localHashMap = new HashMap();
    synchronized (this.xgc)
    {
      Iterator localIterator = this.xgc.keySet().iterator();
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localHashMap.put(str, this.xgc.get(str));
      }
    }
    AppMethodBeat.o(262844);
    return localMap1;
  }
  
  private static int eC(Object paramObject)
  {
    AppMethodBeat.i(262851);
    if (paramObject == null)
    {
      AppMethodBeat.o(262851);
      return 0;
    }
    if (!eF(paramObject))
    {
      Log.e("DataReportService", "[getPageId] target is not a page!!!");
      AppMethodBeat.o(262851);
      return 0;
    }
    int i = com.tencent.mm.plugin.datareport.d.a.eC(paramObject);
    AppMethodBeat.o(262851);
    return i;
  }
  
  public static boolean eF(Object paramObject)
  {
    return ((paramObject instanceof Activity)) || ((paramObject instanceof Fragment)) || ((paramObject instanceof com.tencent.mm.plugin.datareport.f.c));
  }
  
  private static void j(Object paramObject, String paramString)
  {
    AppMethodBeat.i(262964);
    if ((paramObject == null) || (i.hm(paramString)))
    {
      AppMethodBeat.o(262964);
      return;
    }
    if (i.qA(paramString, "view_clk"))
    {
      com.tencent.mm.plugin.datareport.d.a.f(paramObject, "view_clk_count", Integer.valueOf(com.tencent.mm.plugin.datareport.d.a.k(paramObject, "view_clk_count") + 1));
      AppMethodBeat.o(262964);
      return;
    }
    if (i.qA(paramString, "view_exp"))
    {
      com.tencent.mm.plugin.datareport.d.a.f(paramObject, "view_exp_count", Integer.valueOf(com.tencent.mm.plugin.datareport.d.a.k(paramObject, "view_exp_count") + 1));
      AppMethodBeat.o(262964);
      return;
    }
    if (i.qA(paramString, "view_unexp")) {
      com.tencent.mm.plugin.datareport.d.a.f(paramObject, "view_unexp_policy", Integer.valueOf(com.tencent.mm.plugin.datareport.d.a.k(paramObject, "view_unexp_policy") + 1));
    }
    AppMethodBeat.o(262964);
  }
  
  private void s(String paramString, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(262925);
    if (i.hm(paramString))
    {
      AppMethodBeat.o(262925);
      return;
    }
    paramMap.put("report_seq", Integer.valueOf(this.xgf));
    this.xgf += 1;
    int i = 0;
    if (this.xgg.containsKey(paramString)) {
      i = ((Integer)this.xgg.get(paramString)).intValue();
    }
    paramMap.put("event_seq", Integer.valueOf(i));
    this.xgg.put(paramString, Integer.valueOf(i + 1));
    AppMethodBeat.o(262925);
  }
  
  private void t(String paramString, List<Integer> paramList)
  {
    AppMethodBeat.i(262859);
    if ((!dto()) || (i.hm(paramString)) || (paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(262859);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramString = (List)this.xgd.get(paramString);
    if (paramString != null)
    {
      Iterator localIterator = paramString.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.datareport.a.b.b localb = (com.tencent.mm.plugin.datareport.a.b.b)localIterator.next();
        if (paramList.contains(Integer.valueOf(localb.xgH))) {
          localArrayList.add(localb);
        }
      }
    }
    paramList = localArrayList.iterator();
    while (paramList.hasNext()) {
      paramString.remove((com.tencent.mm.plugin.datareport.a.b.b)paramList.next());
    }
    AppMethodBeat.o(262859);
  }
  
  public final void A(String paramString, Object paramObject)
  {
    AppMethodBeat.i(262981);
    if ((i.hm(paramString)) || (paramObject == null) || (!dto()))
    {
      AppMethodBeat.o(262981);
      return;
    }
    synchronized (this.xgb)
    {
      this.xgb.put(paramString, paramObject);
      AppMethodBeat.o(262981);
      return;
    }
  }
  
  public final void B(String paramString, Object paramObject)
  {
    AppMethodBeat.i(262990);
    if ((i.hm(paramString)) || (!dto()))
    {
      AppMethodBeat.o(262990);
      return;
    }
    synchronized (this.xgc)
    {
      this.xgc.put(paramString, paramObject);
      AppMethodBeat.o(262990);
      return;
    }
  }
  
  public final void H(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(263106);
    if (paramContext != null)
    {
      paramIntent.setClass(paramContext, SampleUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/datareport/DataReportService", "showReportSDKSampleUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/datareport/DataReportService", "showReportSDKSampleUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(263106);
  }
  
  public final void I(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(263114);
    paramIntent.setClass(paramContext, KtSampleUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/datareport/DataReportService", "showReportSDKKtSampleUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/datareport/DataReportService", "showReportSDKKtSampleUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(263114);
  }
  
  public final void a(long paramLong, com.tencent.mm.plugin.datareport.a.b.a parama)
  {
    AppMethodBeat.i(263088);
    if ((parama == null) || (!dto()))
    {
      AppMethodBeat.o(263088);
      return;
    }
    if ((parama.mTarget == null) && (!amv(parama.xgD)))
    {
      com.tencent.mm.plugin.datareport.f.b localb = new com.tencent.mm.plugin.datareport.f.b();
      localb.eventId = parama.xgD;
      localb.ae(parama.xgE);
      a(paramLong, null, localb);
    }
    if ((parama.mTarget != null) && (!a(parama.mTarget, com.tencent.mm.plugin.datareport.d.a.eR(parama.mTarget), parama.xgD))) {
      b(paramLong, parama);
    }
    if ((parama.mTarget != null) && (!b(parama.mTarget, com.tencent.mm.plugin.datareport.d.a.eQ(parama.mTarget), parama.xgD))) {
      c(paramLong, parama);
    }
    if ((parama.mTarget != null) && ((parama.mTarget instanceof View)) && (com.tencent.mm.plugin.datareport.d.a.eJ(parama.mTarget))) {
      j(parama.mTarget, parama.xgD);
    }
    AppMethodBeat.o(263088);
  }
  
  public final void a(long paramLong, String paramString, Object paramObject, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(263078);
    if (!dto())
    {
      AppMethodBeat.o(263078);
      return;
    }
    a.a locala = com.tencent.mm.plugin.datareport.a.b.a.dts();
    locala.mTarget = paramObject;
    locala.xgD = paramString;
    a(paramLong, locala.ac(new HashMap(paramMap)).dtt());
    AppMethodBeat.o(263078);
  }
  
  public final void a(Object paramObject, com.tencent.mm.plugin.datareport.a.a.a parama)
  {
    AppMethodBeat.i(263016);
    if ((parama == null) || (!dto()))
    {
      AppMethodBeat.o(263016);
      return;
    }
    if (!eF(paramObject))
    {
      Log.e("DataReportService", "[setPageId] target is not a page!!!");
      AppMethodBeat.o(263016);
      return;
    }
    com.tencent.mm.plugin.datareport.d.a.p(paramObject, parama.mValue);
    AppMethodBeat.o(263016);
  }
  
  public final void a(Object paramObject, com.tencent.mm.plugin.datareport.a.c.a parama)
  {
    AppMethodBeat.i(263063);
    if ((paramObject == null) || (parama == null) || (!dto()))
    {
      AppMethodBeat.o(263063);
      return;
    }
    if ((paramObject instanceof View))
    {
      com.tencent.mm.plugin.datareport.d.a.b(paramObject, parama);
      AppMethodBeat.o(263063);
      return;
    }
    if (eF(paramObject))
    {
      com.tencent.mm.plugin.datareport.d.a.c(paramObject, parama);
      AppMethodBeat.o(263063);
      return;
    }
    Log.e("DataReportService", "[addDynamicParams] target is not a page or a view!!!");
    AppMethodBeat.o(263063);
  }
  
  public final void a(Object paramObject, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(263044);
    if ((paramObject == null) || (paramMap == null) || (paramMap.size() <= 0) || (!dto()))
    {
      AppMethodBeat.o(263044);
      return;
    }
    if (!(paramObject instanceof View))
    {
      Log.e("DataReportService", "[setViewParams] target is not a view!!!");
      AppMethodBeat.o(263044);
      return;
    }
    com.tencent.mm.plugin.datareport.d.a.a(paramObject, paramMap);
    AppMethodBeat.o(263044);
  }
  
  public final void a(String paramString, Object paramObject, Map<String, Object> paramMap, int paramInt)
  {
    AppMethodBeat.i(263098);
    if (!dto())
    {
      AppMethodBeat.o(263098);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(paramInt));
    a.a locala;
    if (dto())
    {
      locala = com.tencent.mm.plugin.datareport.a.b.a.dts();
      locala.mTarget = paramObject;
      locala.xgD = paramString;
      if (paramMap == null) {
        break label123;
      }
    }
    label123:
    for (paramString = new HashMap(paramMap);; paramString = null)
    {
      paramString = locala.ac(paramString);
      if (localArrayList.size() > 0) {
        paramString.xgG.addAll(localArrayList);
      }
      a(paramString.dtt());
      AppMethodBeat.o(263098);
      return;
    }
  }
  
  public final void d(Object paramObject1, String paramString, Object paramObject2)
  {
    AppMethodBeat.i(263003);
    if ((i.hm(paramString)) || (!dto()))
    {
      AppMethodBeat.o(263003);
      return;
    }
    if (!eF(paramObject1))
    {
      Log.e("DataReportService", "[setPageParam] target is not a page!!!");
      AppMethodBeat.o(263003);
      return;
    }
    com.tencent.mm.plugin.datareport.d.a.d(paramObject1, paramString, paramObject2);
    AppMethodBeat.o(263003);
  }
  
  public final boolean dto()
  {
    AppMethodBeat.i(262973);
    if (!this.xfY.booleanValue())
    {
      AppMethodBeat.o(262973);
      return false;
    }
    if (this.xfZ == null)
    {
      this.xfZ = Boolean.valueOf(((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zql, true));
      Log.i("DataReportService", "[isOpenSwitch] cloudSwitch : " + this.xfZ);
    }
    boolean bool = this.xfZ.booleanValue();
    AppMethodBeat.o(262973);
    return bool;
  }
  
  public final void dtq()
  {
    AppMethodBeat.i(262997);
    if (!dto())
    {
      AppMethodBeat.o(262997);
      return;
    }
    synchronized (this.xgc)
    {
      this.xgc.clear();
      AppMethodBeat.o(262997);
      return;
    }
  }
  
  public final void e(Object paramObject1, String paramString, Object paramObject2)
  {
    AppMethodBeat.i(263039);
    if ((paramObject1 == null) || (i.hm(paramString)) || (!dto()))
    {
      AppMethodBeat.o(263039);
      return;
    }
    if (!(paramObject1 instanceof View))
    {
      Log.e("DataReportService", "[setViewParam] target is not a view!!!");
      AppMethodBeat.o(263039);
      return;
    }
    com.tencent.mm.plugin.datareport.d.a.e(paramObject1, paramString, paramObject2);
    AppMethodBeat.o(263039);
  }
  
  public final void eB(Object paramObject)
  {
    AppMethodBeat.i(263009);
    if (!dto())
    {
      AppMethodBeat.o(263009);
      return;
    }
    if (!eF(paramObject))
    {
      Log.e("DataReportService", "[resetPageParams] target is not a page!!!");
      AppMethodBeat.o(263009);
      return;
    }
    com.tencent.mm.plugin.datareport.d.a.eO(paramObject);
    AppMethodBeat.o(263009);
  }
  
  public final void eD(Object paramObject)
  {
    AppMethodBeat.i(263049);
    if ((paramObject == null) || (!dto()))
    {
      AppMethodBeat.o(263049);
      return;
    }
    if (!(paramObject instanceof View))
    {
      Log.e("DataReportService", "[resetViewParams] target is not a view!!!");
      AppMethodBeat.o(263049);
      return;
    }
    com.tencent.mm.plugin.datareport.d.a.eL(paramObject);
    AppMethodBeat.o(263049);
  }
  
  public final void eE(Object paramObject)
  {
    AppMethodBeat.i(263073);
    if (!dto())
    {
      AppMethodBeat.o(263073);
      return;
    }
    if (!eF(paramObject))
    {
      Log.e("DataReportService", "[setPageReportPolicy] target is not a view!!!");
      AppMethodBeat.o(263073);
      return;
    }
    com.tencent.mm.plugin.datareport.d.a.eS(paramObject);
    AppMethodBeat.o(263073);
  }
  
  public final void f(Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(263067);
    if ((paramObject == null) || (!dto()))
    {
      AppMethodBeat.o(263067);
      return;
    }
    if (!(paramObject instanceof View))
    {
      Log.e("DataReportService", "[setViewReportPolicy] target is not a view!!!");
      AppMethodBeat.o(263067);
      return;
    }
    if ((paramObject == null) || (!dto()))
    {
      AppMethodBeat.o(263067);
      return;
    }
    if (!(paramObject instanceof View))
    {
      Log.e("DataReportService", "[setViewReportPolicy] target is not a view!!!");
      AppMethodBeat.o(263067);
      return;
    }
    com.tencent.mm.plugin.datareport.d.a.g(paramObject, paramInt1, paramInt2);
    AppMethodBeat.o(263067);
  }
  
  public final void g(Object paramObject, String paramString)
  {
    AppMethodBeat.i(263023);
    if ((i.hm(paramString)) || (!dto()))
    {
      AppMethodBeat.o(263023);
      return;
    }
    if (!eF(paramObject))
    {
      Log.e("DataReportService", "[setPageName] target is not a page!!!");
      AppMethodBeat.o(263023);
      return;
    }
    com.tencent.mm.plugin.datareport.d.a.g(paramObject, paramString);
    AppMethodBeat.o(263023);
  }
  
  public final void h(Object paramObject, String paramString)
  {
    AppMethodBeat.i(263031);
    if ((i.hm(paramString)) || (!dto()))
    {
      AppMethodBeat.o(263031);
      return;
    }
    if (!eF(paramObject))
    {
      Log.e("DataReportService", "[setPageContentId] target is not a page!!!");
      AppMethodBeat.o(263031);
      return;
    }
    com.tencent.mm.plugin.datareport.d.a.h(paramObject, paramString);
    AppMethodBeat.o(263031);
  }
  
  public final void i(Object paramObject, String paramString)
  {
    AppMethodBeat.i(263059);
    if ((paramObject == null) || (i.hm(paramString)) || (!dto()))
    {
      AppMethodBeat.o(263059);
      return;
    }
    if (!(paramObject instanceof View))
    {
      Log.e("DataReportService", "[getViewParams] target is not a view!!!");
      AppMethodBeat.o(263059);
      return;
    }
    com.tencent.mm.plugin.datareport.d.a.i(paramObject, paramString);
    AppMethodBeat.o(263059);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.datareport.a
 * JD-Core Version:    0.7.0.1
 */