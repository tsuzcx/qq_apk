package androidx.appcompat.view;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.g.ad;
import androidx.core.g.ae;
import androidx.core.g.af;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

public final class h
{
  final ArrayList<ad> lB;
  ae lC;
  private final af lD;
  private long mDuration;
  private Interpolator mInterpolator;
  boolean mIsStarted;
  
  public h()
  {
    AppMethodBeat.i(200648);
    this.mDuration = -1L;
    this.lD = new af()
    {
      private boolean lE = false;
      private int lF = 0;
      
      public final void e(View paramAnonymousView)
      {
        AppMethodBeat.i(200689);
        if (this.lE)
        {
          AppMethodBeat.o(200689);
          return;
        }
        this.lE = true;
        if (h.this.lC != null) {
          h.this.lC.e(null);
        }
        AppMethodBeat.o(200689);
      }
      
      public final void f(View paramAnonymousView)
      {
        AppMethodBeat.i(200702);
        int i = this.lF + 1;
        this.lF = i;
        if (i == h.this.lB.size())
        {
          if (h.this.lC != null) {
            h.this.lC.f(null);
          }
          this.lF = 0;
          this.lE = false;
          h.this.mIsStarted = false;
        }
        AppMethodBeat.o(200702);
      }
    };
    this.lB = new ArrayList();
    AppMethodBeat.o(200648);
  }
  
  public final h a(ad paramad)
  {
    AppMethodBeat.i(200654);
    if (!this.mIsStarted) {
      this.lB.add(paramad);
    }
    AppMethodBeat.o(200654);
    return this;
  }
  
  public final h a(ad paramad1, ad paramad2)
  {
    AppMethodBeat.i(200663);
    this.lB.add(paramad1);
    paramad2.bv(paramad1.getDuration());
    this.lB.add(paramad2);
    AppMethodBeat.o(200663);
    return this;
  }
  
  public final h a(ae paramae)
  {
    if (!this.mIsStarted) {
      this.lC = paramae;
    }
    return this;
  }
  
  public final h b(Interpolator paramInterpolator)
  {
    if (!this.mIsStarted) {
      this.mInterpolator = paramInterpolator;
    }
    return this;
  }
  
  public final h cA()
  {
    if (!this.mIsStarted) {
      this.mDuration = 250L;
    }
    return this;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(200683);
    if (!this.mIsStarted)
    {
      AppMethodBeat.o(200683);
      return;
    }
    Iterator localIterator = this.lB.iterator();
    while (localIterator.hasNext()) {
      ((ad)localIterator.next()).cancel();
    }
    this.mIsStarted = false;
    AppMethodBeat.o(200683);
  }
  
  public final void start()
  {
    AppMethodBeat.i(200675);
    if (this.mIsStarted)
    {
      AppMethodBeat.o(200675);
      return;
    }
    Iterator localIterator = this.lB.iterator();
    while (localIterator.hasNext())
    {
      ad localad = (ad)localIterator.next();
      if (this.mDuration >= 0L) {
        localad.bu(this.mDuration);
      }
      if (this.mInterpolator != null) {
        localad.c(this.mInterpolator);
      }
      if (this.lC != null) {
        localad.b(this.lD);
      }
      localad.start();
    }
    this.mIsStarted = true;
    AppMethodBeat.o(200675);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.view.h
 * JD-Core Version:    0.7.0.1
 */