package com.tencent.mm.plugin.emoji;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.e;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.gif.MMWXGFJNI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.vfs.i;

public final class d
  implements c
{
  private static d oWy;
  
  public static int a(byte[] paramArrayOfByte, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(209783);
    long l = bs.Gn();
    String str = s.cp(paramArrayOfByte);
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
      j = ((b)g.ab(b.class)).a(b.a.qaX, 25);
      if (j < 0) {
        break label195;
      }
      paramInt1 = MMWXGFJNI.nativePic2WxamWithWH(str, paramArrayOfByte, k, i, j, paramInt1, paramInt2, paramInt3, paramInt4);
      if (i.aSp(paramString) <= 0L) {
        paramInt1 = -10;
      }
      if (paramInt1 == 0) {
        break label203;
      }
      h.wUl.dB(944, 0);
    }
    for (j = paramInt1;; j = paramInt1)
    {
      ac.i("MicroMsg.HevcHelperService", "pic2wxam %d, %d, %d, %d，%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Long.valueOf(i.aSp(paramString)), Long.valueOf(bs.aO(l)), i.k(paramString, true) });
      AppMethodBeat.o(209783);
      return j;
      label195:
      j = cbk();
      break;
      label203:
      h.wUl.dB(944, 2);
      h.wUl.n(944L, 3L, bs.aO(l));
    }
  }
  
  public static d cbg()
  {
    AppMethodBeat.i(104534);
    if (oWy == null) {
      oWy = new d();
    }
    d locald = oWy;
    AppMethodBeat.o(104534);
    return locald;
  }
  
  private static int cbk()
  {
    AppMethodBeat.i(104542);
    try
    {
      if (ax.isWifi(ai.getContext())) {
        i = bs.getInt(((a)g.ab(a.class)).ZY().getValue("CompressPicLevelForWifi"), 60);
      }
      for (;;)
      {
        i = Math.round(39.0F - i / 5.0F);
        AppMethodBeat.o(104542);
        return i;
        if (ax.is2G(ai.getContext())) {
          i = bs.getInt(((a)g.ab(a.class)).ZY().getValue("CompressPicLevelFor2G"), 40);
        } else if (ax.is3G(ai.getContext())) {
          i = bs.getInt(((a)g.ab(a.class)).ZY().getValue("CompressPicLevelFor3G"), 40);
        } else {
          i = bs.getInt(((a)g.ab(a.class)).ZY().getValue("CompressPicLevelFor4G"), 60);
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
  
  public final String Xx(String paramString)
  {
    AppMethodBeat.i(104536);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(104536);
      return paramString;
    }
    paramString = paramString + "_hevc";
    AppMethodBeat.o(104536);
    return paramString;
  }
  
  public final byte[] aU(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(104539);
    long l = bs.Gn();
    int j = MMWXGFJNI.getErrorCode();
    byte[] arrayOfByte = null;
    int k;
    if (j == 0)
    {
      arrayOfByte = MMWXGFJNI.nativeWxam2PicBuf(paramArrayOfByte);
      if (arrayOfByte == null) {
        h.wUl.dB(944, 1);
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
      ac.i("MicroMsg.HevcHelperService", "wxam2pic %d, %d, %d, %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i), Long.valueOf(bs.aO(l)) });
      AppMethodBeat.o(104539);
      return arrayOfByte;
      h.wUl.dB(944, 5);
      h.wUl.n(944L, 6L, bs.aO(l));
      break;
    }
  }
  
  public final boolean cbh()
  {
    AppMethodBeat.i(104535);
    int i = MMWXGFJNI.getErrorCode();
    ac.i("MicroMsg.HevcHelperService", "checkHevcReady: %s", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      AppMethodBeat.o(104535);
      return true;
    }
    AppMethodBeat.o(104535);
    return false;
  }
  
  public final boolean cbi()
  {
    AppMethodBeat.i(104540);
    boolean bool = ((b)g.ab(b.class)).a(b.a.pMb, false);
    ac.i("MicroMsg.HevcHelperService", "hevc upload %s", new Object[] { Boolean.valueOf(bool) });
    if ((cbh()) && (bool))
    {
      AppMethodBeat.o(104540);
      return true;
    }
    AppMethodBeat.o(104540);
    return false;
  }
  
  public final boolean cbj()
  {
    AppMethodBeat.i(104541);
    boolean bool = ((b)g.ab(b.class)).a(b.a.pMc, false);
    ac.i("MicroMsg.HevcHelperService", "hevc download %s", new Object[] { Boolean.valueOf(bool) });
    if ((cbh()) && (bool))
    {
      AppMethodBeat.o(104541);
      return true;
    }
    AppMethodBeat.o(104541);
    return false;
  }
  
  public final int fi(String paramString1, String paramString2)
  {
    AppMethodBeat.i(104537);
    long l = bs.Gn();
    String str = s.aKF(paramString1);
    int j = 0;
    int i;
    if (".png".equals(str))
    {
      j = 1;
      int k = MMWXGFJNI.getErrorCode();
      i = k;
      if (k == 0)
      {
        i = MMWXGFJNI.nativePic2Wxam(paramString1, paramString2, j, cbk());
        if (i.aSp(paramString2) <= 0L) {
          i = -10;
        }
        if (i == 0) {
          break label163;
        }
        h.wUl.dB(944, 0);
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.HevcHelperService", "pic2wxam %d, %d, %d, %d, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(i.aSp(paramString1)), Long.valueOf(i.aSp(paramString2)), Long.valueOf(bs.aO(l)) });
      AppMethodBeat.o(104537);
      return i;
      if (!".gif".equals(str)) {
        break;
      }
      j = 3;
      break;
      label163:
      h.wUl.dB(944, 2);
      h.wUl.n(944L, 3L, bs.aO(l));
    }
  }
  
  public final int nativeWxam2Pic(String paramString1, String paramString2)
  {
    AppMethodBeat.i(104538);
    long l = bs.Gn();
    int j = MMWXGFJNI.getErrorCode();
    int i = j;
    if (j == 0)
    {
      i = MMWXGFJNI.nativeWxam2Pic(paramString1, paramString2);
      if (i.aSp(paramString2) <= 0L) {
        i = -10;
      }
      if (i == 0) {
        break label113;
      }
      h.wUl.dB(944, 1);
    }
    for (;;)
    {
      ac.i("MicroMsg.HevcHelperService", "wxam2pic %d, %d, %d, %d", new Object[] { Integer.valueOf(i), Long.valueOf(i.aSp(paramString1)), Long.valueOf(i.aSp(paramString2)), Long.valueOf(bs.aO(l)) });
      AppMethodBeat.o(104538);
      return i;
      label113:
      h.wUl.dB(944, 5);
      h.wUl.n(944L, 6L, bs.aO(l));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.d
 * JD-Core Version:    0.7.0.1
 */