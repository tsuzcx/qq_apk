package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.game.d.av;
import com.tencent.mm.plugin.game.d.bi;
import com.tencent.mm.plugin.game.d.r;
import com.tencent.mm.sdk.platformtools.ac;
import java.io.IOException;

public final class ab
  extends x
{
  private bi tfO;
  
  public ab(a parama)
  {
    AppMethodBeat.i(41535);
    if (parama == null)
    {
      this.tfO = new bi();
      AppMethodBeat.o(41535);
      return;
    }
    this.tfO = ((bi)parama);
    AppMethodBeat.o(41535);
  }
  
  public ab(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41536);
    this.tfO = new bi();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(41536);
      return;
    }
    try
    {
      this.tfO.parseFrom(paramArrayOfByte);
      AppMethodBeat.o(41536);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      ac.e("MicroMsg.GamePBDataDownloadGuidance", "Parsing Failed: %s", new Object[] { paramArrayOfByte.getMessage() });
      AppMethodBeat.o(41536);
    }
  }
  
  public final r cQP()
  {
    if (this.tfO != null) {
      return this.tfO.tkl;
    }
    return null;
  }
  
  public final av cQQ()
  {
    if (this.tfO != null) {
      return this.tfO.tkm;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ab
 * JD-Core Version:    0.7.0.1
 */