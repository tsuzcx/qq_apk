package com.tencent.maas.instamovie;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(216874);
    eFk = new a("Null", 0, 0);
    eFl = new a("Asset", 1, 1);
    eFm = new a("TemplateDefault", 2, 2);
    eFn = new a[] { eFk, eFl, eFm };
    AppMethodBeat.o(216874);
  }
  
  private a(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.instamovie.a
 * JD-Core Version:    0.7.0.1
 */