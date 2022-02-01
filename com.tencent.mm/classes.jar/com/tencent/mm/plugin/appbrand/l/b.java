package com.tencent.mm.plugin.appbrand.l;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.q;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class b
{
  private static SimpleDateFormat TF = null;
  
  public static void a(String paramString, double paramDouble1, double paramDouble2, long paramLong)
  {
    AppMethodBeat.i(179483);
    if (!agG(paramString))
    {
      AppMethodBeat.o(179483);
      return;
    }
    if (TF == null)
    {
      localObject = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", Locale.US);
      TF = (SimpleDateFormat)localObject;
      ((SimpleDateFormat)localObject).setTimeZone(TimeZone.getTimeZone("UTC"));
    }
    Object localObject = new androidx.e.a.a(paramString);
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
      ((androidx.e.a.a)localObject).c("GPSLatitudeRef", paramString);
      ((androidx.e.a.a)localObject).c("GPSLatitude", androidx.e.a.a.b(Math.abs(paramDouble1)));
      if (paramDouble2 < 0.0D) {
        break label340;
      }
    }
    label340:
    for (paramString = "E";; paramString = "W")
    {
      ((androidx.e.a.a)localObject).c("GPSLongitudeRef", paramString);
      ((androidx.e.a.a)localObject).c("GPSLongitude", androidx.e.a.a.b(Math.abs(paramDouble2)));
      paramString = TF.format(new Date(paramLong)).split("\\s+", -1);
      ((androidx.e.a.a)localObject).c("GPSDateStamp", paramString[0]);
      ((androidx.e.a.a)localObject).c("GPSTimeStamp", paramString[1]);
      ((androidx.e.a.a)localObject).c("DateTime", TF.format(new Date(paramLong)));
      ((androidx.e.a.a)localObject).c("SubSecTime", Long.toString(paramLong % 1000L));
      ((androidx.e.a.a)localObject).ib();
      AppMethodBeat.o(179483);
      return;
      paramString = "S";
      break;
    }
  }
  
  private static boolean agG(String paramString)
  {
    AppMethodBeat.i(138803);
    if ((!TextUtils.isEmpty(paramString)) && (new q(paramString).ifE()))
    {
      AppMethodBeat.o(138803);
      return true;
    }
    AppMethodBeat.o(138803);
    return false;
  }
  
  public static void b(InputStream paramInputStream, String paramString)
  {
    AppMethodBeat.i(138802);
    if ((paramInputStream == null) || (!agG(paramString)))
    {
      AppMethodBeat.o(138802);
      return;
    }
    paramString = new androidx.e.a.a(paramString);
    a.a(new androidx.e.a.a(paramInputStream), paramString);
    paramString.c("Orientation", null);
    paramString.c("ImageWidth", null);
    paramString.c("ThumbnailImageWidth", null);
    paramString.ib();
    AppMethodBeat.o(138802);
  }
  
  public static void dt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(138801);
    if ((!agG(paramString1)) || (!agG(paramString2)))
    {
      AppMethodBeat.o(138801);
      return;
    }
    paramString2 = new androidx.e.a.a(paramString2);
    a.a(new androidx.e.a.a(paramString1), paramString2);
    paramString2.c("Orientation", null);
    paramString2.c("ImageWidth", null);
    paramString2.c("ThumbnailImageWidth", null);
    paramString2.ib();
    AppMethodBeat.o(138801);
  }
  
  public static int k(InputStream paramInputStream)
  {
    AppMethodBeat.i(138800);
    if (paramInputStream == null)
    {
      AppMethodBeat.o(138800);
      return 0;
    }
    try
    {
      int i = new androidx.e.a.a(paramInputStream).i("Orientation", 1);
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