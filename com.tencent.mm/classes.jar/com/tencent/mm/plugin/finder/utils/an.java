package com.tencent.mm.plugin.finder.utils;

import android.media.ExifInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.k;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/GeoDegree;", "", "exif", "Landroid/media/ExifInterface;", "(Landroid/media/ExifInterface;)V", "Latitude", "", "getLatitude", "()Ljava/lang/Float;", "setLatitude", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "Longitude", "getLongitude", "setLongitude", "TAG", "", "isValid", "", "()Z", "setValid", "(Z)V", "convertToDegree", "stringDMS", "(Ljava/lang/String;)Ljava/lang/Float;", "toString", "plugin-finder_release"})
public final class an
{
  Float AGS;
  Float AGT;
  private final String TAG;
  private boolean cSY;
  
  public an(ExifInterface paramExifInterface)
  {
    AppMethodBeat.i(167973);
    this.TAG = "Finder.GeoDegree";
    Object localObject = paramExifInterface.getAttribute("GPSLatitude");
    String str2 = paramExifInterface.getAttribute("GPSLatitudeRef");
    String str1 = paramExifInterface.getAttribute("GPSLongitude");
    paramExifInterface = paramExifInterface.getAttribute("GPSLongitudeRef");
    if ((localObject != null) && (str2 != null) && (str1 != null) && (paramExifInterface != null))
    {
      this.cSY = true;
      if (p.h(str2, "N")) {}
      for (this.AGS = aFZ((String)localObject); p.h(paramExifInterface, "E"); this.AGS = Float.valueOf(0.0F - ((Float)localObject).floatValue()))
      {
        this.AGT = aFZ(str1);
        AppMethodBeat.o(167973);
        return;
        localObject = aFZ((String)localObject);
        if (localObject == null) {
          p.iCn();
        }
      }
      paramExifInterface = aFZ(str1);
      if (paramExifInterface == null) {
        p.iCn();
      }
      this.AGT = Float.valueOf(0.0F - paramExifInterface.floatValue());
    }
    AppMethodBeat.o(167973);
  }
  
  private final Float aFZ(String paramString)
  {
    AppMethodBeat.i(167971);
    try
    {
      paramString = (CharSequence)paramString;
      paramString = ((Collection)new k(",").u(paramString, 3)).toArray(new String[0]);
      if (paramString == null)
      {
        paramString = new t("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(167971);
        throw paramString;
      }
    }
    catch (Throwable paramString)
    {
      Log.printErrStackTrace(this.TAG, paramString, "convertToDegree", new Object[0]);
      AppMethodBeat.o(167971);
      return null;
    }
    paramString = (String[])paramString;
    Object localObject = (CharSequence)paramString[0];
    localObject = ((Collection)new k("/").u((CharSequence)localObject, 2)).toArray(new String[0]);
    if (localObject == null)
    {
      paramString = new t("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(167971);
      throw paramString;
    }
    localObject = (String[])localObject;
    double d1 = Double.parseDouble(localObject[0]) / Double.parseDouble(localObject[1]);
    localObject = (CharSequence)paramString[1];
    localObject = ((Collection)new k("/").u((CharSequence)localObject, 2)).toArray(new String[0]);
    if (localObject == null)
    {
      paramString = new t("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(167971);
      throw paramString;
    }
    localObject = (String[])localObject;
    double d3 = Double.parseDouble(localObject[0]) / Double.parseDouble(localObject[1]);
    paramString = (CharSequence)paramString[2];
    paramString = ((Collection)new k("/").u(paramString, 2)).toArray(new String[0]);
    if (paramString == null)
    {
      paramString = new t("null cannot be cast to non-null type kotlin.Array<T>");
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
    String str = String.valueOf(this.AGS) + ", " + String.valueOf(this.AGT);
    AppMethodBeat.o(167972);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.an
 * JD-Core Version:    0.7.0.1
 */