package com.tencent.mm.plugin.appbrand.ui.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.m;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.vfs.u;
import java.util.Arrays;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfo;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "guard", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "deleteAll", "", "appId", "", "versionType", "version", "Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfoStorage$VERSION_QUERY;", "fillInitConfig", "", "initConfigWC", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "getScreenshotFilePath", "appVersion", "isDarkMode", "", "updateInfo", "info", "screenshotFilePath", "updateNotify", "item", "isNotify", "keys", "", "(Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfo;Z[Ljava/lang/String;)Z", "Companion", "VERSION_QUERY", "plugin-appbrand-integration_release"})
public final class b
  extends MAutoStorage<a>
{
  public static final String[] lqL;
  private static final String[] nDP;
  public static final a rhO;
  private final ISQLiteDatabase db;
  private final ReentrantReadWriteLock rhN;
  
  static
  {
    AppMethodBeat.i(284234);
    rhO = new a((byte)0);
    lqL = new String[] { MAutoStorage.getCreateSQLs(a.lqK, "AppBrandFakeNativeSplashScreenshot") };
    nDP = new String[] { "appId", "versionType", "appVersion", "isDarkMode" };
    AppMethodBeat.o(284234);
  }
  
  public b(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, a.lqK, "AppBrandFakeNativeSplashScreenshot", m.INDEX_CREATE);
    AppMethodBeat.i(284232);
    this.db = paramISQLiteDatabase;
    this.rhN = new ReentrantReadWriteLock();
    AppMethodBeat.o(284232);
  }
  
  public static final boolean clP()
  {
    AppMethodBeat.i(284236);
    boolean bool = a.clP();
    AppMethodBeat.o(284236);
    return bool;
  }
  
  /* Error */
  public final int a(String paramString, int paramInt, b paramb)
  {
    // Byte code:
    //   0: ldc 144
    //   2: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_3
    //   6: ldc 145
    //   8: invokestatic 110	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   11: aload_1
    //   12: checkcast 147	java/lang/CharSequence
    //   15: astore 8
    //   17: aload 8
    //   19: ifnull +13 -> 32
    //   22: aload 8
    //   24: invokeinterface 151 1 0
    //   29: ifne +18 -> 47
    //   32: iconst_1
    //   33: istore 4
    //   35: iload 4
    //   37: ifeq +16 -> 53
    //   40: ldc 144
    //   42: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: iconst_0
    //   46: ireturn
    //   47: iconst_0
    //   48: istore 4
    //   50: goto -15 -> 35
    //   53: new 153	java/util/LinkedList
    //   56: dup
    //   57: invokespecial 154	java/util/LinkedList:<init>	()V
    //   60: astore 8
    //   62: aload 8
    //   64: new 156	java/lang/StringBuilder
    //   67: dup
    //   68: ldc 158
    //   70: invokespecial 161	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   73: aload_1
    //   74: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: bipush 39
    //   79: invokevirtual 168	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   82: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokevirtual 176	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   88: pop
    //   89: iload_2
    //   90: iflt +60 -> 150
    //   93: aload 8
    //   95: ldc 178
    //   97: iload_2
    //   98: invokestatic 182	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   101: invokevirtual 186	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   104: invokevirtual 176	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   107: pop
    //   108: aload_3
    //   109: instanceof 13
    //   112: ifne +38 -> 150
    //   115: aload_3
    //   116: instanceof 17
    //   119: ifeq +126 -> 245
    //   122: aload 8
    //   124: new 156	java/lang/StringBuilder
    //   127: dup
    //   128: ldc 188
    //   130: invokespecial 161	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   133: aload_3
    //   134: checkcast 17	com/tencent/mm/plugin/appbrand/ui/c/a/b$b$c
    //   137: getfield 191	com/tencent/mm/plugin/appbrand/ui/c/a/b$b$c:version	I
    //   140: invokevirtual 194	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   143: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokevirtual 176	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   149: pop
    //   150: aload 8
    //   152: ldc 196
    //   154: invokevirtual 176	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   157: pop
    //   158: aload 8
    //   160: invokevirtual 200	java/util/LinkedList:toArray	()[Ljava/lang/Object;
    //   163: ldc 202
    //   165: invokestatic 207	org/apache/commons/b/g:a	([Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/String;
    //   168: astore 12
    //   170: aload 12
    //   172: ldc 209
    //   174: invokestatic 212	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   177: aload 12
    //   179: ldc 214
    //   181: invokestatic 212	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   184: new 153	java/util/LinkedList
    //   187: dup
    //   188: invokespecial 154	java/util/LinkedList:<init>	()V
    //   191: astore 11
    //   193: aload_0
    //   194: getfield 127	com/tencent/mm/plugin/appbrand/ui/c/a/b:rhN	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   197: astore 9
    //   199: aload 9
    //   201: invokevirtual 218	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   204: astore 8
    //   206: aload 9
    //   208: invokevirtual 221	java/util/concurrent/locks/ReentrantReadWriteLock:getWriteHoldCount	()I
    //   211: ifne +48 -> 259
    //   214: aload 9
    //   216: invokevirtual 224	java/util/concurrent/locks/ReentrantReadWriteLock:getReadHoldCount	()I
    //   219: istore 4
    //   221: iconst_0
    //   222: istore 5
    //   224: iload 5
    //   226: iload 4
    //   228: if_icmpge +37 -> 265
    //   231: aload 8
    //   233: invokevirtual 229	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   236: iload 5
    //   238: iconst_1
    //   239: iadd
    //   240: istore 5
    //   242: goto -18 -> 224
    //   245: aload_3
    //   246: instanceof 15
    //   249: ifeq -99 -> 150
    //   252: ldc 144
    //   254: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   257: aconst_null
    //   258: athrow
    //   259: iconst_0
    //   260: istore 4
    //   262: goto -41 -> 221
    //   265: aload 9
    //   267: invokevirtual 233	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   270: astore 9
    //   272: aload 9
    //   274: invokevirtual 238	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   277: aload_0
    //   278: getfield 121	com/tencent/mm/plugin/appbrand/ui/c/a/b:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   281: ldc 240
    //   283: aload 12
    //   285: invokestatic 243	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   288: invokevirtual 186	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   291: aconst_null
    //   292: iconst_2
    //   293: invokeinterface 249 4 0
    //   298: checkcast 251	java/io/Closeable
    //   301: astore 10
    //   303: aload 10
    //   305: checkcast 253	android/database/Cursor
    //   308: astore 13
    //   310: new 153	java/util/LinkedList
    //   313: dup
    //   314: invokespecial 154	java/util/LinkedList:<init>	()V
    //   317: astore 14
    //   319: aload 13
    //   321: ifnull +51 -> 372
    //   324: aload 13
    //   326: invokeinterface 256 1 0
    //   331: ifne +41 -> 372
    //   334: aload 13
    //   336: invokeinterface 259 1 0
    //   341: ifeq +31 -> 372
    //   344: aload 14
    //   346: aload 13
    //   348: iconst_0
    //   349: invokeinterface 262 2 0
    //   354: invokevirtual 176	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   357: pop
    //   358: aload 13
    //   360: invokeinterface 265 1 0
    //   365: istore 7
    //   367: iload 7
    //   369: ifne -25 -> 344
    //   372: aload 10
    //   374: aconst_null
    //   375: invokestatic 270	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   378: aload 11
    //   380: aload 14
    //   382: checkcast 272	java/util/Collection
    //   385: invokevirtual 276	java/util/LinkedList:addAll	(Ljava/util/Collection;)Z
    //   388: pop
    //   389: aload_0
    //   390: getfield 121	com/tencent/mm/plugin/appbrand/ui/c/a/b:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   393: ldc 87
    //   395: aload 12
    //   397: aconst_null
    //   398: invokeinterface 280 4 0
    //   403: istore 6
    //   405: getstatic 286	kotlin/x:aazN	Lkotlin/x;
    //   408: astore 10
    //   410: iconst_0
    //   411: istore 5
    //   413: iload 5
    //   415: iload 4
    //   417: if_icmpge +60 -> 477
    //   420: aload 8
    //   422: invokevirtual 287	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   425: iload 5
    //   427: iconst_1
    //   428: iadd
    //   429: istore 5
    //   431: goto -18 -> 413
    //   434: astore_3
    //   435: ldc 144
    //   437: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   440: aload_3
    //   441: athrow
    //   442: astore_1
    //   443: aload 10
    //   445: aload_3
    //   446: invokestatic 270	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   449: ldc 144
    //   451: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   454: aload_1
    //   455: athrow
    //   456: astore_1
    //   457: iconst_0
    //   458: istore_2
    //   459: iload_2
    //   460: iload 4
    //   462: if_icmpge +59 -> 521
    //   465: aload 8
    //   467: invokevirtual 287	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   470: iload_2
    //   471: iconst_1
    //   472: iadd
    //   473: istore_2
    //   474: goto -15 -> 459
    //   477: aload 9
    //   479: invokevirtual 288	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   482: aload 11
    //   484: checkcast 290	java/lang/Iterable
    //   487: invokeinterface 294 1 0
    //   492: astore 8
    //   494: aload 8
    //   496: invokeinterface 299 1 0
    //   501: ifeq +32 -> 533
    //   504: aload 8
    //   506: invokeinterface 303 1 0
    //   511: checkcast 79	java/lang/String
    //   514: invokestatic 309	com/tencent/mm/vfs/u:deleteFile	(Ljava/lang/String;)Z
    //   517: pop
    //   518: goto -24 -> 494
    //   521: aload 9
    //   523: invokevirtual 288	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   526: ldc 144
    //   528: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   531: aload_1
    //   532: athrow
    //   533: getstatic 133	com/tencent/mm/plugin/appbrand/ui/c/a/b$b$a:rhP	Lcom/tencent/mm/plugin/appbrand/ui/c/a/b$b$a;
    //   536: aload_3
    //   537: invokestatic 313	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   540: ifeq +16 -> 556
    //   543: iload_2
    //   544: ifge +12 -> 556
    //   547: aload_1
    //   548: invokestatic 316	com/tencent/mm/plugin/appbrand/ui/c/a/b$a:anb	(Ljava/lang/String;)Ljava/lang/String;
    //   551: iconst_1
    //   552: invokestatic 320	com/tencent/mm/vfs/u:dK	(Ljava/lang/String;Z)Z
    //   555: pop
    //   556: ldc 144
    //   558: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   561: iload 6
    //   563: ireturn
    //   564: astore_1
    //   565: aconst_null
    //   566: astore_3
    //   567: goto -124 -> 443
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	570	0	this	b
    //   0	570	1	paramString	String
    //   0	570	2	paramInt	int
    //   0	570	3	paramb	b
    //   33	430	4	i	int
    //   222	208	5	j	int
    //   403	159	6	k	int
    //   365	3	7	bool	boolean
    //   15	490	8	localObject1	Object
    //   197	325	9	localObject2	Object
    //   301	143	10	localObject3	Object
    //   191	292	11	localLinkedList1	java.util.LinkedList
    //   168	228	12	str	String
    //   308	51	13	localCursor	android.database.Cursor
    //   317	64	14	localLinkedList2	java.util.LinkedList
    // Exception table:
    //   from	to	target	type
    //   303	319	434	java/lang/Throwable
    //   324	344	434	java/lang/Throwable
    //   344	367	434	java/lang/Throwable
    //   435	442	442	finally
    //   277	303	456	finally
    //   372	410	456	finally
    //   443	456	456	finally
    //   303	319	564	finally
    //   324	344	564	finally
    //   344	367	564	finally
  }
  
  public final String a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(284224);
    ReentrantReadWriteLock.ReadLock localReadLock = this.rhN.readLock();
    localReadLock.lock();
    label157:
    for (;;)
    {
      try
      {
        Object localObject = (CharSequence)paramString;
        if (localObject != null)
        {
          if (((CharSequence)localObject).length() == 0)
          {
            break label157;
            if (i == 0)
            {
              localObject = new a();
              ((a)localObject).field_appId = paramString;
              ((a)localObject).field_versionType = paramInt1;
              ((a)localObject).field_appVersion = paramInt2;
              ((a)localObject).field_isDarkMode = paramBoolean;
              paramString = (IAutoDBItem)localObject;
              String[] arrayOfString = nDP;
              if (super.get(paramString, (String[])Arrays.copyOf(arrayOfString, arrayOfString.length)))
              {
                paramString = ((a)localObject).field_screenshotFilePath;
                return paramString;
              }
            }
          }
          else
          {
            i = 0;
            continue;
          }
          paramString = null;
          continue;
        }
        int i = 1;
      }
      finally
      {
        localReadLock.unlock();
        AppMethodBeat.o(284224);
      }
    }
  }
  
  public final boolean a(String paramString1, int paramInt1, int paramInt2, boolean paramBoolean, String paramString2)
  {
    m = 0;
    int k = 0;
    AppMethodBeat.i(284223);
    Object localObject1 = (CharSequence)paramString1;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(284223);
      return false;
    }
    Object localObject2 = this.rhN;
    localObject1 = ((ReentrantReadWriteLock)localObject2).readLock();
    if (((ReentrantReadWriteLock)localObject2).getWriteHoldCount() == 0) {}
    for (i = ((ReentrantReadWriteLock)localObject2).getReadHoldCount();; i = 0)
    {
      int j = 0;
      while (j < i)
      {
        ((ReentrantReadWriteLock.ReadLock)localObject1).unlock();
        j += 1;
      }
    }
    localObject2 = ((ReentrantReadWriteLock)localObject2).writeLock();
    ((ReentrantReadWriteLock.WriteLock)localObject2).lock();
    for (;;)
    {
      try
      {
        localObject3 = new a();
        ((a)localObject3).field_appId = paramString1;
        ((a)localObject3).field_versionType = paramInt1;
        ((a)localObject3).field_appVersion = paramInt2;
        ((a)localObject3).field_isDarkMode = paramBoolean;
        paramString1 = (IAutoDBItem)localObject3;
        String[] arrayOfString = nDP;
        if (super.get(paramString1, (String[])Arrays.copyOf(arrayOfString, arrayOfString.length))) {
          continue;
        }
        paramInt1 = 1;
        paramString1 = ((a)localObject3).field_screenshotFilePath;
        ((a)localObject3).field_screenshotFilePath = paramString2;
        if (paramInt1 == 0) {
          continue;
        }
        paramBoolean = super.insert((IAutoDBItem)localObject3);
        paramString2 = (CharSequence)paramString1;
        if (paramString2 == null) {
          continue;
        }
        if (paramString2.length() != 0) {
          continue;
        }
      }
      finally
      {
        Object localObject3;
        paramInt1 = m;
        continue;
        paramInt1 = 1;
        continue;
      }
      paramInt2 = k;
      if (paramInt1 == 0)
      {
        u.deleteFile(paramString1);
        paramInt2 = k;
      }
      if (paramInt2 >= i) {
        continue;
      }
      ((ReentrantReadWriteLock.ReadLock)localObject1).lock();
      paramInt2 += 1;
      continue;
      paramInt1 = 0;
      continue;
      paramString2 = (IAutoDBItem)localObject3;
      localObject3 = nDP;
      paramBoolean = super.update(paramString2, (String[])Arrays.copyOf((Object[])localObject3, localObject3.length));
      continue;
      paramInt1 = 0;
    }
    ((ReentrantReadWriteLock.WriteLock)localObject2).unlock();
    AppMethodBeat.o(284223);
    return paramBoolean;
    while (paramInt1 < i)
    {
      ((ReentrantReadWriteLock.ReadLock)localObject1).lock();
      paramInt1 += 1;
    }
    ((ReentrantReadWriteLock.WriteLock)localObject2).unlock();
    AppMethodBeat.o(284223);
    throw paramString1;
  }
  
  public final int ana(String paramString)
  {
    AppMethodBeat.i(284228);
    int i = a(this, paramString, 0, null, 6);
    AppMethodBeat.o(284228);
    return i;
  }
  
  public final int cN(String paramString, int paramInt)
  {
    AppMethodBeat.i(284227);
    paramInt = a(this, paramString, paramInt, null, 4);
    AppMethodBeat.o(284227);
    return paramInt;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfoStorage$Companion;", "", "()V", "KEYS", "", "", "[Ljava/lang/String;", "SCREENSHOT_ROOT", "()Ljava/lang/String;", "SWITCH_ON", "", "()Z", "TABLE_CREATE", "kotlin.jvm.PlatformType", "TAG", "uin", "getUin", "generateDir", "appId", "generateFilePath", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static String anb(String paramString)
    {
      AppMethodBeat.i(280567);
      paramString = clQ() + '/' + paramString;
      AppMethodBeat.o(280567);
      return paramString;
    }
    
    public static boolean clP()
    {
      AppMethodBeat.i(280570);
      com.tencent.mm.plugin.expt.b.b localb = (com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class);
      com.tencent.mm.plugin.expt.b.b.a locala = com.tencent.mm.plugin.expt.b.b.a.vBo;
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) {}
      for (boolean bool = true;; bool = false)
      {
        bool = localb.a(locala, bool);
        AppMethodBeat.o(280570);
        return bool;
      }
    }
    
    private static String clQ()
    {
      AppMethodBeat.i(280568);
      Object localObject = new StringBuilder().append(com.tencent.mm.loader.j.b.aSD()).append("appbrand/runtime_snapshots/");
      a locala = b.rhO;
      localObject = getUin();
      u.bBD((String)localObject);
      AppMethodBeat.o(280568);
      return localObject;
    }
    
    private static String getUin()
    {
      AppMethodBeat.i(280569);
      Object localObject = com.tencent.mm.kernel.h.aHD().aHf();
      kotlin.g.b.p.j(localObject, "MMKernel.process().current()");
      if (((com.tencent.mm.kernel.b.h)localObject).aIE()) {
        kotlin.g.b.p.j(com.tencent.mm.kernel.h.aHE(), "MMKernel.account()");
      }
      for (int i = com.tencent.mm.kernel.b.getUin();; i = com.tencent.mm.kernel.b.aGr())
      {
        localObject = new com.tencent.mm.b.p(i).toString();
        kotlin.g.b.p.j(localObject, "if (MMKernel.process().c…(it).toString()\n        }");
        AppMethodBeat.o(280569);
        return localObject;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfoStorage$VERSION_QUERY;", "", "()V", "ALL", "EQUAL", "LESS", "Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfoStorage$VERSION_QUERY$ALL;", "Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfoStorage$VERSION_QUERY$LESS;", "Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfoStorage$VERSION_QUERY$EQUAL;", "plugin-appbrand-integration_release"})
  public static abstract class b
  {
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfoStorage$VERSION_QUERY$ALL;", "Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfoStorage$VERSION_QUERY;", "()V", "plugin-appbrand-integration_release"})
    public static final class a
      extends b.b
    {
      public static final a rhP;
      
      static
      {
        AppMethodBeat.i(254122);
        rhP = new a();
        AppMethodBeat.o(254122);
      }
      
      private a()
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfoStorage$VERSION_QUERY$EQUAL;", "Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfoStorage$VERSION_QUERY;", "version", "", "(I)V", "getVersion", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "plugin-appbrand-integration_release"})
    public static final class b
      extends b.b
    {
      public final boolean equals(Object paramObject)
      {
        if (this != paramObject)
        {
          if ((paramObject instanceof b)) {
            throw null;
          }
        }
        else {
          return true;
        }
        return false;
      }
      
      public final int hashCode()
      {
        throw null;
      }
      
      public final String toString()
      {
        throw null;
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfoStorage$VERSION_QUERY$LESS;", "Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfoStorage$VERSION_QUERY;", "version", "", "(I)V", "getVersion", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "plugin-appbrand-integration_release"})
    public static final class c
      extends b.b
    {
      final int version;
      
      public c(int paramInt)
      {
        super();
        this.version = paramInt;
      }
      
      public final boolean equals(Object paramObject)
      {
        if (this != paramObject)
        {
          if ((paramObject instanceof c))
          {
            paramObject = (c)paramObject;
            if (this.version != paramObject.version) {}
          }
        }
        else {
          return true;
        }
        return false;
      }
      
      public final int hashCode()
      {
        return this.version;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(277000);
        String str = "LESS(version=" + this.version + ")";
        AppMethodBeat.o(277000);
        return str;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.c.a.b
 * JD-Core Version:    0.7.0.1
 */