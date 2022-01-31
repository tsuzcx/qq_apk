package a.g;

import a.d.b.g;
import a.h.e;
import java.util.Iterator;

public class d
  extends c
{
  public static final <T, A extends Appendable> A a(a<? extends T> parama, A paramA, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, CharSequence paramCharSequence4)
  {
    g.k(parama, "$receiver");
    g.k(paramA, "buffer");
    g.k(paramCharSequence1, "separator");
    g.k(paramCharSequence2, "prefix");
    g.k(paramCharSequence3, "postfix");
    g.k(paramCharSequence4, "truncated");
    paramA.append(paramCharSequence2);
    int i = 0;
    parama = parama.iterator();
    while (parama.hasNext())
    {
      paramCharSequence2 = parama.next();
      i += 1;
      if (i > 1) {
        paramA.append(paramCharSequence1);
      }
      e.a(paramA, paramCharSequence2);
    }
    paramA.append(paramCharSequence3);
    return paramA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     a.g.d
 * JD-Core Version:    0.7.0.1
 */