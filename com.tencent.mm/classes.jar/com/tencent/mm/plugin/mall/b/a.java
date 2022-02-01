package com.tencent.mm.plugin.mall.b;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.q;
import com.tencent.mm.b.g;
import com.tencent.mm.g.a.xk;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Util;
import java.text.SimpleDateFormat;

public final class a
{
  private static SimpleDateFormat qkZ = null;
  private static SimpleDateFormat qla = null;
  
  private static String aDJ(String paramString)
  {
    AppMethodBeat.i(66185);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(66185);
      return null;
    }
    paramString = String.format("%s/%s", new Object[] { b.aKJ() + "wallet/mall", g.getMessageDigest(paramString.getBytes()) });
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
    if (!Util.isNullOrNil(paramString))
    {
      Object localObject = new c.a();
      ((c.a)localObject).prefixPath = aDJ(paramString);
      ((c.a)localObject).jbf = true;
      ((c.a)localObject).hZF = true;
      ((c.a)localObject).iaT = false;
      if (paramInt != 0) {
        ((c.a)localObject).jbq = paramInt;
      }
      localObject = ((c.a)localObject).bdv();
      q.bcV().a(paramString, paramImageView, (c)localObject);
      AppMethodBeat.o(66184);
      return;
    }
    if (paramInt != 0) {
      paramImageView.setImageResource(paramInt);
    }
    AppMethodBeat.o(66184);
  }
  
  public static void ehv()
  {
    AppMethodBeat.i(66182);
    xk localxk = new xk();
    localxk.edE.edF = false;
    EventCenter.instance.publish(localxk);
    AppMethodBeat.o(66182);
  }
  
  public static void t(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(66183);
    d(paramImageView, paramString, 0);
    AppMethodBeat.o(66183);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.b.a
 * JD-Core Version:    0.7.0.1
 */