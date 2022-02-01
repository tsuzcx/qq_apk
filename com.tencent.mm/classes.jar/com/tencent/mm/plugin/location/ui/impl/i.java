package com.tencent.mm.plugin.location.ui.impl;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.platformtools.s.a;
import com.tencent.mm.platformtools.s.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.f;
import java.io.IOException;

public final class i
  implements s
{
  private String iconUrl;
  private s.b nSZ;
  
  public i(String paramString)
  {
    AppMethodBeat.i(56143);
    this.nSZ = new s.b()
    {
      public final Bitmap By(String paramAnonymousString)
      {
        AppMethodBeat.i(56142);
        paramAnonymousString = f.decodeFile(paramAnonymousString, null);
        AppMethodBeat.o(56142);
        return paramAnonymousString;
      }
    };
    this.iconUrl = paramString;
    com.tencent.mm.kernel.g.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(56141);
        if (!com.tencent.mm.vfs.i.eK(i.cKz())) {
          com.tencent.mm.vfs.i.aMF(i.cKz());
        }
        AppMethodBeat.o(56141);
      }
    });
    AppMethodBeat.o(56143);
  }
  
  public static String cKz()
  {
    AppMethodBeat.i(56144);
    String str = b.aih() + "taxi_icon";
    AppMethodBeat.o(56144);
    return str;
  }
  
  public final void Z(String paramString, boolean paramBoolean) {}
  
  public final Bitmap a(Bitmap paramBitmap, s.a parama, String paramString)
  {
    AppMethodBeat.i(56146);
    if (s.a.hUk == parama) {
      if ((paramBitmap != null) && (paramBitmap.getNinePatchChunk() != null))
      {
        ad.v("MicroMsg.TaxiWeappIconStrategy", "get ninePatch chChunk.");
        com.tencent.mm.vfs.i.lC(paramString, aGy());
        AppMethodBeat.o(56146);
        return paramBitmap;
      }
    }
    try
    {
      f.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, aGy(), false);
      ad.d("MicroMsg.TaxiWeappIconStrategy", "get bitmap, from %s.", new Object[] { parama.toString() });
      AppMethodBeat.o(56146);
      return paramBitmap;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        try
        {
          com.tencent.mm.vfs.i.aMF(cKz());
          ad.w("MicroMsg.TaxiWeappIconStrategy", "retry saving bitmap.");
          f.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, aGy(), false);
        }
        catch (IOException paramString)
        {
          ad.printErrStackTrace("MicroMsg.TaxiWeappIconStrategy", paramString, "", new Object[0]);
          ad.w("MicroMsg.TaxiWeappIconStrategy", "save bitmap fail.");
        }
      }
    }
  }
  
  public final void a(s.a parama, String paramString) {}
  
  public final String aGA()
  {
    return this.iconUrl;
  }
  
  public final boolean aGB()
  {
    return true;
  }
  
  public final boolean aGC()
  {
    return false;
  }
  
  public final Bitmap aGD()
  {
    return null;
  }
  
  public final void aGE() {}
  
  public final s.b aGx()
  {
    return this.nSZ;
  }
  
  public final String aGy()
  {
    AppMethodBeat.i(56145);
    String str = String.format("%s/%s", new Object[] { cKz(), com.tencent.mm.b.g.getMessageDigest(this.iconUrl.getBytes()) });
    AppMethodBeat.o(56145);
    return str;
  }
  
  public final String aGz()
  {
    return this.iconUrl;
  }
  
  public final String getCacheKey()
  {
    return this.iconUrl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.i
 * JD-Core Version:    0.7.0.1
 */