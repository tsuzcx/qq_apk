package com.tencent.mm.cl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;

public final class a
{
  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int k = paramOptions.outHeight;
    int m = paramOptions.outWidth;
    int i = 1;
    int j;
    for (;;)
    {
      j = i;
      if (m / i <= paramInt1) {
        break;
      }
      i += 1;
    }
    while (k / j > paramInt2) {
      j += 1;
    }
    return j;
  }
  
  public static void avA(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(116370);
    ab.i("MicroMsg.MMPhotoEditUtil", "[deleteDirAllFile] dir:%s", new Object[] { paramString });
    paramString = new File(paramString);
    if (paramString.exists())
    {
      paramString = paramString.listFiles();
      if (paramString != null)
      {
        int j = paramString.length;
        while (i < j)
        {
          Object localObject = paramString[i];
          if ((localObject.isFile()) && (!bo.isNullOrNil(localObject.getName())) && (localObject.getName().startsWith("wx_photo_edit_"))) {
            localObject.delete();
          }
          i += 1;
        }
      }
    }
    AppMethodBeat.o(116370);
  }
  
  public static String avz(String paramString)
  {
    AppMethodBeat.i(116368);
    paramString = e.esI + String.format("%s%d.%s", new Object[] { "wx_photo_edit_", Long.valueOf(System.currentTimeMillis()), paramString });
    AppMethodBeat.o(116368);
    return paramString;
  }
  
  public static int bC(float paramFloat)
  {
    AppMethodBeat.i(116369);
    int i = (int)(ah.getContext().getResources().getDisplayMetrics().density * paramFloat + 0.5F);
    AppMethodBeat.o(116369);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.cl.a
 * JD-Core Version:    0.7.0.1
 */