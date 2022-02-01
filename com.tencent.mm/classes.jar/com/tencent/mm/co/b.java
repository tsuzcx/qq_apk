package com.tencent.mm.co;

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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.vfs.o;

public final class b
{
  private static BitmapFactory.Options aXO(String paramString)
  {
    AppMethodBeat.i(152889);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    paramString = BitmapFactory.decodeFile(o.k(paramString, false), localOptions);
    if (paramString != null) {
      paramString.recycle();
    }
    AppMethodBeat.o(152889);
    return localOptions;
  }
  
  public static boolean bau(String paramString)
  {
    AppMethodBeat.i(152885);
    if (fWN())
    {
      AppMethodBeat.o(152885);
      return false;
    }
    paramString = aXO(paramString);
    int i = paramString.outWidth;
    int j = paramString.outHeight;
    ae.i("MicroMsg.BigImageJudge", "alvinluo checkUseBigImgOpt ignore abTestFlag, widthFactor: %f, heightFactor: %f, width: %d, height: %d", new Object[] { Float.valueOf(1.0F), Float.valueOf(1.0F), Integer.valueOf(i), Integer.valueOf(j) });
    if (a.kN(i, j))
    {
      ae.i("MicroMsg.BigImageJudge", "alvinluo checkUseBigImageOpt filter image");
      AppMethodBeat.o(152885);
      return false;
    }
    ae.i("MicroMsg.BigImageJudge", "alvinluo checkUseBigImageOpt not filter");
    int k = getScreenWidth(ak.getContext());
    int m = getScreenHeight(ak.getContext());
    ae.d("MicroMsg.BigImageJudge", "alvinluo checkUseBigImageOpt width: %d, height: %d, screenWidth: %d, screenHeight: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) });
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
  
  private static boolean fWN()
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
    if (l.abB())
    {
      ae.i("MicroMsg.BigImageJudge", "alvinluo checkUseBigImageOpt is MTK platform");
      if ((Build.VERSION.SDK_INT == 24) || (Build.VERSION.SDK_INT == 25) || (Build.VERSION.SDK_INT == 27))
      {
        ae.i("MicroMsg.BigImageJudge", "alvinluo checkUseBigImgOpt is MTK platform, android api: %d, cannot use BigImgOpt", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
        c.ahd(Build.VERSION.SDK_INT);
        AppMethodBeat.o(152886);
        return true;
      }
    }
    AppMethodBeat.o(152886);
    return false;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.co.b
 * JD-Core Version:    0.7.0.1
 */