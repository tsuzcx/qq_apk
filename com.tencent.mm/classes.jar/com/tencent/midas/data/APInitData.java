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
    AppMethodBeat.i(217000);
    gInstance = new APInitData();
    AppMethodBeat.o(217000);
  }
  
  public static void setInitdataCount(int paramInt)
  {
    initdataCount = paramInt;
  }
  
  public static APInitData singleton()
  {
    AppMethodBeat.i(216992);
    if (gInstance == null) {
      gInstance = new APInitData();
    }
    APInitData localAPInitData = gInstance;
    AppMethodBeat.o(216992);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.midas.data.APInitData
 * JD-Core Version:    0.7.0.1
 */