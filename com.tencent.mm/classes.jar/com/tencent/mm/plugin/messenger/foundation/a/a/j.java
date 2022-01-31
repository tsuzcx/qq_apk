package com.tencent.mm.plugin.messenger.foundation.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;

public abstract interface j
{
  public static final class a
    extends j.b
  {
    private int cmdId;
    
    public a(int paramInt, a parama)
    {
      super();
      this.cmdId = paramInt;
      this.oDZ = parama;
    }
    
    public final int getCmdId()
    {
      return this.cmdId;
    }
  }
  
  public static class b
  {
    public int bsY = -1;
    public byte[] buffer;
    public int cmdId;
    public long fCI;
    public int id;
    public int oDV;
    public long oDW;
    public String oDX;
    public String oDY;
    public a oDZ;
    
    public b(int paramInt)
    {
      this.cmdId = paramInt;
    }
    
    public final a bQh()
    {
      return this.oDZ;
    }
    
    public final byte[] getBuffer()
    {
      AppMethodBeat.i(60022);
      if ((this.buffer == null) && (this.oDZ != null)) {}
      try
      {
        this.buffer = this.oDZ.toByteArray();
        byte[] arrayOfByte = this.buffer;
        AppMethodBeat.o(60022);
        return arrayOfByte;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          ab.e("MicroMsg.OpLog.Operation", "summeroplog Operation toByteArray err: " + localIOException.getMessage());
        }
      }
    }
    
    public int getCmdId()
    {
      return this.cmdId;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.a.a.j
 * JD-Core Version:    0.7.0.1
 */