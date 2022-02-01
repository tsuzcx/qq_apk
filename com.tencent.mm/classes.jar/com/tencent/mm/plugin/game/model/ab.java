package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.game.protobuf.bf;
import com.tencent.mm.plugin.game.protobuf.bs;
import com.tencent.mm.plugin.game.protobuf.v;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public final class ab
  extends x
{
  private bs xHf;
  
  public ab(a parama)
  {
    AppMethodBeat.i(41535);
    if (parama == null)
    {
      this.xHf = new bs();
      AppMethodBeat.o(41535);
      return;
    }
    this.xHf = ((bs)parama);
    AppMethodBeat.o(41535);
  }
  
  public ab(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41536);
    this.xHf = new bs();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(41536);
      return;
    }
    try
    {
      this.xHf.parseFrom(paramArrayOfByte);
      AppMethodBeat.o(41536);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      Log.e("MicroMsg.GamePBDataDownloadGuidance", "Parsing Failed: %s", new Object[] { paramArrayOfByte.getMessage() });
      AppMethodBeat.o(41536);
    }
  }
  
  public final v dVN()
  {
    if (this.xHf != null) {
      return this.xHf.xLP;
    }
    return null;
  }
  
  public final bf dVO()
  {
    if (this.xHf != null) {
      return this.xHf.xLQ;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ab
 * JD-Core Version:    0.7.0.1
 */