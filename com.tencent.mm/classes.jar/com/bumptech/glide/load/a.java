package com.bumptech.glide.load;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a
{
  static
  {
    AppMethodBeat.i(76835);
    aEG = new a("LOCAL", 0);
    aEH = new a("REMOTE", 1);
    aEI = new a("DATA_DISK_CACHE", 2);
    aEJ = new a("RESOURCE_DISK_CACHE", 3);
    aEK = new a("MEMORY_CACHE", 4);
    aEL = new a[] { aEG, aEH, aEI, aEJ, aEK };
    AppMethodBeat.o(76835);
  }
  
  private a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.a
 * JD-Core Version:    0.7.0.1
 */