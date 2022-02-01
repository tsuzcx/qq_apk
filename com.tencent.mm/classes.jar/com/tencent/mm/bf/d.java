package com.tencent.mm.bf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  double hRA;
  String hRz;
  double latitude;
  double longitude;
  
  public final String toString()
  {
    AppMethodBeat.i(150911);
    String str = "gspType:" + this.hRz + " longitude: " + this.longitude + " latitude: " + this.latitude + " distance: " + this.hRA;
    AppMethodBeat.o(150911);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.bf.d
 * JD-Core Version:    0.7.0.1
 */