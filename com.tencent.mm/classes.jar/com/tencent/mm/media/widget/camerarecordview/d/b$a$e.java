package com.tencent.mm.media.widget.camerarecordview.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$SizeConfigItem;", "", "width", "", "height", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getHeight", "()Ljava/lang/Integer;", "setHeight", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getWidth", "setWidth", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$SizeConfigItem;", "equals", "", "other", "hashCode", "toString", "", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b$a$e
{
  public Integer nLa;
  public Integer nLb;
  
  private b$a$e(Integer paramInteger1, Integer paramInteger2)
  {
    this.nLa = paramInteger1;
    this.nLb = paramInteger2;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(237690);
    if (this == paramObject)
    {
      AppMethodBeat.o(237690);
      return true;
    }
    if (!(paramObject instanceof e))
    {
      AppMethodBeat.o(237690);
      return false;
    }
    paramObject = (e)paramObject;
    if (!s.p(this.nLa, paramObject.nLa))
    {
      AppMethodBeat.o(237690);
      return false;
    }
    if (!s.p(this.nLb, paramObject.nLb))
    {
      AppMethodBeat.o(237690);
      return false;
    }
    AppMethodBeat.o(237690);
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(237682);
    int i;
    if (this.nLa == null)
    {
      i = 0;
      if (this.nLb != null) {
        break label46;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(237682);
      return i * 31 + j;
      i = this.nLa.hashCode();
      break;
      label46:
      j = this.nLb.hashCode();
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(237677);
    String str = "SizeConfigItem(width=" + this.nLa + ", height=" + this.nLb + ')';
    AppMethodBeat.o(237677);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.d.b.a.e
 * JD-Core Version:    0.7.0.1
 */