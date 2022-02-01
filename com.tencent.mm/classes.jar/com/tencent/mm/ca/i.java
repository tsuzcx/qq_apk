package com.tencent.mm.ca;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract interface i
{
  public abstract i a(int paramInt, d paramd);
  
  public abstract i a(b paramb);
  
  public abstract void begin();
  
  public static final class a
    implements i
  {
    protected final Handler ELG;
    protected final c ELH;
    protected final g ELI;
    protected long ELJ;
    protected b ELK;
    protected final SparseArray<List<d>> ELL;
    protected final AtomicBoolean ELM;
    protected final Context mContext;
    protected final String mVersionName;
    
    public a(Context paramContext)
    {
      this(paramContext, g.hv(paramContext));
      AppMethodBeat.i(189876);
      AppMethodBeat.o(189876);
    }
    
    private a(Context paramContext, g paramg)
    {
      AppMethodBeat.i(189877);
      this.mContext = paramContext;
      this.ELG = new Handler(Looper.getMainLooper());
      this.mVersionName = k.hD(this.mContext);
      this.ELH = c.ht(this.mContext);
      this.ELI = paramg;
      this.ELK = new b()
      {
        public final void a(Context paramAnonymousContext, c paramAnonymousc) {}
      };
      this.ELL = new SparseArray(2);
      this.ELL.put(1, new ArrayList());
      this.ELL.put(2, new ArrayList());
      this.ELM = new AtomicBoolean();
      AppMethodBeat.o(189877);
    }
    
    private void eCF()
    {
      AppMethodBeat.i(189880);
      c localc = this.ELH.eCt();
      localc.ELn = this.mVersionName;
      localc.ELl = this.ELJ;
      AppMethodBeat.o(189880);
    }
    
    private void eCG()
    {
      AppMethodBeat.i(189881);
      this.ELH.eCu();
      AppMethodBeat.o(189881);
    }
    
    private void uy(boolean paramBoolean)
    {
      AppMethodBeat.i(189882);
      if (paramBoolean)
      {
        this.ELH.save();
        AppMethodBeat.o(189882);
        return;
      }
      this.ELH.eCv();
      AppMethodBeat.o(189882);
    }
    
    public final void begin()
    {
      AppMethodBeat.i(189878);
      this.ELJ = System.currentTimeMillis();
      long l1 = this.ELJ - this.ELH.ELl;
      a.a.log(4, "MicroMsg.recovery.safePoint", "recovery interval = ".concat(String.valueOf(l1)));
      long l2 = this.ELI.ELx;
      if ((l2 > 0L) && (l1 < l2))
      {
        a.a.log(4, "MicroMsg.recovery.safePoint", "too fast, skip and do nothing, min = ".concat(String.valueOf(l2)));
        AppMethodBeat.o(189878);
        return;
      }
      this.ELM.set(true);
      if ((!TextUtils.isEmpty(this.ELH.ELn)) && (!this.ELH.ELn.equals(this.mVersionName)))
      {
        a.a.log(4, "MicroMsg.recovery.safePoint", "version code mismatch, skip");
        eCG();
      }
      if (l1 >= this.ELI.ELw)
      {
        a.a.log(4, "MicroMsg.recovery.safePoint", "over interval, skip");
        eCG();
      }
      int i = this.ELH.ELm;
      a.a.log(4, "MicroMsg.recovery.safePoint", "recovery crashCount = ".concat(String.valueOf(i)));
      Object localObject2;
      if (i >= this.ELI.ELu)
      {
        a.a.log(4, "MicroMsg.recovery.safePoint", "on launch recovery page");
        try
        {
          this.ELK.a(this.mContext, this.ELH);
          Object localObject1 = h.hy(this.mContext);
          ((h)localObject1).ELF = false;
          ((h)localObject1).ELm = this.ELH.ELm;
          ((h)localObject1).ELB = true;
          ((h)localObject1).save();
          if (i < this.ELI.ELv)
          {
            a.a.log(4, "MicroMsg.recovery.safePoint", "recovery event, level = 1");
            localObject1 = ((List)this.ELL.get(1)).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              d locald1 = (d)((Iterator)localObject1).next();
              try
              {
                locald1.VQ(1);
              }
              catch (Throwable localThrowable2)
              {
                a.w("MicroMsg.recovery.safePoint", "recovery event error", localThrowable2);
              }
            }
          }
        }
        catch (Throwable localThrowable1)
        {
          for (;;)
          {
            a.w("MicroMsg.recovery.safePoint", "on launch recovery page error", localThrowable1);
          }
          eCF();
        }
        for (;;)
        {
          uy(true);
          a.a.log(4, "MicroMsg.recovery.safePoint", "self handler handle crash");
          Process.killProcess(Process.myPid());
          System.exit(10);
          AppMethodBeat.o(189878);
          return;
          a.a.log(4, "MicroMsg.recovery.safePoint", "recovery event, level = 2");
          localObject2 = ((List)this.ELL.get(2)).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            d locald2 = (d)((Iterator)localObject2).next();
            try
            {
              locald2.VQ(2);
            }
            catch (Throwable localThrowable3)
            {
              a.w("MicroMsg.recovery.safePoint", "recovery event error", localThrowable3);
            }
          }
          eCG();
        }
      }
      a.a.log(4, "MicroMsg.recovery.safePoint", "onLaunchNormal");
      if (this.ELH.ELm > 0)
      {
        localObject2 = h.hy(this.mContext);
        ((h)localObject2).ELF = false;
        ((h)localObject2).ELm = this.ELH.ELm;
        ((h)localObject2).ELo.fC("crash_count", ((h)localObject2).ELm).cu("launch_recovery", ((h)localObject2).ELB).cu("launch_recovery_real", ((h)localObject2).ELC).cu("recover_from_crash", ((h)localObject2).ELD).fC("recovery_status", ((h)localObject2).ELE).cu("recover_is_discard", ((h)localObject2).ELF).eCy();
      }
      eCF();
      uy(false);
      this.ELG.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(189875);
          a.a.log(4, "MicroMsg.recovery.safePoint", "auto clear point");
          i.a.this.finish();
          AppMethodBeat.o(189875);
        }
      }, this.ELI.ELy);
      AppMethodBeat.o(189878);
    }
    
    public final void finish()
    {
      AppMethodBeat.i(189879);
      if (this.ELM.get())
      {
        this.ELM.set(false);
        eCG();
        uy(false);
      }
      AppMethodBeat.o(189879);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ca.i
 * JD-Core Version:    0.7.0.1
 */