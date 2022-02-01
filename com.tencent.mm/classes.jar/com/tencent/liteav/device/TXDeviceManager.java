package com.tencent.liteav.device;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface TXDeviceManager
{
  public abstract int enableCameraAutoFocus(boolean paramBoolean);
  
  public abstract boolean enableCameraTorch(boolean paramBoolean);
  
  public abstract float getCameraZoomMaxRatio();
  
  public abstract boolean isAutoFocusEnabled();
  
  public abstract boolean isFrontCamera();
  
  public abstract int setAudioRoute(TXAudioRoute paramTXAudioRoute);
  
  public abstract int setCameraFocusPosition(int paramInt1, int paramInt2);
  
  public abstract int setCameraZoomRatio(float paramFloat);
  
  public abstract int setSystemVolumeType(TXSystemVolumeType paramTXSystemVolumeType);
  
  public abstract int switchCamera(boolean paramBoolean);
  
  public static enum TXAudioRoute
  {
    static
    {
      AppMethodBeat.i(245730);
      TXAudioRouteSpeakerphone = new TXAudioRoute("TXAudioRouteSpeakerphone", 0);
      TXAudioRouteEarpiece = new TXAudioRoute("TXAudioRouteEarpiece", 1);
      $VALUES = new TXAudioRoute[] { TXAudioRouteSpeakerphone, TXAudioRouteEarpiece };
      AppMethodBeat.o(245730);
    }
    
    private TXAudioRoute() {}
  }
  
  public static enum TXSystemVolumeType
  {
    static
    {
      AppMethodBeat.i(245587);
      TXSystemVolumeTypeAuto = new TXSystemVolumeType("TXSystemVolumeTypeAuto", 0);
      TXSystemVolumeTypeMedia = new TXSystemVolumeType("TXSystemVolumeTypeMedia", 1);
      TXSystemVolumeTypeVOIP = new TXSystemVolumeType("TXSystemVolumeTypeVOIP", 2);
      $VALUES = new TXSystemVolumeType[] { TXSystemVolumeTypeAuto, TXSystemVolumeTypeMedia, TXSystemVolumeTypeVOIP };
      AppMethodBeat.o(245587);
    }
    
    private TXSystemVolumeType() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.device.TXDeviceManager
 * JD-Core Version:    0.7.0.1
 */