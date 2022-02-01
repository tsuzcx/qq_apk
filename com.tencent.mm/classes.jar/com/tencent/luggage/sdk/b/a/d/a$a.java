package com.tencent.luggage.sdk.b.a.d;

import android.util.Base64;
import com.tencent.mm.plugin.appbrand.af.k;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.utils.ae;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.Objects;

public abstract class a$a
  implements com.tencent.mm.appbrand.commonjni.a.a.a
{
  private final WeakReference<g> esh;
  
  public a$a(g paramg)
  {
    this.esh = new WeakReference(paramg);
  }
  
  public final void W(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      h.OAn.p(paramInt1, paramInt2, paramInt3);
      return;
    }
    catch (Exception localException) {}
  }
  
  public final void fr(String paramString)
  {
    CrashReportFactory.reportRawMessage(Base64.encodeToString(paramString.getBytes(), 2), "appbrand_commonbinding");
  }
  
  public final String[] getAsyncableJsApis()
  {
    if (this.esh.get() == null)
    {
      Log.e("MicroMsg.AbsAppBrandDelegate", "hy: component released when getAsyncableJsApis");
      return new String[0];
    }
    return ((g)this.esh.get()).getAsyncableJsApis();
  }
  
  public String nativeInvokeHandler(final String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean)
  {
    if (this.esh.get() == null)
    {
      Log.e("MicroMsg.AbsAppBrandDelegate", "hy: component released when nativeInvokeHandler: %s, %s, %d, %b", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
      return null;
    }
    try
    {
      paramString1 = ((g)this.esh.get()).a(paramString1, paramString2, paramString3, paramInt, paramBoolean, null);
      return paramString1;
    }
    finally
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
  
  public ByteBuffer readWeAppFile(String paramString)
  {
    if (this.esh.get() == null)
    {
      Log.e("MicroMsg.AbsAppBrandDelegate", "hy: component released when readWeAppFile");
      return null;
    }
    k localk = new k();
    r localr = ((w)Objects.requireNonNull(((g)this.esh.get()).getFileSystem())).b(paramString, localk);
    if (localr == r.qML) {
      return ae.t((ByteBuffer)localk.value);
    }
    Log.e("MicroMsg.AbsAppBrandDelegate", "readFile %s failed: %s", new Object[] { paramString, localr });
    return null;
  }
  
  public final void reportKV(int paramInt, String paramString)
  {
    try
    {
      h.OAn.kvStat(paramInt, paramString);
      return;
    }
    catch (Exception paramString) {}
  }
  
  public boolean syncInitModule(String paramString1, String paramString2)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.d.a.a
 * JD-Core Version:    0.7.0.1
 */