package com.tencent.mm.plugin.appbrand.m;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.SSLContext;
import org.json.JSONObject;

public final class g
{
  c hrA;
  final String igf;
  protected final ArrayList<String> isA;
  SSLContext isz;
  private int ita;
  public final ArrayList<h> itb;
  
  public g(c paramc)
  {
    AppMethodBeat.i(108170);
    this.itb = new ArrayList();
    this.isA = new ArrayList();
    this.hrA = paramc;
    paramc = (a)paramc.U(a.class);
    this.ita = paramc.bDr;
    this.igf = paramc.isv;
    this.isz = j.a(paramc);
    AppMethodBeat.o(108170);
  }
  
  private void a(String paramString, HttpURLConnection paramHttpURLConnection)
  {
    AppMethodBeat.i(108176);
    lI(paramString);
    if (paramHttpURLConnection != null) {
      try
      {
        paramHttpURLConnection.getInputStream().close();
        paramHttpURLConnection.disconnect();
        AppMethodBeat.o(108176);
        return;
      }
      catch (Exception paramHttpURLConnection)
      {
        ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", paramHttpURLConnection, "removeTask Exception: id %s", new Object[] { paramString });
      }
    }
    AppMethodBeat.o(108176);
  }
  
  private void lI(String paramString)
  {
    AppMethodBeat.i(108172);
    if (paramString == null)
    {
      AppMethodBeat.o(108172);
      return;
    }
    synchronized (this.itb)
    {
      Iterator localIterator = this.itb.iterator();
      while (localIterator.hasNext())
      {
        h localh = (h)localIterator.next();
        if (paramString.equals(localh.hwp)) {
          this.itb.remove(localh);
        }
      }
      AppMethodBeat.o(108172);
      return;
    }
  }
  
  public final boolean DN(String paramString)
  {
    AppMethodBeat.i(108175);
    boolean bool = this.isA.contains(paramString);
    AppMethodBeat.o(108175);
    return bool;
  }
  
  public final h DT(String paramString)
  {
    AppMethodBeat.i(108173);
    if (paramString == null)
    {
      AppMethodBeat.o(108173);
      return null;
    }
    synchronized (this.itb)
    {
      Iterator localIterator = this.itb.iterator();
      while (localIterator.hasNext())
      {
        h localh = (h)localIterator.next();
        if (paramString.equals(localh.hwp))
        {
          AppMethodBeat.o(108173);
          return localh;
        }
      }
      AppMethodBeat.o(108173);
      return null;
    }
  }
  
  public final void a(int paramInt, String paramString1, String arg3, JSONObject paramJSONObject, Map<String, String> paramMap, ArrayList<String> paramArrayList, g.a parama, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(108171);
    String str1 = j.DY(paramJSONObject.optString("url"));
    String str2 = paramJSONObject.optString("name");
    paramJSONObject = j.K(paramJSONObject);
    synchronized (this.itb)
    {
      if (this.itb.size() >= this.ita)
      {
        parama.CE("tasked refused max connected");
        ab.i("MicroMsg.AppBrandNetworkUpload", "max connected mUploadTaskList.size():%d,mMaxUploadConcurrent:%d", new Object[] { Integer.valueOf(this.itb.size()), Integer.valueOf(this.ita) });
        AppMethodBeat.o(108171);
        return;
      }
      if (TextUtils.isEmpty(str2))
      {
        parama.CE("fileName error");
        ab.i("MicroMsg.AppBrandNetworkUpload", "fileName error");
        AppMethodBeat.o(108171);
        return;
      }
    }
    paramString1 = new h(???, str1, str2, paramString5, paramInt, paramString1, parama);
    paramString1.ite = paramJSONObject;
    paramString1.isT = paramMap;
    paramString1.isU = paramArrayList;
    paramString1.isRunning = true;
    paramString1.hwp = paramString3;
    paramString1.isY = paramString4;
    synchronized (this.itb)
    {
      this.itb.add(paramString1);
      d.post(new g.b(this, paramString1), "appbrand_upload_thread");
      AppMethodBeat.o(108171);
      return;
    }
  }
  
  public final void a(h paramh)
  {
    AppMethodBeat.i(108174);
    if (paramh == null)
    {
      AppMethodBeat.o(108174);
      return;
    }
    this.isA.add(paramh.hwp);
    paramh.isRunning = false;
    a(paramh.hwp, paramh.isX);
    AppMethodBeat.o(108174);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m.g
 * JD-Core Version:    0.7.0.1
 */