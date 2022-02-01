package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.os.ParcelUuid;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;

final class d
{
  public static final ParcelUuid oKA;
  public static final ParcelUuid oKB;
  public static final ParcelUuid oKC;
  public static final ParcelUuid oKD;
  public static final ParcelUuid oKE;
  public static final ParcelUuid oKF;
  public static final ParcelUuid oKG;
  public static final ParcelUuid oKH;
  public static final ParcelUuid oKI;
  public static final ParcelUuid oKJ;
  public static final ParcelUuid oKK;
  public static final ParcelUuid oKL;
  public static final ParcelUuid[] oKM;
  public static final ParcelUuid oKs;
  public static final ParcelUuid oKt;
  public static final ParcelUuid oKu;
  public static final ParcelUuid oKv;
  public static final ParcelUuid oKw;
  public static final ParcelUuid oKx;
  public static final ParcelUuid oKy;
  public static final ParcelUuid oKz;
  
  static
  {
    AppMethodBeat.i(144620);
    oKs = ParcelUuid.fromString("0000110B-0000-1000-8000-00805F9B34FB");
    oKt = ParcelUuid.fromString("0000110A-0000-1000-8000-00805F9B34FB");
    oKu = ParcelUuid.fromString("0000110D-0000-1000-8000-00805F9B34FB");
    oKv = ParcelUuid.fromString("00001108-0000-1000-8000-00805F9B34FB");
    oKw = ParcelUuid.fromString("00001112-0000-1000-8000-00805F9B34FB");
    oKx = ParcelUuid.fromString("0000111E-0000-1000-8000-00805F9B34FB");
    oKy = ParcelUuid.fromString("0000111F-0000-1000-8000-00805F9B34FB");
    oKz = ParcelUuid.fromString("0000110E-0000-1000-8000-00805F9B34FB");
    oKA = ParcelUuid.fromString("0000110C-0000-1000-8000-00805F9B34FB");
    oKB = ParcelUuid.fromString("00001105-0000-1000-8000-00805f9b34fb");
    oKC = ParcelUuid.fromString("00001124-0000-1000-8000-00805f9b34fb");
    oKD = ParcelUuid.fromString("00001812-0000-1000-8000-00805f9b34fb");
    oKE = ParcelUuid.fromString("00001115-0000-1000-8000-00805F9B34FB");
    oKF = ParcelUuid.fromString("00001116-0000-1000-8000-00805F9B34FB");
    oKG = ParcelUuid.fromString("0000000f-0000-1000-8000-00805F9B34FB");
    oKH = ParcelUuid.fromString("0000112f-0000-1000-8000-00805F9B34FB");
    oKI = ParcelUuid.fromString("00001134-0000-1000-8000-00805F9B34FB");
    oKJ = ParcelUuid.fromString("00001133-0000-1000-8000-00805F9B34FB");
    oKK = ParcelUuid.fromString("00001132-0000-1000-8000-00805F9B34FB");
    oKL = ParcelUuid.fromString("00000000-0000-1000-8000-00805F9B34FB");
    oKM = new ParcelUuid[] { oKs, oKt, oKu, oKv, oKx, oKz, oKA, oKB, oKE, oKF, oKI, oKJ, oKK };
    AppMethodBeat.o(144620);
  }
  
  public static ParcelUuid aU(byte[] paramArrayOfByte)
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
      paramArrayOfByte = new ParcelUuid(new UUID(oKL.getUuid().getMostSignificantBits() + (l << 32), oKL.getUuid().getLeastSignificantBits()));
      AppMethodBeat.o(144619);
      return paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.d
 * JD-Core Version:    0.7.0.1
 */