package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.game.d.ay;
import com.tencent.mm.plugin.game.d.bl;
import com.tencent.mm.plugin.game.d.r;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;

public final class ab
  extends x
{
  private bl udE;
  
  public ab(a parama)
  {
    AppMethodBeat.i(41535);
    if (parama == null)
    {
      this.udE = new bl();
      AppMethodBeat.o(41535);
      return;
    }
    this.udE = ((bl)parama);
    AppMethodBeat.o(41535);
  }
  
  public ab(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41536);
    this.udE = new bl();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(41536);
      return;
    }
    try
    {
      this.udE.parseFrom(paramArrayOfByte);
      AppMethodBeat.o(41536);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      ad.e("MicroMsg.GamePBDataDownloadGuidance", "Parsing Failed: %s", new Object[] { paramArrayOfByte.getMessage() });
      AppMethodBeat.o(41536);
    }
  }
  
  public final r cZv()
  {
    if (this.udE != null) {
      return this.udE.uip;
    }
    return null;
  }
  
  public final ay cZw()
  {
    if (this.udE != null) {
      return this.udE.uiq;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ab
 * JD-Core Version:    0.7.0.1
 */