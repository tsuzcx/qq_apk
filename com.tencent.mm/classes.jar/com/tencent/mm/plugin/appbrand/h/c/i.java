package com.tencent.mm.plugin.appbrand.h.c;

import android.net.http.AndroidHttpClient;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.a;
import com.tencent.mm.plugin.appbrand.h.c.b.b;
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
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

public final class i
{
  static i jjJ;
  MulticastSocket jjK;
  InetAddress jjL;
  int port;
  
  i(boolean paramBoolean)
  {
    AppMethodBeat.i(159011);
    this.port = -1;
    try
    {
      this.jjL = InetAddress.getByName("239.255.255.250");
      if (paramBoolean)
      {
        this.jjK = new MulticastSocket();
        this.jjK.setBroadcast(true);
        this.port = this.jjK.getLocalPort();
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
  
  public static com.tencent.mm.plugin.appbrand.h.c.b.e a(com.tencent.mm.plugin.appbrand.h.a.e parame)
  {
    AppMethodBeat.i(159013);
    localObject2 = null;
    try
    {
      localObject1 = AndroidHttpClient.newInstance("");
      try
      {
        localObject2 = new i.a(parame.getUrl(), parame.aUG());
        localObject3 = parame.aUH();
        if ((localObject3 == null) || (((Map)localObject3).isEmpty())) {
          break label141;
        }
        localObject3 = ((Map)localObject3).entrySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localEntry = (Map.Entry)((Iterator)localObject3).next();
          ((i.a)localObject2).addHeader((String)localEntry.getKey(), (String)localEntry.getValue());
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
    parame = parame.aUE();
    if (!TextUtils.isEmpty(parame))
    {
      parame = new StringEntity(parame, "utf-8");
      parame.setContentType("text/xml; charset=\"utf-8\"");
      ((i.a)localObject2).setEntity(parame);
    }
    parame = ((AndroidHttpClient)localObject1).execute((HttpUriRequest)localObject2);
    ((AndroidHttpClient)localObject1).close();
    localObject2 = new com.tencent.mm.plugin.appbrand.h.c.b.e();
    ((com.tencent.mm.plugin.appbrand.h.c.b.e)localObject2).jjR = new b();
    localObject3 = parame.getAllHeaders();
    j = localObject3.length;
    i = 0;
    while (i < j)
    {
      localEntry = localObject3[i];
      ((com.tencent.mm.plugin.appbrand.h.c.b.e)localObject2).jjR.put(localEntry.getName(), localEntry.getValue());
      i += 1;
    }
    localObject3 = EntityUtils.toString(parame.getEntity(), "utf-8").replaceAll("&(?!amp;)", "&amp;");
    ((com.tencent.mm.plugin.appbrand.h.c.b.e)localObject2).jjS = j.aVb().GO((String)localObject3);
    ((com.tencent.mm.plugin.appbrand.h.c.b.e)localObject2).responseCode = parame.getStatusLine().getStatusCode();
    AppMethodBeat.o(159013);
    return localObject2;
  }
  
  public static i aVa()
  {
    AppMethodBeat.i(159012);
    if (jjJ == null) {}
    try
    {
      if (jjJ == null) {
        jjJ = new i(true);
      }
      i locali = jjJ;
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
    if (this == jjJ) {
      this.jjK.close();
    }
    super.finalize();
    AppMethodBeat.o(159014);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.h.c.i
 * JD-Core Version:    0.7.0.1
 */