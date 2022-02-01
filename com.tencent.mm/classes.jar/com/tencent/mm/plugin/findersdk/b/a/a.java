package com.tencent.mm.plugin.findersdk.b.a;

import android.os.SystemClock;
import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.e.a;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/cgi/report/CgiStrategy;", "", "()V", "MAGIC_CODE_1", "", "MAGIC_CODE_2", "autoBlockErrorMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/findersdk/cgi/report/CgiStrategy$TimeLimit;", "autoBlockMap", "autoLimitBlock", "Lcom/tencent/mm/plugin/findersdk/cgi/report/CgiStrategy$ServerLimit;", "autoLimitErrorBlock", "blockErrorReport", "Ljava/util/concurrent/ConcurrentSkipListSet;", "blockList", "blockReport", "lastInitTime", "", "magicCode", "noPrint", "autoBlock", "", "uri", "errorCode", "checkMapCount", "Lkotlin/Pair;", "map", "svrLimit", "init", "", "isBlock", "isNoPrint", "isOnlyReportError", "tryMoreInit", "ServerLimit", "TimeLimit", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a HcR;
  private static final ConcurrentSkipListSet<String> HcS;
  private static final ConcurrentSkipListSet<String> HcT;
  private static int HcU;
  private static a HcV;
  private static a HcW;
  private static final ConcurrentHashMap<String, b> HcX;
  private static final ConcurrentHashMap<String, b> HcY;
  private static final ConcurrentSkipListSet<String> HcZ;
  private static final ConcurrentSkipListSet<String> Hda;
  public static long Hdb;
  
  static
  {
    AppMethodBeat.i(273918);
    HcR = new a();
    HcS = new ConcurrentSkipListSet();
    HcT = new ConcurrentSkipListSet();
    HcV = new a(200, 60L);
    HcW = new a(1000, 60L);
    HcX = new ConcurrentHashMap();
    HcY = new ConcurrentHashMap();
    HcZ = new ConcurrentSkipListSet();
    Hda = new ConcurrentSkipListSet();
    HcS.add("finderstatsreport");
    HcS.add("findergetlivemsg");
    HcS.add("findermarkread");
    AppMethodBeat.o(273918);
  }
  
  private static r<Boolean, b> a(ConcurrentHashMap<String, b> paramConcurrentHashMap, a parama, String paramString)
  {
    AppMethodBeat.i(273883);
    if ((paramString == null) || (Util.isNullOrNil(paramString)))
    {
      paramConcurrentHashMap = new r(Boolean.TRUE, null);
      AppMethodBeat.o(273883);
      return paramConcurrentHashMap;
    }
    String str = n.rw(paramString, "/");
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
        if (SystemClock.elapsedRealtime() - paramConcurrentHashMap.hxK <= parama.time * 60L * 1000L)
        {
          paramConcurrentHashMap = new r(Boolean.TRUE, paramConcurrentHashMap);
          AppMethodBeat.o(273883);
          return paramConcurrentHashMap;
        }
        paramConcurrentHashMap.count = 0;
        paramConcurrentHashMap.hxK = SystemClock.elapsedRealtime();
      }
      paramConcurrentHashMap.count += 1;
      paramConcurrentHashMap = new r(Boolean.FALSE, null);
      AppMethodBeat.o(273883);
      return paramConcurrentHashMap;
      label188:
      paramConcurrentHashMap = paramString;
    }
  }
  
  public static boolean aDe(String paramString)
  {
    AppMethodBeat.i(273898);
    if ((paramString == null) || (Util.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(273898);
      return true;
    }
    if (HcU == 1)
    {
      AppMethodBeat.o(273898);
      return true;
    }
    paramString = n.rw(paramString, "/");
    if (HcT.contains(paramString))
    {
      AppMethodBeat.o(273898);
      return true;
    }
    AppMethodBeat.o(273898);
    return false;
  }
  
  public static boolean aDf(String paramString)
  {
    AppMethodBeat.i(273909);
    if ((paramString == null) || (Util.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(273909);
      return true;
    }
    paramString = n.rw(paramString, "/");
    if (HcS.contains(paramString))
    {
      AppMethodBeat.o(273909);
      return true;
    }
    AppMethodBeat.o(273909);
    return false;
  }
  
  public static boolean fe(String paramString, final int paramInt)
  {
    AppMethodBeat.i(273873);
    final r localr;
    if (paramInt != 0)
    {
      localr = a(HcX, HcV, paramString);
      if (((Boolean)localr.bsC).booleanValue())
      {
        if (BuildInfo.DEBUG) {
          Log.i("Finder.CgiStrategy", "isBlock error case " + paramString + ' ' + paramInt);
        }
        if (!Hda.contains(paramString))
        {
          e.a.a((e)com.tencent.mm.plugin.findersdk.b.HbT, "cgiReportError", false, null, false, (kotlin.g.a.a)new c(paramString, paramInt, localr), 28);
          Hda.add(paramString);
        }
        AppMethodBeat.o(273873);
        return true;
      }
    }
    else
    {
      localr = a(HcY, HcW, paramString);
      if (((Boolean)localr.bsC).booleanValue())
      {
        if (!HcZ.contains(paramString))
        {
          e.a.a((e)com.tencent.mm.plugin.findersdk.b.HbT, "cgiReportNormal", false, null, false, (kotlin.g.a.a)new d(paramString, paramInt, localr), 28);
          HcZ.add(paramString);
        }
        if (BuildInfo.DEBUG) {
          Log.i("Finder.CgiStrategy", "isBlock normal case " + paramString + ' ' + paramInt);
        }
        AppMethodBeat.o(273873);
        return true;
      }
    }
    AppMethodBeat.o(273873);
    return false;
  }
  
  public static boolean frY()
  {
    return HcU == 2;
  }
  
  public static void init()
  {
    Object localObject2 = null;
    AppMethodBeat.i(273862);
    f.a locala = new f.a();
    Object localObject1 = com.tencent.mm.plugin.findersdk.storage.config.b.Hdw;
    String str = com.tencent.mm.plugin.findersdk.storage.config.b.fsg();
    List localList = Util.stringToList(str, ",");
    s.s(localList, "it");
    localObject1 = (String)p.ae(localList, 0);
    if (localObject1 == null)
    {
      localObject1 = null;
      i = Util.safeParseInt((String)localObject1);
      localObject1 = (String)p.ae(localList, 1);
      if (localObject1 != null) {
        break label194;
      }
      localObject1 = null;
      label80:
      HcV = new a(i, Util.safeParseInt((String)localObject1));
      localObject1 = (String)p.ae(localList, 2);
      if (localObject1 != null) {
        break label208;
      }
      localObject1 = null;
      label112:
      i = Util.safeParseInt((String)localObject1);
      localObject1 = (String)p.ae(localList, 3);
      if (localObject1 != null) {
        break label222;
      }
    }
    label194:
    label208:
    label222:
    for (localObject1 = localObject2;; localObject1 = n.bq((CharSequence)localObject1).toString())
    {
      HcW = new a(i, Util.safeParseInt((String)localObject1));
      localObject1 = com.tencent.mm.plugin.findersdk.storage.config.b.Hdw;
      localObject1 = com.tencent.mm.plugin.findersdk.storage.config.b.fsh();
      if (localObject1 != null) {
        break label236;
      }
      localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(273862);
      throw ((Throwable)localObject1);
      localObject1 = n.bq((CharSequence)localObject1).toString();
      break;
      localObject1 = n.bq((CharSequence)localObject1).toString();
      break label80;
      localObject1 = n.bq((CharSequence)localObject1).toString();
      break label112;
    }
    label236:
    int i = Util.safeParseInt(n.bq((CharSequence)localObject1).toString());
    HcU = i;
    if (i > 0)
    {
      Log.e("Finder.CgiStrategy", s.X("blockAll cgi ", Integer.valueOf(HcU)));
      AppMethodBeat.o(273862);
      return;
    }
    localObject2 = com.tencent.mm.plugin.findersdk.storage.config.b.Hdw;
    localObject2 = Util.stringToList(com.tencent.mm.plugin.findersdk.storage.config.b.fsh(), ",");
    Log.i("Finder.CgiStrategy", "init blockString " + (String)localObject1 + " limitString " + str + " size " + ((List)localObject2).size() + " autoLimitErrorBlock:" + HcV.count + ' ' + HcV.time + " autoLimitBlock:" + HcW.count + ' ' + HcW.time + " errorReport " + HcZ.size() + ' ' + Hda.size() + " cost:" + locala.aPY());
    HcT.clear();
    HcT.addAll((Collection)localObject2);
    AppMethodBeat.o(273862);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/cgi/report/CgiStrategy$ServerLimit;", "", "count", "", "time", "", "(IJ)V", "getCount", "()I", "setCount", "(I)V", "getTime", "()J", "setTime", "(J)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
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
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof a)) {
          return false;
        }
        paramObject = (a)paramObject;
        if (this.count != paramObject.count) {
          return false;
        }
      } while (this.time == paramObject.time);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(273847);
      int i = this.count;
      int j = q.a..ExternalSyntheticBackport0.m(this.time);
      AppMethodBeat.o(273847);
      return i * 31 + j;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(273837);
      String str = "ServerLimit(count=" + this.count + ", time=" + this.time + ')';
      AppMethodBeat.o(273837);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/cgi/report/CgiStrategy$TimeLimit;", "", "count", "", "lastTryTime", "", "(IJ)V", "getCount", "()I", "setCount", "(I)V", "getLastTryTime", "()J", "setLastTryTime", "(J)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    int count = 0;
    long hxK;
    
    public b(long paramLong)
    {
      this.hxK = paramLong;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof b)) {
          return false;
        }
        paramObject = (b)paramObject;
        if (this.count != paramObject.count) {
          return false;
        }
      } while (this.hxK == paramObject.hxK);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(273845);
      int i = this.count;
      int j = q.a..ExternalSyntheticBackport0.m(this.hxK);
      AppMethodBeat.o(273845);
      return i * 31 + j;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(273838);
      String str = "TimeLimit(count=" + this.count + ", lastTryTime=" + this.hxK + ')';
      AppMethodBeat.o(273838);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<String>
  {
    c(String paramString, int paramInt, r<Boolean, a.b> paramr)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<String>
  {
    d(String paramString, int paramInt, r<Boolean, a.b> paramr)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.b.a.a
 * JD-Core Version:    0.7.0.1
 */