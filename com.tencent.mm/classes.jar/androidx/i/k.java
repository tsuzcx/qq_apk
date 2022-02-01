package androidx.i;

import androidx.recyclerview.widget.h.a;
import androidx.recyclerview.widget.h.b;
import androidx.recyclerview.widget.h.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class k
{
  static int a(h.b paramb, j paramj1, j paramj2, int paramInt)
  {
    AppMethodBeat.i(216682);
    int i = paramj1.jJ();
    int k = paramInt - i;
    int j = paramj1.size();
    int m = paramj1.jK();
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
          if ((j < 0) || (j >= paramj1.aes)) {
            break label214;
          }
          if ((j >= 0) && (j < paramb.agF.length)) {
            break;
          }
          paramb = new IndexOutOfBoundsException("Index out of bounds - passed position = " + j + ", old list size = " + paramb.agF.length);
          AppMethodBeat.o(216682);
          throw paramb;
        }
        j = paramb.agF[j];
        if ((j & 0x1F) == 0) {
          j = -1;
        }
        while (j != -1)
        {
          paramInt = paramj2.aeo;
          AppMethodBeat.o(216682);
          return j + paramInt;
          j >>= 5;
        }
        label214:
        i += 1;
      }
    }
    paramInt = Math.max(0, Math.min(paramInt, paramj2.size() - 1));
    AppMethodBeat.o(216682);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.i.k
 * JD-Core Version:    0.7.0.1
 */