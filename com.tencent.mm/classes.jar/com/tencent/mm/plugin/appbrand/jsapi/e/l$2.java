package com.tencent.mm.plugin.appbrand.jsapi.e;

import android.os.Message;
import com.tencent.luggage.b.e;
import com.tencent.mm.plugin.appbrand.v.b.a;
import com.tencent.mm.sdk.d.c;
import com.tencent.mm.sdk.d.d;

final class l$2
  extends c
{
  l$2(l paraml) {}
  
  public final void enter()
  {
    super.enter();
    ((a)e.i(a.class)).a("gcj02", this.grQ.grL, this.grQ.ezQ);
    if (this.grQ.grM != null) {
      this.grQ.grM.uc("StateListening");
    }
  }
  
  public final void exit()
  {
    super.exit();
    ((a)e.i(a.class)).b("gcj02", this.grQ.grL, this.grQ.ezQ);
  }
  
  public final boolean g(Message paramMessage)
  {
    if (2 == paramMessage.what)
    {
      this.grQ.b(this.grQ.grN);
      return true;
    }
    if (3 == paramMessage.what)
    {
      this.grQ.b(this.grQ.grP);
      return true;
    }
    return super.g(paramMessage);
  }
  
  public final String getName()
  {
    return this.grQ.mName + "$StateNotListening";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.e.l.2
 * JD-Core Version:    0.7.0.1
 */