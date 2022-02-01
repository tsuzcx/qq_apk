package com.tencent.mm.plugin.card.ui.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.ui.e.a;
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.protocal.protobuf.agy;
import com.tencent.mm.protocal.protobuf.ty;
import com.tencent.mm.protocal.protobuf.uz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public class a
  implements g
{
  protected b pQV;
  protected MMActivity pQZ;
  protected e.a pZU;
  boolean qeD = false;
  private boolean qeE = false;
  private boolean qeF = false;
  private boolean qeG = false;
  private boolean qeH = false;
  private boolean qeI = false;
  private boolean qeJ = false;
  private boolean qeK = false;
  private boolean qeL = false;
  private boolean qeM = false;
  
  public a(MMActivity paramMMActivity)
  {
    this.pQZ = paramMMActivity;
  }
  
  private boolean cws()
  {
    AppMethodBeat.i(113625);
    if (!TextUtils.isEmpty(this.pQV.csR().code))
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
    String str = this.pQZ.getString(paramInt);
    AppMethodBeat.o(113622);
    return str;
  }
  
  public final void a(b paramb, e.a parama)
  {
    AppMethodBeat.i(113620);
    this.pQV = paramb;
    this.pZU = parama;
    cwv();
    AppMethodBeat.o(113620);
  }
  
  public final boolean cvO()
  {
    return this.qeD;
  }
  
  public final boolean cwA()
  {
    return this.qeI;
  }
  
  public final boolean cwB()
  {
    return this.qeK;
  }
  
  public final boolean cwC()
  {
    return this.qeL;
  }
  
  public final boolean cwD()
  {
    return this.qeM;
  }
  
  public boolean cwE()
  {
    return true;
  }
  
  public boolean cwF()
  {
    return false;
  }
  
  public boolean cwG()
  {
    return false;
  }
  
  public boolean cwH()
  {
    AppMethodBeat.i(113629);
    if (((this.pZU.gwE == 6) && ((!this.pQV.csM()) || (this.pQV.csN()))) || (this.pZU.gwE == 5) || ((this.pZU.gwE == 23) && (this.pQV.csP())))
    {
      AppMethodBeat.o(113629);
      return true;
    }
    AppMethodBeat.o(113629);
    return false;
  }
  
  public boolean cwI()
  {
    return false;
  }
  
  public boolean cwJ()
  {
    return true;
  }
  
  public boolean cwK()
  {
    AppMethodBeat.i(113630);
    if (((cws()) && (cwq()) && (cwr())) || (this.qeD))
    {
      AppMethodBeat.o(113630);
      return true;
    }
    AppMethodBeat.o(113630);
    return false;
  }
  
  public boolean cwL()
  {
    return false;
  }
  
  public boolean cwM()
  {
    AppMethodBeat.i(113631);
    if (!this.pQV.csM())
    {
      AppMethodBeat.o(113631);
      return true;
    }
    AppMethodBeat.o(113631);
    return false;
  }
  
  public boolean cwN()
  {
    AppMethodBeat.i(113632);
    if ((this.pQV.csQ().LeS != null) && (this.pQV.csQ().LeS.LqB != null) && (this.pQV.csQ().LeS.LqB.size() > 0) && (!TextUtils.isEmpty((CharSequence)this.pQV.csQ().LeS.LqB.get(0))))
    {
      AppMethodBeat.o(113632);
      return true;
    }
    AppMethodBeat.o(113632);
    return false;
  }
  
  public boolean cwO()
  {
    AppMethodBeat.i(113633);
    if ((this.pQV.csR().Lcs != null) && (this.pQV.csR().Lcs.size() > 0) && (((cwq()) && (cwr())) || (this.qeD)))
    {
      AppMethodBeat.o(113633);
      return true;
    }
    AppMethodBeat.o(113633);
    return false;
  }
  
  public boolean cwP()
  {
    return false;
  }
  
  public final boolean cwQ()
  {
    AppMethodBeat.i(113634);
    if ((this.pQV.csR().Lcw != null) && (!TextUtils.isEmpty(this.pQV.csR().Lcw.title)))
    {
      AppMethodBeat.o(113634);
      return true;
    }
    AppMethodBeat.o(113634);
    return false;
  }
  
  public boolean cwR()
  {
    AppMethodBeat.i(113635);
    if ((this.pQV.csR().Lcz != null) && (!TextUtils.isEmpty(this.pQV.csR().Lcz.title)))
    {
      AppMethodBeat.o(113635);
      return true;
    }
    AppMethodBeat.o(113635);
    return false;
  }
  
  public boolean cwS()
  {
    AppMethodBeat.i(113636);
    if (this.pQV.csQ().LeO != null)
    {
      AppMethodBeat.o(113636);
      return true;
    }
    AppMethodBeat.o(113636);
    return false;
  }
  
  public boolean cwT()
  {
    AppMethodBeat.i(113637);
    if (!TextUtils.isEmpty(this.pQV.csQ().LeL))
    {
      AppMethodBeat.o(113637);
      return true;
    }
    AppMethodBeat.o(113637);
    return false;
  }
  
  public boolean cwU()
  {
    return false;
  }
  
  public boolean cwV()
  {
    return false;
  }
  
  public final void cwW()
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
    if (cws())
    {
      i = 1;
      str = cwp();
      if (!this.qeD) {
        break label237;
      }
      j = 1;
      if (!cww()) {
        break label242;
      }
      k = 1;
      if (!this.qeF) {
        break label247;
      }
      m = 1;
      if (!this.qeG) {
        break label253;
      }
      n = 1;
      if (!this.qeH) {
        break label259;
      }
      i1 = 1;
      if (!this.qeI) {
        break label265;
      }
      i2 = 1;
      if (!this.qeJ) {
        break label271;
      }
      i3 = 1;
      if (!this.qeK) {
        break label277;
      }
      i4 = 1;
      if (!this.qeL) {
        break label283;
      }
      i5 = 1;
      label111:
      if (!this.qeM) {
        break label289;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.CardBaseShowLogic", "printStatus, isValidCode:%d, getUnacceptWording:%s, isAcceptedCard:%d, acceptViewVisible:%d, acceptViewEnabled:%d, isShowConsumedBtn:%d, isConsumedBtnEnabled:%d, enableOptionMenu:%d, isShareLogoVisible:%d, addShareMenu:%d, addMenu:%d, addInvalidCardMenu:%d ", new Object[] { Integer.valueOf(i), str, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6) });
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
  
  public final String cwp()
  {
    AppMethodBeat.i(113621);
    String str = "";
    if (!TextUtils.isEmpty(this.pQV.csQ().LeY)) {
      str = this.pQV.csQ().LeY;
    }
    for (;;)
    {
      AppMethodBeat.o(113621);
      return str;
      if (this.pQV.csR().Lct == 0L) {
        str = getString(2131757116);
      } else if (this.pQV.csR().Lcu == 0) {
        if (!TextUtils.isEmpty(this.pQV.csQ().lHL)) {
          str = this.pQV.csQ().lHL;
        } else {
          str = getString(2131756957);
        }
      }
    }
  }
  
  public final boolean cwq()
  {
    AppMethodBeat.i(113623);
    if ((this.pQV.csR().status == 0) || (this.pQV.csR().status == 1) || (this.pQV.csR().status == 2))
    {
      AppMethodBeat.o(113623);
      return true;
    }
    AppMethodBeat.o(113623);
    return false;
  }
  
  public final boolean cwr()
  {
    AppMethodBeat.i(113624);
    if ((this.pZU.gwE == 3) || ((this.pZU.gwE == 6) && (this.pQV.csR().Lcq == 0)) || (this.pZU.gwE == 4) || (this.pZU.gwE == 5) || (this.pZU.gwE == 15))
    {
      AppMethodBeat.o(113624);
      return true;
    }
    AppMethodBeat.o(113624);
    return false;
  }
  
  protected final boolean cwt()
  {
    AppMethodBeat.i(113626);
    if ((!this.pQV.isAcceptable()) && ((l.EH(this.pZU.gwE)) || (l.EI(this.pZU.gwE)) || (this.pZU.gwE == 23)))
    {
      AppMethodBeat.o(113626);
      return true;
    }
    AppMethodBeat.o(113626);
    return false;
  }
  
  protected final boolean cwu()
  {
    AppMethodBeat.i(113627);
    if ((!this.pQV.csN()) && (this.pZU.gwE == 6))
    {
      AppMethodBeat.o(113627);
      return true;
    }
    AppMethodBeat.o(113627);
    return false;
  }
  
  protected void cwv()
  {
    AppMethodBeat.i(113628);
    Log.i("MicroMsg.CardBaseShowLogic", "updateAcceptState()");
    if ((l.EH(this.pZU.gwE)) || (l.EI(this.pZU.gwE))) {
      if (this.pQV.isAcceptable())
      {
        this.qeE = true;
        this.qeF = true;
        this.qeK = true;
        this.qeI = true;
        this.qeJ = true;
        if (!this.pQV.csL()) {
          break label574;
        }
        this.qeE = false;
        this.qeF = false;
        Log.i("MicroMsg.CardBaseShowLogic", "need direct jump!");
        label107:
        if (!this.qeD) {
          break label585;
        }
        this.qeE = false;
        this.qeF = false;
        Log.i("MicroMsg.CardBaseShowLogic", "updateAcceptView to gone!");
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.CardBaseShowLogic", "mIsAcceptedCard:" + this.qeD);
      AppMethodBeat.o(113628);
      return;
      if (!this.pQV.isAcceptable())
      {
        this.qeE = true;
        this.qeF = false;
        if (this.pQV.csL())
        {
          this.qeL = true;
          this.qeI = true;
          this.qeH = true;
        }
        for (;;)
        {
          this.qeJ = true;
          break;
          this.qeI = false;
        }
      }
      this.qeE = false;
      this.qeF = false;
      this.qeI = false;
      break;
      if (this.pZU.gwE == 6)
      {
        if (this.pQV.csN())
        {
          this.qeE = true;
          this.qeF = true;
          this.qeI = false;
          break;
        }
        if (this.pQV.csM())
        {
          this.qeL = true;
          this.qeI = true;
          this.qeG = true;
          this.qeH = true;
          break;
        }
        this.qeE = false;
        this.qeF = false;
        this.qeI = false;
        this.qeG = true;
        break;
      }
      if (l.EJ(this.pZU.gwE))
      {
        this.qeE = false;
        this.qeF = false;
        this.qeG = true;
        if (this.pQV.csM())
        {
          this.qeL = true;
          this.qeI = true;
          this.qeH = true;
          break;
        }
        this.qeM = true;
        break;
      }
      if (this.pZU.gwE != 23) {
        break;
      }
      if (this.pQV.isAcceptable())
      {
        this.qeE = true;
        this.qeF = true;
        this.qeI = false;
      }
      for (this.qeJ = true;; this.qeJ = true)
      {
        if ((TextUtils.isEmpty(this.pZU.pZc)) || (this.pZU.pZc.equals(z.aTY())) || (this.pQV.csP())) {
          break label572;
        }
        Log.i("MicroMsg.CardBaseShowLogic", " detail page");
        this.qeE = false;
        this.qeF = false;
        this.qeG = true;
        if (!this.pQV.csM()) {
          break;
        }
        this.qeL = true;
        this.qeI = true;
        this.qeH = true;
        break;
        this.qeE = true;
        this.qeF = false;
        this.qeI = false;
      }
      label572:
      break;
      label574:
      Log.i("MicroMsg.CardBaseShowLogic", "not need direct jump!");
      break label107;
      label585:
      if (!this.qeE)
      {
        this.qeD = true;
        Log.i("MicroMsg.CardBaseShowLogic", "set mIsAcceptedCard is true");
      }
      else
      {
        this.qeD = false;
        Log.i("MicroMsg.CardBaseShowLogic", "set mIsAcceptedCard is false!");
      }
    }
  }
  
  public boolean cww()
  {
    return this.qeE;
  }
  
  public final boolean cwx()
  {
    return this.qeF;
  }
  
  public final boolean cwy()
  {
    return this.qeG;
  }
  
  public final boolean cwz()
  {
    return this.qeH;
  }
  
  public final void release()
  {
    this.pQV = null;
    this.pZU = null;
    this.pQZ = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.a.a
 * JD-Core Version:    0.7.0.1
 */