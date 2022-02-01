package com.tencent.luggage.sdk.processes;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramStatus;", "", "(Ljava/lang/String;I)V", "INIT", "PRE_RENDERED", "RUNNING", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum f
{
  static
  {
    AppMethodBeat.i(220453);
    euq = new f("INIT", 0);
    eur = new f("PRE_RENDERED", 1);
    eus = new f("RUNNING", 2);
    eut = new f[] { euq, eur, eus };
    AppMethodBeat.o(220453);
  }
  
  private f() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.sdk.processes.f
 * JD-Core Version:    0.7.0.1
 */