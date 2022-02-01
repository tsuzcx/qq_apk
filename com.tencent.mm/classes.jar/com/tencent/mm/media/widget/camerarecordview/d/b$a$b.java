package com.tencent.mm.media.widget.camerarecordview.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$FocusConfigItem;", "", "focusPriority", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "getFocusPriority", "()Ljava/util/ArrayList;", "setFocusPriority", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b$a$b
{
  public ArrayList<String> nKU = null;
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(237693);
    if (this == paramObject)
    {
      AppMethodBeat.o(237693);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(237693);
      return false;
    }
    paramObject = (b)paramObject;
    if (!s.p(this.nKU, paramObject.nKU))
    {
      AppMethodBeat.o(237693);
      return false;
    }
    AppMethodBeat.o(237693);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(237687);
    if (this.nKU == null)
    {
      AppMethodBeat.o(237687);
      return 0;
    }
    int i = this.nKU.hashCode();
    AppMethodBeat.o(237687);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(237681);
    String str = "FocusConfigItem(focusPriority=" + this.nKU + ')';
    AppMethodBeat.o(237681);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.d.b.a.b
 * JD-Core Version:    0.7.0.1
 */