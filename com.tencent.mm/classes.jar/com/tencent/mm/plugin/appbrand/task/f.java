package com.tencent.mm.plugin.appbrand.task;

import com.tencent.luggage.sdk.processes.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/task/AppBrandMiniProgramRecord;", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramRecord;", "appId", "", "debugType", "", "status", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramStatus;", "isPersistentApp", "", "(Ljava/lang/String;ILcom/tencent/luggage/sdk/processes/LuggageMiniProgramStatus;Z)V", "isGame", "()Z", "setGame", "(Z)V", "value", "isHalfScreen", "setHalfScreen", "plugin-appbrand-integration_release"})
public final class f
  extends e
{
  public boolean csz;
  boolean qRj;
  
  public f(String paramString, int paramInt, com.tencent.luggage.sdk.processes.f paramf, boolean paramBoolean)
  {
    super(paramString, paramInt, paramf, paramBoolean);
    AppMethodBeat.i(283441);
    AppMethodBeat.o(283441);
  }
  
  public final void jz(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.cxb = true;
    }
    this.qRj = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.f
 * JD-Core Version:    0.7.0.1
 */