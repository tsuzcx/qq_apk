package com.tencent.mm.media.editor.a;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bmw;
import com.tencent.mm.protocal.protobuf.bmx;
import com.tencent.mm.protocal.protobuf.dks;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/editor/item/LyricsItem;", "Lcom/tencent/mm/media/editor/item/BaseEditorData;", "lyricsInfo", "", "Lcom/tencent/mm/protocal/protobuf/LyricsItemInfo;", "matrix", "Landroid/graphics/Matrix;", "(Ljava/util/List;Landroid/graphics/Matrix;)V", "getLyricsInfo", "()Ljava/util/List;", "toProtoBuf", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "plugin-mediaeditor_release"})
public final class l
  extends a
{
  private final List<bmx> gpm;
  
  public l(List<? extends bmx> paramList, Matrix paramMatrix)
  {
    super(e.goK, paramMatrix);
    AppMethodBeat.i(93583);
    this.gpm = paramList;
    AppMethodBeat.o(93583);
  }
  
  public final com.tencent.mm.bx.a ajx()
  {
    AppMethodBeat.i(93582);
    Object localObject = new bmw();
    float[] arrayOfFloat = new float[9];
    dks localdks = new dks();
    this.dY.getValues(arrayOfFloat);
    int i = 0;
    while (i < 9)
    {
      float f = arrayOfFloat[i];
      localdks.DmV.add(Float.valueOf(f));
      i += 1;
    }
    ((bmw)localObject).DKq.addAll((Collection)this.gpm);
    ((bmw)localObject).DKf = localdks;
    localObject = (com.tencent.mm.bx.a)localObject;
    AppMethodBeat.o(93582);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.editor.a.l
 * JD-Core Version:    0.7.0.1
 */