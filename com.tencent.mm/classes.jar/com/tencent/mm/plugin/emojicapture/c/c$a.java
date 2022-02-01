package com.tencent.mm.plugin.emojicapture.c;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.MotionEvent;
import com.tencent.mm.plugin.recordvideo.ui.editor.c.c;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IPresenter;", "", "drawCommon", "", "canvas", "Landroid/graphics/Canvas;", "drawOutside", "getTouchTracker", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "onTouch", "", "event", "Landroid/view/MotionEvent;", "setDrawingSize", "width", "", "height", "setEditing", "editing", "setValidArea", "bounds", "Landroid/graphics/RectF;", "radius", "", "plugin-emojicapture_release"})
public abstract interface c$a
{
  public abstract boolean P(MotionEvent paramMotionEvent);
  
  public abstract void a(RectF paramRectF, float paramFloat);
  
  public abstract void fo(int paramInt1, int paramInt2);
  
  public abstract c getTouchTracker();
  
  public abstract void j(Canvas paramCanvas);
  
  public abstract void k(Canvas paramCanvas);
  
  public abstract void setEditing(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.c.c.a
 * JD-Core Version:    0.7.0.1
 */