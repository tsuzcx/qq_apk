package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.os.ParcelUuid;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;

final class c
{
  public static final ParcelUuid kJA;
  public static final ParcelUuid kJB;
  public static final ParcelUuid kJC;
  public static final ParcelUuid kJD;
  public static final ParcelUuid kJE;
  public static final ParcelUuid kJF;
  public static final ParcelUuid kJG;
  public static final ParcelUuid kJH;
  public static final ParcelUuid kJI;
  public static final ParcelUuid kJJ;
  public static final ParcelUuid kJK;
  public static final ParcelUuid kJL;
  public static final ParcelUuid kJM;
  public static final ParcelUuid kJN;
  public static final ParcelUuid[] kJO;
  public static final ParcelUuid kJu;
  public static final ParcelUuid kJv;
  public static final ParcelUuid kJw;
  public static final ParcelUuid kJx;
  public static final ParcelUuid kJy;
  public static final ParcelUuid kJz;
  
  static
  {
    AppMethodBeat.i(144620);
    kJu = ParcelUuid.fromString("0000110B-0000-1000-8000-00805F9B34FB");
    kJv = ParcelUuid.fromString("0000110A-0000-1000-8000-00805F9B34FB");
    kJw = ParcelUuid.fromString("0000110D-0000-1000-8000-00805F9B34FB");
    kJx = ParcelUuid.fromString("00001108-0000-1000-8000-00805F9B34FB");
    kJy = ParcelUuid.fromString("00001112-0000-1000-8000-00805F9B34FB");
    kJz = ParcelUuid.fromString("0000111E-0000-1000-8000-00805F9B34FB");
    kJA = ParcelUuid.fromString("0000111F-0000-1000-8000-00805F9B34FB");
    kJB = ParcelUuid.fromString("0000110E-0000-1000-8000-00805F9B34FB");
    kJC = ParcelUuid.fromString("0000110C-0000-1000-8000-00805F9B34FB");
    kJD = ParcelUuid.fromString("00001105-0000-1000-8000-00805f9b34fb");
    kJE = ParcelUuid.fromString("00001124-0000-1000-8000-00805f9b34fb");
    kJF = ParcelUuid.fromString("00001812-0000-1000-8000-00805f9b34fb");
    kJG = ParcelUuid.fromString("00001115-0000-1000-8000-00805F9B34FB");
    kJH = ParcelUuid.fromString("00001116-0000-1000-8000-00805F9B34FB");
    kJI = ParcelUuid.fromString("0000000f-0000-1000-8000-00805F9B34FB");
    kJJ = ParcelUuid.fromString("0000112f-0000-1000-8000-00805F9B34FB");
    kJK = ParcelUuid.fromString("00001134-0000-1000-8000-00805F9B34FB");
    kJL = ParcelUuid.fromString("00001133-0000-1000-8000-00805F9B34FB");
    kJM = ParcelUuid.fromString("00001132-0000-1000-8000-00805F9B34FB");
    kJN = ParcelUuid.fromString("00000000-0000-1000-8000-00805F9B34FB");
    kJO = new ParcelUuid[] { kJu, kJv, kJw, kJx, kJz, kJB, kJC, kJD, kJG, kJH, kJK, kJL, kJM };
    AppMethodBeat.o(144620);
  }
  
  public static ParcelUuid ar(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(144619);
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = new IllegalArgumentException("uuidBytes cannot be null");
      AppMethodBeat.o(144619);
      throw paramArrayOfByte;
    }
    int i = paramArrayOfByte.length;
    if ((i != 2) && (i != 4) && (i != 16))
    {
      paramArrayOfByte = new IllegalArgumentException("uuidBytes length invalid - ".concat(String.valueOf(i)));
      AppMethodBeat.o(144619);
      throw paramArrayOfByte;
    }
    if (i == 16)
    {
      paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.LITTLE_ENDIAN);
      paramArrayOfByte = new ParcelUuid(new UUID(paramArrayOfByte.getLong(8), paramArrayOfByte.getLong(0)));
      AppMethodBeat.o(144619);
      return paramArrayOfByte;
    }
    if (i == 2) {}
    for (long l = (paramArrayOfByte[0] & 0xFF) + ((paramArrayOfByte[1] & 0xFF) << 8);; l = (paramArrayOfByte[0] & 0xFF) + ((paramArrayOfByte[1] & 0xFF) << 8) + ((paramArrayOfByte[2] & 0xFF) << 16) + ((paramArrayOfByte[3] & 0xFF) << 24))
    {
      paramArrayOfByte = new ParcelUuid(new UUID(kJN.getUuid().getMostSignificantBits() + (l << 32), kJN.getUuid().getLeastSignificantBits()));
      AppMethodBeat.o(144619);
      return paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.c
 * JD-Core Version:    0.7.0.1
 */