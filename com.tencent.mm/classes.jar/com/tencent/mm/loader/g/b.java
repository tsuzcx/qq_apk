package com.tencent.mm.loader.g;

import com.tencent.mm.loader.cache.a.c;
import com.tencent.mm.loader.g.b.a;
import java.io.OutputStream;

public final class b
  extends f<byte[]>
{
  public String contentType;
  private f.a nsc;
  
  private b(byte[] paramArrayOfByte, String paramString, f.a<byte[]> parama)
  {
    super(paramArrayOfByte);
    this.contentType = paramString;
    this.nsc = parama;
  }
  
  public static b d(byte[] paramArrayOfByte, String paramString)
  {
    new b(paramArrayOfByte, paramString, new f.a() {});
  }
  
  public final void b(OutputStream paramOutputStream)
  {
    c localc = c.npb;
    c.b((byte[])this.cpt, paramOutputStream);
  }
  
  public final a blY()
  {
    return this.nsc.blZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.g.b
 * JD-Core Version:    0.7.0.1
 */