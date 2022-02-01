package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.game.d.be;
import com.tencent.mm.plugin.game.d.bs;
import com.tencent.mm.plugin.game.d.v;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.IOException;

public final class ab
  extends x
{
  private bs uoM;
  
  public ab(a parama)
  {
    AppMethodBeat.i(41535);
    if (parama == null)
    {
      this.uoM = new bs();
      AppMethodBeat.o(41535);
      return;
    }
    this.uoM = ((bs)parama);
    AppMethodBeat.o(41535);
  }
  
  public ab(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41536);
    this.uoM = new bs();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(41536);
      return;
    }
    try
    {
      this.uoM.parseFrom(paramArrayOfByte);
      AppMethodBeat.o(41536);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      ae.e("MicroMsg.GamePBDataDownloadGuidance", "Parsing Failed: %s", new Object[] { paramArrayOfByte.getMessage() });
      AppMethodBeat.o(41536);
    }
  }
  
  public final v dcg()
  {
    if (this.uoM != null) {
      return this.uoM.utN;
    }
    return null;
  }
  
  public final be dch()
  {
    if (this.uoM != null) {
      return this.uoM.utO;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ab
 * JD-Core Version:    0.7.0.1
 */