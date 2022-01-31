package com.tencent.mm.plugin.appbrand.jsapi.camera;

import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import java.util.HashMap;

final class h$1
  extends g.b
{
  h$1(h paramh, e parame, d paramd, int paramInt) {}
  
  public final void onDestroy()
  {
    this.gkV.b(this.gpb);
    this.gkV.b(this.gpb);
    this.gkV.b(this.gpb);
    a locala = a.a.aiD();
    Integer localInteger = Integer.valueOf(this.gkY);
    if (locala.goq.containsKey(localInteger)) {
      ((d)locala.goq.remove(localInteger)).release();
    }
    g.b(this.gkV.getAppId(), this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.h.1
 * JD-Core Version:    0.7.0.1
 */