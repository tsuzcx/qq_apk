package com.tencent.mm.plugin.appbrand.h.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.b.c;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class h
{
  private static final String TAG;
  private boolean enabled;
  private rx.f.b jJO;
  private ReentrantReadWriteLock jJP;
  private Lock jJQ;
  private e jJR;
  private Pattern jJS;
  private Set<String> jJT;
  private int port;
  
  static
  {
    AppMethodBeat.i(159009);
    TAG = h.class.getSimpleName();
    AppMethodBeat.o(159009);
  }
  
  private h()
  {
    AppMethodBeat.i(158998);
    this.jJO = new rx.f.b();
    this.jJP = new ReentrantReadWriteLock(true);
    this.jJQ = this.jJP.writeLock();
    this.enabled = false;
    this.port = -1;
    this.jJT = new HashSet();
    this.jJS = Pattern.compile("uuid:([a-fA-F\\d]{8}(-[a-fA-F\\d]{4}){3}-[a-fA-F\\d]{12})");
    AppMethodBeat.o(158998);
  }
  
  private static void a(Lock paramLock)
  {
    AppMethodBeat.i(159007);
    try
    {
      if (!paramLock.tryLock(6000L, TimeUnit.MILLISECONDS))
      {
        com.tencent.mm.plugin.appbrand.h.c.c.a locala = new com.tencent.mm.plugin.appbrand.h.c.c.a("Router wasn't available exclusively after waiting 6000ms, lock failed: " + paramLock.getClass().getSimpleName());
        AppMethodBeat.o(159007);
        throw locala;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      paramLock = new com.tencent.mm.plugin.appbrand.h.c.c.a("Interruption while waiting for exclusive access: " + paramLock.getClass().getSimpleName(), localInterruptedException);
      AppMethodBeat.o(159007);
      throw paramLock;
    }
    AppMethodBeat.o(159007);
  }
  
  private boolean b(com.tencent.mm.plugin.appbrand.h.c.b.b paramb)
  {
    AppMethodBeat.i(159005);
    String str1 = paramb.get("NT");
    Object localObject2 = paramb.get("ST");
    Object localObject1 = paramb.get("NTS");
    String str2 = paramb.get("USN");
    paramb = paramb.get("LOCATION");
    if ((!"upnp:rootdevice".equals(str1)) && (!"upnp:rootdevice".equals(localObject2)))
    {
      AppMethodBeat.o(159005);
      return false;
    }
    if ((this.jJT.size() > 0) && (this.jJT.contains(paramb)))
    {
      AppMethodBeat.o(159005);
      return false;
    }
    str1 = yu(str2);
    if (TextUtils.isEmpty(str1))
    {
      AppMethodBeat.o(159005);
      return false;
    }
    localObject2 = com.tencent.mm.plugin.appbrand.h.b.a.bbG();
    if ("ssdp:alive".equals(localObject1))
    {
      localObject1 = ((com.tencent.mm.plugin.appbrand.h.b.a)localObject2).KP(str1);
      if (localObject1 != null)
      {
        if (!((c)localObject1).bbJ().jIC.equals(paramb))
        {
          ((com.tencent.mm.plugin.appbrand.h.b.a)localObject2).remove(str1);
          this.jJT.add(paramb);
          AppMethodBeat.o(159005);
          return true;
        }
        AppMethodBeat.o(159005);
        return false;
      }
      if (!TextUtils.isEmpty(paramb))
      {
        this.jJT.add(paramb);
        AppMethodBeat.o(159005);
        return true;
      }
      AppMethodBeat.o(159005);
      return false;
    }
    if ("ssdp:byebye".equals(localObject1))
    {
      if (((com.tencent.mm.plugin.appbrand.h.b.a)localObject2).contains(str1)) {
        ((com.tencent.mm.plugin.appbrand.h.b.a)localObject2).remove(str1);
      }
      AppMethodBeat.o(159005);
      return false;
    }
    if (TextUtils.isEmpty(paramb))
    {
      com.tencent.mm.plugin.appbrand.h.a.e(TAG, "mDevice location is empty");
      AppMethodBeat.o(159005);
      return false;
    }
    if (!((com.tencent.mm.plugin.appbrand.h.b.a)localObject2).contains(str1))
    {
      AppMethodBeat.o(159005);
      return true;
    }
    AppMethodBeat.o(159005);
    return false;
  }
  
  public static h bbW()
  {
    AppMethodBeat.i(158999);
    h localh = a.bbX();
    AppMethodBeat.o(158999);
    return localh;
  }
  
  private String yu(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(159006);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(159006);
      return null;
    }
    Matcher localMatcher = this.jJS.matcher(paramString);
    paramString = localObject;
    if (localMatcher.find()) {
      paramString = localMatcher.group(1);
    }
    AppMethodBeat.o(159006);
    return paramString;
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.h.a.e parame, final com.tencent.mm.plugin.appbrand.h.c.a.a parama)
  {
    AppMethodBeat.i(159003);
    if (!this.enabled)
    {
      com.tencent.mm.plugin.appbrand.h.a.e(TAG, "DLNA Router is not enable");
      AppMethodBeat.o(159003);
      return;
    }
    this.jJO.b(new b.b(parame).bbQ().a(new rx.b.b()new rx.b.b {}, new rx.b.b() {}));
    AppMethodBeat.o(159003);
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.h.c.b.b paramb)
  {
    AppMethodBeat.i(159004);
    try
    {
      a(this.jJQ);
      boolean bool = this.enabled;
      if (!bool) {
        return;
      }
      if (b(paramb)) {
        this.jJO.b(new b.a(paramb).bbQ().a(new rx.b.b()new rx.b.b {}, new rx.b.b() {}));
      }
      return;
    }
    catch (Exception paramb)
    {
      com.tencent.mm.plugin.appbrand.h.a.b(TAG, paramb, "");
      return;
    }
    finally
    {
      this.jJQ.unlock();
      AppMethodBeat.o(159004);
    }
  }
  
  public final boolean disable()
  {
    AppMethodBeat.i(159001);
    com.tencent.mm.plugin.appbrand.h.a.i(TAG, "mRouter is shutting down...");
    if (this.enabled)
    {
      this.jJT.clear();
      this.jJR.close();
      this.jJO.clear();
      this.enabled = false;
      AppMethodBeat.o(159001);
      return true;
    }
    AppMethodBeat.o(159001);
    return false;
  }
  
  public final boolean enable()
  {
    AppMethodBeat.i(159000);
    com.tencent.mm.plugin.appbrand.h.a.i(TAG, "mRouter is starting ...");
    this.port = i.bbY().port;
    try
    {
      if (!this.enabled)
      {
        List localList = g.bbU();
        this.jJR = new e(new f("239.255.255.250"), localList, this, this.port);
        this.jJR.start();
        this.enabled = true;
        AppMethodBeat.o(159000);
        return true;
      }
      AppMethodBeat.o(159000);
      return false;
    }
    catch (Exception localException)
    {
      com.tencent.mm.plugin.appbrand.h.a.b(TAG, localException, "");
      AppMethodBeat.o(159000);
    }
    return false;
  }
  
  public final void fY(boolean paramBoolean)
  {
    AppMethodBeat.i(200800);
    Object localObject = new com.tencent.mm.plugin.appbrand.h.a.h(paramBoolean);
    if (!this.enabled)
    {
      com.tencent.mm.plugin.appbrand.h.a.e(TAG, "DLNA Router is not enable");
      AppMethodBeat.o(200800);
      return;
    }
    rx.f.b localb = this.jJO;
    localObject = new b.c((com.tencent.mm.plugin.appbrand.h.a.d)localObject);
    localb.b(rx.d.a(new a.2(((b.c)localObject).jJp, ((b.c)localObject).jJo)).a(((com.tencent.mm.plugin.appbrand.h.d.b)localObject).jKi).a(new rx.b.b()new rx.b.b {}, new rx.b.b() {}));
    AppMethodBeat.o(200800);
  }
  
  static final class a
  {
    private static h jJV;
    
    static
    {
      AppMethodBeat.i(158997);
      jJV = new h((byte)0);
      AppMethodBeat.o(158997);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.h.c.h
 * JD-Core Version:    0.7.0.1
 */