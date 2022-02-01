package androidx.lifecycle;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ae
{
  final s bHV;
  private a bIr;
  private final Handler mHandler;
  
  public ae(q paramq)
  {
    AppMethodBeat.i(194434);
    this.bHV = new s(paramq);
    this.mHandler = new Handler();
    AppMethodBeat.o(194434);
  }
  
  final void c(j.a parama)
  {
    AppMethodBeat.i(194443);
    if (this.bIr != null) {
      this.bIr.run();
    }
    this.bIr = new a(this.bHV, parama);
    this.mHandler.postAtFrontOfQueue(this.bIr);
    AppMethodBeat.o(194443);
  }
  
  static final class a
    implements Runnable
  {
    private final s bHV;
    final j.a bIs;
    private boolean bIt = false;
    
    a(s params, j.a parama)
    {
      this.bHV = params;
      this.bIs = parama;
    }
    
    public final void run()
    {
      AppMethodBeat.i(194339);
      if (!this.bIt)
      {
        this.bHV.a(this.bIs);
        this.bIt = true;
      }
      AppMethodBeat.o(194339);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.lifecycle.ae
 * JD-Core Version:    0.7.0.1
 */