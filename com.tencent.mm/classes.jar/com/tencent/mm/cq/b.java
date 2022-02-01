package com.tencent.mm.cq;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.util.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.s;

public final class b
{
  public static boolean adl(String paramString)
  {
    AppMethodBeat.i(152885);
    if (hiq())
    {
      AppMethodBeat.o(152885);
      return false;
    }
    paramString = bmT(paramString);
    int i = paramString.outWidth;
    int j = paramString.outHeight;
    Log.i("MicroMsg.BigImageJudge", "alvinluo checkUseBigImgOpt ignore abTestFlag, widthFactor: %f, heightFactor: %f, width: %d, height: %d", new Object[] { Float.valueOf(1.0F), Float.valueOf(1.0F), Integer.valueOf(i), Integer.valueOf(j) });
    if (a.ml(i, j))
    {
      Log.i("MicroMsg.BigImageJudge", "alvinluo checkUseBigImageOpt filter image");
      AppMethodBeat.o(152885);
      return false;
    }
    Log.i("MicroMsg.BigImageJudge", "alvinluo checkUseBigImageOpt not filter");
    int k = getScreenWidth(MMApplicationContext.getContext());
    int m = getScreenHeight(MMApplicationContext.getContext());
    Log.d("MicroMsg.BigImageJudge", "alvinluo checkUseBigImageOpt width: %d, height: %d, screenWidth: %d, screenHeight: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) });
    if (i >= k * 1.0F)
    {
      AppMethodBeat.o(152885);
      return true;
    }
    if (j >= m * 1.0F)
    {
      AppMethodBeat.o(152885);
      return true;
    }
    AppMethodBeat.o(152885);
    return false;
  }
  
  private static BitmapFactory.Options bmT(String paramString)
  {
    AppMethodBeat.i(152889);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    paramString = BitmapFactory.decodeFile(s.k(paramString, false), localOptions);
    if (paramString != null) {
      paramString.recycle();
    }
    AppMethodBeat.o(152889);
    return localOptions;
  }
  
  private static int getScreenHeight(Context paramContext)
  {
    AppMethodBeat.i(152888);
    if (paramContext == null)
    {
      AppMethodBeat.o(152888);
      return 0;
    }
    int i = paramContext.getResources().getDisplayMetrics().heightPixels;
    AppMethodBeat.o(152888);
    return i;
  }
  
  private static int getScreenWidth(Context paramContext)
  {
    AppMethodBeat.i(152887);
    if (paramContext == null)
    {
      AppMethodBeat.o(152887);
      return 0;
    }
    int i = paramContext.getResources().getDisplayMetrics().widthPixels;
    AppMethodBeat.o(152887);
    return i;
  }
  
  private static boolean hiq()
  {
    AppMethodBeat.i(152886);
    if (Build.VERSION.SDK_INT == 27)
    {
      String str = af.get("ro.mediatek.platform");
      if ((str != null) && ((str.startsWith("mt6765")) || (str.startsWith("MT6765"))))
      {
        AppMethodBeat.o(152886);
        return false;
      }
    }
    if (l.apy())
    {
      Log.i("MicroMsg.BigImageJudge", "alvinluo checkUseBigImageOpt is MTK platform");
      if ((Build.VERSION.SDK_INT == 24) || (Build.VERSION.SDK_INT == 25) || (Build.VERSION.SDK_INT == 27))
      {
        Log.i("MicroMsg.BigImageJudge", "alvinluo checkUseBigImgOpt is MTK platform, android api: %d, cannot use BigImgOpt", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
        c.aqp(Build.VERSION.SDK_INT);
        AppMethodBeat.o(152886);
        return true;
      }
    }
    AppMethodBeat.o(152886);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.cq.b
 * JD-Core Version:    0.7.0.1
 */