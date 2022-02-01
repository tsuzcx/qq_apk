package com.tencent.mm.plugin.cast.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/cast/transportclient/connection/Status;", "", "(Ljava/lang/String;I)V", "DISCONNECTED", "CONNECTING", "CONNECTED", "TIMEOUT", "ERROR", "INIT_MEDIACODEC_FAILED", "REMOTE_SERVICE_REMOVED", "plugin-cast_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum b
{
  static
  {
    AppMethodBeat.i(274295);
    wNJ = new b("DISCONNECTED", 0);
    wNK = new b("CONNECTING", 1);
    wNL = new b("CONNECTED", 2);
    wNM = new b("TIMEOUT", 3);
    wNN = new b("ERROR", 4);
    wNO = new b("INIT_MEDIACODEC_FAILED", 5);
    wNP = new b("REMOTE_SERVICE_REMOVED", 6);
    wNQ = new b[] { wNJ, wNK, wNL, wNM, wNN, wNO, wNP };
    AppMethodBeat.o(274295);
  }
  
  private b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.cast.g.a.b
 * JD-Core Version:    0.7.0.1
 */