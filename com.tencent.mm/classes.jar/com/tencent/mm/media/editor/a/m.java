package com.tencent.mm.media.editor.a;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dgz;
import com.tencent.mm.protocal.protobuf.dqj;
import d.l;
import java.util.LinkedList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/editor/item/TextItem;", "Lcom/tencent/mm/media/editor/item/BaseEditorData;", "text", "", "textColor", "", "textBgColor", "marginBottom", "dataType", "Lcom/tencent/mm/media/editor/item/EditorDataType;", "matrix", "Landroid/graphics/Matrix;", "(Ljava/lang/CharSequence;IIILcom/tencent/mm/media/editor/item/EditorDataType;Landroid/graphics/Matrix;)V", "getMarginBottom", "()I", "getText", "()Ljava/lang/CharSequence;", "getTextBgColor", "getTextColor", "toProtoBuf", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "plugin-mediaeditor_release"})
public final class m
  extends a
{
  private final int gPV;
  private final int gPW;
  private final CharSequence text;
  private final int textColor;
  
  public m(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, e parame, Matrix paramMatrix)
  {
    super(parame, paramMatrix);
    AppMethodBeat.i(93586);
    this.text = paramCharSequence;
    this.textColor = paramInt1;
    this.gPV = paramInt2;
    this.gPW = paramInt3;
    AppMethodBeat.o(93586);
  }
  
  public final com.tencent.mm.bw.a aqw()
  {
    AppMethodBeat.i(93585);
    Object localObject = new dgz();
    float[] arrayOfFloat = new float[9];
    dqj localdqj = new dqj();
    this.eY.getValues(arrayOfFloat);
    int i = 0;
    while (i < 9)
    {
      float f = arrayOfFloat[i];
      localdqj.EHU.add(Float.valueOf(f));
      i += 1;
    }
    ((dgz)localObject).text = String.valueOf(this.text);
    ((dgz)localObject).Fgu = localdqj;
    ((dgz)localObject).gPV = this.gPV;
    ((dgz)localObject).textColor = this.textColor;
    localObject = (com.tencent.mm.bw.a)localObject;
    AppMethodBeat.o(93585);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.media.editor.a.m
 * JD-Core Version:    0.7.0.1
 */