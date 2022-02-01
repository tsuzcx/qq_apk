package com.tencent.mm.ak;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.be.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.storage.am;
import junit.framework.Assert;

public final class f
  implements com.tencent.mm.al.f
{
  c hMC;
  l hMD;
  boolean hME;
  boolean hMF;
  boolean hMG;
  be hMH;
  i hMn;
  
  public f()
  {
    AppMethodBeat.i(150274);
    this.hMn = null;
    this.hMC = null;
    this.hMD = null;
    this.hME = false;
    this.hMF = true;
    this.hMG = true;
    this.hMH = null;
    com.tencent.mm.kernel.g.aiU().a(158, this);
    AppMethodBeat.o(150274);
  }
  
  private int a(i parami)
  {
    AppMethodBeat.i(150278);
    if ((this.hMH == null) || (this.hMH.flo())) {
      this.hMH = new be(1, "get-hd-headimg", 1);
    }
    int i = this.hMH.c(new f.b(this, parami));
    AppMethodBeat.o(150278);
    return i;
  }
  
  public final int a(String paramString, c paramc)
  {
    AppMethodBeat.i(150276);
    Assert.assertTrue("GetHDHeadImg must set callback", true);
    if (bt.isNullOrNil(paramString))
    {
      paramc.df(3, -101);
      AppMethodBeat.o(150276);
      return -101;
    }
    this.hMC = paramc;
    if (am.zs(paramString)) {}
    for (String str = am.aSZ(paramString);; str = paramString)
    {
      this.hMn = p.aEx().Dj(str);
      ad.d("MicroMsg.GetHDHeadImgHelper", "GetHDHeadImg: %s", new Object[] { str });
      if ((this.hMn == null) || (!this.hMn.getUsername().equals(str)))
      {
        this.hMn = new i();
        this.hMn.username = str;
      }
      if (bt.isNullOrNil(this.hMn.aEq()))
      {
        ad.w("MicroMsg.GetHDHeadImgHelper", "dkhurl [%s] has NO URL flag:%d !", new Object[] { paramString, Integer.valueOf(this.hMn.ePj) });
        this.hMD = new l(str);
        if (!com.tencent.mm.kernel.g.aiU().a(this.hMD, 0))
        {
          paramc.df(3, -102);
          AppMethodBeat.o(150276);
          return -102;
        }
        AppMethodBeat.o(150276);
        return 0;
      }
      if (a(this.hMn) == 0)
      {
        AppMethodBeat.o(150276);
        return 0;
      }
      paramc.df(3, -103);
      AppMethodBeat.o(150276);
      return -103;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(150277);
    this.hMC.df(paramInt1, paramInt2);
    AppMethodBeat.o(150277);
  }
  
  public final void sN()
  {
    AppMethodBeat.i(150275);
    com.tencent.mm.kernel.g.aiU().b(158, this);
    AppMethodBeat.o(150275);
  }
  
  final class a
    implements be.a
  {
    boolean aGQ = true;
    boolean bGj;
    boolean gqo = false;
    String hMI;
    String hMJ;
    i hMn;
    
    public a(i parami, String paramString1, String paramString2)
    {
      this.hMn = parami;
      this.hMI = paramString1;
      this.hMJ = paramString2;
      this.bGj = false;
    }
    
    public final boolean aEm()
    {
      AppMethodBeat.i(150269);
      Object localObject;
      String str1;
      String str2;
      if (this.bGj)
      {
        com.tencent.mm.plugin.report.service.g.yhR.dD(138, 61);
        ad.i("MicroMsg.GetHDHeadImgHelper", "DecryptAvatar: decrypt %s", new Object[] { this.hMJ });
        localObject = UtilsJni.DecryptAvatar(com.tencent.mm.vfs.i.aY(this.hMJ, 0, -1));
        if ((localObject != null) && (localObject.length > 0))
        {
          com.tencent.mm.vfs.i.deleteFile(this.hMJ);
          com.tencent.mm.vfs.i.f(this.hMJ, (byte[])localObject, localObject.length);
        }
      }
      else
      {
        if (!t.aQk(this.hMJ)) {
          break label334;
        }
        this.gqo = true;
        ad.i("MicroMsg.GetHDHeadImgHelper", "DecryptAvatar: hevc to pic start");
        com.tencent.mm.plugin.report.service.g.yhR.dD(138, 63);
        localObject = this.hMJ + "_hevc";
        boolean bool1 = com.tencent.mm.vfs.i.mA(this.hMJ, (String)localObject);
        boolean bool2 = com.tencent.mm.vfs.i.aYs(this.hMJ);
        str1 = com.tencent.mm.vfs.i.k(this.hMJ, true);
        str2 = com.tencent.mm.vfs.i.k((String)localObject, false);
        if ((str1 != null) && (str2 != null)) {
          break label281;
        }
        ad.i("MicroMsg.GetHDHeadImgHelper", "DecryptAvatar: uri is null %s, %s; path %s, %s; result %s, %s", new Object[] { str1, str2, this.hMJ, localObject, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        com.tencent.mm.plugin.report.service.g.yhR.dD(138, 65);
        AppMethodBeat.o(150269);
        return true;
      }
      com.tencent.mm.plugin.report.service.g.yhR.dD(138, 62);
      ad.i("MicroMsg.GetHDHeadImgHelper", "DecryptAvatar: decrypt failed");
      AppMethodBeat.o(150269);
      return true;
      label281:
      int i = ((c)com.tencent.mm.kernel.g.ab(c.class)).nativeWxam2Pic(str2, str1);
      com.tencent.mm.vfs.i.deleteFile((String)localObject);
      if (i != 0)
      {
        com.tencent.mm.plugin.report.service.g.yhR.dD(138, 64);
        ad.i("MicroMsg.GetHDHeadImgHelper", "DecryptAvatar: hevc to pic failed");
        AppMethodBeat.o(150269);
        return true;
      }
      label334:
      this.aGQ = false;
      AppMethodBeat.o(150269);
      return true;
    }
    
    public final boolean aEn()
    {
      AppMethodBeat.i(150270);
      if (f.this.hME)
      {
        AppMethodBeat.o(150270);
        return false;
      }
      if (this.aGQ)
      {
        if ((this.gqo) && (f.this.hMF))
        {
          ad.i("MicroMsg.GetHDHeadImgHelper", "onPostExecute: first request hevc failed");
          f.this.hMF = false;
          f.this.hMG = false;
          f.this.hMH.c(new f.b(f.this, this.hMn));
        }
        for (;;)
        {
          AppMethodBeat.o(150270);
          return false;
          f.this.hMC.df(3, -1);
        }
      }
      com.tencent.mm.vfs.i.deleteFile(this.hMI);
      com.tencent.mm.vfs.i.mA(this.hMJ, this.hMI);
      l.aY(this.hMI, this.hMn.getUsername());
      f.this.hMC.df(0, 0);
      AppMethodBeat.o(150270);
      return true;
    }
  }
  
  public static abstract interface c
  {
    public abstract int df(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ak.f
 * JD-Core Version:    0.7.0.1
 */