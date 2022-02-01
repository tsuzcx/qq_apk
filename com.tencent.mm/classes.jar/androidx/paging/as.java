package androidx.paging;

import androidx.recyclerview.widget.g.a;
import androidx.recyclerview.widget.g.b;
import androidx.recyclerview.widget.g.c;
import androidx.recyclerview.widget.q;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class as
{
  static int a(g.b paramb, ar paramar1, ar paramar2, int paramInt)
  {
    AppMethodBeat.i(196684);
    int i = paramar1.computeLeadingNulls();
    int k = paramInt - i;
    int j = paramar1.size();
    int m = paramar1.computeTrailingNulls();
    if ((k >= 0) && (k < j - i - m))
    {
      i = 0;
      while (i < 30)
      {
        m = i / 2;
        if (i % 2 == 1) {}
        for (j = -1;; j = 1)
        {
          j = j * m + k;
          if ((j < 0) || (j >= paramar1.Ie())) {
            break label214;
          }
          if ((j >= 0) && (j < paramb.bVl.length)) {
            break;
          }
          paramb = new IndexOutOfBoundsException("Index out of bounds - passed position = " + j + ", old list size = " + paramb.bVl.length);
          AppMethodBeat.o(196684);
          throw paramb;
        }
        j = paramb.bVl[j];
        if ((j & 0x1F) == 0) {
          j = -1;
        }
        while (j != -1)
        {
          paramInt = paramar2.getLeadingNullCount();
          AppMethodBeat.o(196684);
          return j + paramInt;
          j >>= 5;
        }
        label214:
        i += 1;
      }
    }
    paramInt = Math.max(0, Math.min(paramInt, paramar2.size() - 1));
    AppMethodBeat.o(196684);
    return paramInt;
  }
  
  static final class a
    implements q
  {
    private final int Sc;
    private final q bQg;
    
    a(int paramInt, q paramq)
    {
      this.Sc = paramInt;
      this.bQg = paramq;
    }
    
    public final void aR(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(196899);
      this.bQg.aR(this.Sc + paramInt1, paramInt2);
      AppMethodBeat.o(196899);
    }
    
    public final void aS(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(196903);
      this.bQg.aS(this.Sc + paramInt1, paramInt2);
      AppMethodBeat.o(196903);
    }
    
    public final void aW(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(196908);
      this.bQg.aW(this.Sc + paramInt1, this.Sc + paramInt2);
      AppMethodBeat.o(196908);
    }
    
    public final void c(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(196913);
      this.bQg.c(this.Sc + paramInt1, paramInt2, paramObject);
      AppMethodBeat.o(196913);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.paging.as
 * JD-Core Version:    0.7.0.1
 */