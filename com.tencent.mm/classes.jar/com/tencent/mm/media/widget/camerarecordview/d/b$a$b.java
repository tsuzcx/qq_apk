package com.tencent.mm.media.widget.camerarecordview.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$FocusConfigItem;", "", "focusPriority", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "getFocusPriority", "()Ljava/util/ArrayList;", "setFocusPriority", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-mediaeditor_release"})
public final class b$a$b
{
  public ArrayList<String> lgk = null;
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(258122);
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if (!p.h(this.lgk, paramObject.lgk)) {}
      }
    }
    else
    {
      AppMethodBeat.o(258122);
      return true;
    }
    AppMethodBeat.o(258122);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(258121);
    ArrayList localArrayList = this.lgk;
    if (localArrayList != null)
    {
      int i = localArrayList.hashCode();
      AppMethodBeat.o(258121);
      return i;
    }
    AppMethodBeat.o(258121);
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(258119);
    String str = "FocusConfigItem(focusPriority=" + this.lgk + ")";
    AppMethodBeat.o(258119);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.d.b.a.b
 * JD-Core Version:    0.7.0.1
 */