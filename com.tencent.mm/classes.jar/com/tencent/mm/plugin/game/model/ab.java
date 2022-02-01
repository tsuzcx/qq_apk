package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.game.d.av;
import com.tencent.mm.plugin.game.d.bi;
import com.tencent.mm.plugin.game.d.r;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;

public final class ab
  extends x
{
  private bi rXW;
  
  public ab(a parama)
  {
    AppMethodBeat.i(41535);
    if (parama == null)
    {
      this.rXW = new bi();
      AppMethodBeat.o(41535);
      return;
    }
    this.rXW = ((bi)parama);
    AppMethodBeat.o(41535);
  }
  
  public ab(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41536);
    this.rXW = new bi();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(41536);
      return;
    }
    try
    {
      this.rXW.parseFrom(paramArrayOfByte);
      AppMethodBeat.o(41536);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      ad.e("MicroMsg.GamePBDataDownloadGuidance", "Parsing Failed: %s", new Object[] { paramArrayOfByte.getMessage() });
      AppMethodBeat.o(41536);
    }
  }
  
  public final r cDF()
  {
    if (this.rXW != null) {
      return this.rXW.scr;
    }
    return null;
  }
  
  public final av cDG()
  {
    if (this.rXW != null) {
      return this.rXW.scs;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ab
 * JD-Core Version:    0.7.0.1
 */