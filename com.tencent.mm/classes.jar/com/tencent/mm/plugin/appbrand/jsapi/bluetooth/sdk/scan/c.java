package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.os.ParcelUuid;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;

final class c
{
  public static final ParcelUuid jKE;
  public static final ParcelUuid jKF;
  public static final ParcelUuid jKG;
  public static final ParcelUuid jKH;
  public static final ParcelUuid jKI;
  public static final ParcelUuid jKJ;
  public static final ParcelUuid jKK;
  public static final ParcelUuid jKL;
  public static final ParcelUuid jKM;
  public static final ParcelUuid jKN;
  public static final ParcelUuid jKO;
  public static final ParcelUuid jKP;
  public static final ParcelUuid jKQ;
  public static final ParcelUuid jKR;
  public static final ParcelUuid jKS;
  public static final ParcelUuid jKT;
  public static final ParcelUuid jKU;
  public static final ParcelUuid jKV;
  public static final ParcelUuid jKW;
  public static final ParcelUuid jKX;
  public static final ParcelUuid[] jKY;
  
  static
  {
    AppMethodBeat.i(144620);
    jKE = ParcelUuid.fromString("0000110B-0000-1000-8000-00805F9B34FB");
    jKF = ParcelUuid.fromString("0000110A-0000-1000-8000-00805F9B34FB");
    jKG = ParcelUuid.fromString("0000110D-0000-1000-8000-00805F9B34FB");
    jKH = ParcelUuid.fromString("00001108-0000-1000-8000-00805F9B34FB");
    jKI = ParcelUuid.fromString("00001112-0000-1000-8000-00805F9B34FB");
    jKJ = ParcelUuid.fromString("0000111E-0000-1000-8000-00805F9B34FB");
    jKK = ParcelUuid.fromString("0000111F-0000-1000-8000-00805F9B34FB");
    jKL = ParcelUuid.fromString("0000110E-0000-1000-8000-00805F9B34FB");
    jKM = ParcelUuid.fromString("0000110C-0000-1000-8000-00805F9B34FB");
    jKN = ParcelUuid.fromString("00001105-0000-1000-8000-00805f9b34fb");
    jKO = ParcelUuid.fromString("00001124-0000-1000-8000-00805f9b34fb");
    jKP = ParcelUuid.fromString("00001812-0000-1000-8000-00805f9b34fb");
    jKQ = ParcelUuid.fromString("00001115-0000-1000-8000-00805F9B34FB");
    jKR = ParcelUuid.fromString("00001116-0000-1000-8000-00805F9B34FB");
    jKS = ParcelUuid.fromString("0000000f-0000-1000-8000-00805F9B34FB");
    jKT = ParcelUuid.fromString("0000112f-0000-1000-8000-00805F9B34FB");
    jKU = ParcelUuid.fromString("00001134-0000-1000-8000-00805F9B34FB");
    jKV = ParcelUuid.fromString("00001133-0000-1000-8000-00805F9B34FB");
    jKW = ParcelUuid.fromString("00001132-0000-1000-8000-00805F9B34FB");
    jKX = ParcelUuid.fromString("00000000-0000-1000-8000-00805F9B34FB");
    jKY = new ParcelUuid[] { jKE, jKF, jKG, jKH, jKJ, jKL, jKM, jKN, jKQ, jKR, jKU, jKV, jKW };
    AppMethodBeat.o(144620);
  }
  
  public static ParcelUuid as(byte[] paramArrayOfByte)
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
      paramArrayOfByte = new ParcelUuid(new UUID(jKX.getUuid().getMostSignificantBits() + (l << 32), jKX.getUuid().getLeastSignificantBits()));
      AppMethodBeat.o(144619);
      return paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.c
 * JD-Core Version:    0.7.0.1
 */