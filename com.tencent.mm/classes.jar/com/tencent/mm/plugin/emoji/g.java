package com.tencent.mm.plugin.emoji;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.gif.MMWXGFJNI;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;

public final class g
  implements c
{
  private static g uzm;
  
  public static int a(byte[] paramArrayOfByte, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(222813);
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
      paramString1 = u.n(paramString2, true);
      k = paramArrayOfByte.length;
      j = ((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vVH, 25);
      if (j < 0) {
        break label192;
      }
      paramInt1 = MMWXGFJNI.pic2WxamWithWH(paramString1, paramArrayOfByte, k, i, j, paramInt1, paramInt2, paramInt3, paramInt4);
      if (u.bBQ(paramString2) <= 0L) {
        paramInt1 = -10;
      }
      if (paramInt1 == 0) {
        break label200;
      }
      com.tencent.mm.plugin.report.service.h.IzE.el(944, 0);
    }
    for (j = paramInt1;; j = paramInt1)
    {
      Log.i("MicroMsg.HevcHelperService", "pic2wxam %d, %d, %d, %d，%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Long.valueOf(u.bBQ(paramString2)), Long.valueOf(Util.ticksToNow(l)), u.n(paramString2, true) });
      AppMethodBeat.o(222813);
      return j;
      label192:
      j = cTv();
      break;
      label200:
      com.tencent.mm.plugin.report.service.h.IzE.el(944, 2);
      com.tencent.mm.plugin.report.service.h.IzE.p(944L, 3L, Util.ticksToNow(l));
    }
  }
  
  public static g cTr()
  {
    AppMethodBeat.i(104534);
    if (uzm == null) {
      uzm = new g();
    }
    g localg = uzm;
    AppMethodBeat.o(104534);
    return localg;
  }
  
  private static int cTv()
  {
    AppMethodBeat.i(104542);
    try
    {
      if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
        i = Util.getInt(((a)com.tencent.mm.kernel.h.ae(a.class)).axc().getValue("CompressPicLevelForWifi"), 60);
      }
      for (;;)
      {
        i = Math.round(39.0F - i / 5.0F);
        AppMethodBeat.o(104542);
        return i;
        if (NetStatusUtil.is2G(MMApplicationContext.getContext())) {
          i = Util.getInt(((a)com.tencent.mm.kernel.h.ae(a.class)).axc().getValue("CompressPicLevelFor2G"), 40);
        } else if (NetStatusUtil.is3G(MMApplicationContext.getContext())) {
          i = Util.getInt(((a)com.tencent.mm.kernel.h.ae(a.class)).axc().getValue("CompressPicLevelFor3G"), 40);
        } else {
          i = Util.getInt(((a)com.tencent.mm.kernel.h.ae(a.class)).axc().getValue("CompressPicLevelFor4G"), 60);
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
  
  public final String atR(String paramString)
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
  
  public final byte[] bA(byte[] paramArrayOfByte)
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
        com.tencent.mm.plugin.report.service.h.IzE.el(944, 1);
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
      com.tencent.mm.plugin.report.service.h.IzE.el(944, 5);
      com.tencent.mm.plugin.report.service.h.IzE.p(944L, 6L, Util.ticksToNow(l));
      break;
    }
  }
  
  public final boolean cTs()
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
  
  public final boolean cTt()
  {
    AppMethodBeat.i(104540);
    boolean bool = ((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vub, false);
    Log.i("MicroMsg.HevcHelperService", "hevc upload %s", new Object[] { Boolean.valueOf(bool) });
    if ((cTs()) && (bool))
    {
      AppMethodBeat.o(104540);
      return true;
    }
    AppMethodBeat.o(104540);
    return false;
  }
  
  public final boolean cTu()
  {
    AppMethodBeat.i(104541);
    boolean bool = ((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vuc, false);
    Log.i("MicroMsg.HevcHelperService", "hevc download %s", new Object[] { Boolean.valueOf(bool) });
    if ((cTs()) && (bool))
    {
      AppMethodBeat.o(104541);
      return true;
    }
    AppMethodBeat.o(104541);
    return false;
  }
  
  public final int gb(String paramString1, String paramString2)
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
        i = MMWXGFJNI.pic2Wxam(u.n(paramString1, false), u.n(paramString2, true), j, cTv());
        if (u.bBQ(paramString2) <= 0L) {
          i = -10;
        }
        if (i == 0) {
          break label170;
        }
        com.tencent.mm.plugin.report.service.h.IzE.el(944, 0);
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.HevcHelperService", "pic2wxam %d, %d, %d, %d, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(u.bBQ(paramString1)), Long.valueOf(u.bBQ(paramString2)), Long.valueOf(Util.ticksToNow(l)) });
      AppMethodBeat.o(104537);
      return i;
      if (!".gif".equals(str)) {
        break;
      }
      j = 3;
      break;
      label170:
      com.tencent.mm.plugin.report.service.h.IzE.el(944, 2);
      com.tencent.mm.plugin.report.service.h.IzE.p(944L, 3L, Util.ticksToNow(l));
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
      i = MMWXGFJNI.wxam2Pic(u.n(paramString1, false), u.n(paramString2, true));
      if (u.bBQ(paramString2) <= 0L) {
        i = -10;
      }
      if (i == 0) {
        break label121;
      }
      com.tencent.mm.plugin.report.service.h.IzE.el(944, 1);
    }
    for (;;)
    {
      Log.i("MicroMsg.HevcHelperService", "wxam2pic %d, %d, %d, %d", new Object[] { Integer.valueOf(i), Long.valueOf(u.bBQ(paramString1)), Long.valueOf(u.bBQ(paramString2)), Long.valueOf(Util.ticksToNow(l)) });
      AppMethodBeat.o(104538);
      return i;
      label121:
      com.tencent.mm.plugin.report.service.h.IzE.el(944, 5);
      com.tencent.mm.plugin.report.service.h.IzE.p(944L, 6L, Util.ticksToNow(l));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.g
 * JD-Core Version:    0.7.0.1
 */