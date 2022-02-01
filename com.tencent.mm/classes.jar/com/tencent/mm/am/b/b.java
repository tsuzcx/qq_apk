package com.tencent.mm.am.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/modelbase/observer/NetSceneAction;", "", "(Ljava/lang/String;I)V", "Init", "DoScene", "OnEnd", "mmkernel_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum b
{
  static
  {
    AppMethodBeat.i(236835);
    ovz = new b("Init", 0);
    ovA = new b("DoScene", 1);
    ovB = new b("OnEnd", 2);
    ovC = new b[] { ovz, ovA, ovB };
    AppMethodBeat.o(236835);
  }
  
  private b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.am.b.b
 * JD-Core Version:    0.7.0.1
 */