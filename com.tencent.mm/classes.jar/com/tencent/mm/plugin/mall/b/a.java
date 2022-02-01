package com.tencent.mm.plugin.mall.b;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.a.c;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.o;
import com.tencent.mm.b.g;
import com.tencent.mm.g.a.vd;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.bt;
import java.text.SimpleDateFormat;

public final class a
{
  private static SimpleDateFormat nJi = null;
  private static SimpleDateFormat nJj = null;
  
  private static String afC(String paramString)
  {
    AppMethodBeat.i(66185);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(66185);
      return null;
    }
    paramString = String.format("%s/%s", new Object[] { b.aih() + "wallet/mall", g.getMessageDigest(paramString.getBytes()) });
    AppMethodBeat.o(66185);
    return paramString;
  }
  
  public static void cNI()
  {
    AppMethodBeat.i(66182);
    vd localvd = new vd();
    localvd.dAB.dAC = false;
    com.tencent.mm.sdk.b.a.ESL.l(localvd);
    AppMethodBeat.o(66182);
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
    if (!bt.isNullOrNil(paramString))
    {
      Object localObject = new c.a();
      ((c.a)localObject).prefixPath = afC(paramString);
      ((c.a)localObject).hjU = true;
      ((c.a)localObject).gjA = true;
      ((c.a)localObject).gkG = false;
      if (paramInt != 0) {
        ((c.a)localObject).hkf = paramInt;
      }
      localObject = ((c.a)localObject).azc();
      o.ayJ().a(paramString, paramImageView, (c)localObject);
      AppMethodBeat.o(66184);
      return;
    }
    if (paramInt != 0) {
      paramImageView.setImageResource(paramInt);
    }
    AppMethodBeat.o(66184);
  }
  
  public static void q(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(66183);
    d(paramImageView, paramString, 0);
    AppMethodBeat.o(66183);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.b.a
 * JD-Core Version:    0.7.0.1
 */