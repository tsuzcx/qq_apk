package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bf.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.storage.an;
import com.tencent.mm.vfs.o;
import junit.framework.Assert;

public final class f
  implements com.tencent.mm.ak.f
{
  bf hPA;
  i hPg;
  c hPv;
  l hPw;
  boolean hPx;
  boolean hPy;
  boolean hPz;
  
  public f()
  {
    AppMethodBeat.i(150274);
    this.hPg = null;
    this.hPv = null;
    this.hPw = null;
    this.hPx = false;
    this.hPy = true;
    this.hPz = true;
    this.hPA = null;
    com.tencent.mm.kernel.g.ajj().a(158, this);
    AppMethodBeat.o(150274);
  }
  
  private int a(i parami)
  {
    AppMethodBeat.i(150278);
    if ((this.hPA == null) || (this.hPA.fpj())) {
      this.hPA = new bf(1, "get-hd-headimg", 1);
    }
    int i = this.hPA.c(new f.b(this, parami));
    AppMethodBeat.o(150278);
    return i;
  }
  
  public final int a(String paramString, c paramc)
  {
    AppMethodBeat.i(150276);
    Assert.assertTrue("GetHDHeadImg must set callback", true);
    if (bu.isNullOrNil(paramString))
    {
      paramc.df(3, -101);
      AppMethodBeat.o(150276);
      return -101;
    }
    this.hPv = paramc;
    if (an.Ac(paramString)) {}
    for (String str = an.aUA(paramString);; str = paramString)
    {
      this.hPg = p.aEN().DL(str);
      ae.d("MicroMsg.GetHDHeadImgHelper", "GetHDHeadImg: %s", new Object[] { str });
      if ((this.hPg == null) || (!this.hPg.getUsername().equals(str)))
      {
        this.hPg = new i();
        this.hPg.username = str;
      }
      if (bu.isNullOrNil(this.hPg.aEG()))
      {
        ae.w("MicroMsg.GetHDHeadImgHelper", "dkhurl [%s] has NO URL flag:%d !", new Object[] { paramString, Integer.valueOf(this.hPg.eQU) });
        this.hPw = new l(str);
        if (!com.tencent.mm.kernel.g.ajj().a(this.hPw, 0))
        {
          paramc.df(3, -102);
          AppMethodBeat.o(150276);
          return -102;
        }
        AppMethodBeat.o(150276);
        return 0;
      }
      if (a(this.hPg) == 0)
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
    this.hPv.df(paramInt1, paramInt2);
    AppMethodBeat.o(150277);
  }
  
  public final void sN()
  {
    AppMethodBeat.i(150275);
    com.tencent.mm.kernel.g.ajj().b(158, this);
    AppMethodBeat.o(150275);
  }
  
  final class a
    implements bf.a
  {
    boolean aGQ = true;
    boolean bGj;
    boolean gsO = false;
    String hPB;
    String hPC;
    i hPg;
    
    public a(i parami, String paramString1, String paramString2)
    {
      this.hPg = parami;
      this.hPB = paramString1;
      this.hPC = paramString2;
      this.bGj = false;
    }
    
    public final boolean aEC()
    {
      AppMethodBeat.i(150269);
      Object localObject;
      String str1;
      String str2;
      if (this.bGj)
      {
        com.tencent.mm.plugin.report.service.g.yxI.dD(138, 61);
        ae.i("MicroMsg.GetHDHeadImgHelper", "DecryptAvatar: decrypt %s", new Object[] { this.hPC });
        localObject = UtilsJni.DecryptAvatar(o.bb(this.hPC, 0, -1));
        if ((localObject != null) && (localObject.length > 0))
        {
          o.deleteFile(this.hPC);
          o.f(this.hPC, (byte[])localObject, localObject.length);
        }
      }
      else
      {
        if (!u.aRH(this.hPC)) {
          break label334;
        }
        this.gsO = true;
        ae.i("MicroMsg.GetHDHeadImgHelper", "DecryptAvatar: hevc to pic start");
        com.tencent.mm.plugin.report.service.g.yxI.dD(138, 63);
        localObject = this.hPC + "_hevc";
        boolean bool1 = o.mG(this.hPC, (String)localObject);
        boolean bool2 = o.aZV(this.hPC);
        str1 = o.k(this.hPC, true);
        str2 = o.k((String)localObject, false);
        if ((str1 != null) && (str2 != null)) {
          break label281;
        }
        ae.i("MicroMsg.GetHDHeadImgHelper", "DecryptAvatar: uri is null %s, %s; path %s, %s; result %s, %s", new Object[] { str1, str2, this.hPC, localObject, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        com.tencent.mm.plugin.report.service.g.yxI.dD(138, 65);
        AppMethodBeat.o(150269);
        return true;
      }
      com.tencent.mm.plugin.report.service.g.yxI.dD(138, 62);
      ae.i("MicroMsg.GetHDHeadImgHelper", "DecryptAvatar: decrypt failed");
      AppMethodBeat.o(150269);
      return true;
      label281:
      int i = ((c)com.tencent.mm.kernel.g.ab(c.class)).nativeWxam2Pic(str2, str1);
      o.deleteFile((String)localObject);
      if (i != 0)
      {
        com.tencent.mm.plugin.report.service.g.yxI.dD(138, 64);
        ae.i("MicroMsg.GetHDHeadImgHelper", "DecryptAvatar: hevc to pic failed");
        AppMethodBeat.o(150269);
        return true;
      }
      label334:
      this.aGQ = false;
      AppMethodBeat.o(150269);
      return true;
    }
    
    public final boolean aED()
    {
      AppMethodBeat.i(150270);
      if (f.this.hPx)
      {
        AppMethodBeat.o(150270);
        return false;
      }
      if (this.aGQ)
      {
        if ((this.gsO) && (f.this.hPy))
        {
          ae.i("MicroMsg.GetHDHeadImgHelper", "onPostExecute: first request hevc failed");
          f.this.hPy = false;
          f.this.hPz = false;
          f.this.hPA.c(new f.b(f.this, this.hPg));
        }
        for (;;)
        {
          AppMethodBeat.o(150270);
          return false;
          f.this.hPv.df(3, -1);
        }
      }
      o.deleteFile(this.hPB);
      o.mG(this.hPC, this.hPB);
      l.aY(this.hPB, this.hPg.getUsername());
      f.this.hPv.df(0, 0);
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
 * Qualified Name:     com.tencent.mm.aj.f
 * JD-Core Version:    0.7.0.1
 */