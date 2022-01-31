package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.os.ParcelUuid;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;

final class c
{
  public static final ParcelUuid hHA;
  public static final ParcelUuid hHB;
  public static final ParcelUuid hHC;
  public static final ParcelUuid hHD;
  public static final ParcelUuid hHE;
  public static final ParcelUuid hHF;
  public static final ParcelUuid hHG;
  public static final ParcelUuid hHH;
  public static final ParcelUuid hHI;
  public static final ParcelUuid hHJ;
  public static final ParcelUuid hHK;
  public static final ParcelUuid[] hHL;
  public static final ParcelUuid hHr;
  public static final ParcelUuid hHs;
  public static final ParcelUuid hHt;
  public static final ParcelUuid hHu;
  public static final ParcelUuid hHv;
  public static final ParcelUuid hHw;
  public static final ParcelUuid hHx;
  public static final ParcelUuid hHy;
  public static final ParcelUuid hHz;
  
  static
  {
    AppMethodBeat.i(94308);
    hHr = ParcelUuid.fromString("0000110B-0000-1000-8000-00805F9B34FB");
    hHs = ParcelUuid.fromString("0000110A-0000-1000-8000-00805F9B34FB");
    hHt = ParcelUuid.fromString("0000110D-0000-1000-8000-00805F9B34FB");
    hHu = ParcelUuid.fromString("00001108-0000-1000-8000-00805F9B34FB");
    hHv = ParcelUuid.fromString("00001112-0000-1000-8000-00805F9B34FB");
    hHw = ParcelUuid.fromString("0000111E-0000-1000-8000-00805F9B34FB");
    hHx = ParcelUuid.fromString("0000111F-0000-1000-8000-00805F9B34FB");
    hHy = ParcelUuid.fromString("0000110E-0000-1000-8000-00805F9B34FB");
    hHz = ParcelUuid.fromString("0000110C-0000-1000-8000-00805F9B34FB");
    hHA = ParcelUuid.fromString("00001105-0000-1000-8000-00805f9b34fb");
    hHB = ParcelUuid.fromString("00001124-0000-1000-8000-00805f9b34fb");
    hHC = ParcelUuid.fromString("00001812-0000-1000-8000-00805f9b34fb");
    hHD = ParcelUuid.fromString("00001115-0000-1000-8000-00805F9B34FB");
    hHE = ParcelUuid.fromString("00001116-0000-1000-8000-00805F9B34FB");
    hHF = ParcelUuid.fromString("0000000f-0000-1000-8000-00805F9B34FB");
    hHG = ParcelUuid.fromString("0000112f-0000-1000-8000-00805F9B34FB");
    hHH = ParcelUuid.fromString("00001134-0000-1000-8000-00805F9B34FB");
    hHI = ParcelUuid.fromString("00001133-0000-1000-8000-00805F9B34FB");
    hHJ = ParcelUuid.fromString("00001132-0000-1000-8000-00805F9B34FB");
    hHK = ParcelUuid.fromString("00000000-0000-1000-8000-00805F9B34FB");
    hHL = new ParcelUuid[] { hHr, hHs, hHt, hHu, hHw, hHy, hHz, hHA, hHD, hHE, hHH, hHI, hHJ };
    AppMethodBeat.o(94308);
  }
  
  public static ParcelUuid ah(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(94307);
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = new IllegalArgumentException("uuidBytes cannot be null");
      AppMethodBeat.o(94307);
      throw paramArrayOfByte;
    }
    int i = paramArrayOfByte.length;
    if ((i != 2) && (i != 4) && (i != 16))
    {
      paramArrayOfByte = new IllegalArgumentException("uuidBytes length invalid - ".concat(String.valueOf(i)));
      AppMethodBeat.o(94307);
      throw paramArrayOfByte;
    }
    if (i == 16)
    {
      paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.LITTLE_ENDIAN);
      paramArrayOfByte = new ParcelUuid(new UUID(paramArrayOfByte.getLong(8), paramArrayOfByte.getLong(0)));
      AppMethodBeat.o(94307);
      return paramArrayOfByte;
    }
    if (i == 2) {}
    for (long l = (paramArrayOfByte[0] & 0xFF) + ((paramArrayOfByte[1] & 0xFF) << 8);; l = (paramArrayOfByte[0] & 0xFF) + ((paramArrayOfByte[1] & 0xFF) << 8) + ((paramArrayOfByte[2] & 0xFF) << 16) + ((paramArrayOfByte[3] & 0xFF) << 24))
    {
      paramArrayOfByte = new ParcelUuid(new UUID(hHK.getUuid().getMostSignificantBits() + (l << 32), hHK.getUuid().getLeastSignificantBits()));
      AppMethodBeat.o(94307);
      return paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.c
 * JD-Core Version:    0.7.0.1
 */