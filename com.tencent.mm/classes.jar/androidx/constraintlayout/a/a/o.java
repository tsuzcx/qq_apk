package androidx.constraintlayout.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Iterator;

public class o
{
  HashSet<o> bkA;
  public int state;
  
  public o()
  {
    AppMethodBeat.i(194027);
    this.bkA = new HashSet(2);
    this.state = 0;
    AppMethodBeat.o(194027);
  }
  
  public void CB() {}
  
  public final void De()
  {
    AppMethodBeat.i(194057);
    this.state = 1;
    Iterator localIterator = this.bkA.iterator();
    while (localIterator.hasNext()) {
      ((o)localIterator.next()).CB();
    }
    AppMethodBeat.o(194057);
  }
  
  public final boolean Df()
  {
    return this.state == 1;
  }
  
  public final void a(o paramo)
  {
    AppMethodBeat.i(194034);
    this.bkA.add(paramo);
    AppMethodBeat.o(194034);
  }
  
  public final void invalidate()
  {
    AppMethodBeat.i(194051);
    this.state = 0;
    Iterator localIterator = this.bkA.iterator();
    while (localIterator.hasNext()) {
      ((o)localIterator.next()).invalidate();
    }
    AppMethodBeat.o(194051);
  }
  
  public void reset()
  {
    AppMethodBeat.i(194045);
    this.state = 0;
    this.bkA.clear();
    AppMethodBeat.o(194045);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     androidx.constraintlayout.a.a.o
 * JD-Core Version:    0.7.0.1
 */