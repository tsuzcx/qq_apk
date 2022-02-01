package com.tencent.mm.plugin.messenger.foundation.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.sdk.platformtools.ac;
import java.io.IOException;

public class j$b
{
  public byte[] buffer;
  public int cmdId;
  public int drx = -1;
  public long hFM;
  public int id;
  public int uHf;
  public long uHg;
  public String uHh;
  public String uHi;
  public a uHj;
  
  public j$b(int paramInt)
  {
    this.cmdId = paramInt;
  }
  
  public final a dcJ()
  {
    return this.uHj;
  }
  
  public final byte[] getBuffer()
  {
    AppMethodBeat.i(43081);
    if ((this.buffer == null) && (this.uHj != null)) {}
    try
    {
      this.buffer = this.uHj.toByteArray();
      byte[] arrayOfByte = this.buffer;
      AppMethodBeat.o(43081);
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ac.e("MicroMsg.OpLog.Operation", "summeroplog Operation toByteArray err: " + localIOException.getMessage());
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