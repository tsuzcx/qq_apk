package com.tencent.matrix.a.c.a;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.matrix.a.c.a.b;
import com.tencent.matrix.a.c.a.c;
import com.tencent.matrix.g.c;
import com.tencent.matrix.g.d;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
  implements Handler.Callback, a
{
  private static boolean csi;
  private static long csp;
  private static long csq = 900000L;
  private static byte[] sBuffer = new byte[2048];
  private c csr = null;
  private com.tencent.matrix.a.c.a css;
  private b cst = new b((byte)0);
  private Handler handler;
  
  private static void a(String paramString, d paramd)
  {
    int i2 = e(paramString, sBuffer);
    int n = 0;
    int i = 0;
    for (;;)
    {
      int j;
      if (i < i2)
      {
        if (Character.isSpaceChar(sBuffer[i]))
        {
          n += 1;
          i += 1;
        }
        else
        {
          int k;
          switch (n)
          {
          default: 
            i += 1;
            break;
          case 1: 
            k = 0;
            j = i;
            while ((j < i2) && (!Character.isSpaceChar(sBuffer[j])))
            {
              j += 1;
              k += 1;
            }
            int m = k;
            int i1 = i;
            if (40 == sBuffer[i])
            {
              i1 = i + 1;
              m = k - 1;
            }
            i = m;
            if (41 == sBuffer[(i1 + m - 1)]) {
              i = m - 1;
            }
            if (i <= 0) {
              break label284;
            }
            paramd.name = new String(sBuffer, i1, i);
            i = j;
            break;
          case 13: 
          case 14: 
          case 15: 
          case 16: 
            k = 0;
            j = i;
            while ((j < i2) && (!Character.isSpaceChar(sBuffer[j])))
            {
              j += 1;
              k += 1;
            }
            paramString = new String(sBuffer, i, k);
            paramd.csC += d.dk(paramString);
            i = j;
            break;
          }
        }
      }
      else
      {
        return;
        label284:
        i = j;
      }
    }
  }
  
  private static int e(String paramString, byte[] paramArrayOfByte)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      return -1;
    }
    for (;;)
    {
      try
      {
        localFileInputStream = new FileInputStream(paramString);
        paramString = null;
      }
      catch (IOException paramString)
      {
        try
        {
          FileInputStream localFileInputStream;
          localFileInputStream.close();
          throw paramArrayOfByte;
          paramString = paramString;
          c.printErrStackTrace("Matrix.JiffiesMonitorPlugin", paramString, "", new Object[0]);
          int i = -1;
        }
        catch (Throwable localThrowable)
        {
          paramString.addSuppressed(localThrowable);
          continue;
        }
        localThrowable.close();
        continue;
      }
      try
      {
        i = localFileInputStream.read(paramArrayOfByte);
        localFileInputStream.close();
        return i;
      }
      catch (Throwable paramArrayOfByte)
      {
        paramString = paramArrayOfByte;
        throw paramArrayOfByte;
      }
      finally
      {
        if (paramString == null) {}
      }
    }
  }
  
  /* Error */
  private java.util.Set<d> gQ(int paramInt)
  {
    // Byte code:
    //   0: new 135	java/util/HashSet
    //   3: dup
    //   4: invokespecial 136	java/util/HashSet:<init>	()V
    //   7: astore 7
    //   9: ldc 138
    //   11: iconst_1
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: iload_1
    //   18: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   21: aastore
    //   22: invokestatic 148	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   25: astore 5
    //   27: new 96	java/io/File
    //   30: dup
    //   31: aload 5
    //   33: invokespecial 99	java/io/File:<init>	(Ljava/lang/String;)V
    //   36: astore 4
    //   38: aload 4
    //   40: invokevirtual 151	java/io/File:isDirectory	()Z
    //   43: ifeq +15 -> 58
    //   46: aload 4
    //   48: invokevirtual 155	java/io/File:listFiles	()[Ljava/io/File;
    //   51: astore 6
    //   53: aload 6
    //   55: ifnonnull +6 -> 61
    //   58: aload 7
    //   60: areturn
    //   61: aload 6
    //   63: arraylength
    //   64: istore_3
    //   65: iconst_0
    //   66: istore_2
    //   67: iload_2
    //   68: iload_3
    //   69: if_icmpge -11 -> 58
    //   72: aload 6
    //   74: iload_2
    //   75: aaload
    //   76: astore 8
    //   78: aload 8
    //   80: invokevirtual 151	java/io/File:isDirectory	()Z
    //   83: ifeq +85 -> 168
    //   86: new 19	com/tencent/matrix/a/c/a/b$d
    //   89: dup
    //   90: aload_0
    //   91: invokespecial 158	com/tencent/matrix/a/c/a/b$d:<init>	(Lcom/tencent/matrix/a/c/a/b;)V
    //   94: astore 4
    //   96: aload 4
    //   98: aload 8
    //   100: invokevirtual 162	java/io/File:getName	()Ljava/lang/String;
    //   103: invokestatic 166	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   106: putfield 170	com/tencent/matrix/a/c/a/b$d:tid	I
    //   109: new 172	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   116: aload 5
    //   118: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: aload 8
    //   123: invokevirtual 162	java/io/File:getName	()Ljava/lang/String;
    //   126: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: ldc 179
    //   131: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: aload 4
    //   139: invokestatic 184	com/tencent/matrix/a/c/a/b:a	(Ljava/lang/String;Lcom/tencent/matrix/a/c/a/b$d;)V
    //   142: aload 4
    //   144: getfield 170	com/tencent/matrix/a/c/a/b$d:tid	I
    //   147: iload_1
    //   148: if_icmpne +27 -> 175
    //   151: aload 4
    //   153: ldc 186
    //   155: putfield 81	com/tencent/matrix/a/c/a/b$d:name	Ljava/lang/String;
    //   158: aload 7
    //   160: aload 4
    //   162: invokeinterface 192 2 0
    //   167: pop
    //   168: iload_2
    //   169: iconst_1
    //   170: iadd
    //   171: istore_2
    //   172: goto -105 -> 67
    //   175: aload 4
    //   177: getfield 81	com/tencent/matrix/a/c/a/b$d:name	Ljava/lang/String;
    //   180: invokestatic 198	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   183: ifeq -25 -> 158
    //   186: aload 4
    //   188: ldc 200
    //   190: putfield 81	com/tencent/matrix/a/c/a/b$d:name	Ljava/lang/String;
    //   193: goto -35 -> 158
    //   196: astore 8
    //   198: aload 4
    //   200: ifnull -32 -> 168
    //   203: aload 7
    //   205: aload 4
    //   207: invokeinterface 192 2 0
    //   212: pop
    //   213: goto -45 -> 168
    //   216: astore 4
    //   218: aconst_null
    //   219: astore 5
    //   221: aload 5
    //   223: ifnull +13 -> 236
    //   226: aload 7
    //   228: aload 5
    //   230: invokeinterface 192 2 0
    //   235: pop
    //   236: aload 4
    //   238: athrow
    //   239: astore 5
    //   241: aload 4
    //   243: astore 6
    //   245: aload 5
    //   247: astore 4
    //   249: aload 6
    //   251: astore 5
    //   253: goto -32 -> 221
    //   256: astore 4
    //   258: aconst_null
    //   259: astore 4
    //   261: goto -63 -> 198
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	this	b
    //   0	264	1	paramInt	int
    //   66	106	2	i	int
    //   64	6	3	j	int
    //   36	170	4	localObject1	Object
    //   216	26	4	localObject2	Object
    //   247	1	4	localObject3	Object
    //   256	1	4	localException1	java.lang.Exception
    //   259	1	4	localObject4	Object
    //   25	204	5	str	String
    //   239	7	5	localObject5	Object
    //   251	1	5	localObject6	Object
    //   51	199	6	localObject7	Object
    //   7	220	7	localHashSet	java.util.HashSet
    //   76	46	8	localObject8	Object
    //   196	1	8	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   96	158	196	java/lang/Exception
    //   175	193	196	java/lang/Exception
    //   86	96	216	finally
    //   96	158	239	finally
    //   175	193	239	finally
    //   86	96	256	java/lang/Exception
  }
  
  public final void GN() {}
  
  public final void GO()
  {
    this.handler.removeCallbacksAndMessages(null);
  }
  
  public final int GP()
  {
    return 2147483647;
  }
  
  public final void a(com.tencent.matrix.a.c.a parama)
  {
    this.css = parama;
    this.handler = new Handler(com.tencent.matrix.g.b.HY().getLooper(), this);
    csp = parama.csc.csg;
    csq = parama.csc.csh;
    csi = parama.csc.csi;
  }
  
  public final void bT(boolean paramBoolean)
  {
    if (!com.tencent.matrix.b.Gp()) {
      c.e("Matrix.JiffiesMonitorPlugin", "Matrix was not installed yet, just ignore the event", new Object[0]);
    }
    label132:
    for (;;)
    {
      return;
      Message localMessage;
      if (!paramBoolean)
      {
        this.handler.removeCallbacksAndMessages(null);
        localMessage = Message.obtain(this.handler);
        localMessage.what = 1;
        this.handler.sendMessageDelayed(localMessage, csp);
      }
      for (;;)
      {
        if (!paramBoolean) {
          break label132;
        }
        this.handler.removeCallbacks(this.cst);
        if (!csi) {
          break;
        }
        this.cst.csy = 1;
        this.handler.post(this.cst);
        return;
        if (!this.handler.hasMessages(1))
        {
          localMessage = Message.obtain(this.handler);
          localMessage.what = 2;
          this.handler.sendMessageAtFrontOfQueue(localMessage);
        }
      }
    }
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    Object localObject1;
    if (paramMessage.what == 1)
    {
      localObject1 = new c((byte)0);
      ((c)localObject1).pid = Process.myPid();
      if (com.tencent.matrix.b.Gp()) {}
      for (paramMessage = d.getProcessName(com.tencent.matrix.b.Gq().application);; paramMessage = "default")
      {
        ((c)localObject1).name = paramMessage;
        ((c)localObject1).csB.addAll(gQ(((c)localObject1).pid));
        ((c)localObject1).csA = SystemClock.uptimeMillis();
        ((c)localObject1).time = System.currentTimeMillis();
        this.csr = ((c)localObject1);
        if (this.css.csc.cse != null) {
          this.css.csc.cse.GK();
        }
        return true;
      }
    }
    if (paramMessage.what == 2)
    {
      if (this.csr == null) {
        return true;
      }
      if (this.css.csc.cse != null) {
        this.css.csc.cse.GL();
      }
      c localc = new c((byte)0);
      localc.pid = Process.myPid();
      if (com.tencent.matrix.b.Gp()) {}
      long l2;
      SparseArray localSparseArray;
      long l1;
      d locald;
      e locale;
      for (localObject1 = d.getProcessName(com.tencent.matrix.b.Gq().application);; localObject1 = "default")
      {
        localc.name = ((String)localObject1);
        localc.csB.addAll(gQ(localc.pid));
        localc.csA = SystemClock.uptimeMillis();
        localc.time = System.currentTimeMillis();
        localObject1 = this.csr;
        l2 = 0L;
        localSparseArray = new SparseArray();
        localObject2 = localc.csB.iterator();
        l1 = 0L;
        while (((Iterator)localObject2).hasNext())
        {
          locald = (d)((Iterator)localObject2).next();
          l1 += locald.csC;
          locale = e.a(locald, 1);
          locale.csE = locald.csC;
          localSparseArray.put(locald.tid, locale);
        }
      }
      Object localObject2 = ((c)localObject1).csB.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        locald = (d)((Iterator)localObject2).next();
        locale = (e)localSparseArray.get(locald.tid);
        if (locale == null)
        {
          localSparseArray.put(locald.tid, e.a(locald, 3));
        }
        else
        {
          l2 += locald.csC;
          locale.csF = 2;
          locale.csE = (locale.csD.csC - locald.csC);
        }
      }
      localObject2 = new a();
      ((a)localObject2).csu = (l1 - l2);
      ((a)localObject2).csv = (localc.time - ((c)localObject1).time);
      ((a)localObject2).csw = (localc.csA - ((c)localObject1).csA);
      int i = 0;
      while (i < localSparseArray.size())
      {
        ((a)localObject2).csx.add(localSparseArray.valueAt(i));
        i += 1;
      }
      Collections.sort(((a)localObject2).csx);
      if (paramMessage.arg1 == 1) {}
      for (boolean bool = true;; bool = false)
      {
        ((a)localObject2).cqM = bool;
        if (this.css.csc.cse != null) {
          this.css.csc.cse.a((a)localObject2);
        }
        this.csr = null;
        return true;
      }
    }
    return false;
  }
  
  public static final class a
  {
    public boolean cqM;
    public long csu;
    public long csv;
    public long csw;
    public LinkedList<b.e> csx = new LinkedList();
  }
  
  final class b
    implements Runnable
  {
    int csy = 1;
    
    private b() {}
    
    public final void run()
    {
      int i = 1;
      Message localMessage = Message.obtain(b.a(b.this));
      localMessage.what = this.csy;
      localMessage.arg1 = 1;
      b.a(b.this).sendMessageAtFrontOfQueue(localMessage);
      if (this.csy == 2) {}
      for (;;)
      {
        this.csy = i;
        b.a(b.this).postDelayed(this, b.GQ());
        return;
        i = 2;
      }
    }
  }
  
  final class c
  {
    long csA;
    LinkedList<b.d> csB = new LinkedList();
    String name;
    int pid;
    long time;
    
    private c() {}
    
    public final String toString()
    {
      return "process:" + this.name + "(" + this.pid + ") thread size:" + this.csB.size();
    }
  }
  
  public final class d
  {
    public long csC;
    public String name;
    public int tid;
    
    public d() {}
    
    public final String toString()
    {
      return "thread:" + this.name + "(" + this.tid + ") " + this.csC;
    }
  }
  
  public static final class e
    implements Comparable<e>
  {
    public b.d csD;
    public long csE;
    int csF = 1;
    
    private e(b.d paramd, int paramInt)
    {
      this.csD = paramd;
      this.csF = paramInt;
    }
    
    static e a(b.d paramd, int paramInt)
    {
      return new e(paramd, paramInt);
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      String str;
      if (this.csF == 1) {
        str = "+";
      }
      for (;;)
      {
        localStringBuilder.append("(").append(str).append(")").append(this.csD.name).append("(").append(this.csD.tid).append(")\t").append(this.csE).append(" jiffies");
        return localStringBuilder.toString();
        if (this.csF == 2) {
          str = "~";
        } else {
          str = "-";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.a.c.a.b
 * JD-Core Version:    0.7.0.1
 */