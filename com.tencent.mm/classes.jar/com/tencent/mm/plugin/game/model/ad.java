package com.tencent.mm.plugin.game.model;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.b;
import com.tencent.mm.plugin.game.d.ag;
import com.tencent.mm.plugin.game.d.al;
import com.tencent.mm.plugin.game.d.bd;
import com.tencent.mm.plugin.game.d.bx;
import com.tencent.mm.plugin.game.d.dh;
import com.tencent.mm.plugin.game.f.d;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.IOException;

public final class ad
  extends y
{
  public ad.a kQA;
  public ag kQB;
  public dh kQC;
  public al kQD;
  private bd kQy;
  public bx kQz;
  
  public ad(bd parambd)
  {
    if (parambd == null)
    {
      this.kQy = new bd();
      return;
    }
    this.kQy = parambd;
    gw(true);
  }
  
  public ad(byte[] paramArrayOfByte)
  {
    this.kQy = new bd();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return;
    }
    try
    {
      this.kQy.aH(paramArrayOfByte);
      gw(false);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.GamePBDataIndex4", "Parsing Failed: %s", new Object[] { paramArrayOfByte.getMessage() });
      }
    }
  }
  
  private void gw(boolean paramBoolean)
  {
    if (this.kQy != null)
    {
      this.kQz = this.kQy.kUK;
      if ((this.kQy.kUH != null) && (this.kQy.kUH.kRQ != null))
      {
        this.kQA = new ad.a();
        this.kQA.kQE = a(this.kQy.kUH.kRQ);
        if (this.kQA.kQE != null)
        {
          this.kQA.kQE.kNX = this.kQy.kUH.kRN;
          this.kQA.kQE.scene = 10;
          this.kQA.kQE.bXn = 1002;
          this.kQA.kQE.position = 1;
        }
        this.kQA.kQF = this.kQy.kUH.kTv;
        this.kQA.kQG = this.kQy.kUH.kTu;
        this.kQA.desc = this.kQy.kUH.kRN;
        this.kQA.kQH = this.kQy.kUJ;
      }
      this.kQB = this.kQy.kUI;
      this.kQC = this.kQy.kUL;
      this.kQD = this.kQy.kUM;
    }
    if ((this.kQy == null) || (!paramBoolean)) {
      return;
    }
    if ((this.kQy.kUH != null) && (this.kQy.kUH.kRQ != null)) {
      d.a(a(this.kQy.kUH.kRQ));
    }
    ((b)g.r(b.class)).aYc().init(ae.getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ad
 * JD-Core Version:    0.7.0.1
 */