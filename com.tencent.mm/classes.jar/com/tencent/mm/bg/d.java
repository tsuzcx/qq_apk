package com.tencent.mm.bg;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  String hqX;
  double hqY;
  double latitude;
  double longitude;
  
  public final String toString()
  {
    AppMethodBeat.i(150911);
    String str = "gspType:" + this.hqX + " longitude: " + this.longitude + " latitude: " + this.latitude + " distance: " + this.hqY;
    AppMethodBeat.o(150911);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bg.d
 * JD-Core Version:    0.7.0.1
 */