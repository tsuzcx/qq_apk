package c.t.m.g;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class au
  implements Runnable
{
  private static au a = new au();
  private volatile boolean b = false;
  private int c = 20000;
  private Map d = new HashMap();
  private Socket e;
  private int f = -1;
  private r g;
  private OutputStream h;
  private InputStream i;
  private Object j = new Object();
  private int k = -1;
  private int l = -1;
  private long m = -1L;
  private int n = -1;
  private int o = -1;
  
  public static au a()
  {
    try
    {
      au localau = a;
      return localau;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void a(int paramInt)
  {
    try
    {
      a(paramInt, null);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    try
    {
      if (paramInt != this.f)
      {
        Iterator localIterator = this.d.values().iterator();
        while (localIterator.hasNext())
        {
          av localav = (av)localIterator.next();
          if (localav != null)
          {
            localav.b = paramInt;
            if (paramString != null) {
              localav.c = paramString;
            }
          }
        }
      }
    }
    finally {}
  }
  
  private void b()
  {
    try
    {
      Iterator localIterator = this.d.values().iterator();
      while (localIterator.hasNext()) {
        b((av)localIterator.next());
      }
    }
    finally {}
  }
  
  /* Error */
  private boolean b(av paramav)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore_3
    //   4: iload_3
    //   5: ifne +325 -> 330
    //   8: aload_1
    //   9: ifnull +189 -> 198
    //   12: invokestatic 110	java/lang/System:currentTimeMillis	()J
    //   15: aload_1
    //   16: getfield 112	c/t/m/g/av:j	J
    //   19: lsub
    //   20: aload_1
    //   21: getfield 113	c/t/m/g/av:k	I
    //   24: i2l
    //   25: lcmp
    //   26: ifge +172 -> 198
    //   29: iconst_0
    //   30: istore_2
    //   31: iload_2
    //   32: ifne +298 -> 330
    //   35: aload_1
    //   36: ifnull +167 -> 203
    //   39: aload_0
    //   40: getfield 49	c/t/m/g/au:d	Ljava/util/Map;
    //   43: ifnull +160 -> 203
    //   46: aload_0
    //   47: getfield 49	c/t/m/g/au:d	Ljava/util/Map;
    //   50: aload_1
    //   51: invokevirtual 116	c/t/m/g/av:k	()I
    //   54: invokestatic 122	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   57: invokeinterface 126 2 0
    //   62: checkcast 94	c/t/m/g/av
    //   65: astore 5
    //   67: aload 5
    //   69: ifnull +134 -> 203
    //   72: aload 5
    //   74: invokevirtual 116	c/t/m/g/av:k	()I
    //   77: aload_1
    //   78: invokevirtual 116	c/t/m/g/av:k	()I
    //   81: if_icmpne +122 -> 203
    //   84: iconst_0
    //   85: istore_2
    //   86: iload_2
    //   87: ifne +243 -> 330
    //   90: aload_0
    //   91: invokespecial 128	c/t/m/g/au:e	()Z
    //   94: istore 4
    //   96: iload 4
    //   98: ifeq +225 -> 323
    //   101: ldc 130
    //   103: new 132	java/lang/StringBuilder
    //   106: dup
    //   107: ldc 134
    //   109: invokespecial 137	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   112: aload_1
    //   113: invokevirtual 116	c/t/m/g/av:k	()I
    //   116: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   119: ldc 143
    //   121: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload_0
    //   125: getfield 148	c/t/m/g/au:e	Ljava/net/Socket;
    //   128: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   131: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 160	c/t/m/g/ax:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   137: aload_1
    //   138: invokevirtual 163	c/t/m/g/av:l	()[B
    //   141: astore 5
    //   143: aload_0
    //   144: getfield 165	c/t/m/g/au:h	Ljava/io/OutputStream;
    //   147: aload 5
    //   149: iconst_0
    //   150: aload 5
    //   152: arraylength
    //   153: invokevirtual 171	java/io/OutputStream:write	([BII)V
    //   156: aload_0
    //   157: getfield 165	c/t/m/g/au:h	Ljava/io/OutputStream;
    //   160: invokevirtual 174	java/io/OutputStream:flush	()V
    //   163: aload_0
    //   164: invokestatic 110	java/lang/System:currentTimeMillis	()J
    //   167: putfield 61	c/t/m/g/au:m	J
    //   170: ldc 130
    //   172: new 132	java/lang/StringBuilder
    //   175: dup
    //   176: ldc 176
    //   178: invokespecial 137	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   181: aload 5
    //   183: arraylength
    //   184: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   187: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 178	c/t/m/g/ax:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   193: iconst_1
    //   194: istore_3
    //   195: goto -191 -> 4
    //   198: iconst_1
    //   199: istore_2
    //   200: goto -169 -> 31
    //   203: iconst_1
    //   204: istore_2
    //   205: goto -119 -> 86
    //   208: astore 5
    //   210: ldc 130
    //   212: aload 5
    //   214: invokestatic 181	c/t/m/g/ax:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   217: aload_1
    //   218: bipush 251
    //   220: putfield 96	c/t/m/g/av:b	I
    //   223: aload_1
    //   224: aload 5
    //   226: invokestatic 186	c/t/m/g/ay:a	(Ljava/lang/Exception;)Ljava/lang/String;
    //   229: putfield 99	c/t/m/g/av:c	Ljava/lang/String;
    //   232: iload_3
    //   233: ifne -229 -> 4
    //   236: aload_0
    //   237: aload_1
    //   238: getfield 96	c/t/m/g/av:b	I
    //   241: invokespecial 188	c/t/m/g/au:a	(I)V
    //   244: aload_0
    //   245: getfield 165	c/t/m/g/au:h	Ljava/io/OutputStream;
    //   248: invokevirtual 191	java/io/OutputStream:close	()V
    //   251: aload_0
    //   252: getfield 148	c/t/m/g/au:e	Ljava/net/Socket;
    //   255: invokevirtual 194	java/net/Socket:close	()V
    //   258: aload_0
    //   259: invokespecial 196	c/t/m/g/au:g	()V
    //   262: goto -258 -> 4
    //   265: astore 5
    //   267: aload 5
    //   269: invokevirtual 199	java/lang/Exception:printStackTrace	()V
    //   272: goto -268 -> 4
    //   275: astore_1
    //   276: aload_0
    //   277: monitorexit
    //   278: aload_1
    //   279: athrow
    //   280: astore 5
    //   282: iload_3
    //   283: ifne +29 -> 312
    //   286: aload_0
    //   287: aload_1
    //   288: getfield 96	c/t/m/g/av:b	I
    //   291: invokespecial 188	c/t/m/g/au:a	(I)V
    //   294: aload_0
    //   295: getfield 165	c/t/m/g/au:h	Ljava/io/OutputStream;
    //   298: invokevirtual 191	java/io/OutputStream:close	()V
    //   301: aload_0
    //   302: getfield 148	c/t/m/g/au:e	Ljava/net/Socket;
    //   305: invokevirtual 194	java/net/Socket:close	()V
    //   308: aload_0
    //   309: invokespecial 196	c/t/m/g/au:g	()V
    //   312: aload 5
    //   314: athrow
    //   315: astore_1
    //   316: aload_1
    //   317: invokevirtual 199	java/lang/Exception:printStackTrace	()V
    //   320: goto -8 -> 312
    //   323: aload_0
    //   324: invokespecial 196	c/t/m/g/au:g	()V
    //   327: goto -323 -> 4
    //   330: aload_0
    //   331: monitorexit
    //   332: iload_3
    //   333: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	334	0	this	au
    //   0	334	1	paramav	av
    //   30	175	2	i1	int
    //   3	330	3	bool1	boolean
    //   94	3	4	bool2	boolean
    //   65	117	5	localObject1	Object
    //   208	17	5	localException1	Exception
    //   265	3	5	localException2	Exception
    //   280	33	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   101	193	208	java/lang/Exception
    //   236	262	265	java/lang/Exception
    //   12	29	275	finally
    //   39	67	275	finally
    //   72	84	275	finally
    //   90	96	275	finally
    //   236	262	275	finally
    //   267	272	275	finally
    //   286	312	275	finally
    //   312	315	275	finally
    //   316	320	275	finally
    //   323	327	275	finally
    //   101	193	280	finally
    //   210	232	280	finally
    //   286	312	315	java/lang/Exception
  }
  
  private int c()
  {
    long l1;
    int i3;
    for (;;)
    {
      label203:
      try
      {
        l1 = System.currentTimeMillis();
        try
        {
          ax.b("WupTaskController", "doReadData: try read data...sk:" + this.e);
          localObject5 = new byte[4];
          i1 = 0;
          i2 = i1;
          if (i1 < 4)
          {
            ax.a("WupTaskController", "try read packet size: 4 bytes");
            i3 = this.i.read((byte[])localObject5, i1, 4 - i1);
            if (i3 <= 0) {
              continue;
            }
            this.n = ((int)(System.currentTimeMillis() - this.m));
            i2 = i1 + i3;
            i1 = i2;
            if (i2 != 4) {
              continue;
            }
          }
          if (i2 != 4) {
            continue;
          }
          i1 = ay.a((byte[])localObject5);
          if ((i1 > 4) && (i1 <= 524288)) {
            continue;
          }
          a(-6, "packSizeFail:" + i1);
          i1 = -6;
        }
        catch (Exception localException2)
        {
          Object localObject5;
          int i2;
          Object localObject1;
          long l2;
          localException2 = localException2;
          localException2.printStackTrace();
          ax.a("WupTaskController", localException2);
          a(-7, ay.a(localException2));
          int i1 = -7;
          continue;
          i1 = -50;
          continue;
        }
        finally {}
        return i1;
      }
      finally {}
      i2 = i1;
      if (i3 != -1)
      {
        continue;
        a(-6, "readLen fail:" + i2);
        i1 = -6;
        continue;
        localObject1 = new byte[i1];
        System.arraycopy(localObject5, 0, localObject1, 0, 4);
        l2 = System.currentTimeMillis();
        while (i2 < i1)
        {
          i3 = i1 - i2;
          ax.a("WupTaskController", "try read:" + i3);
          i3 = this.i.read((byte[])localObject1, i2, i3);
          ax.a("WupTaskController", "read ret:" + i3);
          if (i3 <= 0) {
            break label576;
          }
          i2 += i3;
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        if (i2 != i1)
        {
          ax.c("WupTaskController", "read fail. readLen:" + i2 + ",packSize:" + i1);
          a(-6, "readLen != packSize,rspBuff:" + ay.b((byte[])localObject1));
          i1 = -6;
          break;
        }
        this.o = ((int)(System.currentTimeMillis() - l2));
        ax.b("WupTaskController", "doSendReceive: read finish,readLen=" + i2);
        localObject5 = new bc();
        try
        {
          ((bc)localObject5).a((byte[])localObject1);
          i1 = ((bc)localObject5).a.b;
          localObject1 = (av)this.d.get(Integer.valueOf(i1));
          if ((localObject1 != null) && (((av)localObject1).k() == i1))
          {
            ((av)localObject1).a = ((bc)localObject5);
            ((av)localObject1).b = 0;
            ((av)localObject1).h = ((int)(System.currentTimeMillis() - l1));
            ((av)localObject1).e = this.l;
            ((av)localObject1).i = this.g;
            this.d.remove(Integer.valueOf(i1));
            ((av)localObject1).d.countDown();
            i1 = 0;
            break;
          }
        }
        catch (Exception localException1)
        {
          localException1 = localException1;
          a(-8, ay.a(localException1));
          i1 = -8;
          break;
        }
        finally {}
      }
      label576:
      if (i3 != -1) {
        break label203;
      }
    }
  }
  
  /* Error */
  private void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 42	c/t/m/g/au:b	Z
    //   6: ifne +22 -> 28
    //   9: new 276	java/lang/Thread
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 279	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   17: invokevirtual 282	java/lang/Thread:start	()V
    //   20: aload_0
    //   21: iconst_1
    //   22: putfield 42	c/t/m/g/au:b	Z
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: aload_0
    //   29: getfield 53	c/t/m/g/au:j	Ljava/lang/Object;
    //   32: astore_1
    //   33: aload_1
    //   34: monitorenter
    //   35: aload_0
    //   36: getfield 53	c/t/m/g/au:j	Ljava/lang/Object;
    //   39: invokevirtual 285	java/lang/Object:notify	()V
    //   42: aload_1
    //   43: monitorexit
    //   44: goto -19 -> 25
    //   47: astore_2
    //   48: aload_1
    //   49: monitorexit
    //   50: aload_2
    //   51: athrow
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	au
    //   52	4	1	localObject2	Object
    //   47	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   35	44	47	finally
    //   2	25	52	finally
    //   28	35	52	finally
    //   48	52	52	finally
  }
  
  private boolean e()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (this.e != null)
      {
        bool1 = bool2;
        if (this.e.isConnected())
        {
          bool1 = bool2;
          if (!this.e.isClosed())
          {
            OutputStream localOutputStream = this.h;
            bool1 = bool2;
            if (localOutputStream != null) {
              bool1 = true;
            }
          }
        }
      }
      return bool1;
    }
    finally {}
  }
  
  /* Error */
  private void f()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 205	c/t/m/g/au:i	Ljava/io/InputStream;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +15 -> 23
    //   11: aload_0
    //   12: getfield 205	c/t/m/g/au:i	Ljava/io/InputStream;
    //   15: invokevirtual 292	java/io/InputStream:close	()V
    //   18: aload_0
    //   19: aconst_null
    //   20: putfield 205	c/t/m/g/au:i	Ljava/io/InputStream;
    //   23: aload_0
    //   24: getfield 165	c/t/m/g/au:h	Ljava/io/OutputStream;
    //   27: astore_1
    //   28: aload_1
    //   29: ifnull +15 -> 44
    //   32: aload_0
    //   33: getfield 165	c/t/m/g/au:h	Ljava/io/OutputStream;
    //   36: invokevirtual 191	java/io/OutputStream:close	()V
    //   39: aload_0
    //   40: aconst_null
    //   41: putfield 165	c/t/m/g/au:h	Ljava/io/OutputStream;
    //   44: aload_0
    //   45: getfield 148	c/t/m/g/au:e	Ljava/net/Socket;
    //   48: astore_1
    //   49: aload_1
    //   50: ifnull +15 -> 65
    //   53: aload_0
    //   54: getfield 148	c/t/m/g/au:e	Ljava/net/Socket;
    //   57: invokevirtual 194	java/net/Socket:close	()V
    //   60: aload_0
    //   61: aconst_null
    //   62: putfield 148	c/t/m/g/au:e	Ljava/net/Socket;
    //   65: aload_0
    //   66: monitorexit
    //   67: return
    //   68: astore_1
    //   69: aload_0
    //   70: aconst_null
    //   71: putfield 205	c/t/m/g/au:i	Ljava/io/InputStream;
    //   74: goto -51 -> 23
    //   77: astore_1
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    //   82: astore_1
    //   83: aload_0
    //   84: aconst_null
    //   85: putfield 205	c/t/m/g/au:i	Ljava/io/InputStream;
    //   88: aload_1
    //   89: athrow
    //   90: astore_1
    //   91: aload_0
    //   92: aconst_null
    //   93: putfield 165	c/t/m/g/au:h	Ljava/io/OutputStream;
    //   96: goto -52 -> 44
    //   99: astore_1
    //   100: aload_0
    //   101: aconst_null
    //   102: putfield 165	c/t/m/g/au:h	Ljava/io/OutputStream;
    //   105: aload_1
    //   106: athrow
    //   107: astore_1
    //   108: aload_0
    //   109: aconst_null
    //   110: putfield 148	c/t/m/g/au:e	Ljava/net/Socket;
    //   113: goto -48 -> 65
    //   116: astore_1
    //   117: aload_0
    //   118: aconst_null
    //   119: putfield 148	c/t/m/g/au:e	Ljava/net/Socket;
    //   122: aload_1
    //   123: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	au
    //   6	44	1	localObject1	Object
    //   68	1	1	localException1	Exception
    //   77	4	1	localObject2	Object
    //   82	7	1	localObject3	Object
    //   90	1	1	localException2	Exception
    //   99	7	1	localObject4	Object
    //   107	1	1	localException3	Exception
    //   116	7	1	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   11	18	68	java/lang/Exception
    //   2	7	77	finally
    //   18	23	77	finally
    //   23	28	77	finally
    //   39	44	77	finally
    //   44	49	77	finally
    //   60	65	77	finally
    //   69	74	77	finally
    //   83	90	77	finally
    //   91	96	77	finally
    //   100	107	77	finally
    //   108	113	77	finally
    //   117	124	77	finally
    //   11	18	82	finally
    //   32	39	90	java/lang/Exception
    //   32	39	99	finally
    //   53	60	107	java/lang/Exception
    //   53	60	116	finally
  }
  
  private void g()
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        int i1;
        long l1;
        if (this.d.size() > 0)
        {
          ax.c("WupTaskController", "try reConnect...");
          at localat = new at();
          localat.c = b.a.b().b.a;
          i1 = b.a.b().b.d;
          localat.a = i1;
          localat.b = i1;
          Object localObject3 = c.a;
          localat.g = "dispatcher.3g.qq.com";
          localat.a((int[])localObject3);
          localObject3 = t.a().a("dispatcher.3g.qq.com");
          if (localObject3 != null)
          {
            ArrayList localArrayList = new ArrayList();
            localArrayList.addAll(((s.a)localObject3).c);
            localat.d = localArrayList;
          }
          l1 = b.a.b().a.b;
          if (l1 > 0L) {
            continue;
          }
          localat.e = b.a.b().a.c();
          localat.f = bool;
          this.l = 0;
          localat.a();
          this.k = localat.j;
          this.l = localat.k;
          if (localat.i != 0) {
            break label527;
          }
          this.e = localat.h;
          this.g = localat.l;
          ax.c("WupTaskController", "reConnect ok. sk:" + this.e + ",accessIP:" + this.g);
          if ((this.e == null) || (!this.e.isConnected())) {
            break label460;
          }
          bool = this.e.isClosed();
          if (bool) {
            break label460;
          }
        }
        try
        {
          this.e.setSoTimeout(this.c);
          this.e.setReceiveBufferSize(524288);
          this.h = this.e.getOutputStream();
          this.i = this.e.getInputStream();
          ax.b("WupTaskController", "reConnect socket succ. sk:" + this.e);
          return;
          long l2 = System.currentTimeMillis();
          i1 = b.a.b().b.e;
          if (l1 + i1 * 60 * 1000 < l2) {
            continue;
          }
          bool = false;
          continue;
        }
        catch (Exception localException1)
        {
          localException1 = localException1;
          localException1.printStackTrace();
          ax.a("WupTaskController", "reConnect socket fail. sk:" + this.e, localException1);
          a(-3, ay.a(localException1));
          f();
          continue;
        }
        finally {}
        if (this.e != null) {
          break label479;
        }
      }
      finally {}
      label460:
      a(-3, "sk is null");
      continue;
      label479:
      a(-3, "connect:" + this.e.isConnected() + "close:" + this.e.isClosed());
      continue;
      label527:
      if (aw.e())
      {
        if (i.a())
        {
          a(-3, "ret:" + localObject2.i);
        }
        else
        {
          a(-16);
          try
          {
            Thread.sleep(3000L);
          }
          catch (Exception localException2) {}
        }
      }
      else
      {
        a(-4);
        try
        {
          Thread.sleep(5000L);
        }
        catch (Exception localException3) {}
      }
    }
  }
  
  public final void a(av paramav)
  {
    paramav.j = System.currentTimeMillis();
    if (paramav == null) {
      return;
    }
    int i1 = paramav.k();
    if ((av)this.d.get(Integer.valueOf(i1)) != null)
    {
      ax.c("WupTaskController", "WupTaskImpl already exists. reqId:" + i1);
      return;
    }
    this.d.put(Integer.valueOf(i1), paramav);
    paramav.k = 22000;
    if (b(paramav)) {
      d();
    }
    try
    {
      if (paramav.d.await(22L, TimeUnit.SECONDS))
      {
        paramav.f = this.k;
        paramav.e = this.l;
        paramav.g = this.n;
        paramav.h = this.o;
        paramav.b = 0;
      }
      if (paramav.b == -1)
      {
        paramav.b = -14;
        paramav.f = this.k;
        paramav.e = this.l;
        paramav.g = this.n;
        paramav.h = this.o;
      }
      this.d.remove(Integer.valueOf(i1));
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
  
  public final void run()
  {
    for (;;)
    {
      try
      {
        if (this.d.size() <= 0) {
          break label155;
        }
        if (e())
        {
          i1 = c();
          if (i1 == 0)
          {
            ax.a("WupTaskController", "doReadData ok, now task num:" + this.d.size());
            continue;
          }
        }
      }
      catch (Exception localException1)
      {
        int i1;
        return;
        ax.a("WupTaskController", "doReadData fail, now task num:" + this.d.size());
        a(i1);
        f();
        g();
        if (!e()) {
          continue;
        }
        b();
        continue;
      }
      finally
      {
        this.b = false;
      }
      f();
      g();
      if (!e()) {
        continue;
      }
      b();
      continue;
      try
      {
        label155:
        synchronized (this.j)
        {
          if (this.d.size() <= 0)
          {
            ax.b("WupTaskController", "wait for readerLock... task size:" + this.d.size());
            this.j.wait();
            ax.b("WupTaskController", "readerLock waked... task size:" + this.d.size());
          }
        }
      }
      catch (Exception localException2) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     c.t.m.g.au
 * JD-Core Version:    0.7.0.1
 */