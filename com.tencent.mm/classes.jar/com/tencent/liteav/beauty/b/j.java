package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.c.a;
import com.tencent.liteav.basic.d.h;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class j
{
  private static String j = "GPUGreenScreen";
  private int a;
  private int b;
  private boolean c;
  private w d;
  private boolean e;
  private h f;
  private e g;
  private p h;
  private boolean i;
  private a k;
  
  private void b()
  {
    AppMethodBeat.i(67026);
    TXCLog.d(j, "come into destroyPlayer");
    if (this.d != null) {
      this.d.a();
    }
    this.d = null;
    this.e = false;
    this.i = false;
    TXCLog.d(j, "come out destroyPlayer");
    AppMethodBeat.o(67026);
  }
  
  private void c()
  {
    AppMethodBeat.i(67028);
    if ((this.b != -1) && (this.b != this.a))
    {
      GLES20.glDeleteTextures(1, new int[] { this.b }, 0);
      this.b = -1;
    }
    if (this.a != -1)
    {
      GLES20.glDeleteTextures(1, new int[] { this.a }, 0);
      this.a = -1;
    }
    AppMethodBeat.o(67028);
  }
  
  public int a(int paramInt)
  {
    return paramInt;
  }
  
  public void a()
  {
    AppMethodBeat.i(67027);
    TXCLog.d(j, "come into GreenScreen destroy");
    b();
    c();
    if (this.f != null)
    {
      this.f.d();
      this.f = null;
    }
    if (this.g != null)
    {
      this.g.d();
      this.g = null;
    }
    if (this.h != null)
    {
      this.h.d();
      this.h = null;
    }
    this.c = false;
    TXCLog.d(j, "come out GreenScreen destroy");
    AppMethodBeat.o(67027);
  }
  
  public void a(a parama)
  {
    AppMethodBeat.i(146363);
    TXCLog.i(j, "set notify");
    this.k = parama;
    AppMethodBeat.o(146363);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.j
 * JD-Core Version:    0.7.0.1
 */