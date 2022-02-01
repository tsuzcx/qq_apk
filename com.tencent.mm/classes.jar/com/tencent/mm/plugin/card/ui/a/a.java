package com.tencent.mm.plugin.card.ui.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.ui.e.a;
import com.tencent.mm.protocal.protobuf.aai;
import com.tencent.mm.protocal.protobuf.aeu;
import com.tencent.mm.protocal.protobuf.st;
import com.tencent.mm.protocal.protobuf.tu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public class a
  implements g
{
  protected b oDm;
  protected MMActivity oDq;
  protected e.a oMg;
  boolean oQP = false;
  private boolean oQQ = false;
  private boolean oQR = false;
  private boolean oQS = false;
  private boolean oQT = false;
  private boolean oQU = false;
  private boolean oQV = false;
  private boolean oQW = false;
  private boolean oQX = false;
  private boolean oQY = false;
  
  public a(MMActivity paramMMActivity)
  {
    this.oDq = paramMMActivity;
  }
  
  private boolean bYC()
  {
    AppMethodBeat.i(113625);
    if (!TextUtils.isEmpty(this.oDm.bVd().code))
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
    String str = this.oDq.getString(paramInt);
    AppMethodBeat.o(113622);
    return str;
  }
  
  public final void a(b paramb, e.a parama)
  {
    AppMethodBeat.i(113620);
    this.oDm = paramb;
    this.oMg = parama;
    bYF();
    AppMethodBeat.o(113620);
  }
  
  public final boolean bXY()
  {
    return this.oQP;
  }
  
  public final boolean bYA()
  {
    AppMethodBeat.i(113623);
    if ((this.oDm.bVd().status == 0) || (this.oDm.bVd().status == 1) || (this.oDm.bVd().status == 2))
    {
      AppMethodBeat.o(113623);
      return true;
    }
    AppMethodBeat.o(113623);
    return false;
  }
  
  public final boolean bYB()
  {
    AppMethodBeat.i(113624);
    if ((this.oMg.fRv == 3) || ((this.oMg.fRv == 6) && (this.oDm.bVd().GhN == 0)) || (this.oMg.fRv == 4) || (this.oMg.fRv == 5) || (this.oMg.fRv == 15))
    {
      AppMethodBeat.o(113624);
      return true;
    }
    AppMethodBeat.o(113624);
    return false;
  }
  
  protected final boolean bYD()
  {
    AppMethodBeat.i(113626);
    if ((!this.oDm.isAcceptable()) && ((l.AZ(this.oMg.fRv)) || (l.Ba(this.oMg.fRv)) || (this.oMg.fRv == 23)))
    {
      AppMethodBeat.o(113626);
      return true;
    }
    AppMethodBeat.o(113626);
    return false;
  }
  
  protected final boolean bYE()
  {
    AppMethodBeat.i(113627);
    if ((!this.oDm.bUZ()) && (this.oMg.fRv == 6))
    {
      AppMethodBeat.o(113627);
      return true;
    }
    AppMethodBeat.o(113627);
    return false;
  }
  
  protected void bYF()
  {
    AppMethodBeat.i(113628);
    ae.i("MicroMsg.CardBaseShowLogic", "updateAcceptState()");
    if ((l.AZ(this.oMg.fRv)) || (l.Ba(this.oMg.fRv))) {
      if (this.oDm.isAcceptable())
      {
        this.oQQ = true;
        this.oQR = true;
        this.oQW = true;
        this.oQU = true;
        this.oQV = true;
        if (!this.oDm.bUX()) {
          break label567;
        }
        this.oQQ = false;
        this.oQR = false;
        ae.i("MicroMsg.CardBaseShowLogic", "need direct jump!");
        label104:
        if (!this.oQP) {
          break label577;
        }
        this.oQQ = false;
        this.oQR = false;
        ae.i("MicroMsg.CardBaseShowLogic", "updateAcceptView to gone!");
      }
    }
    for (;;)
    {
      ae.i("MicroMsg.CardBaseShowLogic", "mIsAcceptedCard:" + this.oQP);
      AppMethodBeat.o(113628);
      return;
      if (!this.oDm.isAcceptable())
      {
        this.oQQ = true;
        this.oQR = false;
        if (this.oDm.bUX())
        {
          this.oQX = true;
          this.oQU = true;
          this.oQT = true;
        }
        for (;;)
        {
          this.oQV = true;
          break;
          this.oQU = false;
        }
      }
      this.oQQ = false;
      this.oQR = false;
      this.oQU = false;
      break;
      if (this.oMg.fRv == 6)
      {
        if (this.oDm.bUZ())
        {
          this.oQQ = true;
          this.oQR = true;
          this.oQU = false;
          break;
        }
        if (this.oDm.bUY())
        {
          this.oQX = true;
          this.oQU = true;
          this.oQS = true;
          this.oQT = true;
          break;
        }
        this.oQQ = false;
        this.oQR = false;
        this.oQU = false;
        this.oQS = true;
        break;
      }
      if (l.Bb(this.oMg.fRv))
      {
        this.oQQ = false;
        this.oQR = false;
        this.oQS = true;
        if (this.oDm.bUY())
        {
          this.oQX = true;
          this.oQU = true;
          this.oQT = true;
          break;
        }
        this.oQY = true;
        break;
      }
      if (this.oMg.fRv != 23) {
        break;
      }
      if (this.oDm.isAcceptable())
      {
        this.oQQ = true;
        this.oQR = true;
        this.oQU = false;
      }
      for (this.oQV = true;; this.oQV = true)
      {
        if ((TextUtils.isEmpty(this.oMg.oLo)) || (this.oMg.oLo.equals(v.aAC())) || (this.oDm.bVb())) {
          break label565;
        }
        ae.i("MicroMsg.CardBaseShowLogic", " detail page");
        this.oQQ = false;
        this.oQR = false;
        this.oQS = true;
        if (!this.oDm.bUY()) {
          break;
        }
        this.oQX = true;
        this.oQU = true;
        this.oQT = true;
        break;
        this.oQQ = true;
        this.oQR = false;
        this.oQU = false;
      }
      label565:
      break;
      label567:
      ae.i("MicroMsg.CardBaseShowLogic", "not need direct jump!");
      break label104;
      label577:
      if (!this.oQQ)
      {
        this.oQP = true;
        ae.i("MicroMsg.CardBaseShowLogic", "set mIsAcceptedCard is true");
      }
      else
      {
        this.oQP = false;
        ae.i("MicroMsg.CardBaseShowLogic", "set mIsAcceptedCard is false!");
      }
    }
  }
  
  public boolean bYG()
  {
    return this.oQQ;
  }
  
  public final boolean bYH()
  {
    return this.oQR;
  }
  
  public final boolean bYI()
  {
    return this.oQS;
  }
  
  public final boolean bYJ()
  {
    return this.oQT;
  }
  
  public final boolean bYK()
  {
    return this.oQU;
  }
  
  public final boolean bYL()
  {
    return this.oQW;
  }
  
  public final boolean bYM()
  {
    return this.oQX;
  }
  
  public final boolean bYN()
  {
    return this.oQY;
  }
  
  public boolean bYO()
  {
    return true;
  }
  
  public boolean bYP()
  {
    return false;
  }
  
  public boolean bYQ()
  {
    return false;
  }
  
  public boolean bYR()
  {
    AppMethodBeat.i(113629);
    if (((this.oMg.fRv == 6) && ((!this.oDm.bUY()) || (this.oDm.bUZ()))) || (this.oMg.fRv == 5) || ((this.oMg.fRv == 23) && (this.oDm.bVb())))
    {
      AppMethodBeat.o(113629);
      return true;
    }
    AppMethodBeat.o(113629);
    return false;
  }
  
  public boolean bYS()
  {
    return false;
  }
  
  public boolean bYT()
  {
    return true;
  }
  
  public boolean bYU()
  {
    AppMethodBeat.i(113630);
    if (((bYC()) && (bYA()) && (bYB())) || (this.oQP))
    {
      AppMethodBeat.o(113630);
      return true;
    }
    AppMethodBeat.o(113630);
    return false;
  }
  
  public boolean bYV()
  {
    return false;
  }
  
  public boolean bYW()
  {
    AppMethodBeat.i(113631);
    if (!this.oDm.bUY())
    {
      AppMethodBeat.o(113631);
      return true;
    }
    AppMethodBeat.o(113631);
    return false;
  }
  
  public boolean bYX()
  {
    AppMethodBeat.i(113632);
    if ((this.oDm.bVc().Gkp != null) && (this.oDm.bVc().Gkp.GuW != null) && (this.oDm.bVc().Gkp.GuW.size() > 0) && (!TextUtils.isEmpty((CharSequence)this.oDm.bVc().Gkp.GuW.get(0))))
    {
      AppMethodBeat.o(113632);
      return true;
    }
    AppMethodBeat.o(113632);
    return false;
  }
  
  public boolean bYY()
  {
    AppMethodBeat.i(113633);
    if ((this.oDm.bVd().GhP != null) && (this.oDm.bVd().GhP.size() > 0) && (((bYA()) && (bYB())) || (this.oQP)))
    {
      AppMethodBeat.o(113633);
      return true;
    }
    AppMethodBeat.o(113633);
    return false;
  }
  
  public boolean bYZ()
  {
    return false;
  }
  
  public final String bYz()
  {
    AppMethodBeat.i(113621);
    String str = "";
    if (!TextUtils.isEmpty(this.oDm.bVc().Gkv)) {
      str = this.oDm.bVc().Gkv;
    }
    for (;;)
    {
      AppMethodBeat.o(113621);
      return str;
      if (this.oDm.bVd().GhQ == 0L) {
        str = getString(2131756946);
      } else if (this.oDm.bVd().GhR == 0) {
        if (!TextUtils.isEmpty(this.oDm.bVc().kDk)) {
          str = this.oDm.bVc().kDk;
        } else {
          str = getString(2131756792);
        }
      }
    }
  }
  
  public final boolean bZa()
  {
    AppMethodBeat.i(113634);
    if ((this.oDm.bVd().GhT != null) && (!TextUtils.isEmpty(this.oDm.bVd().GhT.title)))
    {
      AppMethodBeat.o(113634);
      return true;
    }
    AppMethodBeat.o(113634);
    return false;
  }
  
  public boolean bZb()
  {
    AppMethodBeat.i(113635);
    if ((this.oDm.bVd().GhW != null) && (!TextUtils.isEmpty(this.oDm.bVd().GhW.title)))
    {
      AppMethodBeat.o(113635);
      return true;
    }
    AppMethodBeat.o(113635);
    return false;
  }
  
  public boolean bZc()
  {
    AppMethodBeat.i(113636);
    if (this.oDm.bVc().Gkl != null)
    {
      AppMethodBeat.o(113636);
      return true;
    }
    AppMethodBeat.o(113636);
    return false;
  }
  
  public boolean bZd()
  {
    AppMethodBeat.i(113637);
    if (!TextUtils.isEmpty(this.oDm.bVc().Gki))
    {
      AppMethodBeat.o(113637);
      return true;
    }
    AppMethodBeat.o(113637);
    return false;
  }
  
  public boolean bZe()
  {
    return false;
  }
  
  public boolean bZf()
  {
    return false;
  }
  
  public final void bZg()
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
    if (bYC())
    {
      i = 1;
      str = bYz();
      if (!this.oQP) {
        break label240;
      }
      j = 1;
      if (!bYG()) {
        break label245;
      }
      k = 1;
      if (!this.oQR) {
        break label250;
      }
      m = 1;
      if (!this.oQS) {
        break label256;
      }
      n = 1;
      if (!this.oQT) {
        break label262;
      }
      i1 = 1;
      if (!this.oQU) {
        break label268;
      }
      i2 = 1;
      if (!this.oQV) {
        break label274;
      }
      i3 = 1;
      if (!this.oQW) {
        break label280;
      }
      i4 = 1;
      if (!this.oQX) {
        break label286;
      }
      i5 = 1;
      label112:
      if (!this.oQY) {
        break label292;
      }
    }
    for (;;)
    {
      ae.i("MicroMsg.CardBaseShowLogic", "printStatus, isValidCode:%d, getUnacceptWording:%s, isAcceptedCard:%d, acceptViewVisible:%d, acceptViewEnabled:%d, isShowConsumedBtn:%d, isConsumedBtnEnabled:%d, enableOptionMenu:%d, isShareLogoVisible:%d, addShareMenu:%d, addMenu:%d, addInvalidCardMenu:%d ", new Object[] { Integer.valueOf(i), str, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6) });
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
    this.oDm = null;
    this.oMg = null;
    this.oDq = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.a.a
 * JD-Core Version:    0.7.0.1
 */