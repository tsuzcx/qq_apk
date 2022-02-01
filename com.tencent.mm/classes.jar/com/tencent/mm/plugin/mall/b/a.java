package com.tencent.mm.plugin.mall.b;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.o;
import com.tencent.mm.b.g;
import com.tencent.mm.g.a.vn;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.bs;
import java.text.SimpleDateFormat;

public final class a
{
  private static SimpleDateFormat omi = null;
  private static SimpleDateFormat omj = null;
  
  private static String akw(String paramString)
  {
    AppMethodBeat.i(66185);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(66185);
      return null;
    }
    paramString = String.format("%s/%s", new Object[] { b.aph() + "wallet/mall", g.getMessageDigest(paramString.getBytes()) });
    AppMethodBeat.o(66185);
    return paramString;
  }
  
  public static void d(ImageView paramImageView, String paramString, int paramInt)
  {
    AppMethodBeat.i(66184);
    if (paramImageView == null)
    {
      AppMethodBeat.o(66184);
      return;
    }
    paramImageView.setImageBitmap(null);
    if (!bs.isNullOrNil(paramString))
    {
      Object localObject = new c.a();
      ((c.a)localObject).prefixPath = akw(paramString);
      ((c.a)localObject).hKx = true;
      ((c.a)localObject).gKm = true;
      ((c.a)localObject).gLt = false;
      if (paramInt != 0) {
        ((c.a)localObject).hKI = paramInt;
      }
      localObject = ((c.a)localObject).aFT();
      o.aFB().a(paramString, paramImageView, (c)localObject);
      AppMethodBeat.o(66184);
      return;
    }
    if (paramInt != 0) {
      paramImageView.setImageResource(paramInt);
    }
    AppMethodBeat.o(66184);
  }
  
  public static void dbp()
  {
    AppMethodBeat.i(66182);
    vn localvn = new vn();
    localvn.dyn.dyo = false;
    com.tencent.mm.sdk.b.a.GpY.l(localvn);
    AppMethodBeat.o(66182);
  }
  
  public static void q(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(66183);
    d(paramImageView, paramString, 0);
    AppMethodBeat.o(66183);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.b.a
 * JD-Core Version:    0.7.0.1
 */