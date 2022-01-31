package com.tencent.mm.plugin.exdevice.jni;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.model.j;
import com.tencent.mm.plugin.exdevice.service.a;
import com.tencent.mm.plugin.exdevice.service.b;
import com.tencent.mm.sdk.platformtools.ab;

public final class C2JavaExDevice
{
  private static final String TAG = "MicroMsg.exdevice.C2JavaExDevice";
  
  public static void C2Java_onStateChange(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(19072);
    a.b(paramLong, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(19072);
  }
  
  public static void C2Java_onTaskEnd(long paramLong, int paramInt1, int paramInt2, String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(19071);
    a.c(paramLong, paramInt1, paramInt2, paramString);
    AppMethodBeat.o(19071);
  }
  
  public static boolean connect(long paramLong)
  {
    AppMethodBeat.i(19076);
    boolean bool = b.connect(paramLong);
    AppMethodBeat.o(19076);
    return bool;
  }
  
  public static void createSession(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(19074);
    b.createSession(paramLong1, paramLong2);
    AppMethodBeat.o(19074);
  }
  
  public static void destroySession(long paramLong)
  {
    AppMethodBeat.i(19077);
    b.destroySession(paramLong);
    AppMethodBeat.o(19077);
  }
  
  public static void onAirKissCallback(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(19078);
    ab.v("MicroMsg.exdevice.C2JavaExDevice", "onAirKissCallback(errType : %d, errCode : %d)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    j.bpP().h(0, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(19078);
  }
  
  public static void onDeviceRequest(long paramLong, short paramShort1, short paramShort2, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(19073);
    a.onDeviceRequest(paramLong, paramShort1, paramShort2, paramArrayOfByte, paramInt);
    AppMethodBeat.o(19073);
  }
  
  public static void onReceiveWCLanDeviceDiscPackage(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(19079);
    if (paramArrayOfByte == null) {}
    for (int i = 0;; i = paramArrayOfByte.length)
    {
      ab.i("MicroMsg.exdevice.C2JavaExDevice", "onReceiveWCLanDeviceDiscPackage, dataLen(%d).", new Object[] { Integer.valueOf(i) });
      j.bpP().h(10, new Object[] { paramArrayOfByte });
      AppMethodBeat.o(19079);
      return;
    }
  }
  
  public static void onReceiveWCLanDeviceProfile(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(19083);
    if (paramArrayOfByte == null) {}
    for (int i = 0;; i = paramArrayOfByte.length)
    {
      ab.i("MicroMsg.exdevice.C2JavaExDevice", "onReceiveWCLanDeviceProfile, data(%d).", new Object[] { Integer.valueOf(i) });
      j.bpP().h(14, new Object[] { paramArrayOfByte });
      AppMethodBeat.o(19083);
      return;
    }
  }
  
  public static void onWCLanDeviceConnectStateNotify(String paramString, int paramInt)
  {
    AppMethodBeat.i(19082);
    ab.i("MicroMsg.exdevice.C2JavaExDevice", "onWCLanDeviceConnectStateNotify, devclassinfo(%s), stateCode(%d).", new Object[] { paramString, Integer.valueOf(paramInt) });
    j.bpP().h(13, new Object[] { paramString, Integer.valueOf(paramInt) });
    AppMethodBeat.o(19082);
  }
  
  public static void onWCLanDeviceUdpError(int paramInt)
  {
    AppMethodBeat.i(19080);
    ab.i("MicroMsg.exdevice.C2JavaExDevice", "onWCLanDeviceUdpError, errCode(%d).", new Object[] { Integer.valueOf(paramInt) });
    j.bpP().h(11, new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(19080);
  }
  
  public static void onWCLanFileTransferUpdate(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(19084);
    if (paramArrayOfByte == null) {}
    for (int i = 0;; i = paramArrayOfByte.length)
    {
      ab.i("MicroMsg.exdevice.C2JavaExDevice", "onWCLanFileTransferUpdate, cmdId(%d), data(%d).", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      j.bpP().h(15, new Object[] { Integer.valueOf(paramInt), paramArrayOfByte });
      AppMethodBeat.o(19084);
      return;
    }
  }
  
  public static void onWCLanReceiveNotify(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(19085);
    if (paramArrayOfByte == null) {}
    for (int i = 0;; i = paramArrayOfByte.length)
    {
      ab.i("MicroMsg.exdevice.C2JavaExDevice", "onWCLanReceiveNotify, devclassinfo(%s), data(%d).", new Object[] { paramString, Integer.valueOf(i) });
      j.bpP().h(16, new Object[] { paramString, paramArrayOfByte });
      AppMethodBeat.o(19085);
      return;
    }
  }
  
  public static void onWCLanReceiveResponse(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(19081);
    if (paramArrayOfByte == null) {}
    for (int i = 0;; i = paramArrayOfByte.length)
    {
      ab.i("MicroMsg.exdevice.C2JavaExDevice", "onWCLanReceiveResponse, cmdId(%d), data(%d).", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      j.bpP().h(12, new Object[] { Integer.valueOf(paramInt), paramArrayOfByte });
      AppMethodBeat.o(19081);
      return;
    }
  }
  
  public static boolean sendData(long paramLong, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(19075);
    boolean bool = b.sendData(paramLong, paramArrayOfByte);
    AppMethodBeat.o(19075);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.jni.C2JavaExDevice
 * JD-Core Version:    0.7.0.1
 */