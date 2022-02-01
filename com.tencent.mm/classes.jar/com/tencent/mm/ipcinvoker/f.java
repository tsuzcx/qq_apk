package com.tencent.mm.ipcinvoker;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
{
  public String fZl;
  
  public f(String paramString)
  {
    this.fZl = paramString;
  }
  
  public static String bg(Object paramObject)
  {
    AppMethodBeat.i(158730);
    paramObject = "Token#IPCObserver#" + paramObject.hashCode();
    AppMethodBeat.o(158730);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.f
 * JD-Core Version:    0.7.0.1
 */