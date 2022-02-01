package com.tencent.mm.plugin.appbrand.widget.input.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b
{
  public final int mIp;
  
  static
  {
    AppMethodBeat.i(131524);
    mIj = new b("DONE", 0, 6);
    mIk = new b("SEARCH", 1, 3);
    mIl = new b("NEXT", 2, 5);
    mIm = new b("GO", 3, 2);
    mIn = new b("SEND", 4, 4);
    mIo = new b("RETURN", 5, 0);
    mIq = new b[] { mIj, mIk, mIl, mIm, mIn, mIo };
    AppMethodBeat.o(131524);
  }
  
  private b(int paramInt)
  {
    this.mIp = paramInt;
  }
  
  public static b RV(String paramString)
  {
    AppMethodBeat.i(131523);
    paramString = (b)d.h(paramString, b.class);
    AppMethodBeat.o(131523);
    return paramString;
  }
  
  public static b ic(boolean paramBoolean)
  {
    if (paramBoolean) {
      return mIo;
    }
    return mIj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.d.b
 * JD-Core Version:    0.7.0.1
 */