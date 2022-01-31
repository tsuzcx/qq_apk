package com.tencent.liteav.basic.module;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class a
{
  private String mID = "";
  
  public void clearID()
  {
    AppMethodBeat.i(66078);
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
      AppMethodBeat.o(66078);
    }
  }
  
  public void finalize()
  {
    AppMethodBeat.i(66076);
    clearID();
    super.finalize();
    AppMethodBeat.o(66076);
  }
  
  public double getDoubleValue(int paramInt)
  {
    AppMethodBeat.i(146460);
    double d = TXCStatus.d(this.mID, paramInt);
    AppMethodBeat.o(146460);
    return d;
  }
  
  public double getDoubleValue(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(146464);
    double d = TXCStatus.d(this.mID, paramInt1, paramInt2);
    AppMethodBeat.o(146464);
    return d;
  }
  
  public String getID()
  {
    return this.mID;
  }
  
  public int getIntValue(int paramInt)
  {
    AppMethodBeat.i(146459);
    paramInt = TXCStatus.c(this.mID, paramInt);
    AppMethodBeat.o(146459);
    return paramInt;
  }
  
  public int getIntValue(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(146462);
    paramInt1 = TXCStatus.c(this.mID, paramInt1, paramInt2);
    AppMethodBeat.o(146462);
    return paramInt1;
  }
  
  public long getLongValue(int paramInt)
  {
    AppMethodBeat.i(146457);
    long l = TXCStatus.a(this.mID, paramInt);
    AppMethodBeat.o(146457);
    return l;
  }
  
  public long getLongValue(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(146463);
    long l = TXCStatus.a(this.mID, paramInt1, paramInt2);
    AppMethodBeat.o(146463);
    return l;
  }
  
  public String getStringValue(int paramInt)
  {
    AppMethodBeat.i(146458);
    String str = TXCStatus.b(this.mID, paramInt);
    AppMethodBeat.o(146458);
    return str;
  }
  
  public String getStringValue(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(146461);
    String str = TXCStatus.b(this.mID, paramInt1, paramInt2);
    AppMethodBeat.o(146461);
    return str;
  }
  
  public void setID(String paramString)
  {
    AppMethodBeat.i(66077);
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
      AppMethodBeat.o(66077);
    }
  }
  
  public boolean setStatusValue(int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(146456);
    boolean bool = TXCStatus.a(this.mID, paramInt1, paramInt2, paramObject);
    AppMethodBeat.o(146456);
    return bool;
  }
  
  public boolean setStatusValue(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(66079);
    boolean bool = TXCStatus.a(this.mID, paramInt, paramObject);
    AppMethodBeat.o(66079);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.liteav.basic.module.a
 * JD-Core Version:    0.7.0.1
 */