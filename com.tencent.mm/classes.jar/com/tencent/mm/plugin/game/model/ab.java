package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.game.d.at;
import com.tencent.mm.plugin.game.d.bi;
import com.tencent.mm.plugin.game.d.p;
import java.io.IOException;

public final class ab
  extends x
{
  private bi noB;
  
  public ab(a parama)
  {
    AppMethodBeat.i(111370);
    if (parama == null)
    {
      this.noB = new bi();
      AppMethodBeat.o(111370);
      return;
    }
    this.noB = ((bi)parama);
    AppMethodBeat.o(111370);
  }
  
  public ab(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(111371);
    this.noB = new bi();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(111371);
      return;
    }
    try
    {
      this.noB.parseFrom(paramArrayOfByte);
      AppMethodBeat.o(111371);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.GamePBDataDownloadGuidance", "Parsing Failed: %s", new Object[] { paramArrayOfByte.getMessage() });
      AppMethodBeat.o(111371);
    }
  }
  
  public final p bGK()
  {
    if (this.noB != null) {
      return this.noB.nsP;
    }
    return null;
  }
  
  public final at bGL()
  {
    if (this.noB != null) {
      return this.noB.nsQ;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ab
 * JD-Core Version:    0.7.0.1
 */