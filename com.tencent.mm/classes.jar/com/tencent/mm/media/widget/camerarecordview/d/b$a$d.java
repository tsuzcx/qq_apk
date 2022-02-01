package com.tencent.mm.media.widget.camerarecordview.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$PreviewFormatItem;", "", "format", "", "(Ljava/lang/Integer;)V", "getFormat", "()Ljava/lang/Integer;", "setFormat", "Ljava/lang/Integer;", "component1", "copy", "(Ljava/lang/Integer;)Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$PreviewFormatItem;", "equals", "", "other", "hashCode", "toString", "", "plugin-mediaeditor_release"})
public final class b$a$d
{
  public Integer irk;
  
  private b$a$d(Integer paramInteger)
  {
    this.irk = paramInteger;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(218903);
    if (this != paramObject)
    {
      if ((paramObject instanceof d))
      {
        paramObject = (d)paramObject;
        if (!p.j(this.irk, paramObject.irk)) {}
      }
    }
    else
    {
      AppMethodBeat.o(218903);
      return true;
    }
    AppMethodBeat.o(218903);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(218902);
    Integer localInteger = this.irk;
    if (localInteger != null)
    {
      int i = localInteger.hashCode();
      AppMethodBeat.o(218902);
      return i;
    }
    AppMethodBeat.o(218902);
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(218901);
    String str = "PreviewFormatItem(format=" + this.irk + ")";
    AppMethodBeat.o(218901);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.d.b.a.d
 * JD-Core Version:    0.7.0.1
 */