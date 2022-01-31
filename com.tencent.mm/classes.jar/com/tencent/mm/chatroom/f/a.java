package com.tencent.mm.chatroom.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static int bU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104481);
    switch (paramInt1)
    {
    default: 
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Invalid Month");
      AppMethodBeat.o(104481);
      throw localIllegalArgumentException;
    case 0: 
    case 2: 
    case 4: 
    case 6: 
    case 7: 
    case 9: 
    case 11: 
      AppMethodBeat.o(104481);
      return 31;
    case 3: 
    case 5: 
    case 8: 
    case 10: 
      AppMethodBeat.o(104481);
      return 30;
    }
    if (((paramInt2 % 4 == 0) && (paramInt2 % 100 != 0)) || (paramInt2 % 400 == 0))
    {
      AppMethodBeat.o(104481);
      return 29;
    }
    AppMethodBeat.o(104481);
    return 28;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.f.a
 * JD-Core Version:    0.7.0.1
 */