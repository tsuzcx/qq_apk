package com.tencent.luggage.k.a.b;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import com.tencent.luggage.k.a.c.c;
import com.tencent.luggage.k.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class a
  implements b
{
  protected c cjC;
  protected volatile boolean cnR;
  protected int id;
  public String type;
  
  public final String AL()
  {
    AppMethodBeat.i(139353);
    String str = d.l(this.type, this.id);
    AppMethodBeat.o(139353);
    return str;
  }
  
  public void EY()
  {
    this.cnR = false;
  }
  
  public final c FI()
  {
    return this.cjC;
  }
  
  public final void a(c paramc)
  {
    this.cjC = paramc;
  }
  
  public void e(SurfaceTexture paramSurfaceTexture)
  {
    this.cnR = true;
  }
  
  public final int getId()
  {
    return this.id;
  }
  
  public final String getType()
  {
    return this.type;
  }
  
  public boolean h(com.tencent.luggage.k.a.a parama)
  {
    return false;
  }
  
  public String i(com.tencent.luggage.k.a.a parama)
  {
    return null;
  }
  
  public void n(MotionEvent paramMotionEvent) {}
  
  public void r(Bitmap paramBitmap) {}
  
  public final void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public final void setType(String paramString)
  {
    this.type = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.k.a.b.a
 * JD-Core Version:    0.7.0.1
 */