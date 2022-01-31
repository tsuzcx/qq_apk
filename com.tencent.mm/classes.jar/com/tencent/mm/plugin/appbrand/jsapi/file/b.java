package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

abstract class b<T extends d>
  extends a
{
  private static final ThreadPoolExecutor gqE = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque());
  private final T gqD;
  
  public b(T paramT)
  {
    this.gqD = paramT;
    this.gqD.gqG = this;
  }
  
  public final void a(final c paramc, final JSONObject paramJSONObject, final int paramInt)
  {
    gqE.submit(new Runnable()
    {
      public final void run()
      {
        f.a locala = b.a(b.this).b(paramc, paramJSONObject);
        paramc.C(paramInt, b.this.a(paramc, locala.aox, locala.values));
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.b
 * JD-Core Version:    0.7.0.1
 */