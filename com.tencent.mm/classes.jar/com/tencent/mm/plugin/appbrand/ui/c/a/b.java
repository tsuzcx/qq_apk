package com.tencent.mm.plugin.appbrand.ui.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.g.c.m;
import com.tencent.mm.kernel.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.l;
import java.util.Arrays;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfo;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "guard", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "deleteAll", "", "appId", "", "versionType", "version", "Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfoStorage$VERSION_QUERY;", "fillInitConfig", "", "initConfigWC", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "getScreenshotFilePath", "appVersion", "isDarkMode", "", "updateInfo", "info", "screenshotFilePath", "updateNotify", "item", "isNotify", "keys", "", "(Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfo;Z[Ljava/lang/String;)Z", "Companion", "VERSION_QUERY", "plugin-appbrand-integration_release"})
public final class b
  extends j<a>
{
  public static final String[] gLs;
  private static final String[] iLd;
  public static final a lLx;
  private final e db;
  private final ReentrantReadWriteLock lLw;
  
  static
  {
    AppMethodBeat.i(196487);
    lLx = new a((byte)0);
    gLs = new String[] { j.getCreateSQLs(a.gLr, "AppBrandFakeNativeSplashScreenshot") };
    iLd = new String[] { "appId", "versionType", "appVersion", "isDarkMode" };
    AppMethodBeat.o(196487);
  }
  
  public b(e parame)
  {
    super(parame, a.gLr, "AppBrandFakeNativeSplashScreenshot", m.INDEX_CREATE);
    AppMethodBeat.i(196486);
    this.db = parame;
    this.lLw = new ReentrantReadWriteLock();
    AppMethodBeat.o(196486);
  }
  
  public static final boolean bqg()
  {
    AppMethodBeat.i(196488);
    boolean bool = a.bqg();
    AppMethodBeat.o(196488);
    return bool;
  }
  
  public final int Nc(String paramString)
  {
    AppMethodBeat.i(196484);
    int i = a(this, paramString, 0, null, 6);
    AppMethodBeat.o(196484);
    return i;
  }
  
  /* Error */
  public final int a(String paramString, int paramInt, b paramb)
  {
    // Byte code:
    //   0: ldc 151
    //   2: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_3
    //   6: ldc 152
    //   8: invokestatic 112	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   11: aload_1
    //   12: checkcast 154	java/lang/CharSequence
    //   15: astore 8
    //   17: aload 8
    //   19: ifnull +13 -> 32
    //   22: aload 8
    //   24: invokeinterface 158 1 0
    //   29: ifne +18 -> 47
    //   32: iconst_1
    //   33: istore 4
    //   35: iload 4
    //   37: ifeq +16 -> 53
    //   40: ldc 151
    //   42: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: iconst_0
    //   46: ireturn
    //   47: iconst_0
    //   48: istore 4
    //   50: goto -15 -> 35
    //   53: new 160	java/util/LinkedList
    //   56: dup
    //   57: invokespecial 161	java/util/LinkedList:<init>	()V
    //   60: astore 8
    //   62: aload 8
    //   64: new 163	java/lang/StringBuilder
    //   67: dup
    //   68: ldc 165
    //   70: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   73: aload_1
    //   74: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: bipush 39
    //   79: invokevirtual 175	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   82: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokevirtual 183	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   88: pop
    //   89: iload_2
    //   90: iflt +60 -> 150
    //   93: aload 8
    //   95: ldc 185
    //   97: iload_2
    //   98: invokestatic 189	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   101: invokevirtual 193	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   104: invokevirtual 183	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   107: pop
    //   108: aload_3
    //   109: instanceof 13
    //   112: ifne +38 -> 150
    //   115: aload_3
    //   116: instanceof 17
    //   119: ifeq +126 -> 245
    //   122: aload 8
    //   124: new 163	java/lang/StringBuilder
    //   127: dup
    //   128: ldc 195
    //   130: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   133: aload_3
    //   134: checkcast 17	com/tencent/mm/plugin/appbrand/ui/c/a/b$b$c
    //   137: getfield 198	com/tencent/mm/plugin/appbrand/ui/c/a/b$b$c:version	I
    //   140: invokevirtual 201	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   143: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokevirtual 183	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   149: pop
    //   150: aload 8
    //   152: ldc 203
    //   154: invokevirtual 183	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   157: pop
    //   158: aload 8
    //   160: invokevirtual 207	java/util/LinkedList:toArray	()[Ljava/lang/Object;
    //   163: ldc 209
    //   165: invokestatic 214	org/apache/commons/b/g:a	([Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/String;
    //   168: astore 12
    //   170: aload 12
    //   172: ldc 216
    //   174: invokestatic 219	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   177: aload 12
    //   179: ldc 221
    //   181: invokestatic 219	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   184: new 160	java/util/LinkedList
    //   187: dup
    //   188: invokespecial 161	java/util/LinkedList:<init>	()V
    //   191: astore 11
    //   193: aload_0
    //   194: getfield 129	com/tencent/mm/plugin/appbrand/ui/c/a/b:lLw	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   197: astore 9
    //   199: aload 9
    //   201: invokevirtual 225	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   204: astore 8
    //   206: aload 9
    //   208: invokevirtual 228	java/util/concurrent/locks/ReentrantReadWriteLock:getWriteHoldCount	()I
    //   211: ifne +72 -> 283
    //   214: aload 9
    //   216: invokevirtual 231	java/util/concurrent/locks/ReentrantReadWriteLock:getReadHoldCount	()I
    //   219: istore 4
    //   221: iconst_0
    //   222: istore 5
    //   224: iload 5
    //   226: iload 4
    //   228: if_icmpge +61 -> 289
    //   231: aload 8
    //   233: invokevirtual 236	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   236: iload 5
    //   238: iconst_1
    //   239: iadd
    //   240: istore 5
    //   242: goto -18 -> 224
    //   245: aload_3
    //   246: instanceof 15
    //   249: ifeq -99 -> 150
    //   252: aload 8
    //   254: new 163	java/lang/StringBuilder
    //   257: dup
    //   258: ldc 238
    //   260: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   263: aload_3
    //   264: checkcast 15	com/tencent/mm/plugin/appbrand/ui/c/a/b$b$b
    //   267: getfield 239	com/tencent/mm/plugin/appbrand/ui/c/a/b$b$b:version	I
    //   270: invokevirtual 201	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   273: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: invokevirtual 183	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   279: pop
    //   280: goto -130 -> 150
    //   283: iconst_0
    //   284: istore 4
    //   286: goto -65 -> 221
    //   289: aload 9
    //   291: invokevirtual 243	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   294: astore 9
    //   296: aload 9
    //   298: invokevirtual 248	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   301: aload_0
    //   302: getfield 123	com/tencent/mm/plugin/appbrand/ui/c/a/b:db	Lcom/tencent/mm/sdk/e/e;
    //   305: ldc 250
    //   307: aload 12
    //   309: invokestatic 253	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   312: invokevirtual 193	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   315: aconst_null
    //   316: iconst_2
    //   317: invokeinterface 258 4 0
    //   322: checkcast 260	java/io/Closeable
    //   325: astore 10
    //   327: aload 10
    //   329: checkcast 262	android/database/Cursor
    //   332: astore 13
    //   334: new 160	java/util/LinkedList
    //   337: dup
    //   338: invokespecial 161	java/util/LinkedList:<init>	()V
    //   341: astore 14
    //   343: aload 13
    //   345: ifnull +51 -> 396
    //   348: aload 13
    //   350: invokeinterface 265 1 0
    //   355: ifne +41 -> 396
    //   358: aload 13
    //   360: invokeinterface 268 1 0
    //   365: ifeq +31 -> 396
    //   368: aload 14
    //   370: aload 13
    //   372: iconst_0
    //   373: invokeinterface 271 2 0
    //   378: invokevirtual 183	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   381: pop
    //   382: aload 13
    //   384: invokeinterface 274 1 0
    //   389: istore 7
    //   391: iload 7
    //   393: ifne -25 -> 368
    //   396: aload 10
    //   398: aconst_null
    //   399: invokestatic 279	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   402: aload 11
    //   404: aload 14
    //   406: checkcast 281	java/util/Collection
    //   409: invokevirtual 285	java/util/LinkedList:addAll	(Ljava/util/Collection;)Z
    //   412: pop
    //   413: aload_0
    //   414: getfield 123	com/tencent/mm/plugin/appbrand/ui/c/a/b:db	Lcom/tencent/mm/sdk/e/e;
    //   417: ldc 88
    //   419: aload 12
    //   421: aconst_null
    //   422: invokeinterface 289 4 0
    //   427: istore 6
    //   429: getstatic 295	d/y:JfV	Ld/y;
    //   432: astore 10
    //   434: iconst_0
    //   435: istore 5
    //   437: iload 5
    //   439: iload 4
    //   441: if_icmpge +60 -> 501
    //   444: aload 8
    //   446: invokevirtual 296	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   449: iload 5
    //   451: iconst_1
    //   452: iadd
    //   453: istore 5
    //   455: goto -18 -> 437
    //   458: astore_3
    //   459: ldc 151
    //   461: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   464: aload_3
    //   465: athrow
    //   466: astore_1
    //   467: aload 10
    //   469: aload_3
    //   470: invokestatic 279	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   473: ldc 151
    //   475: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   478: aload_1
    //   479: athrow
    //   480: astore_1
    //   481: iconst_0
    //   482: istore_2
    //   483: iload_2
    //   484: iload 4
    //   486: if_icmpge +59 -> 545
    //   489: aload 8
    //   491: invokevirtual 296	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   494: iload_2
    //   495: iconst_1
    //   496: iadd
    //   497: istore_2
    //   498: goto -15 -> 483
    //   501: aload 9
    //   503: invokevirtual 297	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   506: aload 11
    //   508: checkcast 299	java/lang/Iterable
    //   511: invokeinterface 303 1 0
    //   516: astore 8
    //   518: aload 8
    //   520: invokeinterface 308 1 0
    //   525: ifeq +32 -> 557
    //   528: aload 8
    //   530: invokeinterface 312 1 0
    //   535: checkcast 80	java/lang/String
    //   538: invokestatic 318	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   541: pop
    //   542: goto -24 -> 518
    //   545: aload 9
    //   547: invokevirtual 297	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   550: ldc 151
    //   552: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   555: aload_1
    //   556: athrow
    //   557: getstatic 135	com/tencent/mm/plugin/appbrand/ui/c/a/b$b$a:lLy	Lcom/tencent/mm/plugin/appbrand/ui/c/a/b$b$a;
    //   560: aload_3
    //   561: invokestatic 321	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   564: ifeq +16 -> 580
    //   567: iload_2
    //   568: ifge +12 -> 580
    //   571: aload_1
    //   572: invokestatic 324	com/tencent/mm/plugin/appbrand/ui/c/a/b$a:Nd	(Ljava/lang/String;)Ljava/lang/String;
    //   575: iconst_1
    //   576: invokestatic 328	com/tencent/mm/vfs/i:cO	(Ljava/lang/String;Z)Z
    //   579: pop
    //   580: ldc 151
    //   582: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   585: iload 6
    //   587: ireturn
    //   588: astore_1
    //   589: aconst_null
    //   590: astore_3
    //   591: goto -124 -> 467
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	594	0	this	b
    //   0	594	1	paramString	String
    //   0	594	2	paramInt	int
    //   0	594	3	paramb	b
    //   33	454	4	i	int
    //   222	232	5	j	int
    //   427	159	6	k	int
    //   389	3	7	bool	boolean
    //   15	514	8	localObject1	Object
    //   197	349	9	localObject2	Object
    //   325	143	10	localObject3	Object
    //   191	316	11	localLinkedList1	java.util.LinkedList
    //   168	252	12	str	String
    //   332	51	13	localCursor	android.database.Cursor
    //   341	64	14	localLinkedList2	java.util.LinkedList
    // Exception table:
    //   from	to	target	type
    //   327	343	458	java/lang/Throwable
    //   348	368	458	java/lang/Throwable
    //   368	391	458	java/lang/Throwable
    //   459	466	466	finally
    //   301	327	480	finally
    //   396	434	480	finally
    //   467	480	480	finally
    //   327	343	588	finally
    //   348	368	588	finally
    //   368	391	588	finally
  }
  
  public final boolean a(String paramString1, int paramInt1, int paramInt2, boolean paramBoolean, String paramString2)
  {
    m = 0;
    int k = 0;
    AppMethodBeat.i(196479);
    Object localObject1 = (CharSequence)paramString1;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(196479);
      return false;
    }
    Object localObject2 = this.lLw;
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
        paramString1 = (c)localObject3;
        String[] arrayOfString = iLd;
        if (super.get(paramString1, (String[])Arrays.copyOf(arrayOfString, arrayOfString.length))) {
          continue;
        }
        paramInt1 = 1;
        paramString1 = ((a)localObject3).field_screenshotFilePath;
        ((a)localObject3).field_screenshotFilePath = paramString2;
        if (paramInt1 == 0) {
          continue;
        }
        paramBoolean = super.insert((c)localObject3);
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
        i.deleteFile(paramString1);
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
      paramString2 = (c)localObject3;
      localObject3 = iLd;
      paramBoolean = super.update(paramString2, (String[])Arrays.copyOf((Object[])localObject3, localObject3.length));
      continue;
      paramInt1 = 0;
    }
    ((ReentrantReadWriteLock.WriteLock)localObject2).unlock();
    AppMethodBeat.o(196479);
    return paramBoolean;
    while (paramInt1 < i)
    {
      ((ReentrantReadWriteLock.ReadLock)localObject1).lock();
      paramInt1 += 1;
    }
    ((ReentrantReadWriteLock.WriteLock)localObject2).unlock();
    AppMethodBeat.o(196479);
    throw paramString1;
  }
  
  public final String b(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(196480);
    ReentrantReadWriteLock.ReadLock localReadLock = this.lLw.readLock();
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
              paramString = (c)localObject;
              String[] arrayOfString = iLd;
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
        AppMethodBeat.o(196480);
      }
    }
  }
  
  public final int bX(String paramString, int paramInt)
  {
    AppMethodBeat.i(196483);
    paramInt = a(this, paramString, paramInt, null, 4);
    AppMethodBeat.o(196483);
    return paramInt;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfoStorage$Companion;", "", "()V", "KEYS", "", "", "[Ljava/lang/String;", "SCREENSHOT_ROOT", "()Ljava/lang/String;", "SWITCH_ON", "", "()Z", "TABLE_CREATE", "kotlin.jvm.PlatformType", "TAG", "uin", "getUin", "generateDir", "appId", "generateFilePath", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static String Nd(String paramString)
    {
      AppMethodBeat.i(196472);
      paramString = bqh() + '/' + paramString;
      AppMethodBeat.o(196472);
      return paramString;
    }
    
    public static boolean bqg()
    {
      AppMethodBeat.i(196475);
      com.tencent.mm.plugin.expt.a.b localb = (com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class);
      com.tencent.mm.plugin.expt.a.b.a locala = com.tencent.mm.plugin.expt.a.b.a.pnc;
      if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE)) {}
      for (boolean bool = true;; bool = false)
      {
        bool = localb.a(locala, bool);
        AppMethodBeat.o(196475);
        return bool;
      }
    }
    
    private static String bqh()
    {
      AppMethodBeat.i(196473);
      Object localObject = new StringBuilder().append(com.tencent.mm.loader.j.b.ahZ()).append("appbrand/runtime_snapshots/");
      a locala = b.lLx;
      localObject = getUin();
      i.aMF((String)localObject);
      AppMethodBeat.o(196473);
      return localObject;
    }
    
    private static String getUin()
    {
      AppMethodBeat.i(196474);
      Object localObject = g.afy().aeZ();
      k.g(localObject, "MMKernel.process().current()");
      if (((com.tencent.mm.kernel.b.h)localObject).agu()) {
        k.g(g.afz(), "MMKernel.account()");
      }
      for (int i = com.tencent.mm.kernel.a.getUin();; i = com.tencent.mm.kernel.a.aep())
      {
        localObject = new p(i).toString();
        k.g(localObject, "if (MMKernel.process().c…(it).toString()\n        }");
        AppMethodBeat.o(196474);
        return localObject;
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfoStorage$VERSION_QUERY;", "", "()V", "ALL", "EQUAL", "LESS", "Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfoStorage$VERSION_QUERY$ALL;", "Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfoStorage$VERSION_QUERY$LESS;", "Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfoStorage$VERSION_QUERY$EQUAL;", "plugin-appbrand-integration_release"})
  public static abstract class b
  {
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfoStorage$VERSION_QUERY$ALL;", "Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfoStorage$VERSION_QUERY;", "()V", "plugin-appbrand-integration_release"})
    public static final class a
      extends b.b
    {
      public static final a lLy;
      
      static
      {
        AppMethodBeat.i(196476);
        lLy = new a();
        AppMethodBeat.o(196476);
      }
      
      private a()
      {
        super();
      }
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfoStorage$VERSION_QUERY$EQUAL;", "Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfoStorage$VERSION_QUERY;", "version", "", "(I)V", "getVersion", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "plugin-appbrand-integration_release"})
    public static final class b
      extends b.b
    {
      final int version;
      
      public final boolean equals(Object paramObject)
      {
        if (this != paramObject)
        {
          if ((paramObject instanceof b))
          {
            paramObject = (b)paramObject;
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
        AppMethodBeat.i(196477);
        String str = "EQUAL(version=" + this.version + ")";
        AppMethodBeat.o(196477);
        return str;
      }
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfoStorage$VERSION_QUERY$LESS;", "Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfoStorage$VERSION_QUERY;", "version", "", "(I)V", "getVersion", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "plugin-appbrand-integration_release"})
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
        AppMethodBeat.i(196478);
        String str = "LESS(version=" + this.version + ")";
        AppMethodBeat.o(196478);
        return str;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.c.a.b
 * JD-Core Version:    0.7.0.1
 */