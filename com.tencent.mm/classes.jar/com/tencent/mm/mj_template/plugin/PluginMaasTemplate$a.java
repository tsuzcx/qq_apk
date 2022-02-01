package com.tencent.mm.mj_template.plugin;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.FlutterEngine;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/plugin/PluginMaasTemplate$CachedEngineInfo;", "", "eventTopicId", "", "priorityTplId", "", "engineId", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "(JLjava/lang/String;Ljava/lang/String;Lio/flutter/embedding/engine/FlutterEngine;)V", "getEngineId", "()Ljava/lang/String;", "setEngineId", "(Ljava/lang/String;)V", "getEventTopicId", "()J", "getFlutterEngine", "()Lio/flutter/embedding/engine/FlutterEngine;", "setFlutterEngine", "(Lio/flutter/embedding/engine/FlutterEngine;)V", "getPriorityTplId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PluginMaasTemplate$a
{
  public static final a ocC;
  String engineId;
  FlutterEngine flutterEngine;
  private final long ocD;
  private final String ocE;
  
  static
  {
    AppMethodBeat.i(239655);
    ocC = new a((byte)0);
    AppMethodBeat.o(239655);
  }
  
  public PluginMaasTemplate$a()
  {
    this(0L, null, null, 15);
  }
  
  private PluginMaasTemplate$a(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(239628);
    this.ocD = paramLong;
    this.ocE = paramString1;
    this.engineId = paramString2;
    this.flutterEngine = null;
    AppMethodBeat.o(239628);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(239667);
    if (this == paramObject)
    {
      AppMethodBeat.o(239667);
      return true;
    }
    Class localClass = getClass();
    if (paramObject == null) {}
    for (Object localObject = null; !s.p(localClass, localObject); localObject = paramObject.getClass())
    {
      AppMethodBeat.o(239667);
      return false;
    }
    if (paramObject == null)
    {
      paramObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.mj_template.plugin.PluginMaasTemplate.CachedEngineInfo");
      AppMethodBeat.o(239667);
      throw paramObject;
    }
    if (this.ocD != ((a)paramObject).ocD)
    {
      AppMethodBeat.o(239667);
      return false;
    }
    if (!s.p(this.ocE, ((a)paramObject).ocE))
    {
      AppMethodBeat.o(239667);
      return false;
    }
    AppMethodBeat.o(239667);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(239677);
    int i = q.a..ExternalSyntheticBackport0.m(this.ocD);
    int j = this.ocE.hashCode();
    AppMethodBeat.o(239677);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(239689);
    String str = "CachedEngineInfo(eventTopicId=" + this.ocD + ", priorityTplId=" + this.ocE + ", engineId=" + this.engineId + ", flutterEngine=" + this.flutterEngine + ')';
    AppMethodBeat.o(239689);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/plugin/PluginMaasTemplate$CachedEngineInfo$Companion;", "", "()V", "EMPTY_EVENT_TOPIC_ID", "", "EMPTY_PRIORITY_TPL_ID", "", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.mj_template.plugin.PluginMaasTemplate.a
 * JD-Core Version:    0.7.0.1
 */