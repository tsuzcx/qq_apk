package com.google.android.exoplayer2.f.b;

import com.google.android.exoplayer2.i.j;
import java.util.List;

public final class a
  extends com.google.android.exoplayer2.f.b
{
  private final b aNN;
  
  public a(List<byte[]> paramList)
  {
    super("DvbDecoder");
    paramList = new j((byte[])paramList.get(0));
    this.aNN = new b(paramList.readUnsignedShort(), paramList.readUnsignedShort());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.f.b.a
 * JD-Core Version:    0.7.0.1
 */