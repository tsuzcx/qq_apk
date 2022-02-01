package com.google.android.exoplayer2.f.b;

import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class a
  extends com.google.android.exoplayer2.f.b
{
  private final b btk;
  
  public a(List<byte[]> paramList)
  {
    super("DvbDecoder");
    AppMethodBeat.i(92790);
    paramList = new m((byte[])paramList.get(0));
    this.btk = new b(paramList.readUnsignedShort(), paramList.readUnsignedShort());
    AppMethodBeat.o(92790);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.f.b.a
 * JD-Core Version:    0.7.0.1
 */