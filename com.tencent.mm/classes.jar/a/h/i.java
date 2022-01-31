package a.h;

import a.d.b.g;

public class i
  extends h
{
  public static final <T> void a(Appendable paramAppendable, T paramT)
  {
    g.k(paramAppendable, "$receiver");
    if (paramT != null) {}
    for (boolean bool = paramT instanceof CharSequence; bool; bool = true)
    {
      paramAppendable.append((CharSequence)paramT);
      return;
    }
    if ((paramT instanceof Character))
    {
      paramAppendable.append(((Character)paramT).charValue());
      return;
    }
    paramAppendable.append((CharSequence)String.valueOf(paramT));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.h.i
 * JD-Core Version:    0.7.0.1
 */