package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/modelmulti/ContinueSyncScene;", "", "(Ljava/lang/String;I)V", "DoCmdAccNotReady", "DoCmdEmptyResp", "DoCmdEmptyCmdList", "DoCmdProcessEnd", "AsyncProcessEnd", "mmkernel_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum b
{
  static
  {
    AppMethodBeat.i(243115);
    oLq = new b("DoCmdAccNotReady", 0);
    oLr = new b("DoCmdEmptyResp", 1);
    oLs = new b("DoCmdEmptyCmdList", 2);
    oLt = new b("DoCmdProcessEnd", 3);
    oLu = new b("AsyncProcessEnd", 4);
    oLv = new b[] { oLq, oLr, oLs, oLt, oLu };
    AppMethodBeat.o(243115);
  }
  
  private b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelmulti.b
 * JD-Core Version:    0.7.0.1
 */