package com.tencent.mm.appbrand.v8;

import android.content.Context;
import android.util.Log;
import android.webkit.ValueCallback;
import com.eclipsesource.v8.JavaCallback;
import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Context;
import com.eclipsesource.v8.V8Function;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.V8ScriptException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsruntime.h;
import com.tencent.mm.plugin.appbrand.jsruntime.o;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
  private final AtomicInteger dau;
  public final ConcurrentHashMap<Integer, m> dav;
  w daw;
  private e dax;
  
  public v(w paramw)
  {
    AppMethodBeat.i(144116);
    this.dau = new AtomicInteger(0);
    this.dav = new ConcurrentHashMap();
    this.dax = new e()
    {
      public final void bufferStoreBindTo(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(194199);
        v.this.daw.bufferStoreBindTo(paramAnonymousLong1, paramAnonymousLong2);
        AppMethodBeat.o(194199);
      }
      
      public final int generateId()
      {
        AppMethodBeat.i(194195);
        int i = v.this.daw.NC();
        AppMethodBeat.o(194195);
        return i;
      }
      
      public final ByteBuffer getBuffer(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(194196);
        ByteBuffer localByteBuffer = v.this.daw.hA(paramAnonymousInt);
        AppMethodBeat.o(194196);
        return localByteBuffer;
      }
      
      public final void releaseDirectByteBuffer(ByteBuffer paramAnonymousByteBuffer) {}
      
      public final void setBuffer(int paramAnonymousInt, ByteBuffer paramAnonymousByteBuffer)
      {
        AppMethodBeat.i(194197);
        v.this.daw.setBuffer(paramAnonymousInt, paramAnonymousByteBuffer);
        AppMethodBeat.o(194197);
      }
      
      public final boolean supportBufferStoreBindTo()
      {
        AppMethodBeat.i(194198);
        boolean bool = v.this.daw.supportBufferStoreBindTo();
        AppMethodBeat.o(194198);
        return bool;
      }
    };
    this.daw = paramw;
    AppMethodBeat.o(144116);
  }
  
  static void a(m paramm, String paramString1, String paramString2)
  {
    AppMethodBeat.i(175404);
    ae.e("MicroMsg.V8EngineWorkerManager", "handleException(%s), stackTrace : %s", new Object[] { paramString1, paramString2 });
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
        ae.e("MicroMsg.V8EngineWorkerManager", Log.getStackTraceString(paramString1));
      }
    }
  }
  
  public final int a(ArrayList<v.a> paramArrayList, final d paramd, final List<String> paramList)
  {
    AppMethodBeat.i(194200);
    final int j = this.dau.addAndGet(1);
    Object localObject2 = new IJSRuntime.Config();
    ((IJSRuntime.Config)localObject2).cYN = new WeakReference(paramd);
    Object localObject1 = y.f((IJSRuntime.Config)localObject2);
    ((a)localObject1).cYr = this.dax;
    localObject1 = ((y)localObject1).hv(1);
    a(paramd.getContext(), (m)localObject1);
    paramd = ((IJSRuntime.Config)localObject2).cYN;
    localObject2 = new WeakReference(localObject1);
    JavaVoidCallback local2 = new JavaVoidCallback()
    {
      public final void invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
      {
        AppMethodBeat.i(144109);
        if ((paramAnonymousV8Array.length() <= 0) || (paramAnonymousV8Array.getType(0) != 4))
        {
          AppMethodBeat.o(144109);
          return;
        }
        v.this.daw.n(j, paramAnonymousV8Array.getString(0));
        AppMethodBeat.o(144109);
      }
    };
    ((m)localObject1).cZl.r(new m.2((m)localObject1, local2, "postMessage"));
    if (paramd != null)
    {
      paramd = new JavaCallback()
      {
        public final Object invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
        {
          AppMethodBeat.i(194190);
          String str1 = paramAnonymousV8Array.getString(0);
          String str2 = paramAnonymousV8Array.getString(1);
          int i = paramAnonymousV8Array.getInteger(2);
          paramAnonymousV8Object = "";
          if (paramd.get() != null)
          {
            paramAnonymousV8Object = (d)paramd.get();
            if ((paramList == null) || (!paramList.contains(str1)))
            {
              ae.e("MicroMsg.V8EngineWorkerManager", "hy: calling not permitted api: %s", new Object[] { str1 });
              paramAnonymousV8Object.a(i, d.aq(str1, "fail:not supported"), new o()
              {
                public final void evaluateJavascript(String paramAnonymous2String, ValueCallback<String> paramAnonymous2ValueCallback)
                {
                  AppMethodBeat.i(194188);
                  v.a(v.this, (m)v.3.this.daC.get(), paramAnonymous2String, paramAnonymous2ValueCallback);
                  AppMethodBeat.o(194188);
                }
              });
              paramAnonymousV8Object = "fail:not supported";
            }
          }
          for (;;)
          {
            AppMethodBeat.o(194190);
            return paramAnonymousV8Object;
            paramAnonymousV8Object = paramAnonymousV8Object.a(str1, str2, i, false, new o()
            {
              public final void evaluateJavascript(String paramAnonymous2String, ValueCallback<String> paramAnonymous2ValueCallback)
              {
                AppMethodBeat.i(194189);
                v.a(v.this, (m)v.3.this.daC.get(), paramAnonymous2String, paramAnonymous2ValueCallback);
                AppMethodBeat.o(194189);
              }
            });
            continue;
            ae.w("MicroMsg.V8EngineWorkerManager", "hy: component lost. stop dispatch");
          }
        }
      };
      ((m)localObject1).cZl.r(new m.14((m)localObject1, paramd, "workerInvokeJsApi"));
    }
    ((m)localObject1).a(1, new h()
    {
      public final void u(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(144108);
        v.a(this.day, paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(144108);
      }
    });
    paramArrayList = paramArrayList.iterator();
    label248:
    while (paramArrayList.hasNext())
    {
      paramd = (v.a)paramArrayList.next();
      if (paramd != null)
      {
        if ((!bu.isNullOrNil(paramd.script)) || (!bu.isNullOrNil(paramd.filePath))) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label248;
          }
          a((m)localObject1, paramd);
          break;
        }
      }
    }
    this.dav.put(Integer.valueOf(j), localObject1);
    AppMethodBeat.o(194200);
    return j;
  }
  
  protected void a(Context paramContext, m paramm)
  {
    AppMethodBeat.i(194201);
    ae.e("MicroMsg.V8EngineWorkerManager", "hy: not support bind native in nano case");
    AppMethodBeat.o(194201);
  }
  
  protected void a(m paramm, v.a parama)
  {
    AppMethodBeat.i(144118);
    ae.i("MicroMsg.V8EngineWorkerManager", "hy: evaluating %s", new Object[] { parama.filePath });
    paramm.a(parama.filePath, parama.script, null);
    AppMethodBeat.o(144118);
  }
  
  public o b(final m paramm)
  {
    AppMethodBeat.i(194203);
    paramm = new o()
    {
      public final void evaluateJavascript(String paramAnonymousString, final ValueCallback<String> paramAnonymousValueCallback)
      {
        AppMethodBeat.i(194193);
        if (paramm != null) {
          paramm.a(paramAnonymousString, new m.b()
          {
            public final void a(String paramAnonymous2String, m.c paramAnonymous2c)
            {
              AppMethodBeat.i(194192);
              if (paramAnonymousValueCallback != null) {
                paramAnonymousValueCallback.onReceiveValue(paramAnonymous2String);
              }
              AppMethodBeat.o(194192);
            }
          });
        }
        AppMethodBeat.o(194193);
      }
    };
    AppMethodBeat.o(194203);
    return paramm;
  }
  
  public final m hz(int paramInt)
  {
    AppMethodBeat.i(144121);
    m localm = (m)this.dav.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(144121);
    return localm;
  }
  
  public void terminate(int paramInt)
  {
    AppMethodBeat.i(194202);
    m localm = (m)this.dav.remove(Integer.valueOf(paramInt));
    if (localm != null) {
      localm.destroy();
    }
    AppMethodBeat.o(194202);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.v
 * JD-Core Version:    0.7.0.1
 */