package com.tencent.mm.be;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  String fOb;
  double fOc;
  double latitude;
  double longitude;
  
  public final String toString()
  {
    AppMethodBeat.i(78562);
    String str = "gspType:" + this.fOb + " longitude: " + this.longitude + " latitude: " + this.latitude + " distance: " + this.fOc;
    AppMethodBeat.o(78562);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.be.d
 * JD-Core Version:    0.7.0.1
 */