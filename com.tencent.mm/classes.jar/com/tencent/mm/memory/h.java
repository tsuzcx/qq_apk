package com.tencent.mm.memory;

import com.tencent.mm.sdk.b;
import com.tencent.mm.sdk.f.e;
import java.nio.ByteBuffer;

public final class h
  extends b<ByteBuffer>
{
  public static h dPc = new h();
  
  static
  {
    e.post(new h.1(), "DecodeTempStorage_preload");
  }
  
  private h()
  {
    super(20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.memory.h
 * JD-Core Version:    0.7.0.1
 */