package com.tencent.mm.plugin.appbrand.t;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.t.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.SSLContext;
import org.json.JSONObject;

public final class g
{
  private f rot;
  private final String sKB;
  private boolean skm;
  private SSLContext tnm;
  protected final ArrayList<String> tnn;
  private int tof;
  public final ArrayList<com.tencent.mm.plugin.appbrand.t.b.a> tog;
  
  public g(f paramf, boolean paramBoolean)
  {
    AppMethodBeat.i(319176);
    this.skm = false;
    this.tog = new ArrayList();
    this.tnn = new ArrayList();
    this.rot = paramf;
    paramf = (a)paramf.aN(a.class);
    this.tof = paramf.epI;
    this.sKB = paramf.tnh;
    this.tnm = i.a(paramf);
    this.skm = paramBoolean;
    AppMethodBeat.o(319176);
  }
  
  final void Em(String paramString)
  {
    AppMethodBeat.i(144349);
    if (paramString == null)
    {
      AppMethodBeat.o(144349);
      return;
    }
    synchronized (this.tog)
    {
      Iterator localIterator = this.tog.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.t.b.a locala = (com.tencent.mm.plugin.appbrand.t.b.a)localIterator.next();
        if (paramString.equals(locala.ppa)) {
          this.tog.remove(locala);
        }
      }
      AppMethodBeat.o(144349);
      return;
    }
  }
  
  public final void a(int paramInt, String paramString1, String arg3, JSONObject paramJSONObject, Map<String, String> paramMap, ArrayList<String> paramArrayList, final a parama, final String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(144348);
    Object localObject = paramJSONObject.optString("url");
    Log.i("MicroMsg.AppBrandNetworkUpload", "upload taskId:%s url:%s", new Object[] { paramString3, localObject });
    String str1 = i.aeg((String)localObject);
    String str2 = paramJSONObject.optString("name");
    localObject = i.aC(paramJSONObject);
    synchronized (this.tog)
    {
      if (this.tog.size() >= this.tof)
      {
        parama.abi("tasked refused max connected");
        Log.i("MicroMsg.AppBrandNetworkUpload", "max connected mUploadTaskList.size():%d,mMaxUploadConcurrent:%d", new Object[] { Integer.valueOf(this.tog.size()), Integer.valueOf(this.tof) });
        AppMethodBeat.o(144348);
        return;
      }
      if (TextUtils.isEmpty(str2))
      {
        parama.abi("fileName error");
        Log.i("MicroMsg.AppBrandNetworkUpload", "fileName error");
        AppMethodBeat.o(144348);
        return;
      }
    }
    boolean bool1 = paramJSONObject.optBoolean("enableHttp2", false);
    boolean bool2 = paramJSONObject.optBoolean("enableQuic", false);
    boolean bool3 = paramJSONObject.optBoolean("enableCache", false);
    boolean bool4 = paramJSONObject.optBoolean("enableProfile", true);
    Log.i("MicroMsg.AppBrandNetworkUpload", "upload taskId %s,useHttp2 %b, useQuic %b, useMemoryCache %b, useProfile %b", new Object[] { paramString3, Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
    paramString1 = new com.tencent.mm.plugin.appbrand.t.b.a(this.rot, str1, ???, str2, paramString5, paramString1, this.sKB, this.skm, bool1, bool2, bool3, bool4, new b()
    {
      public final void O(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
      {
        AppMethodBeat.i(319136);
        Log.e("MicroMsg.AppBrandNetworkUpload", "upload error! errorMessage:%s, filename %s, url %s", new Object[] { paramAnonymousString3, paramAnonymousString1, paramAnonymousString2 });
        g.this.Em(paramString3);
        parama.abi(paramAnonymousString3);
        AppMethodBeat.o(319136);
      }
      
      public final void X(JSONObject paramAnonymousJSONObject)
      {
        AppMethodBeat.i(319128);
        parama.X(paramAnonymousJSONObject);
        AppMethodBeat.o(319128);
      }
      
      public final void adV(String paramAnonymousString)
      {
        AppMethodBeat.i(319145);
        g.this.tnn.remove(paramAnonymousString);
        AppMethodBeat.o(319145);
      }
      
      public final void e(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt)
      {
        AppMethodBeat.i(319125);
        g.this.Em(paramString3);
        parama.cH(paramAnonymousString3, paramAnonymousInt);
        Log.i("MicroMsg.AppBrandNetworkUpload", "upload success! filename %s, url %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
        AppMethodBeat.o(319125);
      }
      
      public final void fd(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(319141);
        Log.i("MicroMsg.AppBrandNetworkUpload", "upload start! filename %s, url %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
        AppMethodBeat.o(319141);
      }
      
      public final void k(int paramAnonymousInt, long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(319132);
        parama.k(paramAnonymousInt, paramAnonymousLong1, paramAnonymousLong2);
        AppMethodBeat.o(319132);
      }
    });
    paramString1.toZ = ((Map)localObject);
    paramString1.ppb = paramMap;
    paramString1.timeout = paramInt;
    paramString1.Uz = true;
    paramString1.tnQ = paramArrayList;
    paramString1.tnm = this.tnm;
    paramString1.ppa = paramString3;
    paramString1.tnV = paramString4;
    synchronized (this.tog)
    {
      this.tog.add(paramString1);
      h.ahAA.g(paramString1, "appbrand_upload_thread");
      AppMethodBeat.o(144348);
      return;
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.t.b.a parama)
  {
    AppMethodBeat.i(319210);
    if (parama == null)
    {
      AppMethodBeat.o(319210);
      return;
    }
    this.tnn.add(parama.ppa);
    Em(parama.ppa);
    parama.cCx();
    AppMethodBeat.o(319210);
  }
  
  public final boolean adU(String paramString)
  {
    AppMethodBeat.i(144352);
    boolean bool = this.tnn.contains(paramString);
    AppMethodBeat.o(144352);
    return bool;
  }
  
  public final com.tencent.mm.plugin.appbrand.t.b.a aeb(String paramString)
  {
    AppMethodBeat.i(319201);
    if (paramString == null)
    {
      AppMethodBeat.o(319201);
      return null;
    }
    synchronized (this.tog)
    {
      Iterator localIterator = this.tog.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.t.b.a locala = (com.tencent.mm.plugin.appbrand.t.b.a)localIterator.next();
        if (paramString.equals(locala.ppa))
        {
          AppMethodBeat.o(319201);
          return locala;
        }
      }
      AppMethodBeat.o(319201);
      return null;
    }
  }
  
  public static abstract interface a
  {
    public abstract void X(JSONObject paramJSONObject);
    
    public abstract void abi(String paramString);
    
    public abstract void cH(String paramString, int paramInt);
    
    public abstract void k(int paramInt, long paramLong1, long paramLong2);
  }
  
  public static abstract interface b
  {
    public abstract boolean cdJ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.g
 * JD-Core Version:    0.7.0.1
 */