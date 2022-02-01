package com.tencent.mm.plugin.appbrand.widget.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/widget/halfscreen/HalfScreenDragStatus;", "", "(Ljava/lang/String;I)V", "DRAG_STATE_IDLE", "DRAG_STATE_DRAGGING", "plugin-appbrand-integration_release"})
public enum d
{
  static
  {
    AppMethodBeat.i(267331);
    d locald1 = new d("DRAG_STATE_IDLE", 0);
    rsX = locald1;
    d locald2 = new d("DRAG_STATE_DRAGGING", 1);
    rsY = locald2;
    rsZ = new d[] { locald1, locald2 };
    AppMethodBeat.o(267331);
  }
  
  private d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.c.d
 * JD-Core Version:    0.7.0.1
 */