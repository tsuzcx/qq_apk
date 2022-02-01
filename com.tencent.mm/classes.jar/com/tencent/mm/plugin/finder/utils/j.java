package com.tencent.mm.plugin.finder.utils;

import android.media.ExifInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import d.v;
import java.util.Collection;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/utils/GeoDegree;", "", "exif", "Landroid/media/ExifInterface;", "(Landroid/media/ExifInterface;)V", "Latitude", "", "getLatitude", "()Ljava/lang/Float;", "setLatitude", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "Longitude", "getLongitude", "setLongitude", "TAG", "", "isValid", "", "()Z", "setValid", "(Z)V", "convertToDegree", "stringDMS", "(Ljava/lang/String;)Ljava/lang/Float;", "toString", "plugin-finder_release"})
public final class j
{
  private final String TAG;
  private boolean cBN;
  public Float qTd;
  public Float qTe;
  
  public j(ExifInterface paramExifInterface)
  {
    AppMethodBeat.i(167973);
    this.TAG = "Finder.GeoDegree";
    Object localObject = paramExifInterface.getAttribute("GPSLatitude");
    String str2 = paramExifInterface.getAttribute("GPSLatitudeRef");
    String str1 = paramExifInterface.getAttribute("GPSLongitude");
    paramExifInterface = paramExifInterface.getAttribute("GPSLongitudeRef");
    if ((localObject != null) && (str2 != null) && (str1 != null) && (paramExifInterface != null))
    {
      this.cBN = true;
      if (d.g.b.k.g(str2, "N")) {}
      for (this.qTd = ZW((String)localObject); d.g.b.k.g(paramExifInterface, "E"); this.qTd = Float.valueOf(0.0F - ((Float)localObject).floatValue()))
      {
        this.qTe = ZW(str1);
        AppMethodBeat.o(167973);
        return;
        localObject = ZW((String)localObject);
        if (localObject == null) {
          d.g.b.k.fvU();
        }
      }
      paramExifInterface = ZW(str1);
      if (paramExifInterface == null) {
        d.g.b.k.fvU();
      }
      this.qTe = Float.valueOf(0.0F - paramExifInterface.floatValue());
    }
    AppMethodBeat.o(167973);
  }
  
  private final Float ZW(String paramString)
  {
    AppMethodBeat.i(167971);
    try
    {
      paramString = (CharSequence)paramString;
      paramString = ((Collection)new d.n.k(",").r(paramString, 3)).toArray(new String[0]);
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(167971);
        throw paramString;
      }
    }
    catch (Throwable paramString)
    {
      ad.printErrStackTrace(this.TAG, paramString, "convertToDegree", new Object[0]);
      AppMethodBeat.o(167971);
      return null;
    }
    paramString = (String[])paramString;
    Object localObject = (CharSequence)paramString[0];
    localObject = ((Collection)new d.n.k("/").r((CharSequence)localObject, 2)).toArray(new String[0]);
    if (localObject == null)
    {
      paramString = new v("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(167971);
      throw paramString;
    }
    localObject = (String[])localObject;
    double d1 = Double.parseDouble(localObject[0]) / Double.parseDouble(localObject[1]);
    localObject = (CharSequence)paramString[1];
    localObject = ((Collection)new d.n.k("/").r((CharSequence)localObject, 2)).toArray(new String[0]);
    if (localObject == null)
    {
      paramString = new v("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(167971);
      throw paramString;
    }
    localObject = (String[])localObject;
    double d3 = Double.parseDouble(localObject[0]) / Double.parseDouble(localObject[1]);
    paramString = (CharSequence)paramString[2];
    paramString = ((Collection)new d.n.k("/").r(paramString, 2)).toArray(new String[0]);
    if (paramString == null)
    {
      paramString = new v("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(167971);
      throw paramString;
    }
    paramString = (String[])paramString;
    double d2 = Double.parseDouble(paramString[0]) / Double.parseDouble(paramString[1]);
    d3 /= 60.0D;
    float f = (float)(d2 / 3600.0D + (d1 + d3));
    AppMethodBeat.o(167971);
    return Float.valueOf(f);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(167972);
    String str = String.valueOf(this.qTd) + ", " + String.valueOf(this.qTe);
    AppMethodBeat.o(167972);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.j
 * JD-Core Version:    0.7.0.1
 */