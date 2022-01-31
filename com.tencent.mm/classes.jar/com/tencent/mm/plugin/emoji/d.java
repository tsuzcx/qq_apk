package com.tencent.mm.plugin.emoji;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.gif.MMWXGFJNI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.r;

public final class d
  implements c
{
  private static d ldo;
  
  public static d bkd()
  {
    AppMethodBeat.i(62307);
    if (ldo == null) {
      ldo = new d();
    }
    d locald = ldo;
    AppMethodBeat.o(62307);
    return locald;
  }
  
  private static int bkh()
  {
    AppMethodBeat.i(62314);
    try
    {
      if (at.isWifi(ah.getContext())) {
        i = bo.getInt(((com.tencent.mm.plugin.zero.b.a)g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getValue("CompressPicLevelForWifi"), 60);
      }
      for (;;)
      {
        i = Math.round(39.0F - i / 5.0F);
        AppMethodBeat.o(62314);
        return i;
        if (at.is2G(ah.getContext())) {
          i = bo.getInt(((com.tencent.mm.plugin.zero.b.a)g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getValue("CompressPicLevelFor2G"), 40);
        } else if (at.is3G(ah.getContext())) {
          i = bo.getInt(((com.tencent.mm.plugin.zero.b.a)g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getValue("CompressPicLevelFor3G"), 40);
        } else {
          i = bo.getInt(((com.tencent.mm.plugin.zero.b.a)g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getValue("CompressPicLevelFor4G"), 60);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = 60;
      }
    }
  }
  
  public final String Kf(String paramString)
  {
    AppMethodBeat.i(62308);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(62308);
      return paramString;
    }
    paramString = paramString + "_hevc";
    AppMethodBeat.o(62308);
    return paramString;
  }
  
  public final byte[] aF(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62311);
    long l = bo.yB();
    int j = MMWXGFJNI.getErrorCode();
    byte[] arrayOfByte = null;
    int k;
    if (j == 0)
    {
      arrayOfByte = MMWXGFJNI.nativeWxam2PicBuf(paramArrayOfByte);
      if (arrayOfByte == null) {
        h.qsU.cT(944, 1);
      }
    }
    else
    {
      k = paramArrayOfByte.length;
      if (arrayOfByte != null) {
        break label135;
      }
    }
    label135:
    for (int i = 0;; i = arrayOfByte.length)
    {
      ab.i("MicroMsg.HevcHelperService", "wxam2pic %d, %d, %d, %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i), Long.valueOf(bo.av(l)) });
      AppMethodBeat.o(62311);
      return arrayOfByte;
      h.qsU.cT(944, 5);
      h.qsU.j(944L, 6L, bo.av(l));
      break;
    }
  }
  
  public final boolean bke()
  {
    AppMethodBeat.i(138079);
    int i = MMWXGFJNI.getErrorCode();
    ab.i("MicroMsg.HevcHelperService", "checkHevcReady: %s", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      AppMethodBeat.o(138079);
      return true;
    }
    AppMethodBeat.o(138079);
    return false;
  }
  
  public final boolean bkf()
  {
    AppMethodBeat.i(62312);
    boolean bool = ((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lRB, false);
    ab.i("MicroMsg.HevcHelperService", "hevc upload %s", new Object[] { Boolean.valueOf(bool) });
    if ((bke()) && (bool))
    {
      AppMethodBeat.o(62312);
      return true;
    }
    AppMethodBeat.o(62312);
    return false;
  }
  
  public final boolean bkg()
  {
    AppMethodBeat.i(62313);
    boolean bool = ((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lRC, false);
    ab.i("MicroMsg.HevcHelperService", "hevc download %s", new Object[] { Boolean.valueOf(bool) });
    if ((bke()) && (bool))
    {
      AppMethodBeat.o(62313);
      return true;
    }
    AppMethodBeat.o(62313);
    return false;
  }
  
  public final int dI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(62309);
    long l = bo.yB();
    String str = r.apa(paramString1);
    int i = 0;
    int j;
    if (".png".equals(str))
    {
      i = 1;
      int k = MMWXGFJNI.getErrorCode();
      j = k;
      if (k == 0)
      {
        j = MMWXGFJNI.nativePic2Wxam(paramString1, paramString2, i, bkh());
        if (j == 0) {
          break label150;
        }
        h.qsU.cT(944, 0);
      }
    }
    for (;;)
    {
      ab.i("MicroMsg.HevcHelperService", "pic2wxam %d, %d, %d, %d, %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Long.valueOf(com.tencent.mm.vfs.e.avI(paramString1)), Long.valueOf(com.tencent.mm.vfs.e.avI(paramString2)), Long.valueOf(bo.av(l)) });
      AppMethodBeat.o(62309);
      return j;
      if (!".gif".equals(str)) {
        break;
      }
      i = 3;
      break;
      label150:
      h.qsU.cT(944, 2);
      h.qsU.j(944L, 3L, bo.av(l));
    }
  }
  
  public final int nativeWxam2Pic(String paramString1, String paramString2)
  {
    AppMethodBeat.i(62310);
    long l = bo.yB();
    int j = MMWXGFJNI.getErrorCode();
    int i = j;
    if (j == 0)
    {
      i = MMWXGFJNI.nativeWxam2Pic(paramString1, paramString2);
      if (i == 0) {
        break label99;
      }
      h.qsU.cT(944, 1);
    }
    for (;;)
    {
      ab.i("MicroMsg.HevcHelperService", "wxam2pic %d, %d, %d, %d", new Object[] { Integer.valueOf(i), Long.valueOf(com.tencent.mm.vfs.e.avI(paramString1)), Long.valueOf(com.tencent.mm.vfs.e.avI(paramString2)), Long.valueOf(bo.av(l)) });
      AppMethodBeat.o(62310);
      return i;
      label99:
      h.qsU.cT(944, 5);
      h.qsU.j(944L, 6L, bo.av(l));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.d
 * JD-Core Version:    0.7.0.1
 */