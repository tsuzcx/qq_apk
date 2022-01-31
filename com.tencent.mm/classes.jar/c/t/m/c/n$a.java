package c.t.m.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CountDownLatch;

class n$a
  extends Thread
{
  private String b;
  
  public n$a(n paramn, String paramString)
  {
    this.b = paramString;
  }
  
  public void run()
  {
    AppMethodBeat.i(136388);
    e.a(n.a(this.a)).a(this.b);
    n.b(this.a).countDown();
    AppMethodBeat.o(136388);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     c.t.m.c.n.a
 * JD-Core Version:    0.7.0.1
 */