package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.d.ae;
import com.tencent.mm.plugin.game.d.am;
import com.tencent.mm.plugin.game.d.be;
import com.tencent.mm.plugin.game.d.by;
import com.tencent.mm.plugin.game.d.di;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;

public final class ac
  extends x
{
  private be noC;
  public by noD;
  public ac.a noE;
  public com.tencent.mm.plugin.game.d.ah noF;
  public di noG;
  public am noH;
  
  public ac(be parambe)
  {
    AppMethodBeat.i(111372);
    if (parambe == null)
    {
      this.noC = new be();
      AppMethodBeat.o(111372);
      return;
    }
    this.noC = parambe;
    ie(true);
    AppMethodBeat.o(111372);
  }
  
  public ac(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(111373);
    this.noC = new be();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(111373);
      return;
    }
    try
    {
      this.noC.parseFrom(paramArrayOfByte);
      ie(false);
      AppMethodBeat.o(111373);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      for (;;)
      {
        ab.e("MicroMsg.GamePBDataIndex4", "Parsing Failed: %s", new Object[] { paramArrayOfByte.getMessage() });
      }
    }
  }
  
  private void bGM()
  {
    AppMethodBeat.i(111376);
    if (this.noC == null)
    {
      AppMethodBeat.o(111376);
      return;
    }
    this.noD = this.noC.nsM;
    if ((this.noC.nsJ != null) && (this.noC.nsJ.npS != null))
    {
      this.noE = new ac.a();
      this.noE.noI = a(this.noC.nsJ.npS);
      if (this.noE.noI != null)
      {
        this.noE.noI.nlU = this.noC.nsJ.Desc;
        this.noE.noI.scene = 10;
        this.noE.noI.cFj = 1002;
        this.noE.noI.position = 1;
      }
      this.noE.noJ = this.noC.nsJ.nrv;
      this.noE.noK = this.noC.nsJ.nru;
      this.noE.desc = this.noC.nsJ.Desc;
      this.noE.noL = this.noC.nsL;
    }
    this.noF = this.noC.nsK;
    this.noG = this.noC.nsN;
    this.noH = this.noC.nsO;
    AppMethodBeat.o(111376);
  }
  
  private void ie(boolean paramBoolean)
  {
    AppMethodBeat.i(111374);
    bGM();
    jdMethod_if(paramBoolean);
    AppMethodBeat.o(111374);
  }
  
  private void jdMethod_if(boolean paramBoolean)
  {
    AppMethodBeat.i(111375);
    if ((this.noC == null) || (!paramBoolean))
    {
      AppMethodBeat.o(111375);
      return;
    }
    if ((this.noC.nsJ != null) && (this.noC.nsJ.npS != null)) {
      com.tencent.mm.plugin.game.f.d.c(a(this.noC.nsJ.npS));
    }
    ((com.tencent.mm.plugin.game.api.d)g.E(com.tencent.mm.plugin.game.api.d.class)).bEP().init(com.tencent.mm.sdk.platformtools.ah.getContext());
    AppMethodBeat.o(111375);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ac
 * JD-Core Version:    0.7.0.1
 */