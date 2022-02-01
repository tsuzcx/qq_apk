package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bd.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.storage.ai;
import junit.framework.Assert;

public final class f
  implements com.tencent.mm.ak.g
{
  i htV;
  c huk;
  l hul;
  boolean hum;
  boolean hun;
  boolean huo;
  bd hup;
  
  public f()
  {
    AppMethodBeat.i(150274);
    this.htV = null;
    this.huk = null;
    this.hul = null;
    this.hum = false;
    this.hun = true;
    this.huo = true;
    this.hup = null;
    com.tencent.mm.kernel.g.agi().a(158, this);
    AppMethodBeat.o(150274);
  }
  
  private int a(i parami)
  {
    AppMethodBeat.i(150278);
    if ((this.hup == null) || (this.hup.eVH())) {
      this.hup = new bd(1, "get-hd-headimg", 1);
    }
    int i = this.hup.c(new f.b(this, parami));
    AppMethodBeat.o(150278);
    return i;
  }
  
  public final int a(String paramString, c paramc)
  {
    AppMethodBeat.i(150276);
    Assert.assertTrue("GetHDHeadImg must set callback", true);
    if (bs.isNullOrNil(paramString))
    {
      paramc.dd(3, -101);
      AppMethodBeat.o(150276);
      return -101;
    }
    this.huk = paramc;
    if (ai.ww(paramString)) {}
    for (String str = ai.aNh(paramString);; str = paramString)
    {
      this.htV = p.aBw().Ak(str);
      ac.d("MicroMsg.GetHDHeadImgHelper", "GetHDHeadImg: %s", new Object[] { str });
      if ((this.htV == null) || (!this.htV.getUsername().equals(str)))
      {
        this.htV = new i();
        this.htV.username = str;
      }
      if (bs.isNullOrNil(this.htV.aBo()))
      {
        ac.w("MicroMsg.GetHDHeadImgHelper", "dkhurl [%s] has NO URL flag:%d !", new Object[] { paramString, Integer.valueOf(this.htV.exK) });
        this.hul = new l(str);
        if (!com.tencent.mm.kernel.g.agi().a(this.hul, 0))
        {
          paramc.dd(3, -102);
          AppMethodBeat.o(150276);
          return -102;
        }
        AppMethodBeat.o(150276);
        return 0;
      }
      if (a(this.htV) == 0)
      {
        AppMethodBeat.o(150276);
        return 0;
      }
      paramc.dd(3, -103);
      AppMethodBeat.o(150276);
      return -103;
    }
  }
  
  public final void aBl()
  {
    AppMethodBeat.i(150275);
    com.tencent.mm.kernel.g.agi().b(158, this);
    AppMethodBeat.o(150275);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(150277);
    this.huk.dd(paramInt1, paramInt2);
    AppMethodBeat.o(150277);
  }
  
  final class a
    implements bd.a
  {
    boolean aEZ = true;
    boolean bvV;
    boolean fWN = false;
    i htV;
    String huq;
    String hur;
    
    public a(i parami, String paramString1, String paramString2)
    {
      this.htV = parami;
      this.huq = paramString1;
      this.hur = paramString2;
      this.bvV = false;
    }
    
    public final boolean aBj()
    {
      AppMethodBeat.i(150269);
      Object localObject;
      String str1;
      String str2;
      if (this.bvV)
      {
        h.wUl.dB(138, 61);
        ac.i("MicroMsg.GetHDHeadImgHelper", "DecryptAvatar: decrypt %s", new Object[] { this.hur });
        localObject = UtilsJni.DecryptAvatar(com.tencent.mm.vfs.i.aU(this.hur, 0, -1));
        if ((localObject != null) && (localObject.length > 0))
        {
          com.tencent.mm.vfs.i.deleteFile(this.hur);
          com.tencent.mm.vfs.i.f(this.hur, (byte[])localObject, localObject.length);
        }
      }
      else
      {
        if (!s.aKE(this.hur)) {
          break label334;
        }
        this.fWN = true;
        ac.i("MicroMsg.GetHDHeadImgHelper", "DecryptAvatar: hevc to pic start");
        h.wUl.dB(138, 63);
        localObject = this.hur + "_hevc";
        boolean bool1 = com.tencent.mm.vfs.i.ma(this.hur, (String)localObject);
        boolean bool2 = com.tencent.mm.vfs.i.aSt(this.hur);
        str1 = com.tencent.mm.vfs.i.k(this.hur, true);
        str2 = com.tencent.mm.vfs.i.k((String)localObject, false);
        if ((str1 != null) && (str2 != null)) {
          break label281;
        }
        ac.i("MicroMsg.GetHDHeadImgHelper", "DecryptAvatar: uri is null %s, %s; path %s, %s; result %s, %s", new Object[] { str1, str2, this.hur, localObject, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        h.wUl.dB(138, 65);
        AppMethodBeat.o(150269);
        return true;
      }
      h.wUl.dB(138, 62);
      ac.i("MicroMsg.GetHDHeadImgHelper", "DecryptAvatar: decrypt failed");
      AppMethodBeat.o(150269);
      return true;
      label281:
      int i = ((c)com.tencent.mm.kernel.g.ab(c.class)).nativeWxam2Pic(str2, str1);
      com.tencent.mm.vfs.i.deleteFile((String)localObject);
      if (i != 0)
      {
        h.wUl.dB(138, 64);
        ac.i("MicroMsg.GetHDHeadImgHelper", "DecryptAvatar: hevc to pic failed");
        AppMethodBeat.o(150269);
        return true;
      }
      label334:
      this.aEZ = false;
      AppMethodBeat.o(150269);
      return true;
    }
    
    public final boolean aBk()
    {
      AppMethodBeat.i(150270);
      if (f.this.hum)
      {
        AppMethodBeat.o(150270);
        return false;
      }
      if (this.aEZ)
      {
        if ((this.fWN) && (f.this.hun))
        {
          ac.i("MicroMsg.GetHDHeadImgHelper", "onPostExecute: first request hevc failed");
          f.this.hun = false;
          f.this.huo = false;
          f.this.hup.c(new f.b(f.this, this.htV));
        }
        for (;;)
        {
          AppMethodBeat.o(150270);
          return false;
          f.this.huk.dd(3, -1);
        }
      }
      com.tencent.mm.vfs.i.deleteFile(this.huq);
      com.tencent.mm.vfs.i.ma(this.hur, this.huq);
      l.aX(this.huq, this.htV.getUsername());
      f.this.huk.dd(0, 0);
      AppMethodBeat.o(150270);
      return true;
    }
  }
  
  public static abstract interface c
  {
    public abstract int dd(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aj.f
 * JD-Core Version:    0.7.0.1
 */