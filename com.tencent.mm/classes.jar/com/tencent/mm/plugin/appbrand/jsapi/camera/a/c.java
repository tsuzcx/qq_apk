package com.tencent.mm.plugin.appbrand.jsapi.camera.a;

import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.qbar.QbarNative.QBarPoint;

public abstract class c
{
  private boolean dtm = false;
  public a kIK;
  
  public final void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Point paramPoint, Rect paramRect, int paramInt5, int paramInt6)
  {
    if (this.dtm) {}
    b localb;
    do
    {
      return;
      localb = bjW();
    } while (paramArrayOfByte == null);
    localb.kIt.postToWorker(new b.1(localb, paramArrayOfByte, paramInt5, paramInt1, paramInt2, paramInt3, paramInt4, paramPoint, paramRect, paramInt6));
  }
  
  protected abstract b bjW();
  
  public final void init()
  {
    bjW().init();
  }
  
  public final void release()
  {
    bjW().release();
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, byte[] paramArrayOfByte, QbarNative.QBarPoint paramQBarPoint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.a.c
 * JD-Core Version:    0.7.0.1
 */