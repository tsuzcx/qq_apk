package com.tencent.mm.plugin.location.ui.impl;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.platformtools.s.a;
import com.tencent.mm.platformtools.s.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.f;
import java.io.IOException;

public final class i
  implements s
{
  private String iconUrl;
  private s.b owu;
  
  public i(String paramString)
  {
    AppMethodBeat.i(56143);
    this.owu = new s.b()
    {
      public final Bitmap FC(String paramAnonymousString)
      {
        AppMethodBeat.i(56142);
        paramAnonymousString = f.decodeFile(paramAnonymousString, null);
        AppMethodBeat.o(56142);
        return paramAnonymousString;
      }
    };
    this.iconUrl = paramString;
    com.tencent.mm.kernel.g.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(56141);
        if (!com.tencent.mm.vfs.i.eA(i.cYe())) {
          com.tencent.mm.vfs.i.aSh(i.cYe());
        }
        AppMethodBeat.o(56141);
      }
    });
    AppMethodBeat.o(56143);
  }
  
  public static String cYe()
  {
    AppMethodBeat.i(56144);
    String str = b.aph() + "taxi_icon";
    AppMethodBeat.o(56144);
    return str;
  }
  
  public final Bitmap a(Bitmap paramBitmap, s.a parama, String paramString)
  {
    AppMethodBeat.i(56146);
    if (s.a.iuo == parama) {
      if ((paramBitmap != null) && (paramBitmap.getNinePatchChunk() != null))
      {
        ac.v("MicroMsg.TaxiWeappIconStrategy", "get ninePatch chChunk.");
        com.tencent.mm.vfs.i.lZ(paramString, aNl());
        AppMethodBeat.o(56146);
        return paramBitmap;
      }
    }
    try
    {
      f.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, aNl(), false);
      ac.d("MicroMsg.TaxiWeappIconStrategy", "get bitmap, from %s.", new Object[] { parama.toString() });
      AppMethodBeat.o(56146);
      return paramBitmap;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        try
        {
          com.tencent.mm.vfs.i.aSh(cYe());
          ac.w("MicroMsg.TaxiWeappIconStrategy", "retry saving bitmap.");
          f.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, aNl(), false);
        }
        catch (IOException paramString)
        {
          ac.printErrStackTrace("MicroMsg.TaxiWeappIconStrategy", paramString, "", new Object[0]);
          ac.w("MicroMsg.TaxiWeappIconStrategy", "save bitmap fail.");
        }
      }
    }
  }
  
  public final void a(s.a parama, String paramString) {}
  
  public final s.b aNk()
  {
    return this.owu;
  }
  
  public final String aNl()
  {
    AppMethodBeat.i(56145);
    String str = String.format("%s/%s", new Object[] { cYe(), com.tencent.mm.b.g.getMessageDigest(this.iconUrl.getBytes()) });
    AppMethodBeat.o(56145);
    return str;
  }
  
  public final String aNm()
  {
    return this.iconUrl;
  }
  
  public final String aNn()
  {
    return this.iconUrl;
  }
  
  public final boolean aNo()
  {
    return true;
  }
  
  public final boolean aNp()
  {
    return false;
  }
  
  public final Bitmap aNq()
  {
    return null;
  }
  
  public final void aNr() {}
  
  public final void aa(String paramString, boolean paramBoolean) {}
  
  public final String getCacheKey()
  {
    return this.iconUrl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.i
 * JD-Core Version:    0.7.0.1
 */