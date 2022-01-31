package com.tencent.mm.aa.c;

import com.tencent.mm.aa.b.b.a;
import com.tencent.mm.aa.b.d;
import com.tencent.mm.sdk.platformtools.bk;

final class c$1
  implements b.a
{
  c$1(c paramc, int paramInt) {}
  
  public final void ab(Object paramObject)
  {
    e locale = this.dIT.dIO.dIU;
    int i = this.dIS;
    if (paramObject == null) {}
    for (paramObject = "";; paramObject = paramObject.toString())
    {
      Object localObject = paramObject;
      if (bk.bl(paramObject)) {
        localObject = "{}";
      }
      locale.dJa.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.invokeCallbackHandler(%d, %s)", new Object[] { Integer.valueOf(i), localObject }), null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.aa.c.c.1
 * JD-Core Version:    0.7.0.1
 */