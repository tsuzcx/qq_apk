package com.tencent.mm.loader.h;

import com.tencent.mm.loader.b.a.c;
import com.tencent.mm.loader.h.b.a;
import java.io.OutputStream;

public final class b
  extends f<byte[]>
{
  public String contentType;
  private f.a gMl;
  
  private b(byte[] paramArrayOfByte, String paramString, f.a<byte[]> parama)
  {
    super(paramArrayOfByte);
    this.contentType = paramString;
    this.gMl = parama;
  }
  
  public static b d(byte[] paramArrayOfByte, String paramString)
  {
    new b(paramArrayOfByte, paramString, new f.a() {});
  }
  
  public final a aoH()
  {
    return this.gMl.aoI();
  }
  
  public final void b(OutputStream paramOutputStream)
  {
    c localc = c.gJp;
    c.a((byte[])this.data, paramOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.h.b
 * JD-Core Version:    0.7.0.1
 */