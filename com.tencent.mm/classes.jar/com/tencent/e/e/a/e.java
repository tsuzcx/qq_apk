package com.tencent.e.e.a;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.e.e.a.a.c;
import com.tencent.e.e.a.a.f;
import com.tencent.e.e.a.a.g;
import com.tencent.e.e.a.a.g.a;
import com.tencent.e.e.a.a.h;
import com.tencent.e.e.a.a.k;
import com.tencent.e.f.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.List;

public final class e
{
  private static final j<e> MtV;
  private g ahtP;
  private final List<k> ahtQ;
  private d ahtR;
  private b ahtS;
  private com.tencent.e.e.a.a.d ahtT;
  private final Runnable ahtU;
  private final a ahtV;
  private boolean bzr;
  private final MMHandler mHandler;
  
  static
  {
    AppMethodBeat.i(138392);
    MtV = new j() {};
    AppMethodBeat.o(138392);
  }
  
  private e()
  {
    AppMethodBeat.i(138386);
    this.bzr = false;
    this.ahtQ = new ArrayList();
    this.ahtU = new c()
    {
      public final void bXC()
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
          if (e.g(e.this).Ba(e.a(e.this).Tzj))
          {
            long l = e.g(e.this).ahum.jXr();
            e.a locala = e.d(e.this);
            int i = (int)(e.a(e.this).Tzj / f.ahuf);
            locala.mCount = 1;
            locala.sfk = i;
            locala.ahuc = l;
            l = l + f.ahuf - System.currentTimeMillis();
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
      
      public final void jXn()
      {
        AppMethodBeat.i(138378);
        if (e.f(e.this) != null) {
          e.f(e.this);
        }
        AppMethodBeat.o(138378);
      }
    };
    this.ahtV = new a((byte)0);
    this.mHandler = new MMHandler("TuringMMCore");
    AppMethodBeat.o(138386);
  }
  
  public static e jXm()
  {
    AppMethodBeat.i(138385);
    e locale = (e)MtV.get();
    AppMethodBeat.o(138385);
    return locale;
  }
  
  public final void a(Context paramContext, final String paramString, final com.tencent.e.e.a.a.e parame)
  {
    try
    {
      AppMethodBeat.i(138389);
      h localh = h.jXt();
      if (!localh.mInit) {
        localh.init(paramContext);
      }
      this.mHandler.post(new c()
      {
        /* Error */
        public final void bXC()
        {
          // Byte code:
          //   0: ldc 29
          //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
          //   5: invokestatic 41	com/tencent/e/e/a/a/h:jXt	()Lcom/tencent/e/e/a/a/h;
          //   8: invokevirtual 45	com/tencent/e/e/a/a/h:jXu	()Ljava/util/Map;
          //   11: astore_3
          //   12: new 47	java/util/HashMap
          //   15: dup
          //   16: invokespecial 48	java/util/HashMap:<init>	()V
          //   19: astore_2
          //   20: aload_3
          //   21: invokeinterface 54 1 0
          //   26: ifeq +86 -> 112
          //   29: aload_3
          //   30: iconst_0
          //   31: invokestatic 58	com/tencent/e/e/a/a/h:j	(Ljava/util/Map;I)Lcom/tencent/e/e/a/a/h$a;
          //   34: astore 4
          //   36: aload 4
          //   38: ifnull +20 -> 58
          //   41: aload_2
          //   42: aload 4
          //   44: getfield 64	com/tencent/e/e/a/a/h$a:ahur	Lcom/tencent/e/e/a/b/a;
          //   47: aload 4
          //   49: getfield 68	com/tencent/e/e/a/a/h$a:ahus	Ljava/util/List;
          //   52: invokeinterface 72 3 0
          //   57: pop
          //   58: aload_3
          //   59: iconst_1
          //   60: invokestatic 58	com/tencent/e/e/a/a/h:j	(Ljava/util/Map;I)Lcom/tencent/e/e/a/a/h$a;
          //   63: astore 4
          //   65: aload 4
          //   67: ifnull +20 -> 87
          //   70: aload_2
          //   71: aload 4
          //   73: getfield 64	com/tencent/e/e/a/a/h$a:ahur	Lcom/tencent/e/e/a/b/a;
          //   76: aload 4
          //   78: getfield 68	com/tencent/e/e/a/a/h$a:ahus	Ljava/util/List;
          //   81: invokeinterface 72 3 0
          //   86: pop
          //   87: aload_3
          //   88: iconst_2
          //   89: invokestatic 58	com/tencent/e/e/a/a/h:j	(Ljava/util/Map;I)Lcom/tencent/e/e/a/a/h$a;
          //   92: astore_3
          //   93: aload_3
          //   94: ifnull +18 -> 112
          //   97: aload_2
          //   98: aload_3
          //   99: getfield 64	com/tencent/e/e/a/a/h$a:ahur	Lcom/tencent/e/e/a/b/a;
          //   102: aload_3
          //   103: getfield 68	com/tencent/e/e/a/a/h$a:ahus	Ljava/util/List;
          //   106: invokeinterface 72 3 0
          //   111: pop
          //   112: aload_2
          //   113: invokeinterface 54 1 0
          //   118: ifne +18 -> 136
          //   121: aload_0
          //   122: getfield 21	com/tencent/e/e/a/e$4:ahua	Lcom/tencent/e/e/a/a/e;
          //   125: invokeinterface 77 1 0
          //   130: ldc 29
          //   132: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   135: return
          //   136: aload_2
          //   137: invokeinterface 84 1 0
          //   142: invokeinterface 90 1 0
          //   147: astore_3
          //   148: aload_3
          //   149: invokeinterface 96 1 0
          //   154: ifeq +145 -> 299
          //   157: aload_3
          //   158: invokeinterface 100 1 0
          //   163: checkcast 102	com/tencent/e/e/a/b/a
          //   166: astore 4
          //   168: aload 4
          //   170: invokestatic 108	java/lang/System:currentTimeMillis	()J
          //   173: putfield 112	com/tencent/e/e/a/b/a:ahuA	J
          //   176: aload 4
          //   178: aload_0
          //   179: getfield 23	com/tencent/e/e/a/e$4:ahub	Ljava/lang/String;
          //   182: putfield 115	com/tencent/e/e/a/b/a:hTs	Ljava/lang/String;
          //   185: aload_0
          //   186: getfield 21	com/tencent/e/e/a/e$4:ahua	Lcom/tencent/e/e/a/a/e;
          //   189: instanceof 117
          //   192: ifeq +81 -> 273
          //   195: aload_0
          //   196: getfield 21	com/tencent/e/e/a/e$4:ahua	Lcom/tencent/e/e/a/a/e;
          //   199: checkcast 117	com/tencent/e/e/a/a
          //   202: aload 4
          //   204: invokestatic 120	com/tencent/e/e/a/e:a	(Lcom/tencent/e/e/a/a;Lcom/tencent/e/e/a/b/a;)Z
          //   207: istore_1
          //   208: iload_1
          //   209: ifeq -61 -> 148
          //   212: aload_2
          //   213: aload 4
          //   215: invokeinterface 124 2 0
          //   220: checkcast 126	java/util/List
          //   223: invokeinterface 127 1 0
          //   228: astore 4
          //   230: aload 4
          //   232: invokeinterface 96 1 0
          //   237: ifeq -89 -> 148
          //   240: aload 4
          //   242: invokeinterface 100 1 0
          //   247: checkcast 129	java/lang/String
          //   250: astore 5
          //   252: new 131	java/io/File
          //   255: dup
          //   256: aload 5
          //   258: invokespecial 134	java/io/File:<init>	(Ljava/lang/String;)V
          //   261: invokevirtual 137	java/io/File:delete	()Z
          //   264: pop
          //   265: goto -35 -> 230
          //   268: astore 5
          //   270: goto -40 -> 230
          //   273: aload_0
          //   274: getfield 21	com/tencent/e/e/a/e$4:ahua	Lcom/tencent/e/e/a/a/e;
          //   277: instanceof 139
          //   280: ifeq +25 -> 305
          //   283: aload_0
          //   284: getfield 21	com/tencent/e/e/a/e$4:ahua	Lcom/tencent/e/e/a/a/e;
          //   287: checkcast 139	com/tencent/e/e/a/c
          //   290: aload 4
          //   292: invokestatic 142	com/tencent/e/e/a/e:a	(Lcom/tencent/e/e/a/c;Lcom/tencent/e/e/a/b/a;)Z
          //   295: istore_1
          //   296: goto -88 -> 208
          //   299: ldc 29
          //   301: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   304: return
          //   305: iconst_0
          //   306: istore_1
          //   307: goto -99 -> 208
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	310	0	this	4
          //   207	100	1	bool	boolean
          //   19	194	2	localHashMap	java.util.HashMap
          //   11	147	3	localObject1	Object
          //   34	257	4	localObject2	Object
          //   250	7	5	str	String
          //   268	1	5	localObject3	Object
          // Exception table:
          //   from	to	target	type
          //   252	265	268	finally
        }
        
        public final void jXn()
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
    //   4: ldc 187
    //   6: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_1
    //   10: getfield 193	com/tencent/e/e/a/d:context	Landroid/content/Context;
    //   13: astore_3
    //   14: aload_3
    //   15: ifnonnull +14 -> 29
    //   18: iconst_0
    //   19: istore_2
    //   20: ldc 187
    //   22: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: aload_0
    //   26: monitorexit
    //   27: iload_2
    //   28: ireturn
    //   29: invokestatic 171	com/tencent/e/e/a/a/h:jXt	()Lcom/tencent/e/e/a/a/h;
    //   32: astore 4
    //   34: aload 4
    //   36: getfield 174	com/tencent/e/e/a/a/h:mInit	Z
    //   39: ifne +9 -> 48
    //   42: aload 4
    //   44: aload_3
    //   45: invokevirtual 178	com/tencent/e/e/a/a/h:init	(Landroid/content/Context;)V
    //   48: aload_0
    //   49: getfield 59	com/tencent/e/e/a/e:bzr	Z
    //   52: ifeq +8 -> 60
    //   55: aload_0
    //   56: invokevirtual 197	com/tencent/e/e/a/e:stop	()Z
    //   59: pop
    //   60: aload_0
    //   61: aload_1
    //   62: putfield 88	com/tencent/e/e/a/e:ahtR	Lcom/tencent/e/e/a/d;
    //   65: aload_0
    //   66: iconst_1
    //   67: putfield 59	com/tencent/e/e/a/e:bzr	Z
    //   70: aload_0
    //   71: getfield 150	com/tencent/e/e/a/e:ahtP	Lcom/tencent/e/e/a/a/g;
    //   74: ifnonnull +14 -> 88
    //   77: aload_0
    //   78: new 199	com/tencent/e/e/a/a/g
    //   81: dup
    //   82: invokespecial 200	com/tencent/e/e/a/a/g:<init>	()V
    //   85: putfield 150	com/tencent/e/e/a/e:ahtP	Lcom/tencent/e/e/a/a/g;
    //   88: aload_0
    //   89: getfield 150	com/tencent/e/e/a/e:ahtP	Lcom/tencent/e/e/a/a/g;
    //   92: ifnull +27 -> 119
    //   95: aload_0
    //   96: getfield 150	com/tencent/e/e/a/e:ahtP	Lcom/tencent/e/e/a/a/g;
    //   99: astore 4
    //   101: aload 4
    //   103: getfield 204	com/tencent/e/e/a/a/g:ahuk	Landroid/util/SparseArray;
    //   106: astore_3
    //   107: aload_3
    //   108: monitorenter
    //   109: aload 4
    //   111: getfield 204	com/tencent/e/e/a/a/g:ahuk	Landroid/util/SparseArray;
    //   114: invokevirtual 209	android/util/SparseArray:clear	()V
    //   117: aload_3
    //   118: monitorexit
    //   119: aload_0
    //   120: getfield 64	com/tencent/e/e/a/e:ahtQ	Ljava/util/List;
    //   123: astore_3
    //   124: aload_3
    //   125: monitorenter
    //   126: aload_0
    //   127: getfield 64	com/tencent/e/e/a/e:ahtQ	Ljava/util/List;
    //   130: invokeinterface 212 1 0
    //   135: aload_3
    //   136: monitorexit
    //   137: aload_0
    //   138: getfield 83	com/tencent/e/e/a/e:mHandler	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   141: aload_0
    //   142: getfield 69	com/tencent/e/e/a/e:ahtU	Ljava/lang/Runnable;
    //   145: aload_1
    //   146: getfield 216	com/tencent/e/e/a/d:delayTime	J
    //   149: invokevirtual 220	com/tencent/mm/sdk/platformtools/MMHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   152: pop
    //   153: ldc 187
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
    //   169: ldc 187
    //   171: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   174: aload_1
    //   175: athrow
    //   176: astore_1
    //   177: aload_3
    //   178: monitorexit
    //   179: ldc 187
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
  
  public final boolean stop()
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(138388);
        if (!this.bzr)
        {
          AppMethodBeat.o(138388);
          bool = true;
          return bool;
        }
        this.bzr = false;
        if (this.ahtR == null)
        {
          AppMethodBeat.o(138388);
          continue;
        }
        this.mHandler.removeCallbacks(this.ahtU);
      }
      finally {}
      this.mHandler.removeCallbacks(this.ahtV);
      if (this.ahtP != null)
      {
        this.ahtP.jXp();
        if ((int)(this.ahtP.ahum.jXs() / f.ahuf) < 3) {
          AppMethodBeat.o(138388);
        }
      }
      else
      {
        AppMethodBeat.o(138388);
        bool = true;
        continue;
      }
      SparseArray localSparseArray1 = this.ahtP.jXq();
      if (localSparseArray1.size() == 0)
      {
        AppMethodBeat.o(138388);
      }
      else
      {
        final ArrayList localArrayList;
        final int i;
        final int j;
        synchronized (this.ahtQ)
        {
          localArrayList = new ArrayList(this.ahtQ);
          if (localArrayList.size() < 3) {
            AppMethodBeat.o(138388);
          }
        }
        final int k = this.ahtR.requestType;
        this.mHandler.post(new c()
        {
          /* Error */
          public final void bXC()
          {
            // Byte code:
            //   0: ldc 41
            //   2: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
            //   5: aload_0
            //   6: getfield 23	com/tencent/e/e/a/e$3:ahtW	Lcom/tencent/e/e/a/e;
            //   9: astore_3
            //   10: aload_3
            //   11: monitorenter
            //   12: aload_0
            //   13: getfield 25	com/tencent/e/e/a/e$3:ahtX	I
            //   16: aload_0
            //   17: getfield 27	com/tencent/e/e/a/e$3:hli	I
            //   20: aload_0
            //   21: getfield 23	com/tencent/e/e/a/e$3:ahtW	Lcom/tencent/e/e/a/e;
            //   24: invokestatic 51	com/tencent/e/e/a/e:a	(Lcom/tencent/e/e/a/e;)Lcom/tencent/e/e/a/d;
            //   27: getfield 57	com/tencent/e/e/a/d:context	Landroid/content/Context;
            //   30: aload_0
            //   31: getfield 29	com/tencent/e/e/a/e$3:XcG	I
            //   34: aload_0
            //   35: getfield 31	com/tencent/e/e/a/e$3:ahtY	Landroid/util/SparseArray;
            //   38: aload_0
            //   39: getfield 33	com/tencent/e/e/a/e$3:ahtZ	Ljava/util/List;
            //   42: invokestatic 62	com/tencent/e/e/a/a/b:a	(IILandroid/content/Context;ILandroid/util/SparseArray;Ljava/util/List;)Lcom/tencent/e/e/a/b/a;
            //   45: astore 5
            //   47: aload_3
            //   48: monitorexit
            //   49: invokestatic 68	com/tencent/e/e/a/a/h:jXt	()Lcom/tencent/e/e/a/a/h;
            //   52: astore 4
            //   54: aload_0
            //   55: getfield 25	com/tencent/e/e/a/e$3:ahtX	I
            //   58: istore_1
            //   59: aload_0
            //   60: getfield 27	com/tencent/e/e/a/e$3:hli	I
            //   63: istore_2
            //   64: aload 5
            //   66: invokevirtual 74	com/tencent/e/e/a/b/a:toByteArray	()[B
            //   69: invokestatic 80	com/tencent/e/f/b:compress	([B)[B
            //   72: invokestatic 85	com/tencent/e/f/c:jXz	()[B
            //   75: invokestatic 89	com/tencent/e/f/c:q	([B[B)[B
            //   78: astore 5
            //   80: aload 5
            //   82: ifnull +86 -> 168
            //   85: aload 4
            //   87: getfield 92	com/tencent/e/e/a/a/h:mContext	Landroid/content/Context;
            //   90: ldc 94
            //   92: iconst_0
            //   93: invokevirtual 100	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
            //   96: astore_3
            //   97: aload_3
            //   98: ifnonnull +113 -> 211
            //   101: ldc 102
            //   103: astore_3
            //   104: aload_3
            //   105: invokestatic 108	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
            //   108: ifne +60 -> 168
            //   111: new 110	java/io/BufferedOutputStream
            //   114: dup
            //   115: new 112	java/io/FileOutputStream
            //   118: dup
            //   119: aload_3
            //   120: invokespecial 115	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
            //   123: invokespecial 118	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
            //   126: astore_3
            //   127: aload_3
            //   128: aload 5
            //   130: invokevirtual 122	java/io/BufferedOutputStream:write	([B)V
            //   133: aload_3
            //   134: invokevirtual 125	java/io/BufferedOutputStream:flush	()V
            //   137: aload_3
            //   138: invokestatic 131	com/tencent/e/f/f:closeQuietly	(Ljava/io/Closeable;)V
            //   141: aload 4
            //   143: iload_1
            //   144: iload_2
            //   145: invokevirtual 135	com/tencent/e/e/a/a/h:pG	(II)Ljava/lang/String;
            //   148: astore_3
            //   149: aload_3
            //   150: invokestatic 108	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
            //   153: ifne +15 -> 168
            //   156: new 137	java/io/File
            //   159: dup
            //   160: aload_3
            //   161: invokespecial 138	java/io/File:<init>	(Ljava/lang/String;)V
            //   164: invokevirtual 141	java/io/File:delete	()Z
            //   167: pop
            //   168: aload_0
            //   169: getfield 23	com/tencent/e/e/a/e$3:ahtW	Lcom/tencent/e/e/a/e;
            //   172: invokestatic 145	com/tencent/e/e/a/e:h	(Lcom/tencent/e/e/a/e;)Lcom/tencent/e/e/a/b;
            //   175: ifnull +11 -> 186
            //   178: aload_0
            //   179: getfield 23	com/tencent/e/e/a/e$3:ahtW	Lcom/tencent/e/e/a/e;
            //   182: invokestatic 145	com/tencent/e/e/a/e:h	(Lcom/tencent/e/e/a/e;)Lcom/tencent/e/e/a/b;
            //   185: pop
            //   186: ldc 41
            //   188: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
            //   191: return
            //   192: astore 4
            //   194: aload_3
            //   195: monitorexit
            //   196: ldc 41
            //   198: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
            //   201: aload 4
            //   203: athrow
            //   204: astore_3
            //   205: ldc 41
            //   207: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
            //   210: return
            //   211: new 150	java/lang/StringBuilder
            //   214: dup
            //   215: invokespecial 151	java/lang/StringBuilder:<init>	()V
            //   218: aload_3
            //   219: invokevirtual 155	java/io/File:getAbsolutePath	()Ljava/lang/String;
            //   222: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   225: getstatic 163	java/io/File:separator	Ljava/lang/String;
            //   228: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   231: iload_1
            //   232: iload_2
            //   233: invokestatic 166	com/tencent/e/e/a/a/h:pH	(II)Ljava/lang/String;
            //   236: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   239: ldc 168
            //   241: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   244: invokestatic 174	java/lang/System:currentTimeMillis	()J
            //   247: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
            //   250: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
            //   253: astore_3
            //   254: goto -150 -> 104
            //   257: astore_3
            //   258: aconst_null
            //   259: astore_3
            //   260: aload_3
            //   261: invokestatic 131	com/tencent/e/f/f:closeQuietly	(Ljava/io/Closeable;)V
            //   264: goto -123 -> 141
            //   267: astore 5
            //   269: goto -9 -> 260
            // Local variable table:
            //   start	length	slot	name	signature
            //   0	272	0	this	3
            //   58	174	1	i	int
            //   63	170	2	j	int
            //   9	186	3	localObject1	Object
            //   204	15	3	localIllegalArgumentException	java.lang.IllegalArgumentException
            //   253	1	3	str	String
            //   257	1	3	localObject2	Object
            //   259	2	3	localCloseable	java.io.Closeable
            //   52	90	4	localh	h
            //   192	10	4	localObject3	Object
            //   45	84	5	localObject4	Object
            //   267	1	5	localObject5	Object
            // Exception table:
            //   from	to	target	type
            //   12	49	192	finally
            //   5	12	204	java/lang/IllegalArgumentException
            //   194	204	204	java/lang/IllegalArgumentException
            //   111	127	257	finally
            //   127	137	267	finally
          }
          
          public final void jXn()
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
  
  final class a
    extends c
  {
    long ahuc = 0L;
    int mCount = 1;
    int sfk = 3;
    
    private a() {}
    
    /* Error */
    public final void bXC()
    {
      // Byte code:
      //   0: ldc 33
      //   2: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: new 41	com/tencent/e/e/a/a/k
      //   8: dup
      //   9: invokespecial 42	com/tencent/e/e/a/a/k:<init>	()V
      //   12: astore 7
      //   14: aload_0
      //   15: getfield 18	com/tencent/e/e/a/e$a:ahtW	Lcom/tencent/e/e/a/e;
      //   18: astore 8
      //   20: aload 8
      //   22: monitorenter
      //   23: aload_0
      //   24: getfield 18	com/tencent/e/e/a/e$a:ahtW	Lcom/tencent/e/e/a/e;
      //   27: invokestatic 45	com/tencent/e/e/a/e:a	(Lcom/tencent/e/e/a/e;)Lcom/tencent/e/e/a/d;
      //   30: getfield 51	com/tencent/e/e/a/d:context	Landroid/content/Context;
      //   33: astore 9
      //   35: getstatic 56	android/os/Build$VERSION:SDK_INT	I
      //   38: bipush 20
      //   40: if_icmplt +371 -> 411
      //   43: ldc 58
      //   45: invokestatic 64	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
      //   48: astore 10
      //   50: aload 9
      //   52: invokevirtual 70	java/lang/Object:getClass	()Ljava/lang/Class;
      //   55: ldc 72
      //   57: invokevirtual 76	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
      //   60: astore 11
      //   62: aload 11
      //   64: iconst_1
      //   65: invokevirtual 82	java/lang/reflect/Field:setAccessible	(Z)V
      //   68: aload 9
      //   70: aload 11
      //   72: aload 9
      //   74: invokevirtual 86	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
      //   77: checkcast 88	java/lang/String
      //   80: invokevirtual 94	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
      //   83: astore 11
      //   85: aload 11
      //   87: ifnonnull +175 -> 262
      //   90: iconst_0
      //   91: istore_1
      //   92: aload 7
      //   94: iload_1
      //   95: putfield 97	com/tencent/e/e/a/a/k:ahuw	I
      //   98: new 99	java/io/File
      //   101: dup
      //   102: ldc 101
      //   104: invokespecial 104	java/io/File:<init>	(Ljava/lang/String;)V
      //   107: invokestatic 110	com/tencent/e/f/f:X	(Ljava/io/File;)Ljava/lang/String;
      //   110: astore 10
      //   112: aload 10
      //   114: invokestatic 116	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   117: ifne +19 -> 136
      //   120: ldc 118
      //   122: aload 10
      //   124: invokevirtual 122	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   127: ifeq +330 -> 457
      //   130: aload 7
      //   132: iconst_1
      //   133: putfield 125	com/tencent/e/e/a/a/k:ahuy	I
      //   136: aload 9
      //   138: aconst_null
      //   139: new 127	android/content/IntentFilter
      //   142: dup
      //   143: ldc 129
      //   145: invokespecial 130	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
      //   148: invokevirtual 134	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
      //   151: astore 9
      //   153: aload 9
      //   155: ifnull +35 -> 190
      //   158: aload 9
      //   160: ldc 136
      //   162: iconst_m1
      //   163: invokevirtual 142	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
      //   166: istore_1
      //   167: iload_1
      //   168: iconst_2
      //   169: if_icmpeq +518 -> 687
      //   172: iload_1
      //   173: iconst_5
      //   174: if_icmpne +539 -> 713
      //   177: goto +510 -> 687
      //   180: iload_1
      //   181: ifne +327 -> 508
      //   184: aload 7
      //   186: iconst_1
      //   187: putfield 145	com/tencent/e/e/a/a/k:ahuz	I
      //   190: aload 8
      //   192: monitorexit
      //   193: aload_0
      //   194: getfield 18	com/tencent/e/e/a/e$a:ahtW	Lcom/tencent/e/e/a/e;
      //   197: invokestatic 149	com/tencent/e/e/a/e:b	(Lcom/tencent/e/e/a/e;)Ljava/util/List;
      //   200: astore 8
      //   202: aload 8
      //   204: monitorenter
      //   205: aload_0
      //   206: getfield 18	com/tencent/e/e/a/e$a:ahtW	Lcom/tencent/e/e/a/e;
      //   209: invokestatic 149	com/tencent/e/e/a/e:b	(Lcom/tencent/e/e/a/e;)Ljava/util/List;
      //   212: aload 7
      //   214: invokeinterface 154 2 0
      //   219: pop
      //   220: aload 8
      //   222: monitorexit
      //   223: aload_0
      //   224: getfield 23	com/tencent/e/e/a/e$a:mCount	I
      //   227: aload_0
      //   228: getfield 25	com/tencent/e/e/a/e$a:sfk	I
      //   231: if_icmplt +366 -> 597
      //   234: aload_0
      //   235: getfield 18	com/tencent/e/e/a/e$a:ahtW	Lcom/tencent/e/e/a/e;
      //   238: astore 7
      //   240: aload 7
      //   242: monitorenter
      //   243: aload_0
      //   244: getfield 18	com/tencent/e/e/a/e$a:ahtW	Lcom/tencent/e/e/a/e;
      //   247: invokestatic 158	com/tencent/e/e/a/e:c	(Lcom/tencent/e/e/a/e;)Z
      //   250: ifne +317 -> 567
      //   253: aload 7
      //   255: monitorexit
      //   256: ldc 33
      //   258: invokestatic 161	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   261: return
      //   262: aload 10
      //   264: ldc 163
      //   266: iconst_0
      //   267: anewarray 60	java/lang/Class
      //   270: invokevirtual 167	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
      //   273: astore 10
      //   275: aload 10
      //   277: ifnonnull +8 -> 285
      //   280: iconst_0
      //   281: istore_1
      //   282: goto -190 -> 92
      //   285: aload 10
      //   287: iconst_1
      //   288: invokevirtual 170	java/lang/reflect/Method:setAccessible	(Z)V
      //   291: aload 10
      //   293: aload 11
      //   295: iconst_0
      //   296: anewarray 66	java/lang/Object
      //   299: invokevirtual 174	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
      //   302: checkcast 176	[Landroid/view/Display;
      //   305: astore 10
      //   307: ldc 178
      //   309: ldc 180
      //   311: iconst_0
      //   312: anewarray 60	java/lang/Class
      //   315: invokevirtual 167	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
      //   318: astore 11
      //   320: aload 11
      //   322: iconst_1
      //   323: invokevirtual 170	java/lang/reflect/Method:setAccessible	(Z)V
      //   326: ldc 178
      //   328: ldc 182
      //   330: invokevirtual 76	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
      //   333: astore 12
      //   335: aload 12
      //   337: iconst_1
      //   338: invokevirtual 82	java/lang/reflect/Field:setAccessible	(Z)V
      //   341: iconst_0
      //   342: istore_1
      //   343: aload 10
      //   345: arraylength
      //   346: istore_3
      //   347: iconst_0
      //   348: istore_2
      //   349: iload_2
      //   350: iload_3
      //   351: if_icmpge +348 -> 699
      //   354: aload 10
      //   356: iload_2
      //   357: aaload
      //   358: astore 13
      //   360: aload 12
      //   362: aload 13
      //   364: invokevirtual 186	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
      //   367: istore 4
      //   369: aload 11
      //   371: aload 13
      //   373: iconst_0
      //   374: anewarray 66	java/lang/Object
      //   377: invokevirtual 174	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
      //   380: checkcast 188	java/lang/Integer
      //   383: invokevirtual 192	java/lang/Integer:intValue	()I
      //   386: iload 4
      //   388: if_icmpeq +296 -> 684
      //   391: iconst_1
      //   392: istore_1
      //   393: goto +299 -> 692
      //   396: aload 7
      //   398: iload_1
      //   399: putfield 97	com/tencent/e/e/a/a/k:ahuw	I
      //   402: aload 7
      //   404: getfield 97	com/tencent/e/e/a/a/k:ahuw	I
      //   407: istore_1
      //   408: goto -316 -> 92
      //   411: aload 9
      //   413: ldc 194
      //   415: invokevirtual 94	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
      //   418: checkcast 196	android/os/PowerManager
      //   421: astore 10
      //   423: aload 10
      //   425: ifnull -327 -> 98
      //   428: aload 10
      //   430: invokevirtual 200	android/os/PowerManager:isScreenOn	()Z
      //   433: ifeq +19 -> 452
      //   436: iconst_1
      //   437: istore_1
      //   438: aload 7
      //   440: iload_1
      //   441: putfield 97	com/tencent/e/e/a/a/k:ahuw	I
      //   444: goto -346 -> 98
      //   447: astore 10
      //   449: goto -351 -> 98
      //   452: iconst_2
      //   453: istore_1
      //   454: goto -16 -> 438
      //   457: ldc 202
      //   459: aload 10
      //   461: invokevirtual 122	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   464: ifeq +25 -> 489
      //   467: aload 7
      //   469: iconst_2
      //   470: putfield 125	com/tencent/e/e/a/a/k:ahuy	I
      //   473: goto -337 -> 136
      //   476: astore 7
      //   478: aload 8
      //   480: monitorexit
      //   481: ldc 33
      //   483: invokestatic 161	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   486: aload 7
      //   488: athrow
      //   489: ldc 204
      //   491: aload 10
      //   493: invokevirtual 122	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   496: ifeq -360 -> 136
      //   499: aload 7
      //   501: iconst_3
      //   502: putfield 125	com/tencent/e/e/a/a/k:ahuy	I
      //   505: goto -369 -> 136
      //   508: aload 9
      //   510: ldc 206
      //   512: iconst_m1
      //   513: invokevirtual 142	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
      //   516: istore_1
      //   517: iload_1
      //   518: iconst_2
      //   519: if_icmpne +12 -> 531
      //   522: aload 7
      //   524: iconst_3
      //   525: putfield 145	com/tencent/e/e/a/a/k:ahuz	I
      //   528: goto -338 -> 190
      //   531: iload_1
      //   532: iconst_1
      //   533: if_icmpne +12 -> 545
      //   536: aload 7
      //   538: iconst_2
      //   539: putfield 145	com/tencent/e/e/a/a/k:ahuz	I
      //   542: goto -352 -> 190
      //   545: aload 7
      //   547: iconst_0
      //   548: putfield 145	com/tencent/e/e/a/a/k:ahuz	I
      //   551: goto -361 -> 190
      //   554: astore 7
      //   556: aload 8
      //   558: monitorexit
      //   559: ldc 33
      //   561: invokestatic 161	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   564: aload 7
      //   566: athrow
      //   567: aload_0
      //   568: getfield 18	com/tencent/e/e/a/e$a:ahtW	Lcom/tencent/e/e/a/e;
      //   571: invokevirtual 209	com/tencent/e/e/a/e:stop	()Z
      //   574: pop
      //   575: aload 7
      //   577: monitorexit
      //   578: ldc 33
      //   580: invokestatic 161	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   583: return
      //   584: astore 8
      //   586: aload 7
      //   588: monitorexit
      //   589: ldc 33
      //   591: invokestatic 161	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   594: aload 8
      //   596: athrow
      //   597: aload_0
      //   598: aload_0
      //   599: getfield 23	com/tencent/e/e/a/e$a:mCount	I
      //   602: iconst_1
      //   603: iadd
      //   604: putfield 23	com/tencent/e/e/a/e$a:mCount	I
      //   607: aload_0
      //   608: getfield 27	com/tencent/e/e/a/e$a:ahuc	J
      //   611: getstatic 214	com/tencent/e/e/a/a/f:ahuf	J
      //   614: aload_0
      //   615: getfield 23	com/tencent/e/e/a/e$a:mCount	I
      //   618: i2l
      //   619: lmul
      //   620: ladd
      //   621: invokestatic 220	java/lang/System:currentTimeMillis	()J
      //   624: lsub
      //   625: lstore 5
      //   627: lload 5
      //   629: lconst_0
      //   630: lcmp
      //   631: ifle +29 -> 660
      //   634: aload_0
      //   635: getfield 18	com/tencent/e/e/a/e$a:ahtW	Lcom/tencent/e/e/a/e;
      //   638: invokestatic 224	com/tencent/e/e/a/e:e	(Lcom/tencent/e/e/a/e;)Lcom/tencent/mm/sdk/platformtools/MMHandler;
      //   641: aload_0
      //   642: getfield 18	com/tencent/e/e/a/e$a:ahtW	Lcom/tencent/e/e/a/e;
      //   645: invokestatic 228	com/tencent/e/e/a/e:d	(Lcom/tencent/e/e/a/e;)Lcom/tencent/e/e/a/e$a;
      //   648: lload 5
      //   650: invokevirtual 234	com/tencent/mm/sdk/platformtools/MMHandler:postDelayed	(Ljava/lang/Runnable;J)Z
      //   653: pop
      //   654: ldc 33
      //   656: invokestatic 161	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   659: return
      //   660: aload_0
      //   661: getfield 18	com/tencent/e/e/a/e$a:ahtW	Lcom/tencent/e/e/a/e;
      //   664: invokestatic 224	com/tencent/e/e/a/e:e	(Lcom/tencent/e/e/a/e;)Lcom/tencent/mm/sdk/platformtools/MMHandler;
      //   667: aload_0
      //   668: getfield 18	com/tencent/e/e/a/e$a:ahtW	Lcom/tencent/e/e/a/e;
      //   671: invokestatic 228	com/tencent/e/e/a/e:d	(Lcom/tencent/e/e/a/e;)Lcom/tencent/e/e/a/e$a;
      //   674: invokevirtual 238	com/tencent/mm/sdk/platformtools/MMHandler:post	(Ljava/lang/Runnable;)Z
      //   677: pop
      //   678: ldc 33
      //   680: invokestatic 161	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   683: return
      //   684: goto +8 -> 692
      //   687: iconst_1
      //   688: istore_1
      //   689: goto -509 -> 180
      //   692: iload_2
      //   693: iconst_1
      //   694: iadd
      //   695: istore_2
      //   696: goto -347 -> 349
      //   699: iload_1
      //   700: ifeq +8 -> 708
      //   703: iconst_1
      //   704: istore_1
      //   705: goto -309 -> 396
      //   708: iconst_2
      //   709: istore_1
      //   710: goto -314 -> 396
      //   713: iconst_0
      //   714: istore_1
      //   715: goto -535 -> 180
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	718	0	this	a
      //   91	624	1	i	int
      //   348	348	2	j	int
      //   346	6	3	k	int
      //   367	22	4	m	int
      //   625	24	5	l	long
      //   476	70	7	localObject2	Object
      //   554	33	7	localObject3	Object
      //   584	11	8	localObject5	Object
      //   33	476	9	localObject6	Object
      //   48	381	10	localObject7	Object
      //   447	45	10	localObject8	Object
      //   60	310	11	localObject9	Object
      //   333	28	12	localField	java.lang.reflect.Field
      //   358	14	13	localObject10	Object
      // Exception table:
      //   from	to	target	type
      //   35	85	447	finally
      //   92	98	447	finally
      //   262	275	447	finally
      //   285	341	447	finally
      //   343	347	447	finally
      //   360	391	447	finally
      //   396	408	447	finally
      //   411	423	447	finally
      //   428	436	447	finally
      //   438	444	447	finally
      //   23	35	476	finally
      //   98	136	476	finally
      //   136	153	476	finally
      //   158	167	476	finally
      //   184	190	476	finally
      //   190	193	476	finally
      //   457	473	476	finally
      //   489	505	476	finally
      //   508	517	476	finally
      //   522	528	476	finally
      //   536	542	476	finally
      //   545	551	476	finally
      //   205	223	554	finally
      //   243	256	584	finally
      //   567	578	584	finally
    }
    
    public final void jXn()
    {
      AppMethodBeat.i(138384);
      if (e.f(e.this) != null) {
        e.f(e.this);
      }
      AppMethodBeat.o(138384);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.e.e.a.e
 * JD-Core Version:    0.7.0.1
 */