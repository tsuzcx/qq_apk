package com.tencent.mm.loader.h;

import com.tencent.mm.loader.b.a.c;
import java.io.OutputStream;

public final class a
  extends f<String>
{
  public String bxn;
  private f.a gly;
  
  private a(String paramString1, String paramString2, f.a<String> parama)
  {
    super(paramString1);
    this.bxn = paramString2;
    this.gly = parama;
  }
  
  public static a an(String paramString1, String paramString2)
  {
    new a(paramString1, paramString2, new f.a() {});
  }
  
  public final com.tencent.mm.loader.h.b.a ahF()
  {
    return this.gly.ahG();
  }
  
  public final void b(OutputStream paramOutputStream)
  {
    c localc = c.giE;
    c.a((String)this.data, paramOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.h.a
 * JD-Core Version:    0.7.0.1
 */