package com.tencent.mapsdk.internal;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class ks
{
  public static final int a = 1;
  public static final int b = 0;
  public final Rect c;
  public int[] d;
  public int[] e;
  public int[] f;
  
  public ks()
  {
    AppMethodBeat.i(222351);
    this.c = new Rect();
    AppMethodBeat.o(222351);
  }
  
  private static ks a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(222377);
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.nativeOrder());
    if (paramArrayOfByte.get() == 0)
    {
      AppMethodBeat.o(222377);
      return null;
    }
    ks localks = new ks();
    localks.d = new int[paramArrayOfByte.get()];
    localks.e = new int[paramArrayOfByte.get()];
    localks.f = new int[paramArrayOfByte.get()];
    a(localks.d.length);
    a(localks.e.length);
    paramArrayOfByte.getInt();
    paramArrayOfByte.getInt();
    localks.c.left = paramArrayOfByte.getInt();
    localks.c.right = paramArrayOfByte.getInt();
    localks.c.top = paramArrayOfByte.getInt();
    localks.c.bottom = paramArrayOfByte.getInt();
    paramArrayOfByte.getInt();
    a(localks.d, paramArrayOfByte);
    a(localks.e, paramArrayOfByte);
    a(localks.f, paramArrayOfByte);
    AppMethodBeat.o(222377);
    return localks;
  }
  
  private static void a(int paramInt)
  {
    AppMethodBeat.i(222367);
    if ((paramInt == 0) || ((paramInt & 0x1) != 0))
    {
      RuntimeException localRuntimeException = new RuntimeException("invalid nine-patch: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(222367);
      throw localRuntimeException;
    }
    AppMethodBeat.o(222367);
  }
  
  private static void a(int[] paramArrayOfInt, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(222358);
    int i = 0;
    int j = paramArrayOfInt.length;
    while (i < j)
    {
      paramArrayOfInt[i] = paramByteBuffer.getInt();
      i += 1;
    }
    AppMethodBeat.o(222358);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ks
 * JD-Core Version:    0.7.0.1
 */