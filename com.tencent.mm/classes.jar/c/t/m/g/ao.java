package c.t.m.g;

import android.os.SystemClock;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;

public final class ao
  extends ai
{
  private HttpURLConnection A;
  private DataOutputStream B;
  private DataInputStream C;
  private String D;
  private am E;
  an o;
  boolean p;
  boolean q;
  String r = "";
  int s;
  long t = 0L;
  String u;
  ao.a v = new ao.a((byte)0);
  long w;
  boolean x = false;
  int y = 0;
  boolean z = false;
  
  public ao(String paramString1, String paramString2, boolean paramBoolean, Map<String, String> paramMap, byte[] paramArrayOfByte, int paramInt, String paramString3)
  {
    this.D = paramString1;
    this.b = paramString2;
    this.c = paramBoolean;
    this.d = paramMap;
    this.e = paramArrayOfByte;
    int i;
    if (x.g() == 2)
    {
      i = x.a.a("direct_access_time_out", 1000, 60000, 15000);
      if (paramInt >= i) {
        break label140;
      }
    }
    for (;;)
    {
      this.f = cm.a(paramInt, 200, 60000, 10000);
      this.g = paramString3;
      return;
      i = x.a.a("direct_access_time_out", 1000, 60000, 10000);
      break;
      label140:
      paramInt = i;
    }
  }
  
  private void a(int paramInt)
  {
    int m = 0;
    for (;;)
    {
      try
      {
        localBufferedInputStream = new BufferedInputStream(this.A.getInputStream());
        localByteArrayOutputStream = new ByteArrayOutputStream();
        arrayOfByte = new byte[4096];
        i = 0;
        j = i;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        try
        {
          BufferedInputStream localBufferedInputStream;
          ByteArrayOutputStream localByteArrayOutputStream;
          byte[] arrayOfByte;
          int i;
          int k;
          localByteArrayOutputStream.close();
          return;
        }
        catch (Exception localException2)
        {
          int j;
          return;
        }
        localOutOfMemoryError1 = localOutOfMemoryError1;
        j = 0;
        this.o.a = -306;
        this.o.b = ("no-content-length:" + j);
        return;
      }
      catch (Exception localException1)
      {
        this.o.a = -287;
        this.o.b = "read without content-length error";
        return;
      }
      try
      {
        k = localBufferedInputStream.read(arrayOfByte);
        if (k == -1) {
          break label218;
        }
        j = i;
        localByteArrayOutputStream.write(arrayOfByte, 0, k);
        k = i + k;
        i = k;
        if (k > paramInt)
        {
          j = k;
          this.o.a = -303;
          j = k;
          this.o.b = "no-content-length";
          paramInt = m;
          i = k;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        continue;
        paramInt = 1;
      }
    }
    if (paramInt != 0)
    {
      j = i;
      this.o.d = localByteArrayOutputStream.toByteArray();
      j = i;
      this.v.f = SystemClock.elapsedRealtime();
    }
    j = i;
  }
  
  private void b()
  {
    int j = 0;
    int i = j;
    if (this.d != null)
    {
      i = j;
      if (this.d.size() > 0)
      {
        Iterator localIterator = this.d.keySet().iterator();
        i = 0;
        if (localIterator.hasNext())
        {
          String str1 = (String)localIterator.next();
          String str2 = (String)this.d.get(str1);
          this.A.addRequestProperty(str1, str2);
          if (!str1.toLowerCase().contains("host")) {
            break label207;
          }
          i = 1;
        }
      }
    }
    label207:
    for (;;)
    {
      break;
      if (i == 0) {
        this.A.setRequestProperty("Host", this.D);
      }
      this.A.setRequestProperty("Halley", this.g + "-" + this.y + "-" + System.currentTimeMillis());
      if (this.x)
      {
        this.A.setRequestProperty("X-Online-Host", this.D);
        this.A.setRequestProperty("x-tx-host", this.D);
      }
      return;
    }
  }
  
  private void c()
  {
    try
    {
      if (this.A != null) {
        this.A.disconnect();
      }
      if (this.B != null) {
        this.B.close();
      }
      if (this.C != null) {
        this.C.close();
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public final an a()
  {
    int m = 1;
    int j = 1;
    int k = 1;
    int i = 1;
    this.m = System.currentTimeMillis();
    this.w = SystemClock.elapsedRealtime();
    this.v.a = this.w;
    this.o = new an(0, "");
    label1319:
    label1601:
    label1606:
    label1611:
    for (;;)
    {
      try
      {
        Object localObject1 = new URL(this.b);
        this.p = ((URL)localObject1).getProtocol().toLowerCase().startsWith("https");
        this.q = cm.d(((URL)localObject1).getHost());
        if (this.p) {
          if ((this.x) && (x.k() != null))
          {
            localObject1 = (HttpsURLConnection)((URL)localObject1).openConnection(x.k());
            localObject3 = localObject1;
            if (this.q)
            {
              this.E = new am(this.D);
              ((HttpsURLConnection)localObject1).setSSLSocketFactory(this.E);
              ((HttpsURLConnection)localObject1).setHostnameVerifier(new al(this.D));
              localObject3 = localObject1;
            }
            this.A = ((HttpURLConnection)localObject3);
            localObject3 = this.A;
            if (!this.c) {
              break label1611;
            }
            localObject1 = "GET";
            ((HttpURLConnection)localObject3).setRequestMethod((String)localObject1);
            this.A.setConnectTimeout(this.f);
            this.A.setReadTimeout(this.f);
            this.A.setUseCaches(false);
            this.A.setDoInput(true);
            this.A.setInstanceFollowRedirects(false);
            b();
            if ((!this.c) && (!cm.a(this.e)))
            {
              this.A.setDoOutput(true);
              this.t = this.e.length;
            }
            this.v.b = SystemClock.elapsedRealtime();
            this.A.connect();
            this.v.c = SystemClock.elapsedRealtime();
            if ((!this.c) && (!cm.a(this.e)))
            {
              this.B = new DataOutputStream(this.A.getOutputStream());
              this.B.write(this.e);
              this.B.flush();
            }
            this.v.d = SystemClock.elapsedRealtime();
            n = this.A.getResponseCode();
            this.v.e = SystemClock.elapsedRealtime();
            this.o.c = n;
            this.r = this.A.getContentType();
            localObject1 = new HashMap();
            localObject3 = this.A.getHeaderFields().entrySet().iterator();
            if (!((Iterator)localObject3).hasNext()) {
              continue;
            }
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
            if (localEntry.getKey() == null) {
              continue;
            }
            ((Map)localObject1).put(localEntry.getKey(), ((List)localEntry.getValue()).get(0));
            continue;
          }
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        this.o.a = -300;
        c();
        this.w = (SystemClock.elapsedRealtime() - this.w);
        this.v.a();
        if ((this.o.a != 0) && (x.h()) && (this.o.a != -20))
        {
          if (x.a.a("direct_fail_to_report_dns_ip", 0, 1, 0) != 1) {
            break label1367;
          }
          if (i != 0) {
            this.u = cm.c(this.D);
          }
        }
        return this.o;
        HttpsURLConnection localHttpsURLConnection = (HttpsURLConnection)localMalformedURLException.openConnection();
        continue;
        if ((this.x) && (x.k() != null))
        {
          localObject3 = (HttpURLConnection)localHttpsURLConnection.openConnection(x.k());
          continue;
        }
        Object localObject3 = (HttpURLConnection)localHttpsURLConnection.openConnection();
        continue;
        this.o.a(localHttpsURLConnection);
        if ((this.o.c < 200) || (this.o.c >= 300)) {
          break label1319;
        }
        this.s = this.A.getContentLength();
        n = x.a.a("app_receive_pack_size", 524288, 10485760, 2097152);
        if (this.s < 0)
        {
          a(n);
          c();
          this.w = (SystemClock.elapsedRealtime() - this.w);
          this.v.a();
          if ((this.o.a == 0) || (!x.h()) || (this.o.a == -20)) {
            continue;
          }
          if (x.a.a("direct_fail_to_report_dns_ip", 0, 1, 0) != 1) {
            break label1362;
          }
          i = m;
          if (i == 0) {
            continue;
          }
          this.u = cm.c(this.D);
          continue;
        }
        if (this.s == 0)
        {
          this.o.d = new byte[0];
          this.v.f = SystemClock.elapsedRealtime();
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        int n;
        this.o.a = -287;
        this.o.b = (localThrowable.getClass().getSimpleName() + "(" + localThrowable.getLocalizedMessage() + ")");
        if (((this.E != null) && (this.E.a)) || ((this.p) && (this.o.b.toLowerCase().contains("cannot verify hostname")))) {
          break label1619;
        }
        if ((!this.p) || (!this.o.b.toLowerCase().contains("not verified"))) {
          break label1372;
        }
        break label1619;
        if (x.h()) {
          break label1377;
        }
        this.o.a = -4;
        c();
        this.w = (SystemClock.elapsedRealtime() - this.w);
        this.v.a();
        if ((this.o.a == 0) || (!x.h()) || (this.o.a == -20)) {
          continue;
        }
        if (x.a.a("direct_fail_to_report_dns_ip", 0, 1, 0) != 1) {
          break label1601;
        }
        i = j;
        if (i == 0) {
          continue;
        }
        this.u = cm.c(this.D);
        continue;
        if (this.s > n)
        {
          this.o.a = -303;
          this.o.b = this.s;
          continue;
        }
      }
      finally
      {
        c();
        this.w = (SystemClock.elapsedRealtime() - this.w);
        this.v.a();
        if ((this.o.a != 0) && (x.h()) && (this.o.a != -20))
        {
          if (x.a.a("direct_fail_to_report_dns_ip", 0, 1, 0) != 1) {
            break label1606;
          }
          i = k;
          if (i != 0) {
            this.u = cm.c(this.D);
          }
        }
      }
      try
      {
        byte[] arrayOfByte = new byte[this.s];
        this.C = new DataInputStream(this.A.getInputStream());
        this.C.readFully(arrayOfByte);
        this.o.d = arrayOfByte;
        this.v.f = SystemClock.elapsedRealtime();
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        this.o.a = -306;
        this.o.b = this.s;
      }
      continue;
      label1362:
      label1619:
      if ((this.o.c >= 300) && (this.o.c < 400))
      {
        this.h = this.o.a("location");
        continue;
        i = 0;
        continue;
        label1367:
        i = 0;
        continue;
        label1372:
        i = 0;
        continue;
        label1377:
        if (i != 0)
        {
          this.o.a = -289;
        }
        else
        {
          this.i = true;
          if ((localOutOfMemoryError.getMessage() != null) && (localOutOfMemoryError.getMessage().toLowerCase().contains("permission")))
          {
            this.o.a = -281;
            this.o.b = "no permission";
          }
          else if ((localOutOfMemoryError instanceof UnknownHostException))
          {
            this.o.a = -284;
          }
          else if ((localOutOfMemoryError instanceof ConnectException))
          {
            this.o.a = -42;
          }
          else
          {
            String str;
            if ((localOutOfMemoryError instanceof SocketTimeoutException))
            {
              str = localOutOfMemoryError.getLocalizedMessage();
              if ((str != null) && ((str.toLowerCase().contains("connect")) || (str.toLowerCase().contains("connection")))) {
                this.o.a = -10;
              } else {
                this.o.a = -13;
              }
            }
            else if ((str instanceof SocketException))
            {
              this.o.a = -41;
            }
            else if ((str instanceof IOException))
            {
              this.o.a = -286;
              continue;
              i = 0;
              continue;
              i = 0;
              continue;
              str = "POST";
              continue;
              i = 1;
            }
          }
        }
      }
    }
  }
  
  public final void a(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     c.t.m.g.ao
 * JD-Core Version:    0.7.0.1
 */