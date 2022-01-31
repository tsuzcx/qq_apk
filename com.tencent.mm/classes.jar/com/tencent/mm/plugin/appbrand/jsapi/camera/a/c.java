package com.tencent.mm.plugin.appbrand.jsapi.camera.a;

import android.graphics.Rect;
import com.tencent.mm.sdk.platformtools.al;

public abstract class c
{
  private boolean cvo = false;
  public c.a hJB;
  
  public final void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, Rect paramRect, int paramInt3)
  {
    if (this.cvo) {}
    b localb;
    do
    {
      return;
      localb = aCQ();
    } while (paramArrayOfByte == null);
    localb.hJp.ac(new b.1(localb, paramArrayOfByte, paramInt3, paramInt1, paramInt2, paramRect));
  }
  
  protected abstract b aCQ();
  
  public final void init()
  {
    aCQ().init();
  }
  
  public final void release()
  {
    aCQ().release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.a.c
 * JD-Core Version:    0.7.0.1
 */