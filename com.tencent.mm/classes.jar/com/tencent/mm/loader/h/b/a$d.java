package com.tencent.mm.loader.h.b;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

final class a$d
  implements d
{
  InputStream bAO = null;
  byte[] mBuf;
  
  public a$d(byte[] paramArrayOfByte)
  {
    this.mBuf = paramArrayOfByte;
  }
  
  public final InputStream Uh()
  {
    if (this.bAO == null) {
      this.bAO = new ByteArrayInputStream(this.mBuf);
    }
    return this.bAO;
  }
  
  public final void close()
  {
    a.o(this.bAO);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.loader.h.b.a.d
 * JD-Core Version:    0.7.0.1
 */