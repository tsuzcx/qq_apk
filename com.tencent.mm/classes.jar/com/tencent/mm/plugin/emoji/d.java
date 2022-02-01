package com.tencent.mm.plugin.emoji;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.n.e;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.gif.MMWXGFJNI;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.vfs.i;

public final class d
  implements c
{
  private static d pAi;
  
  public static int a(byte[] paramArrayOfByte, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(219020);
    long l = bt.HI();
    String str = t.cw(paramArrayOfByte);
    int i = 7;
    if (".gif".equals(str)) {
      i = 3;
    }
    int k = MMWXGFJNI.getErrorCode();
    int j = k;
    if (k == 0)
    {
      str = i.k(paramString, true);
      k = paramArrayOfByte.length;
      j = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qGw, 25);
      if (j < 0) {
        break label195;
      }
      paramInt1 = MMWXGFJNI.pic2WxamWithWH(str, paramArrayOfByte, k, i, j, paramInt1, paramInt2, paramInt3, paramInt4);
      if (i.aYo(paramString) <= 0L) {
        paramInt1 = -10;
      }
      if (paramInt1 == 0) {
        break label203;
      }
      com.tencent.mm.plugin.report.service.g.yhR.dD(944, 0);
    }
    for (j = paramInt1;; j = paramInt1)
    {
      ad.i("MicroMsg.HevcHelperService", "pic2wxam %d, %d, %d, %d，%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Long.valueOf(i.aYo(paramString)), Long.valueOf(bt.aO(l)), i.k(paramString, true) });
      AppMethodBeat.o(219020);
      return j;
      label195:
      j = cfO();
      break;
      label203:
      com.tencent.mm.plugin.report.service.g.yhR.dD(944, 2);
      com.tencent.mm.plugin.report.service.g.yhR.n(944L, 3L, bt.aO(l));
    }
  }
  
  public static d cfK()
  {
    AppMethodBeat.i(104534);
    if (pAi == null) {
      pAi = new d();
    }
    d locald = pAi;
    AppMethodBeat.o(104534);
    return locald;
  }
  
  private static int cfO()
  {
    AppMethodBeat.i(104542);
    try
    {
      if (ay.isWifi(aj.getContext())) {
        i = bt.getInt(((a)com.tencent.mm.kernel.g.ab(a.class)).acA().getValue("CompressPicLevelForWifi"), 60);
      }
      for (;;)
      {
        i = Math.round(39.0F - i / 5.0F);
        AppMethodBeat.o(104542);
        return i;
        if (ay.is2G(aj.getContext())) {
          i = bt.getInt(((a)com.tencent.mm.kernel.g.ab(a.class)).acA().getValue("CompressPicLevelFor2G"), 40);
        } else if (ay.is3G(aj.getContext())) {
          i = bt.getInt(((a)com.tencent.mm.kernel.g.ab(a.class)).acA().getValue("CompressPicLevelFor3G"), 40);
        } else {
          i = bt.getInt(((a)com.tencent.mm.kernel.g.ab(a.class)).acA().getValue("CompressPicLevelFor4G"), 60);
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
  
  public final byte[] aX(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(104539);
    long l = bt.HI();
    int j = MMWXGFJNI.getErrorCode();
    byte[] arrayOfByte = null;
    int k;
    if (j == 0)
    {
      arrayOfByte = MMWXGFJNI.nativeWxam2PicBuf(paramArrayOfByte);
      if (arrayOfByte == null) {
        com.tencent.mm.plugin.report.service.g.yhR.dD(944, 1);
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
      ad.i("MicroMsg.HevcHelperService", "wxam2pic %d, %d, %d, %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i), Long.valueOf(bt.aO(l)) });
      AppMethodBeat.o(104539);
      return arrayOfByte;
      com.tencent.mm.plugin.report.service.g.yhR.dD(944, 5);
      com.tencent.mm.plugin.report.service.g.yhR.n(944L, 6L, bt.aO(l));
      break;
    }
  }
  
  public final String abe(String paramString)
  {
    AppMethodBeat.i(104536);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(104536);
      return paramString;
    }
    paramString = paramString + "_hevc";
    AppMethodBeat.o(104536);
    return paramString;
  }
  
  public final boolean cfL()
  {
    AppMethodBeat.i(104535);
    int i = MMWXGFJNI.getErrorCode();
    ad.i("MicroMsg.HevcHelperService", "checkHevcReady: %s", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      AppMethodBeat.o(104535);
      return true;
    }
    AppMethodBeat.o(104535);
    return false;
  }
  
  public final boolean cfM()
  {
    AppMethodBeat.i(104540);
    boolean bool = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qpP, false);
    ad.i("MicroMsg.HevcHelperService", "hevc upload %s", new Object[] { Boolean.valueOf(bool) });
    if ((cfL()) && (bool))
    {
      AppMethodBeat.o(104540);
      return true;
    }
    AppMethodBeat.o(104540);
    return false;
  }
  
  public final boolean cfN()
  {
    AppMethodBeat.i(104541);
    boolean bool = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qpQ, false);
    ad.i("MicroMsg.HevcHelperService", "hevc download %s", new Object[] { Boolean.valueOf(bool) });
    if ((cfL()) && (bool))
    {
      AppMethodBeat.o(104541);
      return true;
    }
    AppMethodBeat.o(104541);
    return false;
  }
  
  public final int fs(String paramString1, String paramString2)
  {
    AppMethodBeat.i(104537);
    long l = bt.HI();
    String str = t.aQl(paramString1);
    int j = 0;
    int i;
    if (".png".equals(str))
    {
      j = 1;
      int k = MMWXGFJNI.getErrorCode();
      i = k;
      if (k == 0)
      {
        i = MMWXGFJNI.pic2Wxam(paramString1, paramString2, j, cfO());
        if (i.aYo(paramString2) <= 0L) {
          i = -10;
        }
        if (i == 0) {
          break label163;
        }
        com.tencent.mm.plugin.report.service.g.yhR.dD(944, 0);
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.HevcHelperService", "pic2wxam %d, %d, %d, %d, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(i.aYo(paramString1)), Long.valueOf(i.aYo(paramString2)), Long.valueOf(bt.aO(l)) });
      AppMethodBeat.o(104537);
      return i;
      if (!".gif".equals(str)) {
        break;
      }
      j = 3;
      break;
      label163:
      com.tencent.mm.plugin.report.service.g.yhR.dD(944, 2);
      com.tencent.mm.plugin.report.service.g.yhR.n(944L, 3L, bt.aO(l));
    }
  }
  
  public final int nativeWxam2Pic(String paramString1, String paramString2)
  {
    AppMethodBeat.i(104538);
    long l = bt.HI();
    int j = MMWXGFJNI.getErrorCode();
    int i = j;
    if (j == 0)
    {
      i = MMWXGFJNI.wxam2Pic(paramString1, paramString2);
      if (i.aYo(paramString2) <= 0L) {
        i = -10;
      }
      if (i == 0) {
        break label113;
      }
      com.tencent.mm.plugin.report.service.g.yhR.dD(944, 1);
    }
    for (;;)
    {
      ad.i("MicroMsg.HevcHelperService", "wxam2pic %d, %d, %d, %d", new Object[] { Integer.valueOf(i), Long.valueOf(i.aYo(paramString1)), Long.valueOf(i.aYo(paramString2)), Long.valueOf(bt.aO(l)) });
      AppMethodBeat.o(104538);
      return i;
      label113:
      com.tencent.mm.plugin.report.service.g.yhR.dD(944, 5);
      com.tencent.mm.plugin.report.service.g.yhR.n(944L, 6L, bt.aO(l));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.d
 * JD-Core Version:    0.7.0.1
 */