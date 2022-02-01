package com.tencent.mm.plugin.finder.utils;

import android.media.ExifInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/GeoDegree;", "", "exif", "Landroid/media/ExifInterface;", "(Landroid/media/ExifInterface;)V", "Latitude", "", "getLatitude", "()Ljava/lang/Float;", "setLatitude", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "Longitude", "getLongitude", "setLongitude", "TAG", "", "isValid", "", "()Z", "setValid", "(Z)V", "convertToDegree", "stringDMS", "(Ljava/lang/String;)Ljava/lang/Float;", "toString", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class az
{
  Float Gjr;
  Float Gjs;
  private final String TAG;
  private boolean clZ;
  
  public az(ExifInterface paramExifInterface)
  {
    AppMethodBeat.i(167973);
    this.TAG = "Finder.GeoDegree";
    Object localObject = paramExifInterface.getAttribute("GPSLatitude");
    String str2 = paramExifInterface.getAttribute("GPSLatitudeRef");
    String str1 = paramExifInterface.getAttribute("GPSLongitude");
    paramExifInterface = paramExifInterface.getAttribute("GPSLongitudeRef");
    if ((localObject != null) && (str2 != null) && (str1 != null) && (paramExifInterface != null))
    {
      this.clZ = true;
      if (s.p(str2, "N")) {}
      for (this.Gjr = aCa((String)localObject); s.p(paramExifInterface, "E"); this.Gjr = Float.valueOf(0.0F - ((Float)localObject).floatValue()))
      {
        this.Gjs = aCa(str1);
        AppMethodBeat.o(167973);
        return;
        localObject = aCa((String)localObject);
        s.checkNotNull(localObject);
      }
      paramExifInterface = aCa(str1);
      s.checkNotNull(paramExifInterface);
      this.Gjs = Float.valueOf(0.0F - paramExifInterface.floatValue());
    }
    AppMethodBeat.o(167973);
  }
  
  private final Float aCa(String paramString)
  {
    AppMethodBeat.i(167971);
    try
    {
      paramString = (CharSequence)paramString;
      paramString = ((Collection)new k(",").o(paramString, 3)).toArray(new String[0]);
      if (paramString == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(167971);
        throw paramString;
      }
    }
    finally
    {
      Log.printErrStackTrace(this.TAG, paramString, "convertToDegree", new Object[0]);
      AppMethodBeat.o(167971);
      return null;
    }
    paramString = (String[])paramString;
    Object localObject = (CharSequence)paramString[0];
    localObject = ((Collection)new k("/").o((CharSequence)localObject, 2)).toArray(new String[0]);
    if (localObject == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(167971);
      throw paramString;
    }
    localObject = (String[])localObject;
    double d1 = Double.parseDouble(localObject[0]) / Double.parseDouble(localObject[1]);
    localObject = (CharSequence)paramString[1];
    localObject = ((Collection)new k("/").o((CharSequence)localObject, 2)).toArray(new String[0]);
    if (localObject == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(167971);
      throw paramString;
    }
    localObject = (String[])localObject;
    double d3 = Double.parseDouble(localObject[0]) / Double.parseDouble(localObject[1]);
    paramString = (CharSequence)paramString[2];
    paramString = ((Collection)new k("/").o(paramString, 2)).toArray(new String[0]);
    if (paramString == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
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
    String str = this.Gjr + ", " + this.Gjs;
    AppMethodBeat.o(167972);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.az
 * JD-Core Version:    0.7.0.1
 */