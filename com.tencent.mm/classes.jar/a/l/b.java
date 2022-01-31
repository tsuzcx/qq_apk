package a.l;

import a.i.d;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"category", "Lkotlin/text/CharCategory;", "", "getCategory", "(C)Lkotlin/text/CharCategory;", "directionality", "Lkotlin/text/CharDirectionality;", "getDirectionality", "(C)Lkotlin/text/CharDirectionality;", "checkRadix", "", "radix", "digitOf", "char", "isDefined", "", "isDigit", "isHighSurrogate", "isISOControl", "isIdentifierIgnorable", "isJavaIdentifierPart", "isJavaIdentifierStart", "isLetter", "isLetterOrDigit", "isLowSurrogate", "isLowerCase", "isTitleCase", "isUpperCase", "isWhitespace", "toLowerCase", "toTitleCase", "toUpperCase", "kotlin-stdlib"}, eaR=1)
public class b
{
  public static final int We(int paramInt)
  {
    AppMethodBeat.i(56266);
    if ((2 > paramInt) || (36 < paramInt))
    {
      Throwable localThrowable = (Throwable)new IllegalArgumentException("radix " + paramInt + " was not in valid range " + new d(2, 36));
      AppMethodBeat.o(56266);
      throw localThrowable;
    }
    AppMethodBeat.o(56266);
    return paramInt;
  }
  
  public static final boolean isWhitespace(char paramChar)
  {
    AppMethodBeat.i(56265);
    if ((Character.isWhitespace(paramChar)) || (Character.isSpaceChar(paramChar)))
    {
      AppMethodBeat.o(56265);
      return true;
    }
    AppMethodBeat.o(56265);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.l.b
 * JD-Core Version:    0.7.0.1
 */