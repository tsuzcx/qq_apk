package com.tencent.mm.plugin.card.ui.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.c.l;
import com.tencent.mm.plugin.card.ui.e.b;
import com.tencent.mm.protocal.protobuf.aek;
import com.tencent.mm.protocal.protobuf.akb;
import com.tencent.mm.protocal.protobuf.vr;
import com.tencent.mm.protocal.protobuf.ws;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public class a
  implements g
{
  protected e.b wAo;
  private boolean wEY = false;
  private boolean wEZ = false;
  private boolean wFa = false;
  private boolean wFb = false;
  private boolean wFc = false;
  private boolean wFd = false;
  private boolean wFe = false;
  private boolean wFf = false;
  private boolean wFg = false;
  private boolean wFh = false;
  protected b wru;
  protected MMActivity wry;
  
  public a(MMActivity paramMMActivity)
  {
    this.wry = paramMMActivity;
  }
  
  private boolean dnk()
  {
    AppMethodBeat.i(113625);
    if (!TextUtils.isEmpty(this.wru.djL().code))
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
    String str = this.wry.getString(paramInt);
    AppMethodBeat.o(113622);
    return str;
  }
  
  public final void a(b paramb, e.b paramb1)
  {
    AppMethodBeat.i(113620);
    this.wru = paramb;
    this.wAo = paramb1;
    dnn();
    AppMethodBeat.o(113620);
  }
  
  public final boolean dmH()
  {
    return this.wEY;
  }
  
  public boolean dnA()
  {
    AppMethodBeat.i(113629);
    if (((this.wAo.lCR == 6) && ((!this.wru.djF()) || (this.wru.djH()))) || (this.wAo.lCR == 5) || ((this.wAo.lCR == 23) && (this.wru.djJ())))
    {
      AppMethodBeat.o(113629);
      return true;
    }
    AppMethodBeat.o(113629);
    return false;
  }
  
  public boolean dnB()
  {
    return false;
  }
  
  public boolean dnC()
  {
    return true;
  }
  
  public boolean dnD()
  {
    AppMethodBeat.i(113630);
    if (((dnk()) && (dni()) && (dnj())) || (this.wEY))
    {
      AppMethodBeat.o(113630);
      return true;
    }
    AppMethodBeat.o(113630);
    return false;
  }
  
  public boolean dnE()
  {
    return false;
  }
  
  public boolean dnF()
  {
    AppMethodBeat.i(113631);
    if (!this.wru.djF())
    {
      AppMethodBeat.o(113631);
      return true;
    }
    AppMethodBeat.o(113631);
    return false;
  }
  
  public boolean dnG()
  {
    AppMethodBeat.i(113632);
    if ((this.wru.djK().Zeb != null) && (this.wru.djK().Zeb.Zrh != null) && (this.wru.djK().Zeb.Zrh.size() > 0) && (!TextUtils.isEmpty((CharSequence)this.wru.djK().Zeb.Zrh.get(0))))
    {
      AppMethodBeat.o(113632);
      return true;
    }
    AppMethodBeat.o(113632);
    return false;
  }
  
  public boolean dnH()
  {
    AppMethodBeat.i(113633);
    if ((this.wru.djL().Zbz != null) && (this.wru.djL().Zbz.size() > 0) && (((dni()) && (dnj())) || (this.wEY)))
    {
      AppMethodBeat.o(113633);
      return true;
    }
    AppMethodBeat.o(113633);
    return false;
  }
  
  public boolean dnI()
  {
    return false;
  }
  
  public final boolean dnJ()
  {
    AppMethodBeat.i(113634);
    if ((this.wru.djL().ZbD != null) && (!TextUtils.isEmpty(this.wru.djL().ZbD.title)))
    {
      AppMethodBeat.o(113634);
      return true;
    }
    AppMethodBeat.o(113634);
    return false;
  }
  
  public boolean dnK()
  {
    AppMethodBeat.i(113635);
    if ((this.wru.djL().ZbG != null) && (!TextUtils.isEmpty(this.wru.djL().ZbG.title)))
    {
      AppMethodBeat.o(113635);
      return true;
    }
    AppMethodBeat.o(113635);
    return false;
  }
  
  public boolean dnL()
  {
    AppMethodBeat.i(113636);
    if (this.wru.djK().ZdX != null)
    {
      AppMethodBeat.o(113636);
      return true;
    }
    AppMethodBeat.o(113636);
    return false;
  }
  
  public boolean dnM()
  {
    AppMethodBeat.i(113637);
    if (!TextUtils.isEmpty(this.wru.djK().ZdU))
    {
      AppMethodBeat.o(113637);
      return true;
    }
    AppMethodBeat.o(113637);
    return false;
  }
  
  public boolean dnN()
  {
    return false;
  }
  
  public boolean dnO()
  {
    return false;
  }
  
  public final void dnP()
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
    if (dnk())
    {
      i = 1;
      str = dnh();
      if (!this.wEY) {
        break label237;
      }
      j = 1;
      if (!dno()) {
        break label242;
      }
      k = 1;
      if (!this.wFa) {
        break label247;
      }
      m = 1;
      if (!this.wFb) {
        break label253;
      }
      n = 1;
      if (!this.wFc) {
        break label259;
      }
      i1 = 1;
      if (!this.wFd) {
        break label265;
      }
      i2 = 1;
      if (!this.wFe) {
        break label271;
      }
      i3 = 1;
      if (!this.wFf) {
        break label277;
      }
      i4 = 1;
      if (!this.wFg) {
        break label283;
      }
      i5 = 1;
      label111:
      if (!this.wFh) {
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
  
  public final String dnh()
  {
    AppMethodBeat.i(113621);
    String str = "";
    if (!TextUtils.isEmpty(this.wru.djK().Zeh)) {
      str = this.wru.djK().Zeh;
    }
    for (;;)
    {
      AppMethodBeat.o(113621);
      return str;
      if (this.wru.djL().ZbA == 0L) {
        str = getString(a.g.wpG);
      } else if (this.wru.djL().ZbB == 0) {
        if (!TextUtils.isEmpty(this.wru.djK().rHe)) {
          str = this.wru.djK().rHe;
        } else {
          str = getString(a.g.wnX);
        }
      }
    }
  }
  
  public final boolean dni()
  {
    AppMethodBeat.i(113623);
    if ((this.wru.djL().status == 0) || (this.wru.djL().status == 1) || (this.wru.djL().status == 2))
    {
      AppMethodBeat.o(113623);
      return true;
    }
    AppMethodBeat.o(113623);
    return false;
  }
  
  public final boolean dnj()
  {
    AppMethodBeat.i(113624);
    if ((this.wAo.lCR == 3) || ((this.wAo.lCR == 6) && (this.wru.djL().Zbx == 0)) || (this.wAo.lCR == 4) || (this.wAo.lCR == 5) || (this.wAo.lCR == 15))
    {
      AppMethodBeat.o(113624);
      return true;
    }
    AppMethodBeat.o(113624);
    return false;
  }
  
  protected final boolean dnl()
  {
    AppMethodBeat.i(113626);
    if ((!this.wru.djG()) && ((l.IL(this.wAo.lCR)) || (l.IM(this.wAo.lCR)) || (this.wAo.lCR == 23)))
    {
      AppMethodBeat.o(113626);
      return true;
    }
    AppMethodBeat.o(113626);
    return false;
  }
  
  protected final boolean dnm()
  {
    AppMethodBeat.i(113627);
    if ((!this.wru.djH()) && (this.wAo.lCR == 6))
    {
      AppMethodBeat.o(113627);
      return true;
    }
    AppMethodBeat.o(113627);
    return false;
  }
  
  protected void dnn()
  {
    AppMethodBeat.i(113628);
    Log.i("MicroMsg.CardBaseShowLogic", "updateAcceptState()");
    if ((l.IL(this.wAo.lCR)) || (l.IM(this.wAo.lCR))) {
      if (this.wru.djG())
      {
        this.wEZ = true;
        this.wFa = true;
        this.wFf = true;
        this.wFd = true;
        this.wFe = true;
        if (!this.wru.djE()) {
          break label574;
        }
        this.wEZ = false;
        this.wFa = false;
        Log.i("MicroMsg.CardBaseShowLogic", "need direct jump!");
        label107:
        if (!this.wEY) {
          break label585;
        }
        this.wEZ = false;
        this.wFa = false;
        Log.i("MicroMsg.CardBaseShowLogic", "updateAcceptView to gone!");
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.CardBaseShowLogic", "mIsAcceptedCard:" + this.wEY);
      AppMethodBeat.o(113628);
      return;
      if (!this.wru.djG())
      {
        this.wEZ = true;
        this.wFa = false;
        if (this.wru.djE())
        {
          this.wFg = true;
          this.wFd = true;
          this.wFc = true;
        }
        for (;;)
        {
          this.wFe = true;
          break;
          this.wFd = false;
        }
      }
      this.wEZ = false;
      this.wFa = false;
      this.wFd = false;
      break;
      if (this.wAo.lCR == 6)
      {
        if (this.wru.djH())
        {
          this.wEZ = true;
          this.wFa = true;
          this.wFd = false;
          break;
        }
        if (this.wru.djF())
        {
          this.wFg = true;
          this.wFd = true;
          this.wFb = true;
          this.wFc = true;
          break;
        }
        this.wEZ = false;
        this.wFa = false;
        this.wFd = false;
        this.wFb = true;
        break;
      }
      if (l.IN(this.wAo.lCR))
      {
        this.wEZ = false;
        this.wFa = false;
        this.wFb = true;
        if (this.wru.djF())
        {
          this.wFg = true;
          this.wFd = true;
          this.wFc = true;
          break;
        }
        this.wFh = true;
        break;
      }
      if (this.wAo.lCR != 23) {
        break;
      }
      if (this.wru.djG())
      {
        this.wEZ = true;
        this.wFa = true;
        this.wFd = false;
      }
      for (this.wFe = true;; this.wFe = true)
      {
        if ((TextUtils.isEmpty(this.wAo.wzv)) || (this.wAo.wzv.equals(z.bAM())) || (this.wru.djJ())) {
          break label572;
        }
        Log.i("MicroMsg.CardBaseShowLogic", " detail page");
        this.wEZ = false;
        this.wFa = false;
        this.wFb = true;
        if (!this.wru.djF()) {
          break;
        }
        this.wFg = true;
        this.wFd = true;
        this.wFc = true;
        break;
        this.wEZ = true;
        this.wFa = false;
        this.wFd = false;
      }
      label572:
      break;
      label574:
      Log.i("MicroMsg.CardBaseShowLogic", "not need direct jump!");
      break label107;
      label585:
      if (!this.wEZ)
      {
        this.wEY = true;
        Log.i("MicroMsg.CardBaseShowLogic", "set mIsAcceptedCard is true");
      }
      else
      {
        this.wEY = false;
        Log.i("MicroMsg.CardBaseShowLogic", "set mIsAcceptedCard is false!");
      }
    }
  }
  
  public boolean dno()
  {
    return this.wEZ;
  }
  
  public final boolean dnp()
  {
    return this.wFa;
  }
  
  public final boolean dnq()
  {
    return this.wFb;
  }
  
  public final boolean dnr()
  {
    return this.wFc;
  }
  
  public final boolean dns()
  {
    return this.wFd;
  }
  
  public final boolean dnt()
  {
    return this.wFe;
  }
  
  public final boolean dnu()
  {
    return this.wFf;
  }
  
  public final boolean dnv()
  {
    return this.wFg;
  }
  
  public final boolean dnw()
  {
    return this.wFh;
  }
  
  public boolean dnx()
  {
    AppMethodBeat.i(293812);
    if (this.wru.djr())
    {
      AppMethodBeat.o(293812);
      return false;
    }
    AppMethodBeat.o(293812);
    return true;
  }
  
  public boolean dny()
  {
    return false;
  }
  
  public boolean dnz()
  {
    return false;
  }
  
  public final void release()
  {
    this.wru = null;
    this.wAo = null;
    this.wry = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.a.a
 * JD-Core Version:    0.7.0.1
 */