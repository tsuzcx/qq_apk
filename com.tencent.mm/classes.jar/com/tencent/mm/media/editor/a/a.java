package com.tencent.mm.media.editor.a;

import android.graphics.Matrix;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/editor/item/BaseEditorData;", "", "dataType", "Lcom/tencent/mm/media/editor/item/EditorDataType;", "matrix", "Landroid/graphics/Matrix;", "(Lcom/tencent/mm/media/editor/item/EditorDataType;Landroid/graphics/Matrix;)V", "getDataType", "()Lcom/tencent/mm/media/editor/item/EditorDataType;", "setDataType", "(Lcom/tencent/mm/media/editor/item/EditorDataType;)V", "getMatrix", "()Landroid/graphics/Matrix;", "toProtoBuf", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "plugin-mediaeditor_release"})
public abstract class a
{
  public final Matrix dY;
  public e goB;
  
  public a(e parame, Matrix paramMatrix)
  {
    this.goB = parame;
    this.dY = paramMatrix;
  }
  
  public abstract com.tencent.mm.bx.a ajx();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.editor.a.a
 * JD-Core Version:    0.7.0.1
 */