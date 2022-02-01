package com.tencent.mm.loader.cache.memory;

import android.graphics.Bitmap;
import com.tencent.mm.b.f;
import com.tencent.mm.loader.g.e;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
  extends d<String, Bitmap>
{
  public static final int npg;
  public static final int npi;
  public static final int npj = c.blp();
  private f<String, Bitmap> npk;
  private f<String, Bitmap> npl;
  
  static
  {
    c localc = c.npo;
    npi = c.bln();
    localc = c.npo;
    npg = c.blo();
    localc = c.npo;
  }
  
  public a()
  {
    c localc = c.npo;
    this.npk = c.blq();
    localc = c.npo;
    this.npl = c.blr();
  }
  
  public final e<Bitmap> a(com.tencent.mm.loader.g.a.a<String> parama, com.tencent.mm.loader.d.c.a<Bitmap> parama1)
  {
    if (!Util.isNullOrNil((String)parama.bmg()))
    {
      parama1 = b(parama, parama1);
      parama = (Bitmap)this.npk.get(parama1);
      if (parama != null) {
        break label66;
      }
      parama = (Bitmap)this.npl.get(parama1);
    }
    label66:
    for (;;)
    {
      if (parama != null) {
        return new e(parama);
      }
      return null;
    }
  }
  
  public final void c(com.tencent.mm.loader.g.a.a<String> parama)
  {
    this.npk.remove((String)parama.bmg());
    this.npl.remove((String)parama.bmg());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.cache.memory.a
 * JD-Core Version:    0.7.0.1
 */