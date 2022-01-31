package com.tencent.d.e.a;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.d.e.a.a.c;
import com.tencent.d.e.a.a.g;
import com.tencent.d.e.a.a.h;
import com.tencent.d.e.a.a.k;
import com.tencent.d.f.j;
import java.util.ArrayList;
import java.util.List;

public final class e
{
  private static final j<e> wMZ = new e.1();
  private boolean ahC = false;
  private final Handler mHandler;
  private g wNa;
  private final List<k> wNb = new ArrayList();
  private d wNc;
  private b wNd;
  private com.tencent.d.e.a.a.d wNe;
  private final Runnable wNf = new e.2(this);
  private final a wNg = new a((byte)0);
  
  private e()
  {
    HandlerThread localHandlerThread = new HandlerThread("TuringMMCore");
    localHandlerThread.start();
    this.mHandler = new Handler(localHandlerThread.getLooper());
  }
  
  public static e cOP()
  {
    return (e)wMZ.get();
  }
  
  public final void a(Context paramContext, String paramString, com.tencent.d.e.a.a.e parame)
  {
    try
    {
      h localh = h.cOW();
      if (!localh.mInit) {
        localh.init(paramContext);
      }
      this.mHandler.post(new e.4(this, parame, paramString));
      return;
    }
    finally {}
  }
  
  /* Error */
  public final boolean a(d paramd)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: getfield 187	com/tencent/d/e/a/d:context	Landroid/content/Context;
    //   8: astore_3
    //   9: aload_3
    //   10: ifnonnull +9 -> 19
    //   13: iconst_0
    //   14: istore_2
    //   15: aload_0
    //   16: monitorexit
    //   17: iload_2
    //   18: ireturn
    //   19: invokestatic 164	com/tencent/d/e/a/a/h:cOW	()Lcom/tencent/d/e/a/a/h;
    //   22: astore 4
    //   24: aload 4
    //   26: getfield 167	com/tencent/d/e/a/a/h:mInit	Z
    //   29: ifne +9 -> 38
    //   32: aload 4
    //   34: aload_3
    //   35: invokevirtual 171	com/tencent/d/e/a/a/h:init	(Landroid/content/Context;)V
    //   38: aload_0
    //   39: getfield 42	com/tencent/d/e/a/e:ahC	Z
    //   42: ifeq +8 -> 50
    //   45: aload_0
    //   46: invokevirtual 191	com/tencent/d/e/a/e:un	()Z
    //   49: pop
    //   50: aload_0
    //   51: aload_1
    //   52: putfield 85	com/tencent/d/e/a/e:wNc	Lcom/tencent/d/e/a/d;
    //   55: aload_0
    //   56: iconst_1
    //   57: putfield 42	com/tencent/d/e/a/e:ahC	Z
    //   60: aload_0
    //   61: getfield 153	com/tencent/d/e/a/e:wNa	Lcom/tencent/d/e/a/a/g;
    //   64: ifnonnull +15 -> 79
    //   67: aload_0
    //   68: new 193	com/tencent/d/e/a/a/g
    //   71: dup
    //   72: aload_3
    //   73: invokespecial 195	com/tencent/d/e/a/a/g:<init>	(Landroid/content/Context;)V
    //   76: putfield 153	com/tencent/d/e/a/e:wNa	Lcom/tencent/d/e/a/a/g;
    //   79: aload_0
    //   80: getfield 153	com/tencent/d/e/a/e:wNa	Lcom/tencent/d/e/a/a/g;
    //   83: ifnull +27 -> 110
    //   86: aload_0
    //   87: getfield 153	com/tencent/d/e/a/e:wNa	Lcom/tencent/d/e/a/a/g;
    //   90: astore 4
    //   92: aload 4
    //   94: getfield 199	com/tencent/d/e/a/a/g:wNv	Landroid/util/SparseArray;
    //   97: astore_3
    //   98: aload_3
    //   99: monitorenter
    //   100: aload 4
    //   102: getfield 199	com/tencent/d/e/a/a/g:wNv	Landroid/util/SparseArray;
    //   105: invokevirtual 204	android/util/SparseArray:clear	()V
    //   108: aload_3
    //   109: monitorexit
    //   110: aload_0
    //   111: getfield 47	com/tencent/d/e/a/e:wNb	Ljava/util/List;
    //   114: astore_3
    //   115: aload_3
    //   116: monitorenter
    //   117: aload_0
    //   118: getfield 47	com/tencent/d/e/a/e:wNb	Ljava/util/List;
    //   121: invokeinterface 207 1 0
    //   126: aload_3
    //   127: monitorexit
    //   128: aload_0
    //   129: getfield 80	com/tencent/d/e/a/e:mHandler	Landroid/os/Handler;
    //   132: aload_0
    //   133: getfield 54	com/tencent/d/e/a/e:wNf	Ljava/lang/Runnable;
    //   136: aload_1
    //   137: getfield 211	com/tencent/d/e/a/d:ugs	J
    //   140: invokevirtual 215	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   143: pop
    //   144: goto -129 -> 15
    //   147: astore_1
    //   148: aload_0
    //   149: monitorexit
    //   150: aload_1
    //   151: athrow
    //   152: astore_1
    //   153: aload_3
    //   154: monitorexit
    //   155: aload_1
    //   156: athrow
    //   157: astore_1
    //   158: aload_3
    //   159: monitorexit
    //   160: aload_1
    //   161: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	this	e
    //   0	162	1	paramd	d
    //   1	17	2	bool	boolean
    //   22	79	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	147	finally
    //   19	38	147	finally
    //   38	50	147	finally
    //   50	79	147	finally
    //   79	100	147	finally
    //   110	117	147	finally
    //   128	144	147	finally
    //   155	157	147	finally
    //   160	162	147	finally
    //   100	110	152	finally
    //   153	155	152	finally
    //   117	128	157	finally
    //   158	160	157	finally
  }
  
  /* Error */
  public final boolean un()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: getfield 42	com/tencent/d/e/a/e:ahC	Z
    //   9: istore 4
    //   11: iload 4
    //   13: ifne +11 -> 24
    //   16: iconst_1
    //   17: istore 4
    //   19: aload_0
    //   20: monitorexit
    //   21: iload 4
    //   23: ireturn
    //   24: aload_0
    //   25: iconst_0
    //   26: putfield 42	com/tencent/d/e/a/e:ahC	Z
    //   29: iload 5
    //   31: istore 4
    //   33: aload_0
    //   34: getfield 85	com/tencent/d/e/a/e:wNc	Lcom/tencent/d/e/a/d;
    //   37: ifnull -18 -> 19
    //   40: aload_0
    //   41: getfield 80	com/tencent/d/e/a/e:mHandler	Landroid/os/Handler;
    //   44: aload_0
    //   45: getfield 54	com/tencent/d/e/a/e:wNf	Ljava/lang/Runnable;
    //   48: invokevirtual 219	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   51: aload_0
    //   52: getfield 80	com/tencent/d/e/a/e:mHandler	Landroid/os/Handler;
    //   55: aload_0
    //   56: getfield 59	com/tencent/d/e/a/e:wNg	Lcom/tencent/d/e/a/e$a;
    //   59: invokevirtual 219	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   62: aload_0
    //   63: getfield 153	com/tencent/d/e/a/e:wNa	Lcom/tencent/d/e/a/a/g;
    //   66: ifnull +147 -> 213
    //   69: aload_0
    //   70: getfield 153	com/tencent/d/e/a/e:wNa	Lcom/tencent/d/e/a/a/g;
    //   73: invokevirtual 222	com/tencent/d/e/a/a/g:cOS	()V
    //   76: iload 5
    //   78: istore 4
    //   80: aload_0
    //   81: getfield 153	com/tencent/d/e/a/e:wNa	Lcom/tencent/d/e/a/a/g;
    //   84: getfield 226	com/tencent/d/e/a/a/g:wNx	Lcom/tencent/d/e/a/a/g$a;
    //   87: invokevirtual 232	com/tencent/d/e/a/a/g$a:cOV	()J
    //   90: getstatic 237	com/tencent/d/e/a/a/f:wNq	J
    //   93: ldiv
    //   94: l2i
    //   95: iconst_3
    //   96: if_icmplt -77 -> 19
    //   99: aload_0
    //   100: getfield 153	com/tencent/d/e/a/e:wNa	Lcom/tencent/d/e/a/a/g;
    //   103: invokevirtual 241	com/tencent/d/e/a/a/g:cOT	()Landroid/util/SparseArray;
    //   106: astore 7
    //   108: iload 5
    //   110: istore 4
    //   112: aload 7
    //   114: invokevirtual 245	android/util/SparseArray:size	()I
    //   117: ifeq -98 -> 19
    //   120: aload_0
    //   121: getfield 47	com/tencent/d/e/a/e:wNb	Ljava/util/List;
    //   124: astore 6
    //   126: aload 6
    //   128: monitorenter
    //   129: new 44	java/util/ArrayList
    //   132: dup
    //   133: aload_0
    //   134: getfield 47	com/tencent/d/e/a/e:wNb	Ljava/util/List;
    //   137: invokespecial 248	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   140: astore 8
    //   142: aload 6
    //   144: monitorexit
    //   145: iload 5
    //   147: istore 4
    //   149: aload 8
    //   151: invokeinterface 249 1 0
    //   156: iconst_3
    //   157: if_icmplt -138 -> 19
    //   160: aload_0
    //   161: getfield 85	com/tencent/d/e/a/e:wNc	Lcom/tencent/d/e/a/d;
    //   164: getfield 252	com/tencent/d/e/a/d:wMX	I
    //   167: istore_1
    //   168: aload_0
    //   169: getfield 85	com/tencent/d/e/a/e:wNc	Lcom/tencent/d/e/a/d;
    //   172: getfield 255	com/tencent/d/e/a/d:action	I
    //   175: istore_2
    //   176: aload_0
    //   177: getfield 85	com/tencent/d/e/a/e:wNc	Lcom/tencent/d/e/a/d;
    //   180: getfield 256	com/tencent/d/e/a/d:requestType	I
    //   183: istore_3
    //   184: aload_0
    //   185: getfield 80	com/tencent/d/e/a/e:mHandler	Landroid/os/Handler;
    //   188: new 258	com/tencent/d/e/a/e$3
    //   191: dup
    //   192: aload_0
    //   193: iload_1
    //   194: iload_2
    //   195: iload_3
    //   196: aload 7
    //   198: aload 8
    //   200: invokespecial 261	com/tencent/d/e/a/e$3:<init>	(Lcom/tencent/d/e/a/e;IIILandroid/util/SparseArray;Ljava/util/List;)V
    //   203: invokevirtual 180	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   206: pop
    //   207: iconst_1
    //   208: istore 4
    //   210: goto -191 -> 19
    //   213: iconst_1
    //   214: istore 4
    //   216: goto -197 -> 19
    //   219: astore 7
    //   221: aload 6
    //   223: monitorexit
    //   224: aload 7
    //   226: athrow
    //   227: astore 6
    //   229: aload_0
    //   230: monitorexit
    //   231: aload 6
    //   233: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	234	0	this	e
    //   167	27	1	i	int
    //   175	20	2	j	int
    //   183	13	3	k	int
    //   9	206	4	bool1	boolean
    //   1	145	5	bool2	boolean
    //   227	5	6	localObject1	Object
    //   106	91	7	localSparseArray	android.util.SparseArray
    //   219	6	7	localObject2	Object
    //   140	59	8	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   129	145	219	finally
    //   221	224	219	finally
    //   5	11	227	finally
    //   24	29	227	finally
    //   33	76	227	finally
    //   80	108	227	finally
    //   112	129	227	finally
    //   149	207	227	finally
    //   224	227	227	finally
  }
  
  private final class a
    extends c
  {
    int mCount = 1;
    int mMaxCount = 3;
    long wNn = 0L;
    
    private a() {}
    
    /* Error */
    public final void cOQ()
    {
      // Byte code:
      //   0: new 36	com/tencent/d/e/a/a/k
      //   3: dup
      //   4: invokespecial 37	com/tencent/d/e/a/a/k:<init>	()V
      //   7: astore 7
      //   9: aload_0
      //   10: getfield 18	com/tencent/d/e/a/e$a:wNh	Lcom/tencent/d/e/a/e;
      //   13: astore 8
      //   15: aload 8
      //   17: monitorenter
      //   18: aload_0
      //   19: getfield 18	com/tencent/d/e/a/e$a:wNh	Lcom/tencent/d/e/a/e;
      //   22: invokestatic 40	com/tencent/d/e/a/e:a	(Lcom/tencent/d/e/a/e;)Lcom/tencent/d/e/a/d;
      //   25: getfield 46	com/tencent/d/e/a/d:context	Landroid/content/Context;
      //   28: astore 9
      //   30: getstatic 51	android/os/Build$VERSION:SDK_INT	I
      //   33: bipush 20
      //   35: if_icmplt +369 -> 404
      //   38: ldc 53
      //   40: invokestatic 59	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
      //   43: astore 10
      //   45: aload 9
      //   47: invokevirtual 65	java/lang/Object:getClass	()Ljava/lang/Class;
      //   50: ldc 67
      //   52: invokevirtual 71	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
      //   55: astore 11
      //   57: aload 11
      //   59: iconst_1
      //   60: invokevirtual 77	java/lang/reflect/Field:setAccessible	(Z)V
      //   63: aload 9
      //   65: aload 11
      //   67: aload 9
      //   69: invokevirtual 81	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
      //   72: checkcast 83	java/lang/String
      //   75: invokevirtual 89	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
      //   78: astore 11
      //   80: aload 11
      //   82: ifnonnull +170 -> 252
      //   85: iconst_0
      //   86: istore_1
      //   87: aload 7
      //   89: iload_1
      //   90: putfield 92	com/tencent/d/e/a/a/k:wNG	I
      //   93: new 94	java/io/File
      //   96: dup
      //   97: ldc 96
      //   99: invokespecial 99	java/io/File:<init>	(Ljava/lang/String;)V
      //   102: invokestatic 105	com/tencent/d/f/f:V	(Ljava/io/File;)Ljava/lang/String;
      //   105: astore 10
      //   107: aload 10
      //   109: invokestatic 111	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   112: ifne +19 -> 131
      //   115: ldc 113
      //   117: aload 10
      //   119: invokevirtual 117	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   122: ifeq +328 -> 450
      //   125: aload 7
      //   127: iconst_1
      //   128: putfield 120	com/tencent/d/e/a/a/k:wNI	I
      //   131: aload 9
      //   133: aconst_null
      //   134: new 122	android/content/IntentFilter
      //   137: dup
      //   138: ldc 124
      //   140: invokespecial 125	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
      //   143: invokevirtual 129	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
      //   146: astore 9
      //   148: aload 9
      //   150: ifnull +35 -> 185
      //   153: aload 9
      //   155: ldc 131
      //   157: iconst_m1
      //   158: invokevirtual 137	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
      //   161: istore_1
      //   162: iload_1
      //   163: iconst_2
      //   164: if_icmpeq +486 -> 650
      //   167: iload_1
      //   168: iconst_5
      //   169: if_icmpne +507 -> 676
      //   172: goto +478 -> 650
      //   175: iload_1
      //   176: ifne +320 -> 496
      //   179: aload 7
      //   181: iconst_1
      //   182: putfield 140	com/tencent/d/e/a/a/k:wNJ	I
      //   185: aload 8
      //   187: monitorexit
      //   188: aload_0
      //   189: getfield 18	com/tencent/d/e/a/e$a:wNh	Lcom/tencent/d/e/a/e;
      //   192: invokestatic 144	com/tencent/d/e/a/e:b	(Lcom/tencent/d/e/a/e;)Ljava/util/List;
      //   195: astore 8
      //   197: aload 8
      //   199: monitorenter
      //   200: aload_0
      //   201: getfield 18	com/tencent/d/e/a/e$a:wNh	Lcom/tencent/d/e/a/e;
      //   204: invokestatic 144	com/tencent/d/e/a/e:b	(Lcom/tencent/d/e/a/e;)Ljava/util/List;
      //   207: aload 7
      //   209: invokeinterface 149 2 0
      //   214: pop
      //   215: aload 8
      //   217: monitorexit
      //   218: aload_0
      //   219: getfield 23	com/tencent/d/e/a/e$a:mCount	I
      //   222: aload_0
      //   223: getfield 25	com/tencent/d/e/a/e$a:mMaxCount	I
      //   226: if_icmplt +344 -> 570
      //   229: aload_0
      //   230: getfield 18	com/tencent/d/e/a/e$a:wNh	Lcom/tencent/d/e/a/e;
      //   233: astore 7
      //   235: aload 7
      //   237: monitorenter
      //   238: aload_0
      //   239: getfield 18	com/tencent/d/e/a/e$a:wNh	Lcom/tencent/d/e/a/e;
      //   242: invokestatic 153	com/tencent/d/e/a/e:c	(Lcom/tencent/d/e/a/e;)Z
      //   245: ifne +305 -> 550
      //   248: aload 7
      //   250: monitorexit
      //   251: return
      //   252: aload 10
      //   254: ldc 155
      //   256: iconst_0
      //   257: anewarray 55	java/lang/Class
      //   260: invokevirtual 159	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
      //   263: astore 10
      //   265: aload 10
      //   267: ifnonnull +8 -> 275
      //   270: iconst_0
      //   271: istore_1
      //   272: goto -185 -> 87
      //   275: aload 10
      //   277: iconst_1
      //   278: invokevirtual 162	java/lang/reflect/Method:setAccessible	(Z)V
      //   281: aload 10
      //   283: aload 11
      //   285: iconst_0
      //   286: anewarray 61	java/lang/Object
      //   289: invokevirtual 166	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
      //   292: checkcast 168	[Landroid/view/Display;
      //   295: checkcast 168	[Landroid/view/Display;
      //   298: astore 10
      //   300: ldc 170
      //   302: ldc 172
      //   304: iconst_0
      //   305: anewarray 55	java/lang/Class
      //   308: invokevirtual 159	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
      //   311: astore 11
      //   313: aload 11
      //   315: iconst_1
      //   316: invokevirtual 162	java/lang/reflect/Method:setAccessible	(Z)V
      //   319: ldc 170
      //   321: ldc 174
      //   323: invokevirtual 71	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
      //   326: astore 12
      //   328: aload 12
      //   330: iconst_1
      //   331: invokevirtual 77	java/lang/reflect/Field:setAccessible	(Z)V
      //   334: aload 10
      //   336: arraylength
      //   337: istore_3
      //   338: iconst_0
      //   339: istore_2
      //   340: iconst_0
      //   341: istore_1
      //   342: iload_2
      //   343: iload_3
      //   344: if_icmpge +318 -> 662
      //   347: aload 10
      //   349: iload_2
      //   350: aaload
      //   351: astore 13
      //   353: aload 12
      //   355: aload 13
      //   357: invokevirtual 178	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
      //   360: istore 4
      //   362: aload 11
      //   364: aload 13
      //   366: iconst_0
      //   367: anewarray 61	java/lang/Object
      //   370: invokevirtual 166	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
      //   373: checkcast 180	java/lang/Integer
      //   376: invokevirtual 184	java/lang/Integer:intValue	()I
      //   379: iload 4
      //   381: if_icmpeq +266 -> 647
      //   384: iconst_1
      //   385: istore_1
      //   386: goto +269 -> 655
      //   389: aload 7
      //   391: iload_1
      //   392: putfield 92	com/tencent/d/e/a/a/k:wNG	I
      //   395: aload 7
      //   397: getfield 92	com/tencent/d/e/a/a/k:wNG	I
      //   400: istore_1
      //   401: goto -314 -> 87
      //   404: aload 9
      //   406: ldc 186
      //   408: invokevirtual 89	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
      //   411: checkcast 188	android/os/PowerManager
      //   414: astore 10
      //   416: aload 10
      //   418: ifnull -325 -> 93
      //   421: aload 10
      //   423: invokevirtual 192	android/os/PowerManager:isScreenOn	()Z
      //   426: ifeq +19 -> 445
      //   429: iconst_1
      //   430: istore_1
      //   431: aload 7
      //   433: iload_1
      //   434: putfield 92	com/tencent/d/e/a/a/k:wNG	I
      //   437: goto -344 -> 93
      //   440: astore 10
      //   442: goto -349 -> 93
      //   445: iconst_2
      //   446: istore_1
      //   447: goto -16 -> 431
      //   450: ldc 194
      //   452: aload 10
      //   454: invokevirtual 117	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   457: ifeq +20 -> 477
      //   460: aload 7
      //   462: iconst_2
      //   463: putfield 120	com/tencent/d/e/a/a/k:wNI	I
      //   466: goto -335 -> 131
      //   469: astore 7
      //   471: aload 8
      //   473: monitorexit
      //   474: aload 7
      //   476: athrow
      //   477: ldc 196
      //   479: aload 10
      //   481: invokevirtual 117	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   484: ifeq -353 -> 131
      //   487: aload 7
      //   489: iconst_3
      //   490: putfield 120	com/tencent/d/e/a/a/k:wNI	I
      //   493: goto -362 -> 131
      //   496: aload 9
      //   498: ldc 198
      //   500: iconst_m1
      //   501: invokevirtual 137	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
      //   504: istore_1
      //   505: iload_1
      //   506: iconst_2
      //   507: if_icmpne +12 -> 519
      //   510: aload 7
      //   512: iconst_3
      //   513: putfield 140	com/tencent/d/e/a/a/k:wNJ	I
      //   516: goto -331 -> 185
      //   519: iload_1
      //   520: iconst_1
      //   521: if_icmpne +12 -> 533
      //   524: aload 7
      //   526: iconst_2
      //   527: putfield 140	com/tencent/d/e/a/a/k:wNJ	I
      //   530: goto -345 -> 185
      //   533: aload 7
      //   535: iconst_0
      //   536: putfield 140	com/tencent/d/e/a/a/k:wNJ	I
      //   539: goto -354 -> 185
      //   542: astore 7
      //   544: aload 8
      //   546: monitorexit
      //   547: aload 7
      //   549: athrow
      //   550: aload_0
      //   551: getfield 18	com/tencent/d/e/a/e$a:wNh	Lcom/tencent/d/e/a/e;
      //   554: invokevirtual 201	com/tencent/d/e/a/e:un	()Z
      //   557: pop
      //   558: aload 7
      //   560: monitorexit
      //   561: return
      //   562: astore 8
      //   564: aload 7
      //   566: monitorexit
      //   567: aload 8
      //   569: athrow
      //   570: aload_0
      //   571: aload_0
      //   572: getfield 23	com/tencent/d/e/a/e$a:mCount	I
      //   575: iconst_1
      //   576: iadd
      //   577: putfield 23	com/tencent/d/e/a/e$a:mCount	I
      //   580: aload_0
      //   581: getfield 27	com/tencent/d/e/a/e$a:wNn	J
      //   584: getstatic 206	com/tencent/d/e/a/a/f:wNq	J
      //   587: aload_0
      //   588: getfield 23	com/tencent/d/e/a/e$a:mCount	I
      //   591: i2l
      //   592: lmul
      //   593: ladd
      //   594: invokestatic 212	java/lang/System:currentTimeMillis	()J
      //   597: lsub
      //   598: lstore 5
      //   600: lload 5
      //   602: lconst_0
      //   603: lcmp
      //   604: ifle +24 -> 628
      //   607: aload_0
      //   608: getfield 18	com/tencent/d/e/a/e$a:wNh	Lcom/tencent/d/e/a/e;
      //   611: invokestatic 216	com/tencent/d/e/a/e:e	(Lcom/tencent/d/e/a/e;)Landroid/os/Handler;
      //   614: aload_0
      //   615: getfield 18	com/tencent/d/e/a/e$a:wNh	Lcom/tencent/d/e/a/e;
      //   618: invokestatic 220	com/tencent/d/e/a/e:d	(Lcom/tencent/d/e/a/e;)Lcom/tencent/d/e/a/e$a;
      //   621: lload 5
      //   623: invokevirtual 226	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
      //   626: pop
      //   627: return
      //   628: aload_0
      //   629: getfield 18	com/tencent/d/e/a/e$a:wNh	Lcom/tencent/d/e/a/e;
      //   632: invokestatic 216	com/tencent/d/e/a/e:e	(Lcom/tencent/d/e/a/e;)Landroid/os/Handler;
      //   635: aload_0
      //   636: getfield 18	com/tencent/d/e/a/e$a:wNh	Lcom/tencent/d/e/a/e;
      //   639: invokestatic 220	com/tencent/d/e/a/e:d	(Lcom/tencent/d/e/a/e;)Lcom/tencent/d/e/a/e$a;
      //   642: invokevirtual 230	android/os/Handler:post	(Ljava/lang/Runnable;)Z
      //   645: pop
      //   646: return
      //   647: goto +8 -> 655
      //   650: iconst_1
      //   651: istore_1
      //   652: goto -477 -> 175
      //   655: iload_2
      //   656: iconst_1
      //   657: iadd
      //   658: istore_2
      //   659: goto -317 -> 342
      //   662: iload_1
      //   663: ifeq +8 -> 671
      //   666: iconst_1
      //   667: istore_1
      //   668: goto -279 -> 389
      //   671: iconst_2
      //   672: istore_1
      //   673: goto -284 -> 389
      //   676: iconst_0
      //   677: istore_1
      //   678: goto -503 -> 175
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	681	0	this	a
      //   86	592	1	i	int
      //   339	320	2	j	int
      //   337	8	3	k	int
      //   360	22	4	m	int
      //   598	24	5	l	long
      //   469	65	7	localObject2	Object
      //   542	23	7	localObject3	Object
      //   562	6	8	localObject5	Object
      //   28	469	9	localObject6	Object
      //   43	379	10	localObject7	Object
      //   440	40	10	localThrowable	java.lang.Throwable
      //   55	308	11	localObject8	Object
      //   326	28	12	localField	java.lang.reflect.Field
      //   351	14	13	localObject9	Object
      // Exception table:
      //   from	to	target	type
      //   30	80	440	java/lang/Throwable
      //   87	93	440	java/lang/Throwable
      //   252	265	440	java/lang/Throwable
      //   275	338	440	java/lang/Throwable
      //   353	384	440	java/lang/Throwable
      //   389	401	440	java/lang/Throwable
      //   404	416	440	java/lang/Throwable
      //   421	429	440	java/lang/Throwable
      //   431	437	440	java/lang/Throwable
      //   18	30	469	finally
      //   30	80	469	finally
      //   87	93	469	finally
      //   93	131	469	finally
      //   131	148	469	finally
      //   153	162	469	finally
      //   179	185	469	finally
      //   185	188	469	finally
      //   252	265	469	finally
      //   275	338	469	finally
      //   353	384	469	finally
      //   389	401	469	finally
      //   404	416	469	finally
      //   421	429	469	finally
      //   431	437	469	finally
      //   450	466	469	finally
      //   471	474	469	finally
      //   477	493	469	finally
      //   496	505	469	finally
      //   510	516	469	finally
      //   524	530	469	finally
      //   533	539	469	finally
      //   200	218	542	finally
      //   544	547	542	finally
      //   238	251	562	finally
      //   550	561	562	finally
      //   564	567	562	finally
    }
    
    public final void cOR()
    {
      if (e.f(e.this) != null) {
        e.f(e.this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.d.e.a.e
 * JD-Core Version:    0.7.0.1
 */