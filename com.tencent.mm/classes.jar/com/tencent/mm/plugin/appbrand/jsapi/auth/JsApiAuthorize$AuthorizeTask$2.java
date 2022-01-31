package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.widget.b.i;
import java.util.LinkedList;

final class JsApiAuthorize$AuthorizeTask$2
  implements Runnable
{
  JsApiAuthorize$AuthorizeTask$2(JsApiAuthorize.AuthorizeTask paramAuthorizeTask, LinkedList paramLinkedList) {}
  
  public final void run()
  {
    JsApiAuthorize.AuthorizeTask.2.1 local1 = new JsApiAuthorize.AuthorizeTask.2.1(this);
    i locali = this.gjR.gjI.Zm();
    c localc = this.gjR.gjH;
    locali.b(new com.tencent.mm.plugin.appbrand.widget.b.c(c.a(this.gjR.gjI), this.fXW, this.gjR.mAppName, this.gjR.fXS, local1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiAuthorize.AuthorizeTask.2
 * JD-Core Version:    0.7.0.1
 */