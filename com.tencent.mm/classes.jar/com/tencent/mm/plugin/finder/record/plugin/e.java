package com.tencent.mm.plugin.finder.record.plugin;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/record/plugin/RecorderActionDetector;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "()V", "center", "Lkotlin/Pair;", "", "getCenter", "()Lkotlin/Pair;", "setCenter", "(Lkotlin/Pair;)V", "longPressing", "", "onTouchListener", "Landroid/view/View$OnTouchListener;", "getOnTouchListener", "()Landroid/view/View$OnTouchListener;", "setOnTouchListener", "(Landroid/view/View$OnTouchListener;)V", "raduis", "getRaduis", "()I", "setRaduis", "(I)V", "inRecorderRange", "e", "Landroid/view/MotionEvent;", "makeTouchEvent", "", "touch", "onDown", "onLongPress", "onSingleTapConfirmed", "onTouch", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends GestureDetector.SimpleOnGestureListener
{
  r<Integer, Integer> Fjn;
  boolean Fjo;
  View.OnTouchListener onTouchListener;
  int wED;
  
  public e()
  {
    AppMethodBeat.i(337064);
    this.Fjn = new r(Integer.valueOf(0), Integer.valueOf(0));
    AppMethodBeat.o(337064);
  }
  
  private final void RI(int paramInt)
  {
    AppMethodBeat.i(337071);
    View.OnTouchListener localOnTouchListener = this.onTouchListener;
    if (localOnTouchListener != null)
    {
      MotionEvent localMotionEvent = MotionEvent.obtain(0L, 0L, 0, 0.0F, 0.0F, 0);
      localMotionEvent.setAction(paramInt);
      localOnTouchListener.onTouch(null, localMotionEvent);
    }
    AppMethodBeat.o(337071);
  }
  
  public final boolean onContextClick(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(337118);
    b localb = new b();
    localb.cH(paramMotionEvent);
    a.c("com/tencent/mm/plugin/finder/record/plugin/RecorderActionDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
    boolean bool = super.onContextClick(paramMotionEvent);
    a.a(bool, this, "com/tencent/mm/plugin/finder/record/plugin/RecorderActionDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(337118);
    return bool;
  }
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(337110);
    b localb = new b();
    localb.cH(paramMotionEvent);
    a.c("com/tencent/mm/plugin/finder/record/plugin/RecorderActionDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
    boolean bool = super.onDoubleTap(paramMotionEvent);
    a.a(bool, this, "com/tencent/mm/plugin/finder/record/plugin/RecorderActionDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(337110);
    return bool;
  }
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(337082);
    this.Fjo = false;
    boolean bool = super.onDown(paramMotionEvent);
    AppMethodBeat.o(337082);
    return bool;
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(337087);
    Object localObject = new b();
    ((b)localObject).cH(paramMotionEvent);
    a.c("com/tencent/mm/plugin/finder/record/plugin/RecorderActionDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, ((b)localObject).aYj());
    Log.i("MicroMsg.FinderTemplateListPlugin", s.X("onLongPress() called with: e = ", paramMotionEvent));
    localObject = this.onTouchListener;
    if (localObject != null) {
      ((View.OnTouchListener)localObject).onTouch(null, paramMotionEvent);
    }
    this.Fjo = true;
    a.a(this, "com/tencent/mm/plugin/finder/record/plugin/RecorderActionDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(337087);
  }
  
  public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(337096);
    Log.i("MicroMsg.FinderTemplateListPlugin", s.X("onSingleTapConfirmed() called with: e = ", paramMotionEvent));
    if (paramMotionEvent != null)
    {
      float f = (float)Math.pow(paramMotionEvent.getX() - ((Number)this.Fjn.bsC).floatValue(), 2.0D);
      if ((float)Math.pow((float)Math.pow(paramMotionEvent.getY() - ((Number)this.Fjn.bsD).floatValue(), 2.0D) + f, 0.5D) < this.wED) {}
      for (int i = 1; i != 0; i = 0)
      {
        RI(0);
        RI(1);
        AppMethodBeat.o(337096);
        return true;
      }
    }
    AppMethodBeat.o(337096);
    return false;
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(337104);
    b localb = new b();
    localb.cH(paramMotionEvent);
    a.c("com/tencent/mm/plugin/finder/record/plugin/RecorderActionDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
    boolean bool = super.onSingleTapUp(paramMotionEvent);
    a.a(bool, this, "com/tencent/mm/plugin/finder/record/plugin/RecorderActionDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(337104);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.record.plugin.e
 * JD-Core Version:    0.7.0.1
 */