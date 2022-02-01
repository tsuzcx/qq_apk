package com.tencent.luggage.xweb_ext.extendplugin.a;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import android.view.Surface;
import com.tencent.luggage.xweb_ext.extendplugin.b.c;
import com.tencent.luggage.xweb_ext.extendplugin.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class a
  implements b
{
  protected volatile boolean eEm;
  protected c exB;
  protected int id;
  public String type;
  
  public final void a(c paramc)
  {
    this.exB = paramc;
  }
  
  public void atW()
  {
    this.eEm = false;
  }
  
  public final c auT()
  {
    return this.exB;
  }
  
  public void e(SurfaceTexture paramSurfaceTexture)
  {
    this.eEm = true;
  }
  
  public boolean g(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    return false;
  }
  
  public final int getId()
  {
    return this.id;
  }
  
  public String h(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    return null;
  }
  
  public void i(Surface paramSurface)
  {
    this.eEm = true;
  }
  
  public final String key()
  {
    AppMethodBeat.i(139353);
    String str = d.G(this.type, this.id);
    AppMethodBeat.o(139353);
    return str;
  }
  
  public void o(MotionEvent paramMotionEvent) {}
  
  public final void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public final void setType(String paramString)
  {
    this.type = paramString;
  }
  
  public void y(Bitmap paramBitmap) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.a.a
 * JD-Core Version:    0.7.0.1
 */