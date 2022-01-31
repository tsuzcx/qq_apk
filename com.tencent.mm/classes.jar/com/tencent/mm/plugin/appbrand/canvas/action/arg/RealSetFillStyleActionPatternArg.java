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
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.canvas.e;
import com.tencent.mm.plugin.appbrand.u.h;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class RealSetFillStyleActionPatternArg
  extends RealSetFillStyleActionArg
{
  public static final Parcelable.Creator<RealSetFillStyleActionPatternArg> CREATOR = new RealSetFillStyleActionPatternArg.1();
  public String fLN;
  public String path;
  
  public RealSetFillStyleActionPatternArg() {}
  
  public RealSetFillStyleActionPatternArg(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public final boolean a(d paramd, Canvas paramCanvas)
  {
    paramCanvas = null;
    if (bk.bl(this.path)) {
      return false;
    }
    a locala = paramd.fLq;
    paramd = paramd.fLv.a(paramd, this.path);
    String str;
    int j;
    int k;
    int i;
    if ((paramd != null) && (!paramd.isRecycled()))
    {
      str = this.fLN;
      j = h.my(paramd.getWidth());
      k = h.my(paramd.getHeight());
      i = -1;
      switch (str.hashCode())
      {
      default: 
        switch (i)
        {
        default: 
          paramd = paramCanvas;
        }
        break;
      }
    }
    for (;;)
    {
      locala.setShader(paramd);
      return true;
      if (!str.equals("repeat")) {
        break;
      }
      i = 0;
      break;
      if (!str.equals("repeat-x")) {
        break;
      }
      i = 1;
      break;
      if (!str.equals("repeat-y")) {
        break;
      }
      i = 2;
      break;
      if (!str.equals("no-repeat")) {
        break;
      }
      i = 3;
      break;
      paramd = new BitmapShader(Bitmap.createScaledBitmap(paramd, j, k, false), Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
      continue;
      paramCanvas = Bitmap.createBitmap(j, k + 1, Bitmap.Config.ARGB_8888);
      new Canvas(paramCanvas).drawBitmap(paramd, new Rect(0, 0, paramd.getWidth(), paramd.getHeight()), new RectF(0.0F, 0.0F, j, k), null);
      paramd = new BitmapShader(paramCanvas, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP);
      continue;
      paramCanvas = Bitmap.createBitmap(j + 1, k, Bitmap.Config.ARGB_8888);
      new Canvas(paramCanvas).drawBitmap(paramd, new Rect(0, 0, paramd.getWidth(), paramd.getHeight()), new RectF(0.0F, 0.0F, j, k), null);
      paramd = new BitmapShader(paramCanvas, Shader.TileMode.CLAMP, Shader.TileMode.REPEAT);
      continue;
      paramCanvas = Bitmap.createBitmap(j + 1, k + 1, Bitmap.Config.ARGB_8888);
      new Canvas(paramCanvas).drawBitmap(paramd, new Rect(0, 0, paramd.getWidth(), paramd.getHeight()), new RectF(0.0F, 0.0F, j, k), null);
      paramd = new BitmapShader(paramCanvas, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void e(JSONArray paramJSONArray)
  {
    super.e(paramJSONArray);
    this.path = paramJSONArray.optString(1);
    this.fLN = paramJSONArray.optString(2);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof RealSetFillStyleActionPatternArg)) {
        return false;
      }
      if (!super.equals(paramObject)) {
        return false;
      }
      paramObject = (RealSetFillStyleActionPatternArg)paramObject;
    } while ((Objects.equals(this.path, paramObject.path)) && (Objects.equals(this.fLN, paramObject.fLN)));
    return false;
  }
  
  public final void f(Parcel paramParcel)
  {
    super.f(paramParcel);
    this.path = paramParcel.readString();
    this.fLN = paramParcel.readString();
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), this.path, this.fLN });
  }
  
  public final void j(JSONObject paramJSONObject)
  {
    super.j(paramJSONObject);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.path);
    paramParcel.writeString(this.fLN);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetFillStyleActionPatternArg
 * JD-Core Version:    0.7.0.1
 */