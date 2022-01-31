package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum d$c
{
  static
  {
    AppMethodBeat.i(60315);
    oIF = new c("WaitStart", 0);
    oIG = new c("Start", 1);
    oIH = new c("PrepareStop", 2);
    oII = new c("WaitStop", 3);
    oIJ = new c("Stop", 4);
    oIK = new c("WaitSend", 5);
    oIL = new c("Sent", 6);
    oIM = new c("Error", 7);
    oIN = new c("Initialized", 8);
    oIO = new c("Pause", 9);
    oIP = new c[] { oIF, oIG, oIH, oII, oIJ, oIK, oIL, oIM, oIN, oIO };
    AppMethodBeat.o(60315);
  }
  
  private d$c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.d.c
 * JD-Core Version:    0.7.0.1
 */