package a.h;

import a.a.n;
import a.d.b.g;
import a.e.d;
import java.util.Collection;
import java.util.Iterator;

public class k
  extends j
{
  public static final boolean X(CharSequence paramCharSequence)
  {
    g.k(paramCharSequence, "$receiver");
    if (paramCharSequence.length() != 0)
    {
      g.k(paramCharSequence, "$receiver");
      Object localObject = (Iterable)new d(0, paramCharSequence.length() - 1);
      if (((localObject instanceof Collection)) && (((Collection)localObject).isEmpty())) {
        break label123;
      }
      localObject = ((Iterable)localObject).iterator();
      if (!((Iterator)localObject).hasNext()) {
        break label123;
      }
      char c = paramCharSequence.charAt(((n)localObject).nextInt());
      if ((!Character.isWhitespace(c)) && (!Character.isSpaceChar(c))) {
        break label118;
      }
      i = 1;
      label106:
      if (i != 0) {
        break label121;
      }
    }
    label118:
    label121:
    label123:
    for (int i = 0;; i = 1)
    {
      if (i == 0) {
        break label128;
      }
      return true;
      i = 0;
      break label106;
      break;
    }
    label128:
    return false;
  }
  
  public static final boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    g.k(paramString1, "$receiver");
    g.k(paramString2, "other");
    if (!paramBoolean) {
      return paramString1.regionMatches(0, paramString2, paramInt1, paramInt2);
    }
    return paramString1.regionMatches(paramBoolean, 0, paramString2, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.h.k
 * JD-Core Version:    0.7.0.1
 */