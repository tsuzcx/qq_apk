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
  protected c cDJ;
  protected volatile boolean cJY;
  protected int id;
  public String type;
  
  public final String Lb()
  {
    AppMethodBeat.i(139353);
    String str = d.o(this.type, this.id);
    AppMethodBeat.o(139353);
    return str;
  }
  
  public void PQ()
  {
    this.cJY = false;
  }
  
  public final c QJ()
  {
    return this.cDJ;
  }
  
  public final void a(c paramc)
  {
    this.cDJ = paramc;
  }
  
  public void e(SurfaceTexture paramSurfaceTexture)
  {
    this.cJY = true;
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
  
  public void o(MotionEvent paramMotionEvent) {}
  
  public void s(Bitmap paramBitmap) {}
  
  public final void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public final void setType(String paramString)
  {
    this.type = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.a.a
 * JD-Core Version:    0.7.0.1
 */