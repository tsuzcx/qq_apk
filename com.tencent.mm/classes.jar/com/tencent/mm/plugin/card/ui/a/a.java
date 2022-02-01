package com.tencent.mm.plugin.card.ui.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.ui.e.a;
import com.tencent.mm.protocal.protobuf.acl;
import com.tencent.mm.protocal.protobuf.qy;
import com.tencent.mm.protocal.protobuf.ry;
import com.tencent.mm.protocal.protobuf.yg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public class a
  implements g
{
  protected b nTp;
  protected MMActivity nTt;
  protected e.a ocl;
  boolean ogU = false;
  private boolean ogV = false;
  private boolean ogW = false;
  private boolean ogX = false;
  private boolean ogY = false;
  private boolean ogZ = false;
  private boolean oha = false;
  private boolean ohb = false;
  private boolean ohc = false;
  private boolean ohd = false;
  
  public a(MMActivity paramMMActivity)
  {
    this.nTt = paramMMActivity;
  }
  
  private boolean bSI()
  {
    AppMethodBeat.i(113625);
    if (!TextUtils.isEmpty(this.nTp.bPj().code))
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
    String str = this.nTt.getString(paramInt);
    AppMethodBeat.o(113622);
    return str;
  }
  
  public final void a(b paramb, e.a parama)
  {
    AppMethodBeat.i(113620);
    this.nTp = paramb;
    this.ocl = parama;
    bSL();
    AppMethodBeat.o(113620);
  }
  
  public final String bSF()
  {
    AppMethodBeat.i(113621);
    String str = "";
    if (!TextUtils.isEmpty(this.nTp.bPi().EkN)) {
      str = this.nTp.bPi().EkN;
    }
    for (;;)
    {
      AppMethodBeat.o(113621);
      return str;
      if (this.nTp.bPj().Eih == 0L) {
        str = getString(2131756946);
      } else if (this.nTp.bPj().Eii == 0) {
        if (!TextUtils.isEmpty(this.nTp.bPi().kfh)) {
          str = this.nTp.bPi().kfh;
        } else {
          str = getString(2131756792);
        }
      }
    }
  }
  
  public final boolean bSG()
  {
    AppMethodBeat.i(113623);
    if ((this.nTp.bPj().status == 0) || (this.nTp.bPj().status == 1) || (this.nTp.bPj().status == 2))
    {
      AppMethodBeat.o(113623);
      return true;
    }
    AppMethodBeat.o(113623);
    return false;
  }
  
  public final boolean bSH()
  {
    AppMethodBeat.i(113624);
    if ((this.ocl.fwc == 3) || ((this.ocl.fwc == 6) && (this.nTp.bPj().Eie == 0)) || (this.ocl.fwc == 4) || (this.ocl.fwc == 5) || (this.ocl.fwc == 15))
    {
      AppMethodBeat.o(113624);
      return true;
    }
    AppMethodBeat.o(113624);
    return false;
  }
  
  protected final boolean bSJ()
  {
    AppMethodBeat.i(113626);
    if ((!this.nTp.isAcceptable()) && ((l.Ae(this.ocl.fwc)) || (l.Af(this.ocl.fwc)) || (this.ocl.fwc == 23)))
    {
      AppMethodBeat.o(113626);
      return true;
    }
    AppMethodBeat.o(113626);
    return false;
  }
  
  protected final boolean bSK()
  {
    AppMethodBeat.i(113627);
    if ((!this.nTp.bPf()) && (this.ocl.fwc == 6))
    {
      AppMethodBeat.o(113627);
      return true;
    }
    AppMethodBeat.o(113627);
    return false;
  }
  
  protected void bSL()
  {
    AppMethodBeat.i(113628);
    ac.i("MicroMsg.CardBaseShowLogic", "updateAcceptState()");
    if ((l.Ae(this.ocl.fwc)) || (l.Af(this.ocl.fwc))) {
      if (this.nTp.isAcceptable())
      {
        this.ogV = true;
        this.ogW = true;
        this.ohb = true;
        this.ogZ = true;
        this.oha = true;
        if (!this.nTp.bPd()) {
          break label567;
        }
        this.ogV = false;
        this.ogW = false;
        ac.i("MicroMsg.CardBaseShowLogic", "need direct jump!");
        label104:
        if (!this.ogU) {
          break label577;
        }
        this.ogV = false;
        this.ogW = false;
        ac.i("MicroMsg.CardBaseShowLogic", "updateAcceptView to gone!");
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.CardBaseShowLogic", "mIsAcceptedCard:" + this.ogU);
      AppMethodBeat.o(113628);
      return;
      if (!this.nTp.isAcceptable())
      {
        this.ogV = true;
        this.ogW = false;
        if (this.nTp.bPd())
        {
          this.ohc = true;
          this.ogZ = true;
          this.ogY = true;
        }
        for (;;)
        {
          this.oha = true;
          break;
          this.ogZ = false;
        }
      }
      this.ogV = false;
      this.ogW = false;
      this.ogZ = false;
      break;
      if (this.ocl.fwc == 6)
      {
        if (this.nTp.bPf())
        {
          this.ogV = true;
          this.ogW = true;
          this.ogZ = false;
          break;
        }
        if (this.nTp.bPe())
        {
          this.ohc = true;
          this.ogZ = true;
          this.ogX = true;
          this.ogY = true;
          break;
        }
        this.ogV = false;
        this.ogW = false;
        this.ogZ = false;
        this.ogX = true;
        break;
      }
      if (l.Ag(this.ocl.fwc))
      {
        this.ogV = false;
        this.ogW = false;
        this.ogX = true;
        if (this.nTp.bPe())
        {
          this.ohc = true;
          this.ogZ = true;
          this.ogY = true;
          break;
        }
        this.ohd = true;
        break;
      }
      if (this.ocl.fwc != 23) {
        break;
      }
      if (this.nTp.isAcceptable())
      {
        this.ogV = true;
        this.ogW = true;
        this.ogZ = false;
      }
      for (this.oha = true;; this.oha = true)
      {
        if ((TextUtils.isEmpty(this.ocl.obt)) || (this.ocl.obt.equals(u.axw())) || (this.nTp.bPh())) {
          break label565;
        }
        ac.i("MicroMsg.CardBaseShowLogic", " detail page");
        this.ogV = false;
        this.ogW = false;
        this.ogX = true;
        if (!this.nTp.bPe()) {
          break;
        }
        this.ohc = true;
        this.ogZ = true;
        this.ogY = true;
        break;
        this.ogV = true;
        this.ogW = false;
        this.ogZ = false;
      }
      label565:
      break;
      label567:
      ac.i("MicroMsg.CardBaseShowLogic", "not need direct jump!");
      break label104;
      label577:
      if (!this.ogV)
      {
        this.ogU = true;
        ac.i("MicroMsg.CardBaseShowLogic", "set mIsAcceptedCard is true");
      }
      else
      {
        this.ogU = false;
        ac.i("MicroMsg.CardBaseShowLogic", "set mIsAcceptedCard is false!");
      }
    }
  }
  
  public boolean bSM()
  {
    return this.ogV;
  }
  
  public final boolean bSN()
  {
    return this.ogW;
  }
  
  public final boolean bSO()
  {
    return this.ogX;
  }
  
  public final boolean bSP()
  {
    return this.ogY;
  }
  
  public final boolean bSQ()
  {
    return this.ogZ;
  }
  
  public final boolean bSR()
  {
    return this.ohb;
  }
  
  public final boolean bSS()
  {
    return this.ohc;
  }
  
  public final boolean bST()
  {
    return this.ohd;
  }
  
  public boolean bSU()
  {
    return true;
  }
  
  public boolean bSV()
  {
    return false;
  }
  
  public boolean bSW()
  {
    return false;
  }
  
  public boolean bSX()
  {
    AppMethodBeat.i(113629);
    if (((this.ocl.fwc == 6) && ((!this.nTp.bPe()) || (this.nTp.bPf()))) || (this.ocl.fwc == 5) || ((this.ocl.fwc == 23) && (this.nTp.bPh())))
    {
      AppMethodBeat.o(113629);
      return true;
    }
    AppMethodBeat.o(113629);
    return false;
  }
  
  public boolean bSY()
  {
    return false;
  }
  
  public boolean bSZ()
  {
    return true;
  }
  
  public final boolean bSe()
  {
    return this.ogU;
  }
  
  public boolean bTa()
  {
    AppMethodBeat.i(113630);
    if (((bSI()) && (bSG()) && (bSH())) || (this.ogU))
    {
      AppMethodBeat.o(113630);
      return true;
    }
    AppMethodBeat.o(113630);
    return false;
  }
  
  public boolean bTb()
  {
    return false;
  }
  
  public boolean bTc()
  {
    AppMethodBeat.i(113631);
    if (!this.nTp.bPe())
    {
      AppMethodBeat.o(113631);
      return true;
    }
    AppMethodBeat.o(113631);
    return false;
  }
  
  public boolean bTd()
  {
    AppMethodBeat.i(113632);
    if ((this.nTp.bPi().EkH != null) && (this.nTp.bPi().EkH.EuV != null) && (this.nTp.bPi().EkH.EuV.size() > 0) && (!TextUtils.isEmpty((CharSequence)this.nTp.bPi().EkH.EuV.get(0))))
    {
      AppMethodBeat.o(113632);
      return true;
    }
    AppMethodBeat.o(113632);
    return false;
  }
  
  public boolean bTe()
  {
    AppMethodBeat.i(113633);
    if ((this.nTp.bPj().Eig != null) && (this.nTp.bPj().Eig.size() > 0) && (((bSG()) && (bSH())) || (this.ogU)))
    {
      AppMethodBeat.o(113633);
      return true;
    }
    AppMethodBeat.o(113633);
    return false;
  }
  
  public boolean bTf()
  {
    return false;
  }
  
  public final boolean bTg()
  {
    AppMethodBeat.i(113634);
    if ((this.nTp.bPj().Eik != null) && (!TextUtils.isEmpty(this.nTp.bPj().Eik.title)))
    {
      AppMethodBeat.o(113634);
      return true;
    }
    AppMethodBeat.o(113634);
    return false;
  }
  
  public boolean bTh()
  {
    AppMethodBeat.i(113635);
    if ((this.nTp.bPj().Ein != null) && (!TextUtils.isEmpty(this.nTp.bPj().Ein.title)))
    {
      AppMethodBeat.o(113635);
      return true;
    }
    AppMethodBeat.o(113635);
    return false;
  }
  
  public boolean bTi()
  {
    AppMethodBeat.i(113636);
    if (this.nTp.bPi().EkD != null)
    {
      AppMethodBeat.o(113636);
      return true;
    }
    AppMethodBeat.o(113636);
    return false;
  }
  
  public boolean bTj()
  {
    AppMethodBeat.i(113637);
    if (!TextUtils.isEmpty(this.nTp.bPi().EkA))
    {
      AppMethodBeat.o(113637);
      return true;
    }
    AppMethodBeat.o(113637);
    return false;
  }
  
  public boolean bTk()
  {
    return false;
  }
  
  public boolean bTl()
  {
    return false;
  }
  
  public final void bTm()
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
    if (bSI())
    {
      i = 1;
      str = bSF();
      if (!this.ogU) {
        break label240;
      }
      j = 1;
      if (!bSM()) {
        break label245;
      }
      k = 1;
      if (!this.ogW) {
        break label250;
      }
      m = 1;
      if (!this.ogX) {
        break label256;
      }
      n = 1;
      if (!this.ogY) {
        break label262;
      }
      i1 = 1;
      if (!this.ogZ) {
        break label268;
      }
      i2 = 1;
      if (!this.oha) {
        break label274;
      }
      i3 = 1;
      if (!this.ohb) {
        break label280;
      }
      i4 = 1;
      if (!this.ohc) {
        break label286;
      }
      i5 = 1;
      label112:
      if (!this.ohd) {
        break label292;
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.CardBaseShowLogic", "printStatus, isValidCode:%d, getUnacceptWording:%s, isAcceptedCard:%d, acceptViewVisible:%d, acceptViewEnabled:%d, isShowConsumedBtn:%d, isConsumedBtnEnabled:%d, enableOptionMenu:%d, isShareLogoVisible:%d, addShareMenu:%d, addMenu:%d, addInvalidCardMenu:%d ", new Object[] { Integer.valueOf(i), str, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6) });
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
    this.nTp = null;
    this.ocl = null;
    this.nTt = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.a.a
 * JD-Core Version:    0.7.0.1
 */