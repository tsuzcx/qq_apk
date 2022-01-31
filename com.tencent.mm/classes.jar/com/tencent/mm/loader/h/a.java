package com.tencent.mm.loader.h;

import com.tencent.mm.loader.b.a.c;
import java.io.OutputStream;

public final class a
  extends f<String>
{
  public String aZn;
  private f.a ePV;
  
  private a(String paramString1, String paramString2, f.a<String> parama)
  {
    super(paramString1);
    this.aZn = paramString2;
    this.ePV = parama;
  }
  
  public static a X(String paramString1, String paramString2)
  {
    return new a(paramString1, paramString2, new a.1(paramString1));
  }
  
  public final com.tencent.mm.loader.h.b.a TU()
  {
    return this.ePV.TV();
  }
  
  public final void b(OutputStream paramOutputStream)
  {
    c localc = c.eNn;
    c.a((String)this.data, paramOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.loader.h.a
 * JD-Core Version:    0.7.0.1
 */