package com.tencent.mm.plugin.mall.b;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.a.c;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.ay.q;
import com.tencent.mm.b.g;
import com.tencent.mm.f.a.yq;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Util;
import java.text.SimpleDateFormat;

public final class a
{
  private static SimpleDateFormat tGV = null;
  private static SimpleDateFormat tGW = null;
  
  private static String aNT(String paramString)
  {
    AppMethodBeat.i(66185);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(66185);
      return null;
    }
    paramString = String.format("%s/%s", new Object[] { b.aSL() + "wallet/mall", g.getMessageDigest(paramString.getBytes()) });
    AppMethodBeat.o(66185);
    return paramString;
  }
  
  public static void eRc()
  {
    AppMethodBeat.i(66182);
    yq localyq = new yq();
    localyq.fXN.fXO = false;
    EventCenter.instance.publish(localyq);
    AppMethodBeat.o(66182);
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
      ((c.a)localObject).prefixPath = aNT(paramString);
      ((c.a)localObject).lRD = true;
      ((c.a)localObject).kOl = true;
      ((c.a)localObject).kPz = false;
      if (paramInt != 0) {
        ((c.a)localObject).lRP = paramInt;
      }
      localObject = ((c.a)localObject).bmL();
      q.bml().a(paramString, paramImageView, (c)localObject);
      AppMethodBeat.o(66184);
      return;
    }
    if (paramInt != 0) {
      paramImageView.setImageResource(paramInt);
    }
    AppMethodBeat.o(66184);
  }
  
  public static void s(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(66183);
    f(paramImageView, paramString, 0);
    AppMethodBeat.o(66183);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.b.a
 * JD-Core Version:    0.7.0.1
 */