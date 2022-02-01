package com.tencent.mm.plugin.comm.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/comm/kvstat/OpeartionState;", "", "(Ljava/lang/String;I)V", "DEFAULT", "APPEND", "ACTIONTRACE", "ELAPSE", "UNREPEAT", "REPEAT", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum c
{
  static
  {
    AppMethodBeat.i(260552);
    xeS = new c("DEFAULT", 0);
    xeT = new c("APPEND", 1);
    xeU = new c("ACTIONTRACE", 2);
    xeV = new c("ELAPSE", 3);
    xeW = new c("UNREPEAT", 4);
    xeX = new c("REPEAT", 5);
    xeY = new c[] { xeS, xeT, xeU, xeV, xeW, xeX };
    AppMethodBeat.o(260552);
  }
  
  private c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.comm.b.c
 * JD-Core Version:    0.7.0.1
 */