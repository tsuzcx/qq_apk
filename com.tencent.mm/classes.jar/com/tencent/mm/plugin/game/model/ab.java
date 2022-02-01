package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.game.protobuf.bg;
import com.tencent.mm.plugin.game.protobuf.bt;
import com.tencent.mm.plugin.game.protobuf.w;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public final class ab
  extends x
{
  private bt CLi;
  
  public ab(a parama)
  {
    AppMethodBeat.i(41535);
    if (parama == null)
    {
      this.CLi = new bt();
      AppMethodBeat.o(41535);
      return;
    }
    this.CLi = ((bt)parama);
    AppMethodBeat.o(41535);
  }
  
  public ab(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41536);
    this.CLi = new bt();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(41536);
      return;
    }
    try
    {
      this.CLi.parseFrom(paramArrayOfByte);
      AppMethodBeat.o(41536);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      Log.e("MicroMsg.GamePBDataDownloadGuidance", "Parsing Failed: %s", new Object[] { paramArrayOfByte.getMessage() });
      AppMethodBeat.o(41536);
    }
  }
  
  public final w eyV()
  {
    if (this.CLi != null) {
      return this.CLi.CPY;
    }
    return null;
  }
  
  public final bg eyW()
  {
    if (this.CLi != null) {
      return this.CLi.CPZ;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ab
 * JD-Core Version:    0.7.0.1
 */