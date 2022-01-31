package com.tencent.mm.media.editor.a;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bay;
import com.tencent.mm.protocal.protobuf.baz;
import com.tencent.mm.protocal.protobuf.cqz;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/editor/item/LyricsItem;", "Lcom/tencent/mm/media/editor/item/BaseEditorData;", "lyricsInfo", "", "Lcom/tencent/mm/protocal/protobuf/LyricsItemInfo;", "matrix", "Landroid/graphics/Matrix;", "(Ljava/util/List;Landroid/graphics/Matrix;)V", "getLyricsInfo", "()Ljava/util/List;", "getMatrix", "()Landroid/graphics/Matrix;", "setMatrix", "(Landroid/graphics/Matrix;)V", "toProtoBuf", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "plugin-mediaeditor_release"})
public final class l
  extends a
{
  private Matrix asO;
  private final List<baz> eTi;
  
  public l(List<? extends baz> paramList, Matrix paramMatrix)
  {
    super(e.eSG);
    AppMethodBeat.i(152087);
    this.eTi = paramList;
    this.asO = paramMatrix;
    AppMethodBeat.o(152087);
  }
  
  public final com.tencent.mm.bv.a UF()
  {
    AppMethodBeat.i(152086);
    Object localObject = new bay();
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
    ((bay)localObject).xqh.addAll((Collection)this.eTi);
    ((bay)localObject).xpW = localcqz;
    localObject = (com.tencent.mm.bv.a)localObject;
    AppMethodBeat.o(152086);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.media.editor.a.l
 * JD-Core Version:    0.7.0.1
 */