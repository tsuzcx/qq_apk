package com.tencent.mm.plugin.appbrand.m;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.e;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class b
{
  private static SimpleDateFormat vF = null;
  
  public static void a(String paramString, double paramDouble1, double paramDouble2, long paramLong)
  {
    AppMethodBeat.i(179483);
    if (!eK(paramString))
    {
      AppMethodBeat.o(179483);
      return;
    }
    if (vF == null)
    {
      localObject = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", Locale.US);
      vF = (SimpleDateFormat)localObject;
      ((SimpleDateFormat)localObject).setTimeZone(TimeZone.getTimeZone("UTC"));
    }
    Object localObject = new android.support.d.a(paramString);
    if ((paramDouble1 < -90.0D) || (paramDouble1 > 90.0D) || (Double.isNaN(paramDouble1)))
    {
      paramString = new IllegalArgumentException("Latitude value " + paramDouble1 + " is not valid.");
      AppMethodBeat.o(179483);
      throw paramString;
    }
    if ((paramDouble2 < -180.0D) || (paramDouble2 > 180.0D) || (Double.isNaN(paramDouble2)))
    {
      paramString = new IllegalArgumentException("Longitude value " + paramDouble2 + " is not valid.");
      AppMethodBeat.o(179483);
      throw paramString;
    }
    if (paramDouble1 >= 0.0D)
    {
      paramString = "N";
      ((android.support.d.a)localObject).setAttribute("GPSLatitudeRef", paramString);
      ((android.support.d.a)localObject).setAttribute("GPSLatitude", android.support.d.a.b(Math.abs(paramDouble1)));
      if (paramDouble2 < 0.0D) {
        break label340;
      }
    }
    label340:
    for (paramString = "E";; paramString = "W")
    {
      ((android.support.d.a)localObject).setAttribute("GPSLongitudeRef", paramString);
      ((android.support.d.a)localObject).setAttribute("GPSLongitude", android.support.d.a.b(Math.abs(paramDouble2)));
      paramString = vF.format(new Date(paramLong)).split("\\s+", -1);
      ((android.support.d.a)localObject).setAttribute("GPSDateStamp", paramString[0]);
      ((android.support.d.a)localObject).setAttribute("GPSTimeStamp", paramString[1]);
      ((android.support.d.a)localObject).setAttribute("DateTime", vF.format(new Date(paramLong)));
      ((android.support.d.a)localObject).setAttribute("SubSecTime", Long.toString(paramLong % 1000L));
      ((android.support.d.a)localObject).saveAttributes();
      AppMethodBeat.o(179483);
      return;
      paramString = "S";
      break;
    }
  }
  
  public static void b(InputStream paramInputStream, String paramString)
  {
    AppMethodBeat.i(138802);
    if ((paramInputStream == null) || (!eK(paramString)))
    {
      AppMethodBeat.o(138802);
      return;
    }
    paramString = new android.support.d.a(paramString);
    a.a(new android.support.d.a(paramInputStream), paramString);
    paramString.setAttribute("Orientation", null);
    paramString.setAttribute("ImageWidth", null);
    paramString.setAttribute("ThumbnailImageWidth", null);
    paramString.saveAttributes();
    AppMethodBeat.o(138802);
  }
  
  public static void cH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(138801);
    if ((!eK(paramString1)) || (!eK(paramString2)))
    {
      AppMethodBeat.o(138801);
      return;
    }
    paramString2 = new android.support.d.a(paramString2);
    a.a(new android.support.d.a(paramString1), paramString2);
    paramString2.setAttribute("Orientation", null);
    paramString2.setAttribute("ImageWidth", null);
    paramString2.setAttribute("ThumbnailImageWidth", null);
    paramString2.saveAttributes();
    AppMethodBeat.o(138801);
  }
  
  private static boolean eK(String paramString)
  {
    AppMethodBeat.i(138803);
    if ((!TextUtils.isEmpty(paramString)) && (new e(paramString).exists()))
    {
      AppMethodBeat.o(138803);
      return true;
    }
    AppMethodBeat.o(138803);
    return false;
  }
  
  public static int j(InputStream paramInputStream)
  {
    AppMethodBeat.i(138800);
    if (paramInputStream == null)
    {
      AppMethodBeat.o(138800);
      return 0;
    }
    try
    {
      int i = new android.support.d.a(paramInputStream).l("Orientation");
      AppMethodBeat.o(138800);
      return i;
    }
    catch (Exception paramInputStream)
    {
      AppMethodBeat.o(138800);
      return 0;
    }
    catch (Error paramInputStream)
    {
      AppMethodBeat.o(138800);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m.b
 * JD-Core Version:    0.7.0.1
 */