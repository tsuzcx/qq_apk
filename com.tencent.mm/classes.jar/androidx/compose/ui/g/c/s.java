package androidx.compose.ui.g.c;

import androidx.compose.ui.h.j;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/input/pointer/PointerInputFilter;", "", "()V", "isAttached", "", "isAttached$ui_release", "()Z", "layoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getLayoutCoordinates$ui_release", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setLayoutCoordinates$ui_release", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "()J", "onCancel", "", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class s
{
  public static final int Ue = 8;
  public j ahy;
  
  public abstract void a(i parami, k paramk, long paramLong);
  
  public abstract void onCancel();
  
  public final boolean wp()
  {
    j localj = this.ahy;
    return (localj != null) && (localj.isAttached() == true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.g.c.s
 * JD-Core Version:    0.7.0.1
 */