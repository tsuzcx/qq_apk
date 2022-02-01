package com.tencent.luggage.sdk.processes;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/sdk/processes/LuggageStartStrategy;", "", "(Ljava/lang/String;I)V", "CREATE_NEW", "RESUME_EXISTED", "luggage-wechat-full-sdk_release"})
public enum h
{
  static
  {
    AppMethodBeat.i(234766);
    h localh1 = new h("CREATE_NEW", 0);
    cBV = localh1;
    h localh2 = new h("RESUME_EXISTED", 1);
    cBW = localh2;
    cBX = new h[] { localh1, localh2 };
    AppMethodBeat.o(234766);
  }
  
  private h() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.sdk.processes.h
 * JD-Core Version:    0.7.0.1
 */