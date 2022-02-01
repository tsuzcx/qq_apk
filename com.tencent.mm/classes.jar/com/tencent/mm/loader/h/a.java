package com.tencent.mm.loader.h;

import com.tencent.mm.loader.b.a.c;
import java.io.OutputStream;

public final class a
  extends f<String>
{
  public String contentType;
  private f.a kQz;
  
  private a(String paramString1, String paramString2, f.a<String> parama)
  {
    super(paramString1);
    this.contentType = paramString2;
    this.kQz = parama;
  }
  
  public static a aC(String paramString1, String paramString2)
  {
    new a(paramString1, paramString2, new f.a() {});
  }
  
  public final com.tencent.mm.loader.h.b.a aSj()
  {
    f.a locala = this.kQz;
    aSr();
    return locala.aSk();
  }
  
  public final void b(OutputStream paramOutputStream)
  {
    c localc = c.kNn;
    c.a((String)aSr(), paramOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.h.a
 * JD-Core Version:    0.7.0.1
 */