package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.widget.b.c;
import com.tencent.mm.plugin.appbrand.widget.b.l;
import java.util.LinkedList;

final class JsApiLogin$LoginTask$2
  implements Runnable
{
  JsApiLogin$LoginTask$2(JsApiLogin.LoginTask paramLoginTask, LinkedList paramLinkedList) {}
  
  public final void run()
  {
    AppMethodBeat.i(130858);
    JsApiLogin.LoginTask.2.1 local1 = new JsApiLogin.LoginTask.2.1(this);
    this.hDP.hDv.asX().b(new c(f.a(this.hDP.hDv), f.x(this.hDM), this.hDP.mAppName, this.hDP.hDB, local1));
    AppMethodBeat.o(130858);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiLogin.LoginTask.2
 * JD-Core Version:    0.7.0.1
 */