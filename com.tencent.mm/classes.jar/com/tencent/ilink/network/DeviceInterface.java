package com.tencent.ilink.network;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class DeviceInterface
{
  private static final String TAG = "DeviceInterface";
  private static DeviceInterface instance;
  public DeviceCallbackInterface deviceCallback;
  
  public static native void SetLonglinkIplist(byte[] paramArrayOfByte);
  
  public static native void SetProxyInfo(byte[] paramArrayOfByte);
  
  public static native void SetShortlinkIplist(byte[] paramArrayOfByte);
  
  public static native void Start(byte[] paramArrayOfByte);
  
  public static native void Stop();
  
  public static DeviceInterface getInstance()
  {
    AppMethodBeat.i(213926);
    if (instance == null) {
      instance = new DeviceInterface();
    }
    DeviceInterface localDeviceInterface = instance;
    AppMethodBeat.o(213926);
    return localDeviceInterface;
  }
  
  public static native boolean isAlreadyGetStrategy();
  
  public DeviceCallbackInterface getDeviceCallback()
  {
    return this.deviceCallback;
  }
  
  public void setDeviceCallback(DeviceCallbackInterface paramDeviceCallbackInterface)
  {
    this.deviceCallback = paramDeviceCallbackInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.ilink.network.DeviceInterface
 * JD-Core Version:    0.7.0.1
 */