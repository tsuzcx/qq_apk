package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ls
{
  private static final int a = 7;
  private static Canvas b;
  private static int c;
  private static Bitmap[] d;
  private static Bitmap e;
  
  static
  {
    AppMethodBeat.i(222937);
    Bitmap[] arrayOfBitmap = new Bitmap[7];
    d = arrayOfBitmap;
    arrayOfBitmap[0] = Bitmap.createBitmap(64, 32, Bitmap.Config.ARGB_8888);
    d[1] = Bitmap.createBitmap(128, 32, Bitmap.Config.ARGB_8888);
    d[2] = Bitmap.createBitmap(128, 64, Bitmap.Config.ARGB_8888);
    d[3] = Bitmap.createBitmap(256, 32, Bitmap.Config.ARGB_8888);
    d[4] = Bitmap.createBitmap(256, 128, Bitmap.Config.ARGB_8888);
    d[5] = Bitmap.createBitmap(32, 128, Bitmap.Config.ARGB_8888);
    d[6] = Bitmap.createBitmap(32, 256, Bitmap.Config.ARGB_8888);
    b = new Canvas(d[1]);
    c = 1;
    e = null;
    AppMethodBeat.o(222937);
  }
  
  private static Canvas a(float paramFloat1, float paramFloat2)
  {
    int k = 1;
    AppMethodBeat.i(222877);
    int i = 0;
    while ((i < 7) && ((d[i].getWidth() < paramFloat1) || (d[i].getHeight() < paramFloat2))) {
      i += 1;
    }
    if (i < 7)
    {
      c = i;
      b.setBitmap(d[i]);
      d[i].eraseColor(0);
      localCanvas = b;
      AppMethodBeat.o(222877);
      return localCanvas;
    }
    c = d.length;
    i = 1;
    int j;
    for (;;)
    {
      j = k;
      if (i >= paramFloat1) {
        break;
      }
      i <<= 1;
    }
    while (j < paramFloat2) {
      j <<= 1;
    }
    e = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    b.setBitmap(e);
    e.eraseColor(0);
    Canvas localCanvas = b;
    AppMethodBeat.o(222877);
    return localCanvas;
  }
  
  private static void a()
  {
    AppMethodBeat.i(222906);
    if (e != null)
    {
      e.recycle();
      e = null;
    }
    AppMethodBeat.o(222906);
  }
  
  private static void a(float paramFloat1, float paramFloat2, Point paramPoint)
  {
    int k = 1;
    AppMethodBeat.i(222890);
    int i = 0;
    while (i < 7)
    {
      if ((d[i].getWidth() >= paramFloat1) && (d[i].getHeight() >= paramFloat2))
      {
        paramPoint.set(d[i].getWidth(), d[i].getHeight());
        AppMethodBeat.o(222890);
        return;
      }
      i += 1;
    }
    i = 1;
    int j;
    for (;;)
    {
      j = k;
      if (i >= paramFloat1) {
        break;
      }
      i <<= 1;
    }
    while (j < paramFloat2) {
      j <<= 1;
    }
    paramPoint.set(i, j);
    AppMethodBeat.o(222890);
  }
  
  private static Bitmap b()
  {
    if (c < 7) {
      return d[c];
    }
    return e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ls
 * JD-Core Version:    0.7.0.1
 */