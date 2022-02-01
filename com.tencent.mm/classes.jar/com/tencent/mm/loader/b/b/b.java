package com.tencent.mm.loader.b.b;

import android.graphics.Bitmap;
import com.tencent.mm.b.f;
import com.tencent.mm.sdk.platformtools.bt;

public final class b
  extends e<String, Bitmap>
{
  public static final int hdd;
  public static final int hdf;
  public static final int hdg = d.aqM();
  private f<String, Bitmap> hdh;
  private f<String, Bitmap> hdi;
  
  static
  {
    d locald = d.hdm;
    hdf = d.aqK();
    locald = d.hdm;
    hdd = d.aqL();
    locald = d.hdm;
  }
  
  public b()
  {
    d locald = d.hdm;
    this.hdh = d.aqN();
    locald = d.hdm;
    this.hdi = d.aqO();
  }
  
  public final com.tencent.mm.loader.h.e<Bitmap> a(com.tencent.mm.loader.h.a.a<String> parama, com.tencent.mm.loader.e.c.a<Bitmap> parama1)
  {
    if (!bt.isNullOrNil((String)parama.value()))
    {
      parama1 = b(parama, parama1);
      parama = (Bitmap)this.hdh.get(parama1);
      if (parama != null) {
        break label66;
      }
      parama = (Bitmap)this.hdi.get(parama1);
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