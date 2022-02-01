package com.tencent.mm.plugin.messenger.foundation.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.IOException;

public class k$b
{
  public byte[] buffer;
  public int cmdId;
  public int dEu = -1;
  public long ibj;
  public int id;
  public int vWm;
  public long vWn;
  public String vWo;
  public String vWp;
  public a vWq;
  
  public k$b(int paramInt)
  {
    this.cmdId = paramInt;
  }
  
  public final a dpc()
  {
    return this.vWq;
  }
  
  public final byte[] getBuffer()
  {
    AppMethodBeat.i(43081);
    if ((this.buffer == null) && (this.vWq != null)) {}
    try
    {
      this.buffer = this.vWq.toByteArray();
      byte[] arrayOfByte = this.buffer;
      AppMethodBeat.o(43081);
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ae.e("MicroMsg.OpLog.Operation", "summeroplog Operation toByteArray err: " + localIOException.getMessage());
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