package com.tencent.mm.media.editor.a;

import a.l;
import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bar;
import com.tencent.mm.protocal.protobuf.cqz;
import java.util.LinkedList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/editor/item/LocationItem;", "Lcom/tencent/mm/media/editor/item/BaseEditorData;", "cityName", "", "poiName", "matrix", "Landroid/graphics/Matrix;", "(Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Matrix;)V", "getCityName", "()Ljava/lang/String;", "setCityName", "(Ljava/lang/String;)V", "getMatrix", "()Landroid/graphics/Matrix;", "setMatrix", "(Landroid/graphics/Matrix;)V", "getPoiName", "setPoiName", "toProtoBuf", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "plugin-mediaeditor_release"})
public final class i
  extends a
{
  private Matrix asO;
  public String eSL;
  public String eSM;
  
  public i(String paramString1, String paramString2, Matrix paramMatrix)
  {
    super(e.eSE);
    AppMethodBeat.i(12892);
    this.eSL = paramString1;
    this.eSM = paramString2;
    this.asO = paramMatrix;
    AppMethodBeat.o(12892);
  }
  
  public final com.tencent.mm.bv.a UF()
  {
    AppMethodBeat.i(12891);
    Object localObject = new bar();
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
    ((bar)localObject).eSL = this.eSL;
    ((bar)localObject).eSM = this.eSM;
    ((bar)localObject).xpW = localcqz;
    localObject = (com.tencent.mm.bv.a)localObject;
    AppMethodBeat.o(12891);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.editor.a.i
 * JD-Core Version:    0.7.0.1
 */