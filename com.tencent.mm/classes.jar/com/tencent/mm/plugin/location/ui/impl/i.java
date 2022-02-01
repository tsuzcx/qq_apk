package com.tencent.mm.plugin.location.ui.impl;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.platformtools.s.a;
import com.tencent.mm.platformtools.s.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.io.IOException;

public final class i
  implements com.tencent.mm.platformtools.s
{
  private String iconUrl;
  private s.b qvE;
  
  public i(String paramString)
  {
    AppMethodBeat.i(56143);
    this.qvE = new s.b()
    {
      public final Bitmap So(String paramAnonymousString)
      {
        AppMethodBeat.i(56142);
        paramAnonymousString = BitmapUtil.decodeFile(paramAnonymousString, null);
        AppMethodBeat.o(56142);
        return paramAnonymousString;
      }
    };
    this.iconUrl = paramString;
    com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(56141);
        if (!com.tencent.mm.vfs.s.YS(i.eea())) {
          com.tencent.mm.vfs.s.boN(i.eea());
        }
        AppMethodBeat.o(56141);
      }
    });
    AppMethodBeat.o(56143);
  }
  
  public static String eea()
  {
    AppMethodBeat.i(56144);
    String str = b.aKJ() + "taxi_icon";
    AppMethodBeat.o(56144);
    return str;
  }
  
  public final Bitmap a(Bitmap paramBitmap, s.a parama, String paramString)
  {
    AppMethodBeat.i(56146);
    if (s.a.jNh == parama) {
      if ((paramBitmap != null) && (paramBitmap.getNinePatchChunk() != null))
      {
        Log.v("MicroMsg.TaxiWeappIconStrategy", "get ninePatch chChunk.");
        com.tencent.mm.vfs.s.nw(paramString, blA());
        AppMethodBeat.o(56146);
        return paramBitmap;
      }
    }
    try
    {
      BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.PNG, blA(), false);
      Log.d("MicroMsg.TaxiWeappIconStrategy", "get bitmap, from %s.", new Object[] { parama.toString() });
      AppMethodBeat.o(56146);
      return paramBitmap;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        try
        {
          com.tencent.mm.vfs.s.boN(eea());
          Log.w("MicroMsg.TaxiWeappIconStrategy", "retry saving bitmap.");
          BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.PNG, blA(), false);
        }
        catch (IOException paramString)
        {
          Log.printErrStackTrace("MicroMsg.TaxiWeappIconStrategy", paramString, "", new Object[0]);
          Log.w("MicroMsg.TaxiWeappIconStrategy", "save bitmap fail.");
        }
      }
    }
  }
  
  public final void a(s.a parama, String paramString) {}
  
  public final void ad(String paramString, boolean paramBoolean) {}
  
  public final String blA()
  {
    AppMethodBeat.i(56145);
    String str = String.format("%s/%s", new Object[] { eea(), com.tencent.mm.b.g.getMessageDigest(this.iconUrl.getBytes()) });
    AppMethodBeat.o(56145);
    return str;
  }
  
  public final String blB()
  {
    return this.iconUrl;
  }
  
  public final String blC()
  {
    return this.iconUrl;
  }
  
  public final boolean blD()
  {
    return true;
  }
  
  public final boolean blE()
  {
    return false;
  }
  
  public final Bitmap blF()
  {
    return null;
  }
  
  public final void blG() {}
  
  public final s.b blz()
  {
    return this.qvE;
  }
  
  public final String getCacheKey()
  {
    return this.iconUrl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.i
 * JD-Core Version:    0.7.0.1
 */