package com.tencent.ilink.network;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class DeviceCallback
{
  public static void OnFinishGetStrategy()
  {
    AppMethodBeat.i(213946);
    if (DeviceInterface.getInstance().getDeviceCallback() != null) {
      DeviceInterface.getInstance().getDeviceCallback().OnFinishGetStrategy();
    }
    AppMethodBeat.o(213946);
  }
  
  public static void OnLonglinkConnected()
  {
    AppMethodBeat.i(213932);
    if (DeviceInterface.getInstance().getDeviceCallback() != null) {
      DeviceInterface.getInstance().getDeviceCallback().OnLonglinkConnected();
    }
    AppMethodBeat.o(213932);
  }
  
  public static void OnLonglinkDisconnected()
  {
    AppMethodBeat.i(213941);
    if (DeviceInterface.getInstance().getDeviceCallback() != null) {
      DeviceInterface.getInstance().getDeviceCallback().OnLonglinkDisconnected();
    }
    AppMethodBeat.o(213941);
  }
  
  public static void OnSessionTimeout()
  {
    AppMethodBeat.i(213921);
    if (DeviceInterface.getInstance().getDeviceCallback() != null) {
      DeviceInterface.getInstance().getDeviceCallback().OnSessionTimeout();
    }
    AppMethodBeat.o(213921);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.ilink.network.DeviceCallback
 * JD-Core Version:    0.7.0.1
 */