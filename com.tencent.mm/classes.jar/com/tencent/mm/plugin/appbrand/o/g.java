package com.tencent.mm.plugin.appbrand.o;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.y;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.SSLContext;
import org.json.JSONObject;

public final class g
{
  SSLContext gQJ;
  final String gQK;
  protected final ArrayList<String> gQL = new ArrayList();
  private int gRl;
  public final ArrayList<h> gRm = new ArrayList();
  c geu;
  
  public g(c paramc)
  {
    this.geu = paramc;
    paramc = (a)paramc.D(a.class);
    this.gRl = paramc.fQa;
    this.gQK = paramc.gQG;
    this.gQJ = j.a(paramc);
  }
  
  private void a(String paramString, HttpURLConnection paramHttpURLConnection)
  {
    if (paramString != null) {}
    synchronized (this.gRm)
    {
      Iterator localIterator = this.gRm.iterator();
      while (localIterator.hasNext())
      {
        h localh = (h)localIterator.next();
        if (paramString.equals(localh.gep)) {
          this.gRm.remove(localh);
        }
      }
      if (paramHttpURLConnection == null) {}
    }
  }
  
  public final void a(int paramInt, String paramString1, String arg3, JSONObject paramJSONObject, Map<String, String> paramMap, ArrayList<String> paramArrayList, g.a parama, String paramString3, String paramString4, String paramString5)
  {
    String str1 = paramJSONObject.optString("url");
    String str2 = paramJSONObject.optString("name");
    paramJSONObject = j.D(paramJSONObject);
    synchronized (this.gRm)
    {
      if (this.gRm.size() >= this.gRl)
      {
        parama.uu("tasked refused max connected");
        y.i("MicroMsg.AppBrandNetworkUpload", "max connected");
        return;
      }
      if (TextUtils.isEmpty(str2))
      {
        parama.uu("fileName error");
        y.i("MicroMsg.AppBrandNetworkUpload", "fileName error");
        return;
      }
    }
    paramString1 = new h(???, str1, str2, paramString5, paramInt, paramString1, parama);
    paramString1.gRq = paramJSONObject;
    paramString1.gRe = paramMap;
    paramString1.gRf = paramArrayList;
    paramString1.isRunning = true;
    paramString1.gep = paramString3;
    paramString1.gRj = paramString4;
    synchronized (this.gRm)
    {
      this.gRm.add(paramString1);
      e.post(new g.b(this, paramString1), "appbrand_upload_thread");
      return;
    }
  }
  
  public final void a(h paramh)
  {
    if (paramh == null) {
      return;
    }
    this.gQL.add(paramh.gep);
    paramh.isRunning = false;
    a(paramh.gep, paramh.gRi);
  }
  
  public final boolean vq(String paramString)
  {
    return this.gQL.contains(paramString);
  }
  
  public final h vw(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    synchronized (this.gRm)
    {
      Iterator localIterator = this.gRm.iterator();
      while (localIterator.hasNext())
      {
        h localh = (h)localIterator.next();
        if (paramString.equals(localh.gep)) {
          return localh;
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.g
 * JD-Core Version:    0.7.0.1
 */