package com.tencent.mm.ah;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import junit.framework.Assert;

public final class e
  implements f
{
  h frB;
  e.c frP;
  k frQ;
  boolean frR;
  boolean frS;
  boolean frT;
  az frU;
  
  public e()
  {
    AppMethodBeat.i(77910);
    this.frB = null;
    this.frP = null;
    this.frQ = null;
    this.frR = false;
    this.frS = true;
    this.frT = true;
    this.frU = null;
    g.Rc().a(158, this);
    AppMethodBeat.o(77910);
  }
  
  private int a(h paramh)
  {
    AppMethodBeat.i(77914);
    if ((this.frU == null) || (this.frU.dtw())) {
      this.frU = new az(1, "get-hd-headimg", 1);
    }
    int i = this.frU.e(new e.b(this, paramh));
    AppMethodBeat.o(77914);
    return i;
  }
  
  public final int a(String paramString, e.c paramc)
  {
    AppMethodBeat.i(77912);
    Assert.assertTrue("GetHDHeadImg must set callback", true);
    if (bo.isNullOrNil(paramString))
    {
      paramc.cv(3, -101);
      AppMethodBeat.o(77912);
      return -101;
    }
    this.frP = paramc;
    if (ad.nM(paramString)) {}
    for (String str = ad.ark(paramString);; str = paramString)
    {
      this.frB = o.adg().rj(str);
      ab.d("MicroMsg.GetHDHeadImgHelper", "GetHDHeadImg: %s", new Object[] { str });
      if ((this.frB == null) || (!this.frB.getUsername().equals(str)))
      {
        this.frB = new h();
        this.frB.username = str;
      }
      if (bo.isNullOrNil(this.frB.acX()))
      {
        ab.w("MicroMsg.GetHDHeadImgHelper", "dkhurl [%s] has NO URL flag:%d !", new Object[] { paramString, Integer.valueOf(this.frB.dqB) });
        this.frQ = new k(str);
        if (!g.Rc().a(this.frQ, 0))
        {
          paramc.cv(3, -102);
          AppMethodBeat.o(77912);
          return -102;
        }
        AppMethodBeat.o(77912);
        return 0;
      }
      if (a(this.frB) == 0)
      {
        AppMethodBeat.o(77912);
        return 0;
      }
      paramc.cv(3, -103);
      AppMethodBeat.o(77912);
      return -103;
    }
  }
  
  public final void acU()
  {
    AppMethodBeat.i(77911);
    g.Rc().b(158, this);
    AppMethodBeat.o(77911);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(77913);
    this.frP.cv(paramInt1, paramInt2);
    AppMethodBeat.o(77913);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ah.e
 * JD-Core Version:    0.7.0.1
 */