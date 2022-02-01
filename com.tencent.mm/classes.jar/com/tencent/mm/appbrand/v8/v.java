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
  private final AtomicInteger cQL;
  public final ConcurrentHashMap<Integer, m> cQM;
  w cQN;
  private e cQO;
  
  public v(w paramw)
  {
    AppMethodBeat.i(144116);
    this.cQL = new AtomicInteger(0);
    this.cQM = new ConcurrentHashMap();
    this.cQO = new e()
    {
      public final void bufferStoreBindTo(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(193513);
        v.this.cQN.bufferStoreBindTo(paramAnonymousLong1, paramAnonymousLong2);
        AppMethodBeat.o(193513);
      }
      
      public final int generateId()
      {
        AppMethodBeat.i(193509);
        int i = v.this.cQN.LX();
        AppMethodBeat.o(193509);
        return i;
      }
      
      public final ByteBuffer getBuffer(int paramAnonymousInt)
      {
        AppMethodBeat.i(193510);
        ByteBuffer localByteBuffer = v.this.cQN.getBuffer(paramAnonymousInt);
        AppMethodBeat.o(193510);
        return localByteBuffer;
      }
      
      public final void setBuffer(int paramAnonymousInt, ByteBuffer paramAnonymousByteBuffer)
      {
        AppMethodBeat.i(193511);
        v.this.cQN.setBuffer(paramAnonymousInt, paramAnonymousByteBuffer);
        AppMethodBeat.o(193511);
      }
      
      public final boolean supportBufferStoreBindTo()
      {
        AppMethodBeat.i(193512);
        boolean bool = v.this.cQN.supportBufferStoreBindTo();
        AppMethodBeat.o(193512);
        return bool;
      }
    };
    this.cQN = paramw;
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
  
  public final int a(ArrayList<a> paramArrayList, final d paramd, final List<String> paramList)
  {
    AppMethodBeat.i(193514);
    final int j = this.cQL.addAndGet(1);
    Object localObject = new IJSRuntime.Config();
    ((IJSRuntime.Config)localObject).cPe = new WeakReference(paramd);
    paramd = y.f((IJSRuntime.Config)localObject);
    paramd.cOL = this.cQO;
    paramd = paramd.hE(1);
    localObject = ((IJSRuntime.Config)localObject).cPe;
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
        v.this.cQN.n(j, paramAnonymousV8Array.getString(0));
        AppMethodBeat.o(144109);
      }
    };
    paramd.cPC.q(new m.2(paramd, local2, "postMessage"));
    if (localObject != null)
    {
      paramList = new JavaCallback()
      {
        public final Object invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
        {
          AppMethodBeat.i(193506);
          String str1 = paramAnonymousV8Array.getString(0);
          String str2 = paramAnonymousV8Array.getString(1);
          int i = paramAnonymousV8Array.getInteger(2);
          paramAnonymousV8Object = "";
          if (this.cQR.get() != null)
          {
            paramAnonymousV8Object = (d)this.cQR.get();
            if ((paramList == null) || (!paramList.contains(str1)))
            {
              ad.e("MicroMsg.V8EngineWorkerManager", "hy: calling not permitted api: %s", new Object[] { str1 });
              paramAnonymousV8Object.a(i, d.al(str1, "fail:not supported"), new o()
              {
                public final void evaluateJavascript(String paramAnonymous2String, ValueCallback<String> paramAnonymous2ValueCallback)
                {
                  AppMethodBeat.i(193504);
                  v.a(v.this, (m)v.3.this.cQT.get(), paramAnonymous2String, paramAnonymous2ValueCallback);
                  AppMethodBeat.o(193504);
                }
              });
              paramAnonymousV8Object = "fail:not supported";
            }
          }
          for (;;)
          {
            AppMethodBeat.o(193506);
            return paramAnonymousV8Object;
            paramAnonymousV8Object = paramAnonymousV8Object.a(str1, str2, i, false, new o()
            {
              public final void evaluateJavascript(String paramAnonymous2String, ValueCallback<String> paramAnonymous2ValueCallback)
              {
                AppMethodBeat.i(193505);
                v.a(v.this, (m)v.3.this.cQT.get(), paramAnonymous2String, paramAnonymous2ValueCallback);
                AppMethodBeat.o(193505);
              }
            });
            continue;
            ad.w("MicroMsg.V8EngineWorkerManager", "hy: component lost. stop dispatch");
          }
        }
      };
      paramd.cPC.q(new m.14(paramd, paramList, "workerInvokeJsApi"));
    }
    paramd.a(1, new h()
    {
      public final void t(String paramAnonymousString1, String paramAnonymousString2)
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
      paramList = (a)paramArrayList.next();
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
    this.cQM.put(Integer.valueOf(j), paramd);
    AppMethodBeat.o(193514);
    return j;
  }
  
  protected void a(m paramm, a parama)
  {
    AppMethodBeat.i(144118);
    ad.i("MicroMsg.V8EngineWorkerManager", "hy: evaluating %s", new Object[] { parama.filePath });
    paramm.a(parama.filePath, parama.script, null);
    AppMethodBeat.o(144118);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.v
 * JD-Core Version:    0.7.0.1
 */