package com.bumptech.glide.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a
{
  static
  {
    AppMethodBeat.i(76835);
    aCP = new a("LOCAL", 0);
    aCQ = new a("REMOTE", 1);
    aCR = new a("DATA_DISK_CACHE", 2);
    aCS = new a("RESOURCE_DISK_CACHE", 3);
    aCT = new a("MEMORY_CACHE", 4);
    aCU = new a[] { aCP, aCQ, aCR, aCS, aCT };
    AppMethodBeat.o(76835);
  }
  
  private a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.a
 * JD-Core Version:    0.7.0.1
 */