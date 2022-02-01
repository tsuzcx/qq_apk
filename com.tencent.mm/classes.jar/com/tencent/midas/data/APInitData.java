package com.tencent.midas.data;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class APInitData
{
  private static APInitData gInstance = null;
  private static int initdataCount = 0;
  private String initGUID = "";
  private long initInterfaceTime = 0L;
  
  private APInitData()
  {
    initdataCount = 0;
    this.initInterfaceTime = 0L;
    this.initGUID = "";
  }
  
  public static int getInitdataCount()
  {
    int i = initdataCount;
    initdataCount = i + 1;
    return i;
  }
  
  public static void init()
  {
    AppMethodBeat.i(253290);
    gInstance = new APInitData();
    AppMethodBeat.o(253290);
  }
  
  public static void setInitdataCount(int paramInt)
  {
    initdataCount = paramInt;
  }
  
  public static APInitData singleton()
  {
    AppMethodBeat.i(253288);
    if (gInstance == null) {
      gInstance = new APInitData();
    }
    APInitData localAPInitData = gInstance;
    AppMethodBeat.o(253288);
    return localAPInitData;
  }
  
  public String getInitGUID()
  {
    return this.initGUID;
  }
  
  public long getInitInterfaceTime()
  {
    return this.initInterfaceTime;
  }
  
  public void setInitGUID(String paramString)
  {
    this.initGUID = paramString;
  }
  
  public void setInitInterfaceTime(long paramLong)
  {
    this.initInterfaceTime = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.midas.data.APInitData
 * JD-Core Version:    0.7.0.1
 */