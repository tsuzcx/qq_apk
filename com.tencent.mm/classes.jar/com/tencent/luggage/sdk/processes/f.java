package com.tencent.luggage.sdk.processes;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramStatus;", "", "(Ljava/lang/String;I)V", "INIT", "PRE_RENDERED", "RUNNING", "luggage-wechat-full-sdk_release"})
public enum f
{
  static
  {
    AppMethodBeat.i(237387);
    f localf1 = new f("INIT", 0);
    cBL = localf1;
    f localf2 = new f("PRE_RENDERED", 1);
    cBM = localf2;
    f localf3 = new f("RUNNING", 2);
    cBN = localf3;
    cBO = new f[] { localf1, localf2, localf3 };
    AppMethodBeat.o(237387);
  }
  
  private f() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.sdk.processes.f
 * JD-Core Version:    0.7.0.1
 */