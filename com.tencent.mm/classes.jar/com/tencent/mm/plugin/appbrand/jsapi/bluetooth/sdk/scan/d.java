package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.os.ParcelUuid;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;

final class d
{
  public static final ParcelUuid rOA;
  public static final ParcelUuid rOB;
  public static final ParcelUuid rOC;
  public static final ParcelUuid rOD;
  public static final ParcelUuid rOE;
  public static final ParcelUuid[] rOF;
  public static final ParcelUuid rOl;
  public static final ParcelUuid rOm;
  public static final ParcelUuid rOn;
  public static final ParcelUuid rOo;
  public static final ParcelUuid rOp;
  public static final ParcelUuid rOq;
  public static final ParcelUuid rOr;
  public static final ParcelUuid rOs;
  public static final ParcelUuid rOt;
  public static final ParcelUuid rOu;
  public static final ParcelUuid rOv;
  public static final ParcelUuid rOw;
  public static final ParcelUuid rOx;
  public static final ParcelUuid rOy;
  public static final ParcelUuid rOz;
  
  static
  {
    AppMethodBeat.i(144620);
    rOl = ParcelUuid.fromString("0000110B-0000-1000-8000-00805F9B34FB");
    rOm = ParcelUuid.fromString("0000110A-0000-1000-8000-00805F9B34FB");
    rOn = ParcelUuid.fromString("0000110D-0000-1000-8000-00805F9B34FB");
    rOo = ParcelUuid.fromString("00001108-0000-1000-8000-00805F9B34FB");
    rOp = ParcelUuid.fromString("00001112-0000-1000-8000-00805F9B34FB");
    rOq = ParcelUuid.fromString("0000111E-0000-1000-8000-00805F9B34FB");
    rOr = ParcelUuid.fromString("0000111F-0000-1000-8000-00805F9B34FB");
    rOs = ParcelUuid.fromString("0000110E-0000-1000-8000-00805F9B34FB");
    rOt = ParcelUuid.fromString("0000110C-0000-1000-8000-00805F9B34FB");
    rOu = ParcelUuid.fromString("00001105-0000-1000-8000-00805f9b34fb");
    rOv = ParcelUuid.fromString("00001124-0000-1000-8000-00805f9b34fb");
    rOw = ParcelUuid.fromString("00001812-0000-1000-8000-00805f9b34fb");
    rOx = ParcelUuid.fromString("00001115-0000-1000-8000-00805F9B34FB");
    rOy = ParcelUuid.fromString("00001116-0000-1000-8000-00805F9B34FB");
    rOz = ParcelUuid.fromString("0000000f-0000-1000-8000-00805F9B34FB");
    rOA = ParcelUuid.fromString("0000112f-0000-1000-8000-00805F9B34FB");
    rOB = ParcelUuid.fromString("00001134-0000-1000-8000-00805F9B34FB");
    rOC = ParcelUuid.fromString("00001133-0000-1000-8000-00805F9B34FB");
    rOD = ParcelUuid.fromString("00001132-0000-1000-8000-00805F9B34FB");
    rOE = ParcelUuid.fromString("00000000-0000-1000-8000-00805F9B34FB");
    rOF = new ParcelUuid[] { rOl, rOm, rOn, rOo, rOq, rOs, rOt, rOu, rOx, rOy, rOB, rOC, rOD };
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
      paramArrayOfByte = new ParcelUuid(new UUID(rOE.getUuid().getMostSignificantBits() + (l << 32), rOE.getUuid().getLeastSignificantBits()));
      AppMethodBeat.o(144619);
      return paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.d
 * JD-Core Version:    0.7.0.1
 */