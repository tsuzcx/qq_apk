package com.tencent.mm.plugin.appbrand.widget.input.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b
{
  public final int rzY;
  
  static
  {
    AppMethodBeat.i(131524);
    rzS = new b("DONE", 0, 6);
    rzT = new b("SEARCH", 1, 3);
    rzU = new b("NEXT", 2, 5);
    rzV = new b("GO", 3, 2);
    rzW = new b("SEND", 4, 4);
    rzX = new b("RETURN", 5, 0);
    rzZ = new b[] { rzS, rzT, rzU, rzV, rzW, rzX };
    AppMethodBeat.o(131524);
  }
  
  private b(int paramInt)
  {
    this.rzY = paramInt;
  }
  
  public static b anD(String paramString)
  {
    AppMethodBeat.i(131523);
    paramString = (b)d.h(paramString, b.class);
    AppMethodBeat.o(131523);
    return paramString;
  }
  
  public static b kv(boolean paramBoolean)
  {
    if (paramBoolean) {
      return rzX;
    }
    return rzS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.e.b
 * JD-Core Version:    0.7.0.1
 */