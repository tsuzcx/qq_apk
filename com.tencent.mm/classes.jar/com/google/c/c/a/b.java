package com.google.c.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class b
  implements g
{
  public final void a(h paramh)
  {
    int j = 0;
    AppMethodBeat.i(12384);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('\000');
    while (paramh.JN())
    {
      localStringBuilder.append(paramh.JM());
      paramh.pos += 1;
      i = j.b(paramh.msg, paramh.pos, 5);
      if (i != 5) {
        paramh.cfj = i;
      }
    }
    int k = localStringBuilder.length() - 1;
    int i = paramh.cfi.length() + k + 1;
    paramh.hZ(i);
    if (paramh.cfk.cft - i > 0)
    {
      i = 1;
      if ((paramh.JN()) || (i != 0))
      {
        if (k > 249) {
          break label217;
        }
        localStringBuilder.setCharAt(0, (char)k);
      }
      label144:
      k = localStringBuilder.length();
      i = j;
      label154:
      if (i >= k) {
        break label296;
      }
      j = localStringBuilder.charAt(i) + ((paramh.cfi.length() + 1) * 149 % 255 + 1);
      if (j > 255) {
        break label285;
      }
    }
    label285:
    for (char c = (char)j;; c = (char)(j - 256))
    {
      paramh.k(c);
      i += 1;
      break label154;
      i = 0;
      break;
      label217:
      if (k <= 1555)
      {
        localStringBuilder.setCharAt(0, (char)(k / 250 + 249));
        localStringBuilder.insert(1, (char)(k % 250));
        break label144;
      }
      paramh = new IllegalStateException("Message length not in valid ranges: ".concat(String.valueOf(k)));
      AppMethodBeat.o(12384);
      throw paramh;
    }
    label296:
    AppMethodBeat.o(12384);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.c.c.a.b
 * JD-Core Version:    0.7.0.1
 */