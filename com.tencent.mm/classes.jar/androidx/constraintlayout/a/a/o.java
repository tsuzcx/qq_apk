package androidx.constraintlayout.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Iterator;

public class o
{
  HashSet<o> Es;
  public int state;
  
  public o()
  {
    AppMethodBeat.i(229632);
    this.Es = new HashSet(2);
    this.state = 0;
    AppMethodBeat.o(229632);
  }
  
  public final void a(o paramo)
  {
    AppMethodBeat.i(229635);
    this.Es.add(paramo);
    AppMethodBeat.o(229635);
  }
  
  public final void fV()
  {
    AppMethodBeat.i(229642);
    this.state = 1;
    Iterator localIterator = this.Es.iterator();
    while (localIterator.hasNext()) {
      ((o)localIterator.next()).fs();
    }
    AppMethodBeat.o(229642);
  }
  
  public final boolean fW()
  {
    return this.state == 1;
  }
  
  public void fs() {}
  
  public final void invalidate()
  {
    AppMethodBeat.i(229640);
    this.state = 0;
    Iterator localIterator = this.Es.iterator();
    while (localIterator.hasNext()) {
      ((o)localIterator.next()).invalidate();
    }
    AppMethodBeat.o(229640);
  }
  
  public void reset()
  {
    AppMethodBeat.i(229637);
    this.state = 0;
    this.Es.clear();
    AppMethodBeat.o(229637);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     androidx.constraintlayout.a.a.o
 * JD-Core Version:    0.7.0.1
 */