package androidx.camera.core;

import android.media.ImageReader;
import android.util.LongSparseArray;
import android.view.Surface;
import androidx.camera.core.impl.an;
import androidx.camera.core.impl.an.a;
import androidx.camera.core.impl.h;
import androidx.camera.core.impl.l;
import androidx.core.f.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

final class am
  implements aa.a, an
{
  h Cc;
  private an.a Im;
  private final an In;
  an.a Io;
  final LongSparseArray<af> Ip;
  private final LongSparseArray<ag> Iq;
  private int Ir;
  private final List<ag> Is;
  private final List<ag> It;
  boolean mClosed;
  private Executor mExecutor;
  final Object mLock;
  
  am(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this(new b(ImageReader.newInstance(paramInt1, paramInt2, paramInt3, paramInt4)));
    AppMethodBeat.i(198258);
    AppMethodBeat.o(198258);
  }
  
  private am(an paraman)
  {
    AppMethodBeat.i(198262);
    this.mLock = new Object();
    this.Cc = new h()
    {
      public final void a(l paramAnonymousl)
      {
        AppMethodBeat.i(198403);
        super.a(paramAnonymousl);
        am localam = am.this;
        synchronized (localam.mLock)
        {
          if (localam.mClosed)
          {
            AppMethodBeat.o(198403);
            return;
          }
          localam.Ip.put(paramAnonymousl.getTimestamp(), new androidx.camera.core.a.b(paramAnonymousl));
          localam.jh();
          AppMethodBeat.o(198403);
          return;
        }
      }
    };
    this.Im = new am..ExternalSyntheticLambda0(this);
    this.mClosed = false;
    this.Ip = new LongSparseArray();
    this.Iq = new LongSparseArray();
    this.It = new ArrayList();
    this.In = paraman;
    this.Ir = 0;
    this.Is = new ArrayList(ix());
    AppMethodBeat.o(198262);
  }
  
  public final void a(an.a parama, Executor paramExecutor)
  {
    AppMethodBeat.i(198321);
    synchronized (this.mLock)
    {
      this.Io = ((an.a)f.checkNotNull(parama));
      this.mExecutor = ((Executor)f.checkNotNull(paramExecutor));
      this.In.a(this.Im, paramExecutor);
      AppMethodBeat.o(198321);
      return;
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(198288);
    synchronized (this.mLock)
    {
      if (this.mClosed)
      {
        AppMethodBeat.o(198288);
        return;
      }
      Iterator localIterator = new ArrayList(this.Is).iterator();
      if (localIterator.hasNext()) {
        ((ag)localIterator.next()).close();
      }
    }
    this.Is.clear();
    this.In.close();
    this.mClosed = true;
    AppMethodBeat.o(198288);
  }
  
  public final int getHeight()
  {
    AppMethodBeat.i(198292);
    synchronized (this.mLock)
    {
      int i = this.In.getHeight();
      AppMethodBeat.o(198292);
      return i;
    }
  }
  
  public final Surface getSurface()
  {
    AppMethodBeat.i(198312);
    synchronized (this.mLock)
    {
      Surface localSurface = this.In.getSurface();
      AppMethodBeat.o(198312);
      return localSurface;
    }
  }
  
  public final int getWidth()
  {
    AppMethodBeat.i(198297);
    synchronized (this.mLock)
    {
      int i = this.In.getWidth();
      AppMethodBeat.o(198297);
      return i;
    }
  }
  
  public final ag iu()
  {
    AppMethodBeat.i(198282);
    synchronized (this.mLock)
    {
      if (this.Is.isEmpty())
      {
        AppMethodBeat.o(198282);
        return null;
      }
      if (this.Ir >= this.Is.size())
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("Maximum image number reached.");
        AppMethodBeat.o(198282);
        throw localIllegalStateException;
      }
    }
    Object localObject3 = new ArrayList();
    int i = 0;
    for (;;)
    {
      if (i < this.Is.size() - 1)
      {
        if (!this.It.contains(this.Is.get(i))) {
          ((List)localObject3).add((ag)this.Is.get(i));
        }
      }
      else
      {
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((ag)((Iterator)localObject3).next()).close();
        }
        this.Ir = (this.Is.size() - 1);
        localObject3 = this.Is;
        i = this.Ir;
        this.Ir = (i + 1);
        localObject3 = (ag)((List)localObject3).get(i);
        this.It.add(localObject3);
        AppMethodBeat.o(198282);
        return localObject3;
      }
      i += 1;
    }
  }
  
  public final ag iv()
  {
    AppMethodBeat.i(198285);
    synchronized (this.mLock)
    {
      if (this.Is.isEmpty())
      {
        AppMethodBeat.o(198285);
        return null;
      }
      if (this.Ir >= this.Is.size())
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("Maximum image number reached.");
        AppMethodBeat.o(198285);
        throw localIllegalStateException;
      }
    }
    Object localObject3 = this.Is;
    int i = this.Ir;
    this.Ir = (i + 1);
    localObject3 = (ag)((List)localObject3).get(i);
    this.It.add(localObject3);
    AppMethodBeat.o(198285);
    return localObject3;
  }
  
  public final int iw()
  {
    AppMethodBeat.i(198302);
    synchronized (this.mLock)
    {
      int i = this.In.iw();
      AppMethodBeat.o(198302);
      return i;
    }
  }
  
  public final int ix()
  {
    AppMethodBeat.i(198306);
    synchronized (this.mLock)
    {
      int i = this.In.ix();
      AppMethodBeat.o(198306);
      return i;
    }
  }
  
  public final void iy()
  {
    synchronized (this.mLock)
    {
      this.Io = null;
      this.mExecutor = null;
      return;
    }
  }
  
  final void jh()
  {
    AppMethodBeat.i(198343);
    int i;
    Object localObject5;
    for (;;)
    {
      synchronized (this.mLock)
      {
        i = this.Ip.size() - 1;
        if (i < 0) {
          break;
        }
        Object localObject1 = (af)this.Ip.valueAt(i);
        long l = ((af)localObject1).getTimestamp();
        localObject5 = (ag)this.Iq.get(l);
        if (localObject5 != null)
        {
          this.Iq.remove(l);
          this.Ip.removeAt(i);
          localObject1 = new at((ag)localObject5, (af)localObject1);
        }
        synchronized (this.mLock)
        {
          if (this.Is.size() < ix())
          {
            ((at)localObject1).a(this);
            this.Is.add(localObject1);
            localObject5 = this.Io;
            localObject1 = this.mExecutor;
            if (localObject5 != null)
            {
              if (localObject1 != null) {
                ((Executor)localObject1).execute(new am..ExternalSyntheticLambda1(this, (an.a)localObject5));
              }
            }
            else {
              i -= 1;
            }
          }
          else
          {
            al.O("TAG");
            ((at)localObject1).close();
            localObject1 = null;
            localObject5 = null;
          }
        }
      }
      ((an.a)localObject5).onImageAvailable(this);
    }
    for (;;)
    {
      synchronized (this.mLock)
      {
        if ((this.Iq.size() == 0) || (this.Ip.size() == 0))
        {
          AppMethodBeat.o(198343);
          return;
        }
        localObject5 = Long.valueOf(this.Iq.keyAt(0));
        ??? = Long.valueOf(this.Ip.keyAt(0));
        if (((Long)???).equals(localObject5)) {
          break label470;
        }
        bool = true;
        f.checkArgument(bool);
        if (((Long)???).longValue() > ((Long)localObject5).longValue())
        {
          i = this.Iq.size() - 1;
          if (i >= 0)
          {
            if (this.Iq.keyAt(i) >= ((Long)???).longValue()) {
              break label463;
            }
            ((ag)this.Iq.valueAt(i)).close();
            this.Iq.removeAt(i);
            break label463;
          }
        }
        else
        {
          i = this.Ip.size() - 1;
          if (i >= 0)
          {
            if (this.Ip.keyAt(i) >= ((Long)localObject5).longValue()) {
              break label476;
            }
            this.Ip.removeAt(i);
            break label476;
          }
        }
      }
      label463:
      i -= 1;
      continue;
      label470:
      boolean bool = false;
      continue;
      label476:
      i -= 1;
    }
  }
  
  public final void onImageClose(ag paramag)
  {
    AppMethodBeat.i(198333);
    synchronized (this.mLock)
    {
      synchronized (this.mLock)
      {
        int i = this.Is.indexOf(paramag);
        if (i >= 0)
        {
          this.Is.remove(i);
          if (i <= this.Ir) {
            this.Ir -= 1;
          }
        }
        this.It.remove(paramag);
        AppMethodBeat.o(198333);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.am
 * JD-Core Version:    0.7.0.1
 */