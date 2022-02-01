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
import java.io.IOException;

public final class i
  implements s
{
  private String iconUrl;
  private s.b oZP;
  
  public i(String paramString)
  {
    AppMethodBeat.i(56143);
    this.oZP = new s.b()
    {
      public final Bitmap IR(String paramAnonymousString)
      {
        AppMethodBeat.i(56142);
        paramAnonymousString = com.tencent.mm.sdk.platformtools.g.decodeFile(paramAnonymousString, null);
        AppMethodBeat.o(56142);
        return paramAnonymousString;
      }
    };
    this.iconUrl = paramString;
    com.tencent.mm.kernel.g.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(56141);
        if (!com.tencent.mm.vfs.i.fv(i.dhq())) {
          com.tencent.mm.vfs.i.aYg(i.dhq());
        }
        AppMethodBeat.o(56141);
      }
    });
    AppMethodBeat.o(56143);
  }
  
  public static String dhq()
  {
    AppMethodBeat.i(56144);
    String str = b.arU() + "taxi_icon";
    AppMethodBeat.o(56144);
    return str;
  }
  
  public final Bitmap a(Bitmap paramBitmap, s.a parama, String paramString)
  {
    AppMethodBeat.i(56146);
    if (s.a.iNr == parama) {
      if ((paramBitmap != null) && (paramBitmap.getNinePatchChunk() != null))
      {
        ad.v("MicroMsg.TaxiWeappIconStrategy", "get ninePatch chChunk.");
        com.tencent.mm.vfs.i.mz(paramString, aQw());
        AppMethodBeat.o(56146);
        return paramBitmap;
      }
    }
    try
    {
      com.tencent.mm.sdk.platformtools.g.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, aQw(), false);
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
          com.tencent.mm.vfs.i.aYg(dhq());
          ad.w("MicroMsg.TaxiWeappIconStrategy", "retry saving bitmap.");
          com.tencent.mm.sdk.platformtools.g.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, aQw(), false);
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
  
  public final boolean aQA()
  {
    return false;
  }
  
  public final Bitmap aQB()
  {
    return null;
  }
  
  public final void aQC() {}
  
  public final s.b aQv()
  {
    return this.oZP;
  }
  
  public final String aQw()
  {
    AppMethodBeat.i(56145);
    String str = String.format("%s/%s", new Object[] { dhq(), com.tencent.mm.b.g.getMessageDigest(this.iconUrl.getBytes()) });
    AppMethodBeat.o(56145);
    return str;
  }
  
  public final String aQx()
  {
    return this.iconUrl;
  }
  
  public final String aQy()
  {
    return this.iconUrl;
  }
  
  public final boolean aQz()
  {
    return true;
  }
  
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