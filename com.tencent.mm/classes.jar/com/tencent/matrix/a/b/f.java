package com.tencent.matrix.a.b;

import android.os.Environment;
import android.os.SystemClock;
import com.tencent.c.a.a.a;
import com.tencent.matrix.report.d.a;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
  extends com.tencent.matrix.report.d
{
  final a cuA;
  final Runnable cuB;
  final e cuC;
  final Map<String, d> cuv = new HashMap();
  final Map<String, c> cuw = new HashMap();
  final int cux;
  private final int cuy;
  private final int cuz;
  
  public f(d.a parama, com.tencent.matrix.a.a.a parama1, a parama2)
  {
    super(parama);
    this.cux = parama1.cty.get(a.a.Ihu.name(), 120000);
    this.cuy = parama1.cty.get(a.a.Ihw.name(), 600000);
    this.cuz = parama1.cty.get(a.a.Ihv.name(), 20);
    this.cuA = parama2;
    this.cuB = new Runnable()
    {
      public final void run()
      {
        Iterator localIterator = f.this.cuw.entrySet().iterator();
        while (localIterator.hasNext()) {
          ((f.c)((Map.Entry)localIterator.next()).getValue()).GW();
        }
        f.a(f.this);
      }
    };
    if (parama1.GO())
    {
      this.cuC = new e();
      return;
    }
    this.cuC = null;
  }
  
  private void GU()
  {
    Iterator localIterator = this.cuv.entrySet().iterator();
    long l = SystemClock.uptimeMillis();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        d locald = (d)((Map.Entry)localIterator.next()).getValue();
        if (l - locald.cuQ >= this.cux)
        {
          String str = String.format("%s:%d", new Object[] { locald.tag, Integer.valueOf(1) });
          if (cX(str))
          {
            com.tencent.matrix.g.c.v("Matrix.WakeLockDetector", "detectWakeLockOnceHoldTime issue already published: %s", new Object[] { str });
          }
          else
          {
            com.tencent.matrix.report.c localc = new com.tencent.matrix.report.c(1);
            localc.key = str;
            JSONObject localJSONObject = new JSONObject();
            try
            {
              localJSONObject.put("subTag", "wakeLock");
              localJSONObject.put("wakeLockTag", locald.tag);
              localJSONObject.put("flags", locald.flags);
              localJSONObject.put("holdTime", l - locald.cuQ);
              localJSONObject.put("stackHistory", locald.cuK);
              com.tencent.matrix.g.c.i("Matrix.WakeLockDetector", "detected lock once too long, token:%s, tag:%s", new Object[] { locald.cuO, locald.tag });
              localc.cwV = localJSONObject;
              b(localc);
              cW(str);
            }
            catch (JSONException localJSONException)
            {
              for (;;)
              {
                com.tencent.matrix.g.c.e("Matrix.WakeLockDetector", "json content error: %s", new Object[] { localJSONException });
              }
            }
          }
        }
      }
    }
  }
  
  private void GV()
  {
    Iterator localIterator = this.cuw.entrySet().iterator();
    long l1 = System.currentTimeMillis();
    while (localIterator.hasNext())
    {
      Object localObject1 = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject1).getKey();
      localObject1 = (c)((Map.Entry)localObject1).getValue();
      long l2 = l1 - ((c)localObject1).cuF;
      int j = (int)(l2 / 3600000L) + 1;
      int i = j;
      if (j <= 0) {
        i = 1;
      }
      j = ((c)localObject1).cuJ / i;
      long l3 = ((c)localObject1).cuH / i;
      if (j > this.cuz / 2)
      {
        localObject2 = String.format("%s:%d", new Object[] { str, Integer.valueOf(2) });
        if (!cX((String)localObject2)) {
          break label233;
        }
        com.tencent.matrix.g.c.v("Matrix.WakeLockDetector", "detectWakeLockAggregation issue already published: %s", new Object[] { localObject2 });
      }
      for (;;)
      {
        if (l3 < this.cuy) {
          break label275;
        }
        str = String.format("%s:%d", new Object[] { str, Integer.valueOf(3) });
        if (!cX(str)) {
          break label277;
        }
        com.tencent.matrix.g.c.v("Matrix.WakeLockDetector", "detectWakeLockAggregation issue already published: %s", new Object[] { str });
        break;
        label233:
        com.tencent.matrix.report.c localc = new com.tencent.matrix.report.c(2);
        localc.key = ((String)localObject2);
        localc.cwV = a((c)localObject1, l2);
        b(localc);
        cW((String)localObject2);
      }
      label275:
      continue;
      label277:
      Object localObject2 = new com.tencent.matrix.report.c(3);
      ((com.tencent.matrix.report.c)localObject2).key = str;
      ((com.tencent.matrix.report.c)localObject2).cwV = a((c)localObject1, l2);
      b((com.tencent.matrix.report.c)localObject2);
      cW(str);
    }
  }
  
  private static JSONObject a(c paramc, long paramLong)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("wakeLockTag", paramc.tag);
      localJSONObject.put("subTag", "wakeLock");
      localJSONObject.put("timeFrame", paramLong);
      localJSONObject.put("acquireCnt", paramc.cuI);
      localJSONObject.put("acquireCntWhenScreenOff", paramc.cuJ);
      localJSONObject.put("statisticalHoldTime", paramc.cuG);
      localJSONObject.put("stackHistory", paramc.cuK);
      return localJSONObject;
    }
    catch (JSONException paramc)
    {
      com.tencent.matrix.g.c.e("Matrix.WakeLockDetector", "json content error: %s", new Object[] { paramc });
    }
    return localJSONObject;
  }
  
  final void GT()
  {
    GU();
    GV();
  }
  
  public static abstract interface a
  {
    public abstract void d(Runnable paramRunnable, long paramLong);
    
    public abstract boolean isScreenOn();
  }
  
  static final class b
  {
    final Vector<String> cuE = new Vector();
    
    final void cU(String paramString)
    {
      this.cuE.add(paramString);
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while (i < this.cuE.size())
      {
        localStringBuilder.append((String)this.cuE.get(i)).append("\t\t");
        i += 1;
      }
      return localStringBuilder.toString();
    }
  }
  
  static final class c
  {
    final long cuF;
    long cuG;
    long cuH;
    int cuI;
    int cuJ;
    f.b cuK;
    final Map<String, Boolean> cuL;
    long cuM;
    boolean cuN;
    final String tag;
    
    c(String paramString)
    {
      this.tag = paramString;
      this.cuG = 0L;
      this.cuH = 0L;
      this.cuI = 0;
      this.cuJ = 0;
      this.cuM = -1L;
      this.cuK = new f.b();
      this.cuF = System.currentTimeMillis();
      this.cuL = new HashMap();
    }
    
    final void GW()
    {
      if (this.cuM < 0L) {
        return;
      }
      long l = SystemClock.uptimeMillis();
      this.cuG += l - this.cuM;
      if (!this.cuN) {
        this.cuH += l - this.cuM;
      }
      this.cuM = l;
    }
  }
  
  static final class d
  {
    f.b cuK;
    final String cuO;
    final long cuP;
    final long cuQ;
    final int flags;
    final String tag;
    
    d(String paramString1, String paramString2, int paramInt, long paramLong)
    {
      this.cuO = paramString1;
      this.tag = paramString2;
      this.flags = paramInt;
      this.cuP = paramLong;
      this.cuQ = SystemClock.uptimeMillis();
      this.cuK = new f.b();
    }
  }
  
  static final class e
  {
    private final String ctL;
    int cuR;
    final StringBuilder cuS;
    
    e()
    {
      String str = com.tencent.matrix.g.d.formatTime("yyyy-MM-dd", System.currentTimeMillis());
      this.ctL = String.format("%s/com.tencent.matrix/wakelock-detector-record/%s/wakelocks-%s", new Object[] { Environment.getExternalStorageDirectory().getAbsolutePath(), com.tencent.matrix.a.d.a.getPackageName(), str });
      this.cuS = new StringBuilder();
      com.tencent.matrix.g.c.i("Matrix.WakeLockDetector", "WakeLockInfoRecorder path:%s", new Object[] { this.ctL });
    }
    
    /* Error */
    private void GY()
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 4
      //   3: aconst_null
      //   4: astore_2
      //   5: aconst_null
      //   6: astore_3
      //   7: aload_2
      //   8: astore_1
      //   9: new 41	java/io/File
      //   12: dup
      //   13: aload_0
      //   14: getfield 58	com/tencent/matrix/a/b/f$e:ctL	Ljava/lang/String;
      //   17: invokespecial 82	java/io/File:<init>	(Ljava/lang/String;)V
      //   20: astore 5
      //   22: aload_2
      //   23: astore_1
      //   24: aload 5
      //   26: invokevirtual 85	java/io/File:getParentFile	()Ljava/io/File;
      //   29: invokevirtual 89	java/io/File:mkdirs	()Z
      //   32: ifne +30 -> 62
      //   35: aload_2
      //   36: astore_1
      //   37: aload 5
      //   39: invokevirtual 85	java/io/File:getParentFile	()Ljava/io/File;
      //   42: invokevirtual 92	java/io/File:exists	()Z
      //   45: ifne +17 -> 62
      //   48: aload_2
      //   49: astore_1
      //   50: ldc 65
      //   52: ldc 94
      //   54: iconst_0
      //   55: anewarray 4	java/lang/Object
      //   58: invokestatic 96	com/tencent/matrix/g/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   61: return
      //   62: aload_2
      //   63: astore_1
      //   64: new 98	java/io/BufferedWriter
      //   67: dup
      //   68: new 100	java/io/OutputStreamWriter
      //   71: dup
      //   72: new 102	java/io/FileOutputStream
      //   75: dup
      //   76: aload 5
      //   78: iconst_1
      //   79: invokespecial 105	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
      //   82: invokespecial 108	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
      //   85: invokespecial 111	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
      //   88: astore_2
      //   89: aload_0
      //   90: getfield 63	com/tencent/matrix/a/b/f$e:cuS	Ljava/lang/StringBuilder;
      //   93: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   96: astore_1
      //   97: aload_2
      //   98: aload_1
      //   99: iconst_0
      //   100: aload_1
      //   101: invokevirtual 118	java/lang/String:length	()I
      //   104: invokevirtual 122	java/io/BufferedWriter:write	(Ljava/lang/String;II)V
      //   107: aload_2
      //   108: invokevirtual 125	java/io/BufferedWriter:flush	()V
      //   111: aload_2
      //   112: invokevirtual 128	java/io/BufferedWriter:close	()V
      //   115: return
      //   116: astore_1
      //   117: return
      //   118: astore_1
      //   119: aload_3
      //   120: astore_2
      //   121: aload_1
      //   122: astore_3
      //   123: aload_2
      //   124: astore_1
      //   125: ldc 65
      //   127: ldc 130
      //   129: iconst_1
      //   130: anewarray 4	java/lang/Object
      //   133: dup
      //   134: iconst_0
      //   135: aload_3
      //   136: invokevirtual 133	java/io/FileNotFoundException:getLocalizedMessage	()Ljava/lang/String;
      //   139: aastore
      //   140: invokestatic 136	com/tencent/matrix/g/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   143: aload_2
      //   144: ifnull +76 -> 220
      //   147: aload_2
      //   148: invokevirtual 128	java/io/BufferedWriter:close	()V
      //   151: return
      //   152: astore_1
      //   153: return
      //   154: astore_3
      //   155: aload 4
      //   157: astore_2
      //   158: aload_2
      //   159: astore_1
      //   160: ldc 65
      //   162: ldc 130
      //   164: iconst_1
      //   165: anewarray 4	java/lang/Object
      //   168: dup
      //   169: iconst_0
      //   170: aload_3
      //   171: invokevirtual 137	java/io/IOException:getLocalizedMessage	()Ljava/lang/String;
      //   174: aastore
      //   175: invokestatic 136	com/tencent/matrix/g/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   178: aload_2
      //   179: ifnull +41 -> 220
      //   182: aload_2
      //   183: invokevirtual 128	java/io/BufferedWriter:close	()V
      //   186: return
      //   187: astore_1
      //   188: return
      //   189: astore_3
      //   190: aload_1
      //   191: astore_2
      //   192: aload_3
      //   193: astore_1
      //   194: aload_2
      //   195: ifnull +7 -> 202
      //   198: aload_2
      //   199: invokevirtual 128	java/io/BufferedWriter:close	()V
      //   202: aload_1
      //   203: athrow
      //   204: astore_2
      //   205: goto -3 -> 202
      //   208: astore_1
      //   209: goto -15 -> 194
      //   212: astore_3
      //   213: goto -55 -> 158
      //   216: astore_3
      //   217: goto -94 -> 123
      //   220: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	221	0	this	e
      //   8	93	1	localObject1	Object
      //   116	1	1	localIOException1	java.io.IOException
      //   118	4	1	localFileNotFoundException1	java.io.FileNotFoundException
      //   124	1	1	localObject2	Object
      //   152	1	1	localIOException2	java.io.IOException
      //   159	1	1	localObject3	Object
      //   187	4	1	localIOException3	java.io.IOException
      //   193	10	1	localObject4	Object
      //   208	1	1	localObject5	Object
      //   4	195	2	localObject6	Object
      //   204	1	2	localIOException4	java.io.IOException
      //   6	130	3	localObject7	Object
      //   154	17	3	localIOException5	java.io.IOException
      //   189	4	3	localObject8	Object
      //   212	1	3	localIOException6	java.io.IOException
      //   216	1	3	localFileNotFoundException2	java.io.FileNotFoundException
      //   1	155	4	localObject9	Object
      //   20	57	5	localFile	File
      // Exception table:
      //   from	to	target	type
      //   111	115	116	java/io/IOException
      //   9	22	118	java/io/FileNotFoundException
      //   24	35	118	java/io/FileNotFoundException
      //   37	48	118	java/io/FileNotFoundException
      //   50	61	118	java/io/FileNotFoundException
      //   64	89	118	java/io/FileNotFoundException
      //   147	151	152	java/io/IOException
      //   9	22	154	java/io/IOException
      //   24	35	154	java/io/IOException
      //   37	48	154	java/io/IOException
      //   50	61	154	java/io/IOException
      //   64	89	154	java/io/IOException
      //   182	186	187	java/io/IOException
      //   9	22	189	finally
      //   24	35	189	finally
      //   37	48	189	finally
      //   50	61	189	finally
      //   64	89	189	finally
      //   125	143	189	finally
      //   160	178	189	finally
      //   198	202	204	java/io/IOException
      //   89	111	208	finally
      //   89	111	212	java/io/IOException
      //   89	111	216	java/io/FileNotFoundException
    }
    
    final void GX()
    {
      if (this.cuR >= 10)
      {
        GY();
        this.cuR = 0;
        this.cuS.delete(0, this.cuS.length());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.a.b.f
 * JD-Core Version:    0.7.0.1
 */