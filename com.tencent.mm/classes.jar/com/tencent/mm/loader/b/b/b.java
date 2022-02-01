package com.tencent.mm.loader.b.b;

import android.graphics.Bitmap;
import com.tencent.mm.b.f;
import com.tencent.mm.sdk.platformtools.bu;

public final class b
  extends e<String, Bitmap>
{
  public static final int hfR;
  public static final int hfT;
  public static final int hfU = d.arb();
  private f<String, Bitmap> hfV;
  private f<String, Bitmap> hfW;
  
  static
  {
    d locald = d.hga;
    hfT = d.aqZ();
    locald = d.hga;
    hfR = d.ara();
    locald = d.hga;
  }
  
  public b()
  {
    d locald = d.hga;
    this.hfV = d.arc();
    locald = d.hga;
    this.hfW = d.ard();
  }
  
  public final com.tencent.mm.loader.h.e<Bitmap> a(com.tencent.mm.loader.h.a.a<String> parama, com.tencent.mm.loader.e.c.a<Bitmap> parama1)
  {
    if (!bu.isNullOrNil((String)parama.value()))
    {
      parama1 = b(parama, parama1);
      parama = (Bitmap)this.hfV.get(parama1);
      if (parama != null) {
        break label66;
      }
      parama = (Bitmap)this.hfW.get(parama1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.b.b.b
 * JD-Core Version:    0.7.0.1
 */