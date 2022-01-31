package a.j.b.a.c.i.b;

import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class e
  extends m<Character>
{
  public e(char paramChar)
  {
    super(Character.valueOf(paramChar));
    AppMethodBeat.i(122077);
    AppMethodBeat.o(122077);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(122076);
    int j = ((Character)getValue()).charValue();
    char c = ((Character)getValue()).charValue();
    int i;
    switch (c)
    {
    case '\013': 
    default: 
      i = (byte)Character.getType(c);
      if ((i != 0) && (i != 13) && (i != 14) && (i != 15) && (i != 16) && (i != 18) && (i != 19))
      {
        i = 1;
        if (i == 0) {
          break label215;
        }
      }
      break;
    }
    label215:
    for (String str = Character.toString(c);; str = "?")
    {
      j.p(str, "if (isPrintableUnicode(c…cter.toString(c) else \"?\"");
      for (;;)
      {
        str = String.format("\\u%04X ('%s')", Arrays.copyOf(new Object[] { Integer.valueOf(j), str }, 2));
        j.p(str, "java.lang.String.format(this, *args)");
        AppMethodBeat.o(122076);
        return str;
        str = "\\b";
        continue;
        str = "\\t";
        continue;
        str = "\\n";
        continue;
        str = "\\f";
        continue;
        str = "\\r";
      }
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.c.i.b.e
 * JD-Core Version:    0.7.0.1
 */