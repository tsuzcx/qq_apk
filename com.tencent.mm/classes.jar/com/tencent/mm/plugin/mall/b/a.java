package com.tencent.mm.plugin.mall.b;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.q;
import com.tencent.mm.b.g;
import com.tencent.mm.g.a.wk;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.bu;
import java.text.SimpleDateFormat;

public final class a
{
  private static SimpleDateFormat oWf = null;
  private static SimpleDateFormat oWg = null;
  
  private static String aqo(String paramString)
  {
    AppMethodBeat.i(66185);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(66185);
      return null;
    }
    paramString = String.format("%s/%s", new Object[] { b.asj() + "wallet/mall", g.getMessageDigest(paramString.getBytes()) });
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
    if (!bu.isNullOrNil(paramString))
    {
      Object localObject = new c.a();
      ((c.a)localObject).prefixPath = aqo(paramString);
      ((c.a)localObject).igk = true;
      ((c.a)localObject).hgL = true;
      ((c.a)localObject).hhW = false;
      if (paramInt != 0) {
        ((c.a)localObject).igv = paramInt;
      }
      localObject = ((c.a)localObject).aJu();
      q.aJb().a(paramString, paramImageView, (c)localObject);
      AppMethodBeat.o(66184);
      return;
    }
    if (paramInt != 0) {
      paramImageView.setImageResource(paramInt);
    }
    AppMethodBeat.o(66184);
  }
  
  public static void dnJ()
  {
    AppMethodBeat.i(66182);
    wk localwk = new wk();
    localwk.dLP.dLQ = false;
    com.tencent.mm.sdk.b.a.IvT.l(localwk);
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