package com.tencent.mm.appbrand.v8;

import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.eclipsesource.mmv8.JavaCallback;
import com.eclipsesource.mmv8.JavaVoidCallback;
import com.eclipsesource.mmv8.V8Array;
import com.eclipsesource.mmv8.V8Context;
import com.eclipsesource.mmv8.V8Function;
import com.eclipsesource.mmv8.V8Object;
import com.eclipsesource.mmv8.V8ScriptException;
import com.tencent.luggage.l.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.n.a;
import com.tencent.mm.plugin.appbrand.n.h;
import com.tencent.mm.plugin.appbrand.n.i;
import com.tencent.mm.plugin.appbrand.n.o;
import com.tencent.mm.plugin.appbrand.n.x;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public class v
{
  private final AtomicInteger hnS;
  public final ConcurrentHashMap<Integer, m> hnT;
  w hnU;
  private e hnV;
  
  public v(w paramw)
  {
    AppMethodBeat.i(144116);
    this.hnS = new AtomicInteger(aEq());
    this.hnT = new ConcurrentHashMap();
    this.hnV = new e()
    {
      public final void bufferStoreBindTo(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(238619);
        v.this.hnU.bufferStoreBindTo(paramAnonymousLong1, paramAnonymousLong2);
        AppMethodBeat.o(238619);
      }
      
      public final int generateId()
      {
        AppMethodBeat.i(238601);
        int i = v.this.hnU.aEt();
        AppMethodBeat.o(238601);
        return i;
      }
      
      public final ByteBuffer getBuffer(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(238605);
        ByteBuffer localByteBuffer = v.this.hnU.nS(paramAnonymousInt);
        AppMethodBeat.o(238605);
        return localByteBuffer;
      }
      
      public final void releaseDirectByteBuffer(ByteBuffer paramAnonymousByteBuffer) {}
      
      public final void setBuffer(int paramAnonymousInt, ByteBuffer paramAnonymousByteBuffer)
      {
        AppMethodBeat.i(238609);
        v.this.hnU.setBuffer(paramAnonymousInt, paramAnonymousByteBuffer);
        AppMethodBeat.o(238609);
      }
      
      public final boolean supportBufferStoreBindTo()
      {
        AppMethodBeat.i(238612);
        boolean bool = v.this.hnU.supportBufferStoreBindTo();
        AppMethodBeat.o(238612);
        return bool;
      }
    };
    this.hnU = paramw;
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
  
  public final int a(final ArrayList<b> paramArrayList, final g paramg, final List<String> paramList, final a parama, int paramInt, final c paramc)
  {
    AppMethodBeat.i(238637);
    final int i = paramInt;
    if (paramInt == -1) {
      i = this.hnS.addAndGet(1);
    }
    Object localObject = new IJSRuntime.Config();
    ((IJSRuntime.Config)localObject).hmd = "1";
    ((IJSRuntime.Config)localObject).hme = true;
    ((IJSRuntime.Config)localObject).hmg = true;
    ((IJSRuntime.Config)localObject).hmh = true;
    ((IJSRuntime.Config)localObject).hml = new WeakReference(paramg);
    ((IJSRuntime.Config)localObject).hmm = this.hnV;
    x localx = new x((IJSRuntime.Config)localObject);
    final m localm = localx.sSU;
    a(paramArrayList, localx, paramg);
    this.hnT.put(Integer.valueOf(i), localm);
    paramg.getContext();
    boolean bool;
    if (parama == a.hoh)
    {
      bool = true;
      a(i, paramg, paramList, bool);
      paramg = ((IJSRuntime.Config)localObject).hml;
      parama = new WeakReference(localm);
      localObject = new JavaVoidCallback()
      {
        public final void invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
        {
          AppMethodBeat.i(238628);
          if ((paramAnonymousV8Array.length() <= 0) || (paramAnonymousV8Array.getType(0) != 4))
          {
            AppMethodBeat.o(238628);
            return;
          }
          v.this.hnU.q(i, paramAnonymousV8Array.getString(0));
          AppMethodBeat.o(238628);
        }
      };
      localm.hmL.u(new m.2(localm, (JavaVoidCallback)localObject, "postMessage"));
      parama = a(i, parama);
      if (paramg != null)
      {
        paramg = new JavaCallback()
        {
          public final Object invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
          {
            AppMethodBeat.i(238614);
            String str1 = paramAnonymousV8Array.getString(0);
            String str2 = paramAnonymousV8Array.getString(1);
            int i = paramAnonymousV8Array.getInteger(2);
            if ((paramAnonymousV8Array.length() >= 4) && (paramAnonymousV8Array.getType(3) == 4)) {}
            for (paramAnonymousV8Object = paramAnonymousV8Array.getString(3);; paramAnonymousV8Object = "")
            {
              paramAnonymousV8Array = "";
              if (paramg.get() == null) {
                break label162;
              }
              paramAnonymousV8Array = (g)paramg.get();
              if ((paramList != null) && (paramList.contains(str1))) {
                break;
              }
              com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.V8EngineWorkerManager", "hy: calling not permitted api: %s", new Object[] { str1 });
              paramAnonymousV8Array.a(i, g.aE(str1, "fail:not supported"), parama);
              AppMethodBeat.o(238614);
              return "fail:not supported";
            }
            for (paramAnonymousV8Object = paramAnonymousV8Array.a(str1, str2, paramAnonymousV8Object, i, false, parama);; paramAnonymousV8Object = paramAnonymousV8Array)
            {
              AppMethodBeat.o(238614);
              return paramAnonymousV8Object;
              label162:
              com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.V8EngineWorkerManager", "hy: component lost. stop dispatch");
            }
          }
        };
        localm.hmL.u(new m.14(localm, paramg, "workerInvokeJsApi"));
      }
      localm.a(1, new h()
      {
        public final void handleException(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(144108);
          v.a(localm, paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(144108);
        }
      });
      paramg = new ArrayList();
      paramArrayList = paramArrayList.iterator();
    }
    label278:
    label348:
    for (;;)
    {
      if (!paramArrayList.hasNext()) {
        break label350;
      }
      paramList = (b)paramArrayList.next();
      if (paramList != null)
      {
        if ((!Util.isNullOrNil(paramList.script)) || (!Util.isNullOrNil(paramList.filePath))) {}
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt == 0) {
            break label348;
          }
          paramg.add(paramList);
          break label278;
          bool = false;
          break;
        }
      }
    }
    label350:
    paramArrayList = new AtomicInteger(paramg.size());
    final long l = System.currentTimeMillis();
    if (paramc != null) {
      paramc.aEs();
    }
    paramg = paramg.iterator();
    while (paramg.hasNext())
    {
      paramList = (b)paramg.next();
      parama = new m.b()
      {
        public final void onResult(String paramAnonymousString, m.c paramAnonymousc)
        {
          AppMethodBeat.i(238616);
          if ((paramArrayList.decrementAndGet() == 0) && (paramc != null)) {
            paramc.dX(System.currentTimeMillis() - l);
          }
          AppMethodBeat.o(238616);
        }
      };
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.V8EngineWorkerManager", "hy: evaluating %s", new Object[] { paramList.filePath });
      if ((!TextUtils.isEmpty(paramList.esI)) && (!TextUtils.isEmpty(paramList.esH))) {
        localm.a(paramList.filePath, j.fI(paramList.script), parama, paramList.esH, paramList.esI, 0);
      } else {
        localm.a(paramList.filePath, j.fI(paramList.script), parama);
      }
    }
    AppMethodBeat.o(238637);
    return i;
  }
  
  protected o a(int paramInt, final WeakReference<m> paramWeakReference)
  {
    AppMethodBeat.i(238641);
    paramWeakReference = new o()
    {
      public final void evaluateJavascript(String paramAnonymousString, ValueCallback<String> paramAnonymousValueCallback)
      {
        AppMethodBeat.i(238610);
        v.this.a((m)paramWeakReference.get(), paramAnonymousString, paramAnonymousValueCallback);
        AppMethodBeat.o(238610);
      }
    };
    AppMethodBeat.o(238641);
    return paramWeakReference;
  }
  
  protected void a(int paramInt, m paramm)
  {
    AppMethodBeat.i(238648);
    paramm.destroy();
    paramm.hmL.quit();
    AppMethodBeat.o(238648);
  }
  
  protected void a(int paramInt, g paramg, List<String> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(238639);
    com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.V8EngineWorkerManager", "hy: not support bind native in nano case");
    AppMethodBeat.o(238639);
  }
  
  protected void a(m paramm, String paramString, final ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(238644);
    if (paramm != null)
    {
      if (paramValueCallback != null)
      {
        paramm.a(paramString, new m.b()
        {
          public final void onResult(String paramAnonymousString, m.c paramAnonymousc)
          {
            AppMethodBeat.i(238604);
            paramValueCallback.onReceiveValue(paramAnonymousString);
            AppMethodBeat.o(238604);
          }
        });
        AppMethodBeat.o(238644);
        return;
      }
      paramm.a(paramString, null);
      AppMethodBeat.o(238644);
      return;
    }
    com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.V8EngineWorkerManager", "hy: engine context released");
    AppMethodBeat.o(238644);
  }
  
  protected void a(ArrayList<b> paramArrayList, i parami, g paramg)
  {
    AppMethodBeat.i(238638);
    com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.V8EngineWorkerManager", "hy: do noting in base worker manager");
    AppMethodBeat.o(238638);
  }
  
  protected int aEq()
  {
    return 0;
  }
  
  public void aEr() {}
  
  public void exit()
  {
    AppMethodBeat.i(238654);
    Iterator localIterator = this.hnT.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      a(((Integer)localEntry.getKey()).intValue(), (m)localEntry.getValue());
    }
    AppMethodBeat.o(238654);
  }
  
  public final m nR(int paramInt)
  {
    AppMethodBeat.i(144121);
    m localm = (m)this.hnT.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(144121);
    return localm;
  }
  
  public final void terminate(int paramInt)
  {
    AppMethodBeat.i(238647);
    m localm = (m)this.hnT.remove(Integer.valueOf(paramInt));
    if (localm != null) {
      a(paramInt, localm);
    }
    AppMethodBeat.o(238647);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(238592);
      hog = new a("USER", 0);
      hoh = new a("COMMON", 1);
      hoi = new a[] { hog, hoh };
      AppMethodBeat.o(238592);
    }
    
    private a() {}
  }
  
  public static class b
  {
    public String esH = "";
    public String esI = "";
    public String filePath;
    public String script;
    
    public b(String paramString1, String paramString2)
    {
      this.filePath = paramString1;
      this.script = paramString2;
    }
    
    public b(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      this.filePath = paramString1;
      this.script = paramString2;
      this.esH = paramString3;
      this.esI = paramString4;
    }
  }
  
  public static abstract interface c
  {
    public abstract void aEs();
    
    public abstract void dX(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.v
 * JD-Core Version:    0.7.0.1
 */