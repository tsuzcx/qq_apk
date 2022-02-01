package com.tencent.mm.bz;

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
    protected final Handler GiS;
    protected final c GiT;
    protected final g GiU;
    protected long GiV;
    protected b GiW;
    protected final SparseArray<List<d>> GiX;
    protected final AtomicBoolean GiY;
    protected final Context mContext;
    protected final String mVersionName;
    
    public a(Context paramContext)
    {
      this(paramContext, g.hG(paramContext));
      AppMethodBeat.i(194817);
      AppMethodBeat.o(194817);
    }
    
    private a(Context paramContext, g paramg)
    {
      AppMethodBeat.i(194818);
      this.mContext = paramContext;
      this.GiS = new Handler(Looper.getMainLooper());
      this.mVersionName = k.hO(this.mContext);
      this.GiT = c.hE(this.mContext);
      this.GiU = paramg;
      this.GiW = new b()
      {
        public final void a(Context paramAnonymousContext, c paramAnonymousc) {}
      };
      this.GiX = new SparseArray(2);
      this.GiX.put(1, new ArrayList());
      this.GiX.put(2, new ArrayList());
      this.GiY = new AtomicBoolean();
      AppMethodBeat.o(194818);
    }
    
    private void eRZ()
    {
      AppMethodBeat.i(194821);
      c localc = this.GiT.eRO();
      localc.Giz = this.mVersionName;
      localc.Gix = this.GiV;
      AppMethodBeat.o(194821);
    }
    
    private void eSa()
    {
      AppMethodBeat.i(194822);
      this.GiT.eRP();
      AppMethodBeat.o(194822);
    }
    
    private void vA(boolean paramBoolean)
    {
      AppMethodBeat.i(194823);
      if (paramBoolean)
      {
        this.GiT.save();
        AppMethodBeat.o(194823);
        return;
      }
      this.GiT.eRQ();
      AppMethodBeat.o(194823);
    }
    
    public final void begin()
    {
      AppMethodBeat.i(194819);
      this.GiV = System.currentTimeMillis();
      long l1 = this.GiV - this.GiT.Gix;
      a.a.log(4, "MicroMsg.recovery.safePoint", "recovery interval = ".concat(String.valueOf(l1)));
      long l2 = this.GiU.GiJ;
      if ((l2 > 0L) && (l1 < l2))
      {
        a.a.log(4, "MicroMsg.recovery.safePoint", "too fast, skip and do nothing, min = ".concat(String.valueOf(l2)));
        AppMethodBeat.o(194819);
        return;
      }
      this.GiY.set(true);
      if ((!TextUtils.isEmpty(this.GiT.Giz)) && (!this.GiT.Giz.equals(this.mVersionName)))
      {
        a.a.log(4, "MicroMsg.recovery.safePoint", "version code mismatch, skip");
        eSa();
      }
      if (l1 >= this.GiU.GiI)
      {
        a.a.log(4, "MicroMsg.recovery.safePoint", "over interval, skip");
        eSa();
      }
      int i = this.GiT.Giy;
      a.a.log(4, "MicroMsg.recovery.safePoint", "recovery crashCount = ".concat(String.valueOf(i)));
      Object localObject2;
      if (i >= this.GiU.GiG)
      {
        a.a.log(4, "MicroMsg.recovery.safePoint", "on launch recovery page");
        try
        {
          this.GiW.a(this.mContext, this.GiT);
          Object localObject1 = h.hJ(this.mContext);
          ((h)localObject1).GiR = false;
          ((h)localObject1).Giy = this.GiT.Giy;
          ((h)localObject1).GiN = true;
          ((h)localObject1).save();
          if (i < this.GiU.GiH)
          {
            a.a.log(4, "MicroMsg.recovery.safePoint", "recovery event, level = 1");
            localObject1 = ((List)this.GiX.get(1)).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              d locald1 = (d)((Iterator)localObject1).next();
              try
              {
                locald1.XZ(1);
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
          eRZ();
        }
        for (;;)
        {
          vA(true);
          a.a.log(4, "MicroMsg.recovery.safePoint", "self handler handle crash");
          Process.killProcess(Process.myPid());
          System.exit(10);
          AppMethodBeat.o(194819);
          return;
          a.a.log(4, "MicroMsg.recovery.safePoint", "recovery event, level = 2");
          localObject2 = ((List)this.GiX.get(2)).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            d locald2 = (d)((Iterator)localObject2).next();
            try
            {
              locald2.XZ(2);
            }
            catch (Throwable localThrowable3)
            {
              a.w("MicroMsg.recovery.safePoint", "recovery event error", localThrowable3);
            }
          }
          eSa();
        }
      }
      a.a.log(4, "MicroMsg.recovery.safePoint", "onLaunchNormal");
      if (this.GiT.Giy > 0)
      {
        localObject2 = h.hJ(this.mContext);
        ((h)localObject2).GiR = false;
        ((h)localObject2).Giy = this.GiT.Giy;
        ((h)localObject2).GiA.fH("crash_count", ((h)localObject2).Giy).cA("launch_recovery", ((h)localObject2).GiN).cA("launch_recovery_real", ((h)localObject2).GiO).cA("recover_from_crash", ((h)localObject2).GiP).fH("recovery_status", ((h)localObject2).GiQ).cA("recover_is_discard", ((h)localObject2).GiR).eRT();
      }
      eRZ();
      vA(false);
      this.GiS.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(194816);
          a.a.log(4, "MicroMsg.recovery.safePoint", "auto clear point");
          i.a.this.finish();
          AppMethodBeat.o(194816);
        }
      }, this.GiU.GiK);
      AppMethodBeat.o(194819);
    }
    
    public final void finish()
    {
      AppMethodBeat.i(194820);
      if (this.GiY.get())
      {
        this.GiY.set(false);
        eSa();
        vA(false);
      }
      AppMethodBeat.o(194820);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.bz.i
 * JD-Core Version:    0.7.0.1
 */