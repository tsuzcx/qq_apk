package com.tencent.mm.plugin.card.ui.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.ui.e.a;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.protocal.protobuf.uo;
import com.tencent.mm.protocal.protobuf.ye;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public class a
  implements g
{
  protected MMActivity jpX;
  protected b klk;
  protected e.a ktU;
  boolean kyA = false;
  private boolean kyB = false;
  private boolean kyC = false;
  private boolean kyD = false;
  private boolean kyE = false;
  private boolean kyF = false;
  private boolean kyG = false;
  private boolean kyH = false;
  private boolean kyI = false;
  private boolean kyJ = false;
  
  public a(MMActivity paramMMActivity)
  {
    this.jpX = paramMMActivity;
  }
  
  private boolean bez()
  {
    AppMethodBeat.i(88698);
    if (!TextUtils.isEmpty(this.klk.bbe().code))
    {
      AppMethodBeat.o(88698);
      return true;
    }
    AppMethodBeat.o(88698);
    return false;
  }
  
  private String getString(int paramInt)
  {
    AppMethodBeat.i(88695);
    String str = this.jpX.getString(paramInt);
    AppMethodBeat.o(88695);
    return str;
  }
  
  public final void a(b paramb, e.a parama)
  {
    AppMethodBeat.i(88693);
    this.klk = paramb;
    this.ktU = parama;
    beC();
    AppMethodBeat.o(88693);
  }
  
  public final boolean bdT()
  {
    return this.kyA;
  }
  
  protected final boolean beA()
  {
    AppMethodBeat.i(88699);
    if ((!this.klk.isAcceptable()) && ((l.tt(this.ktU.ejF)) || (l.tu(this.ktU.ejF)) || (this.ktU.ejF == 23)))
    {
      AppMethodBeat.o(88699);
      return true;
    }
    AppMethodBeat.o(88699);
    return false;
  }
  
  protected final boolean beB()
  {
    AppMethodBeat.i(88700);
    if ((!this.klk.bba()) && (this.ktU.ejF == 6))
    {
      AppMethodBeat.o(88700);
      return true;
    }
    AppMethodBeat.o(88700);
    return false;
  }
  
  protected void beC()
  {
    AppMethodBeat.i(88701);
    ab.i("MicroMsg.CardBaseShowLogic", "updateAcceptState()");
    if ((l.tt(this.ktU.ejF)) || (l.tu(this.ktU.ejF))) {
      if (this.klk.isAcceptable())
      {
        this.kyB = true;
        this.kyC = true;
        this.kyH = true;
        this.kyF = true;
        this.kyG = true;
        if (!this.klk.baZ()) {
          break label567;
        }
        this.kyB = false;
        this.kyC = false;
        ab.i("MicroMsg.CardBaseShowLogic", "need direct jump!");
        label104:
        if (!this.kyA) {
          break label577;
        }
        this.kyB = false;
        this.kyC = false;
        ab.i("MicroMsg.CardBaseShowLogic", "updateAcceptView to gone!");
      }
    }
    for (;;)
    {
      ab.i("MicroMsg.CardBaseShowLogic", "mIsAcceptedCard:" + this.kyA);
      AppMethodBeat.o(88701);
      return;
      if (!this.klk.isAcceptable())
      {
        this.kyB = true;
        this.kyC = false;
        if (this.klk.baZ())
        {
          this.kyI = true;
          this.kyF = true;
          this.kyE = true;
        }
        for (;;)
        {
          this.kyG = true;
          break;
          this.kyF = false;
        }
      }
      this.kyB = false;
      this.kyC = false;
      this.kyF = false;
      break;
      if (this.ktU.ejF == 6)
      {
        if (this.klk.bba())
        {
          this.kyB = true;
          this.kyC = true;
          this.kyF = false;
          break;
        }
        if (this.klk.isNormal())
        {
          this.kyI = true;
          this.kyF = true;
          this.kyD = true;
          this.kyE = true;
          break;
        }
        this.kyB = false;
        this.kyC = false;
        this.kyF = false;
        this.kyD = true;
        break;
      }
      if (l.tv(this.ktU.ejF))
      {
        this.kyB = false;
        this.kyC = false;
        this.kyD = true;
        if (this.klk.isNormal())
        {
          this.kyI = true;
          this.kyF = true;
          this.kyE = true;
          break;
        }
        this.kyJ = true;
        break;
      }
      if (this.ktU.ejF != 23) {
        break;
      }
      if (this.klk.isAcceptable())
      {
        this.kyB = true;
        this.kyC = true;
        this.kyF = false;
      }
      for (this.kyG = true;; this.kyG = true)
      {
        if ((TextUtils.isEmpty(this.ktU.ktc)) || (this.ktU.ktc.equals(r.Zn())) || (this.klk.bbc())) {
          break label565;
        }
        ab.i("MicroMsg.CardBaseShowLogic", " detail page");
        this.kyB = false;
        this.kyC = false;
        this.kyD = true;
        if (!this.klk.isNormal()) {
          break;
        }
        this.kyI = true;
        this.kyF = true;
        this.kyE = true;
        break;
        this.kyB = true;
        this.kyC = false;
        this.kyF = false;
      }
      label565:
      break;
      label567:
      ab.i("MicroMsg.CardBaseShowLogic", "not need direct jump!");
      break label104;
      label577:
      if (!this.kyB)
      {
        this.kyA = true;
        ab.i("MicroMsg.CardBaseShowLogic", "set mIsAcceptedCard is true");
      }
      else
      {
        this.kyA = false;
        ab.i("MicroMsg.CardBaseShowLogic", "set mIsAcceptedCard is false!");
      }
    }
  }
  
  public boolean beD()
  {
    return this.kyB;
  }
  
  public final boolean beE()
  {
    return this.kyC;
  }
  
  public final boolean beF()
  {
    return this.kyD;
  }
  
  public final boolean beG()
  {
    return this.kyE;
  }
  
  public final boolean beH()
  {
    return this.kyF;
  }
  
  public final boolean beI()
  {
    return this.kyH;
  }
  
  public final boolean beJ()
  {
    return this.kyI;
  }
  
  public final boolean beK()
  {
    return this.kyJ;
  }
  
  public boolean beL()
  {
    return true;
  }
  
  public boolean beM()
  {
    return false;
  }
  
  public boolean beN()
  {
    return false;
  }
  
  public boolean beO()
  {
    AppMethodBeat.i(88702);
    if (((this.ktU.ejF == 6) && ((!this.klk.isNormal()) || (this.klk.bba()))) || (this.ktU.ejF == 5) || ((this.ktU.ejF == 23) && (this.klk.bbc())))
    {
      AppMethodBeat.o(88702);
      return true;
    }
    AppMethodBeat.o(88702);
    return false;
  }
  
  public boolean beP()
  {
    return false;
  }
  
  public boolean beQ()
  {
    return true;
  }
  
  public boolean beR()
  {
    AppMethodBeat.i(88703);
    if (((bez()) && (bex()) && (bey())) || (this.kyA))
    {
      AppMethodBeat.o(88703);
      return true;
    }
    AppMethodBeat.o(88703);
    return false;
  }
  
  public boolean beS()
  {
    return false;
  }
  
  public boolean beT()
  {
    AppMethodBeat.i(88704);
    if (!this.klk.isNormal())
    {
      AppMethodBeat.o(88704);
      return true;
    }
    AppMethodBeat.o(88704);
    return false;
  }
  
  public boolean beU()
  {
    AppMethodBeat.i(88705);
    if ((this.klk.bbd().wGr != null) && (this.klk.bbd().wGr.wPk != null) && (this.klk.bbd().wGr.wPk.size() > 0) && (!TextUtils.isEmpty((CharSequence)this.klk.bbd().wGr.wPk.get(0))))
    {
      AppMethodBeat.o(88705);
      return true;
    }
    AppMethodBeat.o(88705);
    return false;
  }
  
  public boolean beV()
  {
    AppMethodBeat.i(88706);
    if ((this.klk.bbe().wDU != null) && (this.klk.bbe().wDU.size() > 0) && (((bex()) && (bey())) || (this.kyA)))
    {
      AppMethodBeat.o(88706);
      return true;
    }
    AppMethodBeat.o(88706);
    return false;
  }
  
  public boolean beW()
  {
    return false;
  }
  
  public final boolean beX()
  {
    AppMethodBeat.i(88707);
    if ((this.klk.bbe().wDY != null) && (!TextUtils.isEmpty(this.klk.bbe().wDY.title)))
    {
      AppMethodBeat.o(88707);
      return true;
    }
    AppMethodBeat.o(88707);
    return false;
  }
  
  public boolean beY()
  {
    AppMethodBeat.i(88708);
    if ((this.klk.bbe().wEb != null) && (!TextUtils.isEmpty(this.klk.bbe().wEb.title)))
    {
      AppMethodBeat.o(88708);
      return true;
    }
    AppMethodBeat.o(88708);
    return false;
  }
  
  public boolean beZ()
  {
    AppMethodBeat.i(88709);
    if (this.klk.bbd().wGn != null)
    {
      AppMethodBeat.o(88709);
      return true;
    }
    AppMethodBeat.o(88709);
    return false;
  }
  
  public final String bew()
  {
    AppMethodBeat.i(88694);
    String str = "";
    if (!TextUtils.isEmpty(this.klk.bbd().wGx)) {
      str = this.klk.bbd().wGx;
    }
    for (;;)
    {
      AppMethodBeat.o(88694);
      return str;
      if (this.klk.bbe().wDV == 0L) {
        str = getString(2131298004);
      } else if (this.klk.bbe().wDW == 0) {
        if (!TextUtils.isEmpty(this.klk.bbd().wGe)) {
          str = this.klk.bbd().wGe;
        } else {
          str = getString(2131297860);
        }
      }
    }
  }
  
  public final boolean bex()
  {
    AppMethodBeat.i(88696);
    if ((this.klk.bbe().status == 0) || (this.klk.bbe().status == 1) || (this.klk.bbe().status == 2))
    {
      AppMethodBeat.o(88696);
      return true;
    }
    AppMethodBeat.o(88696);
    return false;
  }
  
  public final boolean bey()
  {
    AppMethodBeat.i(88697);
    if ((this.ktU.ejF == 3) || ((this.ktU.ejF == 6) && (this.klk.bbe().wDS == 0)) || (this.ktU.ejF == 4) || (this.ktU.ejF == 5) || (this.ktU.ejF == 15))
    {
      AppMethodBeat.o(88697);
      return true;
    }
    AppMethodBeat.o(88697);
    return false;
  }
  
  public boolean bfa()
  {
    AppMethodBeat.i(88710);
    if (!TextUtils.isEmpty(this.klk.bbd().wGk))
    {
      AppMethodBeat.o(88710);
      return true;
    }
    AppMethodBeat.o(88710);
    return false;
  }
  
  public boolean bfb()
  {
    return false;
  }
  
  public boolean bfc()
  {
    return false;
  }
  
  public final void bfd()
  {
    int i6 = 1;
    AppMethodBeat.i(88711);
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
    if (bez())
    {
      i = 1;
      str = bew();
      if (!this.kyA) {
        break label240;
      }
      j = 1;
      if (!beD()) {
        break label245;
      }
      k = 1;
      if (!this.kyC) {
        break label250;
      }
      m = 1;
      if (!this.kyD) {
        break label256;
      }
      n = 1;
      if (!this.kyE) {
        break label262;
      }
      i1 = 1;
      if (!this.kyF) {
        break label268;
      }
      i2 = 1;
      if (!this.kyG) {
        break label274;
      }
      i3 = 1;
      if (!this.kyH) {
        break label280;
      }
      i4 = 1;
      if (!this.kyI) {
        break label286;
      }
      i5 = 1;
      label112:
      if (!this.kyJ) {
        break label292;
      }
    }
    for (;;)
    {
      ab.i("MicroMsg.CardBaseShowLogic", "printStatus, isValidCode:%d, getUnacceptWording:%s, isAcceptedCard:%d, acceptViewVisible:%d, acceptViewEnabled:%d, isShowConsumedBtn:%d, isConsumedBtnEnabled:%d, enableOptionMenu:%d, isShareLogoVisible:%d, addShareMenu:%d, addMenu:%d, addInvalidCardMenu:%d ", new Object[] { Integer.valueOf(i), str, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6) });
      AppMethodBeat.o(88711);
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
    this.klk = null;
    this.ktU = null;
    this.jpX = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.a.a
 * JD-Core Version:    0.7.0.1
 */