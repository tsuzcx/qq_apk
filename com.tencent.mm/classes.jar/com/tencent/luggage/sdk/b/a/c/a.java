package com.tencent.luggage.sdk.b.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.commonjni.AppBrandCommonBindingJni;
import com.tencent.mm.appbrand.commonjni.a.b;
import com.tencent.mm.appbrand.commonjni.a.c.c;
import com.tencent.mm.appbrand.commonjni.buffer.BufferURLManager;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.utils.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.Objects;

public final class a
{
  public final AppBrandCommonBindingJni czK;
  public final BufferURLManager czL;
  
  static
  {
    AppMethodBeat.i(247151);
    b.a(new a.1());
    c.c.a(new a.2());
    b.loadLibrary("wxa-runtime-binding");
    AppMethodBeat.o(247151);
  }
  
  public a(com.tencent.mm.appbrand.commonjni.a.a.a parama)
  {
    AppMethodBeat.i(247146);
    this.czK = new AppBrandCommonBindingJni(parama);
    this.czL = new BufferURLManager();
    AppMethodBeat.o(247146);
  }
  
  public final AppBrandCommonBindingJni Rf()
  {
    return this.czK;
  }
  
  public static abstract class a
    implements com.tencent.mm.appbrand.commonjni.a.a.a
  {
    private final WeakReference<f> czM;
    
    public a(f paramf)
    {
      this.czM = new WeakReference(paramf);
    }
    
    public final String[] getAsyncableJsApis()
    {
      if (this.czM.get() == null)
      {
        Log.e("MicroMsg.AbsAppBrandDelegate", "hy: component released when getAsyncableJsApis");
        return new String[0];
      }
      return ((f)this.czM.get()).getAsyncableJsApis();
    }
    
    public String nativeInvokeHandler(final String paramString1, String paramString2, int paramInt, boolean paramBoolean)
    {
      if (this.czM.get() == null)
      {
        Log.e("MicroMsg.AbsAppBrandDelegate", "hy: component released when nativeInvokeHandler: %s, %s, %d, %b", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
        return null;
      }
      try
      {
        paramString1 = ((f)this.czM.get()).a(paramString1, paramString2, paramInt, paramBoolean);
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
      if (this.czM.get() == null)
      {
        Log.e("MicroMsg.AbsAppBrandDelegate", "hy: component released when readWeAppFile");
        return null;
      }
      i locali = new i();
      m localm = ((r)Objects.requireNonNull(((f)this.czM.get()).getFileSystem())).b(paramString, locali);
      if (localm == m.nMR) {
        return z.n((ByteBuffer)locali.value);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c.a
 * JD-Core Version:    0.7.0.1
 */