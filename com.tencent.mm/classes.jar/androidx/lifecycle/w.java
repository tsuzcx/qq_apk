package androidx.lifecycle;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class w
{
  final m aaB;
  private a aaJ;
  private final Handler mHandler;
  
  public w(l paraml)
  {
    AppMethodBeat.i(188862);
    this.aaB = new m(paraml);
    this.mHandler = new Handler();
    AppMethodBeat.o(188862);
  }
  
  final void d(h.a parama)
  {
    AppMethodBeat.i(188863);
    if (this.aaJ != null) {
      this.aaJ.run();
    }
    this.aaJ = new a(this.aaB, parama);
    this.mHandler.postAtFrontOfQueue(this.aaJ);
    AppMethodBeat.o(188863);
  }
  
  static final class a
    implements Runnable
  {
    private final m aaB;
    final h.a aaK;
    private boolean aaL = false;
    
    a(m paramm, h.a parama)
    {
      this.aaB = paramm;
      this.aaK = parama;
    }
    
    public final void run()
    {
      AppMethodBeat.i(188860);
      if (!this.aaL)
      {
        this.aaB.a(this.aaK);
        this.aaL = true;
      }
      AppMethodBeat.o(188860);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     androidx.lifecycle.w
 * JD-Core Version:    0.7.0.1
 */