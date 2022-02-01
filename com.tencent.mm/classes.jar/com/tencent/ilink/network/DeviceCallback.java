package com.tencent.ilink.network;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class DeviceCallback
{
  public static void OnFinishGetStrategy()
  {
    AppMethodBeat.i(217200);
    if (DeviceInterface.getInstance().getDeviceCallback() != null) {
      DeviceInterface.getInstance().getDeviceCallback().OnFinishGetStrategy();
    }
    AppMethodBeat.o(217200);
  }
  
  public static void OnLonglinkConnected()
  {
    AppMethodBeat.i(217197);
    if (DeviceInterface.getInstance().getDeviceCallback() != null) {
      DeviceInterface.getInstance().getDeviceCallback().OnLonglinkConnected();
    }
    AppMethodBeat.o(217197);
  }
  
  public static void OnLonglinkDisconnected()
  {
    AppMethodBeat.i(217198);
    if (DeviceInterface.getInstance().getDeviceCallback() != null) {
      DeviceInterface.getInstance().getDeviceCallback().OnLonglinkDisconnected();
    }
    AppMethodBeat.o(217198);
  }
  
  public static void OnSessionTimeout()
  {
    AppMethodBeat.i(217194);
    if (DeviceInterface.getInstance().getDeviceCallback() != null) {
      DeviceInterface.getInstance().getDeviceCallback().OnSessionTimeout();
    }
    AppMethodBeat.o(217194);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.ilink.network.DeviceCallback
 * JD-Core Version:    0.7.0.1
 */