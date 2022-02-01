package com.tencent.mm.appbrand.v8;

import com.eclipsesource.mmv8.MultiContextNodeJS;
import com.eclipsesource.mmv8.MultiContextV8;
import com.eclipsesource.mmv8.V8;
import com.eclipsesource.mmv8.V8.JavaTaskScheduler;
import com.eclipsesource.mmv8.V8Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class h
  extends a
{
  private MultiContextNodeJS hms;
  private volatile m hmt;
  private i hmu;
  
  static
  {
    AppMethodBeat.i(144026);
    MultiContextNodeJS.setGetTmpFileDirectoryDelegate(new h.1());
    AppMethodBeat.o(144026);
  }
  
  private h(IJSRuntime.Config paramConfig)
  {
    super(paramConfig);
  }
  
  static h e(IJSRuntime.Config paramConfig)
  {
    AppMethodBeat.i(144022);
    paramConfig = new h(paramConfig);
    AppMethodBeat.o(144022);
    return paramConfig;
  }
  
  final MultiContextV8 aDT()
  {
    AppMethodBeat.i(144023);
    try
    {
      this.hms = MultiContextNodeJS.createMultiContextNodeJS(1, this.hlN, this.hlO, this.hlR);
      this.hms.getRuntime().getV8().setNativeJavaCallback(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(238642);
          h.a(h.this).aEf();
          AppMethodBeat.o(238642);
        }
      });
      this.hms.getRuntime().getV8().setJavaTaskScheduler(new V8.JavaTaskScheduler()
      {
        public final void Schedule(Runnable paramAnonymousRunnable)
        {
          AppMethodBeat.i(238643);
          h.a(h.this).x(paramAnonymousRunnable);
          AppMethodBeat.o(238643);
        }
      });
      this.hlO = null;
      MultiContextV8 localMultiContextV8 = this.hms.getRuntime();
      AppMethodBeat.o(144023);
      return localMultiContextV8;
    }
    finally
    {
      AppMethodBeat.o(144023);
    }
  }
  
  final c aDU()
  {
    AppMethodBeat.i(144024);
    this.hmu = i.a(new i.a()
    {
      public final boolean aEd()
      {
        AppMethodBeat.i(238651);
        boolean bool = h.b(h.this).handleMessage();
        AppMethodBeat.o(238651);
        return bool;
      }
      
      public final void closeUVLoop()
      {
        AppMethodBeat.i(238659);
        if (h.b(h.this) != null) {
          h.b(h.this).closeUVLoop();
        }
        AppMethodBeat.o(238659);
      }
      
      public final void wakeUpUVLoop()
      {
        AppMethodBeat.i(238655);
        if (h.b(h.this) != null) {
          h.b(h.this).wakeUpUVLoop();
        }
        AppMethodBeat.o(238655);
      }
    }, aDS().hmh);
    i locali = this.hmu;
    AppMethodBeat.o(144024);
    return locali;
  }
  
  final void aDV()
  {
    AppMethodBeat.i(144025);
    Log.i("MicroMsg.NodeJSRuntime", "cleanUpRuntimeWhenThreadEnd");
    try
    {
      this.hms.release();
      Log.i("MicroMsg.NodeJSRuntime", "cleanUpRuntimeWhenThreadEnd done");
      AppMethodBeat.o(144025);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.NodeJSRuntime", "cleanUpWhenThreadEnd exp = %s", new Object[] { localException });
      AppMethodBeat.o(144025);
    }
  }
  
  public final m aEc()
  {
    AppMethodBeat.i(238675);
    if (this.hmt == null) {
      this.hmt = new m(this, aDW(), new m.a()
      {
        public final V8Context aDZ()
        {
          AppMethodBeat.i(238662);
          if (h.b(h.this) == null)
          {
            localObject = new IllegalStateException("getMainContext mNodeJS not ready!");
            AppMethodBeat.o(238662);
            throw ((Throwable)localObject);
          }
          Log.i("MicroMsg.NodeJSRuntime", "getMainContext %s", new Object[] { Integer.valueOf(h.b(h.this).getMainContext().hashCode()) });
          Object localObject = h.b(h.this).getMainContext();
          AppMethodBeat.o(238662);
          return localObject;
        }
      });
    }
    m localm = this.hmt;
    AppMethodBeat.o(238675);
    return localm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.h
 * JD-Core Version:    0.7.0.1
 */