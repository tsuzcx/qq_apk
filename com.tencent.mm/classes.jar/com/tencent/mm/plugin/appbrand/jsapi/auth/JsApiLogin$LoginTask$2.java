package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.widget.b.i;
import java.util.LinkedList;

final class JsApiLogin$LoginTask$2
  implements Runnable
{
  JsApiLogin$LoginTask$2(JsApiLogin.LoginTask paramLoginTask, LinkedList paramLinkedList) {}
  
  public final void run()
  {
    JsApiLogin.LoginTask.2.1 local1 = new JsApiLogin.LoginTask.2.1(this);
    i locali = this.gjU.gjI.Zm();
    c localc = this.gjU.gjH;
    locali.b(new com.tencent.mm.plugin.appbrand.widget.b.c(c.a(this.gjU.gjI), this.fXW, this.gjU.mAppName, this.gjU.fXS, local1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiLogin.LoginTask.2
 * JD-Core Version:    0.7.0.1
 */