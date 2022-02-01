package com.tencent.mm.plugin.facedetect.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a$a
{
  static
  {
    AppMethodBeat.i(104077);
    qDh = new a("UNINITIALIZED", 0);
    qDi = new a("INITIALIZED", 1);
    qDj = new a("STARTED", 2);
    qDk = new a("STOPPING", 3);
    qDl = new a("STOPPED", 4);
    qDm = new a("CANCELLED", 5);
    qDn = new a[] { qDh, qDi, qDj, qDk, qDl, qDm };
    AppMethodBeat.o(104077);
  }
  
  private a$a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.e.a.a
 * JD-Core Version:    0.7.0.1
 */