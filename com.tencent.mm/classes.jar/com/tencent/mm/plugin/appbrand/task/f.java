package com.tencent.mm.plugin.appbrand.task;

import com.tencent.luggage.sdk.processes.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/task/AppBrandMiniProgramRecord;", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramRecord;", "appId", "", "debugType", "", "status", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramStatus;", "isPersistentApp", "", "(Ljava/lang/String;ILcom/tencent/luggage/sdk/processes/LuggageMiniProgramStatus;Z)V", "isGame", "()Z", "setGame", "(Z)V", "value", "isHalfScreen", "setHalfScreen", "startActivityTimestampMs", "", "getStartActivityTimestampMs", "()J", "setStartActivityTimestampMs", "(J)V", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends e
{
  public boolean ekt;
  public long qYe;
  boolean tVR;
  
  public f(String paramString, int paramInt, com.tencent.luggage.sdk.processes.f paramf, boolean paramBoolean)
  {
    super(paramString, paramInt, paramf, paramBoolean);
    AppMethodBeat.i(318585);
    AppMethodBeat.o(318585);
  }
  
  public final void kN(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.epd = true;
    }
    this.tVR = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.f
 * JD-Core Version:    0.7.0.1
 */