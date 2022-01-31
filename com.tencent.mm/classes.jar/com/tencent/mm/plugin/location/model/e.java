package com.tencent.mm.plugin.location.model;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public final class e
{
  public static String a(LocationInfo paramLocationInfo)
  {
    AppMethodBeat.i(113305);
    if (paramLocationInfo.cDl == null) {
      paramLocationInfo.cDl = "";
    }
    paramLocationInfo = "<msg><location x=\"" + paramLocationInfo.nZV + "\" y=\"" + paramLocationInfo.nZW + "\" scale=\"" + paramLocationInfo.nZX + "\" label=\"" + bo.apT(paramLocationInfo.nZY) + "\" poiname=\"" + bo.apT(paramLocationInfo.cDl) + "\" maptype=\"0\" /></msg>";
    AppMethodBeat.o(113305);
    return paramLocationInfo;
  }
  
  public static String a(String paramString1, String paramString2, View paramView)
  {
    AppMethodBeat.i(113306);
    ab.d("MicroMsg.MapUtil", "w h " + paramView.getWidth() + " " + (paramView.getHeight() / 2 + 20));
    String str = paramString1 + paramString2 + ".png";
    Bitmap localBitmap = Bitmap.createBitmap(paramView.getWidth(), (int)(paramView.getHeight() * 0.7D), Bitmap.Config.ARGB_8888);
    paramView.draw(new Canvas(localBitmap));
    try
    {
      ab.d("MicroMsg.MapUtil", "saveMyBitmap ".concat(String.valueOf(paramString2)));
      paramString1 = new File(paramString1 + paramString2 + ".png");
      paramString1.createNewFile();
      try
      {
        paramString1 = new FileOutputStream(paramString1);
        ab.d("MicroMsg.MapUtil", "h " + localBitmap.getHeight() + " w:" + localBitmap.getWidth() + " ");
        localBitmap.compress(Bitmap.CompressFormat.PNG, 100, paramString1);
        if (paramString1 == null) {}
      }
      catch (FileNotFoundException paramString1)
      {
        try
        {
          paramString1.flush();
          paramString1.close();
          ab.i("MicroMsg.MapUtil", "bitmap recycle %s", new Object[] { localBitmap.toString() });
          localBitmap.recycle();
          AppMethodBeat.o(113306);
          return str;
          paramString1 = paramString1;
          ab.printErrStackTrace("MicroMsg.MapUtil", paramString1, "", new Object[0]);
          paramString1 = null;
        }
        catch (IOException paramString1)
        {
          for (;;)
          {
            ab.printErrStackTrace("MicroMsg.MapUtil", paramString1, "", new Object[0]);
          }
        }
      }
      return null;
    }
    catch (IOException paramString1)
    {
      ab.printErrStackTrace("MicroMsg.MapUtil", paramString1, "", new Object[0]);
      AppMethodBeat.o(113306);
    }
  }
  
  public static PackageInfo aK(Context paramContext, String paramString)
  {
    AppMethodBeat.i(113304);
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 1);
      AppMethodBeat.o(113304);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      ab.printErrStackTrace("MicroMsg.MapUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(113304);
      return null;
    }
    catch (ActivityNotFoundException paramContext)
    {
      ab.printErrStackTrace("MicroMsg.MapUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(113304);
    }
    return null;
  }
  
  public static double[] c(double[] paramArrayOfDouble)
  {
    AppMethodBeat.i(113308);
    double d1 = paramArrayOfDouble[0];
    double d2 = paramArrayOfDouble[1];
    if ((d1 < 72.004000000000005D) || (d1 > 137.8347D) || (d2 < 0.8293D) || (d2 > 55.827100000000002D)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(113308);
      return new double[] { d1, d2 };
    }
    double d3 = d1 - 105.0D;
    double d4 = d2 - 35.0D;
    double d10 = Math.sqrt(Math.abs(d3));
    double d11 = (20.0D * Math.sin(6.0D * d3 * 3.141592653589793D) + 20.0D * Math.sin(2.0D * d3 * 3.141592653589793D)) * 2.0D / 3.0D;
    double d12 = (20.0D * Math.sin(3.141592653589793D * d4) + 40.0D * Math.sin(d4 / 3.0D * 3.141592653589793D)) * 2.0D / 3.0D;
    double d13 = (160.0D * Math.sin(d4 / 12.0D * 3.141592653589793D) + 320.0D * Math.sin(3.141592653589793D * d4 / 30.0D)) * 2.0D / 3.0D;
    double d5 = Math.sqrt(Math.abs(d3));
    double d6 = (20.0D * Math.sin(6.0D * d3 * 3.141592653589793D) + 20.0D * Math.sin(2.0D * d3 * 3.141592653589793D)) * 2.0D / 3.0D;
    double d7 = (20.0D * Math.sin(3.141592653589793D * d3) + 40.0D * Math.sin(d3 / 3.0D * 3.141592653589793D)) * 2.0D / 3.0D;
    double d8 = Math.sin(d3 / 12.0D * 3.141592653589793D);
    d8 = (Math.sin(d3 / 30.0D * 3.141592653589793D) * 300.0D + 150.0D * d8) * 2.0D / 3.0D;
    double d9 = d2 / 180.0D * 3.141592653589793D;
    double d14 = Math.sin(d9);
    double d15 = 1.0D - d14 * (0.006693421622965943D * d14);
    d14 = Math.sqrt(d15);
    d10 = (-100.0D + 2.0D * d3 + 3.0D * d4 + 0.2D * d4 * d4 + 0.1D * d3 * d4 + 0.2D * d10 + d11 + d12 + d13) * 180.0D / (6335552.7170004258D / (d15 * d14) * 3.141592653589793D);
    d11 = 6378245.0D / d14;
    d3 = (d8 + (d4 * (0.1D * d3) + (300.0D + d3 + 2.0D * d4 + 0.1D * d3 * d3) + 0.1D * d5 + d6 + d7)) * 180.0D / (Math.cos(d9) * d11 * 3.141592653589793D);
    AppMethodBeat.o(113308);
    return new double[] { d1 * 2.0D - (d1 + d3), 2.0D * d2 - (d2 + d10) };
  }
  
  public static boolean j(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(113307);
    if ((Math.abs(paramDouble2) > 180.0D) || (Math.abs(paramDouble1) > 90.0D))
    {
      AppMethodBeat.o(113307);
      return false;
    }
    AppMethodBeat.o(113307);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.e
 * JD-Core Version:    0.7.0.1
 */