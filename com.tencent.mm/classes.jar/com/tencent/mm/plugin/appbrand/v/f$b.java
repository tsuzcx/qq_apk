package com.tencent.mm.plugin.appbrand.v;

import android.os.Message;
import com.tencent.mm.plugin.appbrand.report.h;

final class f$b
  extends h
{
  private f$b(f paramf) {}
  
  public final void enter()
  {
    super.enter();
    f.a(this.hlo);
  }
  
  public final boolean g(Message paramMessage)
  {
    if ((1 == paramMessage.what) || (2 == paramMessage.what))
    {
      f.a(this.hlo);
      return true;
    }
    return super.g(paramMessage);
  }
  
  public final String getName()
  {
    return this.hlo.hlm + "|StateIdle";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v.f.b
 * JD-Core Version:    0.7.0.1
 */