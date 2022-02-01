package com.tencent.mm.plugin.emojicapture.ui.editor;

import android.graphics.RectF;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.g;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/IEditorItemView;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditable;", "handleRemove", "", "pause", "", "resume", "setEditing", "editing", "setValidArea", "bounds", "Landroid/graphics/RectF;", "radius", "", "plugin-emojicapture_release"})
public abstract interface a
  extends g
{
  public abstract void a(RectF paramRectF, float paramFloat);
  
  public abstract boolean clN();
  
  public abstract void pause();
  
  public abstract void resume();
  
  public abstract void setEditing(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.a
 * JD-Core Version:    0.7.0.1
 */