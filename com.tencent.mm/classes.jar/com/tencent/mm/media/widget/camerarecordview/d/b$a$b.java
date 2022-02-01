package com.tencent.mm.media.widget.camerarecordview.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$FocusConfigItem;", "", "focusPriority", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "getFocusPriority", "()Ljava/util/ArrayList;", "setFocusPriority", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-mediaeditor_release"})
public final class b$a$b
{
  public ArrayList<String> irf = null;
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(218895);
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if (!p.j(this.irf, paramObject.irf)) {}
      }
    }
    else
    {
      AppMethodBeat.o(218895);
      return true;
    }
    AppMethodBeat.o(218895);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(218894);
    ArrayList localArrayList = this.irf;
    if (localArrayList != null)
    {
      int i = localArrayList.hashCode();
      AppMethodBeat.o(218894);
      return i;
    }
    AppMethodBeat.o(218894);
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(218893);
    String str = "FocusConfigItem(focusPriority=" + this.irf + ")";
    AppMethodBeat.o(218893);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.d.b.a.b
 * JD-Core Version:    0.7.0.1
 */