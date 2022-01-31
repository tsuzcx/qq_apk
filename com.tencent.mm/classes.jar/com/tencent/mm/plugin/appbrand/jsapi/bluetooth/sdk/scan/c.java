package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.os.ParcelUuid;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;

final class c
{
  public static final ParcelUuid gnA = ParcelUuid.fromString("0000110E-0000-1000-8000-00805F9B34FB");
  public static final ParcelUuid gnB = ParcelUuid.fromString("0000110C-0000-1000-8000-00805F9B34FB");
  public static final ParcelUuid gnC = ParcelUuid.fromString("00001105-0000-1000-8000-00805f9b34fb");
  public static final ParcelUuid gnD = ParcelUuid.fromString("00001124-0000-1000-8000-00805f9b34fb");
  public static final ParcelUuid gnE = ParcelUuid.fromString("00001812-0000-1000-8000-00805f9b34fb");
  public static final ParcelUuid gnF = ParcelUuid.fromString("00001115-0000-1000-8000-00805F9B34FB");
  public static final ParcelUuid gnG = ParcelUuid.fromString("00001116-0000-1000-8000-00805F9B34FB");
  public static final ParcelUuid gnH = ParcelUuid.fromString("0000000f-0000-1000-8000-00805F9B34FB");
  public static final ParcelUuid gnI = ParcelUuid.fromString("0000112f-0000-1000-8000-00805F9B34FB");
  public static final ParcelUuid gnJ = ParcelUuid.fromString("00001134-0000-1000-8000-00805F9B34FB");
  public static final ParcelUuid gnK = ParcelUuid.fromString("00001133-0000-1000-8000-00805F9B34FB");
  public static final ParcelUuid gnL = ParcelUuid.fromString("00001132-0000-1000-8000-00805F9B34FB");
  public static final ParcelUuid gnM = ParcelUuid.fromString("00000000-0000-1000-8000-00805F9B34FB");
  public static final ParcelUuid[] gnN = { gnt, gnu, gnv, gnw, gny, gnA, gnB, gnC, gnF, gnG, gnJ, gnK, gnL };
  public static final ParcelUuid gnt = ParcelUuid.fromString("0000110B-0000-1000-8000-00805F9B34FB");
  public static final ParcelUuid gnu = ParcelUuid.fromString("0000110A-0000-1000-8000-00805F9B34FB");
  public static final ParcelUuid gnv = ParcelUuid.fromString("0000110D-0000-1000-8000-00805F9B34FB");
  public static final ParcelUuid gnw = ParcelUuid.fromString("00001108-0000-1000-8000-00805F9B34FB");
  public static final ParcelUuid gnx = ParcelUuid.fromString("00001112-0000-1000-8000-00805F9B34FB");
  public static final ParcelUuid gny = ParcelUuid.fromString("0000111E-0000-1000-8000-00805F9B34FB");
  public static final ParcelUuid gnz = ParcelUuid.fromString("0000111F-0000-1000-8000-00805F9B34FB");
  
  public static ParcelUuid N(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("uuidBytes cannot be null");
    }
    int i = paramArrayOfByte.length;
    if ((i != 2) && (i != 4) && (i != 16)) {
      throw new IllegalArgumentException("uuidBytes length invalid - " + i);
    }
    if (i == 16)
    {
      paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.LITTLE_ENDIAN);
      return new ParcelUuid(new UUID(paramArrayOfByte.getLong(8), paramArrayOfByte.getLong(0)));
    }
    if (i == 2) {}
    for (long l = (paramArrayOfByte[0] & 0xFF) + ((paramArrayOfByte[1] & 0xFF) << 8);; l = (paramArrayOfByte[0] & 0xFF) + ((paramArrayOfByte[1] & 0xFF) << 8) + ((paramArrayOfByte[2] & 0xFF) << 16) + ((paramArrayOfByte[3] & 0xFF) << 24)) {
      return new ParcelUuid(new UUID(gnM.getUuid().getMostSignificantBits() + (l << 32), gnM.getUuid().getLeastSignificantBits()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.c
 * JD-Core Version:    0.7.0.1
 */