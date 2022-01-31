package com.tencent.mm.plugin.emojicapture.ui.editor;

import a.l;
import android.graphics.RectF;
import com.tencent.mm.media.editor.a.h;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/IEditorItemView;", "Lcom/tencent/mm/media/editor/item/IEditable;", "handleRemove", "", "pause", "", "resume", "setEditing", "editing", "setValidArea", "bounds", "Landroid/graphics/RectF;", "radius", "", "plugin-emojicapture_release"})
public abstract interface a
  extends h
{
  public abstract void a(RectF paramRectF, float paramFloat);
  
  public abstract boolean bpe();
  
  public abstract void pause();
  
  public abstract void resume();
  
  public abstract void setEditing(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.a
 * JD-Core Version:    0.7.0.1
 */