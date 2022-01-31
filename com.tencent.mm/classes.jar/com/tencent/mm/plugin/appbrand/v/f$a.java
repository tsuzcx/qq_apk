package com.tencent.mm.plugin.appbrand.v;

import android.os.Message;
import com.tencent.mm.plugin.appbrand.report.h;

final class f$a
  extends h
{
  private f$a(f paramf) {}
  
  public final boolean g(Message paramMessage)
  {
    if (2 == paramMessage.what)
    {
      this.hlo.b(this.hlo.hlk);
      return true;
    }
    return super.g(paramMessage);
  }
  
  public final String getName()
  {
    return this.hlo.hlm + "|StateExecuting";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v.f.a
 * JD-Core Version:    0.7.0.1
 */