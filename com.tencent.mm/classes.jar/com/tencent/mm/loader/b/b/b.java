package com.tencent.mm.loader.b.b;

import android.graphics.Bitmap;
import com.tencent.mm.b.f;
import com.tencent.mm.sdk.platformtools.Util;

public final class b
  extends e<String, Bitmap>
{
  public static final int hYM;
  public static final int hYO;
  public static final int hYP = d.aJA();
  private f<String, Bitmap> hYQ;
  private f<String, Bitmap> hYR;
  
  static
  {
    d locald = d.hYV;
    hYO = d.aJy();
    locald = d.hYV;
    hYM = d.aJz();
    locald = d.hYV;
  }
  
  public b()
  {
    d locald = d.hYV;
    this.hYQ = d.aJB();
    locald = d.hYV;
    this.hYR = d.aJC();
  }
  
  public final com.tencent.mm.loader.h.e<Bitmap> a(com.tencent.mm.loader.h.a.a<String> parama, com.tencent.mm.loader.e.c.a<Bitmap> parama1)
  {
    if (!Util.isNullOrNil((String)parama.value()))
    {
      parama1 = b(parama, parama1);
      parama = (Bitmap)this.hYQ.get(parama1);
      if (parama != null) {
        break label66;
      }
      parama = (Bitmap)this.hYR.get(parama1);
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
  
  public final void a(com.tencent.mm.loader.h.a.a<String> parama)
  {
    this.hYQ.remove(parama.value());
    this.hYR.remove(parama.value());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.loader.b.b.b
 * JD-Core Version:    0.7.0.1
 */