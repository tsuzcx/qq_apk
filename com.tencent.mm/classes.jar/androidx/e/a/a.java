package androidx.e.a;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import androidx.b.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class a
{
  public static final ThreadLocal<a> byL;
  final g<b, Long> byM;
  final ArrayList<b> byN;
  private final a byO;
  private c byP;
  long byQ;
  boolean byR;
  
  static
  {
    AppMethodBeat.i(196506);
    byL = new ThreadLocal();
    AppMethodBeat.o(196506);
  }
  
  a()
  {
    AppMethodBeat.i(196493);
    this.byM = new g();
    this.byN = new ArrayList();
    this.byO = new a();
    this.byQ = 0L;
    this.byR = false;
    AppMethodBeat.o(196493);
  }
  
  public static a FE()
  {
    AppMethodBeat.i(196501);
    if (byL.get() == null) {
      byL.set(new a());
    }
    a locala = (a)byL.get();
    AppMethodBeat.o(196501);
    return locala;
  }
  
  final c FF()
  {
    AppMethodBeat.i(196517);
    if (this.byP == null) {
      if (Build.VERSION.SDK_INT < 16) {
        break label47;
      }
    }
    label47:
    for (this.byP = new e(this.byO);; this.byP = new d(this.byO))
    {
      c localc = this.byP;
      AppMethodBeat.o(196517);
      return localc;
    }
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(196526);
    this.byM.remove(paramb);
    int i = this.byN.indexOf(paramb);
    if (i >= 0)
    {
      this.byN.set(i, null);
      this.byR = true;
    }
    AppMethodBeat.o(196526);
  }
  
  final class a
  {
    a() {}
    
    final void FG()
    {
      AppMethodBeat.i(196485);
      a.this.byQ = SystemClock.uptimeMillis();
      a locala = a.this;
      long l1 = a.this.byQ;
      long l2 = SystemClock.uptimeMillis();
      int j = 0;
      int i;
      if (j < locala.byN.size())
      {
        a.b localb = (a.b)locala.byN.get(j);
        Long localLong;
        if (localb != null)
        {
          localLong = (Long)locala.byM.get(localb);
          if (localLong != null) {
            break label109;
          }
          i = 1;
        }
        for (;;)
        {
          if (i != 0) {
            localb.bx(l1);
          }
          j += 1;
          break;
          label109:
          if (localLong.longValue() < l2)
          {
            locala.byM.remove(localb);
            i = 1;
          }
          else
          {
            i = 0;
          }
        }
      }
      if (locala.byR)
      {
        i = locala.byN.size() - 1;
        while (i >= 0)
        {
          if (locala.byN.get(i) == null) {
            locala.byN.remove(i);
          }
          i -= 1;
        }
        locala.byR = false;
      }
      if (a.this.byN.size() > 0) {
        a.this.FF().FH();
      }
      AppMethodBeat.o(196485);
    }
  }
  
  static abstract interface b
  {
    public abstract boolean bx(long paramLong);
  }
  
  static abstract class c
  {
    final a.a byT;
    
    c(a.a parama)
    {
      this.byT = parama;
    }
    
    abstract void FH();
  }
  
  static final class d
    extends a.c
  {
    long byU;
    private final Handler mHandler;
    private final Runnable mRunnable;
    
    d(a.a parama)
    {
      super();
      AppMethodBeat.i(196473);
      this.byU = -1L;
      this.mRunnable = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(196513);
          a.d.this.byU = SystemClock.uptimeMillis();
          a.d.this.byT.FG();
          AppMethodBeat.o(196513);
        }
      };
      this.mHandler = new Handler(Looper.myLooper());
      AppMethodBeat.o(196473);
    }
    
    final void FH()
    {
      AppMethodBeat.i(196482);
      long l = Math.max(10L - (SystemClock.uptimeMillis() - this.byU), 0L);
      this.mHandler.postDelayed(this.mRunnable, l);
      AppMethodBeat.o(196482);
    }
  }
  
  static final class e
    extends a.c
  {
    private final Choreographer byW;
    private final Choreographer.FrameCallback byX;
    
    e(a.a parama)
    {
      super();
      AppMethodBeat.i(196483);
      this.byW = Choreographer.getInstance();
      this.byX = new Choreographer.FrameCallback()
      {
        public final void doFrame(long paramAnonymousLong)
        {
          AppMethodBeat.i(196504);
          a.e.this.byT.FG();
          AppMethodBeat.o(196504);
        }
      };
      AppMethodBeat.o(196483);
    }
    
    final void FH()
    {
      AppMethodBeat.i(196489);
      this.byW.postFrameCallback(this.byX);
      AppMethodBeat.o(196489);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.e.a.a
 * JD-Core Version:    0.7.0.1
 */