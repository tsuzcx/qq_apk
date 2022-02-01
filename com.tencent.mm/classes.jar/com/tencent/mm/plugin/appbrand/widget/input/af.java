package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface af
{
  public abstract void a(String paramString, int paramInt, a parama);
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(131516);
      mFJ = new a("COMPLETE", 0);
      mFK = new a("CONFIRM", 1);
      mFL = new a("CHANGED", 2);
      mFM = new a[] { mFJ, mFK, mFL };
      AppMethodBeat.o(131516);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.af
 * JD-Core Version:    0.7.0.1
 */