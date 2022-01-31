package com.tencent.mm.plugin.ext.c;

import android.content.Context;
import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.d.a.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

public class e
{
  public static e jLg = null;
  public Context mContext = null;
  
  public static void M(String paramString, int paramInt1, int paramInt2)
  {
    h.nFQ.f(14869, new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public static void N(String paramString, int paramInt1, int paramInt2)
  {
    h.nFQ.f(14868, new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public static d.b aA(String paramString, boolean paramBoolean)
  {
    return d.aNK().az(paramString, paramBoolean);
  }
  
  public static e aNL()
  {
    if (jLg == null) {
      try
      {
        if (jLg == null) {
          jLg = new e();
        }
        e locale = jLg;
        return locale;
      }
      finally {}
    }
    return jLg;
  }
  
  public static Cursor aNM()
  {
    y.i("MicroMsg.ExtQrCodeHandler", "hy: release temp mapping");
    c.clearCache();
    return a.DA(1);
  }
  
  public static ah aNN()
  {
    return new ah(Looper.getMainLooper());
  }
  
  public final e.a a(d.b paramb)
  {
    long l = System.currentTimeMillis();
    e.a locala = (e.a)new e.1(this, new e.a(), paramb).b(aNN());
    if (locala != null) {}
    for (paramb = locala.toString();; paramb = "null")
    {
      y.i("MicroMsg.ExtQrCodeHandler", "hy: resolved qrcode: %s, using: %d ms", new Object[] { paramb, Long.valueOf(System.currentTimeMillis() - l) });
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.c.e
 * JD-Core Version:    0.7.0.1
 */