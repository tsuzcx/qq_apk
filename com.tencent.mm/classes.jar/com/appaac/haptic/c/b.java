package com.appaac.haptic.c;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.SystemClock;
import android.os.Vibrator;
import com.appaac.haptic.a.f;
import com.appaac.haptic.a.f.a;
import com.appaac.haptic.a.g;
import com.appaac.haptic.sync.VibrationPattern;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import org.json.JSONObject;

public final class b
  implements d
{
  private final boolean DEBUG;
  private Vibrator cqQ;
  com.appaac.haptic.sync.a crI;
  com.appaac.haptic.a.c crL;
  Handler crM;
  HandlerThread crN;
  com.appaac.haptic.sync.c crO;
  a crP;
  f crQ;
  private Context mContext;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(208337);
    this.DEBUG = false;
    this.crP = new a();
    this.mContext = paramContext;
    this.cqQ = ((Vibrator)paramContext.getSystemService("vibrator"));
    this.crL = new com.appaac.haptic.a.c(this.mContext);
    this.crL.start();
    AppMethodBeat.o(208337);
  }
  
  public final void Nn()
  {
    this.crP.crG = 2147483647;
  }
  
  public final void Nx()
  {
    AppMethodBeat.i(208341);
    this.crP.reset();
    Nz();
    Ny();
    AppMethodBeat.o(208341);
  }
  
  final void Ny()
  {
    AppMethodBeat.i(208384);
    if (this.crL != null) {
      this.crL.No();
    }
    this.cqQ.cancel();
    AppMethodBeat.o(208384);
  }
  
  final void Nz()
  {
    AppMethodBeat.i(208395);
    if (this.crN != null)
    {
      this.crN.quit();
      this.crN = null;
      this.crM = null;
      this.crO = null;
    }
    if (this.crQ != null)
    {
      this.crQ.quit();
      this.crQ = null;
    }
    AppMethodBeat.o(208395);
  }
  
  public final void a(File paramFile, com.appaac.haptic.sync.a parama)
  {
    AppMethodBeat.i(208359);
    this.crP.reset();
    this.crP.crK = paramFile;
    this.crP.cqH = 255;
    this.crP.cqI = 50;
    this.crP.crI = parama;
    AppMethodBeat.o(208359);
  }
  
  final void a(String paramString, final int paramInt1, final int paramInt2, com.appaac.haptic.sync.a parama)
  {
    AppMethodBeat.i(208393);
    this.crI = parama;
    this.crN = new HandlerThread("Richtap-Sync");
    this.crN.start();
    this.crM = new Handler(this.crN.getLooper())
    {
      int crV = 0;
      
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(208348);
        for (;;)
        {
          Object localObject1;
          int i;
          try
          {
            if ((b.this.crM != null) && (b.this.crN != null))
            {
              localObject1 = b.this.crO;
              if (localObject1 != null) {}
            }
            else
            {
              AppMethodBeat.o(208348);
              return;
            }
            i = paramAnonymousMessage.what;
            switch (i)
            {
            default: 
              AppMethodBeat.o(208348);
              return;
            }
          }
          catch (Exception paramAnonymousMessage)
          {
            long l2;
            new StringBuilder("ex in handleMessage:").append(paramAnonymousMessage.toString());
            AppMethodBeat.o(208348);
            return;
          }
          long l1 = ((Long)paramAnonymousMessage.obj).longValue();
          if (b.this.crI != null)
          {
            i = b.this.crI.getCurrentPosition();
            if ((i > 0) && (i >= this.crV))
            {
              paramAnonymousMessage = b.this.crO;
              l2 = i;
              paramAnonymousMessage.csf = l2;
              b.this.crO.x(l2, l1);
              this.crV = i;
              AppMethodBeat.o(208348);
              return;
            }
            if ((i >= 0) && (i < this.crV) && (b.this.crP.crG > 0))
            {
              b.this.gW(i);
              continue;
            }
            b.this.crM.sendMessage(Message.obtain(paramAnonymousMessage));
            continue;
          }
          b.this.crO.csf = l1;
          b.this.crO.x(l1, l1);
          AppMethodBeat.o(208348);
          return;
          if ((paramAnonymousMessage.obj instanceof Parcel))
          {
            paramAnonymousMessage = (Parcel)paramAnonymousMessage.obj;
            if (b.this.crI != null) {
              b.this.crI.getCurrentPosition();
            }
            localObject1 = new VibrationPattern(paramAnonymousMessage);
            Object localObject2 = "{\"Metadata\": {\"Version\": 1}," + ((VibrationPattern)localObject1).pattern + "}";
            localObject1 = b.this;
            int j;
            if (b.this.crQ != null)
            {
              i = b.this.crQ.Nu();
              j = paramInt2;
            }
            for (;;)
            {
              try
              {
                k = new JSONObject((String)localObject2).getJSONObject("Metadata").getInt("Version");
                if (k != 1) {
                  continue;
                }
                ((b)localObject1).Ny();
                localObject2 = new com.appaac.haptic.a.b((String)localObject2, i, j);
                ((b)localObject1).crL.a((com.appaac.haptic.a.b)localObject2);
              }
              catch (Exception localException)
              {
                int k;
                continue;
              }
              paramAnonymousMessage.recycle();
              AppMethodBeat.o(208348);
              return;
              i = paramInt1;
              break;
              if (k == 2)
              {
                ((b)localObject1).Nz();
                localObject2 = g.bg(g.bc((String)localObject2));
                ((b)localObject1).crQ = new f();
                ((b)localObject1).crQ.gT(i);
                ((b)localObject1).crQ.a(g.bh((String)localObject2), new b.1((b)localObject1, (String)localObject2, i, j));
              }
            }
            if (b.this.crP.crG > 0)
            {
              if ((b.this.crI != null) && (b.this.crI.getCurrentPosition() > g.bi(b.this.crP.crF)))
              {
                b.this.crM.sendEmptyMessageDelayed(102, 10L);
                AppMethodBeat.o(208348);
                return;
              }
              b.this.gW(0);
              AppMethodBeat.o(208348);
              return;
            }
            b.this.crP.mStatus = 9;
          }
        }
      }
    };
    this.crO = new com.appaac.haptic.sync.c(this.crM, paramString, this.crP);
    if (this.crP.crI != null)
    {
      if (this.crP.crI.getCurrentPosition() < 0)
      {
        this.crO.csf = this.crP.crI.getCurrentPosition();
        this.crO.x(this.crP.crI.getCurrentPosition(), this.crP.crJ);
        AppMethodBeat.o(208393);
        return;
      }
      this.crO.csf = this.crP.crJ;
      this.crO.x(this.crP.crJ, this.crP.crJ);
      AppMethodBeat.o(208393);
      return;
    }
    if (parama != null)
    {
      this.crO.csf = parama.getCurrentPosition();
      this.crO.x(parama.getCurrentPosition(), 0L);
      AppMethodBeat.o(208393);
      return;
    }
    this.crO.NC();
    AppMethodBeat.o(208393);
  }
  
  public final boolean gW(int paramInt)
  {
    AppMethodBeat.i(208375);
    if (!a.a(this.crP.crH))
    {
      AppMethodBeat.o(208375);
      return false;
    }
    if ((paramInt < 0) || (paramInt > this.crP.crH.getDuration()))
    {
      AppMethodBeat.o(208375);
      return false;
    }
    Nz();
    Ny();
    this.crP.crJ = paramInt;
    String str2 = g.n(this.crP.crF, this.crP.crJ);
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (!"".equals(str2)) {}
    }
    else
    {
      if (this.crP.crG <= 0) {
        break label146;
      }
      str1 = this.crP.crF;
      this.crP.crJ = 0;
    }
    if (6 != this.crP.mStatus)
    {
      AppMethodBeat.o(208375);
      return true;
      label146:
      this.crP.mStatus = 9;
      AppMethodBeat.o(208375);
      return false;
    }
    this.crP.mStartTime = SystemClock.elapsedRealtime();
    if (this.crP.crI != null) {
      a(this.crP.crF, this.crP.cqH, this.crP.cqI, this.crP.crI);
    }
    for (;;)
    {
      AppMethodBeat.o(208375);
      return true;
      a(str1, this.crP.cqH, this.crP.cqI, null);
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(208350);
    if (6 != this.crP.mStatus)
    {
      AppMethodBeat.o(208350);
      return;
    }
    Nz();
    Ny();
    this.crP.mStatus = 7;
    if (!a.a(this.crP.crH))
    {
      this.crP.crJ = 0;
      AppMethodBeat.o(208350);
      return;
    }
    if (this.crP.crI != null)
    {
      this.crP.crJ = this.crP.crI.getCurrentPosition();
      AppMethodBeat.o(208350);
      return;
    }
    int i = (int)(SystemClock.elapsedRealtime() - this.crP.mStartTime);
    if (i < 0)
    {
      this.crP.crJ = 0;
      AppMethodBeat.o(208350);
      return;
    }
    a locala = this.crP;
    locala.crJ = (i + locala.crJ);
    AppMethodBeat.o(208350);
  }
  
  public final boolean prepare()
  {
    AppMethodBeat.i(208366);
    if (this.crP.crK != null) {
      this.crP.crF = g.r(this.crP.crK);
    }
    if (1 == g.bd(this.crP.crF)) {
      this.crP.crF = g.bb(this.crP.crF);
    }
    this.crP.crF = g.bc(this.crP.crF);
    this.crP.crF = g.bg(this.crP.crF);
    com.appaac.haptic.b.a.c localc = g.ba(this.crP.crF);
    if (!a.a(localc))
    {
      this.crP.reset();
      AppMethodBeat.o(208366);
      return false;
    }
    this.crP.crH = localc;
    AppMethodBeat.o(208366);
    return true;
  }
  
  /* Error */
  public final void release()
  {
    // Byte code:
    //   0: ldc 252
    //   2: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 49	com/appaac/haptic/c/b:crP	Lcom/appaac/haptic/c/a;
    //   9: invokevirtual 87	com/appaac/haptic/c/a:reset	()V
    //   12: aload_0
    //   13: invokevirtual 90	com/appaac/haptic/c/b:Nz	()V
    //   16: aload_0
    //   17: getfield 69	com/appaac/haptic/c/b:crL	Lcom/appaac/haptic/a/c;
    //   20: ifnull +57 -> 77
    //   23: aload_0
    //   24: getfield 69	com/appaac/haptic/c/b:crL	Lcom/appaac/haptic/a/c;
    //   27: astore_3
    //   28: aload_3
    //   29: iconst_1
    //   30: putfield 255	com/appaac/haptic/a/c:cqN	Z
    //   33: aload_3
    //   34: getfield 259	com/appaac/haptic/a/c:mLock	Ljava/lang/Object;
    //   37: astore_1
    //   38: aload_1
    //   39: monitorenter
    //   40: aload_3
    //   41: getfield 262	com/appaac/haptic/a/c:cqM	Ljava/lang/Object;
    //   44: astore_2
    //   45: aload_2
    //   46: monitorenter
    //   47: aload_3
    //   48: getfield 266	com/appaac/haptic/a/c:cqO	Ljava/util/List;
    //   51: invokeinterface 271 1 0
    //   56: aload_3
    //   57: aconst_null
    //   58: putfield 266	com/appaac/haptic/a/c:cqO	Ljava/util/List;
    //   61: aload_2
    //   62: monitorexit
    //   63: aload_3
    //   64: getfield 259	com/appaac/haptic/a/c:mLock	Ljava/lang/Object;
    //   67: invokevirtual 274	java/lang/Object:notify	()V
    //   70: aload_1
    //   71: monitorexit
    //   72: aload_0
    //   73: aconst_null
    //   74: putfield 69	com/appaac/haptic/c/b:crL	Lcom/appaac/haptic/a/c;
    //   77: ldc 252
    //   79: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   82: return
    //   83: astore_3
    //   84: aload_2
    //   85: monitorexit
    //   86: ldc 252
    //   88: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: aload_3
    //   92: athrow
    //   93: astore_2
    //   94: goto -24 -> 70
    //   97: astore_2
    //   98: aload_1
    //   99: monitorexit
    //   100: ldc 252
    //   102: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: aload_2
    //   106: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	b
    //   37	62	1	localObject1	Object
    //   93	1	2	localException	Exception
    //   97	9	2	localObject3	Object
    //   27	37	3	localc	com.appaac.haptic.a.c
    //   83	9	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   47	63	83	finally
    //   40	47	93	java/lang/Exception
    //   63	70	93	java/lang/Exception
    //   84	93	93	java/lang/Exception
    //   40	47	97	finally
    //   63	70	97	finally
    //   70	72	97	finally
    //   84	93	97	finally
  }
  
  public final boolean start()
  {
    AppMethodBeat.i(208354);
    if (6 == this.crP.mStatus)
    {
      AppMethodBeat.o(208354);
      return false;
    }
    if (!a.a(this.crP.crH))
    {
      AppMethodBeat.o(208354);
      return false;
    }
    if (this.crP.crJ < 0)
    {
      AppMethodBeat.o(208354);
      return false;
    }
    if (9 == this.crP.mStatus) {
      this.crP.crJ = 0;
    }
    String str = g.n(this.crP.crF, this.crP.crJ);
    if ((str == null) || ("".equals(str)))
    {
      this.crP.mStatus = 9;
      AppMethodBeat.o(208354);
      return false;
    }
    this.crP.mStartTime = SystemClock.elapsedRealtime();
    this.crP.mStatus = 6;
    if (this.crP.crI != null) {
      a(this.crP.crF, this.crP.cqH, this.crP.cqI, this.crP.crI);
    }
    for (;;)
    {
      AppMethodBeat.o(208354);
      return true;
      a(str, this.crP.cqH, this.crP.cqI, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.appaac.haptic.c.b
 * JD-Core Version:    0.7.0.1
 */