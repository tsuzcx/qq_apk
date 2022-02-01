package com.tencent.mm.loader.b.b;

import android.graphics.Bitmap;
import com.tencent.mm.b.f;
import com.tencent.mm.sdk.platformtools.bs;

public final class b
  extends e<String, Bitmap>
{
  public static final int gJs;
  public static final int gJu;
  public static final int gJv = d.anZ();
  private f<String, Bitmap> gJw;
  private f<String, Bitmap> gJx;
  
  static
  {
    d locald = d.gJB;
    gJu = d.anX();
    locald = d.gJB;
    gJs = d.anY();
    locald = d.gJB;
  }
  
  public b()
  {
    d locald = d.gJB;
    this.gJw = d.aoa();
    locald = d.gJB;
    this.gJx = d.aob();
  }
  
  public final com.tencent.mm.loader.h.e<Bitmap> a(com.tencent.mm.loader.h.a.a<String> parama, com.tencent.mm.loader.e.c.a<Bitmap> parama1)
  {
    if (!bs.isNullOrNil((String)parama.value()))
    {
      parama1 = b(parama, parama1);
      parama = (Bitmap)this.gJw.get(parama1);
      if (parama != null) {
        break label66;
      }
      parama = (Bitmap)this.gJx.get(parama1);
    }
    label66:
    for (;;)
    {
      if (parama != null) {
        return new com.tencent.mm.loader.h.e(parama);
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.b.b.b
 * JD-Core Version:    0.7.0.1
 */