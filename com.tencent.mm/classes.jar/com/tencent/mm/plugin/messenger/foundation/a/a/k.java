package com.tencent.mm.plugin.messenger.foundation.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public abstract interface k
{
  public static class b
  {
    public int KRq;
    public long KRr;
    public String KRs;
    public String KRt;
    public a KRu;
    public byte[] buffer;
    public int cmdId;
    public int eQp = -1;
    public int id;
    public long oFj;
    
    public b(int paramInt)
    {
      this.cmdId = paramInt;
    }
    
    public final byte[] getBuffer()
    {
      AppMethodBeat.i(43081);
      if ((this.buffer == null) && (this.KRu != null)) {}
      try
      {
        this.buffer = this.KRu.toByteArray();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.a.a.k
 * JD-Core Version:    0.7.0.1
 */