package com.tencent.mm.ipcinvoker;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  public String eEf;
  
  public d(String paramString)
  {
    this.eEf = paramString;
  }
  
  public static String ae(Object paramObject)
  {
    AppMethodBeat.i(114020);
    paramObject = "Token#IPCObserver#" + paramObject.hashCode();
    AppMethodBeat.o(114020);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.d
 * JD-Core Version:    0.7.0.1
 */