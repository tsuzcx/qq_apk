package com.tencent.mm.plugin.facedetect.d;

import com.tencent.mm.plugin.facedetect.model.h.a;
import com.tencent.mm.sdk.platformtools.y;

public final class b$c
{
  private static String TAG = "MicroMsg.IFaceMotion.Factory";
  
  public static b a(h.a parama)
  {
    if (parama == null) {
      return null;
    }
    if (parama.type == 4)
    {
      y.i(TAG, "hy: is read number");
      return new d(parama.jNY);
    }
    y.i(TAG, "hy: is normal");
    return new c(parama.fuj, parama.jNV);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.d.b.c
 * JD-Core Version:    0.7.0.1
 */