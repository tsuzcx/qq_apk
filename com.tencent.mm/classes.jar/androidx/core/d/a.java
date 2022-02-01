package androidx.core.d;

import android.graphics.Typeface;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private final e.c brw;
  private final Handler brx;
  
  public a(e.c paramc, Handler paramHandler)
  {
    this.brw = paramc;
    this.brx = paramHandler;
  }
  
  final void a(final d.a parama)
  {
    AppMethodBeat.i(196226);
    if (parama.brM == 0) {}
    for (final int i = 1; i != 0; i = 0)
    {
      parama = parama.brL;
      final e.c localc = this.brw;
      this.brx.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(196271);
          localc.d(parama);
          AppMethodBeat.o(196271);
        }
      });
      AppMethodBeat.o(196226);
      return;
    }
    i = parama.brM;
    parama = this.brw;
    this.brx.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(196264);
        parama.ei(i);
        AppMethodBeat.o(196264);
      }
    });
    AppMethodBeat.o(196226);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.core.d.a
 * JD-Core Version:    0.7.0.1
 */