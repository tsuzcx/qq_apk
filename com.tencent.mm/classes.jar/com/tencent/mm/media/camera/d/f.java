package com.tencent.mm.media.camera.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/camera/model/CameraKitSetting;", "", "uiSetting", "Lcom/tencent/mm/media/camera/model/CameraKitUiSetting;", "commonSetting", "Lcom/tencent/mm/media/camera/model/CameraKitCommonSetting;", "(Lcom/tencent/mm/media/camera/model/CameraKitUiSetting;Lcom/tencent/mm/media/camera/model/CameraKitCommonSetting;)V", "getCommonSetting", "()Lcom/tencent/mm/media/camera/model/CameraKitCommonSetting;", "getUiSetting", "()Lcom/tencent/mm/media/camera/model/CameraKitUiSetting;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "setPictureInfo", "toString", "", "plugin-camera_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public final g nvH;
  public final b nvI;
  
  public f(g paramg)
  {
    this.nvH = paramg;
    this.nvI = null;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(237134);
    if (this == paramObject)
    {
      AppMethodBeat.o(237134);
      return true;
    }
    if (!(paramObject instanceof f))
    {
      AppMethodBeat.o(237134);
      return false;
    }
    paramObject = (f)paramObject;
    if (!s.p(this.nvH, paramObject.nvH))
    {
      AppMethodBeat.o(237134);
      return false;
    }
    if (!s.p(this.nvI, paramObject.nvI))
    {
      AppMethodBeat.o(237134);
      return false;
    }
    AppMethodBeat.o(237134);
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(237128);
    int i;
    if (this.nvH == null)
    {
      i = 0;
      if (this.nvI != null) {
        break label46;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(237128);
      return i * 31 + j;
      i = this.nvH.hashCode();
      break;
      label46:
      j = this.nvI.hashCode();
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(237121);
    String str = "CameraKitSetting(uiSetting=" + this.nvH + ", commonSetting=" + this.nvI + ')';
    AppMethodBeat.o(237121);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.media.camera.d.f
 * JD-Core Version:    0.7.0.1
 */