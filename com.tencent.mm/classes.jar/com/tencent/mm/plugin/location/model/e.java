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
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public final class e
{
  public static String a(LocationInfo paramLocationInfo)
  {
    if (paramLocationInfo.bVA == null) {
      paramLocationInfo.bVA = "";
    }
    return "<msg><location x=\"" + paramLocationInfo.lCJ + "\" y=\"" + paramLocationInfo.lCK + "\" scale=\"" + paramLocationInfo.lCL + "\" label=\"" + bk.ZP(paramLocationInfo.lCM) + "\" poiname=\"" + bk.ZP(paramLocationInfo.bVA) + "\" maptype=\"0\" /></msg>";
  }
  
  public static String a(String paramString1, String paramString2, View paramView)
  {
    y.d("MicroMsg.MapUtil", "w h " + paramView.getWidth() + " " + (paramView.getHeight() / 2 + 20));
    String str = paramString1 + paramString2 + ".png";
    Bitmap localBitmap = Bitmap.createBitmap(paramView.getWidth(), (int)(paramView.getHeight() * 0.7D), Bitmap.Config.ARGB_8888);
    paramView.draw(new Canvas(localBitmap));
    try
    {
      y.d("MicroMsg.MapUtil", "saveMyBitmap " + paramString2);
      paramString1 = new File(paramString1 + paramString2 + ".png");
      paramString1.createNewFile();
      try
      {
        paramString1 = new FileOutputStream(paramString1);
        y.d("MicroMsg.MapUtil", "h " + localBitmap.getHeight() + " w:" + localBitmap.getWidth() + " ");
        localBitmap.compress(Bitmap.CompressFormat.PNG, 100, paramString1);
        if (paramString1 == null) {}
      }
      catch (FileNotFoundException paramString1)
      {
        try
        {
          paramString1.flush();
          paramString1.close();
          localBitmap.recycle();
          return str;
          paramString1 = paramString1;
          y.printErrStackTrace("MicroMsg.MapUtil", paramString1, "", new Object[0]);
          paramString1 = null;
        }
        catch (IOException paramString1)
        {
          for (;;)
          {
            y.printErrStackTrace("MicroMsg.MapUtil", paramString1, "", new Object[0]);
          }
        }
      }
      return null;
    }
    catch (IOException paramString1)
    {
      y.printErrStackTrace("MicroMsg.MapUtil", paramString1, "", new Object[0]);
    }
  }
  
  public static PackageInfo aB(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 1);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      y.printErrStackTrace("MicroMsg.MapUtil", paramContext, "", new Object[0]);
      return null;
    }
    catch (ActivityNotFoundException paramContext)
    {
      y.printErrStackTrace("MicroMsg.MapUtil", paramContext, "", new Object[0]);
    }
    return null;
  }
  
  public static boolean h(double paramDouble1, double paramDouble2)
  {
    return (Math.abs(paramDouble2) <= 180.0D) && (Math.abs(paramDouble1) <= 90.0D);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.e
 * JD-Core Version:    0.7.0.1
 */