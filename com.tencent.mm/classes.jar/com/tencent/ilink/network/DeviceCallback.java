package com.tencent.ilink.network;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class DeviceCallback
{
  public static void OnFinishGetStrategy()
  {
    AppMethodBeat.i(188643);
    if (DeviceInterface.getInstance().getDeviceCallback() != null) {
      DeviceInterface.getInstance().getDeviceCallback().OnFinishGetStrategy();
    }
    AppMethodBeat.o(188643);
  }
  
  public static void OnLonglinkConnected()
  {
    AppMethodBeat.i(188641);
    if (DeviceInterface.getInstance().getDeviceCallback() != null) {
      DeviceInterface.getInstance().getDeviceCallback().OnLonglinkConnected();
    }
    AppMethodBeat.o(188641);
  }
  
  public static void OnLonglinkDisconnected()
  {
    AppMethodBeat.i(188642);
    if (DeviceInterface.getInstance().getDeviceCallback() != null) {
      DeviceInterface.getInstance().getDeviceCallback().OnLonglinkDisconnected();
    }
    AppMethodBeat.o(188642);
  }
  
  public static void OnSessionTimeout()
  {
    AppMethodBeat.i(188640);
    if (DeviceInterface.getInstance().getDeviceCallback() != null) {
      DeviceInterface.getInstance().getDeviceCallback().OnSessionTimeout();
    }
    AppMethodBeat.o(188640);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ilink.network.DeviceCallback
 * JD-Core Version:    0.7.0.1
 */