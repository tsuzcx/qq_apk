package com.tencent.mapsdk.internal;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class st
  extends View
  implements bt
{
  private Context a;
  private sj b;
  private Object c;
  private int d;
  private int e;
  private si f;
  private boolean g;
  
  public st(bd parambd)
  {
    super(parambd.getContext());
    AppMethodBeat.i(223798);
    this.g = true;
    Object localObject = parambd.i();
    if (localObject == null)
    {
      AppMethodBeat.o(223798);
      return;
    }
    this.a = parambd.getContext();
    this.b = ((sj)parambd.b());
    this.c = localObject;
    this.d = parambd.j();
    this.e = parambd.k();
    if ((this.e <= 0) || (this.d <= 0))
    {
      this.d = 0;
      this.e = 0;
    }
    this.f = new si(this.b);
    this.f.a(this.c);
    si.a(parambd.m());
    this.f.start();
    AppMethodBeat.o(223798);
  }
  
  private void f()
  {
    AppMethodBeat.i(223811);
    if ((this.b != null) && (this.g == true))
    {
      this.b.a(null, null);
      this.b.a(null, this.d, this.e);
      this.b.e(this.d, this.e);
      this.g = false;
    }
    AppMethodBeat.o(223811);
  }
  
  public final void a()
  {
    AppMethodBeat.i(223829);
    if (this.f != null) {
      this.f.b();
    }
    if ((this.b != null) && (this.g == true))
    {
      this.b.a(null, null);
      this.b.a(null, this.d, this.e);
      this.b.e(this.d, this.e);
      this.g = false;
    }
    AppMethodBeat.o(223829);
  }
  
  public final void a(float paramFloat)
  {
    AppMethodBeat.i(223904);
    if (this.f != null) {
      si.a(paramFloat);
    }
    AppMethodBeat.o(223904);
  }
  
  public final void a(Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(223892);
    if ((this.b == null) || (this.f == null) || (!this.f.isAlive()))
    {
      AppMethodBeat.o(223892);
      return;
    }
    if (this.f != null)
    {
      this.c = paramObject;
      this.f.a(paramObject);
    }
    if (this.b != null)
    {
      this.b.a(null, null);
      this.b.a(null, paramInt1, paramInt2);
    }
    AppMethodBeat.o(223892);
  }
  
  public final void b()
  {
    AppMethodBeat.i(223844);
    if (this.f != null) {
      this.f.a();
    }
    AppMethodBeat.o(223844);
  }
  
  public final void c()
  {
    AppMethodBeat.i(223852);
    if (this.f != null) {
      this.f.c();
    }
    AppMethodBeat.o(223852);
  }
  
  public final void d()
  {
    AppMethodBeat.i(223820);
    if (this.f != null) {
      synchronized (this.f)
      {
        this.f.notify();
        AppMethodBeat.o(223820);
        return;
      }
    }
    AppMethodBeat.o(223820);
  }
  
  public final boolean e()
  {
    return false;
  }
  
  public final View getView()
  {
    return this;
  }
  
  public final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(223880);
    if (this.b != null)
    {
      this.d = paramInt1;
      this.e = paramInt2;
      this.b.a(null, paramInt1, paramInt2);
      this.b.e(paramInt1, paramInt2);
      this.b.F();
      this.g = true;
    }
    AppMethodBeat.o(223880);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public final void setMapOpaque(boolean paramBoolean) {}
  
  public final void setZOrderMediaOverlay(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.internal.st
 * JD-Core Version:    0.7.0.1
 */