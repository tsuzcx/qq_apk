package com.tencent.mm.plugin.emojicapture.ui.editor;

import android.graphics.RectF;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.h;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/IEditorItemView;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditable;", "handleRemove", "", "pause", "", "resume", "setEditing", "editing", "setValidArea", "bounds", "Landroid/graphics/RectF;", "radius", "", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface a
  extends h
{
  public abstract void a(RectF paramRectF, float paramFloat);
  
  public abstract boolean dEQ();
  
  public abstract void pause();
  
  public abstract void resume();
  
  public abstract void setEditing(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.a
 * JD-Core Version:    0.7.0.1
 */