package com.tencent.mm.plugin.messenger.foundation.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public class k$b
{
  public byte[] buffer;
  public int cSx = -1;
  public int cmdId;
  public long iWh;
  public int id;
  public int zqr;
  public long zqs;
  public String zqt;
  public String zqu;
  public a zqv;
  
  public k$b(int paramInt)
  {
    this.cmdId = paramInt;
  }
  
  public final a eiR()
  {
    return this.zqv;
  }
  
  public final byte[] getBuffer()
  {
    AppMethodBeat.i(43081);
    if ((this.buffer == null) && (this.zqv != null)) {}
    try
    {
      this.buffer = this.zqv.toByteArray();
      byte[] arrayOfByte = this.buffer;
      AppMethodBeat.o(43081);
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.e("MicroMsg.OpLog.Operation", "summeroplog Operation toByteArray err: " + localIOException.getMessage());
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