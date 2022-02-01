package com.tencent.mm.loader.h;

import com.tencent.mm.loader.b.a.c;
import com.tencent.mm.loader.h.b.a;
import java.io.OutputStream;

public final class b
  extends f<byte[]>
{
  public String bxn;
  private f.a gly;
  
  private b(byte[] paramArrayOfByte, String paramString, f.a<byte[]> parama)
  {
    super(paramArrayOfByte);
    this.bxn = paramString;
    this.gly = parama;
  }
  
  public static b d(byte[] paramArrayOfByte, String paramString)
  {
    new b(paramArrayOfByte, paramString, new f.a() {});
  }
  
  public final a ahF()
  {
    return this.gly.ahG();
  }
  
  public final void b(OutputStream paramOutputStream)
  {
    c localc = c.giE;
    c.a((byte[])this.data, paramOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.h.b
 * JD-Core Version:    0.7.0.1
 */