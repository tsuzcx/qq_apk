package androidx.camera.core.impl;

import android.util.Log;
import android.util.Size;
import android.view.Surface;
import androidx.c.a.b.a;
import androidx.camera.core.al;
import androidx.camera.core.impl.a.b.e;
import com.google.b.b.a.f;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class ad
{
  private static final boolean DEBUG = al.N("DeferrableSurface");
  public static final Size Mf = new Size(0, 0);
  private static final AtomicInteger Mg = new AtomicInteger(0);
  private static final AtomicInteger Mh = new AtomicInteger(0);
  private int Af = 0;
  private b.a<Void> Mi;
  public final f<Void> Mj;
  public final Size Mk;
  public final int Ml;
  public Class<?> Mm;
  private boolean mClosed = false;
  private final Object mLock = new Object();
  
  public ad()
  {
    this(Mf, 0);
  }
  
  public ad(Size paramSize, int paramInt)
  {
    this.Mk = paramSize;
    this.Ml = paramInt;
    this.Mj = androidx.c.a.b.a(new ad..ExternalSyntheticLambda0(this));
    if (al.N("DeferrableSurface"))
    {
      e("Surface created", Mh.incrementAndGet(), Mg.get());
      paramSize = Log.getStackTraceString(new Exception());
      this.Mj.a(new ad..ExternalSyntheticLambda1(this, paramSize), androidx.camera.core.impl.a.a.b.kP());
    }
  }
  
  private void e(String paramString, int paramInt1, int paramInt2)
  {
    if ((!DEBUG) && (al.N("DeferrableSurface"))) {
      al.O("DeferrableSurface");
    }
    new StringBuilder().append(paramString).append("[total_surfaces=").append(paramInt1).append(", used_surfaces=").append(paramInt2).append("](").append(this).append("}");
    al.O("DeferrableSurface");
  }
  
  public final void close()
  {
    for (;;)
    {
      synchronized (this.mLock)
      {
        if (this.mClosed) {
          break label102;
        }
        this.mClosed = true;
        if (this.Af == 0)
        {
          b.a locala1 = this.Mi;
          this.Mi = null;
          locala2 = locala1;
          if (al.N("DeferrableSurface"))
          {
            new StringBuilder("surface closed,  useCount=").append(this.Af).append(" closed=true ").append(this);
            al.O("DeferrableSurface");
            locala2 = locala1;
          }
          if (locala2 != null) {
            locala2.ap(null);
          }
          return;
        }
      }
      Object localObject2 = null;
      continue;
      label102:
      b.a locala2 = null;
    }
  }
  
  public final void gp()
  {
    synchronized (this.mLock)
    {
      if ((this.Af == 0) && (this.mClosed)) {
        throw new a("Cannot begin use on a closed surface.", this);
      }
    }
    this.Af += 1;
    if (al.N("DeferrableSurface"))
    {
      if (this.Af == 1) {
        e("New surface in use", Mh.get(), Mg.incrementAndGet());
      }
      new StringBuilder("use count+1, useCount=").append(this.Af).append(" ").append(this);
      al.O("DeferrableSurface");
    }
  }
  
  public final void gq()
  {
    synchronized (this.mLock)
    {
      if (this.Af == 0) {
        throw new IllegalStateException("Decrementing use count occurs more times than incrementing");
      }
    }
    this.Af -= 1;
    b.a locala;
    if ((this.Af == 0) && (this.mClosed))
    {
      locala = this.Mi;
      this.Mi = null;
    }
    for (;;)
    {
      if (al.N("DeferrableSurface"))
      {
        new StringBuilder("use count-1,  useCount=").append(this.Af).append(" closed=").append(this.mClosed).append(" ").append(this);
        al.O("DeferrableSurface");
        if (this.Af == 0) {
          e("Surface no longer in use", Mh.get(), Mg.decrementAndGet());
        }
      }
      if (locala != null) {
        locala.ap(null);
      }
      return;
      locala = null;
    }
  }
  
  protected abstract f<Surface> jq();
  
  public final f<Surface> kf()
  {
    synchronized (this.mLock)
    {
      if (this.mClosed)
      {
        localf = e.i(new a("DeferrableSurface already closed.", this));
        return localf;
      }
      f localf = jq();
      return localf;
    }
  }
  
  public static final class a
    extends Exception
  {
    public ad Dm;
    
    public a(String paramString, ad paramad)
    {
      super();
      this.Dm = paramad;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.impl.ad
 * JD-Core Version:    0.7.0.1
 */