package com.tencent.mm.loader.h;

import com.tencent.mm.loader.b.a.c;
import java.io.OutputStream;

public final class a
  extends f<String>
{
  public String contentType;
  private f.a hiW;
  
  private a(String paramString1, String paramString2, f.a<String> parama)
  {
    super(paramString1);
    this.contentType = paramString2;
    this.hiW = parama;
  }
  
  public static a ax(String paramString1, String paramString2)
  {
    new a(paramString1, paramString2, new f.a() {});
  }
  
  public final com.tencent.mm.loader.h.b.a arJ()
  {
    return this.hiW.arK();
  }
  
  public final void b(OutputStream paramOutputStream)
  {
    c localc = c.hfO;
    c.a((String)this.data, paramOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.h.a
 * JD-Core Version:    0.7.0.1
 */