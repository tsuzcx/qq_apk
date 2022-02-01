package androidx.d.a;

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
  public static final ThreadLocal<a> Sv;
  long SA;
  boolean SB;
  final g<b, Long> Sw;
  final ArrayList<b> Sx;
  private final a Sy;
  private c Sz;
  
  static
  {
    AppMethodBeat.i(250128);
    Sv = new ThreadLocal();
    AppMethodBeat.o(250128);
  }
  
  a()
  {
    AppMethodBeat.i(250122);
    this.Sw = new g();
    this.Sx = new ArrayList();
    this.Sy = new a();
    this.SA = 0L;
    this.SB = false;
    AppMethodBeat.o(250122);
  }
  
  public static a hS()
  {
    AppMethodBeat.i(250124);
    if (Sv.get() == null) {
      Sv.set(new a());
    }
    a locala = (a)Sv.get();
    AppMethodBeat.o(250124);
    return locala;
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(250127);
    this.Sw.remove(paramb);
    int i = this.Sx.indexOf(paramb);
    if (i >= 0)
    {
      this.Sx.set(i, null);
      this.SB = true;
    }
    AppMethodBeat.o(250127);
  }
  
  final c hT()
  {
    AppMethodBeat.i(250126);
    if (this.Sz == null) {
      if (Build.VERSION.SDK_INT < 16) {
        break label47;
      }
    }
    label47:
    for (this.Sz = new e(this.Sy);; this.Sz = new d(this.Sy))
    {
      c localc = this.Sz;
      AppMethodBeat.o(250126);
      return localc;
    }
  }
  
  final class a
  {
    a() {}
    
    final void hU()
    {
      AppMethodBeat.i(250103);
      a.this.SA = SystemClock.uptimeMillis();
      a locala = a.this;
      long l1 = a.this.SA;
      long l2 = SystemClock.uptimeMillis();
      int j = 0;
      int i;
      if (j < locala.Sx.size())
      {
        a.b localb = (a.b)locala.Sx.get(j);
        Long localLong;
        if (localb != null)
        {
          localLong = (Long)locala.Sw.get(localb);
          if (localLong != null) {
            break label109;
          }
          i = 1;
        }
        for (;;)
        {
          if (i != 0) {
            localb.i(l1);
          }
          j += 1;
          break;
          label109:
          if (localLong.longValue() < l2)
          {
            locala.Sw.remove(localb);
            i = 1;
          }
          else
          {
            i = 0;
          }
        }
      }
      if (locala.SB)
      {
        i = locala.Sx.size() - 1;
        while (i >= 0)
        {
          if (locala.Sx.get(i) == null) {
            locala.Sx.remove(i);
          }
          i -= 1;
        }
        locala.SB = false;
      }
      if (a.this.Sx.size() > 0) {
        a.this.hT().hV();
      }
      AppMethodBeat.o(250103);
    }
  }
  
  static abstract interface b
  {
    public abstract boolean i(long paramLong);
  }
  
  static abstract class c
  {
    final a.a SD;
    
    c(a.a parama)
    {
      this.SD = parama;
    }
    
    abstract void hV();
  }
  
  static final class d
    extends a.c
  {
    long SE;
    private final Handler mHandler;
    private final Runnable mRunnable;
    
    d(a.a parama)
    {
      super();
      AppMethodBeat.i(250112);
      this.SE = -1L;
      this.mRunnable = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(250109);
          a.d.this.SE = SystemClock.uptimeMillis();
          a.d.this.SD.hU();
          AppMethodBeat.o(250109);
        }
      };
      this.mHandler = new Handler(Looper.myLooper());
      AppMethodBeat.o(250112);
    }
    
    final void hV()
    {
      AppMethodBeat.i(250113);
      long l = Math.max(10L - (SystemClock.uptimeMillis() - this.SE), 0L);
      this.mHandler.postDelayed(this.mRunnable, l);
      AppMethodBeat.o(250113);
    }
  }
  
  static final class e
    extends a.c
  {
    private final Choreographer SG;
    private final Choreographer.FrameCallback SH;
    
    e(a.a parama)
    {
      super();
      AppMethodBeat.i(250119);
      this.SG = Choreographer.getInstance();
      this.SH = new Choreographer.FrameCallback()
      {
        public final void doFrame(long paramAnonymousLong)
        {
          AppMethodBeat.i(250117);
          a.e.this.SD.hU();
          AppMethodBeat.o(250117);
        }
      };
      AppMethodBeat.o(250119);
    }
    
    final void hV()
    {
      AppMethodBeat.i(250121);
      this.SG.postFrameCallback(this.SH);
      AppMethodBeat.o(250121);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.d.a.a
 * JD-Core Version:    0.7.0.1
 */