package com.tencent.luggage.game.e;

import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$a
  extends SparseIntArray
{
  final boolean bp(int paramInt)
  {
    AppMethodBeat.i(130696);
    if (super.indexOfKey(paramInt) >= 0)
    {
      AppMethodBeat.o(130696);
      return true;
    }
    AppMethodBeat.o(130696);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.e.a.a
 * JD-Core Version:    0.7.0.1
 */