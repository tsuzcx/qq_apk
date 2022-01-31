package com.tencent.mm.plugin.appbrand.widget.recentview;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$a
{
  String juX;
  StringBuilder juY;
  StringBuilder juZ;
  StringBuilder jva;
  StringBuilder jvb;
  StringBuilder jvc;
  StringBuilder jvd;
  
  public b$a(String paramString)
  {
    AppMethodBeat.i(114933);
    this.juX = paramString;
    this.juY = new StringBuilder();
    this.juZ = new StringBuilder();
    this.jva = new StringBuilder();
    this.jvb = new StringBuilder();
    this.jvc = new StringBuilder();
    this.jvd = new StringBuilder();
    AppMethodBeat.o(114933);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(114934);
    String str = String.format("DuplicateNameInfo: {duplicatedName: %s, appId: %s, \nnameType: %s, \nlistType: %s, \nposition: %s, \nversion: %s, \nversionType: %s", new Object[] { this.juX, this.juY.toString(), this.juZ.toString(), this.jva.toString(), this.jvb.toString(), this.jvc.toString(), this.jvd.toString() });
    AppMethodBeat.o(114934);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.b.a
 * JD-Core Version:    0.7.0.1
 */