package com.tencent.liteav.basic.module;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class a
{
  private String mID = "";
  
  public void clearID()
  {
    AppMethodBeat.i(14416);
    try
    {
      if (this.mID.length() != 0)
      {
        TXCStatus.b(this.mID);
        this.mID = "";
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(14416);
    }
  }
  
  public void finalize()
  {
    AppMethodBeat.i(14414);
    clearID();
    super.finalize();
    AppMethodBeat.o(14414);
  }
  
  public double getDoubleValue(int paramInt)
  {
    AppMethodBeat.i(14422);
    double d = TXCStatus.d(this.mID, paramInt);
    AppMethodBeat.o(14422);
    return d;
  }
  
  public double getDoubleValue(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(14426);
    double d = TXCStatus.d(this.mID, paramInt1, paramInt2);
    AppMethodBeat.o(14426);
    return d;
  }
  
  public String getID()
  {
    return this.mID;
  }
  
  public int getIntValue(int paramInt)
  {
    AppMethodBeat.i(14421);
    paramInt = TXCStatus.c(this.mID, paramInt);
    AppMethodBeat.o(14421);
    return paramInt;
  }
  
  public int getIntValue(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(14424);
    paramInt1 = TXCStatus.c(this.mID, paramInt1, paramInt2);
    AppMethodBeat.o(14424);
    return paramInt1;
  }
  
  public long getLongValue(int paramInt)
  {
    AppMethodBeat.i(14419);
    long l = TXCStatus.a(this.mID, paramInt);
    AppMethodBeat.o(14419);
    return l;
  }
  
  public long getLongValue(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(14425);
    long l = TXCStatus.a(this.mID, paramInt1, paramInt2);
    AppMethodBeat.o(14425);
    return l;
  }
  
  public String getStringValue(int paramInt)
  {
    AppMethodBeat.i(14420);
    String str = TXCStatus.b(this.mID, paramInt);
    AppMethodBeat.o(14420);
    return str;
  }
  
  public String getStringValue(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(14423);
    String str = TXCStatus.b(this.mID, paramInt1, paramInt2);
    AppMethodBeat.o(14423);
    return str;
  }
  
  public void setID(String paramString)
  {
    AppMethodBeat.i(14415);
    clearID();
    try
    {
      if (paramString.length() != 0)
      {
        this.mID = paramString;
        TXCStatus.a(this.mID);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(14415);
    }
  }
  
  public boolean setStatusValue(int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(14418);
    boolean bool = TXCStatus.a(this.mID, paramInt1, paramInt2, paramObject);
    AppMethodBeat.o(14418);
    return bool;
  }
  
  public boolean setStatusValue(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(14417);
    boolean bool = TXCStatus.a(this.mID, paramInt, paramObject);
    AppMethodBeat.o(14417);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.basic.module.a
 * JD-Core Version:    0.7.0.1
 */