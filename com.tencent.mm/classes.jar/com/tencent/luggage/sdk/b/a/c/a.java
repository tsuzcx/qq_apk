package com.tencent.luggage.sdk.b.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.commonjni.AppBrandCommonBindingJni;
import com.tencent.mm.appbrand.commonjni.a.a.b;
import com.tencent.mm.appbrand.commonjni.a.b;
import com.tencent.mm.appbrand.commonjni.a.b.a;
import com.tencent.mm.appbrand.commonjni.a.c.c;
import com.tencent.mm.appbrand.commonjni.buffer.BufferURLManager;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.utils.x;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.Objects;

public final class a
{
  public final AppBrandCommonBindingJni cAE;
  public final BufferURLManager cAF;
  
  static
  {
    AppMethodBeat.i(229849);
    b.a(new b.a()
    {
      public final void loadLibrary(String paramAnonymousString)
      {
        AppMethodBeat.i(229844);
        long l = Util.currentTicks();
        j.load(paramAnonymousString);
        Log.i("MicroMsg.AppBrandCommonBinding", "hy: test loading %s using %d ms", new Object[] { paramAnonymousString, Long.valueOf(Util.ticksToNow(l)) });
        AppMethodBeat.o(229844);
      }
    });
    c.c.a(new a.2());
    b.loadLibrary("wxa-runtime-binding");
    AppMethodBeat.o(229849);
  }
  
  public a(a.b paramb)
  {
    AppMethodBeat.i(229848);
    this.cAE = new AppBrandCommonBindingJni(paramb);
    this.cAF = new BufferURLManager();
    AppMethodBeat.o(229848);
  }
  
  public final AppBrandCommonBindingJni Oh()
  {
    return this.cAE;
  }
  
  public static abstract class a
    implements a.b
  {
    private final WeakReference<g> cAG;
    
    public a(g paramg)
    {
      this.cAG = new WeakReference(paramg);
    }
    
    public final String[] getAsyncableJsApis()
    {
      if (this.cAG.get() == null)
      {
        Log.e("MicroMsg.AbsAppBrandDelegate", "hy: component released when getAsyncableJsApis");
        return new String[0];
      }
      return ((g)this.cAG.get()).getAsyncableJsApis();
    }
    
    public String nativeInvokeHandler(final String paramString1, String paramString2, int paramInt, boolean paramBoolean)
    {
      if (this.cAG.get() == null)
      {
        Log.e("MicroMsg.AbsAppBrandDelegate", "hy: component released when nativeInvokeHandler: %s, %s, %d, %b", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
        return null;
      }
      try
      {
        paramString1 = ((g)this.cAG.get()).a(paramString1, paramString2, paramInt, paramBoolean);
        return paramString1;
      }
      catch (Throwable paramString1)
      {
        Log.printErrStackTrace("MicroMsg.AbsAppBrandDelegate", paramString1, "IMBInvokeHandler.invoke", new Object[0]);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            throw paramString1;
          }
        });
      }
      return "";
    }
    
    public final ByteBuffer readWeAppFile(String paramString)
    {
      if (this.cAG.get() == null)
      {
        Log.e("MicroMsg.AbsAppBrandDelegate", "hy: component released when readWeAppFile");
        return null;
      }
      i locali = new i();
      m localm = ((q)Objects.requireNonNull(((g)this.cAG.get()).getFileSystem())).b(paramString, locali);
      if (localm == m.kSu) {
        return x.q((ByteBuffer)locali.value);
      }
      Log.e("MicroMsg.AbsAppBrandDelegate", "readFile %s failed: %s", new Object[] { paramString, localm });
      return null;
    }
    
    public boolean syncInitModule(String paramString1, String paramString2)
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c.a
 * JD-Core Version:    0.7.0.1
 */