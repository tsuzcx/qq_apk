package com.tencent.mm.plugin.mall.b;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.tg;
import com.tencent.mm.sdk.platformtools.bo;
import java.text.SimpleDateFormat;

public final class a
{
  private static SimpleDateFormat kCj;
  private static SimpleDateFormat kCk;
  private static final String oBb;
  
  static
  {
    AppMethodBeat.i(43283);
    kCj = null;
    kCk = null;
    oBb = e.eQz + "wallet/mall";
    AppMethodBeat.o(43283);
  }
  
  private static String SA(String paramString)
  {
    AppMethodBeat.i(43282);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(43282);
      return null;
    }
    paramString = String.format("%s/%s", new Object[] { oBb, g.w(paramString.getBytes()) });
    AppMethodBeat.o(43282);
    return paramString;
  }
  
  public static void bOS()
  {
    AppMethodBeat.i(43279);
    tg localtg = new tg();
    localtg.cJH.cJI = false;
    com.tencent.mm.sdk.b.a.ymk.l(localtg);
    AppMethodBeat.o(43279);
  }
  
  public static void d(ImageView paramImageView, String paramString, int paramInt)
  {
    AppMethodBeat.i(43281);
    if (paramImageView == null)
    {
      AppMethodBeat.o(43281);
      return;
    }
    paramImageView.setImageBitmap(null);
    if (!bo.isNullOrNil(paramString))
    {
      Object localObject = new c.a();
      ((c.a)localObject).eNP = SA(paramString);
      ((c.a)localObject).eNM = true;
      ((c.a)localObject).eOe = true;
      ((c.a)localObject).eOk = false;
      if (paramInt != 0) {
        ((c.a)localObject).eNY = paramInt;
      }
      localObject = ((c.a)localObject).ahY();
      o.ahG().a(paramString, paramImageView, (c)localObject);
      AppMethodBeat.o(43281);
      return;
    }
    if (paramInt != 0) {
      paramImageView.setImageResource(paramInt);
    }
    AppMethodBeat.o(43281);
  }
  
  public static void o(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(43280);
    d(paramImageView, paramString, 0);
    AppMethodBeat.o(43280);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.b.a
 * JD-Core Version:    0.7.0.1
 */