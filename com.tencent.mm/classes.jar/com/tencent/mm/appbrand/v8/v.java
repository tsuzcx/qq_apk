package com.tencent.mm.appbrand.v8;

import android.webkit.ValueCallback;
import com.eclipsesource.v8.JavaCallback;
import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.m.h;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.o;
import com.tencent.mm.plugin.appbrand.m.x;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public class v
{
  private final AtomicInteger dqY;
  public final ConcurrentHashMap<Integer, m> dqZ;
  w dra;
  private e drb;
  
  public v(w paramw)
  {
    AppMethodBeat.i(144116);
    this.dqY = new AtomicInteger(0);
    this.dqZ = new ConcurrentHashMap();
    this.drb = new e()
    {
      public final void bufferStoreBindTo(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(216919);
        v.this.dra.bufferStoreBindTo(paramAnonymousLong1, paramAnonymousLong2);
        AppMethodBeat.o(216919);
      }
      
      public final int generateId()
      {
        AppMethodBeat.i(216915);
        int i = v.this.dra.XN();
        AppMethodBeat.o(216915);
        return i;
      }
      
      public final ByteBuffer getBuffer(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(216916);
        ByteBuffer localByteBuffer = v.this.dra.iU(paramAnonymousInt);
        AppMethodBeat.o(216916);
        return localByteBuffer;
      }
      
      public final void releaseDirectByteBuffer(ByteBuffer paramAnonymousByteBuffer) {}
      
      public final void setBuffer(int paramAnonymousInt, ByteBuffer paramAnonymousByteBuffer)
      {
        AppMethodBeat.i(216917);
        v.this.dra.setBuffer(paramAnonymousInt, paramAnonymousByteBuffer);
        AppMethodBeat.o(216917);
      }
      
      public final boolean supportBufferStoreBindTo()
      {
        AppMethodBeat.i(216918);
        boolean bool = v.this.dra.supportBufferStoreBindTo();
        AppMethodBeat.o(216918);
        return bool;
      }
    };
    this.dra = paramw;
    AppMethodBeat.o(144116);
  }
  
  static void a(m paramm, String paramString1, String paramString2)
  {
    AppMethodBeat.i(175404);
    com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.V8EngineWorkerManager", "handleException(%s), stackTrace : %s", new Object[] { paramString1, paramString2 });
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("message", paramString1);
      localJSONObject.put("stack", paramString2);
      paramm.a(String.format("WeixinWorker.errorHandler(%s)", new Object[] { localJSONObject }), null);
      AppMethodBeat.o(175404);
      return;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.V8EngineWorkerManager", android.util.Log.getStackTraceString(paramString1));
      }
    }
  }
  
  public final int a(ArrayList<a> paramArrayList, final g paramg, final List<String> paramList)
  {
    AppMethodBeat.i(216920);
    final int j = this.dqY.addAndGet(1);
    Object localObject1 = new IJSRuntime.Config();
    ((IJSRuntime.Config)localObject1).dpl = "1";
    ((IJSRuntime.Config)localObject1).dpm = true;
    ((IJSRuntime.Config)localObject1).dpo = true;
    ((IJSRuntime.Config)localObject1).dpp = true;
    ((IJSRuntime.Config)localObject1).dps = new WeakReference(paramg);
    Object localObject2 = new x((IJSRuntime.Config)localObject1);
    ((a)((com.tencent.mm.plugin.appbrand.m.a)localObject2).dqn).doV = this.drb;
    final m localm = ((com.tencent.mm.plugin.appbrand.m.a)localObject2).mNC;
    a(paramArrayList, (i)localObject2, paramg);
    this.dqZ.put(Integer.valueOf(j), localm);
    paramg.getContext();
    a(j, paramg);
    paramg = ((IJSRuntime.Config)localObject1).dps;
    localObject1 = new WeakReference(localm);
    localObject2 = new JavaVoidCallback()
    {
      public final void invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
      {
        AppMethodBeat.i(144109);
        if ((paramAnonymousV8Array.length() <= 0) || (paramAnonymousV8Array.getType(0) != 4))
        {
          AppMethodBeat.o(144109);
          return;
        }
        v.this.dra.p(j, paramAnonymousV8Array.getString(0));
        AppMethodBeat.o(144109);
      }
    };
    localm.dpQ.r(new m.2(localm, (JavaVoidCallback)localObject2, "postMessage"));
    if (paramg != null)
    {
      paramg = new JavaCallback()
      {
        public final Object invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
        {
          AppMethodBeat.i(216910);
          String str1 = paramAnonymousV8Array.getString(0);
          String str2 = paramAnonymousV8Array.getString(1);
          int i = paramAnonymousV8Array.getInteger(2);
          paramAnonymousV8Object = "";
          if (paramg.get() != null)
          {
            paramAnonymousV8Object = (g)paramg.get();
            if ((paramList == null) || (!paramList.contains(str1)))
            {
              com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.V8EngineWorkerManager", "hy: calling not permitted api: %s", new Object[] { str1 });
              paramAnonymousV8Object.a(i, g.as(str1, "fail:not supported"), new o()
              {
                public final void evaluateJavascript(String paramAnonymous2String, ValueCallback<String> paramAnonymous2ValueCallback)
                {
                  AppMethodBeat.i(216908);
                  v.a(v.this, (m)v.3.this.drg.get(), paramAnonymous2String, paramAnonymous2ValueCallback);
                  AppMethodBeat.o(216908);
                }
              });
              paramAnonymousV8Object = "fail:not supported";
            }
          }
          for (;;)
          {
            AppMethodBeat.o(216910);
            return paramAnonymousV8Object;
            paramAnonymousV8Object = paramAnonymousV8Object.a(str1, str2, i, false, new o()
            {
              public final void evaluateJavascript(String paramAnonymous2String, ValueCallback<String> paramAnonymous2ValueCallback)
              {
                AppMethodBeat.i(216909);
                v.a(v.this, (m)v.3.this.drg.get(), paramAnonymous2String, paramAnonymous2ValueCallback);
                AppMethodBeat.o(216909);
              }
            });
            continue;
            com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.V8EngineWorkerManager", "hy: component lost. stop dispatch");
          }
        }
      };
      localm.dpQ.r(new m.14(localm, paramg, "workerInvokeJsApi"));
    }
    localm.a(1, new h()
    {
      public final void u(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(144108);
        v.a(localm, paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(144108);
      }
    });
    paramArrayList = paramArrayList.iterator();
    label307:
    while (paramArrayList.hasNext())
    {
      paramg = (a)paramArrayList.next();
      if (paramg != null)
      {
        if ((!Util.isNullOrNil(paramg.script)) || (!Util.isNullOrNil(paramg.filePath))) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label307;
          }
          a(localm, paramg);
          break;
        }
      }
    }
    AppMethodBeat.o(216920);
    return j;
  }
  
  protected void a(int paramInt, g paramg)
  {
    AppMethodBeat.i(216922);
    com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.V8EngineWorkerManager", "hy: not support bind native in nano case");
    AppMethodBeat.o(216922);
  }
  
  protected void a(m paramm, a parama)
  {
    AppMethodBeat.i(144118);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.V8EngineWorkerManager", "hy: evaluating %s", new Object[] { parama.filePath });
    paramm.a(parama.filePath, parama.script, null);
    AppMethodBeat.o(144118);
  }
  
  protected void a(ArrayList<a> paramArrayList, i parami, g paramg)
  {
    AppMethodBeat.i(216921);
    com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.V8EngineWorkerManager", "hy: do noting in base worker manager");
    AppMethodBeat.o(216921);
  }
  
  public final m iT(int paramInt)
  {
    AppMethodBeat.i(144121);
    m localm = (m)this.dqZ.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(144121);
    return localm;
  }
  
  public void terminate(int paramInt)
  {
    AppMethodBeat.i(216923);
    m localm = (m)this.dqZ.remove(Integer.valueOf(paramInt));
    if (localm != null) {
      localm.destroy();
    }
    AppMethodBeat.o(216923);
  }
  
  public static class a
  {
    public String filePath;
    public String script;
    
    public a(String paramString1, String paramString2)
    {
      this.filePath = paramString1;
      this.script = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.v
 * JD-Core Version:    0.7.0.1
 */