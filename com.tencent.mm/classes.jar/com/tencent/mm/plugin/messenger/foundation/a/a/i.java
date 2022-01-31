package com.tencent.mm.plugin.messenger.foundation.a.a;

import com.tencent.mm.bv.a;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;

public abstract interface i
{
  public static final class a
    extends i.b
  {
    private int cmdId;
    
    public a(int paramInt, a parama)
    {
      super();
      this.cmdId = paramInt;
      this.mdD = parama;
    }
    
    public final int getCmdId()
    {
      return this.cmdId;
    }
  }
  
  public static class b
  {
    public int bcw = -1;
    public byte[] buffer;
    public int cmdId;
    public long eml;
    public int id;
    public long mdA;
    public String mdB;
    public String mdC;
    public a mdD;
    public int mdz;
    
    public b(int paramInt)
    {
      this.cmdId = paramInt;
    }
    
    public final byte[] getBuffer()
    {
      if ((this.buffer == null) && (this.mdD != null)) {}
      try
      {
        this.buffer = this.mdD.toByteArray();
        return this.buffer;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          y.e("MicroMsg.OpLog.Operation", "summeroplog Operation toByteArray err: " + localIOException.getMessage());
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
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.a.a.i
 * JD-Core Version:    0.7.0.1
 */