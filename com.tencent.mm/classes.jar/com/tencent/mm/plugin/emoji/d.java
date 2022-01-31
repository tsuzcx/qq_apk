package com.tencent.mm.plugin.emoji;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.gif.MMWXGFJNI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.y;

public final class d
  implements c
{
  private static d iUk;
  
  public static d aGv()
  {
    if (iUk == null) {
      iUk = new d();
    }
    return iUk;
  }
  
  private static int aGy()
  {
    try
    {
      if (aq.isWifi(ae.getContext())) {
        i = bk.getInt(((com.tencent.mm.plugin.zero.b.a)g.r(com.tencent.mm.plugin.zero.b.a.class)).AA().getValue("CompressPicLevelForWifi"), 60);
      }
      for (;;)
      {
        return Math.round(39.0F - i / 5.0F);
        if (aq.is2G(ae.getContext())) {
          i = bk.getInt(((com.tencent.mm.plugin.zero.b.a)g.r(com.tencent.mm.plugin.zero.b.a.class)).AA().getValue("CompressPicLevelFor2G"), 40);
        } else if (aq.is3G(ae.getContext())) {
          i = bk.getInt(((com.tencent.mm.plugin.zero.b.a)g.r(com.tencent.mm.plugin.zero.b.a.class)).AA().getValue("CompressPicLevelFor3G"), 40);
        } else {
          i = bk.getInt(((com.tencent.mm.plugin.zero.b.a)g.r(com.tencent.mm.plugin.zero.b.a.class)).AA().getValue("CompressPicLevelFor4G"), 60);
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
  
  public final String Ah(String paramString)
  {
    if (bk.bl(paramString)) {
      return paramString;
    }
    return paramString + "_hevc";
  }
  
  public final boolean aGw()
  {
    boolean bool = ((com.tencent.mm.plugin.expt.a.a)g.r(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.jId, false);
    y.i("MicroMsg.HevcHelperService", "hevc upload %s", new Object[] { Boolean.valueOf(bool) });
    return bool;
  }
  
  public final boolean aGx()
  {
    boolean bool = ((com.tencent.mm.plugin.expt.a.a)g.r(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.jIe, false);
    y.i("MicroMsg.HevcHelperService", "hevc download %s", new Object[] { Boolean.valueOf(bool) });
    return bool;
  }
  
  public final int cH(String paramString1, String paramString2)
  {
    long l = bk.UZ();
    String str = o.Zc(paramString1);
    int i = 0;
    int j;
    if (".png".equals(str))
    {
      i = 1;
      int k = MMWXGFJNI.getErrorCode();
      j = k;
      if (k == 0)
      {
        j = MMWXGFJNI.nativePic2Wxam(paramString1, paramString2, i, aGy());
        if (j == 0) {
          break label141;
        }
        h.nFQ.h(944L, 0L, 1L);
      }
    }
    for (;;)
    {
      y.i("MicroMsg.HevcHelperService", "pic2Wxam %d, %d, %d, %d, %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Long.valueOf(com.tencent.mm.vfs.e.aeQ(paramString1)), Long.valueOf(com.tencent.mm.vfs.e.aeQ(paramString2)), Long.valueOf(bk.cp(l)) });
      return j;
      if (!".gif".equals(str)) {
        break;
      }
      i = 3;
      break;
      label141:
      h.nFQ.h(944L, 2L, 1L);
      h.nFQ.h(944L, 3L, bk.cp(l));
    }
  }
  
  public final int nativeWxam2Pic(String paramString1, String paramString2)
  {
    long l = bk.UZ();
    int j = MMWXGFJNI.getErrorCode();
    int i = j;
    if (j == 0)
    {
      i = MMWXGFJNI.nativeWxam2Pic(paramString1, paramString2);
      if (i == 0) {
        break label90;
      }
      h.nFQ.h(944L, 1L, 1L);
    }
    for (;;)
    {
      y.i("MicroMsg.HevcHelperService", "pic2Wxam %d, %d, %d, %d", new Object[] { Integer.valueOf(i), Long.valueOf(com.tencent.mm.vfs.e.aeQ(paramString1)), Long.valueOf(com.tencent.mm.vfs.e.aeQ(paramString2)), Long.valueOf(bk.cp(l)) });
      return i;
      label90:
      h.nFQ.h(944L, 5L, 1L);
      h.nFQ.h(944L, 6L, bk.cp(l));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.d
 * JD-Core Version:    0.7.0.1
 */