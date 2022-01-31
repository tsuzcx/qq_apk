package com.tencent.mm.plugin.appbrand.jsapi.e;

import android.os.Message;
import com.tencent.mm.sdk.d.c;
import com.tencent.mm.sdk.d.d;

final class l$3
  extends c
{
  l$3(l paraml) {}
  
  public final void enter()
  {
    super.enter();
    if (this.grQ.grM != null) {
      this.grQ.grM.uc("StateSuspend");
    }
  }
  
  public final boolean g(Message paramMessage)
  {
    if (2 == paramMessage.what)
    {
      this.grQ.b(this.grQ.grN);
      return true;
    }
    if (4 == paramMessage.what)
    {
      this.grQ.b(this.grQ.grO);
      return true;
    }
    return super.g(paramMessage);
  }
  
  public final String getName()
  {
    return this.grQ.mName + "$StateSuspend";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.e.l.3
 * JD-Core Version:    0.7.0.1
 */