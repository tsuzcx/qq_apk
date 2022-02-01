package com.tencent.mm.plugin.cast.h.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/cast/transportclient/connection/Status;", "", "(Ljava/lang/String;I)V", "DISCONNECTED", "CONNECTING", "CONNECTED", "TIMEOUT", "ERROR", "INIT_MEDIACODEC_FAILED", "REMOTE_SERVICE_REMOVED", "plugin-cast_release"})
public enum b
{
  static
  {
    AppMethodBeat.i(189555);
    b localb1 = new b("DISCONNECTED", 0);
    tKq = localb1;
    b localb2 = new b("CONNECTING", 1);
    tKr = localb2;
    b localb3 = new b("CONNECTED", 2);
    tKs = localb3;
    b localb4 = new b("TIMEOUT", 3);
    tKt = localb4;
    b localb5 = new b("ERROR", 4);
    tKu = localb5;
    b localb6 = new b("INIT_MEDIACODEC_FAILED", 5);
    tKv = localb6;
    b localb7 = new b("REMOTE_SERVICE_REMOVED", 6);
    tKw = localb7;
    tKx = new b[] { localb1, localb2, localb3, localb4, localb5, localb6, localb7 };
    AppMethodBeat.o(189555);
  }
  
  private b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.cast.h.a.b
 * JD-Core Version:    0.7.0.1
 */