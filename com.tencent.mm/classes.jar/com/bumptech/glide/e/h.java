package com.bumptech.glide.e;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.support.v4.e.l.a;
import android.util.Log;
import com.bumptech.glide.g.a.a.a;
import com.bumptech.glide.g.a.a.c;
import com.bumptech.glide.g.a.b;
import com.bumptech.glide.g.a.b.a;
import com.bumptech.glide.g.f;
import com.bumptech.glide.load.b.k.d;
import com.bumptech.glide.load.b.q;
import com.bumptech.glide.load.b.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

public final class h<R>
  implements com.bumptech.glide.e.a.d, c, g, a.c
{
  private static final l.a<h<?>> aHW;
  private static final boolean aNm;
  private com.bumptech.glide.load.b.k aCi;
  private com.bumptech.glide.e aCm;
  private Class<R> aDd;
  private Object aDf;
  private List<e<R>> aDg;
  private v<R> aFJ;
  private com.bumptech.glide.g aGc;
  private final b aGi;
  private Drawable aMY;
  private int aNa;
  private int aNb;
  private Drawable aNd;
  private boolean aNl;
  private e<R> aNn;
  private d aNo;
  private a<?> aNp;
  private com.bumptech.glide.e.a.e<R> aNq;
  private com.bumptech.glide.e.b.c<? super R> aNr;
  private Executor aNs;
  private k.d aNt;
  private a aNu;
  private Drawable aNv;
  private RuntimeException aNw;
  private Context context;
  private int height;
  private long startTime;
  private final String tag;
  private int width;
  
  static
  {
    AppMethodBeat.i(77686);
    aHW = com.bumptech.glide.g.a.a.a(150, new a.a() {});
    aNm = Log.isLoggable("Request", 2);
    AppMethodBeat.o(77686);
  }
  
  h()
  {
    AppMethodBeat.i(77661);
    if (aNm) {}
    for (String str = String.valueOf(super.hashCode());; str = null)
    {
      this.tag = str;
      this.aGi = new b.a();
      AppMethodBeat.o(77661);
      return;
    }
  }
  
  private void V(String paramString)
  {
    AppMethodBeat.i(77685);
    new StringBuilder().append(paramString).append(" this: ").append(this.tag);
    AppMethodBeat.o(77685);
  }
  
  public static <R> h<R> a(Context paramContext, com.bumptech.glide.e parame, Object paramObject, Class<R> paramClass, a<?> parama, int paramInt1, int paramInt2, com.bumptech.glide.g paramg, com.bumptech.glide.e.a.e<R> parame1, e<R> parame2, List<e<R>> paramList, d paramd, com.bumptech.glide.load.b.k paramk, com.bumptech.glide.e.b.c<? super R> paramc, Executor paramExecutor)
  {
    AppMethodBeat.i(204489);
    h localh2 = (h)aHW.acquire();
    h localh1 = localh2;
    if (localh2 == null) {
      localh1 = new h();
    }
    localh1.b(paramContext, parame, paramObject, paramClass, parama, paramInt1, paramInt2, paramg, parame1, parame2, paramList, paramd, paramk, paramc, paramExecutor);
    AppMethodBeat.o(204489);
    return localh1;
  }
  
  private void a(q paramq, int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(77683);
        this.aGi.qz();
        paramq.exception = this.aNw;
        int i = this.aCm.aCy;
        if (i <= paramInt)
        {
          new StringBuilder("Load failed for ").append(this.aDf).append(" with size [").append(this.width).append("x").append(this.height).append("]");
          if (i <= 4) {
            paramq.oX();
          }
        }
        this.aNt = null;
        this.aNu = a.aNB;
        this.aNl = true;
        try
        {
          if (this.aDg != null)
          {
            paramq = this.aDg.iterator();
            paramInt = 0;
            i = paramInt;
            if (paramq.hasNext())
            {
              e locale = (e)paramq.next();
              ql();
              paramInt |= locale.qe();
              continue;
            }
            if (this.aNn != null)
            {
              paramq = this.aNn;
              ql();
              if (paramq.qe())
              {
                paramInt = 1;
                if ((paramInt | i) == 0) {
                  qj();
                }
                this.aNl = false;
                if (this.aNo != null) {
                  this.aNo.g(this);
                }
                AppMethodBeat.o(77683);
                return;
              }
            }
            paramInt = 0;
            continue;
            paramq = finally;
          }
        }
        finally
        {
          this.aNl = false;
          AppMethodBeat.o(77683);
        }
        i = 0;
      }
      finally {}
    }
  }
  
  private void a(v<R> paramv, R paramR, com.bumptech.glide.load.a parama)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(77681);
        ql();
        this.aNu = a.aNA;
        this.aFJ = paramv;
        if (this.aCm.aCy <= 3) {
          new StringBuilder("Finished loading ").append(paramR.getClass().getSimpleName()).append(" from ").append(parama).append(" for ").append(this.aDf).append(" with size [").append(this.width).append("x").append(this.height).append("] in ").append(f.p(this.startTime)).append(" ms");
        }
        this.aNl = true;
        try
        {
          if (this.aDg != null)
          {
            paramv = this.aDg.iterator();
            boolean bool1 = false;
            bool2 = bool1;
            if (paramv.hasNext())
            {
              bool1 |= ((e)paramv.next()).qf();
              continue;
            }
            if ((this.aNn != null) && (this.aNn.qf()))
            {
              bool1 = true;
              if (!(bool1 | bool2))
              {
                this.aNr.qp();
                this.aNq.aa(paramR);
              }
              this.aNl = false;
              if (this.aNo != null) {
                this.aNo.f(this);
              }
              AppMethodBeat.o(77681);
              return;
            }
            bool1 = false;
            continue;
            paramv = finally;
          }
        }
        finally
        {
          this.aNl = false;
          AppMethodBeat.o(77681);
        }
        boolean bool2 = false;
      }
      finally {}
    }
  }
  
  private boolean a(h<?> paramh)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(204491);
        int i;
        int j;
        try
        {
          if (this.aDg == null)
          {
            i = 0;
            if (paramh.aDg == null)
            {
              j = 0;
              break label91;
              AppMethodBeat.o(204491);
              return bool;
            }
          }
          else
          {
            i = this.aDg.size();
            continue;
          }
          j = paramh.aDg.size();
        }
        finally
        {
          AppMethodBeat.o(204491);
        }
        if (i != j) {
          continue;
        }
      }
      finally {}
      label91:
      bool = true;
    }
  }
  
  private void b(Context paramContext, com.bumptech.glide.e parame, Object paramObject, Class<R> paramClass, a<?> parama, int paramInt1, int paramInt2, com.bumptech.glide.g paramg, com.bumptech.glide.e.a.e<R> parame1, e<R> parame2, List<e<R>> paramList, d paramd, com.bumptech.glide.load.b.k paramk, com.bumptech.glide.e.b.c<? super R> paramc, Executor paramExecutor)
  {
    try
    {
      AppMethodBeat.i(204490);
      this.context = paramContext;
      this.aCm = parame;
      this.aDf = paramObject;
      this.aDd = paramClass;
      this.aNp = parama;
      this.aNb = paramInt1;
      this.aNa = paramInt2;
      this.aGc = paramg;
      this.aNq = parame1;
      this.aNn = parame2;
      this.aDg = paramList;
      this.aNo = paramd;
      this.aCi = paramk;
      this.aNr = paramc;
      this.aNs = paramExecutor;
      this.aNu = a.aNx;
      if ((this.aNw == null) && (parame.aCE)) {
        this.aNw = new RuntimeException("Glide request origin trace");
      }
      AppMethodBeat.o(204490);
      return;
    }
    finally {}
  }
  
  private Drawable dp(int paramInt)
  {
    AppMethodBeat.i(77671);
    if (this.aNp.aNf != null) {}
    for (Object localObject = this.aNp.aNf;; localObject = this.context.getTheme())
    {
      localObject = com.bumptech.glide.load.d.c.a.a(this.aCm, paramInt, (Resources.Theme)localObject);
      AppMethodBeat.o(77671);
      return localObject;
    }
  }
  
  private void f(v<?> paramv)
  {
    AppMethodBeat.i(77667);
    com.bumptech.glide.load.b.k.b(paramv);
    this.aFJ = null;
    AppMethodBeat.o(77667);
  }
  
  private static int g(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(77674);
    if (paramInt == -2147483648)
    {
      AppMethodBeat.o(77674);
      return paramInt;
    }
    paramInt = Math.round(paramInt * paramFloat);
    AppMethodBeat.o(77674);
    return paramInt;
  }
  
  private void qg()
  {
    AppMethodBeat.i(77664);
    if (this.aNl)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
      AppMethodBeat.o(77664);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(77664);
  }
  
  private Drawable qh()
  {
    AppMethodBeat.i(77669);
    if (this.aMY == null)
    {
      this.aMY = this.aNp.aMY;
      if ((this.aMY == null) && (this.aNp.aMZ > 0)) {
        this.aMY = dp(this.aNp.aMZ);
      }
    }
    Drawable localDrawable = this.aMY;
    AppMethodBeat.o(77669);
    return localDrawable;
  }
  
  private Drawable qi()
  {
    AppMethodBeat.i(77670);
    if (this.aNd == null)
    {
      this.aNd = this.aNp.aNd;
      if ((this.aNd == null) && (this.aNp.aNe > 0)) {
        this.aNd = dp(this.aNp.aNe);
      }
    }
    Drawable localDrawable = this.aNd;
    AppMethodBeat.o(77670);
    return localDrawable;
  }
  
  /* Error */
  private void qj()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 412
    //   5: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokespecial 415	com/bumptech/glide/e/h:qk	()Z
    //   12: ifne +12 -> 24
    //   15: ldc_w 412
    //   18: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aconst_null
    //   25: astore_1
    //   26: aload_0
    //   27: getfield 187	com/bumptech/glide/e/h:aDf	Ljava/lang/Object;
    //   30: ifnonnull +8 -> 38
    //   33: aload_0
    //   34: invokespecial 417	com/bumptech/glide/e/h:qi	()Landroid/graphics/drawable/Drawable;
    //   37: astore_1
    //   38: aload_1
    //   39: astore_2
    //   40: aload_1
    //   41: ifnonnull +58 -> 99
    //   44: aload_0
    //   45: getfield 419	com/bumptech/glide/e/h:aNv	Landroid/graphics/drawable/Drawable;
    //   48: ifnonnull +46 -> 94
    //   51: aload_0
    //   52: aload_0
    //   53: getfield 327	com/bumptech/glide/e/h:aNp	Lcom/bumptech/glide/e/a;
    //   56: getfield 422	com/bumptech/glide/e/a:aMW	Landroid/graphics/drawable/Drawable;
    //   59: putfield 419	com/bumptech/glide/e/h:aNv	Landroid/graphics/drawable/Drawable;
    //   62: aload_0
    //   63: getfield 419	com/bumptech/glide/e/h:aNv	Landroid/graphics/drawable/Drawable;
    //   66: ifnonnull +28 -> 94
    //   69: aload_0
    //   70: getfield 327	com/bumptech/glide/e/h:aNp	Lcom/bumptech/glide/e/a;
    //   73: getfield 425	com/bumptech/glide/e/a:aMX	I
    //   76: ifle +18 -> 94
    //   79: aload_0
    //   80: aload_0
    //   81: aload_0
    //   82: getfield 327	com/bumptech/glide/e/h:aNp	Lcom/bumptech/glide/e/a;
    //   85: getfield 425	com/bumptech/glide/e/a:aMX	I
    //   88: invokespecial 403	com/bumptech/glide/e/h:dp	(I)Landroid/graphics/drawable/Drawable;
    //   91: putfield 419	com/bumptech/glide/e/h:aNv	Landroid/graphics/drawable/Drawable;
    //   94: aload_0
    //   95: getfield 419	com/bumptech/glide/e/h:aNv	Landroid/graphics/drawable/Drawable;
    //   98: astore_2
    //   99: aload_2
    //   100: ifnonnull +8 -> 108
    //   103: aload_0
    //   104: invokespecial 427	com/bumptech/glide/e/h:qh	()Landroid/graphics/drawable/Drawable;
    //   107: pop
    //   108: ldc_w 412
    //   111: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   114: goto -93 -> 21
    //   117: astore_1
    //   118: aload_0
    //   119: monitorexit
    //   120: aload_1
    //   121: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	this	h
    //   25	16	1	localDrawable1	Drawable
    //   117	4	1	localObject	Object
    //   39	61	2	localDrawable2	Drawable
    // Exception table:
    //   from	to	target	type
    //   2	21	117	finally
    //   26	38	117	finally
    //   44	94	117	finally
    //   94	99	117	finally
    //   103	108	117	finally
    //   108	114	117	finally
  }
  
  private boolean qk()
  {
    AppMethodBeat.i(77676);
    if ((this.aNo == null) || (this.aNo.c(this)))
    {
      AppMethodBeat.o(77676);
      return true;
    }
    AppMethodBeat.o(77676);
    return false;
  }
  
  private boolean ql()
  {
    AppMethodBeat.i(77677);
    if ((this.aNo == null) || (!this.aNo.qd()))
    {
      AppMethodBeat.o(77677);
      return true;
    }
    AppMethodBeat.o(77677);
    return false;
  }
  
  public final void a(q paramq)
  {
    try
    {
      AppMethodBeat.i(185718);
      a(paramq, 5);
      AppMethodBeat.o(185718);
      return;
    }
    finally
    {
      paramq = finally;
      throw paramq;
    }
  }
  
  public final boolean a(c paramc)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(77684);
        if ((paramc instanceof h))
        {
          paramc = (h)paramc;
          bool1 = bool2;
          try
          {
            if (this.aNb == paramc.aNb)
            {
              bool1 = bool2;
              if (this.aNa == paramc.aNa)
              {
                bool1 = bool2;
                if (com.bumptech.glide.g.k.i(this.aDf, paramc.aDf))
                {
                  bool1 = bool2;
                  if (this.aDd.equals(paramc.aDd))
                  {
                    bool1 = bool2;
                    if (this.aNp.equals(paramc.aNp))
                    {
                      bool1 = bool2;
                      if (this.aGc == paramc.aGc)
                      {
                        bool1 = bool2;
                        if (a(paramc)) {
                          bool1 = true;
                        }
                      }
                    }
                  }
                }
              }
            }
            AppMethodBeat.o(77684);
            return bool1;
          }
          finally
          {
            AppMethodBeat.o(77684);
          }
        }
        AppMethodBeat.o(77684);
      }
      finally {}
    }
  }
  
  /* Error */
  public final void aS(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 456
    //   5: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 132	com/bumptech/glide/e/h:aGi	Lcom/bumptech/glide/g/a/b;
    //   12: invokevirtual 166	com/bumptech/glide/g/a/b:qz	()V
    //   15: getstatic 109	com/bumptech/glide/e/h:aNm	Z
    //   18: ifeq +30 -> 48
    //   21: aload_0
    //   22: new 137	java/lang/StringBuilder
    //   25: dup
    //   26: ldc_w 458
    //   29: invokespecial 185	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   32: aload_0
    //   33: getfield 280	com/bumptech/glide/e/h:startTime	J
    //   36: invokestatic 286	com/bumptech/glide/g/f:p	(J)D
    //   39: invokevirtual 289	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   42: invokevirtual 461	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokespecial 463	com/bumptech/glide/e/h:V	(Ljava/lang/String;)V
    //   48: aload_0
    //   49: getfield 213	com/bumptech/glide/e/h:aNu	Lcom/bumptech/glide/e/h$a;
    //   52: getstatic 466	com/bumptech/glide/e/h$a:aNz	Lcom/bumptech/glide/e/h$a;
    //   55: if_acmpeq +12 -> 67
    //   58: ldc_w 456
    //   61: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: aload_0
    //   65: monitorexit
    //   66: return
    //   67: aload_0
    //   68: getstatic 469	com/bumptech/glide/e/h$a:aNy	Lcom/bumptech/glide/e/h$a;
    //   71: putfield 213	com/bumptech/glide/e/h:aNu	Lcom/bumptech/glide/e/h$a;
    //   74: aload_0
    //   75: getfield 327	com/bumptech/glide/e/h:aNp	Lcom/bumptech/glide/e/a;
    //   78: getfield 473	com/bumptech/glide/e/a:aMV	F
    //   81: fstore_3
    //   82: aload_0
    //   83: iload_1
    //   84: fload_3
    //   85: invokestatic 475	com/bumptech/glide/e/h:g	(IF)I
    //   88: putfield 194	com/bumptech/glide/e/h:width	I
    //   91: aload_0
    //   92: iload_2
    //   93: fload_3
    //   94: invokestatic 475	com/bumptech/glide/e/h:g	(IF)I
    //   97: putfield 201	com/bumptech/glide/e/h:height	I
    //   100: getstatic 109	com/bumptech/glide/e/h:aNm	Z
    //   103: ifeq +30 -> 133
    //   106: aload_0
    //   107: new 137	java/lang/StringBuilder
    //   110: dup
    //   111: ldc_w 477
    //   114: invokespecial 185	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   117: aload_0
    //   118: getfield 280	com/bumptech/glide/e/h:startTime	J
    //   121: invokestatic 286	com/bumptech/glide/g/f:p	(J)D
    //   124: invokevirtual 289	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   127: invokevirtual 461	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokespecial 463	com/bumptech/glide/e/h:V	(Ljava/lang/String;)V
    //   133: aload_0
    //   134: aload_0
    //   135: getfield 335	com/bumptech/glide/e/h:aCi	Lcom/bumptech/glide/load/b/k;
    //   138: aload_0
    //   139: getfield 176	com/bumptech/glide/e/h:aCm	Lcom/bumptech/glide/e;
    //   142: aload_0
    //   143: getfield 187	com/bumptech/glide/e/h:aDf	Ljava/lang/Object;
    //   146: aload_0
    //   147: getfield 327	com/bumptech/glide/e/h:aNp	Lcom/bumptech/glide/e/a;
    //   150: getfield 481	com/bumptech/glide/e/a:aFT	Lcom/bumptech/glide/load/g;
    //   153: aload_0
    //   154: getfield 194	com/bumptech/glide/e/h:width	I
    //   157: aload_0
    //   158: getfield 201	com/bumptech/glide/e/h:height	I
    //   161: aload_0
    //   162: getfield 327	com/bumptech/glide/e/h:aNp	Lcom/bumptech/glide/e/a;
    //   165: getfield 484	com/bumptech/glide/e/a:aFX	Ljava/lang/Class;
    //   168: aload_0
    //   169: getfield 325	com/bumptech/glide/e/h:aDd	Ljava/lang/Class;
    //   172: aload_0
    //   173: getfield 333	com/bumptech/glide/e/h:aGc	Lcom/bumptech/glide/g;
    //   176: aload_0
    //   177: getfield 327	com/bumptech/glide/e/h:aNp	Lcom/bumptech/glide/e/a;
    //   180: getfield 488	com/bumptech/glide/e/a:aGd	Lcom/bumptech/glide/load/b/j;
    //   183: aload_0
    //   184: getfield 327	com/bumptech/glide/e/h:aNp	Lcom/bumptech/glide/e/a;
    //   187: getfield 492	com/bumptech/glide/e/a:aFZ	Ljava/util/Map;
    //   190: aload_0
    //   191: getfield 327	com/bumptech/glide/e/h:aNp	Lcom/bumptech/glide/e/a;
    //   194: getfield 495	com/bumptech/glide/e/a:aGe	Z
    //   197: aload_0
    //   198: getfield 327	com/bumptech/glide/e/h:aNp	Lcom/bumptech/glide/e/a;
    //   201: getfield 498	com/bumptech/glide/e/a:aGf	Z
    //   204: aload_0
    //   205: getfield 327	com/bumptech/glide/e/h:aNp	Lcom/bumptech/glide/e/a;
    //   208: getfield 502	com/bumptech/glide/e/a:aFV	Lcom/bumptech/glide/load/i;
    //   211: aload_0
    //   212: getfield 327	com/bumptech/glide/e/h:aNp	Lcom/bumptech/glide/e/a;
    //   215: getfield 505	com/bumptech/glide/e/a:aFI	Z
    //   218: aload_0
    //   219: getfield 327	com/bumptech/glide/e/h:aNp	Lcom/bumptech/glide/e/a;
    //   222: getfield 508	com/bumptech/glide/e/a:aNh	Z
    //   225: aload_0
    //   226: getfield 327	com/bumptech/glide/e/h:aNp	Lcom/bumptech/glide/e/a;
    //   229: getfield 511	com/bumptech/glide/e/a:aHC	Z
    //   232: aload_0
    //   233: getfield 327	com/bumptech/glide/e/h:aNp	Lcom/bumptech/glide/e/a;
    //   236: getfield 514	com/bumptech/glide/e/a:aGr	Z
    //   239: aload_0
    //   240: aload_0
    //   241: getfield 337	com/bumptech/glide/e/h:aNs	Ljava/util/concurrent/Executor;
    //   244: invokevirtual 517	com/bumptech/glide/load/b/k:a	(Lcom/bumptech/glide/e;Ljava/lang/Object;Lcom/bumptech/glide/load/g;IILjava/lang/Class;Ljava/lang/Class;Lcom/bumptech/glide/g;Lcom/bumptech/glide/load/b/j;Ljava/util/Map;ZZLcom/bumptech/glide/load/i;ZZZZLcom/bumptech/glide/e/g;Ljava/util/concurrent/Executor;)Lcom/bumptech/glide/load/b/k$d;
    //   247: putfield 208	com/bumptech/glide/e/h:aNt	Lcom/bumptech/glide/load/b/k$d;
    //   250: aload_0
    //   251: getfield 213	com/bumptech/glide/e/h:aNu	Lcom/bumptech/glide/e/h$a;
    //   254: getstatic 469	com/bumptech/glide/e/h$a:aNy	Lcom/bumptech/glide/e/h$a;
    //   257: if_acmpeq +8 -> 265
    //   260: aload_0
    //   261: aconst_null
    //   262: putfield 208	com/bumptech/glide/e/h:aNt	Lcom/bumptech/glide/load/b/k$d;
    //   265: getstatic 109	com/bumptech/glide/e/h:aNm	Z
    //   268: ifeq +30 -> 298
    //   271: aload_0
    //   272: new 137	java/lang/StringBuilder
    //   275: dup
    //   276: ldc_w 519
    //   279: invokespecial 185	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   282: aload_0
    //   283: getfield 280	com/bumptech/glide/e/h:startTime	J
    //   286: invokestatic 286	com/bumptech/glide/g/f:p	(J)D
    //   289: invokevirtual 289	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   292: invokevirtual 461	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: invokespecial 463	com/bumptech/glide/e/h:V	(Ljava/lang/String;)V
    //   298: ldc_w 456
    //   301: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   304: goto -240 -> 64
    //   307: astore 4
    //   309: aload_0
    //   310: monitorexit
    //   311: aload 4
    //   313: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	314	0	this	h
    //   0	314	1	paramInt1	int
    //   0	314	2	paramInt2	int
    //   81	13	3	f	float
    //   307	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	48	307	finally
    //   48	64	307	finally
    //   67	133	307	finally
    //   133	265	307	finally
    //   265	298	307	finally
    //   298	304	307	finally
  }
  
  public final void begin()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(77663);
        qg();
        this.aGi.qz();
        this.startTime = f.qt();
        if (this.aDf == null)
        {
          if (com.bumptech.glide.g.k.aT(this.aNb, this.aNa))
          {
            this.width = this.aNb;
            this.height = this.aNa;
          }
          if (qi() == null)
          {
            i = 5;
            a(new q("Received null model"), i);
            AppMethodBeat.o(77663);
            return;
          }
          int i = 3;
          continue;
        }
        if (this.aNu == a.aNy)
        {
          IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Cannot restart a running request");
          AppMethodBeat.o(77663);
          throw localIllegalArgumentException;
        }
      }
      finally {}
      if (this.aNu != a.aNA) {
        break;
      }
      c(this.aFJ, com.bumptech.glide.load.a.aEK);
      AppMethodBeat.o(77663);
    }
    this.aNu = a.aNz;
    if (com.bumptech.glide.g.k.aT(this.aNb, this.aNa)) {
      aS(this.aNb, this.aNa);
    }
    for (;;)
    {
      if (((this.aNu == a.aNy) || (this.aNu == a.aNz)) && (qk())) {
        qh();
      }
      if (aNm) {
        V("finished run method in " + f.p(this.startTime));
      }
      AppMethodBeat.o(77663);
      break;
      this.aNq.a(this);
    }
  }
  
  public final void c(v<?> paramv, com.bumptech.glide.load.a parama)
  {
    Object localObject;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(77680);
        this.aGi.qz();
        this.aNt = null;
        if (paramv == null)
        {
          a(new q("Expected to receive a Resource<R> with an object of " + this.aDd + " inside, but instead got null."));
          AppMethodBeat.o(77680);
          return;
        }
        localObject = paramv.get();
        if ((localObject != null) && (this.aDd.isAssignableFrom(localObject.getClass()))) {
          break;
        }
        f(paramv);
        StringBuilder localStringBuilder = new StringBuilder("Expected to receive an object of ").append(this.aDd).append(" but instead got ");
        if (localObject != null)
        {
          parama = localObject.getClass();
          parama = localStringBuilder.append(parama).append("{").append(localObject).append("} inside Resource{").append(paramv).append("}.");
          if (localObject == null) {
            break label287;
          }
          paramv = "";
          label182:
          a(new q(paramv));
          AppMethodBeat.o(77680);
        }
        else
        {
          parama = "";
        }
      }
      finally {}
    }
    if (this.aNo != null) {
      if (!this.aNo.b(this)) {
        break label299;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        f(paramv);
        this.aNu = a.aNA;
        AppMethodBeat.o(77680);
        break;
      }
      a(paramv, localObject, parama);
      AppMethodBeat.o(77680);
      break;
      label287:
      paramv = " To indicate failure return a null Resource object, rather than a Resource object containing null data.";
      break label182;
      int i = 1;
      continue;
      label299:
      i = 0;
    }
  }
  
  /* Error */
  public final void clear()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 594
    //   5: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokespecial 523	com/bumptech/glide/e/h:qg	()V
    //   12: aload_0
    //   13: getfield 132	com/bumptech/glide/e/h:aGi	Lcom/bumptech/glide/g/a/b;
    //   16: invokevirtual 166	com/bumptech/glide/g/a/b:qz	()V
    //   19: aload_0
    //   20: getfield 213	com/bumptech/glide/e/h:aNu	Lcom/bumptech/glide/e/h$a;
    //   23: getstatic 597	com/bumptech/glide/e/h$a:aNC	Lcom/bumptech/glide/e/h$a;
    //   26: if_acmpne +12 -> 38
    //   29: ldc_w 594
    //   32: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: aload_0
    //   36: monitorexit
    //   37: return
    //   38: aload_0
    //   39: invokespecial 523	com/bumptech/glide/e/h:qg	()V
    //   42: aload_0
    //   43: getfield 132	com/bumptech/glide/e/h:aGi	Lcom/bumptech/glide/g/a/b;
    //   46: invokevirtual 166	com/bumptech/glide/g/a/b:qz	()V
    //   49: aload_0
    //   50: getfield 208	com/bumptech/glide/e/h:aNt	Lcom/bumptech/glide/load/b/k$d;
    //   53: ifnull +33 -> 86
    //   56: aload_0
    //   57: getfield 208	com/bumptech/glide/e/h:aNt	Lcom/bumptech/glide/load/b/k$d;
    //   60: astore_3
    //   61: aload_3
    //   62: getfield 602	com/bumptech/glide/load/b/k$d:aHw	Lcom/bumptech/glide/load/b/k;
    //   65: astore_2
    //   66: aload_2
    //   67: monitorenter
    //   68: aload_3
    //   69: getfield 606	com/bumptech/glide/load/b/k$d:aHu	Lcom/bumptech/glide/load/b/l;
    //   72: aload_3
    //   73: getfield 610	com/bumptech/glide/load/b/k$d:aHv	Lcom/bumptech/glide/e/g;
    //   76: invokevirtual 615	com/bumptech/glide/load/b/l:c	(Lcom/bumptech/glide/e/g;)V
    //   79: aload_2
    //   80: monitorexit
    //   81: aload_0
    //   82: aconst_null
    //   83: putfield 208	com/bumptech/glide/e/h:aNt	Lcom/bumptech/glide/load/b/k$d;
    //   86: aload_0
    //   87: getfield 260	com/bumptech/glide/e/h:aFJ	Lcom/bumptech/glide/load/b/v;
    //   90: ifnull +11 -> 101
    //   93: aload_0
    //   94: aload_0
    //   95: getfield 260	com/bumptech/glide/e/h:aFJ	Lcom/bumptech/glide/load/b/v;
    //   98: invokespecial 573	com/bumptech/glide/e/h:f	(Lcom/bumptech/glide/load/b/v;)V
    //   101: aload_0
    //   102: getfield 247	com/bumptech/glide/e/h:aNo	Lcom/bumptech/glide/e/d;
    //   105: ifnull +65 -> 170
    //   108: aload_0
    //   109: getfield 247	com/bumptech/glide/e/h:aNo	Lcom/bumptech/glide/e/d;
    //   112: aload_0
    //   113: invokeinterface 618 2 0
    //   118: ifeq +47 -> 165
    //   121: goto +49 -> 170
    //   124: iload_1
    //   125: ifeq +8 -> 133
    //   128: aload_0
    //   129: invokespecial 427	com/bumptech/glide/e/h:qh	()Landroid/graphics/drawable/Drawable;
    //   132: pop
    //   133: aload_0
    //   134: getstatic 597	com/bumptech/glide/e/h$a:aNC	Lcom/bumptech/glide/e/h$a;
    //   137: putfield 213	com/bumptech/glide/e/h:aNu	Lcom/bumptech/glide/e/h$a;
    //   140: ldc_w 594
    //   143: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: goto -111 -> 35
    //   149: astore_2
    //   150: aload_0
    //   151: monitorexit
    //   152: aload_2
    //   153: athrow
    //   154: astore_3
    //   155: aload_2
    //   156: monitorexit
    //   157: ldc_w 594
    //   160: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   163: aload_3
    //   164: athrow
    //   165: iconst_0
    //   166: istore_1
    //   167: goto -43 -> 124
    //   170: iconst_1
    //   171: istore_1
    //   172: goto -48 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	h
    //   124	48	1	i	int
    //   149	7	2	localObject1	Object
    //   60	13	3	locald	k.d
    //   154	10	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	35	149	finally
    //   38	68	149	finally
    //   81	86	149	finally
    //   86	101	149	finally
    //   101	121	149	finally
    //   128	133	149	finally
    //   133	146	149	finally
    //   157	165	149	finally
    //   68	81	154	finally
    //   155	157	154	finally
  }
  
  /* Error */
  public final boolean isComplete()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 213	com/bumptech/glide/e/h:aNu	Lcom/bumptech/glide/e/h$a;
    //   6: astore_2
    //   7: getstatic 258	com/bumptech/glide/e/h$a:aNA	Lcom/bumptech/glide/e/h$a;
    //   10: astore_3
    //   11: aload_2
    //   12: aload_3
    //   13: if_acmpne +9 -> 22
    //   16: iconst_1
    //   17: istore_1
    //   18: aload_0
    //   19: monitorexit
    //   20: iload_1
    //   21: ireturn
    //   22: iconst_0
    //   23: istore_1
    //   24: goto -6 -> 18
    //   27: astore_2
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_2
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	h
    //   17	7	1	bool	boolean
    //   6	6	2	locala1	a
    //   27	4	2	localObject	Object
    //   10	3	3	locala2	a
    // Exception table:
    //   from	to	target	type
    //   2	11	27	finally
  }
  
  /* Error */
  public final boolean isFailed()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 213	com/bumptech/glide/e/h:aNu	Lcom/bumptech/glide/e/h$a;
    //   6: astore_2
    //   7: getstatic 211	com/bumptech/glide/e/h$a:aNB	Lcom/bumptech/glide/e/h$a;
    //   10: astore_3
    //   11: aload_2
    //   12: aload_3
    //   13: if_acmpne +9 -> 22
    //   16: iconst_1
    //   17: istore_1
    //   18: aload_0
    //   19: monitorexit
    //   20: iload_1
    //   21: ireturn
    //   22: iconst_0
    //   23: istore_1
    //   24: goto -6 -> 18
    //   27: astore_2
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_2
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	h
    //   17	7	1	bool	boolean
    //   6	6	2	locala1	a
    //   27	4	2	localObject	Object
    //   10	3	3	locala2	a
    // Exception table:
    //   from	to	target	type
    //   2	11	27	finally
  }
  
  /* Error */
  public final boolean isRunning()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 213	com/bumptech/glide/e/h:aNu	Lcom/bumptech/glide/e/h$a;
    //   6: getstatic 469	com/bumptech/glide/e/h$a:aNy	Lcom/bumptech/glide/e/h$a;
    //   9: if_acmpeq +17 -> 26
    //   12: aload_0
    //   13: getfield 213	com/bumptech/glide/e/h:aNu	Lcom/bumptech/glide/e/h$a;
    //   16: astore_2
    //   17: getstatic 466	com/bumptech/glide/e/h$a:aNz	Lcom/bumptech/glide/e/h$a;
    //   20: astore_3
    //   21: aload_2
    //   22: aload_3
    //   23: if_acmpne +9 -> 32
    //   26: iconst_1
    //   27: istore_1
    //   28: aload_0
    //   29: monitorexit
    //   30: iload_1
    //   31: ireturn
    //   32: iconst_0
    //   33: istore_1
    //   34: goto -6 -> 28
    //   37: astore_2
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_2
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	h
    //   27	7	1	bool	boolean
    //   16	6	2	locala1	a
    //   37	4	2	localObject	Object
    //   20	3	3	locala2	a
    // Exception table:
    //   from	to	target	type
    //   2	21	37	finally
  }
  
  public final b oK()
  {
    return this.aGi;
  }
  
  public final boolean qb()
  {
    try
    {
      AppMethodBeat.i(77668);
      boolean bool = isComplete();
      AppMethodBeat.o(77668);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final boolean qc()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 213	com/bumptech/glide/e/h:aNu	Lcom/bumptech/glide/e/h$a;
    //   6: astore_2
    //   7: getstatic 597	com/bumptech/glide/e/h$a:aNC	Lcom/bumptech/glide/e/h$a;
    //   10: astore_3
    //   11: aload_2
    //   12: aload_3
    //   13: if_acmpne +9 -> 22
    //   16: iconst_1
    //   17: istore_1
    //   18: aload_0
    //   19: monitorexit
    //   20: iload_1
    //   21: ireturn
    //   22: iconst_0
    //   23: istore_1
    //   24: goto -6 -> 18
    //   27: astore_2
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_2
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	h
    //   17	7	1	bool	boolean
    //   6	6	2	locala1	a
    //   27	4	2	localObject	Object
    //   10	3	3	locala2	a
    // Exception table:
    //   from	to	target	type
    //   2	11	27	finally
  }
  
  public final void recycle()
  {
    try
    {
      AppMethodBeat.i(77662);
      qg();
      this.context = null;
      this.aCm = null;
      this.aDf = null;
      this.aDd = null;
      this.aNp = null;
      this.aNb = -1;
      this.aNa = -1;
      this.aNq = null;
      this.aDg = null;
      this.aNn = null;
      this.aNo = null;
      this.aNr = null;
      this.aNt = null;
      this.aNv = null;
      this.aMY = null;
      this.aNd = null;
      this.width = -1;
      this.height = -1;
      this.aNw = null;
      aHW.release(this);
      AppMethodBeat.o(77662);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(77659);
      aNx = new a("PENDING", 0);
      aNy = new a("RUNNING", 1);
      aNz = new a("WAITING_FOR_SIZE", 2);
      aNA = new a("COMPLETE", 3);
      aNB = new a("FAILED", 4);
      aNC = new a("CLEARED", 5);
      aND = new a[] { aNx, aNy, aNz, aNA, aNB, aNC };
      AppMethodBeat.o(77659);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.e.h
 * JD-Core Version:    0.7.0.1
 */