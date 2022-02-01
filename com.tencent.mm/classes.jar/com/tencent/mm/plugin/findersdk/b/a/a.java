package com.tencent.mm.plugin.findersdk.b.a;

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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/findersdk/cgi/report/CgiStrategy;", "", "()V", "MAGIC_CODE_1", "", "MAGIC_CODE_2", "autoBlockErrorMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/findersdk/cgi/report/CgiStrategy$TimeLimit;", "autoBlockMap", "autoLimitBlock", "Lcom/tencent/mm/plugin/findersdk/cgi/report/CgiStrategy$ServerLimit;", "autoLimitErrorBlock", "blockErrorReport", "Ljava/util/concurrent/ConcurrentSkipListSet;", "blockList", "blockReport", "lastInitTime", "", "magicCode", "noPrint", "autoBlock", "", "uri", "errorCode", "checkMapCount", "Lkotlin/Pair;", "map", "svrLimit", "init", "", "isBlock", "isNoPrint", "isOnlyReportError", "tryMoreInit", "ServerLimit", "TimeLimit", "finder-sdk_release"})
public final class a
{
  private static final ConcurrentSkipListSet<String> BvH;
  private static final ConcurrentSkipListSet<String> BvI;
  private static int BvJ;
  private static a BvK;
  private static a BvL;
  private static final ConcurrentHashMap<String, b> BvM;
  private static final ConcurrentHashMap<String, b> BvN;
  private static final ConcurrentSkipListSet<String> BvO;
  private static final ConcurrentSkipListSet<String> BvP;
  public static long BvQ;
  public static final a BvR;
  
  static
  {
    AppMethodBeat.i(209887);
    BvR = new a();
    BvH = new ConcurrentSkipListSet();
    BvI = new ConcurrentSkipListSet();
    BvK = new a(200, 60L);
    BvL = new a(1000, 60L);
    BvM = new ConcurrentHashMap();
    BvN = new ConcurrentHashMap();
    BvO = new ConcurrentSkipListSet();
    BvP = new ConcurrentSkipListSet();
    BvH.add("finderstatsreport");
    BvH.add("findergetlivemsg");
    BvH.add("findermarkread");
    AppMethodBeat.o(209887);
  }
  
  private static o<Boolean, b> a(ConcurrentHashMap<String, b> paramConcurrentHashMap, a parama, String paramString)
  {
    AppMethodBeat.i(209883);
    if ((paramString == null) || (Util.isNullOrNil(paramString)))
    {
      paramConcurrentHashMap = new o(Boolean.TRUE, null);
      AppMethodBeat.o(209883);
      return paramConcurrentHashMap;
    }
    String str = n.pz(paramString, "/");
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
        if (SystemClock.elapsedRealtime() - paramConcurrentHashMap.ftv <= parama.time * 60L * 1000L)
        {
          paramConcurrentHashMap = new o(Boolean.TRUE, paramConcurrentHashMap);
          AppMethodBeat.o(209883);
          return paramConcurrentHashMap;
        }
        paramConcurrentHashMap.count = 0;
        paramConcurrentHashMap.ftv = SystemClock.elapsedRealtime();
      }
      paramConcurrentHashMap.count += 1;
      paramConcurrentHashMap = new o(Boolean.FALSE, null);
      AppMethodBeat.o(209883);
      return paramConcurrentHashMap;
      label188:
      paramConcurrentHashMap = paramString;
    }
  }
  
  public static boolean aGN(String paramString)
  {
    AppMethodBeat.i(209884);
    if ((paramString == null) || (Util.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(209884);
      return true;
    }
    if (BvJ == 1)
    {
      AppMethodBeat.o(209884);
      return true;
    }
    paramString = n.pz(paramString, "/");
    if (BvI.contains(paramString))
    {
      AppMethodBeat.o(209884);
      return true;
    }
    AppMethodBeat.o(209884);
    return false;
  }
  
  public static boolean aGO(String paramString)
  {
    AppMethodBeat.i(209885);
    if ((paramString == null) || (Util.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(209885);
      return true;
    }
    paramString = n.pz(paramString, "/");
    if (BvH.contains(paramString))
    {
      AppMethodBeat.o(209885);
      return true;
    }
    AppMethodBeat.o(209885);
    return false;
  }
  
  public static boolean eno()
  {
    return BvJ == 2;
  }
  
  public static boolean ep(String paramString, final int paramInt)
  {
    AppMethodBeat.i(209880);
    final o localo;
    if (paramInt != 0)
    {
      localo = a(BvM, BvK, paramString);
      if (((Boolean)localo.Mx).booleanValue())
      {
        if (BuildInfo.DEBUG) {
          Log.i("Finder.CgiStrategy", "isBlock error case " + paramString + ' ' + paramInt);
        }
        if (!BvP.contains(paramString))
        {
          com.tencent.mm.ae.f.a.a(com.tencent.mm.plugin.findersdk.b.BuZ, "cgiReportError", false, false, (kotlin.g.a.a)new c(paramString, paramInt, localo), 12);
          BvP.add(paramString);
        }
        AppMethodBeat.o(209880);
        return true;
      }
    }
    else
    {
      localo = a(BvN, BvL, paramString);
      if (((Boolean)localo.Mx).booleanValue())
      {
        if (!BvO.contains(paramString))
        {
          com.tencent.mm.ae.f.a.a(com.tencent.mm.plugin.findersdk.b.BuZ, "cgiReportNormal", false, false, (kotlin.g.a.a)new d(paramString, paramInt, localo), 12);
          BvO.add(paramString);
        }
        if (BuildInfo.DEBUG) {
          Log.i("Finder.CgiStrategy", "isBlock normal case " + paramString + ' ' + paramInt);
        }
        AppMethodBeat.o(209880);
        return true;
      }
    }
    AppMethodBeat.o(209880);
    return false;
  }
  
  public static void init()
  {
    Object localObject2 = null;
    AppMethodBeat.i(209879);
    com.tencent.mm.compatible.util.f.a locala = new com.tencent.mm.compatible.util.f.a();
    Object localObject1 = com.tencent.mm.plugin.findersdk.d.a.b.Bwn;
    String str = com.tencent.mm.plugin.findersdk.d.a.b.enu();
    List localList = Util.stringToList(str, ",");
    p.j(localList, "it");
    localObject1 = (String)j.M(localList, 0);
    if (localObject1 != null) {
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(209879);
        throw ((Throwable)localObject1);
      }
    }
    for (localObject1 = n.bb((CharSequence)localObject1).toString();; localObject1 = null)
    {
      i = Util.safeParseInt((String)localObject1);
      localObject1 = (String)j.M(localList, 1);
      if (localObject1 == null) {
        break label202;
      }
      if (localObject1 != null) {
        break;
      }
      localObject1 = new t("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(209879);
      throw ((Throwable)localObject1);
    }
    label202:
    for (localObject1 = n.bb((CharSequence)localObject1).toString();; localObject1 = null)
    {
      BvK = new a(i, Util.safeParseInt((String)localObject1));
      localObject1 = (String)j.M(localList, 2);
      if (localObject1 == null) {
        break label260;
      }
      if (localObject1 != null) {
        break;
      }
      localObject1 = new t("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(209879);
      throw ((Throwable)localObject1);
    }
    label260:
    for (localObject1 = n.bb((CharSequence)localObject1).toString();; localObject1 = null)
    {
      i = Util.safeParseInt((String)localObject1);
      localObject1 = (String)j.M(localList, 3);
      if (localObject1 == null) {
        break label323;
      }
      if (localObject1 != null) {
        break;
      }
      localObject1 = new t("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(209879);
      throw ((Throwable)localObject1);
    }
    label323:
    for (localObject1 = n.bb((CharSequence)localObject1).toString();; localObject1 = localObject2)
    {
      BvL = new a(i, Util.safeParseInt((String)localObject1));
      localObject1 = com.tencent.mm.plugin.findersdk.d.a.b.Bwn;
      localObject1 = com.tencent.mm.plugin.findersdk.d.a.b.env();
      if (localObject1 != null) {
        break;
      }
      localObject1 = new t("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(209879);
      throw ((Throwable)localObject1);
    }
    int i = Util.safeParseInt(n.bb((CharSequence)localObject1).toString());
    BvJ = i;
    if (i > 0)
    {
      Log.e("Finder.CgiStrategy", "blockAll cgi " + BvJ);
      AppMethodBeat.o(209879);
      return;
    }
    localObject2 = com.tencent.mm.plugin.findersdk.d.a.b.Bwn;
    localObject2 = Util.stringToList(com.tencent.mm.plugin.findersdk.d.a.b.env(), ",");
    Log.i("Finder.CgiStrategy", "init blockString " + (String)localObject1 + " limitString " + str + " size " + ((List)localObject2).size() + " autoLimitErrorBlock:" + BvK.count + ' ' + BvK.time + " autoLimitBlock:" + BvL.count + ' ' + BvL.time + " errorReport " + BvO.size() + ' ' + BvP.size() + " cost:" + locala.avE());
    BvI.clear();
    BvI.addAll((Collection)localObject2);
    AppMethodBeat.o(209879);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/findersdk/cgi/report/CgiStrategy$ServerLimit;", "", "count", "", "time", "", "(IJ)V", "getCount", "()I", "setCount", "(I)V", "getTime", "()J", "setTime", "(J)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "finder-sdk_release"})
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
      AppMethodBeat.i(209314);
      String str = "ServerLimit(count=" + this.count + ", time=" + this.time + ")";
      AppMethodBeat.o(209314);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/findersdk/cgi/report/CgiStrategy$TimeLimit;", "", "count", "", "lastTryTime", "", "(IJ)V", "getCount", "()I", "setCount", "(I)V", "getLastTryTime", "()J", "setLastTryTime", "(J)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "finder-sdk_release"})
  public static final class b
  {
    int count = 0;
    long ftv;
    
    public b(long paramLong)
    {
      this.ftv = paramLong;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((this.count != paramObject.count) || (this.ftv != paramObject.ftv)) {}
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
      long l = this.ftv;
      return i * 31 + (int)(l ^ l >>> 32);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(208888);
      String str = "TimeLimit(count=" + this.count + ", lastTryTime=" + this.ftv + ")";
      AppMethodBeat.o(208888);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<String>
  {
    c(String paramString, int paramInt, o paramo)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.b.a.a
 * JD-Core Version:    0.7.0.1
 */