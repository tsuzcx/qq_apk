package com.tencent.mm.loader.g;

import com.tencent.mm.loader.cache.a.c;
import java.io.OutputStream;

public final class a
  extends f<String>
{
  public String contentType;
  private f.a nsc;
  
  private a(String paramString1, String paramString2, f.a<String> parama)
  {
    super(paramString1);
    this.contentType = paramString2;
    this.nsc = parama;
  }
  
  public static a aL(String paramString1, String paramString2)
  {
    new a(paramString1, paramString2, new f.a() {});
  }
  
  public final void b(OutputStream paramOutputStream)
  {
    c localc = c.npb;
    c.a((String)this.cpt, paramOutputStream);
  }
  
  public final com.tencent.mm.loader.g.b.a blY()
  {
    return this.nsc.blZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.g.a
 * JD-Core Version:    0.7.0.1
 */