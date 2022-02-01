package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.os.ParcelUuid;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;

final class c
{
  public static final ParcelUuid kGf;
  public static final ParcelUuid kGg;
  public static final ParcelUuid kGh;
  public static final ParcelUuid kGi;
  public static final ParcelUuid kGj;
  public static final ParcelUuid kGk;
  public static final ParcelUuid kGl;
  public static final ParcelUuid kGm;
  public static final ParcelUuid kGn;
  public static final ParcelUuid kGo;
  public static final ParcelUuid kGp;
  public static final ParcelUuid kGq;
  public static final ParcelUuid kGr;
  public static final ParcelUuid kGs;
  public static final ParcelUuid kGt;
  public static final ParcelUuid kGu;
  public static final ParcelUuid kGv;
  public static final ParcelUuid kGw;
  public static final ParcelUuid kGx;
  public static final ParcelUuid kGy;
  public static final ParcelUuid[] kGz;
  
  static
  {
    AppMethodBeat.i(144620);
    kGf = ParcelUuid.fromString("0000110B-0000-1000-8000-00805F9B34FB");
    kGg = ParcelUuid.fromString("0000110A-0000-1000-8000-00805F9B34FB");
    kGh = ParcelUuid.fromString("0000110D-0000-1000-8000-00805F9B34FB");
    kGi = ParcelUuid.fromString("00001108-0000-1000-8000-00805F9B34FB");
    kGj = ParcelUuid.fromString("00001112-0000-1000-8000-00805F9B34FB");
    kGk = ParcelUuid.fromString("0000111E-0000-1000-8000-00805F9B34FB");
    kGl = ParcelUuid.fromString("0000111F-0000-1000-8000-00805F9B34FB");
    kGm = ParcelUuid.fromString("0000110E-0000-1000-8000-00805F9B34FB");
    kGn = ParcelUuid.fromString("0000110C-0000-1000-8000-00805F9B34FB");
    kGo = ParcelUuid.fromString("00001105-0000-1000-8000-00805f9b34fb");
    kGp = ParcelUuid.fromString("00001124-0000-1000-8000-00805f9b34fb");
    kGq = ParcelUuid.fromString("00001812-0000-1000-8000-00805f9b34fb");
    kGr = ParcelUuid.fromString("00001115-0000-1000-8000-00805F9B34FB");
    kGs = ParcelUuid.fromString("00001116-0000-1000-8000-00805F9B34FB");
    kGt = ParcelUuid.fromString("0000000f-0000-1000-8000-00805F9B34FB");
    kGu = ParcelUuid.fromString("0000112f-0000-1000-8000-00805F9B34FB");
    kGv = ParcelUuid.fromString("00001134-0000-1000-8000-00805F9B34FB");
    kGw = ParcelUuid.fromString("00001133-0000-1000-8000-00805F9B34FB");
    kGx = ParcelUuid.fromString("00001132-0000-1000-8000-00805F9B34FB");
    kGy = ParcelUuid.fromString("00000000-0000-1000-8000-00805F9B34FB");
    kGz = new ParcelUuid[] { kGf, kGg, kGh, kGi, kGk, kGm, kGn, kGo, kGr, kGs, kGv, kGw, kGx };
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
      paramArrayOfByte = new ParcelUuid(new UUID(kGy.getUuid().getMostSignificantBits() + (l << 32), kGy.getUuid().getLeastSignificantBits()));
      AppMethodBeat.o(144619);
      return paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.c
 * JD-Core Version:    0.7.0.1
 */