package com.tencent.mm.cj;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.util.DisplayMetrics;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;

public final class a
{
  public static int aR(float paramFloat)
  {
    return (int)(ae.getContext().getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public static void aeI(String paramString)
  {
    int i = 0;
    y.i("MicroMsg.MMPhotoEditUtil", "[deleteDirAllFile] dir:%s", new Object[] { paramString });
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
          if ((localObject.isFile()) && (!bk.bl(localObject.getName())) && (localObject.getName().startsWith("wx_photo_edit_"))) {
            localObject.delete();
          }
          i += 1;
        }
      }
    }
  }
  
  public static int calculateInSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cj.a
 * JD-Core Version:    0.7.0.1
 */