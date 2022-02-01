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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.m.a;
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
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public class v
{
  private final AtomicInteger fjF;
  public final ConcurrentHashMap<Integer, m> fjG;
  w fjH;
  private e fjI;
  
  public v(w paramw)
  {
    AppMethodBeat.i(144116);
    this.fjF = new AtomicInteger(acq());
    this.fjG = new ConcurrentHashMap();
    this.fjI = new e()
    {
      public final void bufferStoreBindTo(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(262618);
        v.this.fjH.bufferStoreBindTo(paramAnonymousLong1, paramAnonymousLong2);
        AppMethodBeat.o(262618);
      }
      
      public final int generateId()
      {
        AppMethodBeat.i(262610);
        int i = v.this.fjH.act();
        AppMethodBeat.o(262610);
        return i;
      }
      
      public final ByteBuffer getBuffer(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(262613);
        ByteBuffer localByteBuffer = v.this.fjH.kk(paramAnonymousInt);
        AppMethodBeat.o(262613);
        return localByteBuffer;
      }
      
      public final void releaseDirectByteBuffer(ByteBuffer paramAnonymousByteBuffer) {}
      
      public final void setBuffer(int paramAnonymousInt, ByteBuffer paramAnonymousByteBuffer)
      {
        AppMethodBeat.i(262614);
        v.this.fjH.setBuffer(paramAnonymousInt, paramAnonymousByteBuffer);
        AppMethodBeat.o(262614);
      }
      
      public final boolean supportBufferStoreBindTo()
      {
        AppMethodBeat.i(262616);
        boolean bool = v.this.fjH.supportBufferStoreBindTo();
        AppMethodBeat.o(262616);
        return bool;
      }
    };
    this.fjH = paramw;
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
  
  public final int a(final ArrayList<b> paramArrayList, final f paramf, final List<String> paramList, final v.a parama, int paramInt, final c paramc)
  {
    AppMethodBeat.i(262229);
    final int i = paramInt;
    if (paramInt == -1) {
      i = this.fjF.addAndGet(1);
    }
    Object localObject = new IJSRuntime.Config();
    ((IJSRuntime.Config)localObject).fhR = "1";
    ((IJSRuntime.Config)localObject).fhS = true;
    ((IJSRuntime.Config)localObject).fhU = true;
    ((IJSRuntime.Config)localObject).fhV = true;
    ((IJSRuntime.Config)localObject).fhY = new WeakReference(paramf);
    ((IJSRuntime.Config)localObject).fhZ = this.fjI;
    x localx = new x((IJSRuntime.Config)localObject);
    final m localm = localx.pOw;
    a(paramArrayList, localx, paramf);
    this.fjG.put(Integer.valueOf(i), localm);
    paramf.getContext();
    boolean bool;
    if (parama == v.a.fjU)
    {
      bool = true;
      a(i, paramf, paramList, bool);
      paramf = ((IJSRuntime.Config)localObject).fhY;
      parama = new WeakReference(localm);
      localObject = new JavaVoidCallback()
      {
        public final void invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
        {
          AppMethodBeat.i(262843);
          if ((paramAnonymousV8Array.length() <= 0) || (paramAnonymousV8Array.getType(0) != 4))
          {
            AppMethodBeat.o(262843);
            return;
          }
          v.this.fjH.q(i, paramAnonymousV8Array.getString(0));
          AppMethodBeat.o(262843);
        }
      };
      localm.fiy.q(new m.2(localm, (JavaVoidCallback)localObject, "postMessage"));
      parama = a(i, parama);
      if (paramf != null)
      {
        paramf = new JavaCallback()
        {
          public final Object invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
          {
            AppMethodBeat.i(262175);
            String str1 = paramAnonymousV8Array.getString(0);
            String str2 = paramAnonymousV8Array.getString(1);
            int i = paramAnonymousV8Array.getInteger(2);
            paramAnonymousV8Object = "";
            if (paramf.get() != null)
            {
              paramAnonymousV8Object = (f)paramf.get();
              if ((paramList == null) || (!paramList.contains(str1)))
              {
                com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.V8EngineWorkerManager", "hy: calling not permitted api: %s", new Object[] { str1 });
                AppMethodBeat.o(262175);
                return "fail:not supported";
              }
              paramAnonymousV8Object = paramAnonymousV8Object.a(str1, str2, i, false, parama);
            }
            for (;;)
            {
              AppMethodBeat.o(262175);
              return paramAnonymousV8Object;
              com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.V8EngineWorkerManager", "hy: component lost. stop dispatch");
            }
          }
        };
        localm.fiy.q(new m.14(localm, paramf, "workerInvokeJsApi"));
      }
      localm.a(1, new h()
      {
        public final void A(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(144108);
          v.a(localm, paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(144108);
        }
      });
      paramf = new ArrayList();
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
          paramf.add(paramList);
          break label278;
          bool = false;
          break;
        }
      }
    }
    label350:
    paramArrayList = new AtomicInteger(paramf.size());
    final long l = System.currentTimeMillis();
    if (paramc != null) {
      paramc.acs();
    }
    paramf = paramf.iterator();
    while (paramf.hasNext())
    {
      paramList = (b)paramf.next();
      parama = new m.b()
      {
        public final void a(String paramAnonymousString, m.c paramAnonymousc)
        {
          AppMethodBeat.i(262657);
          if ((paramArrayList.decrementAndGet() == 0) && (paramc != null)) {
            paramc.bH(System.currentTimeMillis() - l);
          }
          AppMethodBeat.o(262657);
        }
      };
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.V8EngineWorkerManager", "hy: evaluating %s", new Object[] { paramList.filePath });
      if ((!TextUtils.isEmpty(paramList.cAn)) && (!TextUtils.isEmpty(paramList.cAm))) {
        localm.a(paramList.filePath, paramList.script, parama, paramList.cAm, paramList.cAn, 0);
      } else {
        localm.a(paramList.filePath, paramList.script, parama);
      }
    }
    AppMethodBeat.o(262229);
    return i;
  }
  
  protected o a(int paramInt, final WeakReference<m> paramWeakReference)
  {
    AppMethodBeat.i(262232);
    paramWeakReference = new o()
    {
      public final void evaluateJavascript(String paramAnonymousString, ValueCallback<String> paramAnonymousValueCallback)
      {
        AppMethodBeat.i(262586);
        v.this.a((m)paramWeakReference.get(), paramAnonymousString, paramAnonymousValueCallback);
        AppMethodBeat.o(262586);
      }
    };
    AppMethodBeat.o(262232);
    return paramWeakReference;
  }
  
  protected void a(int paramInt, m paramm)
  {
    AppMethodBeat.i(293018);
    paramm.destroy();
    paramm.fiy.quit();
    AppMethodBeat.o(293018);
  }
  
  protected void a(int paramInt, f paramf, List<String> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(262231);
    com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.V8EngineWorkerManager", "hy: not support bind native in nano case");
    AppMethodBeat.o(262231);
  }
  
  protected void a(m paramm, String paramString, final ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(262235);
    if (paramm != null)
    {
      if (paramValueCallback != null)
      {
        paramm.a(paramString, new m.b()
        {
          public final void a(String paramAnonymousString, m.c paramAnonymousc)
          {
            AppMethodBeat.i(262268);
            paramValueCallback.onReceiveValue(paramAnonymousString);
            AppMethodBeat.o(262268);
          }
        });
        AppMethodBeat.o(262235);
        return;
      }
      paramm.a(paramString, null);
      AppMethodBeat.o(262235);
      return;
    }
    com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.V8EngineWorkerManager", "hy: engine context released");
    AppMethodBeat.o(262235);
  }
  
  protected void a(ArrayList<b> paramArrayList, i parami, f paramf)
  {
    AppMethodBeat.i(262230);
    com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.V8EngineWorkerManager", "hy: do noting in base worker manager");
    AppMethodBeat.o(262230);
  }
  
  protected int acq()
  {
    return 0;
  }
  
  public void acr() {}
  
  public void exit()
  {
    AppMethodBeat.i(262240);
    Iterator localIterator = this.fjG.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      a(((Integer)localEntry.getKey()).intValue(), (m)localEntry.getValue());
    }
    AppMethodBeat.o(262240);
  }
  
  public final m kj(int paramInt)
  {
    AppMethodBeat.i(144121);
    m localm = (m)this.fjG.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(144121);
    return localm;
  }
  
  public final void terminate(int paramInt)
  {
    AppMethodBeat.i(262236);
    m localm = (m)this.fjG.remove(Integer.valueOf(paramInt));
    if (localm != null) {
      a(paramInt, localm);
    }
    AppMethodBeat.o(262236);
  }
  
  public static class b
  {
    public String cAm = "";
    public String cAn = "";
    public String filePath;
    public String script;
    
    public b(String paramString1, String paramString2)
    {
      this.filePath = paramString1;
      this.script = paramString2;
    }
  }
  
  public static abstract interface c
  {
    public abstract void acs();
    
    public abstract void bH(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.v
 * JD-Core Version:    0.7.0.1
 */