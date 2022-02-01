package com.tencent.mm.plugin.appbrand.l;

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
  private static SimpleDateFormat yw = null;
  
  public static void a(String paramString, double paramDouble1, double paramDouble2, long paramLong)
  {
    AppMethodBeat.i(179483);
    if (!fv(paramString))
    {
      AppMethodBeat.o(179483);
      return;
    }
    if (yw == null)
    {
      localObject = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", Locale.US);
      yw = (SimpleDateFormat)localObject;
      ((SimpleDateFormat)localObject).setTimeZone(TimeZone.getTimeZone("UTC"));
    }
    Object localObject = new android.support.e.a(paramString);
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
      ((android.support.e.a)localObject).setAttribute("GPSLatitudeRef", paramString);
      ((android.support.e.a)localObject).setAttribute("GPSLatitude", android.support.e.a.b(Math.abs(paramDouble1)));
      if (paramDouble2 < 0.0D) {
        break label340;
      }
    }
    label340:
    for (paramString = "E";; paramString = "W")
    {
      ((android.support.e.a)localObject).setAttribute("GPSLongitudeRef", paramString);
      ((android.support.e.a)localObject).setAttribute("GPSLongitude", android.support.e.a.b(Math.abs(paramDouble2)));
      paramString = yw.format(new Date(paramLong)).split("\\s+", -1);
      ((android.support.e.a)localObject).setAttribute("GPSDateStamp", paramString[0]);
      ((android.support.e.a)localObject).setAttribute("GPSTimeStamp", paramString[1]);
      ((android.support.e.a)localObject).setAttribute("DateTime", yw.format(new Date(paramLong)));
      ((android.support.e.a)localObject).setAttribute("SubSecTime", Long.toString(paramLong % 1000L));
      ((android.support.e.a)localObject).saveAttributes();
      AppMethodBeat.o(179483);
      return;
      paramString = "S";
      break;
    }
  }
  
  public static void b(InputStream paramInputStream, String paramString)
  {
    AppMethodBeat.i(138802);
    if ((paramInputStream == null) || (!fv(paramString)))
    {
      AppMethodBeat.o(138802);
      return;
    }
    paramString = new android.support.e.a(paramString);
    a.a(new android.support.e.a(paramInputStream), paramString);
    paramString.setAttribute("Orientation", null);
    paramString.setAttribute("ImageWidth", null);
    paramString.setAttribute("ThumbnailImageWidth", null);
    paramString.saveAttributes();
    AppMethodBeat.o(138802);
  }
  
  public static void cT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(138801);
    if ((!fv(paramString1)) || (!fv(paramString2)))
    {
      AppMethodBeat.o(138801);
      return;
    }
    paramString2 = new android.support.e.a(paramString2);
    a.a(new android.support.e.a(paramString1), paramString2);
    paramString2.setAttribute("Orientation", null);
    paramString2.setAttribute("ImageWidth", null);
    paramString2.setAttribute("ThumbnailImageWidth", null);
    paramString2.saveAttributes();
    AppMethodBeat.o(138801);
  }
  
  private static boolean fv(String paramString)
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
  
  public static int m(InputStream paramInputStream)
  {
    AppMethodBeat.i(138800);
    if (paramInputStream == null)
    {
      AppMethodBeat.o(138800);
      return 0;
    }
    try
    {
      int i = new android.support.e.a(paramInputStream).l("Orientation");
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.l.b
 * JD-Core Version:    0.7.0.1
 */