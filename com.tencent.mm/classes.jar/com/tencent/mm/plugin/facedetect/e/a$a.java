package com.tencent.mm.plugin.facedetect.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a$a
{
  static
  {
    AppMethodBeat.i(104077);
    rvc = new a("UNINITIALIZED", 0);
    rvd = new a("INITIALIZED", 1);
    rve = new a("STARTED", 2);
    rvf = new a("STOPPING", 3);
    rvg = new a("STOPPED", 4);
    rvh = new a("CANCELLED", 5);
    rvi = new a[] { rvc, rvd, rve, rvf, rvg, rvh };
    AppMethodBeat.o(104077);
  }
  
  private a$a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.e.a.a
 * JD-Core Version:    0.7.0.1
 */