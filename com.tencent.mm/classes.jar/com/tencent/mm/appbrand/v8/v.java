package com.tencent.mm.appbrand.v8;

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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  private final AtomicInteger cZw;
  public final ConcurrentHashMap<Integer, m> cZx;
  w cZy;
  private e cZz;
  
  public v(w paramw)
  {
    AppMethodBeat.i(144116);
    this.cZw = new AtomicInteger(0);
    this.cZx = new ConcurrentHashMap();
    this.cZz = new e()
    {
      public final void bufferStoreBindTo(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(198714);
        v.this.cZy.bufferStoreBindTo(paramAnonymousLong1, paramAnonymousLong2);
        AppMethodBeat.o(198714);
      }
      
      public final int generateId()
      {
        AppMethodBeat.i(198710);
        int i = v.this.cZy.NE();
        AppMethodBeat.o(198710);
        return i;
      }
      
      public final ByteBuffer getBuffer(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(221745);
        ByteBuffer localByteBuffer = v.this.cZy.getBuffer(paramAnonymousInt);
        AppMethodBeat.o(221745);
        return localByteBuffer;
      }
      
      public final void releaseDirectByteBuffer(ByteBuffer paramAnonymousByteBuffer) {}
      
      public final void setBuffer(int paramAnonymousInt, ByteBuffer paramAnonymousByteBuffer)
      {
        AppMethodBeat.i(198712);
        v.this.cZy.setBuffer(paramAnonymousInt, paramAnonymousByteBuffer);
        AppMethodBeat.o(198712);
      }
      
      public final boolean supportBufferStoreBindTo()
      {
        AppMethodBeat.i(198713);
        boolean bool = v.this.cZy.supportBufferStoreBindTo();
        AppMethodBeat.o(198713);
        return bool;
      }
    };
    this.cZy = paramw;
    AppMethodBeat.o(144116);
  }
  
  static void a(m paramm, String paramString1, String paramString2)
  {
    AppMethodBeat.i(175404);
    ad.e("MicroMsg.V8EngineWorkerManager", "handleException(%s), stackTrace : %s", new Object[] { paramString1, paramString2 });
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
        ad.e("MicroMsg.V8EngineWorkerManager", Log.getStackTraceString(paramString1));
      }
    }
  }
  
  public final int a(ArrayList<v.a> paramArrayList, final d paramd, final List<String> paramList)
  {
    AppMethodBeat.i(198715);
    final int j = this.cZw.addAndGet(1);
    Object localObject = new IJSRuntime.Config();
    ((IJSRuntime.Config)localObject).cXP = new WeakReference(paramd);
    paramd = y.f((IJSRuntime.Config)localObject);
    paramd.cXu = this.cZz;
    paramd = paramd.hv(1);
    localObject = ((IJSRuntime.Config)localObject).cXP;
    final WeakReference localWeakReference = new WeakReference(paramd);
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
        v.this.cZy.n(j, paramAnonymousV8Array.getString(0));
        AppMethodBeat.o(144109);
      }
    };
    paramd.cYn.r(new m.2(paramd, local2, "postMessage"));
    if (localObject != null)
    {
      paramList = new JavaCallback()
      {
        public final Object invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
        {
          AppMethodBeat.i(198707);
          String str1 = paramAnonymousV8Array.getString(0);
          String str2 = paramAnonymousV8Array.getString(1);
          int i = paramAnonymousV8Array.getInteger(2);
          paramAnonymousV8Object = "";
          if (this.cZC.get() != null)
          {
            paramAnonymousV8Object = (d)this.cZC.get();
            if ((paramList == null) || (!paramList.contains(str1)))
            {
              ad.e("MicroMsg.V8EngineWorkerManager", "hy: calling not permitted api: %s", new Object[] { str1 });
              paramAnonymousV8Object.a(i, d.ap(str1, "fail:not supported"), new o()
              {
                public final void evaluateJavascript(String paramAnonymous2String, ValueCallback<String> paramAnonymous2ValueCallback)
                {
                  AppMethodBeat.i(198705);
                  v.a(v.this, (m)v.3.this.cZE.get(), paramAnonymous2String, paramAnonymous2ValueCallback);
                  AppMethodBeat.o(198705);
                }
              });
              paramAnonymousV8Object = "fail:not supported";
            }
          }
          for (;;)
          {
            AppMethodBeat.o(198707);
            return paramAnonymousV8Object;
            paramAnonymousV8Object = paramAnonymousV8Object.a(str1, str2, i, false, new o()
            {
              public final void evaluateJavascript(String paramAnonymous2String, ValueCallback<String> paramAnonymous2ValueCallback)
              {
                AppMethodBeat.i(198706);
                v.a(v.this, (m)v.3.this.cZE.get(), paramAnonymous2String, paramAnonymous2ValueCallback);
                AppMethodBeat.o(198706);
              }
            });
            continue;
            ad.w("MicroMsg.V8EngineWorkerManager", "hy: component lost. stop dispatch");
          }
        }
      };
      paramd.cYn.r(new m.14(paramd, paramList, "workerInvokeJsApi"));
    }
    paramd.a(1, new h()
    {
      public final void u(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(144108);
        v.a(paramd, paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(144108);
      }
    });
    paramArrayList = paramArrayList.iterator();
    label229:
    while (paramArrayList.hasNext())
    {
      paramList = (v.a)paramArrayList.next();
      if (paramList != null)
      {
        if ((!bt.isNullOrNil(paramList.script)) || (!bt.isNullOrNil(paramList.filePath))) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label229;
          }
          a(paramd, paramList);
          break;
        }
      }
    }
    this.cZx.put(Integer.valueOf(j), paramd);
    AppMethodBeat.o(198715);
    return j;
  }
  
  protected void a(m paramm, v.a parama)
  {
    AppMethodBeat.i(144118);
    ad.i("MicroMsg.V8EngineWorkerManager", "hy: evaluating %s", new Object[] { parama.filePath });
    paramm.a(parama.filePath, parama.script, null);
    AppMethodBeat.o(144118);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.v
 * JD-Core Version:    0.7.0.1
 */