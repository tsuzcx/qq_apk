package com.tencent.mm.plugin.emoji;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.n.e;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.gif.MMWXGFJNI;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.vfs.o;

public final class d
  implements c
{
  private static d pGM;
  
  public static int a(byte[] paramArrayOfByte, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(188499);
    long l = bu.HQ();
    paramString1 = u.aRI(paramString1);
    int i = 7;
    if (".gif".equals(paramString1)) {
      i = 3;
    }
    int k = MMWXGFJNI.getErrorCode();
    int j = k;
    if (k == 0)
    {
      paramString1 = o.k(paramString2, true);
      k = paramArrayOfByte.length;
      j = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qOc, 25);
      if (j < 0) {
        break label192;
      }
      paramInt1 = MMWXGFJNI.pic2WxamWithWH(paramString1, paramArrayOfByte, k, i, j, paramInt1, paramInt2, paramInt3, paramInt4);
      if (o.aZR(paramString2) <= 0L) {
        paramInt1 = -10;
      }
      if (paramInt1 == 0) {
        break label200;
      }
      com.tencent.mm.plugin.report.service.g.yxI.dD(944, 0);
    }
    for (j = paramInt1;; j = paramInt1)
    {
      ae.i("MicroMsg.HevcHelperService", "pic2wxam %d, %d, %d, %d，%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Long.valueOf(o.aZR(paramString2)), Long.valueOf(bu.aO(l)), o.k(paramString2, true) });
      AppMethodBeat.o(188499);
      return j;
      label192:
      j = che();
      break;
      label200:
      com.tencent.mm.plugin.report.service.g.yxI.dD(944, 2);
      com.tencent.mm.plugin.report.service.g.yxI.n(944L, 3L, bu.aO(l));
    }
  }
  
  public static d cha()
  {
    AppMethodBeat.i(104534);
    if (pGM == null) {
      pGM = new d();
    }
    d locald = pGM;
    AppMethodBeat.o(104534);
    return locald;
  }
  
  private static int che()
  {
    AppMethodBeat.i(104542);
    try
    {
      if (az.isWifi(ak.getContext())) {
        i = bu.getInt(((a)com.tencent.mm.kernel.g.ab(a.class)).acL().getValue("CompressPicLevelForWifi"), 60);
      }
      for (;;)
      {
        i = Math.round(39.0F - i / 5.0F);
        AppMethodBeat.o(104542);
        return i;
        if (az.is2G(ak.getContext())) {
          i = bu.getInt(((a)com.tencent.mm.kernel.g.ab(a.class)).acL().getValue("CompressPicLevelFor2G"), 40);
        } else if (az.is3G(ak.getContext())) {
          i = bu.getInt(((a)com.tencent.mm.kernel.g.ab(a.class)).acL().getValue("CompressPicLevelFor3G"), 40);
        } else {
          i = bu.getInt(((a)com.tencent.mm.kernel.g.ab(a.class)).acL().getValue("CompressPicLevelFor4G"), 60);
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
  
  public final byte[] aW(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(104539);
    long l = bu.HQ();
    int j = MMWXGFJNI.getErrorCode();
    byte[] arrayOfByte = null;
    int k;
    if (j == 0)
    {
      arrayOfByte = MMWXGFJNI.nativeWxam2PicBuf(paramArrayOfByte);
      if (arrayOfByte == null) {
        com.tencent.mm.plugin.report.service.g.yxI.dD(944, 1);
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
      ae.i("MicroMsg.HevcHelperService", "wxam2pic %d, %d, %d, %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i), Long.valueOf(bu.aO(l)) });
      AppMethodBeat.o(104539);
      return arrayOfByte;
      com.tencent.mm.plugin.report.service.g.yxI.dD(944, 5);
      com.tencent.mm.plugin.report.service.g.yxI.n(944L, 6L, bu.aO(l));
      break;
    }
  }
  
  public final String abV(String paramString)
  {
    AppMethodBeat.i(104536);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(104536);
      return paramString;
    }
    paramString = paramString + "_hevc";
    AppMethodBeat.o(104536);
    return paramString;
  }
  
  public final boolean chb()
  {
    AppMethodBeat.i(104535);
    int i = MMWXGFJNI.getErrorCode();
    ae.i("MicroMsg.HevcHelperService", "checkHevcReady: %s", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      AppMethodBeat.o(104535);
      return true;
    }
    AppMethodBeat.o(104535);
    return false;
  }
  
  public final boolean chc()
  {
    AppMethodBeat.i(104540);
    boolean bool = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qww, false);
    ae.i("MicroMsg.HevcHelperService", "hevc upload %s", new Object[] { Boolean.valueOf(bool) });
    if ((chb()) && (bool))
    {
      AppMethodBeat.o(104540);
      return true;
    }
    AppMethodBeat.o(104540);
    return false;
  }
  
  public final boolean chd()
  {
    AppMethodBeat.i(104541);
    boolean bool = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qwx, false);
    ae.i("MicroMsg.HevcHelperService", "hevc download %s", new Object[] { Boolean.valueOf(bool) });
    if ((chb()) && (bool))
    {
      AppMethodBeat.o(104541);
      return true;
    }
    AppMethodBeat.o(104541);
    return false;
  }
  
  public final int fw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(104537);
    long l = bu.HQ();
    String str = u.aRI(paramString1);
    int j = 0;
    int i;
    if (".png".equals(str))
    {
      j = 1;
      int k = MMWXGFJNI.getErrorCode();
      i = k;
      if (k == 0)
      {
        i = MMWXGFJNI.pic2Wxam(paramString1, paramString2, j, che());
        if (o.aZR(paramString2) <= 0L) {
          i = -10;
        }
        if (i == 0) {
          break label162;
        }
        com.tencent.mm.plugin.report.service.g.yxI.dD(944, 0);
      }
    }
    for (;;)
    {
      ae.i("MicroMsg.HevcHelperService", "pic2wxam %d, %d, %d, %d, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(o.aZR(paramString1)), Long.valueOf(o.aZR(paramString2)), Long.valueOf(bu.aO(l)) });
      AppMethodBeat.o(104537);
      return i;
      if (!".gif".equals(str)) {
        break;
      }
      j = 3;
      break;
      label162:
      com.tencent.mm.plugin.report.service.g.yxI.dD(944, 2);
      com.tencent.mm.plugin.report.service.g.yxI.n(944L, 3L, bu.aO(l));
    }
  }
  
  public final int nativeWxam2Pic(String paramString1, String paramString2)
  {
    AppMethodBeat.i(104538);
    long l = bu.HQ();
    int j = MMWXGFJNI.getErrorCode();
    int i = j;
    if (j == 0)
    {
      i = MMWXGFJNI.wxam2Pic(paramString1, paramString2);
      if (o.aZR(paramString2) <= 0L) {
        i = -10;
      }
      if (i == 0) {
        break label113;
      }
      com.tencent.mm.plugin.report.service.g.yxI.dD(944, 1);
    }
    for (;;)
    {
      ae.i("MicroMsg.HevcHelperService", "wxam2pic %d, %d, %d, %d", new Object[] { Integer.valueOf(i), Long.valueOf(o.aZR(paramString1)), Long.valueOf(o.aZR(paramString2)), Long.valueOf(bu.aO(l)) });
      AppMethodBeat.o(104538);
      return i;
      label113:
      com.tencent.mm.plugin.report.service.g.yxI.dD(944, 5);
      com.tencent.mm.plugin.report.service.g.yxI.n(944L, 6L, bu.aO(l));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.d
 * JD-Core Version:    0.7.0.1
 */