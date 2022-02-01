package com.facebook.share.internal;

import com.facebook.internal.DialogFeature;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum CameraEffectFeature
  implements DialogFeature
{
  private int minVersion;
  
  static
  {
    AppMethodBeat.i(7967);
    SHARE_CAMERA_EFFECT = new CameraEffectFeature("SHARE_CAMERA_EFFECT", 0, 20170417);
    $VALUES = new CameraEffectFeature[] { SHARE_CAMERA_EFFECT };
    AppMethodBeat.o(7967);
  }
  
  private CameraEffectFeature(int paramInt)
  {
    this.minVersion = paramInt;
  }
  
  public final String getAction()
  {
    return "com.facebook.platform.action.request.CAMERA_EFFECT";
  }
  
  public final int getMinVersion()
  {
    return this.minVersion;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.facebook.share.internal.CameraEffectFeature
 * JD-Core Version:    0.7.0.1
 */