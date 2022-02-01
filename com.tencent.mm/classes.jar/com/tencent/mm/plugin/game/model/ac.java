package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.e.d;
import com.tencent.mm.plugin.game.protobuf.ap;
import com.tencent.mm.plugin.game.protobuf.aq;
import com.tencent.mm.plugin.game.protobuf.ar;
import com.tencent.mm.plugin.game.protobuf.as;
import com.tencent.mm.plugin.game.protobuf.at;
import com.tencent.mm.plugin.game.protobuf.ax;
import com.tencent.mm.plugin.game.protobuf.bo;
import com.tencent.mm.plugin.game.protobuf.cl;
import com.tencent.mm.plugin.game.protobuf.eg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.IOException;

public final class ac
  extends x
{
  private bo xHg;
  public cl xHh;
  public a xHi;
  public as xHj;
  public eg xHk;
  public ax xHl;
  
  public ac(bo parambo)
  {
    AppMethodBeat.i(41537);
    if (parambo == null)
    {
      this.xHg = new bo();
      AppMethodBeat.o(41537);
      return;
    }
    this.xHg = parambo;
    pN(true);
    AppMethodBeat.o(41537);
  }
  
  public ac(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41538);
    this.xHg = new bo();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(41538);
      return;
    }
    try
    {
      this.xHg.parseFrom(paramArrayOfByte);
      pN(false);
      AppMethodBeat.o(41538);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      for (;;)
      {
        Log.e("MicroMsg.GamePBDataIndex4", "Parsing Failed: %s", new Object[] { paramArrayOfByte.getMessage() });
      }
    }
  }
  
  private void dVP()
  {
    AppMethodBeat.i(41541);
    if (this.xHg == null)
    {
      AppMethodBeat.o(41541);
      return;
    }
    this.xHh = this.xHg.xLM;
    if ((this.xHg.xLJ != null) && (this.xHg.xLJ.xIz != null))
    {
      this.xHi = new a();
      this.xHi.xHm = a(this.xHg.xLJ.xIz);
      if (this.xHi.xHm != null)
      {
        this.xHi.xHm.xDV = this.xHg.xLJ.Desc;
        this.xHi.xHm.scene = 10;
        this.xHi.xHm.dYu = 1002;
        this.xHi.xHm.position = 1;
      }
      this.xHi.xHn = this.xHg.xLJ.xKC;
      this.xHi.xHo = this.xHg.xLJ.xKB;
      this.xHi.desc = this.xHg.xLJ.Desc;
      this.xHi.xHp = this.xHg.xLL;
    }
    this.xHj = this.xHg.xLK;
    this.xHk = this.xHg.xLN;
    this.xHl = this.xHg.xLO;
    AppMethodBeat.o(41541);
  }
  
  private void pN(boolean paramBoolean)
  {
    AppMethodBeat.i(41539);
    dVP();
    pO(paramBoolean);
    AppMethodBeat.o(41539);
  }
  
  private void pO(boolean paramBoolean)
  {
    AppMethodBeat.i(41540);
    if ((this.xHg == null) || (!paramBoolean))
    {
      AppMethodBeat.o(41540);
      return;
    }
    if ((this.xHg.xLJ != null) && (this.xHg.xLJ.xIz != null)) {
      d.c(a(this.xHg.xLJ.xIz));
    }
    ((e)g.af(e.class)).dSI().init(MMApplicationContext.getContext());
    AppMethodBeat.o(41540);
  }
  
  public static final class a
  {
    public String desc;
    public c xHm;
    public aq xHn;
    public ar xHo;
    public at xHp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ac
 * JD-Core Version:    0.7.0.1
 */