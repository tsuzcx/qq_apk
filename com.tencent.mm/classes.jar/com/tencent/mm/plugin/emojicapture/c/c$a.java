package com.tencent.mm.plugin.emojicapture.c;

import a.l;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.MotionEvent;
import com.tencent.mm.media.editor.c.c;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IPresenter;", "", "drawCommon", "", "canvas", "Landroid/graphics/Canvas;", "drawOutside", "getTouchTracker", "Lcom/tencent/mm/media/editor/touch/TouchTracker;", "onTouch", "", "event", "Landroid/view/MotionEvent;", "setDrawingSize", "width", "", "height", "setEditing", "editing", "setValidArea", "bounds", "Landroid/graphics/RectF;", "radius", "", "plugin-emojicapture_release"})
public abstract interface c$a
{
  public abstract boolean K(MotionEvent paramMotionEvent);
  
  public abstract void a(RectF paramRectF, float paramFloat);
  
  public abstract void ee(int paramInt1, int paramInt2);
  
  public abstract c getTouchTracker();
  
  public abstract void h(Canvas paramCanvas);
  
  public abstract void i(Canvas paramCanvas);
  
  public abstract void setEditing(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.c.c.a
 * JD-Core Version:    0.7.0.1
 */