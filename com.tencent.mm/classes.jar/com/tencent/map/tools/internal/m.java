package com.tencent.map.tools.internal;

import android.content.Context;
import com.tencent.map.tools.sheet.listener.ModuleEncryptListener;
import com.tencent.map.tools.sheet.listener.ModuleUncaughtListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import dalvik.system.DexClassLoader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.zip.GZIPOutputStream;

public class m
{
  private static final String a;
  private DexClassLoader b;
  private Context c;
  private ModuleUncaughtListener d;
  private File e;
  private h f;
  private j g;
  private i h;
  private n i;
  private ModuleEncryptListener j;
  
  static
  {
    AppMethodBeat.i(180825);
    a = m.class.getSimpleName();
    AppMethodBeat.o(180825);
  }
  
  public m(Context paramContext)
  {
    AppMethodBeat.i(180820);
    this.j = new ModuleEncryptListener()
    {
      public final byte[] enCryptModleData(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(180819);
        paramAnonymousArrayOfByte = m.a(paramAnonymousArrayOfByte, "0PEq^X$sjtWqEqa2$dg4TG2PT^4dFEep", t.G);
        AppMethodBeat.o(180819);
        return paramAnonymousArrayOfByte;
      }
    };
    this.c = paramContext;
    this.f = new h(paramContext);
    this.g = new j(paramContext);
    this.h = new i(paramContext, g.a(paramContext).c());
    g.a(paramContext).a(this.j);
    AppMethodBeat.o(180820);
  }
  
  private static byte[] a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(180823);
    Object localObject2 = null;
    localObject1 = localObject2;
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(paramArrayOfByte.length);
      localObject1 = localObject2;
      GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
      localObject1 = localObject2;
      localGZIPOutputStream.write(paramArrayOfByte);
      localObject1 = localObject2;
      localGZIPOutputStream.close();
      localObject1 = localObject2;
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      localObject1 = paramArrayOfByte;
      localByteArrayOutputStream.close();
    }
    catch (Throwable paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte = (byte[])localObject1;
      }
    }
    AppMethodBeat.o(180823);
    return paramArrayOfByte;
  }
  
  /* Error */
  public final int a(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 141
    //   6: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: invokevirtual 144	com/tencent/map/tools/internal/m:b	()Ldalvik/system/DexClassLoader;
    //   13: astore 4
    //   15: aload 4
    //   17: ifnonnull +12 -> 29
    //   20: ldc 141
    //   22: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: aload_0
    //   26: monitorexit
    //   27: iload_2
    //   28: ireturn
    //   29: aload_1
    //   30: invokestatic 150	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   33: ifne +69 -> 102
    //   36: aload_0
    //   37: getfield 58	com/tencent/map/tools/internal/m:c	Landroid/content/Context;
    //   40: invokevirtual 156	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   43: ldc 158
    //   45: iconst_1
    //   46: anewarray 36	java/lang/Class
    //   49: dup
    //   50: iconst_0
    //   51: ldc 160
    //   53: aastore
    //   54: iconst_1
    //   55: anewarray 4	java/lang/Object
    //   58: dup
    //   59: iconst_0
    //   60: aload_1
    //   61: aastore
    //   62: invokestatic 165	com/tencent/map/tools/internal/x:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   65: checkcast 160	java/lang/String
    //   68: astore_1
    //   69: aload_1
    //   70: invokestatic 150	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   73: ifne +29 -> 102
    //   76: new 167	java/io/File
    //   79: dup
    //   80: aload_1
    //   81: invokespecial 170	java/io/File:<init>	(Ljava/lang/String;)V
    //   84: invokevirtual 174	java/io/File:exists	()Z
    //   87: istore_3
    //   88: iload_3
    //   89: ifeq +13 -> 102
    //   92: ldc 141
    //   94: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: iconst_0
    //   98: istore_2
    //   99: goto -74 -> 25
    //   102: getstatic 176	com/tencent/map/tools/internal/x:g	Ljava/lang/String;
    //   105: astore_1
    //   106: aload_1
    //   107: ifnull +14 -> 121
    //   110: aload_1
    //   111: ldc 178
    //   113: invokevirtual 182	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   116: istore_3
    //   117: iload_3
    //   118: ifeq +13 -> 131
    //   121: ldc 141
    //   123: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: iconst_3
    //   127: istore_2
    //   128: goto -103 -> 25
    //   131: invokestatic 188	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   134: astore 5
    //   136: getstatic 194	android/os/Build$VERSION:SDK_INT	I
    //   139: bipush 28
    //   141: if_icmplt +48 -> 189
    //   144: aload 5
    //   146: ldc 196
    //   148: iconst_2
    //   149: anewarray 36	java/lang/Class
    //   152: dup
    //   153: iconst_0
    //   154: ldc 160
    //   156: aastore
    //   157: dup
    //   158: iconst_1
    //   159: ldc 198
    //   161: aastore
    //   162: iconst_2
    //   163: anewarray 4	java/lang/Object
    //   166: dup
    //   167: iconst_0
    //   168: aload_1
    //   169: aastore
    //   170: dup
    //   171: iconst_1
    //   172: aload 4
    //   174: aastore
    //   175: invokestatic 165	com/tencent/map/tools/internal/x:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   178: pop
    //   179: ldc 141
    //   181: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   184: iconst_0
    //   185: istore_2
    //   186: goto -161 -> 25
    //   189: aload 5
    //   191: ldc 196
    //   193: iconst_3
    //   194: anewarray 36	java/lang/Class
    //   197: dup
    //   198: iconst_0
    //   199: ldc 160
    //   201: aastore
    //   202: dup
    //   203: iconst_1
    //   204: ldc 198
    //   206: aastore
    //   207: dup
    //   208: iconst_2
    //   209: ldc 160
    //   211: aastore
    //   212: iconst_3
    //   213: anewarray 4	java/lang/Object
    //   216: dup
    //   217: iconst_0
    //   218: aload_1
    //   219: aastore
    //   220: dup
    //   221: iconst_1
    //   222: aload 4
    //   224: aastore
    //   225: dup
    //   226: iconst_2
    //   227: aconst_null
    //   228: aastore
    //   229: invokestatic 165	com/tencent/map/tools/internal/x:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   232: pop
    //   233: goto -54 -> 179
    //   236: astore_1
    //   237: ldc 141
    //   239: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   242: iconst_2
    //   243: istore_2
    //   244: goto -219 -> 25
    //   247: astore_1
    //   248: ldc 141
    //   250: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   253: iconst_2
    //   254: istore_2
    //   255: goto -230 -> 25
    //   258: astore_1
    //   259: aload_0
    //   260: monitorexit
    //   261: aload_1
    //   262: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	this	m
    //   0	263	1	paramString	String
    //   1	254	2	k	int
    //   87	31	3	bool	boolean
    //   13	210	4	localDexClassLoader	DexClassLoader
    //   134	56	5	localRuntime	java.lang.Runtime
    // Exception table:
    //   from	to	target	type
    //   136	179	236	java/lang/NoSuchMethodError
    //   189	233	236	java/lang/NoSuchMethodError
    //   29	88	247	java/lang/Throwable
    //   102	106	247	java/lang/Throwable
    //   110	117	247	java/lang/Throwable
    //   131	136	247	java/lang/Throwable
    //   136	179	247	java/lang/Throwable
    //   189	233	247	java/lang/Throwable
    //   4	15	258	finally
    //   20	25	258	finally
    //   29	88	258	finally
    //   92	97	258	finally
    //   102	106	258	finally
    //   110	117	258	finally
    //   121	126	258	finally
    //   131	136	258	finally
    //   136	179	258	finally
    //   179	184	258	finally
    //   189	233	258	finally
    //   237	242	258	finally
    //   248	253	258	finally
  }
  
  public final void a()
  {
    AppMethodBeat.i(224089);
    g.a(this.c).b();
    AppMethodBeat.o(224089);
  }
  
  public final void a(ModuleUncaughtListener paramModuleUncaughtListener)
  {
    AppMethodBeat.i(224087);
    if (paramModuleUncaughtListener != null)
    {
      this.d = paramModuleUncaughtListener;
      this.i = new n(this.c);
      this.i.a(paramModuleUncaughtListener);
    }
    AppMethodBeat.o(224087);
  }
  
  public final void a(File paramFile)
  {
    AppMethodBeat.i(224088);
    this.e = paramFile;
    if (a.i) {
      g.a(this.c).a(this.e);
    }
    AppMethodBeat.o(224088);
  }
  
  public final DexClassLoader b()
  {
    DexClassLoader localDexClassLoader1 = null;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(224090);
        if (this.b != null)
        {
          localDexClassLoader1 = this.b;
          AppMethodBeat.o(224090);
          return localDexClassLoader1;
        }
        if (this.c == null)
        {
          AppMethodBeat.o(224090);
          continue;
        }
        v.a(this.c).a("load");
      }
      finally {}
      y.a = System.currentTimeMillis();
      if (!this.f.a())
      {
        AppMethodBeat.o(224090);
      }
      else
      {
        if (!this.f.b()) {
          l.a(this.c, t.k);
        }
        this.b = this.g.a();
        this.h.a();
        v.a(this.c).b("load");
        DexClassLoader localDexClassLoader2 = this.b;
        AppMethodBeat.o(224090);
      }
    }
  }
  
  public final File c()
  {
    AppMethodBeat.i(224091);
    File localFile = g.a(this.c).e();
    AppMethodBeat.o(224091);
    return localFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.map.tools.internal.m
 * JD-Core Version:    0.7.0.1
 */