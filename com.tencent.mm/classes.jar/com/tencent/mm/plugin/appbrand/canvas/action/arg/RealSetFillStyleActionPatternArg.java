package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.canvas.e;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class RealSetFillStyleActionPatternArg
  extends RealSetFillStyleActionArg
{
  public static final Parcelable.Creator<RealSetFillStyleActionPatternArg> CREATOR;
  public String heX;
  public String path;
  
  static
  {
    AppMethodBeat.i(103388);
    CREATOR = new RealSetFillStyleActionPatternArg.1();
    AppMethodBeat.o(103388);
  }
  
  public RealSetFillStyleActionPatternArg() {}
  
  public RealSetFillStyleActionPatternArg(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public final boolean a(d paramd, Canvas paramCanvas)
  {
    AppMethodBeat.i(103381);
    if (bo.isNullOrNil(this.path))
    {
      AppMethodBeat.o(103381);
      return false;
    }
    paramCanvas = paramd.heC;
    paramd = paramd.heH.a(paramd, this.path);
    Object localObject;
    int j;
    int k;
    int i;
    if ((paramd != null) && (!paramd.isRecycled()))
    {
      localObject = this.heX;
      j = g.pO(paramd.getWidth());
      k = g.pO(paramd.getHeight());
      i = -1;
      switch (((String)localObject).hashCode())
      {
      default: 
        switch (i)
        {
        default: 
          paramd = null;
        }
        break;
      }
    }
    for (;;)
    {
      paramCanvas.setShader(paramd);
      AppMethodBeat.o(103381);
      return true;
      if (!((String)localObject).equals("repeat")) {
        break;
      }
      i = 0;
      break;
      if (!((String)localObject).equals("repeat-x")) {
        break;
      }
      i = 1;
      break;
      if (!((String)localObject).equals("repeat-y")) {
        break;
      }
      i = 2;
      break;
      if (!((String)localObject).equals("no-repeat")) {
        break;
      }
      i = 3;
      break;
      paramd = Bitmap.createScaledBitmap(paramd, j, k, false);
      localObject = Shader.TileMode.REPEAT;
      paramd = new BitmapShader(paramd, (Shader.TileMode)localObject, (Shader.TileMode)localObject);
      continue;
      localObject = Bitmap.createBitmap(j, k + 1, Bitmap.Config.ARGB_8888);
      new Canvas((Bitmap)localObject).drawBitmap(paramd, new Rect(0, 0, paramd.getWidth(), paramd.getHeight()), new RectF(0.0F, 0.0F, j, k), null);
      paramd = new BitmapShader((Bitmap)localObject, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP);
      continue;
      localObject = Bitmap.createBitmap(j + 1, k, Bitmap.Config.ARGB_8888);
      new Canvas((Bitmap)localObject).drawBitmap(paramd, new Rect(0, 0, paramd.getWidth(), paramd.getHeight()), new RectF(0.0F, 0.0F, j, k), null);
      paramd = new BitmapShader((Bitmap)localObject, Shader.TileMode.CLAMP, Shader.TileMode.REPEAT);
      continue;
      localObject = Bitmap.createBitmap(j + 1, k + 1, Bitmap.Config.ARGB_8888);
      new Canvas((Bitmap)localObject).drawBitmap(paramd, new Rect(0, 0, paramd.getWidth(), paramd.getHeight()), new RectF(0.0F, 0.0F, j, k), null);
      paramd = Shader.TileMode.CLAMP;
      paramd = new BitmapShader((Bitmap)localObject, paramd, paramd);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(103382);
    if (this == paramObject)
    {
      AppMethodBeat.o(103382);
      return true;
    }
    if (!(paramObject instanceof RealSetFillStyleActionPatternArg))
    {
      AppMethodBeat.o(103382);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(103382);
      return false;
    }
    paramObject = (RealSetFillStyleActionPatternArg)paramObject;
    if ((Objects.equals(this.path, paramObject.path)) && (Objects.equals(this.heX, paramObject.heX)))
    {
      AppMethodBeat.o(103382);
      return true;
    }
    AppMethodBeat.o(103382);
    return false;
  }
  
  public final void f(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(103386);
    super.f(paramJSONArray);
    this.path = paramJSONArray.optString(1);
    this.heX = paramJSONArray.optString(2);
    AppMethodBeat.o(103386);
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(103384);
    super.h(paramParcel);
    this.path = paramParcel.readString();
    this.heX = paramParcel.readString();
    AppMethodBeat.o(103384);
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(103383);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), this.path, this.heX });
    AppMethodBeat.o(103383);
    return i;
  }
  
  public final void p(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(103387);
    super.p(paramJSONObject);
    AppMethodBeat.o(103387);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(103385);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.path);
    paramParcel.writeString(this.heX);
    AppMethodBeat.o(103385);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetFillStyleActionPatternArg
 * JD-Core Version:    0.7.0.1
 */