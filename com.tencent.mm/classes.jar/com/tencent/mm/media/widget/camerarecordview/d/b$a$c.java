package com.tencent.mm.media.widget.camerarecordview.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$FpsConfigItem;", "", "lowerFps", "", "upperFps", "curFps", "useFixMode", "", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getCurFps", "()Ljava/lang/Integer;", "setCurFps", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getLowerFps", "setLowerFps", "getUpperFps", "setUpperFps", "getUseFixMode", "()Ljava/lang/Boolean;", "setUseFixMode", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$FpsConfigItem;", "equals", "other", "hashCode", "toString", "", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b$a$c
{
  public Integer nKV;
  public Integer nKW;
  public Integer nKX;
  public Boolean nKY;
  
  private b$a$c(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3)
  {
    this.nKV = paramInteger1;
    this.nKW = paramInteger2;
    this.nKX = paramInteger3;
    this.nKY = null;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(237700);
    if (this == paramObject)
    {
      AppMethodBeat.o(237700);
      return true;
    }
    if (!(paramObject instanceof c))
    {
      AppMethodBeat.o(237700);
      return false;
    }
    paramObject = (c)paramObject;
    if (!s.p(this.nKV, paramObject.nKV))
    {
      AppMethodBeat.o(237700);
      return false;
    }
    if (!s.p(this.nKW, paramObject.nKW))
    {
      AppMethodBeat.o(237700);
      return false;
    }
    if (!s.p(this.nKX, paramObject.nKX))
    {
      AppMethodBeat.o(237700);
      return false;
    }
    if (!s.p(this.nKY, paramObject.nKY))
    {
      AppMethodBeat.o(237700);
      return false;
    }
    AppMethodBeat.o(237700);
    return true;
  }
  
  public final int hashCode()
  {
    int m = 0;
    AppMethodBeat.i(237698);
    int i;
    int j;
    label26:
    int k;
    if (this.nKV == null)
    {
      i = 0;
      if (this.nKW != null) {
        break label76;
      }
      j = 0;
      if (this.nKX != null) {
        break label87;
      }
      k = 0;
      label35:
      if (this.nKY != null) {
        break label98;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(237698);
      return (k + (j + i * 31) * 31) * 31 + m;
      i = this.nKV.hashCode();
      break;
      label76:
      j = this.nKW.hashCode();
      break label26;
      label87:
      k = this.nKX.hashCode();
      break label35;
      label98:
      m = this.nKY.hashCode();
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(237691);
    String str = "FpsConfigItem(lowerFps=" + this.nKV + ", upperFps=" + this.nKW + ", curFps=" + this.nKX + ", useFixMode=" + this.nKY + ')';
    AppMethodBeat.o(237691);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.d.b.a.c
 * JD-Core Version:    0.7.0.1
 */