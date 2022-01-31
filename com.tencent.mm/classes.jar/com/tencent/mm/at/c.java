package com.tencent.mm.at;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cache.f.a;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

public final class c
{
  private HashMap<String, c.c> fDy;
  
  public c()
  {
    AppMethodBeat.i(78167);
    this.fDy = new HashMap();
    AppMethodBeat.o(78167);
  }
  
  public static void h(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(78169);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ab.e("MicroMsg.CdnImageService", "push fail, key is null");
      AppMethodBeat.o(78169);
      return;
    }
    f.a.a("local_cdn_img_cache", paramString, paramBitmap);
    AppMethodBeat.o(78169);
  }
  
  public static Bitmap lK(String paramString)
  {
    AppMethodBeat.i(78170);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ab.e("MicroMsg.CdnImageService", "get fail, key is null");
      AppMethodBeat.o(78170);
      return null;
    }
    paramString = (Bitmap)f.a.M("local_cdn_img_cache", paramString);
    AppMethodBeat.o(78170);
    return paramString;
  }
  
  public final void a(String paramString, c.c paramc)
  {
    AppMethodBeat.i(78172);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.CdnImageService", "do load fail, url is empty");
      AppMethodBeat.o(78172);
      return;
    }
    Bitmap localBitmap = lK(paramString);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      ab.i("MicroMsg.CdnImageService", "do load ok, url[%s], bitmap exists", new Object[] { paramString });
      if (paramc != null) {
        paramc.B(localBitmap);
      }
      AppMethodBeat.o(78172);
      return;
    }
    if (localBitmap == null) {}
    for (boolean bool = true;; bool = false)
    {
      ab.w("MicroMsg.CdnImageService", "try to download: url[%s], src bitmap is null[%B]", new Object[] { paramString, Boolean.valueOf(bool) });
      if (!this.fDy.containsKey(paramString)) {
        break;
      }
      ab.w("MicroMsg.CdnImageService", "contains url[%s]", new Object[] { paramString });
      AppMethodBeat.o(78172);
      return;
    }
    this.fDy.put(paramString, paramc);
    d.post(new c.b(paramString, this.fDy), "CdnImageService_download");
    AppMethodBeat.o(78172);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(78168);
    super.finalize();
    AppMethodBeat.o(78168);
  }
  
  public final void sU(String paramString)
  {
    AppMethodBeat.i(78171);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.CdnImageService", "stop load fail, url is empty");
      AppMethodBeat.o(78171);
      return;
    }
    this.fDy.remove(paramString);
    AppMethodBeat.o(78171);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.at.c
 * JD-Core Version:    0.7.0.1
 */