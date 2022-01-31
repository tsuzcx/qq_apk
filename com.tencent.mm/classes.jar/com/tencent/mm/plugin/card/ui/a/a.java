package com.tencent.mm.plugin.card.ui.a;

import android.text.TextUtils;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.ui.e.a;
import com.tencent.mm.protocal.c.lv;
import com.tencent.mm.protocal.c.mg;
import com.tencent.mm.protocal.c.ra;
import com.tencent.mm.protocal.c.tw;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public class a
  implements g
{
  protected MMActivity hxN;
  protected b ikk;
  protected e.a isN;
  private boolean ixA = false;
  private boolean ixB = false;
  private boolean ixC = false;
  private boolean ixD = false;
  private boolean ixE = false;
  private boolean ixF = false;
  private boolean ixG = false;
  boolean ixx = false;
  private boolean ixy = false;
  private boolean ixz = false;
  
  public a(MMActivity paramMMActivity)
  {
    this.hxN = paramMMActivity;
  }
  
  private boolean aCp()
  {
    return !TextUtils.isEmpty(this.ikk.azy().code);
  }
  
  private String getString(int paramInt)
  {
    return this.hxN.getString(paramInt);
  }
  
  public final void a(b paramb, e.a parama)
  {
    this.ikk = paramb;
    this.isN = parama;
    aCs();
  }
  
  public final boolean aBP()
  {
    return this.ixx;
  }
  
  public final boolean aCA()
  {
    return this.ixG;
  }
  
  public boolean aCB()
  {
    return true;
  }
  
  public boolean aCC()
  {
    return false;
  }
  
  public boolean aCD()
  {
    return false;
  }
  
  public boolean aCE()
  {
    return ((this.isN.drX == 6) && ((!this.ikk.isNormal()) || (this.ikk.azu()))) || (this.isN.drX == 5) || ((this.isN.drX == 23) && (this.ikk.azw()));
  }
  
  public boolean aCF()
  {
    return false;
  }
  
  public boolean aCG()
  {
    return true;
  }
  
  public boolean aCH()
  {
    return ((aCp()) && (aCn()) && (aCo())) || (this.ixx);
  }
  
  public boolean aCI()
  {
    return false;
  }
  
  public boolean aCJ()
  {
    return !this.ikk.isNormal();
  }
  
  public boolean aCK()
  {
    return (this.ikk.azx().sII != null) && (this.ikk.azx().sII.sQI != null) && (this.ikk.azx().sII.sQI.size() > 0) && (!TextUtils.isEmpty((CharSequence)this.ikk.azx().sII.sQI.get(0)));
  }
  
  public boolean aCL()
  {
    return (this.ikk.azy().sHy != null) && (this.ikk.azy().sHy.size() > 0) && (((aCn()) && (aCo())) || (this.ixx));
  }
  
  public boolean aCM()
  {
    return false;
  }
  
  public final boolean aCN()
  {
    return (this.ikk.azy().sHC != null) && (!TextUtils.isEmpty(this.ikk.azy().sHC.title));
  }
  
  public boolean aCO()
  {
    return (this.ikk.azy().sHF != null) && (!TextUtils.isEmpty(this.ikk.azy().sHF.title));
  }
  
  public boolean aCP()
  {
    return this.ikk.azx().sIE != null;
  }
  
  public boolean aCQ()
  {
    return !TextUtils.isEmpty(this.ikk.azx().sIB);
  }
  
  public boolean aCR()
  {
    return false;
  }
  
  public boolean aCS()
  {
    return false;
  }
  
  public final void aCT()
  {
    int i6 = 1;
    int i;
    String str;
    int j;
    label27:
    int k;
    label36:
    int m;
    label46:
    int n;
    label56:
    int i1;
    label66:
    int i2;
    label76:
    int i3;
    label86:
    int i4;
    label96:
    int i5;
    if (aCp())
    {
      i = 1;
      str = aCm();
      if (!this.ixx) {
        break label227;
      }
      j = 1;
      if (!aCt()) {
        break label232;
      }
      k = 1;
      if (!this.ixz) {
        break label237;
      }
      m = 1;
      if (!this.ixA) {
        break label243;
      }
      n = 1;
      if (!this.ixB) {
        break label249;
      }
      i1 = 1;
      if (!this.ixC) {
        break label255;
      }
      i2 = 1;
      if (!this.ixD) {
        break label261;
      }
      i3 = 1;
      if (!this.ixE) {
        break label267;
      }
      i4 = 1;
      if (!this.ixF) {
        break label273;
      }
      i5 = 1;
      label106:
      if (!this.ixG) {
        break label279;
      }
    }
    for (;;)
    {
      y.i("MicroMsg.CardBaseShowLogic", "printStatus, isValidCode:%d, getUnacceptWording:%s, isAcceptedCard:%d, acceptViewVisible:%d, acceptViewEnabled:%d, isShowConsumedBtn:%d, isConsumedBtnEnabled:%d, enableOptionMenu:%d, isShareLogoVisible:%d, addShareMenu:%d, addMenu:%d, addInvalidCardMenu:%d ", new Object[] { Integer.valueOf(i), str, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6) });
      return;
      i = 0;
      break;
      label227:
      j = 0;
      break label27;
      label232:
      k = 0;
      break label36;
      label237:
      m = 0;
      break label46;
      label243:
      n = 0;
      break label56;
      label249:
      i1 = 0;
      break label66;
      label255:
      i2 = 0;
      break label76;
      label261:
      i3 = 0;
      break label86;
      label267:
      i4 = 0;
      break label96;
      label273:
      i5 = 0;
      break label106;
      label279:
      i6 = 0;
    }
  }
  
  public final String aCm()
  {
    String str = "";
    if (!TextUtils.isEmpty(this.ikk.azx().sIO)) {
      str = this.ikk.azx().sIO;
    }
    do
    {
      return str;
      if (this.ikk.azy().sHz == 0L) {
        return getString(a.g.card_no_stock);
      }
    } while (this.ikk.azy().sHA != 0);
    if (!TextUtils.isEmpty(this.ikk.azx().sIv)) {
      return this.ikk.azx().sIv;
    }
    return getString(a.g.card_accept_over_limite);
  }
  
  public final boolean aCn()
  {
    return (this.ikk.azy().status == 0) || (this.ikk.azy().status == 1) || (this.ikk.azy().status == 2);
  }
  
  public final boolean aCo()
  {
    return (this.isN.drX == 3) || ((this.isN.drX == 6) && (this.ikk.azy().sHw == 0)) || (this.isN.drX == 4) || (this.isN.drX == 5) || (this.isN.drX == 15);
  }
  
  protected final boolean aCq()
  {
    return (!this.ikk.isAcceptable()) && ((l.pe(this.isN.drX)) || (l.pf(this.isN.drX)) || (this.isN.drX == 23));
  }
  
  protected final boolean aCr()
  {
    return (!this.ikk.azu()) && (this.isN.drX == 6);
  }
  
  protected void aCs()
  {
    y.i("MicroMsg.CardBaseShowLogic", "updateAcceptState()");
    if ((l.pe(this.isN.drX)) || (l.pf(this.isN.drX))) {
      if (this.ikk.isAcceptable())
      {
        this.ixy = true;
        this.ixz = true;
        this.ixE = true;
        this.ixC = true;
        this.ixD = true;
        if (!this.ikk.azt()) {
          break label561;
        }
        this.ixy = false;
        this.ixz = false;
        y.i("MicroMsg.CardBaseShowLogic", "need direct jump!");
        label100:
        if (!this.ixx) {
          break label572;
        }
        this.ixy = false;
        this.ixz = false;
        y.i("MicroMsg.CardBaseShowLogic", "updateAcceptView to gone!");
      }
    }
    for (;;)
    {
      y.i("MicroMsg.CardBaseShowLogic", "mIsAcceptedCard:" + this.ixx);
      return;
      if (!this.ikk.isAcceptable())
      {
        this.ixy = true;
        this.ixz = false;
        if (this.ikk.azt())
        {
          this.ixF = true;
          this.ixC = true;
          this.ixB = true;
        }
        for (;;)
        {
          this.ixD = true;
          break;
          this.ixC = false;
        }
      }
      this.ixy = false;
      this.ixz = false;
      this.ixC = false;
      break;
      if (this.isN.drX == 6)
      {
        if (this.ikk.azu())
        {
          this.ixy = true;
          this.ixz = true;
          this.ixC = false;
          break;
        }
        if (this.ikk.isNormal())
        {
          this.ixF = true;
          this.ixC = true;
          this.ixA = true;
          this.ixB = true;
          break;
        }
        this.ixy = false;
        this.ixz = false;
        this.ixC = false;
        this.ixA = true;
        break;
      }
      if (l.pg(this.isN.drX))
      {
        this.ixy = false;
        this.ixz = false;
        this.ixA = true;
        if (this.ikk.isNormal())
        {
          this.ixF = true;
          this.ixC = true;
          this.ixB = true;
          break;
        }
        this.ixG = true;
        break;
      }
      if (this.isN.drX != 23) {
        break;
      }
      if (this.ikk.isAcceptable())
      {
        this.ixy = true;
        this.ixz = true;
        this.ixC = false;
      }
      for (this.ixD = true;; this.ixD = true)
      {
        if ((TextUtils.isEmpty(this.isN.irV)) || (this.isN.irV.equals(q.Gj())) || (this.ikk.azw())) {
          break label559;
        }
        y.i("MicroMsg.CardBaseShowLogic", " detail page");
        this.ixy = false;
        this.ixz = false;
        this.ixA = true;
        if (!this.ikk.isNormal()) {
          break;
        }
        this.ixF = true;
        this.ixC = true;
        this.ixB = true;
        break;
        this.ixy = true;
        this.ixz = false;
        this.ixC = false;
      }
      label559:
      break;
      label561:
      y.i("MicroMsg.CardBaseShowLogic", "not need direct jump!");
      break label100;
      label572:
      if (!this.ixy)
      {
        this.ixx = true;
        y.i("MicroMsg.CardBaseShowLogic", "set mIsAcceptedCard is true");
      }
      else
      {
        this.ixx = false;
        y.i("MicroMsg.CardBaseShowLogic", "set mIsAcceptedCard is false!");
      }
    }
  }
  
  public boolean aCt()
  {
    return this.ixy;
  }
  
  public final boolean aCu()
  {
    return this.ixz;
  }
  
  public final boolean aCv()
  {
    return this.ixA;
  }
  
  public final boolean aCw()
  {
    return this.ixB;
  }
  
  public final boolean aCx()
  {
    return this.ixC;
  }
  
  public final boolean aCy()
  {
    return this.ixE;
  }
  
  public final boolean aCz()
  {
    return this.ixF;
  }
  
  public final void release()
  {
    this.ikk = null;
    this.isN = null;
    this.hxN = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.a.a
 * JD-Core Version:    0.7.0.1
 */