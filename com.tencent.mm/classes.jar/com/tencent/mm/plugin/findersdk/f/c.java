package com.tencent.mm.plugin.findersdk.f;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/findersdk/trace/TimeConsumingTrace;", "", "traceName", "", "(Ljava/lang/String;)V", "state", "", "tracesMap", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "beginTrace", "", "node", "endTrace", "getHead", "", "map", "getTail", "trace", "traceToJson", "Lorg/json/JSONObject;", "traceToString", "Companion", "finder-sdk_release"})
public class c
{
  public static final a Bxj;
  private final LinkedHashMap<String, Long> Bxh;
  private final String Bxi;
  private int state;
  
  static
  {
    AppMethodBeat.i(209947);
    Bxj = new a((byte)0);
    AppMethodBeat.o(209947);
  }
  
  public c(String paramString)
  {
    AppMethodBeat.i(209946);
    this.Bxi = paramString;
    this.Bxh = new LinkedHashMap();
    this.state = 1;
    AppMethodBeat.o(209946);
  }
  
  private static Map.Entry<String, Long> a(LinkedHashMap<String, Long> paramLinkedHashMap)
  {
    AppMethodBeat.i(209944);
    paramLinkedHashMap = (Map.Entry)((Map)paramLinkedHashMap).entrySet().iterator().next();
    AppMethodBeat.o(209944);
    return paramLinkedHashMap;
  }
  
  private static Map.Entry<String, Long> b(LinkedHashMap<String, Long> paramLinkedHashMap)
  {
    AppMethodBeat.i(209945);
    Iterator localIterator = ((Map)paramLinkedHashMap).entrySet().iterator();
    for (paramLinkedHashMap = null; localIterator.hasNext(); paramLinkedHashMap = (Map.Entry)localIterator.next()) {}
    AppMethodBeat.o(209945);
    return paramLinkedHashMap;
  }
  
  public final void aGV(String paramString)
  {
    AppMethodBeat.i(209930);
    p.k(paramString, "node");
    if (this.state == 3)
    {
      AppMethodBeat.o(209930);
      return;
    }
    ((Map)this.Bxh).put(paramString, Long.valueOf(SystemClock.elapsedRealtime()));
    this.state = 2;
    AppMethodBeat.o(209930);
  }
  
  public final JSONObject eoa()
  {
    long l3 = 0L;
    AppMethodBeat.i(209941);
    Object localObject = b(this.Bxh);
    if (localObject != null)
    {
      localObject = (Long)((Map.Entry)localObject).getValue();
      if (localObject == null) {}
    }
    JSONObject localJSONObject;
    for (long l1 = ((Long)localObject).longValue();; l1 = 0L)
    {
      localObject = a(this.Bxh);
      long l2 = l3;
      if (localObject != null)
      {
        localObject = (Long)((Map.Entry)localObject).getValue();
        l2 = l3;
        if (localObject != null) {
          l2 = ((Long)localObject).longValue();
        }
      }
      localJSONObject = new JSONObject();
      localJSONObject.put("traceName", this.Bxi);
      localJSONObject.put("totalTime", l1 - l2);
      Iterator localIterator = ((Map)this.Bxh).entrySet().iterator();
      Map.Entry localEntry;
      for (localObject = (Map.Entry)localIterator.next(); localIterator.hasNext(); localObject = localEntry)
      {
        localEntry = (Map.Entry)localIterator.next();
        localJSONObject.put((String)((Map.Entry)localObject).getKey() + "->" + (String)localEntry.getKey(), ((Number)localEntry.getValue()).longValue() - ((Number)((Map.Entry)localObject).getValue()).longValue());
      }
    }
    AppMethodBeat.o(209941);
    return localJSONObject;
  }
  
  public final void fo(String paramString)
  {
    AppMethodBeat.i(209927);
    p.k(paramString, "node");
    this.Bxh.clear();
    ((Map)this.Bxh).put(paramString, Long.valueOf(SystemClock.elapsedRealtime()));
    this.state = 1;
    AppMethodBeat.o(209927);
  }
  
  public void fp(String paramString)
  {
    long l3 = 0L;
    AppMethodBeat.i(209936);
    p.k(paramString, "node");
    if (this.state == 3)
    {
      AppMethodBeat.o(209936);
      return;
    }
    ((Map)this.Bxh).put(paramString, Long.valueOf(SystemClock.elapsedRealtime()));
    paramString = b(this.Bxh);
    if (paramString != null)
    {
      paramString = (Long)paramString.getValue();
      if (paramString == null) {}
    }
    StringBuilder localStringBuilder;
    for (long l1 = paramString.longValue();; l1 = 0L)
    {
      paramString = a(this.Bxh);
      long l2 = l3;
      if (paramString != null)
      {
        paramString = (Long)paramString.getValue();
        l2 = l3;
        if (paramString != null) {
          l2 = paramString.longValue();
        }
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TimeConsumingTrace " + this.Bxi + " total:" + (l1 - l2) + '\n');
      Iterator localIterator = ((Map)this.Bxh).entrySet().iterator();
      Map.Entry localEntry;
      for (paramString = (Map.Entry)localIterator.next(); localIterator.hasNext(); paramString = localEntry)
      {
        localEntry = (Map.Entry)localIterator.next();
        localStringBuilder.append((String)paramString.getKey()).append("-->").append((String)localEntry.getKey()).append(":").append(((Number)localEntry.getValue()).longValue() - ((Number)paramString.getValue()).longValue()).append("\n");
      }
    }
    paramString = localStringBuilder.toString();
    p.j(paramString, "traceBuilder.toString()");
    this.state = 3;
    Log.i("TimeConsumingTrace", paramString);
    AppMethodBeat.o(209936);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/findersdk/trace/TimeConsumingTrace$Companion;", "", "()V", "STATE_END", "", "STATE_IDLE", "STATE_TRACE", "TAG", "", "finder-sdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.f.c
 * JD-Core Version:    0.7.0.1
 */