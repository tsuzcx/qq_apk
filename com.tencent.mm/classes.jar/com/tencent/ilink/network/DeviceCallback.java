package com.tencent.ilink.network;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class DeviceCallback
{
  public static void OnFinishGetStrategy()
  {
    AppMethodBeat.i(220347);
    if (DeviceInterface.getInstance().getDeviceCallback() != null) {
      DeviceInterface.getInstance().getDeviceCallback().OnFinishGetStrategy();
    }
    AppMethodBeat.o(220347);
  }
  
  public static void OnLonglinkConnected()
  {
    AppMethodBeat.i(220345);
    if (DeviceInterface.getInstance().getDeviceCallback() != null) {
      DeviceInterface.getInstance().getDeviceCallback().OnLonglinkConnected();
    }
    AppMethodBeat.o(220345);
  }
  
  public static void OnLonglinkDisconnected()
  {
    AppMethodBeat.i(220346);
    if (DeviceInterface.getInstance().getDeviceCallback() != null) {
      DeviceInterface.getInstance().getDeviceCallback().OnLonglinkDisconnected();
    }
    AppMethodBeat.o(220346);
  }
  
  public static void OnSessionTimeout()
  {
    AppMethodBeat.i(220344);
    if (DeviceInterface.getInstance().getDeviceCallback() != null) {
      DeviceInterface.getInstance().getDeviceCallback().OnSessionTimeout();
    }
    AppMethodBeat.o(220344);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ilink.network.DeviceCallback
 * JD-Core Version:    0.7.0.1
 */