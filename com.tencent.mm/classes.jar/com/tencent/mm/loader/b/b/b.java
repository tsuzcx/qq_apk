package com.tencent.mm.loader.b.b;

import android.graphics.Bitmap;
import com.tencent.mm.b.f;
import com.tencent.mm.sdk.platformtools.bt;

public final class b
  extends e<String, Bitmap>
{
  public static final int giH;
  public static final int giJ;
  public static final int giK = d.agX();
  private f<String, Bitmap> giL;
  private f<String, Bitmap> giM;
  
  static
  {
    d locald = d.giQ;
    giJ = d.agV();
    locald = d.giQ;
    giH = d.agW();
    locald = d.giQ;
  }
  
  public b()
  {
    d locald = d.giQ;
    this.giL = d.agY();
    locald = d.giQ;
    this.giM = d.agZ();
  }
  
  public final com.tencent.mm.loader.h.e<Bitmap> a(com.tencent.mm.loader.h.a.a<String> parama, com.tencent.mm.loader.e.c.a<Bitmap> parama1)
  {
    if (!bt.isNullOrNil((String)parama.value()))
    {
      parama1 = b(parama, parama1);
      parama = (Bitmap)this.giL.get(parama1);
      if (parama != null) {
        break label66;
      }
      parama = (Bitmap)this.giM.get(parama1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.b.b.b
 * JD-Core Version:    0.7.0.1
 */