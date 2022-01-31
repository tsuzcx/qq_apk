package com.tencent.mm.d.a;

import com.eclipsesource.v8.MultiContextV8;
import com.eclipsesource.v8.V8Context;
import com.tencent.mm.plugin.appbrand.i.e;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public final class b
{
  volatile V8Context byX;
  public final h byY;
  public final a byZ;
  public final LinkedList<c> bza = new LinkedList();
  
  b(MultiContextV8 paramMultiContextV8, h paramh, a parama, int paramInt)
  {
    paramh.i(new b.1(this, paramMultiContextV8, paramInt));
    this.byY = paramh;
    paramMultiContextV8 = parama;
    if (parama == null) {
      paramMultiContextV8 = new g();
    }
    this.byZ = paramMultiContextV8;
    this.byY.i(new b.2(this));
  }
  
  public final void a(int paramInt, e parame)
  {
    this.byY.bzD.put(Integer.valueOf(paramInt), parame);
  }
  
  public final void a(String paramString, b.a parama)
  {
    this.byY.i(new b.3(this, parama, paramString));
  }
  
  public final void a(String paramString1, String paramString2, b.a parama)
  {
    this.byY.i(new b.4(this, paramString1, parama, paramString2));
  }
  
  public final void destroy()
  {
    this.byY.i(new Runnable()
    {
      public final void run()
      {
        y.i("MicroMsg.J2V8.V8ContextEngine", "destroy");
        int i = 0;
        while (i < b.this.bza.size())
        {
          ((c)b.this.bza.get(i)).cleanup();
          i += 1;
        }
        b.this.byX.release();
      }
    });
  }
  
  public final void pause()
  {
    this.byY.sn = true;
  }
  
  public final void resume()
  {
    h localh = this.byY;
    localh.sn = false;
    synchronized (localh.bzC)
    {
      localh.bzC.notify();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.d.a.b
 * JD-Core Version:    0.7.0.1
 */