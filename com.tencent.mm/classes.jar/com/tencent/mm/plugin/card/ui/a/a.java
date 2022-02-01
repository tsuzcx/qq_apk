package com.tencent.mm.plugin.card.ui.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.ui.e.a;
import com.tencent.mm.protocal.protobuf.aaf;
import com.tencent.mm.protocal.protobuf.ael;
import com.tencent.mm.protocal.protobuf.sr;
import com.tencent.mm.protocal.protobuf.ts;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public class a
  implements g
{
  protected e.a oFE;
  boolean oKn = false;
  private boolean oKo = false;
  private boolean oKp = false;
  private boolean oKq = false;
  private boolean oKr = false;
  private boolean oKs = false;
  private boolean oKt = false;
  private boolean oKu = false;
  private boolean oKv = false;
  private boolean oKw = false;
  protected b owK;
  protected MMActivity owO;
  
  public a(MMActivity paramMMActivity)
  {
    this.owO = paramMMActivity;
  }
  
  private boolean bXn()
  {
    AppMethodBeat.i(113625);
    if (!TextUtils.isEmpty(this.owK.bTO().code))
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
    String str = this.owO.getString(paramInt);
    AppMethodBeat.o(113622);
    return str;
  }
  
  public final void a(b paramb, e.a parama)
  {
    AppMethodBeat.i(113620);
    this.owK = paramb;
    this.oFE = parama;
    bXq();
    AppMethodBeat.o(113620);
  }
  
  public final boolean bWJ()
  {
    return this.oKn;
  }
  
  public boolean bXA()
  {
    return false;
  }
  
  public boolean bXB()
  {
    return false;
  }
  
  public boolean bXC()
  {
    AppMethodBeat.i(113629);
    if (((this.oFE.fPp == 6) && ((!this.owK.bTJ()) || (this.owK.bTK()))) || (this.oFE.fPp == 5) || ((this.oFE.fPp == 23) && (this.owK.bTM())))
    {
      AppMethodBeat.o(113629);
      return true;
    }
    AppMethodBeat.o(113629);
    return false;
  }
  
  public boolean bXD()
  {
    return false;
  }
  
  public boolean bXE()
  {
    return true;
  }
  
  public boolean bXF()
  {
    AppMethodBeat.i(113630);
    if (((bXn()) && (bXl()) && (bXm())) || (this.oKn))
    {
      AppMethodBeat.o(113630);
      return true;
    }
    AppMethodBeat.o(113630);
    return false;
  }
  
  public boolean bXG()
  {
    return false;
  }
  
  public boolean bXH()
  {
    AppMethodBeat.i(113631);
    if (!this.owK.bTJ())
    {
      AppMethodBeat.o(113631);
      return true;
    }
    AppMethodBeat.o(113631);
    return false;
  }
  
  public boolean bXI()
  {
    AppMethodBeat.i(113632);
    if ((this.owK.bTN().FRQ != null) && (this.owK.bTN().FRQ.Gcp != null) && (this.owK.bTN().FRQ.Gcp.size() > 0) && (!TextUtils.isEmpty((CharSequence)this.owK.bTN().FRQ.Gcp.get(0))))
    {
      AppMethodBeat.o(113632);
      return true;
    }
    AppMethodBeat.o(113632);
    return false;
  }
  
  public boolean bXJ()
  {
    AppMethodBeat.i(113633);
    if ((this.owK.bTO().FPq != null) && (this.owK.bTO().FPq.size() > 0) && (((bXl()) && (bXm())) || (this.oKn)))
    {
      AppMethodBeat.o(113633);
      return true;
    }
    AppMethodBeat.o(113633);
    return false;
  }
  
  public boolean bXK()
  {
    return false;
  }
  
  public final boolean bXL()
  {
    AppMethodBeat.i(113634);
    if ((this.owK.bTO().FPu != null) && (!TextUtils.isEmpty(this.owK.bTO().FPu.title)))
    {
      AppMethodBeat.o(113634);
      return true;
    }
    AppMethodBeat.o(113634);
    return false;
  }
  
  public boolean bXM()
  {
    AppMethodBeat.i(113635);
    if ((this.owK.bTO().FPx != null) && (!TextUtils.isEmpty(this.owK.bTO().FPx.title)))
    {
      AppMethodBeat.o(113635);
      return true;
    }
    AppMethodBeat.o(113635);
    return false;
  }
  
  public boolean bXN()
  {
    AppMethodBeat.i(113636);
    if (this.owK.bTN().FRM != null)
    {
      AppMethodBeat.o(113636);
      return true;
    }
    AppMethodBeat.o(113636);
    return false;
  }
  
  public boolean bXO()
  {
    AppMethodBeat.i(113637);
    if (!TextUtils.isEmpty(this.owK.bTN().FRJ))
    {
      AppMethodBeat.o(113637);
      return true;
    }
    AppMethodBeat.o(113637);
    return false;
  }
  
  public boolean bXP()
  {
    return false;
  }
  
  public boolean bXQ()
  {
    return false;
  }
  
  public final void bXR()
  {
    int i6 = 1;
    AppMethodBeat.i(113638);
    int i;
    String str;
    int j;
    label32:
    int k;
    label41:
    int m;
    label51:
    int n;
    label61:
    int i1;
    label71:
    int i2;
    label81:
    int i3;
    label91:
    int i4;
    label101:
    int i5;
    if (bXn())
    {
      i = 1;
      str = bXk();
      if (!this.oKn) {
        break label237;
      }
      j = 1;
      if (!bXr()) {
        break label242;
      }
      k = 1;
      if (!this.oKp) {
        break label247;
      }
      m = 1;
      if (!this.oKq) {
        break label253;
      }
      n = 1;
      if (!this.oKr) {
        break label259;
      }
      i1 = 1;
      if (!this.oKs) {
        break label265;
      }
      i2 = 1;
      if (!this.oKt) {
        break label271;
      }
      i3 = 1;
      if (!this.oKu) {
        break label277;
      }
      i4 = 1;
      if (!this.oKv) {
        break label283;
      }
      i5 = 1;
      label111:
      if (!this.oKw) {
        break label289;
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.CardBaseShowLogic", "printStatus, isValidCode:%d, getUnacceptWording:%s, isAcceptedCard:%d, acceptViewVisible:%d, acceptViewEnabled:%d, isShowConsumedBtn:%d, isConsumedBtnEnabled:%d, enableOptionMenu:%d, isShareLogoVisible:%d, addShareMenu:%d, addMenu:%d, addInvalidCardMenu:%d ", new Object[] { Integer.valueOf(i), str, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6) });
      AppMethodBeat.o(113638);
      return;
      i = 0;
      break;
      label237:
      j = 0;
      break label32;
      label242:
      k = 0;
      break label41;
      label247:
      m = 0;
      break label51;
      label253:
      n = 0;
      break label61;
      label259:
      i1 = 0;
      break label71;
      label265:
      i2 = 0;
      break label81;
      label271:
      i3 = 0;
      break label91;
      label277:
      i4 = 0;
      break label101;
      label283:
      i5 = 0;
      break label111;
      label289:
      i6 = 0;
    }
  }
  
  public final String bXk()
  {
    AppMethodBeat.i(113621);
    String str = "";
    if (!TextUtils.isEmpty(this.owK.bTN().FRW)) {
      str = this.owK.bTN().FRW;
    }
    for (;;)
    {
      AppMethodBeat.o(113621);
      return str;
      if (this.owK.bTO().FPr == 0L) {
        str = getString(2131756946);
      } else if (this.owK.bTO().FPs == 0) {
        if (!TextUtils.isEmpty(this.owK.bTN().kzV)) {
          str = this.owK.bTN().kzV;
        } else {
          str = getString(2131756792);
        }
      }
    }
  }
  
  public final boolean bXl()
  {
    AppMethodBeat.i(113623);
    if ((this.owK.bTO().status == 0) || (this.owK.bTO().status == 1) || (this.owK.bTO().status == 2))
    {
      AppMethodBeat.o(113623);
      return true;
    }
    AppMethodBeat.o(113623);
    return false;
  }
  
  public final boolean bXm()
  {
    AppMethodBeat.i(113624);
    if ((this.oFE.fPp == 3) || ((this.oFE.fPp == 6) && (this.owK.bTO().FPo == 0)) || (this.oFE.fPp == 4) || (this.oFE.fPp == 5) || (this.oFE.fPp == 15))
    {
      AppMethodBeat.o(113624);
      return true;
    }
    AppMethodBeat.o(113624);
    return false;
  }
  
  protected final boolean bXo()
  {
    AppMethodBeat.i(113626);
    if ((!this.owK.isAcceptable()) && ((l.AN(this.oFE.fPp)) || (l.AO(this.oFE.fPp)) || (this.oFE.fPp == 23)))
    {
      AppMethodBeat.o(113626);
      return true;
    }
    AppMethodBeat.o(113626);
    return false;
  }
  
  protected final boolean bXp()
  {
    AppMethodBeat.i(113627);
    if ((!this.owK.bTK()) && (this.oFE.fPp == 6))
    {
      AppMethodBeat.o(113627);
      return true;
    }
    AppMethodBeat.o(113627);
    return false;
  }
  
  protected void bXq()
  {
    AppMethodBeat.i(113628);
    ad.i("MicroMsg.CardBaseShowLogic", "updateAcceptState()");
    if ((l.AN(this.oFE.fPp)) || (l.AO(this.oFE.fPp))) {
      if (this.owK.isAcceptable())
      {
        this.oKo = true;
        this.oKp = true;
        this.oKu = true;
        this.oKs = true;
        this.oKt = true;
        if (!this.owK.bTI()) {
          break label574;
        }
        this.oKo = false;
        this.oKp = false;
        ad.i("MicroMsg.CardBaseShowLogic", "need direct jump!");
        label107:
        if (!this.oKn) {
          break label585;
        }
        this.oKo = false;
        this.oKp = false;
        ad.i("MicroMsg.CardBaseShowLogic", "updateAcceptView to gone!");
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.CardBaseShowLogic", "mIsAcceptedCard:" + this.oKn);
      AppMethodBeat.o(113628);
      return;
      if (!this.owK.isAcceptable())
      {
        this.oKo = true;
        this.oKp = false;
        if (this.owK.bTI())
        {
          this.oKv = true;
          this.oKs = true;
          this.oKr = true;
        }
        for (;;)
        {
          this.oKt = true;
          break;
          this.oKs = false;
        }
      }
      this.oKo = false;
      this.oKp = false;
      this.oKs = false;
      break;
      if (this.oFE.fPp == 6)
      {
        if (this.owK.bTK())
        {
          this.oKo = true;
          this.oKp = true;
          this.oKs = false;
          break;
        }
        if (this.owK.bTJ())
        {
          this.oKv = true;
          this.oKs = true;
          this.oKq = true;
          this.oKr = true;
          break;
        }
        this.oKo = false;
        this.oKp = false;
        this.oKs = false;
        this.oKq = true;
        break;
      }
      if (l.AP(this.oFE.fPp))
      {
        this.oKo = false;
        this.oKp = false;
        this.oKq = true;
        if (this.owK.bTJ())
        {
          this.oKv = true;
          this.oKs = true;
          this.oKr = true;
          break;
        }
        this.oKw = true;
        break;
      }
      if (this.oFE.fPp != 23) {
        break;
      }
      if (this.owK.isAcceptable())
      {
        this.oKo = true;
        this.oKp = true;
        this.oKs = false;
      }
      for (this.oKt = true;; this.oKt = true)
      {
        if ((TextUtils.isEmpty(this.oFE.oEM)) || (this.oFE.oEM.equals(u.aAm())) || (this.owK.bTM())) {
          break label572;
        }
        ad.i("MicroMsg.CardBaseShowLogic", " detail page");
        this.oKo = false;
        this.oKp = false;
        this.oKq = true;
        if (!this.owK.bTJ()) {
          break;
        }
        this.oKv = true;
        this.oKs = true;
        this.oKr = true;
        break;
        this.oKo = true;
        this.oKp = false;
        this.oKs = false;
      }
      label572:
      break;
      label574:
      ad.i("MicroMsg.CardBaseShowLogic", "not need direct jump!");
      break label107;
      label585:
      if (!this.oKo)
      {
        this.oKn = true;
        ad.i("MicroMsg.CardBaseShowLogic", "set mIsAcceptedCard is true");
      }
      else
      {
        this.oKn = false;
        ad.i("MicroMsg.CardBaseShowLogic", "set mIsAcceptedCard is false!");
      }
    }
  }
  
  public boolean bXr()
  {
    return this.oKo;
  }
  
  public final boolean bXs()
  {
    return this.oKp;
  }
  
  public final boolean bXt()
  {
    return this.oKq;
  }
  
  public final boolean bXu()
  {
    return this.oKr;
  }
  
  public final boolean bXv()
  {
    return this.oKs;
  }
  
  public final boolean bXw()
  {
    return this.oKu;
  }
  
  public final boolean bXx()
  {
    return this.oKv;
  }
  
  public final boolean bXy()
  {
    return this.oKw;
  }
  
  public boolean bXz()
  {
    return true;
  }
  
  public final void release()
  {
    this.owK = null;
    this.oFE = null;
    this.owO = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.a.a
 * JD-Core Version:    0.7.0.1
 */