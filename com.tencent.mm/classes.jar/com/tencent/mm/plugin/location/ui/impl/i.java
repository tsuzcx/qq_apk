package com.tencent.mm.plugin.location.ui.impl;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.platformtools.p.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.vfs.y;
import java.io.IOException;

public final class i
  implements p
{
  private String iconUrl;
  private p.b wXZ;
  
  public i(String paramString)
  {
    AppMethodBeat.i(56143);
    this.wXZ = new p.b()
    {
      public final Bitmap Se(String paramAnonymousString)
      {
        AppMethodBeat.i(56142);
        paramAnonymousString = BitmapUtil.decodeFile(paramAnonymousString, null);
        AppMethodBeat.o(56142);
        return paramAnonymousString;
      }
    };
    this.iconUrl = paramString;
    h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(56141);
        if (!y.ZC(i.fVO())) {
          y.bDX(i.fVO());
        }
        AppMethodBeat.o(56141);
      }
    });
    AppMethodBeat.o(56143);
  }
  
  public static String fVO()
  {
    AppMethodBeat.i(56144);
    String str = b.bmz() + "taxi_icon";
    AppMethodBeat.o(56144);
    return str;
  }
  
  public final Bitmap a(Bitmap paramBitmap, p.a parama, String paramString)
  {
    AppMethodBeat.i(56146);
    if (p.a.pAS == parama) {
      if ((paramBitmap != null) && (paramBitmap.getNinePatchChunk() != null))
      {
        Log.v("MicroMsg.TaxiWeappIconStrategy", "get ninePatch chChunk.");
        y.O(paramString, bTC(), false);
        AppMethodBeat.o(56146);
        return paramBitmap;
      }
    }
    try
    {
      BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.PNG, bTC(), false);
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
          y.bDX(fVO());
          Log.w("MicroMsg.TaxiWeappIconStrategy", "retry saving bitmap.");
          BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.PNG, bTC(), false);
        }
        catch (IOException paramString)
        {
          Log.printErrStackTrace("MicroMsg.TaxiWeappIconStrategy", paramString, "", new Object[0]);
          Log.w("MicroMsg.TaxiWeappIconStrategy", "save bitmap fail.");
        }
      }
    }
  }
  
  public final void a(p.a parama) {}
  
  public final p.b bTB()
  {
    return this.wXZ;
  }
  
  public final String bTC()
  {
    AppMethodBeat.i(56145);
    String str = String.format("%s/%s", new Object[] { fVO(), g.getMessageDigest(this.iconUrl.getBytes()) });
    AppMethodBeat.o(56145);
    return str;
  }
  
  public final String bTD()
  {
    return this.iconUrl;
  }
  
  public final String bTE()
  {
    return this.iconUrl;
  }
  
  public final boolean bTF()
  {
    return true;
  }
  
  public final boolean bTG()
  {
    return false;
  }
  
  public final Bitmap bTH()
  {
    return null;
  }
  
  public final void bTI() {}
  
  public final void bTJ() {}
  
  public final String getCacheKey()
  {
    return this.iconUrl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.i
 * JD-Core Version:    0.7.0.1
 */