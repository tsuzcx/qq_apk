package com.google.android.exoplayer2.c.d;

import android.util.Pair;
import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.UUID;

public final class h
{
  public static UUID v(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(92122);
    paramArrayOfByte = w(paramArrayOfByte);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(92122);
      return null;
    }
    paramArrayOfByte = (UUID)paramArrayOfByte.first;
    AppMethodBeat.o(92122);
    return paramArrayOfByte;
  }
  
  private static Pair<UUID, byte[]> w(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(92123);
    paramArrayOfByte = new m(paramArrayOfByte);
    if (paramArrayOfByte.limit < 32)
    {
      AppMethodBeat.o(92123);
      return null;
    }
    paramArrayOfByte.setPosition(0);
    if (paramArrayOfByte.readInt() != paramArrayOfByte.UF() + 4)
    {
      AppMethodBeat.o(92123);
      return null;
    }
    if (paramArrayOfByte.readInt() != a.cPb)
    {
      AppMethodBeat.o(92123);
      return null;
    }
    int i = a.hG(paramArrayOfByte.readInt());
    if (i > 1)
    {
      AppMethodBeat.o(92123);
      return null;
    }
    UUID localUUID = new UUID(paramArrayOfByte.readLong(), paramArrayOfByte.readLong());
    if (i == 1) {
      paramArrayOfByte.iH(paramArrayOfByte.UN() * 16);
    }
    i = paramArrayOfByte.UN();
    if (i != paramArrayOfByte.UF())
    {
      AppMethodBeat.o(92123);
      return null;
    }
    byte[] arrayOfByte = new byte[i];
    paramArrayOfByte.readBytes(arrayOfByte, 0, i);
    paramArrayOfByte = Pair.create(localUUID, arrayOfByte);
    AppMethodBeat.o(92123);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.c.d.h
 * JD-Core Version:    0.7.0.1
 */