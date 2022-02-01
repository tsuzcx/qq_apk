package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.d.ai;
import com.tencent.mm.plugin.game.d.ak;
import com.tencent.mm.plugin.game.d.al;
import com.tencent.mm.plugin.game.d.am;
import com.tencent.mm.plugin.game.d.aq;
import com.tencent.mm.plugin.game.d.bh;
import com.tencent.mm.plugin.game.d.ce;
import com.tencent.mm.plugin.game.d.dx;
import com.tencent.mm.plugin.game.f.d;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;

public final class ac
  extends x
{
  private bh udF;
  public ce udG;
  public a udH;
  public al udI;
  public dx udJ;
  public aq udK;
  
  public ac(bh parambh)
  {
    AppMethodBeat.i(41537);
    if (parambh == null)
    {
      this.udF = new bh();
      AppMethodBeat.o(41537);
      return;
    }
    this.udF = parambh;
    nd(true);
    AppMethodBeat.o(41537);
  }
  
  public ac(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41538);
    this.udF = new bh();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(41538);
      return;
    }
    try
    {
      this.udF.parseFrom(paramArrayOfByte);
      nd(false);
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
  
  private void cZx()
  {
    AppMethodBeat.i(41541);
    if (this.udF == null)
    {
      AppMethodBeat.o(41541);
      return;
    }
    this.udG = this.udF.uil;
    if ((this.udF.uii != null) && (this.udF.uii.ueZ != null))
    {
      this.udH = new a();
      this.udH.udL = a(this.udF.uii.ueZ);
      if (this.udH.udL != null)
      {
        this.udH.udL.uaB = this.udF.uii.Desc;
        this.udH.udL.scene = 10;
        this.udH.udL.dFG = 1002;
        this.udH.udL.position = 1;
      }
      this.udH.udM = this.udF.uii.ugN;
      this.udH.udN = this.udF.uii.ugM;
      this.udH.desc = this.udF.uii.Desc;
      this.udH.udO = this.udF.uik;
    }
    this.udI = this.udF.uij;
    this.udJ = this.udF.uim;
    this.udK = this.udF.uio;
    AppMethodBeat.o(41541);
  }
  
  private void nd(boolean paramBoolean)
  {
    AppMethodBeat.i(41539);
    cZx();
    ne(paramBoolean);
    AppMethodBeat.o(41539);
  }
  
  private void ne(boolean paramBoolean)
  {
    AppMethodBeat.i(41540);
    if ((this.udF == null) || (!paramBoolean))
    {
      AppMethodBeat.o(41540);
      return;
    }
    if ((this.udF.uii != null) && (this.udF.uii.ueZ != null)) {
      d.c(a(this.udF.uii.ueZ));
    }
    ((e)g.ab(e.class)).cWF().init(com.tencent.mm.sdk.platformtools.aj.getContext());
    AppMethodBeat.o(41540);
  }
  
  public static final class a
  {
    public String desc;
    public c udL;
    public com.tencent.mm.plugin.game.d.aj udM;
    public ak udN;
    public am udO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ac
 * JD-Core Version:    0.7.0.1
 */