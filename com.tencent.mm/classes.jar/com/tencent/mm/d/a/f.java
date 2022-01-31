package com.tencent.mm.d.a;

import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Context;
import com.eclipsesource.v8.V8Function;
import com.eclipsesource.v8.V8Object;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collection;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

final class f
  extends c
{
  final AtomicInteger bzo = new AtomicInteger(0);
  final ConcurrentHashMap<Integer, a> bzp = new ConcurrentHashMap();
  
  static int cC(String paramString)
  {
    if (paramString != null) {
      try
      {
        if (paramString.length() <= 0) {
          return -2147483648;
        }
        int i = Integer.decode(paramString).intValue();
        return i;
      }
      catch (NumberFormatException paramString)
      {
        y.printErrStackTrace("MicroMsg.J2V8.V8DirectApiTimer", paramString, "", new Object[0]);
      }
    }
    return -2147483648;
  }
  
  protected final void a(b paramb, V8Object paramV8Object)
  {
    paramV8Object.registerJavaMethod(new f.1(this, paramb), "setTimeout");
    paramV8Object.registerJavaMethod(new f.2(this, paramb), "setInterval");
    paramV8Object.registerJavaMethod(new f.3(this), "clearTimeout");
    paramV8Object.registerJavaMethod(new JavaVoidCallback()
    {
      public final void invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
      {
        if ((paramAnonymousV8Array.length() <= 0) || (paramAnonymousV8Array.getType(0) != 1)) {
          return;
        }
        f.a(f.this, paramAnonymousV8Array.getInteger(0));
      }
    }, "clearInterval");
  }
  
  public final void cleanup()
  {
    Iterator localIterator = this.bzp.values().iterator();
    while (localIterator.hasNext()) {
      a.a((a)localIterator.next());
    }
    this.bzp.clear();
  }
  
  private final class a
  {
    V8Context bzu;
    V8Function bzv;
    V8Array bzw;
    Timer bzx;
    boolean cancelled = false;
    int id;
    
    public a(V8Context paramV8Context, Timer paramTimer, int paramInt, V8Function paramV8Function, V8Array paramV8Array)
    {
      this.bzu = paramV8Context;
      this.bzv = paramV8Function;
      this.bzw = paramV8Array;
      this.id = paramInt;
      this.bzx = paramTimer;
    }
    
    private void cleanup()
    {
      f.this.bzp.remove(Integer.valueOf(this.id));
      this.bzv.release();
      this.bzw.release();
    }
    
    public final void aR(boolean paramBoolean)
    {
      if ((!this.bzv.isReleased()) && (!this.bzu.isReleased())) {
        this.bzv.call(this.bzu.getGlobalObject(), this.bzw);
      }
      if (paramBoolean) {
        cleanup();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.d.a.f
 * JD-Core Version:    0.7.0.1
 */