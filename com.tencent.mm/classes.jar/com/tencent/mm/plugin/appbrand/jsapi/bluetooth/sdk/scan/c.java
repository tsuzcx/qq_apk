package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.os.ParcelUuid;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;

final class c
{
  public static final ParcelUuid klf;
  public static final ParcelUuid klg;
  public static final ParcelUuid klh;
  public static final ParcelUuid kli;
  public static final ParcelUuid klj;
  public static final ParcelUuid klk;
  public static final ParcelUuid kll;
  public static final ParcelUuid klm;
  public static final ParcelUuid kln;
  public static final ParcelUuid klo;
  public static final ParcelUuid klp;
  public static final ParcelUuid klq;
  public static final ParcelUuid klr;
  public static final ParcelUuid kls;
  public static final ParcelUuid klt;
  public static final ParcelUuid klu;
  public static final ParcelUuid klv;
  public static final ParcelUuid klw;
  public static final ParcelUuid klx;
  public static final ParcelUuid kly;
  public static final ParcelUuid[] klz;
  
  static
  {
    AppMethodBeat.i(144620);
    klf = ParcelUuid.fromString("0000110B-0000-1000-8000-00805F9B34FB");
    klg = ParcelUuid.fromString("0000110A-0000-1000-8000-00805F9B34FB");
    klh = ParcelUuid.fromString("0000110D-0000-1000-8000-00805F9B34FB");
    kli = ParcelUuid.fromString("00001108-0000-1000-8000-00805F9B34FB");
    klj = ParcelUuid.fromString("00001112-0000-1000-8000-00805F9B34FB");
    klk = ParcelUuid.fromString("0000111E-0000-1000-8000-00805F9B34FB");
    kll = ParcelUuid.fromString("0000111F-0000-1000-8000-00805F9B34FB");
    klm = ParcelUuid.fromString("0000110E-0000-1000-8000-00805F9B34FB");
    kln = ParcelUuid.fromString("0000110C-0000-1000-8000-00805F9B34FB");
    klo = ParcelUuid.fromString("00001105-0000-1000-8000-00805f9b34fb");
    klp = ParcelUuid.fromString("00001124-0000-1000-8000-00805f9b34fb");
    klq = ParcelUuid.fromString("00001812-0000-1000-8000-00805f9b34fb");
    klr = ParcelUuid.fromString("00001115-0000-1000-8000-00805F9B34FB");
    kls = ParcelUuid.fromString("00001116-0000-1000-8000-00805F9B34FB");
    klt = ParcelUuid.fromString("0000000f-0000-1000-8000-00805F9B34FB");
    klu = ParcelUuid.fromString("0000112f-0000-1000-8000-00805F9B34FB");
    klv = ParcelUuid.fromString("00001134-0000-1000-8000-00805F9B34FB");
    klw = ParcelUuid.fromString("00001133-0000-1000-8000-00805F9B34FB");
    klx = ParcelUuid.fromString("00001132-0000-1000-8000-00805F9B34FB");
    kly = ParcelUuid.fromString("00000000-0000-1000-8000-00805F9B34FB");
    klz = new ParcelUuid[] { klf, klg, klh, kli, klk, klm, kln, klo, klr, kls, klv, klw, klx };
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
      paramArrayOfByte = new ParcelUuid(new UUID(kly.getUuid().getMostSignificantBits() + (l << 32), kly.getUuid().getLeastSignificantBits()));
      AppMethodBeat.o(144619);
      return paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.c
 * JD-Core Version:    0.7.0.1
 */