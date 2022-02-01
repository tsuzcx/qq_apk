package com.tencent.mm.plugin.emoji;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.gif.MMWXGFJNI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

public final class e
  implements c
{
  private static e qWy;
  
  public static int a(byte[] paramArrayOfByte, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(199780);
    long l = Util.currentTicks();
    paramString1 = ImgUtil.identifyImgType(paramString1);
    int i = 7;
    if (".gif".equals(paramString1)) {
      i = 3;
    }
    int k = MMWXGFJNI.getErrorCode();
    int j = k;
    if (k == 0)
    {
      paramString1 = s.k(paramString2, true);
      k = paramArrayOfByte.length;
      j = ((b)g.af(b.class)).a(b.a.sle, 25);
      if (j < 0) {
        break label192;
      }
      paramInt1 = MMWXGFJNI.pic2WxamWithWH(paramString1, paramArrayOfByte, k, i, j, paramInt1, paramInt2, paramInt3, paramInt4);
      if (s.boW(paramString2) <= 0L) {
        paramInt1 = -10;
      }
      if (paramInt1 == 0) {
        break label200;
      }
      h.CyF.dN(944, 0);
    }
    for (j = paramInt1;; j = paramInt1)
    {
      Log.i("MicroMsg.HevcHelperService", "pic2wxam %d, %d, %d, %d，%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Long.valueOf(s.boW(paramString2)), Long.valueOf(Util.ticksToNow(l)), s.k(paramString2, true) });
      AppMethodBeat.o(199780);
      return j;
      label192:
      j = cEQ();
      break;
      label200:
      h.CyF.dN(944, 2);
      h.CyF.n(944L, 3L, Util.ticksToNow(l));
    }
  }
  
  public static e cEM()
  {
    AppMethodBeat.i(104534);
    if (qWy == null) {
      qWy = new e();
    }
    e locale = qWy;
    AppMethodBeat.o(104534);
    return locale;
  }
  
  private static int cEQ()
  {
    AppMethodBeat.i(104542);
    try
    {
      if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
        i = Util.getInt(((a)g.af(a.class)).aqJ().getValue("CompressPicLevelForWifi"), 60);
      }
      for (;;)
      {
        i = Math.round(39.0F - i / 5.0F);
        AppMethodBeat.o(104542);
        return i;
        if (NetStatusUtil.is2G(MMApplicationContext.getContext())) {
          i = Util.getInt(((a)g.af(a.class)).aqJ().getValue("CompressPicLevelFor2G"), 40);
        } else if (NetStatusUtil.is3G(MMApplicationContext.getContext())) {
          i = Util.getInt(((a)g.af(a.class)).aqJ().getValue("CompressPicLevelFor3G"), 40);
        } else {
          i = Util.getInt(((a)g.af(a.class)).aqJ().getValue("CompressPicLevelFor4G"), 60);
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
  
  public final String alX(String paramString)
  {
    AppMethodBeat.i(104536);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(104536);
      return paramString;
    }
    paramString = paramString + "_hevc";
    AppMethodBeat.o(104536);
    return paramString;
  }
  
  public final byte[] bn(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(104539);
    long l = Util.currentTicks();
    int j = MMWXGFJNI.getErrorCode();
    byte[] arrayOfByte = null;
    int k;
    if (j == 0)
    {
      arrayOfByte = MMWXGFJNI.nativeWxam2PicBuf(paramArrayOfByte);
      if (arrayOfByte == null) {
        h.CyF.dN(944, 1);
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
      Log.i("MicroMsg.HevcHelperService", "wxam2pic %d, %d, %d, %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i), Long.valueOf(Util.ticksToNow(l)) });
      AppMethodBeat.o(104539);
      return arrayOfByte;
      h.CyF.dN(944, 5);
      h.CyF.n(944L, 6L, Util.ticksToNow(l));
      break;
    }
  }
  
  public final boolean cEN()
  {
    AppMethodBeat.i(104535);
    int i = MMWXGFJNI.getErrorCode();
    Log.i("MicroMsg.HevcHelperService", "checkHevcReady: %s", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      AppMethodBeat.o(104535);
      return true;
    }
    AppMethodBeat.o(104535);
    return false;
  }
  
  public final boolean cEO()
  {
    AppMethodBeat.i(104540);
    boolean bool = ((b)g.af(b.class)).a(b.a.rOh, false);
    Log.i("MicroMsg.HevcHelperService", "hevc upload %s", new Object[] { Boolean.valueOf(bool) });
    if ((cEN()) && (bool))
    {
      AppMethodBeat.o(104540);
      return true;
    }
    AppMethodBeat.o(104540);
    return false;
  }
  
  public final boolean cEP()
  {
    AppMethodBeat.i(104541);
    boolean bool = ((b)g.af(b.class)).a(b.a.rOi, false);
    Log.i("MicroMsg.HevcHelperService", "hevc download %s", new Object[] { Boolean.valueOf(bool) });
    if ((cEN()) && (bool))
    {
      AppMethodBeat.o(104541);
      return true;
    }
    AppMethodBeat.o(104541);
    return false;
  }
  
  public final int fO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(104537);
    long l = Util.currentTicks();
    String str = ImgUtil.identifyImgType(paramString1);
    int j = 0;
    int i;
    if (".png".equals(str))
    {
      j = 1;
      int k = MMWXGFJNI.getErrorCode();
      i = k;
      if (k == 0)
      {
        i = MMWXGFJNI.pic2Wxam(s.k(paramString1, false), s.k(paramString2, true), j, cEQ());
        if (s.boW(paramString2) <= 0L) {
          i = -10;
        }
        if (i == 0) {
          break label170;
        }
        h.CyF.dN(944, 0);
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.HevcHelperService", "pic2wxam %d, %d, %d, %d, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(s.boW(paramString1)), Long.valueOf(s.boW(paramString2)), Long.valueOf(Util.ticksToNow(l)) });
      AppMethodBeat.o(104537);
      return i;
      if (!".gif".equals(str)) {
        break;
      }
      j = 3;
      break;
      label170:
      h.CyF.dN(944, 2);
      h.CyF.n(944L, 3L, Util.ticksToNow(l));
    }
  }
  
  public final int nativeWxam2Pic(String paramString1, String paramString2)
  {
    AppMethodBeat.i(104538);
    long l = Util.currentTicks();
    int j = MMWXGFJNI.getErrorCode();
    int i = j;
    if (j == 0)
    {
      i = MMWXGFJNI.wxam2Pic(s.k(paramString1, false), s.k(paramString2, true));
      if (s.boW(paramString2) <= 0L) {
        i = -10;
      }
      if (i == 0) {
        break label121;
      }
      h.CyF.dN(944, 1);
    }
    for (;;)
    {
      Log.i("MicroMsg.HevcHelperService", "wxam2pic %d, %d, %d, %d", new Object[] { Integer.valueOf(i), Long.valueOf(s.boW(paramString1)), Long.valueOf(s.boW(paramString2)), Long.valueOf(Util.ticksToNow(l)) });
      AppMethodBeat.o(104538);
      return i;
      label121:
      h.CyF.dN(944, 5);
      h.CyF.n(944L, 6L, Util.ticksToNow(l));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e
 * JD-Core Version:    0.7.0.1
 */