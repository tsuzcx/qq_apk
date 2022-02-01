package androidx.appcompat.view;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.g.aa;
import androidx.core.g.ab;
import androidx.core.g.ac;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

public final class h
{
  final ArrayList<aa> kF;
  ab kG;
  private final ac kH;
  private long mDuration;
  private Interpolator mInterpolator;
  boolean mIsStarted;
  
  public h()
  {
    AppMethodBeat.i(239006);
    this.mDuration = -1L;
    this.kH = new ac()
    {
      private boolean kI = false;
      private int kJ = 0;
      
      public final void e(View paramAnonymousView)
      {
        AppMethodBeat.i(239002);
        if (this.kI)
        {
          AppMethodBeat.o(239002);
          return;
        }
        this.kI = true;
        if (h.this.kG != null) {
          h.this.kG.e(null);
        }
        AppMethodBeat.o(239002);
      }
      
      public final void f(View paramAnonymousView)
      {
        AppMethodBeat.i(239004);
        int i = this.kJ + 1;
        this.kJ = i;
        if (i == h.this.kF.size())
        {
          if (h.this.kG != null) {
            h.this.kG.f(null);
          }
          this.kJ = 0;
          this.kI = false;
          h.this.mIsStarted = false;
        }
        AppMethodBeat.o(239004);
      }
    };
    this.kF = new ArrayList();
    AppMethodBeat.o(239006);
  }
  
  public final h a(Interpolator paramInterpolator)
  {
    if (!this.mIsStarted) {
      this.mInterpolator = paramInterpolator;
    }
    return this;
  }
  
  public final h a(aa paramaa)
  {
    AppMethodBeat.i(239008);
    if (!this.mIsStarted) {
      this.kF.add(paramaa);
    }
    AppMethodBeat.o(239008);
    return this;
  }
  
  public final h a(aa paramaa1, aa paramaa2)
  {
    AppMethodBeat.i(239009);
    this.kF.add(paramaa1);
    paramaa2.g(paramaa1.getDuration());
    this.kF.add(paramaa2);
    AppMethodBeat.o(239009);
    return this;
  }
  
  public final h a(ab paramab)
  {
    if (!this.mIsStarted) {
      this.kG = paramab;
    }
    return this;
  }
  
  public final h bH()
  {
    if (!this.mIsStarted) {
      this.mDuration = 250L;
    }
    return this;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(239013);
    if (!this.mIsStarted)
    {
      AppMethodBeat.o(239013);
      return;
    }
    Iterator localIterator = this.kF.iterator();
    while (localIterator.hasNext()) {
      ((aa)localIterator.next()).cancel();
    }
    this.mIsStarted = false;
    AppMethodBeat.o(239013);
  }
  
  public final void start()
  {
    AppMethodBeat.i(239010);
    if (this.mIsStarted)
    {
      AppMethodBeat.o(239010);
      return;
    }
    Iterator localIterator = this.kF.iterator();
    while (localIterator.hasNext())
    {
      aa localaa = (aa)localIterator.next();
      if (this.mDuration >= 0L) {
        localaa.f(this.mDuration);
      }
      if (this.mInterpolator != null) {
        localaa.b(this.mInterpolator);
      }
      if (this.kG != null) {
        localaa.b(this.kH);
      }
      localaa.start();
    }
    this.mIsStarted = true;
    AppMethodBeat.o(239010);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.appcompat.view.h
 * JD-Core Version:    0.7.0.1
 */