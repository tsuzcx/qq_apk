package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.d.ag;
import com.tencent.mm.plugin.game.d.ah;
import com.tencent.mm.plugin.game.d.ai;
import com.tencent.mm.plugin.game.d.ak;
import com.tencent.mm.plugin.game.d.ao;
import com.tencent.mm.plugin.game.d.be;
import com.tencent.mm.plugin.game.d.by;
import com.tencent.mm.plugin.game.d.dj;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;

public final class ac
  extends x
{
  private be rXX;
  public by rXY;
  public a rXZ;
  public com.tencent.mm.plugin.game.d.aj rYa;
  public dj rYb;
  public ao rYc;
  
  public ac(be parambe)
  {
    AppMethodBeat.i(41537);
    if (parambe == null)
    {
      this.rXX = new be();
      AppMethodBeat.o(41537);
      return;
    }
    this.rXX = parambe;
    lQ(true);
    AppMethodBeat.o(41537);
  }
  
  public ac(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41538);
    this.rXX = new be();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(41538);
      return;
    }
    try
    {
      this.rXX.parseFrom(paramArrayOfByte);
      lQ(false);
      AppMethodBeat.o(41538);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      for (;;)
      {
        ad.e("MicroMsg.GamePBDataIndex4", "Parsing Failed: %s", new Object[] { paramArrayOfByte.getMessage() });
      }
    }
  }
  
  private void cDH()
  {
    AppMethodBeat.i(41541);
    if (this.rXX == null)
    {
      AppMethodBeat.o(41541);
      return;
    }
    this.rXY = this.rXX.sco;
    if ((this.rXX.scl != null) && (this.rXX.scl.rZp != null))
    {
      this.rXZ = new a();
      this.rXZ.rYd = a(this.rXX.scl.rZp);
      if (this.rXZ.rYd != null)
      {
        this.rXZ.rYd.rUT = this.rXX.scl.Desc;
        this.rXZ.rYd.scene = 10;
        this.rXZ.rYd.dvS = 1002;
        this.rXZ.rYd.position = 1;
      }
      this.rXZ.rYe = this.rXX.scl.saY;
      this.rXZ.rYf = this.rXX.scl.saX;
      this.rXZ.desc = this.rXX.scl.Desc;
      this.rXZ.rYg = this.rXX.scn;
    }
    this.rYa = this.rXX.scm;
    this.rYb = this.rXX.scp;
    this.rYc = this.rXX.scq;
    AppMethodBeat.o(41541);
  }
  
  private void lQ(boolean paramBoolean)
  {
    AppMethodBeat.i(41539);
    cDH();
    lR(paramBoolean);
    AppMethodBeat.o(41539);
  }
  
  private void lR(boolean paramBoolean)
  {
    AppMethodBeat.i(41540);
    if ((this.rXX == null) || (!paramBoolean))
    {
      AppMethodBeat.o(41540);
      return;
    }
    if ((this.rXX.scl != null) && (this.rXX.scl.rZp != null)) {
      com.tencent.mm.plugin.game.f.d.c(a(this.rXX.scl.rZp));
    }
    ((com.tencent.mm.plugin.game.api.d)g.ab(com.tencent.mm.plugin.game.api.d.class)).cBb().init(com.tencent.mm.sdk.platformtools.aj.getContext());
    AppMethodBeat.o(41540);
  }
  
  public static final class a
  {
    public String desc;
    public c rYd;
    public ah rYe;
    public ai rYf;
    public ak rYg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ac
 * JD-Core Version:    0.7.0.1
 */