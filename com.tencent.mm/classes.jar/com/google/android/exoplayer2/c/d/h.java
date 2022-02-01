package com.google.android.exoplayer2.c.d;

import android.util.Pair;
import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.UUID;

public final class h
{
  public static byte[] a(UUID paramUUID, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(92121);
    int i = paramArrayOfByte.length + 32;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(i);
    localByteBuffer.putInt(i);
    localByteBuffer.putInt(a.baB);
    localByteBuffer.putInt(0);
    localByteBuffer.putLong(paramUUID.getMostSignificantBits());
    localByteBuffer.putLong(paramUUID.getLeastSignificantBits());
    localByteBuffer.putInt(paramArrayOfByte.length);
    localByteBuffer.put(paramArrayOfByte);
    paramUUID = localByteBuffer.array();
    AppMethodBeat.o(92121);
    return paramUUID;
  }
  
  public static UUID r(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(92122);
    paramArrayOfByte = s(paramArrayOfByte);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(92122);
      return null;
    }
    paramArrayOfByte = (UUID)paramArrayOfByte.first;
    AppMethodBeat.o(92122);
    return paramArrayOfByte;
  }
  
  private static Pair<UUID, byte[]> s(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(92123);
    paramArrayOfByte = new m(paramArrayOfByte);
    if (paramArrayOfByte.limit < 32)
    {
      AppMethodBeat.o(92123);
      return null;
    }
    paramArrayOfByte.setPosition(0);
    if (paramArrayOfByte.readInt() != paramArrayOfByte.vJ() + 4)
    {
      AppMethodBeat.o(92123);
      return null;
    }
    if (paramArrayOfByte.readInt() != a.baB)
    {
      AppMethodBeat.o(92123);
      return null;
    }
    int i = a.ee(paramArrayOfByte.readInt());
    if (i > 1)
    {
      AppMethodBeat.o(92123);
      return null;
    }
    UUID localUUID = new UUID(paramArrayOfByte.readLong(), paramArrayOfByte.readLong());
    if (i == 1) {
      paramArrayOfByte.fl(paramArrayOfByte.vQ() * 16);
    }
    i = paramArrayOfByte.vQ();
    if (i != paramArrayOfByte.vJ())
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.d.h
 * JD-Core Version:    0.7.0.1
 */