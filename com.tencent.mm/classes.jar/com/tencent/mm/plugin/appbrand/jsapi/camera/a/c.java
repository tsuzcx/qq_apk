package com.tencent.mm.plugin.appbrand.jsapi.camera.a;

import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.qbar.QbarNative.QBarPoint;

public abstract class c
{
  private boolean hJi = false;
  public a rRd;
  
  public final void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Point paramPoint, Rect paramRect, int paramInt5, int paramInt6)
  {
    if (this.hJi) {}
    b localb;
    do
    {
      return;
      localb = crQ();
    } while (paramArrayOfByte == null);
    localb.rQM.postToWorker(new b.1(localb, paramArrayOfByte, paramInt5, paramInt1, paramInt2, paramInt3, paramInt4, paramPoint, paramRect, paramInt6));
  }
  
  protected abstract b crQ();
  
  public final void init()
  {
    crQ().init();
  }
  
  public final void release()
  {
    crQ().release();
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, byte[] paramArrayOfByte, QbarNative.QBarPoint paramQBarPoint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.a.c
 * JD-Core Version:    0.7.0.1
 */