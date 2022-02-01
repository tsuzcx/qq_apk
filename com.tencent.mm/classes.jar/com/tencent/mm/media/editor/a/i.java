package com.tencent.mm.media.editor.a;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.brf;
import com.tencent.mm.protocal.protobuf.dqj;
import d.l;
import java.util.LinkedList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/editor/item/LocationItem;", "Lcom/tencent/mm/media/editor/item/BaseEditorData;", "cityName", "", "poiName", "longitude", "", "latitude", "matrix", "Landroid/graphics/Matrix;", "(Ljava/lang/String;Ljava/lang/String;FFLandroid/graphics/Matrix;)V", "getCityName", "()Ljava/lang/String;", "setCityName", "(Ljava/lang/String;)V", "getLatitude", "()F", "setLatitude", "(F)V", "getLongitude", "setLongitude", "getPoiName", "setPoiName", "toProtoBuf", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "plugin-mediaeditor_release"})
public final class i
  extends a
{
  public float dmL;
  public float doB;
  public String gPx;
  public String gPy;
  
  public i(String paramString1, String paramString2, float paramFloat1, float paramFloat2, Matrix paramMatrix)
  {
    super(e.gPq, paramMatrix);
    AppMethodBeat.i(93576);
    this.gPx = paramString1;
    this.gPy = paramString2;
    this.doB = paramFloat1;
    this.dmL = paramFloat2;
    AppMethodBeat.o(93576);
  }
  
  public final com.tencent.mm.bw.a aqw()
  {
    AppMethodBeat.i(93575);
    Object localObject = new brf();
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
    ((brf)localObject).gPx = this.gPx;
    ((brf)localObject).gPy = this.gPy;
    ((brf)localObject).Fgu = localdqj;
    ((brf)localObject).doB = this.doB;
    ((brf)localObject).dmL = this.dmL;
    localObject = (com.tencent.mm.bw.a)localObject;
    AppMethodBeat.o(93575);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.media.editor.a.i
 * JD-Core Version:    0.7.0.1
 */