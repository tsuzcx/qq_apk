package com.tencent.mm.plugin.messenger.foundation.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;

public class j$b
{
  public byte[] buffer;
  public int cmdId;
  public int dtM = -1;
  public long hfj;
  public int id;
  public int tyI;
  public long tyJ;
  public String tyK;
  public String tyL;
  public a tyM;
  
  public j$b(int paramInt)
  {
    this.cmdId = paramInt;
  }
  
  public final a cPa()
  {
    return this.tyM;
  }
  
  public final byte[] getBuffer()
  {
    AppMethodBeat.i(43081);
    if ((this.buffer == null) && (this.tyM != null)) {}
    try
    {
      this.buffer = this.tyM.toByteArray();
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
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.a.a.j.b
 * JD-Core Version:    0.7.0.1
 */