package com.tencent.mm.plugin.exdevice.jni;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;

public final class Java2CExDevice
{
  static
  {
    AppMethodBeat.i(19086);
    k.a("wechataccessory", Java2CExDevice.class.getClassLoader());
    onCreate();
    initBluetoothAccessoryLib();
    AppMethodBeat.o(19086);
  }
  
  public static native void cancelWCLanDeviceTask(int paramInt);
  
  public static native void closeBluetoothAccessoryLib();
  
  public static native int connectWCLanDevice(byte[] paramArrayOfByte, boolean paramBoolean);
  
  public static native int createChannel(long paramLong, Java2CExDevice.LongWrapper paramLongWrapper);
  
  public static native void destroyChannel(long paramLong);
  
  public static native int disconnectWCLanDevice(byte[] paramArrayOfByte);
  
  public static native int getWCLanDeviceService(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  public static native void initBluetoothAccessoryLib();
  
  public static native void initWCLanDeviceLib();
  
  public static native void onBluetoothConnected(long paramLong);
  
  public static native void onBluetoothDisconnected(long paramLong);
  
  public static native void onBluetoothError(long paramLong, int paramInt);
  
  public static native void onBluetoothRecvData(long paramLong, byte[] paramArrayOfByte);
  
  public static native void onBluetoothSendDataCompleted(long paramLong);
  
  public static native void onBluetoothSessionCreated(long paramLong1, long paramLong2, long paramLong3);
  
  public static native void onCreate();
  
  public static native int readFileDataFromWCLanDevice(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  public static native void releaseWCLanDeviceLib();
  
  public static native int sendFileToWCLanDevice(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3);
  
  public static native void setChannelSessionKey(long paramLong, byte[] paramArrayOfByte);
  
  public static native int startAirKiss(String paramString1, String paramString2, byte[] paramArrayOfByte, long paramLong);
  
  public static native int startAirKissWithInter(String paramString1, String paramString2, byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2);
  
  public static native int startChannelService(long paramLong);
  
  public static native void startScanWCLanDevice(byte[] paramArrayOfByte, int paramInt);
  
  public static native int startTask(long paramLong, short paramShort, Java2CExDevice.AccessoryCmd paramAccessoryCmd, byte[] paramArrayOfByte);
  
  public static native void stopAirKiss();
  
  public static native void stopChannelService(long paramLong);
  
  public static native void stopScanWCLanDevice();
  
  public static native void stopTask(long paramLong);
  
  public static native int useWCLanDeviceService(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  public static native int writeFileDataToWCLanDevice(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.jni.Java2CExDevice
 * JD-Core Version:    0.7.0.1
 */