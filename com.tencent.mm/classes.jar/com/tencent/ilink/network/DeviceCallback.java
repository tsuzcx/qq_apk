package com.tencent.ilink.network;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class DeviceCallback
{
  public static void OnFinishGetStrategy()
  {
    AppMethodBeat.i(187954);
    if (DeviceInterface.getInstance().getDeviceCallback() != null) {
      DeviceInterface.getInstance().getDeviceCallback().OnFinishGetStrategy();
    }
    AppMethodBeat.o(187954);
  }
  
  public static void OnLonglinkConnected()
  {
    AppMethodBeat.i(187952);
    if (DeviceInterface.getInstance().getDeviceCallback() != null) {
      DeviceInterface.getInstance().getDeviceCallback().OnLonglinkConnected();
    }
    AppMethodBeat.o(187952);
  }
  
  public static void OnLonglinkDisconnected()
  {
    AppMethodBeat.i(187953);
    if (DeviceInterface.getInstance().getDeviceCallback() != null) {
      DeviceInterface.getInstance().getDeviceCallback().OnLonglinkDisconnected();
    }
    AppMethodBeat.o(187953);
  }
  
  public static void OnSessionTimeout()
  {
    AppMethodBeat.i(187951);
    if (DeviceInterface.getInstance().getDeviceCallback() != null) {
      DeviceInterface.getInstance().getDeviceCallback().OnSessionTimeout();
    }
    AppMethodBeat.o(187951);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.ilink.network.DeviceCallback
 * JD-Core Version:    0.7.0.1
 */