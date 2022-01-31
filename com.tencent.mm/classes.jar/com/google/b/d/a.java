package com.google.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends n
{
  static final char[] bjM;
  static final int[] bjN;
  private static final char[] bjO;
  
  static
  {
    AppMethodBeat.i(57325);
    bjM = "0123456789-$:/.+ABCD".toCharArray();
    bjN = new int[] { 3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14 };
    bjO = new char[] { 65, 66, 67, 68 };
    AppMethodBeat.o(57325);
  }
  
  static boolean a(char[] paramArrayOfChar, char paramChar)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int j;
    int i;
    if (paramArrayOfChar != null)
    {
      j = paramArrayOfChar.length;
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        if (paramArrayOfChar[i] == paramChar) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.b.d.a
 * JD-Core Version:    0.7.0.1
 */