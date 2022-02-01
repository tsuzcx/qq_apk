package com.tencent.mm.loader.b.b;

import android.graphics.Bitmap;
import com.tencent.mm.b.f;
import com.tencent.mm.sdk.platformtools.Util;

public final class b
  extends e<String, Bitmap>
{
  public static final int kNr;
  public static final int kNu;
  public static final int kNv = d.aRA();
  private f<String, Bitmap> kNw;
  private f<String, Bitmap> kNx;
  
  static
  {
    d locald = d.kNB;
    kNu = d.aRy();
    locald = d.kNB;
    kNr = d.aRz();
    locald = d.kNB;
  }
  
  public b()
  {
    d locald = d.kNB;
    this.kNw = d.aRB();
    locald = d.kNB;
    this.kNx = d.aRC();
  }
  
  public final com.tencent.mm.loader.h.e<Bitmap> a(com.tencent.mm.loader.h.a.a<String> parama, com.tencent.mm.loader.e.c.a<Bitmap> parama1)
  {
    if (!Util.isNullOrNil((String)parama.aSr()))
    {
      parama1 = b(parama, parama1);
      parama = (Bitmap)this.kNw.get(parama1);
      if (parama != null) {
        break label66;
      }
      parama = (Bitmap)this.kNx.get(parama1);
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
    this.kNw.remove(parama.aSr());
    this.kNx.remove(parama.aSr());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.b.b.b
 * JD-Core Version:    0.7.0.1
 */