package androidx.activity;

import androidx.lifecycle.j;
import androidx.lifecycle.j.a;
import androidx.lifecycle.j.b;
import androidx.lifecycle.o;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.Iterator;

public final class OnBackPressedDispatcher
{
  private final Runnable ex;
  final ArrayDeque<b> ey;
  
  public OnBackPressedDispatcher()
  {
    this(null);
  }
  
  public OnBackPressedDispatcher(Runnable paramRunnable)
  {
    AppMethodBeat.i(199182);
    this.ey = new ArrayDeque();
    this.ex = paramRunnable;
    AppMethodBeat.o(199182);
  }
  
  public final void a(q paramq, b paramb)
  {
    AppMethodBeat.i(199187);
    paramq = paramq.getLifecycle();
    if (paramq.getCurrentState() == j.b.bHg)
    {
      AppMethodBeat.o(199187);
      return;
    }
    paramb.a(new LifecycleOnBackPressedCancellable(paramq, paramb));
    AppMethodBeat.o(199187);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(199194);
    Iterator localIterator = this.ey.descendingIterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.mEnabled)
      {
        localb.handleOnBackPressed();
        AppMethodBeat.o(199194);
        return;
      }
    }
    if (this.ex != null) {
      this.ex.run();
    }
    AppMethodBeat.o(199194);
  }
  
  class LifecycleOnBackPressedCancellable
    implements a, o
  {
    private a eA;
    private final j ez;
    private final b mOnBackPressedCallback;
    
    LifecycleOnBackPressedCancellable(j paramj, b paramb)
    {
      AppMethodBeat.i(199181);
      this.ez = paramj;
      this.mOnBackPressedCallback = paramb;
      paramj.addObserver(this);
      AppMethodBeat.o(199181);
    }
    
    public final void cancel()
    {
      AppMethodBeat.i(199196);
      this.ez.removeObserver(this);
      this.mOnBackPressedCallback.b(this);
      if (this.eA != null)
      {
        this.eA.cancel();
        this.eA = null;
      }
      AppMethodBeat.o(199196);
    }
    
    public void onStateChanged(q paramq, j.a parama)
    {
      AppMethodBeat.i(199189);
      if (parama == j.a.ON_START)
      {
        parama = OnBackPressedDispatcher.this;
        paramq = this.mOnBackPressedCallback;
        parama.ey.add(paramq);
        parama = new OnBackPressedDispatcher.a(parama, paramq);
        paramq.a(parama);
        this.eA = parama;
        AppMethodBeat.o(199189);
        return;
      }
      if (parama == j.a.ON_STOP)
      {
        if (this.eA != null)
        {
          this.eA.cancel();
          AppMethodBeat.o(199189);
        }
      }
      else if (parama == j.a.ON_DESTROY) {
        cancel();
      }
      AppMethodBeat.o(199189);
    }
  }
  
  final class a
    implements a
  {
    private final b mOnBackPressedCallback;
    
    a(b paramb)
    {
      this.mOnBackPressedCallback = paramb;
    }
    
    public final void cancel()
    {
      AppMethodBeat.i(199174);
      OnBackPressedDispatcher.this.ey.remove(this.mOnBackPressedCallback);
      this.mOnBackPressedCallback.b(this);
      AppMethodBeat.o(199174);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.activity.OnBackPressedDispatcher
 * JD-Core Version:    0.7.0.1
 */