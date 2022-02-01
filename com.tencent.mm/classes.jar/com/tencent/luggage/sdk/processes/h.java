package com.tencent.luggage.sdk.processes;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/processes/LuggageStartStrategy;", "", "(Ljava/lang/String;I)V", "CREATE_NEW", "RESUME_EXISTED", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum h
{
  static
  {
    AppMethodBeat.i(220447);
    euA = new h("CREATE_NEW", 0);
    euB = new h("RESUME_EXISTED", 1);
    euC = new h[] { euA, euB };
    AppMethodBeat.o(220447);
  }
  
  private h() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.processes.h
 * JD-Core Version:    0.7.0.1
 */