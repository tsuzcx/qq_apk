package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.d.ag;
import com.tencent.mm.plugin.game.d.ah;
import com.tencent.mm.plugin.game.d.aj;
import com.tencent.mm.plugin.game.d.ak;
import com.tencent.mm.plugin.game.d.ao;
import com.tencent.mm.plugin.game.d.be;
import com.tencent.mm.plugin.game.d.by;
import com.tencent.mm.plugin.game.d.dj;
import java.io.IOException;

public final class ac
  extends x
{
  private be tfP;
  public by tfQ;
  public a tfR;
  public aj tfS;
  public dj tfT;
  public ao tfU;
  
  public ac(be parambe)
  {
    AppMethodBeat.i(41537);
    if (parambe == null)
    {
      this.tfP = new be();
      AppMethodBeat.o(41537);
      return;
    }
    this.tfP = parambe;
    mJ(true);
    AppMethodBeat.o(41537);
  }
  
  public ac(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41538);
    this.tfP = new be();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(41538);
      return;
    }
    try
    {
      this.tfP.parseFrom(paramArrayOfByte);
      mJ(false);
      AppMethodBeat.o(41538);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.GamePBDataIndex4", "Parsing Failed: %s", new Object[] { paramArrayOfByte.getMessage() });
      }
    }
  }
  
  private void cQR()
  {
    AppMethodBeat.i(41541);
    if (this.tfP == null)
    {
      AppMethodBeat.o(41541);
      return;
    }
    this.tfQ = this.tfP.tki;
    if ((this.tfP.tkf != null) && (this.tfP.tkf.thi != null))
    {
      this.tfR = new a();
      this.tfR.tfV = a(this.tfP.tkf.thi);
      if (this.tfR.tfV != null)
      {
        this.tfR.tfV.tcL = this.tfP.tkf.Desc;
        this.tfR.tfV.scene = 10;
        this.tfR.tfV.dtF = 1002;
        this.tfR.tfV.position = 1;
      }
      this.tfR.tfW = this.tfP.tkf.tiS;
      this.tfR.tfX = this.tfP.tkf.tiR;
      this.tfR.desc = this.tfP.tkf.Desc;
      this.tfR.tfY = this.tfP.tkh;
    }
    this.tfS = this.tfP.tkg;
    this.tfT = this.tfP.tkj;
    this.tfU = this.tfP.tkk;
    AppMethodBeat.o(41541);
  }
  
  private void mJ(boolean paramBoolean)
  {
    AppMethodBeat.i(41539);
    cQR();
    mK(paramBoolean);
    AppMethodBeat.o(41539);
  }
  
  private void mK(boolean paramBoolean)
  {
    AppMethodBeat.i(41540);
    if ((this.tfP == null) || (!paramBoolean))
    {
      AppMethodBeat.o(41540);
      return;
    }
    if ((this.tfP.tkf != null) && (this.tfP.tkf.thi != null)) {
      com.tencent.mm.plugin.game.f.d.c(a(this.tfP.tkf.thi));
    }
    ((com.tencent.mm.plugin.game.api.d)g.ab(com.tencent.mm.plugin.game.api.d.class)).cOk().init(com.tencent.mm.sdk.platformtools.ai.getContext());
    AppMethodBeat.o(41540);
  }
  
  public static final class a
  {
    public String desc;
    public c tfV;
    public ah tfW;
    public com.tencent.mm.plugin.game.d.ai tfX;
    public ak tfY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ac
 * JD-Core Version:    0.7.0.1
 */