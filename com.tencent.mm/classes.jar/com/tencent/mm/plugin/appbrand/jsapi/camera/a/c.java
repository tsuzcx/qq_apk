package com.tencent.mm.plugin.appbrand.jsapi.camera.a;

import android.graphics.Rect;
import com.tencent.mm.sdk.platformtools.ai;

public abstract class c
{
  private boolean bNW = false;
  public c.a gpx;
  
  public final void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, Rect paramRect, int paramInt3)
  {
    if (this.bNW) {}
    b localb;
    do
    {
      return;
      localb = aiQ();
    } while (paramArrayOfByte == null);
    localb.gpl.O(new b.1(localb, paramArrayOfByte, paramInt3, paramInt1, paramInt2, paramRect));
  }
  
  protected abstract b aiQ();
  
  public final void init()
  {
    aiQ().init();
  }
  
  public final void release()
  {
    aiQ().release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.a.c
 * JD-Core Version:    0.7.0.1
 */