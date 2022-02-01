package c.t.m.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.location.LocationManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Pair;
import com.tencent.map.geolocation.internal.TencentHttpClient;
import com.tencent.map.geolocation.internal.TencentHttpClientFactory;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public class bf
{
  private static volatile bf e;
  public final Context a;
  private final bg b;
  private final ExecutorService c;
  private final HashMap<String, bi> d;
  private TencentHttpClient f;
  
  @SuppressLint({"NewApi"})
  private bf(Context paramContext)
  {
    this.a = paramContext;
    ThreadPoolExecutor localThreadPoolExecutor = new ThreadPoolExecutor(1, 5, 60000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory()
    {
      private final AtomicInteger a = new AtomicInteger(1);
      
      public final Thread newThread(Runnable paramAnonymousRunnable)
      {
        return new Thread(paramAnonymousRunnable, "sdk-" + this.a.getAndIncrement());
      }
    });
    if (Build.VERSION.SDK_INT >= 9) {
      localThreadPoolExecutor.allowCoreThreadTimeOut(true);
    }
    this.c = localThreadPoolExecutor;
    this.d = new HashMap();
    this.d.put("cell", new bj("cell"));
    this.d.put("so", new bk(paramContext, "so"));
    this.b = new bg(this);
    new Thread(new Runnable()
    {
      public final void run()
      {
        bf.this.g();
      }
    }).start();
  }
  
  public static bf a(Context paramContext)
  {
    if (e == null) {}
    try
    {
      if (e == null) {
        e = new bf(paramContext);
      }
      return e;
    }
    finally {}
  }
  
  private PackageInfo i()
  {
    Object localObject = this.a;
    try
    {
      localObject = ((Context)localObject).getPackageManager().getPackageInfo(((Context)localObject).getPackageName(), 0);
      return localObject;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    return new PackageInfo();
  }
  
  public final TelephonyManager a()
  {
    return (TelephonyManager)this.a.getSystemService("phone");
  }
  
  @NonNull
  public final bi a(String paramString)
  {
    paramString = (bi)this.d.get(paramString);
    if (paramString != null) {
      return paramString;
    }
    return bh.c;
  }
  
  public final String a(String paramString, byte[] paramArrayOfByte)
    throws IOException
  {
    if (this.f == null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("channelId", b.a.d(this.b.c()));
      this.f = TencentHttpClientFactory.getInstance().getTencentHttpClient(this.a, localBundle);
    }
    paramString = this.f.postSync(paramString, paramArrayOfByte);
    paramArrayOfByte = b.a.c((byte[])paramString.first);
    if (paramArrayOfByte != null) {
      return new String(paramArrayOfByte, (String)paramString.second);
    }
    return "{}";
  }
  
  public final WifiManager b()
  {
    return (WifiManager)this.a.getSystemService("wifi");
  }
  
  public final LocationManager c()
  {
    return (LocationManager)this.a.getSystemService("location");
  }
  
  @NonNull
  public final bg d()
  {
    return this.b;
  }
  
  public final ExecutorService e()
  {
    return this.c;
  }
  
  public final boolean f()
  {
    WifiManager localWifiManager = b();
    return (b.a.b(localWifiManager)) && (localWifiManager.isWifiEnabled());
  }
  
  final void g()
  {
    for (;;)
    {
      try
      {
        cj.a("AppContext", "doInBg: app status init start");
        bg localbg = this.b;
        localbg.a(h());
        Object localObject1 = i();
        int i = ((PackageInfo)localObject1).versionCode;
        localObject1 = ((PackageInfo)localObject1).versionName;
        localObject1 = a();
        if (localObject1 != null)
        {
          Object localObject2 = new int[2];
          b.a.a((TelephonyManager)localObject1, (int[])localObject2);
          localbg.h = localObject2[0];
          localbg.i = localObject2[1];
          localbg.b = ((TelephonyManager)localObject1).getPhoneType();
          localObject2 = ck.a(((TelephonyManager)localObject1).getDeviceId(), ck.a);
          String str2 = ck.a(((TelephonyManager)localObject1).getSubscriberId(), ck.b);
          localObject1 = ck.a(((TelephonyManager)localObject1).getLine1Number(), ck.c);
          localbg.c = ((String)localObject2);
          localbg.d = str2;
          localbg.e = ((String)localObject1);
        }
        localObject1 = b();
        if (localObject1 != null)
        {
          localObject1 = ((WifiManager)localObject1).getConnectionInfo();
          if (localObject1 != null)
          {
            localObject1 = ((WifiInfo)localObject1).getMacAddress();
            localObject1 = ck.a(((String)localObject1).replaceAll(":", "").toUpperCase(Locale.ENGLISH), ck.d);
            localbg.f = ((String)localObject1);
            cj.a("AppContext", "doInBg: app status init done");
          }
        }
        else
        {
          localObject1 = "";
          continue;
        }
        String str1 = "";
      }
      catch (Throwable localThrowable)
      {
        cj.a("AppContext", "doInBg: app status init error", localThrowable);
        return;
      }
    }
  }
  
  @Nullable
  public final String h()
  {
    Context localContext = this.a;
    try
    {
      Object localObject = localContext.getPackageManager().getApplicationInfo(localContext.getPackageName(), 128).metaData;
      if (localObject != null)
      {
        if (((Bundle)localObject).containsKey("TencentGeoLocationSDK")) {
          return ((Bundle)localObject).getString("TencentGeoLocationSDK");
        }
        if (((Bundle)localObject).containsKey("TencentMapSDK"))
        {
          localObject = ((Bundle)localObject).getString("TencentMapSDK");
          return localObject;
        }
        return "";
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      cj.b("AppContext", "doInBg: " + localContext.getPackageName() + " not found");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     c.t.m.g.bf
 * JD-Core Version:    0.7.0.1
 */