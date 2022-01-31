package com.tencent.mm.bc;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.v.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.j;
import java.io.File;

public final class c
{
  private static c fNr;
  private az fNs = null;
  
  public static c aiT()
  {
    AppMethodBeat.i(136864);
    if (fNr == null) {
      fNr = new c();
    }
    c localc = fNr;
    AppMethodBeat.o(136864);
    return localc;
  }
  
  public static String tU(String paramString)
  {
    AppMethodBeat.i(136865);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(136865);
      return null;
    }
    paramString = j.b(a.cgG(), "remark_", g.w((paramString + "ZnVjaw==").getBytes()), ".png", 1);
    AppMethodBeat.o(136865);
    return paramString;
  }
  
  public static boolean tV(String paramString)
  {
    AppMethodBeat.i(136866);
    String str = tU(paramString);
    ab.d("MicroMsg.RemarkImageStorage", "remove remark image: %s, path:%s", new Object[] { paramString, str });
    boolean bool = new File(str).exists();
    AppMethodBeat.o(136866);
    return bool;
  }
  
  public static boolean tW(String paramString)
  {
    AppMethodBeat.i(136867);
    String str = tU(paramString);
    ab.d("MicroMsg.RemarkImageStorage", "remove remark image: %s, path:%s", new Object[] { paramString, str });
    boolean bool = e.deleteFile(str);
    AppMethodBeat.o(136867);
    return bool;
  }
  
  public static Bitmap tX(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(136868);
    paramString = d.aA(tU(paramString), 0, 0);
    int i = j;
    if (paramString != null)
    {
      i = j;
      if (!paramString.isRecycled()) {
        i = 1;
      }
    }
    if (i != 0)
    {
      AppMethodBeat.o(136868);
      return paramString;
    }
    AppMethodBeat.o(136868);
    return null;
  }
  
  public final void a(String paramString1, String paramString2, c.a parama)
  {
    AppMethodBeat.i(136869);
    if ((!bo.isNullOrNil(paramString2)) && (!tV(paramString1)))
    {
      if ((this.fNs == null) || (this.fNs.dtw())) {
        this.fNs = new az(1, "download-remark-img", 1);
      }
      this.fNs.e(new c.b(this, paramString1, paramString2, parama));
    }
    AppMethodBeat.o(136869);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bc.c
 * JD-Core Version:    0.7.0.1
 */