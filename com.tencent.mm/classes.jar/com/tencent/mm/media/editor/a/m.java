package com.tencent.mm.media.editor.a;

import a.l;
import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cjv;
import com.tencent.mm.protocal.protobuf.cqz;
import java.util.LinkedList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/editor/item/TextItem;", "Lcom/tencent/mm/media/editor/item/BaseEditorData;", "text", "", "textColor", "", "textBgColor", "marginBottom", "dataType", "Lcom/tencent/mm/media/editor/item/EditorDataType;", "matrix", "Landroid/graphics/Matrix;", "(Ljava/lang/CharSequence;IIILcom/tencent/mm/media/editor/item/EditorDataType;Landroid/graphics/Matrix;)V", "getMarginBottom", "()I", "getMatrix", "()Landroid/graphics/Matrix;", "setMatrix", "(Landroid/graphics/Matrix;)V", "getText", "()Ljava/lang/CharSequence;", "getTextBgColor", "getTextColor", "toProtoBuf", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "plugin-mediaeditor_release"})
public final class m
  extends a
{
  private Matrix asO;
  private final int eTj;
  private final int eTk;
  public final CharSequence text;
  private final int textColor;
  
  public m(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, e parame, Matrix paramMatrix)
  {
    super(parame);
    AppMethodBeat.i(152089);
    this.text = paramCharSequence;
    this.textColor = paramInt1;
    this.eTj = paramInt2;
    this.eTk = paramInt3;
    this.asO = paramMatrix;
    AppMethodBeat.o(152089);
  }
  
  public final com.tencent.mm.bv.a UF()
  {
    AppMethodBeat.i(12894);
    Object localObject = new cjv();
    float[] arrayOfFloat = new float[9];
    cqz localcqz = new cqz();
    this.asO.getValues(arrayOfFloat);
    int i = 0;
    while (i < 9)
    {
      float f = arrayOfFloat[i];
      localcqz.xZD.add(Float.valueOf(f));
      i += 1;
    }
    ((cjv)localObject).text = String.valueOf(this.text);
    ((cjv)localObject).xpW = localcqz;
    ((cjv)localObject).eTj = this.eTj;
    ((cjv)localObject).textColor = this.textColor;
    localObject = (com.tencent.mm.bv.a)localObject;
    AppMethodBeat.o(12894);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.editor.a.m
 * JD-Core Version:    0.7.0.1
 */