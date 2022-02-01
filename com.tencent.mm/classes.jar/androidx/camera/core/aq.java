package androidx.camera.core;

import android.media.ImageReader;
import android.util.Size;
import android.util.SparseArray;
import android.view.Surface;
import androidx.c.a.b.a;
import androidx.camera.core.impl.a.b.c;
import androidx.camera.core.impl.a.b.e;
import androidx.camera.core.impl.aa;
import androidx.camera.core.impl.ab;
import androidx.camera.core.impl.an;
import androidx.camera.core.impl.an.a;
import androidx.camera.core.impl.bi;
import androidx.camera.core.impl.h;
import androidx.camera.core.impl.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

final class aq
  implements an
{
  final aa HI;
  private an.a IK;
  private c<List<ag>> IL;
  boolean IM;
  final am IN;
  final an IP;
  b.a<Void> IQ;
  private com.google.b.b.a.f<Void> IR;
  final Executor IS;
  String IT;
  au IU;
  final List<Integer> IV;
  private an.a Im;
  an.a Io;
  boolean mClosed;
  Executor mExecutor;
  final Object mLock;
  
  aq(a parama)
  {
    AppMethodBeat.i(198327);
    this.mLock = new Object();
    this.Im = new an.a()
    {
      public final void onImageAvailable(an paramAnonymousan)
      {
        AppMethodBeat.i(198425);
        aq localaq = aq.this;
        synchronized (localaq.mLock)
        {
          if (localaq.mClosed)
          {
            AppMethodBeat.o(198425);
            return;
          }
          try
          {
            paramAnonymousan = paramAnonymousan.iv();
            if (paramAnonymousan != null)
            {
              Integer localInteger = (Integer)paramAnonymousan.it().go().getTag(localaq.IT);
              if (localaq.IV.contains(localInteger)) {
                break label110;
              }
              "ImageProxyBundle does not contain this id: ".concat(String.valueOf(localInteger));
              al.R("ProcessingImageReader");
              paramAnonymousan.close();
            }
          }
          catch (IllegalStateException paramAnonymousan)
          {
            for (;;)
            {
              al.U("ProcessingImageReader");
            }
          }
          finally
          {
            AppMethodBeat.o(198425);
          }
          AppMethodBeat.o(198425);
          return;
          label110:
          localaq.IU.g(paramAnonymousan);
        }
      }
    };
    this.IK = new an.a()
    {
      public final void onImageAvailable(an arg1)
      {
        AppMethodBeat.i(198439);
        for (;;)
        {
          au localau;
          synchronized (aq.this.mLock)
          {
            an.a locala = aq.this.Io;
            Executor localExecutor = aq.this.mExecutor;
            localau = aq.this.IU;
            synchronized (localau.mLock)
            {
              if (localau.mClosed)
              {
                aq.this.jp();
                if (locala == null) {
                  break label205;
                }
                if (localExecutor == null) {
                  break;
                }
                localExecutor.execute(new aq.2..ExternalSyntheticLambda0(this, locala));
                AppMethodBeat.o(198439);
                return;
              }
              Iterator localIterator = localau.Jj.iterator();
              if (localIterator.hasNext()) {
                ((ag)localIterator.next()).close();
              }
            }
          }
          localau.Jj.clear();
          localau.Ji.clear();
          localau.Jh.clear();
          localau.setup();
        }
        localObject3.onImageAvailable(aq.this);
        label205:
        AppMethodBeat.o(198439);
      }
    };
    this.IL = new c()
    {
      public final void onFailure(Throwable paramAnonymousThrowable) {}
    };
    this.mClosed = false;
    this.IM = false;
    this.IT = new String();
    this.IU = new au(Collections.emptyList(), this.IT);
    this.IV = new ArrayList();
    if (parama.IN.ix() < parama.HG.iM().size())
    {
      parama = new IllegalArgumentException("MetadataImageReader is smaller than CaptureBundle.");
      AppMethodBeat.o(198327);
      throw parama;
    }
    this.IN = parama.IN;
    int k = this.IN.getWidth();
    int m = this.IN.getHeight();
    int j = m;
    int i = k;
    if (parama.IX == 256)
    {
      i = 64000 + (int)(m * k * 1.5F);
      j = 1;
    }
    this.IP = new b(ImageReader.newInstance(i, j, parama.IX, this.IN.ix()));
    this.IS = parama.IS;
    this.HI = parama.HI;
    this.HI.a(this.IP.getSurface(), parama.IX);
    this.HI.c(new Size(this.IN.getWidth(), this.IN.getHeight()));
    b(parama.HG);
    AppMethodBeat.o(198327);
  }
  
  public final void a(an.a parama, Executor paramExecutor)
  {
    AppMethodBeat.i(198423);
    synchronized (this.mLock)
    {
      this.Io = ((an.a)androidx.core.f.f.checkNotNull(parama));
      this.mExecutor = ((Executor)androidx.core.f.f.checkNotNull(paramExecutor));
      this.IN.a(this.Im, paramExecutor);
      this.IP.a(this.IK, paramExecutor);
      AppMethodBeat.o(198423);
      return;
    }
  }
  
  public final void b(y paramy)
  {
    AppMethodBeat.i(198436);
    synchronized (this.mLock)
    {
      if (paramy.iM() == null) {
        break label138;
      }
      if (this.IN.ix() < paramy.iM().size())
      {
        paramy = new IllegalArgumentException("CaptureBundle is larger than InputImageReader.");
        AppMethodBeat.o(198436);
        throw paramy;
      }
    }
    this.IV.clear();
    Iterator localIterator = paramy.iM().iterator();
    while (localIterator.hasNext())
    {
      ab localab = (ab)localIterator.next();
      if (localab != null) {
        this.IV.add(Integer.valueOf(localab.getId()));
      }
    }
    label138:
    this.IT = Integer.toString(paramy.hashCode());
    this.IU = new au(this.IV, this.IT);
    jp();
    AppMethodBeat.o(198436);
  }
  
  public final void close()
  {
    AppMethodBeat.i(198363);
    synchronized (this.mLock)
    {
      if (this.mClosed)
      {
        AppMethodBeat.o(198363);
        return;
      }
      this.IP.iy();
      if (!this.IM)
      {
        this.IN.close();
        this.IU.close();
        this.IP.close();
        if (this.IQ != null) {
          this.IQ.ap(null);
        }
      }
      this.mClosed = true;
      AppMethodBeat.o(198363);
      return;
    }
  }
  
  public final int getHeight()
  {
    AppMethodBeat.i(198381);
    synchronized (this.mLock)
    {
      int i = this.IN.getHeight();
      AppMethodBeat.o(198381);
      return i;
    }
  }
  
  public final Surface getSurface()
  {
    AppMethodBeat.i(198415);
    synchronized (this.mLock)
    {
      Surface localSurface = this.IN.getSurface();
      AppMethodBeat.o(198415);
      return localSurface;
    }
  }
  
  public final int getWidth()
  {
    AppMethodBeat.i(198392);
    synchronized (this.mLock)
    {
      int i = this.IN.getWidth();
      AppMethodBeat.o(198392);
      return i;
    }
  }
  
  public final ag iu()
  {
    AppMethodBeat.i(198348);
    synchronized (this.mLock)
    {
      ag localag = this.IP.iu();
      AppMethodBeat.o(198348);
      return localag;
    }
  }
  
  public final ag iv()
  {
    AppMethodBeat.i(198354);
    synchronized (this.mLock)
    {
      ag localag = this.IP.iv();
      AppMethodBeat.o(198354);
      return localag;
    }
  }
  
  public final int iw()
  {
    AppMethodBeat.i(198400);
    synchronized (this.mLock)
    {
      int i = this.IP.iw();
      AppMethodBeat.o(198400);
      return i;
    }
  }
  
  public final int ix()
  {
    AppMethodBeat.i(198408);
    synchronized (this.mLock)
    {
      int i = this.IN.ix();
      AppMethodBeat.o(198408);
      return i;
    }
  }
  
  public final void iy()
  {
    AppMethodBeat.i(198429);
    synchronized (this.mLock)
    {
      this.Io = null;
      this.mExecutor = null;
      this.IN.iy();
      this.IP.iy();
      if (!this.IM) {
        this.IU.close();
      }
      AppMethodBeat.o(198429);
      return;
    }
  }
  
  final com.google.b.b.a.f<Void> jn()
  {
    AppMethodBeat.i(198373);
    synchronized (this.mLock)
    {
      if ((this.mClosed) && (!this.IM))
      {
        localf = e.v(null);
        AppMethodBeat.o(198373);
        return localf;
      }
      if (this.IR == null) {
        this.IR = androidx.c.a.b.a(new aq..ExternalSyntheticLambda0(this));
      }
      com.google.b.b.a.f localf = e.d(this.IR);
    }
  }
  
  final h jo()
  {
    synchronized (this.mLock)
    {
      h localh = this.IN.Cc;
      return localh;
    }
  }
  
  final void jp()
  {
    AppMethodBeat.i(198447);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.IV.iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      localArrayList.add(this.IU.aV(localInteger.intValue()));
    }
    e.a(e.j(localArrayList), this.IL, this.IS);
    AppMethodBeat.o(198447);
  }
  
  static final class a
  {
    protected final y HG;
    protected final aa HI;
    protected final am IN;
    protected Executor IS;
    protected int IX;
    
    a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, y paramy, aa paramaa)
    {
      this(new am(paramInt1, paramInt2, paramInt3, paramInt4), paramy, paramaa);
      AppMethodBeat.i(198252);
      AppMethodBeat.o(198252);
    }
    
    private a(am paramam, y paramy, aa paramaa)
    {
      AppMethodBeat.i(198246);
      this.IS = Executors.newSingleThreadExecutor();
      this.IN = paramam;
      this.HG = paramy;
      this.HI = paramaa;
      this.IX = paramam.iw();
      AppMethodBeat.o(198246);
    }
    
    final a a(Executor paramExecutor)
    {
      this.IS = paramExecutor;
      return this;
    }
    
    final a aU(int paramInt)
    {
      this.IX = paramInt;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.aq
 * JD-Core Version:    0.7.0.1
 */