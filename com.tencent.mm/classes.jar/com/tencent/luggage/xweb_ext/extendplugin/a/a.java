package com.tencent.luggage.xweb_ext.extendplugin.a;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import com.tencent.luggage.xweb_ext.extendplugin.b.c;
import com.tencent.luggage.xweb_ext.extendplugin.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class a
  implements b
{
  protected c cEq;
  protected volatile boolean cKB;
  protected int id;
  public String type;
  
  public void Tr()
  {
    this.cKB = false;
  }
  
  public final c Uq()
  {
    return this.cEq;
  }
  
  public final void a(c paramc)
  {
    this.cEq = paramc;
  }
  
  public void e(SurfaceTexture paramSurfaceTexture)
  {
    this.cKB = true;
  }
  
  public boolean g(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    return false;
  }
  
  public final int getId()
  {
    return this.id;
  }
  
  public final String getType()
  {
    return this.type;
  }
  
  public String h(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    return null;
  }
  
  public final String key()
  {
    AppMethodBeat.i(139353);
    String str = d.y(this.type, this.id);
    AppMethodBeat.o(139353);
    return str;
  }
  
  public void n(Bitmap paramBitmap) {}
  
  public void o(MotionEvent paramMotionEvent) {}
  
  public final void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public final void setType(String paramString)
  {
    this.type = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.a.a
 * JD-Core Version:    0.7.0.1
 */