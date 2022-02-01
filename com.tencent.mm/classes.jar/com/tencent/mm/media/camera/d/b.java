package com.tencent.mm.media.camera.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/camera/model/CameraKitCommonSetting;", "", "version", "", "cameraFrameRate", "pictureSetting", "Lcom/tencent/mm/media/camera/model/CameraKitPictureSetting;", "renderSetting", "Lcom/tencent/mm/media/camera/model/CameraKitRenderSetting;", "(IILcom/tencent/mm/media/camera/model/CameraKitPictureSetting;Lcom/tencent/mm/media/camera/model/CameraKitRenderSetting;)V", "getCameraFrameRate", "()I", "setCameraFrameRate", "(I)V", "getPictureSetting", "()Lcom/tencent/mm/media/camera/model/CameraKitPictureSetting;", "setPictureSetting", "(Lcom/tencent/mm/media/camera/model/CameraKitPictureSetting;)V", "getRenderSetting", "()Lcom/tencent/mm/media/camera/model/CameraKitRenderSetting;", "setRenderSetting", "(Lcom/tencent/mm/media/camera/model/CameraKitRenderSetting;)V", "getVersion", "setVersion", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-camera_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public int nvw = 30;
  private d nvx = null;
  public e nvy = null;
  private int version = 1;
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(237117);
    if (this == paramObject)
    {
      AppMethodBeat.o(237117);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(237117);
      return false;
    }
    paramObject = (b)paramObject;
    if (this.version != paramObject.version)
    {
      AppMethodBeat.o(237117);
      return false;
    }
    if (this.nvw != paramObject.nvw)
    {
      AppMethodBeat.o(237117);
      return false;
    }
    if (!s.p(this.nvx, paramObject.nvx))
    {
      AppMethodBeat.o(237117);
      return false;
    }
    if (!s.p(this.nvy, paramObject.nvy))
    {
      AppMethodBeat.o(237117);
      return false;
    }
    AppMethodBeat.o(237117);
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(237109);
    int k = this.version;
    int m = this.nvw;
    int i;
    if (this.nvx == null)
    {
      i = 0;
      if (this.nvy != null) {
        break label68;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(237109);
      return (i + (k * 31 + m) * 31) * 31 + j;
      i = this.nvx.hashCode();
      break;
      label68:
      j = this.nvy.hashCode();
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(237105);
    String str = "CameraKitCommonSetting(version=" + this.version + ", cameraFrameRate=" + this.nvw + ", pictureSetting=" + this.nvx + ", renderSetting=" + this.nvy + ')';
    AppMethodBeat.o(237105);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.media.camera.d.b
 * JD-Core Version:    0.7.0.1
 */