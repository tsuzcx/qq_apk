package com.tencent.mm.media.editor.a;

import android.graphics.Matrix;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/editor/item/BaseEditorData;", "", "dataType", "Lcom/tencent/mm/media/editor/item/EditorDataType;", "matrix", "Landroid/graphics/Matrix;", "(Lcom/tencent/mm/media/editor/item/EditorDataType;Landroid/graphics/Matrix;)V", "getDataType", "()Lcom/tencent/mm/media/editor/item/EditorDataType;", "setDataType", "(Lcom/tencent/mm/media/editor/item/EditorDataType;)V", "getMatrix", "()Landroid/graphics/Matrix;", "toProtoBuf", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "plugin-mediaeditor_release"})
public abstract class a
{
  public final Matrix eY;
  public e gPj;
  
  public a(e parame, Matrix paramMatrix)
  {
    this.gPj = parame;
    this.eY = paramMatrix;
  }
  
  public abstract com.tencent.mm.bw.a aqw();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.media.editor.a.a
 * JD-Core Version:    0.7.0.1
 */