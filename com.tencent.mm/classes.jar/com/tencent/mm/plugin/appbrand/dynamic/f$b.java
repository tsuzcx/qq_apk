package com.tencent.mm.plugin.appbrand.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class f$b
{
  String appId;
  int fmF;
  String hny;
  LinkedList<Integer> hnz;
  String query;
  
  public f$b(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(10684);
    this.fmF = 0;
    this.hny = "";
    this.appId = "";
    this.query = "";
    this.hnz = new LinkedList();
    this.hny = paramString1;
    this.appId = paramString2;
    this.fmF = paramInt;
    this.query = paramString3;
    AppMethodBeat.o(10684);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.f.b
 * JD-Core Version:    0.7.0.1
 */