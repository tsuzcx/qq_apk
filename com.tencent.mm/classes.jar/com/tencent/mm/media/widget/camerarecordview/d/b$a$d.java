package com.tencent.mm.media.widget.camerarecordview.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$PreviewFormatItem;", "", "format", "", "(Ljava/lang/Integer;)V", "getFormat", "()Ljava/lang/Integer;", "setFormat", "Ljava/lang/Integer;", "component1", "copy", "(Ljava/lang/Integer;)Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$PreviewFormatItem;", "equals", "", "other", "hashCode", "toString", "", "plugin-mediaeditor_release"})
public final class b$a$d
{
  public Integer lgp;
  
  private b$a$d(Integer paramInteger)
  {
    this.lgp = paramInteger;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(258860);
    if (this != paramObject)
    {
      if ((paramObject instanceof d))
      {
        paramObject = (d)paramObject;
        if (!p.h(this.lgp, paramObject.lgp)) {}
      }
    }
    else
    {
      AppMethodBeat.o(258860);
      return true;
    }
    AppMethodBeat.o(258860);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(258857);
    Integer localInteger = this.lgp;
    if (localInteger != null)
    {
      int i = localInteger.hashCode();
      AppMethodBeat.o(258857);
      return i;
    }
    AppMethodBeat.o(258857);
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(258854);
    String str = "PreviewFormatItem(format=" + this.lgp + ")";
    AppMethodBeat.o(258854);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.d.b.a.d
 * JD-Core Version:    0.7.0.1
 */