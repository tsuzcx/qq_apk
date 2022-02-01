package com.tencent.mm.plugin.card.ui.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.ui.e.a;
import com.tencent.mm.protocal.protobuf.acg;
import com.tencent.mm.protocal.protobuf.ahk;
import com.tencent.mm.protocal.protobuf.ua;
import com.tencent.mm.protocal.protobuf.vb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public class a
  implements g
{
  private boolean tAA = false;
  private boolean tAB = false;
  private boolean tAC = false;
  private boolean tAD = false;
  private boolean tAE = false;
  private boolean tAF = false;
  private boolean tAG = false;
  private boolean tAH = false;
  private boolean tAI = false;
  private boolean tAJ = false;
  protected b tmU;
  protected MMActivity tmY;
  protected e.a tvQ;
  
  public a(MMActivity paramMMActivity)
  {
    this.tmY = paramMMActivity;
  }
  
  private boolean cJU()
  {
    AppMethodBeat.i(113625);
    if (!TextUtils.isEmpty(this.tmU.cGt().code))
    {
      AppMethodBeat.o(113625);
      return true;
    }
    AppMethodBeat.o(113625);
    return false;
  }
  
  private String getString(int paramInt)
  {
    AppMethodBeat.i(113622);
    String str = this.tmY.getString(paramInt);
    AppMethodBeat.o(113622);
    return str;
  }
  
  public final void a(b paramb, e.a parama)
  {
    AppMethodBeat.i(113620);
    this.tmU = paramb;
    this.tvQ = parama;
    cJX();
    AppMethodBeat.o(113620);
  }
  
  public final String cJR()
  {
    AppMethodBeat.i(113621);
    String str = "";
    if (!TextUtils.isEmpty(this.tmU.cGs().Sgm)) {
      str = this.tmU.cGs().Sgm;
    }
    for (;;)
    {
      AppMethodBeat.o(113621);
      return str;
      if (this.tmU.cGt().SdG == 0L) {
        str = getString(a.g.tlh);
      } else if (this.tmU.cGt().SdH == 0) {
        if (!TextUtils.isEmpty(this.tmU.cGs().oDU)) {
          str = this.tmU.cGs().oDU;
        } else {
          str = getString(a.g.tjA);
        }
      }
    }
  }
  
  public final boolean cJS()
  {
    AppMethodBeat.i(113623);
    if ((this.tmU.cGt().status == 0) || (this.tmU.cGt().status == 1) || (this.tmU.cGt().status == 2))
    {
      AppMethodBeat.o(113623);
      return true;
    }
    AppMethodBeat.o(113623);
    return false;
  }
  
  public final boolean cJT()
  {
    AppMethodBeat.i(113624);
    if ((this.tvQ.jaR == 3) || ((this.tvQ.jaR == 6) && (this.tmU.cGt().SdD == 0)) || (this.tvQ.jaR == 4) || (this.tvQ.jaR == 5) || (this.tvQ.jaR == 15))
    {
      AppMethodBeat.o(113624);
      return true;
    }
    AppMethodBeat.o(113624);
    return false;
  }
  
  protected final boolean cJV()
  {
    AppMethodBeat.i(113626);
    if ((!this.tmU.cGo()) && ((l.Ii(this.tvQ.jaR)) || (l.Ij(this.tvQ.jaR)) || (this.tvQ.jaR == 23)))
    {
      AppMethodBeat.o(113626);
      return true;
    }
    AppMethodBeat.o(113626);
    return false;
  }
  
  protected final boolean cJW()
  {
    AppMethodBeat.i(113627);
    if ((!this.tmU.cGp()) && (this.tvQ.jaR == 6))
    {
      AppMethodBeat.o(113627);
      return true;
    }
    AppMethodBeat.o(113627);
    return false;
  }
  
  protected void cJX()
  {
    AppMethodBeat.i(113628);
    Log.i("MicroMsg.CardBaseShowLogic", "updateAcceptState()");
    if ((l.Ii(this.tvQ.jaR)) || (l.Ij(this.tvQ.jaR))) {
      if (this.tmU.cGo())
      {
        this.tAB = true;
        this.tAC = true;
        this.tAH = true;
        this.tAF = true;
        this.tAG = true;
        if (!this.tmU.cGm()) {
          break label567;
        }
        this.tAB = false;
        this.tAC = false;
        Log.i("MicroMsg.CardBaseShowLogic", "need direct jump!");
        label104:
        if (!this.tAA) {
          break label577;
        }
        this.tAB = false;
        this.tAC = false;
        Log.i("MicroMsg.CardBaseShowLogic", "updateAcceptView to gone!");
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.CardBaseShowLogic", "mIsAcceptedCard:" + this.tAA);
      AppMethodBeat.o(113628);
      return;
      if (!this.tmU.cGo())
      {
        this.tAB = true;
        this.tAC = false;
        if (this.tmU.cGm())
        {
          this.tAI = true;
          this.tAF = true;
          this.tAE = true;
        }
        for (;;)
        {
          this.tAG = true;
          break;
          this.tAF = false;
        }
      }
      this.tAB = false;
      this.tAC = false;
      this.tAF = false;
      break;
      if (this.tvQ.jaR == 6)
      {
        if (this.tmU.cGp())
        {
          this.tAB = true;
          this.tAC = true;
          this.tAF = false;
          break;
        }
        if (this.tmU.cGn())
        {
          this.tAI = true;
          this.tAF = true;
          this.tAD = true;
          this.tAE = true;
          break;
        }
        this.tAB = false;
        this.tAC = false;
        this.tAF = false;
        this.tAD = true;
        break;
      }
      if (l.Ik(this.tvQ.jaR))
      {
        this.tAB = false;
        this.tAC = false;
        this.tAD = true;
        if (this.tmU.cGn())
        {
          this.tAI = true;
          this.tAF = true;
          this.tAE = true;
          break;
        }
        this.tAJ = true;
        break;
      }
      if (this.tvQ.jaR != 23) {
        break;
      }
      if (this.tmU.cGo())
      {
        this.tAB = true;
        this.tAC = true;
        this.tAF = false;
      }
      for (this.tAG = true;; this.tAG = true)
      {
        if ((TextUtils.isEmpty(this.tvQ.tuY)) || (this.tvQ.tuY.equals(z.bcZ())) || (this.tmU.cGr())) {
          break label565;
        }
        Log.i("MicroMsg.CardBaseShowLogic", " detail page");
        this.tAB = false;
        this.tAC = false;
        this.tAD = true;
        if (!this.tmU.cGn()) {
          break;
        }
        this.tAI = true;
        this.tAF = true;
        this.tAE = true;
        break;
        this.tAB = true;
        this.tAC = false;
        this.tAF = false;
      }
      label565:
      break;
      label567:
      Log.i("MicroMsg.CardBaseShowLogic", "not need direct jump!");
      break label104;
      label577:
      if (!this.tAB)
      {
        this.tAA = true;
        Log.i("MicroMsg.CardBaseShowLogic", "set mIsAcceptedCard is true");
      }
      else
      {
        this.tAA = false;
        Log.i("MicroMsg.CardBaseShowLogic", "set mIsAcceptedCard is false!");
      }
    }
  }
  
  public boolean cJY()
  {
    return this.tAB;
  }
  
  public final boolean cJZ()
  {
    return this.tAC;
  }
  
  public final boolean cJq()
  {
    return this.tAA;
  }
  
  public final boolean cKa()
  {
    return this.tAD;
  }
  
  public final boolean cKb()
  {
    return this.tAE;
  }
  
  public final boolean cKc()
  {
    return this.tAF;
  }
  
  public final boolean cKd()
  {
    return this.tAG;
  }
  
  public final boolean cKe()
  {
    return this.tAH;
  }
  
  public final boolean cKf()
  {
    return this.tAI;
  }
  
  public final boolean cKg()
  {
    return this.tAJ;
  }
  
  public boolean cKh()
  {
    return true;
  }
  
  public boolean cKi()
  {
    return false;
  }
  
  public boolean cKj()
  {
    return false;
  }
  
  public boolean cKk()
  {
    AppMethodBeat.i(113629);
    if (((this.tvQ.jaR == 6) && ((!this.tmU.cGn()) || (this.tmU.cGp()))) || (this.tvQ.jaR == 5) || ((this.tvQ.jaR == 23) && (this.tmU.cGr())))
    {
      AppMethodBeat.o(113629);
      return true;
    }
    AppMethodBeat.o(113629);
    return false;
  }
  
  public boolean cKl()
  {
    return false;
  }
  
  public boolean cKm()
  {
    return true;
  }
  
  public boolean cKn()
  {
    AppMethodBeat.i(113630);
    if (((cJU()) && (cJS()) && (cJT())) || (this.tAA))
    {
      AppMethodBeat.o(113630);
      return true;
    }
    AppMethodBeat.o(113630);
    return false;
  }
  
  public boolean cKo()
  {
    return false;
  }
  
  public boolean cKp()
  {
    AppMethodBeat.i(113631);
    if (!this.tmU.cGn())
    {
      AppMethodBeat.o(113631);
      return true;
    }
    AppMethodBeat.o(113631);
    return false;
  }
  
  public boolean cKq()
  {
    AppMethodBeat.i(113632);
    if ((this.tmU.cGs().Sgg != null) && (this.tmU.cGs().Sgg.SrZ != null) && (this.tmU.cGs().Sgg.SrZ.size() > 0) && (!TextUtils.isEmpty((CharSequence)this.tmU.cGs().Sgg.SrZ.get(0))))
    {
      AppMethodBeat.o(113632);
      return true;
    }
    AppMethodBeat.o(113632);
    return false;
  }
  
  public boolean cKr()
  {
    AppMethodBeat.i(113633);
    if ((this.tmU.cGt().SdF != null) && (this.tmU.cGt().SdF.size() > 0) && (((cJS()) && (cJT())) || (this.tAA)))
    {
      AppMethodBeat.o(113633);
      return true;
    }
    AppMethodBeat.o(113633);
    return false;
  }
  
  public boolean cKs()
  {
    return false;
  }
  
  public final boolean cKt()
  {
    AppMethodBeat.i(113634);
    if ((this.tmU.cGt().SdJ != null) && (!TextUtils.isEmpty(this.tmU.cGt().SdJ.title)))
    {
      AppMethodBeat.o(113634);
      return true;
    }
    AppMethodBeat.o(113634);
    return false;
  }
  
  public boolean cKu()
  {
    AppMethodBeat.i(113635);
    if ((this.tmU.cGt().SdM != null) && (!TextUtils.isEmpty(this.tmU.cGt().SdM.title)))
    {
      AppMethodBeat.o(113635);
      return true;
    }
    AppMethodBeat.o(113635);
    return false;
  }
  
  public boolean cKv()
  {
    AppMethodBeat.i(113636);
    if (this.tmU.cGs().Sgc != null)
    {
      AppMethodBeat.o(113636);
      return true;
    }
    AppMethodBeat.o(113636);
    return false;
  }
  
  public boolean cKw()
  {
    AppMethodBeat.i(113637);
    if (!TextUtils.isEmpty(this.tmU.cGs().SfZ))
    {
      AppMethodBeat.o(113637);
      return true;
    }
    AppMethodBeat.o(113637);
    return false;
  }
  
  public boolean cKx()
  {
    return false;
  }
  
  public boolean cKy()
  {
    return false;
  }
  
  public final void cKz()
  {
    int i6 = 1;
    AppMethodBeat.i(113638);
    int i;
    String str;
    int j;
    label33:
    int k;
    label42:
    int m;
    label52:
    int n;
    label62:
    int i1;
    label72:
    int i2;
    label82:
    int i3;
    label92:
    int i4;
    label102:
    int i5;
    if (cJU())
    {
      i = 1;
      str = cJR();
      if (!this.tAA) {
        break label240;
      }
      j = 1;
      if (!cJY()) {
        break label245;
      }
      k = 1;
      if (!this.tAC) {
        break label250;
      }
      m = 1;
      if (!this.tAD) {
        break label256;
      }
      n = 1;
      if (!this.tAE) {
        break label262;
      }
      i1 = 1;
      if (!this.tAF) {
        break label268;
      }
      i2 = 1;
      if (!this.tAG) {
        break label274;
      }
      i3 = 1;
      if (!this.tAH) {
        break label280;
      }
      i4 = 1;
      if (!this.tAI) {
        break label286;
      }
      i5 = 1;
      label112:
      if (!this.tAJ) {
        break label292;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.CardBaseShowLogic", "printStatus, isValidCode:%d, getUnacceptWording:%s, isAcceptedCard:%d, acceptViewVisible:%d, acceptViewEnabled:%d, isShowConsumedBtn:%d, isConsumedBtnEnabled:%d, enableOptionMenu:%d, isShareLogoVisible:%d, addShareMenu:%d, addMenu:%d, addInvalidCardMenu:%d ", new Object[] { Integer.valueOf(i), str, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6) });
      AppMethodBeat.o(113638);
      return;
      i = 0;
      break;
      label240:
      j = 0;
      break label33;
      label245:
      k = 0;
      break label42;
      label250:
      m = 0;
      break label52;
      label256:
      n = 0;
      break label62;
      label262:
      i1 = 0;
      break label72;
      label268:
      i2 = 0;
      break label82;
      label274:
      i3 = 0;
      break label92;
      label280:
      i4 = 0;
      break label102;
      label286:
      i5 = 0;
      break label112;
      label292:
      i6 = 0;
    }
  }
  
  public final void release()
  {
    this.tmU = null;
    this.tvQ = null;
    this.tmY = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.a.a
 * JD-Core Version:    0.7.0.1
 */