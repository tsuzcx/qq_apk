package com.tencent.luggage.xweb_ext.extendplugin.a;

import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import com.tencent.luggage.xweb_ext.extendplugin.b.c;
import com.tencent.luggage.xweb_ext.extendplugin.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class a
  implements b
{
  protected c bFS;
  protected volatile boolean bIZ;
  protected int id;
  protected String type;
  
  public String a(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    return null;
  }
  
  public final void a(c paramc)
  {
    this.bFS = paramc;
  }
  
  public void d(SurfaceTexture paramSurfaceTexture)
  {
    this.bIZ = true;
  }
  
  public final int getId()
  {
    return this.id;
  }
  
  public final String getType()
  {
    return this.type;
  }
  
  public void m(MotionEvent paramMotionEvent) {}
  
  public final void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public final void setType(String paramString)
  {
    this.type = paramString;
  }
  
  public final String tX()
  {
    AppMethodBeat.i(140002);
    String str = d.m(this.type, this.id);
    AppMethodBeat.o(140002);
    return str;
  }
  
  public boolean xp()
  {
    return false;
  }
  
  public void xq()
  {
    this.bIZ = false;
  }
  
  public final c yh()
  {
    return this.bFS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.a.a
 * JD-Core Version:    0.7.0.1
 */