package com.google.android.gms.internal.wearable;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public final class zzm
  extends IOException
{
  zzm(int paramInt1, int paramInt2)
  {
    super(108 + "CodedOutputStream was writing to a flat byte array and ran out of space (pos " + paramInt1 + " limit " + paramInt2 + ").");
    AppMethodBeat.i(100732);
    AppMethodBeat.o(100732);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.internal.wearable.zzm
 * JD-Core Version:    0.7.0.1
 */