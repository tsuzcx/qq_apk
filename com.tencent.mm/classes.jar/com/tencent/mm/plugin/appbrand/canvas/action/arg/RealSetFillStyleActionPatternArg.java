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
import com.tencent.mm.plugin.appbrand.z.g;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class RealSetFillStyleActionPatternArg
  extends RealSetFillStyleActionArg
{
  public static final Parcelable.Creator<RealSetFillStyleActionPatternArg> CREATOR;
  public String jTt;
  public String path;
  
  static
  {
    AppMethodBeat.i(145071);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(145071);
  }
  
  public RealSetFillStyleActionPatternArg() {}
  
  public RealSetFillStyleActionPatternArg(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public final boolean a(d paramd, Canvas paramCanvas)
  {
    AppMethodBeat.i(145064);
    if (bt.isNullOrNil(this.path))
    {
      AppMethodBeat.o(145064);
      return false;
    }
    paramCanvas = paramd.jSZ;
    paramd = paramd.jTe.a(paramd, this.path);
    Object localObject;
    int j;
    int k;
    int i;
    if ((paramd != null) && (!paramd.isRecycled()))
    {
      localObject = this.jTt;
      j = g.vJ(paramd.getWidth());
      k = g.vJ(paramd.getHeight());
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
      AppMethodBeat.o(145064);
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
    AppMethodBeat.i(145065);
    if (this == paramObject)
    {
      AppMethodBeat.o(145065);
      return true;
    }
    if (!(paramObject instanceof RealSetFillStyleActionPatternArg))
    {
      AppMethodBeat.o(145065);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(145065);
      return false;
    }
    paramObject = (RealSetFillStyleActionPatternArg)paramObject;
    if ((Objects.equals(this.path, paramObject.path)) && (Objects.equals(this.jTt, paramObject.jTt)))
    {
      AppMethodBeat.o(145065);
      return true;
    }
    AppMethodBeat.o(145065);
    return false;
  }
  
  public final void f(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(145069);
    super.f(paramJSONArray);
    this.path = paramJSONArray.optString(1);
    this.jTt = paramJSONArray.optString(2);
    AppMethodBeat.o(145069);
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(145067);
    super.h(paramParcel);
    this.path = paramParcel.readString();
    this.jTt = paramParcel.readString();
    AppMethodBeat.o(145067);
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(145066);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), this.path, this.jTt });
    AppMethodBeat.o(145066);
    return i;
  }
  
  public final void parse(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145070);
    super.parse(paramJSONObject);
    AppMethodBeat.o(145070);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(145068);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.path);
    paramParcel.writeString(this.jTt);
    AppMethodBeat.o(145068);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetFillStyleActionPatternArg
 * JD-Core Version:    0.7.0.1
 */