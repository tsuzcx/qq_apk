package com.tencent.mm.plugin.finder.cgi.report;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.o;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/report/CgiStrategy;", "", "()V", "MAGIC_CODE_1", "", "MAGIC_CODE_2", "autoBlockErrorMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/cgi/report/CgiStrategy$TimeLimit;", "autoBlockMap", "autoLimitBlock", "Lcom/tencent/mm/plugin/finder/cgi/report/CgiStrategy$ServerLimit;", "autoLimitErrorBlock", "blockErrorReport", "Ljava/util/concurrent/ConcurrentSkipListSet;", "blockList", "blockReport", "lastInitTime", "", "magicCode", "noPrint", "autoBlock", "", "uri", "errorCode", "checkMapCount", "Lkotlin/Pair;", "map", "svrLimit", "init", "", "isBlock", "isNoPrint", "isOnlyReportError", "tryMoreInit", "ServerLimit", "TimeLimit", "plugin-finder_release"})
public final class a
{
  private static final ConcurrentSkipListSet<String> txQ;
  private static final ConcurrentSkipListSet<String> txR;
  private static int txS;
  private static a txT;
  private static a txU;
  private static final ConcurrentHashMap<String, b> txV;
  private static final ConcurrentHashMap<String, b> txW;
  private static final ConcurrentSkipListSet<String> txX;
  private static final ConcurrentSkipListSet<String> txY;
  public static long txZ;
  public static final a tya;
  
  static
  {
    AppMethodBeat.i(242684);
    tya = new a();
    txQ = new ConcurrentSkipListSet();
    txR = new ConcurrentSkipListSet();
    txT = new a(200, 60L);
    txU = new a(1000, 60L);
    txV = new ConcurrentHashMap();
    txW = new ConcurrentHashMap();
    txX = new ConcurrentSkipListSet();
    txY = new ConcurrentSkipListSet();
    txQ.add("finderstatsreport");
    txQ.add("findergetlivemsg");
    txQ.add("findermarkread");
    AppMethodBeat.o(242684);
  }
  
  private static o<Boolean, b> a(ConcurrentHashMap<String, b> paramConcurrentHashMap, a parama, String paramString)
  {
    AppMethodBeat.i(242681);
    if ((paramString == null) || (Util.isNullOrNil(paramString)))
    {
      paramConcurrentHashMap = new o(Boolean.TRUE, null);
      AppMethodBeat.o(242681);
      return paramConcurrentHashMap;
    }
    String str = n.oD(paramString, "/");
    ConcurrentMap localConcurrentMap = (ConcurrentMap)paramConcurrentHashMap;
    paramString = localConcurrentMap.get(str);
    paramConcurrentHashMap = paramString;
    if (paramString == null)
    {
      paramConcurrentHashMap = new b(SystemClock.elapsedRealtime());
      paramString = localConcurrentMap.putIfAbsent(str, paramConcurrentHashMap);
      if (paramString != null) {
        break label188;
      }
    }
    for (;;)
    {
      paramConcurrentHashMap = (b)paramConcurrentHashMap;
      if (paramConcurrentHashMap.count >= parama.count)
      {
        if (SystemClock.elapsedRealtime() - paramConcurrentHashMap.dAG <= parama.time * 60L * 1000L)
        {
          paramConcurrentHashMap = new o(Boolean.TRUE, paramConcurrentHashMap);
          AppMethodBeat.o(242681);
          return paramConcurrentHashMap;
        }
        paramConcurrentHashMap.count = 0;
        paramConcurrentHashMap.dAG = SystemClock.elapsedRealtime();
      }
      paramConcurrentHashMap.count += 1;
      paramConcurrentHashMap = new o(Boolean.FALSE, null);
      AppMethodBeat.o(242681);
      return paramConcurrentHashMap;
      label188:
      paramConcurrentHashMap = paramString;
    }
  }
  
  public static boolean asP(String paramString)
  {
    AppMethodBeat.i(242682);
    if ((paramString == null) || (Util.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(242682);
      return true;
    }
    if (txS == 1)
    {
      AppMethodBeat.o(242682);
      return true;
    }
    paramString = n.oD(paramString, "/");
    if (txR.contains(paramString))
    {
      AppMethodBeat.o(242682);
      return true;
    }
    AppMethodBeat.o(242682);
    return false;
  }
  
  public static boolean asQ(String paramString)
  {
    AppMethodBeat.i(242683);
    if ((paramString == null) || (Util.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(242683);
      return true;
    }
    paramString = n.oD(paramString, "/");
    if (txQ.contains(paramString))
    {
      AppMethodBeat.o(242683);
      return true;
    }
    AppMethodBeat.o(242683);
    return false;
  }
  
  public static boolean cZs()
  {
    return txS == 2;
  }
  
  public static boolean dv(String paramString, final int paramInt)
  {
    AppMethodBeat.i(242680);
    final o localo;
    if (paramInt != 0)
    {
      localo = a(txV, txT, paramString);
      if (((Boolean)localo.first).booleanValue())
      {
        if (BuildInfo.DEBUG) {
          Log.i("Finder.CgiStrategy", "isBlock error case " + paramString + ' ' + paramInt);
        }
        if (!txY.contains(paramString))
        {
          com.tencent.mm.ac.f.a.a(com.tencent.mm.plugin.finder.utils.c.vVc, "cgiReportError", false, false, (kotlin.g.a.a)new c(paramString, paramInt, localo), 12);
          txY.add(paramString);
        }
        AppMethodBeat.o(242680);
        return true;
      }
    }
    else
    {
      localo = a(txW, txU, paramString);
      if (((Boolean)localo.first).booleanValue())
      {
        if (!txX.contains(paramString))
        {
          com.tencent.mm.ac.f.a.a(com.tencent.mm.plugin.finder.utils.c.vVc, "cgiReportNormal", false, false, (kotlin.g.a.a)new d(paramString, paramInt, localo), 12);
          txX.add(paramString);
        }
        if (BuildInfo.DEBUG) {
          Log.i("Finder.CgiStrategy", "isBlock normal case " + paramString + ' ' + paramInt);
        }
        AppMethodBeat.o(242680);
        return true;
      }
    }
    AppMethodBeat.o(242680);
    return false;
  }
  
  public static void init()
  {
    Object localObject2 = null;
    AppMethodBeat.i(242679);
    com.tencent.mm.compatible.util.f.a locala = new com.tencent.mm.compatible.util.f.a();
    Object localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
    String str = com.tencent.mm.plugin.finder.storage.c.dxg();
    Object localObject3 = Util.stringToList(str, ",");
    p.g(localObject3, "it");
    localObject1 = (String)j.L((List)localObject3, 0);
    if (localObject1 != null) {
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(242679);
        throw ((Throwable)localObject1);
      }
    }
    for (localObject1 = n.trim((CharSequence)localObject1).toString();; localObject1 = null)
    {
      i = Util.safeParseInt((String)localObject1);
      localObject1 = (String)j.L((List)localObject3, 1);
      if (localObject1 == null) {
        break label202;
      }
      if (localObject1 != null) {
        break;
      }
      localObject1 = new t("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(242679);
      throw ((Throwable)localObject1);
    }
    label202:
    for (localObject1 = n.trim((CharSequence)localObject1).toString();; localObject1 = null)
    {
      txT = new a(i, Util.safeParseInt((String)localObject1));
      localObject1 = (String)j.L((List)localObject3, 2);
      if (localObject1 == null) {
        break label260;
      }
      if (localObject1 != null) {
        break;
      }
      localObject1 = new t("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(242679);
      throw ((Throwable)localObject1);
    }
    label260:
    for (localObject1 = n.trim((CharSequence)localObject1).toString();; localObject1 = null)
    {
      i = Util.safeParseInt((String)localObject1);
      localObject1 = (String)j.L((List)localObject3, 3);
      if (localObject1 == null) {
        break label332;
      }
      if (localObject1 != null) {
        break;
      }
      localObject1 = new t("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(242679);
      throw ((Throwable)localObject1);
    }
    label332:
    for (localObject1 = n.trim((CharSequence)localObject1).toString();; localObject1 = null)
    {
      txU = new a(i, Util.safeParseInt((String)localObject1));
      localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject3 = com.tencent.mm.plugin.finder.storage.c.dxf();
      localObject1 = localObject2;
      if (localObject3 == null) {
        break label349;
      }
      if (localObject3 != null) {
        break;
      }
      localObject1 = new t("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(242679);
      throw ((Throwable)localObject1);
    }
    localObject1 = n.trim((CharSequence)localObject3).toString();
    label349:
    int i = Util.safeParseInt((String)localObject1);
    txS = i;
    if (i > 0)
    {
      Log.e("Finder.CgiStrategy", "blockAll cgi " + txS);
      AppMethodBeat.o(242679);
      return;
    }
    localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
    localObject1 = Util.stringToList(com.tencent.mm.plugin.finder.storage.c.dxf(), ",");
    Log.i("Finder.CgiStrategy", "init blockString " + (String)localObject3 + " limitString " + str + " size " + ((List)localObject1).size() + " autoLimitErrorBlock:" + txT.count + ' ' + txT.time + " autoLimitBlock:" + txU.count + ' ' + txU.time + " errorReport " + txX.size() + ' ' + txY.size() + " cost:" + locala.apr());
    txR.clear();
    txR.addAll((Collection)localObject1);
    AppMethodBeat.o(242679);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/report/CgiStrategy$ServerLimit;", "", "count", "", "time", "", "(IJ)V", "getCount", "()I", "setCount", "(I)V", "getTime", "()J", "setTime", "(J)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
  public static final class a
  {
    int count;
    long time;
    
    public a(int paramInt, long paramLong)
    {
      this.count = paramInt;
      this.time = paramLong;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.count != paramObject.count) || (this.time != paramObject.time)) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      int i = this.count;
      long l = this.time;
      return i * 31 + (int)(l ^ l >>> 32);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(242675);
      String str = "ServerLimit(count=" + this.count + ", time=" + this.time + ")";
      AppMethodBeat.o(242675);
      return str;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/report/CgiStrategy$TimeLimit;", "", "count", "", "lastTryTime", "", "(IJ)V", "getCount", "()I", "setCount", "(I)V", "getLastTryTime", "()J", "setLastTryTime", "(J)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
  public static final class b
  {
    int count = 0;
    long dAG;
    
    public b(long paramLong)
    {
      this.dAG = paramLong;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((this.count != paramObject.count) || (this.dAG != paramObject.dAG)) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      int i = this.count;
      long l = this.dAG;
      return i * 31 + (int)(l ^ l >>> 32);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(242676);
      String str = "TimeLimit(count=" + this.count + ", lastTryTime=" + this.dAG + ")";
      AppMethodBeat.o(242676);
      return str;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<String>
  {
    c(String paramString, int paramInt, o paramo)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<String>
  {
    d(String paramString, int paramInt, o paramo)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.report.a
 * JD-Core Version:    0.7.0.1
 */