package com.tencent.mm.ci;

import android.os.Debug;
import android.os.Environment;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.a.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public final class d
  implements EventListener
{
  static ak faV;
  public static a ySK;
  public static d ySP;
  private static int ySQ;
  public static final String ySS;
  private volatile boolean fQi;
  private volatile boolean ySR;
  private LinkedBlockingQueue<d.a> yST;
  ExecutorService ySU;
  public WeakReference<d.b> ySV;
  
  static
  {
    AppMethodBeat.i(76920);
    ySQ = 5242880;
    ySS = Environment.getExternalStorageDirectory() + "/tencent/MicroMsg/tracedog/";
    ySK = null;
    faV = new d.2();
    AppMethodBeat.o(76920);
  }
  
  private void NS(int paramInt)
  {
    AppMethodBeat.i(76916);
    this.ySU.execute(new d.3(this, paramInt));
    AppMethodBeat.o(76916);
  }
  
  private static void Y(File paramFile)
  {
    AppMethodBeat.i(76910);
    if (paramFile.isFile())
    {
      paramFile.delete();
      AppMethodBeat.o(76910);
      return;
    }
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      if ((arrayOfFile == null) || (arrayOfFile.length == 0))
      {
        paramFile.delete();
        AppMethodBeat.o(76910);
        return;
      }
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        Y(arrayOfFile[i]);
        i += 1;
      }
      paramFile.delete();
    }
    AppMethodBeat.o(76910);
  }
  
  private static String Z(File paramFile)
  {
    AppMethodBeat.i(76912);
    ArrayList localArrayList = new ArrayList();
    int i;
    if (paramFile.isDirectory())
    {
      ab.i("MicroMsg.TraceDebugManager", "TRACE currentPath is dir");
      paramFile = paramFile.listFiles();
      if (paramFile == null)
      {
        ab.e("MicroMsg.TraceDebugManager", " get file list failed");
        AppMethodBeat.o(76912);
        return null;
      }
      i = 0;
      while (i < paramFile.length)
      {
        localArrayList.add(paramFile[i]);
        i += 1;
      }
    }
    localArrayList.add(paramFile);
    paramFile = new File(ySS + bo.aoy() + ".zip");
    try
    {
      q.a(localArrayList, paramFile);
      i = 0;
      while (i < localArrayList.size())
      {
        ((File)localArrayList.get(i)).delete();
        i += 1;
      }
      if (paramFile.length() <= 3145728L) {
        break label231;
      }
    }
    catch (Exception paramFile)
    {
      ab.e("MicroMsg.TraceDebugManager", "exception:%s", new Object[] { bo.l(paramFile) });
      ab.e("MicroMsg.TraceDebugManager", "zip file failed msg:%s ", new Object[] { paramFile.getMessage() });
      AppMethodBeat.o(76912);
      return null;
    }
    ab.e("MicroMsg.TraceDebugManager", "trace file is too large:%d ", new Object[] { Long.valueOf(paramFile.length()) });
    AppMethodBeat.o(76912);
    return null;
    label231:
    paramFile = paramFile.getAbsolutePath();
    AppMethodBeat.o(76912);
    return paramFile;
  }
  
  private void a(d.a parama)
  {
    AppMethodBeat.i(76908);
    if (this.ySR)
    {
      AppMethodBeat.o(76908);
      return;
    }
    if (!c.Mi())
    {
      ab.i("MicroMsg.TraceDebugManager", "TRACE sdcard is invalid");
      AppMethodBeat.o(76908);
      return;
    }
    dAu();
    for (;;)
    {
      try
      {
        Object localObject = new File(ySS);
        if ((parama.cKk != 6) && (((File)localObject).exists()))
        {
          ab.i("MicroMsg.TraceDebugManager", "TRACE delete all file ");
          Y((File)localObject);
        }
        ((File)localObject).mkdirs();
        localObject = parama.savePath;
        if (parama.ySY > 0) {
          continue;
        }
        i = ySQ;
        Debug.startMethodTracing((String)localObject, i);
        this.ySR = true;
      }
      catch (IncompatibleClassChangeError parama)
      {
        int i;
        ab.printErrStackTrace("MicroMsg.Crash", parama, "May cause dvmFindCatchBlock crash!", new Object[0]);
        parama = (IncompatibleClassChangeError)new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(parama);
        AppMethodBeat.o(76908);
        throw parama;
      }
      catch (Throwable localThrowable)
      {
        this.ySR = false;
        ab.printErrStackTrace("MicroMsg.TraceDebugManager", localThrowable, "TRACE startMethodTracing ERROR", new Object[0]);
        continue;
        if (this.ySR) {
          continue;
        }
        AppMethodBeat.o(76908);
        return;
        Message localMessage = Message.obtain();
        localMessage.what = 0;
        localMessage.obj = parama;
        if ((!bo.isNullOrNil(parama.className)) && (parama.cKk != 5)) {
          continue;
        }
        faV.sendMessageDelayed(localMessage, 15000L);
        AppMethodBeat.o(76908);
        return;
        faV.sendMessageDelayed(localMessage, 10000L);
        AppMethodBeat.o(76908);
      }
      if (parama.cKk != 6) {
        continue;
      }
      ab.i("MicroMsg.TraceDebugManager", "TRACE startTrace uploadType is CLIENT ");
      AppMethodBeat.o(76908);
      return;
      i = parama.ySY;
      i = i * 1024 * 1024;
    }
  }
  
  public static d dAt()
  {
    AppMethodBeat.i(76907);
    if (ySP == null) {
      ySP = new d();
    }
    d locald = ySP;
    AppMethodBeat.o(76907);
    return locald;
  }
  
  private static void dAu()
  {
    AppMethodBeat.i(76909);
    faV.removeMessages(0);
    faV.removeMessages(2);
    faV.removeMessages(1);
    AppMethodBeat.o(76909);
  }
  
  final void ath(String paramString)
  {
    AppMethodBeat.i(76914);
    if (paramString == null)
    {
      AppMethodBeat.o(76914);
      return;
    }
    this.fQi = true;
    if (bo.isNullOrNil(paramString)) {
      ab.e("MicroMsg.TraceDebugManager", "TRACE error uploadPath %s ", new Object[] { paramString });
    }
    for (;;)
    {
      this.fQi = false;
      AppMethodBeat.o(76914);
      return;
      if (!c.Mi())
      {
        ab.e("MicroMsg.TraceDebugManager", "TRACE sdcard invalid.");
      }
      else
      {
        File localFile = new File(paramString);
        if (!localFile.exists())
        {
          ab.e("MicroMsg.TraceDebugManager", "TRACE upload file is not exist");
        }
        else
        {
          if (localFile.isDirectory()) {
            paramString = Z(localFile);
          }
          if ((paramString != null) && (new File(paramString).length() >= 131072L)) {
            if (ySK == null)
            {
              ab.e("MicroMsg.TraceDebugManager", "TRACE upload : no file upload impl set!");
            }
            else
            {
              boolean bool = ySK.WP(paramString);
              ab.i("MicroMsg.TraceDebugManager", "TRACE upload : %b", new Object[] { Boolean.valueOf(bool) });
              if (bool) {
                e.o(new File(ySS));
              }
            }
          }
        }
      }
    }
  }
  
  public final boolean b(final d.a parama)
  {
    AppMethodBeat.i(76911);
    dAu();
    if ((!this.ySR) || (this.fQi))
    {
      ab.i("MicroMsg.TraceDebugManager", "TRACE stopTrace hasStartTrace : %b ,isUploading :%b  ", new Object[] { Boolean.valueOf(this.ySR), Boolean.valueOf(this.fQi) });
      AppMethodBeat.o(76911);
      return false;
    }
    if (!c.Mi())
    {
      ab.i("MicroMsg.TraceDebugManager", "TRACE stopTrace sdcard invalid");
      AppMethodBeat.o(76911);
      return false;
    }
    this.ySU.execute(new Runnable()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: ldc 33
        //   2: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 44	android/os/Debug:stopMethodTracing	()V
        //   8: aload_0
        //   9: getfield 21	com/tencent/mm/ci/d$1:ySW	Lcom/tencent/mm/ci/d$a;
        //   12: getfield 50	com/tencent/mm/ci/d$a:savePath	Ljava/lang/String;
        //   15: astore 4
        //   17: aload_0
        //   18: getfield 21	com/tencent/mm/ci/d$1:ySW	Lcom/tencent/mm/ci/d$a;
        //   21: getfield 54	com/tencent/mm/ci/d$a:ySZ	I
        //   24: istore_1
        //   25: aload_0
        //   26: getfield 21	com/tencent/mm/ci/d$1:ySW	Lcom/tencent/mm/ci/d$a;
        //   29: getfield 50	com/tencent/mm/ci/d$a:savePath	Ljava/lang/String;
        //   32: astore 5
        //   34: aload 5
        //   36: ifnonnull +17 -> 53
        //   39: aload_0
        //   40: getfield 19	com/tencent/mm/ci/d$1:ySX	Lcom/tencent/mm/ci/d;
        //   43: invokestatic 57	com/tencent/mm/ci/d:b	(Lcom/tencent/mm/ci/d;)Z
        //   46: pop
        //   47: ldc 33
        //   49: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   52: return
        //   53: new 62	java/io/File
        //   56: dup
        //   57: aload 4
        //   59: invokespecial 65	java/io/File:<init>	(Ljava/lang/String;)V
        //   62: astore 5
        //   64: new 62	java/io/File
        //   67: dup
        //   68: new 67	java/lang/StringBuilder
        //   71: dup
        //   72: invokespecial 68	java/lang/StringBuilder:<init>	()V
        //   75: aload 4
        //   77: iconst_0
        //   78: aload 4
        //   80: bipush 46
        //   82: invokevirtual 74	java/lang/String:lastIndexOf	(I)I
        //   85: invokevirtual 78	java/lang/String:substring	(II)Ljava/lang/String;
        //   88: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   91: ldc 84
        //   93: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   96: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   99: invokespecial 65	java/io/File:<init>	(Ljava/lang/String;)V
        //   102: astore 4
        //   104: invokestatic 94	java/lang/System:currentTimeMillis	()J
        //   107: lstore_2
        //   108: aload 5
        //   110: aload 4
        //   112: invokevirtual 98	java/io/File:renameTo	(Ljava/io/File;)Z
        //   115: pop
        //   116: aload 5
        //   118: invokevirtual 102	java/io/File:delete	()Z
        //   121: pop
        //   122: ldc 104
        //   124: new 67	java/lang/StringBuilder
        //   127: dup
        //   128: ldc 106
        //   130: invokespecial 107	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   133: invokestatic 94	java/lang/System:currentTimeMillis	()J
        //   136: lload_2
        //   137: lsub
        //   138: invokevirtual 110	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
        //   141: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   144: invokestatic 115	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   147: bipush 10
        //   149: invokestatic 120	android/os/Process:setThreadPriority	(I)V
        //   152: aload_0
        //   153: getfield 21	com/tencent/mm/ci/d$1:ySW	Lcom/tencent/mm/ci/d$a;
        //   156: getfield 123	com/tencent/mm/ci/d$a:cKk	I
        //   159: bipush 6
        //   161: if_icmpne +135 -> 296
        //   164: new 125	java/util/ArrayList
        //   167: dup
        //   168: invokespecial 126	java/util/ArrayList:<init>	()V
        //   171: astore 5
        //   173: aload 5
        //   175: aload 4
        //   177: invokevirtual 130	java/util/ArrayList:add	(Ljava/lang/Object;)Z
        //   180: pop
        //   181: new 62	java/io/File
        //   184: dup
        //   185: new 67	java/lang/StringBuilder
        //   188: dup
        //   189: invokespecial 68	java/lang/StringBuilder:<init>	()V
        //   192: aload 4
        //   194: invokevirtual 133	java/io/File:getAbsolutePath	()Ljava/lang/String;
        //   197: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   200: ldc 135
        //   202: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   205: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   208: invokespecial 65	java/io/File:<init>	(Ljava/lang/String;)V
        //   211: astore 4
        //   213: aload 5
        //   215: aload 4
        //   217: invokestatic 141	com/tencent/mm/a/q:a	(Ljava/util/Collection;Ljava/io/File;)V
        //   220: getstatic 145	com/tencent/mm/ci/d:faV	Lcom/tencent/mm/sdk/platformtools/ak;
        //   223: iconst_1
        //   224: invokevirtual 151	com/tencent/mm/sdk/platformtools/ak:sendEmptyMessage	(I)Z
        //   227: pop
        //   228: aload_0
        //   229: getfield 19	com/tencent/mm/ci/d$1:ySX	Lcom/tencent/mm/ci/d;
        //   232: invokestatic 57	com/tencent/mm/ci/d:b	(Lcom/tencent/mm/ci/d;)Z
        //   235: pop
        //   236: ldc 33
        //   238: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   241: return
        //   242: astore 4
        //   244: ldc 104
        //   246: ldc 153
        //   248: iconst_1
        //   249: anewarray 4	java/lang/Object
        //   252: dup
        //   253: iconst_0
        //   254: aload 4
        //   256: invokestatic 159	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
        //   259: aastore
        //   260: invokestatic 163	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   263: ldc 104
        //   265: ldc 165
        //   267: iconst_1
        //   268: anewarray 4	java/lang/Object
        //   271: dup
        //   272: iconst_0
        //   273: aload 4
        //   275: invokevirtual 168	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   278: aastore
        //   279: invokestatic 163	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   282: aload_0
        //   283: getfield 19	com/tencent/mm/ci/d$1:ySX	Lcom/tencent/mm/ci/d;
        //   286: invokestatic 57	com/tencent/mm/ci/d:b	(Lcom/tencent/mm/ci/d;)Z
        //   289: pop
        //   290: ldc 33
        //   292: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   295: return
        //   296: aload_0
        //   297: getfield 19	com/tencent/mm/ci/d$1:ySX	Lcom/tencent/mm/ci/d;
        //   300: invokestatic 171	com/tencent/mm/ci/d:a	(Lcom/tencent/mm/ci/d;)Ljava/util/concurrent/LinkedBlockingQueue;
        //   303: ifnull +16 -> 319
        //   306: aload_0
        //   307: getfield 19	com/tencent/mm/ci/d$1:ySX	Lcom/tencent/mm/ci/d;
        //   310: invokestatic 171	com/tencent/mm/ci/d:a	(Lcom/tencent/mm/ci/d;)Ljava/util/concurrent/LinkedBlockingQueue;
        //   313: invokevirtual 177	java/util/concurrent/LinkedBlockingQueue:size	()I
        //   316: ifne +50 -> 366
        //   319: aload 4
        //   321: invokestatic 181	com/tencent/mm/ci/d:aa	(Ljava/io/File;)Ljava/lang/String;
        //   324: astore 4
        //   326: aload 4
        //   328: invokestatic 185	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
        //   331: ifne +35 -> 366
        //   334: aload_0
        //   335: getfield 19	com/tencent/mm/ci/d$1:ySX	Lcom/tencent/mm/ci/d;
        //   338: astore 5
        //   340: iload_1
        //   341: iconst_1
        //   342: if_icmpeq +17 -> 359
        //   345: iload_1
        //   346: iconst_3
        //   347: if_icmpne +19 -> 366
        //   350: invokestatic 191	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
        //   353: invokestatic 197	com/tencent/mm/sdk/platformtools/at:isWifi	(Landroid/content/Context;)Z
        //   356: ifeq +10 -> 366
        //   359: aload 5
        //   361: aload 4
        //   363: invokevirtual 200	com/tencent/mm/ci/d:ath	(Ljava/lang/String;)V
        //   366: aload_0
        //   367: getfield 19	com/tencent/mm/ci/d$1:ySX	Lcom/tencent/mm/ci/d;
        //   370: invokestatic 57	com/tencent/mm/ci/d:b	(Lcom/tencent/mm/ci/d;)Z
        //   373: pop
        //   374: ldc 33
        //   376: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   379: return
        //   380: astore 4
        //   382: ldc 202
        //   384: aload 4
        //   386: ldc 204
        //   388: iconst_0
        //   389: anewarray 4	java/lang/Object
        //   392: invokestatic 208	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   395: new 28	java/lang/IncompatibleClassChangeError
        //   398: dup
        //   399: ldc 204
        //   401: invokespecial 209	java/lang/IncompatibleClassChangeError:<init>	(Ljava/lang/String;)V
        //   404: aload 4
        //   406: invokevirtual 213	java/lang/IncompatibleClassChangeError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
        //   409: checkcast 28	java/lang/IncompatibleClassChangeError
        //   412: checkcast 28	java/lang/IncompatibleClassChangeError
        //   415: astore 4
        //   417: ldc 33
        //   419: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   422: aload 4
        //   424: athrow
        //   425: astore 4
        //   427: aload_0
        //   428: getfield 19	com/tencent/mm/ci/d$1:ySX	Lcom/tencent/mm/ci/d;
        //   431: invokestatic 57	com/tencent/mm/ci/d:b	(Lcom/tencent/mm/ci/d;)Z
        //   434: pop
        //   435: ldc 33
        //   437: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   440: aload 4
        //   442: athrow
        //   443: astore 4
        //   445: ldc 104
        //   447: aload 4
        //   449: ldc 215
        //   451: iconst_0
        //   452: anewarray 4	java/lang/Object
        //   455: invokestatic 208	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   458: aload_0
        //   459: getfield 19	com/tencent/mm/ci/d$1:ySX	Lcom/tencent/mm/ci/d;
        //   462: invokestatic 57	com/tencent/mm/ci/d:b	(Lcom/tencent/mm/ci/d;)Z
        //   465: pop
        //   466: ldc 33
        //   468: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   471: return
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	472	0	this	1
        //   24	324	1	i	int
        //   107	30	2	l	long
        //   15	201	4	localObject1	Object
        //   242	78	4	localException	Exception
        //   324	38	4	str	String
        //   380	25	4	localIncompatibleClassChangeError1	IncompatibleClassChangeError
        //   415	8	4	localIncompatibleClassChangeError2	IncompatibleClassChangeError
        //   425	16	4	localObject2	Object
        //   443	5	4	localThrowable	Throwable
        //   32	328	5	localObject3	Object
        // Exception table:
        //   from	to	target	type
        //   213	220	242	java/lang/Exception
        //   5	34	380	java/lang/IncompatibleClassChangeError
        //   53	213	380	java/lang/IncompatibleClassChangeError
        //   213	220	380	java/lang/IncompatibleClassChangeError
        //   220	228	380	java/lang/IncompatibleClassChangeError
        //   244	282	380	java/lang/IncompatibleClassChangeError
        //   296	319	380	java/lang/IncompatibleClassChangeError
        //   319	340	380	java/lang/IncompatibleClassChangeError
        //   350	359	380	java/lang/IncompatibleClassChangeError
        //   359	366	380	java/lang/IncompatibleClassChangeError
        //   5	34	425	finally
        //   53	213	425	finally
        //   213	220	425	finally
        //   220	228	425	finally
        //   244	282	425	finally
        //   296	319	425	finally
        //   319	340	425	finally
        //   350	359	425	finally
        //   359	366	425	finally
        //   382	425	425	finally
        //   445	458	425	finally
        //   5	34	443	java/lang/Throwable
        //   53	213	443	java/lang/Throwable
        //   213	220	443	java/lang/Throwable
        //   220	228	443	java/lang/Throwable
        //   244	282	443	java/lang/Throwable
        //   296	319	443	java/lang/Throwable
        //   319	340	443	java/lang/Throwable
        //   350	359	443	java/lang/Throwable
        //   359	366	443	java/lang/Throwable
      }
    });
    AppMethodBeat.o(76911);
    return true;
  }
  
  public final void c(d.a parama)
  {
    AppMethodBeat.i(76915);
    if (parama.cKk <= 0)
    {
      AppMethodBeat.o(76915);
      return;
    }
    if (this.ySU == null) {
      this.ySU = Executors.newSingleThreadExecutor();
    }
    if ((this.fQi) || (this.ySR))
    {
      ab.i("MicroMsg.TraceDebugManager", "TRACE isUloading or hasStartTrace %b %b", new Object[] { Boolean.valueOf(this.fQi), Boolean.valueOf(this.ySR) });
      AppMethodBeat.o(76915);
      return;
    }
    faV.removeMessages(0);
    if ((parama.ySZ == 4) || (parama.ySZ == 5)) {
      NS(parama.ySZ);
    }
    for (;;)
    {
      ab.i("MicroMsg.TraceDebugManager", "TRACE PUSH : class : %s  code :%s type :%s", new Object[] { parama.className, Integer.valueOf(parama.cKk), Integer.valueOf(parama.ySZ) });
      AppMethodBeat.o(76915);
      return;
      if ((parama.cKk == 6) || (parama.cKk == 5))
      {
        Message localMessage = Message.obtain();
        localMessage.what = 2;
        localMessage.obj = parama;
        if (parama.cKk == 5) {
          faV.sendMessage(localMessage);
        } else {
          faV.sendMessageDelayed(localMessage, 500L);
        }
      }
      else
      {
        if (this.yST == null) {
          this.yST = new LinkedBlockingQueue();
        }
        this.yST.clear();
        this.yST.add(parama);
      }
    }
  }
  
  public final void eJ(String paramString, int paramInt)
  {
    AppMethodBeat.i(76913);
    if ((this.yST != null) && (this.yST.size() > 0))
    {
      ab.i("MicroMsg.TraceDebugManager", "TRACE gatherData : isUploading : %b  hasStart :%b currentClass : %s currentCode %d ", new Object[] { Boolean.valueOf(this.fQi), Boolean.valueOf(this.ySR), paramString, Integer.valueOf(paramInt) });
      if ((!this.fQi) && (!this.ySR))
      {
        Iterator localIterator = this.yST.iterator();
        while (localIterator.hasNext())
        {
          d.a locala = (d.a)localIterator.next();
          if (locala.className != null)
          {
            if ((locala.className.equals(paramString)) && (locala.cKk == paramInt))
            {
              a(locala);
              this.yST.remove(locala);
              AppMethodBeat.o(76913);
            }
          }
          else
          {
            a(null);
            this.yST.remove(locala);
            AppMethodBeat.o(76913);
            return;
          }
        }
      }
    }
    AppMethodBeat.o(76913);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ci.d
 * JD-Core Version:    0.7.0.1
 */