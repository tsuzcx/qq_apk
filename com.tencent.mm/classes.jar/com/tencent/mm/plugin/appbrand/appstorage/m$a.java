package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum m$a
{
  static
  {
    AppMethodBeat.i(101782);
    gZV = new a("NONE", 0);
    gZW = new a("UNKNOWN", 1);
    gZX = new a("MISSING_PARAMS", 2);
    gZY = new a("NO_SUCH_KEY", 3);
    gZZ = new a("QUOTA_REACHED", 4);
    haa = new a[] { gZV, gZW, gZX, gZY, gZZ };
    AppMethodBeat.o(101782);
  }
  
  private m$a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.m.a
 * JD-Core Version:    0.7.0.1
 */