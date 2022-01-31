package com.tencent.mm.plugin.appbrand.jsapi.e;

import android.os.Message;
import com.tencent.luggage.b.e;
import com.tencent.mm.plugin.appbrand.v.b.a;
import com.tencent.mm.sdk.d.c;
import com.tencent.mm.sdk.d.d;

final class l$1
  extends c
{
  l$1(l paraml) {}
  
  public final void enter()
  {
    super.enter();
    ((a)e.i(a.class)).b("gcj02", this.grQ.grL, this.grQ.ezQ);
    if (this.grQ.grM != null) {
      this.grQ.grM.uc("StateNotListening");
    }
  }
  
  public final boolean g(Message paramMessage)
  {
    if (1 == paramMessage.what)
    {
      this.grQ.b(this.grQ.grO);
      return true;
    }
    return super.g(paramMessage);
  }
  
  public final String getName()
  {
    return this.grQ.mName + "$StateListening";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.e.l.1
 * JD-Core Version:    0.7.0.1
 */