package com.tencent.mm.media.editor.a;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.brm;
import com.tencent.mm.protocal.protobuf.brn;
import com.tencent.mm.protocal.protobuf.dqj;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/editor/item/LyricsItem;", "Lcom/tencent/mm/media/editor/item/BaseEditorData;", "lyricsInfo", "", "Lcom/tencent/mm/protocal/protobuf/LyricsItemInfo;", "matrix", "Landroid/graphics/Matrix;", "(Ljava/util/List;Landroid/graphics/Matrix;)V", "getLyricsInfo", "()Ljava/util/List;", "toProtoBuf", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "plugin-mediaeditor_release"})
public final class l
  extends a
{
  private final List<brn> gPU;
  
  public l(List<? extends brn> paramList, Matrix paramMatrix)
  {
    super(e.gPs, paramMatrix);
    AppMethodBeat.i(93583);
    this.gPU = paramList;
    AppMethodBeat.o(93583);
  }
  
  public final com.tencent.mm.bw.a aqw()
  {
    AppMethodBeat.i(93582);
    Object localObject = new brm();
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
    ((brm)localObject).FgG.addAll((Collection)this.gPU);
    ((brm)localObject).Fgu = localdqj;
    localObject = (com.tencent.mm.bw.a)localObject;
    AppMethodBeat.o(93582);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.media.editor.a.l
 * JD-Core Version:    0.7.0.1
 */