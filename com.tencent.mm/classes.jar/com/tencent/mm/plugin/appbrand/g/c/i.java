package com.tencent.mm.plugin.appbrand.g.c;

import android.net.http.AndroidHttpClient;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g.a;
import com.tencent.mm.plugin.appbrand.g.a.e.a;
import com.tencent.mm.plugin.appbrand.g.c.b.b;
import java.io.IOException;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

public final class i
{
  static i kei;
  MulticastSocket kej;
  InetAddress kek;
  int port;
  
  i(boolean paramBoolean)
  {
    AppMethodBeat.i(159011);
    this.port = -1;
    try
    {
      this.kek = InetAddress.getByName("239.255.255.250");
      if (paramBoolean)
      {
        this.kej = new MulticastSocket();
        this.kej.setBroadcast(true);
        this.port = this.kej.getLocalPort();
      }
      AppMethodBeat.o(159011);
      return;
    }
    catch (IOException localIOException)
    {
      a.b("TransporterImpl", localIOException, "");
      AppMethodBeat.o(159011);
    }
  }
  
  public static com.tencent.mm.plugin.appbrand.g.c.b.e a(com.tencent.mm.plugin.appbrand.g.a.e parame)
  {
    AppMethodBeat.i(159013);
    localObject2 = null;
    try
    {
      localObject1 = AndroidHttpClient.newInstance("");
      try
      {
        localObject2 = new a(parame.getUrl(), parame.bfi());
        localObject3 = parame.bfj();
        if ((localObject3 == null) || (((Map)localObject3).isEmpty())) {
          break label141;
        }
        localObject3 = ((Map)localObject3).entrySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localEntry = (Map.Entry)((Iterator)localObject3).next();
          ((a)localObject2).addHeader((String)localEntry.getKey(), (String)localEntry.getValue());
        }
        if (localObject1 == null) {
          break label125;
        }
      }
      catch (IOException parame) {}
    }
    catch (IOException parame)
    {
      for (;;)
      {
        Object localObject3;
        Map.Entry localEntry;
        int j;
        int i;
        Object localObject1 = localObject2;
      }
    }
    ((AndroidHttpClient)localObject1).close();
    label125:
    a.e("TransporterImpl", parame.toString());
    AppMethodBeat.o(159013);
    throw parame;
    label141:
    parame = parame.bfg();
    if (!TextUtils.isEmpty(parame))
    {
      parame = new StringEntity(parame, "utf-8");
      parame.setContentType("text/xml; charset=\"utf-8\"");
      ((a)localObject2).setEntity(parame);
    }
    parame = ((AndroidHttpClient)localObject1).execute((HttpUriRequest)localObject2);
    ((AndroidHttpClient)localObject1).close();
    localObject2 = new com.tencent.mm.plugin.appbrand.g.c.b.e();
    ((com.tencent.mm.plugin.appbrand.g.c.b.e)localObject2).kep = new b();
    localObject3 = parame.getAllHeaders();
    j = localObject3.length;
    i = 0;
    while (i < j)
    {
      localEntry = localObject3[i];
      ((com.tencent.mm.plugin.appbrand.g.c.b.e)localObject2).kep.put(localEntry.getName(), localEntry.getValue());
      i += 1;
    }
    localObject3 = EntityUtils.toString(parame.getEntity(), "utf-8").replaceAll("&(?!amp;)", "&amp;");
    ((com.tencent.mm.plugin.appbrand.g.c.b.e)localObject2).keq = j.bfD().Om((String)localObject3);
    ((com.tencent.mm.plugin.appbrand.g.c.b.e)localObject2).responseCode = parame.getStatusLine().getStatusCode();
    AppMethodBeat.o(159013);
    return localObject2;
  }
  
  public static i bfC()
  {
    AppMethodBeat.i(159012);
    if (kei == null) {}
    try
    {
      if (kei == null) {
        kei = new i(true);
      }
      i locali = kei;
      AppMethodBeat.o(159012);
      return locali;
    }
    finally
    {
      AppMethodBeat.o(159012);
    }
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(159014);
    if (this == kei) {
      this.kej.close();
    }
    super.finalize();
    AppMethodBeat.o(159014);
  }
  
  public static final class a
    extends HttpPost
  {
    private e.a kcv;
    
    public a(String paramString, e.a parama)
    {
      super();
      this.kcv = parama;
    }
    
    public final String getMethod()
    {
      AppMethodBeat.i(159010);
      String str = this.kcv.name();
      AppMethodBeat.o(159010);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.c.i
 * JD-Core Version:    0.7.0.1
 */