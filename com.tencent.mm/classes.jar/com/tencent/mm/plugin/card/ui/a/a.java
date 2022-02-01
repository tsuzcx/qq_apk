package com.tencent.mm.plugin.card.ui.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.ui.e.a;
import com.tencent.mm.protocal.protobuf.abm;
import com.tencent.mm.protocal.protobuf.qo;
import com.tencent.mm.protocal.protobuf.ro;
import com.tencent.mm.protocal.protobuf.xo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public class a
  implements g
{
  boolean nDT = false;
  private boolean nDU = false;
  private boolean nDV = false;
  private boolean nDW = false;
  private boolean nDX = false;
  private boolean nDY = false;
  private boolean nDZ = false;
  private boolean nEa = false;
  private boolean nEb = false;
  private boolean nEc = false;
  protected b nqp;
  protected MMActivity nqt;
  protected e.a nzk;
  
  public a(MMActivity paramMMActivity)
  {
    this.nqt = paramMMActivity;
  }
  
  private boolean bLv()
  {
    AppMethodBeat.i(113625);
    if (!TextUtils.isEmpty(this.nqp.bHW().code))
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
    String str = this.nqt.getString(paramInt);
    AppMethodBeat.o(113622);
    return str;
  }
  
  public final void a(b paramb, e.a parama)
  {
    AppMethodBeat.i(113620);
    this.nqp = paramb;
    this.nzk = parama;
    bLy();
    AppMethodBeat.o(113620);
  }
  
  public final boolean bKR()
  {
    return this.nDT;
  }
  
  public final boolean bLA()
  {
    return this.nDV;
  }
  
  public final boolean bLB()
  {
    return this.nDW;
  }
  
  public final boolean bLC()
  {
    return this.nDX;
  }
  
  public final boolean bLD()
  {
    return this.nDY;
  }
  
  public final boolean bLE()
  {
    return this.nEa;
  }
  
  public final boolean bLF()
  {
    return this.nEb;
  }
  
  public final boolean bLG()
  {
    return this.nEc;
  }
  
  public boolean bLH()
  {
    return true;
  }
  
  public boolean bLI()
  {
    return false;
  }
  
  public boolean bLJ()
  {
    return false;
  }
  
  public boolean bLK()
  {
    AppMethodBeat.i(113629);
    if (((this.nzk.fsv == 6) && ((!this.nqp.bHR()) || (this.nqp.bHS()))) || (this.nzk.fsv == 5) || ((this.nzk.fsv == 23) && (this.nqp.bHU())))
    {
      AppMethodBeat.o(113629);
      return true;
    }
    AppMethodBeat.o(113629);
    return false;
  }
  
  public boolean bLL()
  {
    return false;
  }
  
  public boolean bLM()
  {
    return true;
  }
  
  public boolean bLN()
  {
    AppMethodBeat.i(113630);
    if (((bLv()) && (bLt()) && (bLu())) || (this.nDT))
    {
      AppMethodBeat.o(113630);
      return true;
    }
    AppMethodBeat.o(113630);
    return false;
  }
  
  public boolean bLO()
  {
    return false;
  }
  
  public boolean bLP()
  {
    AppMethodBeat.i(113631);
    if (!this.nqp.bHR())
    {
      AppMethodBeat.o(113631);
      return true;
    }
    AppMethodBeat.o(113631);
    return false;
  }
  
  public boolean bLQ()
  {
    AppMethodBeat.i(113632);
    if ((this.nqp.bHV().CRW != null) && (this.nqp.bHV().CRW.DbO != null) && (this.nqp.bHV().CRW.DbO.size() > 0) && (!TextUtils.isEmpty((CharSequence)this.nqp.bHV().CRW.DbO.get(0))))
    {
      AppMethodBeat.o(113632);
      return true;
    }
    AppMethodBeat.o(113632);
    return false;
  }
  
  public boolean bLR()
  {
    AppMethodBeat.i(113633);
    if ((this.nqp.bHW().CPv != null) && (this.nqp.bHW().CPv.size() > 0) && (((bLt()) && (bLu())) || (this.nDT)))
    {
      AppMethodBeat.o(113633);
      return true;
    }
    AppMethodBeat.o(113633);
    return false;
  }
  
  public boolean bLS()
  {
    return false;
  }
  
  public final boolean bLT()
  {
    AppMethodBeat.i(113634);
    if ((this.nqp.bHW().CPz != null) && (!TextUtils.isEmpty(this.nqp.bHW().CPz.title)))
    {
      AppMethodBeat.o(113634);
      return true;
    }
    AppMethodBeat.o(113634);
    return false;
  }
  
  public boolean bLU()
  {
    AppMethodBeat.i(113635);
    if ((this.nqp.bHW().CPC != null) && (!TextUtils.isEmpty(this.nqp.bHW().CPC.title)))
    {
      AppMethodBeat.o(113635);
      return true;
    }
    AppMethodBeat.o(113635);
    return false;
  }
  
  public boolean bLV()
  {
    AppMethodBeat.i(113636);
    if (this.nqp.bHV().CRS != null)
    {
      AppMethodBeat.o(113636);
      return true;
    }
    AppMethodBeat.o(113636);
    return false;
  }
  
  public boolean bLW()
  {
    AppMethodBeat.i(113637);
    if (!TextUtils.isEmpty(this.nqp.bHV().CRP))
    {
      AppMethodBeat.o(113637);
      return true;
    }
    AppMethodBeat.o(113637);
    return false;
  }
  
  public boolean bLX()
  {
    return false;
  }
  
  public boolean bLY()
  {
    return false;
  }
  
  public final void bLZ()
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
    if (bLv())
    {
      i = 1;
      str = bLs();
      if (!this.nDT) {
        break label237;
      }
      j = 1;
      if (!bLz()) {
        break label242;
      }
      k = 1;
      if (!this.nDV) {
        break label247;
      }
      m = 1;
      if (!this.nDW) {
        break label253;
      }
      n = 1;
      if (!this.nDX) {
        break label259;
      }
      i1 = 1;
      if (!this.nDY) {
        break label265;
      }
      i2 = 1;
      if (!this.nDZ) {
        break label271;
      }
      i3 = 1;
      if (!this.nEa) {
        break label277;
      }
      i4 = 1;
      if (!this.nEb) {
        break label283;
      }
      i5 = 1;
      label111:
      if (!this.nEc) {
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
  
  public final String bLs()
  {
    AppMethodBeat.i(113621);
    String str = "";
    if (!TextUtils.isEmpty(this.nqp.bHV().CSc)) {
      str = this.nqp.bHV().CSc;
    }
    for (;;)
    {
      AppMethodBeat.o(113621);
      return str;
      if (this.nqp.bHW().CPw == 0L) {
        str = getString(2131756946);
      } else if (this.nqp.bHW().CPx == 0) {
        if (!TextUtils.isEmpty(this.nqp.bHV().jEK)) {
          str = this.nqp.bHV().jEK;
        } else {
          str = getString(2131756792);
        }
      }
    }
  }
  
  public final boolean bLt()
  {
    AppMethodBeat.i(113623);
    if ((this.nqp.bHW().status == 0) || (this.nqp.bHW().status == 1) || (this.nqp.bHW().status == 2))
    {
      AppMethodBeat.o(113623);
      return true;
    }
    AppMethodBeat.o(113623);
    return false;
  }
  
  public final boolean bLu()
  {
    AppMethodBeat.i(113624);
    if ((this.nzk.fsv == 3) || ((this.nzk.fsv == 6) && (this.nqp.bHW().CPt == 0)) || (this.nzk.fsv == 4) || (this.nzk.fsv == 5) || (this.nzk.fsv == 15))
    {
      AppMethodBeat.o(113624);
      return true;
    }
    AppMethodBeat.o(113624);
    return false;
  }
  
  protected final boolean bLw()
  {
    AppMethodBeat.i(113626);
    if ((!this.nqp.isAcceptable()) && ((l.zn(this.nzk.fsv)) || (l.zo(this.nzk.fsv)) || (this.nzk.fsv == 23)))
    {
      AppMethodBeat.o(113626);
      return true;
    }
    AppMethodBeat.o(113626);
    return false;
  }
  
  protected final boolean bLx()
  {
    AppMethodBeat.i(113627);
    if ((!this.nqp.bHS()) && (this.nzk.fsv == 6))
    {
      AppMethodBeat.o(113627);
      return true;
    }
    AppMethodBeat.o(113627);
    return false;
  }
  
  protected void bLy()
  {
    AppMethodBeat.i(113628);
    ad.i("MicroMsg.CardBaseShowLogic", "updateAcceptState()");
    if ((l.zn(this.nzk.fsv)) || (l.zo(this.nzk.fsv))) {
      if (this.nqp.isAcceptable())
      {
        this.nDU = true;
        this.nDV = true;
        this.nEa = true;
        this.nDY = true;
        this.nDZ = true;
        if (!this.nqp.bHQ()) {
          break label574;
        }
        this.nDU = false;
        this.nDV = false;
        ad.i("MicroMsg.CardBaseShowLogic", "need direct jump!");
        label107:
        if (!this.nDT) {
          break label585;
        }
        this.nDU = false;
        this.nDV = false;
        ad.i("MicroMsg.CardBaseShowLogic", "updateAcceptView to gone!");
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.CardBaseShowLogic", "mIsAcceptedCard:" + this.nDT);
      AppMethodBeat.o(113628);
      return;
      if (!this.nqp.isAcceptable())
      {
        this.nDU = true;
        this.nDV = false;
        if (this.nqp.bHQ())
        {
          this.nEb = true;
          this.nDY = true;
          this.nDX = true;
        }
        for (;;)
        {
          this.nDZ = true;
          break;
          this.nDY = false;
        }
      }
      this.nDU = false;
      this.nDV = false;
      this.nDY = false;
      break;
      if (this.nzk.fsv == 6)
      {
        if (this.nqp.bHS())
        {
          this.nDU = true;
          this.nDV = true;
          this.nDY = false;
          break;
        }
        if (this.nqp.bHR())
        {
          this.nEb = true;
          this.nDY = true;
          this.nDW = true;
          this.nDX = true;
          break;
        }
        this.nDU = false;
        this.nDV = false;
        this.nDY = false;
        this.nDW = true;
        break;
      }
      if (l.zp(this.nzk.fsv))
      {
        this.nDU = false;
        this.nDV = false;
        this.nDW = true;
        if (this.nqp.bHR())
        {
          this.nEb = true;
          this.nDY = true;
          this.nDX = true;
          break;
        }
        this.nEc = true;
        break;
      }
      if (this.nzk.fsv != 23) {
        break;
      }
      if (this.nqp.isAcceptable())
      {
        this.nDU = true;
        this.nDV = true;
        this.nDY = false;
      }
      for (this.nDZ = true;; this.nDZ = true)
      {
        if ((TextUtils.isEmpty(this.nzk.nys)) || (this.nzk.nys.equals(u.aqG())) || (this.nqp.bHU())) {
          break label572;
        }
        ad.i("MicroMsg.CardBaseShowLogic", " detail page");
        this.nDU = false;
        this.nDV = false;
        this.nDW = true;
        if (!this.nqp.bHR()) {
          break;
        }
        this.nEb = true;
        this.nDY = true;
        this.nDX = true;
        break;
        this.nDU = true;
        this.nDV = false;
        this.nDY = false;
      }
      label572:
      break;
      label574:
      ad.i("MicroMsg.CardBaseShowLogic", "not need direct jump!");
      break label107;
      label585:
      if (!this.nDU)
      {
        this.nDT = true;
        ad.i("MicroMsg.CardBaseShowLogic", "set mIsAcceptedCard is true");
      }
      else
      {
        this.nDT = false;
        ad.i("MicroMsg.CardBaseShowLogic", "set mIsAcceptedCard is false!");
      }
    }
  }
  
  public boolean bLz()
  {
    return this.nDU;
  }
  
  public final void release()
  {
    this.nqp = null;
    this.nzk = null;
    this.nqt = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.a.a
 * JD-Core Version:    0.7.0.1
 */