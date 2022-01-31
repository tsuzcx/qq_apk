package com.google.android.exoplayer2.c.d;

import android.util.Pair;
import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.UUID;

public final class h
{
  public static UUID m(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95006);
    paramArrayOfByte = n(paramArrayOfByte);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(95006);
      return null;
    }
    paramArrayOfByte = (UUID)paramArrayOfByte.first;
    AppMethodBeat.o(95006);
    return paramArrayOfByte;
  }
  
  private static Pair<UUID, byte[]> n(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95007);
    paramArrayOfByte = new m(paramArrayOfByte);
    if (paramArrayOfByte.limit < 32)
    {
      AppMethodBeat.o(95007);
      return null;
    }
    paramArrayOfByte.setPosition(0);
    if (paramArrayOfByte.readInt() != paramArrayOfByte.qM() + 4)
    {
      AppMethodBeat.o(95007);
      return null;
    }
    if (paramArrayOfByte.readInt() != a.aFj)
    {
      AppMethodBeat.o(95007);
      return null;
    }
    int i = a.dt(paramArrayOfByte.readInt());
    if (i > 1)
    {
      AppMethodBeat.o(95007);
      return null;
    }
    UUID localUUID = new UUID(paramArrayOfByte.readLong(), paramArrayOfByte.readLong());
    if (i == 1) {
      paramArrayOfByte.en(paramArrayOfByte.qT() * 16);
    }
    i = paramArrayOfByte.qT();
    if (i != paramArrayOfByte.qM())
    {
      AppMethodBeat.o(95007);
      return null;
    }
    byte[] arrayOfByte = new byte[i];
    paramArrayOfByte.readBytes(arrayOfByte, 0, i);
    paramArrayOfByte = Pair.create(localUUID, arrayOfByte);
    AppMethodBeat.o(95007);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.c.d.h
 * JD-Core Version:    0.7.0.1
 */