package com.tencent.mm.cl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;

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
  
  public static int ao(float paramFloat)
  {
    AppMethodBeat.i(9346);
    int i = (int)(MMApplicationContext.getContext().getResources().getDisplayMetrics().density * paramFloat + 0.5F);
    AppMethodBeat.o(9346);
    return i;
  }
  
  public static String boD(String paramString)
  {
    AppMethodBeat.i(9345);
    paramString = b.aKS() + String.format("%s%d.%s", new Object[] { "wx_photo_edit_", Long.valueOf(System.currentTimeMillis()), paramString });
    AppMethodBeat.o(9345);
    return paramString;
  }
  
  public static void boE(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(9347);
    Log.i("MicroMsg.MMPhotoEditUtil", "[deleteDirAllFile] dir:%s", new Object[] { paramString });
    paramString = new o(paramString);
    if (paramString.exists())
    {
      paramString = paramString.het();
      if (paramString != null)
      {
        int j = paramString.length;
        while (i < j)
        {
          Object localObject = paramString[i];
          if ((localObject.isFile()) && (!Util.isNullOrNil(localObject.getName())) && (localObject.getName().startsWith("wx_photo_edit_"))) {
            localObject.delete();
          }
          i += 1;
        }
      }
    }
    AppMethodBeat.o(9347);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.cl.a
 * JD-Core Version:    0.7.0.1
 */