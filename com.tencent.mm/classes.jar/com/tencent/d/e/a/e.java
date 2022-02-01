package com.tencent.d.e.a;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.d.e.a.a.f;
import com.tencent.d.e.a.a.g;
import com.tencent.d.e.a.a.g.a;
import com.tencent.d.e.a.a.h;
import com.tencent.d.e.a.a.h.a;
import com.tencent.d.e.a.a.k;
import com.tencent.d.f.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class e
{
  private static final j<e> GxP;
  private boolean Tb;
  private g Zph;
  private final List<k> Zpi;
  private d Zpj;
  private b Zpk;
  private com.tencent.d.e.a.a.d Zpl;
  private final Runnable Zpm;
  private final a Zpn;
  private final MMHandler mHandler;
  
  static
  {
    AppMethodBeat.i(138392);
    GxP = new j() {};
    AppMethodBeat.o(138392);
  }
  
  private e()
  {
    AppMethodBeat.i(138386);
    this.Tb = false;
    this.Zpi = new ArrayList();
    this.Zpm = new com.tencent.d.e.a.a.c()
    {
      public final void byO()
      {
        AppMethodBeat.i(138377);
        synchronized (e.this)
        {
          if (!e.c(e.this))
          {
            AppMethodBeat.o(138377);
            return;
          }
          if (e.g(e.this) == null)
          {
            AppMethodBeat.o(138377);
            return;
          }
          if (e.g(e.this).WN(e.a(e.this).MMU))
          {
            long l = e.g(e.this).ZpE.iog();
            e.a locala = e.d(e.this);
            int i = (int)(e.a(e.this).MMU / f.Zpx);
            locala.mCount = 1;
            locala.mMaxCount = i;
            locala.Zpu = l;
            l = l + f.Zpx - System.currentTimeMillis();
            if (l > 0L) {
              e.e(e.this).postDelayed(e.d(e.this), l);
            }
          }
          else
          {
            AppMethodBeat.o(138377);
            return;
          }
          e.e(e.this).post(e.d(e.this));
        }
      }
      
      public final void ioc()
      {
        AppMethodBeat.i(138378);
        if (e.f(e.this) != null) {
          e.f(e.this);
        }
        AppMethodBeat.o(138378);
      }
    };
    this.Zpn = new a((byte)0);
    this.mHandler = new MMHandler("TuringMMCore");
    AppMethodBeat.o(138386);
  }
  
  public static e iob()
  {
    AppMethodBeat.i(138385);
    e locale = (e)GxP.get();
    AppMethodBeat.o(138385);
    return locale;
  }
  
  public final boolean TV()
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(138388);
        if (!this.Tb)
        {
          AppMethodBeat.o(138388);
          bool = true;
          return bool;
        }
        this.Tb = false;
        if (this.Zpj == null)
        {
          AppMethodBeat.o(138388);
          continue;
        }
        this.mHandler.removeCallbacks(this.Zpm);
      }
      finally {}
      this.mHandler.removeCallbacks(this.Zpn);
      if (this.Zph != null)
      {
        this.Zph.ioe();
        if ((int)(this.Zph.ZpE.ioh() / f.Zpx) < 3) {
          AppMethodBeat.o(138388);
        }
      }
      else
      {
        AppMethodBeat.o(138388);
        bool = true;
        continue;
      }
      SparseArray localSparseArray1 = this.Zph.iof();
      if (localSparseArray1.size() == 0)
      {
        AppMethodBeat.o(138388);
      }
      else
      {
        final ArrayList localArrayList;
        final int i;
        final int j;
        synchronized (this.Zpi)
        {
          localArrayList = new ArrayList(this.Zpi);
          if (localArrayList.size() < 3) {
            AppMethodBeat.o(138388);
          }
        }
        final int k = this.Zpj.requestType;
        this.mHandler.post(new com.tencent.d.e.a.a.c()
        {
          /* Error */
          public final void byO()
          {
            // Byte code:
            //   0: ldc 43
            //   2: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
            //   5: aload_0
            //   6: getfield 23	com/tencent/d/e/a/e$3:Zpo	Lcom/tencent/d/e/a/e;
            //   9: astore_3
            //   10: aload_3
            //   11: monitorenter
            //   12: aload_0
            //   13: getfield 25	com/tencent/d/e/a/e$3:Zpp	I
            //   16: aload_0
            //   17: getfield 27	com/tencent/d/e/a/e$3:fgX	I
            //   20: aload_0
            //   21: getfield 23	com/tencent/d/e/a/e$3:Zpo	Lcom/tencent/d/e/a/e;
            //   24: invokestatic 53	com/tencent/d/e/a/e:a	(Lcom/tencent/d/e/a/e;)Lcom/tencent/d/e/a/d;
            //   27: getfield 59	com/tencent/d/e/a/d:context	Landroid/content/Context;
            //   30: aload_0
            //   31: getfield 29	com/tencent/d/e/a/e$3:QkG	I
            //   34: aload_0
            //   35: getfield 31	com/tencent/d/e/a/e$3:Zpq	Landroid/util/SparseArray;
            //   38: aload_0
            //   39: getfield 33	com/tencent/d/e/a/e$3:Zpr	Ljava/util/List;
            //   42: invokestatic 64	com/tencent/d/e/a/a/b:a	(IILandroid/content/Context;ILandroid/util/SparseArray;Ljava/util/List;)Lcom/tencent/d/e/a/b/a;
            //   45: astore 4
            //   47: aload_3
            //   48: monitorexit
            //   49: invokestatic 70	com/tencent/d/e/a/a/h:ioi	()Lcom/tencent/d/e/a/a/h;
            //   52: astore 5
            //   54: aload_0
            //   55: getfield 25	com/tencent/d/e/a/e$3:Zpp	I
            //   58: istore_1
            //   59: aload_0
            //   60: getfield 27	com/tencent/d/e/a/e$3:fgX	I
            //   63: istore_2
            //   64: aload 4
            //   66: invokevirtual 76	com/tencent/d/e/a/b/a:toByteArray	()[B
            //   69: invokestatic 82	com/tencent/d/f/b:compress	([B)[B
            //   72: invokestatic 87	com/tencent/d/f/c:ion	()[B
            //   75: invokestatic 91	com/tencent/d/f/c:p	([B[B)[B
            //   78: astore 6
            //   80: aload 6
            //   82: ifnull +89 -> 171
            //   85: aload 5
            //   87: getfield 94	com/tencent/d/e/a/a/h:mContext	Landroid/content/Context;
            //   90: ldc 96
            //   92: iconst_0
            //   93: invokevirtual 102	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
            //   96: astore_3
            //   97: aload_3
            //   98: ifnonnull +116 -> 214
            //   101: ldc 104
            //   103: astore_3
            //   104: aload_3
            //   105: invokestatic 110	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
            //   108: ifne +63 -> 171
            //   111: aconst_null
            //   112: astore 4
            //   114: new 112	java/io/BufferedOutputStream
            //   117: dup
            //   118: new 114	java/io/FileOutputStream
            //   121: dup
            //   122: aload_3
            //   123: invokespecial 117	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
            //   126: invokespecial 120	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
            //   129: astore_3
            //   130: aload_3
            //   131: aload 6
            //   133: invokevirtual 124	java/io/BufferedOutputStream:write	([B)V
            //   136: aload_3
            //   137: invokevirtual 127	java/io/BufferedOutputStream:flush	()V
            //   140: aload_3
            //   141: invokestatic 133	com/tencent/d/f/f:closeQuietly	(Ljava/io/Closeable;)V
            //   144: aload 5
            //   146: iload_1
            //   147: iload_2
            //   148: invokevirtual 137	com/tencent/d/e/a/a/h:nJ	(II)Ljava/lang/String;
            //   151: astore_3
            //   152: aload_3
            //   153: invokestatic 110	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
            //   156: ifne +15 -> 171
            //   159: new 139	java/io/File
            //   162: dup
            //   163: aload_3
            //   164: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
            //   167: invokevirtual 143	java/io/File:delete	()Z
            //   170: pop
            //   171: aload_0
            //   172: getfield 23	com/tencent/d/e/a/e$3:Zpo	Lcom/tencent/d/e/a/e;
            //   175: invokestatic 147	com/tencent/d/e/a/e:h	(Lcom/tencent/d/e/a/e;)Lcom/tencent/d/e/a/b;
            //   178: ifnull +11 -> 189
            //   181: aload_0
            //   182: getfield 23	com/tencent/d/e/a/e$3:Zpo	Lcom/tencent/d/e/a/e;
            //   185: invokestatic 147	com/tencent/d/e/a/e:h	(Lcom/tencent/d/e/a/e;)Lcom/tencent/d/e/a/b;
            //   188: pop
            //   189: ldc 43
            //   191: invokestatic 150	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
            //   194: return
            //   195: astore 4
            //   197: aload_3
            //   198: monitorexit
            //   199: ldc 43
            //   201: invokestatic 150	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
            //   204: aload 4
            //   206: athrow
            //   207: astore_3
            //   208: ldc 43
            //   210: invokestatic 150	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
            //   213: return
            //   214: new 152	java/lang/StringBuilder
            //   217: dup
            //   218: invokespecial 153	java/lang/StringBuilder:<init>	()V
            //   221: aload_3
            //   222: invokevirtual 157	java/io/File:getAbsolutePath	()Ljava/lang/String;
            //   225: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   228: getstatic 165	java/io/File:separator	Ljava/lang/String;
            //   231: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   234: iload_1
            //   235: iload_2
            //   236: invokestatic 168	com/tencent/d/e/a/a/h:nK	(II)Ljava/lang/String;
            //   239: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   242: ldc 170
            //   244: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   247: invokestatic 176	java/lang/System:currentTimeMillis	()J
            //   250: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
            //   253: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
            //   256: astore_3
            //   257: goto -153 -> 104
            //   260: astore_3
            //   261: aconst_null
            //   262: astore_3
            //   263: aload_3
            //   264: invokestatic 133	com/tencent/d/f/f:closeQuietly	(Ljava/io/Closeable;)V
            //   267: goto -123 -> 144
            //   270: astore_3
            //   271: aload 4
            //   273: invokestatic 133	com/tencent/d/f/f:closeQuietly	(Ljava/io/Closeable;)V
            //   276: ldc 43
            //   278: invokestatic 150	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
            //   281: aload_3
            //   282: athrow
            //   283: astore 5
            //   285: aload_3
            //   286: astore 4
            //   288: aload 5
            //   290: astore_3
            //   291: goto -20 -> 271
            //   294: astore 4
            //   296: goto -33 -> 263
            // Local variable table:
            //   start	length	slot	name	signature
            //   0	299	0	this	3
            //   58	177	1	i	int
            //   63	173	2	j	int
            //   9	189	3	localObject1	Object
            //   207	15	3	localIllegalArgumentException	java.lang.IllegalArgumentException
            //   256	1	3	str	String
            //   260	1	3	localThrowable1	Throwable
            //   262	2	3	localCloseable1	java.io.Closeable
            //   270	16	3	localObject2	Object
            //   290	1	3	localObject3	Object
            //   45	68	4	locala	com.tencent.d.e.a.b.a
            //   195	77	4	localCloseable2	java.io.Closeable
            //   286	1	4	localObject4	Object
            //   294	1	4	localThrowable2	Throwable
            //   52	93	5	localh	h
            //   283	6	5	localObject5	Object
            //   78	54	6	arrayOfByte	byte[]
            // Exception table:
            //   from	to	target	type
            //   12	49	195	finally
            //   5	12	207	java/lang/IllegalArgumentException
            //   197	207	207	java/lang/IllegalArgumentException
            //   114	130	260	java/lang/Throwable
            //   114	130	270	finally
            //   130	140	283	finally
            //   130	140	294	java/lang/Throwable
          }
          
          public final void ioc()
          {
            AppMethodBeat.i(138380);
            if (e.f(e.this) != null) {
              e.f(e.this);
            }
            AppMethodBeat.o(138380);
          }
        });
        AppMethodBeat.o(138388);
        bool = true;
      }
    }
  }
  
  public final void a(Context paramContext, final String paramString, final com.tencent.d.e.a.a.e parame)
  {
    try
    {
      AppMethodBeat.i(138389);
      h localh = h.ioi();
      if (!localh.mInit) {
        localh.init(paramContext);
      }
      this.mHandler.post(new com.tencent.d.e.a.a.c()
      {
        public final void byO()
        {
          AppMethodBeat.i(138381);
          Object localObject1 = h.ioi().ioj();
          HashMap localHashMap = new HashMap();
          Object localObject2;
          if (((Map)localObject1).size() != 0)
          {
            localObject2 = h.i((Map)localObject1, 0);
            if (localObject2 != null) {
              localHashMap.put(((h.a)localObject2).ZpJ, ((h.a)localObject2).ZpK);
            }
            localObject2 = h.i((Map)localObject1, 1);
            if (localObject2 != null) {
              localHashMap.put(((h.a)localObject2).ZpJ, ((h.a)localObject2).ZpK);
            }
            localObject1 = h.i((Map)localObject1, 2);
            if (localObject1 != null) {
              localHashMap.put(((h.a)localObject1).ZpJ, ((h.a)localObject1).ZpK);
            }
          }
          if (localHashMap.size() == 0)
          {
            parame.bBE();
            AppMethodBeat.o(138381);
            return;
          }
          localObject1 = localHashMap.keySet().iterator();
          label308:
          for (;;)
          {
            boolean bool;
            if (((Iterator)localObject1).hasNext())
            {
              localObject2 = (com.tencent.d.e.a.b.a)((Iterator)localObject1).next();
              ((com.tencent.d.e.a.b.a)localObject2).ZpS = System.currentTimeMillis();
              ((com.tencent.d.e.a.b.a)localObject2).fND = paramString;
              if ((parame instanceof a)) {
                bool = e.a((a)parame, (com.tencent.d.e.a.b.a)localObject2);
              }
            }
            for (;;)
            {
              if (!bool) {
                break label308;
              }
              localObject2 = ((List)localHashMap.get(localObject2)).iterator();
              while (((Iterator)localObject2).hasNext())
              {
                String str = (String)((Iterator)localObject2).next();
                try
                {
                  new File(str).delete();
                }
                catch (Throwable localThrowable) {}
              }
              break;
              if ((parame instanceof c))
              {
                bool = e.a((c)parame, (com.tencent.d.e.a.b.a)localObject2);
                continue;
                AppMethodBeat.o(138381);
              }
              else
              {
                bool = false;
              }
            }
          }
        }
        
        public final void ioc()
        {
          AppMethodBeat.i(138382);
          if (e.f(e.this) != null) {
            e.f(e.this);
          }
          AppMethodBeat.o(138382);
        }
      });
      AppMethodBeat.o(138389);
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
    //   4: ldc 243
    //   6: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_1
    //   10: getfield 247	com/tencent/d/e/a/d:context	Landroid/content/Context;
    //   13: astore_3
    //   14: aload_3
    //   15: ifnonnull +14 -> 29
    //   18: iconst_0
    //   19: istore_2
    //   20: ldc 243
    //   22: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: aload_0
    //   26: monitorexit
    //   27: iload_2
    //   28: ireturn
    //   29: invokestatic 231	com/tencent/d/e/a/a/h:ioi	()Lcom/tencent/d/e/a/a/h;
    //   32: astore 4
    //   34: aload 4
    //   36: getfield 234	com/tencent/d/e/a/a/h:mInit	Z
    //   39: ifne +9 -> 48
    //   42: aload 4
    //   44: aload_3
    //   45: invokevirtual 238	com/tencent/d/e/a/a/h:init	(Landroid/content/Context;)V
    //   48: aload_0
    //   49: getfield 59	com/tencent/d/e/a/e:Tb	Z
    //   52: ifeq +8 -> 60
    //   55: aload_0
    //   56: invokevirtual 249	com/tencent/d/e/a/e:TV	()Z
    //   59: pop
    //   60: aload_0
    //   61: aload_1
    //   62: putfield 88	com/tencent/d/e/a/e:Zpj	Lcom/tencent/d/e/a/d;
    //   65: aload_0
    //   66: iconst_1
    //   67: putfield 59	com/tencent/d/e/a/e:Tb	Z
    //   70: aload_0
    //   71: getfield 150	com/tencent/d/e/a/e:Zph	Lcom/tencent/d/e/a/a/g;
    //   74: ifnonnull +14 -> 88
    //   77: aload_0
    //   78: new 172	com/tencent/d/e/a/a/g
    //   81: dup
    //   82: invokespecial 250	com/tencent/d/e/a/a/g:<init>	()V
    //   85: putfield 150	com/tencent/d/e/a/e:Zph	Lcom/tencent/d/e/a/a/g;
    //   88: aload_0
    //   89: getfield 150	com/tencent/d/e/a/e:Zph	Lcom/tencent/d/e/a/a/g;
    //   92: ifnull +27 -> 119
    //   95: aload_0
    //   96: getfield 150	com/tencent/d/e/a/e:Zph	Lcom/tencent/d/e/a/a/g;
    //   99: astore 4
    //   101: aload 4
    //   103: getfield 254	com/tencent/d/e/a/a/g:ZpC	Landroid/util/SparseArray;
    //   106: astore_3
    //   107: aload_3
    //   108: monitorenter
    //   109: aload 4
    //   111: getfield 254	com/tencent/d/e/a/a/g:ZpC	Landroid/util/SparseArray;
    //   114: invokevirtual 257	android/util/SparseArray:clear	()V
    //   117: aload_3
    //   118: monitorexit
    //   119: aload_0
    //   120: getfield 64	com/tencent/d/e/a/e:Zpi	Ljava/util/List;
    //   123: astore_3
    //   124: aload_3
    //   125: monitorenter
    //   126: aload_0
    //   127: getfield 64	com/tencent/d/e/a/e:Zpi	Ljava/util/List;
    //   130: invokeinterface 258 1 0
    //   135: aload_3
    //   136: monitorexit
    //   137: aload_0
    //   138: getfield 83	com/tencent/d/e/a/e:mHandler	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   141: aload_0
    //   142: getfield 69	com/tencent/d/e/a/e:Zpm	Ljava/lang/Runnable;
    //   145: aload_1
    //   146: getfield 261	com/tencent/d/e/a/d:delayTime	J
    //   149: invokevirtual 265	com/tencent/mm/sdk/platformtools/MMHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   152: pop
    //   153: ldc 243
    //   155: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   158: goto -133 -> 25
    //   161: astore_1
    //   162: aload_0
    //   163: monitorexit
    //   164: aload_1
    //   165: athrow
    //   166: astore_1
    //   167: aload_3
    //   168: monitorexit
    //   169: ldc 243
    //   171: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   174: aload_1
    //   175: athrow
    //   176: astore_1
    //   177: aload_3
    //   178: monitorexit
    //   179: ldc 243
    //   181: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   184: aload_1
    //   185: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	this	e
    //   0	186	1	paramd	d
    //   1	27	2	bool	boolean
    //   32	78	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   4	14	161	finally
    //   20	25	161	finally
    //   29	48	161	finally
    //   48	60	161	finally
    //   60	88	161	finally
    //   88	109	161	finally
    //   119	126	161	finally
    //   137	158	161	finally
    //   167	176	161	finally
    //   177	186	161	finally
    //   109	119	166	finally
    //   126	137	176	finally
  }
  
  final class a
    extends com.tencent.d.e.a.a.c
  {
    long Zpu = 0L;
    int mCount = 1;
    int mMaxCount = 3;
    
    private a() {}
    
    /* Error */
    public final void byO()
    {
      // Byte code:
      //   0: ldc 35
      //   2: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: new 43	com/tencent/d/e/a/a/k
      //   8: dup
      //   9: invokespecial 44	com/tencent/d/e/a/a/k:<init>	()V
      //   12: astore 7
      //   14: aload_0
      //   15: getfield 18	com/tencent/d/e/a/e$a:Zpo	Lcom/tencent/d/e/a/e;
      //   18: astore 8
      //   20: aload 8
      //   22: monitorenter
      //   23: aload_0
      //   24: getfield 18	com/tencent/d/e/a/e$a:Zpo	Lcom/tencent/d/e/a/e;
      //   27: invokestatic 47	com/tencent/d/e/a/e:a	(Lcom/tencent/d/e/a/e;)Lcom/tencent/d/e/a/d;
      //   30: getfield 53	com/tencent/d/e/a/d:context	Landroid/content/Context;
      //   33: astore 9
      //   35: getstatic 58	android/os/Build$VERSION:SDK_INT	I
      //   38: bipush 20
      //   40: if_icmplt +374 -> 414
      //   43: ldc 60
      //   45: invokestatic 66	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
      //   48: astore 10
      //   50: aload 9
      //   52: invokevirtual 72	java/lang/Object:getClass	()Ljava/lang/Class;
      //   55: ldc 74
      //   57: invokevirtual 78	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
      //   60: astore 11
      //   62: aload 11
      //   64: iconst_1
      //   65: invokevirtual 84	java/lang/reflect/Field:setAccessible	(Z)V
      //   68: aload 9
      //   70: aload 11
      //   72: aload 9
      //   74: invokevirtual 88	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
      //   77: checkcast 90	java/lang/String
      //   80: invokevirtual 96	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
      //   83: astore 11
      //   85: aload 11
      //   87: ifnonnull +175 -> 262
      //   90: iconst_0
      //   91: istore_1
      //   92: aload 7
      //   94: iload_1
      //   95: putfield 99	com/tencent/d/e/a/a/k:ZpO	I
      //   98: new 101	java/io/File
      //   101: dup
      //   102: ldc 103
      //   104: invokespecial 106	java/io/File:<init>	(Ljava/lang/String;)V
      //   107: invokestatic 112	com/tencent/d/f/f:S	(Ljava/io/File;)Ljava/lang/String;
      //   110: astore 10
      //   112: aload 10
      //   114: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   117: ifne +19 -> 136
      //   120: ldc 120
      //   122: aload 10
      //   124: invokevirtual 124	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   127: ifeq +333 -> 460
      //   130: aload 7
      //   132: iconst_1
      //   133: putfield 127	com/tencent/d/e/a/a/k:ZpQ	I
      //   136: aload 9
      //   138: aconst_null
      //   139: new 129	android/content/IntentFilter
      //   142: dup
      //   143: ldc 131
      //   145: invokespecial 132	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
      //   148: invokevirtual 136	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
      //   151: astore 9
      //   153: aload 9
      //   155: ifnull +35 -> 190
      //   158: aload 9
      //   160: ldc 138
      //   162: iconst_m1
      //   163: invokevirtual 144	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
      //   166: istore_1
      //   167: iload_1
      //   168: iconst_2
      //   169: if_icmpeq +521 -> 690
      //   172: iload_1
      //   173: iconst_5
      //   174: if_icmpne +542 -> 716
      //   177: goto +513 -> 690
      //   180: iload_1
      //   181: ifne +330 -> 511
      //   184: aload 7
      //   186: iconst_1
      //   187: putfield 147	com/tencent/d/e/a/a/k:ZpR	I
      //   190: aload 8
      //   192: monitorexit
      //   193: aload_0
      //   194: getfield 18	com/tencent/d/e/a/e$a:Zpo	Lcom/tencent/d/e/a/e;
      //   197: invokestatic 151	com/tencent/d/e/a/e:b	(Lcom/tencent/d/e/a/e;)Ljava/util/List;
      //   200: astore 8
      //   202: aload 8
      //   204: monitorenter
      //   205: aload_0
      //   206: getfield 18	com/tencent/d/e/a/e$a:Zpo	Lcom/tencent/d/e/a/e;
      //   209: invokestatic 151	com/tencent/d/e/a/e:b	(Lcom/tencent/d/e/a/e;)Ljava/util/List;
      //   212: aload 7
      //   214: invokeinterface 156 2 0
      //   219: pop
      //   220: aload 8
      //   222: monitorexit
      //   223: aload_0
      //   224: getfield 23	com/tencent/d/e/a/e$a:mCount	I
      //   227: aload_0
      //   228: getfield 25	com/tencent/d/e/a/e$a:mMaxCount	I
      //   231: if_icmplt +369 -> 600
      //   234: aload_0
      //   235: getfield 18	com/tencent/d/e/a/e$a:Zpo	Lcom/tencent/d/e/a/e;
      //   238: astore 7
      //   240: aload 7
      //   242: monitorenter
      //   243: aload_0
      //   244: getfield 18	com/tencent/d/e/a/e$a:Zpo	Lcom/tencent/d/e/a/e;
      //   247: invokestatic 160	com/tencent/d/e/a/e:c	(Lcom/tencent/d/e/a/e;)Z
      //   250: ifne +320 -> 570
      //   253: aload 7
      //   255: monitorexit
      //   256: ldc 35
      //   258: invokestatic 163	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   261: return
      //   262: aload 10
      //   264: ldc 165
      //   266: iconst_0
      //   267: anewarray 62	java/lang/Class
      //   270: invokevirtual 169	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
      //   273: astore 10
      //   275: aload 10
      //   277: ifnonnull +8 -> 285
      //   280: iconst_0
      //   281: istore_1
      //   282: goto -190 -> 92
      //   285: aload 10
      //   287: iconst_1
      //   288: invokevirtual 172	java/lang/reflect/Method:setAccessible	(Z)V
      //   291: aload 10
      //   293: aload 11
      //   295: iconst_0
      //   296: anewarray 68	java/lang/Object
      //   299: invokevirtual 176	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
      //   302: checkcast 178	[Landroid/view/Display;
      //   305: checkcast 178	[Landroid/view/Display;
      //   308: astore 10
      //   310: ldc 180
      //   312: ldc 182
      //   314: iconst_0
      //   315: anewarray 62	java/lang/Class
      //   318: invokevirtual 169	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
      //   321: astore 11
      //   323: aload 11
      //   325: iconst_1
      //   326: invokevirtual 172	java/lang/reflect/Method:setAccessible	(Z)V
      //   329: ldc 180
      //   331: ldc 184
      //   333: invokevirtual 78	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
      //   336: astore 12
      //   338: aload 12
      //   340: iconst_1
      //   341: invokevirtual 84	java/lang/reflect/Field:setAccessible	(Z)V
      //   344: iconst_0
      //   345: istore_1
      //   346: aload 10
      //   348: arraylength
      //   349: istore_3
      //   350: iconst_0
      //   351: istore_2
      //   352: iload_2
      //   353: iload_3
      //   354: if_icmpge +348 -> 702
      //   357: aload 10
      //   359: iload_2
      //   360: aaload
      //   361: astore 13
      //   363: aload 12
      //   365: aload 13
      //   367: invokevirtual 188	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
      //   370: istore 4
      //   372: aload 11
      //   374: aload 13
      //   376: iconst_0
      //   377: anewarray 68	java/lang/Object
      //   380: invokevirtual 176	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
      //   383: checkcast 190	java/lang/Integer
      //   386: invokevirtual 194	java/lang/Integer:intValue	()I
      //   389: iload 4
      //   391: if_icmpeq +296 -> 687
      //   394: iconst_1
      //   395: istore_1
      //   396: goto +299 -> 695
      //   399: aload 7
      //   401: iload_1
      //   402: putfield 99	com/tencent/d/e/a/a/k:ZpO	I
      //   405: aload 7
      //   407: getfield 99	com/tencent/d/e/a/a/k:ZpO	I
      //   410: istore_1
      //   411: goto -319 -> 92
      //   414: aload 9
      //   416: ldc 196
      //   418: invokevirtual 96	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
      //   421: checkcast 198	android/os/PowerManager
      //   424: astore 10
      //   426: aload 10
      //   428: ifnull -330 -> 98
      //   431: aload 10
      //   433: invokevirtual 202	android/os/PowerManager:isScreenOn	()Z
      //   436: ifeq +19 -> 455
      //   439: iconst_1
      //   440: istore_1
      //   441: aload 7
      //   443: iload_1
      //   444: putfield 99	com/tencent/d/e/a/a/k:ZpO	I
      //   447: goto -349 -> 98
      //   450: astore 10
      //   452: goto -354 -> 98
      //   455: iconst_2
      //   456: istore_1
      //   457: goto -16 -> 441
      //   460: ldc 204
      //   462: aload 10
      //   464: invokevirtual 124	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   467: ifeq +25 -> 492
      //   470: aload 7
      //   472: iconst_2
      //   473: putfield 127	com/tencent/d/e/a/a/k:ZpQ	I
      //   476: goto -340 -> 136
      //   479: astore 7
      //   481: aload 8
      //   483: monitorexit
      //   484: ldc 35
      //   486: invokestatic 163	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   489: aload 7
      //   491: athrow
      //   492: ldc 206
      //   494: aload 10
      //   496: invokevirtual 124	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   499: ifeq -363 -> 136
      //   502: aload 7
      //   504: iconst_3
      //   505: putfield 127	com/tencent/d/e/a/a/k:ZpQ	I
      //   508: goto -372 -> 136
      //   511: aload 9
      //   513: ldc 208
      //   515: iconst_m1
      //   516: invokevirtual 144	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
      //   519: istore_1
      //   520: iload_1
      //   521: iconst_2
      //   522: if_icmpne +12 -> 534
      //   525: aload 7
      //   527: iconst_3
      //   528: putfield 147	com/tencent/d/e/a/a/k:ZpR	I
      //   531: goto -341 -> 190
      //   534: iload_1
      //   535: iconst_1
      //   536: if_icmpne +12 -> 548
      //   539: aload 7
      //   541: iconst_2
      //   542: putfield 147	com/tencent/d/e/a/a/k:ZpR	I
      //   545: goto -355 -> 190
      //   548: aload 7
      //   550: iconst_0
      //   551: putfield 147	com/tencent/d/e/a/a/k:ZpR	I
      //   554: goto -364 -> 190
      //   557: astore 7
      //   559: aload 8
      //   561: monitorexit
      //   562: ldc 35
      //   564: invokestatic 163	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   567: aload 7
      //   569: athrow
      //   570: aload_0
      //   571: getfield 18	com/tencent/d/e/a/e$a:Zpo	Lcom/tencent/d/e/a/e;
      //   574: invokevirtual 211	com/tencent/d/e/a/e:TV	()Z
      //   577: pop
      //   578: aload 7
      //   580: monitorexit
      //   581: ldc 35
      //   583: invokestatic 163	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   586: return
      //   587: astore 8
      //   589: aload 7
      //   591: monitorexit
      //   592: ldc 35
      //   594: invokestatic 163	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   597: aload 8
      //   599: athrow
      //   600: aload_0
      //   601: aload_0
      //   602: getfield 23	com/tencent/d/e/a/e$a:mCount	I
      //   605: iconst_1
      //   606: iadd
      //   607: putfield 23	com/tencent/d/e/a/e$a:mCount	I
      //   610: aload_0
      //   611: getfield 27	com/tencent/d/e/a/e$a:Zpu	J
      //   614: getstatic 216	com/tencent/d/e/a/a/f:Zpx	J
      //   617: aload_0
      //   618: getfield 23	com/tencent/d/e/a/e$a:mCount	I
      //   621: i2l
      //   622: lmul
      //   623: ladd
      //   624: invokestatic 222	java/lang/System:currentTimeMillis	()J
      //   627: lsub
      //   628: lstore 5
      //   630: lload 5
      //   632: lconst_0
      //   633: lcmp
      //   634: ifle +29 -> 663
      //   637: aload_0
      //   638: getfield 18	com/tencent/d/e/a/e$a:Zpo	Lcom/tencent/d/e/a/e;
      //   641: invokestatic 226	com/tencent/d/e/a/e:e	(Lcom/tencent/d/e/a/e;)Lcom/tencent/mm/sdk/platformtools/MMHandler;
      //   644: aload_0
      //   645: getfield 18	com/tencent/d/e/a/e$a:Zpo	Lcom/tencent/d/e/a/e;
      //   648: invokestatic 230	com/tencent/d/e/a/e:d	(Lcom/tencent/d/e/a/e;)Lcom/tencent/d/e/a/e$a;
      //   651: lload 5
      //   653: invokevirtual 236	com/tencent/mm/sdk/platformtools/MMHandler:postDelayed	(Ljava/lang/Runnable;J)Z
      //   656: pop
      //   657: ldc 35
      //   659: invokestatic 163	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   662: return
      //   663: aload_0
      //   664: getfield 18	com/tencent/d/e/a/e$a:Zpo	Lcom/tencent/d/e/a/e;
      //   667: invokestatic 226	com/tencent/d/e/a/e:e	(Lcom/tencent/d/e/a/e;)Lcom/tencent/mm/sdk/platformtools/MMHandler;
      //   670: aload_0
      //   671: getfield 18	com/tencent/d/e/a/e$a:Zpo	Lcom/tencent/d/e/a/e;
      //   674: invokestatic 230	com/tencent/d/e/a/e:d	(Lcom/tencent/d/e/a/e;)Lcom/tencent/d/e/a/e$a;
      //   677: invokevirtual 240	com/tencent/mm/sdk/platformtools/MMHandler:post	(Ljava/lang/Runnable;)Z
      //   680: pop
      //   681: ldc 35
      //   683: invokestatic 163	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   686: return
      //   687: goto +8 -> 695
      //   690: iconst_1
      //   691: istore_1
      //   692: goto -512 -> 180
      //   695: iload_2
      //   696: iconst_1
      //   697: iadd
      //   698: istore_2
      //   699: goto -347 -> 352
      //   702: iload_1
      //   703: ifeq +8 -> 711
      //   706: iconst_1
      //   707: istore_1
      //   708: goto -309 -> 399
      //   711: iconst_2
      //   712: istore_1
      //   713: goto -314 -> 399
      //   716: iconst_0
      //   717: istore_1
      //   718: goto -538 -> 180
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	721	0	this	a
      //   91	627	1	i	int
      //   351	348	2	j	int
      //   349	6	3	k	int
      //   370	22	4	m	int
      //   628	24	5	l	long
      //   479	70	7	localObject2	Object
      //   557	33	7	localObject3	Object
      //   587	11	8	localObject5	Object
      //   33	479	9	localObject6	Object
      //   48	384	10	localObject7	Object
      //   450	45	10	localThrowable	Throwable
      //   60	313	11	localObject8	Object
      //   336	28	12	localField	java.lang.reflect.Field
      //   361	14	13	localObject9	Object
      // Exception table:
      //   from	to	target	type
      //   35	85	450	java/lang/Throwable
      //   92	98	450	java/lang/Throwable
      //   262	275	450	java/lang/Throwable
      //   285	344	450	java/lang/Throwable
      //   346	350	450	java/lang/Throwable
      //   363	394	450	java/lang/Throwable
      //   399	411	450	java/lang/Throwable
      //   414	426	450	java/lang/Throwable
      //   431	439	450	java/lang/Throwable
      //   441	447	450	java/lang/Throwable
      //   23	35	479	finally
      //   35	85	479	finally
      //   92	98	479	finally
      //   98	136	479	finally
      //   136	153	479	finally
      //   158	167	479	finally
      //   184	190	479	finally
      //   190	193	479	finally
      //   262	275	479	finally
      //   285	344	479	finally
      //   346	350	479	finally
      //   363	394	479	finally
      //   399	411	479	finally
      //   414	426	479	finally
      //   431	439	479	finally
      //   441	447	479	finally
      //   460	476	479	finally
      //   492	508	479	finally
      //   511	520	479	finally
      //   525	531	479	finally
      //   539	545	479	finally
      //   548	554	479	finally
      //   205	223	557	finally
      //   243	256	587	finally
      //   570	581	587	finally
    }
    
    public final void ioc()
    {
      AppMethodBeat.i(138384);
      if (e.f(e.this) != null) {
        e.f(e.this);
      }
      AppMethodBeat.o(138384);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.e.a.e
 * JD-Core Version:    0.7.0.1
 */