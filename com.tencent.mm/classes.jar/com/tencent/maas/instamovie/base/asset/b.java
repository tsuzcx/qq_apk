package com.tencent.maas.instamovie.base.asset;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b
{
  final int value;
  
  static
  {
    AppMethodBeat.i(216941);
    eFr = new b("Image", 0, 0);
    eFs = new b("Video", 1, 1);
    eFt = new b[] { eFr, eFs };
    AppMethodBeat.o(216941);
  }
  
  private b(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.instamovie.base.asset.b
 * JD-Core Version:    0.7.0.1
 */