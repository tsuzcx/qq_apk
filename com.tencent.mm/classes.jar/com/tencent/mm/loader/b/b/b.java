package com.tencent.mm.loader.b.b;

import android.graphics.Bitmap;
import com.tencent.mm.a.f;
import com.tencent.mm.loader.h.e;
import com.tencent.mm.sdk.platformtools.bo;

public final class b
  extends d<String, Bitmap>
{
  private f<String, Bitmap> eNs = new com.tencent.mm.memory.a.b(50, getClass());
  private f<String, Bitmap> eNt = new com.tencent.mm.memory.a.b(10, getClass());
  
  public final e<Bitmap> a(com.tencent.mm.loader.h.a.a<String> parama, com.tencent.mm.loader.e.c.a<Bitmap> parama1)
  {
    if (!bo.isNullOrNil((String)parama.value()))
    {
      parama1 = b(parama, parama1);
      parama = (Bitmap)this.eNs.get(parama1);
      if (parama != null) {
        break label66;
      }
      parama = (Bitmap)this.eNt.get(parama1);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.b.b.b
 * JD-Core Version:    0.7.0.1
 */