package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.os.ParcelUuid;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;

final class c
{
  public static final ParcelUuid lNZ;
  public static final ParcelUuid lOa;
  public static final ParcelUuid lOb;
  public static final ParcelUuid lOc;
  public static final ParcelUuid lOd;
  public static final ParcelUuid lOe;
  public static final ParcelUuid lOf;
  public static final ParcelUuid lOg;
  public static final ParcelUuid lOh;
  public static final ParcelUuid lOi;
  public static final ParcelUuid lOj;
  public static final ParcelUuid lOk;
  public static final ParcelUuid lOl;
  public static final ParcelUuid lOm;
  public static final ParcelUuid lOn;
  public static final ParcelUuid lOo;
  public static final ParcelUuid lOp;
  public static final ParcelUuid lOq;
  public static final ParcelUuid lOr;
  public static final ParcelUuid lOs;
  public static final ParcelUuid[] lOt;
  
  static
  {
    AppMethodBeat.i(144620);
    lNZ = ParcelUuid.fromString("0000110B-0000-1000-8000-00805F9B34FB");
    lOa = ParcelUuid.fromString("0000110A-0000-1000-8000-00805F9B34FB");
    lOb = ParcelUuid.fromString("0000110D-0000-1000-8000-00805F9B34FB");
    lOc = ParcelUuid.fromString("00001108-0000-1000-8000-00805F9B34FB");
    lOd = ParcelUuid.fromString("00001112-0000-1000-8000-00805F9B34FB");
    lOe = ParcelUuid.fromString("0000111E-0000-1000-8000-00805F9B34FB");
    lOf = ParcelUuid.fromString("0000111F-0000-1000-8000-00805F9B34FB");
    lOg = ParcelUuid.fromString("0000110E-0000-1000-8000-00805F9B34FB");
    lOh = ParcelUuid.fromString("0000110C-0000-1000-8000-00805F9B34FB");
    lOi = ParcelUuid.fromString("00001105-0000-1000-8000-00805f9b34fb");
    lOj = ParcelUuid.fromString("00001124-0000-1000-8000-00805f9b34fb");
    lOk = ParcelUuid.fromString("00001812-0000-1000-8000-00805f9b34fb");
    lOl = ParcelUuid.fromString("00001115-0000-1000-8000-00805F9B34FB");
    lOm = ParcelUuid.fromString("00001116-0000-1000-8000-00805F9B34FB");
    lOn = ParcelUuid.fromString("0000000f-0000-1000-8000-00805F9B34FB");
    lOo = ParcelUuid.fromString("0000112f-0000-1000-8000-00805F9B34FB");
    lOp = ParcelUuid.fromString("00001134-0000-1000-8000-00805F9B34FB");
    lOq = ParcelUuid.fromString("00001133-0000-1000-8000-00805F9B34FB");
    lOr = ParcelUuid.fromString("00001132-0000-1000-8000-00805F9B34FB");
    lOs = ParcelUuid.fromString("00000000-0000-1000-8000-00805F9B34FB");
    lOt = new ParcelUuid[] { lNZ, lOa, lOb, lOc, lOe, lOg, lOh, lOi, lOl, lOm, lOp, lOq, lOr };
    AppMethodBeat.o(144620);
  }
  
  public static ParcelUuid aI(byte[] paramArrayOfByte)
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
      paramArrayOfByte = new ParcelUuid(new UUID(lOs.getUuid().getMostSignificantBits() + (l << 32), lOs.getUuid().getLeastSignificantBits()));
      AppMethodBeat.o(144619);
      return paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.c
 * JD-Core Version:    0.7.0.1
 */