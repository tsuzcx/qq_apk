package com.tencent.mm.plugin.location.ui.impl;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.platformtools.s.a;
import com.tencent.mm.platformtools.s.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.vfs.o;
import java.io.IOException;

public final class i
  implements s
{
  private String iconUrl;
  private s.b pgt;
  
  public i(String paramString)
  {
    AppMethodBeat.i(56143);
    this.pgt = new s.b()
    {
      public final Bitmap Jq(String paramAnonymousString)
      {
        AppMethodBeat.i(56142);
        paramAnonymousString = h.decodeFile(paramAnonymousString, null);
        AppMethodBeat.o(56142);
        return paramAnonymousString;
      }
    };
    this.iconUrl = paramString;
    com.tencent.mm.kernel.g.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(56141);
        if (!o.fB(i.dkp())) {
          o.aZI(i.dkp());
        }
        AppMethodBeat.o(56141);
      }
    });
    AppMethodBeat.o(56143);
  }
  
  public static String dkp()
  {
    AppMethodBeat.i(56144);
    String str = b.asj() + "taxi_icon";
    AppMethodBeat.o(56144);
    return str;
  }
  
  public final Bitmap a(Bitmap paramBitmap, s.a parama, String paramString)
  {
    AppMethodBeat.i(56146);
    if (s.a.iQl == parama) {
      if ((paramBitmap != null) && (paramBitmap.getNinePatchChunk() != null))
      {
        ae.v("MicroMsg.TaxiWeappIconStrategy", "get ninePatch chChunk.");
        o.mF(paramString, aQV());
        AppMethodBeat.o(56146);
        return paramBitmap;
      }
    }
    try
    {
      h.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, aQV(), false);
      ae.d("MicroMsg.TaxiWeappIconStrategy", "get bitmap, from %s.", new Object[] { parama.toString() });
      AppMethodBeat.o(56146);
      return paramBitmap;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        try
        {
          o.aZI(dkp());
          ae.w("MicroMsg.TaxiWeappIconStrategy", "retry saving bitmap.");
          h.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, aQV(), false);
        }
        catch (IOException paramString)
        {
          ae.printErrStackTrace("MicroMsg.TaxiWeappIconStrategy", paramString, "", new Object[0]);
          ae.w("MicroMsg.TaxiWeappIconStrategy", "save bitmap fail.");
        }
      }
    }
  }
  
  public final void a(s.a parama, String paramString) {}
  
  public final s.b aQU()
  {
    return this.pgt;
  }
  
  public final String aQV()
  {
    AppMethodBeat.i(56145);
    String str = String.format("%s/%s", new Object[] { dkp(), com.tencent.mm.b.g.getMessageDigest(this.iconUrl.getBytes()) });
    AppMethodBeat.o(56145);
    return str;
  }
  
  public final String aQW()
  {
    return this.iconUrl;
  }
  
  public final String aQX()
  {
    return this.iconUrl;
  }
  
  public final boolean aQY()
  {
    return true;
  }
  
  public final boolean aQZ()
  {
    return false;
  }
  
  public final Bitmap aRa()
  {
    return null;
  }
  
  public final void aRb() {}
  
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