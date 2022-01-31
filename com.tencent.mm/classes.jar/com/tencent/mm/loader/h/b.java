package com.tencent.mm.loader.h;

import com.tencent.mm.loader.b.a.c;
import com.tencent.mm.loader.h.b.a;
import java.io.OutputStream;

public final class b
  extends f<byte[]>
{
  public String aZn;
  private f.a ePV;
  
  public b(byte[] paramArrayOfByte, String paramString, f.a<byte[]> parama)
  {
    super(paramArrayOfByte);
    this.aZn = paramString;
    this.ePV = parama;
  }
  
  public final a TU()
  {
    return this.ePV.TV();
  }
  
  public final void b(OutputStream paramOutputStream)
  {
    c localc = c.eNn;
    c.a((byte[])this.data, paramOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.h.b
 * JD-Core Version:    0.7.0.1
 */