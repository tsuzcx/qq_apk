package com.f.a.b;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public int code;
  public Bundle result;
  
  public a()
  {
    AppMethodBeat.i(207428);
    this.code = 0;
    this.result = new Bundle();
    AppMethodBeat.o(207428);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(207431);
    String str = "CompactRet code:" + this.code + " result:" + this.result;
    AppMethodBeat.o(207431);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.f.a.b.a
 * JD-Core Version:    0.7.0.1
 */