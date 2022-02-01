package com.tencent.mm.plugin.mall.b;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.aaj;
import com.tencent.mm.b.g;
import com.tencent.mm.modelimage.loader.a;
import com.tencent.mm.modelimage.loader.a.c;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.sdk.platformtools.Util;
import java.text.SimpleDateFormat;

public final class b
{
  private static SimpleDateFormat wKu = null;
  private static SimpleDateFormat wKv = null;
  
  private static String aKQ(String paramString)
  {
    AppMethodBeat.i(66185);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(66185);
      return null;
    }
    paramString = String.format("%s/%s", new Object[] { com.tencent.mm.loader.i.b.bmz() + "wallet/mall", g.getMessageDigest(paramString.getBytes()) });
    AppMethodBeat.o(66185);
    return paramString;
  }
  
  public static void f(ImageView paramImageView, String paramString, int paramInt)
  {
    AppMethodBeat.i(66184);
    if (paramImageView == null)
    {
      AppMethodBeat.o(66184);
      return;
    }
    paramImageView.setImageBitmap(null);
    if (!Util.isNullOrNil(paramString))
    {
      Object localObject = new c.a();
      ((c.a)localObject).prefixPath = aKQ(paramString);
      ((c.a)localObject).oKp = true;
      ((c.a)localObject).nqa = true;
      ((c.a)localObject).nrc = false;
      if (paramInt != 0) {
        ((c.a)localObject).oKB = paramInt;
      }
      localObject = ((c.a)localObject).bKx();
      r.bKe().a(paramString, paramImageView, (c)localObject);
      AppMethodBeat.o(66184);
      return;
    }
    if (paramInt != 0) {
      paramImageView.setImageResource(paramInt);
    }
    AppMethodBeat.o(66184);
  }
  
  public static void fZL()
  {
    AppMethodBeat.i(66182);
    aaj localaaj = new aaj();
    localaaj.idN.idO = false;
    localaaj.publish();
    AppMethodBeat.o(66182);
  }
  
  public static void t(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(66183);
    f(paramImageView, paramString, 0);
    AppMethodBeat.o(66183);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.b.b
 * JD-Core Version:    0.7.0.1
 */