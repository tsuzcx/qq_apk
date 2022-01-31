package com.tencent.mm.loader.h.b;

import java.io.InputStream;

final class a$e
  implements d
{
  InputStream eQr;
  
  public a$e(InputStream paramInputStream)
  {
    this.eQr = paramInputStream;
  }
  
  public final InputStream Uh()
  {
    return this.eQr;
  }
  
  public final void close()
  {
    a.o(this.eQr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.loader.h.b.a.e
 * JD-Core Version:    0.7.0.1
 */