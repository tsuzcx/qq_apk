package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.d.ao;
import com.tencent.mm.plugin.game.d.ap;
import com.tencent.mm.plugin.game.d.aq;
import com.tencent.mm.plugin.game.d.ar;
import com.tencent.mm.plugin.game.d.as;
import com.tencent.mm.plugin.game.d.aw;
import com.tencent.mm.plugin.game.d.bo;
import com.tencent.mm.plugin.game.d.cl;
import com.tencent.mm.plugin.game.d.eg;
import com.tencent.mm.plugin.game.f.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import java.io.IOException;

public final class ac
  extends x
{
  private bo uoN;
  public cl uoO;
  public a uoP;
  public ar uoQ;
  public eg uoR;
  public aw uoS;
  
  public ac(bo parambo)
  {
    AppMethodBeat.i(41537);
    if (parambo == null)
    {
      this.uoN = new bo();
      AppMethodBeat.o(41537);
      return;
    }
    this.uoN = parambo;
    nh(true);
    AppMethodBeat.o(41537);
  }
  
  public ac(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41538);
    this.uoN = new bo();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(41538);
      return;
    }
    try
    {
      this.uoN.parseFrom(paramArrayOfByte);
      nh(false);
      AppMethodBeat.o(41538);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      for (;;)
      {
        ae.e("MicroMsg.GamePBDataIndex4", "Parsing Failed: %s", new Object[] { paramArrayOfByte.getMessage() });
      }
    }
  }
  
  private void dci()
  {
    AppMethodBeat.i(41541);
    if (this.uoN == null)
    {
      AppMethodBeat.o(41541);
      return;
    }
    this.uoO = this.uoN.utK;
    if ((this.uoN.utH != null) && (this.uoN.utH.uqg != null))
    {
      this.uoP = new a();
      this.uoP.uoT = a(this.uoN.utH.uqg);
      if (this.uoP.uoT != null)
      {
        this.uoP.uoT.ulD = this.uoN.utH.Desc;
        this.uoP.uoT.scene = 10;
        this.uoP.uoT.dGL = 1002;
        this.uoP.uoT.position = 1;
      }
      this.uoP.uoU = this.uoN.utH.usk;
      this.uoP.uoV = this.uoN.utH.usj;
      this.uoP.desc = this.uoN.utH.Desc;
      this.uoP.uoW = this.uoN.utJ;
    }
    this.uoQ = this.uoN.utI;
    this.uoR = this.uoN.utL;
    this.uoS = this.uoN.utM;
    AppMethodBeat.o(41541);
  }
  
  private void nh(boolean paramBoolean)
  {
    AppMethodBeat.i(41539);
    dci();
    ni(paramBoolean);
    AppMethodBeat.o(41539);
  }
  
  private void ni(boolean paramBoolean)
  {
    AppMethodBeat.i(41540);
    if ((this.uoN == null) || (!paramBoolean))
    {
      AppMethodBeat.o(41540);
      return;
    }
    if ((this.uoN.utH != null) && (this.uoN.utH.uqg != null)) {
      d.c(a(this.uoN.utH.uqg));
    }
    ((e)g.ab(e.class)).cZj().init(ak.getContext());
    AppMethodBeat.o(41540);
  }
  
  public static final class a
  {
    public String desc;
    public c uoT;
    public ap uoU;
    public aq uoV;
    public as uoW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ac
 * JD-Core Version:    0.7.0.1
 */