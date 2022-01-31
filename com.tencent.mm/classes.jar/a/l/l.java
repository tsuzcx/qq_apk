package a.l;

import com.tencent.matrix.trace.core.AppMethodBeat;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/text/ScreenFloatValueRegEx;", "", "()V", "value", "Lkotlin/text/Regex;", "kotlin-stdlib"})
final class l
{
  public static final k CGX;
  public static final l CGY;
  
  static
  {
    AppMethodBeat.i(56362);
    CGY = new l();
    String str1 = "[eE][+-]?".concat(String.valueOf("(\\p{Digit}+)"));
    String str2 = "(0[xX]" + "(\\p{XDigit}+)" + "(\\.)?)|(0[xX]" + "(\\p{XDigit}+)" + "?(\\.)" + "(\\p{XDigit}+)" + ')';
    str1 = "(" + "(\\p{Digit}+)" + "(\\.)?(" + "(\\p{Digit}+)" + "?)(" + str1 + ")?)|(\\.(" + "(\\p{Digit}+)" + ")(" + str1 + ")?)|((" + str2 + ")[pP][+-]?" + "(\\p{Digit}+)" + ')';
    CGX = new k("[\\x00-\\x20]*[+-]?(NaN|Infinity|((" + str1 + ")[fFdD]?))[\\x00-\\x20]*");
    AppMethodBeat.o(56362);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.l.l
 * JD-Core Version:    0.7.0.1
 */