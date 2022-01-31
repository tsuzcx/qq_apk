package com.tencent.mm.plugin.appbrand.performance;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c$a
{
  long aID;
  String appId;
  String category;
  String iAS;
  String iAT;
  String name;
  long start;
  
  public final String toString()
  {
    AppMethodBeat.i(114382);
    String str = this.name + "," + this.category + "," + this.iAS + "," + (this.start - c.aKq()) + "," + (this.aID - c.aKq()) + "," + this.iAT;
    AppMethodBeat.o(114382);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.performance.c.a
 * JD-Core Version:    0.7.0.1
 */