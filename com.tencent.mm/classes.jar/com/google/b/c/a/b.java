package com.google.b.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class b
  implements g
{
  public final void a(h paramh)
  {
    int j = 0;
    AppMethodBeat.i(57319);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('\000');
    while (paramh.sG())
    {
      localStringBuilder.append(paramh.sF());
      paramh.pos += 1;
      i = j.b(paramh.bjm, paramh.pos, 5);
      if (i != 5) {
        paramh.bjr = i;
      }
    }
    int k = localStringBuilder.length() - 1;
    int i = paramh.bjq.length() + k + 1;
    paramh.fg(i);
    if (paramh.bjs.bjB - i > 0)
    {
      i = 1;
      if ((paramh.sG()) || (i != 0))
      {
        if (k > 249) {
          break label216;
        }
        localStringBuilder.setCharAt(0, (char)k);
      }
      label143:
      k = localStringBuilder.length();
      i = j;
      label153:
      if (i >= k) {
        break label294;
      }
      j = localStringBuilder.charAt(i) + ((paramh.bjq.length() + 1) * 149 % 255 + 1);
      if (j > 255) {
        break label283;
      }
    }
    label283:
    for (char c = (char)j;; c = (char)(j - 256))
    {
      paramh.g(c);
      i += 1;
      break label153;
      i = 0;
      break;
      label216:
      if (k <= 1555)
      {
        localStringBuilder.setCharAt(0, (char)(k / 250 + 249));
        localStringBuilder.insert(1, (char)(k % 250));
        break label143;
      }
      paramh = new IllegalStateException("Message length not in valid ranges: ".concat(String.valueOf(k)));
      AppMethodBeat.o(57319);
      throw paramh;
    }
    label294:
    AppMethodBeat.o(57319);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.b.c.a.b
 * JD-Core Version:    0.7.0.1
 */