package com.tencent.mm.plugin.appbrand.g.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g.b.c;
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
  private rx.f.b lla;
  private ReentrantReadWriteLock llb;
  private Lock llc;
  private e lld;
  private Pattern lle;
  private Set<String> llf;
  private int port;
  
  static
  {
    AppMethodBeat.i(159009);
    if (!h.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      TAG = h.class.getSimpleName();
      AppMethodBeat.o(159009);
      return;
    }
  }
  
  private h()
  {
    AppMethodBeat.i(158998);
    this.lla = new rx.f.b();
    this.llb = new ReentrantReadWriteLock(true);
    this.llc = this.llb.writeLock();
    this.enabled = false;
    this.port = -1;
    this.llf = new HashSet();
    this.lle = Pattern.compile("uuid:([a-fA-F\\d]{8}(-[a-fA-F\\d]{4}){3}-[a-fA-F\\d]{12})");
    AppMethodBeat.o(158998);
  }
  
  private String KB(String paramString)
  {
    String str = null;
    AppMethodBeat.i(159006);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(159006);
      return null;
    }
    Object localObject = this.lle.matcher(paramString);
    if (((Matcher)localObject).find()) {
      str = ((Matcher)localObject).group(1);
    }
    localObject = str;
    if (str == null)
    {
      if ((!$assertionsDisabled) && (paramString == null))
      {
        paramString = new AssertionError();
        AppMethodBeat.o(159006);
        throw paramString;
      }
      localObject = Yd(paramString);
    }
    AppMethodBeat.o(159006);
    return localObject;
  }
  
  private static String Yd(String paramString)
  {
    AppMethodBeat.i(222906);
    com.tencent.mm.plugin.appbrand.g.a.e(TAG, "fallbackGetUuid: ".concat(String.valueOf(paramString)));
    if (paramString.startsWith("uuid:"))
    {
      paramString = paramString.substring(5);
      AppMethodBeat.o(222906);
      return paramString;
    }
    AppMethodBeat.o(222906);
    return paramString;
  }
  
  private static void a(Lock paramLock)
  {
    AppMethodBeat.i(159007);
    try
    {
      if (!paramLock.tryLock(6000L, TimeUnit.MILLISECONDS))
      {
        com.tencent.mm.plugin.appbrand.g.c.c.a locala = new com.tencent.mm.plugin.appbrand.g.c.c.a("Router wasn't available exclusively after waiting 6000ms, lock failed: " + paramLock.getClass().getSimpleName());
        AppMethodBeat.o(159007);
        throw locala;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      paramLock = new com.tencent.mm.plugin.appbrand.g.c.c.a("Interruption while waiting for exclusive access: " + paramLock.getClass().getSimpleName(), localInterruptedException);
      AppMethodBeat.o(159007);
      throw paramLock;
    }
    AppMethodBeat.o(159007);
  }
  
  private boolean b(com.tencent.mm.plugin.appbrand.g.c.b.b paramb)
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
    if ((this.llf.size() > 0) && (this.llf.contains(paramb)))
    {
      AppMethodBeat.o(159005);
      return false;
    }
    str1 = KB(str2);
    if (TextUtils.isEmpty(str1))
    {
      AppMethodBeat.o(159005);
      return false;
    }
    localObject2 = com.tencent.mm.plugin.appbrand.g.b.a.bBl();
    if ("ssdp:alive".equals(localObject1))
    {
      localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.a)localObject2).Yb(str1);
      if (localObject1 != null)
      {
        if (!((c)localObject1).bBo().ljO.equals(paramb))
        {
          ((com.tencent.mm.plugin.appbrand.g.b.a)localObject2).remove(str1);
          this.llf.add(paramb);
          AppMethodBeat.o(159005);
          return true;
        }
        AppMethodBeat.o(159005);
        return false;
      }
      if (!TextUtils.isEmpty(paramb))
      {
        this.llf.add(paramb);
        AppMethodBeat.o(159005);
        return true;
      }
      AppMethodBeat.o(159005);
      return false;
    }
    if ("ssdp:byebye".equals(localObject1))
    {
      if (((com.tencent.mm.plugin.appbrand.g.b.a)localObject2).contains(str1)) {
        ((com.tencent.mm.plugin.appbrand.g.b.a)localObject2).remove(str1);
      }
      AppMethodBeat.o(159005);
      return false;
    }
    if (TextUtils.isEmpty(paramb))
    {
      com.tencent.mm.plugin.appbrand.g.a.e(TAG, "mDevice location is empty");
      AppMethodBeat.o(159005);
      return false;
    }
    if (!((com.tencent.mm.plugin.appbrand.g.b.a)localObject2).contains(str1))
    {
      AppMethodBeat.o(159005);
      return true;
    }
    AppMethodBeat.o(159005);
    return false;
  }
  
  public static h bBB()
  {
    AppMethodBeat.i(158999);
    h localh = a.bBC();
    AppMethodBeat.o(158999);
    return localh;
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.g.a.e parame, final com.tencent.mm.plugin.appbrand.g.c.a.a parama)
  {
    AppMethodBeat.i(159003);
    if (!this.enabled)
    {
      com.tencent.mm.plugin.appbrand.g.a.e(TAG, "DLNA Router is not enable");
      AppMethodBeat.o(159003);
      return;
    }
    this.lla.b(new b.b(parame).bBv().a(new rx.b.b()new rx.b.b {}, new rx.b.b() {}));
    AppMethodBeat.o(159003);
  }
  
  /* Error */
  public final void a(final com.tencent.mm.plugin.appbrand.g.c.b.b paramb)
  {
    // Byte code:
    //   0: ldc_w 319
    //   3: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 88	com/tencent/mm/plugin/appbrand/g/c/h:llc	Ljava/util/concurrent/locks/Lock;
    //   10: invokestatic 321	com/tencent/mm/plugin/appbrand/g/c/h:a	(Ljava/util/concurrent/locks/Lock;)V
    //   13: aload_0
    //   14: getfield 90	com/tencent/mm/plugin/appbrand/g/c/h:enabled	Z
    //   17: istore_2
    //   18: iload_2
    //   19: ifne +19 -> 38
    //   22: aload_0
    //   23: getfield 88	com/tencent/mm/plugin/appbrand/g/c/h:llc	Ljava/util/concurrent/locks/Lock;
    //   26: invokeinterface 324 1 0
    //   31: ldc_w 319
    //   34: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: return
    //   38: aload_0
    //   39: aload_1
    //   40: invokespecial 326	com/tencent/mm/plugin/appbrand/g/c/h:b	(Lcom/tencent/mm/plugin/appbrand/g/c/b/b;)Z
    //   43: ifeq +57 -> 100
    //   46: aload_0
    //   47: getfield 75	com/tencent/mm/plugin/appbrand/g/c/h:lla	Lrx/f/b;
    //   50: new 328	com/tencent/mm/plugin/appbrand/g/c/b$a
    //   53: dup
    //   54: aload_1
    //   55: invokespecial 330	com/tencent/mm/plugin/appbrand/g/c/b$a:<init>	(Lcom/tencent/mm/plugin/appbrand/g/c/b/b;)V
    //   58: invokevirtual 331	com/tencent/mm/plugin/appbrand/g/c/b$a:bBv	()Lrx/d;
    //   61: new 14	com/tencent/mm/plugin/appbrand/g/c/h$5
    //   64: dup
    //   65: aload_0
    //   66: aload_1
    //   67: invokespecial 334	com/tencent/mm/plugin/appbrand/g/c/h$5:<init>	(Lcom/tencent/mm/plugin/appbrand/g/c/h;Lcom/tencent/mm/plugin/appbrand/g/c/b/b;)V
    //   70: new 16	com/tencent/mm/plugin/appbrand/g/c/h$6
    //   73: dup
    //   74: aload_0
    //   75: invokespecial 337	com/tencent/mm/plugin/appbrand/g/c/h$6:<init>	(Lcom/tencent/mm/plugin/appbrand/g/c/h;)V
    //   78: invokevirtual 312	rx/d:a	(Lrx/b/b;Lrx/b/b;)Lrx/j;
    //   81: invokevirtual 315	rx/f/b:b	(Lrx/j;)V
    //   84: aload_0
    //   85: getfield 88	com/tencent/mm/plugin/appbrand/g/c/h:llc	Ljava/util/concurrent/locks/Lock;
    //   88: invokeinterface 324 1 0
    //   93: ldc_w 319
    //   96: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: return
    //   100: getstatic 62	com/tencent/mm/plugin/appbrand/g/c/h:TAG	Ljava/lang/String;
    //   103: ldc_w 339
    //   106: invokestatic 341	com/tencent/mm/plugin/appbrand/g/a:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   109: goto -25 -> 84
    //   112: astore_1
    //   113: getstatic 62	com/tencent/mm/plugin/appbrand/g/c/h:TAG	Ljava/lang/String;
    //   116: aload_1
    //   117: ldc_w 343
    //   120: invokestatic 346	com/tencent/mm/plugin/appbrand/g/a:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   123: aload_0
    //   124: getfield 88	com/tencent/mm/plugin/appbrand/g/c/h:llc	Ljava/util/concurrent/locks/Lock;
    //   127: invokeinterface 324 1 0
    //   132: ldc_w 319
    //   135: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: return
    //   139: astore_1
    //   140: aload_0
    //   141: getfield 88	com/tencent/mm/plugin/appbrand/g/c/h:llc	Ljava/util/concurrent/locks/Lock;
    //   144: invokeinterface 324 1 0
    //   149: ldc_w 319
    //   152: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   155: aload_1
    //   156: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	this	h
    //   0	157	1	paramb	com.tencent.mm.plugin.appbrand.g.c.b.b
    //   17	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   6	18	112	java/lang/Exception
    //   38	84	112	java/lang/Exception
    //   100	109	112	java/lang/Exception
    //   6	18	139	finally
    //   38	84	139	finally
    //   100	109	139	finally
    //   113	123	139	finally
  }
  
  public final boolean disable()
  {
    AppMethodBeat.i(159001);
    com.tencent.mm.plugin.appbrand.g.a.i(TAG, "mRouter is shutting down...");
    if (this.enabled)
    {
      this.llf.clear();
      this.lld.close();
      this.lla.clear();
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
    com.tencent.mm.plugin.appbrand.g.a.i(TAG, "mRouter is starting ...");
    this.port = i.bBD().port;
    try
    {
      if (!this.enabled)
      {
        List localList = g.bBz();
        this.lld = new e(new f("239.255.255.250"), localList, this, this.port);
        this.lld.start();
        this.enabled = true;
        AppMethodBeat.o(159000);
        return true;
      }
      AppMethodBeat.o(159000);
      return false;
    }
    catch (Exception localException)
    {
      com.tencent.mm.plugin.appbrand.g.a.a(TAG, localException, "");
      AppMethodBeat.o(159000);
    }
    return false;
  }
  
  public final void gZ(boolean paramBoolean)
  {
    AppMethodBeat.i(222905);
    Object localObject = new com.tencent.mm.plugin.appbrand.g.a.h(paramBoolean);
    if (!this.enabled)
    {
      com.tencent.mm.plugin.appbrand.g.a.e(TAG, "DLNA Router is not enable");
      AppMethodBeat.o(222905);
      return;
    }
    rx.f.b localb = this.lla;
    localObject = new b.c((com.tencent.mm.plugin.appbrand.g.a.d)localObject);
    localb.b(rx.d.a(new a.2(((b.c)localObject).lkB, ((b.c)localObject).lkA)).a(((com.tencent.mm.plugin.appbrand.g.d.b)localObject).llt).a(new rx.b.b()new rx.b.b {}, new rx.b.b() {}));
    AppMethodBeat.o(222905);
  }
  
  static final class a
  {
    private static h llh;
    
    static
    {
      AppMethodBeat.i(158997);
      llh = new h((byte)0);
      AppMethodBeat.o(158997);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.c.h
 * JD-Core Version:    0.7.0.1
 */