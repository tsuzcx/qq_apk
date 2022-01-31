package com.tencent.mm.plugin.appbrand.jsapi.live;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

final class a$1
  implements Runnable
{
  a$1(String paramString, a.a parama) {}
  
  public final void run()
  {
    if (!a.aiY().containsKey(this.val$url)) {
      a.aiY().put(this.val$url, new ArrayList());
    }
    ((List)a.aiY().get(this.val$url)).add(this.grT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.a.1
 * JD-Core Version:    0.7.0.1
 */