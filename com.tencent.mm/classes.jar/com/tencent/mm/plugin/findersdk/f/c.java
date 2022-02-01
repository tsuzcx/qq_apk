package com.tencent.mm.plugin.findersdk.f;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/trace/TimeConsumingTrace;", "", "traceName", "", "(Ljava/lang/String;)V", "state", "", "totalTime", "", "getTotalTime", "()J", "setTotalTime", "(J)V", "traceMsg", "tracesMap", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "beginTrace", "", "node", "endTrace", "getHead", "", "map", "getTail", "getTraceMsg", "trace", "traceToJson", "Lorg/json/JSONObject;", "traceToString", "Companion", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public class c
{
  public static final a HeK;
  private final String HeL;
  private final LinkedHashMap<String, Long> HeM;
  public long hqS;
  private int state;
  private String traceMsg;
  
  static
  {
    AppMethodBeat.i(273724);
    HeK = new a((byte)0);
    AppMethodBeat.o(273724);
  }
  
  public c(String paramString)
  {
    AppMethodBeat.i(273705);
    this.HeL = paramString;
    this.HeM = new LinkedHashMap();
    this.state = 1;
    this.traceMsg = "";
    AppMethodBeat.o(273705);
  }
  
  private static Map.Entry<String, Long> a(LinkedHashMap<String, Long> paramLinkedHashMap)
  {
    AppMethodBeat.i(273714);
    paramLinkedHashMap = (Map.Entry)((Map)paramLinkedHashMap).entrySet().iterator().next();
    AppMethodBeat.o(273714);
    return paramLinkedHashMap;
  }
  
  private static Map.Entry<String, Long> b(LinkedHashMap<String, Long> paramLinkedHashMap)
  {
    AppMethodBeat.i(273720);
    Iterator localIterator = ((Map)paramLinkedHashMap).entrySet().iterator();
    for (paramLinkedHashMap = null; localIterator.hasNext(); paramLinkedHashMap = (Map.Entry)localIterator.next()) {}
    AppMethodBeat.o(273720);
    return paramLinkedHashMap;
  }
  
  public final void aDn(String paramString)
  {
    AppMethodBeat.i(273741);
    s.u(paramString, "node");
    if (this.state == 3)
    {
      AppMethodBeat.o(273741);
      return;
    }
    ((Map)this.HeM).put(paramString, Long.valueOf(SystemClock.elapsedRealtime()));
    this.state = 2;
    AppMethodBeat.o(273741);
  }
  
  public final JSONObject ftd()
  {
    long l2 = 0L;
    AppMethodBeat.i(273768);
    Object localObject = b(this.HeM);
    long l1;
    if (localObject == null)
    {
      l1 = 0L;
      localObject = a(this.HeM);
      if (localObject != null) {
        break label234;
      }
    }
    JSONObject localJSONObject;
    for (;;)
    {
      localJSONObject = new JSONObject();
      localJSONObject.put("traceName", this.HeL);
      localJSONObject.put("totalTime", l1 - l2);
      Iterator localIterator = ((Map)this.HeM).entrySet().iterator();
      Map.Entry localEntry;
      for (localObject = (Map.Entry)localIterator.next(); localIterator.hasNext(); localObject = localEntry)
      {
        localEntry = (Map.Entry)localIterator.next();
        localJSONObject.put((String)((Map.Entry)localObject).getKey() + "->" + (String)localEntry.getKey(), ((Number)localEntry.getValue()).longValue() - ((Number)((Map.Entry)localObject).getValue()).longValue());
      }
      localObject = (Long)((Map.Entry)localObject).getValue();
      if (localObject == null)
      {
        l1 = 0L;
        break;
      }
      l1 = ((Long)localObject).longValue();
      break;
      label234:
      localObject = (Long)((Map.Entry)localObject).getValue();
      if (localObject != null) {
        l2 = ((Long)localObject).longValue();
      }
    }
    AppMethodBeat.o(273768);
    return localJSONObject;
  }
  
  public final void gF(String paramString)
  {
    AppMethodBeat.i(273733);
    s.u(paramString, "node");
    this.HeM.clear();
    this.traceMsg = "";
    ((Map)this.HeM).put(paramString, Long.valueOf(SystemClock.elapsedRealtime()));
    this.state = 1;
    AppMethodBeat.o(273733);
  }
  
  public void gG(String paramString)
  {
    long l2 = 0L;
    AppMethodBeat.i(273755);
    s.u(paramString, "node");
    if (this.state == 3)
    {
      AppMethodBeat.o(273755);
      return;
    }
    ((Map)this.HeM).put(paramString, Long.valueOf(SystemClock.elapsedRealtime()));
    paramString = b(this.HeM);
    long l1;
    if (paramString == null)
    {
      l1 = 0L;
      paramString = a(this.HeM);
      if (paramString != null) {
        break label290;
      }
    }
    StringBuilder localStringBuilder;
    for (;;)
    {
      this.hqS = (l1 - l2);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TimeConsumingTrace " + this.HeL + " total:" + this.hqS + '\n');
      Iterator localIterator = ((Map)this.HeM).entrySet().iterator();
      Map.Entry localEntry;
      for (paramString = (Map.Entry)localIterator.next(); localIterator.hasNext(); paramString = localEntry)
      {
        localEntry = (Map.Entry)localIterator.next();
        localStringBuilder.append((String)paramString.getKey()).append("-->").append((String)localEntry.getKey()).append(":").append(((Number)localEntry.getValue()).longValue() - ((Number)paramString.getValue()).longValue()).append("\n");
      }
      paramString = (Long)paramString.getValue();
      if (paramString == null)
      {
        l1 = 0L;
        break;
      }
      l1 = paramString.longValue();
      break;
      label290:
      paramString = (Long)paramString.getValue();
      if (paramString != null) {
        l2 = paramString.longValue();
      }
    }
    paramString = localStringBuilder.toString();
    s.s(paramString, "traceBuilder.toString()");
    this.traceMsg = paramString;
    this.state = 3;
    Log.i("TimeConsumingTrace", this.traceMsg);
    AppMethodBeat.o(273755);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/trace/TimeConsumingTrace$Companion;", "", "()V", "STATE_END", "", "STATE_IDLE", "STATE_TRACE", "TAG", "", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.f.c
 * JD-Core Version:    0.7.0.1
 */