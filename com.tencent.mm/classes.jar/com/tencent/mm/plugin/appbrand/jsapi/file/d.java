package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

abstract class d<T extends f>
  extends a
{
  static final ThreadPoolExecutor hLQ = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque());
  private final T hLP;
  
  public d(T paramT)
  {
    this.hLP = paramT;
    this.hLP.hLS = this;
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    hLQ.submit(new d.1(this, paramc, paramJSONObject, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.d
 * JD-Core Version:    0.7.0.1
 */