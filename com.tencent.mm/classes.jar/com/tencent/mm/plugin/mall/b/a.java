package com.tencent.mm.plugin.mall.b;

import android.widget.ImageView;
import com.tencent.mm.a.g;
import com.tencent.mm.as.a.a.c;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.h.a.rp;
import com.tencent.mm.sdk.platformtools.bk;
import java.text.SimpleDateFormat;

public final class a
{
  private static SimpleDateFormat izc = null;
  private static SimpleDateFormat izd = null;
  private static final String maC = e.bkH + "wallet/mall";
  
  public static void bgU()
  {
    rp localrp = new rp();
    localrp.cbe.cbf = false;
    com.tencent.mm.sdk.b.a.udP.m(localrp);
  }
  
  public static void f(ImageView paramImageView, String paramString, int paramInt)
  {
    Object localObject = null;
    if (paramImageView == null) {}
    do
    {
      return;
      paramImageView.setImageBitmap(null);
      if (!bk.bl(paramString))
      {
        c.a locala = new c.a();
        if (bk.bl(paramString)) {}
        for (;;)
        {
          locala.eri = ((String)localObject);
          locala.erf = true;
          locala.erC = true;
          locala.erD = false;
          if (paramInt != 0) {
            locala.eru = paramInt;
          }
          localObject = locala.OV();
          o.ON().a(paramString, paramImageView, (c)localObject);
          return;
          localObject = String.format("%s/%s", new Object[] { maC, g.o(paramString.getBytes()) });
        }
      }
    } while (paramInt == 0);
    paramImageView.setImageResource(paramInt);
  }
  
  public static void j(ImageView paramImageView, String paramString)
  {
    f(paramImageView, paramString, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.b.a
 * JD-Core Version:    0.7.0.1
 */