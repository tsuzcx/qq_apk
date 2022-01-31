package com.tencent.mm.plugin.facedetect.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a$a
{
  static
  {
    AppMethodBeat.i(558);
    mnS = new a("UNINITIALIZED", 0);
    mnT = new a("INITIALIZED", 1);
    mnU = new a("STARTED", 2);
    mnV = new a("STOPPING", 3);
    mnW = new a("STOPPED", 4);
    mnX = new a("CANCELLED", 5);
    mnY = new a[] { mnS, mnT, mnU, mnV, mnW, mnX };
    AppMethodBeat.o(558);
  }
  
  private a$a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.e.a.a
 * JD-Core Version:    0.7.0.1
 */