package com.tencent.mm.plugin.exdevice.jni;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.model.j;
import com.tencent.mm.plugin.exdevice.service.a;
import com.tencent.mm.plugin.exdevice.service.b;
import com.tencent.mm.sdk.platformtools.ac;

public final class C2JavaExDevice
{
  private static final String TAG = "MicroMsg.exdevice.C2JavaExDevice";
  
  public static void C2Java_onStateChange(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(23180);
    a.a(paramLong, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(23180);
  }
  
  public static void C2Java_onTaskEnd(long paramLong, int paramInt1, int paramInt2, String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23179);
    a.c(paramLong, paramInt1, paramInt2, paramString);
    AppMethodBeat.o(23179);
  }
  
  public static boolean connect(long paramLong)
  {
    AppMethodBeat.i(23184);
    boolean bool = b.connect(paramLong);
    AppMethodBeat.o(23184);
    return bool;
  }
  
  public static void createSession(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(23182);
    b.createSession(paramLong1, paramLong2);
    AppMethodBeat.o(23182);
  }
  
  public static void destroySession(long paramLong)
  {
    AppMethodBeat.i(23185);
    b.destroySession(paramLong);
    AppMethodBeat.o(23185);
  }
  
  public static void onAirKissCallback(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(23186);
    ac.v("MicroMsg.exdevice.C2JavaExDevice", "onAirKissCallback(errType : %d, errCode : %d)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    j.cgG().h(0, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(23186);
  }
  
  public static void onDeviceRequest(long paramLong, short paramShort1, short paramShort2, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(23181);
    a.onDeviceRequest(paramLong, paramShort1, paramShort2, paramArrayOfByte, paramInt);
    AppMethodBeat.o(23181);
  }
  
  public static void onReceiveWCLanDeviceDiscPackage(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23187);
    if (paramArrayOfByte == null) {}
    for (int i = 0;; i = paramArrayOfByte.length)
    {
      ac.i("MicroMsg.exdevice.C2JavaExDevice", "onReceiveWCLanDeviceDiscPackage, dataLen(%d).", new Object[] { Integer.valueOf(i) });
      j.cgG().h(10, new Object[] { paramArrayOfByte });
      AppMethodBeat.o(23187);
      return;
    }
  }
  
  public static void onReceiveWCLanDeviceProfile(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23191);
    if (paramArrayOfByte == null) {}
    for (int i = 0;; i = paramArrayOfByte.length)
    {
      ac.i("MicroMsg.exdevice.C2JavaExDevice", "onReceiveWCLanDeviceProfile, data(%d).", new Object[] { Integer.valueOf(i) });
      j.cgG().h(14, new Object[] { paramArrayOfByte });
      AppMethodBeat.o(23191);
      return;
    }
  }
  
  public static void onWCLanDeviceConnectStateNotify(String paramString, int paramInt)
  {
    AppMethodBeat.i(23190);
    ac.i("MicroMsg.exdevice.C2JavaExDevice", "onWCLanDeviceConnectStateNotify, devclassinfo(%s), stateCode(%d).", new Object[] { paramString, Integer.valueOf(paramInt) });
    j.cgG().h(13, new Object[] { paramString, Integer.valueOf(paramInt) });
    AppMethodBeat.o(23190);
  }
  
  public static void onWCLanDeviceUdpError(int paramInt)
  {
    AppMethodBeat.i(23188);
    ac.i("MicroMsg.exdevice.C2JavaExDevice", "onWCLanDeviceUdpError, errCode(%d).", new Object[] { Integer.valueOf(paramInt) });
    j.cgG().h(11, new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(23188);
  }
  
  public static void onWCLanFileTransferUpdate(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23192);
    if (paramArrayOfByte == null) {}
    for (int i = 0;; i = paramArrayOfByte.length)
    {
      ac.i("MicroMsg.exdevice.C2JavaExDevice", "onWCLanFileTransferUpdate, cmdId(%d), data(%d).", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      j.cgG().h(15, new Object[] { Integer.valueOf(paramInt), paramArrayOfByte });
      AppMethodBeat.o(23192);
      return;
    }
  }
  
  public static void onWCLanReceiveNotify(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23193);
    if (paramArrayOfByte == null) {}
    for (int i = 0;; i = paramArrayOfByte.length)
    {
      ac.i("MicroMsg.exdevice.C2JavaExDevice", "onWCLanReceiveNotify, devclassinfo(%s), data(%d).", new Object[] { paramString, Integer.valueOf(i) });
      j.cgG().h(16, new Object[] { paramString, paramArrayOfByte });
      AppMethodBeat.o(23193);
      return;
    }
  }
  
  public static void onWCLanReceiveResponse(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23189);
    if (paramArrayOfByte == null) {}
    for (int i = 0;; i = paramArrayOfByte.length)
    {
      ac.i("MicroMsg.exdevice.C2JavaExDevice", "onWCLanReceiveResponse, cmdId(%d), data(%d).", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      j.cgG().h(12, new Object[] { Integer.valueOf(paramInt), paramArrayOfByte });
      AppMethodBeat.o(23189);
      return;
    }
  }
  
  public static boolean sendData(long paramLong, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23183);
    boolean bool = b.sendData(paramLong, paramArrayOfByte);
    AppMethodBeat.o(23183);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.jni.C2JavaExDevice
 * JD-Core Version:    0.7.0.1
 */