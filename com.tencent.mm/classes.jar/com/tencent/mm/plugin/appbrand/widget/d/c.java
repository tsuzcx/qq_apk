package com.tencent.mm.plugin.appbrand.widget.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/halfscreen/HalfScreenDragStatus;", "", "(Ljava/lang/String;I)V", "DRAG_STATE_IDLE", "DRAG_STATE_DRAGGING", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum c
{
  static
  {
    AppMethodBeat.i(324301);
    uDA = new c("DRAG_STATE_IDLE", 0);
    uDB = new c("DRAG_STATE_DRAGGING", 1);
    uDC = new c[] { uDA, uDB };
    AppMethodBeat.o(324301);
  }
  
  private c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.d.c
 * JD-Core Version:    0.7.0.1
 */