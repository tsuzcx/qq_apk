package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.d.d;
import com.tencent.mm.plugin.game.protobuf.aq;
import com.tencent.mm.plugin.game.protobuf.ar;
import com.tencent.mm.plugin.game.protobuf.as;
import com.tencent.mm.plugin.game.protobuf.at;
import com.tencent.mm.plugin.game.protobuf.au;
import com.tencent.mm.plugin.game.protobuf.ay;
import com.tencent.mm.plugin.game.protobuf.bp;
import com.tencent.mm.plugin.game.protobuf.cm;
import com.tencent.mm.plugin.game.protobuf.eh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.IOException;

public final class ac
  extends x
{
  private bp CLj;
  public cm CLk;
  public a CLl;
  public at CLm;
  public eh CLn;
  public ay CLo;
  
  public ac(bp parambp)
  {
    AppMethodBeat.i(41537);
    if (parambp == null)
    {
      this.CLj = new bp();
      AppMethodBeat.o(41537);
      return;
    }
    this.CLj = parambp;
    sk(true);
    AppMethodBeat.o(41537);
  }
  
  public ac(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41538);
    this.CLj = new bp();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(41538);
      return;
    }
    try
    {
      this.CLj.parseFrom(paramArrayOfByte);
      sk(false);
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
  
  private void eyX()
  {
    AppMethodBeat.i(41541);
    if (this.CLj == null)
    {
      AppMethodBeat.o(41541);
      return;
    }
    this.CLk = this.CLj.CPV;
    if ((this.CLj.CPS != null) && (this.CLj.CPS.CME != null))
    {
      this.CLl = new a();
      this.CLl.CLp = a(this.CLj.CPS.CME);
      if (this.CLl.CLp != null)
      {
        this.CLl.CLp.CHW = this.CLj.CPS.CMB;
        this.CLl.CLp.scene = 10;
        this.CLl.CLp.fSl = 1002;
        this.CLl.CLp.position = 1;
      }
      this.CLl.CLq = this.CLj.CPS.COJ;
      this.CLl.CLr = this.CLj.CPS.COI;
      this.CLl.desc = this.CLj.CPS.CMB;
      this.CLl.CLs = this.CLj.CPU;
    }
    this.CLm = this.CLj.CPT;
    this.CLn = this.CLj.CPW;
    this.CLo = this.CLj.CPX;
    AppMethodBeat.o(41541);
  }
  
  private void sk(boolean paramBoolean)
  {
    AppMethodBeat.i(41539);
    eyX();
    sl(paramBoolean);
    AppMethodBeat.o(41539);
  }
  
  private void sl(boolean paramBoolean)
  {
    AppMethodBeat.i(41540);
    if ((this.CLj == null) || (!paramBoolean))
    {
      AppMethodBeat.o(41540);
      return;
    }
    if ((this.CLj.CPS != null) && (this.CLj.CPS.CME != null)) {
      d.c(a(this.CLj.CPS.CME));
    }
    ((e)h.ae(e.class)).evm().init(MMApplicationContext.getContext());
    AppMethodBeat.o(41540);
  }
  
  public static final class a
  {
    public c CLp;
    public ar CLq;
    public as CLr;
    public au CLs;
    public String desc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ac
 * JD-Core Version:    0.7.0.1
 */