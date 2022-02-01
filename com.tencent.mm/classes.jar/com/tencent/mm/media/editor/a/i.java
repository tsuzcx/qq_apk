package com.tencent.mm.media.editor.a;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bmp;
import com.tencent.mm.protocal.protobuf.dks;
import d.l;
import java.util.LinkedList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/editor/item/LocationItem;", "Lcom/tencent/mm/media/editor/item/BaseEditorData;", "cityName", "", "poiName", "longitude", "", "latitude", "matrix", "Landroid/graphics/Matrix;", "(Ljava/lang/String;Ljava/lang/String;FFLandroid/graphics/Matrix;)V", "getCityName", "()Ljava/lang/String;", "setCityName", "(Ljava/lang/String;)V", "getLatitude", "()F", "setLatitude", "(F)V", "getLongitude", "setLongitude", "getPoiName", "setPoiName", "toProtoBuf", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "plugin-mediaeditor_release"})
public final class i
  extends a
{
  public float dpb;
  public float dqQ;
  public String goP;
  public String goQ;
  
  public i(String paramString1, String paramString2, float paramFloat1, float paramFloat2, Matrix paramMatrix)
  {
    super(e.goI, paramMatrix);
    AppMethodBeat.i(93576);
    this.goP = paramString1;
    this.goQ = paramString2;
    this.dqQ = paramFloat1;
    this.dpb = paramFloat2;
    AppMethodBeat.o(93576);
  }
  
  public final com.tencent.mm.bx.a ajx()
  {
    AppMethodBeat.i(93575);
    Object localObject = new bmp();
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
    ((bmp)localObject).goP = this.goP;
    ((bmp)localObject).goQ = this.goQ;
    ((bmp)localObject).DKf = localdks;
    ((bmp)localObject).dqQ = this.dqQ;
    ((bmp)localObject).dpb = this.dpb;
    localObject = (com.tencent.mm.bx.a)localObject;
    AppMethodBeat.o(93575);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.editor.a.i
 * JD-Core Version:    0.7.0.1
 */