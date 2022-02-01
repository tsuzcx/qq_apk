package com.tencent.mm.plugin.messenger.foundation.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public abstract interface k
{
  public static final class a
    extends k.b
  {
    private int cmdId;
    
    public a(int paramInt, a parama)
    {
      super();
      this.cmdId = paramInt;
      this.EVU = parama;
    }
    
    public final int getCmdId()
    {
      return this.cmdId;
    }
  }
  
  public static class b
  {
    public int EVQ;
    public long EVR;
    public String EVS;
    public String EVT;
    public a EVU;
    public byte[] buffer;
    public int cUP = -1;
    public int cmdId;
    public int id;
    public long lMC;
    
    public b(int paramInt)
    {
      this.cmdId = paramInt;
    }
    
    public final a eSx()
    {
      return this.EVU;
    }
    
    public final byte[] getBuffer()
    {
      AppMethodBeat.i(43081);
      if ((this.buffer == null) && (this.EVU != null)) {}
      try
      {
        this.buffer = this.EVU.toByteArray();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.a.a.k
 * JD-Core Version:    0.7.0.1
 */