package com.tencent.mm.media.widget.camerarecordview.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$PreviewFormatItem;", "", "format", "", "(Ljava/lang/Integer;)V", "getFormat", "()Ljava/lang/Integer;", "setFormat", "Ljava/lang/Integer;", "component1", "copy", "(Ljava/lang/Integer;)Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$PreviewFormatItem;", "equals", "", "other", "hashCode", "toString", "", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b$a$d
{
  public Integer nKZ;
  
  private b$a$d(Integer paramInteger)
  {
    this.nKZ = paramInteger;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(237702);
    if (this == paramObject)
    {
      AppMethodBeat.o(237702);
      return true;
    }
    if (!(paramObject instanceof d))
    {
      AppMethodBeat.o(237702);
      return false;
    }
    paramObject = (d)paramObject;
    if (!s.p(this.nKZ, paramObject.nKZ))
    {
      AppMethodBeat.o(237702);
      return false;
    }
    AppMethodBeat.o(237702);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(237697);
    if (this.nKZ == null)
    {
      AppMethodBeat.o(237697);
      return 0;
    }
    int i = this.nKZ.hashCode();
    AppMethodBeat.o(237697);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(237686);
    String str = "PreviewFormatItem(format=" + this.nKZ + ')';
    AppMethodBeat.o(237686);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.d.b.a.d
 * JD-Core Version:    0.7.0.1
 */