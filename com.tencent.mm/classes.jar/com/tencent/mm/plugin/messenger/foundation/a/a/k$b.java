package com.tencent.mm.plugin.messenger.foundation.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;

public class k$b
{
  public byte[] buffer;
  public int cmdId;
  public int dDp = -1;
  public long hYr;
  public int id;
  public int vKi;
  public long vKj;
  public String vKk;
  public String vKl;
  public a vKm;
  
  public k$b(int paramInt)
  {
    this.cmdId = paramInt;
  }
  
  public final a dmd()
  {
    return this.vKm;
  }
  
  public final byte[] getBuffer()
  {
    AppMethodBeat.i(43081);
    if ((this.buffer == null) && (this.vKm != null)) {}
    try
    {
      this.buffer = this.vKm.toByteArray();
      byte[] arrayOfByte = this.buffer;
      AppMethodBeat.o(43081);
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ad.e("MicroMsg.OpLog.Operation", "summeroplog Operation toByteArray err: " + localIOException.getMessage());
      }
    }
  }
  
  public int getCmdId()
  {
    return this.cmdId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.a.a.k.b
 * JD-Core Version:    0.7.0.1
 */