package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.d.d;
import com.tencent.mm.plugin.game.protobuf.ar;
import com.tencent.mm.plugin.game.protobuf.as;
import com.tencent.mm.plugin.game.protobuf.at;
import com.tencent.mm.plugin.game.protobuf.au;
import com.tencent.mm.plugin.game.protobuf.av;
import com.tencent.mm.plugin.game.protobuf.az;
import com.tencent.mm.plugin.game.protobuf.bq;
import com.tencent.mm.plugin.game.protobuf.co;
import com.tencent.mm.plugin.game.protobuf.el;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.IOException;

public final class ac
  extends x
{
  private bq IFq;
  public co IFr;
  public a IFs;
  public au IFt;
  public el IFu;
  public az IFv;
  
  public ac(bq parambq)
  {
    AppMethodBeat.i(41537);
    if (parambq == null)
    {
      this.IFq = new bq();
      AppMethodBeat.o(41537);
      return;
    }
    this.IFq = parambq;
    wq(true);
    AppMethodBeat.o(41537);
  }
  
  public ac(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41538);
    this.IFq = new bq();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(41538);
      return;
    }
    try
    {
      this.IFq.parseFrom(paramArrayOfByte);
      wq(false);
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
  
  private void fGT()
  {
    AppMethodBeat.i(41541);
    if (this.IFq == null)
    {
      AppMethodBeat.o(41541);
      return;
    }
    this.IFr = this.IFq.IKf;
    if ((this.IFq.IKc != null) && (this.IFq.IKc.IGJ != null))
    {
      this.IFs = new a();
      this.IFs.IFw = a(this.IFq.IKc.IGJ);
      if (this.IFs.IFw != null)
      {
        this.IFs.IFw.ICg = this.IFq.IKc.IGG;
        this.IFs.IFw.scene = 10;
        this.IFs.IFw.hYi = 1002;
        this.IFs.IFw.position = 1;
      }
      this.IFs.IFx = this.IFq.IKc.IIT;
      this.IFs.IFy = this.IFq.IKc.IIS;
      this.IFs.desc = this.IFq.IKc.IGG;
      this.IFs.IFz = this.IFq.IKe;
    }
    this.IFt = this.IFq.IKd;
    this.IFu = this.IFq.IKg;
    this.IFv = this.IFq.IKh;
    AppMethodBeat.o(41541);
  }
  
  private void wq(boolean paramBoolean)
  {
    AppMethodBeat.i(41539);
    fGT();
    wr(paramBoolean);
    AppMethodBeat.o(41539);
  }
  
  private void wr(boolean paramBoolean)
  {
    AppMethodBeat.i(41540);
    if ((this.IFq == null) || (!paramBoolean))
    {
      AppMethodBeat.o(41540);
      return;
    }
    if ((this.IFq.IKc != null) && (this.IFq.IKc.IGJ != null)) {
      d.c(a(this.IFq.IKc.IGJ));
    }
    ((e)h.ax(e.class)).fCf().init(MMApplicationContext.getContext());
    AppMethodBeat.o(41540);
  }
  
  public static final class a
  {
    public c IFw;
    public as IFx;
    public at IFy;
    public av IFz;
    public String desc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ac
 * JD-Core Version:    0.7.0.1
 */